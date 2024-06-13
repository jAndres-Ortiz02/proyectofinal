/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.EstudianteAsignatura;
import com.pavanzada.proyectofinal.service.EstudianteAsignaturaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
@RequestMapping("/api/estudiante-asignaturas")
public class EstudianteAsignaturaRestController {

    @Autowired
    private EstudianteAsignaturaService service;

    @GetMapping
    public List<EstudianteAsignatura> getAll() {
        return service.findAll();
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<EstudianteAsignatura> getByEstudianteId(@PathVariable String estudianteId) {
        return service.findByEstudianteId(estudianteId);
    }

    @GetMapping("/asignatura/{asignaturaId}/grupo/{grupo}")
    public List<EstudianteAsignatura> getByAsignaturaIdAndGrupo(@PathVariable String asignaturaId, @PathVariable String grupo) {
        return service.findByAsignaturaIdAndGrupo(asignaturaId, grupo);
    }

    @GetMapping("/{id}")
    public Optional<EstudianteAsignatura> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public EstudianteAsignatura create(@RequestBody EstudianteAsignatura estudianteAsignatura) {
        return service.save(estudianteAsignatura);
    }

    @PutMapping("/{id}")
    public EstudianteAsignatura update(@PathVariable String id, @RequestBody EstudianteAsignatura estudianteAsignatura) {
        estudianteAsignatura.setId(id);
        return service.save(estudianteAsignatura);
    }
}
