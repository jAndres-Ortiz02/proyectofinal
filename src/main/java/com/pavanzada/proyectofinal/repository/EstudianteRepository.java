/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pavanzada.proyectofinal.repository;

import com.pavanzada.proyectofinal.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author root
 */
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    
}
