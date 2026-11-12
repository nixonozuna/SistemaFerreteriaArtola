package com.example.sistemaferreteriaartola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homecontroller {

    // Muestra el panel principal tras el login (Ruta /home o /dashboard)
    @GetMapping("/home")
    public String mostrarHome() {
        return "home";
    }
}