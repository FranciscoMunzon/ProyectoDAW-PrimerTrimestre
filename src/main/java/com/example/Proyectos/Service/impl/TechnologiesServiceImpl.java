package com.example.Proyectos.Service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Proyectos.Service.TechnologiesService;
import com.example.Proyectos.persistance.model.Technologies;
import com.example.Proyectos.persistance.repository.TechnologiesRepository;

import lombok.RequiredArgsConstructor;

/*
  Implementación de TechnologiesService.
  
  Esta clase contiene la lógica de negocio relacionada con las tecnologías.
  Utiliza el repositorio para realizar operaciones sobre la base de datos.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class TechnologiesServiceImpl implements TechnologiesService {

    // Repositorio para acceder a los registros de tecnologías
    private final TechnologiesRepository technologiesRepository;

    // Devuelve la lista completa de tecnologías registradas.
    @Override
    public List<Technologies> findAll() {
        return technologiesRepository.findAll();
    }

    // Crea una nueva tecnología dentro del sistema.
    @Override
    public Technologies createTechnology(Technologies tech) {
        return technologiesRepository.save(tech);
    }

    /*
      Actualiza una tecnología existente.
      Se carga el objeto original y se reemplazan los campos modificados.
     */
    @Override
    public Technologies update(Integer id, Technologies tech) {
        tech.setTechId(id);
        return technologiesRepository.save(tech);
    }

    // Elimina una tecnología mediante su ID.
    @Override
    public void deleteTechnology(Integer id) {
        technologiesRepository.deleteById(id);
    }
}