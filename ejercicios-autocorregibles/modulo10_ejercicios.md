# Módulo 10: Entrada/Salida (I/O)
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## Conceptos Clave

- Clase File
- FileReader y FileWriter
- BufferedReader y BufferedWriter
- Scanner para archivos
- Manejo de rutas y directorios

---


### Ejercicio 1 - Nivel 1
**¿Qué clase se usa para representar un archivo o directorio?**

a) Document  
b) File  
c) Path  
d) Folder  

<details>
<summary>💡 Pista</summary>
La clase File representa archivos y directorios.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) File**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué método verifica si un archivo existe?**

a) isExist()  
b) exists()  
c) checkFile()  
d) hasFile()  

<details>
<summary>💡 Pista</summary>
exists() devuelve true si el archivo existe.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) exists()**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Para qué sirve BufferedReader?**

a) Escribir archivos  
b) Leer archivos eficientemente  
c) Crear archivos  
d) Borrar archivos  

<details>
<summary>💡 Pista</summary>
BufferedReader lee archivos de forma eficiente.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Leer archivos eficientemente línea por línea**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Qué clase usarías para escribir texto en un archivo?**

a) FileInput  
b) FileWriter  
c) TextWriter  
d) DocumentWriter  

<details>
<summary>💡 Pista</summary>
FileWriter escribe texto en archivos.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) FileWriter**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Qué método de File crea un nuevo archivo vacío?**

a) create()  
b) createNewFile()  
c) newFile()  
d) makeFile()  

<details>
<summary>💡 Pista</summary>
createNewFile() crea un archivo nuevo.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) createNewFile()**
</details>

---

### Ejercicio 6 - Nivel 3
**Completa: `File archivo = new File(____)`**

<details>
<summary>💡 Pista</summary>
new File("ruta/archivo.txt")
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
File archivo = new File("datos.txt");
```
</details>

---

### Ejercicio 7 - Nivel 3
**¿Cómo abres un archivo para lectura con FileReader?**

<details>
<summary>💡 Pista</summary>
FileReader fr = new FileReader("archivo.txt");
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
FileReader fr = new FileReader("archivo.txt");
```
</details>

---

### Ejercicio 8 - Nivel 3
**Escribe código para verificar si un archivo existe:**

<details>
<summary>💡 Pista</summary>
File f = new File("..."); if (f.exists()) { }
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
File f = new File("datos.txt");
if (f.exists()) {
    System.out.println("El archivo existe");
}
```
</details>

---

### Ejercicio 9 - Nivel 4
**Crea un método que lea todas las líneas de un archivo de texto:**

<details>
<summary>💡 Pista</summary>
Usa BufferedReader con readLine() en un bucle.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public static void leerArchivo(String ruta) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(ruta));
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
    br.close();
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Programa que escriba "Hola" en un archivo llamado saludo.txt:**

<details>
<summary>💡 Pista</summary>
FileWriter con write() o BufferedWriter.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class EscribirArchivo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("saludo.txt");
        fw.write("Hola");
        fw.close();
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
