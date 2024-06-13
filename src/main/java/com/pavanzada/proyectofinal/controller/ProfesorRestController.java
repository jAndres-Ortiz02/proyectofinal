/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.controller;

import com.pavanzada.proyectofinal.model.Profesor;
import com.pavanzada.proyectofinal.service.ProfesorService;
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
@RequestMapping("/api/profesores")
public class ProfesorRestController {

    @Autowired
    private ProfesorService service;

    @GetMapping
    public List<Profesor> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Profesor> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Profesor create(@RequestBody Profesor profesor) {
        return service.save(profesor);
    }

    @PutMapping("/{id}")
    public Profesor update(@PathVariable String id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        return service.save(profesor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
