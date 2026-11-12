package com.example.sistemaferreteriaartola.controller;

import com.example.sistemaferreteriaartola.entity.usuarioentity;
import com.example.sistemaferreteriaartola.service.rolservice;
import com.example.sistemaferreteriaartola.service.usuarioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class usuariocontroller {

    @Autowired
    private usuarioservice usuarioService;

    @Autowired
    private rolservice rolService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("usuario", new usuarioentity());
        model.addAttribute("roles", rolService.listarRoles());
        return "usuarios";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute usuarioentity usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") Integer id, Model model) {
        usuarioentity usuarioEncontrado = usuarioService.buscarPorId(id).orElse(new usuarioentity());
        model.addAttribute("usuario", usuarioEncontrado);
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("roles", rolService.listarRoles());
        return "usuarios";
    }
}