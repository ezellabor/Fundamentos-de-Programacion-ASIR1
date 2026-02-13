
![Módulo](https://img.shields.io/badge/Módulo-Fundamentos_de_Programación-brown?style=for-the-badge)
![Lenguaje](https://img.shields.io/badge/Lenguaje-Java-brown?style=for-the-badge)
![Grupo](https://img.shields.io/badge/Grupo-ASIR1V-blue?style=for-the-badge)
![Profesor](https://img.shields.io/badge/Profesor-Ezequiel_Llarena_Borges-blue?style=for-the-badge)  
 
<!--
## 01 - Literales y Tipos 

#### Conceptos a evaluar:
```
- Tipos primitivos en Java
- Literales por defecto
- Conversión implícita y explícita
- Rango de tipos numéricos
- Promoción de tipos
- Pérdida de precisión
```

---

### PARTE 1: ¿Compila o no compila?

Indica si el siguiente código:

- ✅ Compila correctamente  
- ❌ No compila  
- ⚠️ Compila pero puede tener implicaciones  

Y **justifica tu respuesta**.

---

#### 1️⃣
```java
long a = 1000000000;
```
---

## EL CEREBRO NUMÉRICO DE JAVA-->
# Literales · Jerarquía · Promoción · Conversión  
  
#### 1. LITERALES POR DEFECTO  

|     Literal          | Tipo por defecto |
|----------------------|------------------|
| Entero sin sufijo    |    ```int```     |
| Decimales sin sufijo |   ```double```   |

Ejemplos:

```java
5      → int  
5L     → long  
3.14   → double  
3.14F  → float  
```
**Esquema general**  
```javascript
      Literal escrito
            ↓
     Tipo por defecto
            ↓
¿Cabe en el tipo declarado?
            ↓
       Sí → Compila
        No → Error
```  
## 

#### 2. ESCALERA DE TIPOS NUMÉRICOS

         double
           ▲
         float
           ▲
         long
           ▲
          int
           ▲
         short
           ▲
         byte

>Regla:
>La conversión automática solo sube hacia arriba.

##

#### 3. ¿QUÉ HACE EL COMPILADOR?

Cuando escribes:

```java
float x = 3.14;
```

Proceso interno:

```java
3.14 → double  
double → float ❌ 
```

```java
float x = 3.14F;
3.14F → float  ✔ Coincide  
```  
##

#### 4. ERRORES CLÁSICOS
```java
❌ long x = 5000000000;
   → Literal int demasiado grande

❌ float y = 3.14;
   → double no baja a float

❌ int z = 10L;
   → long no baja a int
```
##

#### 5. DIVISIÓN ENTERA

```java
1 / 2   → 0  
1 / 2.0 → 0.5  
```
Porque:  

```java  
int / int → int  
int / double → double  
```  
##

#### 6. TABLA RESUMEN TIPOS DE DATOS

| Tipo   | Tamaño | Precisión |
|--------|--------|-----------|
| byte   | 8 bit  | Exacta    |
| short  | 16 bit | Exacta    |
| int    | 32 bit | Exacta    |
| long   | 64 bit | Exacta    |
| float  | 32 bit | Aproximada|
| double | 64 bit | Aproximada|

##

#### 7. REGLAS DE ORO  

Si hay un double en la operación…
👉 Todo se convierte en double.

 - Enteros sin sufijo → int
 - Decimales sin sufijo → double
 - Java no pierde precisión automáticamente
 - La promoción siempre va hacia tipos más grandes
 - Si hay un double en una operación → todo sube a double

## 

## 8. EJERCICIOS - TIPOS NUMÉRICOS EN JAVA

<!-- #### NIVEL 1 – Literales por defecto-->

#### Ejercicio 1

Indica el tipo de cada literal:
```
a) 10  
b) 10L  
c) 5.5  
d) 5.5F  
```
---

#### Ejercicio 2

Corrige el código para que compile:

```
float x = 8.2;
long y = 4000000000;
```
---

<!-- #### NIVEL 2 – Conversión implícita -->

#### Ejercicio 3

Indica si compila:

```
int a = 5;
long b = a;
```
---

#### Ejercicio 4

¿Por qué esto falla? Corrígelo de dos maneras

```
int x = 5L;
```
---

<!-- #### NIVEL 3 – Promoción automática -->

#### Ejercicio 5

¿Qué tipo tiene el resultado?

``` 
a) 5 + 3  
b) 5 + 3L  
c) 5 + 3.0  
d) 5F + 3  
```
---

#### Ejercicio 6

¿Qué imprime el siguiente código?

```
System.out.println(3 / 2);
System.out.println(3 / 2.0);
```
---

<!-- #### NIVEL 4 – Conceptual -->

#### Ejercicio 7

¿Por qué Java no convierte automáticamente double → float?

Relaciona la respuesta con:

- Precisión
- Pérdida de datos
- IEEE 754

---

#### Ejercicio 8

Completa la escalera:
``` 
byte < ____ < int < ____ < float < ____
```
---

#### Ejercicio 9

Modifica este bloque de código para que imprima 2.5:
``` 
int a = 5;
int b = 2;

System.out.println(a / b);
```
##  


