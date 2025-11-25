# Unidad Práctica 1 - Identificadores, variables y constantes

Resultados de aprendizaje a trabajar:
- *RA2 - Reconocer y utilizar correctamente los entornos de desarrollo para la implementación de código.*
- *RA3 - Escribir y probar programas sencillos, reconociendo y aplicando los fundamentos de la programación.*

---

# Indicaciones para el entregable:
Añade el siguiente bloque de comentarios al principio de tu código de esta práctica (copia y pega):
```// ======================================================================================================
// Unidad Práctica 1 - Identificadores, variables y constantes
// Duración estimada: 1 hora
// Fecha: [dd/mm/aaaa]
// Nombre del alumno: [Nombre del alumno]
// Grupo: ASIR1V
// Profesor: Ezequiel Llarena Borges
//
// Resultados de aprendizaje a trabajar:
// RA2 - Reconocer y utilizar correctamente los entornos de desarrollo para la implementación de código.
// RA3 - Escribir y probar programas sencillos, reconociendo y aplicando los fundamentos de la programación.
//
Algoritmo Practica_01
	// Aquí va tu código de la práctica
	Escribir "Hola, esta es la práctica 01"
FinAlgoritmo
```

---  

## 1 - Objetivos
 
- Identificar los distintos **tipos de variables** y su utilidad.
- Elegir identificadores válidos y descriptivos para variables y constantes.
- Diferenciar entre tipos de datos: *numéricos, texto, booleanos.*
- Aplicar **buenas prácticas y convenciones de código** en el uso de variables y constantes.


---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;"> 2 - Conceptos clave</h2>
<h3>2.1. Identificador</h3>
<p><b>Identificadores →</b> Son los nombres que damos a variables, constantes o algoritmos.</p> 
<p>Ejemplos: <code>nombreUsuario</code>, <code>precioTotal</code>, <code>edad</code>, <code>IVA</code>, <code>TARIFA_UNO</code></p>

<h3>2.2. Variable</h3>
<p><b>Variables →</b> Almacenan valores que irán cambiando durante la ejecución del programa.</p>
<quote>Ejemplo:</quote>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
   <span style="color:#cc3300;">edad</span> <- 18
   <span style="color:#cc3300;">edad</span> <- <span style="color:#cc3300;">edad</span> + 1  // ahora <span style="color:#cc3300;">edad</span> vale 19
</pre>

<h3>2.3. Constante</h3>
<p><b>Constantes →</b> Almacenan valores que no cambian durante todo el programa.</p>
<quote>Ejemplo:</quote>
<pre style="background-color:#ededed; padding:8px; border-radius:5px;">
// Constantes predefinidas de Pseint
	Escribir "Valor de PI: ", PI
	Escribir "Valor de EULER: ", EULER
</pre>
</div>

### 2.4. Tipo de dato

<p><b>2.4.1. Sintaxis</b> para declarar una variable:</p>
<pre>Definir nombre_variable Como tipo_de_dato</pre>
<ul><li><b>nombre_variable:</b> Este es el nombre que se le asignará a la variable.</li>
<li><b>tipo_de_dato:</b> Valores que la variable almacenará, como entero, real, caracter o lógico.</li></ul>

<p><b>2.4.2. Ejemplos:</p>
```
Algoritmo DeclaracionDeVariables
   Definir numeroEntero Como Entero
   Definir texto Como Cadena
   Definir esVerdadero Como Logico
   Definir precio Como Real
FinAlgoritmo
```
---

| Tipo de dato | Rango de valores | Sintaxis | Ejemplos |
|--------------|------------------|----------|---------|
| Entero | Números sin decimales, positivos o negativos | `Definir edad Como Entero` | `5, -10, 0`|
| Real | Números con decimales | `Definir longitud Como Real` | `3.14, -0.5, 12.0` |
| Logico | Valores booleanos | `Definir bit Como Logico` | `Verdadero`, `Falso`, `True`, `False` |
| Cadena | Secuencia de caracteres (texto) | `Definir letra_dni Como Caracter` | `"Hola"`, `"ASIR1"` |
| Caracter | Un solo carácter | `Definir nombre Como Cadena` | `'A', '1', '#'` |

>Aplicación:
>- `Entero` y `Real` se usan para operaciones y cálculos numéricos.
>- `Logico` se usa para almacenar el resultado de comparaciones: `capacidad > 1000`, `grupo == "ASIR1V"`
>- `Cadena` y `Caracter` se usan para mostrar texto o recibir entradas de texto.
---

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> 3 - Desarrollo paso a paso</h2>

<h3>Paso 1: Declaración de variables</h3>
<p>La declaración de una variable es el proceso de reservar un espacio de memoria para almacenar datos de un tipo específico. Sintaxis: </p>
<ol>
  <li>Los nombres de las variables deben comenzar con una letra</li>
  <li>No pueden contener espacios ni caracteres especiales, excepto el guion bajo (_)</li>
</ol>
<h3>Identificadores válidos</h3>
<p>Ejemplos:</p>
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


<!--<h3>Paso 4: Pequeño reto</h3>
<p>Crea un algoritmo que pida nombre, edad y año actual y muestre: "Hola, Alex. Naciste en 2005."</p>
<code></code>
</div>-->

---

<div style="background-color:#e6f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#0066cc;">4 - Autoevaluación</h2>
<ol>
<li>Declara tres variables con tu nombre, edad y ciudad, y muéstralas.</li>
<li>Calcula el área de un rectángulo usando constantes para la base y la altura.</li>
<li>Corrige los errores del siguiente pseudocódigo:</li>
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

<div style="background-color:#f2f2f2; padding:15px; border-radius:8px;">
<h2 style="color:#009966;">5 - Buenas prácticas de programación </h2>
 <p>Las convenciones de programación son un conjunto de <b>reglas de estilo y prácticas</b> que guían la escritura de <b>código legible, coherente y fácil de mantener.</b> Estas son las más comunes:
</p>
</div>
 
- [ ] Identación de código o sangrías
- [ ] Comentar el código 
- [ ] Nombres estandarizados para variables y funciones
- [ ] Usar nombres descriptivos y coherentes
- [ ] Las constantes en mayúsculas

 ---
 
<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<h2 style="color:#006633;"> 6 - Síntesis </h2>
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#ccece6;">
<th style="border:1px solid #ccc; padding:4px;">Concepto</th>
<th style="border:1px solid #ccc; padding:4px;">Descripción</th>
<th style="border:1px solid #ccc; padding:4px;">Ejemplo</th>
</tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Identificador</td><td style="border:1px solid #ccc; padding:4px;"><span style="font-style: italic;">Nombre de variable o constante</span></td><td style="border:1px solid #ccc; padding:4px;"><code>nombre_usuario</code>, <code>espacioLibre, espacioUsado</code></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Variable</td><td style="border:1px solid #ccc; padding:4px;">Valor que va cambiando en tiempo de ejecución</td><td style="border:1px solid #ccc; padding:4px;"><code>edad <- 18</code>, <code>contador <- contador + 1</code></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Constante</td><td style="border:1px solid #ccc; padding:4px;">Valor que no cambia durante todo el programa</td><td style=" border:1px solid #ccc; padding:4px;"><code>AÑO_NACIMIENTO <- 1984</code>, <code>ESPACIO_TOTAL</code></td></tr>
<tr><td style="border:1px solid #ccc; padding:4px;">Tipo de dato</td><td style="border:1px solid #ccc; padding:4px;">Determina el tipo de valor</td><td style="border:1px solid #ccc; padding:4px;"><code>Entero, Real, Cadena, Caracter, Lógico</code></td></tr>
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
