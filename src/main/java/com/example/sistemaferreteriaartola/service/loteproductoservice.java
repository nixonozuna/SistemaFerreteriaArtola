package com.example.sistemaferreteriaartola.service;

import com.example.sistemaferreteriaartola.entity.loteproductoentity;
import com.example.sistemaferreteriaartola.repository.loteproductorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class loteproductoservice {

    @Autowired
    private loteproductorepository loteProductoRepository;

    public List<loteproductoentity> listarLotes() {
        return loteProductoRepository.findAll();
    }

    public void guardarLote(loteproductoentity lote) {
        if (lote.getFechaIngreso() == null) {
            lote.setFechaIngreso(new Date());
        }
        if (lote.getEstado() == null) {
            lote.setEstado(true);
        }
        if (lote.getIdLoteProducto() == null && lote.getStockActual() == null) {
            lote.setStockActual(lote.getCantidadInicial());
        }
        loteProductoRepository.save(lote);
    }

    public Optional<loteproductoentity> buscarPorId(Integer id) {
        return loteProductoRepository.findById(id);
    }
}