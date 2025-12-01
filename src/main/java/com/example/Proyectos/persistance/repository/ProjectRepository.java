package com.example.Proyectos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyectos.persistance.model.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByProjectNameContainingIgnoreCase(String word);
}