package com.example.Proyectos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyectos.persistance.model.Technologies;

public interface TechnologiesRepository extends JpaRepository<Technologies, Integer> {
}