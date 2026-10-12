-- SIGCOIN - Datos Semilla Iniciales (Seed Script)
-- Utilizar sobre la base de datos 'sigcoin' después de ejecutar schema.sql

USE sigcoin;

-- 1. Usuarios Semilla (Contraseñas hasheadas en formato BCrypt simulado/demo)
INSERT INTO usuario (rol_id, nombre_usuario, email, password_hash, activo) VALUES
    (1, 'admin', 'admin@sigcoin.inmobiliaria.com', '$2a$12$eImiTXuWVxfM37uY4JANjOL.8844883377221199', TRUE),
    (2, 'operador1', 'operador@sigcoin.inmobiliaria.com', '$2a$12$eImiTXuWVxfM37uY4JANjOL.8844883377221199', TRUE);

-- 2. Cajas de Tesorería Iniciales
INSERT INTO caja (usuario_id, nombre, tipo, moneda, saldo, activa) VALUES
    (NULL, 'Caja Maestra Gerencial', 'MAESTRA', 'ARS', 0.00, TRUE),
    (1, 'Caja Chica - Administración Central', 'CHICA', 'ARS', 0.00, TRUE),
    (2, 'Caja Chica - Operador Ventas/Alquileres', 'CHICA', 'ARS', 0.00, TRUE);

-- 3. Índices de Referencia Iniciales (Ejemplo IPC / ICL para pruebas de cálculo)
INSERT INTO indice (tipo, periodo, valor, fuente) VALUES
    ('ICL', '2026-01-01', 12.450000, 'BCRA - Simulado'),
    ('ICL', '2026-02-01', 12.980000, 'BCRA - Simulado'),
    ('ICL', '2026-03-01', 13.520000, 'BCRA - Simulado'),
    ('IPC', '2026-01-01', 280.500000, 'INDEC - Simulado'),
    ('IPC', '2026-02-01', 291.200000, 'INDEC - Simulado'),
    ('IPC', '2026-03-01', 302.800000, 'INDEC - Simulado');
