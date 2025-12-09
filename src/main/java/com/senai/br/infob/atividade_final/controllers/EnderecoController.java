package com.senai.br.infob.atividade_final.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public EnderecoService enderecoService;

    @GetMapping("/buscar/{id}")
    public Endereco buscar(@PathVariable Integer id) {
        return enderecoService.buscar(id);
    }


    @PostMapping("salvar")
    public Endereco salvar(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }


}
