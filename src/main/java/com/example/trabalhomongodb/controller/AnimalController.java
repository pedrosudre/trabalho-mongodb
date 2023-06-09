package com.example.trabalhomongodb.controller;

import ch.qos.logback.core.model.Model;
import com.example.trabalhomongodb.model.Animal;
import com.example.trabalhomongodb.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("")
    public List<Animal> getAnimaisDisponiveis() {

        return animalService.getAnimaisDisponiveis();
    }

    @GetMapping("/animais/adotados/{idUsuario}")
    public ResponseEntity<List<Animal>> listarAnimaisAdotadosPorUsuario(@PathVariable String idUsuario) {
        List<Animal> animaisAdotados = animalService.listarAnimaisAdotadosPorUsuario(idUsuario);
        return ResponseEntity.ok(animaisAdotados);
    }

    @GetMapping("/animais/disponiveis/{especie}")
    public ResponseEntity<List<Animal>> listarAnimaisDisponiveisPorEspecie(@PathVariable String especie) {
        List<Animal> animaisDisponiveis = animalService.listarAnimaisDisponiveisPorEspecie(especie);
        return ResponseEntity.ok(animaisDisponiveis);
    }

    @GetMapping("/animais/disponiveis/por-raca/{raca}")
    public ResponseEntity<List<Animal>> listarAnimaisDisponiveisPorRaca(@PathVariable String raca) {
        List<Animal> animaisDisponiveis = animalService.listarAnimaisDisponiveisPorRaca(raca);
        return ResponseEntity.ok(animaisDisponiveis);
    }

    @PostMapping("/animal")
    public ResponseEntity<Animal> cadastrarAnimal(@RequestBody Animal animal) {
        Animal animalCadastrado = animalService.cadastrarAnimal(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(animalCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizarAnimal(@PathVariable String id, @RequestBody Animal animal) {
        Animal animalAtualizado = animalService.atualizarAnimal(id, animal);
        if (animalAtualizado != null) {
            return ResponseEntity.ok(animalAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable String id) {
        boolean animalDeletado = animalService.deletarAnimal(id);
        if (animalDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
