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

@Data   // Lombok: genera getters, setters, toString, equals, hashCode automáticamente
@NoArgsConstructor // Lombok: genera un constructor vacío
@Entity // Marca la clase como una entidad JPA
@Table(name = "developers") // Asocia la clase con la tabla "developers" en la base de datos
public class Developers {
    
    @Id // Define la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del id (auto-increment)
    @Column(name = "dev_id", nullable = false, unique = true) // Configuración de la columna en la tabla
    Integer devId;

    @Column(name = "devname", nullable = false, unique = true, length = 20) // Nombre del developer
    String devName;
  
    @Column(name = "dev_surname", nullable = false, length = 60) // Apellidos del developer
    String devSurname;

    @Column(name = "email", nullable = false, unique = true, length = 90) // Email del developer
    String email;

    @Column(name = "linkedin_url", nullable = false, unique = true, length = 90) // URL de LinkedIn
    String linkedinUrl;

    @Column(name = "github_url", nullable = false, unique = true, length = 90) // URL de GitHub
    String githubUrl;

    @ManyToMany(mappedBy = "developers") // Relación muchos a muchos con Project, lado inverso
    @JsonIgnore // Ignora al serializar a JSON para evitar ciclos infinitos
    private List<Project> projects;
}
