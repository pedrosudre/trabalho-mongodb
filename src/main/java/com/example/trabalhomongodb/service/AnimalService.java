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

    public List<Animal> listarAnimaisAdotadosPorUsuario(String idUsuario) {

        List<Animal> animaisAdotados = animalRepository.findByUsuarioAdotante(idUsuario);
        return animaisAdotados;
    }

    public List<Animal> listarAnimaisDisponiveisPorEspecie(String especie) {

        List<Animal> animaisDisponiveis = animalRepository.findByEspecieAndUsuarioAdotanteIsNull(especie);
        return animaisDisponiveis;
    }

    public List<Animal> listarAnimaisDisponiveisPorRaca(String raca) {

        List<Animal> animaisDisponiveis = animalRepository.findByRacaAndUsuarioAdotanteIsNull(raca);
        return animaisDisponiveis;
    }

    public Animal cadastrarAnimal(Animal animal) {

        return animalRepository.save(animal);
    }

    public Animal atualizarAnimal(String id, Animal animal) {

        Optional<Animal> animalExistente = animalRepository.findById(id);
        if (animalExistente.isPresent()) {
            Animal animalAtualizado = animalExistente.get();
            animalAtualizado.setNome(animal.getNome());
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