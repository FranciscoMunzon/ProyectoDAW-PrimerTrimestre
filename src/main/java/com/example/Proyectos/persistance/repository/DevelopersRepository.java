package com.example.Proyectos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyectos.persistance.model.Developers;

public interface DevelopersRepository extends JpaRepository<Developers, Integer> {
}