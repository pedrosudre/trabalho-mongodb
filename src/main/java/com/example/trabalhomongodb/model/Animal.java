package com.example.trabalhomongodb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    private Long id;

    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    private boolean status;
}
