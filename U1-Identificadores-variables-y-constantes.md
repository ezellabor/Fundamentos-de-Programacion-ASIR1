<code>Fundamentos de Programación | Ezequiel Llarena Borges</code>
# Unidad 1 - Identificadores, variables y constantes

 ---

 > *Contenido y ejemplos adaptados al curriculo oficial del ciclo formativo de grado medio "Administración de Sistemas Infórmaticos en Red" 

<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> Lo que sabrás hacer al finalizar esta unidad</h2>
<ul>
<li>Reconocer los elementos y estructuras básicas de un programa informático.</li>
<li>Escribir programas sencillos aplicando buenas prácticas en el uso de variables y constantes.</li>
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

<p><b>Identificadores →</b> Son los nombres que damos a variables, constantes o algoritmos.</p> 
<p>Ejemplo: <code>nombreUsuario</code>, <code>precioTotal</code>, <code>edad</code>.</p>

<p><b>Variables →</b> Almacenan valores que irán cambiando durante la ejecución del programa.</p>
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
<pre>...</pre>

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
<pre>...</pre>

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
<code></code>
</div>-->

---


<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">Convenciones de código</h2>
 <p>Las convenciones de programación son un conjunto de reglas de estilo y prácticas que guían la escritura de código para que sea más legible, coherente y fácil de mantener. Estas son algunas de las principales:
</p>
 <ul>
<li>Uso de sangría</li>
<li>Uso de comentarios</li>
<li>Nombres estandarizados para variables y funciones</li>
<li>Usar nombres descriptivos y coherentes</li>
<li>Usar mayúsculas para las constantes</li>
</ul>
 </div>
 
 ---
 
 

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">Autoevaluación</h2>
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


>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges

