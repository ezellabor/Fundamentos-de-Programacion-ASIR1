# Módulo 11: Fechas y Tiempo
## Ejercicios de Autoevaluación

**Curso:** Fundamentos de programación  
**Profesor:** Ezequiel Llarena Borges  
**ASIR - Administración de Sistemas Informáticos en Red**

---

## 📚 Conceptos Clave

- LocalDate, LocalTime, LocalDateTime
- DateTimeFormatter
- Period y Duration
- Comparación de fechas
- Operaciones con fechas

---

## 📝 Ejercicios

### Ejercicio 1 - Nivel 1
**¿Qué clase representa solo una fecha (sin hora)?**

a) Date  
b) LocalDate  
c) Calendar  
d) DateTime  

<details>
<summary>💡 Pista</summary>
LocalDate representa solo la fecha.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) LocalDate**
</details>

---

### Ejercicio 2 - Nivel 1
**¿Qué clase representa fecha y hora juntas?**

a) DateTime  
b) LocalDateTime  
c) TimeStamp  
d) DateAndTime  

<details>
<summary>💡 Pista</summary>
LocalDateTime tiene fecha y hora.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) LocalDateTime**
</details>

---

### Ejercicio 3 - Nivel 2
**¿Cómo obtienes la fecha actual?**

a) LocalDate.now()  
b) Date.current()  
c) LocalDate.today()  
d) getCurrentDate()  

<details>
<summary>💡 Pista</summary>
LocalDate.now() devuelve la fecha actual.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**a) LocalDate.now()**
</details>

---

### Ejercicio 4 - Nivel 2
**¿Para qué sirve DateTimeFormatter?**

a) Calcular fechas  
b) Formatear/parsear fechas  
c) Comparar fechas  
d) Crear fechas  

<details>
<summary>💡 Pista</summary>
DateTimeFormatter formatea fechas a String y viceversa.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Formatear/parsear fechas**
</details>

---

### Ejercicio 5 - Nivel 2
**¿Qué clase mide la diferencia entre dos fechas?**

a) TimeDiff  
b) Period  
c) DateDiff  
d) Interval  

<details>
<summary>💡 Pista</summary>
Period representa el período entre dos fechas.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**b) Period**
</details>

---

### Ejercicio 6 - Nivel 3
**Completa: `LocalDate fecha = LocalDate.____();`**

<details>
<summary>💡 Pista</summary>
now() para la fecha actual.
</details>

<details>
<summary>✅ Respuesta correcta</summary>
**now()**

```java
LocalDate fecha = LocalDate.now();
```
</details>

---

### Ejercicio 7 - Nivel 3
**¿Cómo añades 7 días a una fecha llamada inicio?**

<details>
<summary>💡 Pista</summary>
inicio.plusDays(7)
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
LocalDate nuevaFecha = inicio.plusDays(7);
```
</details>

---

### Ejercicio 8 - Nivel 3
**Escribe código para obtener el año actual:**

<details>
<summary>💡 Pista</summary>
LocalDate.now().getYear()
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
int año = LocalDate.now().getYear();
```
</details>

---

### Ejercicio 9 - Nivel 4
**Crea un método que calcule la edad a partir de fecha de nacimiento:**

<details>
<summary>💡 Pista</summary>
Period.between(fechaNac, LocalDate.now()).getYears()
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public static int calcularEdad(LocalDate fechaNacimiento) {
    return Period.between(fechaNacimiento, LocalDate.now()).getYears();
}
```
</details>

---

### Ejercicio 10 - Nivel 4
**Programa que muestre la fecha en formato dd/MM/yyyy:**

<details>
<summary>💡 Pista</summary>
DateTimeFormatter con pattern y format().
</details>

<details>
<summary>✅ Respuesta correcta</summary>
```java
public class FormatearFecha {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(fecha.format(formato));
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
