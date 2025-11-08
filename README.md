# UT1 – Identificadores, Variables y Constantes
**Módulo:** Fundamentos de Programación  
**Ciclo:** ASIR1  
**Profesor:** Ezequiel Llarena Borges

---

<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> ¿Qué se espera que logres al finalizar la práctica?</h2>
<ul>
<li><b>RA1:</b> Reconocer los elementos y estructuras básicas de un programa informático.</li>
<li><b>RA2:</b> Escribir programas sencillos aplicando buenas prácticas en el uso de variables y constantes.</li>
</ul>
<p><b>Criterios de evaluación:</b></p>
<ul>
<li>CE1.1: Identifica correctamente los tipos de datos y su finalidad.</li>
<li>CE1.2: Usa nombres de variables significativos y coherentes.</li>
<li>CE1.3: Declara y utiliza constantes en lugar de valores fijos cuando sea necesario.</li>
</ul>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;"> Objetivos de la unidad</h2>
<ul>
<li>Comprender qué son las variables y las constantes.</li>
<li>Aprender a elegir identificadores válidos y descriptivos.</li>
<li>Diferenciar entre tipos de datos: numéricos, texto, booleanos.</li>
<li>Aplicar estos conceptos en pequeños algoritmos prácticos.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;"> Resumen teórico</h2>

<p><b>Identificadores →</b> Son los nombres que damos a variables, constantes o algoritmos. Ejemplo: <code>nombreUsuario</code>, <code>precioTotal</code>, <code>edad</code>.</p>

<p><b>Variables →</b> Almacenan datos que pueden cambiar durante la ejecución.</p>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo EjemploVariable
   Definir <span style="color:#cc3300;">edad</span> Como Entero
   <span style="color:#cc3300;">edad</span> <- 18
   <span style="color:#cc3300;">edad</span> <- <span style="color:#cc3300;">edad</span> + 1  // ahora <span style="color:#cc3300;">edad</span> vale 19
   Escribir <span style="color:#cc3300;">edad</span>
FinAlgoritmo
</pre>

<p><b>Constantes →</b> Almacenan valores que no deben modificarse.</p>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Const <span style="color:#0033cc;">IVA</span> <- 0.21
precioFinal <- precio * (1 + <span style="color:#0033cc;">IVA</span>)
</pre>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> Práctica guiada paso a paso</h2>

<h3>Paso 1: Declara tus primeras variables</h3>
<p>Abre PSeInt y crea un algoritmo llamado <b>Variables</b>:</p>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
Algoritmo Variables
   Definir <span style="color:#cc3300;">nombre</span> Como Cadena
   Definir <span style="color:#cc3300;">edad</span>, <span style="color:#cc3300;">altura</span> Como Real

   <span style="color:#cc3300;">nombre</span> <- "Alex"
   <span style="color:#cc3300;">edad</span> <- 20
   <span style="color:#cc3300;">altura</span> <- 1.75

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

<h3>Paso 3: Identificadores correctos e incorrectos</h3>
<p>Tabla de ejemplos:</p>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#d9f2e6;">
<th style="border:1px solid #ccc; padding:4px;">Identificador</th>
<th style="border:1px solid #ccc; padding:4px;">¿Válido?</th>
<th style="border:1px solid #ccc; padding:4px;">Motivo</th>
</tr>
<tr><td style="border:1px solid #ccc; padding:4px;">2nombre</td><td style="border:1px solid #ccc; padding:4px;">❌</td><td></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">_usuario</td><td style="border:1px solid #ccc; padding:4px;">✅</td><td></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">nombre completo</td><td style="border:1px solid #ccc; padding:4px;">❌</td><td></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">precio_total</td><td style="border:1px solid #ccc; padding:4px;">✅</td><td></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Escribir</td><td style="border:1px solid #ccc; padding:4px;">❌</td><td></td></tr>
</table>

<h3>Paso 4: Pequeño reto</h3>
<p>Crea un algoritmo que pida nombre, edad y año actual y muestre: "Hola, Alex. Naciste en 2005."</p>
<p>_____________________________________________________________<br>_____________________________________________________________<br>_____________________________________________________________</p>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;"> Recordatorios y consejos</h2>
<ul>
<li>Los identificadores no pueden empezar por número ni contener espacios.</li>
<li>Usa nombres descriptivos y coherentes.</li>
<li>Usa <b>MAYÚSCULAS</b> para las constantes.</li>
<li>No utilices palabras reservadas del lenguaje.</li>
</ul>
</div>

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
<h2 style="color:#006633;"> Resumen de conceptos clave</h2>
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

Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges
# UT3 – Estructuras de Control Condicionales
**Módulo:** Fundamentos de Programación  
**Ciclo:** ASIR1  
**Profesor:** Ezequiel Llarena Borges

---

<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">¿Qué se espera que logres al finalizar la práctica?</h2>
<ul>
<li><b>RA1:</b> Comprender la lógica de decisión en algoritmos.</li>
<li><b>RA2:</b> Aplicar correctamente condicionales simples y anidados.</li>
</ul>
<p><b>Criterios de evaluación:</b></p>
<ul>
<li>CE3.1: Crear algoritmos que tomen decisiones basadas en condiciones.</li>
<li>CE3.2: Usar correctamente condicionales simples, compuestas y anidadas.</li>
<li>CE3.3: Probar todos los casos posibles para validar resultados.</li>
</ul>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Objetivos de la unidad</h2>
<ul>
<li>Comprender la estructura IF…THEN…ELSE.</li>
<li>Aprender a anidar condicionales.</li>
<li>Resolver problemas usando decisiones lógicas.</li>
<li>Aplicar condicionales con operadores relacionales y lógicos.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Resumen teórico</h2>
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
<h2 style="color:#006633;">Práctica guiada paso a paso</h2>

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

<h3>Paso 4: Reto</h3>
<p>Escribe un algoritmo que pida edad y año de nacimiento, y diga si es mayor de edad y si nació antes del 2000.</p>
<p>_____________________________________________________________<br>_____________________________________________________________<br>_____________________________________________________________</p>
</div>

---

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Recordatorios y consejos</h2>
<ul>
<li>Verifica las condiciones lógicas antes de escribirlas.</li>
<li>Los condicionales pueden ser anidados para múltiples decisiones.</li>
<li>Prueba varios valores para comprobar el algoritmo.</li>
<li>Usa sangría consistente para mejor legibilidad.</li>
</ul>
</div>

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Ejercicios adicionales / Autoevaluación</h2>
<ol>
<li>Determinar si un número introducido es positivo, negativo o cero.</li>
<li>Verificar si un año es bisiesto.</li>
<li>Clasificar edades en rangos: niño, adolescente, adulto, anciano.</li>
</ol>
</div>

---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;">Resumen de conceptos clave</h2>
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

**Pie de página:** Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges

