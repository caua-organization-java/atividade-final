package com.senai.br.infob.atividade_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.br.infob.atividade_final.models.Endereco;
import com.senai.br.infob.atividade_final.repositories.EnderecoRepository;

@Service
public class EnderecoService {


    @Autowired
    public EnderecoRepository enderecoRepository;

    
    public Endereco buscar(Integer id) {
        return enderecoRepository.findById(id).get();
    }

        
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }


}

