package com.Search.Bonten.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "loj_loja")
public class Loja{

    @Id
    @Column(name = "loj_cnpj", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "loj_name", length = 50, nullable = false)
    private String nome;

    @Column(name = "loj_cep")
    private int cep;

    @Column(name = "loj_numero")
    private int numero;

}
