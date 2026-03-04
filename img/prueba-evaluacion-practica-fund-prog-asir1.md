# Prueba de Evaluación Práctica: Fundamentos de Programación Java

**Módulo:** Fundamentos de Programación (Optativo)  
**Ciclo Formativo:** ASIR 1º Año  
**Duración:** 60 minutos  
**Nombre del Alumno:** _________________________________________________  
**Fecha:** __________________________

---

## 📋 Instrucciones Generales

1.  **Entorno:** Puedes utilizar el IDE de tu preferencia (IntelliJ, Eclipse, NetBeans) o un editor de texto junto con la consola.
2.  **Entrega:** Deberás entregar un único archivo comprimido `.zip` nombrado `Apellido_Nombre_ExamenJava.zip`. Este archivo debe contener los proyectos o archivos `.java` utilizados.
3.  **Criterios de Evaluación:**
    *   Sintaxis correcta del lenguaje Java.
    *   Lógica correcta en el uso de condicionales (`if`, `switch`).
    *   El código debe compilar y ejecutarse sin errores.
4.  **Contexto:** Todos los ejercicios están simulados sobre situaciones reales de administración de sistemas (servidores, redes, seguridad).

---

## 🟢 Bloque 1: Predicción de Salida (20 Puntos)
*Lee el siguiente fragmento de código y escribe exactamente qué se mostrará por consola. No es necesario ejecutar el código, solo razonar la salida.*  
**(Tiempo estimado: 5 minutos)**

### Ejercicio 1.1: Cálculo de ancho de banda residual
```java
int total = 100;
int usado = 30;
int reserva = 10;
int disponible = total - usado - reserva;
System.out.println("Disponible: " + disponible + " Mbps");
System.out.println("¿Es crítico? " + (disponible < 20));