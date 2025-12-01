package com.example.Proyectos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyectos.persistance.model.Developers;

// Interfaz que extiende JpaRepository para manejar la entidad Developers
// JpaRepository<Entidad, TipoClavePrimaria>
public interface DevelopersRepository extends JpaRepository<Developers, Integer> {
    // Con JpaRepository ya tienes métodos CRUD básicos:
    // save(), findById(), findAll(), deleteById(), etc.
}