package com.example.Proyectos.Service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Proyectos.Service.ProjectService;
import com.example.Proyectos.persistance.model.Project;
import com.example.Proyectos.persistance.model.Status;
import com.example.Proyectos.persistance.repository.ProjectRepository;
import com.example.Proyectos.persistance.repository.StatusRepository;

import lombok.RequiredArgsConstructor;

/*
  Implementación de ProjectService.
 
  Esta clase contiene la lógica de negocio relacionada con los proyectos.
  Utiliza los repositorios para realizar operaciones sobre la base de datos.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    // Repositorio para acceder a los registros de proyectos
    private final ProjectRepository projectRepository;

    // Repositorio para cargar el estado de un proyecto
    private final StatusRepository statusRepository;

    // Devuelve la lista completa de proyectos registrados.
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Busca proyectos cuyo nombre contenga la palabra proporcionada, ignorando mayúsculas/minúsculas.
    @Override
    public List<Project> getProjectsByNameContaining(String word) {
        return projectRepository.findByProjectNameContainingIgnoreCase(word);
    }

    /*
    Crea un nuevo proyecto. Antes de guardarlo:
     - Comprueba si se ha enviado un "status"
     - Si existe, lo busca en la base de datos y lo asocia al proyecto
    */
    @Override
    public Project createProject(Project project) {

        // Si el proyecto trae un objeto Status con ID -> lo cargamos de la BD
        if (project.getStatus() != null && project.getStatus().getStatusId() != null) {

            Status status = statusRepository.findById(project.getStatus().getStatusId())
                            .orElseThrow(() -> new RuntimeException("Status no encontrado"));

            // Asignamos el estado válido
            project.setStatus(status);
        }

        // Guardamos el proyecto completo
        return projectRepository.save(project);
    }

    /*
    Actualiza un proyecto existente. 
    Se cargan los datos originales, se reemplazan los campos editados y finalmente se persiste el resultado.
     */
    @Override
    public Project updateProject(Integer id, Project project) {

        // Comprobamos si existe el proyecto
        Project existing = projectRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        // Actualizamos los campos editables
        existing.setProjectName(project.getProjectName());
        existing.setDescription(project.getDescription());
        existing.setStartDate(project.getStartDate());
        existing.setEndDate(project.getEndDate());
        existing.setDemoUrl(project.getDemoUrl());
        existing.setPicture(project.getPicture());

        /* 
        Si viene un estado en la petición:
         - Se busca en la BD
         - Se asigna al proyecto existente
         */
        if (project.getStatus() != null && project.getStatus().getStatusId() != null) {

            Status status = statusRepository.findById(project.getStatus().getStatusId())
                            .orElseThrow(() -> new RuntimeException("Status no encontrado"));

            existing.setStatus(status);
        }

        // Actualizamos la lista de desarrolladores asignados al proyecto
        existing.setDevelopers(project.getDevelopers());

        // Actualizamos la lista de tecnologías usadas
        existing.setTechnologies(project.getTechnologies());

        // Guardamos los cambios en la base de datos
        return projectRepository.save(existing);
    }

    // Elimina un proyecto mediante su ID.
    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }
}