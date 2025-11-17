# Práctica: Uso correcto de operadores aritméticos y relacionales en PSeInt  
**Ciclo Formativo:** ASIR 1 – Fundamentos de Programación

---

## 1. Título de la práctica  
**Uso correcto de operadores aritméticos y relacionales en PSeInt**

---

## 2. Resultado de aprendizaje a trabajar  
**RA1:** Desarrolla programas sencillos identificando y aplicando los elementos básicos de la programación estructurada.

---

## 3. Objetivos
- Aprender a manejar correctamente operadores aritméticos.
- Aprender a comparar valores utilizando operadores relacionales.
- Interpretar resultados numéricos y booleanos generados por operaciones.
- Generar pseudocódigo claro y comentado (ejemplo inicial sin condicionales).

---

## 4. Conceptos clave

### 4.1 Tabla síntesis: operadores aritméticos
| Operador | Significado | Ejemplo | Resultado |
|---|---:|---|---:|
| `+` | Suma | `3 + 2` | `5` |
| `-` | Resta | `10 - 6` | `4` |
| `*` | Multiplicación | `4 * 3` | `12` |
| `/` | División | `12 / 3` | `4` |
| `%` | Módulo (resto) | `10 % 3` | `1` |

**Recomendación breve:** usar `%` cuando trabajes con números enteros para obtener restos; evitar división por cero (se tratará en otra práctica).

---

### 4.2 Tabla síntesis: operadores relacionales
| Operador | Significado | Ejemplo (valor lógico) |
|---|---|---|
| `==` | Igual que | `5 == 5 → Verdadero` |
| `<>` | Distinto que | `4 <> 4 → Falso` |
| `>` | Mayor que | `10 > 3 → Verdadero` |
| `<` | Menor que | `2 < 1 → Falso` |
| `>=` | Mayor o igual que | `5 >= 3 → Verdadero` |
| `<=` | Menor o igual que | `3 <= 3 → Verdadero` |

**Recomendación breve:** estas comparaciones devuelven `Verdadero` o `Falso`. En esta práctica sólo las evaluaremos y almacenaremos; no se usarán instrucciones condicionales.

---

## 5. Ejemplo paso a paso (primera práctica, sin condicionales)

**Objetivo del ejemplo:** Calcular espacio libre en disco y comprobar (solo evaluación) si un archivo ISO de 4 GB cabe. Es un ejemplo inicial sencillo — se centra únicamente en operadores.

**Pseudocódigo (palabras reservadas en negrita):**
```pseudocode
**Proceso** Ejemplo_EspacioSimple
    **Definir** espacioTotal, espacioUsado, espacioLibre Como Real
    **Definir** cabeISO Como Logico

    **Escribir** "Tamaño total del disco (GB): "
    **Leer** espacioTotal

    **Escribir** "Espacio usado (GB): "
    **Leer** espacioUsado

    espacioLibre <- espacioTotal - espacioUsado      // resta: operador aritmético

    cabeISO <- espacioLibre >= 4                    // comparación: operador relacional

    **Escribir** "Espacio libre (GB): ", espacioLibre
    **Escribir** "¿Cabe un ISO de 4GB?: ", cabeISO
**FinProceso**
```

### Explicación breve, instrucción por instrucción (clave de la práctica)
Esta tabla explica, en términos sencillos, las instrucciones más importantes del ejemplo — pensado como **primer** ejemplo donde el alumno solo observa cálculos y comparaciones.

| Instrucción | Qué hace | Comentario pedagógico |
|---|---|---|
| `**Definir** espacioTotal, espacioUsado, espacioLibre Como Real` | Declara variables numéricas con decimales | Usar `Real` para permitir fracciones de GB (p. ej. 12.5). |
| `**Definir** cabeISO Como Logico` | Declara variable booleana | Guarda `Verdadero` o `Falso` resultado de una comparación. |
| `**Escribir** "Tamaño total..."` | Muestra texto en pantalla | Mensajes claros facilitan la entrada correcta de datos. |
| `**Leer** espacioTotal` | Lee el valor introducido por el usuario | En prácticas iniciales no hacemos validación; en siguientes prácticas sí. |
| `espacioLibre <- espacioTotal - espacioUsado` | Resta: cálculo del espacio disponible | Operador aritmético `-`. Marca la idea de **entrada → proceso → salida**. |
| `cabeISO <- espacioLibre >= 4` | Comparación: ¿espacioLibre es mayor o igual que 4? | Operador relacional `>=` produce un valor lógico. Aquí **no** se toma decisión, sólo se almacena la evaluación. |
| `**Escribir** "Espacio libre...", espacioLibre` | Muestra el resultado numérico | Permite verificar manualmente el cálculo. |
| `**Escribir** "¿Cabe un ISO...?:", cabeISO` | Muestra `Verdadero`/`Falso` | Hace explícito el resultado de la comparación para el alumno. |

**Nota formativa:** este es un *primer* ejemplo. Su propósito es que el alumno identifique la diferencia entre cálculo aritmético (devuelve número) y comparación relacional (devuelve booleano). No usamos condicionales para mantener el foco.

---

## 6. Ejercicios prácticos (sin condicionales) — soluciones incluidas

> Las soluciones están escritas en pseudocódigo con palabras reservadas en **negrita**. Comentar las líneas clave.

### Ejercicio 1 — Operaciones básicas
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

### Ejercicio 3 — Ram libre y evaluación
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

## 7. Buenas prácticas y recomendaciones breves
- Empezar por ejemplos sencillos (como este) antes de añadir condicionales.  
- Usar nombres de variables descriptivos.  
- Documentar los cálculos con un comentario breve.  
- Diferenciar tipo `Real` (decimales) y `Entero` (conteos, uso de `%`).  
- Enseñar al alumno a interpretar `Verdadero`/`Falso` como resultado de una comparación.

---

## 8. Ficha rápida (resumen)
- **Aritmética:** `+  -  *  /  %` → devuelven número.  
- **Relacionales:** `==  <>  >  <  >=  <=` → devuelven `Verdadero`/`Falso`.  
- **Ejemplo clave:** cálculo `espacioLibre <- espacioTotal - espacioUsado` (aritmética) y `cabeISO <- espacioLibre >= 4` (relacional).

---

**Fin del documento.**  

