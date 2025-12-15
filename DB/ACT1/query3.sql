DROP DATABASE academiaIdiomas;

CREATE DATABASE academiaIdiomas;
USE academiaIdiomas;


CREATE TABLE profesores (
    dni VARCHAR(9) PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(20) UNIQUE,
    apellido1 VARCHAR(20),
    apellido2 VARCHAR(20),
    direccion VARCHAR(30),
    titulo VARCHAR(20),
    gana_hora INT NOT NULL
);

CREATE TABLE cursos (
    cod_curso INT PRIMARY KEY UNIQUE NOT NULL,
    nombre_curso VARCHAR(20) UNIQUE,
    dni_profesor VARCHAR(9),
    maximo_alumnos INT,
    fecha_inicio DATE,
    fecha_fin DATE,
    CHECK (fecha_fin > fecha_inicio),
    num_horas INT NOT NULL,
    FOREIGN KEY (dni_profesor)
        REFERENCES profesores (dni)
);

CREATE TABLE alumnos (
    dni VARCHAR(9) PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(20),
    apellido1 VARCHAR(20),
    apellido2 VARCHAR(20),
    direccion VARCHAR(30),
    sexo VARCHAR(1) CHECK (sexo = 'H' OR sexo = 'M'),
    fecha_nacimiento DATE,
    curso INT NOT NULL,
    FOREIGN KEY (curso)
        REFERENCES cursos (cod_curso)
);