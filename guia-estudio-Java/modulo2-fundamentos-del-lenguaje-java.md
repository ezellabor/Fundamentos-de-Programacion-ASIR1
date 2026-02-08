<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# MÓDULO 2: FUNDAMENTOS DEL LENGUAJE JAVA

1. Sintaxis básica y estructura de un programa
1. Variables y tipos de datos primitivos
1. Constantes y literales
1. Operadores aritméticos, lógicos y relacionales
1. Conversión de tipos (casting)
1. Entrada y salida de datos por consola
1. Comentarios y buenas prácticas de código
   
## 1. Sintaxis básica y estructura de un programa

### Estructura general de un programa Java

Todo programa Java sigue una estructura básica que ya vimos en el Módulo 1, pero ahora profundizaremos en cada elemento:

```java
// 1. Declaración del paquete (opcional)
package com.ejemplo.miapp;

// 2. Importación de clases (opcional)
import java.util.Scanner;
import java.time.LocalDate;

// 3. Declaración de la clase
public class MiPrograma {

    // 4. Variables de clase (atributos)
    static int contadorGlobal = 0;

    // 5. Método principal (punto de entrada)
    public static void main(String[] args) {
        // 6. Cuerpo del programa
        System.out.println("Iniciando programa...");
    }

    // 7. Otros métodos (opcional)
    public static void otroMetodo() {
        // código adicional
    }
}
```

### Reglas fundamentales de sintaxis

**Sensibilidad a mayúsculas y minúsculas:**
Java distingue entre mayúsculas y minúsculas. `miVariable` y `MiVariable` son dos identificadores diferentes.

**Punto y coma obligatorio:**
Cada sentencia debe terminar con punto y coma (`;`):

```java
int edad = 25;
String nombre = "Ana";
System.out.println("Hola");
```

**Llaves para delimitar bloques:**
Los bloques de código se delimitan con llaves `{ }`:

```java
if (edad >= 18) {
    System.out.println("Mayor de edad");
    System.out.println("Puede votar");
}
```

**Identación y estilo:**
Aunque no es obligatorio, es fundamental para la legibilidad:

```java
// Mal estilo
public class Ejemplo{
public static void main(String[] args){
System.out.println("Hola");
}}

// Buen estilo
public class Ejemplo {
    public static void main(String[] args) {
        System.out.println("Hola");
    }
}
```

### Convenciones de nomenclatura

**Clases:** PascalCase (primera letra de cada palabra en mayúscula)

```java
public class GestorUsuarios { }
public class ConexionBaseDatos { }
```

**Métodos y variables:** camelCase (primera palabra en minúscula, siguientes con mayúscula inicial)

```java
int contadorIntentos;
String nombreCompleto;
void procesarDatos() { }
void calcularPromedio() { }
```

**Constantes:** MAYÚSCULAS con guión bajo

```java
static final int MAX_INTENTOS = 3;
static final String NOMBRE_SISTEMA = "Monitor ASIR";
```

**Paquetes:** todo en minúsculas

```java
package com.empresa.proyecto;
package utilidades.red;
```

## 2. Variables y tipos de datos primitivos

### ¿Qué es una variable?

Una variable es un espacio en memoria que almacena un valor que puede cambiar durante la ejecución del programa. Tiene tres componentes:

- **Tipo:** qué tipo de dato almacena
- **Nombre:** identificador único
- **Valor:** el dato almacenado

### Declaración y asignación

```java
// Declaración (reserva espacio en memoria)
int edad;

// Asignación (almacena un valor)
edad = 25;

// Declaración e inicialización en una línea
int numeroServidores = 10;

// Múltiples variables del mismo tipo
int servidor1, servidor2, servidor3;
int a = 5, b = 10, c = 15;
```

### Tipos de datos primitivos

Java tiene 8 tipos de datos primitivos, divididos en cuatro categorías:

#### 1. Tipos enteros (números sin decimales)

|Tipo   |Tamaño |Rango                         |Uso típico                     |
|-------|-------|------------------------------|-------------------------------|
|`byte` |8 bits |-128 a 127                    |Ahorrar memoria, datos binarios|
|`short`|16 bits|-32,768 a 32,767              |Números pequeños               |
|`int`  |32 bits|-2,147,483,648 a 2,147,483,647|Uso general (más común)        |
|`long` |64 bits|-9,223,372,036,854,775,808 a …|Números muy grandes            |

```java
byte puertosAbiertos = 80;
short anio = 2025;
int memoriaRAM = 16384;  // MB
long espacioDisco = 2000000000000L;  // Bytes (nota la 'L' al final)
```

**Importante:** Los literales `long` deben terminar con `L` o `l` (se recomienda `L` mayúscula para evitar confusión con el número 1).

#### 2. Tipos de punto flotante (números decimales)

|Tipo    |Tamaño |Precisión       |Uso típico                 |
|--------|-------|----------------|---------------------------|
|`float` |32 bits|~6-7 decimales  |Precisión simple           |
|`double`|64 bits|~15-16 decimales|Precisión doble (más común)|

```java
float temperatura = 36.5f;  // Nota la 'f' al final
double latencia = 0.0045;   // Segundos
double porcentajeCPU = 87.34;
```

**Importante:** Los literales `float` deben terminar con `F` o `f`.

#### 3. Tipo carácter

|Tipo  |Tamaño |Rango     |Descripción              |
|------|-------|----------|-------------------------|
|`char`|16 bits|0 a 65,535|Un único carácter Unicode|

```java
char letraUnidad = 'C';
char simbolo = '@';
char unicode = '\u0041';  // Representa 'A'
```

**Importante:** Los caracteres se escriben entre comillas simples `' '`.

#### 4. Tipo booleano

|Tipo     |Valores posibles|Uso                |
|---------|----------------|-------------------|
|`boolean`|`true`, `false` |Condiciones lógicas|

```java
boolean sistemaActivo = true;
boolean errorEncontrado = false;
boolean esAdministrador = true;
```

### Tabla resumen de tipos primitivos

```java
public class TiposPrimitivos {
    public static void main(String[] args) {
        // Enteros
        byte cpuCores = 8;
        short puertoHTTP = 80;
        int memoriaTotal = 16384;
        long tiempoUptime = 86400000L;

        // Decimales
        float latenciaMS = 12.5f;
        double usoCPU = 45.67;

        // Carácter
        char tipoSistema = 'L';  // L de Linux

        // Booleano
        boolean servicioActivo = true;

        // Imprimir todos
        System.out.println("Cores CPU: " + cpuCores);
        System.out.println("Puerto: " + puertoHTTP);
        System.out.println("Memoria (MB): " + memoriaTotal);
        System.out.println("Uptime (ms): " + tiempoUptime);
        System.out.println("Latencia: " + latenciaMS + " ms");
        System.out.println("Uso CPU: " + usoCPU + "%");
        System.out.println("Sistema: " + tipoSistema);
        System.out.println("Servicio activo: " + servicioActivo);
    }
}
```

### Tipos de referencia vs tipos primitivos

**Tipos primitivos:** Almacenan el valor directamente en memoria.
**Tipos de referencia:** Almacenan una referencia (dirección) a un objeto en memoria.

```java
// Tipo primitivo
int numero = 10;  // El valor 10 se almacena directamente

// Tipo de referencia
String texto = "Hola";  // Se almacena una referencia al objeto String
```

**String no es un tipo primitivo**, es una clase, pero se usa tan frecuentemente que Java permite crearlos de forma simplificada.

## 3. Constantes y literales

### Constantes

Las constantes son variables cuyos valores no pueden cambiar una vez asignados. Se declaran con la palabra clave `final`:

```java
final int MAX_CONEXIONES = 100;
final double PI = 3.14159265359;
final String SERVIDOR_PRINCIPAL = "192.168.1.100";

// Intento de cambiar el valor (ERROR de compilación)
// MAX_CONEXIONES = 200;  // ¡Error!
```

**Convención:** Las constantes se escriben en MAYÚSCULAS con guiones bajos.

**Ventajas de usar constantes:**

- Hace el código más legible
- Facilita el mantenimiento (cambiar el valor en un solo lugar)
- Previene modificaciones accidentales
- El compilador puede optimizar el código

```java
public class ConfiguracionServidor {
    // Constantes de configuración
    public static final String IP_SERVIDOR = "192.168.1.10";
    public static final int PUERTO_HTTP = 80;
    public static final int PUERTO_HTTPS = 443;
    public static final int TIMEOUT_CONEXION = 30000;  // milisegundos
    public static final int MAX_REINTENTOS = 3;

    public static void main(String[] args) {
        System.out.println("Conectando a " + IP_SERVIDOR + ":" + PUERTO_HTTPS);
        System.out.println("Timeout configurado: " + TIMEOUT_CONEXION + " ms");
        System.out.println("Reintentos máximos: " + MAX_REINTENTOS);
    }
}
```

### Literales

Los literales son valores constantes que se escriben directamente en el código:

**Literales enteros:**

```java
int decimal = 100;
int binario = 0b1100100;    // Prefijo 0b
int octal = 0144;           // Prefijo 0
int hexadecimal = 0x64;     // Prefijo 0x

// Guiones bajos para legibilidad (Java 7+)
int millones = 1_000_000;
long tarjetaCredito = 1234_5678_9012_3456L;
```

**Literales de punto flotante:**

```java
double d1 = 123.45;
double d2 = 1.2345e2;  // Notación científica (123.45)
float f = 123.45f;
```

**Literales de caracteres:**

```java
char letra = 'A';
char tab = '\t';      // Tabulación
char nuevaLinea = '\n';  // Salto de línea
char comilla = '\'';  // Comilla simple escapada
char unicode = '\u0041';  // 'A' en Unicode
```

**Secuencias de escape comunes:**

- `\n` - Nueva línea
- `\t` - Tabulación
- `\\` - Barra invertida
- `\'` - Comilla simple
- `\"` - Comilla doble
- `\r` - Retorno de carro

**Literales de cadena:**

```java
String mensaje = "Hola Mundo";
String ruta = "C:\\Windows\\System32";  // Barras escapadas
String multilínea = "Primera línea\nSegunda línea\nTercera línea";
```

**Literales booleanos:**

```java
boolean verdadero = true;
boolean falso = false;
```

## 4. Operadores aritméticos, lógicos y relacionales

### Operadores aritméticos

Realizan operaciones matemáticas básicas:

|Operador|Operación     |Ejemplo |Resultado|
|--------|--------------|--------|---------|
|`+`     |Suma          |`5 + 3` |`8`      |
|`-`     |Resta         |`5 - 3` |`2`      |
|`*`     |Multiplicación|`5 * 3` |`15`     |
|`/`     |División      |`10 / 3`|`3`      |
|`%`     |Módulo (resto)|`10 % 3`|`1`      |

```java
public class OperadoresAritmeticos {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println("Suma: " + (a + b));        // 13
        System.out.println("Resta: " + (a - b));       // 7
        System.out.println("Multiplicación: " + (a * b)); // 30
        System.out.println("División: " + (a / b));    // 3 (división entera)
        System.out.println("Módulo: " + (a % b));      // 1 (resto)

        // División decimal
        double resultado = (double) a / b;
        System.out.println("División decimal: " + resultado); // 3.333...
    }
}
```

**Importante:** La división entre enteros produce un resultado entero (se trunca la parte decimal).

### Operadores de asignación compuesta

Combinan una operación aritmética con la asignación:

|Operador|Equivalente|Ejemplo |Significado|
|--------|-----------|--------|-----------|
|`+=`    |`a = a + b`|`a += 5`|`a = a + 5`|
|`-=`    |`a = a - b`|`a -= 3`|`a = a - 3`|
|`*=`    |`a = a * b`|`a *= 2`|`a = a * 2`|
|`/=`    |`a = a / b`|`a /= 4`|`a = a / 4`|
|`%=`    |`a = a % b`|`a %= 3`|`a = a % 3`|

```java
int contador = 10;
contador += 5;   // contador es ahora 15
contador -= 3;   // contador es ahora 12
contador *= 2;   // contador es ahora 24
contador /= 4;   // contador es ahora 6
```

### Operadores de incremento y decremento

|Operador|Nombre    |Descripción            |Ejemplo|
|--------|----------|-----------------------|-------|
|`++`    |Incremento|Aumenta el valor en 1  |`a++`  |
|`--`    |Decremento|Disminuye el valor en 1|`a--`  |

**Pre-incremento vs Post-incremento:**

```java
int a = 5;
int b = ++a;  // Pre-incremento: primero incrementa, luego asigna
// a = 6, b = 6

int c = 5;
int d = c++;  // Post-incremento: primero asigna, luego incrementa
// c = 6, d = 5
```

Ejemplo práctico:

```java
int intentos = 0;
System.out.println("Intento número: " + (++intentos));  // 1
System.out.println("Intento número: " + (++intentos));  // 2
System.out.println("Intento número: " + (++intentos));  // 3
```

### Operadores relacionales (de comparación)

Comparan dos valores y devuelven un resultado booleano:

|Operador|Significado      |Ejemplo |Resultado|
|--------|-----------------|--------|---------|
|`==`    |Igual a          |`5 == 5`|`true`   |
|`!=`    |Diferente de     |`5 != 3`|`true`   |
|`>`     |Mayor que        |`5 > 3` |`true`   |
|`<`     |Menor que        |`5 < 3` |`false`  |
|`>=`    |Mayor o igual que|`5 >= 5`|`true`   |
|`<=`    |Menor o igual que|`5 <= 3`|`false`  |

```java
int edad = 20;
boolean esMayorDeEdad = edad >= 18;  // true
boolean esAdolescente = edad >= 13 && edad <= 19;  // false

int servidoresActivos = 45;
int totalServidores = 50;
boolean todosActivos = servidoresActivos == totalServidores;  // false
boolean hayInactivos = servidoresActivos < totalServidores;   // true
```

**¡Cuidado!** No confundir `=` (asignación) con `==` (comparación):

```java
int x = 5;      // Asignación: x toma el valor 5
boolean y = (x == 5);  // Comparación: ¿x es igual a 5?
```

### Operadores lógicos

Trabajan con valores booleanos:

|Operador|Nombre    |Descripción                      |Ejemplo                  |
|--------|----------|---------------------------------|-------------------------|
|`&&`    |AND lógico|Verdadero si ambos son verdaderos|`true && false` → `false`|
|`                 ||`                                |OR lógico                |
|`!`     |NOT lógico|Invierte el valor                |`!true` → `false`        |

**Tabla de verdad AND (&&):**

```
A     | B     | A && B
------|-------|--------
true  | true  | true
true  | false | false
false | true  | false
false | false | false
```

**Tabla de verdad OR (||):**

```
A     | B     | A || B
------|-------|--------
true  | true  | true
true  | false | true
false | true  | true
false | false | false
```

Ejemplos prácticos:

```java
// Sistema de autenticación
boolean usuarioCorrecto = true;
boolean passwordCorrecta = true;
boolean puedeAcceder = usuarioCorrecto && passwordCorrecta;  // true

// Sistema de alertas
int temperatura = 85;
int usoCPU = 95;
boolean alerta = (temperatura > 80) || (usoCPU > 90);  // true

// Negación
boolean servicioActivo = false;
boolean servicioInactivo = !servicioActivo;  // true
```

**Evaluación en cortocircuito:**
Java optimiza las expresiones lógicas:

- En `&&`: si la primera condición es falsa, no evalúa la segunda
- En `||`: si la primera condición es verdadera, no evalúa la segunda

```java
int x = 0;
// La división no se ejecuta porque (x != 0) es falso
boolean resultado = (x != 0) && (10 / x > 2);  // false, sin error
```

### Operador ternario

Es una forma compacta del `if-else`:

```java
// Sintaxis: condición ? valorSiVerdadero : valorSiFalso
int edad = 17;
String mensaje = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
System.out.println(mensaje);  // "Menor de edad"

// Equivalente con if-else
String mensaje2;
if (edad >= 18) {
    mensaje2 = "Mayor de edad";
} else {
    mensaje2 = "Menor de edad";
}
```

Ejemplo práctico ASIR:

```java
int memoriaDisponible = 512;  // MB
String estado = (memoriaDisponible > 1024) ? "OK" : "ALERTA";
System.out.println("Estado memoria: " + estado);  // ALERTA
```

### Precedencia de operadores

Cuando se combinan varios operadores, Java los evalúa en un orden específico:

1. Paréntesis `( )`
1. Incremento/Decremento `++`, `--`
1. NOT lógico `!`
1. Multiplicación, División, Módulo `*`, `/`, `%`
1. Suma, Resta `+`, `-`
1. Relacionales `<`, `>`, `<=`, `>=`
1. Igualdad `==`, `!=`
1. AND lógico `&&`
1. OR lógico `||`
1. Operador ternario `? :`
1. Asignación `=`, `+=`, `-=`, etc.

```java
int resultado = 10 + 5 * 2;        // 20 (no 30)
int resultado2 = (10 + 5) * 2;     // 30 (los paréntesis tienen prioridad)

boolean complejo = 5 > 3 && 10 < 20 || false; 
// Se evalúa: (5 > 3) && (10 < 20) || false
// true && true || false = true
```
### Ejemplo completo  
Ejemplo completo de cómo funcionan los tipos, los operadores y las expresiones en Java.  
```java
public class JavaTypesOperatorsExpressions {
    public static void main(String[] args) {
        // ==================== JAVA DATA TYPES ====================
        
        // Primitive Data Types
        
        // 1. BYTE (-128 to 127)
        byte myByte = 100;
        System.out.println("Byte value: " + myByte);
        
        // 2. SHORT (-32,768 to 32,767)
        short myShort = 1000;
        System.out.println("Short value: " + myShort);
        
        // 3. INT (-2,147,483,648 to 2,147,483,647)
        int myInt = 100000;
        System.out.println("Int value: " + myInt);
        
        // 4. LONG (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
        long myLong = 10000000000L; // Note the 'L' suffix
        System.out.println("Long value: " + myLong);
        
        // 5. FLOAT (32-bit floating point)
        float myFloat = 3.14f; // Note the 'f' suffix
        System.out.println("Float value: " + myFloat);
        
        // 6. DOUBLE (64-bit floating point)
        double myDouble = 3.14159;
        System.out.println("Double value: " + myDouble);
        
        // 7. BOOLEAN (true or false)
        boolean myBoolean = true;
        System.out.println("Boolean value: " + myBoolean);
        
        // 8. CHAR (16-bit Unicode character)
        char myChar = 'A';
        System.out.println("Char value: " + myChar);
        
        System.out.println("\n==================== OPERATORS ====================\n");
        
        // ==================== ARITHMETIC OPERATORS ====================
        int a = 20, b = 10;
        System.out.println("Arithmetic Operations:");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + (a + b)); // Addition
        System.out.println("a - b = " + (a - b)); // Subtraction
        System.out.println("a * b = " + (a * b)); // Multiplication
        System.out.println("a / b = " + (a / b)); // Division
        System.out.println("a % b = " + (a % b)); // Modulus (remainder)
        
        // ==================== UNARY OPERATORS ====================
        int x = 10;
        System.out.println("\nUnary Operations:");
        System.out.println("x = " + x);
        System.out.println("++x = " + (++x)); // Pre-increment
        System.out.println("x++ = " + (x++)); // Post-increment
        System.out.println("x after post-increment = " + x);
        System.out.println("--x = " + (--x)); // Pre-decrement
        System.out.println("x-- = " + (x--)); // Post-decrement
        System.out.println("!true = " + (!true)); // Logical NOT
        
        // ==================== RELATIONAL OPERATORS ====================
        int p = 10, q = 20;
        System.out.println("\nRelational Operations:");
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p == q: " + (p == q)); // Equal to
        System.out.println("p != q: " + (p != q)); // Not equal to
        System.out.println("p > q: " + (p > q));   // Greater than
        System.out.println("p < q: " + (p < q));   // Less than
        System.out.println("p >= q: " + (p >= q)); // Greater than or equal to
        System.out.println("p <= q: " + (p <= q)); // Less than or equal to
        
        // ==================== LOGICAL OPERATORS ====================
        boolean bool1 = true, bool2 = false;
        System.out.println("\nLogical Operations:");
        System.out.println("bool1 = " + bool1 + ", bool2 = " + bool2);
        System.out.println("bool1 && bool2: " + (bool1 && bool2)); // Logical AND
        System.out.println("bool1 || bool2: " + (bool1 || bool2)); // Logical OR
        System.out.println("!bool1: " + (!bool1));                // Logical NOT
        
        // ==================== ASSIGNMENT OPERATORS ====================
        int assignVar = 5;
        System.out.println("\nAssignment Operations:");
        System.out.println("Initial value: " + assignVar);
        assignVar += 3; // Same as assignVar = assignVar + 3
        System.out.println("After += 3: " + assignVar);
        assignVar -= 2; // Same as assignVar = assignVar - 2
        System.out.println("After -= 2: " + assignVar);
        assignVar *= 4; // Same as assignVar = assignVar * 4
        System.out.println("After *= 4: " + assignVar);
        assignVar /= 3; // Same as assignVar = assignVar / 3
        System.out.println("After /= 3: " + assignVar);
        assignVar %= 3; // Same as assignVar = assignVar % 3
        System.out.println("After %= 3: " + assignVar);
        
        // ==================== EXPRESSIONS ====================
        System.out.println("\n==================== EXPRESSIONS ====================\n");
        
        // Arithmetic Expression
        int expression1 = (10 + 5) * 2 - 8 / 4;
        System.out.println("Expression (10 + 5) * 2 - 8 / 4 = " + expression1);
        
        // Boolean Expression
        boolean expression2 = (10 > 5) && (3 < 7);
        System.out.println("Boolean expression (10 > 5) && (3 < 7) = " + expression2);
        
        // Complex Expression with Mixed Types
        double expression3 = (15.5 + 4.5) / 2 * 3;
        System.out.println("Complex expression (15.5 + 4.5) / 2 * 3 = " + expression3);
        
        // Type Conversion in Expressions
        int intVal = 10;
        double doubleVal = 3.0;
        double result = intVal / doubleVal; // int is promoted to double
        System.out.println("Type conversion: 10 / 3.0 = " + result);
        
        // Ternary Operator (Conditional Expression)
        int marks = 85;
        String grade = (marks >= 60) ? "Pass" : "Fail";
        System.out.println("Marks: " + marks + ", Grade: " + grade);
        
       
    }
}
```

## 5. Conversión de tipos (casting)

### Tipos de conversión

#### Conversión implícita (automática)

Java convierte automáticamente de un tipo más pequeño a uno más grande:

```java
byte b = 10;
int i = b;      // byte → int (automático)
long l = i;     // int → long (automático)
float f = l;    // long → float (automático)
double d = f;   // float → double (automático)

// Orden de conversión automática:
// byte → short → int → long → float → double
```

#### Conversión explícita (casting)

Necesaria cuando se convierte de un tipo más grande a uno más pequeño:

```java
double d = 9.7;
int i = (int) d;  // 9 (se pierde la parte decimal)

long l = 1000L;
int i2 = (int) l;  // Conversión explícita

float f = 3.14f;
int i3 = (int) f;  // 3
```

**Sintaxis del casting:** `(tipoDestino) valor`

### Conversión entre tipos primitivos

```java
public class ConversionTipos {
    public static void main(String[] args) {
        // Conversión implícita (ensanchamiento)
        int entero = 100;
        long largo = entero;  // OK
        double decimal = entero;  // OK

        System.out.println("Entero: " + entero);      // 100
        System.out.println("Largo: " + largo);        // 100
        System.out.println("Decimal: " + decimal);    // 100.0

        // Conversión explícita (estrechamiento)
        double pi = 3.14159;
        int piEntero = (int) pi;  // Pierde decimales

        System.out.println("Pi: " + pi);              // 3.14159
        System.out.println("Pi entero: " + piEntero); // 3

        // Pérdida de datos con valores grandes
        long numerGrande = 1234567890123L;
        int numPequeno = (int) numeroGrande;  // Pérdida de datos
        System.out.println("Número grande: " + numeroGrande);
        System.out.println("Conversión: " + numPequeno);  // Valor incorrecto
    }
}
```

### Conversión de char a int y viceversa

```java
char letra = 'A';
int codigoASCII = (int) letra;  // 65
System.out.println("Código de 'A': " + codigoASCII);

int codigo = 66;
char caracter = (char) codigo;  // 'B'
System.out.println("Carácter del código 66: " + caracter);
```

### Conversión con String

**De String a tipos primitivos:**

```java
String textoNumero = "123";
int numero = Integer.parseInt(textoNumero);

String textoDecimal = "45.67";
double decimal = Double.parseDouble(textoDecimal);

String textoBoolean = "true";
boolean valor = Boolean.parseBoolean(textoBoolean);
```

**De tipos primitivos a String:**

```java
int numero = 42;
String texto1 = String.valueOf(numero);
String texto2 = "" + numero;  // Concatenación con cadena vacía
String texto3 = Integer.toString(numero);
```

### Cuidado con la pérdida de precisión

```java
int a = 10;
int b = 3;
double resultado1 = a / b;  // 3.0 (división entera, luego convertida)
double resultado2 = (double) a / b;  // 3.333... (conversión antes de dividir)

System.out.println("Sin casting: " + resultado1);
System.out.println("Con casting: " + resultado2);
```
### Ejemplo  
```java
 // ==================== TYPE CONVERSION ====================
        System.out.println("\n==================== TYPE CONVERSION ====================\n");
        
        // Implicit (Automatic) Conversion
        int smallNum = 100;
        long bigNum = smallNum; // int automatically converted to long
        System.out.println("Implicit conversion: int " + smallNum + " to long " + bigNum);
        
        // Explicit (Manual) Conversion - Casting
        double pi = 3.14159;
        int intPi = (int) pi; // double explicitly converted to int
        System.out.println("Explicit conversion: double " + pi + " to int " + intPi);
        
        // ==================== COMMON MISTAKES TO AVOID ====================
        System.out.println("\n==================== COMMON MISTAKES ====================\n");
        
        // 1. Integer Division
        int num1 = 5, num2 = 2;
        int intDivision = num1 / num2; // Result is 2, not 2.5
        double doubleDivision = (double) num1 / num2; // Result is 2.5
        System.out.println("Integer division 5/2 = " + intDivision);
        System.out.println("Double division 5/2 = " + doubleDivision);
        
        // 2. Operator Precedence
        int precedence1 = 10 + 5 * 2; // 20, not 30
        int precedence2 = (10 + 5) * 2; // 30
        System.out.println("10 + 5 * 2 = " + precedence1);
        System.out.println("(10 + 5) * 2 = " + precedence2);
        
        // 3. Type Range Issues
        byte smallByte = 120;
        // smallByte = smallByte + 10; // This would cause compilation error!
        smallByte = (byte) (smallByte + 10); // Need explicit casting
        System.out.println("Byte after addition: " + smallByte);

```


## 6. Entrada y salida de datos por consola

### Salida de datos: System.out

**println() - Imprime y añade salto de línea:**

```java
System.out.println("Hola Mundo");
System.out.println("Siguiente línea");
```

**print() - Imprime sin salto de línea:**

```java
System.out.print("Hola ");
System.out.print("Mundo");
// Salida: Hola Mundo
```

**printf() - Impresión con formato:**

```java
String nombre = "Juan";
int edad = 25;
double altura = 1.75;

System.out.printf("Nombre: %s, Edad: %d, Altura: %.2f m%n", nombre, edad, altura);
// Salida: Nombre: Juan, Edad: 25, Altura: 1.75 m
```

**Especificadores de formato comunes:**

- `%s` - String
- `%d` - Entero decimal
- `%f` - Punto flotante
- `%.2f` - Punto flotante con 2 decimales
- `%n` - Nueva línea (independiente del SO)
- `%x` - Hexadecimal
- `%b` - Booleano

Ejemplo completo:

```java
public class FormatoSalida {
    public static void main(String[] args) {
        String servidor = "web-01";
        int puerto = 8080;
        double uptime = 99.87;
        boolean activo = true;

        System.out.printf("Servidor: %s%n", servidor);
        System.out.printf("Puerto: %d%n", puerto);
        System.out.printf("Uptime: %.2f%%%n", uptime);  // %% para imprimir %
        System.out.printf("Estado: %b%n", activo);

        // Alineación y anchura
        System.out.printf("%-20s | %10d | %6.2f%%%n", servidor, puerto, uptime);
    }
}
```

### Entrada de datos: Scanner

La clase `Scanner` permite leer datos del usuario:

```java
import java.util.Scanner;

public class EntradaDatos {
    public static void main(String[] args) {
        // Crear objeto Scanner
        Scanner entrada = new Scanner(System.in);

        // Leer diferentes tipos de datos
        System.out.print("Introduce tu nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = entrada.nextInt();

        System.out.print("Introduce tu altura (m): ");
        double altura = entrada.nextDouble();

        // Mostrar resultados
        System.out.println("\n=== DATOS INGRESADOS ===");
        System.out.printf("Nombre: %s%n", nombre);
        System.out.printf("Edad: %d años%n", edad);
        System.out.printf("Altura: %.2f m%n", altura);

        // Cerrar el Scanner
        entrada.close();
    }
}
```

**Métodos principales de Scanner:**

- `nextLine()` - Lee una línea completa de texto
- `next()` - Lee una palabra (hasta el espacio)
- `nextInt()` - Lee un entero
- `nextDouble()` - Lee un número decimal
- `nextBoolean()` - Lee un booleano
- `nextByte()`, `nextShort()`, `nextLong()`, `nextFloat()` - Otros tipos

### Problema común: nextInt() + nextLine()

```java
Scanner sc = new Scanner(System.in);

System.out.print("Edad: ");
int edad = sc.nextInt();
sc.nextLine();  // ¡Necesario! Consume el salto de línea pendiente

System.out.print("Nombre: ");
String nombre = sc.nextLine();
```

### Ejemplo práctico: Calculadora de recursos

```java
import java.util.Scanner;

public class CalculadoraRecursos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CALCULADORA DE RECURSOS DEL SERVIDOR ===");

        System.out.print("Memoria total (GB): ");
        int memoriaTotal = sc.nextInt();

        System.out.print("Memoria en uso (GB): ");
        int memoriaUso = sc.nextInt();

        System.out.print("CPU total (cores): ");
        int cpuTotal = sc.nextInt();

        System.out.print("CPU en uso (cores): ");
        int cpuUso = sc.nextInt();

        // Calcular porcentajes
        double porcentajeMemoria = (memoriaUso * 100.0) / memoriaTotal;
        double porcentajeCPU = (cpuUso * 100.0) / cpuTotal;

        // Mostrar resultados
        System.out.println("\n=== ESTADO DEL SERVIDOR ===");
        System.out.printf("Memoria: %d/%d GB (%.1f%%)%n",
                          memoriaUso, memoriaTotal, porcentajeMemoria);
        System.out.printf("CPU: %d/%d cores (%.1f%%)%n",
                          cpuUso, cpuTotal, porcentajeCPU);

        // Alertas
        if (porcentajeMemoria > 80) {
            System.out.println("⚠️  ALERTA: Uso de memoria crítico");
        }
        if (porcentajeCPU > 80) {
            System.out.println("⚠️  ALERTA: Uso de CPU crítico");
        }
```








