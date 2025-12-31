# Módulo 7: POO - Herencia y Polimorfismo
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## Conceptos Clave

- Herencia con extends
- Palabra clave super
- Sobrescritura de métodos (@Override)
- Polimorfismo
- Instanceof y casting

---


### Ejercicio 1 - Nivel 1
**¿Qué palabra clave se usa para heredar de otra clase?**

a) inherit  
b) extends  
c) implements  
d) super  

<details>
<summary>💡 Pista</summary>
extends se usa para la herencia de clases.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) extends**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué palabra clave llama al constructor de la clase padre?**

a) parent()  
b) super()  
c) base()  
d) father()  

<details>
<summary>💡 Pista</summary>
super() invoca el constructor del padre.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) super()**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Qué anotación se usa para indicar que un método sobrescribe otro de la clase padre?**

a) @Overwrite  
b) @Override  
c) @Rewrite  
d) @Super  

<details>
<summary>💡 Pista</summary>
@Override indica sobrescritura de métodos.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) @Override**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Qué es el polimorfismo?**

a) Tener muchas clases  
b) Un objeto puede tomar muchas formas  
c) Heredar de varias clases  
d) Crear muchos objetos  

<details>
<summary>💡 Pista</summary>
Polimorfismo permite que un objeto adopte diferentes formas.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Un objeto puede tomar muchas formas**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Para qué sirve el operador instanceof?**

a) Crear instancias  
b) Verificar el tipo de un objeto  
c) Comparar objetos  
d) Destruir objetos  

<details>
<summary>💡 Pista</summary>
instanceof verifica si un objeto es de cierto tipo.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Verificar el tipo de un objeto**
</details>

---

### Ejercicio 6 - Nivel 3
**Completa: `public class ServidorWeb ___ Servidor`**

<details>
<summary>💡 Pista</summary>
Usa 'extends' para heredar de Servidor.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**extends**

```java
public class ServidorWeb extends Servidor
```
</details>

---

### Ejercicio 7 - Nivel 3
**Escribe la llamada al constructor del padre si recibe un String nombre:**

<details>
<summary>💡 Pista</summary>
super(nombre);
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
super(nombre);
```
</details>

---

### Ejercicio 8 - Nivel 3
**Sobrescribe el método toString() para una clase Dispositivo:**

<details>
<summary>💡 Pista</summary>
@Override public String toString() { return...; }
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
@Override
public String toString() {
    return "Dispositivo: " + nombre;
}
```
</details>

---

### Ejercicio 9 - Nivel 4
**Crea una clase base Equipo y una subclase Router que la extienda:**

<details>
<summary>💡 Pista</summary>
Dos clases: Equipo base y Router extends Equipo.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class Equipo {
    private String nombre;
    
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
}

public class Router extends Equipo {
    public Router(String nombre) {
        super(nombre);
    }
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Programa con clase Animal, subclase Perro que sobrescriba hacerSonido():**

<details>
<summary>💡 Pista</summary>
Clase base Animal con método, subclase Perro con @Override.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class Animal {
    public void hacerSonido() {
        System.out.println("Sonido genérico");
    }
}

public class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau!");
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
