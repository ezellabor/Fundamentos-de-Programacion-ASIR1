# Módulo 4: Arrays y Colecciones
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## Conceptos clave

- Arrays unidimensionales y multidimensionales
- Declaración e inicialización
- ArrayList y operaciones
- Recorrido con for y for-each
- Búsqueda y ordenamiento básico

---



### 1 - ¿Cómo se declara correctamente un array de enteros de tamaño 5?

a) int[] numeros = new int[5];  
b) int[5] numeros = new int;  
c) array int numeros[5];  
d) int numeros = new array[5];  
<!--
<details>
<summary>💡 Pista</summary>
En Java, los arrays se declaran con tipo[] nombre = new tipo[tamaño].
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**a) int[] numeros = new int[5];**
</details>
-->
---

### 2 - ¿Cuál es el índice del primer elemento de un array?

a) 1  
b) 0  
c) -1  
d) Depende del tamaño  
<!--
<details>
<summary>💡 Pista</summary>
Los arrays en Java (y la mayoría de lenguajes) empiezan en índice 0.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) 0**
</details>
-->
---

### 3 - ¿Qué excepción se lanza al intentar acceder a un índice fuera del rango del array?

a) IndexOutOfBoundsException  
b) ArrayIndexOutOfBoundsException  
c) OutOfRangeException  
d) ArrayException  
<!--
<details>
<summary>💡 Pista</summary>
La excepción específica para arrays incluye 'Array' en su nombre.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) ArrayIndexOutOfBoundsException**
</details>
-->
---

###  4 - ¿Cómo obtienes el tamaño/longitud de un array llamado 'servidores'?

a) servidores.size()  
b) servidores.length  
c) servidores.length()  
d) size(servidores)  
<!--
<details>
<summary>💡 Pista</summary>
Para arrays es un atributo (length), para ArrayList es un método (size()).
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) servidores.length**
</details>
-->
---

### 5 - ¿Cuál es la ventaja principal de ArrayList sobre arrays normales?

a) Es más rápido  
b) Tiene tamaño dinámico  
c) Usa menos memoria  
d) Es más simple  
<!--
<details>
<summary>💡 Pista</summary>
Los arrays tienen tamaño fijo, pero ArrayList puede crecer automáticamente.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Tiene tamaño dinámico**
</details>
-->
---

### 6 - Completa el código para inicializar un array con los puertos HTTP comunes:

```java
int[] puertos =  /* 80, 443, 8080, 8443 */
```

<!--
{80, 443, ____, 8443};
```  

<details>
<summary>💡 Pista</summary>
El puerto HTTP alternativo más común es 8080.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**8080**

```java
int[] puertos = {80, 443, 8080, 8443};
```
</details>
-->
---

### 7 - ¿Cuál es el último índice válido de un array de tamaño 10?  
<!--
<details>
<summary>💡 Pista</summary>
Si empieza en 0 y tiene 10 elementos... el último índice es tamaño - 1.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**9**

Los índices van de 0 a 9 (10 elementos en total).
</details>
-->
---

### 8 - Escribe un for-each para recorrer un array de IPs llamado ```ips```.  

<!--

<details>
<summary>💡 Pista</summary>
Sintaxis: for (String ip : ips) { ... }
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
for (String ip : ips) {
    System.out.println(ip);
}
```
</details>
-->
---

<!-- 

### 9 - Nivel 4
**Escribe código para crear un ArrayList de String, agregar 3 servidores y mostrar su tamaño:
Servidores: "web01", "web02", "web03"**

<details>
<summary>💡 Pista</summary>
ArrayList<String> lista = new ArrayList<>(); luego .add() y .size().
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
ArrayList<String> servidores = new ArrayList<>();
servidores.add("web01");
servidores.add("web02");
servidores.add("web03");
System.out.println("Total: " + servidores.size());
```
</details>
-->
---

### 10 - Escribe un programa que declare un array de 5 puertos, los inicialice y muestre todos. Puertos: 21, 22, 80, 443, 3306
<!--
<details>
<summary>💡 Pista</summary>
Usa inicialización directa con {} y un for-each para mostrar.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class Puertos {
    public static void main(String[] args) {
        int[] puertos = {21, 22, 80, 443, 3306};
        for (int puerto : puertos) {
            System.out.println("Puerto: " + puerto);
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

**💡 Recuerda:** La práctica constante es el secreto del aprendizaje.-->
