<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>


# MÓDULO 12: COLECCIONES AVANZADAS

## 1. Framework de colecciones Java

El **Java Collections Framework** proporciona estructuras de datos y algoritmos para almacenar y manipular grupos de objetos.

### Jerarquía principal

```
Collection
├── List (orden, duplicados permitidos)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
├── Set (sin duplicados)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet (ordenado)
└── Queue (cola)
    ├── LinkedList
    ├── PriorityQueue
    └── ArrayDeque

Map (no extiende Collection)
├── HashMap
├── LinkedHashMap
└── TreeMap (ordenado)
```

### Características por tipo

|Interfaz|Orden|Duplicados   |Acceso    |Uso típico            |
|--------|-----|-------------|----------|----------------------|
|List    |Sí   |Sí           |Por índice|Listas ordenadas      |
|Set     |No*  |No           |Por valor |Elementos únicos      |
|Map     |No*  |Claves únicas|Por clave |Pares clave-valor     |
|Queue   |Sí   |Sí           |FIFO/LIFO |Colas de procesamiento|

*TreeSet y TreeMap mantienen orden natural

## 2. Set: TreeSet y características

### HashSet - Conjunto sin orden

```java
import java.util.HashSet;
import java.util.Set;

public class EjemploHashSet {
    public static void ejemplos() {
        Set<String> usuarios = new HashSet<>();

        // Agregar elementos
        usuarios.add("admin");
        usuarios.add("user1");
        usuarios.add("user2");
        usuarios.add("admin");  // No se agrega (duplicado)

        System.out.println(usuarios.size());  // 3

        // Verificar existencia
        boolean existe = usuarios.contains("admin");  // true

        // Eliminar
        usuarios.remove("user1");

        // Iterar (orden no garantizado)
        for (String usuario : usuarios) {
            System.out.println(usuario);
        }

        // Operaciones de conjuntos
        Set<String> grupoA = new HashSet<>();
        grupoA.add("user1");
        grupoA.add("user2");
        grupoA.add("user3");

        Set<String> grupoB = new HashSet<>();
        grupoB.add("user2");
        grupoB.add("user3");
        grupoB.add("user4");

        // Unión
        Set<String> union = new HashSet<>(grupoA);
        union.addAll(grupoB);  // {user1, user2, user3, user4}

        // Intersección
        Set<String> interseccion = new HashSet<>(grupoA);
        interseccion.retainAll(grupoB);  // {user2, user3}

        // Diferencia
        Set<String> diferencia = new HashSet<>(grupoA);
        diferencia.removeAll(grupoB);  // {user1}
    }
}
```

### LinkedHashSet - Mantiene orden de inserción

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class EjemploLinkedHashSet {
    public static void ejemplos() {
        Set<String> comandos = new LinkedHashSet<>();

        comandos.add("ls");
        comandos.add("cd");
        comandos.add("pwd");
        comandos.add("mkdir");

        // Mantiene el orden de inserción
        for (String cmd : comandos) {
            System.out.println(cmd);  // ls, cd, pwd, mkdir (en orden)
        }
    }
}
```

### TreeSet - Conjunto ordenado naturalmente

```java
import java.util.TreeSet;
import java.util.Set;

public class EjemploTreeSet {
    public static void ejemplos() {
        Set<Integer> puertos = new TreeSet<>();

        puertos.add(8080);
        puertos.add(80);
        puertos.add(443);
        puertos.add(3306);
        puertos.add(22);

        // Siempre ordenado
        System.out.println(puertos);  // [22, 80, 443, 3306, 8080]

        // Métodos específicos de TreeSet
        TreeSet<Integer> ts = new TreeSet<>(puertos);

        System.out.println("Primero: " + ts.first());     // 22
        System.out.println("Último: " + ts.last());       // 8080
        System.out.println("Mayor que 100: " + ts.higher(100));  // 443
        System.out.println("Menor que 1000: " + ts.lower(1000)); // 443

        // Subconjuntos
        Set<Integer> menoresQue1000 = ts.headSet(1000);   // [22, 80, 443]
        Set<Integer> mayoresQue80 = ts.tailSet(80);       // [80, 443, 3306, 8080]
        Set<Integer> entre = ts.subSet(80, 3306);         // [80, 443]
    }
}
```

### Ejemplo práctico: Sistema de permisos

```java
import java.util.*;

public class SistemaPermisos {
    private Map<String, Set<String>> usuariosPermisos;

    public SistemaPermisos() {
        this.usuariosPermisos = new HashMap<>();
    }

    public void agregarPermiso(String usuario, String permiso) {
        usuariosPermisos.putIfAbsent(usuario, new TreeSet<>());
        usuariosPermisos.get(usuario).add(permiso);
    }

    public void revocarPermiso(String usuario, String permiso) {
        Set<String> permisos = usuariosPermisos.get(usuario);
        if (permisos != null) {
            permisos.remove(permiso);
        }
    }

    public boolean tienePermiso(String usuario, String permiso) {
        Set<String> permisos = usuariosPermisos.get(usuario);
        return permisos != null && permisos.contains(permiso);
    }

    public Set<String> obtenerPermisos(String usuario) {
        return usuariosPermisos.getOrDefault(usuario, new TreeSet<>());
    }

    public Set<String> permisosComunes(String usuario1, String usuario2) {
        Set<String> permisos1 = obtenerPermisos(usuario1);
        Set<String> permisos2 = obtenerPermisos(usuario2);

        Set<String> comunes = new HashSet<>(permisos1);
        comunes.retainAll(permisos2);
        return comunes;
    }

    public static void main(String[] args) {
        SistemaPermisos sistema = new SistemaPermisos();

        sistema.agregarPermiso("admin", "READ");
        sistema.agregarPermiso("admin", "WRITE");
        sistema.agregarPermiso("admin", "DELETE");
        sistema.agregarPermiso("admin", "EXECUTE");

        sistema.agregarPermiso("user", "READ");
        sistema.agregarPermiso("user", "WRITE");

        System.out.println("Permisos admin: " + sistema.obtenerPermisos("admin"));
        System.out.println("Permisos user: " + sistema.obtenerPermisos("user"));
        System.out.println("Permisos comunes: " +
                          sistema.permisosComunes("admin", "user"));
    }
}
```

## 3. Map: TreeMap y operaciones

### HashMap - Map sin orden

```java
import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {
    public static void ejemplos() {
        Map<String, Integer> puertos = new HashMap<>();

        // Agregar pares clave-valor
        puertos.put("HTTP", 80);
        puertos.put("HTTPS", 443);
        puertos.put("SSH", 22);
        puertos.put("FTP", 21);

        // Obtener valor
        int puertoHTTP = puertos.get("HTTP");  // 80

        // Valor por defecto si no existe
        int puertoSMTP = puertos.getOrDefault("SMTP", 25);  // 25

        // Verificar existencia
        boolean tieneHTTPS = puertos.containsKey("HTTPS");  // true
        boolean tienePuerto22 = puertos.containsValue(22);  // true

        // Actualizar o insertar
        puertos.putIfAbsent("MySQL", 3306);  // Solo si no existe
        puertos.put("HTTP", 8080);           // Actualiza si existe

        // Eliminar
        puertos.remove("FTP");

        // Iterar
        for (Map.Entry<String, Integer> entry : puertos.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Solo claves
        for (String servicio : puertos.keySet()) {
            System.out.println(servicio);
        }

        // Solo valores
        for (Integer puerto : puertos.values()) {
            System.out.println(puerto);
        }

        // Operación computacional
        puertos.compute("HTTP", (k, v) -> v + 1000);  // HTTP -> 9080

        // Fusionar
        puertos.merge("PostgreSQL", 5432, (oldVal, newVal) -> oldVal);
    }
}
```

### TreeMap - Map ordenado por claves

```java
import java.util.TreeMap;
import java.util.Map;

public class EjemploTreeMap {
    public static void ejemplos() {
        TreeMap<String, String> config = new TreeMap<>();

        config.put("database.host", "localhost");
        config.put("database.port", "5432");
        config.put("database.name", "mydb");
        config.put("server.port", "8080");
        config.put("server.host", "0.0.0.0");

        // Siempre ordenado por clave
        for (String key : config.keySet()) {
            System.out.println(key + " = " + config.get(key));
        }
        // database.host = localhost
        // database.name = mydb
        // database.port = 5432
        // server.host = 0.0.0.0
        // server.port = 8080

        // Métodos específicos de TreeMap
        String primeraClave = config.firstKey();     // database.host
        String ultimaClave = config.lastKey();       // server.port

        // Claves que empiezan con "database"
        Map<String, String> dbConfig = config.subMap("database", "database~");

        // Primera clave mayor o igual a
        String clave = config.ceilingKey("server");  // server.host

        // Última clave menor o igual a
        String clave2 = config.floorKey("database.port");  // database.port
    }
}
```

### LinkedHashMap - Mantiene orden de inserción

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class EjemploLinkedHashMap {
    public static void ejemplos() {
        // LRU Cache (Least Recently Used)
        Map<String, String> cache = new LinkedHashMap<String, String>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 100;  // Máximo 100 elementos
            }
        };

        cache.put("page1", "Contenido 1");
        cache.put("page2", "Contenido 2");
        cache.put("page3", "Contenido 3");

        cache.get("page1");  // Acceso, mueve al final

        // Orden: page2, page3, page1 (page1 movido al final por acceso)
    }
}
```

### Ejemplo práctico: Configuración del servidor

```java
import java.util.*;
import java.io.*;

public class GestorConfiguracion {
    private TreeMap<String, String> configuracion;

    public GestorConfiguracion() {
        this.configuracion = new TreeMap<>();
    }

    public void cargar(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                // Ignorar comentarios y líneas vacías
                if (linea.isEmpty() || linea.startsWith("#")) {
                    continue;
                }

                // Procesar clave=valor
                String[] partes = linea.split("=", 2);
                if (partes.length == 2) {
                    configuracion.put(partes[0].trim(), partes[1].trim());
                }
            }
        }
    }

    public void guardar(String archivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("# Configuración del servidor");
            bw.newLine();
            bw.write("# Generado: " + new Date());
            bw.newLine();
            bw.newLine();

            for (Map.Entry<String, String> entry : configuracion.entrySet()) {
                bw.write(entry.getKey() + "=" + entry.getValue());
                bw.newLine();
            }
        }
    }

    public String get(String clave) {
        return configuracion.get(clave);
    }

    public String get(String clave, String valorDefecto) {
        return configuracion.getOrDefault(clave, valorDefecto);
    }

    public void set(String clave, String valor) {
        configuracion.put(clave, valor);
    }

    public Map<String, String> getSeccion(String prefijo) {
        return configuracion.subMap(prefijo, prefijo + "~");
    }

    public void mostrar() {
        System.out.println("=== CONFIGURACIÓN ===");
        for (Map.Entry<String, String> entry : configuracion.entrySet()) {
            System.out.printf("%-30s = %s%n", entry.getKey(), entry.getValue());
        }
    }
}
```

## 4. Queue y Deque

### Queue - Cola FIFO

```java
import java.util.LinkedList;
import java.util.Queue;

public class EjemploQueue {
    public static void ejemplos() {
        Queue<String> cola = new LinkedList<>();

        // Agregar elementos
        cola.offer("Tarea 1");  // true si se agregó
        cola.offer("Tarea 2");
        cola.offer("Tarea 3");

        // Ver el primero sin remover
        String primero = cola.peek();  // "Tarea 1" (null si vacía)

        // Remover y retornar el primero
        String procesado = cola.poll();  // "Tarea 1" (null si vacía)

        System.out.println("Cola: " + cola);  // [Tarea 2, Tarea 3]
    }
}
```

### PriorityQueue - Cola con prioridad

```java
import java.util.PriorityQueue;
import java.util.Queue;

public class EjemploPriorityQueue {
    public static void ejemplos() {
        // Cola de prioridad (orden natural)
        Queue<Integer> cola = new PriorityQueue<>();

        cola.offer(5);
        cola.offer(2);
        cola.offer(8);
        cola.offer(1);

        // Extrae en orden: 1, 2, 5, 8
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }

    // Con objetos personalizados
    static class Proceso {
        String nombre;
        int prioridad;  // Menor número = mayor prioridad

        public Proceso(String nombre, int prioridad) {
            this.nombre = nombre;
            this.prioridad = prioridad;
        }
    }

    public static void ejemploObjetos() {
        Queue<Proceso> cola = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p1.prioridad, p2.prioridad)
        );

        cola.offer(new Proceso("Proceso A", 5));
        cola.offer(new Proceso("Proceso B", 1));
        cola.offer(new Proceso("Proceso C", 3));

        // Extrae: Proceso B (1), Proceso C (3), Proceso A (5)
        while (!cola.isEmpty()) {
            Proceso p = cola.poll();
            System.out.println(p.nombre + " - Prioridad: " + p.prioridad);
        }
    }
}
```

### Deque - Cola de doble extremo

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class EjemploDeque {
    public static void ejemplos() {
        Deque<String> deque = new ArrayDeque<>();

        // Agregar al final
        deque.addLast("A");
        deque.addLast("B");

        // Agregar al inicio
        deque.addFirst("Z");

        // deque: [Z, A, B]

        // Remover del inicio
        String primero = deque.removeFirst();  // "Z"

        // Remover del final
        String ultimo = deque.removeLast();    // "B"

        // Usar como pila (LIFO)
        Deque<Integer> pila = new ArrayDeque<>();
        pila.push(1);  // Agregar arriba
        pila.push(2);
        pila.push(3);

        System.out.println(pila.pop());  // 3 (último en entrar)
        System.out.println(pila.pop());  // 2
        System.out.println(pila.pop());  // 1
    }
}
```

### Ejemplo práctico: Sistema de colas de impresión

```java
import java.util.*;

public class SistemaImpresion {

    static class Trabajo {
        String usuario;
        String documento;
        int paginas;
        int prioridad;

        public Trabajo(String usuario, String documento, int paginas, int prioridad) {
            this.usuario = usuario;
            this.documento = documento;
            this.paginas = paginas;
            this.prioridad = prioridad;
        }

        @Override
        public String toString() {
            return String.format("%s - %s (%d págs) [Prioridad: %d]",
                               usuario, documento, paginas, prioridad);
        }
    }

    private PriorityQueue<Trabajo> cola;

    public SistemaImpresion() {
        // Menor prioridad = se imprime primero
        this.cola = new PriorityQueue<>(
            Comparator.comparingInt(t -> t.prioridad)
        );
    }

    public void agregarTrabajo(String usuario, String documento,
                              int paginas, int prioridad) {
        cola.offer(new Trabajo(usuario, documento, paginas, prioridad));
        System.out.println("✓ Trabajo agregado a la cola");
    }

    public void procesarSiguiente() {
        Trabajo trabajo = cola.poll();
        if (trabajo != null) {
            System.out.println("🖨️  Imprimiendo: " + trabajo);
            // Simular impresión
            try {
                Thread.sleep(trabajo.paginas * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("✓ Impresión completada");
        } else {
            System.out.println("No hay trabajos en cola");
        }
    }

    public void mostrarCola() {
        System.out.println("\n=== COLA DE IMPRESIÓN ===");
        if (cola.isEmpty()) {
            System.out.println("(vacía)");
        } else {
            int pos = 1;
            for (Trabajo t : cola) {
                System.out.println(pos++ + ". " + t);
            }
        }
    }

    public static void main(String[] args) {
        SistemaImpresion sistema = new SistemaImpresion();

        sistema.agregarTrabajo("user1", "reporte.pdf", 10, 2);
        sistema.agregarTrabajo("admin", "urgente.pdf", 2, 1);
        sistema.agregarTrabajo("user2", "documento.pdf", 50, 3);

        sistema.mostrarCola();

        sistema.procesarSiguiente();
        sistema.procesarSiguiente();

        sistema.mostrarCola();
    }
}
```

## 5. Ordenación de colecciones

### Collections.sort()

```java
import java.util.*;

public class OrdenacionBasica {
    public static void ejemplos() {
        List<Integer> numeros = Arrays.asList(5, 2, 8, 1, 9);

        // Ordenar (orden natural)
        Collections.sort(numeros);
        System.out.println(numeros);  // [1, 2, 5, 8, 9]

        // Ordenar inverso
        Collections.sort(numeros, Collections.reverseOrder());
        System.out.println(numeros);  // [9, 8, 5, 2, 1]

        List<String> palabras = Arrays.asList("zorro", "apache", "mysql", "nginx");
        Collections.sort(palabras);
        System.out.println(palabras);  // [apache, mysql, nginx, zorro]

        // Ordenar por longitud
        Collections.sort(palabras, (a, b) -> Integer.compare(a.length(), b.length()));
    }
}
```

## 6. Comparator y Comparable

### Comparable - Orden natural

```java
public class Servidor implements Comparable<Servidor> {
    private String nombre;
    private String ip;
    private double cpu;

    public Servidor(String nombre, String ip, double cpu) {
        this.nombre = nombre;
        this.ip = ip;
        this.cpu = cpu;
    }

    @Override
    public int compareTo(Servidor otro) {
        // Ordenar por nombre
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - CPU: %.1f%%", nombre, ip, cpu);
    }

    public static void main(String[] args) {
        List<Servidor> servidores = new ArrayList<>();
        servidores.add(new Servidor("web-02", "10.0.1.12", 45.5));
        servidores.add(new Servidor("db-01", "10.0.1.20", 78.3));
        servidores.add(new Servidor("web-01", "10.0.1.11", 23.1));

        Collections.sort(servidores);  // Usa compareTo

        for (Servidor s : servidores) {
            System.out.println(s);
        }
    }

    // Getters para usar en Comparators
    public String getNombre() { return nombre; }
    public String getIp() { return ip; }
    public double getCpu() { return cpu; }
}
```

### Comparator - Órdenes personalizados

```java
import java.util.*;

public class ComparadoresServidor {

    // Ordenar por uso de CPU
    public static Comparator<Servidor> porCPU() {
        return (s1, s2) -> Double.compare(s1.getCpu(), s2.getCpu());
    }

    // Ordenar por CPU (descendente)
    public static Comparator<Servidor> porCPUDesc() {
        return (s1, s2) -> Double.compare(s2.getCpu(), s1.getCpu());
    }

    // Ordenar por IP
    public static Comparator<Servidor> porIP() {
        return Comparator.comparing(Servidor::getIp);
    }

    // Orden compuesto: primero por nombre, luego por CPU
    public static Comparator<Servidor> nombreYCPU() {
        return Comparator.comparing(Servidor::getNombre)
                        .thenComparingDouble(Servidor::getCpu);
    }

    public static void main(String[] args) {
        List<Servidor> servidores = Arrays.asList(
            new Servidor("web-02", "10.0.1.12", 45.5),
            new Servidor("db-01", "10.0.1.20", 78.3),
            new Servidor("web-01", "10.0.1.11", 23.1)
        );

        // Ordenar por CPU
        servidores.sort(porCPU());
        System.out.println("=== Por CPU ===");
        servidores.forEach(System.out::println);

        // Ordenar por nombre
        servidores.sort(Comparator.comparing(Servidor::getNombre));
        System.out.println("\n=== Por nombre ===");
        servidores.forEach(System.out::println);
    }
}
```

## Ejercicios prácticos

### Ejercicio 1: Gestor de usuarios únicos

Usa TreeSet para mantener usuarios únicos ordenados alfabéticamente.

### Ejercicio 2: Caché LRU

Implementa una caché con LinkedHashMap que elimine los elementos menos usados.

### Ejercicio 3: Sistema de tareas prioritarias

Crea un gestor de tareas con PriorityQueue basado en urgencia y fecha límite.

-----

## **Conceptos clave del módulo:**

- Set no permite duplicados, TreeSet mantiene orden natural
- Map asocia claves con valores, TreeMap ordena por claves
- Queue/Deque para procesamiento FIFO/LIFO
- PriorityQueue ordena elementos automáticamente
- Comparable define orden natural, Comparator permite órdenes personalizados
- Collections.sort() ordena listas
- Elegir la colección adecuada mejora el rendimiento
