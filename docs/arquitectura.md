# Arquitectura del Proyecto - SIGCOIN

## 1. Objetivo y Visión General

El **Sistema de Gestión Contable Inmobiliaria (SIGCOIN)** es una plataforma web integral diseñada para centralizar, 
automatizar y auditar la administración contable de una empresa inmobiliaria. El sistema abarca el ciclo de vida 
completo de clientes (propietarios, inquilinos, garantes), inmuebles administrados, contratos de alquiler, cobranzas, 
emisión de comprobantes, ajustes por inflación y control de tesorería (cajas chicas y caja maestra).

---

## 2. Arquitectura Elegida: Hexagonal (Puertos & Adaptadores)

Para garantizar un alto grado de desacoplamiento, la mantenibilidad del código a largo plazo y la facilidad de prueba, 
se adopta la **Arquitectura Hexagonal (Puertos y Adaptadores)** en el backend, complementada con una aplicación cliente 
de página única (SPA) en el frontend.

### Esquema Conceptual de la Arquitectura

```text
+-----------------------------------------------------------------------------------+
|                            FRONTEND SPA (React + TypeScript)                      |
+-----------------------------------------------------------------------------------+
                                          |
                                    HTTP / REST (JSON)
                                          v
+-----------------------------------------------------------------------------------+
| CAPA DE ADAPTADORES DE ENTRADA (REST Controllers, DTOs, Validaciones API)         |
+-----------------------------------------------------------------------------------+
                                          |
                                    Puertos de Entrada
                                          v
+-----------------------------------------------------------------------------------+
| CAPA DE APLICACIÓN (Casos de Uso, Coordinación de Servicios de Negocio)          |
+-----------------------------------------------------------------------------------+
                                          |
                                    Dominio Puro
                                          v
+-----------------------------------------------------------------------------------+
| CAPA DE DOMINIO (Entidades, Objetos de Valor, Reglas Financieras y Validaciones)  |
+-----------------------------------------------------------------------------------+
                                          |
                                    Puertos de Salida
                                          v
+-----------------------------------------------------------------------------------+
| CAPA DE ADAPTADORES DE SALIDA (Infraestructura, JPA Repositories, Clientes HTTP)  |
+-----------------------------------------------------------------------------------+
                     |                                       |
                     v                                       v
        [MySQL 8.0 - Base Relacional]             [Proveedor de Índices (ICL/IPC)]
                                                  - Adaptador Simulado (MVP)
                                                  - BCRA / INDEC API (Evolutivo)
```

---

## 3. Tecnologías Definitivas y Justificación

| Componente | Tecnología Seleccionada | Justificación Técnica |
|---|---|---|
| **Interfaz (Frontend)** | React 18, TypeScript, Vite | SPA responsiva, validación de formularios de carga y filtros de búsqueda rápida. |
| **Backend API** | Java 21, Spring Boot 4.x | Entorno robusto con soporte nativo para programación orientada a objetos, gestión de transacciones declarativas y ecosistema maduro de seguridad y APIs REST. |
| **Persistencia** | Spring Data JPA, MySQL 8.0 | Modelo relacional idóneo para contratos, comprobantes y movimientos financieros que exigen cumplimiento estricto de propiedades ACID. |
| **Documentación API** | OpenAPI 3.0 / Swagger UI | Especificación interactiva del contrato API entre el equipo frontend y backend. |
| **Índices Contractuales** | Adaptador simulado en MVP (Evolutivo a BCRA/INDEC via HTTP) | Permite probar la lógica de cálculo e incremento de alquileres sin bloquear el desarrollo por dependencias de APIs externas. |
| **Infraestructura Cloud** | AWS EC2 (Servidor Web & API) | Instancia Linux para despliegue de la API Spring Boot y alojamiento estático del frontend. |

---

## 4. Estructura del Repositorio y Carpetas del Proyecto

El proyecto se encuentra organizado en un **único repositorio de GitHub** con proyectos independientes separados por responsabilidad:

```text
TFI_Cuquejo_DiazdeQuintana/
├── frontend/                  # Proyecto SPA React + TypeScript (Vite)
│   ├── public/
│   ├── src/
│   │   ├── components/       # Componentes UI reutilizables
│   │   ├── modules/          # Módulos funcionales (Auth, Personas, Contratos, etc.)
│   │   ├── services/         # Clientes de API REST
│   │   └── types/            # Definiciones de tipos TypeScript
│   ├── package.json
│   └── vite.config.ts
│
├── backend/                   # Proyecto API REST Java 21 + Spring Boot
│   ├── src/main/java/ar/edu/utn/tupad/sigcoin/
│   │   ├── domain/           # Entidades puras y Puertos (Interfaces)
│   │   ├── application/      # Servicios de aplicación y casos de uso
│   │   └── infrastructure/   # Adaptadores REST (Controllers) y Adaptadores JPA/HTTP
│   ├── src/main/resources/   # application.properties y configuraciones
│   └── build.gradle
│
├── database/                  # Scripts SQL de Base de Datos
│   ├── schema.sql            # Definición DDL completa (Tablas, Claves, Índices)
│   └── inicializacion.sql              # Datos iniciales DML (Roles, Usuarios demo, Índices)
│
└── docs/                      # Documentación y Diagramas UML
    ├── arquitectura.md       # Presente documento de arquitectura
    ├── modulos.md            # Listado de módulos y prioridades
    ├── modelo-base-de-datos.md # Esquema relacional e integridad
    └── diagramas/            # Diagramas UML Mermaid (Clases, Componentes, Secuencias)
```


---

## 5. Diagramas UML de la Arquitectura

Para consultar la representación gráfica completa de la arquitectura y los flujos:
* [Diagrama UML de Componentes del Sistema](diagramas/diagrama-componentes-uml.md)
* [Diagrama UML de Clases del Dominio](diagramas/diagrama-clases-uml.md)
* [Diagramas UML de Secuencia para Procesos Clave](diagramas/diagrama-secuencias-uml.md)

---

## 6. Despliegue en la Nube (AWS EC2)

La arquitectura de despliegue prevista para la entrega final incluye:
1. **Backend Service:** Proceso de Spring Boot ejecutándose en puerto 8080 controlado por un servicio de sistema.
2. **Database:** Servidor MySQL 8.0 local en la instancia EC2 o servicio administrado en la nube con acceso restringido a la IP local del backend.
3. **Frontend Web:** Archivos estáticos de React servidos mediante Nginx.
