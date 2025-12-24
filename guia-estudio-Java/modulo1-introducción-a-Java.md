# MÓDULO 1: INTRODUCCIÓN A JAVA

## 1. ¿Qué es Java y por qué aprenderlo?

Java es un lenguaje de programación de propósito general, orientado a objetos y diseñado para ser portable, seguro y robusto. Fue creado por Sun Microsystems (ahora propiedad de Oracle) en 1995 por James Gosling y su equipo.

### Características principales que hacen a Java relevante para ASIR:

**Portabilidad:** Java funciona bajo el principio “Write Once, Run Anywhere” (escribe una vez, ejecuta en cualquier lugar). Un programa Java puede ejecutarse en Windows, Linux, macOS y otros sistemas operativos sin necesidad de recompilarlo, algo fundamental cuando administras sistemas heterogéneos.

**Amplio uso en entornos empresariales:** Muchos servidores de aplicaciones, herramientas de monitorización y sistemas de gestión empresarial están desarrollados en Java. Como administrador de sistemas, encontrarás Java en:

- Servidores de aplicaciones (Apache Tomcat, JBoss, WebLogic)
- Herramientas de monitorización (Nagios, algunos módulos de Zabbix)
- Sistemas de big data (Hadoop, Apache Spark)
- Aplicaciones empresariales (SAP, Oracle)

**Automatización de tareas:** Java permite crear scripts robustos para automatizar tareas administrativas, procesar logs, gestionar configuraciones y monitorizar recursos del sistema.

**Gestión de redes y sistemas:** Java ofrece bibliotecas potentes para programación de red, gestión de procesos del sistema y manipulación de archivos, herramientas esenciales en la administración de sistemas.

## 2. Características principales del lenguaje

### Orientado a objetos

Java organiza el código en clases y objetos, lo que facilita la modularidad, reutilización y mantenimiento del código. Esto es especialmente útil cuando desarrollas herramientas administrativas complejas.

### Tipado fuerte

Java exige declarar el tipo de cada variable, lo que ayuda a detectar errores en tiempo de compilación y hace el código más predecible y seguro.

### Gestión automática de memoria

Java incluye un recolector de basura (garbage collector) que libera automáticamente la memoria no utilizada, reduciendo errores comunes de gestión de memoria.

### Seguridad

Java fue diseñado con la seguridad en mente, incorporando mecanismos de control de acceso, verificación de bytecode y un gestor de seguridad que protege los recursos del sistema.

### Multihilo

Java facilita la programación concurrente, permitiendo ejecutar múltiples tareas simultáneamente, útil para herramientas de monitorización que necesitan supervisar varios servicios a la vez.

### Robustez

El lenguaje incluye un sistema de manejo de excepciones que permite gestionar errores de forma elegante, evitando que los programas terminen abruptamente.

### Rica biblioteca estándar

Java proporciona miles de clases predefinidas para tareas comunes: manipulación de archivos, redes, bases de datos, procesamiento de XML/JSON, etc.

## 3. JDK, JRE y JVM: conceptos y diferencias

Entender estos tres componentes es fundamental para trabajar con Java:

### JVM (Java Virtual Machine - Máquina Virtual de Java)

Es el componente que ejecuta los programas Java. Actúa como una capa de abstracción entre el código Java y el sistema operativo subyacente. Cuando ejecutas un programa Java, la JVM:

- Lee el bytecode compilado
- Lo traduce a instrucciones nativas del procesador
- Gestiona la memoria automáticamente
- Proporciona seguridad y portabilidad

**Analogía:** La JVM es como un intérprete que traduce “lenguaje Java” a “lenguaje máquina” específico de tu sistema operativo.

### JRE (Java Runtime Environment - Entorno de Ejecución de Java)

Es el paquete necesario para **ejecutar** aplicaciones Java. Incluye:

- La JVM
- Las bibliotecas estándar de Java (clases predefinidas)
- Otros componentes necesarios para ejecutar aplicaciones

**Cuándo lo necesitas:** Si solo vas a ejecutar programas Java (no desarrollarlos), el JRE es suficiente. Por ejemplo, si instalas una aplicación empresarial que requiere Java.

### JDK (Java Development Kit - Kit de Desarrollo de Java)

Es el paquete completo para **desarrollar** aplicaciones Java. Incluye:

- Todo el JRE (por tanto, también la JVM)
- El compilador de Java (javac)
- Herramientas de desarrollo (debugger, javadoc, jar, etc.)
- Código fuente de las bibliotecas estándar

**Cuándo lo necesitas:** Para programar en Java necesitas el JDK completo.

### Esquema visual de la relación:

```
┌─────────────────────────────────────┐
│             JDK                     │
│  ┌───────────────────────────────┐  │
│  │          JRE                  │  │
│  │  ┌─────────────────────────┐  │  │
│  │  │        JVM              │  │  │
│  │  └─────────────────────────┘  │  │
│  │  + Bibliotecas estándar       │  │
│  └───────────────────────────────┘  │
│  + Compilador (javac)               │
│  + Herramientas de desarrollo       │
└─────────────────────────────────────┘
```

### Resumen práctico:

- **Solo ejecutar programas Java** → Necesitas JRE
- **Desarrollar programas Java** → Necesitas JDK (que incluye el JRE)
- **La JVM** → Está incluida tanto en JRE como en JDK

## 4. Instalación del entorno de desarrollo

### Paso 1: Descargar el JDK

**Para sistemas basados en Debian/Ubuntu:**

```bash
# Actualizar repositorios
sudo apt update

# Instalar OpenJDK (versión 17 LTS recomendada)
sudo apt install openjdk-17-jdk

# Verificar la instalación
java -version
javac -version
```

**Para Red Hat/CentOS/Fedora:**

```bash
# Instalar OpenJDK
sudo dnf install java-17-openjdk-devel

# Verificar la instalación
java -version
javac -version
```

**Para Windows:**

1. Descargar el JDK desde la página oficial de Oracle o adoptar OpenJDK (https://adoptium.net/)
1. Ejecutar el instalador
1. Configurar las variables de entorno:
- `JAVA_HOME`: ruta de instalación del JDK (ej: C:\Program Files\Java\jdk-17)
- Añadir `%JAVA_HOME%\bin` a la variable PATH
1. Verificar desde CMD o PowerShell:

```cmd
java -version
javac -version
```

### Paso 2: Elegir un editor o IDE

**Editores ligeros (recomendados para empezar):**

- **Visual Studio Code** con extensión “Extension Pack for Java”
- **Sublime Text** con paquetes para Java
- **Notepad++** (solo Windows)

**IDEs completos (recomendados una vez familiarizado con lo básico):**

- **IntelliJ IDEA Community Edition** (gratuito, muy potente)
- **Eclipse IDE** (gratuito, clásico)
- **NetBeans** (gratuito, incluye soporte para Java EE)

**Para empezar, recomendación:** Visual Studio Code o directamente un editor de texto simple con terminal.

### Paso 3: Configurar el espacio de trabajo

Crea una carpeta para tus proyectos Java:

```bash
# Linux/macOS
mkdir ~/java-proyectos
cd ~/java-proyectos

# Windows
mkdir C:\java-proyectos
cd C:\java-proyectos
```

## 5. Primer programa: “Hola Mundo”

Vamos a crear nuestro primer programa Java paso a paso.

### Paso 1: Crear el archivo fuente

Crea un archivo llamado `HolaMundo.java` (importante: el nombre debe coincidir exactamente con el nombre de la clase, incluyendo mayúsculas).

```java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("¡Hola Mundo desde Java!");
    }
}
```

### Análisis línea por línea:

**`public class HolaMundo {`**

- `public`: modificador de acceso que indica que la clase es accesible desde cualquier lugar
- `class`: palabra clave para declarar una clase
- `HolaMundo`: nombre de la clase (debe coincidir con el nombre del archivo)
- `{`: inicio del bloque de código de la clase

**`public static void main(String[] args) {`**

- `public`: el método es accesible desde fuera de la clase
- `static`: el método pertenece a la clase, no a instancias individuales
- `void`: el método no devuelve ningún valor
- `main`: nombre del método principal, punto de entrada del programa
- `String[] args`: parámetro que recibe argumentos de línea de comandos
- `{`: inicio del bloque del método

**`System.out.println("¡Hola Mundo desde Java!");`**

- `System`: clase que proporciona acceso a recursos del sistema
- `out`: objeto de salida estándar (consola)
- `println`: método que imprime texto y añade un salto de línea
- `"¡Hola Mundo desde Java!"`: cadena de texto a imprimir

**`}`**

- Cierre del método main

**`}`**

- Cierre de la clase

### Variaciones útiles:

```java
public class HolaMundo {
    public static void main(String[] args) {
        // print vs println
        System.out.print("Hola ");      // No añade salto de línea
        System.out.println("Mundo");    // Añade salto de línea

        // Imprimir variables
        String nombre = "Administrador";
        System.out.println("Bienvenido, " + nombre);

        // Imprimir con formato
        System.out.printf("Sistema operativo: %s%n", System.getProperty("os.name"));
    }
}
```

## 6. Compilación y ejecución de programas Java

Java es un lenguaje **compilado e interpretado**. El proceso tiene dos pasos:

### Paso 1: Compilación (código fuente → bytecode)

Abre una terminal en la carpeta donde guardaste `HolaMundo.java` y ejecuta:

```bash
javac HolaMundo.java
```

**¿Qué hace este comando?**

- `javac` es el compilador de Java
- Lee el archivo `HolaMundo.java`
- Verifica que no haya errores de sintaxis
- Genera un archivo `HolaMundo.class` que contiene bytecode

**Bytecode:** Es un código intermedio independiente de la plataforma que la JVM puede interpretar.

Si hay errores de compilación, el compilador te indicará la línea y tipo de error:

```
HolaMundo.java:3: error: ';' expected
        System.out.println("Hola Mundo")
                                        ^
1 error
```

### Paso 2: Ejecución (bytecode → ejecución por la JVM)

Una vez compilado sin errores, ejecuta el programa:

```bash
java HolaMundo
```

**¡Importante!** No incluyas la extensión `.class`. El comando `java` busca automáticamente el archivo de bytecode.

**Salida esperada:**

```
¡Hola Mundo desde Java!
```

### Diagrama del proceso completo:

```
HolaMundo.java  ──[javac]──>  HolaMundo.class  ──[java]──>  Salida en consola
(código fuente)             (bytecode)                    (¡Hola Mundo!)
```

### Pasar argumentos al programa

Los programas Java pueden recibir argumentos desde la línea de comandos:

```java
public class Saludo {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("¡Hola, " + args[0] + "!");
        } else {
            System.out.println("¡Hola, usuario!");
        }
    }
}
```

Compilar y ejecutar con argumentos:

```bash
javac Saludo.java
java Saludo Juan
```

Salida:

```
¡Hola, Juan!
```

### Comandos útiles para ASIR

**Ver la versión de Java:**

```bash
java -version
```

**Ver información detallada de la JVM:**

```bash
java -XshowSettings:all -version
```

**Compilar múltiples archivos:**

```bash
javac *.java
```

**Compilar con destino específico:**

```bash
javac -d bin HolaMundo.java
# Crea el .class en la carpeta bin/
```

**Ejecutar desde una carpeta específica:**

```bash
java -cp bin HolaMundo
# -cp o -classpath indica dónde buscar las clases
```

### Errores comunes y soluciones

**Error: “javac no se reconoce como comando”**

- Solución: El JDK no está instalado o no está en el PATH. Verifica la instalación y las variables de entorno.

**Error: “Could not find or load main class HolaMundo”**

- Solución: Asegúrate de estar en el directorio correcto y que el archivo .class exista.

**Error: “class HolaMundo is public, should be declared in a file named HolaMundo.java”**

- Solución: El nombre del archivo debe coincidir exactamente con el nombre de la clase pública.

**Error en tiempo de ejecución: “Exception in thread “main” java.lang.NoSuchMethodError: main”**

- Solución: Verifica que la firma del método main sea exactamente: `public static void main(String[] args)`

-----

## Ejercicios prácticos del Módulo 1

### Ejercicio 1: Información del sistema

Crea un programa que muestre información básica del sistema usando propiedades de Java:

```java
public class InfoSistema {
    public static void main(String[] args) {
        System.out.println("=== INFORMACIÓN DEL SISTEMA ===");
        System.out.println("Sistema Operativo: " + System.getProperty("os.name"));
        System.out.println("Versión: " + System.getProperty("os.version"));
        System.out.println("Arquitectura: " + System.getProperty("os.arch"));
        System.out.println("Usuario: " + System.getProperty("user.name"));
        System.out.println("Directorio actual: " + System.getProperty("user.dir"));
        System.out.println("Java versión: " + System.getProperty("java.version"));
    }
}
```

### Ejercicio 2: Saludo personalizado

Crea un programa que reciba nombre y apellido como argumentos y muestre un saludo personalizado:

```java
public class SaludoPersonalizado {
    public static void main(String[] args) {
        if (args.length >= 2) {
            System.out.println("Bienvenido al sistema, " + args[0] + " " + args[1]);
        } else {
            System.out.println("Uso: java SaludoPersonalizado <nombre> <apellido>");
        }
    }
}
```

### Ejercicio 3: Primera herramienta administrativa

Crea un programa simple que simule el inicio de una herramienta de monitorización:

```java
public class MonitorInicio {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║  Sistema de Monitorización v1.0   ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println();
        System.out.println("Inicializando servicios...");
        System.out.println("[OK] Módulo de red cargado");
        System.out.println("[OK] Módulo de disco cargado");
        System.out.println("[OK] Módulo de procesos cargado");
        System.out.println();
        System.out.println("Sistema listo. Fecha: " + new java.util.Date());
    }
}
```

-----

## Resumen del Módulo 1

Has aprendido:

- Qué es Java y por qué es relevante para administración de sistemas
- Las características principales del lenguaje
- La diferencia entre JDK, JRE y JVM
- Cómo instalar y configurar el entorno de desarrollo
- A escribir, compilar y ejecutar tu primer programa Java
- El proceso de compilación e interpretación de Java

**Conceptos clave para recordar:**

- Java es portable: “Write Once, Run Anywhere”
- Necesitas el JDK para desarrollar, el JRE solo para ejecutar
- El proceso es: código fuente (.java) → compilación → bytecode (.class) → ejecución en JVM
- El método `main` es el punto de entrada de todo programa Java
- El nombre del archivo debe coincidir con el nombre de la clase pública

**Próximo paso:** En el Módulo 2 profundizaremos en los fundamentos del lenguaje: variables, tipos de datos y operadores.
