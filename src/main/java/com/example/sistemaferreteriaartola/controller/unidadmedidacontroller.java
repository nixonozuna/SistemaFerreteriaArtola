package com.example.sistemaferreteriaartola.controller;

import com.example.sistemaferreteriaartola.entity.unidadmedidaentity;
import com.example.sistemaferreteriaartola.service.unidadmedidaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/unidades")
public class unidadmedidacontroller {

    @Autowired
    private unidadmedidaservice unidadMedidaService;

    @GetMapping
    public String listarUnidades(Model model) {
        model.addAttribute("unidades", unidadMedidaService.listarUnidades());
        model.addAttribute("unidad", new unidadmedidaentity());
        return "unidades";
    }

    @PostMapping("/guardar")
    public String guardarUnidad(@ModelAttribute unidadmedidaentity unidad) {
        unidadMedidaService.guardarUnidad(unidad);
        return "redirect:/unidades";
    }

    @GetMapping("/editar/{id}")
    public String editarUnidad(@PathVariable("id") Integer id, Model model) {
        unidadmedidaentity unidadEncontrada = unidadMedidaService.buscarPorId(id).orElse(new unidadmedidaentity());
        model.addAttribute("unidad", unidadEncontrada);
        model.addAttribute("unidades", unidadMedidaService.listarUnidades());
        return "unidades";
    }
}