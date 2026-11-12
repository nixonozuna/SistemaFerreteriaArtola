package com.example.sistemaferreteriaartola.service;

import com.example.sistemaferreteriaartola.entity.usuarioentity;
import com.example.sistemaferreteriaartola.repository.usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioservice {

    @Autowired
    private usuariorepository usuarioRepository;

    public List<usuarioentity> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void guardarUsuario(usuarioentity usuario) {
        usuarioRepository.save(usuario);
    }

    public Optional<usuarioentity> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }
}