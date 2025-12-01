package com.example.Proyectos.persistance.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   
@NoArgsConstructor 
@Entity
@Table(name = "developers")
public class Developers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id", nullable = false, unique = true)
    Integer devId;

    @Column(name = "devname", nullable = false, unique = true, length = 20)
    String devName;
  
    @Column(name = "dev_surname", nullable = false, length = 60)
    String devSurname;

    @Column(name = "email", nullable = false, unique = true, length = 90)
    String email;

    @Column(name = "linkedin_url", nullable = false, unique = true, length = 90)
    String linkedinUrl;

    @Column(name = "github_url", nullable = false, unique = true, length = 90)
    String githubUrl;


    @ManyToMany(mappedBy = "developers")
    @JsonIgnore
    private List<Project> projects;
}
