package com.ayi.ejercicio02.controller;

import com.ayi.ejercicio02.service.interf.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final IUsuarioService iUsuarioService;

    @Autowired
    public LoginController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

    @GetMapping("/login")
    public String formLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String nombre, @RequestParam String passwordUsuario, Model model){
        boolean esValido =iUsuarioService.validarUsuario(nombre, passwordUsuario);

        if (esValido){
            return "redirect:/listado";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}
