# Listado de Módulos Funcionales — SIGCOIN

## 1. Criterio de Priorización (Alcance MVP vs Evolutivo)

* **P0 — Crítico (Core MVP):** Módulos indispensables sin los cuales el sistema no puede operar. Constituyen la columna vertebral de la solución.
* **P1 — Alto (MVP Completo):** Módulos que completan los flujos operativos principales de cobranzas, comprobantes y tesorería.
* **P2 — Evolutivo (Fase 2):** Funcionalidades avanzadas, portales externos e integraciones de terceros previstas para etapas posteriores a la asignatura.

---

## 2. Módulos del Producto Mínimo Viable (MVP)

| Prioridad | Módulo | Descripción General | Funcionalidades Principales |
|---|---|---|---|
| **P0** | **Autenticación y Autorización** | Control de acceso seguro a la plataforma interna según perfiles. | Login, Logout, gestión de sesiones, roles `ADMINISTRADOR` y `OPERADOR`. |
| **P0** | **Gestión de Personas** | Registro centralizado de propietarios, inquilinos y garantes. | ABM completo, baja lógica, filtros de búsqueda global por DNI/CUIT, Nombre o Apellido. |
| **P0** | **Gestión de Inmuebles** | Administración del inventario de unidades inmobiliarias. | ABM de propiedades, asociación con propietarios (porcentajes de dominio), estado ocupacional. |
| **P0** | **Gestión de Contratos** | Definición y seguimiento de contratos de alquiler. | Alta de contratos, asignación de inquilinos y garantes, importe inicial/vigente, periodicidad de ajuste e índice asociado. |
| **P0** | **Gestión de Cobranzas** | Registro de cobro de períodos mensuales de alquiler. | Imputación de pago, medio de pago, fecha, registro de operador y cambio de estado a completado. |
| **P1** | **Gestión de Comprobantes** | Emisión de recibos inmutables y comprobantes complementarios. | Generación de recibos con numeración correlativa por punto de venta, emisión de comprobantes por novedades posteriores, anulación justificada. |
| **P0** | **Gestión de Tesorería y Cajas** | Control de Cajas Chicas por usuario y Caja Maestra. | Registro de movimientos (ingresos/egresos/transferencias), saldos en tiempo real y arqueo de caja por turno. |
| **P1** | **Turnero de Pagos** | Ordenamiento de egresos sujeto a disponibilidad líquida. | Registro de solicitudes de pago a propietarios o servicios, asignación de prioridades y liquidación autorizada por Gerencia. |
| **P1** | **Ajustes de Contratos** | Incremento automático del alquiler según índice (ICL/IPC). | Consulta del proveedor de índices simulado, cálculo del nuevo canon locativo, registro histórico del ajuste. |
| **P1** | **Dashboard & Buscador Global** | Panel de control diario y utilidades de búsqueda rápida. | Indicadores clave (saldos, cobres pendientes del mes, contratos a vencer), buscador directo multi-criterio. |

---

## 3. Módulos Evolutivos (Fase 2)

| Prioridad | Módulo | Alcance Evolutivo Posterior |
|---|---|---|
| **P2** | **Portal de Autogestión** | Acceso web para que inquilinos descarguen recibos y propietarios consulten liquidaciones. |
| **P2** | **Facturación Electrónica (AFIP/ARCA)** | Emisión directa de comprobantes fiscales homologados vía Web Services. |
| **P2** | **Conciliación Bancaria** | Importación automática de extractos bancarios (CBU/CVU) para conciliación de cobranzas. |
| **P2** | **Notificaciones Externas** | Envío automático de avisos de vencimiento y recibos digitales por WhatsApp Business / Email. |
| **P2** | **Integración Real BCRA / INDEC** | Cliente HTTP para consumir los servicios web oficiales del Banco Central y del INDEC. |

---

## 4. Diagramas UML de Módulos

Para una especificación detallada del comportamiento y la interacción entre módulos:
* [Diagrama UML de Componentes de Módulos](diagrams/uml-component-diagram.md)
* [Diagramas UML de Secuencia Operativos](diagrams/uml-sequence-diagrams.md)
