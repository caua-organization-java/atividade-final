package com.senai.br.infob.atividade_final.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.br.infob.atividade_final.models.Endereco;
import com.senai.br.infob.atividade_final.services.EnderecoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    public EnderecoService enderecoService;

    // Cadastrar endereço para um usuário
    @PostMapping("/usuario/{usuarioId}/cadastro")
    public Endereco cadastrarEndereco(
            @PathVariable Integer usuarioId,
            @RequestBody Endereco endereco) {
        return enderecoService.cadastrarEndereco(usuarioId, endereco);
    }

    // Listar todos
    @GetMapping
    public List<Endereco> listar() {
        return enderecoService.listarEnderecos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Integer id) {
        return enderecoService.buscarPorId(id);
    }

    // Listar endereços de um usuário
    @GetMapping("/usuario/{usuarioId}")
    public List<Endereco> listarPorUsuario(@PathVariable Integer usuarioId) {
        return enderecoService.listarPorUsuario(usuarioId);
    }
}