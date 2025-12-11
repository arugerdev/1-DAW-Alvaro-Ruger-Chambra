DROP DATABASE bibliotecaNuevo;

CREATE DATABASE bibliotecaNuevo;
USE bibliotecaNuevo;

CREATE TABLE autor (
    claveautor INT UNIQUE NOT NULL PRIMARY KEY,
    nombre VARCHAR(60)
);

CREATE TABLE editorial (
    claveeditorial SMALLINT(6) UNIQUE NOT NULL PRIMARY KEY,
    nombre VARCHAR(60),
    direccion VARCHAR(60),
    telefono VARCHAR(15)
);

CREATE TABLE socio (
    clavesocio INT(11) UNIQUE NOT NULL PRIMARY KEY,
    nombre VARCHAR(60),
    direccion VARCHAR(60),
    telefono VARCHAR(15),
    categoria CHAR(1)
);

CREATE TABLE tema (
    clavetema SMALLINT(6) UNIQUE NOT NULL PRIMARY KEY,
    nombre VARCHAR(40)
);

CREATE TABLE libro (
    clavelibro INT(11) UNIQUE NOT NULL PRIMARY KEY,
    titulo VARCHAR(60),
    idioma VARCHAR(15),
    formato VARCHAR(15),
    claveeditorial SMALLINT(6),
    FOREIGN KEY (claveeditorial)
        REFERENCES editorial (claveeditorial)
);

CREATE TABLE escrito_por (
    clavelibro INT(11),
    claveautor INT,
    FOREIGN KEY (clavelibro)
        REFERENCES libro (clavelibro),
    FOREIGN KEY (claveautor)
        REFERENCES autor (claveautor),
    PRIMARY KEY (clavelibro , claveautor)
);

CREATE TABLE trata_sobre (
    clavelibro INT(11),
    clavetema SMALLINT(6),
    FOREIGN KEY (clavelibro)
        REFERENCES libro (clavelibro),
    FOREIGN KEY (clavetema)
        REFERENCES tema (clavetema),
    PRIMARY KEY (clavelibro , clavetema)
);

CREATE TABLE ejemplar (
    claveejemplar INT(11) UNIQUE NOT NULL PRIMARY KEY,
    clavelibro INT(11),
    numeroorden SMALLINT(6),
    edicion SMALLINT(6),
    ubicacion VARCHAR(15),
    categoria CHAR(1),
    FOREIGN KEY (clavelibro)
        REFERENCES libro (clavelibro)
);

CREATE TABLE prestamo (
    clavesocio INT(11),
    claveejemplar INT(11),
    numeroorden SMALLINT(6),
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    notas BLOB,
    FOREIGN KEY (clavesocio)
        REFERENCES socio (clavesocio),
    FOREIGN KEY (claveejemplar)
        REFERENCES ejemplar (claveejemplar),
    PRIMARY KEY (clavesocio , claveejemplar)
);
