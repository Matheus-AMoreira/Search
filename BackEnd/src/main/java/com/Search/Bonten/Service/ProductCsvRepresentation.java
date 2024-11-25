package com.Search.Bonten.Service.Representation;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCsvRepresentation {

    private String nome;
    private int preço;
    private java.sql.Date atualizacao;
    private String imagem;
    private String cnpj;
}
