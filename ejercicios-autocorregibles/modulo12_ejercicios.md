# Módulo 12: Framework de Colecciones
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## 📚 Conceptos Clave

- List, Set, Map, Queue
- ArrayList, LinkedList, HashSet, TreeSet
- HashMap, TreeMap
- Iteración avanzada
- Comparator y Collections

---

## 📝 Ejercicios

### Ejercicio 1 - Nivel 1
**¿Qué interfaz representa una lista ordenada que permite duplicados?**

a) Set  
b) List  
c) Map  
d) Queue  

<details>
<summary>💡 Pista</summary>
List permite elementos duplicados y mantiene el orden.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) List**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué interfaz NO permite elementos duplicados?**

a) List  
b) Set  
c) Map  
d) Queue  

<details>
<summary>💡 Pista</summary>
Set no permite duplicados.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Set**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Cuál es la diferencia entre ArrayList y LinkedList?**

a) No hay diferencia  
b) ArrayList usa array, LinkedList usa nodos enlazados  
c) LinkedList es más rápido siempre  
d) ArrayList no permite duplicados  

<details>
<summary>💡 Pista</summary>
ArrayList usa array interno, LinkedList usa nodos.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) ArrayList usa array, LinkedList usa nodos enlazados**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Qué estructura guarda pares clave-valor?**

a) List  
b) Set  
c) Map  
d) Queue  

<details>
<summary>💡 Pista</summary>
Map almacena pares clave-valor.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**c) Map**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Qué método obtiene un valor de un HashMap con una clave?**

a) getValue()  
b) get()  
c) find()  
d) retrieve()  

<details>
<summary>💡 Pista</summary>
get(clave) obtiene el valor asociado.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) get()**
</details>

---

### Ejercicio 6 - Nivel 3
**Declara un ArrayList de enteros:**

<details>
<summary>💡 Pista</summary>
ArrayList<Integer> lista = new ArrayList<>();
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
ArrayList<Integer> numeros = new ArrayList<>();
```
</details>

---

### Ejercicio 7 - Nivel 3
**¿Cómo añades un elemento a un HashSet?**

<details>
<summary>💡 Pista</summary>
set.add(elemento);
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
set.add(elemento);
```
</details>

---

### Ejercicio 8 - Nivel 3
**Escribe un bucle for-each para recorrer una List<String>:**

<details>
<summary>💡 Pista</summary>
for (String s : lista) { }
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
for (String elemento : lista) {
    System.out.println(elemento);
}
```
</details>

---

### Ejercicio 9 - Nivel 4
**Crea un HashMap que asocie puertos (int) con servicios (String):**

<details>
<summary>💡 Pista</summary>
HashMap<Integer, String> puertos = new HashMap<>();
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
HashMap<Integer, String> puertos = new HashMap<>();
puertos.put(80, "HTTP");
puertos.put(443, "HTTPS");
puertos.put(22, "SSH");
```
</details>

---

### Ejercicio 10 - Nivel 4
**Programa que ordene una lista de números con Collections.sort():**

<details>
<summary>💡 Pista</summary>
List con números, luego Collections.sort(lista).
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
import java.util.*;

public class OrdenarLista {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(2);
        numeros.add(8);
        numeros.add(1);
        
        Collections.sort(numeros);
        System.out.println(numeros);
    }
}
```
</details>

---

## 🎯 Puntuación

- **10 ejercicios totales**
- **Niveles:** 1 (básico) a 4 (avanzado)
- **Tipos:** Opción múltiple, completar código, escribir programas

---

**💡 Recuerda:** La práctica constante es el secreto del aprendizaje.
