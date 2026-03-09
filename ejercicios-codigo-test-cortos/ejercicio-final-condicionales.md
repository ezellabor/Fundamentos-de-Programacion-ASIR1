# Fundamentos de Programación (Java)

**Módulo:** Fundamentos de Programación (FUNDPROG)  
**Curso:** 1º ASIR (Administración de Sistemas Informáticos en Red)  

## Instrucciones generales

1.  Este ejercicio final consta de **3 bloques** y **10 preguntas** en total.
2.  Escribe el código Java de forma clara y legible.
3.  No es necesario importar librerías extras (`Scanner`, etc.) salvo que se indique.

---

## Bloque 1: Traza de código

*Lee el siguiente fragmento de código y escribe exactamente qué se mostrará por consola (`System.out.println`).*

### 1.1. Operadores relacionales
```java
int puertosAbiertos = 80;
System.out.println(puertosAbiertos >= 1024);
```
### 1.2. Operadores lógicos  
```java  
boolean servidorActivo = true;
boolean hayConexion = false;
System.out.println(servidorActivo && hayConexion);
```
### 1.3. Sentencia Switch simple  
```java
int nivelLog = 2;
switch(nivelLog) {
    case 1: System.out.println("INFO"); break;
    case 2: System.out.println("ERROR"); break;
}
```

## Bloque 2: Completar código  

*Completa los espacios en blanco (_______) para que el código funcione según lo solicitado.*  

### 2.1. Validación de puerto  

Un puerto es válido si está entre 1 y 65535. Completa la condición ```if```.  
```java
int puerto = 443;
if (puerto >= 1 _______ puerto <= 65535) {
    System.out.println("Puerto válido");
}
```
### 2.2. Rol de usuario  
*Si el usuario es "admin", debe tener acceso. Completa la estructura ```if-else```.*  
```java
String rol = "admin";
if (_______) {
    System.out.println("Acceso concedido");
} else {
    System.out.println("Acceso denegado");
}
```
### 2.3. Estado del servicio  

*Completa el ```switch``` para manejar el estado "STOP".*

```java
String estado = "STOP";
switch(estado) {
    case "START": System.out.println("Iniciando"); break;
    _______ "STOP": System.out.println("Detenido"); break;
    default: System.out.println("Desconocido");
}

```
### 2.4. Anidamiento básico  

*Si hay energía (```power``` true) Y el switch está encendido (```on``` true), encender PC.*  
```java
boolean power = true;
boolean on = true;
if (power) {
    if (_______) {
        System.out.println("PC Encendido");
    }
}
```

## Bloque 3: Lógica conpleta  

*Resuelve los siguientes supuestos prácticos relacionados con redes y hardware. Escribe la lógica completa en el espacio reservado.*  

### 3.1. Validación de primer octeto IP  

*Escribe un ```if-else``` que valide si el primer octeto de una IP (``int octeto```) es válido (entre 1 y 223 para Clase A/B/C estándar). Si es válido imprime "IP Clase Valida", si no "IP Reservada o Invalida".*  
```java
int octeto = 192;

// Escribe tu código aquí:

```

### 3.2. Requisitos de RAM para virtualización  

*Usa un ```if-else if-else``` para determinar si un host puede correr máquinas virtuales.*  

- Si ```ramGB``` >= 16: "Óptimo para Virtualización".  
- Si ```ramGB``` >= 8: "Posible pero limitado".
- Si no: "Insuficiente".  
```java
int ramGB = 12;

// Escribe tu código aquí:


```

### 3.3. Menú de administración de usuarios (Switch)  

*Crea un ```switch``` basado en una variable ```int opcion``` (1, 2 o 3).*  

- 1: "Crear Usuario".  
- 2: "Borrar Usuario".
- 3: "Listar Usuarios".
- Cualquier otro: "Opción no válida".
- Importante: No olvides los ```break```.
  
```java
int opcion = 2;

// Escribe tu código aquí:


```
