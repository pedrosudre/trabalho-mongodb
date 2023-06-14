package com.example.trabalhomongodb.controller;


import com.example.trabalhomongodb.model.Adocao;
import com.example.trabalhomongodb.model.Usuario;
import com.example.trabalhomongodb.repository.AdocaoRepository;
import com.example.trabalhomongodb.repository.UsuarioRepository;
import com.example.trabalhomongodb.service.AdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/adocao")

public class AdocaoController {

    private final AdocaoService adocaoService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AdocaoController(AdocaoService adocaoService, UsuarioRepository usuarioRepository) {
        this.adocaoService = adocaoService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/adocoes")
    public Adocao solicitarAdocao(@RequestParam String animalId, @RequestParam Long solicitanteId) {
        Usuario solicitante = usuarioRepository.findById(solicitanteId).orElse(null);
        return adocaoService.solicitarAdocao(animalId, solicitante);
    }

}