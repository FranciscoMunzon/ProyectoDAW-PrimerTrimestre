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

    @Column(name = "project_name", nullable = false, length = 150)
    String projectName;
  
    @Column(name = "description", nullable = false, length = 150)
    String description;

    @Column(name = "start_date", nullable = false)
    Date startDate;

    @Column(name = "end_date", nullable = false)
    Date endDate;

    @Column(name = "demo_url", nullable = false, length = 150)
    String demoUrl;

    @Column(name = "picture", nullable = false, length = 150)
    String picture;


    @ManyToOne
    @JoinColumn(name = "status_status_id", nullable = false)
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "developers_worked_on_projects",
        joinColumns = @JoinColumn(name = "projects_project_id"),
        inverseJoinColumns = @JoinColumn(name = "developer_dev_id")
    )
    private List<Developers> developers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "technologies_used_in_projects",
        joinColumns = @JoinColumn(name = "projects_project_id"),
        inverseJoinColumns = @JoinColumn(name = "tecnologia_tecnologia_id")
    )
    private List<Technologies> technologies;
}
