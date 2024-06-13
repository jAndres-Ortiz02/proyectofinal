/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.service;

import com.pavanzada.proyectofinal.model.EstudianteAsignatura;
import com.pavanzada.proyectofinal.repository.EstudianteAsignaturaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class EstudianteAsignaturaService {
    
    @Autowired
    private EstudianteAsignaturaRepository repository;

    public List<EstudianteAsignatura> findAll() {
        return repository.findAll();
    }

    public List<EstudianteAsignatura> findByEstudianteId(String estudianteId) {
        return repository.findByEstudianteId(estudianteId);
    }

    public List<EstudianteAsignatura> findByAsignaturaIdAndGrupo(String asignaturaId, String grupo) {
        return repository.findByAsignaturaIdAndGrupo(asignaturaId, grupo);
    }

    public Optional<EstudianteAsignatura> findById(String id) {
        return repository.findById(id);
    }

    public EstudianteAsignatura save(EstudianteAsignatura estudianteAsignatura) {
        return repository.save(estudianteAsignatura);
    }
    
}
