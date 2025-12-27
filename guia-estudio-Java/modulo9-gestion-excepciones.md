<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# MÓDULO 9: GESTIÓN DE EXCEPCIONES

## 1. ¿Qué son las excepciones?

Una **excepción** es un evento que ocurre durante la ejecución de un programa y que interrumpe el flujo normal de instrucciones.

### Concepto

- Las excepciones representan **errores** o **situaciones excepcionales**
- Permiten **separar** el código de manejo de errores del código principal
- Java usa un mecanismo de **propagación** de excepciones

### Tipos de errores

```java
// 1. Error de compilación (no compila)
int numero = "texto";  // Error de tipo

// 2. Error de ejecución (excepción)
int division = 10 / 0;  // ArithmeticException

// 3. Error lógico (programa funciona pero resultado incorrecto)
int promedio = (nota1 + nota2) / 3;  // Debería ser / 2
```

### Jerarquía de excepciones

```
Object
  └── Throwable
       ├── Error (errores graves del sistema)
       │    └── OutOfMemoryError, StackOverflowError...
       └── Exception
            ├── RuntimeException (no verificadas)
            │    ├── NullPointerException
            │    ├── ArrayIndexOutOfBoundsException
            │    ├── ArithmeticException
            │    └── IllegalArgumentException
            └── IOException (verificadas)
                 ├── FileNotFoundException
                 ├── EOFException
                 └── SocketException
```

## 2. Try-Catch-Finally

### Estructura básica

```java
try {
    // Código que puede lanzar excepciones
    int resultado = dividir(10, 0);
} catch (ArithmeticException e) {
    // Manejo del error específico
    System.out.println("Error: División por cero");
} finally {
    // Código que SIEMPRE se ejecuta
    System.out.println("Operación finalizada");
}
```

### Try-Catch simple

```java
public class LectorArchivo {
    public static void leerArchivo(String ruta) {
        try {
            Scanner sc = new Scanner(new File(ruta));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no existe - " + ruta);
        }
    }
}
```

### Múltiples bloques catch

```java
public class ConexionServidor {
    public static void conectar(String ip, String puerto) {
        try {
            int puertoNum = Integer.parseInt(puerto);
            Socket socket = new Socket(ip, puertoNum);
            System.out.println("Conectado a " + ip + ":" + puerto);
            socket.close();

        } catch (NumberFormatException e) {
            System.out.println("Error: El puerto debe ser un número");

        } catch (UnknownHostException e) {
            System.out.println("Error: Host desconocido - " + ip);

        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
```

### Multi-catch (Java 7+)

```java
try {
    String contenido = leerArchivo("config.txt");
    int valor = Integer.parseInt(contenido);

} catch (IOException | NumberFormatException e) {
    // Manejo común para ambas excepciones
    System.out.println("Error al procesar archivo: " + e.getMessage());
}
```

### Bloque Finally

El bloque `finally` **siempre se ejecuta**, independientemente de si ocurre una excepción o no.

```java
FileWriter writer = null;
try {
    writer = new FileWriter("/var/log/app.log");
    writer.write("Log entry");

} catch (IOException e) {
    System.out.println("Error al escribir: " + e.getMessage());

} finally {
    // Cerrar recursos SIEMPRE
    if (writer != null) {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar archivo");
        }
    }
}
```

### Try-with-resources (Java 7+)

Cierra automáticamente recursos que implementan `AutoCloseable`.

```java
// ✅ Forma moderna y recomendada
try (FileWriter writer = new FileWriter("/var/log/app.log");
     BufferedWriter bw = new BufferedWriter(writer)) {

    bw.write("Log entry");
    bw.newLine();

} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
// Los recursos se cierran automáticamente
```

## 3. Tipos de excepciones

### Excepciones verificadas (Checked Exceptions)

Son excepciones que el compilador **obliga** a manejar o declarar.

```java
// Ejemplos comunes
FileNotFoundException
IOException
SQLException
ClassNotFoundException
```

```java
// DEBE manejarse o declararse
public void leerArchivo(String ruta) throws IOException {
    FileReader fr = new FileReader(ruta);  // Puede lanzar IOException
    // ...
}

// O manejarla
public void leerArchivo(String ruta) {
    try {
        FileReader fr = new FileReader(ruta);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

### Excepciones no verificadas (Unchecked Exceptions)

Heredan de `RuntimeException`. **No es obligatorio** manejarlas.

```java
// Ejemplos comunes
NullPointerException
ArrayIndexOutOfBoundsException
ArithmeticException
IllegalArgumentException
NumberFormatException
```

```java
// No es obligatorio manejarlas (pero es buena práctica)
public int dividir(int a, int b) {
    return a / b;  // Puede lanzar ArithmeticException
}

// Mejor con validación
public int dividir(int a, int b) {
    if (b == 0) {
        throw new IllegalArgumentException("El divisor no puede ser cero");
    }
    return a / b;
}
```

### Errores (Errors)

Problemas graves del sistema que **no deberían capturarse**.

```java
OutOfMemoryError
StackOverflowError
VirtualMachineError
```

## 4. Lanzamiento de excepciones (throw)

La palabra clave `throw` permite lanzar una excepción manualmente.

### Sintaxis básica

```java
public void setEdad(int edad) {
    if (edad < 0 || edad > 120) {
        throw new IllegalArgumentException("Edad inválida: " + edad);
    }
    this.edad = edad;
}
```

### Ejemplo: Validación de credenciales

```java
public class ValidadorCredenciales {
    public static void validarUsuario(String usuario, String password) {
        if (usuario == null || usuario.isEmpty()) {
            throw new IllegalArgumentException("El usuario no puede estar vacío");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }

        if (!usuario.matches("[a-zA-Z0-9_]+")) {
            throw new IllegalArgumentException("El usuario contiene caracteres inválidos");
        }
    }

    public static void main(String[] args) {
        try {
            validarUsuario("admin", "123");
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
}
```

### Ejemplo: Gestión de servicios

```java
public class Servicio {
    private boolean ejecutando = false;

    public void iniciar() {
        if (ejecutando) {
            throw new IllegalStateException("El servicio ya está en ejecución");
        }
        ejecutando = true;
        System.out.println("Servicio iniciado");
    }

    public void detener() {
        if (!ejecutando) {
            throw new IllegalStateException("El servicio no está en ejecución");
        }
        ejecutando = false;
        System.out.println("Servicio detenido");
    }
}
```

## 5. Declaración de excepciones (throws)

La palabra clave `throws` declara que un método **puede lanzar** ciertas excepciones.

### Sintaxis

```java
public void metodo() throws IOException, SQLException {
    // Código que puede lanzar estas excepciones
}
```

### Ejemplo: Lectura de archivo

```java
import java.io.*;

public class GestorArchivos {

    // Declara que puede lanzar IOException
    public static String leerArchivo(String ruta) throws IOException {
        StringBuilder contenido = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea;

        while ((linea = br.readLine()) != null) {
            contenido.append(linea).append("\n");
        }

        br.close();
        return contenido.toString();
    }

    public static void main(String[] args) {
        try {
            String contenido = leerArchivo("/etc/hosts");
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}
```

### Propagación de excepciones

```java
public class CadenaLlamadas {

    public void metodoA() throws IOException {
        metodoB();  // Propaga la excepción
    }

    public void metodoB() throws IOException {
        metodoC();  // Propaga la excepción
    }

    public void metodoC() throws IOException {
        throw new IOException("Error en metodoC");  // Lanza la excepción
    }

    public static void main(String[] args) {
        CadenaLlamadas obj = new CadenaLlamadas();
        try {
            obj.metodoA();
        } catch (IOException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
```

## 6. Excepciones personalizadas

Puedes crear tus propias clases de excepción para necesidades específicas.

### Crear excepción personalizada

```java
// Excepción verificada (extiende Exception)
public class ConfiguracionInvalidaException extends Exception {
    public ConfiguracionInvalidaException(String mensaje) {
        super(mensaje);
    }

    public ConfiguracionInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

// Excepción no verificada (extiende RuntimeException)
public class ServicioNoDisponibleException extends RuntimeException {
    private String nombreServicio;

    public ServicioNoDisponibleException(String nombreServicio) {
        super("El servicio " + nombreServicio + " no está disponible");
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }
}
```

### Uso de excepciones personalizadas

```java
public class ConfiguracionServidor {
    private int puerto;
    private String ip;

    public void cargarConfiguracion(String archivo)
            throws ConfiguracionInvalidaException {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(archivo));

            String puertoStr = props.getProperty("puerto");
            if (puertoStr == null) {
                throw new ConfiguracionInvalidaException(
                    "Falta el parámetro 'puerto' en la configuración");
            }

            puerto = Integer.parseInt(puertoStr);
            if (puerto < 1 || puerto > 65535) {
                throw new ConfiguracionInvalidaException(
                    "Puerto fuera de rango: " + puerto);
            }

            ip = props.getProperty("ip", "localhost");

        } catch (IOException e) {
            throw new ConfiguracionInvalidaException(
                "Error al leer el archivo de configuración", e);
        } catch (NumberFormatException e) {
            throw new ConfiguracionInvalidaException(
                "El puerto debe ser un número válido", e);
        }
    }
}
```

### Ejemplo completo: Sistema de backup

```java
public class BackupException extends Exception {
    private String rutaOrigen;
    private String rutaDestino;

    public BackupException(String mensaje, String origen, String destino) {
        super(mensaje);
        this.rutaOrigen = origen;
        this.rutaDestino = destino;
    }

    public String getDetalle() {
        return String.format("Origen: %s, Destino: %s, Error: %s",
                           rutaOrigen, rutaDestino, getMessage());
    }
}

public class SistemaBackup {

    public void realizarBackup(String origen, String destino)
            throws BackupException {
        File archivoOrigen = new File(origen);

        if (!archivoOrigen.exists()) {
            throw new BackupException(
                "El archivo origen no existe", origen, destino);
        }

        if (!archivoOrigen.canRead()) {
            throw new BackupException(
                "No hay permisos de lectura", origen, destino);
        }

        File directorioDestino = new File(destino).getParentFile();
        if (!directorioDestino.exists() && !directorioDestino.mkdirs()) {
            throw new BackupException(
                "No se pudo crear el directorio destino", origen, destino);
        }

        // Realizar copia...
        System.out.println("Backup completado: " + origen + " -> " + destino);
    }

    public static void main(String[] args) {
        SistemaBackup backup = new SistemaBackup();
        try {
            backup.realizarBackup("/var/www/html", "/backup/www.tar.gz");
        } catch (BackupException e) {
            System.err.println("ERROR EN BACKUP:");
            System.err.println(e.getDetalle());
        }
    }
}
```

## 7. Buenas prácticas en el manejo de errores

### ✅ Buenas prácticas

1. **Captura excepciones específicas**

```java
// ✅ Bueno
try {
    // código
} catch (FileNotFoundException e) {
    // manejo específico
} catch (IOException e) {
    // manejo genérico
}

// ❌ Malo
try {
    // código
} catch (Exception e) {  // Demasiado genérico
    // ...
}
```

1. **No ignores las excepciones**

```java
// ❌ Muy malo
try {
    leerArchivo();
} catch (IOException e) {
    // Bloque vacío - error silenciado
}

// ✅ Bueno
try {
    leerArchivo();
} catch (IOException e) {
    logger.error("Error al leer archivo", e);
    // O al menos:
    e.printStackTrace();
}
```

1. **Proporciona mensajes informativos**

```java
// ✅ Bueno
throw new IllegalArgumentException(
    "El puerto debe estar entre 1 y 65535, recibido: " + puerto);

// ❌ Malo
throw new IllegalArgumentException("Error");
```

1. **Cierra recursos correctamente**

```java
// ✅ Mejor opción
try (FileReader fr = new FileReader("archivo.txt")) {
    // usar recurso
}  // Se cierra automáticamente

// ✅ Alternativa válida
FileReader fr = null;
try {
    fr = new FileReader("archivo.txt");
    // usar recurso
} finally {
    if (fr != null) {
        try {
            fr.close();
        } catch (IOException e) {
            // log error
        }
    }
}
```

1. **No uses excepciones para control de flujo**

```java
// ❌ Malo
try {
    while (true) {
        array[i++];
    }
} catch (ArrayIndexOutOfBoundsException e) {
    // Fin del array
}

// ✅ Bueno
for (int i = 0; i < array.length; i++) {
    // procesar array[i]
}
```

1. **Documenta las excepciones**

```java
/**
 * Lee un archivo de configuración.
 *
 * @param ruta Ruta del archivo
 * @return Contenido del archivo
 * @throws FileNotFoundException Si el archivo no existe
 * @throws IOException Si hay error de lectura
 */
public String leerConfiguracion(String ruta)
        throws FileNotFoundException, IOException {
    // implementación
}
```

### Métodos útiles de Exception

```java
try {
    // código que lanza excepción
} catch (Exception e) {
    // Mensaje de error
    String mensaje = e.getMessage();

    // Tipo de excepción
    String tipo = e.getClass().getName();

    // Traza completa del error
    e.printStackTrace();

    // Causa original (si la hay)
    Throwable causa = e.getCause();

    // Elementos de la pila
    StackTraceElement[] stack = e.getStackTrace();
    for (StackTraceElement elemento : stack) {
        System.out.println(elemento);
    }
}
```

## Ejercicios prácticos

### Ejercicio 1: Validador de direcciones IP

Crea un validador que lance excepciones personalizadas para IPs inválidas.

### Ejercicio 2: Gestor de archivos de log

Implementa un sistema que maneje correctamente errores al escribir logs.

### Ejercicio 3: Conexión a servidor

Crea una clase que intente conectarse a un servidor con reintentos y manejo de diferentes tipos de errores.

-----

## **Conceptos clave del módulo:**

- Las excepciones permiten manejar errores de forma estructurada
- try-catch-finally separa lógica de negocio del manejo de errores
- Excepciones verificadas deben manejarse o declararse
- throw lanza excepciones, throws las declara
- Crear excepciones personalizadas para casos específicos del dominio
- Siempre cerrar recursos en finally o usar try-with-resources

  ---
  
