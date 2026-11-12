package com.example.sistemaferreteriaartola.controller;

import com.example.sistemaferreteriaartola.entity.loteproductoentity;
import com.example.sistemaferreteriaartola.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lotes")
public class loteproductocontroller {

    @Autowired
    private loteproductoservice loteProductoService;

    @Autowired
    private productoservice productoService;

    @Autowired
    private proveedorservice proveedorService;

    @Autowired
    private usuarioservice usuarioService;

    @GetMapping
    public String listarLotes(Model model) {
        model.addAttribute("lotes", loteProductoService.listarLotes());
        model.addAttribute("lote", new loteproductoentity());
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "lotes";
    }

    @PostMapping("/guardar")
    public String guardarLote(@ModelAttribute loteproductoentity lote) {
        loteProductoService.guardarLote(lote);
        return "redirect:/lotes";
    }

    @GetMapping("/editar/{id}")
    public String editarLote(@PathVariable("id") Integer id, Model model) {
        loteproductoentity loteEncontrado = loteProductoService.buscarPorId(id).orElse(new loteproductoentity());
        model.addAttribute("lote", loteEncontrado);
        model.addAttribute("lotes", loteProductoService.listarLotes());
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "lotes";
    }
}