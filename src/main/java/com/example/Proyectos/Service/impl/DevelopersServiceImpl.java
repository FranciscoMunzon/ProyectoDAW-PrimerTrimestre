package com.example.Proyectos.Service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Proyectos.Service.DevelopersService;
import com.example.Proyectos.persistance.model.Developers;
import com.example.Proyectos.persistance.repository.DevelopersRepository;

import lombok.RequiredArgsConstructor;

/*
  Implementación de DevelopersService.
  
  Esta clase contiene la lógica de negocio relacionada con los desarrolladores.
  Utiliza el repositorio para realizar operaciones sobre la base de datos.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class DevelopersServiceImpl implements DevelopersService {

    // Repositorio para acceder a los registros de desarrolladores
    private final DevelopersRepository developersRepository;

    // Devuelve la lista completa de desarrolladores registrados.
    @Override
    public List<Developers> findAll() {
        return developersRepository.findAll();
    }

    // Crea un nuevo desarrollador dentro del sistema.
    @Override
    public Developers createDeveloper(Developers developer) {
        return developersRepository.save(developer);
    }

    /*
      Actualiza un desarrollador existente.
      Se busca el registro original y se reemplazan los datos editados.
    */
    @Override
    public Developers update(Integer id, Developers developer) {
        developer.setDevId(id);
        return developersRepository.save(developer);
    }

    // Elimina un desarrollador mediante su ID.
    @Override
    public void deleteDeveloper(Integer id) {
        developersRepository.deleteById(id);
    }
}
