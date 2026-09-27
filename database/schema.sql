CREATE DATABASE IF NOT EXISTS sigcoin CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE sigcoin;

CREATE TABLE rol (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL UNIQUE,
    descripcion VARCHAR(255) NULL
);

CREATE TABLE usuario (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    rol_id BIGINT UNSIGNED NOT NULL,
    nombre_usuario VARCHAR(80) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_usuario_rol FOREIGN KEY (rol_id) REFERENCES rol(id)
);

CREATE TABLE persona (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tipo_documento VARCHAR(10) NULL,
    numero_documento VARCHAR(20) NULL,
    cuit VARCHAR(13) NULL,
    nombre VARCHAR(80) NOT NULL,
    apellido VARCHAR(80) NOT NULL,
    email VARCHAR(150) NULL,
    telefono VARCHAR(40) NULL,
    direccion VARCHAR(255) NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uq_persona_documento (tipo_documento, numero_documento),
    UNIQUE KEY uq_persona_cuit (cuit),
    KEY idx_persona_apellido_nombre (apellido, nombre)
);

CREATE TABLE inmueble (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    localidad VARCHAR(100) NULL,
    provincia VARCHAR(100) NULL,
    identificacion VARCHAR(80) NULL UNIQUE,
    tipo VARCHAR(40) NOT NULL,
    estado VARCHAR(30) NOT NULL DEFAULT 'DISPONIBLE',
    observaciones TEXT NULL,
    creado_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    KEY idx_inmueble_direccion (direccion)
);

CREATE TABLE inmueble_propietario (
    inmueble_id BIGINT UNSIGNED NOT NULL,
    persona_id BIGINT UNSIGNED NOT NULL,
    porcentaje DECIMAL(5,2) NOT NULL DEFAULT 100.00,
    PRIMARY KEY (inmueble_id, persona_id),
    CONSTRAINT fk_ip_inmueble FOREIGN KEY (inmueble_id) REFERENCES inmueble(id),
    CONSTRAINT fk_ip_persona FOREIGN KEY (persona_id) REFERENCES persona(id)
);

CREATE TABLE contrato (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    inmueble_id BIGINT UNSIGNED NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    importe_inicial DECIMAL(15,2) NOT NULL,
    importe_vigente DECIMAL(15,2) NOT NULL,
    periodicidad_meses TINYINT UNSIGNED NOT NULL DEFAULT 4,
    tipo_indice VARCHAR(20) NULL,
    estado VARCHAR(30) NOT NULL DEFAULT 'VIGENTE',
    creado_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_contrato_inmueble FOREIGN KEY (inmueble_id) REFERENCES inmueble(id),
    KEY idx_contrato_estado_fin (estado, fecha_fin)
);

CREATE TABLE contrato_inquilino (
    contrato_id BIGINT UNSIGNED NOT NULL,
    persona_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (contrato_id, persona_id),
    CONSTRAINT fk_ci_contrato FOREIGN KEY (contrato_id) REFERENCES contrato(id),
    CONSTRAINT fk_ci_persona FOREIGN KEY (persona_id) REFERENCES persona(id)
);

CREATE TABLE contrato_garante (
    contrato_id BIGINT UNSIGNED NOT NULL,
    persona_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (contrato_id, persona_id),
    CONSTRAINT fk_cg_contrato FOREIGN KEY (contrato_id) REFERENCES contrato(id),
    CONSTRAINT fk_cg_persona FOREIGN KEY (persona_id) REFERENCES persona(id)
);

CREATE TABLE indice (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL,
    periodo DATE NOT NULL,
    valor DECIMAL(12,6) NOT NULL,
    fuente VARCHAR(80) NOT NULL,
    consultado_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uq_indice_tipo_periodo (tipo, periodo)
);

CREATE TABLE ajuste_contrato (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    contrato_id BIGINT UNSIGNED NOT NULL,
    indice_id BIGINT UNSIGNED NOT NULL,
    fecha_aplicacion DATE NOT NULL,
    importe_anterior DECIMAL(15,2) NOT NULL,
    porcentaje DECIMAL(8,4) NOT NULL,
    importe_nuevo DECIMAL(15,2) NOT NULL,
    CONSTRAINT fk_ajuste_contrato FOREIGN KEY (contrato_id) REFERENCES contrato(id),
    CONSTRAINT fk_ajuste_indice FOREIGN KEY (indice_id) REFERENCES indice(id)
);

CREATE TABLE cobranza (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    contrato_id BIGINT UNSIGNED NOT NULL,
    periodo DATE NOT NULL,
    fecha_pago DATE NULL,
    importe DECIMAL(15,2) NOT NULL,
    medio_pago VARCHAR(30) NOT NULL,
    estado VARCHAR(30) NOT NULL DEFAULT 'PENDIENTE',
    registrado_por BIGINT UNSIGNED NOT NULL,
    UNIQUE KEY uq_cobranza_contrato_periodo (contrato_id, periodo),
    CONSTRAINT fk_cobranza_contrato FOREIGN KEY (contrato_id) REFERENCES contrato(id),
    CONSTRAINT fk_cobranza_usuario FOREIGN KEY (registrado_por) REFERENCES usuario(id),
    KEY idx_cobranza_estado (estado)
);

CREATE TABLE comprobante (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    cobranza_id BIGINT UNSIGNED NULL,
    emitido_por BIGINT UNSIGNED NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    punto_venta SMALLINT UNSIGNED NOT NULL,
    numero INT UNSIGNED NOT NULL,
    fecha_emision DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    importe_total DECIMAL(15,2) NOT NULL,
    estado VARCHAR(30) NOT NULL DEFAULT 'EMITIDO',
    motivo_anulacion VARCHAR(255) NULL,
    UNIQUE KEY uq_comprobante_numero (tipo, punto_venta, numero),
    CONSTRAINT fk_comprobante_cobranza FOREIGN KEY (cobranza_id) REFERENCES cobranza(id),
    CONSTRAINT fk_comprobante_usuario FOREIGN KEY (emitido_por) REFERENCES usuario(id)
);

CREATE TABLE caja (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT UNSIGNED NULL,
    nombre VARCHAR(80) NOT NULL UNIQUE,
    tipo VARCHAR(20) NOT NULL,
    moneda CHAR(3) NOT NULL DEFAULT 'ARS',
    saldo DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_caja_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE solicitud_pago (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    solicitante_id BIGINT UNSIGNED NOT NULL,
    concepto VARCHAR(255) NOT NULL,
    importe DECIMAL(15,2) NOT NULL,
    prioridad VARCHAR(20) NOT NULL DEFAULT 'NORMAL',
    estado VARCHAR(30) NOT NULL DEFAULT 'PENDIENTE',
    fecha_solicitud DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_solicitud_usuario FOREIGN KEY (solicitante_id) REFERENCES usuario(id),
    KEY idx_solicitud_turnero (estado, prioridad, fecha_solicitud)
);

CREATE TABLE movimiento_caja (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    caja_id BIGINT UNSIGNED NOT NULL,
    cobranza_id BIGINT UNSIGNED NULL,
    solicitud_pago_id BIGINT UNSIGNED NULL,
    usuario_id BIGINT UNSIGNED NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    concepto VARCHAR(255) NOT NULL,
    importe DECIMAL(15,2) NOT NULL,
    fecha_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_movimiento_caja FOREIGN KEY (caja_id) REFERENCES caja(id),
    CONSTRAINT fk_movimiento_cobranza FOREIGN KEY (cobranza_id) REFERENCES cobranza(id),
    CONSTRAINT fk_movimiento_solicitud FOREIGN KEY (solicitud_pago_id) REFERENCES solicitud_pago(id),
    CONSTRAINT fk_movimiento_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    KEY idx_movimiento_caja_fecha (caja_id, fecha_hora)
);

INSERT INTO rol (nombre, descripcion) VALUES
    ('ADMINISTRADOR', 'Acceso completo al sistema'),
    ('OPERADOR', 'Operaciones administrativas y de caja');