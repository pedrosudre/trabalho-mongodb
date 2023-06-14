package com.example.trabalhomongodb.controller;

import ch.qos.logback.core.model.Model;
import com.example.trabalhomongodb.model.Animal;
import com.example.trabalhomongodb.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
