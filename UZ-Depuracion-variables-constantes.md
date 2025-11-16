# Práctica: Uso del Depurador en PSeInt – Seguimiento de Variables y Constantes  
**Unidad:** UT1 – Fundamentos de Programación  
**Módulo:** Fundamentos de Programación | 1º ASIR  
**Profesor:** Ezequiel Llarena Borges  

---

## ¿Qué se espera que logres al finalizar la práctica?
- Comprender cómo funciona el **depurador (debugger)** de PSeInt.  
- Observar cómo **cambian los valores de las variables y constantes** paso a paso.  
- Relacionar la **teoría de variables y constantes** con su comportamiento real en un programa.  
- Desarrollar hábitos de **observación, análisis y comprobación** del código.

---

## Resultados de aprendizaje a trabajar 
- **RA3:** Escribe y prueba programas sencillos, reconociendo y aplicando los fundamentos de la programación.  
- **RA4:** Escribe y depura código, analizando y utilizando las estructuras de control del lenguaje.

---

## Objetivos de la práctica
1. Familiarizarse con la interfaz del depurador.  
2. Ejecutar un algoritmo paso a paso (modo “depurar”).  
3. Ver cómo se modifican los valores de las variables en tiempo real.  
4. Comprender la diferencia entre una **variable** (valor cambiante) y una **constante** (valor fijo).  

---

## 1️⃣ Preparación del entorno
1. Abre **PSeInt**.  
2. Crea un nuevo algoritmo llamado `Depuracion_Variables`.  
3. Asegúrate de que la **barra de depuración** esté visible.  
   - Si no la ves, activa desde el menú:  
     `Ver → Barras de herramientas → Depuración`.  

---

## 2️⃣ Código base para depurar

Copia este código en PSeInt:

```pseint
Proceso Depuracion_Variables
    Definir edad Como Entero;
    Definir nombre Como Cadena;
    Const PI <- 3.1416;
    
    Escribir "Introduce tu nombre:";
    Leer nombre;
    
    Escribir "Introduce tu edad:";
    Leer edad;
    
    Escribir "Hola ", nombre, ".";
    Escribir "Tu edad es: ", edad;
    Escribir "El valor de PI es: ", PI;
    
    edad <- edad + 1;
    Escribir "El próximo año tendrás: ", edad, " años.";
FinProceso
