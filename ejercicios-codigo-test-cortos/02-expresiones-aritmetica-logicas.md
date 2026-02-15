#  Operaciones en Java  
## Aritméticas · Relacionales · Lógicas

![Java](https://img.shields.io/badge/Java-17+-blue)
![Nivel](https://img.shields.io/badge/Nivel-Inicial-green)
![Asignatura](https://img.shields.io/badge/Módulo-Programación-orange)
![Estado](https://img.shields.io/badge/Material-Docente-success)
![Licencia](https://img.shields.io/badge/Licencia-Uso_Educativo-lightgrey)

---

## Indice

- [1️⃣ Operaciones Aritméticas](#1️⃣-operaciones-aritméticas)
- [2️⃣ Operaciones Relacionales](#2️⃣-operaciones-relacionales)
- [3️⃣ Operaciones Lógicas](#3️⃣-operaciones-lógicas)
- [4️⃣ Orden de Evaluación](#4️⃣-orden-de-evaluación)
- [5️⃣ Ejemplo Combinado](#5️⃣-ejemplo-combinado)
- [6️⃣ Ejercicios Progresivos](#6️⃣-ejercicios-progresivos)

---

## 1️⃣ Operaciones Aritméticas

Permiten realizar cálculos matemáticos con números.

### Operadores

| Operador | Significado | Ejemplo | Resultado |
|----------|------------|----------|------------|
| `+` | Suma | `5 + 3` | 8 |
| `-` | Resta | `5 - 3` | 2 |
| `*` | Multiplicación | `5 * 3` | 15 |
| `/` | División | `10 / 2` | 5 |
| `%` | Módulo (resto) | `10 % 3` | 1 |

---

### División entera vs decimal

```java
int a = 5 / 2;      // 2
double b = 5.0 / 2; // 2.5
```

Si ambos operandos son `int`, el resultado será entero.

---

### Prioridad

1. `()`
2. `* / %`
3. `+ -`

Ejemplo:

```java
int r = 2 + 3 * 4;  // Resultado: 14
```

---

## 2️⃣ Operaciones Relacionales

Comparan valores y devuelven un resultado booleano (`true` o `false`).

### Operadores

| Operador | Significado |
|----------|------------|
| `==` | Igual que |
| `!=` | Distinto que |
| `>` | Mayor que |
| `<` | Menor que |
| `>=` | Mayor o igual |
| `<=` | Menor o igual |

---

### Ejemplo

```java
int edad = 18;
System.out.println(edad >= 18); // true
```

⚠ Cuidado con:

```java
if (a = 5)   // ❌ Incorrecto
if (a == 5)  // ✅ Correcto
```

`=` asigna  
`==` compara  

---

## 3️⃣ Operaciones Lógicas

Combinan expresiones relacionales y devuelve un tipo booleano (true o false).

### Operadores

| Operador | Nombre | Significado |
|----------|--------|-------------|
| `&&` | AND | Ambas condiciones deben cumplirse |
| `||` | OR | Basta con una condición verdadera |
| `!` | NOT | Invierte el valor |

---

### Tabla de verdad

### AND 

| A | B | A && B |
|---|---|--------|
| T | T | T |
| T | F | F |
| F | T | F |
| F | F | F |

### OR (símbolo ||)*

| A | B | A OR* B |
|---|---|--------|
| T | T | T |
| T | F | T |
| F | T | T |
| F | F | F |

### NOT

| Entrada | ! |
|---------|---|
| true | false |
| false | true |

---

## 4️⃣ Orden de evaluación

Java evalúa en este orden:

1️⃣ `()`  
2️⃣ Operaciones aritméticas  
3️⃣ Operaciones relacionales  
4️⃣ Operaciones lógicas  

---

## 5️⃣ Ejemplo final

```java
int edad = 20;
boolean tieneCarnet = true;

if (edad >= 18 && tieneCarnet) {
    System.out.println("Puede conducir");
}
```

Análisis:

- `edad >= 18` → Relacional  
- `&&` → Lógica  
- Resultado final → Boolean  

---

# 6️⃣ Ejercicios 

### Ejercicio 1

```java
int r = 8 + 2 * 3;
```

<details>
<summary>✅ Solución</summary>

2 * 3 = 6  
8 + 6 = **14**

</details>

---

### Ejercicio 2

```java
System.out.println(10 % 4);
```

<details>
<summary>✅ Solución</summary>

Resto = **2**

</details>

---

### Ejercicio 3

```java
int a = 5;
System.out.println(a > 3);
```

<details>
<summary>✅ Solución</summary>

**true**

</details>

---

### Ejercicio 4

```java
System.out.println(true && false);
```

<details>
<summary>✅ Solución</summary>

**false**

</details>

---

### Ejercicio 5

```java
System.out.println(5 > 3 && 2 < 4);
```

<details>
<summary>✅ Solución</summary>

true && true → **true**

</details>

---

### Ejercicio 6

```java
System.out.println(5 + 3 > 10 || 4 < 2);
```

<details>
<summary>✅ Solución</summary>

5 + 3 = 8  
8 > 10 → false  
4 < 2 → false  
false || false → **false**

</details>

---

