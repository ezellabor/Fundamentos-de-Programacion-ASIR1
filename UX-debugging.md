<!--
---
title: "Práctica 2 – Siguiendo el rastro de las variables"
module: "Fundamentos de Programación | ASIR1"
unit: "UT1 – Identificadores, Variables y Constantes"
author: "Ezequiel Llarena Borges"
description: "Uso del depurador (modo paso a paso) en PSeInt para observar la evolución de variables y constantes."
tags: ["PSeInt", "Depuración", "Variables", "Constantes", "ASIR1", "Fundamentos de Programación"]
date: 2025-11-09
layout: "default"
---  -->

# P2 – Depuración y exploración de código 
>Modo "paso a paso" o Debugger
---
**Unidad:** UT1 – Identificadores, Variables y Constantes  
**Módulo:** Fundamentos de Programación | ASIR1  
**Profesor:** Ezequiel Llarena Borges  

---

## Lo que sabrás hacer al terminar esta práctica

<!--### Resultados de aprendizaje-->
<ol>
   <li>Reconocer la ejecución secuencial de instrucciones y la evolución del estado de las variables.</li>
      <ul >
         <li>Usa correctamente el modo “Depurar” o “Paso a paso” de PSeInt.</li>
         <li>Interpreta los cambios de valores en las variables durante la ejecución.</li>
         <li>Corrige errores simples observando el comportamiento de las variables.</li>
      </ul>
    <li>Comprender la utilidad del depurador para analizar y corregir programas.</li>
</ol>


---

## Objetivos 
- Aprender a ejecutar un pseudocódigo en modo **paso a paso** o **Depuración** en PSeInt.  
- Observar cómo cambian las variables en cada instrucción para localizar errores.   
- Usar el depurador como herramienta para **detectar errores lógicos**.
- Fomentar hábitos de **observación, análisis y comprobación** del código.

---

## Parte 1 – Preparación del entorno

> **Nota:** Esta sección sirve para preparar el entorno de trabajo.

1. Abre **PSeInt** y asegúrate de que la vista *Panel de variables* está visible.  
   - Si no la ves, actívala en el menú: `Ver → Panel de seguimiento`.  
2. Crea un nuevo algoritmo llamado `Depuracion_Variables`.  
3. Copia este código inicial:

```pseudocode
Algoritmo Depuracion_Variables
   Definir edad, aumento Como Entero
   Definir nombre Como Cadena
   Definir sueldo, nuevoSueldo Como Real
   Const IVA <- 0.21

   nombre <- "Alex"
   edad <- 20
   sueldo <- 1200
   aumento <- 100

   nuevoSueldo <- sueldo + aumento
   Escribir "Empleado: ", nombre
   Escribir "Edad: ", edad
   Escribir "Sueldo con aumento: ", nuevoSueldo

   Escribir "Sueldo con IVA: ", nuevoSueldo * (1 + IVA)
FinAlgoritmo
```

---

## Parte 2 – Explorando el modo “Paso a paso”

> **Consejo:** Observa la ejecución de cada instrucción y el cambio de valores.

1. Pulsa **Depurar / Paso a paso (F8)**.  
2. Observa en el panel de variables cómo aparecen las variables una a una.  
3. Cada vez que presiones F8, avanza una línea.  
   - ¿Qué ocurre cuando ejecuta `edad <- 20`?  
   - ¿Qué valor tiene `nuevoSueldo` antes y después de `nuevoSueldo <- sueldo + aumento`?

**Anota tus observaciones:**

```



```

4. Cambia el valor de `aumento` por `50` y repite la depuración.  
   - ¿Qué cambió en los resultados?

---

## Parte 3 – Detectando errores con el depurador

> **Observación:** Analiza el comportamiento del programa cuando contiene un error lógico.

1. Sustituye la línea:  

```pseudocode
nuevoSueldo <- sueldo + aumento
```  

por  

```pseudocode
nuevoSueldo <- sueldo - aumento
```

2. Ejecuta paso a paso.  
   - Observa el valor de `nuevoSueldo`.  
   - ¿Por qué el resultado no es correcto?

**Reflexión:**

```



```

3. Corrige la instrucción y vuelve a ejecutar paso a paso.

---

## Parte 4 – Seguimiento de una constante

> **Recordatorio:** Las constantes no cambian su valor durante la ejecución.

- Observa en el panel que `IVA` siempre mantiene el mismo valor.  
- Prueba a escribir una instrucción que intente cambiarlo:

```pseudocode
IVA <- 0.18
```

y ejecútala paso a paso.

Verás que PSeInt muestra un error: **“No se puede modificar una constante”**.  
Esto demuestra que las **constantes no varían durante la ejecución**.

---

## Parte 5 – Misión final: “Detective de variables”

> **Misión:** Amplía el programa y analiza nuevas variables.

Añade una nueva variable llamada `ahorro`, cuyo valor sea el 10 % del nuevo sueldo.  

```pseudocode
ahorro <- nuevoSueldo * 0.10
Escribir "Ahorro mensual: ", ahorro
```

**Cuestiones propuestas:**
-- ¿En qué momento se crea la variable `ahorro`?  
-- ¿Cuál es su valor antes de ejecutar la línea anterior?  
-- ¿Qué ocurre si cambias el orden de las instrucciones?

```



```
---

## Buenas prácticas
- Usa **F8** para avanzar y **Ctrl + F8** para saltar una función completa.  
- Observa siempre el **panel de variables** mientras depuras.  
- Usa el **modo lento** para seguir el flujo completo.  
- Introduce pequeños errores a propósito para practicar la detección.
---

## Sintesis 

| Concepto | Observación |
|-----------|-------------|
| Variable | Cambia de valor a lo largo del programa |
| Constante | Mantiene su valor durante toda la ejecución |
| Depurador | Permite seguir el flujo del programa paso a paso |
| Error lógico | No interrumpe la ejecución, pero produce un resultado incorrecto |

---

<!--## Extensión (opcional)
Guarda una captura del **panel de variables** mostrando el momento en que cambian los valores y añádela a tus apuntes. -->
