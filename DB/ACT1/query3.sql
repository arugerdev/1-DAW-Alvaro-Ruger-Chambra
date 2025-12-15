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
    gana INT NOT NULL
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

-- PROFESORES (TODOS CORRECTOS)
-- =====================================

INSERT INTO profesores (dni, nombre, apellido1, apellido2, direccion, titulo, gana)
VALUES ('76978084M', 'Juan', 'Arcos', 'López', 'Puerta negra, 4', 'Ing. Informático', 7500);

INSERT INTO profesores (dni, nombre, apellido1, apellido2, direccion, titulo, gana)
VALUES ('50427865C', 'María', 'Oliva', 'Rubio', 'Juan Alfonso, 23', 'Lda. Fil. Inglesa', 4900);

INSERT INTO profesores (dni, nombre, apellido1, apellido2, direccion, titulo, gana)
VALUES ('99857929W', 'Sara', 'Lemes', 'Sancho', 'Calle Viento, 1', 'Magisterio', 6100);

-- =====================================

-- CURSOS
-- =====================================

INSERT INTO cursos (cod_curso, nombre_curso, dni_profesor, maximo_alumnos, fecha_inicio, fecha_fin, num_horas)
VALUES (1, 'Inglés Básico', '50427865C', 15, '2023-01-01', '2023-10-01', 120);

-- FALLA: fecha_fin es NULL → la condición no se cumple
/*
INSERT INTO cursos (cod_curso, nombre_curso, dni_profesor, maximo_alumnos, fecha_inicio, fecha_fin, num_horas)
VALUES (2, 'Adm. Linuz', '76978084M', NULL, '2023-03-02', NULL, 80);
*/

-- =====================================

-- ALUMNOS
-- =====================================

INSERT INTO alumnos (dni, nombre, apellido1, apellido2, direccion, sexo, fecha_nacimiento, curso)
VALUES ('23755174S', 'Lucas', 'Manilva', 'López', 'Alhamar, 4', 'H', '1970-01-01', 1);

INSERT INTO alumnos (dni, nombre, apellido1, apellido2, direccion, sexo, fecha_nacimiento, curso)
VALUES ('03818863N', 'Antonia', 'Santos', 'Alcántara', 'Maniquí, 21', 'M', NULL, 1 /* DEBERIA SER 2 PERO NO EXISTE AL HABER FALLDO LA CREACCION DEL MISMO */);

-- FALLA: sexo es NULL
/*
 INSERT INTO alumnos (dni, nombre, apellido1, apellido2, direccion, sexo, fecha_nacimiento, curso)
 VALUES ('33577501P', 'Manuel', 'Baños', 'Rioseco', 'Jurel, 2', NULL, NULL, 2);
*/

INSERT INTO alumnos (dni, nombre, apellido1, apellido2, direccion, sexo, fecha_nacimiento, curso)
VALUES ('36107620N', 'José', 'Llorente', 'Escudero', 'Jarcha, 5', 'H', '1990-03-02', 1);

-- =====================================

-- INSERCIÓN 3 (NO CORRECTA)
-- =====================================

-- FALLA:
-- 1. CHECK sexo → P no es válido
-- 2. NOT NULL curso → curso es NULL
-- 3. Además, viola la FK curso → cursos(cod_curso)

/*
INSERT INTO alumnos (dni, nombre, apellido1, apellido2, direccion, sexo, fecha_nacimiento, curso)
VALUES ('12345678J', 'Sergio', 'Navas', 'Rental', NULL, 'P', NULL, NULL);
*/

-- =====================================

SELECT * FROM profesores;
SELECT * FROM cursos;
SELECT * FROM alumnos;
