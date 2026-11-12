package com.example.sistemaferreteriaartola.service;

import com.example.sistemaferreteriaartola.entity.productoentity;
import com.example.sistemaferreteriaartola.repository.productorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class productoservice {

    @Autowired
    private productorepository productoRepository;

    public List<productoentity> listarProductos() {
        return productoRepository.findAll();
    }

    public void guardarProducto(productoentity producto) {
        if (producto.getFechaRegistro() == null) {
            producto.setFechaRegistro(new Date());
        }
        if (producto.getEstado() == null) {
            producto.setEstado(true);
        }
        if (producto.getStock() == null) {
            producto.setStock(0);
        }
        // Si no seleccionaron Unidad de Medida (campo nullable), evitar objeto vacío
        if (producto.getUnidadMedida() != null && producto.getUnidadMedida().getIdUnidadMedida() == null) {
            producto.setUnidadMedida(null);
        }
        productoRepository.save(producto);
    }

    public Optional<productoentity> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }
}