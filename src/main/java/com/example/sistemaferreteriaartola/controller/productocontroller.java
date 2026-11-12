package com.example.sistemaferreteriaartola.controller;

import com.example.sistemaferreteriaartola.entity.productoentity;
import com.example.sistemaferreteriaartola.service.categoriaproductoservice;
import com.example.sistemaferreteriaartola.service.productoservice;
import com.example.sistemaferreteriaartola.service.unidadmedidaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class productocontroller {

    @Autowired
    private productoservice productoService;

    @Autowired
    private categoriaproductoservice categoriaProductoService;

    @Autowired
    private unidadmedidaservice unidadMedidaService;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("producto", new productoentity());
        model.addAttribute("categorias", categoriaProductoService.listarCategorias());
        model.addAttribute("unidades", unidadMedidaService.listarUnidades());
        return "productos";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute productoentity producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable("id") Integer id, Model model) {
        productoentity productoEncontrado = productoService.buscarPorId(id).orElse(new productoentity());
        model.addAttribute("producto", productoEncontrado);
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("categorias", categoriaProductoService.listarCategorias());
        model.addAttribute("unidades", unidadMedidaService.listarUnidades());
        return "productos";
    }
}