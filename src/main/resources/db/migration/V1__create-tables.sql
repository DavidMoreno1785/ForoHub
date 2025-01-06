CREATE TABLE usuarios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NULL,
    update_at TIMESTAMP NULL,
    PRIMARY KEY(id)
);

INSERT INTO usuarios ( nombre, email, contrasena ) VALUES ( 'Usuario de prueba', 'admin@gmail.com','123456');

CREATE TABLE cursos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(200) NOT NULL UNIQUE,
    categoria VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NULL,
    update_at TIMESTAMP NULL,
    PRIMARY KEY(id)
);

CREATE TABLE topicos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(50) NOT NULL UNIQUE,
    mensaje VARCHAR(100) NOT NULL UNIQUE,
    fecha_creacion DATE NOT NULL,
    status TINYINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    update_at TIMESTAMP NULL,

    PRIMARY KEY(id),
    FOREIGN KEY(usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY(curso_id) REFERENCES cursos(id)
);
