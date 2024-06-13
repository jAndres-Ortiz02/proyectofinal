/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.service;

import com.pavanzada.proyectofinal.model.Asignatura;
import com.pavanzada.proyectofinal.repository.AsignaturaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class AsignaturaService {
    
     @Autowired
    private AsignaturaRepository repository;

    public List<Asignatura> findAll() {
        return repository.findAll();
    }

    public Optional<Asignatura> findById(String id) {
        return repository.findById(id);
    }

    public Asignatura save(Asignatura asignatura) {
        return repository.save(asignatura);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
    
}
