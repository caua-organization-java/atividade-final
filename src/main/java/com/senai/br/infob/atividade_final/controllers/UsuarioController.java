package com.senai.br.infob.atividade_final.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.br.infob.atividade_final.models.Usuario;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usaurioService;

    @PostMapping("/cadastro")
    public Usuario cadastro(@RequestBody Usuario usuario) {
        return UsuarioService.cadastro(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, String senha) {
        return UsuarioService.login(email,senha);

    }

    @GetMapping("/buscar/{id}")
    public Usuario buscarId(@PathVariable Integer id) {
        return usuarioService.buscar(id);
        
    }
}
