<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>  

<!--# De la idea al código: tus primeros algoritmos con **la estructura de 5 bloques**

1. Introducción: El Lienzo en Blanco del Programador

Todo programador principiante ha sentido esa parálisis frente al lienzo en blanco: tienes un problema que resolver, pero no sabes por dónde empezar a escribir. Es una sensación de caos que puede ser frustrante. Sin embargo, para los problemas que se resuelven con una secuencia de pasos directos, existe una estructura fundamental y rigurosa de cinco bloques que actúa como una guía infalible. Este método convierte el desorden en un proceso claro y ordenado, dándote la confianza para construir tus primeros algoritmos secuenciales.

2. La Estructura Fundamental: Los 5 Bloques del Algoritmo Secuencial

Para resolver problemas sencillos utilizando pseudocódigo, es necesario seguir un método claro definido por cinco bloques principales. Esta estructura es la base para escribir código limpio y lógico desde el principio, pero es crucial entender su alcance: está diseñada específicamente para algoritmos con una estructura de control secuencial. Esto significa que las instrucciones se ejecutan una después de la otra, en orden, sin saltos, decisiones ni repeticiones. Es el punto de partida fundamental antes de aprender estructuras más complejas.

1. El Bloque de Inicio: Marcando el Punto de Partida

Este es el primer bloque requerido en cualquier algoritmo. Aunque pueda parecer obvio, marcar explícitamente el inicio es crucial. Este paso actúa como una bandera que le dice a cualquiera que lea tu código (incluido tu futuro yo) "aquí es donde comienza toda la lógica". Delimita claramente el punto de partida y establece un marco formal para tu solución.

2. La Declaración de Variables: Definiendo tus Herramientas

Este bloque es donde defines todas las variables que tu programa utilizará. Piénsalo como listar todos tus ingredientes antes de empezar a cocinar. Tener un inventario claro de los datos que vas a manejar es una buena práctica fundamental que organiza el código y mejora su legibilidad. Un hábito que te ahorrará horas de frustración es declarar siempre tus variables aquí. Resistir la tentación de crearlas sobre la marcha te convertirá en un programador más disciplinado.

3. La Inicialización: Dando un Valor Inicial

Una vez que has listado tus "ingredientes" en el bloque anterior, el siguiente paso es darles un valor inicial. Este paso es fundamental para asegurar que tu programa se comporte de manera predecible. Sin una inicialización adecuada, las variables podrían contener valores "basura" que llevarían a cálculos incorrectos. Este paso le da un punto de partida confiable a las "herramientas" que definiste, asegurando que tu proceso no comience con caos. Advertencia de mentor: Un programa que funciona a veces sí y a veces no, a menudo sufre de variables no inicializadas. ¡No te saltes este paso jamás!

4. El Proceso: El Cerebro del Algoritmo

Este bloque es el motor de tu programa. Es la receta misma: aquí ejecutas la secuencia de comandos que transforma tus datos iniciales en una respuesta útil. Gracias a que declaraste e inicializaste tus variables correctamente, este bloque puede centrarse al 100% en la lógica de la solución, sin preocuparse por de dónde vienen los datos o si son válidos. Los bloques anteriores preparan el terreno para que aquí te concentres exclusivamente en resolver el problema.

5. La Salida: Mostrando el Resultado

Este es el bloque final y el objetivo de todo tu trabajo. Una vez que el proceso ha calculado la solución, necesitas mostrar ese resultado al usuario. La salida (u output) es el bloque donde comunicas la respuesta. Al fin y al cabo, el propósito de cualquier algoritmo es entregar un resultado tangible, y este bloque se encarga de cumplir con esa misión.

3. El Ingrediente Secreto: Piensa de Forma Visual

Un consejo clave para dominar esta estructura es pensar en ella de forma visual. Dibuja cinco cajas en un papel, una debajo de la otra. Etiqueta cada una: Inicio, Variables, Inicialización, Proceso y Salida. Antes de escribir una sola línea de pseudocódigo, anota dentro de cada caja lo que necesitas hacer. Esta simple técnica te obligará a pensar con orden y te ayudará a compartimentar el problema, enfocándote en una sola tarea a la vez y asegurando que no te saltes ningún paso crítico.

4. Conclusión: Tu Primer Paso Hacia el Código Limpio

La estructura de cinco bloques te proporciona una hoja de ruta clara y confiable para transformar un problema en una solución algorítmica secuencial. Ya no tienes que enfrentarte al lienzo en blanco con incertidumbre. Siguiendo los pasos de Inicio, Declaración, Inicialización, Proceso y Salida, tienes un método probado para construir código de manera ordenada y lógica, sentando las bases para retos de programación más complejos en el futuro.

¿Qué problema sencillo intentarás resolver ahora aplicando esta estructura de cinco bloques?

---  -->

## Método para Algoritmos de Control Secuencial *(Guía de estudio)*  

Esta guía presenta un **método estructurado para la creación de algoritmos y pseudocódigo** que utilizan exclusivamente la **estructura de control secuencial.** Un algoritmo con estructura de control secuencial es aquel cuyas instrucciones se ejecutan en un **orden estricto y predefinido, una tras otra, desde el principio hasta el final, sin saltos, bifurcaciones ni repeticiones.** Este método divide el algoritmo en **cinco bloques lógicos** y visuales para garantizar claridad y corrección.

El objetivo es proporcionar una guía clara y visual para resolver problemas sencillos, definiendo cada uno de los **cinco bloques fundamentales** del programa: *inicio, declaración de variables, inicialización, proceso y salida.*

### La estructura de 5 bloques  
##  

>1 - Bloque de **Inicio**
 
---

Toda solución algorítmica debe tener un punto de partida claramente definido. Este bloque marca el comienzo de la ejecución del programa.

- Propósito: Señalar el inicio formal del algoritmo.
- Pseudocódigo: Se representa comúnmente con la palabra **INICIO.**

##
>2 - Bloque de **Declaración de variables**
----

En este bloque se definen todas las variables que se utilizarán para almacenar datos a lo largo del programa. Declarar una variable significa asignarle un nombre y, en muchos lenguajes, un tipo de dato (ej. numérico, texto).

* Propósito: Reservar espacio en la memoria para los datos que el programa manipulará. Permite al programador y al sistema entender qué tipo de información contendrá cada variable.
* Pseudocódigo: Se suele usar la palabra DECLARAR seguida de los nombres de las variables y sus tipos.
  * Ejemplo: DECLARAR base, altura, area COMO NUMERICO

##
>3 - Bloque de **Inicialización** (o Entrada de datos)

Una vez declaradas, las variables a menudo necesitan un valor inicial para poder operar con ellas. Este valor puede ser asignado directamente en el código o puede ser solicitado al usuario.

* Propósito: Asignar los primeros valores a las variables. Es un paso crucial para evitar operar con datos indefinidos o "basura".
* Pseudocódigo: Implica solicitar datos (LEER) o asignar valores directamente (se suelen usar los caracteres ← o =).
  * Ejemplo pidiendo al usuario: LEER base, LEER altura
  * Ejemplo asignando directamente: base ← 10, altura ← 5

##
>4 - Bloque de **Proceso**

Este es el corazón del algoritmo. Aquí se realizan todas las operaciones, cálculos y transformaciones de datos necesarios para resolver el problema planteado, utilizando las variables declaradas e inicializadas.

* Propósito: Ejecutar la lógica de negocio del problema. Realizar los cálculos matemáticos o las manipulaciones de datos que llevarán a la solución.
* Pseudocódigo: Consiste en una o más expresiones de asignación donde se calcula un resultado y se guarda en una variable.
  * Ejemplo: area <- base * altura

##
>5 - Bloque de **Salida**

En el bloque final, el algoritmo presenta los resultados obtenidos al usuario. La salida debe ser clara y comprensible.

* Propósito: Mostrar al usuario el resultado de los cálculos o el estado final del proceso.
* Pseudocódigo: Se utilizan instrucciones como ESCRIBIR o MOSTRAR para presentar el contenido de las variables que contienen la solución.
  * Ejemplo: ESCRIBIR "El área del rectángulo es: ", area

Finalmente, todo algoritmo debe tener un punto de conclusión explícito.

* Pseudocódigo: **FIN**
---  


## Ejemplo 1: *Calcular el precio final de un producto con IVA*  
### Pseudocódigo  

```
// Bloque 1: Inicio (Indica el punto de comienzo del algoritmo/programa)
INICIO  

 // Bloque 2: Declaración de Variables
DECLARAR precioBase, iva, precioFinal COMO NUMERICO

//  Bloque 3: Inicialización / Entrada de Datos 
precioBase ← 85.50
IVA ← 21

// Bloque 4: Proceso
precioFinal ← precioBase + (precioBase * IVA / 100)

// Bloque 5: Salida
ESCRIBIR "Precio base: " + precioBase + "€"
ESCRIBIR "IVA aplicado: " + IVA + "%"
ESCRIBIR "Precio final: " + precioFinal + "€"
FIN
```

```
INICIO
    DEFINIR precio, ivaAplicado, precioFinal COMO REAL
    DEFINIR IVA COMO REAL ← 21

    ESCRIBIR "Introduce el precio del producto:"
    LEER precio

    ivaAplicado ← precio * IVA / 100
    precioFinal ← precio + ivaAplicado

    ESCRIBIR "El precio final con IVA es: ", precioFinal, " euros"
FIN
```  
### Java  
```java
import java.util.Scanner;

public class PrecioConIVA {

    public static void main(String[] args) {

        // Declaración de variables
        double precio;
        double ivaAplicado;
        double precioFinal;

        // Declaración de constantes
        final double IVA = 21.0;
        final int CIEN = 100;

        // Crear Scanner para entrada por teclado
        Scanner teclado = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Introduce el precio del producto: ");
        precio = teclado.nextDouble();

        // Cálculos
        ivaAplicado = precio * IVA / CIEN;
        precioFinal = precio + ivaAplicado;

        // Mostrar resultado
        System.out.println("El precio final con IVA es: " + precioFinal + " euros");

        // Cerrar Scanner
        teclado.close();
    }
}
```
>Prueba el código aquí: *[Online Java Compiler IDE](https://www.jdoodle.com/ia/1Pk1)*
  
## Ejemplo 2: *Calcular el precio final de un producto con Descuento*

### Pseudocódigo

```
INICIO
    DEFINIR precio, descuento, descuentoAplicado, precioFinal COMO REAL

    ESCRIBIR "Introduce el precio del producto:"
    LEER precio

    ESCRIBIR "Introduce el descuento en porcentaje:"
    LEER descuento

    descuentoAplicado ← precio * descuento / 100
    precioFinal ← precio - descuentoAplicado

    ESCRIBIR "El precio final es: ", precioFinal, " euros"
FIN  
```  
### Java  
```java
import java.util.Scanner;

public class PrecioConDescuento {

    public static void main(String[] args) {

        // Declaración de variables
        double precio;
        double descuento;
        double descuentoAplicado;
        double precioFinal;

        // Declaración de constantes
        final int CIEN = 100;

        // Crear Scanner para entrada por teclado
        Scanner teclado = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Introduce el precio del producto: ");
        precio = teclado.nextDouble();

        System.out.print("Introduce el descuento (%): ");
        descuento = teclado.nextDouble();

        // Cálculos
        descuentoAplicado = precio * descuento / CIEN;
        precioFinal = precio - descuentoAplicado;

        // Mostrar resultado
        System.out.println("El precio final es: " + precioFinal + " euros");

        // Cerrar Scanner
        teclado.close();
    }
}

```
>Prueba el código aquí: *[Online Java Compiler IDE](https://www.jdoodle.com/ia/1PjS)*



## Ejemplo 3: *Calcular el precio final de un producto con Descuento e IVA*  
### Pseudocódigo 
```
// Bloque 1: Inicio

 // Bloque 2: Declaración de Variables

//  Bloque 3: Inicialización / Entrada de Datos 

// Bloque 4: Proceso

// Bloque 5: Salida

```
### Java  
```
// Bloque 1: Inicio

 // Bloque 2: Declaración de Variables

//  Bloque 3: Inicialización / Entrada de Datos 

// Bloque 4: Proceso

// Bloque 5: Salida

```
#



### Test de comprensión  
---  
Responde brevemente a las siguientes preguntas, basándote en el método descrito anteriormente.

1. ¿Por qué es importante tener un bloque de "Declaración de Variables" separado antes del "Proceso"?
2. Describe la diferencia principal entre la declaración y la inicialización de una variable.
3. ¿Qué tipo de operaciones se llevan a cabo típicamente en el bloque de "Proceso"?
4. ¿Cuál es el objetivo del bloque de "Salida" y por qué es crucial para el usuario?
5. Si un algoritmo no tuviera un bloque de "Inicialización", ¿qué problema potencial podría ocurrir durante el "Proceso"?
6. ¿Qué representan las palabras INICIO y FIN en el pseudocódigo?
7. En el ejemplo anterior del *cálculo del precio con IVA*, ¿qué instrucción pertenece al bloque de "Proceso" y qué hace exactamente?
8. ¿Podría un algoritmo secuencial simple funcionar sin un bloque de "Entrada de Datos"? Justifique su respuesta.

<!--
Clave de respuestas

1. El propósito de la estructura de control secuencial es asegurar que las instrucciones de un algoritmo se ejecuten en un orden estricto y predefinido, una después de la otra. Esto proporciona una base lógica y predecible para resolver problemas simples sin desviaciones ni repeticiones.
2. Separar la declaración de variables permite organizar el código y definir todos los datos necesarios antes de comenzar a manipularlos. Esto mejora la legibilidad y ayuda a prevenir errores, como usar una variable que no ha sido definida previamente en el programa.
3. La declaración reserva el nombre y el tipo de una variable en la memoria, pero no le asigna un valor concreto. La inicialización es el acto de asignar un primer valor a esa variable, ya sea directamente en el código o a través de la entrada del usuario.
4. En el bloque de "Proceso" se realizan las operaciones lógicas y matemáticas que transforman los datos de entrada en resultados. Esto incluye cálculos, asignaciones de nuevos valores y cualquier manipulación de datos que sea central para la solución del problema.
5. El objetivo del bloque de "Salida" es comunicar los resultados del algoritmo al usuario de una manera clara y comprensible. Es crucial porque, sin él, el usuario no tendría forma de saber si el programa completó su tarea con éxito ni cuál fue la solución encontrada.
6. Si no hubiera un bloque de "Inicialización", las variables podrían contener valores indefinidos o "basura" de la memoria. Al intentar operar con ellas en el bloque de "Proceso", los cálculos producirían resultados incorrectos o impredecibles, llevando a un fallo lógico del programa.
7. Las palabras INICIO y FIN actúan como delimitadores formales del algoritmo. INICIO marca el punto de partida exacto de la ejecución de las instrucciones, mientras que FIN señala la conclusión del programa.
8. La instrucción del bloque de "Proceso" es area <- base * altura. Esta línea de código calcula el producto de las variables base y altura y asigna el resultado de esa operación a la variable area.
9. Sí, un algoritmo podría funcionar sin un bloque de "Entrada de Datos" si los valores iniciales de las variables se asignan directamente en el código (hardcoding). Por ejemplo, base <- 10 en lugar de LEER base, lo que haría que el algoritmo siempre calcule el resultado para los mismos valores predefinidos.
10. Se considera "visual" porque divide el código en secciones lógicas claramente delimitadas y con un propósito único. Esta separación (Inicio, Declaración, Entrada, Proceso, Salida) crea una estructura fácil de seguir con la vista, similar a un formulario o una receta, mejorando la comprensión y facilitando la depuración.


--------------------------------------------------------------------------------
-->

### Preguntas de ensayo
---

1. Explica con tus propias palabras la importancia de seguir un método estructurado, como el presentado, para escribir algoritmos, incluso para problemas muy sencillos. ¿Qué beneficios aporta a largo plazo para un programador?
2. Desarrolla desde cero un algoritmo en pseudocódigo para resolver el siguiente problema: *Calcular el precio final de un producto después de aplicarle un 10% de descuento*. Asegúrese de utilizar y etiquetar cada uno de los cinco bloques del método secuencial.
3. Compara y contraste el bloque de "Proceso" con el bloque de "Salida". ¿Podría existir uno sin el otro en un algoritmo útil? Argumente su respuesta.
4. Imagina un problema más complejo, como "calcular la ruta más corta entre dos puntos en un mapa". ¿Por qué la estructura de control secuencial por sí sola sería insuficiente para resolver este tipo de problema? ¿Qué otros tipos de estructuras de control serían necesarias?
5. Discute el papel de las variables en un algoritmo secuencial. ¿Cómo su correcta declaración e inicialización afectan la fiabilidad y correctitud del bloque de "Proceso" y del resultado final?

  
### Conceptos clave   

| Concepto/Término                  | Significado |
|-----------------------------------|------------|
| **Algoritmo**                     | Una secuencia finita y ordenada de instrucciones o pasos lógicos para resolver un problema específico o realizar una tarea. |
| **Pseudocódigo**                  | Una descripción de alto nivel de un algoritmo que utiliza un lenguaje natural mezclado con convenciones de lenguajes de programación, diseñado para ser leído por humanos. |
| **Estructura de Control Secuencial** | El tipo más simple de estructura de control, donde las instrucciones se ejecutan en el orden en que aparecen, una tras otra, sin posibilidad de salto o repetición. |
| **Variable**                      | Un espacio en la memoria del ordenador con un nombre simbólico que se utiliza para almacenar un dato o valor que puede cambiar durante la ejecución del programa. |
| **Declaración**                   | El proceso de definir una variable especificando su nombre y, a menudo, su tipo de dato, antes de que sea utilizada en el programa. |
| **Inicialización**                | El acto de asignar un valor inicial a una variable; puede ser un valor predefinido o proporcionado por el usuario. |
| **Proceso**                       | Sección del algoritmo donde se realizan las operaciones, cálculos y transformaciones de datos para convertir entradas en salidas. |
| **Salida**                        | El resultado o información que un programa devuelve al usuario u otro sistema tras completar su proceso. |
| **Entrada**                       | Los datos que un programa recibe del exterior (normalmente del usuario) para poder procesarlos. |
| **Inicio / Fin**                  | Marcadores que definen explícitamente el comienzo y el final de la ejecución de un algoritmo. |


