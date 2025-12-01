package com.example.Proyectos.Service;

import com.example.Proyectos.persistance.model.Technologies;

public interface TechnologiesService {
    Technologies createTechnology(Technologies tech); // POST /technologies
    void deleteTechnology(Integer id);                // DELETE /technologies/{id}
}
