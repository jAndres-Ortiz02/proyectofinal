/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.Asignatura;
import com.pavanzada.proyectofinal.service.AsignaturaService;
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
@RequestMapping("/api/asignaturas")
public class AsignaturaRestController {

    @Autowired
    private AsignaturaService service;

    @GetMapping
    public List<Asignatura> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Asignatura> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Asignatura create(@RequestBody Asignatura asignatura) {
        return service.save(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura update(@PathVariable String id, @RequestBody Asignatura asignatura) {
        asignatura.setId(id);
        return service.save(asignatura);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
