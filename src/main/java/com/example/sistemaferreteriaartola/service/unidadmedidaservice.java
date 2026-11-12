package com.example.sistemaferreteriaartola.service;

import com.example.sistemaferreteriaartola.entity.unidadmedidaentity;
import com.example.sistemaferreteriaartola.repository.unidadmedidarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class unidadmedidaservice {

    @Autowired
    private unidadmedidarepository unidadMedidaRepository;

    public List<unidadmedidaentity> listarUnidades() {
        return unidadMedidaRepository.findAll();
    }

    public void guardarUnidad(unidadmedidaentity unidad) {
        if (unidad.getFechaRegistro() == null) {
            unidad.setFechaRegistro(new java.util.Date());
        }
        unidadMedidaRepository.save(unidad);
    }

    public Optional<unidadmedidaentity> buscarPorId(Integer id) {
        return unidadMedidaRepository.findById(id);
    }
}