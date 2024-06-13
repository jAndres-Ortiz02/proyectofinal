/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.Profesor;
import com.pavanzada.proyectofinal.service.ProfesorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author root
 */
@Controller
@RequestMapping("/profesores")
public class ProfesorController {
    
    @Autowired
    private ProfesorService service;

    @GetMapping
    public String getAll(Model model) {
        List<Profesor> profesores = service.findAll();
        model.addAttribute("profesores", profesores);
        return "profesores";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(profesor -> model.addAttribute("profesor", profesor));
        return "profesor";
    }

    @GetMapping("/crear")
    public String crearForm(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "crear_profesor";
    }

    @PostMapping("/crear")
    public String create(@ModelAttribute Profesor profesor) {
        service.save(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(profesor -> model.addAttribute("profesor", profesor));
        return "editar_profesor";
    }

    @PostMapping("/editar/{id}")
    public String update(@PathVariable String id, @ModelAttribute Profesor profesor) {
        profesor.setId(id);
        service.save(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/profesores";
    }
    
}
