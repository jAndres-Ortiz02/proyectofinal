/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.Estudiante;
import com.pavanzada.proyectofinal.service.EstudianteService;
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
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    @Autowired
    private EstudianteService service;

    @GetMapping
    public List<Estudiante> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Estudiante create(@RequestBody Estudiante estudiante) {
        return service.save(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante update(@PathVariable String id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        return service.save(estudiante);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
