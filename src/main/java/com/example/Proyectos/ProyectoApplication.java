package com.example.Proyectos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
  Clase principal del proyecto Spring Boot.

  - @SpringBootApplication habilita:
      * Configuración automática de Spring (auto-configuration)
      * Escaneo de componentes (component scan)
      * Configuración de Spring Boot

  Esta clase funciona como punto de entrada para iniciar la aplicación.
 */
@SpringBootApplication
public class ProyectoApplication {

    // Método principal que arranca el servidor Spring Boot.
    public static void main(String[] args) {

        // Inicia el contexto de Spring y levanta el servidor embebido (Tomcat por defecto)
        SpringApplication.run(ProyectoApplication.class, args);
    }
}