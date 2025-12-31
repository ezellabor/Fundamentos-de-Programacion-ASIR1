# Módulo 3: Estructuras de Control
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## Conceptos Clave

- Condicionales: if, else, else if
- Switch-case para múltiples opciones
- Bucles: for, while, do-while
- Break y continue
- Operador ternario

---


### Ejercicio 1 - Nivel 1
**¿Cuál es la estructura correcta de un condicional if en Java?**

a) if (condicion) { }  
b) if condicion { }  
c) if [condicion] { }  
d) if {condicion} ( )  

<details>
<summary>💡 Pista</summary>
En Java, las condiciones van entre paréntesis ( ) y el código entre llaves { }.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**a) if (condicion) { }**

La sintaxis correcta es: `if (condición) { código }`
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué bucle usarías cuando NO sabes cuántas veces debe ejecutarse el código?**

a) for  
b) while  
c) switch  
d) if-else  

<details>
<summary>💡 Pista</summary>
El bucle 'while' se ejecuta mientras una condición sea verdadera, sin necesidad de saber cuántas iteraciones.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) while**

El bucle `while` es ideal cuando no sabes de antemano cuántas iteraciones necesitas.
</details>

---

### Ejercicio 3 - Nivel 2
**¿Cuál es la diferencia principal entre while y do-while?**

a) No hay diferencia  
b) do-while siempre se ejecuta al menos una vez  
c) while es más rápido  
d) do-while no existe en Java  

<details>
<summary>💡 Pista</summary>
En do-while, el código se ejecuta primero y DESPUÉS se verifica la condición.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) do-while siempre se ejecuta al menos una vez**

`do-while` ejecuta el código primero, luego verifica la condición.
</details>

---

### Ejercicio 4 - Nivel 2
**¿Qué palabra clave se usa para salir completamente de un bucle?**

a) continue  
b) break  
c) exit  
d) stop  

<details>
<summary>💡 Pista</summary>
'break' rompe/sale del bucle inmediatamente. 'continue' solo salta a la siguiente iteración.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) break**

`break` sale completamente del bucle.
</details>

---

### Ejercicio 5 - Nivel 2
**En un switch, ¿qué palabra clave evita que el código continúe ejecutándose en los siguientes casos?**

a) stop  
b) break  
c) continue  
d) default  

<details>
<summary>💡 Pista</summary>
Sin 'break' en switch, el código 'cae' y ejecuta los casos siguientes (fall-through).
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) break**

Sin `break`, el código continúa ejecutando los casos siguientes.
</details>

---

### Ejercicio 6 - Nivel 3
**Completa el bucle for para iterar del 1 al 10:

```java
for (int i = 1; i ____ 10; i++) {
    System.out.println(i);
}
```**

<details>
<summary>💡 Pista</summary>
Necesitas un operador que sea verdadero mientras i sea menor o igual a 10.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**<=**

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```
</details>

---

### Ejercicio 7 - Nivel 3
**¿Cuántas veces se imprime "Hola" en este código?

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Hola");
}
```**

<details>
<summary>💡 Pista</summary>
El bucle empieza en 0 y va hasta que i sea 5 (pero no incluye 5). Cuenta: 0, 1, 2, 3, 4.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**5 veces**

El bucle itera con i = 0, 1, 2, 3, 4 (5 valores).
</details>

---

### Ejercicio 8 - Nivel 3
**Escribe un if-else que verifique si un servidor está activo (puerto 80 abierto):
Si puerto == 80, imprime "Servidor activo", sino "Servidor inactivo"**

<details>
<summary>💡 Pista</summary>
Usa if (puerto == 80) para comparar. System.out.println() para imprimir.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
if (puerto == 80) {
    System.out.println("Servidor activo");
} else {
    System.out.println("Servidor inactivo");
}
```
</details>

---

### Ejercicio 9 - Nivel 4
**Escribe un switch-case que clasifique el estado de un servidor según su código:
- Código 200: "OK"
- Código 404: "No encontrado"
- Código 500: "Error del servidor"
- Otro: "Código desconocido"**

<details>
<summary>💡 Pista</summary>
Usa switch(codigo), varios case, break después de cada uno, y default para el resto.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
switch (codigo) {
    case 200:
        System.out.println("OK");
        break;
    case 404:
        System.out.println("No encontrado");
        break;
    case 500:
        System.out.println("Error del servidor");
        break;
    default:
        System.out.println("Código desconocido");
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Escribe un programa que verifique los primeros 10 puertos (del 1 al 10) y muestre solo los pares:
Usa un for y un if para verificar si el puerto es par (% 2 == 0)**

<details>
<summary>💡 Pista</summary>
Necesitas: clase, main, for (i=1; i<=10), if (i % 2 == 0), println.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class PuertosPares {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Puerto: " + i);
            }
        }
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
