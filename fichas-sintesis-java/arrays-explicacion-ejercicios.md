![Módulo](https://img.shields.io/badge/Módulo-Fundamentos_de_Programación_(Java)-orange?style=for-the-badge)
![Grupo](https://img.shields.io/badge/Grupo-ASIR1-blue?style=for-the-badge)
![Profesor](https://img.shields.io/badge/Profesor-Ezequiel_Llarena_Borges-blue?style=for-the-badge)

## Arrays

---

## Objetivos

1. Comprender qué es un array y para qué sirve
2. Declarar, inicializar y acceder a elementos de un array
3. Recorrer arrays con bucles `for`
4. Aplicar arrays a contextos reales de ASIR (redes, sistemas, hardware)
5. Realizar operaciones básicas: búsqueda, máximo/mínimo, conteo

---

## 1. Declaración y acceso básico

### ¿Qué es un Array?  

Un array es como un rack de servidores:
- tiene un número fijo de ranuras
- cada una tiene un número (índice)
- solo puedes guardar un tipo de cosa en cada ranura
- Si intentas acceder a una ranura que no existe, el rack te da error.

![array-analogia-rack](fichas-sintesis-java/array-analogia-rack.png)  


```java
public class ArrayComoRack {
    public static void main(String[] args) {
        
        // El rack tiene 5 ranuras para servidores
        int[] rackServidores = {80, 443, 22, 21, 3389};
        
        // ¿Cuántas ranuras tiene el rack?
        System.out.println("Ranuras totales: " + rackServidores.length);
        
        // Acceder a una ranura específica
        System.out.println("Ranura 0 (HTTP): " + rackServidores[0]);
        System.out.println("Ranura 1 (HTTPS): " + rackServidores[1]);
        
        // Intentar acceder a una ranura que NO existe → ERROR
        // System.out.println(rackServidores[5]); // ❌ ArrayIndexOutOfBoundsException!
        
        // Recorrer todas las ranuras del rack
        System.out.println("\n=== INVENTARIO DEL RACK ===");
        for (int ranura = 0; ranura < rackServidores.length; ranura++) {
            System.out.println("Ranura " + ranura + ": Puerto " + rackServidores[ranura]);
        }
    }
}
``` 

### Otro ejemplo:

```java
public class Ejemplo1_ArrayBasico {
    public static void main(String[] args) {
        
        // Declaración e inicialización de un array de puertos
        int[] puertos = {80, 443, 22, 21, 3389};
        
        // Acceder a elementos individuales (índice empieza en 0)
        System.out.println("Puerto HTTP: " + puertos[0]);      // 80
        System.out.println("Puerto HTTPS: " + puertos[1]);     // 443
        System.out.println("Puerto SSH: " + puertos[2]);       // 22
        
        // Saber cuántos elementos tiene el array
        System.out.println("Total de puertos: " + puertos.length);
        
        // Modificar un valor
        puertos[3] = 25;  // Cambiamos FTP (21) por SMTP (25)
        System.out.println("Nuevo puerto 4: " + puertos[3]);
    }
}
