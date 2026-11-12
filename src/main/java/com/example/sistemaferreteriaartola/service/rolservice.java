package com.example.sistemaferreteriaartola.service;

import com.example.sistemaferreteriaartola.entity.rolentity;
import com.example.sistemaferreteriaartola.repository.rolrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class rolservice {
    @Autowired
    private rolrepository rolRepository;

    public List<rolentity> listarRoles() {
        return rolRepository.findAll();
    }

    public rolentity guardarRol(rolentity rol) {
        return rolRepository.save(rol);
    }

    public Optional<rolentity> obtenerRolPorId(Integer id) {
        return rolRepository.findById(id);
    }

    public void eliminarRol(Integer id) {
        rolRepository.deleteById(id);
    }
}