<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# MÓDULO 8: MANEJO DE CADENAS

## 1. La clase String

La clase **String** representa cadenas de caracteres inmutables en Java. Es una de las clases más utilizadas del lenguaje.

### Características principales

- **Inmutable**: Una vez creado, su contenido no puede cambiar
- **Objeto**: String es una clase, no un tipo primitivo
- **Pool de Strings**: Java mantiene un pool de literales para optimizar memoria

### Creación de Strings

```java
// Forma 1: Literal (recomendada)
String mensaje = "Hola Mundo";

// Forma 2: Constructor (no recomendada para literales)
String mensaje2 = new String("Hola Mundo");

// String vacío
String vacio1 = "";
String vacio2 = new String();

// Concatenación
String saludo = "Hola" + " " + "Mundo";
String nombre = "Carlos";
String bienvenida = "Bienvenido, " + nombre;
```

### Inmutabilidad

```java
String texto = "Java";
texto.toUpperCase();  // Crea un nuevo String, no modifica el original
System.out.println(texto);  // Imprime "Java" (sin cambios)

// Para modificar, debemos reasignar
texto = texto.toUpperCase();
System.out.println(texto);  // Imprime "JAVA"
```

## 2. Métodos principales de String

### Métodos de información

```java
String texto = "Administración de Sistemas";

// Longitud
int longitud = texto.length();  // 26

// Carácter en posición
char letra = texto.charAt(0);  // 'A'

// ¿Está vacío?
boolean vacio = texto.isEmpty();  // false
boolean vacio2 = "".isEmpty();   // true

// ¿Está en blanco? (Java 11+)
boolean blanco = "   ".isBlank();  // true
```

### Métodos de búsqueda

```java
String log = "ERROR: Conexión perdida en servidor web";

// Contiene
boolean tiene = log.contains("ERROR");  // true

// Comienza con
boolean esError = log.startsWith("ERROR");  // true

// Termina con
boolean esWeb = log.endsWith("web");  // true

// Índice de primera aparición
int pos = log.indexOf("servidor");  // 29
int noEncontrado = log.indexOf("MySQL");  // -1

// Índice de última aparición
int ultima = log.lastIndexOf("e");  // 35
```

### Métodos de extracción

```java
String ruta = "/var/log/syslog";

// Substring desde posición
String desde = ruta.substring(5);  // "log/syslog"

// Substring entre posiciones
String entre = ruta.substring(5, 8);  // "log"

// Split (dividir)
String[] partes = ruta.split("/");
// partes = ["", "var", "log", "syslog"]

String csv = "192.168.1.100,80,HTTP,OK";
String[] datos = csv.split(",");
// datos = ["192.168.1.100", "80", "HTTP", "OK"]
```

### Métodos de transformación

```java
String comando = "  apt update  ";

// Mayúsculas y minúsculas
String mayus = comando.toUpperCase();    // "  APT UPDATE  "
String minus = comando.toLowerCase();     // "  apt update  "

// Eliminar espacios al inicio y final
String limpio = comando.trim();          // "apt update"

// Reemplazar
String modificado = comando.replace("update", "upgrade");
// "  apt upgrade  "

// Reemplazar con expresión regular
String ip = "192.168.001.100";
String ipCorregida = ip.replaceAll("0+(\\d)", "$1");
// "192.168.1.100"
```

### Ejemplo práctico: Procesamiento de logs

```java
public class AnalizadorLogs {
    public static void analizarLinea(String linea) {
        // Formato: "2024-01-15 10:30:45 ERROR Conexión fallida"

        if (linea.isEmpty() || linea.isBlank()) {
            return;
        }

        linea = linea.trim();

        String[] partes = linea.split(" ");
        String fecha = partes[0];
        String hora = partes[1];
        String nivel = partes[2];

        if (nivel.equals("ERROR") || nivel.equals("CRITICAL")) {
            System.out.println("⚠️ Alerta: " + linea);
        }

        // Extraer mensaje
        int indiceMsg = linea.indexOf(nivel) + nivel.length();
        String mensaje = linea.substring(indiceMsg).trim();

        System.out.println("Fecha: " + fecha);
        System.out.println("Nivel: " + nivel);
        System.out.println("Mensaje: " + mensaje);
    }
}
```

## 3. Comparación de cadenas

### Comparación incorrecta (==)

```java
String s1 = "admin";
String s2 = "admin";
String s3 = new String("admin");

System.out.println(s1 == s2);   // true (mismo literal del pool)
System.out.println(s1 == s3);   // false (diferentes objetos)
```

### Comparación correcta (equals)

```java
String usuario1 = "admin";
String usuario2 = "admin";
String usuario3 = new String("admin");

// equals() compara contenido
System.out.println(usuario1.equals(usuario2));  // true
System.out.println(usuario1.equals(usuario3));  // true

// equalsIgnoreCase() ignora mayúsculas/minúsculas
String cmd1 = "SHUTDOWN";
String cmd2 = "shutdown";
System.out.println(cmd1.equalsIgnoreCase(cmd2));  // true
```

### Comparación lexicográfica

```java
String a = "apache";
String b = "mysql";
String c = "apache";

int resultado = a.compareTo(b);
// < 0 si a < b
// = 0 si a = b
// > 0 si a > b

System.out.println(a.compareTo(b));  // negativo (apache < mysql)
System.out.println(a.compareTo(c));  // 0 (son iguales)
System.out.println(b.compareTo(a));  // positivo (mysql > apache)
```

### Ejemplo: Validación de contraseñas

```java
public class ValidadorPassword {
    public static boolean validar(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean tieneMayuscula = !password.equals(password.toLowerCase());
        boolean tieneMinuscula = !password.equals(password.toUpperCase());
        boolean tieneNumero = password.matches(".*\\d.*");

        return tieneMayuscula && tieneMinuscula && tieneNumero;
    }

    public static void main(String[] args) {
        System.out.println(validar("admin"));        // false
        System.out.println(validar("Admin123"));     // true
        System.out.println(validar("PASSWORD"));     // false
    }
}
```

## 4. StringBuilder y StringBuffer

Cuando necesitas modificar cadenas frecuentemente, **StringBuilder** y **StringBuffer** son más eficientes que String.

### Diferencias

|Característica|String                    |StringBuilder            |StringBuffer|
|--------------|--------------------------|-------------------------|------------|
|Mutabilidad   |Inmutable                 |Mutable                  |Mutable     |
|Thread-safe   |Sí                        |No                       |Sí          |
|Rendimiento   |Lento para concatenaciones|Rápido                   |Medio       |
|Uso           |Cadenas constantes        |Modificaciones frecuentes|Multihilo   |

### StringBuilder

```java
StringBuilder sb = new StringBuilder();

// Agregar al final
sb.append("Sistema: ");
sb.append("Linux");
sb.append(" Ubuntu");

// Insertar en posición
sb.insert(8, " OS");  // "Sistema: OS Linux Ubuntu"

// Eliminar rango
sb.delete(9, 12);  // Elimina "OS "

// Reemplazar
sb.replace(0, 7, "SO");  // "SO: Linux Ubuntu"

// Invertir
sb.reverse();  // "utnubU xuniL :OS"

// Convertir a String
String resultado = sb.toString();
```

### Ejemplo práctico: Construcción de comandos

```java
public class ConstructorComandos {
    public static String crearComandoBackup(String origen, String destino,
                                           boolean compresion, boolean verbose) {
        StringBuilder cmd = new StringBuilder();
        cmd.append("tar ");

        if (compresion) {
            cmd.append("-czf ");
        } else {
            cmd.append("-cf ");
        }

        if (verbose) {
            cmd.append("-v ");
        }

        cmd.append(destino);
        cmd.append(" ");
        cmd.append(origen);

        return cmd.toString();
    }

    public static void main(String[] args) {
        String comando = crearComandoBackup("/var/www",
                                           "/backup/web.tar.gz",
                                           true, true);
        System.out.println(comando);
        // tar -czf -v /backup/web.tar.gz /var/www
    }
}
```

### Concatenación eficiente

```java
// ❌ Ineficiente (crea muchos objetos String)
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado += i + ",";
}

// ✅ Eficiente
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i).append(",");
}
String resultado = sb.toString();
```

## 5. Expresiones regulares básicas

Las expresiones regulares (regex) permiten buscar y manipular patrones en cadenas.

### Métodos de String con regex

```java
String texto = "Mi IP es 192.168.1.100";

// matches() - Comprueba si toda la cadena coincide
boolean esIP = texto.matches("\\d+\\.\\d+\\.\\d+\\.\\d+");  // false

// replaceAll() - Reemplaza todas las coincidencias
String censurado = texto.replaceAll("\\d", "X");
// "Mi IP es XXX.XXX.X.XXX"

// replaceFirst() - Reemplaza la primera coincidencia
String parcial = texto.replaceFirst("\\d+", "XXX");
// "Mi IP es XXX.168.1.100"

// split() con regex
String numeros = "1,2;3:4|5";
String[] array = numeros.split("[,;:|]");
// ["1", "2", "3", "4", "5"]
```

### Patrones comunes

```java
// Validar dirección IP
public static boolean esIPValida(String ip) {
    String patron = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                   "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    return ip.matches(patron);
}

// Validar email
public static boolean esEmailValido(String email) {
    String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    return email.matches(patron);
}

// Extraer números
public static void extraerNumeros(String texto) {
    String patron = "\\d+";
    java.util.regex.Pattern p = java.util.regex.Pattern.compile(patron);
    java.util.regex.Matcher m = p.matcher(texto);

    while (m.find()) {
        System.out.println(m.group());
    }
}
```

### Ejemplo: Análisis de archivo de configuración

```java
import java.util.regex.*;

public class ParserConfiguracion {
    public static void parsearLinea(String linea) {
        // Formato: clave=valor
        Pattern patron = Pattern.compile("^([a-zA-Z_]+)=(.+)$");
        Matcher matcher = patron.matcher(linea.trim());

        if (matcher.matches()) {
            String clave = matcher.group(1);
            String valor = matcher.group(2);
            System.out.println(clave + " -> " + valor);
        }
    }

    public static void main(String[] args) {
        String[] config = {
            "server_port=8080",
            "database_host=localhost",
            "max_connections=100"
        };

        for (String linea : config) {
            parsearLinea(linea);
        }
    }
}
```

### Caracteres especiales de regex

|Patrón  |Significado               |Ejemplo                     |
|--------|--------------------------|----------------------------|
|`.`     |Cualquier carácter        |`"a.c"` → abc, a1c          |
|`\d`    |Dígito [0-9]              |`"\\d+"` → 123              |
|`\D`    |No dígito                 |`"\\D+"` → abc              |
|`\w`    |Palabra [a-zA-Z0-9_]      |`"\\w+"` → user_1           |
|`\s`    |Espacio en blanco         |`"\\s+"` → espacios         |
|`^`     |Inicio de línea           |`"^ERROR"` → ERROR al inicio|
|`$`     |Final de línea            |`"OK$"` → OK al final       |
|`*`     |0 o más veces             |`"a*"` → “”, a, aa          |
|`+`     |1 o más veces             |`"a+"` → a, aa              |
|`?`     |0 o 1 vez                 |`"a?"` → “”, a              |
|`{n}`   |Exactamente n veces       |`"a{3}"` → aaa              |
|`{n,}`  |n o más veces             |`"a{2,}"` → aa, aaa         |
|`{n,m}` |Entre n y m veces         |`"a{2,4}"` → aa, aaa, aaaa  |
|`[abc]` |a, b o c                  |`"[aeiou]"` → vocal         |
|`[^abc]`|Cualquiera excepto a, b, c|`"[^0-9]"` → no dígito      |

## 6. Formateo de cadenas

### String.format()

```java
String nombre = "Apache";
int puerto = 80;
double uso = 45.67;

// Formato básico
String msg = String.format("Servidor %s en puerto %d", nombre, puerto);
// "Servidor Apache en puerto 80"

// Con especificadores de formato
String info = String.format("Uso: %.2f%%", uso);
// "Uso: 45.67%"

// Alineación
String tabla = String.format("%-10s | %5d | %6.2f", nombre, puerto, uso);
// "Apache     |    80 |  45.67"
```

### printf() - Imprimir directamente

```java
System.out.printf("IP: %s, Puerto: %d%n", "192.168.1.1", 22);
System.out.printf("Uso CPU: %6.2f%%%n", 78.5);
```

### Especificadores de formato comunes

|Especificador|Tipo                     |Ejemplo                |
|-------------|-------------------------|-----------------------|
|`%s`         |String                   |`%s` → “texto”         |
|`%d`         |Entero decimal           |`%d` → 123             |
|`%f`         |Punto flotante           |`%f` → 45.67           |
|`%.2f`       |Float con 2 decimales    |`%.2f` → 45.67         |
|`%n`         |Nueva línea              |System.out.printf(”%n”)|
|`%5d`        |Entero con ancho 5       |`%5d` → “  123”        |
|`%-5d`       |Entero alineado izquierda|`%-5d` → “123  “       |
|`%x`         |Hexadecimal              |`%x` → ff              |
|`%o`         |Octal                    |`%o` → 177             |

### Ejemplo práctico: Reporte de servidores

```java
public class ReporteServidores {
    public static void main(String[] args) {
        System.out.printf("%-15s | %-10s | %6s | %8s%n",
                         "SERVIDOR", "IP", "PUERTO", "USO CPU");
        System.out.println("-".repeat(55));

        System.out.printf("%-15s | %-10s | %6d | %7.2f%%%n",
                         "web-server", "10.0.1.10", 80, 23.45);
        System.out.printf("%-15s | %-10s | %6d | %7.2f%%%n",
                         "db-server", "10.0.1.20", 3306, 67.89);
        System.out.printf("%-15s | %-10s | %6d | %7.2f%%%n",
                         "mail-server", "10.0.1.30", 25, 12.34);
    }
}
```

**Salida:**

```
SERVIDOR        | IP         | PUERTO |  USO CPU
-------------------------------------------------------
web-server      | 10.0.1.10  |     80 |   23.45%
db-server       | 10.0.1.20  |   3306 |   67.89%
mail-server     | 10.0.1.30  |     25 |   12.34%
```

## Ejercicios prácticos

### Ejercicio 1: Validador de rutas

Crea un validador que compruebe si una ruta de archivo es válida en Linux.

### Ejercicio 2: Parser de logs Apache

Analiza líneas de log de Apache y extrae IP, fecha, método HTTP y código de estado.

### Ejercicio 3: Generador de configuraciones

Crea un generador que construya archivos de configuración a partir de parámetros.

-----

## **Conceptos clave del módulo:**

- String es inmutable, StringBuilder es mutable y eficiente
- equals() compara contenido, == compara referencias
- Expresiones regulares permiten buscar patrones complejos
- String.format() permite formatear cadenas de forma elegante
- Los métodos de String no modifican el original, retornan nuevos String

  ---

  
