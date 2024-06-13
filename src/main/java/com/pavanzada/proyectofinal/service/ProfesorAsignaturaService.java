/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.service;

import com.pavanzada.proyectofinal.model.ProfesorAsignatura;
import com.pavanzada.proyectofinal.repository.ProfesorAsignaturaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ProfesorAsignaturaService {
    
     @Autowired
    private ProfesorAsignaturaRepository repository;

    public List<ProfesorAsignatura> findAll() {
        return repository.findAll();
    }

    public List<ProfesorAsignatura> findByProfesorId(String profesorId) {
        return repository.findByProfesorId(profesorId);
    }

    public List<ProfesorAsignatura> findByAsignaturaId(String asignaturaId) {
        return repository.findByAsignaturaId(asignaturaId);
    }

    public Optional<ProfesorAsignatura> findById(String id) {
        return repository.findById(id);
    }

    public ProfesorAsignatura save(ProfesorAsignatura profesorAsignatura) {
        return repository.save(profesorAsignatura);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
    
}
