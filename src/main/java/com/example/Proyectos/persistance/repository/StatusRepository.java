package com.example.Proyectos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyectos.persistance.model.Status;


public interface StatusRepository extends JpaRepository<Status, Integer> {
}