![Módulo](https://img.shields.io/badge/Módulo-Fundamentos_de_Programación-brown?style=for-the-badge)
![Lenguaje](https://img.shields.io/badge/Lenguaje-Java-brown?style=for-the-badge)
![Grupo](https://img.shields.io/badge/Grupo-ASIR1V-blue?style=for-the-badge)
![Profesor](https://img.shields.io/badge/Profesor-Ezequiel_Llarena_Borges-blue?style=for-the-badge)  

##  Operaciones Relacionales, Lógicas y Condicionales


### 1️⃣ Análisis de código  
*Analiza los siguientes fragmentos de código en Java y determina qué mostrará por pantalla.*  

#### Ejercicio 1
```java
int x = 5;
int y = ++x * 2;
System.out.println(y);

// Salida: 12
// Explicación: ++x incrementa x a 6, luego 6 * 2 = 12
```

  
#### Ejercicio 2
```java  
boolean a = true;
boolean b = false;
boolean c = a && b || !b;
System.out.println(c);

// Salida: true
// Explicación: true && false = false, false || true = true
```

#### Ejercicio 3
```java
int num = 10;
String resultado = (num % 2 == 0) ? "Par" : "Impar";
System.out.println(resultado);

// Salida: Par
// Explicación: 10 % 2 = 0, por lo tanto "Par"
```

#### Ejercicio 4  
```java
int i = 3;
int j = i-- + --i;
System.out.println(j);

// Salida: 4
// Explicación: i-- usa i=3 y luego decrementa a 2, --i decrementa a 1, total 3+1=4
```

#### Ejercicio 5
```java
int a = 7;
int b = 3;
System.out.println(a > b && a++ < b || b++ == 3);
System.out.println("a = " + a + ", b = " + b);

// Salida: false
// a = 8, b = 4
// Explicación: 7>3 es true, pero 7++<3 es false (7<3 false), por cortocircuito no evalúa b++==3, luego a=8, b=3
```
---  

### 2️⃣ Completar código  
*Completa la instrucción o el bloque de código Java faltante.*  

#### Ejercicio 1  
Completa la condición para comprobar si un número es par o impar:  

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
int n = sc.nextInt();

if (/* escribe la condición aquí */)
    System.out.println("Par");
else
    System.out.println("Impar");

// Solución: (num % 2 == 0
```

#### Ejercicio 2  
Completa la condición para verificar si un número es positivo y par:

```java
int numero = 8;
if (/* escribe la condición aquí */) {
    System.out.println("El número es positivo y par");
}

// Solución: if (numero > 0 && numero % 2 == 0)
```

#### Ejercicio 3  
Completa el operador ternario para asignar el literal "Mayor de edad" a la variable ```mensaje``` si edad >= 18, "Menor de edad" en caso contrario:  

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

// Solución:
// System.out.println(contador++);
```

#### Ejercicio 5  
Completa la expresión lógica para que el resultado sea ```true``` si el número está entre 10 y 20 (inclusive):

```java
int num = 15;
boolean estaEnRango = /* expresión aquí */;
System.out.println(estaEnRango);

// Solución:
// boolean estaEnRango = num >= 10 && num <= 20;
```

---  

### 3️⃣ Escribir el código completo
*Escribe un programa en Java completo de 5-10 líneas máximo.*  

#### Ejercicio 1 
Lee dos números enteros por teclado y muestra si son iguales o cuál es mayor/menor.

```java
// Solución:
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Número 1: ");
int n1 = sc.nextInt();
System.out.print("Número 2: ");
int n2 = sc.nextInt();
if (n1 == n2) System.out.println("Son iguales");
else System.out.println(n1 > n2 ? n1 + " es mayor" : n2 + " es mayor");
```

#### Ejercicio 2  
Pide un número entero y muestra si es positivo, negativo o cero.
```java
// Solución:
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Número: ");
int num = sc.nextInt();
if (num > 0) System.out.println("Positivo");
else if (num < 0) System.out.println("Negativo");
else System.out.println("Cero");
``` 

#### Ejercicio 3   
Lee un número del 1 al 7 y muestra el día de la semana correspondiente. Si el número no está en ese rango, muestra "Número inválido".  
```java
// Solución:
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Número (1-7): ");
int dia = sc.nextInt();
if (dia == 1) System.out.println("Lunes");
else if (dia == 2) System.out.println("Martes");
else if (dia == 3) System.out.println("Miércoles");
else if (dia == 4) System.out.println("Jueves");
else if (dia == 5) System.out.println("Viernes");
else if (dia == 6) System.out.println("Sábado");
else if (dia == 7) System.out.println("Domingo");
else System.out.println("Número inválido");
```


#### Ejercicio 4  
Lee tres números y determina cuál es el mayor de los tres usando el operador ternario.  
```java
// Solución:
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Tres números: ");
int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
int mayor = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
System.out.println("Mayor: " + mayor);
```



#### Ejercicio 5  
5.1. Escribe la implementación en Java de un programa que muestre el siguiente menú de opciones:  
```java
    1. Sumar
    2. Restar
    3. Multiplicar
    4. Dividir
    5. Resto
```

5.2. A continuación pide dos números por teclado y realiza la operación correspondiente según la opción introducida en el apartado anterior.  
5.3. Modifica el código para incluir una regla de validación que no permita la división entre cero. Si el usuario intenta dividir entre cero, debe mostrar un mensaje de error.  
5.4. Reescribe el menú del apartado 5.1 utilizando la estructura ```switch``` en lugar de ```if-else```.    

<!--
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
-->
