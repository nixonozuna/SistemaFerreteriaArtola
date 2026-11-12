package com.example.sistemaferreteriaartola.service;

import com.example.sistemaferreteriaartola.entity.categoriaproductoentity;
import com.example.sistemaferreteriaartola.repository.categoriaproductorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoriaproductoservice {

    @Autowired
    private categoriaproductorepository categoriaProductoRepository;

    public List<categoriaproductoentity> listarCategorias() {
        return categoriaProductoRepository.findAll();
    }

    public void guardarCategoria(categoriaproductoentity categoria) {
        if (categoria.getFechaRegistro() == null) {
            categoria.setFechaRegistro(new java.util.Date());
        }
        categoriaProductoRepository.save(categoria);
    }

    public Optional<categoriaproductoentity> buscarPorId(Integer id) {
        return categoriaProductoRepository.findById(id);
    }
}