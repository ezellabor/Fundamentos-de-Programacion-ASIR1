<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# MÓDULO 11: PROGRAMACIÓN CON FECHAS Y TIEMPO

## 1. Paquete java.time

Desde Java 8, el paquete `java.time` ofrece una API moderna para trabajar con fechas y horas, reemplazando las antiguas clases Date y Calendar.

### Clases principales

```
java.time
├── LocalDate        → Fecha sin hora (2024-01-15)
├── LocalTime        → Hora sin fecha (14:30:00)
├── LocalDateTime    → Fecha y hora sin zona horaria (2024-01-15T14:30:00)
├── ZonedDateTime    → Fecha y hora con zona horaria
├── Instant          → Punto en el tiempo (timestamp)
├── Duration         → Cantidad de tiempo (horas, minutos, segundos)
└── Period           → Cantidad de tiempo (años, meses, días)
```

### Características

- **Inmutables**: Todas las clases son inmutables y thread-safe
- **Basadas en ISO-8601**: Estándar internacional de fechas
- **API fluida**: Métodos encadenables
- **Sin confusión**: Meses de 1-12 (no 0-11 como Calendar)

## 2. LocalDate, LocalTime y LocalDateTime

### LocalDate - Solo fecha

```java
import java.time.LocalDate;
import java.time.Month;

public class EjemplosLocalDate {

    public static void ejemplos() {
        // Crear fechas
        LocalDate hoy = LocalDate.now();
        LocalDate fecha1 = LocalDate.of(2024, 12, 25);
        LocalDate fecha2 = LocalDate.of(2024, Month.DECEMBER, 25);
        LocalDate fecha3 = LocalDate.parse("2024-12-25");

        System.out.println("Hoy: " + hoy);              // 2024-01-15
        System.out.println("Navidad: " + fecha1);       // 2024-12-25

        // Obtener componentes
        int año = hoy.getYear();                        // 2024
        Month mes = hoy.getMonth();                     // JANUARY
        int mesNum = hoy.getMonthValue();              // 1
        int dia = hoy.getDayOfMonth();                 // 15
        int diaAño = hoy.getDayOfYear();               // 15
        DayOfWeek diaSemana = hoy.getDayOfWeek();      // MONDAY

        // Operaciones
        LocalDate mañana = hoy.plusDays(1);
        LocalDate mesProximo = hoy.plusMonths(1);
        LocalDate añoProximo = hoy.plusYears(1);
        LocalDate ayer = hoy.minusDays(1);

        // Comparaciones
        boolean esAntes = fecha1.isBefore(hoy);
        boolean esDespues = fecha1.isAfter(hoy);
        boolean esIgual = fecha1.isEqual(hoy);

        // Consultas
        boolean esBisiesto = hoy.isLeapYear();
        int diasMes = hoy.lengthOfMonth();             // 31
        int diasAño = hoy.lengthOfYear();              // 365 o 366
    }
}
```

### LocalTime - Solo hora

```java
import java.time.LocalTime;

public class EjemplosLocalTime {

    public static void ejemplos() {
        // Crear horas
        LocalTime ahora = LocalTime.now();
        LocalTime hora1 = LocalTime.of(14, 30);              // 14:30
        LocalTime hora2 = LocalTime.of(14, 30, 45);          // 14:30:45
        LocalTime hora3 = LocalTime.of(14, 30, 45, 123456789); // 14:30:45.123456789
        LocalTime hora4 = LocalTime.parse("14:30:45");

        System.out.println("Ahora: " + ahora);

        // Obtener componentes
        int hora = ahora.getHour();                    // 14
        int minuto = ahora.getMinute();                // 30
        int segundo = ahora.getSecond();               // 45
        int nano = ahora.getNano();                    // nanosegundos

        // Operaciones
        LocalTime enUnaHora = ahora.plusHours(1);
        LocalTime en30Min = ahora.plusMinutes(30);
        LocalTime hace15Min = ahora.minusMinutes(15);

        // Constantes útiles
        LocalTime medianoche = LocalTime.MIDNIGHT;     // 00:00
        LocalTime mediodia = LocalTime.NOON;           // 12:00
        LocalTime min = LocalTime.MIN;                 // 00:00
        LocalTime max = LocalTime.MAX;                 // 23:59:59.999999999
    }
}
```

### LocalDateTime - Fecha y hora

```java
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class EjemplosLocalDateTime {

    public static void ejemplos() {
        // Crear fecha-hora
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime fechaHora1 = LocalDateTime.of(2024, 12, 25, 14, 30);
        LocalDateTime fechaHora2 = LocalDateTime.of(2024, 12, 25, 14, 30, 45);
        LocalDateTime fechaHora3 = LocalDateTime.parse("2024-12-25T14:30:45");

        // Combinar LocalDate y LocalTime
        LocalDate fecha = LocalDate.of(2024, 12, 25);
        LocalTime hora = LocalTime.of(14, 30);
        LocalDateTime combinado = LocalDateTime.of(fecha, hora);

        System.out.println("Ahora: " + ahora);

        // Obtener componentes
        LocalDate soloFecha = ahora.toLocalDate();
        LocalTime soloHora = ahora.toLocalTime();
        int año = ahora.getYear();
        int mes = ahora.getMonthValue();
        int dia = ahora.getDayOfMonth();
        int hora24 = ahora.getHour();
        int minuto = ahora.getMinute();

        // Operaciones
        LocalDateTime mañana = ahora.plusDays(1);
        LocalDateTime en2Horas = ahora.plusHours(2);
        LocalDateTime hace1Semana = ahora.minusWeeks(1);

        // Modificar componentes
        LocalDateTime modificado = ahora
                .withYear(2025)
                .withMonth(6)
                .withDayOfMonth(15)
                .withHour(9)
                .withMinute(0)
                .withSecond(0);
    }
}
```

### Ejemplo práctico: Sistema de logs con timestamp

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class SistemaLogs {
    private static final String ARCHIVO_LOG = "/var/log/app.log";

    public enum Nivel {
        INFO, WARNING, ERROR, CRITICAL
    }

    public static void log(Nivel nivel, String mensaje) {
        LocalDateTime timestamp = LocalDateTime.now();
        String entrada = formatearLog(timestamp, nivel, mensaje);

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(ARCHIVO_LOG, true))) {
            bw.write(entrada);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir log: " + e.getMessage());
        }
    }

    private static String formatearLog(LocalDateTime timestamp,
                                      Nivel nivel, String mensaje) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %-8s %s",
                           timestamp.format(formatter),
                           nivel,
                           mensaje);
    }

    public static void main(String[] args) {
        log(Nivel.INFO, "Aplicación iniciada");
        log(Nivel.WARNING, "Uso de memoria alto");
        log(Nivel.ERROR, "Conexión perdida");
    }
}
```

## 3. Formateo de fechas

### DateTimeFormatter

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormateoFechas {

    public static void ejemplos() {
        LocalDateTime ahora = LocalDateTime.now();

        // Formatos predefinidos
        String iso = ahora.format(DateTimeFormatter.ISO_DATE_TIME);
        // 2024-01-15T14:30:45

        String isoFecha = ahora.format(DateTimeFormatter.ISO_DATE);
        // 2024-01-15

        String isoHora = ahora.format(DateTimeFormatter.ISO_TIME);
        // 14:30:45

        // Formatos personalizados
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha1 = ahora.format(formato1);
        // 15/01/2024

        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fecha2 = ahora.format(formato2);
        // 15-01-2024 14:30:45

        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy");
        String fecha3 = ahora.format(formato3);
        // Monday, 15 de January de 2024

        // Con locale español
        DateTimeFormatter formatoES = DateTimeFormatter
                .ofPattern("EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaES = ahora.format(formatoES);
        // lunes, 15 de enero de 2024

        // Para logs
        DateTimeFormatter formatoLog = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String log = ahora.format(formatoLog);
        // 2024-01-15 14:30:45.123
    }

    // Parsear (convertir String a fecha)
    public static void parsear() {
        String fechaStr = "15/01/2024";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaStr, formato);

        String fechaHoraStr = "2024-01-15 14:30:45";
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr, formato2);
    }
}
```

### Patrones de formato comunes

|Patrón|Significado          |Ejemplo|
|------|---------------------|-------|
|`yyyy`|Año (4 dígitos)      |2024   |
|`yy`  |Año (2 dígitos)      |24     |
|`MMMM`|Mes (nombre completo)|January|
|`MMM` |Mes (nombre corto)   |Jan    |
|`MM`  |Mes (número 01-12)   |01     |
|`M`   |Mes (número 1-12)    |1      |
|`dd`  |Día (01-31)          |15     |
|`d`   |Día (1-31)           |15     |
|`EEEE`|Día semana (completo)|Monday |
|`EEE` |Día semana (corto)   |Mon    |
|`HH`  |Hora 24h (00-23)     |14     |
|`hh`  |Hora 12h (01-12)     |02     |
|`mm`  |Minutos (00-59)      |30     |
|`ss`  |Segundos (00-59)     |45     |
|`SSS` |Milisegundos         |123    |
|`a`   |AM/PM                |PM     |

## 4. Operaciones con fechas

### Cálculos temporales

```java
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class CalculosFechas {

    public static void ejemplos() {
        LocalDate hoy = LocalDate.now();
        LocalDate navidad = LocalDate.of(2024, 12, 25);

        // Diferencia en días
        long diasHastaNavidad = ChronoUnit.DAYS.between(hoy, navidad);
        System.out.println("Días hasta Navidad: " + diasHastaNavidad);

        // Diferencia en meses
        long meses = ChronoUnit.MONTHS.between(hoy, navidad);

        // Diferencia en años
        long años = ChronoUnit.YEARS.between(hoy, navidad);

        // Period (diferencia en años, meses, días)
        Period periodo = Period.between(hoy, navidad);
        System.out.printf("%d años, %d meses, %d días%n",
                         periodo.getYears(),
                         periodo.getMonths(),
                         periodo.getDays());

        // Sumar/restar períodos
        LocalDate futuro = hoy.plus(Period.ofDays(10));
        LocalDate futuro2 = hoy.plus(Period.ofMonths(3));
        LocalDate futuro3 = hoy.plus(Period.ofYears(1));
        LocalDate futuro4 = hoy.plus(Period.of(1, 3, 15)); // 1 año, 3 meses, 15 días

        // Primer día del mes
        LocalDate primerDia = hoy.withDayOfMonth(1);

        // Último día del mes
        LocalDate ultimoDia = hoy.withDayOfMonth(hoy.lengthOfMonth());

        // Siguiente lunes
        LocalDate siguienteLunes = hoy.plusDays(
            (7 - hoy.getDayOfWeek().getValue() + 1) % 7);
    }

    // Calcular edad
    public static int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // Verificar si una fecha está en un rango
    public static boolean estaEnRango(LocalDate fecha,
                                      LocalDate inicio,
                                      LocalDate fin) {
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }
}
```

### Duration - Duración en tiempo

```java
import java.time.Duration;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class EjemplosDuration {

    public static void ejemplos() {
        LocalTime inicio = LocalTime.of(9, 0);
        LocalTime fin = LocalTime.of(17, 30);

        // Duración entre dos tiempos
        Duration duracion = Duration.between(inicio, fin);

        long horas = duracion.toHours();           // 8
        long minutos = duracion.toMinutes();       // 510
        long segundos = duracion.getSeconds();     // 30600

        // Crear duraciones
        Duration hora = Duration.ofHours(1);
        Duration minutos30 = Duration.ofMinutes(30);
        Duration dias2 = Duration.ofDays(2);

        // Sumar duraciones
        LocalTime horaFutura = inicio.plus(Duration.ofHours(2));

        // Medir tiempo de ejecución
        LocalDateTime inicioEjecucion = LocalDateTime.now();
        // ... código a ejecutar ...
        LocalDateTime finEjecucion = LocalDateTime.now();
        Duration tiempoEjecucion = Duration.between(inicioEjecucion, finEjecucion);
        System.out.println("Tiempo: " + tiempoEjecucion.toMillis() + " ms");
    }
}
```

### Ejemplo práctico: Gestor de tareas con vencimientos

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Tarea {
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaVencimiento;
    private boolean completada;

    public Tarea(String nombre, String descripcion, LocalDate vencimiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaVencimiento = vencimiento;
        this.completada = false;
    }

    public boolean estaVencida() {
        return !completada && LocalDate.now().isAfter(fechaVencimiento);
    }

    public long diasRestantes() {
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaVencimiento);
    }

    public String getEstado() {
        if (completada) {
            return "Completada";
        }

        long dias = diasRestantes();
        if (dias < 0) {
            return "Vencida (" + Math.abs(dias) + " días)";
        } else if (dias == 0) {
            return "Vence HOY";
        } else if (dias <= 3) {
            return "Urgente (" + dias + " días)";
        } else {
            return "Pendiente (" + dias + " días)";
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s] %s - Vence: %s",
                           getEstado(),
                           nombre,
                           fechaVencimiento.format(formato));
    }
}
```

## 5. ZonedDateTime y zonas horarias

### Trabajar con zonas horarias

```java
import java.time.*;
import java.time.format.DateTimeFormatter;

public class EjemplosZonas {

    public static void ejemplos() {
        // Hora actual en zona local
        ZonedDateTime ahoraLocal = ZonedDateTime.now();
        System.out.println("Local: " + ahoraLocal);

        // Hora en zona específica
        ZonedDateTime nuevaYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime tokio = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime madrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));

        System.out.println("Nueva York: " + nuevaYork);
        System.out.println("Tokio: " + tokio);
        System.out.println("Madrid: " + madrid);

        // Convertir entre zonas
        ZonedDateTime horaLocal = ZonedDateTime.now();
        ZonedDateTime horaUTC = horaLocal.withZoneSameInstant(ZoneId.of("UTC"));

        // Listar todas las zonas disponibles
        for (String zona : ZoneId.getAvailableZoneIds()) {
            System.out.println(zona);
        }
    }

    // Convertir LocalDateTime a ZonedDateTime
    public static void conversion() {
        LocalDateTime local = LocalDateTime.now();
        ZonedDateTime zoned = local.atZone(ZoneId.systemDefault());

        // De ZonedDateTime a LocalDateTime
        LocalDateTime localOtra = zoned.toLocalDateTime();
    }
}
```

### Instant - Timestamp universal

```java
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EjemplosInstant {

    public static void ejemplos() {
        // Momento actual (timestamp UTC)
        Instant ahora = Instant.now();
        System.out.println("Timestamp: " + ahora);
        // 2024-01-15T13:30:45.123456789Z

        // Desde epoch (1 enero 1970)
        Instant desde = Instant.ofEpochMilli(1700000000000L);

        // Operaciones
        Instant mas1Hora = ahora.plusSeconds(3600);
        Instant hace1Dia = ahora.minusSeconds(86400);

        // Convertir a LocalDateTime
        LocalDateTime local = LocalDateTime.ofInstant(ahora, ZoneId.systemDefault());

        // Convertir LocalDateTime a Instant
        Instant instant = LocalDateTime.now()
                .atZone(ZoneId.systemDefault())
                .toInstant();

        // Obtener milisegundos desde epoch
        long millis = ahora.toEpochMilli();
        long segundos = ahora.getEpochSecond();
    }

    // Útil para timestamps de base de datos
    public static void timestampsDB() {
        // Guardar en DB
        Instant timestamp = Instant.now();
        long millisDB = timestamp.toEpochMilli();

        // Recuperar de DB
        Instant recuperado = Instant.ofEpochMilli(millisDB);
        LocalDateTime local = LocalDateTime.ofInstant(
            recuperado,
            ZoneId.systemDefault()
        );
    }
}
```

### Ejemplo práctico: Logger con zonas horarias

```java
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LoggerMultiZona {

    private static final DateTimeFormatter FORMATO =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

    public static void log(String mensaje, String... zonas) {
        Instant ahora = Instant.now();

        System.out.println("=== " + mensaje + " ===");

        if (zonas.length == 0) {
            // Solo zona local
            ZonedDateTime local = ZonedDateTime.ofInstant(ahora, ZoneId.systemDefault());
            System.out.println(local.format(FORMATO));
        } else {
            // Múltiples zonas
            for (String zonaStr : zonas) {
                ZoneId zona = ZoneId.of(zonaStr);
                ZonedDateTime zoned = ZonedDateTime.ofInstant(ahora, zona);
                System.out.printf("%-20s: %s%n",
                                zonaStr,
                                zoned.format(FORMATO));
            }
        }
    }

    public static void main(String[] args) {
        log("Evento del sistema",
            "Europe/Madrid",
            "America/New_York",
            "Asia/Tokyo",
            "UTC");
    }
}
```

## Ejercicios prácticos

### Ejercicio 1: Calculadora de días laborables

Calcula los días laborables entre dos fechas (excluyendo fines de semana).

### Ejercicio 2: Agenda de reuniones

Sistema que gestione reuniones con recordatorios basados en tiempo.

### Ejercicio 3: Conversor de zonas horarias

Herramienta que muestre la hora actual en diferentes ciudades del mundo.

-----

## **Conceptos clave del módulo**

- java.time reemplaza las antiguas Date y Calendar
- LocalDate, LocalTime, LocalDateTime son las clases principales
- DateTimeFormatter permite formatear y parsear fechas
- Period para diferencias en días/meses/años, Duration para horas/minutos
- ZonedDateTime maneja zonas horarias
- Instant representa timestamps universales
- Todas las clases son inmutables y thread-safe

  #
  
