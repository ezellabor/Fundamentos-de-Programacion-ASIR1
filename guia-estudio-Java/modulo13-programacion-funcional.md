<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# MÓDULO 13: PROGRAMACIÓN FUNCIONAL

## 1. Expresiones lambda

Las **expresiones lambda** (desde Java 8) son funciones anónimas que permiten escribir código más conciso y expresivo.

### Sintaxis básica

```java
// Forma tradicional (clase anónima)
Runnable r1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hola");
    }
};

// Con lambda
Runnable r2 = () -> System.out.println("Hola");
```

### Estructura de una lambda

```
(parámetros) -> expresión
(parámetros) -> { instrucciones; }
```

### Ejemplos básicos

```java
// Sin parámetros
Runnable sinParametros = () -> System.out.println("Sin parámetros");

// Un parámetro (paréntesis opcionales)
Consumer<String> unParametro = mensaje -> System.out.println(mensaje);
Consumer<String> conParentesis = (mensaje) -> System.out.println(mensaje);

// Múltiples parámetros
Comparator<Integer> dosParametros = (a, b) -> a.compareTo(b);

// Con tipo explícito
BiFunction<Integer, Integer, Integer> suma = (Integer a, Integer b) -> a + b;

// Con bloque de código
Function<String, String> enMayusculas = texto -> {
    String resultado = texto.toUpperCase();
    System.out.println("Convirtiendo: " + texto);
    return resultado;
};
```

### Ejemplos prácticos

```java
import java.util.*;

public class EjemplosLambda {
    public static void ejemplos() {
        List<String> servidores = Arrays.asList("web-01", "db-01", "cache-01");

        // Iterar con forEach
        servidores.forEach(servidor -> System.out.println(servidor));

        // Ordenar
        servidores.sort((s1, s2) -> s1.compareTo(s2));

        // Filtrar y procesar
        Map<String, Integer> puertos = new HashMap<>();
        puertos.put("HTTP", 80);
        puertos.put("HTTPS", 443);
        puertos.put("SSH", 22);

        puertos.forEach((servicio, puerto) ->
            System.out.println(servicio + " -> " + puerto)
        );

        // Ejecutar tarea
        Thread hilo = new Thread(() -> {
            System.out.println("Ejecutando en hilo: " + Thread.currentThread().getName());
        });
        hilo.start();
    }
}
```

## 2. Interfaces funcionales

Una **interfaz funcional** tiene exactamente un método abstracto. Pueden usarse con expresiones lambda.

### Interfaces funcionales predefinidas

```java
import java.util.function.*;

public class InterfacesFuncionales {

    // Predicate<T> - Recibe T, retorna boolean
    public static void ejemploPredicate() {
        Predicate<Integer> esPar = num -> num % 2 == 0;
        Predicate<String> esVacio = String::isEmpty;
        Predicate<String> empiezaConA = s -> s.startsWith("A");

        System.out.println(esPar.test(4));      // true
        System.out.println(esVacio.test(""));   // true

        // Combinar predicados
        Predicate<Integer> mayorQue10 = n -> n > 10;
        Predicate<Integer> parYMayor = esPar.and(mayorQue10);
        System.out.println(parYMayor.test(12)); // true
    }

    // Consumer<T> - Recibe T, no retorna nada
    public static void ejemploConsumer() {
        Consumer<String> imprimir = System.out::println;
        Consumer<String> logInfo = msg -> System.out.println("[INFO] " + msg);

        imprimir.accept("Hola Mundo");
        logInfo.accept("Sistema iniciado");

        // Encadenar consumers
        Consumer<String> logYGuardar = logInfo.andThen(msg -> {
            // Guardar en archivo
        });
    }

    // Supplier<T> - No recibe nada, retorna T
    public static void ejemploSupplier() {
        Supplier<String> obtenerFecha = () -> new Date().toString();
        Supplier<Integer> numeroAleatorio = () -> (int)(Math.random() * 100);

        System.out.println(obtenerFecha.get());
        System.out.println(numeroAleatorio.get());
    }

    // Function<T, R> - Recibe T, retorna R
    public static void ejemploFunction() {
        Function<String, Integer> longitud = String::length;
        Function<Integer, String> duplicar = n -> String.valueOf(n * 2);
        Function<String, String> mayusculas = String::toUpperCase;

        System.out.println(longitud.apply("Hola"));  // 4

        // Encadenar funciones
        Function<String, Integer> longitudMayusculas =
            mayusculas.andThen(String::length);
        System.out.println(longitudMayusculas.apply("hola")); // 4
    }

    // BiFunction<T, U, R> - Recibe T y U, retorna R
    public static void ejemploBiFunction() {
        BiFunction<Integer, Integer, Integer> suma = (a, b) -> a + b;
        BiFunction<String, String, String> concatenar = (a, b) -> a + b;

        System.out.println(suma.apply(5, 3));           // 8
        System.out.println(concatenar.apply("Hola", " Mundo")); // "Hola Mundo"
    }

    // UnaryOperator<T> - Recibe T, retorna T (caso especial de Function)
    public static void ejemploUnaryOperator() {
        UnaryOperator<String> agregar = s -> s + "!";
        UnaryOperator<Integer> cuadrado = n -> n * n;

        System.out.println(agregar.apply("Hola"));  // "Hola!"
        System.out.println(cuadrado.apply(5));      // 25
    }

    // BinaryOperator<T> - Recibe dos T, retorna T (caso especial de BiFunction)
    public static void ejemploBinaryOperator() {
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        BinaryOperator<String> concatenar = (a, b) -> a + " " + b;

        System.out.println(max.apply(5, 10));              // 10
        System.out.println(concatenar.apply("Hola", "Mundo")); // "Hola Mundo"
    }
}
```

### Crear interfaz funcional personalizada

```java
@FunctionalInterface
public interface Validador<T> {
    boolean validar(T objeto);

    // Métodos default permitidos
    default Validador<T> and(Validador<T> otro) {
        return obj -> this.validar(obj) && otro.validar(obj);
    }
}

// Uso
public class EjemploValidador {
    public static void main(String[] args) {
        Validador<String> noVacio = s -> !s.isEmpty();
        Validador<String> longitudMinima = s -> s.length() >= 8;

        Validador<String> validarPassword = noVacio.and(longitudMinima);

        System.out.println(validarPassword.validar("admin"));      // false
        System.out.println(validarPassword.validar("admin123"));   // true
    }
}
```

### Interfaces funcionales comunes

|Interfaz           |Método               |Descripción        |Ejemplo                     |
|-------------------|---------------------|-------------------|----------------------------|
|`Predicate<T>`     |`boolean test(T t)`  |Prueba condicional |`n -> n > 0`                |
|`Consumer<T>`      |`void accept(T t)`   |Consume un valor   |`s -> System.out.println(s)`|
|`Supplier<T>`      |`T get()`            |Provee un valor    |`() -> new Date()`          |
|`Function<T,R>`    |`R apply(T t)`       |Transforma T en R  |`s -> s.length()`           |
|`BiFunction<T,U,R>`|`R apply(T t, U u)`  |Transforma T,U en R|`(a,b) -> a + b`            |
|`UnaryOperator<T>` |`T apply(T t)`       |Opera sobre T      |`n -> n * 2`                |
|`BinaryOperator<T>`|`T apply(T t1, T t2)`|Opera sobre dos T  |`(a,b) -> Math.max(a,b)`    |

## 3. Stream API básico

Los **Streams** permiten procesar colecciones de datos de forma declarativa y funcional.

### Crear streams

```java
import java.util.stream.*;
import java.util.*;

public class CrearStreams {
    public static void ejemplos() {
        // Desde colección
        List<String> lista = Arrays.asList("a", "b", "c");
        Stream<String> stream1 = lista.stream();

        // Desde array
        String[] array = {"x", "y", "z"};
        Stream<String> stream2 = Arrays.stream(array);

        // Con Stream.of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

        // Stream vacío
        Stream<String> streamVacio = Stream.empty();

        // Stream infinito
        Stream<Integer> infinito = Stream.iterate(0, n -> n + 1);
        Stream<Double> aleatorios = Stream.generate(Math::random);

        // Stream de rango
        IntStream rango = IntStream.range(1, 10);      // 1 a 9
        IntStream rangoInclusive = IntStream.rangeClosed(1, 10); // 1 a 10
    }
}
```

### Características de los Streams

- **No almacenan datos**: Solo procesan datos de una fuente
- **Funcionales**: No modifican la fuente original
- **Lazy**: Las operaciones intermedias no se ejecutan hasta una terminal
- **Consumibles**: Solo se pueden usar una vez

## 4. Operaciones filter, map y reduce

### filter() - Filtrar elementos

```java
import java.util.*;
import java.util.stream.*;

public class EjemploFilter {
    public static void ejemplos() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filtrar pares
        List<Integer> pares = numeros.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println(pares);  // [2, 4, 6, 8, 10]

        // Filtrar mayores que 5
        List<Integer> mayores = numeros.stream()
            .filter(n -> n > 5)
            .collect(Collectors.toList());

        // Múltiples filtros
        List<Integer> resultado = numeros.stream()
            .filter(n -> n > 3)
            .filter(n -> n < 8)
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());  // [4, 6]
    }

    public static void ejemploServidores() {
        class Servidor {
            String nombre;
            double cpu;
            String estado;

            Servidor(String nombre, double cpu, String estado) {
                this.nombre = nombre;
                this.cpu = cpu;
                this.estado = estado;
            }
        }

        List<Servidor> servidores = Arrays.asList(
            new Servidor("web-01", 45.5, "activo"),
            new Servidor("web-02", 78.2, "activo"),
            new Servidor("db-01", 23.1, "mantenimiento"),
            new Servidor("cache-01", 92.3, "activo")
        );

        // Servidores activos con CPU > 50%
        List<Servidor> criticos = servidores.stream()
            .filter(s -> s.estado.equals("activo"))
            .filter(s -> s.cpu > 50)
            .collect(Collectors.toList());

        criticos.forEach(s ->
            System.out.println(s.nombre + ": " + s.cpu + "%")
        );
    }
}
```

### map() - Transformar elementos

```java
import java.util.*;
import java.util.stream.*;

public class EjemploMap {
    public static void ejemplos() {
        List<String> palabras = Arrays.asList("java", "python", "javascript");

        // Convertir a mayúsculas
        List<String> mayusculas = palabras.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println(mayusculas);  // [JAVA, PYTHON, JAVASCRIPT]

        // Obtener longitudes
        List<Integer> longitudes = palabras.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println(longitudes);  // [4, 6, 10]

        // Transformaciones complejas
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        List<String> textos = numeros.stream()
            .map(n -> "Número: " + n)
            .collect(Collectors.toList());
    }

    public static void ejemploArchivos() {
        List<String> rutas = Arrays.asList(
            "/var/log/app.log",
            "/etc/hosts",
            "/home/user/documento.txt"
        );

        // Extraer solo nombres de archivo
        List<String> nombres = rutas.stream()
            .map(ruta -> ruta.substring(ruta.lastIndexOf('/') + 1))
            .collect(Collectors.toList());
        System.out.println(nombres);  // [app.log, hosts, documento.txt]

        // Agregar extensión
        List<String> conBackup = nombres.stream()
            .map(nombre -> nombre + ".bak")
            .collect(Collectors.toList());
    }
}
```

### reduce() - Reducir a un valor

```java
import java.util.*;
import java.util.stream.*;

public class EjemploReduce {
    public static void ejemplos() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Suma
        int suma = numeros.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("Suma: " + suma);  // 15

        // Con method reference
        int suma2 = numeros.stream()
            .reduce(0, Integer::sum);

        // Producto
        int producto = numeros.stream()
            .reduce(1, (a, b) -> a * b);
        System.out.println("Producto: " + producto);  // 120

        // Máximo
        Optional<Integer> max = numeros.stream()
            .reduce((a, b) -> a > b ? a : b);
        max.ifPresent(m -> System.out.println("Máximo: " + m));

        // O con max()
        Optional<Integer> max2 = numeros.stream()
            .max(Integer::compareTo);

        // Concatenar strings
        List<String> palabras = Arrays.asList("Java", "es", "genial");
        String frase = palabras.stream()
            .reduce("", (a, b) -> a + " " + b)
            .trim();
        System.out.println(frase);  // "Java es genial"
    }

    public static void ejemploPractico() {
        class Pedido {
            double precio;
            Pedido(double precio) { this.precio = precio; }
        }

        List<Pedido> pedidos = Arrays.asList(
            new Pedido(100.50),
            new Pedido(250.75),
            new Pedido(89.99)
        );

        // Total de ventas
        double total = pedidos.stream()
            .map(p -> p.precio)
            .reduce(0.0, Double::sum);
        System.out.println("Total: $" + total);
    }
}
```

### Operaciones combinadas

```java
import java.util.*;
import java.util.stream.*;

public class OperacionesCombinadas {

    static class LogEntry {
        String nivel;
        String mensaje;
        long timestamp;

        LogEntry(String nivel, String mensaje, long timestamp) {
            this.nivel = nivel;
            this.mensaje = mensaje;
            this.timestamp = timestamp;
        }
    }

    public static void analizarLogs() {
        List<LogEntry> logs = Arrays.asList(
            new LogEntry("INFO", "Sistema iniciado", 1000),
            new LogEntry("ERROR", "Conexión perdida", 2000),
            new LogEntry("WARNING", "Memoria alta", 3000),
            new LogEntry("ERROR", "Timeout", 4000),
            new LogEntry("INFO", "Backup completado", 5000)
        );

        // Contar errores
        long errores = logs.stream()
            .filter(log -> log.nivel.equals("ERROR"))
            .count();
        System.out.println("Total errores: " + errores);

        // Mensajes de error
        List<String> mensajesError = logs.stream()
            .filter(log -> log.nivel.equals("ERROR"))
            .map(log -> log.mensaje)
            .collect(Collectors.toList());

        // Logs recientes (timestamp > 2500)
        List<LogEntry> recientes = logs.stream()
            .filter(log -> log.timestamp > 2500)
            .collect(Collectors.toList());

        // Niveles únicos
        Set<String> niveles = logs.stream()
            .map(log -> log.nivel)
            .collect(Collectors.toSet());
        System.out.println("Niveles: " + niveles);
    }
}
```

### Otras operaciones útiles

```java
import java.util.*;
import java.util.stream.*;

public class OperacionesUtiles {
    public static void ejemplos() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // distinct() - Eliminar duplicados
        List<Integer> conDuplicados = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> unicos = conDuplicados.stream()
            .distinct()
            .collect(Collectors.toList());  // [1, 2, 3, 4]

        // sorted() - Ordenar
        List<Integer> desordenados = Arrays.asList(5, 2, 8, 1, 9);
        List<Integer> ordenados = desordenados.stream()
            .sorted()
            .collect(Collectors.toList());  // [1, 2, 5, 8, 9]

        // limit() - Limitar cantidad
        List<Integer> primeros5 = numeros.stream()
            .limit(5)
            .collect(Collectors.toList());  // [1, 2, 3, 4, 5]

        // skip() - Saltar elementos
        List<Integer> despuesDe5 = numeros.stream()
            .skip(5)
            .collect(Collectors.toList());  // [6, 7, 8, 9, 10]

        // peek() - Ver elementos (debugging)
        List<Integer> resultado = numeros.stream()
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println("Procesando: " + n))
            .map(n -> n * 2)
            .collect(Collectors.toList());

        // anyMatch() - ¿Alguno cumple?
        boolean hayPares = numeros.stream()
            .anyMatch(n -> n % 2 == 0);  // true

        // allMatch() - ¿Todos cumplen?
        boolean todosPositivos = numeros.stream()
            .allMatch(n -> n > 0);  // true

        // noneMatch() - ¿Ninguno cumple?
        boolean ningunNegativo = numeros.stream()
            .noneMatch(n -> n < 0);  // true

        // findFirst() - Primer elemento
        Optional<Integer> primero = numeros.stream()
            .filter(n -> n > 5)
            .findFirst();  // Optional[6]

        // findAny() - Cualquier elemento
        Optional<Integer> cualquiera = numeros.stream()
            .filter(n -> n > 5)
            .findAny();

        // forEach() - Ejecutar acción
        numeros.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
    }
}
```

## 5. Method references

Las **method references** son una forma abreviada de expresiones lambda que solo llaman a un método.

### Tipos de method references

```java
import java.util.*;
import java.util.function.*;

public class MethodReferences {

    // 1. Referencia a método estático: Clase::metodoEstatico
    public static void ejemploMetodoEstatico() {
        List<String> numeros = Arrays.asList("1", "2", "3");

        // Lambda
        List<Integer> enteros1 = numeros.stream()
            .map(s -> Integer.parseInt(s))
            .collect(Collectors.toList());

        // Method reference
        List<Integer> enteros2 = numeros.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    // 2. Referencia a método de instancia: objeto::metodo
    public static void ejemploMetodoInstancia() {
        String prefijo = "[LOG] ";
        Function<String, String> agregar = prefijo::concat;

        System.out.println(agregar.apply("Error"));  // [LOG] Error
    }

    // 3. Referencia a método de instancia de tipo: Clase::metodo
    public static void ejemploMetodoTipo() {
        List<String> palabras = Arrays.asList("apache", "nginx", "mysql");

        // Lambda
        palabras.stream()
            .map(s -> s.toUpperCase())
            .forEach(System.out::println);

        // Method reference
        palabras.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);

        // Comparar
        palabras.sort((s1, s2) -> s1.compareTo(s2));
        palabras.sort(String::compareTo);
    }

    // 4. Referencia a constructor: Clase::new
    public static void ejemploConstructor() {
        Supplier<ArrayList<String>> listSupplier1 = () -> new ArrayList<>();
        Supplier<ArrayList<String>> listSupplier2 = ArrayList::new;

        Function<String, Integer> parser1 = s -> new Integer(s);
        Function<String, Integer> parser2 = Integer::new;
    }

    // Ejemplos prácticos
    public static void ejemplosPracticos() {
        List<String> logs = Arrays.asList(
            "Error en servidor",
            "Advertencia de memoria",
            "Info: sistema OK"
        );

        // Imprimir cada uno
        logs.forEach(System.out::println);

        // Longitudes
        List<Integer> longitudes = logs.stream()
            .map(String::length)
            .collect(Collectors.toList());

        // Ordenar ignorando mayúsculas
        logs.sort(String::compareToIgnoreCase);

        // Verificar si están vacíos
        boolean hayVacios = logs.stream()
            .anyMatch(String::isEmpty);
    }
}
```

### Equivalencias comunes

|Lambda                      |Method Reference     |
|----------------------------|---------------------|
|`s -> System.out.println(s)`|`System.out::println`|
|`s -> s.length()`           |`String::length`     |
|`s -> s.toUpperCase()`      |`String::toUpperCase`|
|`n -> Integer.parseInt(n)`  |`Integer::parseInt`  |
|`(a,b) -> a.compareTo(b)`   |`String::compareTo`  |
|`() -> new ArrayList<>()`   |`ArrayList::new`     |
|`s -> s.isEmpty()`          |`String::isEmpty`    |

### Ejemplo práctico completo: Procesamiento de logs

```java
import java.util.*;
import java.util.stream.*;
import java.time.LocalDateTime;

public class ProcesadorLogs {

    static class LogEntry {
        LocalDateTime timestamp;
        String nivel;
        String mensaje;

        public LogEntry(String nivel, String mensaje) {
            this.timestamp = LocalDateTime.now();
            this.nivel = nivel;
            this.mensaje = mensaje;
        }

        public String getNivel() { return nivel; }
        public String getMensaje() { return mensaje; }
        public LocalDateTime getTimestamp() { return timestamp; }

        @Override
        public String toString() {
            return String.format("[%s] %s: %s", timestamp, nivel, mensaje);
        }
    }

    public static void procesarLogs(List<LogEntry> logs) {
        System.out.println("=== ANÁLISIS DE LOGS ===\n");

        // Contar por nivel
        Map<String, Long> contadores = logs.stream()
            .collect(Collectors.groupingBy(
                LogEntry::getNivel,
                Collectors.counting()
            ));
        System.out.println("Contadores: " + contadores);

        // Solo errores críticos
        System.out.println("\n=== ERRORES CRÍTICOS ===");
        logs.stream()
            .filter(log -> log.getNivel().equals("ERROR"))
            .map(LogEntry::getMensaje)
            .forEach(System.out::println);

        // Niveles únicos ordenados
        System.out.println("\n=== NIVELES PRESENTES ===");
        logs.stream()
            .map(LogEntry::getNivel)
            .distinct()
            .sorted()
            .forEach(System.out::println);

        // Total de caracteres en mensajes
        int totalCaracteres = logs.stream()
            .map(LogEntry::getMensaje)
            .mapToInt(String::length)
            .sum();
        System.out.println("\nTotal caracteres: " + totalCaracteres);
    }

    public static void main(String[] args) {
        List<LogEntry> logs = Arrays.asList(
            new LogEntry("INFO", "Sistema iniciado"),
            new LogEntry("ERROR", "Conexión perdida"),
            new LogEntry("WARNING", "Memoria alta"),
            new LogEntry("ERROR", "Timeout en BD"),
            new LogEntry("INFO", "Backup completado"),
            new LogEntry("ERROR", "Disco lleno")
        );

        procesarLogs(logs);
    }
}
```

## Ejercicios prácticos

### Ejercicio 1: Estadísticas de servidores

Procesa una lista de servidores y calcula uso promedio de CPU, memoria, etc.

### Ejercicio 2: Filtro de archivos

Lee archivos de un directorio y filtra por extensión, tamaño y fecha usando Streams.

### Ejercicio 3: Procesador de comandos

Analiza historial de comandos de shell: más usados, por usuario, por fecha.

-----

## **Conceptos clave del módulo**

- **Lambdas** simplifican código con funciones anónimas
- **Interfaces** funcionales tienen un solo método abstracto
- **Streams** procesan colecciones de forma declarativa
- **filter()** filtra, **map()** transforma, **reduce()** reduce
- **Method references** son lambdas simplificadas
- Operaciones intermedias son **lazy**, terminales ejecutan el pipeline
- La programación funcional hace el código más expresivo y mantenible

  ---
