package com.example.sistemaferreteriaartola.service;

import com.example.sistemaferreteriaartola.entity.compraentity;
import com.example.sistemaferreteriaartola.repository.comprarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class compraservice {

    @Autowired
    private comprarepository compraRepository;

    public List<compraentity> listarCompras() {
        return compraRepository.findAll();
    }

    public void guardarCompra(compraentity compra) {
        if (compra.getFechaCompra() == null) {
            compra.setFechaCompra(new Date());
        }
        if (compra.getEstado() == null) {
            compra.setEstado(true);
        }
        compraRepository.save(compra);
    }

    public Optional<compraentity> buscarPorId(Integer id) {
        return compraRepository.findById(id);
    }
}