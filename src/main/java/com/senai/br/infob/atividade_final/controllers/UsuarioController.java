package com.senai.br.infob.atividade_final.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.br.infob.atividade_final.models.Usuario;
import com.senai.br.infob.atividade_final.services.UsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    public UsuarioService usuarioService;

    // Cadastrar usuário
    @PostMapping("/cadastro")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    // Login
    @PostMapping("/login")
    public Usuario login(
            @RequestParam String email,
            @RequestParam String senha
    ) {
        return usuarioService.login(email, senha);
    }

    // Listar todos
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }
}