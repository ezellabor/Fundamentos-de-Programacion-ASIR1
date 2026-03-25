#"El Tesoro Escondido"

## Objetivo
Buscar un tesoro escondido en una isla representada por un ```array bidimensional```. Cada celda del array puede contener diferentes elementos, como ```tierra, agua o el tesoro.```

### Descripción del Juego

- **El escenario:** Una isla de 5x5 celdas.
- **Elementos en el array:**
  - `0`: Tierra
  - `1`: Agua
  - `2`: Tesoro _(solo hay uno en el array)_

### Paso a paso

1. **Definir/Declarar el Array:**
   Crea un array bidimensional de tamaño 5x5 ```(5 filas por 5 columnas)``` que represente la isla.

   ```java
   int[][] isla = {
       {0, 0, 1, 0, 0},
       {0, 1, 0, 0, 0},
       {0, 0, 0, 1, 0},
       {0, 0, 0, 0, 2},
       {1, 0, 0, 0, 0}
   };
   ```

### 2. Mostrar la isla   

Escribe un método para imprimir el array de forma amigable.  

```java  
public static void mostrarIsla(int[][] isla) {
    for (int i = 0; i < isla.length; i++) {
        for (int j = 0; j < isla[i].length; j++) {
            System.out.print(isla[i][j] + " ");
        }
        System.out.println();
    }
}
```  

### 3. Buscar el tesoro

Permite a los alumnos ingresar coordenadas (fila y columna) para buscar el tesoro.

```java
import java.util.Scanner;

public static void buscarTesoro(int[][] isla) {
    Scanner scanner = new Scanner(System.in);
    boolean encontrado = false;

    while (!encontrado) {
        System.out.println("Ingresa las coordenadas (fila y columna) para buscar el tesoro:");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();

        if (isla[fila][columna] == 2) {
            System.out.println("¡Felicidades! Has encontrado el tesoro en (" + fila + ", " + columna + ")!");
            encontrado = true;
        } else if (isla[fila][columna] == 1) {
            System.out.println("Has encontrado agua. Intenta de nuevo.");
        } else {
            System.out.println("Has encontrado tierra. Sigue buscando.");
        }
    }
}
```

### 4. Ejecutar el juego  
Llama a los métodos en la función ```main```.  

```java
public static void main(String[] args) {
    int[][] isla = {
        {0, 0, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 0, 2},
        {1, 0, 0, 0, 0}
    };

    mostrarIsla(isla);
    buscarTesoro(isla);
}
```

### 5. Consideraciones adicionales  

- Puntos de Bonificación: Puedes añadir un sistema de puntos donde los alumnos ganen puntos por cada intento (aunque no encuentren el tesoro).
- Niveles: Varía el tamaño del array y la cantidad de tesoros en diferentes niveles.
- Colaboración: Permite que los alumnos jueguen en equipos, fomentando el trabajo en grupo.
