# Módulo 5: Métodos y Funciones
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## Conceptos clave

- Declaración y llamada de métodos
- Parámetros y valores de retorno
- Sobrecarga de métodos
- Métodos static vs instancia
- Ámbito de variables

---


### Ejercicio 1 - Nivel 1
**¿Qué palabra clave se usa para devolver un valor desde un método?**

a) send  
b) return  
c) give  
d) output  

<details>
<summary>💡 Pista</summary>
'return' significa 'retornar' o 'devolver'.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) return**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué tipo de retorno debe usar un método que NO devuelve ningún valor?**

a) int  
b) String  
c) void  
d) null  

<details>
<summary>💡 Pista</summary>
'void' significa 'vacío' - indica que el método no retorna nada.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**c) void**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Qué es la sobrecarga de métodos?**

a) Hacer un método muy complejo  
b) Varios métodos con el mismo nombre pero diferentes parámetros  
c) Métodos que tardan mucho  
d) Métodos recursivos  

<details>
<summary>💡 Pista</summary>
Por ejemplo: calcular(int a, int b) y calcular(double a, double b, double c)
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Varios métodos con el mismo nombre pero diferentes parámetros**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Cómo se llama un método static desde otra clase?**

a) objeto.metodo()  
b) NombreClase.metodo()  
c) static metodo()  
d) metodo.static()  

<details>
<summary>💡 Pista</summary>
Los métodos static pertenecen a la clase. Ejemplo: Math.sqrt()
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) NombreClase.metodo()**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Puede un método tener el mismo nombre que otro pero diferente cantidad de parámetros?**

a) No, nunca  
b) Sí, es sobrecarga  
c) Solo si son static  
d) Solo en clases abstractas  

<details>
<summary>💡 Pista</summary>
Java permite varios métodos con el mismo nombre si los parámetros son diferentes.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Sí, es sobrecarga de métodos**
</details>

---

### Ejercicio 6 - Nivel 3
**Completa la firma de un método que suma dos números enteros y devuelve el resultado:

```java
public static ____ sumar(int a, int b) {
    return a + b;
}
```**

<details>
<summary>💡 Pista</summary>
El método suma dos int y devuelve un int.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**int**
</details>

---

### Ejercicio 7 - Nivel 3
**Escribe la llamada correcta a un método llamado 'verificarPuerto' que recibe un int (puerto 80):**

<details>
<summary>💡 Pista</summary>
nombreMetodo(valorParametro);
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**verificarPuerto(80);**
</details>

---

### Ejercicio 8 - Nivel 3
**Escribe un método void llamado 'mostrarEstado' que reciba un String (estado) y lo imprima:**

<details>
<summary>💡 Pista</summary>
public static void nombreMetodo(tipo parametro) { println(...); }
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public static void mostrarEstado(String estado) {
    System.out.println(estado);
}
```
</details>

---

### Ejercicio 9 - Nivel 4
**Escribe DOS métodos sobrecargados llamados 'calcularAnchoBanda':
1. Uno que reciba dos int (total, usado)
2. Otro que reciba tres int (total, usado1, usado2)**

<details>
<summary>💡 Pista</summary>
Mismo nombre, diferente número de parámetros.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public static int calcularAnchoBanda(int total, int usado) {
    return total - usado;
}

public static int calcularAnchoBanda(int total, int usado1, int usado2) {
    return total - usado1 - usado2;
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Escribe un programa completo con un método que verifique si un puerto está en rango válido (1-65535):
El método debe recibir un int y devolver boolean**

<details>
<summary>💡 Pista</summary>
Método que devuelva boolean (puerto >= 1 && puerto <= 65535), main que lo pruebe.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class VerificarPuerto {
    public static boolean esPuertoValido(int puerto) {
        return puerto >= 1 && puerto <= 65535;
    }
    
    public static void main(String[] args) {
        System.out.println(esPuertoValido(80));
        System.out.println(esPuertoValido(70000));
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
