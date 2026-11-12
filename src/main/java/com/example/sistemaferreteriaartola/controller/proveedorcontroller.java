package com.example.sistemaferreteriaartola.controller;

import com.example.sistemaferreteriaartola.entity.proveedorentity;
import com.example.sistemaferreteriaartola.service.proveedorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class proveedorcontroller {

    @Autowired
    private proveedorservice proveedorService;

    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        model.addAttribute("proveedor", new proveedorentity());
        return "proveedores";
    }

    @PostMapping("/guardar")
    public String guardarProveedor(@ModelAttribute proveedorentity proveedor) {
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String editarProveedor(@PathVariable("id") Integer id, Model model) {
        proveedorentity proveedorEncontrado = proveedorService.buscarPorId(id).orElse(new proveedorentity());
        model.addAttribute("proveedor", proveedorEncontrado);
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        return "proveedores";
    }
}