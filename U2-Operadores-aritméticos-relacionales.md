# Unidad 3 - Operadores aritméticos y relacionales

Resultado de aprendizaje a trabajar:
- *RA3 - Escribir y probar programas sencillos, reconociendo y aplicando los fundamentos de la programación..*


---

## 1. Objetivos
- Utilizar adecuadamente los operadores aritméticos.  
- Emplear operadores **relacionales para comparar** valores.  
- Diferenciar **operaciones de cálculo** y comparaciones lógicas.  
- Interpretar **expresiones booleanas** para **tomar decisiones** en un algoritmo.
- Escribir pseudocódigo claro y documentado con buenas prácticas.
---

## 2. Conceptos clave

### 2.1. Operadores aritméticos

>Las expresiones o condiciones con operadores aritméticos *devuelven* un **valor numérico.**
>
| Operador | Significado | Expresión | Resultado |
|---|---:|---|---:|
| `+` | Suma | `3 + 2` | `5` |
| `-` | Resta | `10 - 6` | `4` |
| `*` | Multiplicación | `4 * 3` | `12` |
| `/` | División | `12 / 3` | `4` |
| `%` | Módulo (resto) | `10 % 3` | `1` |

---

### 2.2 Operadores relacionales (o de comparación)

>Las expresiones o condiciones con operadores relacionales *devuelven* **`Verdadero`** o **`Falso`.**

| Operador | Significado | Expresión → valor lógico |
|---|---|---|
| `==` | Igual que | `5 == 5 → Verdadero` |
| `<>` | Distinto que | `4 <> 4 → Falso` |
| `>` | Mayor que | `10 > 3 → Verdadero` |
| `<` | Menor que | `2 < 1 → Falso` |
| `>=` | Mayor o igual que | `5 >= 3 → Verdadero` |
| `<=` | Menor o igual que | `3 <= 3 → Verdadero` |

>**Consejo del programador:**
>- usa `%` cuando trabajes con números enteros para obtener restos
>- evita división por cero comprobándolo con `numero <> 0`

---

## 3. Ejemplo paso a paso 

Calcular espacio libre en disco y comprobar (solo evaluación) si un archivo ISO de 4 GB cabe.

### 3.1. Pseudocódigo
```pseudocode
**Proceso** Ejemplo_EspacioSimple
    **Definir** espacioTotal, espacioUsado, espacioLibre Como Real
    **Definir** cabeISO Como Logico

    **Escribir** "Tamaño total del disco (GB): "
    **Leer** espacioTotal

    **Escribir** "Espacio usado (GB): "
    **Leer** espacioUsado

    espacioLibre <- espacioTotal - espacioUsado    // resta: operador aritmético

    // usamos operador relacional para saber si es mayor o igual que 4
    cabeISO <- espacioLibre >= 4   

    **Escribir** "Espacio libre (GB): ", espacioLibre
    **Escribir** "¿Cabe un ISO de 4GB?: ", cabeISO
**FinProceso**
```pseudocode

### 3.2. El ejemplo instrucción por instrucción

| Instrucción | Qué hace | Comentario |
|---|---|---|
| `**Definir** espacioTotal, espacioUsado, espacioLibre Como Real` | Declara variables numéricas con decimales | Usar `Real` para permitir fracciones de GB (p. ej. 12.5). |
| `**Definir** cabeISO Como Logico` | Declara variable booleana | Guarda `Verdadero` o `Falso` resultado de una comparación. |
| `**Escribir** "Tamaño total..."` | Muestra texto en pantalla | Mensajes claros facilitan la entrada correcta de datos. |
| `**Leer** espacioTotal` | Lee el valor introducido por el usuario | En prácticas iniciales no hacemos validación; en siguientes prácticas sí. |
| `espacioLibre <- espacioTotal - espacioUsado` | Resta: cálculo del espacio disponible | Operador aritmético `-`. Marca la idea de **entrada → proceso → salida**. |
| `cabeISO <- espacioLibre >= 4` | Comparación: ¿espacioLibre es mayor o igual que 4? | Operador relacional `>=` produce un valor lógico. Aquí **no** se toma decisión, sólo se almacena la evaluación. |
| `**Escribir** "Espacio libre...", espacioLibre` | Muestra el resultado numérico | Permite verificar manualmente el cálculo. |
| `**Escribir** "¿Cabe un ISO...?:", cabeISO` | Muestra `Verdadero`/`Falso` | Hace explícito el resultado de la comparación para el alumno. |

---

## 4. Supuestos prácticos (soluciones incluidas)

>**Indicaciones generales:**
>- crea un fichero .psc por cada ejercicio
>- comenta las líneas más relevantes
>- y ejecuta pruebas con valores representativos

### Ejercicio 1 — Calculadora básica
**Enunciado:** Pedir dos números y mostrar suma, resta, multiplicación, división y módulo.

**Solución:**
```pseudocode
**Proceso** OperacionesBasicas
    **Definir** a, b Como Real
    **Escribir** "Número 1: "
    **Leer** a
    **Escribir** "Número 2: "
    **Leer** b

    **Escribir** "Suma: ", a + b
    **Escribir** "Resta: ", a - b
    **Escribir** "Multiplicación: ", a * b
    **Escribir** "División: ", a / b
    **Escribir** "Módulo: ", a % b
**FinProceso**
```

### Ejercicio 2 — Comparación simple
**Enunciado:** Pedir la nota de dos módulos y mostrar si son iguales (solo evaluación).

**Solución:**
```pseudocode
**Proceso** CompararNotas
    **Definir** nota1, nota2 Como Real
    **Definir** iguales Como Logico
    **Escribir** "Nota 1: "
    **Leer** nota1
    **Escribir** "Nota 2: "
    **Leer** nota2

    iguales <- nota1 == nota2
    **Escribir** "¿Notas iguales?: ", iguales
**FinProceso**
```

### Ejercicio 3 — RAM libre y evaluación
**Enunciado:** Leer RAM total y usada; calcular RAM libre y evaluar si es menor que 2 GB.

**Solución:**
```pseudocode
**Proceso** RamLibre
    **Definir** ramTotal, ramUsada, ramLibre Como Real
    **Definir** menos2GB Como Logico

    **Escribir** "RAM total (GB): "
    **Leer** ramTotal
    **Escribir** "RAM usada (GB): "
    **Leer** ramUsada

    ramLibre <- ramTotal - ramUsada
    menos2GB <- ramLibre < 2

    **Escribir** "RAM libre: ", ramLibre
    **Escribir** "Menos de 2GB?: ", menos2GB
**FinProceso**
```

### Ejercicio 4 — Comparar cuentas de usuarios
**Enunciado:** Introducir usuarios en servidor A y B; mostrar si A tiene más usuarios (evaluación).

**Solución:**
```pseudocode
**Proceso** CompararUsuarios
    **Definir** usersA, usersB Como Entero
    **Definir** AmasB Como Logico

    **Escribir** "Usuarios A: "
    **Leer** usersA
    **Escribir** "Usuarios B: "
    **Leer** usersB

    AmasB <- usersA > usersB
    **Escribir** "¿A tiene más usuarios?: ", AmasB
**FinProceso**
```

---

## 5. Buenas prácticas
- Usar nombres de variables descriptivos.  
- Documentar los cálculos con un comentario breve.  
- Diferenciar tipo `Real` (decimales) y `Entero` (conteos, uso de `%`).  
- Interpretar correctamente `Verdadero`/`Falso` como resultado de una comparación.

---

## 6. Síntesis

| Concepto | Resumen |
|---------|---------|
| Aritmética | `+` &nbsp; `-` &nbsp; `*` &nbsp; `/` &nbsp; `%` |
| Relacionales | `==` &nbsp; `<>` &nbsp; `>` &nbsp; `<` &nbsp; `>=` &nbsp; `<=` |
| Resultado de operadores aritméticos | Devuelven **números**. |
| Resultado de operadores relacionales | Devuelven **Verdadero/Falso**. |
| Uso de booleanos | Se pueden almacenar en **variables lógicas** y mostrarse como salida. |


---

##  
_&copy; 2025 - Fundamentos de Programación - Ezequiel Llarena Borges_  

