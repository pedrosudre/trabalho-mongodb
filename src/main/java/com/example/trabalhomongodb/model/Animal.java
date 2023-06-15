package com.example.trabalhomongodb.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "animal")
public class Animal {

    @Id
    private Long id;

    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    private boolean disponivel;

    @DBRef
    private Adocao adocaoAtual;

    @DBRef
    private Usuario usuarioAdotante;
}
