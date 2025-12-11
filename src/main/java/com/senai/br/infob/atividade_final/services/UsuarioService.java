package com.senai.br.infob.atividade_final.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.senai.br.infob.atividade_final.models.Usuario;
import com.senai.br.infob.atividade_final.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    public UsuarioRepository usuarioRepository;

    // Cadastrar usuário (com ou sem endereços)
    public Usuario cadastrarUsuario(Usuario usuario) {

        if (usuario.getEnderecos() != null) {
            usuario.getEnderecos().forEach(e -> e.setUsuario(usuario));
        }

        return usuarioRepository.save(usuario);
    }

    // Login
    public Usuario login(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenha().equals(senha)) {
            throw new RuntimeException("Senha incorreta");
        }

        return usuario;
    }

    // Listar usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar usuário por ID	
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}