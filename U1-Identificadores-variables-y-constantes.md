# Unidad 1 | Identificadores, variables y constantes

Al finalizar esta unidad sabrás hacer:
- *Reconocer los elementos y estructuras básicas de un programa informático.*
- *Escribir programas sencillos aplicando buenas prácticas en el uso de variables y constantes.*

---
  

## 1 - Objetivos
 
- Comprender qué son las **variables** y las **constantes.**
- Aprender a elegir identificadores válidos y descriptivos para variables, constantes, funciones y subprogramas.
- Diferenciar entre **tipos de datos**: *numéricos, texto, booleanos.*
- Aplicar estos conceptos en la implementación de pequeños algoritmos.


---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;"> 2 - Conceptos clave</h2>

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
<h2 style="color:#006633;"> 3 - Desarrollo paso a paso</h2>

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

<h3>Paso 3: Reconocer identificadores válidos y no válidos </h3>
<p>Lista de ejemplos:</p>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#d9f2e6;">
<th style="border:1px solid #ccc; padding:4px;">Identificador</th>
<th style="border:1px solid #ccc; padding:4px;">¿Válido?</th>
<th style="border:1px solid #ccc; padding:4px;">Motivo</th>
</tr>
<tr><td style="border:1px solid #ccc; padding:4px;"><code>2nombre</code></td><td style="border:1px solid #ccc; padding:4px; align:center;">❌</td><td>...</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;"><code>_usuario</code></td><td style="border:1px solid #ccc; padding:4px;">✅</td><td>...</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;"><code>nombre completo</code></td><td style="border:1px solid #ccc; padding:4px;">❌</td><td>...</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;"><code>precio_total</code></td><td style="border:1px solid #ccc; padding:4px;">✅</td><td>...</td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;"><code>Escribir</code></td><td style="border:1px solid #ccc; padding:4px;">❌</td><td></td></tr>
</table>

<!--<h3>Paso 4: Pequeño reto</h3>
<p>Crea un algoritmo que pida nombre, edad y año actual y muestre: "Hola, Alex. Naciste en 2005."</p>
<code></code>
</div>-->

---


<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">4 - Convenciones de programación</h2>
 <p>Las convenciones de programación son un conjunto de <b>reglas de estilo y prácticas</b> que guían la escritura de <b>código legible, coherente y fácil de mantener.</b> Estas son las más comunes:
</p>
</div>
 
- [ ] Identación de código o sangrías
- [ ] Comentar el código 
- [ ] Nombres estandarizados para variables y funciones
- [ ] Usar nombres descriptivos y coherentes
- [ ] Las constantes en mayúsculas


 ---
 
 

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">5 - Repaso final [Autoevaluación]</h2>
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
<h2 style="color:#006633;"> 6 - Lo importante... </h2>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#ccece6;">
<th style="border:1px solid #ccc; padding:4px;">Concepto</th>
<th style="border:1px solid #ccc; padding:4px;">Descripción</th>
<th style="border:1px solid #ccc; padding:4px;">Ejemplo</th>
</tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Identificador</td><td style="border:1px solid #ccc; padding:4px;"><span style="font-style: italic;">Nombre de variable o constante</span></td><td style="border:1px solid #ccc; padding:4px;"><code>nombre_usuario</code></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Variable</td><td style="border:1px solid #ccc; padding:4px;">Valor que va cambiando en tiempo de ejecución</td><td style="border:1px solid #ccc; padding:4px;"><code>edad <- 18</code></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Constante</td><td style="border:1px solid #ccc; padding:4px;">Valor fijo que no cambia</td><td style=" border:1px solid #ccc; padding:4px;"><code>AÑO_NACIMIENTO <- 1984</code></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Tipo de dato</td><td style="border:1px solid #ccc; padding:4px;">Determina el tipo de valor</td><td style="border:1px solid #ccc; padding:4px;"><code>Número, Entero, Real, Cadena, Lógico</code></td></tr>
</table>
</div>

<!--
<div style="background-color:#ccece6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> Lo que sabrás hacer al finalizar esta unidad</h2>
<ul>
<li>Reconocer los elementos y estructuras de programación básicas.</li>
<li>Escribir programas sencillos aplicando buenas prácticas en el uso de variables y constantes.</li>
</ul>
</div>
-->


##  
_&copy; 2025 - Fundamentos de Programación - Ezequiel Llarena Borges_
