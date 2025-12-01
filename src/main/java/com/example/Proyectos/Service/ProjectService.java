package com.example.Proyectos.Service;

import java.util.List;
import com.example.Proyectos.persistance.model.Project;

public interface ProjectService {
    List<Project> getAllProjects();                    // GET /projects
    List<Project> getProjectsByNameContaining(String word); // GET /projects/{word}
    Project createProject(Project project);            // POST /projects
    Project updateProject(Integer id, Project project); // PUT /projects/{id}
    void deleteProject(Integer id);                    // DELETE /projects/{id}
}
