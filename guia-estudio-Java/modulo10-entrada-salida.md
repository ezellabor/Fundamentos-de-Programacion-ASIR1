<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# MÓDULO 10: ENTRADA/SALIDA (I/O)

## 1. Flujos de datos (streams)

Un **stream** (flujo) es una secuencia de datos que fluye desde un origen hacia un destino.

### Conceptos fundamentales

```
ORIGEN → [Stream de entrada] → Programa → [Stream de salida] → DESTINO
```

- **InputStream/Reader**: Leen datos (entrada)
- **OutputStream/Writer**: Escriben datos (salida)
- **Byte Streams**: Trabajan con bytes (datos binarios)
- **Character Streams**: Trabajan con caracteres (texto)

### Jerarquía de clases I/O

```
Byte Streams (binarios)          Character Streams (texto)
├── InputStream                  ├── Reader
│   ├── FileInputStream          │   ├── FileReader
│   ├── BufferedInputStream      │   ├── BufferedReader
│   └── ObjectInputStream        │   └── InputStreamReader
└── OutputStream                 └── Writer
    ├── FileOutputStream             ├── FileWriter
    ├── BufferedOutputStream         ├── BufferedWriter
    └── ObjectOutputStream           └── OutputStreamWriter
```

## 2. Lectura y escritura de archivos de texto

### Escritura básica con FileWriter

```java
import java.io.*;

public class EscrituraBasica {
    public static void escribirArchivo() throws IOException {
        FileWriter fw = new FileWriter("/var/log/app.log");
        fw.write("Inicio del sistema\n");
        fw.write("Usuario: admin\n");
        fw.write("Fecha: 2024-01-15\n");
        fw.close();  // ¡Importante cerrar!
    }

    // Modo append (agregar al final)
    public static void agregarLog(String mensaje) throws IOException {
        FileWriter fw = new FileWriter("/var/log/app.log", true);  // true = append
        fw.write(mensaje + "\n");
        fw.close();
    }
}
```

### Lectura básica con FileReader

```java
import java.io.*;

public class LecturaBasica {
    public static void leerArchivo() throws IOException {
        FileReader fr = new FileReader("/etc/hosts");
        int caracter;

        // Leer carácter por carácter
        while ((caracter = fr.read()) != -1) {
            System.out.print((char) caracter);
        }

        fr.close();
    }
}
```

## 3. Clases File, FileReader y FileWriter

### Clase File

La clase `File` representa rutas de archivos y directorios (pero no su contenido).

```java
import java.io.File;

public class ManejadorArchivos {
    public static void infoArchivo(String ruta) {
        File archivo = new File(ruta);

        // Verificaciones
        System.out.println("Existe: " + archivo.exists());
        System.out.println("Es archivo: " + archivo.isFile());
        System.out.println("Es directorio: " + archivo.isDirectory());
        System.out.println("Se puede leer: " + archivo.canRead());
        System.out.println("Se puede escribir: " + archivo.canWrite());
        System.out.println("Se puede ejecutar: " + archivo.canExecute());

        // Información
        System.out.println("Nombre: " + archivo.getName());
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        System.out.println("Directorio padre: " + archivo.getParent());
        System.out.println("Tamaño: " + archivo.length() + " bytes");
        System.out.println("Última modificación: " + archivo.lastModified());
    }

    public static void listarDirectorio(String ruta) {
        File directorio = new File(ruta);

        if (directorio.isDirectory()) {
            String[] archivos = directorio.list();
            System.out.println("Contenido de " + ruta + ":");
            for (String nombre : archivos) {
                System.out.println("  " + nombre);
            }

            // O con más información
            File[] files = directorio.listFiles();
            for (File f : files) {
                String tipo = f.isDirectory() ? "[DIR]" : "[FILE]";
                System.out.printf("%s %10d bytes - %s%n",
                                tipo, f.length(), f.getName());
            }
        }
    }

    public static void operacionesArchivos() {
        File archivo = new File("/tmp/test.txt");
        File directorio = new File("/tmp/midir");

        try {
            // Crear archivo
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado");
            }

            // Crear directorio
            if (directorio.mkdir()) {  // Un nivel
                System.out.println("Directorio creado");
            }

            // Crear directorios (múltiples niveles)
            File directorioMulti = new File("/tmp/a/b/c");
            if (directorioMulti.mkdirs()) {
                System.out.println("Directorios creados");
            }

            // Renombrar
            File nuevoNombre = new File("/tmp/test_renamed.txt");
            if (archivo.renameTo(nuevoNombre)) {
                System.out.println("Archivo renombrado");
            }

            // Eliminar
            if (nuevoNombre.delete()) {
                System.out.println("Archivo eliminado");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### FileWriter - Escritura de texto

```java
import java.io.*;

public class EscritorArchivos {

    // Escribir líneas
    public static void escribirLog(String[] mensajes) throws IOException {
        FileWriter fw = new FileWriter("/var/log/app.log");

        for (String mensaje : mensajes) {
            fw.write(mensaje + "\n");
        }

        fw.close();
    }

    // Try-with-resources (recomendado)
    public static void escribirConfiguracion() throws IOException {
        try (FileWriter fw = new FileWriter("/etc/app/config.conf")) {
            fw.write("# Configuración de la aplicación\n");
            fw.write("puerto=8080\n");
            fw.write("host=localhost\n");
            fw.write("debug=true\n");
        }  // Se cierra automáticamente
    }
}
```

### FileReader - Lectura de texto

```java
import java.io.*;

public class LectorArchivos {

    public static String leerArchivo(String ruta) throws IOException {
        StringBuilder contenido = new StringBuilder();

        try (FileReader fr = new FileReader(ruta)) {
            int caracter;
            while ((caracter = fr.read()) != -1) {
                contenido.append((char) caracter);
            }
        }

        return contenido.toString();
    }

    // Leer en buffer (más eficiente)
    public static String leerArchivoBuffer(String ruta) throws IOException {
        StringBuilder contenido = new StringBuilder();

        try (FileReader fr = new FileReader(ruta)) {
            char[] buffer = new char[1024];
            int caracteresLeidos;

            while ((caracteresLeidos = fr.read(buffer)) != -1) {
                contenido.append(buffer, 0, caracteresLeidos);
            }
        }

        return contenido.toString();
    }
}
```

## 4. BufferedReader y BufferedWriter

Los buffered streams mejoran el rendimiento al usar un buffer interno.

### BufferedWriter - Escritura eficiente

```java
import java.io.*;

public class EscrituraBuffered {

    public static void escribirLog(String archivo, String[] lineas)
            throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();  // Salto de línea multiplataforma
            }
        }
    }

    // Agregar a log existente
    public static void agregarLog(String mensaje) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("/var/log/app.log", true))) {

            String timestamp = java.time.LocalDateTime.now().toString();
            bw.write(timestamp + " - " + mensaje);
            bw.newLine();
        }
    }

    // Escribir muchas líneas eficientemente
    public static void generarReporte() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("/tmp/reporte.txt"))) {

            bw.write("=== REPORTE DEL SISTEMA ===");
            bw.newLine();
            bw.newLine();

            for (int i = 1; i <= 10000; i++) {
                bw.write("Línea " + i + ": Datos del reporte");
                bw.newLine();

                // Forzar escritura cada 1000 líneas
                if (i % 1000 == 0) {
                    bw.flush();
                }
            }
        }
    }
}
```

### BufferedReader - Lectura eficiente

```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaBuffered {

    // Leer línea por línea
    public static void leerArchivo(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int numeroLinea = 1;

            while ((linea = br.readLine()) != null) {
                System.out.println(numeroLinea + ": " + linea);
                numeroLinea++;
            }
        }
    }

    // Leer en una lista
    public static List<String> leerLineas(String ruta) throws IOException {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }

        return lineas;
    }

    // Procesar archivo de configuración
    public static void cargarConfiguracion(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Ignorar líneas vacías y comentarios
                if (linea.trim().isEmpty() || linea.trim().startsWith("#")) {
                    continue;
                }

                // Procesar línea: clave=valor
                String[] partes = linea.split("=", 2);
                if (partes.length == 2) {
                    String clave = partes[0].trim();
                    String valor = partes[1].trim();
                    System.out.println(clave + " -> " + valor);
                }
            }
        }
    }

    // Contar líneas de un archivo
    public static int contarLineas(String ruta) throws IOException {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while (br.readLine() != null) {
                contador++;
            }
        }
        return contador;
    }
}
```

### Ejemplo práctico: Analizador de logs

```java
import java.io.*;
import java.util.*;

public class AnalizadorLogs {

    public static Map<String, Integer> analizarNivelesLog(String archivoLog)
            throws IOException {
        Map<String, Integer> contadores = new HashMap<>();
        contadores.put("INFO", 0);
        contadores.put("WARNING", 0);
        contadores.put("ERROR", 0);
        contadores.put("CRITICAL", 0);

        try (BufferedReader br = new BufferedReader(new FileReader(archivoLog))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                for (String nivel : contadores.keySet()) {
                    if (linea.contains(nivel)) {
                        contadores.put(nivel, contadores.get(nivel) + 1);
                        break;
                    }
                }
            }
        }

        return contadores;
    }

    public static void generarReporte(String archivoLog, String archivoSalida)
            throws IOException {
        Map<String, Integer> estadisticas = analizarNivelesLog(archivoLog);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            bw.write("=== ANÁLISIS DE LOGS ===");
            bw.newLine();
            bw.newLine();

            int total = 0;
            for (int count : estadisticas.values()) {
                total += count;
            }

            bw.write("Total de entradas: " + total);
            bw.newLine();
            bw.newLine();

            for (Map.Entry<String, Integer> entry : estadisticas.entrySet()) {
                double porcentaje = (entry.getValue() * 100.0) / total;
                bw.write(String.format("%-10s: %5d (%5.2f%%)%n",
                       entry.getKey(), entry.getValue(), porcentaje));
            }
        }
    }
}
```

## 5. Archivos binarios

### Escritura binaria

```java
import java.io.*;

public class ArchivoBinario {

    public static void escribirBinario() throws IOException {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("/tmp/datos.bin"))) {

            // Escribir diferentes tipos de datos
            dos.writeInt(12345);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Texto en UTF-8");
            dos.writeLong(System.currentTimeMillis());
        }
    }

    public static void leerBinario() throws IOException {
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("/tmp/datos.bin"))) {

            // Leer en el mismo orden que se escribió
            int numero = dis.readInt();
            double decimal = dis.readDouble();
            boolean booleano = dis.readBoolean();
            String texto = dis.readUTF();
            long timestamp = dis.readLong();

            System.out.println("Int: " + numero);
            System.out.println("Double: " + decimal);
            System.out.println("Boolean: " + booleano);
            System.out.println("String: " + texto);
            System.out.println("Long: " + timestamp);
        }
    }
}
```

## 6. Serialización de objetos

La **serialización** convierte objetos en bytes para almacenarlos o transmitirlos.

### Clase serializable

```java
import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String email;
    private int edad;

    // La palabra clave transient excluye el campo de la serialización
    private transient String password;

    public Usuario(String nombre, String email, int edad, String password) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.password = password;
    }

    // Getters y setters
    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', email='" + email +
               "', edad=" + edad + "}";
    }
}
```

### Serializar (guardar objeto)

```java
import java.io.*;

public class Serializador {

    public static void guardarUsuario(Usuario usuario, String archivo)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(archivo))) {
            oos.writeObject(usuario);
            System.out.println("Usuario guardado: " + archivo);
        }
    }

    public static void guardarLista(List<Usuario> usuarios, String archivo)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(archivo))) {
            oos.writeObject(usuarios);
            System.out.println("Lista guardada: " + archivo);
        }
    }
}
```

### Deserializar (cargar objeto)

```java
import java.io.*;
import java.util.List;

public class Deserializador {

    public static Usuario cargarUsuario(String archivo)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivo))) {
            return (Usuario) ois.readObject();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Usuario> cargarLista(String archivo)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivo))) {
            return (List<Usuario>) ois.readObject();
        }
    }

    public static void main(String[] args) {
        try {
            // Guardar
            Usuario user = new Usuario("admin", "admin@example.com", 30, "secreto");
            Serializador.guardarUsuario(user, "/tmp/usuario.ser");

            // Cargar
            Usuario userCargado = cargarUsuario("/tmp/usuario.ser");
            System.out.println(userCargado);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

## 7. Gestión de rutas y directorios

### Operaciones con directorios

```java
import java.io.File;
import java.io.IOException;

public class GestorDirectorios {

    public static void crearEstructura(String base) throws IOException {
        File logs = new File(base + "/logs");
        File config = new File(base + "/config");
        File data = new File(base + "/data");
        File temp = new File(base + "/temp");

        logs.mkdirs();
        config.mkdirs();
        data.mkdirs();
        temp.mkdirs();

        // Crear archivos
        new File(config, "app.properties").createNewFile();
        new File(logs, "app.log").createNewFile();
    }

    public static void listarRecursivo(File directorio, String indent) {
        if (!directorio.exists()) {
            return;
        }

        System.out.println(indent + directorio.getName() + "/");

        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    listarRecursivo(archivo, indent + "  ");
                } else {
                    System.out.println(indent + "  " + archivo.getName());
                }
            }
        }
    }

    public static long calcularTamanioDirectorio(File directorio) {
        long tamanio = 0;

        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    tamanio += archivo.length();
                } else if (archivo.isDirectory()) {
                    tamanio += calcularTamanioDirectorio(archivo);
                }
            }
        }

        return tamanio;
    }

    public static void eliminarDirectorioRecursivo(File directorio) {
        if (!directorio.exists()) {
            return;
        }

        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    eliminarDirectorioRecursivo(archivo);
                } else {
                    archivo.delete();
                }
            }
        }

        directorio.delete();
    }
}
```

### Ejemplo práctico: Sistema de backup

```java
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaBackup {

    public static void hacerBackup(String directorioOrigen, String directorioBackups)
            throws IOException {
        File origen = new File(directorioOrigen);
        if (!origen.exists()) {
            throw new IOException("El directorio origen no existe");
        }

        // Crear nombre de backup con timestamp
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String nombreBackup = "backup_" + timestamp;

        File destino = new File(directorioBackups, nombreBackup);
        destino.mkdirs();

        copiarDirectorio(origen, destino);
        System.out.println("Backup completado: " + destino.getAbsolutePath());
    }

    private static void copiarDirectorio(File origen, File destino) throws IOException {
        if (origen.isDirectory()) {
            if (!destino.exists()) {
                destino.mkdirs();
            }

            String[] archivos = origen.list();
            for (String archivo : archivos) {
                copiarDirectorio(
                    new File(origen, archivo),
                    new File(destino, archivo)
                );
            }
        } else {
            copiarArchivo(origen, destino);
        }
    }

    private static void copiarArchivo(File origen, File destino) throws IOException {
        try (InputStream in = new FileInputStream(origen);
             OutputStream out = new FileOutputStream(destino)) {

            byte[] buffer = new byte[1024];
            int bytesLeidos;

            while ((bytesLeidos = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesLeidos);
            }
        }
    }
}
```

## Ejercicios prácticos

### Ejercicio 1: Contador de palabras

Crea un programa que cuente palabras, líneas y caracteres de un archivo de texto.

### Ejercicio 2: Fusionador de logs

Combina múltiples archivos de log en uno solo, ordenados por timestamp.

### Ejercicio 3: Gestor de configuraciones

Lee un archivo de configuración tipo .properties y permite modificar valores.

-----

## **Conceptos clave del módulo:**

- Streams permiten leer/escribir datos de forma secuencial
- BufferedReader/Writer mejoran el rendimiento
- File representa rutas, no contenidos
- Serialización convierte objetos a bytes
- Try-with-resources cierra automáticamente los recursos
- Siempre manejar excepciones IOException

  ###
