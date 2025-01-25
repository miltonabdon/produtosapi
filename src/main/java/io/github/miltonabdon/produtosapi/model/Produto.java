package io.github.miltonabdon.produtosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Produto {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private Double preco;


}
