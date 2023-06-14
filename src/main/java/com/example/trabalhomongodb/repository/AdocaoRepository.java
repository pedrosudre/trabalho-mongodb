package com.example.trabalhomongodb.repository;

import com.example.trabalhomongodb.model.Adocao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdocaoRepository extends MongoRepository<Adocao, String> {


    Adocao save(Adocao adocao);
}