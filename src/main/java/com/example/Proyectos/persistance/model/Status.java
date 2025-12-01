package com.example.Proyectos.persistance.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false, unique = true) // Clave primaria
    Integer statusId;

    @Column(name = "status_name", nullable = false, unique = true, length = 45) // Nombre del estado
    String statusName;

    @OneToMany(mappedBy = "status") // Un estado puede tener muchos proyectos
    @JsonIgnore // Ignorar al serializar para evitar ciclos infinitos
    private List<Project> projects;
}