package com.example.trabalhomongodb.service;

import com.example.trabalhomongodb.model.Animal;
import com.example.trabalhomongodb.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private final AnimalRepository animalRepository;


    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimaisDisponiveis() {
        return animalRepository.findByDisponivel(true);
    }


}