
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

### REGLAS DE ORO  

Si hay un double en la operación…
👉 Todo se convierte en double.

 - Enteros sin sufijo → int
 - Decimales sin sufijo → double
 - Java no pierde precisión automáticamente
 - La promoción siempre va hacia tipos más grandes
 - Si hay un double en una operación → todo sube a double

##


