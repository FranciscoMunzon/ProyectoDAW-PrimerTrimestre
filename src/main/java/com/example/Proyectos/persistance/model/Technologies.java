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
@Table(name = "technologies")
public class Technologies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tech_id", nullable = false, unique = true) // Clave primaria
    Integer techId;

    @Column(name = "tech_name", nullable = false, unique = true, length = 45) // Nombre de la tecnología
    String techName;

    @ManyToMany(mappedBy = "technologies") // Relación inversa con Project
    @JsonIgnore // Ignorar al serializar para evitar ciclos
    private List<Project> projects;
}