DROP TABLE IF EXISTS cliente;

DROP TABLE IF EXISTS producto;

CREATE TABLE cliente (
    id BIGINT IDENTITY PRIMARY KEY NOT NULL,
    nombre VARCHAR (255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(255) NOT NULL,
    telefono_alternativo VARCHAR(255)
);

CREATE TABLE producto(
    id BIGINT IDENTITY PRIMARY KEY NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    precio_costo DECIMAL (15,5) NOT NULL,
    porcentaje_incremento_precio_costo DECIMAL (15,5) NOT NULL
);
