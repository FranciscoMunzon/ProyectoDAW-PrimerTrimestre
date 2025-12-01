package com.example.Proyectos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyectos.persistance.model.Technologies;

// Repositorio para la entidad Technologies
public interface TechnologiesRepository extends JpaRepository<Technologies, Integer> {
    // JpaRepository proporciona todos los métodos CRUD básicos
}
