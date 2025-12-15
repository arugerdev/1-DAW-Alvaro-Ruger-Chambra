DROP DATABASE vehículos;

CREATE DATABASE vehículos;
USE vehículos;

CREATE TABLE propietarios (
    dni VARCHAR(9) PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(12) NOT NULL,
    direccion VARCHAR(30),
    ciudad VARCHAR(20),
    fecha_nacimiento DATE,
    telefono VARCHAR(12) NOT NULL,
    email VARCHAR(30) NOT NULL
);

CREATE TABLE coches (
    matricula VARCHAR(7) PRIMARY KEY UNIQUE NOT NULL,
    marca VARCHAR(20) NOT NULL,
    modelo VARCHAR(10) UNIQUE,
    nuevo BOOLEAN DEFAULT TRUE,
    precio DECIMAL(5.2) CHECK (precio >= 1000 AND precio <= 30000),
    dni VARCHAR(9),
    FOREIGN KEY (dni)
        REFERENCES propietarios (dni)
);

