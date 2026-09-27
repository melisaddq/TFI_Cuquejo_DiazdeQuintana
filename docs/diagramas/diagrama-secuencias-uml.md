# Diagramas de Secuencia UML — Flujos Principales SIGCOIN

Este documento reúne los diagramas de secuencia UML correspondientes a los procesos de negocio críticos del **Sistema de Gestión Contable Inmobiliaria (SIGCOIN)**.

---

## 1. Flujo de Registro de Cobranza y Emisión de Comprobante

Este flujo describe cómo un operador registra el cobro del alquiler de un contrato y el sistema impacta el movimiento en la caja chica y emite el recibo inmutable.

```mermaid
sequenceDiagram
    autonumber
    actor Operador
    participant UI as Frontend SPA (React)
    participant REST as CobranzaController
    participant Service as ServicioCobranza
    participant CajaService as ServicioCaja
    participant DB as Repositorio JPA (MySQL)

    Operador->>UI: Ingresa pago (Contrato ID, Período, Importe, Medio Pago)
    UI->>REST: POST /api/v1/cobranzas (DTO Cobranza)
    REST->>Service: registrarCobranza(comando)
    Service->>DB: Buscar Contrato y verificar vigencia
    DB-->>Service: Contrato encontrado
    Service->>DB: Guardar registro de Cobranza (Estado: COMPLETADA)
    Service->>Service: Generar Comprobante Principal (Numeración correlativa)
    Service->>DB: Guardar Comprobante
    Service->>CajaService: registrarIngresoCaja(cajaId, importe, concepto)
    CajaService->>DB: Actualizar Saldo Caja + Guardar MovimientoCaja
    DB-->>CajaService: Movimiento registrado
    Service-->>REST: Confirmación de Cobranza + DTO Comprobante
    REST-->>UI: 201 Created (Datos de Comprobante emitido)
    UI-->>Operador: Muestra recibo digital generado y actualiza caja en pantalla
```

---

## 2. Flujo de Cálculo e Incremento Automatizado de Alquileres (Ajuste por Índice)

Este flujo describe la consulta al proveedor de índices simulado (ICL/IPC) y el cálculo e incremento del canon locativo.

```mermaid
sequenceDiagram
    autonumber
    actor Operador
    participant UI as Frontend SPA (React)
    participant REST as ContratoController
    participant Service as ServicioAjustes
    participant PuertoIndice as PuertoProveedorIndice
    participant AdaptadorSim as AdaptadorIndiceSimulado
    participant DB as Repositorio JPA (MySQL)

    Operador->>UI: Solicita calcular ajuste para Contrato X
    UI->>REST: POST /api/v1/contratos/{id}/calcular-ajuste
    REST->>Service: calcularAjusteContrato(contratoId)
    Service->>DB: Obtener Contrato (Importe actual, Tipo índice, Fecha último ajuste)
    DB-->>Service: Datos del Contrato
    Service->>PuertoIndice: obtenerValorIndice(tipoIndice, periodo)
    PuertoIndice->>AdaptadorSim: consultarIndice(tipoIndice, periodo)
    AdaptadorSim-->>PuertoIndice: Valor del Índice (Ej. 13.52 ICL)
    PuertoIndice-->>Service: Valor retornado
    Service->>Service: Aplicar fórmula: Nuevo Importe = ImporteAnterior * (IndiceNuevo / IndiceAnterior)
    Service->>DB: Registrar AjusteContrato y actualizar importeVigente en Contrato
    DB-->>Service: Confirmación de actualización
    Service-->>REST: Resultado del Ajuste (Importe Anterior, % Incremento, Nuevo Importe)
    REST-->>UI: 200 OK (Detalle de Ajuste)
    UI-->>Operador: Visualiza actualización contractual aprobada
```

---

## 3. Flujo de Turnero de Pagos y Consolidación de Cajas

Este flujo documenta la solicitud de pago de un egreso (ej. liquidación a propietario o pago de servicio), su priorización en el turnero y la aprobación según liquidez de la Caja Maestra.

```mermaid
sequenceDiagram
    autonumber
    actor Operador
    actor Admin as Administrador / Gerente
    participant UI as Frontend SPA (React)
    participant REST as TurneroController
    participant Service as ServicioTesorteria
    participant DB as Repositorio JPA (MySQL)

    Operador->>UI: Solicita orden de pago (Concepto, Importe, Prioridad)
    UI->>REST: POST /api/v1/solicitudes-pago
    REST->>Service: crearSolicitudPago(datos)
    Service->>DB: Guardar SolicitudPago (Estado: PENDIENTE)
    DB-->>Service: Solicitud Creada
    Service-->>REST: DTO SolicitudPago
    REST-->>UI: 201 Created

    Admin->>UI: Revisa Turnero de Pagos y liquidez en Caja Maestra
    Admin->>UI: Autorizar y Ejecutar Pago (Solicitud ID, Caja Orig/Dest)
    UI->>REST: POST /api/v1/solicitudes-pago/{id}/ejecutar
    REST->>Service: ejecutarPagoSolicitud(id)
    Service->>DB: Verificar saldo suficiente en Caja Maestra
    DB-->>Service: Saldo OK
    Service->>DB: Actualizar SolicitudPago (Estado: PAGADA)
    Service->>DB: Descontar de Caja Maestra + Registrar MovimientoCaja Egresos
    DB-->>Service: Transacción exitosa
    Service-->>REST: Confirmación de Ejecución de Pago
    REST-->>UI: 200 OK
    UI-->>Admin: Muestra comprobante de egreso y saldo actualizado
```
