package com.example.sistemaferreteriaartola.controller;

import com.example.sistemaferreteriaartola.entity.compraentity;
import com.example.sistemaferreteriaartola.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class compracontroller {

    @Autowired
    private compraservice compraService;

    @Autowired
    private proveedorservice proveedorService;

    @Autowired
    private usuarioservice usuarioService;

    @GetMapping
    public String listarCompras(Model model) {
        model.addAttribute("compras", compraService.listarCompras());
        model.addAttribute("compra", new compraentity());
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "compras";
    }

    @PostMapping("/guardar")
    public String guardarCompra(@ModelAttribute compraentity compra) {
        compraService.guardarCompra(compra);
        return "redirect:/compras";
    }

    @GetMapping("/editar/{id}")
    public String editarCompra(@PathVariable("id") Integer id, Model model) {
        compraentity compraEncontrada = compraService.buscarPorId(id).orElse(new compraentity());
        model.addAttribute("compra", compraEncontrada);
        model.addAttribute("compras", compraService.listarCompras());
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "compras";
    }
}