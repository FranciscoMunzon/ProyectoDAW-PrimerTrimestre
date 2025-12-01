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

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final StatusRepository statusRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getProjectsByNameContaining(String word) {
        return projectRepository.findByProjectNameContainingIgnoreCase(word);
    }

    @Override
    public Project createProject(Project project) {
        if (project.getStatus() != null && project.getStatus().getStatusId() != null) {
            Status status = statusRepository.findById(project.getStatus().getStatusId())
                              .orElseThrow(() -> new RuntimeException("Status no encontrado"));
            project.setStatus(status);
        }
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Integer id, Project project) {
        Project existing = projectRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        existing.setProjectName(project.getProjectName());
        existing.setDescription(project.getDescription());
        existing.setStartDate(project.getStartDate());
        existing.setEndDate(project.getEndDate());
        existing.setDemoUrl(project.getDemoUrl());
        existing.setPicture(project.getPicture());

        if (project.getStatus() != null && project.getStatus().getStatusId() != null) {
            Status status = statusRepository.findById(project.getStatus().getStatusId())
                              .orElseThrow(() -> new RuntimeException("Status no encontrado"));
            existing.setStatus(status);
        }

        existing.setDevelopers(project.getDevelopers());
        existing.setTechnologies(project.getTechnologies());

        return projectRepository.save(existing);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }
}
