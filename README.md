# SIGCOIN — Sistema de Gestión Contable Inmobiliaria

> **Trabajo Final Integrador (TFI)**  
> **Carrera:** Tecnicatura Universitaria en Programación (UTN)  
> **Instancia Evaluativa:** Segunda Entrega — Diseño y Módulos  

---

## Equipo de Trabajo

* **Integrantes:** Mauro Maximiliano Cuquejo, Melisa Magalí Diaz de Quintana  
* **Tutor:** Juan Ignacio Schiavonni  
* **Repositorio Único de GitHub:** [TFI_Cuquejo_DiazdeQuintana](https://github.com/melisaddq/TFI_Cuquejo_DiazdeQuintana)  

---

## Segunda Entrega — Estado de Cumplimiento & Validación

Esta entrega valida el diseño completo de la base de datos, el listado y priorización de módulos funcionales, la 
arquitectura técnica elegida y la estructura inicial del repositorio.

> **IMPORTANTE:**
> Esta entrega **no incluye código ni implementación de lógica de negocio**. Únicamente se presentan diagramas, 
> esquemas DDL/DML, documentación técnica de arquitectura y la estructura base de carpetas y configuraciones para 
> preparar los entornos de desarrollo.

### Checklist de Entrega

- [x] **Diseño de Base de Datos** (modelo relacional MySQL, claves, índices e integridad referencial).
- [x] **Listado de Módulos prioritarios (P0/P1/P2)** con alcance MVP y evolutivo.
- [x] **Arquitectura del Proyecto documentada** (Arquitectura Hexagonal - Puertos & Adaptadores, Java 21 y Spring Boot para el Backend, React y TypeScript para el Frontend).
- [x] **Estructura de Repositorio Organizada** (carpetas `/frontend`, `/backend`, `/database`, `/docs`).
- [x] **Scripts de Base de Datos DDL y DML** subidos a `/database`.
- [x] **Diagramas UML** (Clases, Componentes y Secuencia) subidos a `/docs/diagramas/`.
- [x] **README.md actualizado** con enlaces a toda la documentación del proyecto.

---

## Estructura del Repositorio Único

El repositorio ha sido estructurado en módulos independientes de frontend y backend, manteniendo el proyecto 
centralizado en un único repositorio:

```text
TFI_Cuquejo_DiazdeQuintana/
├── 📁 backend/                # Proyecto API REST Java 21 + Spring Boot (Hexagonal)
│   ├── 📁 src/main/java/ar/edu/utn/tupad/sigcoin/
│   │   ├── 📁 domain/        # Entidades puras y Puertos de aplicación
│   │   ├── 📁 application/   # Servicios y casos de uso
│   │   └── 📁 infrastructure/# Adaptadores REST (Controllers) y JPA Repositories
│   ├── 📁 src/main/resources/# Configuración application.properties
│   ├── 📄 build.gradle       # Configuración de dependencias Gradle
│   └── 📄 settings.gradle
│
├── 📁 frontend/               # Proyecto SPA React 18 + TypeScript (Vite)
│   ├── 📁 public/            # Recursos estáticos
│   ├── 📁 src/               # Código fuente UI
│   │   ├── 📁 components/    # Componentes UI reutilizables
│   │   ├── 📁 modules/       # Estructura modular (Auth, Personas, Contratos, etc.)
│   │   ├── 📁 services/      # Servicios de comunicación con API REST
│   │   ├── 📁 types/         # Interfaces y tipos de TypeScript
│   │   ├── 📄 App.tsx        # Shell principal de la aplicación
│   │   ├── 📄 main.tsx       # Punto de entrada React
│   │   └── 📄 index.css      # Sistema de diseño de estilos base
│   ├── 📄 package.json       # Dependencias Vite + React + Lucide
│   ├── 📄 tsconfig.json      # Configuración de TypeScript
│   └── 📄 vite.config.ts     # Configuración de servidor de desarrollo y proxy API
│
├── 📁 database/               # Scripts de Base de Datos MySQL
│   ├── 📄 schema.sql         # Script DDL completo de creación de tablas e índices
│   └── 📄 inicializacion.sql           # Script DML de datos semilla iniciales
│
└── 📁 docs/                   # Documentación de Análisis, Diseño y UML
    ├── 📄 arquitectura.md    # Documento de Arquitectura Hexagonal y decisiones
    ├── 📄 modulos.md         # Listado funcional de módulos, alcance y prioridades
    ├── 📄 modelo-base-de-datos.md # Especificación del modelo relacional
    └── 📁 diagramas/         # Diagramas UML en formato Mermaid
        ├── 📄 diagrama-clases-uml.md     # Diagrama UML de Clases del Dominio
        ├── 📄 diagrama-componentes-uml.md # Diagrama UML de Componentes del Sistema
        └── 📄 diagrama-secuencias-uml.md # Diagramas UML de Secuencia (Flujos principales)
```


---

## Índice de Documentación Entregada

Toda la documentación requerida para la evaluación del tutor se encuentra accesible a través de los siguientes enlaces directos:

1. **[Arquitectura del Proyecto (`docs/arquitectura.md`)](docs/arquitectura.md):** Justificación del stack tecnológico (Java 21, Spring Boot, React, TypeScript, MySQL, AWS EC2), división en capas de la Arquitectura Hexagonal y estrategia de despliegue.
2. **[Listado de Módulos Funcionales (`docs/modulos.md`)](docs/modulos.md):** Matriz de prioridades (P0 - Críticos, P1 - Altos, P2 - Evolutivos) y desglose de capacidades para el MVP.
3. **[Diseño de Base de Datos (`docs/modelo-base-de-datos.md`)](docs/modelo-base-de-datos.md):** Especificación del modelo entidad-relación, reglas de integridad, índices principales y justificación del motor relacional MySQL.
4. **Diagramas UML Mermaid (`docs/diagramas/`):**
   * [Diagrama UML de Clases del Dominio](docs/diagramas/diagrama-clases-uml.md)
   * [Diagrama UML de Componentes del Sistema](docs/diagramas/diagrama-componentes-uml.md)
   * [Diagramas UML de Secuencia (Cobranzas, Ajustes, Turnero)](docs/diagramas/diagrama-secuencias-uml.md)
5. **Base de Datos (`database/`):**
   * [Esquema DDL de Base de Datos (`database/schema.sql`)](database/schema.sql)
   * [Datos Semilla DML (`database/inicializacion.sql`)](database/inicializacion.sql)

---

## Resumen del Proyecto SIGCOIN

El **Sistema de Gestión Contable Inmobiliaria (SIGCOIN)** resuelve la fragmentación operativa del rubro inmobiliario ofreciendo:
* **Buscador unificado de clientes y propiedades:** Localización instantánea por DNI, CUIT, nombre o dirección.
* **Inmutabilidad en la emisión de comprobantes:** Recibos oficiales protegidos contra alteraciones, con soporte para comprobantes complementarios por novedades.
* **Tesorería y Turnero de Pagos:** Manejo transparente de Cajas Chicas por operador, Caja Maestra consolidada y turnero de pago sujeto a liquidez diaria.
* **Ajustes contractuales por inflación:** Cálculo de alquileres basado en índices oficiales (ICL/IPC).

---

## Tablero de Seguimiento del Proyecto

* **ClickUp:** [Tablero de Seguimiento del Proyecto](https://app.clickup.com/90171307341/v/b/li/901717366518)
