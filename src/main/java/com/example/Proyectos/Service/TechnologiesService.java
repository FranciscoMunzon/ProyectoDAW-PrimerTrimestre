package com.example.Proyectos.Service;

import java.util.List;

import com.example.Proyectos.persistance.model.Technologies;

public interface TechnologiesService {
    List<Technologies> findAll();                       // GET /technologies
    Technologies createTechnology(Technologies tech);   // POST /technologies
    Technologies update(Integer id, Technologies tech); // PUT /technologies/{id}
    void deleteTechnology(Integer id);                  // DELETE /technologies/{id}
}
