package com.Search.Bonten.Controller;

import com.Search.Bonten.Model.Product;
import com.Search.Bonten.Repository.ProductRepository;
import com.Search.Bonten.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductRepository productRepository;

    private final ProductService service;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductService service) {
        this.productRepository = productRepository;
        this.service = service;
    }

    @GetMapping
    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadProducts(@RequestBody MultipartFile file) throws IOException {
        return ResponseEntity.ok(service.uploadProducts(file));
    }
}
