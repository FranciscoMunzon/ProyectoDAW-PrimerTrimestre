package com.example.Proyectos.Service;

import com.example.Proyectos.persistance.model.Developers;

public interface DevelopersService {
    Developers createDeveloper(Developers dev);       // POST /developers
    void deleteDeveloper(Integer id);                 // DELETE /developers/{id}
}
