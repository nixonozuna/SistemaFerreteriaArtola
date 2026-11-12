package com.example.sistemaferreteriaartola.controller;

import com.example.sistemaferreteriaartola.entity.categoriaproductoentity;
import com.example.sistemaferreteriaartola.service.categoriaproductoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class categoriaproductocontroller {

    @Autowired
    private categoriaproductoservice categoriaProductoService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaProductoService.listarCategorias());
        model.addAttribute("categoria", new categoriaproductoentity());
        return "categorias";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute categoriaproductoentity categoria) {
        categoriaProductoService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable("id") Integer id, Model model) {
        categoriaproductoentity categoriaEncontrada = categoriaProductoService.buscarPorId(id).orElse(new categoriaproductoentity());
        model.addAttribute("categoria", categoriaEncontrada);
        model.addAttribute("categorias", categoriaProductoService.listarCategorias());
        return "categorias";
    }
}