package com.example.Proyectos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyectos.persistance.model.Project;
import java.util.List;

// Repositorio para la entidad Project
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    // Método personalizado para buscar proyectos cuyo nombre contenga una palabra ignorando mayúsculas/minúsculas
    List<Project> findByProjectNameContainingIgnoreCase(String word);
    
    // Los métodos CRUD básicos también están disponibles:
    // save(), findById(), findAll(), deleteById(), etc.
}