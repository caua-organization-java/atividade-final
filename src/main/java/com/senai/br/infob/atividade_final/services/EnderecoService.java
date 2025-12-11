package com.senai.br.infob.atividade_final.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.senai.br.infob.atividade_final.models.Endereco;
import com.senai.br.infob.atividade_final.models.Usuario;
import com.senai.br.infob.atividade_final.repositories.EnderecoRepository;
import com.senai.br.infob.atividade_final.repositories.UsuarioRepository;

@Service
public class EnderecoService {

    public EnderecoRepository enderecoRepository;
    public UsuarioRepository usuarioRepository;

    // Cadastrar endereço e vincular ao usuário
    public Endereco cadastrarEndereco(Integer usuarioId, Endereco endereco) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        endereco.setUsuario(usuario);

        return enderecoRepository.save(endereco);
    }

    // Listar todos
    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    // Buscar por ID
    public Endereco buscarPorId(Integer id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    // Listar endereços por usuário
    public List<Endereco> listarPorUsuario(Integer usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return usuario.getEnderecos();
    }
}

