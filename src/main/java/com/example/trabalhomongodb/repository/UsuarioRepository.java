package com.example.trabalhomongodb.repository;

import com.example.trabalhomongodb.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {


}