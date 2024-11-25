package com.Search.Bonten.Service;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCsvRepresentation {

    @CsvBindByName(column = "prd_nome")
    private String nome;
    @CsvBindByName(column = "prd_preco")
    private java.math.BigDecimal preço;
    @CsvBindByName(column = "prd_atualizacao")
    private java.sql.Date atualizacao;
    @CsvBindByName(column = "prd_img")
    private String imagem;
    @CsvBindByName(column = "loj_cnpj")
    private String cnpj;
}
