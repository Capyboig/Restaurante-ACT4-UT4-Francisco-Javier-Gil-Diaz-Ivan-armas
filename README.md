# 🍽️ Sistema de Gestión de Pedidos - Restaurante v1.0

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05032.svg?style=for-the-badge&logo=git&logoColor=white)
---

##  Objetivo del Proyecto
Desarrollar una estructura en Java que permita registrar información de clientes y artículos, controlando el ciclo de vida del pedido y garantizando cálculos precisos de facturación.

## Equipo de Desarrollo

| Miembro | Responsabilidades (Fase de Desarrollo) |
| :--- | :--- |
| **Ivan Armas Trujillo** | **Parte 1: Estructura Base y Datos.** Definición de Enums, atributos estáticos de ID, estructura de almacenamiento (Arrays) y constructor inicial. |
| **Francisco Javier Gil Diaz** | **Parte 2: Métodos, Lógica y Validaciones.** Implementación de lógica de negocio, validación de límite de artículos (máx. 5), cálculo de totales y seguridad de estados. |

---

## Especificaciones Técnicas

### 1. Gestión de Artículos (Seguridad)
El sistema implementa una validación "Extras" que impide el desbordamiento de memoria, limitando cada pedido a un **máximo de 5 artículos**.

### 2. Flujo de Estados (No Retroceso)
Mediante el uso de un `Enum`, el pedido transita por estados controlados. Se ha implementado una lógica de seguridad que **impide el retroceso de estados** (ej. no es posible pasar de `ENTREGADO` a `EN_PREPARACION`).



### 3. Cómputo de Facturación
El sistema calcula automáticamente el precio total recorriendo las estructuras de datos y aplicando la fórmula:
`Total = Σ (Precio Unidad * Cantidad)`.

---

## Estructura del Repositorio

```text
src/
├── controller/
│   └── App.java           # Punto de entrada y pruebas de escenarios
└── model/
    ├── Pedido.java        # Núcleo de la lógica y persistencia temporal
    └── Estado_del_pedido  # Definición de estados lógicos (Enum)
