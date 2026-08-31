# SIGCOIN - Sistema de Gestión Contable Inmobiliaria

---

## Trabajo Final Integrador - Primera Entrega

---

## 👥 Equipo de Trabajo

* **Integrantes:** Mauro Maximiliano Cuquejo, Melisa Magalí Diaz de Quintana

* **Tutor:** Juan Ignacio Schiavonni

* **Fecha de Entrega:** 30 de Agosto de 2026

* **Repositorio:** [TFI_Cuquejo_DiazdeQuintana](https://github.com/melisaddq/TFI_Cuquejo_DiazdeQuintana)



## 📑 Resumen Ejecutivo

El presente Trabajo Final Integrador documenta la planificación, diseño y estrategia de calidad para el desarrollo del **Sistema de Gestión Contable Inmobiliaria (SIGCOIN)**, una solución digital orientada a modernizar y centralizar la gestión contable del rubro inmobiliario.

A partir de la experiencia adquirida en distintas empresas de dicho sector, hemos observado que sus sistemas de gestión actuales carecen de la integración necesaria para facilitar de forma adecuada las responsabilidades diarias del ámbito contable. A saber: la falta de integración con herramientas externas o de utilidades específicas en el manejo de cajas chicas, facturación, definición de tipos de contrataciones y percepciones. En este caso, los usuarios se ven obligados a trabajar con un conjunto de herramientas diversas, tanto físicas como virtuales, para luego realizar una unificación manual de la información. Esto dificulta enormemente los procesos de control, seguimiento y calidad.



## 💡 Propuesta de Valor y Solución

El sistema optimiza la administración inmobiliaria mediante la automatización y centralización de los siguientes procesos clave:



* **Buscador unificado de propietarios e inquilinos:** Permite localizar rápidamente información mediante DNI/CUIT, nombre, apellido, garante o dirección del inmueble.

* **Gestión en todo momento de datos de contacto:** Facilita la actualización inmediata de los datos en cualquier instancia del flujo operativo.

* **Emisión de comprobantes complementarios:** Habilita el registro de novedades operativas con posterioridad al cobro o pago, resguardando la inmutabilidad contable del recibo original.

* **Consolidación de cajas y gestión de turnos financieros:** Ofrece visibilidad en tiempo real de las Cajas Chicas y la Caja Maestra, implementando un turnero de pagos supeditado a la liquidez diaria disponible.

* **Cálculo e incremento automatizado de alquileres:** Se conecta directamente a las APIs oficiales del BCRA e INDEC para determinar los ajustes contractuales (ICL/IPC).



## 🎯 Alcance del Proyecto (MVP)



| Módulo / Capacidad   | Incluido en MVP (Fase 1)                                                            | Excluido (Fase 2 / Evolutivo)                                    |
|----------------------|-------------------------------------------------------------------------------------|------------------------------------------------------------------|
| Clientes y Contratos | ABM de propietarios, inquilinos, garantes y contratos de alquiler. Buscador global. | Portal de autogestión para inquilinos y propietarios.            |
| Gestión de Caja      | Cajas chicas individuales por usuario y vista de Caja Maestra gerencial.            | Conciliación bancaria automatizada por CBU/CVU.                  |
| Facturación          | Recibos principales y comprobantes complementarios por novedades.                   | Facturación electrónica directa con AFIP/ARCA.                   |
| Ajustes de Contrato  | Consulta automatizada de índices (BCRA / INDEC) y cálculo de aumentos.              | Proyección predictiva de rentabilidad mediante Machine Learning. |
| Operaciones          | Dashboard interactivo y turnero manual de pagos según liquidez.                     | Módulo de pago a proveedores y alertas vía WhatsApp Business.    |_



## 📊 Evaluación de Viabilidad

* **Viabilidad Operativa:** Se encuentra respaldada por la validación continua de una experta en el mercado de inmuebles, lo que asegura que cada solución diseñada se ajuste estrictamente a las demandas y flujos operativos del entorno real.

* **Viabilidad Técnica:** El grupo de trabajo posee una sólida trayectoria en la implementación de arquitecturas multicapa y sistemas de alta transaccionalidad, con un enfoque específico en la gestión de lógica financiera compleja.

* **Viabilidad Temporal:** Se ha definido un Producto Mínimo Viable (MVP) riguroso que posterga la integración de proveedores y alertas externas, priorizando así el cumplimiento efectivo de los plazos establecidos por el calendario académico.



## 🚀 Estrategia de Ejecución del Proyecto

Nuestro proyecto propone la construcción y entrega de un **Producto Mínimo Viable (MVP)** funcional en un plazo estricto de 4 meses, y la integración futura de funcionalidades que permitan resolver esta falta de integración, junto con el añadido de funcionalidades específicas de las cuales los sistemas actuales carecen.

Para garantizar el cumplimiento de este objetivo, el equipo de desarrollo estructuró la ejecución del proyecto basándose en los siguientes pilares técnicos y de gestión:



* **Estrategia y Metodología:** Se adoptó un Modelo Incremental guiado por el marco de trabajo ágil Scrum, lo que permite priorizar las funcionalidades críticas (Gestión de Usuarios, Facturación, Búsquedas dinámicas de información, Manejo de Tesorería) y asegurar entregas de valor tempranas.

* **Hoja de Ruta (Roadmap):** Se planificó un cronograma de 16 semanas, desglosando el esfuerzo en tres incrementos funcionales con un fuerte enfoque en la accesibilidad visual (UX/UI) y el desacoplamiento de vistas.

* **Gestión de Riesgos y Stakeholders:** Se identificaron y clasificaron los actores clave según su poder e interés, estableciendo planes de mitigación concretos frente a desafíos técnicos (como la migración desde otras alternativas de software legacy) y de negocio (resistencia al cambio y adopción del sistema).

* **Desglose de Tareas (WBS):** Se estructuró detalladamente el módulo de Autenticación y Registro, el módulo de Gestión de Contratos, el módulo de Facturación, y el módulo de Gestión de Caja; estimando el esfuerzo en horas ideales.

* **Aseguramiento de Calidad (QA):** Se diseñó un plan de pruebas integral que abarca técnicas de Caja Blanca y Caja Negra (partición de equivalencia, análisis de valores límite y tablas de decisión), evidenciando el impacto económico crítico que implicaría omitir el testeo temprano antes de salir a producción.



## 💻 Stack Tecnológico y Arquitectura

Seleccionamos herramientas con las que el equipo ya tiene experiencia para garantizar la viabilidad técnica y temporal del desarrollo, asumiendo que el mejor stack es el que ya se domina:



| Componente                           | Tecnologías             | Justificación Arquitectónica                                                                                                                                                                                                                   |
|--------------------------------------|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Aplicación Cliente (Frontend Web - SPA) | React, TypeScript, Vite | Construcción de un panel de control administrativo responsivo, optimizado para flujos rápidos de carga y enfocado en un diseño visualmente limpio, luminoso y minimalista.                                                                     |
| Servicios (Backend - API REST)       | Java, Spring Boot       | Implementación de Arquitectura Hexagonal (Puertos y Adaptadores) <br>• Dominio: Entidades y reglas de negocio puras.<br>• Puertos: Contratos para repositorios y APIs.<br> • Adaptadores: Controladores REST, Spring Data JPA y clientes HTTP. |
| Base de Datos                        | MySQL                   | La estructura definida y estable de los contratos, propiedades y clientes requiere la integridad transaccional que provee el modelo relacional.                                                                                                |
| Despliegue y Entornos                | AWS (Instancia EC2)     | Modelo de servidor tradicional (VPS) que otorga control total sobre el entorno, permitiendo alojar DB, API y archivos estáticos en una única unidad, cumpliendo el requisito académico de disponibilidad online.                               |



## 📁 Estructura del Repositorio

* `/frontend`: Código fuente de la interfaz web (React/TypeScript).

* `/backend`: Código fuente de la API y lógica de negocio (Java/Spring Boot).

* `/database`: Scripts DDL/DML y esquemas (MySQL).

* `/docs`: Informes, esquemas de avances, documentación técnica y enlace al video explicativo.

