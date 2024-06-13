/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author root
 */
@Controller
@RequestMapping("/universidad")
public class DashboardController {
    
    @GetMapping(path = "/index")
    public String Index(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Usuario usuario = servicioUsuarios.getUsuarioByName(authentication.getName());
//
//        if (!usuario.isCambioPassword()) {
//            System.out.println("El usuario no ha cambiado la contraseña");
//            return "redirect:/cambiar-contrasena";
//        }
//        
//        if (usuario != null && usuario.getStatus().equals("INACTIVO")) {
//            // El usuario tiene el estado "INACTIVO", no permitir el acceso
//            model.addAttribute("mistake", "Usuario inactivo. No se permite el acceso.");
//            return "login";
//        }
        
        return "index";
    }
    
}
