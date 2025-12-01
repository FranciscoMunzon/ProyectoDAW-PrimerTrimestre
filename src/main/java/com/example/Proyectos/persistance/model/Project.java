package com.example.Proyectos.persistance.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false, unique = true)
    Integer projectId;

    @Column(name = "project_name", nullable = false, length = 150) // Nombre del proyecto
    String projectName;
  
    @Column(name = "description", nullable = false, length = 150) // Descripción del proyecto
    String description;

    @Column(name = "start_date", nullable = false) // Fecha de inicio
    Date startDate;

    @Column(name = "end_date", nullable = false) // Fecha de fin
    Date endDate;

    @Column(name = "demo_url", nullable = false, length = 150) // URL de demostración
    String demoUrl;

    @Column(name = "picture", nullable = false, length = 150) // Imagen del proyecto
    String picture;

    @ManyToOne // Relación muchos a uno con Status
    @JoinColumn(name = "status_status_id", nullable = false) // Columna que guarda la FK del estado
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY) // Relación muchos a muchos con Developers
    @JoinTable(
        name = "developers_worked_on_projects", // Tabla intermedia
        joinColumns = @JoinColumn(name = "projects_project_id"), // FK hacia Project
        inverseJoinColumns = @JoinColumn(name = "developer_dev_id") // FK hacia Developers
    )
    private List<Developers> developers;

    @ManyToMany(fetch = FetchType.LAZY) // Relación muchos a muchos con Technologies
    @JoinTable(
        name = "technologies_used_in_projects", // Tabla intermedia
        joinColumns = @JoinColumn(name = "projects_project_id"), // FK hacia Project
        inverseJoinColumns = @JoinColumn(name = "tecnologia_tecnologia_id") // FK hacia Technologies
    )
    private List<Technologies> technologies;
}