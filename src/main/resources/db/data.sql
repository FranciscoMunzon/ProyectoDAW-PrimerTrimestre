USE Proyectosdb;

-- -----------------------------------------------------
-- Tabla: status
-- -----------------------------------------------------
INSERT INTO status (status_name)
VALUES 
('En desarrollo'),
('Completado'),
('En mantenimiento');

-- -----------------------------------------------------
-- Tabla: technologies
-- -----------------------------------------------------
INSERT INTO technologies (tech_name)
VALUES
('Python'),
('JavaScript'),
('React'),
('Node.js'),
('MySQL'),
('Docker');

-- -----------------------------------------------------
-- Tabla: developers
-- -----------------------------------------------------
INSERT INTO developers (devname, dev_surname, email, linkedin_url, github_url)
VALUES
('Ana', 'García López', 'ana.garcia@example.com', 'https://www.linkedin.com/in/anagarcia', 'https://github.com/anagarcia'),
('Luis', 'Martínez Pérez', 'luis.martinez@example.com', 'https://www.linkedin.com/in/luismartinez', 'https://github.com/luismartinez'),
('María', 'Torres Díaz', 'maria.torres@example.com', 'https://www.linkedin.com/in/mariatorres', 'https://github.com/mariatorres'),
('Carlos', 'Ramírez Soto', 'carlos.ramirez@example.com', 'https://www.linkedin.com/in/carlosramirez', 'https://github.com/carlosramirez');

-- -----------------------------------------------------
-- Tabla: projects
-- -----------------------------------------------------
INSERT INTO projects (project_name, description, start_date, end_date, demo_url, picture, status_status_id)
VALUES
('Gestor de Tareas', 'Aplicación web para gestión de tareas personales', '2024-01-10', '2024-03-15', 'https://demo-tareas.example.com', 'tareas.png', 2),
('E-Commerce API', 'API REST para una tienda en línea', '2024-02-01', '2024-04-20', 'https://demo-ecommerce.example.com', 'ecommerce.png', 2),
('Sistema de Reservas', 'Plataforma para gestión de reservas de hoteles', '2024-03-05', '2024-07-10', 'https://reservas.example.com', 'reservas.png', 1),
('Dashboard Financiero', 'Dashboard para visualización de métricas financieras', '2024-05-15', '2024-08-30', 'https://finanzas.example.com', 'dashboard.png', 3);

-- -----------------------------------------------------
-- Tabla: technologies_used_in_projects
-- -----------------------------------------------------
INSERT INTO technologies_used_in_projects (tecnologia_tecnologia_id, projects_project_id)
VALUES
(1, 1), -- Python -> Gestor de Tareas
(5, 1), -- MySQL -> Gestor de Tareas
(2, 2), -- JavaScript -> E-Commerce API
(4, 2), -- Node.js -> E-Commerce API
(5, 2), -- MySQL -> E-Commerce API
(3, 3), -- React -> Sistema de Reservas
(4, 3), -- Node.js -> Sistema de Reservas
(6, 3), -- Docker -> Sistema de Reservas
(1, 4), -- Python -> Dashboard Financiero
(3, 4), -- React -> Dashboard Financiero
(6, 4); -- Docker -> Dashboard Financiero

-- -----------------------------------------------------
-- Tabla: developers_worked_on_projects
-- -----------------------------------------------------
INSERT INTO developers_worked_on_projects (developer_dev_id, projects_project_id)
VALUES
(1, 1), -- Ana -> Gestor de Tareas
(2, 2), -- Luis -> E-Commerce API
(3, 3), -- María -> Sistema de Reservas
(4, 4), -- Carlos -> Dashboard Financiero
(1, 3), -- Ana -> Sistema de Reservas
(2, 4); -- Luis -> Dashboard Financiero
