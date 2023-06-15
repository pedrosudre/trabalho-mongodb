package com.example.trabalhomongodb.repository;

import com.example.trabalhomongodb.model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimalRepository extends MongoRepository<Animal, String> {
    List<Animal> findByDisponivel(boolean disponivel);
    List<Animal> findByUsuarioAdotante(String idUsuario);
    List<Animal> findByEspecieAndUsuarioAdotanteIsNull(String especie);
    List<Animal> findByRacaAndUsuarioAdotanteIsNull(String raca);
}