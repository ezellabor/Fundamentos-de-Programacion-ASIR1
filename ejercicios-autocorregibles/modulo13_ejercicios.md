# Módulo 13: Programación funcional
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## 📚 Conceptos Clave

- Interfaces funcionales
- Expresiones lambda
- Method references
- Optional
- Stream API básico

---

## 📝 Ejercicios

### Ejercicio 1 - Nivel 1
**¿Qué es una expresión lambda?**

a) Un método normal  
b) Una función anónima  
c) Una clase abstracta  
d) Un operador  

<details>
<summary>💡 Pista</summary>
Lambda es una función anónima.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Una función anónima**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Cuál es la sintaxis básica de una lambda sin parámetros?**

a) () => { }  
b) () -> { }  
c) lambda { }  
d) function() { }  

<details>
<summary>💡 Pista</summary>
() -> { } es la sintaxis lambda.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) () -> { }**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Qué es una interfaz funcional?**

a) Interfaz con múltiples métodos  
b) Interfaz con un solo método abstracto  
c) Interfaz sin métodos  
d) Interfaz final  

<details>
<summary>💡 Pista</summary>
Tiene exactamente un método abstracto.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Interfaz con un solo método abstracto**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Para qué sirve Optional?**

a) Optimizar código  
b) Evitar NullPointerException  
c) Ordenar colecciones  
d) Crear threads  

<details>
<summary>💡 Pista</summary>
Optional envuelve valores que pueden ser null.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Evitar NullPointerException**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Qué hace stream() en una colección?**

a) Ordena elementos  
b) Crea un flujo para operaciones funcionales  
c) Elimina duplicados  
d) Suma elementos  

<details>
<summary>💡 Pista</summary>
stream() crea un flujo de datos para procesamiento.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Crea un flujo para operaciones funcionales**
</details>

---

### Ejercicio 6 - Nivel 3
**Completa: `List<String> lista; lista.forEach(____)`**

<details>
<summary>💡 Pista</summary>
s -> System.out.println(s)
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
lista.forEach(s -> System.out.println(s));
```
</details>

---

### Ejercicio 7 - Nivel 3
**Escribe una lambda que sume dos números:**

<details>
<summary>💡 Pista</summary>
(a, b) -> a + b
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
(a, b) -> a + b
```
</details>

---

### Ejercicio 8 - Nivel 3
**¿Cómo filtras elementos pares de un stream de enteros?**

<details>
<summary>💡 Pista</summary>
.filter(n -> n % 2 == 0)
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
.filter(n -> n % 2 == 0)
```
</details>

---

### Ejercicio 9 - Nivel 4
**Crea una lambda que verifique si un número es mayor que 10:**

<details>
<summary>💡 Pista</summary>
n -> n > 10
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
n -> n > 10
```

Puede usarse en: `lista.stream().filter(n -> n > 10)`
</details>

---

### Ejercicio 10 - Nivel 4
**Usa stream para obtener la suma de una lista de enteros:**

<details>
<summary>💡 Pista</summary>
lista.stream().mapToInt(Integer::intValue).sum()
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
int suma = numeros.stream()
                  .mapToInt(Integer::intValue)
                  .sum();
System.out.println("Suma: " + suma);
```
</details>

---

## 🎯 Puntuación

- **10 ejercicios totales**
- **Niveles:** 1 (básico) a 4 (avanzado)
- **Tipos:** Opción múltiple, completar código, escribir programas

---

**💡 Recuerda:** La práctica constante es el secreto del aprendizaje.
