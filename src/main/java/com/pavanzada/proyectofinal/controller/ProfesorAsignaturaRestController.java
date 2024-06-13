/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.ProfesorAsignatura;
import com.pavanzada.proyectofinal.service.ProfesorAsignaturaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/profesor-asignaturas")
public class ProfesorAsignaturaRestController {

    @Autowired
    private ProfesorAsignaturaService service;

    @GetMapping
    public List<ProfesorAsignatura> getAll() {
        return service.findAll();
    }

    @GetMapping("/profesor/{profesorId}")
    public List<ProfesorAsignatura> getByProfesorId(@PathVariable String profesorId) {
        return service.findByProfesorId(profesorId);
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public List<ProfesorAsignatura> getByAsignaturaId(@PathVariable String asignaturaId) {
        return service.findByAsignaturaId(asignaturaId);
    }

    @GetMapping("/{id}")
    public Optional<ProfesorAsignatura> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ProfesorAsignatura create(@RequestBody ProfesorAsignatura profesorAsignatura) {
        return service.save(profesorAsignatura);
    }

    @PutMapping("/{id}")
    public ProfesorAsignatura update(@PathVariable String id, @RequestBody ProfesorAsignatura profesorAsignatura) {
        profesorAsignatura.setId(id);
        return service.save(profesorAsignatura);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
