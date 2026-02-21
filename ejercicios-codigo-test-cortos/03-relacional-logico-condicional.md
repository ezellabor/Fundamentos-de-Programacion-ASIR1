![Módulo](https://img.shields.io/badge/Módulo-Fundamentos_de_Programación-brown?style=for-the-badge)
![Lenguaje](https://img.shields.io/badge/Lenguaje-Java-brown?style=for-the-badge)
![Grupo](https://img.shields.io/badge/Grupo-ASIR1V-blue?style=for-the-badge)
![Profesor](https://img.shields.io/badge/Profesor-Ezequiel_Llarena_Borges-blue?style=for-the-badge)  

##  Operaciones Relacionales, Lógicas y Condicionales


### 1️⃣ Análisis de código  
*Analiza el siguiente código y determina qué mostrará por pantalla.*  

#### Ejercicio 1
```java
int x = 5;
int y = ++x * 2;
System.out.println(y);
```
  
#### Ejercicio 2
```java  
boolean a = true;
boolean b = false;
boolean c = a && b || !b;
System.out.println(c);
```

#### Ejercicio 3
```java
int num = 10;
String resultado = (num % 2 == 0) ? "Par" : "Impar";
System.out.println(resultado);
```

#### Ejercicio 4  
```java
int i = 3;
int j = i-- + --i;
System.out.println(j);
```

#### Ejercicio 5
```java
int a = 7;
int b = 3;
System.out.println(a > b && a++ < b || b++ == 3);
System.out.println("a = " + a + ", b = " + b);
```
---  

### 2️⃣ Completar código  
*Completa la instrucción o el bloque de código faltante.*  

#### Ejercicio 1 (par o impar)
```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
int n = sc.nextInt();

if (n % 2 == 0)
    System.out.println("Par");
else
    System.out.println("Impar");
```

#### Ejercicio 2  
Completa la condición para verificar si un número es positivo y par:

```java
int numero = 8;
if (/* condición aquí */) {
    System.out.println("El número es positivo y par");
}
```

#### Ejercicio 3  
Completa el operador ternario para asignar "Mayor de edad" si edad >= 18, "Menor de edad" en caso contrario:  

```java
int edad = 20;
String mensaje = /* operador ternario aquí */;
System.out.println(mensaje);
```

#### Ejercicio 4  
Completa el incremento correcto para que la variable contador aumente en 1 después de usarla:

```java
int contador = 5;
System.out.println(contador); // Debe mostrar 5
// Instrucción de incremento aquí
System.out.println(contador); // Debe mostrar 6
```

#### Ejercicio 5  
Completa la expresión lógica para que el resultado sea true si el número está entre 10 y 20 (inclusive):

```java
int num = 15;
boolean estaEnRango = /* expresión aquí */;
System.out.println(estaEnRango);
```

---  

### 3️⃣ Escribir el código completo
*Escribe un programa completo de 5-10 líneas máximo.*  

#### Ejercicio 1 
Lee dos números enteros por teclado y muestra si son iguales o cuál es mayor/menor.

#### Ejercicio 2  
Pide un número entero y muestra si es positivo, negativo o cero.

#### Ejercicio 3   
Lee un número del 1 al 7 y muestra el día de la semana correspondiente. Si el número no está en ese rango, muestra "Número inválido".  

#### Ejercicio 4  
Lee tres números y determina cuál es el mayor de los tres usando el operador ternario.  

#### Ejercicio 5  
5-1) Programa que muestre un menú: 
    1. Sumar
    2. Restar
    3. Multiplicar
    4. Dividir
    5. Resto
5-2) Pida dos números y realice la operación.
5-3) Modifica el código para incluir una regla de validación que no permita la división entre cero. Si el usuario intenta dividir entre cero, debe mostrar un mensaje de error.
5-4) Reescribe el menú del apartado 5.1 utilizando la estructura switch en lugar de if-else.  

## 4️⃣ 



## 5️⃣ Ejemplo final


---

### Ejercicio 3

```java
int a = 5;
System.out.println(a > 3);
```

<details>
<summary>✅ Solución</summary>

**true**

</details>

