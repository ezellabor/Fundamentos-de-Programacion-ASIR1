# CMO-313. Fundamentos de programación (Java)

**Programación didáctica — Cronograma semanal del módulo profesional optativo**

Ciclo Formativo de Grado Superior · Administración de Sistemas Informáticos en Red (ASIR) · 1er curso

| | |
|---|---|
| **Duración total** | 50 horas |
| **Distribución** | 1 sesión semanal de 2 horas (25 semanas) |
| **Carácter** | Módulo profesional optativo |
| **Lenguaje de programación** | Java |
| **Profesor** | Ezequiel Llarena Borges |
| **Curso académico** | 2026-2027 |

> **Nota sobre el carácter del módulo:** al tratarse de un módulo profesional optativo de 50 horas, la Comunidad de Madrid no publica un currículo cerrado con resultados de aprendizaje y contenidos fijos (a diferencia de los módulos troncales), sino que corresponde a cada centro definirlos, siguiendo las Instrucciones para la definición de módulos optativos. Los resultados de aprendizaje, criterios de evaluación y contenidos que se proponen a continuación se han diseñado de forma coherente con ese marco y con el perfil profesional de ASIR, tomando como referencia el formato habitual de las programaciones didácticas de la Comunidad de Madrid.

## 1. Resultados de aprendizaje y criterios de evaluación

La calificación final del módulo será la media ponderada de los cinco resultados de aprendizaje (RA), según el peso indicado, calculado en proporción a las horas lectivas dedicadas a cada uno.

| RA | Resultado de aprendizaje | Horas | Peso |
|---|---|---|---|
| RA1 | Reconoce los elementos y la sintaxis básica de un lenguaje de programación orientado a objetos (Java), identificando y utilizando su entorno de desarrollo. | 8 h | 16% |
| RA2 | Aplica estructuras de control de flujo, selectivas e iterativas, en la resolución de problemas sencillos. | 10 h | 20% |
| RA3 | Utiliza estructuras de datos (arrays y colecciones) y modulariza el código mediante métodos para resolver problemas de mayor complejidad. | 12 h | 24% |
| RA4 | Desarrolla aplicaciones sencillas aplicando los principios de la programación orientada a objetos. | 16 h | 32% |
| RA5 | Depura y documenta programas, aplicando un tratamiento básico de excepciones y buenas prácticas de codificación. | 4 h | 8% |

**RA1 — Criterios de evaluación**

- Se ha identificado el entorno de desarrollo (JDK, IDE) y se ha compilado y ejecutado un primer programa.
- Se han utilizado correctamente tipos de datos primitivos, variables y constantes.
- Se ha empleado la entrada de datos por teclado y el formateo de la salida por consola.
- Se han aplicado operadores aritméticos, relacionales y lógicos.

**RA2 — Criterios de evaluación**

- Se han aplicado estructuras selectivas (if, switch) para resolver problemas sencillos.
- Se han aplicado estructuras iterativas (while, do-while, for) de forma adecuada al problema planteado.
- Se han evitado errores habituales como bucles infinitos o condiciones mal planteadas.
- Se han combinado estructuras de control anidadas cuando ha sido necesario.

**RA3 — Criterios de evaluación**

- Se han utilizado arrays y colecciones (ArrayList) para almacenar conjuntos de datos.
- Se han recorrido colecciones con bucles y con la sintaxis for-each.
- Se ha modularizado el código en métodos con parámetros y valor de retorno.
- Se ha reconocido el ámbito (scope) de las variables locales.

**RA4 — Criterios de evaluación**

- Se han creado clases con atributos, constructores y métodos, aplicando encapsulación.
- Se han utilizado colecciones de objetos para representar conjuntos de datos complejos.
- Se han aplicado relaciones de herencia entre clases mediante extends y super.
- Se ha aplicado el polimorfismo para tratar de forma uniforme objetos de distinto tipo.

**RA5 — Criterios de evaluación**

- Se han identificado situaciones susceptibles de provocar errores en tiempo de ejecución.
- Se ha aplicado el tratamiento de excepciones mediante try-catch.
- Se han creado excepciones personalizadas cuando ha sido necesario.
- Se han aplicado buenas prácticas de codificación y documentación básica (comentarios, Javadoc).

## 2. Organización en Unidades de Trabajo

| UT | Título | RA | H. Teoría | H. Práctica | Total | Semanas |
|---|---|---|---|---|---|---|
| UT1 | Introducción al lenguaje y elementos básicos | RA1 | 2.5 | 5.5 | **8** | 1 – 4 |
| UT2 | Estructuras de control selectivas | RA2 | 1.5 | 2.5 | **4** | 5 – 6 |
| UT3 | Estructuras de control iterativas | RA2 | 1.5 | 4.5 | **6** | 7 – 9 |
| UT4 | Arrays y colecciones | RA3 | 1.5 | 4.5 | **6** | 10 – 12 |
| UT5 | Métodos y modularización | RA3 | 1.5 | 4.5 | **6** | 13 – 15 |
| UT6 | Programación orientada a objetos I: clases y objetos | RA4 | 2 | 6 | **8** | 16 – 19 |
| UT7 | Programación orientada a objetos II: herencia y polimorfismo | RA4 | 2 | 6 | **8** | 20 – 23 |
| UT8 | Excepciones, documentación y cierre del proyecto | RA5 | 1.5 | 2.5 | **4** | 24 – 25 |

Total: 50 horas (16,5 h de teoría y 33,5 h de práctica) en 25 semanas.

## 3. El eje vertebrador: proyecto GestorInventario

Todo el módulo gira en torno a la construcción progresiva de un mismo programa en Java: GestorInventario, una aplicación de consola para gestionar el inventario de componentes informáticos de un pequeño taller (discos, módulos de RAM, tarjetas gráficas...). Cada Unidad de Trabajo retoma el código de la anterior y lo amplía con los contenidos recién aprendidos, de modo que el alumnado ve en todo momento para qué sirve cada concepto nuevo dentro de un programa real y con sentido, en lugar de percibir cada UT como un bloque de teoría aislado.

La progresión completa del proyecto es la siguiente:

- **UT1** (Introducción al lenguaje y elementos básicos): Arranque del proyecto: primer programa.
- **UT2** (Estructuras de control selectivas): Añadimos un menú con selección.
- **UT3** (Estructuras de control iterativas): El menú se convierte en repetitivo.
- **UT4** (Arrays y colecciones): De una unidad a un inventario completo.
- **UT5** (Métodos y modularización): El programa se modulariza en métodos.
- **UT6** (Programación orientada a objetos I: clases y objetos): El inventario pasa a estar orientado a objetos.
- **UT7** (Programación orientada a objetos II: herencia y polimorfismo): Distintos tipos de componentes, un mismo tratamiento.
- **UT8** (Excepciones, documentación y cierre del proyecto): Cierre del proyecto: entrada robusta y excepciones propias.

## 4. Cronograma semanal

T = horas de teoría/explicación. P = horas de práctica (realización y corrección de ejercicios). Cada sesión es de 2 horas semanales.

| Sem. | UT | Contenido de la sesión | T | P | Avance del proyecto / cierre |
|---|---|---|---|---|---|
| 1 | UT1 | Presentación del módulo. Instalación JDK/IDE. Primer programa "Hola Mundo". | 1 | 1 | Arranque del proyecto GestorInventario. |
| 2 | UT1 | Tipos de datos primitivos, variables, constantes, operadores aritméticos. | 0.5 | 1.5 | Variables nombre, precio y stock del producto. |
| 3 | UT1 | Entrada de datos con Scanner. Formateo de salida con printf. | 0.5 | 1.5 | Lectura del nuevo stock por teclado. |
| 4 | UT1 | Operadores relacionales y lógicos. Repaso y cierre de la UT1. | 0.5 | 1.5 | Cierre UT1 + Autoevaluación (12 ítems). |
| 5 | UT2 | Sentencia if / if-else. Operador ternario. | 1 | 1 | Clasificación del nivel de stock con if. |
| 6 | UT2 | Sentencia switch. Menú de opciones. Repaso y cierre de la UT2. | 0.5 | 1.5 | Menú con switch + Autoevaluación (10 ítems). |
| 7 | UT3 | Bucle while. Contadores y acumuladores. | 1 | 1 | Bucle de validación de la opción elegida. |
| 8 | UT3 | Bucle do-while. Bucle for. | 0.5 | 1.5 | Menú repetitivo con do-while. |
| 9 | UT3 | Bucles anidados. Repaso y cierre de la UT3. | 0.5 | 1.5 | Cierre UT3 + Autoevaluación (10 ítems). |
| 10 | UT4 | Arrays unidimensionales: declaración y recorrido. | 1 | 1 | Primer array de nombres de producto. |
| 11 | UT4 | ArrayList: añadir, eliminar y recorrer elementos. | 0.5 | 1.5 | Sustitución de arrays por ArrayList. |
| 12 | UT4 | Recorrido con for-each. Repaso y cierre de la UT4. | 0.5 | 1.5 | Listado de productos + Autoevaluación (11 ítems). |
| 13 | UT5 | Definición e invocación de métodos. Paso de parámetros. | 1 | 1 | Extracción del método listarProductos(). |
| 14 | UT5 | Métodos con valor de retorno. Sobrecarga de métodos. | 0.5 | 1.5 | Método calcularValorTotal(). |
| 15 | UT5 | Ámbito de variables. Repaso y cierre de la UT5. | 0.5 | 1.5 | Programa modularizado + Autoevaluación (11 ítems). |
| 16 | UT6 | Clase y objeto. Atributos y constructores. | 1 | 1 | Creación de la clase Producto. |
| 17 | UT6 | Métodos de instancia. Encapsulación (private, getters/setters). | 0.5 | 1.5 | Encapsulación de los atributos de Producto. |
| 18 | UT6 | El método toString(). Uso de ArrayList<Producto>. | 0.5 | 1.5 | Sustitución de listas paralelas por ArrayList<Producto>. |
| 19 | UT6 | Relaciones básicas entre clases. Repaso y cierre de la UT6. | 0.5 | 1.5 | Cierre UT6 + Autoevaluación (13 ítems). |
| 20 | UT7 | Herencia: extends, super(). Superclases y subclases. | 1 | 1 | Clase base ComponenteInformatico. |
| 21 | UT7 | Sobrescritura de métodos heredados (@Override). | 0.5 | 1.5 | Subclases TarjetaGrafica y MemoriaRAM. |
| 22 | UT7 | Polimorfismo: tratamiento uniforme de objetos distintos. | 0.5 | 1.5 | ArrayList<ComponenteInformatico> polimórfico. |
| 23 | UT7 | Atributos protected. Repaso y cierre de la UT7. | 0.5 | 1.5 | Cierre UT7 + Autoevaluación (13 ítems). |
| 24 | UT8 | Tratamiento de excepciones: try-catch. Excepciones comunes. | 1 | 1 | Validación robusta de la entrada de stock. |
| 25 | UT8 | Excepciones personalizadas. Javadoc. Entrega final del proyecto. | 0.5 | 1.5 | StockInvalidoException + cierre del proyecto + Autoevaluación (10 ítems). |

## 5. Desarrollo de cada Unidad de Trabajo

### UT1. Introducción al lenguaje y elementos básicos

*RA1 · 8 horas (T: 2.5 / P: 5.5) · Semanas 1 – 4*

**Contenidos**

- El lenguaje Java: características, JDK, JRE y JVM. Instalación del entorno de desarrollo (IDE).
- Estructura de un programa Java: clase, método main().
- Tipos de datos primitivos (int, double, char, boolean...) y tipos de referencia.
- Declaración de variables y constantes (final). Operadores aritméticos, relacionales y lógicos.
- Entrada de datos por teclado con Scanner. Formateo de la salida con printf.
- Comentarios y estilo básico de codificación.

**Ejercicios cortos de clase**

- **Completar código:** Completar la línea que falta para declarar la variable stock de tipo entero, inicializada a 12 unidades.
- **Encontrar el error:** Localizar el error en un fragmento donde el precio se ha declarado como String y se usa después en un cálculo aritmético.
- **Escribir un bloque:** Escribir las líneas necesarias para pedir por teclado el nombre de un producto y mostrarlo por pantalla.

**Avance del proyecto — Arranque del proyecto: primer programa**

```java
import java.util.Scanner;

public class GestorInventario {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nombre = "Disco SSD 500GB";
        double precio = 45.90;
        int stock = 12;

        System.out.println("=== Gestor de Inventario de Componentes ===");
        System.out.printf("Producto: %s%n", nombre);
        System.out.printf("Precio: %.2f eur%n", precio);
        System.out.printf("Stock: %d unidades%n", stock);

        System.out.print("Introduce el nuevo stock: ");
        stock = teclado.nextInt();
        System.out.println("Stock actualizado a " + stock + " unidades.");
    }
}
```

**Autoevaluación UT1** *(12 ítems, opción múltiple, autocorregible)*

**1. ¿Qué es el JDK?**

- A) Un entorno de ejecución sin herramientas de desarrollo
- B) El kit de desarrollo de Java: incluye compilador, entorno de ejecución y herramientas
- C) Un tipo de dato de Java
- D) Un IDE específico de Java

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) El kit de desarrollo de Java: incluye compilador, entorno de ejecución y herramientas

El JDK (Java Development Kit) incluye el compilador y las herramientas necesarias para programar en Java, además del entorno de ejecución.

</details>

**2. ¿Cómo se llama el método por el que empieza a ejecutarse un programa Java?**

- A) inicio()
- B) run()
- C) main()
- D) start()

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) main()

La ejecución de un programa Java comienza siempre por el método main().

</details>

**3. ¿Cuál de estos es un tipo de dato primitivo en Java?**

- A) String
- B) int
- C) ArrayList
- D) Scanner

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) int

int es un tipo primitivo; String, ArrayList y Scanner son clases.

</details>

**4. ¿Qué palabra clave se usa para declarar una constante en Java?**

- A) const
- B) static
- C) final
- D) constant

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) final

final se usa para declarar valores que no pueden modificarse tras su inicialización.

</details>

**5. ¿Qué imprime System.out.println("Hola" + 5 + 2);?**

- A) Hola52
- B) Hola7
- C) 7Hola
- D) Error de compilación

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Hola52

Al concatenar con un String, los siguientes valores se convierten también a texto: "Hola"+5+2 = "Hola52".

</details>

**6. ¿Qué clase se utiliza habitualmente para leer datos del teclado en Java?**

- A) Reader
- B) Scanner
- C) Input
- D) Console

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Scanner

La clase Scanner (java.util) permite leer datos introducidos por teclado.

</details>

**7. ¿Qué tipo de dato usarías para almacenar el precio 45.90?**

- A) int
- B) boolean
- C) double
- D) char

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) double

double es el tipo adecuado para números decimales como un precio.

</details>

**8. ¿Qué hace el método nextInt() de Scanner?**

- A) Lee una línea completa de texto
- B) Lee un número entero introducido por teclado
- C) Lee un número decimal
- D) Cierra el teclado

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Lee un número entero introducido por teclado

nextInt() lee específicamente un valor entero desde la entrada estándar.

</details>

**9. ¿Cuál es el resultado de 7 / 2 en Java, si ambos son de tipo int?**

- A) 3.5
- B) 3
- C) 4
- D) Error de compilación

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) 3

La división entre enteros en Java descarta la parte decimal: 7/2 da 3.

</details>

**10. ¿Qué formato usa printf para mostrar un número decimal con dos decimales?**

- A) %d
- B) %s
- C) %.2f
- D) %2d

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) %.2f

%.2f indica un número en coma flotante con dos decimales.

</details>

**11. ¿Cómo se escribe un comentario de una sola línea en Java?**

- A) # comentario
- B) // comentario
- C) <!-- comentario -->
- D) ' comentario

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) // comentario

Los comentarios de una línea en Java se escriben con //.

</details>

**12. ¿Qué extensión tiene el archivo compilado (bytecode) de una clase Java?**

- A) .java
- B) .exe
- C) .class
- D) .jar

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) .class

El compilador javac genera archivos .class con el bytecode, que ejecuta la JVM.

</details>

### UT2. Estructuras de control selectivas

*RA2 · 4 horas (T: 1.5 / P: 2.5) · Semanas 5 – 6*

**Contenidos**

- La sentencia if / if-else. Anidamiento de condiciones.
- El operador ternario.
- La sentencia switch y la instrucción break. Menús de opciones.
- Operadores relacionales y lógicos aplicados a condiciones.

**Ejercicios cortos de clase**

- **Completar código:** Completar un if-else que clasifique el stock en "agotado", "bajo" o "suficiente".
- **Encontrar el error:** Localizar el fallo en un switch sin break que provoca una "caída" (fall-through) no deseada.
- **Escribir un bloque:** Escribir un operador ternario que muestre "Disponible" o "Agotado" según el stock.

**Avance del proyecto — Añadimos un menú con selección**

```java
System.out.print("Elige una opcion (1-Ver stock, 2-Salir): ");
int opcion = teclado.nextInt();

switch (opcion) {
    case 1:
        if (stock == 0) {
            System.out.println("Sin stock disponible.");
        } else if (stock < 5) {
            System.out.println("Stock bajo: " + stock + " unidades.");
        } else {
            System.out.println("Stock suficiente: " + stock + " unidades.");
        }
        break;
    case 2:
        System.out.println("Saliendo del programa...");
        break;
    default:
        System.out.println("Opcion no valida.");
}
```

**Autoevaluación UT2** *(10 ítems, opción múltiple, autocorregible)*

**1. ¿Qué estructura se usa para ejecutar un bloque de código solo si se cumple una condición?**

- A) for
- B) if
- C) while
- D) switch-only

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) if

if ejecuta un bloque de código cuando la condición es verdadera.

</details>

**2. ¿Qué devuelve la expresión (5 > 3) && (2 > 4)?**

- A) true
- B) false
- C) 5
- D) Error

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) false

&& exige que ambas condiciones sean verdaderas; la segunda es falsa, así que el resultado es false.

</details>

**3. En una sentencia switch, ¿qué hace la instrucción break?**

- A) Sale del bucle actual
- B) Finaliza la ejecución del switch en ese punto
- C) Repite el case actual
- D) Provoca un error

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Finaliza la ejecución del switch en ese punto

break interrumpe la ejecución del switch, evitando que continúe con los siguientes case.

</details>

**4. ¿Qué ocurre si se olvida el break en un case de un switch?**

- A) El programa no compila
- B) Se ejecuta también el código del siguiente case ("caída")
- C) Solo se ejecuta ese case, como si tuviera break
- D) Se lanza una excepción

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Se ejecuta también el código del siguiente case ("caída")

Sin break, la ejecución "cae" al siguiente case (fall-through) y también lo ejecuta.

</details>

**5. ¿Cuál es la sintaxis correcta del operador ternario?**

- A) condición ? valorSiVerdadero : valorSiFalso
- B) if (condición) valor1 else valor2
- C) condición : valorSiVerdadero ? valorSiFalso
- D) condición => valor1, valor2

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) condición ? valorSiVerdadero : valorSiFalso

El operador ternario tiene la forma condición ? valorSiVerdadero : valorSiFalso.

</details>

**6. ¿Cuál de estos operadores es de igualdad en Java?**

- A) =
- B) ==
- C) ===
- D) eq

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) ==

== compara igualdad de valores; = es el operador de asignación.

</details>

**7. int x = 4; if (x > 5) {"A"} else if (x > 2) {"B"} else {"C"} ¿Qué se muestra?**

- A) A
- B) B
- C) C
- D) No muestra nada

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) B

x=4 no es mayor que 5 pero sí mayor que 2, así que se ejecuta el bloque "B".

</details>

**8. ¿Qué tipo de dato debe tener la condición de un if en Java?**

- A) Cualquier tipo numérico
- B) Únicamente boolean
- C) Cadenas de texto
- D) Cualquier valor, como en otros lenguajes

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Únicamente boolean

En Java la condición de un if debe ser obligatoriamente de tipo boolean.

</details>

**9. ¿Qué hace el operador lógico ! (negación)?**

- A) Compara dos valores
- B) Invierte el valor de una expresión booleana
- C) Suma dos números
- D) Concatena texto

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Invierte el valor de una expresión booleana

El operador ! invierte true a false y viceversa.

</details>

**10. ¿Cuándo es preferible un switch frente a una cadena de if-else?**

- A) Nunca, son intercambiables
- B) Cuando se comparan muchos valores posibles de una misma variable
- C) Solo con números decimales
- D) Solo con booleanos

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Cuando se comparan muchos valores posibles de una misma variable

switch resulta más legible cuando se comparan muchos valores posibles de una misma variable.

</details>

### UT3. Estructuras de control iterativas

*RA2 · 6 horas (T: 1.5 / P: 4.5) · Semanas 7 – 9*

**Contenidos**

- El bucle while. Contadores y acumuladores.
- El bucle do-while: menús repetitivos.
- El bucle for. Bucles anidados.
- Las instrucciones break y continue dentro de un bucle.

**Ejercicios cortos de clase**

- **Completar código:** Completar un bucle for que recorra del 1 al 10.
- **Encontrar el error:** Localizar por qué un bucle while nunca termina (la condición no cambia dentro del bucle).
- **Escribir un bloque:** Escribir un do-while que repita el menú hasta que el usuario introduzca la opción 3 (salir).

**Avance del proyecto — El menú se convierte en repetitivo**

```java
int opcion;
do {
    System.out.println();
    System.out.println("1) Ver stock  2) Actualizar stock  3) Salir");
    System.out.print("Opcion: ");
    opcion = teclado.nextInt();

    switch (opcion) {
        case 1:
            System.out.println("Stock actual: " + stock);
            break;
        case 2:
            System.out.print("Nuevo stock: ");
            stock = teclado.nextInt();
            break;
        case 3:
            System.out.println("Hasta luego.");
            break;
        default:
            System.out.println("Opcion no valida.");
    }
} while (opcion != 3);
```

**Autoevaluación UT3** *(10 ítems, opción múltiple, autocorregible)*

**1. ¿Qué diferencia principal hay entre while y do-while?**

- A) while nunca se ejecuta
- B) do-while ejecuta el bloque al menos una vez, aunque la condición sea falsa
- C) No hay ninguna diferencia
- D) do-while no admite condiciones

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) do-while ejecuta el bloque al menos una vez, aunque la condición sea falsa

En do-while el bloque se ejecuta primero y la condición se comprueba después, por lo que se ejecuta al menos una vez.

</details>

**2. ¿Cuántas veces se ejecuta for (int i = 0; i < 5; i++) {...}?**

- A) 4
- B) 5
- C) 6
- D) Infinitas

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) 5

i toma los valores 0,1,2,3,4: son 5 iteraciones.

</details>

**3. ¿Qué provoca un bucle infinito?**

- A) Que la condición de parada nunca se cumpla
- B) Usar for en vez de while
- C) Olvidar un punto y coma
- D) Declarar mal una variable

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Que la condición de parada nunca se cumpla

Si la condición de salida nunca se vuelve falsa, el bucle no termina nunca.

</details>

**4. En for (int i=0; i<10; i++), ¿qué se ejecuta tras cada vuelta del bloque?**

- A) La inicialización
- B) El incremento y luego la condición
- C) Solo el incremento
- D) Nada

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) El incremento y luego la condición

Tras cada ejecución del bloque, se aplica el incremento y después se comprueba la condición.

</details>

**5. ¿Qué es un acumulador en un bucle?**

- A) Una variable que cuenta cuántas veces se repite el bucle
- B) Una variable que va sumando valores en cada iteración
- C) Una variable constante
- D) Un tipo de bucle

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Una variable que va sumando valores en cada iteración

El acumulador va guardando la suma (u otra operación) de los valores procesados en cada vuelta.

</details>

**6. ¿Qué es un bucle anidado?**

- A) Un bucle sin condición
- B) Un bucle dentro de otro bucle
- C) Dos bucles seguidos
- D) Un bucle con más de una variable

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Un bucle dentro de otro bucle

Un bucle anidado es aquel que se define dentro del cuerpo de otro bucle.

</details>

**7. ¿Qué hace continue dentro de un bucle?**

- A) Termina el bucle por completo
- B) Salta el resto del código de esa iteración y pasa a la siguiente
- C) Repite la misma iteración
- D) Provoca un error de compilación

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Salta el resto del código de esa iteración y pasa a la siguiente

continue salta directamente a la siguiente iteración, sin ejecutar el resto del código de la actual.

</details>

**8. ¿Qué estructura es más adecuada cuando se conoce de antemano el número de repeticiones?**

- A) while
- B) do-while
- C) for
- D) if

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) for

for está pensado especialmente para cuando se conoce el número de iteraciones de antemano.

</details>

**9. ¿Qué ocurre si la condición de un while es falsa desde el principio?**

- A) El bloque se ejecuta una vez
- B) El bloque no se ejecuta nunca
- C) Da un error de compilación
- D) Se ejecuta de forma infinita

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) El bloque no se ejecuta nunca

while comprueba la condición antes de cada ejecución, así que si es falsa desde el inicio, el bloque no se ejecuta.

</details>

**10. En un menú repetitivo con do-while, ¿qué condición suele usarse para salir?**

- A) Que el usuario elija la opción de salir
- B) Que pasen más de 10 segundos
- C) Que se cierre la ventana
- D) No se necesita condición

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Que el usuario elija la opción de salir

Lo habitual es repetir el menú hasta que el usuario elija explícitamente la opción de salir.

</details>

### UT4. Arrays y colecciones

*RA3 · 6 horas (T: 1.5 / P: 4.5) · Semanas 10 – 12*

**Contenidos**

- Arrays unidimensionales: declaración, inicialización y recorrido.
- La colección ArrayList: añadir, eliminar, consultar y recorrer elementos.
- El bucle for-each aplicado a arrays y colecciones.
- Excepciones habituales al trabajar con índices (ArrayIndexOutOfBoundsException).

**Ejercicios cortos de clase**

- **Completar código:** Completar la declaración de un ArrayList<String> e inicializarlo vacío.
- **Encontrar el error:** Localizar el acceso a un índice fuera de rango en un array de productos.
- **Escribir un bloque:** Recorrer con for-each un ArrayList<String> mostrando cada nombre en mayúsculas.

**Avance del proyecto — De una unidad a un inventario completo**

```java
ArrayList<String> nombres = new ArrayList<>();
ArrayList<Double> precios = new ArrayList<>();
ArrayList<Integer> stocks = new ArrayList<>();

nombres.add("Disco SSD 500GB");  precios.add(45.90);  stocks.add(12);
nombres.add("Modulo RAM 8GB");   precios.add(28.50);  stocks.add(20);

for (int i = 0; i < nombres.size(); i++) {
    System.out.printf("%s - %.2f eur - %d uds.%n",
        nombres.get(i), precios.get(i), stocks.get(i));
}
```

**Autoevaluación UT4** *(11 ítems, opción múltiple, autocorregible)*

**1. ¿Cómo se declara un array de 5 enteros en Java?**

- A) int array(5);
- B) int[] array = new int[5];
- C) array int[5];
- D) new int array[5];

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) int[] array = new int[5];

La sintaxis correcta es int[] array = new int[5];

</details>

**2. ¿Cuál es el índice del primer elemento de un array en Java?**

- A) 1
- B) -1
- C) 0
- D) Depende del array

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) 0

En Java los arrays se indexan comenzando por 0.

</details>

**3. ¿Qué excepción se produce al acceder a un índice fuera del rango de un array?**

- A) NullPointerException
- B) ArrayIndexOutOfBoundsException
- C) NumberFormatException
- D) ClassCastException

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) ArrayIndexOutOfBoundsException

Acceder a una posición que no existe lanza ArrayIndexOutOfBoundsException.

</details>

**4. ¿Qué ventaja principal tiene ArrayList frente a un array tradicional?**

- A) Ocupa menos memoria siempre
- B) Puede cambiar de tamaño dinámicamente
- C) Solo admite tipos primitivos
- D) Es más rápido en todos los casos

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Puede cambiar de tamaño dinámicamente

A diferencia de los arrays de tamaño fijo, un ArrayList puede crecer o reducirse en tiempo de ejecución.

</details>

**5. ¿Qué método se usa para añadir un elemento a un ArrayList?**

- A) insert()
- B) push()
- C) add()
- D) put()

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) add()

El método add() añade un nuevo elemento al final de un ArrayList.

</details>

**6. ¿Qué tipo de dato se debe usar en un ArrayList para almacenar enteros?**

- A) int
- B) Integer
- C) Number
- D) entero

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Integer

ArrayList no admite tipos primitivos directamente; hay que usar su clase envoltorio, Integer.

</details>

**7. ¿Qué hace un bucle for-each sobre una colección?**

- A) Recorre todos sus elementos sin gestionar un índice
- B) Solo recorre el primer elemento
- C) Ordena la colección
- D) Elimina elementos mientras recorre

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Recorre todos sus elementos sin gestionar un índice

El for-each simplifica el recorrido de colecciones, sin manejar un contador de índice.

</details>

**8. ¿Qué devuelve el método size() de un ArrayList?**

- A) El tamaño máximo que puede alcanzar
- B) El número de elementos que contiene actualmente
- C) La posición del último elemento
- D) La capacidad reservada en memoria

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) El número de elementos que contiene actualmente

size() devuelve el número de elementos actualmente almacenados.

</details>

**9. ¿Cómo se elimina el elemento en la posición 2 de un ArrayList llamado lista?**

- A) lista.delete(2);
- B) lista.remove(2);
- C) lista.erase(2);
- D) lista[2] = null;

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) lista.remove(2);

El método remove(indice) elimina el elemento situado en esa posición.

</details>

**10. ¿Qué representan tres ArrayList "paralelos" (nombres, precios, stocks) en el mismo índice i?**

- A) Tres copias del mismo dato
- B) Los datos de un mismo producto repartidos en varias listas
- C) Tres productos distintos
- D) Un error que Java no permite

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Los datos de un mismo producto repartidos en varias listas

En listas paralelas, la posición i de cada lista corresponde a un mismo elemento.

</details>

**11. ¿Por qué conviene sustituir las listas paralelas por una clase Producto en la siguiente UT?**

- A) Porque Java no permite varias ArrayList a la vez
- B) Porque agrupa los datos relacionados de un mismo elemento en un solo objeto
- C) Porque los ArrayList dejan de funcionar con muchos datos
- D) No hay ninguna ventaja real

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Porque agrupa los datos relacionados de un mismo elemento en un solo objeto

Agrupar los datos relacionados en una clase evita tener que mantener sincronizadas varias listas.

</details>

### UT5. Métodos y modularización

*RA3 · 6 horas (T: 1.5 / P: 4.5) · Semanas 13 – 15*

**Contenidos**

- Definición e invocación de métodos. Paso de parámetros.
- Métodos con valor de retorno. Sobrecarga de métodos.
- Ámbito (scope) de las variables locales.
- Modularización del programa: mostrarMenu(), listarProductos(), calcularValorTotal()...

**Ejercicios cortos de clase**

- **Completar código:** Completar la cabecera de un método que reciba un ArrayList<Integer> y devuelva un double.
- **Encontrar el error:** Localizar el fallo en un método declarado void que intenta usar return con un valor.
- **Escribir un bloque:** Escribir el método mostrarMenu() que imprima las tres opciones del programa.

**Avance del proyecto — El programa se modulariza en métodos**

```java
public static double calcularValorTotal(ArrayList<Double> precios,
                                         ArrayList<Integer> stocks) {
    double total = 0;
    for (int i = 0; i < precios.size(); i++) {
        total += precios.get(i) * stocks.get(i);
    }
    return total;
}

public static void listarProductos(ArrayList<String> nombres,
                                    ArrayList<Double> precios,
                                    ArrayList<Integer> stocks) {
    for (int i = 0; i < nombres.size(); i++) {
        System.out.printf("%s - %.2f eur - %d uds.%n",
            nombres.get(i), precios.get(i), stocks.get(i));
    }
}
```

**Autoevaluación UT5** *(11 ítems, opción múltiple, autocorregible)*

**1. ¿Qué palabra indica que un método no devuelve ningún valor?**

- A) null
- B) void
- C) empty
- D) none

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) void

void indica que el método no devuelve ningún valor al terminar su ejecución.

</details>

**2. ¿Qué es un parámetro de un método?**

- A) El resultado que devuelve
- B) Un valor que se le pasa para que trabaje con él
- C) El nombre del método
- D) Una variable global

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Un valor que se le pasa para que trabaje con él

Los parámetros son los datos de entrada que recibe un método al ser invocado.

</details>

**3. ¿Qué es la sobrecarga de métodos (overload)?**

- A) Definir dos métodos con el mismo nombre pero distintos parámetros
- B) Ejecutar un método muchas veces
- C) Usar demasiadas variables
- D) Redefinir un método heredado

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Definir dos métodos con el mismo nombre pero distintos parámetros

La sobrecarga permite varios métodos con el mismo nombre, si difieren en el número o tipo de parámetros.

</details>

**4. ¿Qué instrucción se usa para devolver un valor desde un método?**

- A) give
- B) return
- C) output
- D) result

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) return

return finaliza la ejecución del método y devuelve el valor indicado.

</details>

**5. ¿Qué es el ámbito (scope) de una variable local?**

- A) Todo el programa
- B) Únicamente el bloque donde se ha declarado
- C) Solo la clase Main
- D) Depende de si es pública

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Únicamente el bloque donde se ha declarado

Una variable local solo existe dentro del bloque en el que se declara.

</details>

**6. ¿Por qué conviene extraer código repetido a un método?**

- A) Para que el programa ocupe más líneas
- B) Para reutilizar código y facilitar su mantenimiento
- C) Porque Java lo obliga
- D) No aporta ninguna ventaja

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Para reutilizar código y facilitar su mantenimiento

Modularizar en métodos evita duplicar código y facilita corregirlo en un único lugar.

</details>

**7. public static double calcularValorTotal(...) ¿qué tipo de dato devuelve?**

- A) void
- B) ArrayList
- C) double
- D) int

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: C) double

El tipo indicado antes del nombre del método (double) es el que devuelve.

</details>

**8. ¿Qué palabra clave indica que un método pertenece a la clase y no a un objeto concreto?**

- A) public
- B) static
- C) void
- D) final

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) static

static indica que el método pertenece a la clase en sí, invocable sin crear un objeto.

</details>

**9. ¿Qué ocurre si se llama a un método con menos parámetros de los que espera?**

- A) Java los rellena automáticamente
- B) El programa no compila
- C) Se ejecuta con valores por defecto
- D) Se lanza una excepción

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) El programa no compila

Si la llamada no coincide con ninguna firma del método, el código no compila.

</details>

**10. ¿Qué significa que los tipos primitivos se pasen "por valor" a un método?**

- A) El método recibe una copia del valor original
- B) El método modifica siempre la variable original
- C) No se pueden pasar como parámetro
- D) Se pasa por referencia

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) El método recibe una copia del valor original

Con tipos primitivos, el método trabaja sobre una copia; los cambios no afectan a la variable original.

</details>

**11. ¿Qué ventaja aporta dividir el programa en métodos con una responsabilidad concreta?**

- A) Ninguna, solo complica el código
- B) Cada método es más fácil de probar y corregir
- C) El programa se ejecuta más rápido siempre
- D) Evita tener que usar bucles

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Cada método es más fácil de probar y corregir

Dividir el programa en métodos con una única responsabilidad facilita su lectura y mantenimiento.

</details>

### UT6. Programación orientada a objetos I: clases y objetos

*RA4 · 8 horas (T: 2 / P: 6) · Semanas 16 – 19*

**Contenidos**

- Concepto de clase y objeto. Atributos y constructores.
- Métodos de instancia. Encapsulación: private, getters y setters.
- La palabra clave this. El método toString().
- Colecciones de objetos: ArrayList<Producto>.

**Ejercicios cortos de clase**

- **Completar código:** Completar el constructor de la clase Producto.
- **Encontrar el error:** Localizar el fallo de encapsulación: un atributo declarado public en vez de private.
- **Escribir un bloque:** Escribir el método toString() de la clase Producto.

**Avance del proyecto — El inventario pasa a estar orientado a objetos**

```java
public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public double getValorTotal() {
        return precio * stock;
    }

    @Override
    public String toString() {
        return nombre + " - " + precio + " eur - " + stock + " uds.";
    }
}

// En GestorInventario:
ArrayList<Producto> inventario = new ArrayList<>();
inventario.add(new Producto("Disco SSD 500GB", 45.90, 12));
```

**Autoevaluación UT6** *(13 ítems, opción múltiple, autocorregible)*

**1. ¿Qué es una clase en programación orientada a objetos?**

- A) Un objeto ya creado
- B) Una plantilla que define atributos y comportamiento de un tipo de objeto
- C) Un método especial
- D) Una variable global

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Una plantilla que define atributos y comportamiento de un tipo de objeto

La clase es el "molde" a partir del cual se crean los objetos (instancias).

</details>

**2. ¿Qué es un objeto?**

- A) Una instancia concreta de una clase
- B) Lo mismo que una clase
- C) Un tipo de dato primitivo
- D) Un método sin parámetros

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Una instancia concreta de una clase

Un objeto es una instancia concreta, creada a partir de una clase, con sus propios valores.

</details>

**3. ¿Qué es un constructor?**

- A) Un método que se ejecuta al crear un objeto, para inicializarlo
- B) El método principal del programa
- C) Un atributo especial
- D) Un tipo de bucle

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Un método que se ejecuta al crear un objeto, para inicializarlo

El constructor se ejecuta automáticamente al crear (instanciar) un objeto.

</details>

**4. ¿Qué palabra clave se usa para crear un nuevo objeto en Java?**

- A) create
- B) new
- C) make
- D) object

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) new

La palabra clave new invoca el constructor y crea una nueva instancia.

</details>

**5. ¿Qué es la encapsulación?**

- A) Ocultar los atributos y controlar el acceso a ellos mediante métodos
- B) Heredar de otra clase
- C) Tener muchos métodos en una clase
- D) Declarar todos los atributos como públicos

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Ocultar los atributos y controlar el acceso a ellos mediante métodos

La encapsulación protege los atributos (normalmente private) y controla su acceso.

</details>

**6. ¿Para qué sirve un método getter?**

- A) Para modificar el valor de un atributo
- B) Para consultar el valor de un atributo privado
- C) Para eliminar un atributo
- D) Para crear un nuevo objeto

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Para consultar el valor de un atributo privado

Un getter devuelve el valor actual de un atributo, normalmente privado.

</details>

**7. ¿Qué modificador de acceso se usa habitualmente para proteger los atributos de una clase?**

- A) public
- B) private
- C) static
- D) void

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) private

private impide el acceso directo al atributo desde fuera de la clase.

</details>

**8. ¿Para qué se sobrescribe el método toString()?**

- A) Para comparar dos objetos
- B) Para definir cómo se representa un objeto como texto
- C) Para copiar el objeto
- D) Para eliminar el objeto de memoria

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Para definir cómo se representa un objeto como texto

Sobrescribir toString() personaliza el texto que se muestra al imprimir un objeto.

</details>

**9. ¿Qué hace this dentro de un constructor?**

- A) Hace referencia al objeto que se está creando
- B) Crea una nueva clase
- C) Llama al método main
- D) Elimina el objeto actual

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Hace referencia al objeto que se está creando

this se refiere al propio objeto, útil para diferenciar un atributo de un parámetro homónimo.

</details>

**10. ¿Qué anotación indica que un método sobrescribe uno de la clase base?**

- A) @Override
- B) @Inherit
- C) @Method
- D) @Class

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) @Override

@Override indica al compilador que ese método sobrescribe uno heredado.

</details>

**11. ¿Qué contendrá un ArrayList<Producto> tras añadir varios objetos Producto?**

- A) Los nombres como texto
- B) Referencias a los objetos Producto creados
- C) Solo el primer producto
- D) Los precios de los productos

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Referencias a los objetos Producto creados

Un ArrayList<Producto> almacena referencias a objetos completos.

</details>

**12. ¿Qué ventaja tiene una clase Producto frente a las listas paralelas de la UT4?**

- A) Agrupa los datos de cada producto, evitando desincronizaciones
- B) Ocupa menos líneas siempre
- C) Java lo exige a partir de cierto número de productos
- D) No hay ninguna diferencia

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Agrupa los datos de cada producto, evitando desincronizaciones

Cada objeto Producto agrupa sus propios datos, evitando que las listas paralelas se desincronicen.

</details>

**13. ¿Qué método llamarías para conocer el valor total de existencias (precio × stock) de un Producto?**

- A) Un getter como getValorTotal(), si está definido en la clase
- B) No es posible calcularlo desde un objeto
- C) Solo se puede calcular en el método main
- D) toString()

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Un getter como getValorTotal(), si está definido en la clase

Definir getValorTotal() en la propia clase permite que cada objeto calcule su valor total.

</details>

### UT7. Programación orientada a objetos II: herencia y polimorfismo

*RA4 · 8 horas (T: 2 / P: 6) · Semanas 20 – 23*

**Contenidos**

- Herencia: extends, super(). Superclases y subclases.
- Sobrescritura de métodos heredados con @Override.
- Polimorfismo: tratamiento uniforme de objetos de distinto tipo.
- Atributos protected: acceso desde las subclases.

**Ejercicios cortos de clase**

- **Completar código:** Completar la cabecera de la subclase MemoriaRAM que extiende de ComponenteInformatico.
- **Encontrar el error:** Localizar por qué el constructor de una subclase deja sin inicializar los atributos heredados (falta la llamada a super()).
- **Escribir un bloque:** Escribir el método describir() sobrescrito para la clase TarjetaGrafica.

**Avance del proyecto — Distintos tipos de componentes, un mismo tratamiento**

```java
public class ComponenteInformatico {
    protected String nombre;
    protected double precio;

    public ComponenteInformatico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String describir() {
        return nombre + " - " + precio + " eur";
    }
}

public class TarjetaGrafica extends ComponenteInformatico {
    private int memoriaVRAM;

    public TarjetaGrafica(String nombre, double precio, int memoriaVRAM) {
        super(nombre, precio);
        this.memoriaVRAM = memoriaVRAM;
    }

    @Override
    public String describir() {
        return nombre + " (" + memoriaVRAM + " GB VRAM) - " + precio + " eur";
    }
}

// En GestorInventario, recorrido polimorfico:
for (ComponenteInformatico c : catalogo) {
    System.out.println(c.describir());
}
```

**Autoevaluación UT7** *(13 ítems, opción múltiple, autocorregible)*

**1. ¿Qué es la herencia en programación orientada a objetos?**

- A) Copiar el código de una clase en otra manualmente
- B) Crear una clase que reutiliza y extiende otra
- C) Eliminar una clase
- D) Un tipo de bucle

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Crear una clase que reutiliza y extiende otra

La herencia permite que una subclase reutilice y amplíe atributos y métodos de una superclase.

</details>

**2. ¿Qué palabra clave se usa en Java para heredar de otra clase?**

- A) inherits
- B) extends
- C) implements
- D) super

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) extends

extends se utiliza para indicar que una clase hereda de otra.

</details>

**3. ¿Qué hace super() dentro de un constructor?**

- A) Llama al constructor de la superclase
- B) Crea una nueva subclase
- C) Elimina la herencia
- D) Es equivalente a this

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Llama al constructor de la superclase

super() invoca el constructor de la clase de la que se hereda.

</details>

**4. ¿Qué es sobrescribir (@Override) un método?**

- A) Definir un método nuevo con distinto nombre
- B) Redefinir en la subclase el comportamiento de un método heredado
- C) Eliminar un método heredado
- D) Duplicar un método dentro de la misma clase

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Redefinir en la subclase el comportamiento de un método heredado

Sobrescribir significa dar, en la subclase, una implementación distinta a un método que ya existía en la superclase.

</details>

**5. Si TarjetaGrafica hereda describir() de ComponenteInformatico y no lo sobrescribe, ¿qué versión se ejecuta al llamarlo?**

- A) La de la superclase, tal cual
- B) El código no compila
- C) La de otra subclase
- D) Ninguna: hay que sobrescribirlo siempre

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) La de la superclase, tal cual

Si una subclase no sobrescribe un método heredado, se ejecuta la implementación de la superclase.

</details>

**6. ¿Qué es el polimorfismo?**

- A) Que distintos objetos respondan de forma diferente a la misma llamada de método
- B) Que una clase tenga muchos atributos
- C) Que un método tenga muchos parámetros
- D) Usar muchas clases en un programa

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Que distintos objetos respondan de forma diferente a la misma llamada de método

El polimorfismo permite tratar distintos objetos de forma uniforme, aunque cada uno responda distinto.

</details>

**7. Al llamar a describir() sobre elementos de ArrayList<ComponenteInformatico>, ¿qué ocurre?**

- A) Da error, la lista es de tipo ComponenteInformatico
- B) Se ejecuta la versión de cada subclase concreta
- C) Siempre se ejecuta la misma versión
- D) Solo funciona con el primer elemento

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Se ejecuta la versión de cada subclase concreta

Gracias al polimorfismo, se ejecuta la versión sobrescrita (o heredada) correspondiente a la clase real de cada objeto.

</details>

**8. ¿Cuántas superclases directas puede tener una clase en Java?**

- A) Tantas como se quiera
- B) Como máximo una
- C) Ninguna
- D) Depende del proyecto

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Como máximo una

Java solo permite herencia simple: una clase puede extender, como máximo, una única superclase.

</details>

**9. ¿Por qué los atributos de ComponenteInformatico se declaran protected en vez de private?**

- A) Para que las subclases puedan acceder a ellos directamente
- B) Porque private no existe en Java
- C) Para que sean accesibles desde cualquier otra clase del programa
- D) Es indiferente, no cambia nada

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Para que las subclases puedan acceder a ellos directamente

protected permite que las subclases accedan a esos atributos heredados directamente, a diferencia de private.

</details>

**10. ¿Qué ventaja aporta anotar un método con @Override?**

- A) Ninguna, es solo decorativo
- B) El compilador avisa si en realidad no se está sobrescribiendo ningún método de la superclase
- C) Hace que el método se ejecute más rápido
- D) Convierte el método en estático

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) El compilador avisa si en realidad no se está sobrescribiendo ningún método de la superclase

@Override ayuda a detectar errores: si el método no coincide con uno de la superclase, el compilador lo señala.

</details>

**11. ¿Qué representa la relación "TarjetaGrafica es un ComponenteInformatico"?**

- A) Una relación de herencia (es-un)
- B) Una relación de composición
- C) Un error de diseño
- D) Una sobrecarga de métodos

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Una relación de herencia (es-un)

Cuando una subclase hereda de una superclase, mantiene una relación "es-un" con ella.

</details>

**12. ¿Qué ocurre si TarjetaGrafica y MemoriaRAM sobrescriben describir() cada una a su manera?**

- A) Da un error, deben coincidir
- B) Cada una se describe de forma distinta, adaptada a sus propios atributos
- C) Solo una de las dos puede sobrescribirlo
- D) Java lo prohíbe si heredan de la misma clase

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Cada una se describe de forma distinta, adaptada a sus propios atributos

Cada subclase puede dar su propia versión de un método heredado, ajustada a sus propios atributos, sin ningún conflicto.

</details>

**13. ¿Qué ventaja aporta el polimorfismo al recorrer ArrayList<ComponenteInformatico>?**

- A) Permite tratar componentes distintos de forma uniforme, sin comprobar su tipo uno a uno
- B) Obliga a usar un switch para cada tipo
- C) Hace que el bucle se ejecute más rápido
- D) Elimina la necesidad de una superclase común

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Permite tratar componentes distintos de forma uniforme, sin comprobar su tipo uno a uno

El mismo código de recorrido sirve para cualquier subclase, sin distinguir el tipo concreto de cada objeto.

</details>

### UT8. Excepciones, documentación y cierre del proyecto

*RA5 · 4 horas (T: 1.5 / P: 2.5) · Semanas 24 – 25*

**Contenidos**

- Tratamiento de excepciones: try-catch-finally. Excepciones comunes (InputMismatchException).
- Creación de excepciones personalizadas (extends Exception). La instrucción throw.
- Comentarios y documentación básica con Javadoc.
- Buenas prácticas de codificación. Revisión y entrega final del proyecto.

**Ejercicios cortos de clase**

- **Completar código:** Completar un bloque try-catch que capture InputMismatchException al leer el stock.
- **Encontrar el error:** Localizar un bloque catch que captura un tipo de excepción distinto del que realmente se produce.
- **Escribir un bloque:** Escribir la clase StockInvalidoException, que extienda de Exception.

**Avance del proyecto — Cierre del proyecto: entrada robusta y excepciones propias**

```java
public class StockInvalidoException extends Exception {
    public StockInvalidoException(String mensaje) {
        super(mensaje);
    }
}

// En GestorInventario:
try {
    System.out.print("Introduce el nuevo stock: ");
    int nuevoStock = teclado.nextInt();
    if (nuevoStock < 0) {
        throw new StockInvalidoException("El stock no puede ser negativo.");
    }
    stock = nuevoStock;
} catch (InputMismatchException e) {
    System.out.println("Error: debes introducir un numero entero.");
    teclado.nextLine();
} catch (StockInvalidoException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Autoevaluación UT8** *(10 ítems, opción múltiple, autocorregible)*

**1. ¿Qué es una excepción en Java?**

- A) Un tipo de bucle especial
- B) Un evento que interrumpe el flujo normal del programa, normalmente por un error
- C) Un comentario del código
- D) Un método privado

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Un evento que interrumpe el flujo normal del programa, normalmente por un error

Una excepción representa una situación anómala que interrumpe el flujo normal de ejecución.

</details>

**2. ¿Qué bloque se usa para capturar una excepción?**

- A) try-catch
- B) if-else
- C) do-while
- D) switch-case

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) try-catch

El bloque try-catch permite intentar ejecutar un código y capturar la excepción si se produce.

</details>

**3. ¿Qué excepción se lanza si se intenta leer un entero con nextInt() y el usuario escribe texto?**

- A) NumberFormatException
- B) InputMismatchException
- C) NullPointerException
- D) ArrayIndexOutOfBoundsException

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) InputMismatchException

Scanner lanza InputMismatchException cuando el dato leído no coincide con el tipo esperado.

</details>

**4. ¿Qué código se ejecuta siempre, haya o no excepción, si se usa finally?**

- A) El código dentro de finally
- B) Solo el código del try
- C) Solo el código del catch
- D) Ninguno

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) El código dentro de finally

El bloque finally se ejecuta siempre, se produzca o no una excepción.

</details>

**5. ¿Cómo se crea una excepción personalizada en Java?**

- A) No es posible, solo las de Java
- B) Creando una clase que extienda de Exception
- C) Usando la palabra clave custom
- D) Sobrescribiendo el método main

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Creando una clase que extienda de Exception

Una excepción personalizada se define como una clase propia que extiende de Exception.

</details>

**6. ¿Qué instrucción se usa para lanzar una excepción manualmente?**

- A) throw
- B) catch
- C) raise
- D) except

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) throw

throw se usa para lanzar una excepción de forma explícita desde el código.

</details>

**7. ¿Por qué conviene validar los datos introducidos por el usuario?**

- A) Para evitar que el programa falle o se comporte de forma inesperada
- B) Java lo hace siempre automáticamente
- C) Solo es necesario en programas muy grandes
- D) No influye en el funcionamiento del programa

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Para evitar que el programa falle o se comporte de forma inesperada

Validar la entrada evita errores en tiempo de ejecución y mejora la robustez del programa.

</details>

**8. ¿Qué es Javadoc?**

- A) Una herramienta que genera documentación a partir de comentarios especiales del código
- B) Un tipo de excepción
- C) Un IDE de Java
- D) Una librería de colecciones

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Una herramienta que genera documentación a partir de comentarios especiales del código

Javadoc genera documentación en HTML a partir de comentarios especiales (/** ... */).

</details>

**9. ¿Qué ayuda más a que otra persona entienda el código de GestorInventario?**

- A) Nombres claros de variables/métodos y comentarios donde aporten valor
- B) Escribir todo el programa en una sola línea
- C) Evitar el uso de métodos
- D) No usar nunca comentarios

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: A) Nombres claros de variables/métodos y comentarios donde aporten valor

Unos nombres descriptivos y comentarios bien situados facilitan entender y mantener el código.

</details>

**10. Al finalizar la UT8, ¿qué reúne ya el proyecto GestorInventario?**

- A) Solo variables básicas y un menú simple
- B) Elementos básicos, control de flujo, colecciones, métodos, POO y excepciones
- C) Únicamente clases, sin bucles
- D) Solo el tratamiento de excepciones

<details>
<summary>Ver respuesta correcta y explicación</summary>

Correcta: B) Elementos básicos, control de flujo, colecciones, métodos, POO y excepciones

El proyecto ha ido incorporando, UT a UT, todos los contenidos del módulo.

</details>

## 6. Metodología y criterios de calificación

Cada sesión semanal combina una breve explicación de los contenidos nuevos con la realización guiada de ejercicios cortos (completar código, encontrar el error, escribir un pequeño bloque) y el avance correspondiente del proyecto GestorInventario, que se corrige en el aula. Dado el escaso número de horas lectivas disponibles, se prioriza la práctica guiada frente a la exposición teórica extensa, reservando la teoría a lo estrictamente necesario para abordar cada avance del proyecto.

**Instrumentos de evaluación**

- Autoevaluaciones autocorregibles al final de cada UT (tipo test, 10-15 ítems).
- Ejercicios cortos realizados y corregidos en cada sesión.
- Avance semanal del proyecto GestorInventario, revisado UT a UT.
- Entrega final del proyecto completo al cierre de la UT8.

**Ponderación de la calificación**

| Instrumento | Peso |
|---|---|
| Autoevaluaciones de cada UT | 20% |
| Ejercicios cortos y participación en clase | 25% |
| Avance semanal del proyecto GestorInventario | 25% |
| Entrega final del proyecto | 30% |

La nota de cada RA se obtiene a partir de los instrumentos de evaluación de las UT que lo desarrollan. Para superar el módulo será necesario obtener una calificación igual o superior a 5 sobre 10 en cada uno de los cinco resultados de aprendizaje.
