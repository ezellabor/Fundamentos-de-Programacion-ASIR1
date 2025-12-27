<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>  

# MÓDULO 7: POO - HERENCIA Y POLIMORFISMO

## 1. Herencia: concepto y sintaxis

La **herencia** es uno de los pilares fundamentales de la POO que permite crear nuevas clases basadas en clases existentes, reutilizando y extendiendo su funcionalidad.

### Concepto

- Una clase **hija** (subclase o clase derivada) hereda atributos y métodos de una clase **padre** (superclase o clase base)
- Permite crear jerarquías de clases
- Promueve la reutilización de código

### Sintaxis básica

```java
// Clase padre
public class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public void trabajar() {
        System.out.println(nombre + " está trabajando");
    }

    public double calcularSalario() {
        return salario;
    }
}

// Clase hija
public class Programador extends Empleado {
    private String lenguajePrincipal;

    public Programador(String nombre, double salario, String lenguaje) {
        super(nombre, salario);  // Llamada al constructor del padre
        this.lenguajePrincipal = lenguaje;
    }

    public void programar() {
        System.out.println(nombre + " programa en " + lenguajePrincipal);
    }
}
```

### Uso

```java
Programador prog = new Programador("Ana", 35000, "Java");
prog.trabajar();    // Método heredado
prog.programar();   // Método propio
```

## 2. La palabra clave ‘super’

**super** se utiliza para referenciar a la clase padre desde la clase hija.

### Usos principales

1. **Llamar al constructor del padre**

```java
public class Administrador extends Empleado {
    private String departamento;

    public Administrador(String nombre, double salario, String depto) {
        super(nombre, salario);  // DEBE ser la primera línea
        this.departamento = depto;
    }
}
```

1. **Acceder a métodos del padre**

```java
public class Gerente extends Empleado {
    private double bono;

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bono;  // Usa el método del padre
    }
}
```

1. **Acceder a atributos del padre**

```java
public void mostrarInfo() {
    System.out.println("Nombre: " + super.nombre);
}
```

## 3. Sobrescritura de métodos

La **sobrescritura** (override) permite que una clase hija proporcione una implementación específica de un método ya definido en la clase padre.

### Reglas de sobrescritura

- El método debe tener el **mismo nombre**
- El método debe tener los **mismos parámetros**
- El tipo de retorno debe ser el **mismo o un subtipo** (covariante)
- El nivel de acceso no puede ser **más restrictivo**
- Se recomienda usar la anotación **@Override**

### Ejemplo

```java
public class Servidor {
    protected String nombre;
    protected String ip;

    public void iniciar() {
        System.out.println("Iniciando servidor " + nombre);
    }

    public void detener() {
        System.out.println("Deteniendo servidor");
    }
}

public class ServidorWeb extends Servidor {
    private int puerto;

    @Override
    public void iniciar() {
        super.iniciar();  // Llama al método del padre
        System.out.println("Escuchando en puerto " + puerto);
        System.out.println("Servidor web listo");
    }

    @Override
    public void detener() {
        System.out.println("Cerrando conexiones...");
        super.detener();
    }
}
```

## 4. Polimorfismo

El **polimorfismo** permite que un objeto pueda tomar muchas formas. En Java, significa que una referencia de tipo padre puede apuntar a objetos de tipo hijo.

### Polimorfismo en acción

```java
// Una referencia de tipo Empleado puede contener cualquier tipo de empleado
Empleado emp1 = new Programador("Carlos", 30000, "Python");
Empleado emp2 = new Administrador("Laura", 32000, "IT");
Empleado emp3 = new Gerente("Pedro", 50000, 10000);

// Array polimórfico
Empleado[] equipo = {emp1, emp2, emp3};

// El método correcto se ejecuta según el tipo real del objeto
for (Empleado e : equipo) {
    e.trabajar();           // Comportamiento específico de cada tipo
    System.out.println(e.calcularSalario());
}
```

### Ventajas del polimorfismo

1. **Flexibilidad**: Permite escribir código más genérico
1. **Extensibilidad**: Facilita añadir nuevas clases sin modificar código existente
1. **Mantenibilidad**: Reduce la duplicación de código

### Ejemplo práctico para ASIR

```java
public class SistemaOperativo {
    protected String nombre;

    public void iniciar() {
        System.out.println("Iniciando " + nombre);
    }

    public void ejecutarComando(String comando) {
        System.out.println("Ejecutando: " + comando);
    }
}

public class Linux extends SistemaOperativo {
    public Linux() {
        this.nombre = "Linux";
    }

    @Override
    public void ejecutarComando(String comando) {
        System.out.println("$ " + comando);
        // Lógica específica de Linux
    }
}

public class Windows extends SistemaOperativo {
    public Windows() {
        this.nombre = "Windows";
    }

    @Override
    public void ejecutarComando(String comando) {
        System.out.println("C:\\> " + comando);
        // Lógica específica de Windows
    }
}

// Uso polimórfico
public class GestorServidores {
    public void configurarServidor(SistemaOperativo so) {
        so.iniciar();
        so.ejecutarComando("apt update");  // Se adapta según el SO
    }
}
```

## 5. Clases abstractas

Una **clase abstracta** es una clase que no puede ser instanciada y sirve como plantilla para otras clases.

### Características

- Se declara con la palabra clave **abstract**
- Puede tener métodos abstractos (sin implementación) y concretos
- Puede tener atributos, constructores y métodos normales
- Al menos una clase hija debe implementar los métodos abstractos

### Sintaxis

```java
public abstract class DispositivoRed {
    protected String ip;
    protected String mac;

    public DispositivoRed(String ip, String mac) {
        this.ip = ip;
        this.mac = mac;
    }

    // Método abstracto (sin implementación)
    public abstract void conectar();

    // Método abstracto
    public abstract void desconectar();

    // Método concreto (con implementación)
    public void mostrarInfo() {
        System.out.println("IP: " + ip + ", MAC: " + mac);
    }
}

public class Router extends DispositivoRed {
    private int puertos;

    public Router(String ip, String mac, int puertos) {
        super(ip, mac);
        this.puertos = puertos;
    }

    @Override
    public void conectar() {
        System.out.println("Router conectado. Configurando " + puertos + " puertos");
    }

    @Override
    public void desconectar() {
        System.out.println("Desconectando router...");
    }
}

public class Switch extends DispositivoRed {
    private int vlans;

    public Switch(String ip, String mac, int vlans) {
        super(ip, mac);
        this.vlans = vlans;
    }

    @Override
    public void conectar() {
        System.out.println("Switch conectado. VLANs configuradas: " + vlans);
    }

    @Override
    public void desconectar() {
        System.out.println("Desconectando switch...");
    }
}
```

### Uso

```java
// DispositivoRed dispositivo = new DispositivoRed(); // ERROR: no se puede instanciar

DispositivoRed router = new Router("192.168.1.1", "AA:BB:CC:DD:EE:FF", 4);
DispositivoRed switch1 = new Switch("192.168.1.2", "11:22:33:44:55:66", 8);

router.conectar();
router.mostrarInfo();
```

## 6. Interfaces

Una **interfaz** es un contrato que define qué métodos debe implementar una clase, sin especificar cómo.

### Características

- Solo contiene métodos abstractos (por defecto) y constantes
- Una clase puede implementar múltiples interfaces
- Permite la herencia múltiple de comportamiento
- Desde Java 8: puede tener métodos default y static

### Sintaxis básica

```java
public interface Configurable {
    // Constantes (public static final por defecto)
    String VERSION = "1.0";

    // Métodos abstractos (public abstract por defecto)
    void cargarConfiguracion();
    void guardarConfiguracion();
    boolean validarConfiguracion();
}

public interface Auditable {
    void registrarEvento(String evento);
    void generarInforme();
}

// Una clase puede implementar múltiples interfaces
public class ServidorHTTP implements Configurable, Auditable {
    private String configuracion;

    @Override
    public void cargarConfiguracion() {
        System.out.println("Cargando httpd.conf");
        // Implementación específica
    }

    @Override
    public void guardarConfiguracion() {
        System.out.println("Guardando configuración en httpd.conf");
    }

    @Override
    public boolean validarConfiguracion() {
        // Validar sintaxis del archivo
        return true;
    }

    @Override
    public void registrarEvento(String evento) {
        System.out.println("LOG: " + evento);
    }

    @Override
    public void generarInforme() {
        System.out.println("Generando informe de accesos");
    }
}
```

### Métodos default (desde Java 8)

```java
public interface Monitorizable {
    void iniciarMonitoreo();
    void detenerMonitoreo();

    // Método con implementación por defecto
    default void mostrarEstado() {
        System.out.println("Estado del monitoreo");
    }
}
```

### Diferencias entre Clase Abstracta e Interfaz

|Característica|Clase Abstracta                   |Interfaz                                |
|--------------|----------------------------------|----------------------------------------|
|Herencia      |Solo una clase padre              |Múltiples interfaces                    |
|Métodos       |Puede tener métodos concretos     |Solo abstractos (excepto default/static)|
|Atributos     |Puede tener atributos de instancia|Solo constantes (static final)          |
|Constructor   |Puede tener constructores         |No tiene constructores                  |
|Modificadores |Cualquier modificador             |Todos son public                        |
|Cuándo usar   |Relación “es-un” con código común |Relación “puede-hacer” o capacidades    |

### Ejemplo práctico ASIR

```java
public interface Servicio {
    void iniciar();
    void detener();
    void reiniciar();
    String obtenerEstado();
}

public class ServicioSSH implements Servicio {
    private boolean ejecutando;

    @Override
    public void iniciar() {
        System.out.println("systemctl start ssh");
        ejecutando = true;
    }

    @Override
    public void detener() {
        System.out.println("systemctl stop ssh");
        ejecutando = false;
    }

    @Override
    public void reiniciar() {
        detener();
        iniciar();
    }

    @Override
    public String obtenerEstado() {
        return ejecutando ? "activo" : "inactivo";
    }
}

public class GestorServicios {
    public void administrar(Servicio servicio) {
        servicio.iniciar();
        System.out.println("Estado: " + servicio.obtenerEstado());
    }
}
```

## 7. La clase Object

**Object** es la clase raíz de toda la jerarquía de clases en Java. Todas las clases heredan de Object directa o indirectamente.

### Métodos principales de Object

```java
public class Usuario {
    private String nombre;
    private int id;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    // 1. toString() - Representación en String del objeto
    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', id=" + id + "}";
    }

    // 2. equals() - Comparar objetos por contenido
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return id == usuario.id && nombre.equals(usuario.nombre);
    }

    // 3. hashCode() - Código hash del objeto
    @Override
    public int hashCode() {
        return Objects.hash(nombre, id);
    }
}
```

### Uso de métodos de Object

```java
Usuario u1 = new Usuario("Admin", 1);
Usuario u2 = new Usuario("Admin", 1);
Usuario u3 = u1;

// toString()
System.out.println(u1);  // Usuario{nombre='Admin', id=1}

// equals()
System.out.println(u1.equals(u2));  // true (mismo contenido)
System.out.println(u1 == u2);       // false (diferentes referencias)
System.out.println(u1 == u3);       // true (misma referencia)

// getClass()
System.out.println(u1.getClass().getName());  // Usuario
```

## Ejercicios prácticos

### Ejercicio 1: Sistema de logs

Crea una jerarquía de clases para diferentes tipos de logs del sistema.

### Ejercicio 2: Gestión de dispositivos

Implementa un sistema de gestión de dispositivos de red usando interfaces y polimorfismo.

### Ejercicio 3: Servicios del sistema

Crea una interfaz Servicio y implementa diferentes servicios de Linux (Apache, MySQL, SSH).

-----

**Conceptos clave del módulo:**

- Herencia permite reutilizar código mediante relaciones padre-hijo
- super accede a elementos de la clase padre
- Sobrescritura permite especializar comportamiento
- Polimorfismo permite tratar objetos de forma genérica
- Clases abstractas definen plantillas con implementación parcial
- Interfaces definen contratos sin implementación
- Object es la clase base de todas las clases en Java
