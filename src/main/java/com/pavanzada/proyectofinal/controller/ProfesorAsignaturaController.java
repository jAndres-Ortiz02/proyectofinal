/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.ProfesorAsignatura;
import com.pavanzada.proyectofinal.service.AsignaturaService;
import com.pavanzada.proyectofinal.service.ProfesorAsignaturaService;
import com.pavanzada.proyectofinal.service.ProfesorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/profesor-asignaturas")
public class ProfesorAsignaturaController {
    
    @Autowired
    private ProfesorAsignaturaService service;
    
    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/crear")
    public String crearForm(Model model) {
        model.addAttribute("profesorAsignatura", new ProfesorAsignatura());
        model.addAttribute("profesores", profesorService.findAll());
        model.addAttribute("asignaturas", asignaturaService.findAll());
        return "crear_profesor_asignatura";
    }

    @PostMapping("/crear")
    public String create(@ModelAttribute ProfesorAsignatura profesorAsignatura) {
        service.save(profesorAsignatura);
        return "redirect:/profesor-asignaturas";
    }
    
    @GetMapping
    public String getAll(Model model) {
        List<ProfesorAsignatura> asociaciones = service.findAll();
        model.addAttribute("asociaciones", asociaciones);
        
        // Cargar los detalles del profesor asociado a cada asociación
        Map<String, String> profesorNames = new HashMap<>();
        for (ProfesorAsignatura asociacion : asociaciones) {
            profesorService.findById(asociacion.getProfesorId()).ifPresent(profesor -> {
                profesorNames.put(asociacion.getId(), profesor.getNombre());
            });
        }
        model.addAttribute("profesorNames", profesorNames);
        
        // Cargar los detalles de la asignatura asociada a cada asociación
        Map<String, String> asignaturaNames = new HashMap<>();
        for (ProfesorAsignatura asociacion : asociaciones) {
            asignaturaService.findById(asociacion.getAsignaturaId()).ifPresent(asignatura -> {
                asignaturaNames.put(asociacion.getId(), asignatura.getNombre());
            });
        }
        model.addAttribute("asignaturaNames", asignaturaNames);
        
        return "profesor_asignaturas";
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(profesorAsignatura -> model.addAttribute("profesorAsignatura", profesorAsignatura));
        return "profesor-asignatura";
    }

    @GetMapping("/profesor/{profesorId}")
    public String getByProfesorId(@PathVariable String profesorId, Model model) {
        List<ProfesorAsignatura> asignaturas = service.findByProfesorId(profesorId);
        model.addAttribute("asignaturas", asignaturas);
        return "asignaturas-por-profesor";
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public String getByAsignaturaId(@PathVariable String asignaturaId, Model model) {
        List<ProfesorAsignatura> profesores = service.findByAsignaturaId(asignaturaId);
        model.addAttribute("profesores", profesores);
        return "profesores-por-asignatura";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(profesorAsignatura -> model.addAttribute("profesorAsignatura", profesorAsignatura));
        return "editar-profesor-asignatura";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id, @ModelAttribute ProfesorAsignatura profesorAsignatura) {
        profesorAsignatura.setId(id);
        service.save(profesorAsignatura);
        return "redirect:/profesor-asignaturas/" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/profesor-asignaturas";
    }
    
}
