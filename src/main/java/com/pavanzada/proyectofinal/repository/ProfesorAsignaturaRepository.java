/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pavanzada.proyectofinal.repository;

import com.pavanzada.proyectofinal.model.ProfesorAsignatura;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author root
 */
public interface ProfesorAsignaturaRepository extends MongoRepository<ProfesorAsignatura, String> {
    
    List<ProfesorAsignatura> findByProfesorId(String profesorId);
    List<ProfesorAsignatura> findByAsignaturaId(String asignaturaId);
    
}
