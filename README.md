# Fibonacci Calculator MVC

Este proyecto implementa un **calculador de números de Fibonacci** utilizando el **patrón de arquitectura Modelo‑Vista‑Controlador (MVC)** en Java.

La idea principal es separar claramente:
- **Modelo:** lógica del cálculo de Fibonacci  
- **Vista:** interfaz de usuario (consola o GUI)  
- **Controlador:** coordina interacciones entre Vista y Modelo

Este patrón ayuda a mantener el código **organizado, escalable y fácil de mantener** al separar responsabilidades. :contentReference[oaicite:0]{index=0}

---

## 🧠 ¿Qué hace este proyecto?

Este proyecto:
- Calcula el *n‑ésimo* número de la secuencia de Fibonacci.
- Está estructurado con el patrón MVC para demostrar cómo se puede organizar una aplicación en capas separadas.
- Sirve como ejemplo práctico para aprender MVC aplicado a un caso simple pero significativo.

---

## 🛠️ Estructura del proyecto

La estructura del proyecto sigue este esquema, con responsabilidades claras por carpeta:

- `controller/` ← Controladores que exponen la API o gestionan entradas  
- `handlers/` ← Encapsulan la lógica de negocio específica  
- `dtos/` ← Objetos de transferencia de datos (Request/Response)  
- `services/` ← Servicios con lógica de negocio reutilizable  
- `repository/` ← Acceso a datos y persistencia  
- `entities/` ← Clases de dominio y entidades  
- `configuration/` ← Configuraciones y beans de Spring o Java

> Cada capa tiene una responsabilidad específica, lo que facilita **mantenimiento, testing y escalabilidad**.

