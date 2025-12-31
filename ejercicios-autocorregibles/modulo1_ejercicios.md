# Módulo 1: Introducción a Java
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## 📚 Conceptos Clave

- Características de Java (multiplataforma, orientado a objetos)
- JDK, JRE y JVM
- Bytecode y compilación
- Estructura básica de un programa
- Método main

---

## 📝 Ejercicios

### Ejercicio 1 - Nivel 1
**¿Qué significa que Java sea un lenguaje "multiplataforma"?**

a) Que solo funciona en Windows  
b) Que puede ejecutarse en diferentes sistemas operativos sin modificar el código  
c) Que necesita reescribirse para cada sistema operativo  
d) Que solo funciona en servidores

<details>
<summary>💡 Pista</summary>
El lema de Java es "Write Once, Run Anywhere". Piensa en qué opción refleja esta idea.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Que puede ejecutarse en diferentes sistemas operativos sin modificar el código**

Java es multiplataforma porque el bytecode compilado puede ejecutarse en cualquier sistema que tenga una JVM (Java Virtual Machine), sin necesidad de recompilar el código fuente.
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué extensión tienen los archivos de código fuente Java?**

a) .class  
b) .java  
c) .jar  
d) .exe

<details>
<summary>💡 Pista</summary>
El código fuente es el que escribes tú directamente. Los archivos compilados tienen otra extensión diferente.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) .java**

Los archivos de código fuente tienen extensión `.java`. Después de compilar, se generan archivos `.class` con el bytecode.
</details>

---

### Ejercicio 3 - Nivel 2
**¿Qué componente es responsable de ejecutar el bytecode de Java?**

a) JDK (Java Development Kit)  
b) javac (compilador)  
c) JVM (Java Virtual Machine)  
d) IDE (Entorno de Desarrollo)

<details>
<summary>💡 Pista</summary>
Piensa en una "máquina virtual" que interpreta y ejecuta el bytecode.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**c) JVM (Java Virtual Machine)**

La JVM es la máquina virtual que ejecuta el bytecode de Java. Es la clave de la portabilidad de Java.
</details>

---

### Ejercicio 4 - Nivel 2
**¿Qué comando usarías para compilar un archivo llamado "Programa.java"?**

a) java Programa.java  
b) javac Programa.java  
c) compile Programa.java  
d) java Programa

<details>
<summary>💡 Pista</summary>
El compilador de Java se llama "javac". La "c" viene de "compiler".
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) javac Programa.java**

`javac` es el compilador de Java. Genera archivos `.class` con el bytecode.
</details>

---

### Ejercicio 5 - Nivel 2
**¿Cuál es la diferencia principal entre JDK y JRE?**

a) No hay diferencia, son lo mismo  
b) JDK incluye herramientas de desarrollo (compilador, depurador), JRE solo permite ejecutar programas  
c) JRE es más moderno que JDK  
d) JDK es solo para Windows y JRE para Linux

<details>
<summary>💡 Pista</summary>
JDK = Java Development Kit (para desarrolladores). JRE = Java Runtime Environment (para usuarios finales).
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) JDK incluye herramientas de desarrollo (compilador, depurador), JRE solo permite ejecutar programas**

- **JDK:** Incluye JRE + herramientas de desarrollo (javac, debugger, etc.)
- **JRE:** Solo permite ejecutar aplicaciones Java ya compiladas
</details>

---

### Ejercicio 6 - Nivel 3
**Ordena correctamente los pasos del ciclo de vida de un programa Java:**

**Pasos:**
- A) La JVM ejecuta el bytecode
- B) Escribimos el código fuente (.java)
- C) El compilador javac genera bytecode (.class)
- D) Se produce la salida del programa

<details>
<summary>💡 Pista</summary>
El proceso siempre empieza escribiendo código y termina con el resultado final.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**Orden correcto: B, C, A, D**

1. **B)** Escribimos el código fuente (.java)
2. **C)** El compilador javac genera bytecode (.class)
3. **A)** La JVM ejecuta el bytecode
4. **D)** Se produce la salida del programa
</details>

---

### Ejercicio 7 - Nivel 3
**Completa la línea que falta en este programa "Hola Mundo":**

```java
public class HolaMundo {
    public static void main(String[] args) {
        ___________________________________________
    }
}
```

<details>
<summary>💡 Pista</summary>
Usa System.out.println() para imprimir. El texto va entre comillas dobles y termina con punto y coma.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
System.out.println("Hola Mundo");
```

- `System.out.println()` imprime texto en la consola
- El texto va entre comillas dobles `"..."`
- Termina con punto y coma `;`
</details>

---

### Ejercicio 8 - Nivel 3
**Observa este programa. ¿Cuál es el nombre de la clase?**

```java
public class MiPrimerPrograma {
    public static void main(String[] args) {
        System.out.println("Bienvenido a Java");
    }
}
```

<details>
<summary>💡 Pista</summary>
El nombre de la clase aparece después de "public class". Respeta mayúsculas y minúsculas.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**MiPrimerPrograma**

El nombre de la clase es `MiPrimerPrograma` (exactamente como aparece, respetando mayúsculas y minúsculas).
</details>

---

### Ejercicio 9 - Nivel 4
**Este programa tiene errores. Identifica al menos 3 errores y explica cómo corregirlos:**

```java
public clase Saludo {
    public static void main(string[] args) {
        System.out.printline("Hola")
    }
}
```

<details>
<summary>💡 Pista</summary>
Revisa: palabra clave para definir clase, tipo String con mayúscula, nombre del método println, y punto y coma.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**Errores encontrados:**

1. **"clase"** debe ser **"class"** (palabra clave en inglés)
2. **"string"** debe ser **"String"** (con S mayúscula)
3. **"printline"** debe ser **"println"** (sin la 'e' extra)
4. Falta **punto y coma (;)** al final de la línea de println

**Código corregido:**
```java
public class Saludo {
    public static void main(String[] args) {
        System.out.println("Hola");
    }
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Escribe un programa Java completo llamado "Bienvenida" que imprima dos líneas:**

- Primera línea: "Bienvenido al curso de Java"
- Segunda línea: "Preparado para ASIR"

<details>
<summary>💡 Pista</summary>
Necesitas: public class Bienvenida, el método main, y dos System.out.println() diferentes.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class Bienvenida {
    public static void main(String[] args) {
        System.out.println("Bienvenido al curso de Java");
        System.out.println("Preparado para ASIR");
    }
}
```

**Elementos clave:**
- Clase `Bienvenida` con mayúscula inicial
- Método `main` estándar
- Dos llamadas a `println()` separadas
- Textos entre comillas dobles
- Punto y coma al final de cada instrucción
</details>

---

## 🎯 Puntuación

- **10 ejercicios totales**
- **Niveles:** 1 (básico) a 4 (avanzado)
- **Tipos:** Opción múltiple, completar código, escribir programas

---

**💡 Recuerda:** La práctica constante es el secreto del aprendizaje.
