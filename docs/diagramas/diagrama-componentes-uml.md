# Diagrama de Componentes UML y Estructura de Módulos

Este documento presenta el diagrama de componentes UML y la organización modular del **Sistema de Gestión Contable Inmobiliaria (SIGCOIN)**.

## Diagrama UML de Componentes del Sistema

```mermaid
flowchart TB
    subgraph UI["Capa de Presentación (Frontend SPA)"]
        UI_Auth["Módulo Autenticación UI"]
        UI_PersonaInmueble["Módulo Personas & Inmuebles UI"]
        UI_Contrato["Módulo Contratos UI"]
        UI_Cobranza["Módulo Cobranzas & Comprobantes UI"]
        UI_CajaTurnero["Módulo Cajas & Turnero UI"]
        UI_Dashboard["Dashboard UI"]
    end

    subgraph C["Capa de Adaptadores de Entrada (REST Controllers)"]
        C_Auth["AuthController"]
        C_Persona["PersonaController"]
        C_Inmueble["InmuebleController"]
        C_Contrato["ContratoController"]
        C_Cobranza["CobranzaController"]
        C_Comprobante["ComprobanteController"]
        C_Caja["CajaController"]
        C_Turnero["TurneroController"]
    end

    subgraph S["Capa de Aplicación & Dominio (Hexagonal Core)"]
        S_Auth["Servicio de Autenticación"]
        S_Persona["Servicio de Clientes"]
        S_Contrato["Servicio de Contratos & Ajustes"]
        S_Caja["Servicio de Tesorería & Cajas"]
        S_Cobranza["Servicio de Cobranzas & Recibos"]
        S_Indice["Motor de Cálculo de Índices"]
    end

    subgraph A["Capa de Adaptadores de Salida (Infraestructura)"]
        A_JPA["Spring Data JPA Repositories"]
        A_IndiceSim["Proveedor de Índices Simulado"]
        A_IndiceHTTP["Cliente HTTP BCRA/INDEC (Evolutivo)"]
    end

    subgraph DB_BOX["MySQL 8.0"]
        DB[("Base de Datos Relacional")]
    end

    UI_Auth -->|REST / JSON| C_Auth
    UI_PersonaInmueble -->|REST / JSON| C_Persona
    UI_PersonaInmueble -->|REST / JSON| C_Inmueble
    UI_Contrato -->|REST / JSON| C_Contrato
    UI_Cobranza -->|REST / JSON| C_Cobranza
    UI_Cobranza -->|REST / JSON| C_Comprobante
    UI_CajaTurnero -->|REST / JSON| C_Caja
    UI_CajaTurnero -->|REST / JSON| C_Turnero
    UI_Dashboard -->|REST / JSON| C_Cobranza

    C_Auth --> S_Auth
    C_Persona --> S_Persona
    C_Inmueble --> S_Persona
    C_Contrato --> S_Contrato
    C_Cobranza --> S_Cobranza
    C_Comprobante --> S_Cobranza
    C_Caja --> S_Caja
    C_Turnero --> S_Caja

    S_Contrato --> S_Indice
    S_Indice -->|Puerto ProveedorIndice| A_IndiceSim
    S_Indice -.->|Evolución futura| A_IndiceHTTP

    S_Auth --> A_JPA
    S_Persona --> A_JPA
    S_Contrato --> A_JPA
    S_Cobranza --> A_JPA
    S_Caja --> A_JPA

    A_JPA -->|JDBC / SQL| DB
```
