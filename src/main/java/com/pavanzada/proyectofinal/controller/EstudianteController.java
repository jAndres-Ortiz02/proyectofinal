/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.Estudiante;
import com.pavanzada.proyectofinal.service.EstudianteService;
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
@RequestMapping("/estudiantes")
public class EstudianteController {
    
    @Autowired
    private EstudianteService service;

    @GetMapping
    public String getAll(Model model) {
        List<Estudiante> estudiantes = service.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(estudiante -> model.addAttribute("estudiante", estudiante));
        return "estudiante";
    }

    @GetMapping("/crear")
    public String crearForm(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "crear_estudiante";
    }

    @PostMapping("/crear")
    public String create(@ModelAttribute Estudiante estudiante) {
        service.save(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(estudiante -> model.addAttribute("estudiante", estudiante));
        return "editar_estudiante";
    }

    @PostMapping("/editar/{id}")
    public String update(@PathVariable String id, @ModelAttribute Estudiante estudiante) {
        estudiante.setId(id);
        service.save(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/estudiantes";
    }
    
}
