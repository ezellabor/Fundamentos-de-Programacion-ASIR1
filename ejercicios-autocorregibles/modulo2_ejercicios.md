# Módulo 2: Fundamentos del lenguaje Java
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## Conceptos clave

- Variables y constantes (tipos de datos primitivos)
- Operadores (aritméticos, relacionales, lógicos)
- Nomenclatura y convenciones (camelCase, PascalCase)
- Conversión de tipos (casting)
- Expresiones y precedencia de operadores

---

### Ejercicio 1 - Nivel 1
**¿Cuál es la palabra clave correcta para declarar una constante en Java?**

a) const  
b) final  
c) constant  
d) static  

<details>
<summary>💡 Pista</summary>
En Java, la palabra clave que impide que una variable cambie su valor es 'final'.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) final**

En Java, `final` se usa para declarar constantes. Por ejemplo:
```java
final int PUERTO_SSH = 22;
```
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué tipo de dato primitivo usarías para almacenar la dirección IP de un servidor (como número entero)?**

a) byte  
b) short  
c) int  
d) long  

<details>
<summary>💡 Pista</summary>
Una IP como número entero (ej: 3232235777 para 192.168.1.1) necesita un tipo que soporte valores grandes.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**d) long**

Las direcciones IP convertidas a números pueden ser muy grandes, por lo que `long` es la mejor opción.
</details>

---

### Ejercicio 3 - Nivel 2
**¿Cuál es el resultado de la siguiente expresión: `10 / 3` en Java?**

a) 3.333333  
b) 3  
c) 3.0  
d) Error de compilación  

<details>
<summary>💡 Pista</summary>
La división entre dos enteros en Java produce un resultado entero (se trunca la parte decimal).
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) 3**

En Java, la división entre dos enteros (`int / int`) produce un resultado entero, descartando la parte decimal.
</details>

---

### Ejercicio 4 - Nivel 2
**Según las convenciones de Java, ¿cuál es el nombre correcto para una variable que almacena el número de servidores activos?**

a) NumeroServidoresActivos  
b) numeroservidoresactivos  
c) numeroServidoresActivos  
d) NUMERO_SERVIDORES_ACTIVOS  

<details>
<summary>💡 Pista</summary>
Las variables en Java usan camelCase (primera palabra minúscula, siguientes palabras con mayúscula inicial).
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**c) numeroServidoresActivos**

Las variables siguen la convención camelCase en Java.
</details>

---

### Ejercicio 5 - Nivel 2
**¿Qué operador usarías para verificar si dos direcciones IP son diferentes?**

a) ==  
b) !=  
c) <>  
d) .equals()  

<details>
<summary>💡 Pista</summary>
El operador '!=' significa 'no igual' o 'diferente de'.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) !=**

El operador `!=` verifica si dos valores son diferentes.
</details>

---

### Ejercicio 6 - Nivel 3
**Completa el código para declarar una constante que almacene el puerto SSH por defecto:**  

```java
_______ int PUERTO_SSH = 22;

```  

<details>
<summary>💡 Pista</summary>
Las constantes en Java se declaran con 'final' y por convención se nombran en MAYÚSCULAS_CON_GUION_BAJO.
</details>

<details>
<summary>✅ Respuesta correcta</summary>  

```java  
final int PUERTO_SSH = 22;  
```

</details>  

---

### Ejercicio 7 - Nivel 3
**¿Cuál es el resultado de la siguiente expresión?**

```java
int resultado = 15 % 4;
```  

*(El operador % es el operador módulo - resto de la división)*  

<details>
<summary>💡 Pista</summary>
El operador % devuelve el resto de dividir 15 entre 4. ¿Cuánto sobra?
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**3**

15 dividido entre 4 da 3 con resto 3. El operador `%` devuelve el resto.
</details>

---

### Ejercicio 8 - Nivel 3
**Corrige la siguiente declaración de variable para que siga las convenciones de Java:**  

```java
int TiempoEsperaSegundos = 30;
```  

<details>
<summary>💡 Pista</summary>
Las variables en Java deben empezar con minúscula y usar camelCase.
</details>

<details>
<summary>✅ Respuesta correcta</summary>  
    
```java  
int tiempoEsperaSegundos = 30;  
```  

</details>

---

### Ejercicio 9 - Nivel 4
**Escribe el código para declarar tres variables que almacenen:**  
1. Un puerto (tipo int) con valor 8080
2. Una IP (tipo String) con valor "192.168.1.100"
3. Un servidor activo (tipo boolean) con valor true

<details>
<summary>💡 Pista</summary>
Recuerda: tipo nombreVariable = valor; Los nombres deben seguir camelCase.
</details>

<details>
<summary>✅ Respuesta correcta</summary>  
```java  
int puerto = 8080;  
String ip = "192.168.1.100";  
boolean servidorActivo = true;  
```  
</details>

---

### Ejercicio 10 - Nivel 4  
**Escribe un programa completo que calcule el ancho de banda disponible:**  
- Ancho de banda total: 1000 Mbps (constante)
- Ancho usado: 350 Mbps
- Calcula y muestra el ancho disponible  

<details>
<summary>💡 Pista</summary>
Necesitas: clase, método main, constante final para el total, variable para usado, cálculo y System.out.println().
</details>

<details>
<summary>✅ Respuesta correcta</summary> 
    
```java
public class AnchoBanda {
    public static void main(String[] args) {
        final int ANCHO_TOTAL = 1000;
        int anchoUsado = 350;
        int anchoDisponible = ANCHO_TOTAL - anchoUsado;
        System.out.println("Ancho de banda disponible: " + anchoDisponible + " Mbps");
    }
}  
```  
</details>  

---

## Puntuación

- **10 ejercicios totales**
- **Niveles:** 1 (básico) a 4 (avanzado)
- **Tipos:** Opción múltiple, completar código, escribir programas

---

**💡 Recuerda:** La práctica constante es el secreto del aprendizaje.
