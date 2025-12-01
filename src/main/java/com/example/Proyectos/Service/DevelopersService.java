package com.example.Proyectos.Service;

import java.util.List;

import com.example.Proyectos.persistance.model.Developers;

public interface DevelopersService {
    List<Developers> findAll();                             // GET /developers
    Developers createDeveloper(Developers dev);             // POST /developers
    Developers update(Integer id, Developers developer);    // PUT /developers/{id}    
    void deleteDeveloper(Integer id);                       // DELETE /developers/{id}
}
