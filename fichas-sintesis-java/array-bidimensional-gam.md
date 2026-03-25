# Ejercicio: "El Tesoro Escondido"

## Objetivo
Buscar un tesoro escondido en una isla representada por un array bidimensional. Cada celda del array puede contener diferentes elementos, como tierra, agua o el tesoro.

### Descripción del Juego

- **El escenario:** Una isla de 5x5 celdas.
- **Elementos en el array:**
  - `0`: Tierra
  - `1`: Agua
  - `2`: Tesoro (solo hay uno en el array)

### Paso a Paso

1. **Definir el Array:**
   Crea un array bidimensional que represente la isla.

   ```java
   int[][] isla = {
       {0, 0, 1, 0, 0},
       {0, 1, 0, 0, 0},
       {0, 0, 0, 1, 0},
       {0, 0, 0, 0, 2},
       {1, 0, 0, 0, 0}
   };
