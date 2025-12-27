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

-----

Este módulo proporciona aplicaciones prácticas reales que un administrador de sistemas puede utilizar en su trabajo diario. Cada herramienta está diseñada para ser funcional, eficiente y fácil de mantener.
