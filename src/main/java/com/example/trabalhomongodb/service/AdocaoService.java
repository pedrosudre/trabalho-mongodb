package com.example.trabalhomongodb.service;

import com.example.trabalhomongodb.model.Adocao;
import com.example.trabalhomongodb.model.Animal;
import com.example.trabalhomongodb.model.Usuario;
import com.example.trabalhomongodb.repository.AdocaoRepository;
import com.example.trabalhomongodb.repository.AnimalRepository;
import com.example.trabalhomongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdocaoService {

    private final AdocaoRepository adocaoRepository;
    private final AnimalRepository animalRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AdocaoService(AdocaoRepository adocaoRepository, AnimalRepository animalRepository, UsuarioRepository usuarioRepository) {
        this.adocaoRepository = adocaoRepository;
        this.animalRepository = animalRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Adocao solicitarAdocao(String animalId, Usuario solicitante) {
        Animal animal = animalRepository.findById(animalId).orElse(null);


        Adocao adocao = new Adocao();
        adocao.setAnimal(animal);
        adocao.setSolicitante(solicitante);

        animal.setDisponivel(false);
        animal.setAdocaoAtual(adocao);

        solicitante.getAdocoesSolicitadas().add(adocao);

        animalRepository.save(animal);
        usuarioRepository.save(solicitante);
        return adocaoRepository.save(adocao);
    }
    
}