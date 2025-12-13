# Fibonacci Calculator MVC

Este proyecto implementa un **calculador de números de Fibonacci** utilizando el **patrón de arquitectura Modelo‑Vista‑Controlador (MVC)** orientado a **API REST** en Java.

La idea principal es separar claramente las responsabilidades:
- **Modelo:** lógica del cálculo de Fibonacci y entidades de dominio  
- **Controlador:** expone endpoints REST y gestiona las solicitudes HTTP  
- **Handlers/Services:** encapsulan la lógica de negocio y coordinación entre capas  

Esta arquitectura permite tener un código **modular, escalable y fácil de testear**, adaptado a aplicaciones backend sin necesidad de una interfaz gráfica.

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

## 🌐 Endpoints del Servicio

* El servicio está disponible en el puerto `8085` de forma local (`http://localhost:8085`).

* El servicio está disponible en el puerto `8085` en Cloud (`http://54.94.97.140:8085`).

| Endpoint | Método | Parámetro | Descripción |
| :--- | :--- | :--- | :--- |
| `/fibonacci/get-nth-number` | `POST` | **number** (obligatorio) | Retorna el **$n$-ésimo número** de la secuencia de Fibonacci.|
| `/fibonacci/occurrences` | `GET` | *Ninguno* | Retorna una lista ordenada de mayor a menor contando las **ocurrencias** de cada número de Fibonacci consultado previamente. |

### 📖 Interfaz de Usuario de Swagger (OpenAPI)

Accede a la documentación interactiva para explorar y probar todos los endpoints:

* **URL:** `http://localhost:8085/swagger-ui.html`
* **Cloud:** `http://54.94.97.140:8085/swagger-ui/index.html`

