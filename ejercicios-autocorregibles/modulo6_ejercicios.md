# Módulo 6: POO (Clases y Objetos)
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## 📚 Conceptos Clave

- Clases y objetos
- Atributos y métodos
- Constructores
- Encapsulación (private, public)
- La palabra clave this

---

## 📝 Ejercicios

### Ejercicio 1 - Nivel 1
**¿Qué palabra clave se usa para crear una nueva instancia de una clase?**

a) new  
b) create  
c) instance  
d) object  

<details>
<summary>💡 Pista</summary>
Se usa 'new' seguido del constructor.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**a) new**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué modificador de acceso hace que un atributo sea accesible solo dentro de la clase?**

a) public  
b) private  
c) protected  
d) default  

<details>
<summary>💡 Pista</summary>
private restringe el acceso solo a la clase.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) private**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Cuál es el propósito principal de un constructor?**

a) Destruir objetos  
b) Calcular valores  
c) Inicializar objetos  
d) Heredar propiedades  

<details>
<summary>💡 Pista</summary>
El constructor inicializa el estado del objeto.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**c) Inicializar objetos**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Qué palabra clave se usa para referirse al objeto actual dentro de un método?**

a) self  
b) this  
c) me  
d) current  

<details>
<summary>💡 Pista</summary>
'this' hace referencia al objeto actual.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) this**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Puede una clase tener más de un constructor?**

a) No, solo uno  
b) Sí, mediante sobrecarga  
c) Solo si es abstracta  
d) Solo si es final  

<details>
<summary>💡 Pista</summary>
Los constructores pueden sobrecargarse.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Sí, mediante sobrecarga**
</details>

---

### Ejercicio 6 - Nivel 3
**Completa: `public class Servidor { private String ___; }`**

<details>
<summary>💡 Pista</summary>
Los atributos suelen ser private y con nombres descriptivos.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class Servidor {
    private String nombre;
}
```

(O cualquier nombre descriptivo como ip, host, etc.)
</details>

---

### Ejercicio 7 - Nivel 3
**¿Cómo se llama un método desde el mismo objeto?**

<details>
<summary>💡 Pista</summary>
Usa 'this.nombreMetodo()' o directamente 'nombreMetodo()'.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**this.nombreMetodo()** o simplemente **nombreMetodo()**
</details>

---

### Ejercicio 8 - Nivel 3
**Escribe un constructor para una clase llamada Puerto que reciba un int:**

<details>
<summary>💡 Pista</summary>
public Puerto(int numero) { ... }
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public Puerto(int numero) {
    this.numero = numero;
}
```
</details>

---

### Ejercicio 9 - Nivel 4
**Crea una clase Servidor con atributo String nombre y un constructor:**

<details>
<summary>💡 Pista</summary>
Incluye la clase, atributo private, constructor public.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class Servidor {
    private String nombre;
    
    public Servidor(String nombre) {
        this.nombre = nombre;
    }
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Escribe una clase completa Red con atributo ip (String) y método mostrarIP():**

<details>
<summary>💡 Pista</summary>
Clase con atributo, constructor, y método.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class Red {
    private String ip;
    
    public Red(String ip) {
        this.ip = ip;
    }
    
    public void mostrarIP() {
        System.out.println("IP: " + ip);
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
