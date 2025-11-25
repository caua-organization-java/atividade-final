package com.senai.br.infob.atividade_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.br.infob.atividade_final.models.Usuario;
import com.senai.br.infob.atividade_final.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public String login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
     if (email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
            return "Login efetuado com sucesso";
        }
        return "falha ao realizar o acesso";
    }
    
    public Usuario cadastro(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    

    public Usuario salvar(Usuario usuario, String confSenha) {
        if(usuario.getSenha().equals(confSenha)) {
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public Usuario buscar(Integer id) {
            return usuarioRepository.findById(id).get();
    }

    
}
