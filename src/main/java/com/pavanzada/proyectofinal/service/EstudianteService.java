/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.service;

import com.pavanzada.proyectofinal.model.Estudiante;
import com.pavanzada.proyectofinal.repository.EstudianteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class EstudianteService {
    
    @Autowired
    private EstudianteRepository repository;

    public List<Estudiante> findAll() {
        return repository.findAll();
    }

    public Optional<Estudiante> findById(String id) {
        return repository.findById(id);
    }

    public Estudiante save(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
    
}
