/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.Asignatura;
import com.pavanzada.proyectofinal.service.AsignaturaService;
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
@RequestMapping("/asignaturas")
public class AsignaturaController {
    
   @Autowired
    private AsignaturaService service;

    @GetMapping
    public String getAll(Model model) {
        List<Asignatura> asignaturas = service.findAll();
        model.addAttribute("asignaturas", asignaturas);
        return "asignaturas";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(asignatura -> model.addAttribute("asignatura", asignatura));
        return "asignatura";
    }

    @GetMapping("/crear")
    public String crearForm(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "crear_asignatura";
    }

    @PostMapping("/crear")
    public String create(@ModelAttribute Asignatura asignatura) {
        service.save(asignatura);
        return "redirect:/asignaturas";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(asignatura -> model.addAttribute("asignatura", asignatura));
        return "editar_asignatura";
    }

    @PostMapping("/editar/{id}")
    public String update(@PathVariable String id, @ModelAttribute Asignatura asignatura) {
        asignatura.setId(id);
        service.save(asignatura);
        return "redirect:/asignaturas";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/asignaturas";
    }
    
}
