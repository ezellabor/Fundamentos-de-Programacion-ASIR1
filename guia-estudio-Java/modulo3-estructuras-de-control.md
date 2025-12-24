<!DOCTYPE html>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Módulo 2: Fundamentos del Lenguaje Java</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

```
    :root {
        --color-bg: #f5f5f0;
        --color-primary: #5a7c8f;
        --color-secondary: #7d9aa8;
        --color-accent: #d4af7a;
        --color-text: #3a3a3a;
        --color-text-light: #6a6a6a;
        --color-code-bg: #e8e8e0;
        --color-border: #d0d0c8;
        --color-white: #ffffff;
        --color-shadow: rgba(0, 0, 0, 0.1);
    }

    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        line-height: 1.7;
        color: var(--color-text);
        background-color: var(--color-bg);
        padding: 20px;
        max-width: 900px;
        margin: 0 auto;
    }

    header {
        background: linear-gradient(135deg, var(--color-primary), var(--color-secondary));
        color: var(--color-white);
        padding: 40px 30px;
        border-radius: 12px;
        margin-bottom: 40px;
        box-shadow: 0 4px 15px var(--color-shadow);
    }

    h1 {
        font-size: 2.2em;
        margin-bottom: 10px;
        font-weight: 600;
    }

    header p {
        font-size: 1.1em;
        opacity: 0.95;
    }

    section {
        background: var(--color-white);
        padding: 35px;
        margin-bottom: 30px;
        border-radius: 10px;
        box-shadow: 0 2px 10px var(--color-shadow);
    }

    h2 {
        color: var(--color-primary);
        font-size: 1.8em;
        margin-bottom: 20px;
        padding-bottom: 10px;
        border-bottom: 2px solid var(--color-accent);
    }

    h3 {
        color: var(--color-secondary);
        font-size: 1.4em;
        margin-top: 25px;
        margin-bottom: 15px;
    }

    h4 {
        color: var(--color-text);
        font-size: 1.1em;
        margin-top: 20px;
        margin-bottom: 12px;
        font-weight: 600;
    }

    p {
        margin-bottom: 15px;
        text-align: justify;
    }

    ul, ol {
        margin-left: 25px;
        margin-bottom: 15px;
    }

    li {
        margin-bottom: 8px;
    }

    code {
        background-color: var(--color-code-bg);
        padding: 2px 6px;
        border-radius: 4px;
        font-family: 'Courier New', monospace;
        font-size: 0.92em;
        color: var(--color-text);
    }

    pre {
        background-color: var(--color-code-bg);
        padding: 20px;
        border-radius: 8px;
        overflow-x: auto;
        margin: 20px 0;
        border-left: 4px solid var(--color-primary);
        box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.05);
    }

    pre code {
        background: none;
        padding: 0;
        font-size: 0.9em;
        line-height: 1.5;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        background: var(--color-white);
    }

    th {
        background-color: var(--color-primary);
        color: var(--color-white);
        padding: 12px;
        text-align: left;
        font-weight: 500;
    }

    td {
        padding: 12px;
        border-bottom: 1px solid var(--color-border);
    }

    tr:hover {
        background-color: var(--color-code-bg);
    }

    .highlight {
        background-color: var(--color-accent);
        padding: 15px 20px;
        border-radius: 8px;
        margin: 20px 0;
        border-left: 4px solid var(--color-primary);
    }

    .highlight strong {
        color: var(--color-primary);
    }

    .note {
        background-color: #e8f4f8;
        padding: 15px 20px;
        border-radius: 8px;
        margin: 20px 0;
        border-left: 4px solid var(--color-secondary);
    }

    .warning {
        background-color: #fff3cd;
        padding: 15px 20px;
        border-radius: 8px;
        margin: 20px 0;
        border-left: 4px solid #ffb84d;
    }

    .top-button {
        position: fixed;
        bottom: 30px;
        right: 30px;
        background: linear-gradient(135deg, var(--color-primary), var(--color-secondary));
        color: var(--color-white);
        width: 55px;
        height: 55px;
        border-radius: 50%;
        border: none;
        cursor: pointer;
        font-size: 1.3em;
        box-shadow: 0 4px 15px var(--color-shadow);
        opacity: 0;
        visibility: hidden;
        transition: all 0.3s ease;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .top-button.visible {
        opacity: 1;
        visibility: visible;
    }

    .top-button:hover {
        transform: translateY(-5px);
        box-shadow: 0 6px 20px var(--color-shadow);
    }

    .summary {
        background: linear-gradient(135deg, #e8f4f8, #f0f8ff);
        padding: 25px;
        border-radius: 10px;
        margin-top: 30px;
        border: 2px solid var(--color-secondary);
    }

    .summary h3 {
        color: var(--color-primary);
        margin-top: 0;
    }

    footer {
        text-align: center;
        padding: 30px;
        color: var(--color-text-light);
        margin-top: 40px;
        border-top: 2px solid var(--color-border);
    }

    @media (max-width: 768px) {
        body {
            padding: 10px;
        }

        header, section {
            padding: 20px;
        }

        h1 {
            font-size: 1.8em;
        }

        h2 {
            font-size: 1.5em;
        }

        .top-button {
            width: 45px;
            height: 45px;
            bottom: 20px;
            right: 20px;
        }
    }
</style>
```

</head>
<body>
    <header>
        <h1>MÓDULO 2: Fundamentos del Lenguaje Java</h1>
        <p>Guía de estudio para ASIR - Ciclo Formativo</p>
    </header>

```
<section id="sintaxis">
    <h2>1. Sintaxis básica y estructura de un programa</h2>

    <h3>Estructura general de un programa Java</h3>
    <p>Todo programa Java sigue una estructura básica que incluye declaración del paquete, importación de clases, declaración de la clase principal y el método main.</p>

    <pre><code>// 1. Declaración del paquete (opcional)
```

package com.ejemplo.miapp;

// 2. Importación de clases (opcional)
import java.util.Scanner;
import java.time.LocalDate;

// 3. Declaración de la clase
public class MiPrograma {

```
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
```

}</code></pre>

```
    <h3>Reglas fundamentales de sintaxis</h3>

    <h4>Sensibilidad a mayúsculas y minúsculas:</h4>
    <p>Java distingue entre mayúsculas y minúsculas. <code>miVariable</code> y <code>MiVariable</code> son dos identificadores diferentes.</p>

    <h4>Punto y coma obligatorio:</h4>
    <p>Cada sentencia debe terminar con punto y coma (;):</p>
    <pre><code>int edad = 25;
```

String nombre = “Ana”;
System.out.println(“Hola”);</code></pre>

```
    <div class="note">
        <strong>Convenciones de nomenclatura:</strong>
        <ul>
            <li><strong>Clases:</strong> PascalCase → <code>GestorUsuarios</code>, <code>ConexionBaseDatos</code></li>
            <li><strong>Métodos y variables:</strong> camelCase → <code>contadorIntentos</code>, <code>procesarDatos()</code></li>
            <li><strong>Constantes:</strong> MAYÚSCULAS → <code>MAX_INTENTOS</code>, <code>NOMBRE_SISTEMA</code></li>
            <li><strong>Paquetes:</strong> minúsculas → <code>com.empresa.proyecto</code></li>
        </ul>
    </div>
</section>

<section id="variables">
    <h2>2. Variables y tipos de datos primitivos</h2>

    <h3>¿Qué es una variable?</h3>
    <p>Una variable es un espacio en memoria que almacena un valor que puede cambiar durante la ejecución del programa. Tiene tres componentes: tipo, nombre y valor.</p>

    <h3>Declaración y asignación</h3>
    <pre><code>// Declaración (reserva espacio en memoria)
```

int edad;

// Asignación (almacena un valor)
edad = 25;

// Declaración e inicialización en una línea
int numeroServidores = 10;

// Múltiples variables del mismo tipo
int servidor1, servidor2, servidor3;
int a = 5, b = 10, c = 15;</code></pre>

```
    <h3>Tipos de datos primitivos</h3>

    <h4>1. Tipos enteros (números sin decimales)</h4>
    <table>
        <thead>
            <tr>
                <th>Tipo</th>
                <th>Tamaño</th>
                <th>Rango</th>
                <th>Uso típico</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><code>byte</code></td>
                <td>8 bits</td>
                <td>-128 a 127</td>
                <td>Ahorrar memoria, datos binarios</td>
            </tr>
            <tr>
                <td><code>short</code></td>
                <td>16 bits</td>
                <td>-32,768 a 32,767</td>
                <td>Números pequeños</td>
            </tr>
            <tr>
                <td><code>int</code></td>
                <td>32 bits</td>
                <td>-2,147,483,648 a 2,147,483,647</td>
                <td>Uso general (más común)</td>
            </tr>
            <tr>
                <td><code>long</code></td>
                <td>64 bits</td>
                <td>-9,223,372,036,854,775,808 a ...</td>
                <td>Números muy grandes</td>
            </tr>
        </tbody>
    </table>

    <pre><code>byte puertosAbiertos = 80;
```

short anio = 2025;
int memoriaRAM = 16384;  // MB
long espacioDisco = 2000000000000L;  // Bytes</code></pre>

```
    <div class="warning">
        <strong>⚠️ Importante:</strong> Los literales <code>long</code> deben terminar con <code>L</code> o <code>l</code> (se recomienda <code>L</code> mayúscula para evitar confusión con el número 1).
    </div>

    <h4>2. Tipos de punto flotante (números decimales)</h4>
    <table>
        <thead>
            <tr>
                <th>Tipo</th>
                <th>Tamaño</th>
                <th>Precisión</th>
                <th>Uso típico</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><code>float</code></td>
                <td>32 bits</td>
                <td>~6-7 decimales</td>
                <td>Precisión simple</td>
            </tr>
            <tr>
                <td><code>double</code></td>
                <td>64 bits</td>
                <td>~15-16 decimales</td>
                <td>Precisión doble (más común)</td>
            </tr>
        </tbody>
    </table>

    <pre><code>float temperatura = 36.5f;  // Nota la 'f' al final
```

double latencia = 0.0045;   // Segundos
double porcentajeCPU = 87.34;</code></pre>

```
    <h4>3. Tipo carácter y booleano</h4>
    <pre><code>// Carácter (char) - 16 bits
```

char letraUnidad = ‘C’;
char simbolo = ‘@’;
char unicode = ‘\u0041’;  // Representa ‘A’

// Booleano (boolean)
boolean sistemaActivo = true;
boolean errorEncontrado = false;</code></pre>
</section>

```
<section id="constantes">
    <h2>3. Constantes y literales</h2>

    <h3>Constantes</h3>
    <p>Las constantes son variables cuyos valores no pueden cambiar una vez asignados. Se declaran con la palabra clave <code>final</code>:</p>

    <pre><code>final int MAX_CONEXIONES = 100;
```

final double PI = 3.14159265359;
final String SERVIDOR_PRINCIPAL = “192.168.1.100”;

// Intento de cambiar el valor (ERROR de compilación)
// MAX_CONEXIONES = 200;  // ¡Error!</code></pre>

```
    <div class="highlight">
        <strong>Ventajas de usar constantes:</strong>
        <ul>
            <li>Hace el código más legible</li>
            <li>Facilita el mantenimiento (cambiar el valor en un solo lugar)</li>
            <li>Previene modificaciones accidentales</li>
            <li>El compilador puede optimizar el código</li>
        </ul>
    </div>

    <h3>Literales</h3>
    <p>Los literales son valores constantes que se escriben directamente en el código:</p>

    <pre><code>// Literales enteros
```

int decimal = 100;
int binario = 0b1100100;    // Prefijo 0b
int hexadecimal = 0x64;     // Prefijo 0x

// Guiones bajos para legibilidad (Java 7+)
int millones = 1_000_000;
long tarjetaCredito = 1234_5678_9012_3456L;

// Secuencias de escape
char tab = ‘\t’;
char nuevaLinea = ‘\n’;
char comilla = ‘'’;</code></pre>
</section>

```
<section id="operadores">
    <h2>4. Operadores aritméticos, lógicos y relacionales</h2>

    <h3>Operadores aritméticos</h3>
    <table>
        <thead>
            <tr>
                <th>Operador</th>
                <th>Operación</th>
                <th>Ejemplo</th>
                <th>Resultado</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><code>+</code></td>
                <td>Suma</td>
                <td><code>5 + 3</code></td>
                <td>8</td>
            </tr>
            <tr>
                <td><code>-</code></td>
                <td>Resta</td>
                <td><code>5 - 3</code></td>
                <td>2</td>
            </tr>
            <tr>
                <td><code>*</code></td>
                <td>Multiplicación</td>
                <td><code>5 * 3</code></td>
                <td>15</td>
            </tr>
            <tr>
                <td><code>/</code></td>
                <td>División</td>
                <td><code>10 / 3</code></td>
                <td>3</td>
            </tr>
            <tr>
                <td><code>%</code></td>
                <td>Módulo (resto)</td>
                <td><code>10 % 3</code></td>
                <td>1</td>
            </tr>
        </tbody>
    </table>

    <div class="warning">
        <strong>⚠️ Importante:</strong> La división entre enteros produce un resultado entero (se trunca la parte decimal).
    </div>

    <h3>Operadores de asignación compuesta</h3>
    <pre><code>int contador = 10;
```

contador += 5;   // contador es ahora 15
contador -= 3;   // contador es ahora 12
contador *= 2;   // contador es ahora 24
contador /= 4;   // contador es ahora 6</code></pre>

```
    <h3>Operadores relacionales (de comparación)</h3>
    <table>
        <thead>
            <tr>
                <th>Operador</th>
                <th>Significado</th>
                <th>Ejemplo</th>
                <th>Resultado</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><code>==</code></td>
                <td>Igual a</td>
                <td><code>5 == 5</code></td>
                <td>true</td>
            </tr>
            <tr>
                <td><code>!=</code></td>
                <td>Diferente de</td>
                <td><code>5 != 3</code></td>
                <td>true</td>
            </tr>
            <tr>
                <td><code>&gt;</code></td>
                <td>Mayor que</td>
                <td><code>5 &gt; 3</code></td>
                <td>true</td>
            </tr>
            <tr>
                <td><code>&lt;</code></td>
                <td>Menor que</td>
                <td><code>5 &lt; 3</code></td>
                <td>false</td>
            </tr>
            <tr>
                <td><code>&gt;=</code></td>
                <td>Mayor o igual que</td>
                <td><code>5 &gt;= 5</code></td>
                <td>true</td>
            </tr>
            <tr>
                <td><code>&lt;=</code></td>
                <td>Menor o igual que</td>
                <td><code>5 &lt;= 3</code></td>
                <td>false</td>
            </tr>
        </tbody>
    </table>

    <h3>Operadores lógicos</h3>
    <table>
        <thead>
            <tr>
                <th>Operador</th>
                <th>Nombre</th>
                <th>Descripción</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><code>&&</code></td>
                <td>AND lógico</td>
                <td>Verdadero si ambos son verdaderos</td>
            </tr>
            <tr>
                <td><code>||</code></td>
                <td>OR lógico</td>
                <td>Verdadero si al menos uno es verdadero</td>
            </tr>
            <tr>
                <td><code>!</code></td>
                <td>NOT lógico</td>
                <td>Invierte el valor</td>
            </tr>
        </tbody>
    </table>

    <pre><code>// Sistema de autenticación
```

boolean usuarioCorrecto = true;
boolean passwordCorrecta = true;
boolean puedeAcceder = usuarioCorrecto && passwordCorrecta;

// Sistema de alertas
int temperatura = 85;
int usoCPU = 95;
boolean alerta = (temperatura > 80) || (usoCPU > 90);</code></pre>
</section>

```
<section id="casting">
    <h2>5. Conversión de tipos (casting)</h2>

    <h3>Conversión implícita (automática)</h3>
    <p>Java convierte automáticamente de un tipo más pequeño a uno más grande:</p>
    <pre><code>byte b = 10;
```

int i = b;      // byte → int (automático)
long l = i;     // int → long (automático)
float f = l;    // long → float (automático)
double d = f;   // float → double (automático)

// Orden: byte → short → int → long → float → double</code></pre>

```
    <h3>Conversión explícita (casting)</h3>
    <p>Necesaria cuando se convierte de un tipo más grande a uno más pequeño:</p>
    <pre><code>double d = 9.7;
```

int i = (int) d;  // 9 (se pierde la parte decimal)

long l = 1000L;
int i2 = (int) l;  // Conversión explícita

float f = 3.14f;
int i3 = (int) f;  // 3</code></pre>

```
    <div class="warning">
        <strong>⚠️ Cuidado con la pérdida de precisión:</strong>
        <pre><code>int a = 10;
```

int b = 3;
double resultado1 = a / b;  // 3.0 (división entera)
double resultado2 = (double) a / b;  // 3.333…</code></pre>
</div>

```
    <h3>Conversión con String</h3>
    <pre><code>// De String a tipos primitivos
```

String textoNumero = “123”;
int numero = Integer.parseInt(textoNumero);

String textoDecimal = “45.67”;
double decimal = Double.parseDouble(textoDecimal);

// De tipos primitivos a String
int numero = 42;
String texto = String.valueOf(numero);
String texto2 = “” + numero;  // Concatenación</code></pre>
</section>

```
<section id="entrada-salida">
    <h2>6. Entrada y salida de datos por consola</h2>

    <h3>Salida de datos: System.out</h3>
    <pre><code>// println() - Imprime y añade salto de línea
```

System.out.println(“Hola Mundo”);

// print() - Imprime sin salto de línea
System.out.print(“Hola “);
System.out.print(“Mundo”);

// printf() - Impresión con formato
String nombre = “Juan”;
int edad = 25;
double altura = 1.75;

System.out.printf(“Nombre: %s, Edad: %d, Altura: %.2f m%n”,
nombre, edad, altura);</code></pre>

```
    <div class="note">
        <strong>Especificadores de formato comunes:</strong>
        <ul>
            <li><code>%s</code> - String</li>
            <li><code>%d</code> - Entero decimal</li>
            <li><code>%f</code> - Punto flotante</li>
            <li><code>%.2f</code> - Punto flotante con 2 decimales</li>
            <li><code>%n</code> - Nueva línea (independiente del SO)</li>
        </ul>
    </div>

    <h3>Entrada de datos: Scanner</h3>
    <pre><code>import java.util.Scanner;
```

public class EntradaDatos {
public static void main(String[] args) {
Scanner entrada = new Scanner(System.in);

```
    System.out.print("Introduce tu nombre: ");
    String nombre = entrada.nextLine();

    System.out.print("Introduce tu edad: ");
    int edad = entrada.nextInt();

    System.out.printf("Hola %s, tienes %d años%n", nombre, edad);

    entrada.close();
}
```

}</code></pre>

```
    <div class="warning">
        <strong>⚠️ Problema común: nextInt() + nextLine()</strong>
        <pre><code>Scanner sc = new Scanner(System.in);
```

System.out.print(“Edad: “);
int edad = sc.nextInt();
sc.nextLine();  // ¡Necesario! Consume el salto de línea

System.out.print(“Nombre: “);
String nombre = sc.nextLine();</code></pre>
</div>
</section>

```
<section id="comentarios">
    <h2>7. Comentarios y buenas prácticas de código</h2>

    <h3>Tipos de comentarios</h3>
    <pre><code>// Comentario de una línea
```

/*

- Comentario de
- múltiples líneas
  */

/**

- Comentario de documentación (Javadoc)
- @param parametro Descripción del parámetro
- @return Descripción del valor de retorno
  */</code></pre>

  ```
   <div class="highlight">
       <strong>Usa comentarios para:</strong>
       <ul>
           <li>Explicar el "por qué", no el "qué"</li>
           <li>Documentar algoritmos complejos</li>
           <li>Advertir sobre comportamientos no evidentes</li>
           <li>Documentar APIs públicas</li>
       </ul>
   </div>

   <h3>Buenas prácticas</h3>

   <h4>Variables descriptivas:</h4>
   <pre><code>// ❌ MAL
  ```

int x = 86400;

// ✅ BIEN
int segundosPorDia = 86400;</code></pre>

```
    <h4>Constantes significativas:</h4>
    <pre><code>// ❌ MAL
```

if (intentos > 3) {
bloquearUsuario();
}

// ✅ BIEN
final int MAX_INTENTOS_LOGIN = 3;
if (intentos > MAX_INTENTOS_LOGIN) {
bloquearUsuario();
}</code></pre>

```
    <div class="note">
        <strong>Principios fundamentales:</strong>
        <ul>
            <li><strong>DRY:</strong> Don't Repeat Yourself - No te repitas</li>
            <li><strong>KISS:</strong> Keep It Simple, Stupid - Mantenlo simple</li>
            <li><strong>Código limpio:</strong> El código debe ser legible como prosa</li>
        </ul>
    </div>
</section>

<section id="resumen">
    <div class="summary">
        <h3>Resumen del Módulo 2</h3>
        <p><strong>Has aprendido los fundamentos esenciales de Java:</strong></p>

        <h4>Conceptos clave:</h4>
        <ul>
            <li><strong>Sintaxis básica:</strong> estructura de programas, reglas de nomenclatura</li>
            <li><strong>Variables y tipos primitivos:</strong> byte, short, int, long, float, double, char, boolean</li>
            <li><strong>Constantes:</strong> valores inmutables con <code>final</code></li>
            <li><strong>Operadores:</strong> aritméticos, relacionales, lógicos y de asignación</li>
            <li><strong>Casting:</strong> conversión implícita y explícita entre tipos</li>
            <li><strong>Entrada/Salida:</strong> Scanner para entrada, System.out para salida</li>
            <li><strong>Buenas prácticas:</strong> comentarios útiles, código limpio y legible</li>
        </ul>

        <h4>Tipos primitivos en memoria:</h4>
        <pre><code>byte    →  8 bits  →  -128 a 127
```

short   → 16 bits  →  -32,768 a 32,767
int     → 32 bits  →  ~-2 mil millones a ~2 mil millones
long    → 64 bits  →  números muy grandes
float   → 32 bits  →  decimales (precisión simple)
double  → 64 bits  →  decimales (precisión doble)
char
