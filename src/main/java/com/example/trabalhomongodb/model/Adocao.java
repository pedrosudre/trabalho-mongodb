package com.example.trabalhomongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "adocao")
public class Adocao {

    @Id
    private Long id;

    @DBRef
    private Usuario solicitante;

    @DBRef
    private Animal animal;
}
