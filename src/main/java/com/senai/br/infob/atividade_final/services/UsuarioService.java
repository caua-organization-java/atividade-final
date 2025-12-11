package com.senai.br.infob.atividade_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.br.infob.atividade_final.models.Usuario;
import com.senai.br.infob.atividade_final.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    
    public Usuario cadastro(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public String login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            return "Usuário não encontrado";
    }
        if (!usuario.getSenha().equals(senha)) {
            return "Senha incorreta";
    }
        return "Login efetuado com sucesso";
    }

    

    public Usuario buscar(Integer id) {
            return usuarioRepository.findById(id).get();
    }

    
}
