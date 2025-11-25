# Unidad Práctica 2 - Operadores aritméticos y relacionales

Resultados de aprendizaje a trabajar:
- *RA2 - Reconocer y utilizar correctamente los entornos de desarrollo para la implementación de código.*
- *RA3 - Escribir y probar programas sencillos, reconociendo y aplicando los fundamentos de la programación..*


---

## 1. Objetivos
- Utilizar adecuadamente los operadores **aritméticos**.  
- Usar correctamente operadores **relacionales** para comparar valores.    
- Interpretar **expresiones booleanas** para **tomar decisiones**.
- Escribir pseudocódigo identado y con comentarios.
---

## 2. Conceptos clave

### 2.1. Operadores aritméticos

>Las expresiones con operadores aritméticos dan como resultado o *devuelven* un **valor numérico.**
>
| Operador | Significado | Expresión aritmética | Resultado |
|---|:---|---|---:|
| `+` | Suma | `3 + 2` | `5` |
| `-` | Resta | `10 - 6` | `4` |
| `*` | Multiplicación | `4 * 3` | `12` |
| `/` | División | `12 / 3` | `4` |
| `%` | Módulo (resto) | `10 % 3` | `1` |

---

### 2.2 Operadores relacionales (o de comparación)

>Las expresiones o condiciones con operadores relacionales *devuelven* o dan como resultado un valor lógico **`Verdadero`** o **`Falso`.**

| Operador | Significado | Expresión lógica | Resultado (valor lógico) |
|---|---|---|---|
| `==` | Igual que | `5 == 5` | `Verdadero` |
| `<>` | Distinto que | `4 <> 4` | `Falso` |
| `>` | Mayor que | `10 > 3` | `Verdadero` |
| `<` | Menor que | `2 < 1` | `Falso` |
| `>=` | Mayor o igual que | `5 >= 3` | `Verdadero` |
| `<=` | Menor o igual que | `3 <= 3` | `Verdadero` |

>**Consejo del programador:**
>- usa `%` cuando trabajes con números enteros para obtener restos
>- evita división por cero comprobándolo con `numero <> 0`

---

## 3. Ejemplo paso a paso 

Calcular espacio libre en disco y comprobar (solo evaluación) si podemos añadir un archivo de 4 GB.

### 3.1. Pseudocódigo
```
PROCESO Ejemplo_EspacioSimple
    DEFINIR espacioTotal, espacioUsado, espacioLibre COMO REAL
    DEFINIR cabeISO COMO LOGICO

    ESCRIBIR "Tamaño total del disco (GB): "
    LEER espacioTotal

    ESCRIBIR "Espacio usado (GB): "
    LEER espacioUsado

    espacioLibre <- espacioTotal - espacioUsado    // resta: operador aritmético
    cabeISO <- espacioLibre >= 4                   // usamos operador relacional para saber si es mayor o igual que 4

    ESCRIBIR "Espacio libre (GB): ", espacioLibre
    ESCRIBIR "¿Cabe un ISO de 4GB?: ", cabeISO
FINPROCESO
```
### 3.2. Ejemplo instrucción por instrucción

| Instrucción | Qué hace | Comentario |
|---|---|---|
| `Definir espacioTotal, espacioUsado, espacioLibre Como Real` | Declara variables numéricas con decimales | Usar `Real` para permitir fracciones de GB (p. ej. 12.5). |
| `Definir cabeISO Como Logico` | Declara variable booleana | Guarda `Verdadero` o `Falso` resultado de una comparación. |
| `Escribir "Tamaño total..."` | Muestra texto en pantalla | Mensajes claros facilitan la entrada correcta de datos. |
| `Leer espacioTotal` | Lee el valor introducido por el usuario | En prácticas iniciales no hacemos validación; en siguientes prácticas sí. |
| `espacioLibre <- espacioTotal - espacioUsado` | Resta: cálculo del espacio disponible | Operador aritmético `-`. Marca la idea de **entrada → proceso → salida**. |
| `cabeISO <- espacioLibre >= 4` | Comparación: ¿espacioLibre es mayor o igual que 4? | Operador relacional `>=` produce un valor lógico. Aquí **no** se toma decisión, sólo se almacena el resultado de la expresión. |
| `Escribir "Espacio libre...", espacioLibre` | Muestra el resultado numérico | Permite verificar manualmente el cálculo. |
| `Escribir "¿Cabe un ISO...?:", cabeISO` | Muestra `Verdadero`/`Falso` | Hace explícito el resultado de la comparación para el alumno. |

---

## 4. Ejercicios prácticos (soluciones incluidas)

**Indicaciones:**
1. Crea un fichero .psc por cada ejercicio
2. Comenta las líneas más relevantes
3. Ejecuta pruebas con valores representativos

### Ejercicio 1 - Calculadora básica
Pedir dos números y mostrar suma, resta, multiplicación, división y módulo.

**Solución:**
```
// ===== Ejercicio 1 ===
PROCESO OperacionesBasicas
    DEFINIR a, b COMO REAL

    ESCRIBIR "Número 1: "
    LEER a
    ESCRIBIR "Número 2: "
    LEER b

    ESCRIBIR "Suma: ", a + b
    ESCRIBIR "Resta: ", a - b
    ESCRIBIR "Multiplicación: ", a * b
    ESCRIBIR "División: ", a / b
    ESCRIBIR "Módulo: ", a % b
FINPROCESO
```

### Ejercicio 2 - Comparación simple
Pedir la nota de dos módulos y mostrar si son iguales (solo evaluación).

**Solución:**
```
// ===== Ejercicio 2 =====
PROCESO CompararNotas
    DEFINIR nota1, nota2 COMO REAL
    DEFINIR iguales COMO LOGICO

    ESCRIBIR "Nota 1: "
    LEER nota1
    ESCRIBIR "Nota 2: "
    LEER nota2

    iguales <- nota1 == nota2                     // operador relacional para igualdad
    ESCRIBIR "¿Notas iguales?: ", iguales
FINPROCESO
```

### Ejercicio 3 - RAM libre y evaluación
Leer RAM total y usada; calcular RAM libre y evaluar si es menor que 2 GB.

**Solución:**
```
// ===== Ejercicio 3 =====
PROCESO RamLibre
    DEFINIR ramTotal, ramUsada, ramLibre COMO REAL
    DEFINIR menos2GB COMO LOGICO

    ESCRIBIR "RAM total (GB): "
    LEER ramTotal
    ESCRIBIR "RAM usada (GB): "
    LEER ramUsada

    ramLibre <- ramTotal - ramUsada               // cálculo RAM libre
    menos2GB <- ramLibre < 2                      // comparación: menos de 2GB

    ESCRIBIR "RAM libre: ", ramLibre
    ESCRIBIR "Menos de 2GB?: ", menos2GB
FINPROCESO
```

### Ejercicio 4 - Comparar cuentas de usuarios
Introducir usuarios en servidor A y B; mostrar si A tiene más usuarios (evaluación).

**Solución:**
```
// ===== Ejercicio 4 =====
PROCESO CompararUsuarios
    DEFINIR usersA, usersB COMO ENTERO
    DEFINIR AmasB COMO LOGICO

    ESCRIBIR "Usuarios A: "
    LEER usersA
    ESCRIBIR "Usuarios B: "
    LEER usersB

    AmasB <- usersA > usersB                     // comparación: A tiene más que B
    ESCRIBIR "¿A tiene más usuarios?: ", AmasB
FINPROCESO
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
| Aritméticos | `+` &nbsp; `-` &nbsp; `*` &nbsp; `/` &nbsp; `%` |
| Relacionales | `==` &nbsp; `<>` &nbsp; `>` &nbsp; `<` &nbsp; `>=` &nbsp; `<=` |
| Resultado de expresiones aritméticas | Devuelven **números**. |
| Resultado de expresiones lógicas | Devuelven **Verdadero** o **Falso**. |
| Expresiones booleanas | Se almacenan en **variables lógicas** definidas con tipo **Logico.** |


##  
_&copy; 2025 - Fundamentos de Programación - Ezequiel Llarena Borges_  

