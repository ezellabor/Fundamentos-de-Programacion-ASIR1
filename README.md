# UT 1 - Identificadores, variables y constantes
<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>
 
---

<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> Lo que sabrás hacer al finalizar esta unidad</h2>
<ul>
<li><b>RA1:</b> Reconocer los elementos y estructuras básicas de un programa informático.</li>
<li><b>RA2:</b> Escribir programas sencillos aplicando buenas prácticas en el uso de variables y constantes.</li>
</ul>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;"> Objetivos</h2>
<ul>
<li>Comprender qué son las variables y las constantes.</li>
<li>Aprender a elegir identificadores válidos y descriptivos.</li>
<li>Diferenciar entre tipos de datos: numéricos, texto, booleanos.</li>
<li>Aplicar estos conceptos en pequeños algoritmos prácticos.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;"> Conceptos clave</h2>

<p><b>Identificadores →</b> Son los nombres que damos a variables, constantes o algoritmos. Ejemplo: <code>nombreUsuario</code>, <code>precioTotal</code>, <code>edad</code>.</p>

<p><b>Variables →</b> Almacenan datos que van cambiando durante la ejecución del programa.</p>
<quote>Ejemplo:</quote>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
 Algoritmo EjemploVariable
   Definir <span style="color:#cc3300;">edad</span> Como Entero
   <span style="color:#cc3300;">edad</span> <- 18
   <span style="color:#cc3300;">edad</span> <- <span style="color:#cc3300;">edad</span> + 1  // ahora <span style="color:#cc3300;">edad</span> vale 19
   Escribir <span style="color:#cc3300;">edad</span>
FinAlgoritmo
</pre>

<p><b>Constantes →</b> Almacenan valores que no cambian durante todo el programa.</p>
<quote>Ejemplo:</quote>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Const <span style="color:#0033cc;">IVA</span> <- 0.21
precioFinal <- precio * (1 + <span style="color:#0033cc;">IVA</span>)
</pre>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> Desarrollo paso a paso</h2>

<h3>Paso 1: Declara tus primeras variables</h3>
<p>Abre PSeInt y crea un algoritmo llamado <b>Variables</b>:</p>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo Variables
   Definir <span style="color:#cc3300;">nombre</span> Como Cadena
   Definir <span style="color:#cc3300;">edad</span>, <span style="color:#cc3300;">altura</span> Como Real

   <span style="color:#cc3300;">nombre</span> <- "Ezequiel"
   <span style="color:#cc3300;">edad</span> <- 30
   <span style="color:#cc3300;">altura</span> <- 1.70

   Escribir "Hola, ", <span style="color:#cc3300;">nombre</span>
   Escribir "Tienes ", <span style="color:#cc3300;">edad</span>, " años y mides ", <span style="color:#cc3300;">altura</span>, " metros."
FinAlgoritmo
</pre>
<p>Ejecuta y observa la salida. Reflexiona: ¿qué pasa si cambias <span style="color:#cc3300;">edad</span> por "veinte"?</p>
<p>_____________________________________________________________</p>

<h3>Paso 2: Añade una constante</h3>
<p>Define una constante llamada <span style="color:#0033cc;">IVA</span> con valor 0.21 y calcula el precio final:</p>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo CalculoIVA
   Const <span style="color:#0033cc;">IVA</span> <- 0.21
   Definir precioBase, precioFinal Como Real

   precioBase <- 100
   precioFinal <- precioBase * (1 + <span style="color:#0033cc;">IVA</span>)
   Escribir "El precio final es: ", precioFinal
FinAlgoritmo
</pre>
<p>Reflexiona: ¿Por qué <span style="color:#0033cc;">IVA</span> está en mayúsculas?</p>
<p>_____________________________________________________________</p>

<h3>Paso 3: Identificadores válidos </h3>
<p>Lista de ejemplos:</p>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#d9f2e6;">
<th style="border:1px solid #ccc; padding:4px;">Identificador</th>
<th style="border:1px solid #ccc; padding:4px;">¿Válido?</th>
<th style="border:1px solid #ccc; padding:4px;">Motivo</th>
</tr>
<tr><td style="border:1px solid #ccc; padding:4px;">2nombre</td><td style="border:1px solid #ccc; padding:4px;">❌</td><td>...</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">_usuario</td><td style="border:1px solid #ccc; padding:4px;">✅</td><td>...</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">nombre completo</td><td style="border:1px solid #ccc; padding:4px;">❌</td><td>...</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">precio_total</td><td style="border:1px solid #ccc; padding:4px;">✅</td><td>...</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Escribir</td><td style="border:1px solid #ccc; padding:4px;">❌</td><td></td></tr>
</table>

<!--<h3>Paso 4: Pequeño reto</h3>
<p>Crea un algoritmo que pida nombre, edad y año actual y muestre: "Hola, Alex. Naciste en 2005."</p>
<p>_____________________________________________________________<br>_____________________________________________________________<br>_____________________________________________________________</p>
</div>-->

---


<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Convenciones de código</h2>
 <ul>
<li>Uso de sangría</li>
<li>Uso de comentarios</li>
<li>Nombres estandarizados para variables y funciones</li>
<li>Usar nombres descriptivos y coherentes</li>
<li>Usar MAYÚSCULAS para las constantes</li>
</ul>
 </div>
 
 ---
 
 >Conjunto de reglas de estilo y prácticas que guían la escritura de código para que sea más legible, coherente y fácil de mantener

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;"> Ejercicios adicionales / Autoevaluación</h2>
<ol>
<li>Declara tres variables con tu nombre, edad y ciudad, y muéstralas.</li>
<li>Calcula el área de un rectángulo usando constantes para la base y la altura.</li>
<li>Corrige errores del siguiente algoritmo:</li>
</ol>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo Errores
   1edad <- 18
   Const IVA <- 21%
   precioTotal <- 100 * IVA
FinAlgoritmo
</pre>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> Sintesis </h2>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#ccece6;">
<th style="border:1px solid #ccc; padding:4px;">Concepto</th>
<th style="border:1px solid #ccc; padding:4px;">Descripción</th>
<th style="border:1px solid #ccc; padding:4px;">Ejemplo</th>
</tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Identificador</td><td style="border:1px solid #ccc; padding:4px;">Nombre de variable o constante</td><td style="border:1px solid #ccc; padding:4px;">nombre_usuario</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Variable</td><td style="border:1px solid #ccc; padding:4px;">Dato que puede cambiar</td><td style="border:1px solid #ccc; padding:4px;">edad <- 18</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Constante</td><td style="border:1px solid #ccc; padding:4px;">Dato fijo que no cambia</td><td style="border:1px solid #ccc; padding:4px;">PI <- 3.1416</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Tipo de dato</td><td style="border:1px solid #ccc; padding:4px;">Define el tipo de valor</td><td style="border:1px solid #ccc; padding:4px;">Entero, Real, Cadena, Lógico</td></tr>
</table>
</div>

---


# UT 2 – Tipos de datos y operadores
<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

---

<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Lo que sabrás hacer al finalizar esta unidad</h2>
<ul>
<li><b>RA1:</b> Comprender los tipos de datos y su uso en pseudocódigo.</li>
<li><b>RA2:</b> Aplicar operadores aritméticos, lógicos y relacionales en problemas sencillos.</li>
</ul>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Objetivos</h2>
<ul>
<li>Conocer tipos de datos básicos en pseudocódigo.</li>
<li>Usar operadores aritméticos, relacionales y lógicos.</li>
<li>Comprender cómo afectan los tipos de datos a los resultados.</li>
<li>Aplicar operadores en algoritmos sencillos.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Conceptos clave</h2>
<p><b>Tipos de datos:</b> Entero, Real, Cadena, Lógico</p>
<p><b>Operadores:</b></p>
<ul>
<li>Aritméticos: +, -, *, /, ^</li>
<li>Relacionales: =, <>, >, <, >=, <=</li>
<li>Lógicos: Y, O, NO</li>
</ul>

<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo OperadoresEjemplo
   Definir a, b Como Entero
   a <- 5
   b <- 3
   Escribir "Suma:", a + b
   Escribir "Multiplicación:", a * b
   Escribir "Mayor que:", a > b
   Escribir "Condición:", (a > b) Y (b < 10)
FinAlgoritmo
</pre>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Desarrollo paso a paso</h2>
</div>

Algoritmo SumaResta
   Definir x, y Como Entero
   x <- 10
   y <- 7
   Escribir "x+y =", x+y
   Escribir "x-y =", x-y
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 2: Operadores relacionales y lógicos</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo Condiciones
   Definir edad Como Entero
   edad <- 18
   Escribir "Mayor de edad:", edad>=18
   Escribir "Rango permitido:", (edad>=18) Y (edad<=65)
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 3: Reto</h3>
<p>Escribe un algoritmo que pida dos números y muestre cuál es mayor y si son iguales.</p>
<p>_____________________________________________________________<br>_____________________________________________________________<br>_____________________________________________________________</p>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Buenas prácticas</h2>
<ul>
<li>Los operadores deben usarse según el tipo de dato.</li>
<li>Los cálculos con Enteros y Reales pueden dar resultados distintos.</li>
<li>Las condiciones lógicas devuelven Verdadero/Falso.</li>
<li>Prueba varios ejemplos para comprobar resultados.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Ejercicios adicionales / Autoevaluación</h2>
<ol>
<li>Calcula el área de un triángulo usando variables y operadores.</li>
<li>Determina si un número es par o impar.</li>
<li>Usa operadores lógicos para validar si un número está entre 10 y 20.</li>
</ol>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Síntesis</h2>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#ccece6;">
<th style="border:1px solid #ccc; padding:4px;">Concepto</th>
<th style="border:1px solid #ccc; padding:4px;">Descripción</th>
<th style="border:1px solid #ccc; padding:4px;">Ejemplo</th>
</tr>
<tr><td>Entero</td><td>Número sin decimales</td><td>5, -2, 0</td></tr>
<tr><td>Real</td><td>Número con decimales</td><td>3.14, 0.5</td></tr>
<tr><td>Cadena</td><td>Texto</td><td>"Hola"</td></tr>
<tr><td>Lógico</td><td>Verdadero/Falso</td><td>Verdadero, Falso</td></tr>
<tr><td>Operadores</td><td>Aritméticos, relacionales, lógicos</td><td>+, -, *, /, =, Y, O</td></tr>
</table>
</div>

---


# UT 3 – Estructuras de control selectivas (condicionales)
<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

---

<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Lo que sabrás hacer al finalizar esta unidad</h2>
<ul>
<li><b>RA1:</b> Comprender la lógica de decisión en algoritmos.</li>
<li><b>RA2:</b> Aplicar correctamente condicionales simples y anidados.</li>
</ul>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Objetivos</h2>
<ul>
<li>Comprender la estructura IF…THEN…ELSE.</li>
<li>Aprender a anidar condicionales.</li>
<li>Resolver problemas usando decisiones lógicas.</li>
<li>Aplicar condicionales con operadores relacionales y lógicos.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Conceptos clave</h2>
<p>Las estructuras condicionales permiten que un algoritmo tome decisiones según ciertas condiciones.</p>

<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo CondicionalSimple
   Definir edad Como Entero
   edad <- 18
   Si edad >= 18 Entonces
       Escribir "Mayor de edad"
   Sino
       Escribir "Menor de edad"
   FinSi
FinAlgoritmo
</pre>

<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo CondicionalAnidado
   Definir nota Como Entero
   nota <- 7
   Si nota >= 5 Entonces
       Si nota = 10 Entonces
           Escribir "Excelente"
       Sino
           Escribir "Aprobado"
       FinSi
   Sino
       Escribir "Suspenso"
   FinSi
FinAlgoritmo
</pre>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Desarrollo paso a paso</h2>

<h3>Paso 1: Condicional simple</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo MayorEdad
   Definir edad Como Entero
   Escribir "Introduce tu edad:"
   Leer edad
   Si edad >= 18 Entonces
       Escribir "Eres mayor de edad"
   Sino
       Escribir "Eres menor de edad"
   FinSi
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 2: Condicional compuesto</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo NotaAlumno
   Definir nota Como Entero
   nota <- 7
   Si nota >= 5 Entonces
       Escribir "Aprobado"
   Sino
       Escribir "Suspenso"
   FinSi
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 3: Condicional anidado</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo Evaluacion
   Definir nota Como Entero
   nota <- 10
   Si nota = 10 Entonces
       Escribir "Excelente"
   Sino
       Si nota >= 5 Entonces
           Escribir "Aprobado"
       Sino
           Escribir "Suspenso"
       FinSi
   FinSi
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Buenas prácticas</h2>
<ul>
<li>Verifica las condiciones lógicas antes de escribirlas.</li>
<li>Los condicionales pueden ser anidados para múltiples decisiones.</li>
<li>Prueba varios valores para comprobar el algoritmo.</li>
<li>Usa sangría consistente para mejor legibilidad.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Autoevaluación</h2>
<ol>
<li>Determinar si un número introducido es positivo, negativo o cero.</li>
<li>Verificar si un año es bisiesto.</li>
<li>Clasificar edades en rangos: niño, adolescente, adulto, anciano.</li>
<li>Escribe un algoritmo que pida edad y año de nacimiento, y diga si es mayor de edad y si nació antes del 2000.</li>
</ol>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Síntesis</h2>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#ccece6;">
<th style="border:1px solid #ccc; padding:4px;">Concepto</th>
<th style="border:1px solid #ccc; padding:4px;">Descripción</th>
<th style="border:1px solid #ccc; padding:4px;">Ejemplo</th>
</tr>
<tr><td>Condicional simple</td><td>IF…THEN…ELSE básico</td><td>Si edad >=18 Entonces…</td></tr>
<tr><td>Condicional compuesto</td><td>Decisión con dos caminos</td><td>Si nota >=5 Entonces… Sino… FinSi</td></tr>
<tr><td>Condicional anidado</td><td>Condiciones dentro de otras condiciones</td><td>Si nota=10 Entonces… Sino… FinSi</td></tr>
</table>
</div>

---


# UT 5 – Subalgoritmos y Funciones
<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

---

<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;>">o que sabrás hacer al finalizar esta unidad</h2>
<ul>
<li><b>RA1:</b> Diseñar programas modulares mediante subalgoritmos y funciones.</li>
<li><b>RA2:</b> Aplicar funciones para dividir y simplificar la lógica de un programa.</li>
</ul>
<p><b>Criterios de evaluación:</b></p>
<ul>
<li>CE5.1: Crear subalgoritmos con y sin parámetros.</li>
<li>CE5.2: Aplicar funciones que devuelven valores.</li>
<li>CE5.3: Reutilizar código de manera estructurada.</li>
</ul>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Objetivos</h2>
<ul>
<li>Entender la importancia de dividir un problema en partes.</li>
<li>Aprender la sintaxis de subalgoritmos en PSeInt.</li>
<li>Aplicar funciones que realicen tareas específicas y devuelvan resultados.</li>
<li>Organizar programas complejos de forma modular.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Conceptos clave</h2>
<p>Un <b>subalgoritmo</b> es una parte del programa que realiza una tarea concreta y puede reutilizarse. Puede recibir datos (parámetros) y devolver resultados (funciones).</p>

<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
SubAlgoritmo MostrarBienvenida()
   Escribir "Bienvenido al sistema de control de usuarios"
FinSubAlgoritmo
</pre>

<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Funcion Suma <- CalcularTotal(a, b)
   Suma <- a + b
FinFuncion
</pre>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Desarrollo paso a paso</h2>

<h3>Paso 1: Crear un subalgoritmo sin parámetros</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
SubAlgoritmo MostrarInicio()
   Escribir "Iniciando mantenimiento del servidor..."
FinSubAlgoritmo

Algoritmo MantenimientoServidor
   MostrarInicio()
   Escribir "Comprobando estado de red..."
   Escribir "Revisión completada."
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 2: Subalgoritmo con parámetros</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
SubAlgoritmo MostrarUsuario(nombre)
   Escribir "Bienvenido, ", nombre
FinSubAlgoritmo

Algoritmo Login
   Definir usuario Como Cadena
   Escribir "Introduce tu nombre de usuario:"
   Leer usuario
   MostrarUsuario(usuario)
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 3: Función que devuelve resultado</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Funcion Total <- CalcularPrecio(precio, iva)
   Total <- precio + (precio * iva / 100)
FinFuncion

Algoritmo Factura
   Definir precio, total Como Real
   precio <- 120
   total <- CalcularPrecio(precio, 21)
   Escribir "Precio final con IVA:", total
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 4: Reto</h3>
<p>Crea una función llamada <code>ComprobarConexion()</code> que devuelva Verdadero si la red está activa (simula con una variable) y Falso en caso contrario. Si devuelve Verdadero, muestra "Conexión establecida".</p>
<p>_____________________________________________________________<br>_____________________________________________________________<br>_____________________________________________________________</p>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Buenas prácticas</h2>
<ul>
<li>Divide tus programas en pequeñas tareas (subalgoritmos).</li>
<li>Usa funciones para cálculos o comprobaciones repetitivas.</li>
<li>Los subalgoritmos hacen el código más legible y mantenible.</li>
<li>Usa nombres descriptivos para las funciones y sus parámetros.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Autoevaluación</h2>
<ol>
<li>Función que calcule el tiempo estimado de instalación de software (según número de equipos).</li>
<li>Subalgoritmo que muestre un menú de opciones (1. Crear usuario, 2. Eliminar usuario).</li>
<li>Función que calcule el uso de CPU medio de un servidor según varios valores de entrada.</li>
</ol>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Síntesis</h2>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#ccece6;">
<th style="border:1px solid #ccc; padding:4px;">Concepto</th>
<th style="border:1px solid #ccc; padding:4px;">Descripción</th>
<th style="border:1px solid #ccc; padding:4px;">Ejemplo</th>
</tr>
<tr><td>Subalgoritmo</td><td>Bloque de código que realiza una tarea</td><td>SubAlgoritmo MostrarInicio()</td></tr>
<tr><td>Función</td><td>Devuelve un valor tras ejecutar su lógica</td><td>Funcion Total <- CalcularPrecio()</td></tr>
<tr><td>Parámetros</td><td>Valores que se pasan al subalgoritmo</td><td>MostrarUsuario(nombre)</td></tr>
</table>
</div>

---


# UT 6 – Vectores y Listas
<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

---

<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Lo que sabrás hacer al finalizar esta unidad</h2>
<ul>
<li><b>RA1:</b> Gestionar conjuntos de datos usando vectores y listas.</li>
<li><b>RA2:</b> Aplicar estructuras de almacenamiento en problemas reales.</li>
</ul>
<p><b>Criterios de evaluación:</b></p>
<ul>
<li>CE6.1: Declarar y recorrer vectores con bucles.</li>
<li>CE6.2: Usar listas para almacenar elementos de forma dinámica.</li>
<li>CE6.3: Aplicar algoritmos de búsqueda y conteo sobre datos.</li>
</ul>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Objetivos</h2>
<ul>
<li>Aprender qué es un vector y cómo declararlo.</li>
<li>Recorrer vectores con bucles.</li>
<li>Manipular datos almacenados (mostrar, sumar, buscar).</li>
<li>Simular inventarios o listas de usuarios en pseudocódigo.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Conceptos clave</h2>
<p>Un <b>vector</b> es un conjunto de elementos del mismo tipo, como una lista de usuarios, precios o IPs.</p>

<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo ListadoUsuarios
   Definir usuarios[3] Como Cadena
   usuarios[1] <- "admin"
   usuarios[2] <- "tecnico"
   usuarios[3] <- "soporte"
   Para i <- 1 Hasta 3
       Escribir "Usuario:", usuarios[i]
   FinPara
FinAlgoritmo
</pre>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Desarrollo paso a paso</h2>

<h3>Paso 1: Crear y mostrar un vector</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo ListadoEquipos
   Definir equipos[4] Como Cadena
   equipos[1] <- "Servidor"
   equipos[2] <- "Router"
   equipos[3] <- "Switch"
   equipos[4] <- "NAS"
   Para i <- 1 Hasta 4
       Escribir "Equipo conectado:", equipos[i]
   FinPara
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 2: Búsqueda en un vector</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo BuscarUsuario
   Definir usuarios[3], buscado Como Cadena
   usuarios[1] <- "root"
   usuarios[2] <- "admin"
   usuarios[3] <- "guest"
   Escribir "Introduce el usuario a buscar:"
   Leer buscado
   encontrado <- Falso
   Para i <- 1 Hasta 3
       Si usuarios[i] = buscado Entonces
           encontrado <- Verdadero
       FinSi
   FinPara
   Si encontrado Entonces
       Escribir "Usuario encontrado."
   Sino
       Escribir "Usuario no existe."
   FinSi
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 3: Cálculo sobre datos en vector</h3>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo ConsumoServidores
   Definir consumo[3], total Como Real
   consumo[1] <- 350.5
   consumo[2] <- 290.8
   consumo[3] <- 410.2
   total <- 0
   Para i <- 1 Hasta 3
       total <- total + consumo[i]
   FinPara
   Escribir "Consumo total:", total, "W"
FinAlgoritmo
</pre>
<p>_____________________________________________________________</p>

<h3>Paso 4: Reto</h3>
<p>Crea un algoritmo que lea los nombres de varios equipos y permita mostrar solo los que empiecen por la letra “S”.</p>
<p>_____________________________________________________________<br>_____________________________________________________________<br>_____________________________________________________________</p>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Buenas prácticas</h2>
<ul>
<li>Los vectores almacenan varios elementos del mismo tipo.</li>
<li>Usa bucles para recorrerlos fácilmente.</li>
<li>Es recomendable inicializarlos antes de usarlos.</li>
<li>Evita errores de índice fuera del rango del vector.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Autoevaluación</h2>
<ol>
<li>Registrar el nombre de los 5 últimos usuarios conectados al sistema.</li>
<li>Contar cuántos equipos superan un consumo eléctrico determinado.</li>
<li>Buscar un elemento en una lista y eliminarlo (simulado).</li>
</ol>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Síntesis</h2>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#ccece6;">
<th style="border:1px solid #ccc; padding:4px;">Concepto</th>
<th style="border:1px solid #ccc; padding:4px;">Descripción</th>
<th style="border:1px solid #ccc; padding:4px;">Ejemplo</th>
</tr>
<tr><td>Vector</td><td>Conjunto de datos del mismo tipo</td><td>usuarios[1] ← “admin”</td></tr>
<tr><td>Recorrido</td><td>Usar bucle para leer todos los elementos</td><td>Para i ← 1 Hasta 3</td></tr>
<tr><td>Búsqueda</td><td>Comprobar si un elemento está en el vector</td><td>Si usuarios[i] = buscado</td></tr>
</table>
</div>

---

Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges


