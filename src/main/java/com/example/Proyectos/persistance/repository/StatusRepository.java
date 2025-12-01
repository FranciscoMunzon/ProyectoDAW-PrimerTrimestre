package com.example.Proyectos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyectos.persistance.model.Status;

// Repositorio para la entidad Status
public interface StatusRepository extends JpaRepository<Status, Integer> {
    // Métodos CRUD básicos ya incluidos:
    // save(), findById(), findAll(), deleteById(), etc.
}
