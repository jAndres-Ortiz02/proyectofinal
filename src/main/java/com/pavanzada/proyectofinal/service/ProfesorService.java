/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavanzada.proyectofinal.service;

import com.pavanzada.proyectofinal.model.Profesor;
import com.pavanzada.proyectofinal.repository.ProfesorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ProfesorService {
    
     @Autowired
    private ProfesorRepository repository;

    public List<Profesor> findAll() {
        return repository.findAll();
    }

    public Optional<Profesor> findById(String id) {
        return repository.findById(id);
    }

    public Profesor save(Profesor profesor) {
        return repository.save(profesor);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
    
}
