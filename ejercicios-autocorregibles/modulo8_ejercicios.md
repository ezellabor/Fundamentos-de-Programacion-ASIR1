# Módulo 8: Manejo de Cadenas
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## Conceptos Clave

- Clase String y sus métodos
- StringBuilder y StringBuffer
- Comparación de cadenas
- Manipulación y formateo
- Expresiones regulares básicas

---


### Ejercicio 1 - Nivel 1
**¿Qué método de String devuelve la longitud de una cadena?**

a) size()  
b) length()  
c) count()  
d) getLength()  

<details>
<summary>💡 Pista</summary>
length() devuelve el número de caracteres.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) length()**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué método convierte una cadena a mayúsculas?**

a) toUpper()  
b) uppercase()  
c) toUpperCase()  
d) upper()  

<details>
<summary>💡 Pista</summary>
toUpperCase() convierte todo a mayúsculas.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**c) toUpperCase()**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Cuál es la diferencia entre == y equals() para comparar Strings?**

a) No hay diferencia  
b) == compara referencias, equals() compara contenido  
c) equals() es más rápido  
d) == compara contenido  

<details>
<summary>💡 Pista</summary>
== compara referencias en memoria, equals() el contenido.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) == compara referencias, equals() compara contenido**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Para qué se usa StringBuilder?**

a) Leer archivos  
b) Construir cadenas eficientemente  
c) Parsear números  
d) Formatear fechas  

<details>
<summary>💡 Pista</summary>
StringBuilder es eficiente para concatenar muchas cadenas.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Construir cadenas eficientemente**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Qué método extrae una subcadena de una cadena?**

a) sub()  
b) substring()  
c) extract()  
d) get()  

<details>
<summary>💡 Pista</summary>
substring(inicio, fin) extrae parte de la cadena.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) substring()**
</details>

---

### Ejercicio 6 - Nivel 3
**Completa: `String ip = "192.168.1.1"; String[] partes = ip.____(".")`**

<details>
<summary>💡 Pista</summary>
split() divide una cadena por un separador.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**split**

```java
String[] partes = ip.split("\\.");
```

(Nota: el punto debe escaparse con \\\\)
</details>

---

### Ejercicio 7 - Nivel 3
**¿Cómo verificas si una cadena contiene la palabra "error"?**

<details>
<summary>💡 Pista</summary>
str.contains("error")
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
str.contains("error")
```
</details>

---

### Ejercicio 8 - Nivel 3
**Escribe código que convierta "hola mundo" a "HOLA MUNDO":**

<details>
<summary>💡 Pista</summary>
String mayus = texto.toUpperCase();
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
String mayus = "hola mundo".toUpperCase();
```
</details>

---

### Ejercicio 9 - Nivel 4
**Crea un método que valide si un email contiene @:**

<details>
<summary>💡 Pista</summary>
Método que reciba String y use contains("@").
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public static boolean validarEmail(String email) {
    return email.contains("@");
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Programa que extraiga el dominio de una URL (después de //):**

<details>
<summary>💡 Pista</summary>
Usa indexOf(), substring() para extraer la parte del dominio.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class ExtraerDominio {
    public static void main(String[] args) {
        String url = "https://www.ejemplo.com/pagina";
        int inicio = url.indexOf("//") + 2;
        int fin = url.indexOf("/", inicio);
        String dominio = url.substring(inicio, fin);
        System.out.println(dominio);
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
