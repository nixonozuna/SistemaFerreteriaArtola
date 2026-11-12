package com.example.sistemaferreteriaartola.service;

import com.example.sistemaferreteriaartola.entity.proveedorentity;
import com.example.sistemaferreteriaartola.repository.proveedorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class proveedorservice {

    @Autowired
    private proveedorrepository proveedorRepository;

    public List<proveedorentity> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public void guardarProveedor(proveedorentity proveedor) {
        if (proveedor.getFechaRegistro() == null) {
            proveedor.setFechaRegistro(new Date());
        }
        if (proveedor.getEstado() == null) {
            proveedor.setEstado(true);
        }
        proveedorRepository.save(proveedor);
    }

    public Optional<proveedorentity> buscarPorId(Integer id) {
        return proveedorRepository.findById(id);
    }
}