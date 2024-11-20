package com.Search.Bonten.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "prd_produto")
public class Product {

    @Id
    private Long prd_id;

    @Column(length = 50, nullable = false)
    private String prd_name;

    @Column(length = 50)
    private String prd_img;

    @Column(length = 50)
    private int prd_price;

    @Column(length = 14, nullable = false)
    private String loj_cnpj;

}