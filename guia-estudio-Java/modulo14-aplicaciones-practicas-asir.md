<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# MÓDULO 14: APLICACIONES PRÁCTICAS PARA ASIR

## Introducción

Este módulo integra todos los conocimientos adquiridos en los módulos anteriores para crear herramientas prácticas que un administrador de sistemas puede usar en su trabajo diario. Cada aplicación está diseñada para resolver problemas reales y demostrar buenas prácticas de programación.

## 1. Scripts de automatización de tareas

### 1.1. Generador de informes de sistema

Crea informes automáticos del estado del sistema:

```java
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneradorInformesSistema {

    private static final String RUTA_INFORMES = "./informes/";

    // Obtener información del sistema
    public static String obtenerInfoSistema() {
        StringBuilder info = new StringBuilder();

        info.append("=== INFORMACIÓN DEL SISTEMA ===\n\n");
        info.append("Sistema Operativo: ").append(System.getProperty("os.name")).append("\n");
        info.append("Versión: ").append(System.getProperty("os.version")).append("\n");
        info.append("Arquitectura: ").append(System.getProperty("os.arch")).append("\n");
        info.append("Usuario: ").append(System.getProperty("user.name")).append("\n");
        info.append("Directorio Home: ").append(System.getProperty("user.home")).append("\n");
        info.append("Java Version: ").append(System.getProperty("java.version")).append("\n");

        return info.toString();
    }

    // Obtener información de memoria
    public static String obtenerInfoMemoria() {
        StringBuilder info = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();

        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;
        long memoriaMax = runtime.maxMemory();

        info.append("\n=== INFORMACIÓN DE MEMORIA ===\n\n");
        info.append("Memoria Total: ").append(formatearBytes(memoriaTotal)).append("\n");
        info.append("Memoria Usada: ").append(formatearBytes(memoriaUsada)).append("\n");
        info.append("Memoria Libre: ").append(formatearBytes(memoriaLibre)).append("\n");
        info.append("Memoria Máxima: ").append(formatearBytes(memoriaMax)).append("\n");

        double porcentajeUso = (memoriaUsada * 100.0) / memoriaTotal;
        info.append(String.format("Uso: %.2f%%\n", porcentajeUso));

        return info.toString();
    }

    // Formatear bytes a formato legible
    public static String formatearBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.2f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.2f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }

    // Obtener información de procesadores
    public static String obtenerInfoProcesadores() {
        StringBuilder info = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();

        info.append("\n=== INFORMACIÓN DE PROCESADORES ===\n\n");
        info.append("Número de procesadores disponibles: ").append(runtime.availableProcessors()).append("\n");

        return info.toString();
    }

    // Generar informe completo
    public static String generarInformeCompleto() {
        StringBuilder informe = new StringBuilder();

        // Encabezado con fecha y hora
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        informe.append("╔════════════════════════════════════════════════════════════╗\n");
        informe.append("║           INFORME DE ESTADO DEL SISTEMA                   ║\n");
        informe.append("╚════════════════════════════════════════════════════════════╝\n\n");
        informe.append("Fecha: ").append(ahora.format(formatter)).append("\n");
        informe.append("─".repeat(60)).append("\n\n");

        // Agregar secciones
        informe.append(obtenerInfoSistema());
        informe.append(obtenerInfoProcesadores());
        informe.append(obtenerInfoMemoria());

        informe.append("\n").append("─".repeat(60)).append("\n");
        informe.append("Informe generado automáticamente\n");

        return informe.toString();
    }

    // Guardar informe en archivo
    public static boolean guardarInforme(String contenido) {
        try {
            // Crear directorio si no existe
            File directorio = new File(RUTA_INFORMES);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            // Nombre de archivo con timestamp
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String nombreArchivo = "informe_" + ahora.format(formatter) + ".txt";

            // Guardar archivo
            FileWriter writer = new FileWriter(RUTA_INFORMES + nombreArchivo);
            writer.write(contenido);
            writer.close();

            System.out.println("✅ Informe guardado: " + nombreArchivo);
            return true;

        } catch (IOException e) {
            System.err.println("❌ Error al guardar informe: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Generando informe del sistema...\n");

        String informe = generarInformeCompleto();

        // Mostrar en consola
        System.out.println(informe);

        // Guardar en archivo
        guardarInforme(informe);
    }
}
```

### 1.2. Verificador de servicios

Script para verificar si servicios críticos están activos:

```java
import java.io.*;
import java.net.*;
import java.util.*;

public class VerificadorServicios {

    static class Servicio {
        String nombre;
        String host;
        int puerto;
        int timeoutMs;

        public Servicio(String nombre, String host, int puerto, int timeoutMs) {
            this.nombre = nombre;
            this.host = host;
            this.puerto = puerto;
            this.timeoutMs = timeoutMs;
        }
    }

    // Verificar si un servicio está disponible
    public static boolean verificarServicio(Servicio servicio) {
        try (Socket socket = new Socket()) {
            InetSocketAddress address = new InetSocketAddress(servicio.host, servicio.puerto);
            socket.connect(address, servicio.timeoutMs);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Verificar múltiples servicios
    public static Map<String, Boolean> verificarServicios(List<Servicio> servicios) {
        Map<String, Boolean> resultados = new HashMap<>();

        for (Servicio servicio : servicios) {
            System.out.print("Verificando " + servicio.nombre + " (" + servicio.host + ":" + servicio.puerto + ")... ");
            boolean disponible = verificarServicio(servicio);
            resultados.put(servicio.nombre, disponible);

            if (disponible) {
                System.out.println("✅ ACTIVO");
            } else {
                System.out.println("❌ INACTIVO");
            }
        }

        return resultados;
    }

    // Generar resumen
    public static void generarResumen(Map<String, Boolean> resultados) {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("RESUMEN DE VERIFICACIÓN");
        System.out.println("═".repeat(50));

        int total = resultados.size();
        int activos = 0;

        for (boolean estado : resultados.values()) {
            if (estado) activos++;
        }

        int inactivos = total - activos;
        double porcentajeDisponibilidad = (activos * 100.0) / total;

        System.out.println("Total de servicios: " + total);
        System.out.println("Servicios activos: " + activos);
        System.out.println("Servicios inactivos: " + inactivos);
        System.out.printf("Disponibilidad: %.2f%%%n", porcentajeDisponibilidad);

        if (inactivos > 0) {
            System.out.println("\n⚠️  SERVICIOS CAÍDOS:");
            for (Map.Entry<String, Boolean> entry : resultados.entrySet()) {
                if (!entry.getValue()) {
                    System.out.println("  • " + entry.getKey());
                }
            }
        } else {
            System.out.println("\n✅ Todos los servicios están operativos");
        }
    }

    // Guardar log de verificación
    public static void guardarLog(Map<String, Boolean> resultados) {
        try {
            FileWriter writer = new FileWriter("verificacion_servicios.log", true);

            Date fecha = new Date();
            writer.write("\n" + "=".repeat(50) + "\n");
            writer.write("Verificación: " + fecha + "\n");
            writer.write("=".repeat(50) + "\n");

            for (Map.Entry<String, Boolean> entry : resultados.entrySet()) {
                String estado = entry.getValue() ? "ACTIVO" : "INACTIVO";
                writer.write(String.format("%-20s : %s%n", entry.getKey(), estado));
            }

            writer.close();
            System.out.println("\n📝 Log guardado en: verificacion_servicios.log");

        } catch (IOException e) {
            System.err.println("❌ Error al guardar log: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    VERIFICADOR DE SERVICIOS            ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Configurar servicios a verificar
        List<Servicio> servicios = new ArrayList<>();
        servicios.add(new Servicio("HTTP Local", "localhost", 80, 2000));
        servicios.add(new Servicio("Google DNS", "8.8.8.8", 53, 2000));
        servicios.add(new Servicio("Cloudflare DNS", "1.1.1.1", 53, 2000));
        servicios.add(new Servicio("SSH Local", "localhost", 22, 2000));
        servicios.add(new Servicio("MySQL Local", "localhost", 3306, 2000));

        // Verificar servicios
        Map<String, Boolean> resultados = verificarServicios(servicios);

        // Generar resumen
        generarResumen(resultados);

        // Guardar log
        guardarLog(resultados);
    }
}
```

### 1.3. Limpiador de archivos temporales

Script para limpiar archivos temporales antiguos:

```java
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;

public class LimpiadorTemporales {

    private static long tamañoTotalEliminado = 0;
    private static int archivosEliminados = 0;

    // Verificar si un archivo es antiguo
    public static boolean esArchivoAntiguo(File archivo, int diasAntigüedad) {
        long tiempoActual = System.currentTimeMillis();
        long tiempoArchivo = archivo.lastModified();
        long diferenciaDias = (tiempoActual - tiempoArchivo) / (1000 * 60 * 60 * 24);

        return diferenciaDias > diasAntigüedad;
    }

    // Obtener tamaño formateado
    public static String formatearTamaño(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.2f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.2f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }

    // Limpiar directorio
    public static void limpiarDirectorio(String ruta, int diasAntigüedad, boolean modoSimulacion) {
        File directorio = new File(ruta);

        if (!directorio.exists()) {
            System.out.println("❌ El directorio no existe: " + ruta);
            return;
        }

        if (!directorio.isDirectory()) {
            System.out.println("❌ La ruta no es un directorio: " + ruta);
            return;
        }

        System.out.println("\n📁 Analizando: " + ruta);
        System.out.println("🕐 Eliminando archivos con más de " + diasAntigüedad + " días\n");

        File[] archivos = directorio.listFiles();

        if (archivos == null || archivos.length == 0) {
            System.out.println("ℹ️  Directorio vacío");
            return;
        }

        for (File archivo : archivos) {
            if (archivo.isFile() && esArchivoAntiguo(archivo, diasAntigüedad)) {
                long tamaño = archivo.length();
                String nombreArchivo = archivo.getName();

                if (modoSimulacion) {
                    System.out.println("🔍 [SIMULACIÓN] Eliminaría: " + nombreArchivo +
                                     " (" + formatearTamaño(tamaño) + ")");
                } else {
                    if (archivo.delete()) {
                        System.out.println("✅ Eliminado: " + nombreArchivo +
                                         " (" + formatearTamaño(tamaño) + ")");
                        tamañoTotalEliminado += tamaño;
                        archivosEliminados++;
                    } else {
                        System.out.println("❌ Error al eliminar: " + nombreArchivo);
                    }
                }
            }
        }
    }

    // Generar resumen
    public static void generarResumen(boolean modoSimulacion) {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("RESUMEN DE LIMPIEZA");
        System.out.println("═".repeat(50));

        if (modoSimulacion) {
            System.out.println("ℹ️  Modo: SIMULACIÓN (no se eliminó nada)");
        } else {
            System.out.println("Archivos eliminados: " + archivosEliminados);
            System.out.println("Espacio liberado: " + formatearTamaño(tamañoTotalEliminado));
        }
    }

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    LIMPIADOR DE ARCHIVOS TEMPORALES   ║");
        System.out.println("╚════════════════════════════════════════╝");

        Scanner sc = new Scanner(System.in);

        // Solicitar configuración
        System.out.print("\nRuta del directorio a limpiar: ");
        String ruta = sc.nextLine();

        System.out.print("Días de antigüedad (archivos más antiguos serán eliminados): ");
        int dias = sc.nextInt();

        System.out.print("¿Ejecutar en modo simulación? (1=Sí, 0=No): ");
        int simular = sc.nextInt();
        boolean modoSimulacion = simular == 1;

        if (modoSimulacion) {
            System.out.println("\n⚠️  MODO SIMULACIÓN: No se eliminará ningún archivo");
        } else {
            System.out.print("\n⚠️  ¿Confirmar eliminación? (1=Sí, 0=No): ");
            int confirmar = sc.nextInt();
            if (confirmar != 1) {
                System.out.println("❌ Operación cancelada");
                sc.close();
                return;
            }
        }

        // Ejecutar limpieza
        limpiarDirectorio(ruta, dias, modoSimulacion);

        // Mostrar resumen
        generarResumen(modoSimulacion);

        sc.close();
    }
}
```

## 2. Gestión de logs del sistema

### 2.1. Analizador de logs

Herramienta para analizar archivos de log y extraer información relevante:

```java
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class AnalizadorLogs {

    static class EstadisticasLog {
        int totalLineas = 0;
        int errores = 0;
        int advertencias = 0;
        int info = 0;
        Map<String, Integer> erroresPorTipo = new HashMap<>();
        List<String> erroresCriticos = new ArrayList<>();
    }

    // Analizar archivo de log
    public static EstadisticasLog analizarLog(String rutaArchivo) {
        EstadisticasLog stats = new EstadisticasLog();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                stats.totalLineas++;

                // Clasificar por nivel
                if (linea.contains("[ERROR]") || linea.contains("ERROR")) {
                    stats.errores++;
                    clasificarError(linea, stats);

                    // Guardar errores críticos
                    if (linea.toLowerCase().contains("critical") ||
                        linea.toLowerCase().contains("fatal")) {
                        stats.erroresCriticos.add(linea);
                    }

                } else if (linea.contains("[WARNING]") || linea.contains("WARN")) {
                    stats.advertencias++;
                } else if (linea.contains("[INFO]")) {
                    stats.info++;
                }
            }

        } catch (IOException e) {
            System.err.println("❌ Error al leer archivo: " + e.getMessage());
        }

        return stats;
    }

    // Clasificar tipo de error
    public static void clasificarError(String linea, EstadisticasLog stats) {
        String tipoError = "Otro";

        if (linea.toLowerCase().contains("connection") ||
            linea.toLowerCase().contains("timeout")) {
            tipoError = "Conexión/Timeout";
        } else if (linea.toLowerCase().contains("memory") ||
                   linea.toLowerCase().contains("out of memory")) {
            tipoError = "Memoria";
        } else if (linea.toLowerCase().contains("permission") ||
                   linea.toLowerCase().contains("access denied")) {
            tipoError = "Permisos";
        } else if (linea.toLowerCase().contains("file") ||
                   linea.toLowerCase().contains("not found")) {
            tipoError = "Archivo";
        } else if (linea.toLowerCase().contains("null")) {
            tipoError = "NullPointer";
        }

        stats.erroresPorTipo.put(tipoError,
            stats.erroresPorTipo.getOrDefault(tipoError, 0) + 1);
    }

    // Mostrar estadísticas
    public static void mostrarEstadisticas(EstadisticasLog stats, String nombreArchivo) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("ANÁLISIS DE LOG: " + nombreArchivo);
        System.out.println("═".repeat(60));

        System.out.println("\n--- RESUMEN GENERAL ---");
        System.out.println("Total de líneas: " + stats.totalLineas);
        System.out.println("Errores: " + stats.errores);
        System.out.println("Advertencias: " + stats.advertencias);
        System.out.println("Info: " + stats.info);

        if (stats.totalLineas > 0) {
            double porcentajeErrores = (stats.errores * 100.0) / stats.totalLineas;
            System.out.printf("Porcentaje de errores: %.2f%%%n", porcentajeErrores);
        }

        // Mostrar errores por tipo
        if (!stats.erroresPorTipo.isEmpty()) {
            System.out.println("\n--- ERRORES POR TIPO ---");

            // Ordenar por cantidad (descendente)
            List<Map.Entry<String, Integer>> listaOrdenada =
                new ArrayList<>(stats.erroresPorTipo.entrySet());
            listaOrdenada.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            for (Map.Entry<String, Integer> entry : listaOrdenada) {
                System.out.printf("%-20s : %d%n", entry.getKey(), entry.getValue());
            }
        }

        // Mostrar errores críticos
        if (!stats.erroresCriticos.isEmpty()) {
            System.out.println("\n--- ERRORES CRÍTICOS ---");
            int count = 1;
            for (String error : stats.erroresCriticos) {
                System.out.println(count + ". " + error.trim());
                count++;
                if (count > 5) {
                    System.out.println("... (y " + (stats.erroresCriticos.size() - 5) + " más)");
                    break;
                }
            }
        }

        // Recomendaciones
        System.out.println("\n--- RECOMENDACIONES ---");
        if (stats.errores == 0) {
            System.out.println("✅ No se encontraron errores");
        } else if (stats.errores < 10) {
            System.out.println("⚠️  Se encontraron algunos errores, revisar manualmente");
        } else {
            System.out.println("🔴 Alto número de errores, requiere atención inmediata");
        }
    }

    // Generar reporte en archivo
    public static void generarReporte(EstadisticasLog stats, String archivoOriginal) {
        try {
            String nombreReporte = "reporte_" +
                new File(archivoOriginal).getName().replace(".log", "") +
                "_" + System.currentTimeMillis() + ".txt";

            FileWriter writer = new FileWriter(nombreReporte);

            writer.write("REPORTE DE ANÁLISIS DE LOG\n");
            writer.write("==========================\n\n");
            writer.write("Archivo analizado: " + archivoOriginal + "\n");
            writer.write("Fecha: " + new Date() + "\n\n");

            writer.write("ESTADÍSTICAS:\n");
            writer.write("Total líneas: " + stats.totalLineas + "\n");
            writer.write("Errores: " + stats.errores + "\n");
            writer.write("Advertencias: " + stats.advertencias + "\n");
            writer.write("Info: " + stats.info + "\n\n");

            writer.write("ERRORES POR TIPO:\n");
            for (Map.Entry<String, Integer> entry : stats.erroresPorTipo.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            writer.close();
            System.out.println("\n📄 Reporte guardado: " + nombreReporte);

        } catch (IOException e) {
            System.err.println("❌ Error al generar reporte: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       ANALIZADOR DE LOGS               ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("\nRuta del archivo de log: ");
        String rutaArchivo = sc.nextLine();

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("❌ El archivo no existe");
            sc.close();
            return;
        }

        System.out.println("\n🔍 Analizando log...");

        // Analizar
        EstadisticasLog stats = analizarLog(rutaArchivo);

        // Mostrar resultados
        mostrarEstadisticas(stats, archivo.getName());

        // Preguntar si generar reporte
        System.out.print("\n¿Generar reporte en archivo? (1=Sí, 0=No): ");
        int generar = sc.nextInt();

        if (generar == 1) {
            generarReporte(stats, rutaArchivo);
        }

        sc.close();
    }
}
```

## 3. Monitorización de recursos

### 3.1. Monitor de recursos del sistema

Aplicación para monitorizar recursos en tiempo real:

```java
import java.lang.management.*;
import java.io.*;
import java.text.DecimalFormat;

public class MonitorRecursos {

    private static final DecimalFormat df = new DecimalFormat("#.##");
    private static boolean ejecutando = true;

    // Obtener uso de CPU
    public static double obtenerUsoCPU() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        return osBean.getSystemLoadAverage();
    }

    // Obtener información de memoria
    public static String obtenerInfoMemoria() {
        Runtime runtime = Runtime.getRuntime();

        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;
        long memoriaMax = runtime.maxMemory();

        double porcentajeUso = (memoriaUsada * 100.0) / memoriaTotal;

        return String.format("Memoria: %s / %s (%.1f%%)",
            formatearBytes(memoriaUsada),
            formatearBytes(memoriaTotal),
            porcentajeUso);
    }

    // Obtener información de hilos
    public static String obtenerInfoHilos() {
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        int hilosActivos = threadBean.getThreadCount();
        int hilosPico = threadBean.getPeakThreadCount();

        return String.format("Hilos: %d activos (pico: %d)", hilosActivos, hilosPico);
    }

    // Formatear bytes
    public static String formatearBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return df.format(bytes / 1024.0) + " KB";
        if (bytes < 1024 * 1024 * 1024) return df.format(bytes / (1024.0 * 1024.0)) + " MB";
        return df.format(bytes / (1024.0 * 1024.0 * 1024.0)) + " GB";
    }

    // Limpiar consola (multiplataforma)
    public static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, imprimir líneas vacías
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    // Mostrar dashboard
    public static void mostrarDashboard() {
        limpiarConsola();

        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          MONITOR DE RECURSOS DEL SISTEMA              ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println();

        // Información del sistema
        System.out.println("📊 INFORMACIÓN DEL SISTEMA");
        System.out.println("─".repeat(56));
        System.out.println("SO: " + System.getProperty("os.name") + " " +
                         System.getProperty("os.version"));
        System.out.println("Arquitectura: " + System.getProperty("os.arch"));
        System.out.println("Procesadores disponibles: " +
                         Runtime.getRuntime().availableProcessors());

        System.out.println();
        System.out.println("💾 RECURSOS");
        System.out.println("─".repeat(56));
        System.out.println(obtenerInfoMemoria());
        System.out.println(obtenerInfoHilos());

        System.out.println();
        System.out.println("Presiona Ctrl+C para salir...");
    }

    public static void main(String[] args) {
        // Configurar manejador para Ctrl+C
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n\n👋 Cerrando monitor...");
            ejecutando = false;
        }));

        // Bucle principal
        while (ejecutando) {
            mostrarDashboard();

            try {
                Thread.sleep(2000); // Actualizar cada 2 segundos
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
```

## 4. Lectura de Archivos de Configuración

### 4.1 Introducción a los Archivos de Configuración

En entornos ASIR, los archivos de configuración son esenciales para gestionar servicios, aplicaciones y sistemas. Java proporciona varias formas de leer y procesar estos archivos.

**Formatos comunes en sistemas:**

- **Properties** (.properties) - Configuración de aplicaciones Java
- **INI** (.ini) - Configuración de aplicaciones Windows y algunas Linux
- **YAML** (.yaml/.yml) - Configuración moderna (Docker, Kubernetes, Ansible)
- **XML** (.xml) - Configuración de servicios enterprise
- **JSON** (.json) - APIs y configuraciones modernas

### 4.2 Lectura de Archivos .properties

```java
import java.io.*;
import java.util.Properties;

/**
 * Gestor de archivos .properties
 * Útil para: configuración de aplicaciones, parámetros del sistema
 */
public class ConfigPropertiesReader {

    /**
     * Lee un archivo .properties y muestra su contenido
     */
    public static Properties leerConfiguracion(String rutaArchivo) {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
            props.load(fis);
            System.out.println("✓ Configuración cargada desde: " + rutaArchivo);
            return props;
        } catch (IOException e) {
            System.err.println("✗ Error leyendo configuración: " + e.getMessage());
            return null;
        }
    }

    /**
     * Muestra todas las propiedades de forma organizada
     */
    public static void mostrarPropiedades(Properties props) {
        System.out.println("\n=== CONFIGURACIÓN ACTUAL ===");
        props.forEach((clave, valor) -> {
            System.out.printf("%-30s = %s%n", clave, valor);
        });
        System.out.println("============================\n");
    }

    /**
     * Valida que existan las propiedades requeridas
     */
    public static boolean validarConfiguracion(Properties props, String[] propiedadesRequeridas) {
        boolean valido = true;

        System.out.println("Validando configuración...");
        for (String propiedad : propiedadesRequeridas) {
            if (!props.containsKey(propiedad)) {
                System.err.println("✗ Falta propiedad requerida: " + propiedad);
                valido = false;
            } else {
                System.out.println("✓ " + propiedad);
            }
        }

        return valido;
    }

    /**
     * Guarda propiedades en un archivo
     */
    public static void guardarConfiguracion(Properties props, String rutaArchivo, String comentario) {
        try (FileOutputStream fos = new FileOutputStream(rutaArchivo)) {
            props.store(fos, comentario);
            System.out.println("✓ Configuración guardada en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("✗ Error guardando configuración: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo: Configuración de servidor web
        String archivoConfig = "servidor.properties";

        // Crear configuración de ejemplo si no existe
        if (!new File(archivoConfig).exists()) {
            Properties configDefault = new Properties();
            configDefault.setProperty("servidor.puerto", "8080");
            configDefault.setProperty("servidor.host", "localhost");
            configDefault.setProperty("servidor.timeout", "30000");
            configDefault.setProperty("servidor.max_conexiones", "100");
            configDefault.setProperty("servidor.ssl.habilitado", "false");
            configDefault.setProperty("logs.ruta", "/var/log/servidor/");
            configDefault.setProperty("logs.nivel", "INFO");

            guardarConfiguracion(configDefault, archivoConfig,
                "Configuración del servidor web - Generado automáticamente");
        }

        // Leer configuración
        Properties config = leerConfiguracion(archivoConfig);
        if (config != null) {
            mostrarPropiedades(config);

            // Validar propiedades críticas
            String[] propiedadesRequeridas = {
                "servidor.puerto",
                "servidor.host",
                "logs.ruta"
            };

            if (validarConfiguracion(config, propiedadesRequeridas)) {
                System.out.println("✓ Configuración válida");

                // Usar las propiedades
                int puerto = Integer.parseInt(config.getProperty("servidor.puerto"));
                String host = config.getProperty("servidor.host");

                System.out.println("\nServidor configurado para: " + host + ":" + puerto);
            } else {
                System.err.println("✗ Configuración incompleta");
            }
        }
    }
}
```

### 4.3 Lectura de Archivos INI

```java
import java.io.*;
import java.util.*;

/**
 * Lector de archivos INI
 * Formato común en sistemas Windows y algunas aplicaciones Linux
 */
public class ConfigINIReader {

    private Map<String, Map<String, String>> secciones;

    public ConfigINIReader() {
        this.secciones = new HashMap<>();
    }

    /**
     * Lee un archivo INI y lo parsea
     */
    public void leerArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            String seccionActual = "DEFAULT";
            Map<String, String> propiedadesSeccion = new HashMap<>();

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                // Ignorar líneas vacías y comentarios
                if (linea.isEmpty() || linea.startsWith(";") || linea.startsWith("#")) {
                    continue;
                }

                // Detectar sección [nombre]
                if (linea.startsWith("[") && linea.endsWith("]")) {
                    // Guardar sección anterior si existe
                    if (!propiedadesSeccion.isEmpty()) {
                        secciones.put(seccionActual, propiedadesSeccion);
                    }

                    // Nueva sección
                    seccionActual = linea.substring(1, linea.length() - 1);
                    propiedadesSeccion = new HashMap<>();
                }
                // Procesar clave=valor
                else if (linea.contains("=")) {
                    String[] partes = linea.split("=", 2);
                    String clave = partes[0].trim();
                    String valor = partes.length > 1 ? partes[1].trim() : "";
                    propiedadesSeccion.put(clave, valor);
                }
            }

            // Guardar última sección
            if (!propiedadesSeccion.isEmpty()) {
                secciones.put(seccionActual, propiedadesSeccion);
            }

            System.out.println("✓ Archivo INI cargado: " + rutaArchivo);

        } catch (IOException e) {
            System.err.println("✗ Error leyendo archivo INI: " + e.getMessage());
        }
    }

    /**
     * Obtiene un valor de una sección específica
     */
    public String getValor(String seccion, String clave) {
        Map<String, String> props = secciones.get(seccion);
        return props != null ? props.get(clave) : null;
    }

    /**
     * Obtiene un valor con valor por defecto
     */
    public String getValor(String seccion, String clave, String valorDefault) {
        String valor = getValor(seccion, clave);
        return valor != null ? valor : valorDefault;
    }

    /**
     * Muestra todas las secciones y sus valores
     */
    public void mostrarContenido() {
        System.out.println("\n=== CONTENIDO DEL ARCHIVO INI ===");

        secciones.forEach((seccion, propiedades) -> {
            System.out.println("\n[" + seccion + "]");
            propiedades.forEach((clave, valor) -> {
                System.out.printf("  %-25s = %s%n", clave, valor);
            });
        });

        System.out.println("\n================================\n");
    }

    /**
     * Lista todas las secciones disponibles
     */
    public Set<String> getSecciones() {
        return secciones.keySet();
    }

    public static void main(String[] args) {
        // Crear archivo INI de ejemplo
        String archivoINI = "aplicacion.ini";

        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoINI))) {
            writer.println("; Configuración de aplicación ASIR");
            writer.println("; Generado automáticamente");
            writer.println();
            writer.println("[Database]");
            writer.println("host = localhost");
            writer.println("port = 3306");
            writer.println("database = asir_db");
            writer.println("username = admin");
            writer.println("password = ******");
            writer.println();
            writer.println("[Server]");
            writer.println("bind_address = 0.0.0.0");
            writer.println("port = 8080");
            writer.println("workers = 4");
            writer.println("timeout = 60");
            writer.println();
            writer.println("[Logging]");
            writer.println("level = DEBUG");
            writer.println("file = /var/log/app.log");
            writer.println("max_size = 10MB");
            writer.println("backup_count = 5");

            System.out.println("✓ Archivo INI de ejemplo creado");
        } catch (IOException e) {
            System.err.println("✗ Error creando archivo: " + e.getMessage());
        }

        // Leer y procesar el archivo
        ConfigINIReader reader = new ConfigINIReader();
        reader.leerArchivo(archivoINI);
        reader.mostrarContenido();

        // Acceder a valores específicos
        System.out.println("=== ACCESO A VALORES ===");
        System.out.println("Database host: " + reader.getValor("Database", "host"));
        System.out.println("Server port: " + reader.getValor("Server", "port"));
        System.out.println("Log level: " + reader.getValor("Logging", "level"));

        // Listar secciones
        System.out.println("\nSecciones disponibles: " + reader.getSecciones());
    }
}
```

### 4.4 Lector Universal de Configuración

```java
import java.io.*;
import java.util.*;

/**
 * Lector universal que detecta y procesa diferentes formatos
 */
public class ConfigUniversalReader {

    public enum FormatoConfig {
        PROPERTIES,
        INI,
        JSON,
        XML,
        DESCONOCIDO
    }

    /**
     * Detecta el formato del archivo por su extensión
     */
    public static FormatoConfig detectarFormato(String rutaArchivo) {
        String extension = rutaArchivo.substring(rutaArchivo.lastIndexOf(".") + 1).toLowerCase();

        switch (extension) {
            case "properties":
                return FormatoConfig.PROPERTIES;
            case "ini":
            case "conf":
                return FormatoConfig.INI;
            case "json":
                return FormatoConfig.JSON;
            case "xml":
                return FormatoConfig.XML;
            default:
                return FormatoConfig.DESCONOCIDO;
        }
    }

    /**
     * Lee configuración según el formato detectado
     */
    public static Map<String, String> leerConfiguracion(String rutaArchivo) {
        FormatoConfig formato = detectarFormato(rutaArchivo);

        System.out.println("Formato detectado: " + formato);

        switch (formato) {
            case PROPERTIES:
                return leerProperties(rutaArchivo);
            case INI:
                return leerINI(rutaArchivo);
            default:
                System.err.println("Formato no soportado o desconocido");
                return new HashMap<>();
        }
    }

    private static Map<String, String> leerProperties(String rutaArchivo) {
        Map<String, String> config = new HashMap<>();
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
            props.load(fis);
            props.forEach((k, v) -> config.put(k.toString(), v.toString()));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return config;
    }

    private static Map<String, String> leerINI(String rutaArchivo) {
        Map<String, String> config = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            String seccionActual = "";

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.isEmpty() || linea.startsWith(";") || linea.startsWith("#")) {
                    continue;
                }

                if (linea.startsWith("[") && linea.endsWith("]")) {
                    seccionActual = linea.substring(1, linea.length() - 1) + ".";
                } else if (linea.contains("=")) {
                    String[] partes = linea.split("=", 2);
                    String clave = seccionActual + partes[0].trim();
                    String valor = partes.length > 1 ? partes[1].trim() : "";
                    config.put(clave, valor);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return config;
    }

    public static void main(String[] args) {
        // Ejemplo de uso con diferentes archivos
        String[] archivos = {
            "servidor.properties",
            "aplicacion.ini"
        };

        for (String archivo : archivos) {
            if (new File(archivo).exists()) {
                System.out.println("\n=== Procesando: " + archivo + " ===");
                Map<String, String> config = leerConfiguracion(archivo);

                config.forEach((k, v) -> System.out.printf("%-35s = %s%n", k, v));
            }
        }
    }
}
```

-----

## 5. Conexión y Consultas a Bases de Datos (JDBC Básico)

### 5.1 Introducción a JDBC

JDBC (Java Database Connectivity) permite conectar aplicaciones Java con bases de datos relacionales. Es fundamental en ASIR para:

- Gestión de usuarios y permisos
- Auditoría y logs
- Inventario de equipos
- Sistemas de monitorización

### 5.2 Configuración de JDBC

**Driver MySQL (ejemplo):**

```xml
<!-- En Maven (pom.xml) -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

**O descarga manual:**

- MySQL: https://dev.mysql.com/downloads/connector/j/
- PostgreSQL: https://jdbc.postgresql.org/
- SQLite: https://github.com/xerial/sqlite-jdbc

### 5.3 Conexión Básica a Base de Datos

```java
import java.sql.*;

/**
 * Gestor de conexiones a base de datos
 * Implementa patrón Singleton para conexión única
 */
public class DatabaseManager {

    private static DatabaseManager instance;
    private Connection connection;

    // Configuración de la base de datos
    private static final String DB_URL = "jdbc:mysql://localhost:3306/asir_db";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin123";

    private DatabaseManager() {
        try {
            // Cargar el driver (opcional en versiones modernas de JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ Driver MySQL cargado");
        } catch (ClassNotFoundException e) {
            System.err.println("✗ Error cargando driver: " + e.getMessage());
        }
    }

    /**
     * Obtiene la instancia única del gestor
     */
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    /**
     * Establece conexión con la base de datos
     */
    public Connection conectar() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("✓ Conexión establecida con la base de datos");
            }
        } catch (SQLException e) {
            System.err.println("✗ Error conectando a la base de datos: " + e.getMessage());
        }
        return connection;
    }

    /**
     * Cierra la conexión
     */
    public void desconectar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✓ Conexión cerrada");
            }
        } catch (SQLException e) {
            System.err.println("✗ Error cerrando conexión: " + e.getMessage());
        }
    }

    /**
     * Verifica si la conexión está activa
     */
    public boolean estaConectado() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Obtiene información sobre la base de datos
     */
    public void mostrarInfoDB() {
        try (Connection conn = conectar()) {
            DatabaseMetaData metaData = conn.getMetaData();

            System.out.println("\n=== INFORMACIÓN DE LA BASE DE DATOS ===");
            System.out.println("Producto: " + metaData.getDatabaseProductName());
            System.out.println("Versión: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver: " + metaData.getDriverName());
            System.out.println("Versión Driver: " + metaData.getDriverVersion());
            System.out.println("URL: " + metaData.getURL());
            System.out.println("Usuario: " + metaData.getUserName());
            System.out.println("=======================================\n");

        } catch (SQLException e) {
            System.err.println("Error obteniendo información: " + e.getMessage());
        }
    }
}
```

### 5.4 Sistema de Inventario de Equipos

```java
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Sistema de inventario de equipos informáticos
 * Gestiona el inventario de hardware de la organización
 */
public class InventarioEquipos {

    private DatabaseManager dbManager;

    public InventarioEquipos() {
        this.dbManager = DatabaseManager.getInstance();
        crearTablaSiNoExiste();
    }

    /**
     * Crea la tabla de inventario si no existe
     */
    private void crearTablaSiNoExiste() {
        String sql = """
            CREATE TABLE IF NOT EXISTS equipos (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(100) NOT NULL,
                tipo ENUM('PC', 'Servidor', 'Portátil', 'Switch', 'Router', 'Impresora', 'Otro'),
                marca VARCHAR(50),
                modelo VARCHAR(50),
                ip_address VARCHAR(15),
                mac_address VARCHAR(17),
                ubicacion VARCHAR(100),
                estado ENUM('Operativo', 'Mantenimiento', 'Averiado', 'Retirado'),
                fecha_alta DATE,
                ultima_revision DATETIME,
                notas TEXT
            )
            """;

        try (Connection conn = dbManager.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("✓ Tabla 'equipos' verificada/creada");

        } catch (SQLException e) {
            System.err.println("✗ Error creando tabla: " + e.getMessage());
        }
    }

    /**
     * Agrega un nuevo equipo al inventario
     */
    public boolean agregarEquipo(String nombre, String tipo, String marca, String modelo,
                                 String ip, String mac, String ubicacion, String estado) {

        String sql = """
            INSERT INTO equipos
            (nombre, tipo, marca, modelo, ip_address, mac_address, ubicacion, estado, fecha_alta, ultima_revision)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), NOW())
            """;

        try (Connection conn = dbManager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, tipo);
            pstmt.setString(3, marca);
            pstmt.setString(4, modelo);
            pstmt.setString(5, ip);
            pstmt.setString(6, mac);
            pstmt.setString(7, ubicacion);
            pstmt.setString(8, estado);

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✓ Equipo agregado: " + nombre);
                return true;
            }

        } catch (SQLException e) {
            System.err.println("✗ Error agregando equipo: " + e.getMessage());
        }

        return false;
    }

    /**
     * Lista todos los equipos del inventario
     */
    public void listarEquipos() {
        String sql = "SELECT * FROM equipos ORDER BY tipo, nombre";

        try (Connection conn = dbManager.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== INVENTARIO DE EQUIPOS ===");
            System.out.println("-".repeat(120));
            System.out.printf("%-5s %-20s %-12s %-15s %-15s %-15s %-20s %-12s%n",
                "ID", "NOMBRE", "TIPO", "IP", "MAC", "UBICACIÓN", "ESTADO", "ALTA");
            System.out.println("-".repeat(120));

            int contador = 0;
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-12s %-15s %-15s %-20s %-12s %-12s%n",
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("tipo"),
                    rs.getString("ip_address"),
                    rs.getString("mac_address"),
                    rs.getString("ubicacion"),
                    rs.getString("estado"),
                    rs.getDate("fecha_alta")
                );
                contador++;
            }

            System.out.println("-".repeat(120));
            System.out.println("Total de equipos: " + contador);
            System.out.println("=============================\n");

        } catch (SQLException e) {
            System.err.println("✗ Error listando equipos: " + e.getMessage());
        }
    }

    /**
     * Busca equipos por tipo
     */
    public void buscarPorTipo(String tipo) {
        String sql = "SELECT * FROM equipos WHERE tipo = ? ORDER BY nombre";

        try (Connection conn = dbManager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n=== EQUIPOS TIPO: " + tipo + " ===");

            int contador = 0;
            while (rs.next()) {
                System.out.printf("%d. %s - %s %s [%s] - %s%n",
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("ip_address"),
                    rs.getString("estado")
                );
                contador++;
            }

            System.out.println("Total encontrados: " + contador + "\n");

        } catch (SQLException e) {
            System.err.println("✗ Error en búsqueda: " + e.getMessage());
        }
    }

    /**
     * Actualiza el estado de un equipo
     */
    public boolean actualizarEstado(int id, String nuevoEstado, String notas) {
        String sql = """
            UPDATE equipos
            SET estado = ?, ultima_revision = NOW(), notas = ?
            WHERE id = ?
            """;

        try (Connection conn = dbManager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoEstado);
            pstmt.setString(2, notas);
            pstmt.setInt(3, id);

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✓ Estado actualizado para equipo ID: " + id);
                return true;
            } else {
                System.out.println("✗ No se encontró equipo con ID: " + id);
            }

        } catch (SQLException e) {
            System.err.println("✗ Error actualizando estado: " + e.getMessage());
        }

        return false;
    }

    /**
     * Genera estadísticas del inventario
     */
    public void mostrarEstadisticas() {
        String sql = """
            SELECT
                COUNT(*) as total,
                SUM(CASE WHEN estado = 'Operativo' THEN 1 ELSE 0 END) as operativos,
                SUM(CASE WHEN estado = 'Mantenimiento' THEN 1 ELSE 0 END) as mantenimiento,
                SUM(CASE WHEN estado = 'Averiado' THEN 1 ELSE 0 END) as averiados,
                SUM(CASE WHEN estado = 'Retirado' THEN 1 ELSE 0 END) as retirados
            FROM equipos
            """;

        try (Connection conn = dbManager.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("\n=== ESTADÍSTICAS DEL INVENTARIO ===");
                System.out.println("Total de equipos: " + rs.getInt("total"));
                System.out.println("  Operativos: " + rs.getInt("operativos"));
                System.out.println("  En mantenimiento: " + rs.getInt("mantenimiento"));
                System.out.println("  Averiados: " + rs.getInt("averiados"));
                System.out.println("  Retirados: " + rs.getInt("retirados"));

                // Calcular porcentaje operativo
                int total = rs.getInt("total");
                int operativos = rs.getInt("operativos");
                if (total > 0) {
                    double porcentaje = (operativos * 100.0) / total;
                    System.out.printf("  Disponibilidad: %.1f%%%n", porcentaje);
                }

                System.out.println("===================================\n");
            }

        } catch (SQLException e) {
            System.err.println("✗ Error generando estadísticas: " + e.getMessage());
        }
    }

    /**
     * Busca equipos por ubicación
     */
    public void buscarPorUbicacion(String ubicacion) {
        String sql = "SELECT * FROM equipos WHERE ubicacion LIKE ? ORDER BY tipo, nombre";

        try (Connection conn = dbManager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + ubicacion + "%");
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n=== EQUIPOS EN: " + ubicacion + " ===");

            int contador = 0;
            while (rs.next()) {
                System.out.printf("%s [%s] - %s - Estado: %s%n",
                    rs.getString("nombre"),
                    rs.getString("tipo"),
                    rs.getString("ip_address"),
                    rs.getString("estado")
                );
                contador++;
            }

            System.out.println("Total: " + contador + " equipos\n");

        } catch (SQLException e) {
            System.err.println("✗ Error en búsqueda: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        InventarioEquipos inventario = new InventarioEquipos();

        // Agregar equipos de ejemplo
        System.out.println("=== Agregando equipos al inventario ===\n");

        inventario.agregarEquipo("SRV-WEB-01", "Servidor", "Dell", "PowerEdge R740",
            "192.168.1.10", "00:1B:44:11:3A:B7", "Sala Servidores", "Operativo");

        inventario.agregarEquipo("PC-ADM-01", "PC", "HP", "EliteDesk 800",
            "192.168.1.50", "00:1B:44:11:3A:C8", "Oficina Administración", "Operativo");

        inventario.agregarEquipo("SW-CORE-01", "Switch", "Cisco", "Catalyst 2960",
            "192.168.1.1", "00:1B:44:11:3A:D9", "Sala Servidores", "Operativo");

        inventario.agregarEquipo("IMP-PLANTA1", "Impresora", "HP", "LaserJet Pro",
            "192.168.1.100", "00:1B:44:11:3A:E1", "Planta 1", "Mantenimiento");

        // Listar todos los equipos
        inventario.listarEquipos();

        // Buscar por tipo
        inventario.buscarPorTipo("Servidor");

        // Buscar por ubicación
        inventario.buscarPorUbicacion("Sala Servidores");

        // Actualizar estado
        inventario.actualizarEstado(4, "Operativo", "Mantenimiento preventivo completado");

        // Mostrar estadísticas
        inventario.mostrarEstadisticas();

        // Cerrar conexión
        DatabaseManager.getInstance().desconectar();
    }
}
```

### 5.5 Sistema de Logs y Auditoría

```java
import java.sql.*;
import java.time.LocalDateTime;

/**
 * Sistema de logs y auditoría en base de datos
 * Registra eventos del sistema para análisis posterior
 */
public class SistemaAuditoria {

    private DatabaseManager dbManager;

    public enum TipoEvento {
        LOGIN, LOGOUT, ERROR, WARNING, INFO,
        CAMBIO_CONFIG, ACCESO_ARCHIVO, COMANDO_EJECUTADO
    }

    public SistemaAuditoria() {
        this.dbManager = DatabaseManager.getInstance();
        crearTablaLogs();
    }

    /**
     * Crea tabla de logs si no existe
     */
    private void crearTablaLogs() {
        String sql = """
            CREATE TABLE IF NOT EXISTS logs_sistema (
                id INT AUTO_INCREMENT PRIMARY KEY,
                fecha_hora DATETIME NOT NULL,
                tipo_evento VARCHAR(30) NOT NULL,
                usuario VARCHAR(50),
                ip_origen VARCHAR(15),
                descripcion TEXT,
                detalles_tecnicos TEXT,
                nivel_severidad ENUM('INFO', 'WARNING', 'ERROR', 'CRITICAL'),
                INDEX idx_fecha (fecha_hora),
                INDEX idx_tipo (tipo_evento),
                INDEX idx_usuario (usuario)
            )
            """;

        try (Connection conn = dbManager.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("✓ Tabla de logs verificada/creada");

        } catch (SQLException e) {
            System.err.println("✗ Error creando tabla de logs: " + e.getMessage());
        }
    }

    /**
     * Registra un evento en el log
     */
    public void registrarEvento(TipoEvento tipo, String usuario, String ipOrigen,
                                String descripcion, String nivelSeveridad) {

        String sql = """
            INSERT INTO logs_sistema
            (fecha_hora, tipo_evento, usuario, ip_origen, descripcion, nivel_severidad)
            VALUES (NOW(), ?, ?, ?, ?, ?)
            """;

        try (Connection conn = dbManager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipo.toString());
            pstmt.setString(2, usuario);
            pstmt.setString(3, ipOrigen);
            pstmt.setString(4, descripcion);
            pstmt.setString(5, nivelSeveridad);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("✗ Error registrando evento: " + e.getMessage());
        }
    }

    /**
     * Consulta logs por rango de fechas
     */
    public void consultarLogsPorFecha(String fechaInicio, String fechaFin) {
        String sql = """
            SELECT * FROM logs_sistema
            WHERE fecha_hora BETWEEN ? AND ?
            ORDER BY fecha_hora DESC
            """;

        try (Connection conn = dbManager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, fechaInicio);
            pstmt.setString(2, fechaFin);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n=== LOGS DEL SISTEMA ===");
            System.out.println("Período: " + fechaInicio + " a " + fechaFin);
            System.out.println("-".repeat(100));

            while (rs.next()) {
                System.out.printf("[%s] %s - %s - Usuario: %s - IP: %s%n%s%n%n",
                    rs.getTimestamp("fecha_hora"),
                    rs.getString("nivel_severidad"),
                    rs.getString("tipo_evento"),
                    rs.getString("usuario"),
                    rs.getString("ip_origen"),
                    rs.getString("descripcion")
                );
            }

        } catch (SQLException e) {
            System.err.println("✗ Error consultando logs: " + e.getMessage());
        }
    }

    /**
     * Genera reporte de eventos por tipo
     */
    public void reporteEventosPorTipo() {
        String sql = """
            SELECT tipo_evento, COUNT(*) as cantidad,
                   SUM(CASE WHEN nivel_severidad = 'ERROR' THEN 1 ELSE 0 END) as errores,
                   SUM(CASE WHEN nivel_severidad = 'WARNING' THEN 1 ELSE 0 END) as advertencias
            FROM logs_sistema
            GROUP BY tipo_evento
            ORDER BY cantidad DESC
            """;

        try (Connection conn = dbManager.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== REPORTE DE EVENTOS ===");
            System.out.printf("%-25s %10s %10s %10s%n",
                "TIPO EVENTO", "CANTIDAD", "ERRORES", "WARNINGS");
            System.out.println("-".repeat(60));

            while (rs.next()) {
                System.out.printf("%-25s %10d %10d %10d%n",
                    rs.getString("tipo_evento"),
                    rs.getInt("cantidad"),
                    rs.getInt("errores"),
                    rs.getInt("advertencias")
                );
            }

            System.out.println("=========================\n");

        } catch (SQLException e) {
            System.err.println("✗ Error generando reporte: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SistemaAuditoria auditoria = new SistemaAuditoria();

        // Registrar eventos de ejemplo
        auditoria.registrarEvento(TipoEvento.LOGIN, "admin", "192.168.1.100",
            "Inicio de sesión exitoso", "INFO");

        auditoria.registrarEvento(TipoEvento.CAMBIO_CONFIG, "admin", "192.168.1.100",
            "Modificación de configuración del firewall", "WARNING");

        auditoria.registrarEvento(TipoEvento.ERROR, "system", "localhost",
            "Fallo al conectar con servidor de respaldo", "ERROR");

        // Generar reportes
        auditoria.reporteEventosPorTipo();

        DatabaseManager.getInstance().desconectar();
    }
}
```

-----

## 6. Manipulación de Datos CSV y JSON

### 6.1 Introducción

Los formatos CSV y JSON son fundamentales en ASIR para:

- Exportar/importar datos entre sistemas
- Configuración de servicios
- Intercambio de información con APIs
- Generación de reportes

### 6.2 Procesamiento de Archivos CSV

```java
import java.io.*;
import java.util.*;

/**
 * Procesador completo de archivos CSV
 * Lectura, escritura, búsqueda y transformación
 */
public class CSVProcessor {

    private String separador;

    public CSVProcessor() {
        this.separador = ",";
    }

    public CSVProcessor(String separador) {
        this.separador = separador;
    }

    /**
     * Lee un archivo CSV y retorna lista de registros
     */
    public List<Map<String, String>> leerCSV(String rutaArchivo) {
        List<Map<String, String>> registros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Leer encabezados
            String lineaEncabezados = br.readLine();
            if (lineaEncabezados == null) {
                System.err.println("✗ Archivo CSV vacío");
                return registros;
            }

            String[] encabezados = parsearLinea(lineaEncabezados);

            // Leer datos
            String linea;
            int numeroLinea = 1;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty()) continue;

                String[] valores = parsearLinea(linea);

                // Crear mapa clave-valor
                Map<String, String> registro = new HashMap<>();
                for (int i = 0; i < encabezados.length; i++) {
                    String valor = i < valores.length ? valores[i].trim() : "";
                    registro.put(encabezados[i].trim(), valor);
                }

                registros.add(registro);
            }

            System.out.println("✓ CSV leído: " + registros.size() + " registros desde " + rutaArchivo);

        } catch (IOException e) {
            System.err.println("✗ Error leyendo CSV: " + e.getMessage());
        }

        return registros;
    }

    /**
     * Parsea una línea CSV respetando comillas
     */
    private String[] parsearLinea(String linea) {
        List<String> valores = new ArrayList<>();
        StringBuilder valorActual = new StringBuilder();
        boolean dentroComillas = false;

        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);

            if (c == '"') {
                dentroComillas = !dentroComillas;
            } else if (c == separador.charAt(0) && !dentroComillas) {
                valores.add(valorActual.toString());
                valorActual = new StringBuilder();
            } else {
                valorActual.append(c);
            }
        }

        valores.add(valorActual.toString());
        return valores.toArray(new String[0]);
    }

    /**
     * Escribe datos a archivo CSV
     */
    public void escribirCSV(String rutaArchivo, List<String> encabezados,
                            List<Map<String, String>> registros) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            // Escribir encabezados
            writer.println(String.join(separador, encabezados));

            // Escribir registros
            for (Map<String, String> registro : registros) {
                List<String> valores = new ArrayList<>();
                for (String encabezado : encabezados) {
                    String valor = registro.getOrDefault(encabezado, "");
                    // Escapar valores con separador o comillas
                    if (valor.contains(separador) || valor.contains("\"")) {
                        valor = "\"" + valor.replace("\"", "\"\"") + "\"";
                    }
                    valores.add(valor);
                }
                writer.println(String.join(separador, valores));
            }

            System.out.println("✓ CSV escrito: " + registros.size() + " registros en " + rutaArchivo);

        } catch (IOException e) {
            System.err.println("✗ Error escribiendo CSV: " + e.getMessage());
        }
    }

    /**
     * Filtra registros por condición
     */
    public List<Map<String, String>> filtrar(List<Map<String, String>> registros,
                                              String campo, String valor) {
        List<Map<String, String>> resultados = new ArrayList<>();

        for (Map<String, String> registro : registros) {
            if (registro.get(campo) != null &&
                registro.get(campo).toLowerCase().contains(valor.toLowerCase())) {
                resultados.add(registro);
            }
        }

        System.out.println("✓ Filtrado: " + resultados.size() + " registros coinciden");
        return resultados;
    }

    /**
     * Agrupa y cuenta registros por campo
     */
    public Map<String, Integer> agruparYContar(List<Map<String, String>> registros, String campo) {
        Map<String, Integer> conteo = new HashMap<>();

        for (Map<String, String> registro : registros) {
            String valor = registro.get(campo);
            if (valor != null) {
                conteo.put(valor, conteo.getOrDefault(valor, 0) + 1);
            }
        }

        return conteo;
    }

    /**
     * Genera estadísticas del CSV
     */
    public void mostrarEstadisticas(List<Map<String, String>> registros) {
        if (registros.isEmpty()) {
            System.out.println("No hay registros para analizar");
            return;
        }

        System.out.println("\n=== ESTADÍSTICAS DEL CSV ===");
        System.out.println("Total de registros: " + registros.size());
        System.out.println("Campos disponibles: " + registros.get(0).keySet());
        System.out.println("===========================\n");
    }

    public static void main(String[] args) {
        CSVProcessor processor = new CSVProcessor();

        // Crear CSV de ejemplo: usuarios del sistema
        String archivoCSV = "usuarios_sistema.csv";

        List<String> encabezados = Arrays.asList(
            "username", "nombre", "departamento", "email", "estado", "ultimo_acceso"
        );

        List<Map<String, String>> usuarios = new ArrayList<>();

        Map<String, String> u1 = new HashMap<>();
        u1.put("username", "jgarcia");
        u1.put("nombre", "Juan García");
        u1.put("departamento", "IT");
        u1.put("email", "jgarcia@empresa.com");
        u1.put("estado", "activo");
        u1.put("ultimo_acceso", "2024-12-25");
        usuarios.add(u1);

        Map<String, String> u2 = new HashMap<>();
        u2.put("username", "mlopez");
        u2.put("nombre", "María López");
        u2.put("departamento", "RRHH");
        u2.put("email", "mlopez@empresa.com");
        u2.put("estado", "activo");
        u2.put("ultimo_acceso", "2024-12-26");
        usuarios.add(u2);

        Map<String, String> u3 = new HashMap<>();
        u3.put("username", "pmartin");
        u3.put("nombre", "Pedro Martín");
        u3.put("departamento", "IT");
        u3.put("email", "pmartin@empresa.com");
        u3.put("estado", "inactivo");
        u3.put("ultimo_acceso", "2024-11-15");
        usuarios.add(u3);

        // Escribir CSV
        processor.escribirCSV(archivoCSV, encabezados, usuarios);

        // Leer CSV
        List<Map<String, String>> usuariosLeidos = processor.leerCSV(archivoCSV);

        // Mostrar estadísticas
        processor.mostrarEstadisticas(usuariosLeidos);

        // Filtrar usuarios del departamento IT
        System.out.println("=== Usuarios del departamento IT ===");
        List<Map<String, String>> usuariosIT = processor.filtrar(usuariosLeidos, "departamento", "IT");
        usuariosIT.forEach(u -> System.out.println("- " + u.get("nombre") + " (" + u.get("username") + ")"));

        // Agrupar por estado
        System.out.println("\n=== Usuarios por estado ===");
        Map<String, Integer> porEstado = processor.agruparYContar(usuariosLeidos, "estado");
        porEstado.forEach((estado, cantidad) ->
            System.out.println(estado + ": " + cantidad)
        );
    }
}
```

### 6.3 Procesamiento de Archivos JSON (sin librerías externas)

```java
import java.io.*;
import java.util.*;

/**
 * Parser JSON simple sin dependencias externas
 * Procesa JSON básico para configuraciones
 */
public class SimpleJSONParser {

    /**
     * Lee archivo JSON y lo parsea a estructura de datos
     */
    public static Map<String, Object> leerJSON(String rutaArchivo) {
        try {
            String contenido = leerArchivo(rutaArchivo);
            return parsearObjeto(contenido.trim());
        } catch (IOException e) {
            System.err.println("✗ Error leyendo JSON: " + e.getMessage());
            return new HashMap<>();
        }
    }

    /**
     * Lee todo el contenido de un archivo
     */
    private static String leerArchivo(String rutaArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea.trim());
            }
        }
        return contenido.toString();
    }

    /**
     * Parsea un objeto JSON
     */
    private static Map<String, Object> parsearObjeto(String json) {
        Map<String, Object> mapa = new HashMap<>();

        // Remover llaves externas
        json = json.trim();
        if (json.startsWith("{")) json = json.substring(1);
        if (json.endsWith("}")) json = json.substring(0, json.length() - 1);

        // Parsear pares clave-valor
        String[] pares = dividirPares(json);

        for (String par : pares) {
            if (par.trim().isEmpty()) continue;

            int indiceDosPuntos = par.indexOf(":");
            if (indiceDosPuntos == -1) continue;

            String clave = par.substring(0, indiceDosPuntos).trim();
            String valor = par.substring(indiceDosPuntos + 1).trim();

            // Limpiar comillas de la clave
            clave = clave.replace("\"", "");

            // Parsear el valor
            Object valorParseado = parsearValor(valor);
            mapa.put(clave, valorParseado);
        }

        return mapa;
    }

    /**
     * Divide el JSON en pares clave-valor
     */
    private static String[] dividirPares(String json) {
        List<String> pares = new ArrayList<>();
        StringBuilder parActual = new StringBuilder();
        int nivel = 0;
        boolean entreComillas = false;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            if (c == '"' && (i == 0 || json.charAt(i-1) != '\\')) {
                entreComillas = !entreComillas;
            }

            if (!entreComillas) {
                if (c == '{' || c == '[') nivel++;
                if (c == '}' || c == ']') nivel--;

                if (c == ',' && nivel == 0) {
                    pares.add(parActual.toString());
                    parActual = new StringBuilder();
                    continue;
                }
            }

            parActual.append(c);
        }

        if (parActual.length() > 0) {
            pares.add(parActual.toString());
        }

        return pares.toArray(new String[0]);
    }

    /**
     * Parsea un valor JSON
     */
    private static Object parsearValor(String valor) {
        valor = valor.trim();

        // null
        if (valor.equals("null")) return null;

        // boolean
        if (valor.equals("true")) return true;
        if (valor.equals("false")) return false;

        // String
        if (valor.startsWith("\"") && valor.endsWith("\"")) {
            return valor.substring(1, valor.length() - 1);
        }

        // Número
        try {
            if (valor.contains(".")) {
                return Double.parseDouble(valor);
            } else {
                return Integer.parseInt(valor);
            }
        } catch (NumberFormatException e) {
            // No es número
        }

        // Array
        if (valor.startsWith("[") && valor.endsWith("]")) {
            return parsearArray(valor);
        }

        // Objeto
        if (valor.startsWith("{") && valor.endsWith("}")) {
            return parsearObjeto(valor);
        }

        return valor;
    }

    /**
     * Parsea un array JSON
     */
    private static List<Object> parsearArray(String json) {
        List<Object> lista = new ArrayList<>();

        // Remover corchetes
        json = json.substring(1, json.length() - 1).trim();

        if (json.isEmpty()) return lista;

        String[] elementos = dividirPares(json);

        for (String elemento : elementos) {
            lista.add(parsearValor(elemento.trim()));
        }

        return lista;
    }

    /**
     * Obtiene un valor del JSON de forma segura
     */
    public static Object obtenerValor(Map<String, Object> json, String ruta) {
        String[] partes = ruta.split("\\.");
        Object actual = json;

        for (String parte : partes) {
            if (actual instanceof Map) {
                actual = ((Map<String, Object>) actual).get(parte);
                if (actual == null) return null;
            } else {
                return null;
            }
        }

        return actual;
    }

    /**
     * Convierte Map a JSON string
     */
    public static String aJSON(Map<String, Object> mapa) {
        StringBuilder json = new StringBuilder("{");
        boolean primero = true;

        for (Map.Entry<String, Object> entrada : mapa.entrySet()) {
            if (!primero) json.append(",");
            primero = false;

            json.append("\"").append(entrada.getKey()).append("\":");
            json.append(valorAJSON(entrada.getValue()));
        }

        json.append("}");
        return json.toString();
    }

    private static String valorAJSON(Object valor) {
        if (valor == null) return "null";
        if (valor instanceof String) return "\"" + valor + "\"";
        if (valor instanceof Number) return valor.toString();
        if (valor instanceof Boolean) return valor.toString();
        if (valor instanceof Map) return aJSON((Map<String, Object>) valor);
        if (valor instanceof List) return listaAJSON((List<Object>) valor);
        return "\"" + valor.toString() + "\"";
    }

    private static String listaAJSON(List<Object> lista) {
        StringBuilder json = new StringBuilder("[");
        boolean primero = true;

        for (Object elemento : lista) {
            if (!primero) json.append(",");
            primero = false;
            json.append(valorAJSON(elemento));
        }

        json.append("]");
        return json.toString();
    }

    /**
     * Escribe JSON a archivo
     */
    public static void escribirJSON(String rutaArchivo, Map<String, Object> datos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            String json = aJSON(datos);
            // Formatear básico
            writer.println(formatearJSON(json));
            System.out.println("✓ JSON escrito en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("✗ Error escribiendo JSON: " + e.getMessage());
        }
    }

    /**
     * Formatea JSON con indentación
     */
    private static String formatearJSON(String json) {
        StringBuilder formateado = new StringBuilder();
        int indentacion = 0;
        boolean entreComillas = false;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            if (c == '"' && (i == 0 || json.charAt(i-1) != '\\')) {
                entreComillas = !entreComillas;
            }

            if (!entreComillas) {
                if (c == '{' || c == '[') {
                    formateado.append(c).append("\n");
                    indentacion++;
                    formateado.append("  ".repeat(indentacion));
                } else if (c == '}' || c == ']') {
                    formateado.append("\n");
                    indentacion--;
                    formateado.append("  ".repeat(indentacion));
                    formateado.append(c);
                } else if (c == ',') {
                    formateado.append(c).append("\n");
                    formateado.append("  ".repeat(indentacion));
                } else {
                    formateado.append(c);
                }
            } else {
                formateado.append(c);
            }
        }

        return formateado.toString();
    }

    public static void main(String[] args) {
        // Crear configuración JSON de ejemplo
        String archivoJSON = "config_servidor.json";

        Map<String, Object> config = new HashMap<>();
        config.put("nombre_servidor", "SRV-WEB-01");
        config.put("ip", "192.168.1.10");
        config.put("puerto", 8080);
        config.put("ssl_habilitado", true);
        config.put("max_conexiones", 100);

        Map<String, Object> logs = new HashMap<>();
        logs.put("ruta", "/var/log/servidor/");
        logs.put("nivel", "INFO");
        logs.put("rotacion", true);
        config.put("logs", logs);

        List<Object> servicios = new ArrayList<>();
        servicios.add("HTTP");
        servicios.add("HTTPS");
        servicios.add("FTP");
        config.put("servicios_activos", servicios);

        // Escribir JSON
        escribirJSON(archivoJSON, config);

        // Leer JSON
        Map<String, Object> configLeida = leerJSON(archivoJSON);

        System.out.println("\n=== CONFIGURACIÓN LEÍDA ===");
        System.out.println("Servidor: " + configLeida.get("nombre_servidor"));
        System.out.println("IP: " + configLeida.get("ip"));
        System.out.println("Puerto: " + configLeida.get("puerto"));

        // Acceder a valores anidados
        Map<String, Object> logsLeidos = (Map<String, Object>) configLeida.get("logs");
        System.out.println("Nivel de logs: " + logsLeidos.get("nivel"));

        List<Object> serviciosLeidos = (List<Object>) configLeida.get("servicios_activos");
        System.out.println("Servicios activos: " + serviciosLeidos);
    }
}
```

-----

## 7. Herramientas de Línea de Comandos

### 7.1 Introducción

Las herramientas CLI (Command Line Interface) son esenciales en ASIR para:

- Automatización de tareas administrativas
- Scripts de mantenimiento
- Herramientas de diagnóstico
- Utilidades del sistema

### 7.2 Framework para CLIs en Java

```java
import java.util.*;

/**
 * Framework para crear herramientas de línea de comandos
 * Procesa argumentos, opciones y subcomandos
 */
public class CLIFramework {

    private String nombreApp;
    private String version;
    private String descripcion;
    private Map<String, Comando> comandos;
    private Map<String, Opcion> opciones;

    public CLIFramework(String nombre, String version, String descripcion) {
        this.nombreApp = nombre;
        this.version = version;
        this.descripcion = descripcion;
        this.comandos = new HashMap<>();
        this.opciones = new HashMap<>();
    }

    /**
     * Registra un nuevo comando
     */
    public void registrarComando(String nombre, String descripcion, AccionComando accion) {
        comandos.put(nombre, new Comando(nombre, descripcion, accion));
    }

    /**
     * Registra una opción global
     */
    public void registrarOpcion(String nombreCorto, String nombreLargo,
                                String descripcion, boolean requiereValor) {
        Opcion opcion = new Opcion(nombreCorto, nombreLargo, descripcion, requiereValor);
        opciones.put(nombreCorto, opcion);
        opciones.put(nombreLargo, opcion);
    }

    /**
     * Procesa los argumentos de la línea de comandos
     */
    public void ejecutar(String[] args) {
        if (args.length == 0) {
            mostrarAyuda();
            return;
        }

        // Procesar opciones globales
        Map<String, String> opcionesActivadas = new HashMap<>();
        List<String> argumentos = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (arg.startsWith("--")) {
                // Opción larga
                String nombreOpcion = arg.substring(2);
                Opcion opcion = opciones.get(nombreOpcion);

                if (opcion != null && opcion.requiereValor && i + 1 < args.length) {
                    opcionesActivadas.put(nombreOpcion, args[++i]);
                } else if (opcion != null) {
                    opcionesActivadas.put(nombreOpcion, "true");
                }
            } else if (arg.startsWith("-")) {
                // Opción corta
                String nombreOpcion = arg.substring(1);
                Opcion opcion = opciones.get(nombreOpcion);

                if (opcion != null && opcion.requiereValor && i + 1 < args.length) {
                    opcionesActivadas.put(nombreOpcion, args[++i]);
                } else if (opcion != null) {
                    opcionesActivadas.put(nombreOpcion, "true");
                }
            } else {
                argumentos.add(arg);
            }
        }

        // Procesar comandos especiales
        if (opcionesActivadas.containsKey("help") || opcionesActivadas.containsKey("h")) {
            mostrarAyuda();
            return;
        }

        if (opcionesActivadas.containsKey("version") || opcionesActivadas.containsKey("v")) {
            mostrarVersion();
            return;
        }

        // Ejecutar comando
        if (argumentos.isEmpty()) {
            System.err.println("Error: Debe especificar un comando");
            mostrarAyuda();
            return;
        }

        String nombreComando = argumentos.get(0);
        Comando comando = comandos.get(nombreComando);

        if (comando == null) {
            System.err.println("Error: Comando desconocido '" + nombreComando + "'");
            mostrarAyuda();
            return;
        }

        // Ejecutar el comando con los argumentos restantes
        String[] argsComando = argumentos.subList(1, argumentos.size()).toArray(new String[0]);
        comando.accion.ejecutar(argsComando, opcionesActivadas);
    }

    /**
     * Muestra la ayuda general
     */
    private void mostrarAyuda() {
        System.out.println(nombreApp + " v" + version);
        System.out.println(descripcion);
        System.out.println("\nUso: " + nombreApp + " [opciones] <comando> [argumentos]");

        System.out.println("\nOpciones globales:");
        opciones.values().stream()
            .distinct()
            .forEach(o -> System.out.printf("  -%-10s --%-15s %s%n",
                o.nombreCorto, o.nombreLargo, o.descripcion));

        System.out.println("\nComandos disponibles:");
        comandos.values().forEach(c ->
            System.out.printf("  %-15s %s%n", c.nombre, c.descripcion));

        System.out.println("\nEjecuta '" + nombreApp + " <comando> --help' para más información sobre un comando.");
    }

    /**
     * Muestra la versión
     */
    private void mostrarVersion() {
        System.out.println(nombreApp + " versión " + version);
    }

    // Clases internas

    static class Comando {
        String nombre;
        String descripcion;
        AccionComando accion;

        Comando(String nombre, String descripcion, AccionComando accion) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.accion = accion;
        }
    }

    static class Opcion {
        String nombreCorto;
        String nombreLargo;
        String descripcion;
        boolean requiereValor;

        Opcion(String nombreCorto, String nombreLargo, String descripcion, boolean requiereValor) {
            this.nombreCorto = nombreCorto;
            this.nombreLargo = nombreLargo;
            this.descripcion = descripcion;
            this.requiereValor = requiereValor;
        }
    }

    @FunctionalInterface
    interface AccionComando {
        void ejecutar(String[] args, Map<String, String> opciones);
    }
}
```

### 7.3 Herramienta CLI de Gestión de Servicios

```java
import java.io.*;
import java.util.*;

/**
 * Herramienta CLI para gestión de servicios del sistema
 * Simula comandos como systemctl pero en Java
 */
public class ServiceManagerCLI {

    private static final String SERVICES_FILE = "servicios.dat";
    private static Map<String, ServicioInfo> servicios = new HashMap<>();

    static class ServicioInfo {
        String nombre;
        String descripcion;
        String estado;  // running, stopped
        boolean autoInicio;

        ServicioInfo(String nombre, String descripcion, String estado, boolean autoInicio) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.estado = estado;
            this.autoInicio = autoInicio;
        }

        @Override
        public String toString() {
            return String.format("%-20s %-15s %s %s",
                nombre,
                estado,
                autoInicio ? "[AUTO]" : "      ",
                descripcion
            );
        }
    }

    public static void main(String[] args) {
        cargarServicios();

        CLIFramework cli = new CLIFramework(
            "servicemanager",
            "1.0.0",
            "Herramienta de gestión de servicios del sistema"
        );

        // Opciones globales
        cli.registrarOpcion("h", "help", "Muestra esta ayuda", false);
        cli.registrarOpcion("v", "version", "Muestra la versión", false);
        cli.registrarOpcion("q", "quiet", "Modo silencioso", false);

        // Comando: list
        cli.registrarComando("list", "Lista todos los servicios", (cmdArgs, opciones) -> {
            System.out.println("\n=== SERVICIOS DEL SISTEMA ===");
            System.out.println(String.format("%-20s %-15s %-7s %s",
                "SERVICIO", "ESTADO", "AUTO", "DESCRIPCIÓN"));
            System.out.println("-".repeat(80));

            servicios.values().stream()
                .sorted(Comparator.comparing(s -> s.nombre))
                .forEach(System.out::println);

            System.out.println("\nTotal de servicios: " + servicios.size());
            long running = servicios.values().stream()
                .filter(s -> "running".equals(s.estado))
                .count();
            System.out.println("En ejecución: " + running);
        });

        // Comando: start
        cli.registrarComando("start", "Inicia un servicio", (cmdArgs, opciones) -> {
            if (cmdArgs.length == 0) {
                System.err.println("Error: Debe especificar el nombre del servicio");
                return;
            }

            String nombreServicio = cmdArgs[0];
            ServicioInfo servicio = servicios.get(nombreServicio);

            if (servicio == null) {
                System.err.println("Error: Servicio '" + nombreServicio + "' no encontrado");
                return;
            }

            if ("running".equals(servicio.estado)) {
                System.out.println("El servicio '" + nombreServicio + "' ya está en ejecución");
                return;
            }

            servicio.estado = "running";
            guardarServicios();

            if (!opciones.containsKey("quiet")) {
                System.out.println("✓ Servicio '" + nombreServicio + "' iniciado correctamente");
            }
        });

        // Comando: stop
        cli.registrarComando("stop", "Detiene un servicio", (cmdArgs, opciones) -> {
            if (cmdArgs.length == 0) {
                System.err.println("Error: Debe especificar el nombre del servicio");
                return;
            }

            String nombreServicio = cmdArgs[0];
            ServicioInfo servicio = servicios.get(nombreServicio);

            if (servicio == null) {
                System.err.println("Error: Servicio '" + nombreServicio + "' no encontrado");
                return;
            }

            if ("stopped".equals(servicio.estado)) {
                System.out.println("El servicio '" + nombreServicio + "' ya está detenido");
                return;
            }

            servicio.estado = "stopped";
            guardarServicios();

            if (!opciones.containsKey("quiet")) {
                System.out.println("✓ Servicio '" + nombreServicio + "' detenido correctamente");
            }
        });

        // Comando: status
        cli.registrarComando("status", "Muestra el estado de un servicio", (cmdArgs, opciones) -> {
            if (cmdArgs.length == 0) {
                System.err.println("Error: Debe especificar el nombre del servicio");
                return;
            }

            String nombreServicio = cmdArgs[0];
            ServicioInfo servicio = servicios.get(nombreServicio);

            if (servicio == null) {
                System.err.println("Error: Servicio '" + nombreServicio + "' no encontrado");
                return;
            }

            System.out.println("\n● " + servicio.nombre);
            System.out.println("  Descripción: " + servicio.descripcion);
            System.out.println("  Estado: " + servicio.estado);
            System.out.println("  Auto-inicio: " + (servicio.autoInicio ? "Sí" : "No"));
        });

        // Comando: enable
        cli.registrarComando("enable", "Habilita el auto-inicio de un servicio", (cmdArgs, opciones) -> {
            if (cmdArgs.length == 0) {
                System.err.println("Error: Debe especificar el nombre del servicio");
                return;
            }

            String nombreServicio = cmdArgs[0];
            ServicioInfo servicio = servicios.get(nombreServicio);

            if (servicio == null) {
                System.err.println("Error: Servicio '" + nombreServicio + "' no encontrado");
                return;
            }

            servicio.autoInicio = true;
            guardarServicios();
            System.out.println("✓ Auto-inicio habilitado para '" + nombreServicio + "'");
        });

        // Comando: disable
        cli.registrarComando("disable", "Deshabilita el auto-inicio de un servicio", (cmdArgs, opciones) -> {
            if (cmdArgs.length == 0) {
                System.err.println("Error: Debe especificar el nombre del servicio");
                return;
            }

            String nombreServicio = cmdArgs[0];
            ServicioInfo servicio = servicios.get(nombreServicio);

            if (servicio == null) {
                System.err.println("Error: Servicio '" + nombreServicio + "' no encontrado");
                return;
            }

            servicio.autoInicio = false;
            guardarServicios();
            System.out.println("✓ Auto-inicio deshabilitado para '" + nombreServicio + "'");
        });

        // Ejecutar CLI
        cli.ejecutar(args);
    }

    private static void cargarServicios() {
        File archivo = new File(SERVICES_FILE);

        if (!archivo.exists()) {
            // Crear servicios de ejemplo
            servicios.put("apache2", new ServicioInfo("apache2", "Servidor Web Apache", "running", true));
            servicios.put("mysql", new ServicioInfo("mysql", "Servidor de Base de Datos MySQL", "running", true));
            servicios.put("ssh", new ServicioInfo("ssh", "Servidor SSH", "running", true));
            servicios.put("ftp", new ServicioInfo("ftp", "Servidor FTP", "stopped", false));
            servicios.put("backup", new ServicioInfo("backup", "Servicio de Respaldo", "stopped", true));

            guardarServicios();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            servicios = (Map<String, ServicioInfo>) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error cargando servicios: " + e.getMessage());
        }
    }

    private static void guardarServicios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERVICES_FILE))) {
            oos.writeObject(servicios);
        } catch (IOException e) {
            System.err.println("Error guardando servicios: " + e.getMessage());
        }
    }
}
```

### 7.4 Herramienta CLI de Monitorización

```java
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Herramienta CLI de monitorización del sistema
 * Muestra información de recursos, procesos, red, etc.
 */
public class SystemMonitorCLI {

    public static void main(String[] args) {
        CLIFramework cli = new CLIFramework(
            "sysmonitor",
            "1.0.0",
            "Herramienta de monitorización del sistema"
        );

        // Opciones globales
        cli.registrarOpcion("h", "help", "Muestra ayuda", false);
        cli.registrarOpcion("v", "version", "Muestra versión", false);
        cli.registrarOpcion("r", "refresh", "Intervalo de refresco en segundos", true);

        // Comando: cpu
        cli.registrarComando("cpu", "Muestra uso de CPU", (cmdArgs, opciones) -> {
            mostrarUsoCPU();
        });

        // Comando: memory
        cli.registrarComando("memory", "Muestra uso de memoria", (cmdArgs, opciones) -> {
            mostrarUsoMemoria();
        });

        // Comando: disk
        cli.registrarComando("disk", "Muestra uso de disco", (cmdArgs, opciones) -> {
            mostrarUsoDisco();
        });

        // Comando: network
        cli.registrarComando("network", "Muestra información de red", (cmdArgs, opciones) -> {
            mostrarInfoRed();
        });

        // Comando: all
        cli.registrarComando("all", "Muestra toda la información del sistema", (cmdArgs, opciones) -> {
            int intervalo = 0;
            if (opciones.containsKey("refresh")) {
                try {
                    intervalo = Integer.parseInt(opciones.get("refresh"));
                } catch (NumberFormatException e) {
                    System.err.println("Error: Intervalo debe ser un número");
                    return;
                }
            }

            do {
                limpiarPantalla();
                mostrarEncabezado();
                mostrarUsoCPU();
                mostrarUsoMemoria();
                mostrarUsoDisco();
                mostrarInfoRed();

                if (intervalo > 0) {
                    System.out.println("\nActualizando en " + intervalo + " segundos... (Ctrl+C para salir)");
                    try {
                        Thread.sleep(intervalo * 1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            } while (intervalo > 0);
        });

        cli.ejecutar(args);
    }

    private static void mostrarEncabezado() {
        System.out.println("=== MONITOR DEL SISTEMA ===");
        System.out.println("Fecha: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Host: " + obtenerHostname());
        System.out.println();
    }

    private static void mostrarUsoCPU() {
        Runtime runtime = Runtime.getRuntime();
        int procesadores = runtime.availableProcessors();

        System.out.println("--- CPU ---");
        System.out.println("Procesadores disponibles: " + procesadores);

        // Simular carga (en un sistema real se usarían APIs nativas)
        double carga = Math.random() * 100;
        System.out.printf("Carga estimada: %.1f%%%n", carga);

        mostrarBarraProgreso("CPU", carga);
        System.out.println();
    }

    private static void mostrarUsoMemoria() {
        Runtime runtime = Runtime.getRuntime();
        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;
        long memoriaMaxima = runtime.maxMemory();

        System.out.println("--- MEMORIA ---");
        System.out.printf("Total: %s%n", formatearBytes(memoriaTotal));
        System.out.printf("Usada: %s%n", formatearBytes(memoriaUsada));
        System.out.printf("Libre: %s%n", formatearBytes(memoriaLibre));
        System.out.printf("Máxima: %s%n", formatearBytes(memoriaMaxima));

        double porcentaje = (memoriaUsada * 100.0) / memoriaTotal;
        mostrarBarraProgreso("MEM", porcentaje);
        System.out.println();
    }

    private static void mostrarUsoDisco() {
        System.out.println("--- DISCO ---");

        File[] roots = File.listRoots();
        for (File root : roots) {
            long total = root.getTotalSpace();
            long libre = root.getFreeSpace();
            long usado = total - libre;

            System.out.printf("Unidad: %s%n", root.getAbsolutePath());
            System.out.printf("  Total: %s%n", formatearBytes(total));
            System.out.printf("  Usado: %s%n", formatearBytes(usado));
            System.out.printf("  Libre: %s%n", formatearBytes(libre));

            if (total > 0) {
                double porcentaje = (usado * 100.0) / total;
                mostrarBarraProgreso("DISK", porcentaje);
            }
        }
        System.out.println();
    }

    private static void mostrarInfoRed() {
        System.out.println("--- RED ---");

        try {
            java.net.InetAddress localhost = java.net.InetAddress.getLocalHost();
            System.out.println("Hostname: " + localhost.getHostName());
            System.out.println("IP: " + localhost.getHostAddress());

            // Listar interfaces de red
            java.net.NetworkInterface.getNetworkInterfaces().asIterator().forEachRemaining(ni -> {
                try {
                    if (ni.isUp() && !ni.isLoopback()) {
                        System.out.println("\nInterfaz: " + ni.getDisplayName());
                        ni.getInetAddresses().asIterator().forEachRemaining(addr -> {
                            System.out.println("  " + addr.getHostAddress());
                        });
                    }
                } catch (Exception e) {
                    // Ignorar errores
                }
            });

        } catch (Exception e) {
            System.out.println("Error obteniendo información de red: " + e.getMessage());
        }
        System.out.println();
    }

    private static void mostrarBarraProgreso(String etiqueta, double porcentaje) {
        int longitud = 40;
        int lleno = (int) ((porcentaje / 100.0) * longitud);

        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < longitud; i++) {
            if (i < lleno) {
                barra.append("█");
            } else {
                barra.append("░");
            }
        }
        barra.append("]");

        System.out.printf("%-5s %s %.1f%%%n", etiqueta, barra, porcentaje);
    }

    private static String formatearBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.2f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.2f MB", bytes / (1024.0 * 1024));
        return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
    }

    private static String obtenerHostname() {
        try {
            return java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            return "desconocido";
        }
    }

    private static void limpiarPantalla() {
        // En sistemas Unix/Linux
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Alternativa multiplataforma (menos efectiva)
        // for (int i = 0; i < 50; i++) System.out.println();
    }
}
```

-----

Este módulo proporciona aplicaciones prácticas reales que un administrador de sistemas puede utilizar en su trabajo diario. Cada herramienta está diseñada para ser funcional, eficiente y fácil de mantener.
