# Módulo 9: Gestión de Excepciones
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## Conceptos Clave

- Try-catch-finally
- Throw y throws
- Excepciones checked y unchecked
- Crear excepciones personalizadas
- Jerarquía de excepciones

---



### Ejercicio 1 - Nivel 1
**¿Qué bloque se usa para capturar excepciones?**

a) catch  
b) trap  
c) handle  
d) except  

<details>
<summary>💡 Pista</summary>
El bloque catch captura la excepción.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**a) catch**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué bloque se ejecuta siempre, haya o no excepción?**

a) always  
b) finally  
c) end  
d) complete  

<details>
<summary>💡 Pista</summary>
finally se ejecuta siempre.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) finally**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Qué palabra clave lanza manualmente una excepción?**

a) throw  
b) throws  
c) raise  
d) fire  

<details>
<summary>💡 Pista</summary>
throw lanza una nueva excepción.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**a) throw**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Qué añade 'throws' en la firma de un método?**

a) Captura excepciones  
b) Declara que puede lanzar excepciones  
c) Crea excepciones  
d) Ignora excepciones  

<details>
<summary>💡 Pista</summary>
throws declara excepciones que el método puede lanzar.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Declara que puede lanzar excepciones**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Cuál es una excepción checked?**

a) NullPointerException  
b) IOException  
c) ArrayIndexOutOfBoundsException  
d) ArithmeticException  

<details>
<summary>💡 Pista</summary>
IOException es checked, debe ser capturada o declarada.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) IOException**
</details>

---

### Ejercicio 6 - Nivel 3
**Completa: `try { ... } ____ (Exception e) { ... }`**

<details>
<summary>💡 Pista</summary>
catch captura la excepción.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**catch**

```java
try {
    // código
} catch (Exception e) {
    // manejo
}
```
</details>

---

### Ejercicio 7 - Nivel 3
**Escribe la estructura try-catch-finally básica:**

<details>
<summary>💡 Pista</summary>
try { } catch (Exception e) { } finally { }
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
try {
    // código que puede fallar
} catch (Exception e) {
    // manejo de error
} finally {
    // se ejecuta siempre
}
```
</details>

---

### Ejercicio 8 - Nivel 3
**¿Cómo lanzas una nueva excepción de tipo IllegalArgumentException?**

<details>
<summary>💡 Pista</summary>
throw new IllegalArgumentException("mensaje");
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
throw new IllegalArgumentException("Argumento inválido");
```
</details>

---

### Ejercicio 9 - Nivel 4
**Crea una excepción personalizada llamada PuertoInvalidoException:**

<details>
<summary>💡 Pista</summary>
class PuertoInvalidoException extends Exception
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class PuertoInvalidoException extends Exception {
    public PuertoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Método que divida dos números y capture ArithmeticException:**

<details>
<summary>💡 Pista</summary>
Método con try-catch para división por cero.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public static double dividir(int a, int b) {
    try {
        return (double) a / b;
    } catch (ArithmeticException e) {
        System.out.println("Error: División por cero");
        return 0;
    }
}
```
</details>

---

## 🎯 Puntuación

- **10 ejercicios totales**
- **Niveles:** 1 (básico) a 4 (avanzado)
- **Tipos:** Opción múltiple, completar código, escribir programas

---

**💡 Recuerda:** La práctica constante es el secreto del aprendizaje.
