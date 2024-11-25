package com.Search.Bonten.Service;

import com.Search.Bonten.Model.Product;
import com.Search.Bonten.Repository.ProductRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Integer uploadProducts(MultipartFile file) throws IOException {
        Set<Product> products = parseCsv(file);
        repository.saveAll(products);
        return products.size();
    }

    public Set<Product> parseCsv(MultipartFile file) throws IOException {

        try(Reader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream()))){
            HeaderColumnNameMappingStrategy<Product> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Product.class);
            CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse().stream()
                    .map(csvLine -> Product.builder()
                        .nome(csvLine.getNome())
                        .preco(csvLine.getPreco())
                        .atualizacao(csvLine.getAtualizacao())
                        .imagem(csvLine.getImagem())
                        .cnpj(csvLine.getCnpj())
                        .build()
                    ).collect(Collectors.toSet());

        }
    }
}
