/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.EstudianteAsignatura;
import com.pavanzada.proyectofinal.service.AsignaturaService;
import com.pavanzada.proyectofinal.service.EstudianteAsignaturaService;
import com.pavanzada.proyectofinal.service.EstudianteService;
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
@RequestMapping("/estudiante-asignaturas")
public class EstudianteAsignaturaController {
    
    @Autowired
    private EstudianteAsignaturaService service;
    
    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/crear")
    public String crearForm(Model model) {
        model.addAttribute("estudianteAsignatura", new EstudianteAsignatura());
        model.addAttribute("estudiantes", estudianteService.findAll());
        model.addAttribute("asignaturas", asignaturaService.findAll());
        return "crear_estudiante_asignatura";
    }

    @PostMapping("/crear")
    public String create(@ModelAttribute EstudianteAsignatura estudianteAsignatura) {
        service.save(estudianteAsignatura);
        return "redirect:/estudiante-asignaturas";
    }
    
    @GetMapping
    public String getAll(Model model) {
        List<EstudianteAsignatura> asociaciones = service.findAll();
        model.addAttribute("asociaciones", asociaciones);
        
        // Cargar los detalles del estudiante asociado a cada asociación
        Map<String, String> estudianteNames = new HashMap<>();
        for (EstudianteAsignatura asociacion : asociaciones) {
            estudianteService.findById(asociacion.getEstudianteId()).ifPresent(estudiante -> {
                estudianteNames.put(asociacion.getId(), estudiante.getNombre());
            });
        }
        model.addAttribute("estudianteNames", estudianteNames);
        
        // Cargar los detalles de la asignatura asociada a cada asociación
        Map<String, String> asignaturaNames = new HashMap<>();
        for (EstudianteAsignatura asociacion : asociaciones) {
            asignaturaService.findById(asociacion.getAsignaturaId()).ifPresent(asignatura -> {
                asignaturaNames.put(asociacion.getId(), asignatura.getNombre());
            });
        }
        model.addAttribute("asignaturaNames", asignaturaNames);
        return "estudiante_asignaturas";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(estudianteAsignatura -> model.addAttribute("estudianteAsignatura", estudianteAsignatura));
        return "estudiante-asignatura";
    }

    @GetMapping("/estudiante/{estudianteId}")
    public String getByEstudianteId(@PathVariable String estudianteId, Model model) {
        List<EstudianteAsignatura> asignaturas = service.findByEstudianteId(estudianteId);
        model.addAttribute("asignaturas", asignaturas);
        return "asignaturas-por-estudiante";
    }

    @GetMapping("/asignatura/{asignaturaId}/grupo/{grupo}")
    public String getByAsignaturaIdAndGrupo(@PathVariable String asignaturaId, @PathVariable String grupo, Model model) {
        List<EstudianteAsignatura> estudiantes = service.findByAsignaturaIdAndGrupo(asignaturaId, grupo);
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes-por-asignatura-y-grupo";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(estudianteAsignatura -> model.addAttribute("estudianteAsignatura", estudianteAsignatura));
        return "editar-estudiante-asignatura";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id, @ModelAttribute EstudianteAsignatura estudianteAsignatura) {
        estudianteAsignatura.setId(id);
        service.save(estudianteAsignatura);
        return "redirect:/estudiante-asignaturas/" + id;
    }
    
}
