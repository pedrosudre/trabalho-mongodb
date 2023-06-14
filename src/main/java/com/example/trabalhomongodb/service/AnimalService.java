package com.example.trabalhomongodb.service;

import com.example.trabalhomongodb.model.Animal;
import com.example.trabalhomongodb.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Animal cadastrarAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal atualizarAnimal(String id, Animal animal) {
        Optional<Animal> animalExistente = animalRepository.findById(id);
        if (animalExistente.isPresent()) {
            Animal animalAtualizado = animalExistente.get();
            animalAtualizado.setNome(animal.getNome());
            // Atualizar outros atributos conforme necessário
            return animalRepository.save(animalAtualizado);
        }
        return null;
    }

    public boolean deletarAnimal(String id) {
        Optional<Animal> animalExistente = animalRepository.findById(id);
        if (animalExistente.isPresent()) {
            animalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}