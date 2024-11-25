package com.Search.Bonten.Model;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prd_produto", schema="public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prd_id")
    private Long id;

    @Column(name = "prd_nome", length = 50, nullable = false)
    @CsvBindByName(column = "prd_nome")
    private String nome;

    @Column(name = "prd_preco", nullable = false)
    @CsvBindByName(column = "prd_preco")
    private java.math.BigDecimal preco;

    @Column(name = "prd_atualizacao", nullable = true)
    @CsvBindByName(column = "prd_atualizacao")
    private java.sql.Date atualizacao;

    @Column(name = "prd_img", length = 50)
    @CsvBindByName(column = "prd_img")
    private String imagem;

    @Column(name = "loj_cnpj", length = 14, nullable = false)
    @CsvBindByName(column = "loj_cnpj")
    private String cnpj;

}