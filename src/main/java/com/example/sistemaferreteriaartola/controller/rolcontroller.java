package com.example.sistemaferreteriaartola.controller;

import com.example.sistemaferreteriaartola.entity.rolentity;
import com.example.sistemaferreteriaartola.service.rolservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class rolcontroller {

    @Autowired
    private rolservice rolService;

    // Listar todos los roles y mostrar formulario de registro
    @GetMapping
    public String listarRoles(Model model) {
        model.addAttribute("roles", rolService.listarRoles());
        model.addAttribute("rol", new rolentity()); // Objeto vacío para el formulario
        return "roles";
    }

    // Guardar o actualizar un rol
    @PostMapping("/guardar")
    public String guardarRol(@ModelAttribute rolentity rol) {
        rolService.guardarRol(rol);
        return "redirect:/roles";
    }

    // Eliminar un rol por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable("id") Integer id) {
        rolService.eliminarRol(id);
        return "redirect:/roles";
    }
}