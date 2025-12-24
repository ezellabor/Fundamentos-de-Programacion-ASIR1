<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>
# MÓDULO 4: ARRAYS Y COLECCIONES

## 1. Arrays unidimensionales

Un array (arreglo) es una estructura de datos que permite almacenar múltiples valores del mismo tipo en una única variable. Los arrays tienen un tamaño fijo que se define al crearlos.

### ¿Por qué usar arrays?

Imagina que necesitas almacenar las direcciones IP de 100 servidores. Sin arrays, necesitarías:

```java
// Sin arrays (impracticable)
String servidor1 = "192.168.1.1";
String servidor2 = "192.168.1.2";
String servidor3 = "192.168.1.3";
// ... 97 variables más
```

Con arrays:

```java
// Con arrays (eficiente)
String[] servidores = new String[100];
servidores[0] = "192.168.1.1";
servidores[1] = "192.168.1.2";
// ...
```

### Declaración e inicialización de arrays

**Sintaxis básica:**

```java
// Declaración
TipoDato[] nombreArray;

// Inicialización
nombreArray = new TipoDato[tamaño];

// Declaración e inicialización en una línea
TipoDato[] nombreArray = new TipoDato[tamaño];
```

**Ejemplos:**

```java
// Array de enteros
int[] numeros = new int[5];

// Array de Strings
String[] nombres = new String[10];

// Array de doubles
double[] latencias = new double[50];

// Array de booleans
boolean[] estados = new boolean[20];
```

### Inicialización con valores

```java
// Forma 1: Inicialización después de la creación
int[] numeros = new int[5];
numeros[0] = 10;
numeros[1] = 20;
numeros[2] = 30;
numeros[3] = 40;
numeros[4] = 50;

// Forma 2: Inicialización directa (más común)
int[] numeros = {10, 20, 30, 40, 50};

// Forma 3: Con new y valores
int[] numeros = new int[] {10, 20, 30, 40, 50};
```

**Ejemplos prácticos:**

```java
// Puertos comunes
int[] puertosComunes = {21, 22, 23, 25, 80, 443, 3306, 8080};

// Servidores DNS
String[] servidoresDNS = {"8.8.8.8", "8.8.4.4", "1.1.1.1", "1.0.0.1"};

// Estados de servicios
boolean[] serviciosActivos = {true, true, false, true, false};

// Uso de CPU por hora
double[] usoCPU = {45.5, 67.2, 89.1, 34.8, 56.3};
```

### Acceso a elementos del array

Los arrays en Java se indexan desde 0. El primer elemento está en la posición 0, el segundo en la 1, y así sucesivamente.

```java
String[] servidores = {"web-01", "web-02", "db-01", "cache-01"};

// Acceder a elementos
System.out.println(servidores[0]);  // "web-01"
System.out.println(servidores[1]);  // "web-02"
System.out.println(servidores[3]);  // "cache-01"

// Modificar elementos
servidores[2] = "db-02";
System.out.println(servidores[2]);  // "db-02"

// Obtener la longitud del array
int cantidad = servidores.length;  // 4 (sin paréntesis)
System.out.println("Total de servidores: " + cantidad);
```

**⚠️ Importante:** Intentar acceder a un índice fuera de rango causa un error:

```java
int[] numeros = {10, 20, 30};
System.out.println(numeros[3]);  // ❌ ArrayIndexOutOfBoundsException
System.out.println(numeros[-1]); // ❌ ArrayIndexOutOfBoundsException
```

### Recorrer arrays con bucles

**Con bucle for tradicional:**

```java
String[] servicios = {"Apache", "MySQL", "SSH", "FTP"};

System.out.println("Servicios instalados:");
for (int i = 0; i < servicios.length; i++) {
    System.out.println((i + 1) + ". " + servicios[i]);
}

// Salida:
// Servicios instalados:
// 1. Apache
// 2. MySQL
// 3. SSH
// 4. FTP
```

**Con bucle for-each:**

```java
String[] servicios = {"Apache", "MySQL", "SSH", "FTP"};

System.out.println("Servicios instalados:");
for (String servicio : servicios) {
    System.out.println("- " + servicio);
}

// Salida:
// Servicios instalados:
// - Apache
// - MySQL
// - SSH
// - FTP
```

### Operaciones comunes con arrays

**1. Encontrar el valor máximo:**

```java
int[] usoCPU = {45, 67, 89, 34, 92, 56};

int maximo = usoCPU[0];
for (int i = 1; i < usoCPU.length; i++) {
    if (usoCPU[i] > maximo) {
        maximo = usoCPU[i];
    }
}

System.out.println("Uso máximo de CPU: " + maximo + "%");  // 92%
```

**2. Calcular el promedio:**

```java
int[] tiemposRespuesta = {120, 150, 98, 145, 130};

int suma = 0;
for (int tiempo : tiemposRespuesta) {
    suma += tiempo;
}

double promedio = (double) suma / tiemposRespuesta.length;
System.out.printf("Tiempo promedio de respuesta: %.2f ms%n", promedio);
```

**3. Contar elementos que cumplen una condición:**

```java
int[] puertos = {21, 80, 443, 22, 8080, 3306, 23, 25};

int puertosBajos = 0;
for (int puerto : puertos) {
    if (puerto < 1024) {
        puertosBajos++;
    }
}

System.out.println("Puertos del sistema (< 1024): " + puertosBajos);
```

**4. Buscar un elemento:**

```java
String[] usuarios = {"admin", "root", "user1", "guest", "operator"};
String buscar = "root";
boolean encontrado = false;
int posicion = -1;

for (int i = 0; i < usuarios.length; i++) {
    if (usuarios[i].equals(buscar)) {
        encontrado = true;
        posicion = i;
        break;
    }
}

if (encontrado) {
    System.out.println("Usuario '" + buscar + "' encontrado en posición " + posicion);
} else {
    System.out.println("Usuario no encontrado");
}
```

**5. Copiar un array:**

```java
int[] original = {10, 20, 30, 40, 50};

// Forma 1: Bucle manual
int[] copia1 = new int[original.length];
for (int i = 0; i < original.length; i++) {
    copia1[i] = original[i];
}

// Forma 2: System.arraycopy (más eficiente)
int[] copia2 = new int[original.length];
System.arraycopy(original, 0, copia2, 0, original.length);

// Forma 3: Arrays.copyOf (más simple)
int[] copia3 = java.util.Arrays.copyOf(original, original.length);
```

### Ejemplo práctico completo: Monitor de servidores

```java
public class MonitorServidores {
    public static void main(String[] args) {
        // Arrays paralelos (índices relacionados)
        String[] nombres = {"web-01", "web-02", "db-01", "cache-01", "backup-01"};
        int[] usoCPU = {45, 78, 92, 34, 12};
        int[] usoMemoria = {60, 85, 95, 40, 25};
        boolean[] activos = {true, true, false, true, true};

        System.out.println("=== ESTADO DE SERVIDORES ===\n");

        // Mostrar estado de cada servidor
        for (int i = 0; i < nombres.length; i++) {
            String estado = activos[i] ? "🟢 ACTIVO" : "🔴 INACTIVO";

            System.out.println("Servidor: " + nombres[i]);
            System.out.println("Estado: " + estado);

            if (activos[i]) {
                System.out.println("CPU: " + usoCPU[i] + "%");
                System.out.println("Memoria: " + usoMemoria[i] + "%");

                // Alertas
                if (usoCPU[i] > 90 || usoMemoria[i] > 90) {
                    System.out.println("⚠️  ALERTA: Recursos críticos");
                }
            }

            System.out.println();
        }

        // Estadísticas generales
        int servidoresActivos = 0;
        int sumaCPU = 0;
        int sumaMemoria = 0;

        for (int i = 0; i < nombres.length; i++) {
            if (activos[i]) {
                servidoresActivos++;
                sumaCPU += usoCPU[i];
                sumaMemoria += usoMemoria[i];
            }
        }

        System.out.println("=== RESUMEN ===");
        System.out.println("Total servidores: " + nombres.length);
        System.out.println("Activos: " + servidoresActivos);
        System.out.println("Inactivos: " + (nombres.length - servidoresActivos));

        if (servidoresActivos > 0) {
            double promedioCPU = (double) sumaCPU / servidoresActivos;
            double promedioMemoria = (double) sumaMemoria / servidoresActivos;

            System.out.printf("Promedio CPU: %.1f%%%n", promedioCPU);
            System.out.printf("Promedio Memoria: %.1f%%%n", promedioMemoria);
        }
    }
}
```

## 2. Arrays multidimensionales

Los arrays multidimensionales son arrays de arrays. El más común es el array bidimensional (matriz), que tiene filas y columnas.

### Arrays bidimensionales (matrices)

**Declaración e inicialización:**

```java
// Declaración
TipoDato[][] nombreArray;

// Inicialización con tamaño
int[][] matriz = new int[3][4];  // 3 filas, 4 columnas

// Inicialización con valores
int[][] matriz = {
    {10, 20, 30, 40},
    {50, 60, 70, 80},
    {90, 100, 110, 120}
};
```

**Visualización de una matriz:**

```
matriz[0][0]  matriz[0][1]  matriz[0][2]  matriz[0][3]
matriz[1][0]  matriz[1][1]  matriz[1][2]  matriz[1][3]
matriz[2][0]  matriz[2][1]  matriz[2][2]  matriz[2][3]
```

### Acceso a elementos

```java
int[][] numeros = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Acceder a elementos
System.out.println(numeros[0][0]);  // 1 (fila 0, columna 0)
System.out.println(numeros[1][2]);  // 6 (fila 1, columna 2)
System.out.println(numeros[2][1]);  // 8 (fila 2, columna 1)

// Modificar elementos
numeros[1][1] = 50;
System.out.println(numeros[1][1]);  // 50

// Obtener dimensiones
int filas = numeros.length;           // 3
int columnas = numeros[0].length;     // 3
```

### Recorrer matrices

**Con bucles for anidados:**

```java
int[][] matriz = {
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};

// Recorrer por filas
for (int fila = 0; fila < matriz.length; fila++) {
    for (int columna = 0; columna < matriz[fila].length; columna++) {
        System.out.print(matriz[fila][columna] + " ");
    }
    System.out.println();
}

// Salida:
// 10 20 30
// 40 50 60
// 70 80 90
```

**Con for-each anidado:**

```java
int[][] matriz = {
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};

for (int[] fila : matriz) {
    for (int elemento : fila) {
        System.out.print(elemento + " ");
    }
    System.out.println();
}
```

### Ejemplo práctico: Red de servidores (tabla de estado)

```java
public class RedServidores {
    public static void main(String[] args) {
        // Matriz: 4 servidores x 3 métricas (CPU, Memoria, Disco)
        int[][] metricas = {
            {45, 60, 70},  // web-01
            {78, 85, 65},  // web-02
            {92, 95, 88},  // db-01
            {34, 40, 45}   // cache-01
        };

        String[] servidores = {"web-01", "web-02", "db-01", "cache-01"};
        String[] tiposMetrica = {"CPU", "Memoria", "Disco"};

        System.out.println("=== ESTADO DE LA RED ===\n");

        // Mostrar tabla
        System.out.printf("%-12s", "Servidor");
        for (String tipo : tiposMetrica) {
            System.out.printf("%-12s", tipo);
        }
        System.out.println("\n" + "-".repeat(48));

        for (int i = 0; i < servidores.length; i++) {
            System.out.printf("%-12s", servidores[i]);

            for (int j = 0; j < metricas[i].length; j++) {
                System.out.printf("%-12s", metricas[i][j] + "%");
            }
            System.out.println();
        }

        // Calcular promedios por métrica
        System.out.println("\n=== PROMEDIOS POR MÉTRICA ===");

        for (int metrica = 0; metrica < tiposMetrica.length; metrica++) {
            int suma = 0;
            for (int servidor = 0; servidor < metricas.length; servidor++) {
                suma += metricas[servidor][metrica];
            }
            double promedio = (double) suma / metricas.length;
            System.out.printf("%s: %.1f%%%n", tiposMetrica[metrica], promedio);
        }

        // Identificar servidor más cargado
        System.out.println("\n=== ANÁLISIS ===");
        int maxCarga = 0;
        int servidorCritico = 0;

        for (int i = 0; i < metricas.length; i++) {
            int cargaTotal = 0;
            for (int j = 0; j < metricas[i].length; j++) {
                cargaTotal += metricas[i][j];
            }

            if (cargaTotal > maxCarga) {
                maxCarga = cargaTotal;
                servidorCritico = i;
            }
        }

        System.out.println("Servidor con mayor carga: " + servidores[servidorCritico]);
        System.out.printf("Carga total: %d%%%n", maxCarga);
    }
}
```

### Matrices irregulares (jagged arrays)

En Java, cada fila de una matriz puede tener diferente número de columnas:

```java
// Matriz irregular
int[][] irregular = {
    {1, 2, 3, 4},
    {5, 6},
    {7, 8, 9}
};

System.out.println("Fila 0: " + irregular[0].length + " elementos");  // 4
System.out.println("Fila 1: " + irregular[1].length + " elementos");  // 2
System.out.println("Fila 2: " + irregular[2].length + " elementos");  // 3

// Recorrer matriz irregular
for (int i = 0; i < irregular.length; i++) {
    System.out.print("Fila " + i + ": ");
    for (int j = 0; j < irregular[i].length; j++) {
        System.out.print(irregular[i][j] + " ");
    }
    System.out.println();
}
```

### Arrays de más de dos dimensiones

```java
// Array 3D: [capas][filas][columnas]
int[][][] cubo = new int[3][3][3];

// Ejemplo: Logs por día, hora y servidor
String[][][] logs = {
    // Día 1
    {
        {"Server1-00:00", "Server2-00:00"},  // Hora 0
        {"Server1-01:00", "Server2-01:00"}   // Hora 1
    },
    // Día 2
    {
        {"Server1-00:00", "Server2-00:00"},
        {"Server1-01:00", "Server2-01:00"}
    }
};

// Acceso: logs[dia][hora][servidor]
System.out.println(logs[0][1][0]);  // "Server1-01:00" del día 1
```

## 3. Operaciones básicas con arrays

### Clase Arrays (java.util.Arrays)

Java proporciona la clase `Arrays` con métodos útiles para trabajar con arrays.

**Importar la clase:**

```java
import java.util.Arrays;
```

### 1. Ordenar arrays

```java
import java.util.Arrays;

// Ordenar números
int[] numeros = {45, 12, 67, 23, 89, 34};
Arrays.sort(numeros);
System.out.println(Arrays.toString(numeros));
// [12, 23, 34, 45, 67, 89]

// Ordenar strings (orden alfabético)
String[] nombres = {"Carlos", "Ana", "Beatriz", "David"};
Arrays.sort(nombres);
System.out.println(Arrays.toString(nombres));
// [Ana, Beatriz, Carlos, David]
```

**Ordenar en orden descendente:**

```java
import java.util.Arrays;
import java.util.Collections;

Integer[] numeros = {45, 12, 67, 23, 89, 34};
Arrays.sort(numeros, Collections.reverseOrder());
System.out.println(Arrays.toString(numeros));
// [89, 67, 45, 34, 23, 12]
```

### 2. Buscar elementos (búsqueda binaria)

```java
import java.util.Arrays;

int[] numeros = {10, 20, 30, 40, 50, 60, 70};
// ⚠️ El array DEBE estar ordenado para usar binarySearch

int indice = Arrays.binarySearch(numeros, 40);
System.out.println("Elemento 40 encontrado en índice: " + indice);  // 3

int indice2 = Arrays.binarySearch(numeros, 25);
System.out.println("Elemento 25: " + indice2);  // Negativo si no existe
```

### 3. Comparar arrays

```java
import java.util.Arrays;

int[] array1 = {1, 2, 3, 4, 5};
int[] array2 = {1, 2, 3, 4, 5};
int[] array3 = {1, 2, 3, 4, 6};

boolean iguales1 = Arrays.equals(array1, array2);
System.out.println("array1 == array2: " + iguales1);  // true

boolean iguales2 = Arrays.equals(array1, array3);
System.out.println("array1 == array3: " + iguales2);  // false
```

### 4. Llenar arrays

```java
import java.util.Arrays;

int[] numeros = new int[5];
Arrays.fill(numeros, 10);
System.out.println(Arrays.toString(numeros));
// [10, 10, 10, 10, 10]

// Llenar un rango específico
int[] array = new int[10];
Arrays.fill(array, 2, 7, 99);  // Desde índice 2 hasta 6
System.out.println(Arrays.toString(array));
// [0, 0, 99, 99, 99, 99, 99, 0, 0, 0]
```

### 5. Convertir array a String

```java
import java.util.Arrays;

int[] numeros = {10, 20, 30, 40, 50};
String texto = Arrays.toString(numeros);
System.out.println(texto);
// [10, 20, 30, 40, 50]

// Para matrices
int[][] matriz = {{1, 2}, {3, 4}, {5, 6}};
System.out.println(Arrays.deepToString(matriz));
// [[1, 2], [3, 4], [5, 6]]
```

### Ejemplo práctico: Gestión de puertos

```java
import java.util.Arrays;

public class GestionPuertos {
    public static void main(String[] args) {
        int[] puertosEscaneados = {8080, 22, 443, 21, 80, 3306, 25, 23};

        System.out.println("=== GESTIÓN DE PUERTOS ===\n");

        // Mostrar puertos originales
        System.out.println("Puertos escaneados:");
        System.out.println(Arrays.toString(puertosEscaneados));

        // Ordenar puertos
        Arrays.sort(puertosEscaneados);
        System.out.println("\nPuertos ordenados:");
        System.out.println(Arrays.toString(puertosEscaneados));

        // Buscar puerto específico
        int buscar = 443;
        int indice = Arrays.binarySearch(puertosEscaneados, buscar);

        if (indice >= 0) {
            System.out.println("\nPuerto " + buscar + " encontrado en posición " + indice);
        } else {
            System.out.println("\nPuerto " + buscar + " no encontrado");
        }

        // Clasificar puertos
        System.out.println("\n--- CLASIFICACIÓN ---");
        for (int puerto : puertosEscaneados) {
            System.out.print("Puerto " + puerto + ": ");

            if (puerto < 1024) {
                System.out.println("Sistema/Conocido");
            } else if (puerto < 49152) {
                System.out.println("Registrado");
            } else {
                System.out.println("Dinámico/Privado");
            }
        }

        // Contar por tipo
        int sistema = 0, registrado = 0, dinamico = 0;

        for (int puerto : puertosEscaneados) {
            if (puerto < 1024) sistema++;
            else if (puerto < 49152) registrado++;
            else dinamico++;
        }

        System.out.println("\n--- RESUMEN ---");
        System.out.println("Puertos del sistema: " + sistema);
        System.out.println("Puertos registrados: " + registrado);
        System.out.println("Puertos dinámicos: " + dinamico);
    }
}
```

## 4. Introducción a las colecciones

Los arrays tienen limitaciones: tamaño fijo, operaciones manuales para insertar/eliminar. Las **colecciones** (Collections Framework) resuelven estos problemas.

### ¿Qué son las colecciones?

Las colecciones son estructuras de datos dinámicas que pueden crecer o reducirse según sea necesario. Java proporciona varias implementaciones optimizadas para diferentes casos de uso.

### Ventajas sobre los arrays

|Aspecto     |Arrays              |Colecciones          |
|------------|--------------------|---------------------|
|Tamaño      |Fijo                |Dinámico             |
|Tipos       |Primitivos y objetos|Solo objetos         |
|Métodos     |Básicos             |Muchos métodos útiles|
|Rendimiento |Muy rápido          |Ligeramente más lento|
|Flexibilidad|Limitada            |Alta                 |

### Jerarquía de colecciones (simplificada)

```
Collection (interfaz)
├── List (interfaz)
│   ├── ArrayList
│   └── LinkedList
├── Set (interfaz)
│   ├── HashSet
│   └── TreeSet
└── Queue (interfaz)
    └── LinkedList

Map (interfaz, no extiende Collection)
├── HashMap
└── TreeMap
```

### Principales interfaces y clases

**List:** Colección ordenada que permite duplicados

- `ArrayList`: Array dinámico, acceso rápido por índice
- `LinkedList`: Lista enlazada, inserciones/eliminaciones rápidas

**Set:** Colección sin duplicados

- `HashSet`: Sin orden específico, muy rápido
- `TreeSet`: Ordenado automáticamente

**Map:** Pares clave-valor

- `HashMap`: Sin orden, acceso muy rápido por clave
- `TreeMap`: Ordenado por clave

### Importar colecciones

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
// O importar todo el paquete
import java.util.*;
```

## 5. ArrayList y LinkedList

### ArrayList

`ArrayList` es una implementación de lista basada en arrays dinámicos. Es la colección más utilizada.

**Características:**

- Tamaño dinámico (crece automáticamente)
- Acceso rápido por índice (O(1))
- Inserción/eliminación lenta en medio (O(n))
- Permite elementos duplicados
- Mantiene el orden de inserción

**Declaración:**

```java
import java.util.ArrayList;

// ArrayList de Strings
ArrayList<String> lista = new ArrayList<>();

// ArrayList de Integers (no int, debe ser clase wrapper)
ArrayList<Integer> numeros = new ArrayList<>();

// ArrayList con capacidad inicial
ArrayList<String> listaGrande = new ArrayList<>(1000);
```

**⚠️ Importante:** ArrayList no puede almacenar tipos primitivos directamente, usa las clases wrapper:

- `int` → `Integer`
- `double` → `Double`
- `boolean` → `Boolean`
- `char` → `Character`

### Operaciones básicas con ArrayList

```java
import java.util.ArrayList;

ArrayList<String> servidores = new ArrayList<>();

// 1. Agregar elementos
servidores.add("web-01");
servidores.add("web-02");
servidores.add("db-01");
System.out.println(servidores);  // [web-01, web-02, db-01]

// 2. Agregar en posición específica
servidores.add(1, "cache-01");
System.out.println(servidores);  // [web-01, cache-01, web-02, db-01]

// 3. Obtener elemento
String primero = servidores.get(0);
System.out.println("Primer servidor: " + primero);  // web-01

// 4. Modificar elemento
servidores.set(2, "web-03");
System.out.println(servidores);  // [web-01, cache-01, web-03, db-01]

// 5. Eliminar elemento por índice
servidores.remove(1);
System.out.println(servidores);  // [web-01, web-03, db-01]

// 6. Eliminar elemento por valor
servidores.remove("web-03");
System.out.println(servidores);  // [web-01, db-01]

// 7. Tamaño de la lista
int cantidad = servidores.size();
System.out.println("Cantidad: " + cantidad);  // 2

// 8. Verificar si está vacía
boolean vacia = servidores.isEmpty();
System.out.println("¿Vacía?: " + vacia);  // false

// 9. Verificar si contiene un elemento
boolean contiene = servidores.contains("web-01");
System.out.println("¿Contiene web-01?: " + contiene);  // true

// 10. Limpiar toda la lista
servidores.clear();
System.out.println(servidores);  // []
```

### Recorrer ArrayList

```java
ArrayList<String> servicios = new ArrayList<>();
servicios.add("Apache");
servicios.add("MySQL");
servicios.add("SSH");
servicios.add("FTP");

// Forma 1: For tradicional con índice
for (int i = 0; i < servicios.size(); i++) {
    System.out.println((i + 1) + ". " + servicios.get(i));
}

// Forma 2: For-each (más común)
for (String servicio : servicios) {
    System.out.println("- " + servicio);
}

// Forma 3: forEach con lambda (Java 8+)
servicios.forEach(servicio -> System.out.println("→ " + servicio));
```

### Ejemplo práctico: Sistema de gestión de IPs

```java
import java.util.ArrayList;
import java.util.Scanner;

public class GestionIPs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in
```
