<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# Módulo 6: Programación Orientada a Objetos - Conceptos Fundamentales

## Índice

1. Conceptos Fundamentales de POO
1. Clases y Objetos
1. Atributos y Métodos de Instancia
1. Constructores y Sobrecarga
1. Encapsulación: Modificadores de Acceso
1. Getters y Setters
1. La Palabra Clave ‘this’
1. Métodos y Variables Estáticas
1. Proyecto Integrador: Sistema de Gestión de Equipos Informáticos

-----

## 1. Conceptos Fundamentales de POO

### 1.1 ¿Qué es la Programación Orientada a Objetos?

La **Programación Orientada a Objetos (POO)** es un paradigma de programación que organiza el código en torno a **objetos** que representan entidades del mundo real.

**Paradigma anterior (Programación Procedural):**

```java
// Enfoque procedural: variables sueltas y funciones
String nombreServidor = "SRV-WEB-01";
String ip = "192.168.1.10";
boolean activo = true;

void mostrarInfoServidor(String nombre, String ip, boolean activo) {
    System.out.println("Servidor: " + nombre);
    System.out.println("IP: " + ip);
    System.out.println("Estado: " + (activo ? "Activo" : "Inactivo"));
}
```

**Enfoque POO:**

```java
// Enfoque POO: datos y comportamiento juntos en un objeto
class Servidor {
    String nombre;
    String ip;
    boolean activo;

    void mostrarInfo() {
        System.out.println("Servidor: " + nombre);
        System.out.println("IP: " + ip);
        System.out.println("Estado: " + (activo ? "Activo" : "Inactivo"));
    }
}
```

### 1.2 Pilares de la POO

#### 1.2.1 Encapsulación

Ocultar los detalles internos de un objeto y exponer solo lo necesario.

```java
// MAL: Todo es público
class CuentaBancaria {
    public double saldo;  // ¡Cualquiera puede modificarlo!
}

// BIEN: Datos protegidos, acceso controlado
class CuentaBancaria {
    private double saldo;  // Solo accesible dentro de la clase

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }
}
```

#### 1.2.2 Abstracción

Mostrar solo la información esencial y ocultar los detalles complejos.

```java
class SistemaBackup {
    // El usuario solo ve este método simple
    public void realizarBackup() {
        conectarServidor();
        verificarEspacio();
        copiarArchivos();
        comprimir();
        verificarIntegridad();
        desconectar();
    }

    // Los detalles complejos están ocultos
    private void conectarServidor() { /* ... */ }
    private void verificarEspacio() { /* ... */ }
    // etc.
}
```

#### 1.2.3 Herencia (veremos en módulo siguiente)

Crear nuevas clases basadas en clases existentes.

#### 1.2.4 Polimorfismo (veremos en módulo siguiente)

Que objetos de diferentes clases respondan al mismo mensaje de forma diferente.

### 1.3 Ventajas de la POO en ASIR

**Para administración de sistemas:**

- **Organización:** Modelar servidores, usuarios, servicios como objetos
- **Reutilización:** Crear clases base para diferentes tipos de equipos
- **Mantenimiento:** Cambios localizados en cada clase
- **Escalabilidad:** Fácil agregar nuevos tipos de dispositivos
- **Colaboración:** Código más legible para equipos

**Ejemplo práctico:**

```java
// Modelar componentes de red como objetos
Router router1 = new Router("RT-CORE-01", "192.168.1.1");
Switch switch1 = new Switch("SW-FLOOR1", "192.168.1.2", 24);
Servidor servidor1 = new Servidor("SRV-WEB-01", "192.168.1.10");

router1.mostrarInfo();
switch1.configurarVLAN(10, "Administracion");
servidor1.iniciar();
```

-----

## 2. Clases y Objetos

### 2.1 Definición de Clase

Una **clase** es un molde o plantilla que define la estructura y comportamiento de los objetos.

**Sintaxis básica:**

```java
public class NombreClase {
    // Atributos (variables de instancia)
    tipo atributo1;
    tipo atributo2;

    // Constructor
    public NombreClase(parametros) {
        // Inicialización
    }

    // Métodos (funciones)
    public void metodo1() {
        // Código
    }
}
```

### 2.2 Ejemplo: Clase Servidor

```java
/**
 * Clase que representa un servidor en la red
 * Modelo básico para gestión de infraestructura
 */
public class Servidor {
    // Atributos (características del servidor)
    String nombre;
    String ip;
    String sistemaOperativo;
    int ram;          // RAM en GB
    int almacenamiento; // Almacenamiento en GB
    boolean encendido;

    // Constructor (veremos en detalle más adelante)
    public Servidor(String nombre, String ip) {
        this.nombre = nombre;
        this.ip = ip;
        this.encendido = false;
    }

    // Métodos (acciones del servidor)
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("✓ Servidor " + nombre + " encendido");
        } else {
            System.out.println("⚠ El servidor ya está encendido");
        }
    }

    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println("✓ Servidor " + nombre + " apagado");
        } else {
            System.out.println("⚠ El servidor ya está apagado");
        }
    }

    public void mostrarInfo() {
        System.out.println("\n=== Información del Servidor ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("IP: " + ip);
        System.out.println("SO: " + sistemaOperativo);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Almacenamiento: " + almacenamiento + " GB");
        System.out.println("Estado: " + (encendido ? "Encendido" : "Apagado"));
        System.out.println("===============================\n");
    }
}
```

### 2.3 Creación de Objetos

Un **objeto** es una instancia concreta de una clase.

```java
public class GestionServidores {
    public static void main(String[] args) {
        // Crear objetos (instancias de la clase Servidor)
        Servidor servidor1 = new Servidor("SRV-WEB-01", "192.168.1.10");
        Servidor servidor2 = new Servidor("SRV-DB-01", "192.168.1.20");
        Servidor servidor3 = new Servidor("SRV-MAIL-01", "192.168.1.30");

        // Configurar atributos
        servidor1.sistemaOperativo = "Ubuntu Server 22.04";
        servidor1.ram = 16;
        servidor1.almacenamiento = 500;

        servidor2.sistemaOperativo = "CentOS 8";
        servidor2.ram = 32;
        servidor2.almacenamiento = 1000;

        servidor3.sistemaOperativo = "Debian 11";
        servidor3.ram = 8;
        servidor3.almacenamiento = 250;

        // Usar métodos
        servidor1.encender();
        servidor1.mostrarInfo();

        servidor2.encender();
        servidor2.mostrarInfo();

        servidor3.mostrarInfo();  // Este está apagado
    }
}
```

**Salida esperada:**

```
✓ Servidor SRV-WEB-01 encendido

=== Información del Servidor ===
Nombre: SRV-WEB-01
IP: 192.168.1.10
SO: Ubuntu Server 22.04
RAM: 16 GB
Almacenamiento: 500 GB
Estado: Encendido
===============================

✓ Servidor SRV-DB-01 encendido

=== Información del Servidor ===
Nombre: SRV-DB-01
IP: 192.168.1.20
SO: CentOS 8
RAM: 32 GB
Almacenamiento: 1000 GB
Estado: Encendido
===============================

=== Información del Servidor ===
Nombre: SRV-MAIL-01
IP: 192.168.1.30
SO: Debian 11
RAM: 8 GB
Almacenamiento: 250 GB
Estado: Apagado
===============================
```

### 2.4 Múltiples Objetos de la Misma Clase

```java
public class DemoMultiplesObjetos {
    public static void main(String[] args) {
        // Crear array de servidores
        Servidor[] servidores = new Servidor[5];

        // Inicializar cada servidor
        servidores[0] = new Servidor("SRV-WEB-01", "192.168.1.10");
        servidores[1] = new Servidor("SRV-WEB-02", "192.168.1.11");
        servidores[2] = new Servidor("SRV-DB-01", "192.168.1.20");
        servidores[3] = new Servidor("SRV-MAIL-01", "192.168.1.30");
        servidores[4] = new Servidor("SRV-BACKUP-01", "192.168.1.40");

        // Operaciones masivas
        System.out.println("Encendiendo todos los servidores...\n");
        for (Servidor srv : servidores) {
            srv.encender();
        }

        System.out.println("\n--- Estado de todos los servidores ---");
        for (Servidor srv : servidores) {
            srv.mostrarInfo();
        }
    }
}
```

-----

## 3. Atributos y Métodos de Instancia

### 3.1 Atributos de Instancia

Los **atributos de instancia** son variables que pertenecen a cada objeto individual.

```java
public class DispositivoRed {
    // Atributos de instancia
    // Cada objeto tiene sus propias copias de estas variables
    String nombre;
    String ip;
    String macAddress;
    int puerto;
    boolean conectado;
    long bytesEnviados;
    long bytesRecibidos;

    // Cada dispositivo tiene valores diferentes
}
```

**Ejemplo de uso:**

```java
public class EjemploAtributos {
    public static void main(String[] args) {
        DispositivoRed router = new DispositivoRed();
        router.nombre = "Router-Principal";
        router.ip = "192.168.1.1";
        router.macAddress = "00:1B:44:11:3A:B7";
        router.conectado = true;
        router.bytesEnviados = 1500000;
        router.bytesRecibidos = 2300000;

        DispositivoRed switch1 = new DispositivoRed();
        switch1.nombre = "Switch-Planta1";
        switch1.ip = "192.168.1.2";
        switch1.macAddress = "00:1B:44:11:3A:C8";
        switch1.conectado = true;
        switch1.bytesEnviados = 800000;
        switch1.bytesRecibidos = 950000;

        // Cada objeto tiene sus propios valores
        System.out.println(router.nombre + " - Bytes enviados: " + router.bytesEnviados);
        System.out.println(switch1.nombre + " - Bytes enviados: " + switch1.bytesEnviados);
    }
}
```

### 3.2 Métodos de Instancia

Los **métodos de instancia** son funciones que operan sobre los atributos de un objeto específico.

```java
public class Usuario {
    // Atributos
    String username;
    String password;
    String email;
    boolean activo;
    int intentosFallidosLogin;

    // Métodos de instancia

    /**
     * Valida las credenciales del usuario
     * @param pass Contraseña a validar
     * @return true si la contraseña es correcta
     */
    public boolean validarPassword(String pass) {
        if (password.equals(pass)) {
            intentosFallidosLogin = 0;
            System.out.println("✓ Login exitoso para " + username);
            return true;
        } else {
            intentosFallidosLogin++;
            System.out.println("✗ Password incorrecto para " + username);

            if (intentosFallidosLogin >= 3) {
                bloquearCuenta();
            }
            return false;
        }
    }

    /**
     * Bloquea la cuenta del usuario
     */
    public void bloquearCuenta() {
        activo = false;
        System.out.println("⚠ CUENTA BLOQUEADA: " + username +
                         " (3 intentos fallidos)");
    }

    /**
     * Desbloquea la cuenta
     */
    public void desbloquearCuenta() {
        activo = true;
        intentosFallidosLogin = 0;
        System.out.println("✓ Cuenta desbloqueada: " + username);
    }

    /**
     * Cambia el email del usuario
     */
    public void cambiarEmail(String nuevoEmail) {
        String emailAnterior = email;
        email = nuevoEmail;
        System.out.println("Email actualizado de " + emailAnterior +
                         " a " + nuevoEmail);
    }

    /**
     * Muestra información del usuario
     */
    public void mostrarInfo() {
        System.out.println("\n--- Usuario: " + username + " ---");
        System.out.println("Email: " + email);
        System.out.println("Estado: " + (activo ? "Activo" : "Bloqueado"));
        System.out.println("Intentos fallidos: " + intentosFallidosLogin);
    }
}
```

**Uso de los métodos:**

```java
public class TestUsuario {
    public static void main(String[] args) {
        // Crear usuario
        Usuario user = new Usuario();
        user.username = "jgarcia";
        user.password = "segura123";
        user.email = "jgarcia@empresa.com";
        user.activo = true;
        user.intentosFallidosLogin = 0;

        // Usar métodos de instancia
        user.mostrarInfo();

        // Intentos de login
        user.validarPassword("incorrecta");  // Fallo 1
        user.validarPassword("mala");        // Fallo 2
        user.validarPassword("error");       // Fallo 3 - Se bloquea

        user.mostrarInfo();

        // Desbloquear
        user.desbloquearCuenta();
        user.validarPassword("segura123");   // Éxito

        // Cambiar email
        user.cambiarEmail("juan.garcia@empresa.com");
        user.mostrarInfo();
    }
}
```

### 3.3 Diferencia entre Atributos y Variables Locales

```java
public class EjemploDiferencias {
    // ATRIBUTO DE INSTANCIA
    // - Existe mientras exista el objeto
    // - Accesible en todos los métodos de la clase
    // - Valor por defecto: null, 0, false según el tipo
    String nombre;

    public void metodo1() {
        // VARIABLE LOCAL
        // - Solo existe dentro de este método
        // - Debe inicializarse antes de usarse
        int contador = 0;

        // Se puede acceder al atributo
        System.out.println("Nombre: " + nombre);

        // Se puede acceder a la variable local
        System.out.println("Contador: " + contador);
    }

    public void metodo2() {
        // Se puede acceder al atributo
        System.out.println("Nombre: " + nombre);

        // ERROR: No se puede acceder a 'contador'
        // porque es variable local de metodo1()
        // System.out.println(contador);  // ¡NO COMPILA!
    }
}
```

-----

## 4. Constructores y Sobrecarga

### 4.1 ¿Qué es un Constructor?

Un **constructor** es un método especial que se ejecuta automáticamente cuando se crea un objeto.

**Características:**

- Mismo nombre que la clase
- No tiene tipo de retorno (ni siquiera void)
- Se ejecuta automáticamente con `new`
- Inicializa el objeto

### 4.2 Constructor por Defecto

Si no defines ningún constructor, Java crea uno automáticamente:

```java
public class Impresora {
    String modelo;
    String ip;
    int paginasImpresas;

    // Java crea automáticamente:
    // public Impresora() {
    // }
}

// Uso:
Impresora imp = new Impresora();  // Usa el constructor por defecto
imp.modelo = "HP LaserJet";
imp.ip = "192.168.1.100";
```

### 4.3 Constructor Personalizado

```java
public class Impresora {
    String modelo;
    String ip;
    int paginasImpresas;
    boolean tieneToner;

    /**
     * Constructor personalizado
     * Inicializa la impresora con valores específicos
     */
    public Impresora(String mod, String direccionIP) {
        modelo = mod;
        ip = direccionIP;
        paginasImpresas = 0;
        tieneToner = true;

        System.out.println("✓ Impresora " + modelo + " configurada en " + ip);
    }

    public void imprimir(int numPaginas) {
        if (tieneToner) {
            paginasImpresas += numPaginas;
            System.out.println("Imprimiendo " + numPaginas + " páginas...");
            System.out.println("Total impreso: " + paginasImpresas);

            if (paginasImpresas > 500) {
                tieneToner = false;
                System.out.println("⚠ Toner agotado");
            }
        } else {
            System.out.println("✗ No se puede imprimir: Toner agotado");
        }
    }
}
```

**Uso:**

```java
public class TestImpresora {
    public static void main(String[] args) {
        // Al crear el objeto, se ejecuta el constructor
        Impresora imp1 = new Impresora("HP LaserJet Pro", "192.168.1.100");
        Impresora imp2 = new Impresora("Canon ImageClass", "192.168.1.101");

        // Ya están inicializadas
        imp1.imprimir(50);
        imp2.imprimir(30);
    }
}
```

### 4.4 Sobrecarga de Constructores

Puedes tener **múltiples constructores** con diferentes parámetros:

```java
public class Switch {
    String nombre;
    String ip;
    int numeroPuertos;
    String ubicacion;
    boolean administrable;

    /**
     * Constructor 1: Solo nombre e IP
     */
    public Switch(String nombre, String ip) {
        this.nombre = nombre;
        this.ip = ip;
        this.numeroPuertos = 24;  // Valor por defecto
        this.administrable = true;
        System.out.println("✓ Switch básico creado");
    }

    /**
     * Constructor 2: Nombre, IP y número de puertos
     */
    public Switch(String nombre, String ip, int puertos) {
        this.nombre = nombre;
        this.ip = ip;
        this.numeroPuertos = puertos;
        this.administrable = true;
        System.out.println("✓ Switch con " + puertos + " puertos creado");
    }

    /**
     * Constructor 3: Todos los parámetros
     */
    public Switch(String nombre, String ip, int puertos, String ubicacion, boolean admin) {
        this.nombre = nombre;
        this.ip = ip;
        this.numeroPuertos = puertos;
        this.ubicacion = ubicacion;
        this.administrable = admin;
        System.out.println("✓ Switch completo creado en " + ubicacion);
    }

    public void mostrarInfo() {
        System.out.println("\n=== Switch: " + nombre + " ===");
        System.out.println("IP: " + ip);
        System.out.println("Puertos: " + numeroPuertos);
        System.out.println("Ubicación: " + (ubicacion != null ? ubicacion : "No especificada"));
        System.out.println("Tipo: " + (administrable ? "Administrable" : "No administrable"));
    }
}
```

**Uso de los diferentes constructores:**

```java
public class TestSwitch {
    public static void main(String[] args) {
        // Usar constructor 1 (solo nombre e IP)
        Switch sw1 = new Switch("SW-Planta1", "192.168.1.2");

        // Usar constructor 2 (con número de puertos)
        Switch sw2 = new Switch("SW-Planta2", "192.168.1.3", 48);

        // Usar constructor 3 (completo)
        Switch sw3 = new Switch("SW-Core", "192.168.1.1", 48,
                               "Sala Servidores", true);

        sw1.mostrarInfo();
        sw2.mostrarInfo();
        sw3.mostrarInfo();
    }
}
```

### 4.5 Llamada a Constructores desde Otros Constructores

```java
public class Servidor {
    String nombre;
    String ip;
    String so;
    int ram;

    /**
     * Constructor completo
     */
    public Servidor(String nombre, String ip, String so, int ram) {
        this.nombre = nombre;
        this.ip = ip;
        this.so = so;
        this.ram = ram;
    }

    /**
     * Constructor simplificado que llama al completo
     * Usa valores por defecto para SO y RAM
     */
    public Servidor(String nombre, String ip) {
        // Llamar al otro constructor usando 'this()'
        this(nombre, ip, "Ubuntu Server 22.04", 8);
    }

    /**
     * Constructor mínimo
     */
    public Servidor(String nombre) {
        this(nombre, "192.168.1.100");
    }
}
```

**Uso:**

```java
Servidor srv1 = new Servidor("SRV-WEB-01", "192.168.1.10", "CentOS 8", 16);
Servidor srv2 = new Servidor("SRV-DB-01", "192.168.1.20");  // Usa defaults
Servidor srv3 = new Servidor("SRV-BACKUP");  // Usa todos los defaults
```

-----

## 5. Encapsulación: Modificadores de Acceso

### 5.1 ¿Qué es la Encapsulación?

La **encapsulación** es ocultar los detalles internos de una clase y controlar el acceso a sus miembros.

**¿Por qué es importante?**

- Protege los datos de modificaciones no autorizadas
- Permite validar los valores antes de asignarlos
- Facilita el mantenimiento (cambios internos sin afectar el exterior)
- Aumenta la seguridad del código

### 5.2 Modificadores de Acceso

Java tiene 4 niveles de acceso:

|Modificador|Misma Clase|Mismo Paquete|Subclase|Todo el mundo|
|-----------|-----------|-------------|--------|-------------|
|`private`  |✓          |✗            |✗       |✗            |
|*(default)*|✓          |✓            |✗       |✗            |
|`protected`|✓          |✓            |✓       |✗            |
|`public`   |✓          |✓            |✓       |✓            |

### 5.3 private - Acceso Privado

```java
public class CuentaBancaria {
    // Atributos PRIVADOS - Solo accesibles dentro de esta clase
    private String numeroCuenta;
    private double saldo;
    private String titular;

    public CuentaBancaria(String numero, String titular) {
        this.numeroCuenta = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Método público que controla el acceso al saldo
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("✓ Depósito realizado: $" + cantidad);
            System.out.println("  Saldo actual: $" + saldo);
        } else {
            System.out.println("✗ Cantidad inválida");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("✓ Retiro realizado: $" + cantidad);
            System.out.println("  Saldo actual: $" + saldo);
        } else {
            System.out.println("✗ Fondos insuficientes o cantidad inválida");
        }
    }

    // Método para consultar el saldo (lectura controlada)
    public double consultarSaldo() {
        return saldo;
    }
}
```

**Ventajas de usar `private`:**

```java
public class TestCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("123456", "Juan Pérez");

        // CORRECTO: Usar métodos públicos
        cuenta.depositar(1000);
        cuenta.retirar(500);

        // ERROR: No se puede acceder directamente
        // cuenta.saldo = 999999;  // ¡NO COMPILA! (está private)

        // CORRECTO: Consultar saldo de forma controlada
        double saldo = cuenta.consultarSaldo();
        System.out.println("Saldo final: $" + saldo);
    }
}
```

### 5.4 public - Acceso Público

```java
public class Configuracion {
    // Atributos PÚBLICOS - Accesibles desde cualquier lugar
    // (Generalmente NO recomendado para atributos)
    public String version = "1.0.0";
    public String nombreApp = "GestorRed";

    // Métodos públicos
    public void mostrarInfo() {
        System.out.println(nombreApp + " v" + version);
    }
}

// Desde cualquier clase:
Configuracion config = new Configuracion();
config.version = "2.0.0";  // Acceso directo (pero peligroso)
```

### 5.5 Ejemplo Completo: Encapsulación en ASIR

```java
/**
 * Clase que representa un equipo en el inventario
 * Demuestra encapsulación apropiada
 */
public class EquipoInformatico {
    // Atributos PRIVADOS
    private String codigo;
    private String tipo;      // PC, Portátil, Servidor, etc.
    private String marca;
    private String modelo;
    private double precio;
    private boolean asignado;
    private String usuarioAsignado;

    // Constructor
    public EquipoInformatico(String codigo, String tipo, String marca,
                             String modelo, double precio) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.asignado = false;
        this.usuarioAsignado = null;
    }

    // Métodos públicos que controlan el acceso

    /**
     * Asigna el equipo a un usuario
     */
    public boolean asignarA(String usuario) {
        if (!asignado) {
            this.asignado = true;
            this.usuarioAsignado = usuario;
            System.out.println("✓ Equipo " + codigo + " asignado a " + usuario);
            return true;
        } else {
            System.out.println("✗ El equipo ya está asignado a " + usuarioAsignado);
            return false;
        }
    }

    /**
     * Libera el equipo
     */
    public void liberar() {
        if (asignado) {
            System.out.println("✓ Equipo " + codigo + " liberado (estaba asignado a " +
                             usuarioAsignado + ")");
            this.asignado = false;
            this.usuarioAsignado = null;
        } else {
            System.out.println("⚠ El equipo no estaba asignado");
        }
    }

    /**
     * Actualiza el precio con validación
     */
    public void actualizarPrecio(double nuevoPrecio) {
        if (nuevoPrecio > 0) {
            double precioAnterior = this.precio;
            this.precio = nuevoPrecio;
            System.out.println("Precio actualizado: $" + precioAnterior +
                             " -> $" + nuevoPrecio);
        } else {
            System.out.println("✗ Precio inválido");
        }
    }

    /**
     * Muestra información del equipo
     */
    public void mostrarInfo() {
        System.out.println("\n=== Equipo: " + codigo + " ===");
        System.out.println("Tipo: " + tipo);
        System.out.println("Marca: " + marca + " " + modelo);
        System.out.println("Precio: $" + precio);
        System.out.println("Estado: " + (asignado ? "Asignado a " + usuarioAsignado :
                                                     "Disponible"));
        System.out.println("========================\n");
    }

    // Métodos getter (solo lectura) - veremos en la siguiente sección
    public String getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public boolean isAsignado() { return asignado; }
}
```

**Uso:**

```java
public class TestEquipo {
    public static void main(String[] args) {
        EquipoInformatico pc1 = new EquipoInformatico(
            "PC-001", "PC Escritorio", "Dell", "OptiPlex 7090", 899.99
        );

        pc1.mostrarInfo();

        // Intentar asignar
        pc1.asignarA("Juan García");
        pc1.mostrarInfo();

        // Intentar asignar de nuevo (fallará)
        pc1.asignarA("María López");

        // Liberar y reasignar
        pc1.liberar();
        pc1.asignarA("María López");

        // Actualizar precio
        pc1.actualizarPrecio(799.99);

        pc1.mostrarInfo();

        // NO se puede hacer esto (atributos privados):
        // pc1.precio = 0;  // ¡NO COMPILA!
        // pc1.asignado = false;  // ¡NO COMPILA!
    }
}
```

-----

## 6. Getters y Setters

### 6.1 ¿Qué son los Getters y Setters?

Los **getters** y **setters** son métodos públicos que permiten acceder y modificar atributos privados de forma controlada.

**Convención de nombres:**

- **Getter:** `getTipoAtributo nombreAtributo()`
- **Setter:** `void setNombreAtributo(tipo valor)`
- **Para boolean:** `boolean isNombreAtributo()` en lugar de `get`

### 6.2 Ejemplo Básico

```java
public class Persona {
    // Atributos privados
    private String nombre;
    private int edad;
    private String email;

    // Constructor
    public Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    // GETTERS (Métodos de lectura)

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    // SETTERS (Métodos de escritura con validación)

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("✗ Nombre inválido");
        }
    }

    public void setEdad(int edad) {
        if (edad >= 0 && edad <= 120) {
            this.edad = edad;
        } else {
            System.out.println("✗ Edad inválida");
        }
    }

    public void setEmail(String email) {
        // Validación simple de email
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("✗ Email inválido");
        }
    }
}
```

**Uso:**

```java
public class TestPersona {
    public static void main(String[] args) {
        Persona p = new Persona("Juan", 25, "juan@email.com");

        // LEER atributos usando getters
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Edad: " + p.getEdad());
        System.out.println("Email: " + p.getEmail());

        // MODIFICAR atributos usando setters
        p.setEdad(26);  // Válido
        p.setEmail("juan.garcia@empresa.com");  // Válido

        p.setEdad(-5);  // Inválido - muestra error
        p.setEmail("invalido");  // Inválido - muestra error

        System.out.println("\nDatos actualizados:");
        System.out.println("Edad: " + p.getEdad());  // 26
        System.out.println("Email: " + p.getEmail());  // juan.garcia@empresa.com
    }
}
```

### 6.3 Ventajas de Usar Getters y Setters

**1. Validación de Datos**

```java
public class Usuario {
    private String password;

    public void setPassword(String pass) {
        // Validar longitud mínima
        if (pass.length() < 8) {
            System.out.println("✗ La contraseña debe tener al menos 8 caracteres");
            return;
        }

        // Validar que contenga números
        if (!pass.matches(".*\\d.*")) {
            System.out.println("✗ La contraseña debe contener al menos un número");
            return;
        }

        this.password = pass;
        System.out.println("✓ Contraseña actualizada");
    }
}
```

**2. Solo Lectura (Getter sin Setter)**

```java
public class Producto {
    private String codigo;
    private double precio;

    public Producto(String codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    // Solo getter - el código NO se puede cambiar después de creado
    public String getCodigo() {
        return codigo;
    }

    // Getter y setter para precio (sí se puede modificar)
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        }
    }
}
```

**3. Cálculos Dinámicos**

```java
public class Rectangulo {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() { return ancho; }
    public double getAlto() { return alto; }

    // Getter que calcula el área (no hay atributo 'area')
    public double getArea() {
        return ancho * alto;
    }

    // Getter que calcula el perímetro
    public double getPerimetro() {
        return 2 * (ancho + alto);
    }
}

// Uso:
Rectangulo r = new Rectangulo(5, 3);
System.out.println("Área: " + r.getArea());  // 15
System.out.println("Perímetro: " + r.getPerimetro());  // 16
```

### 6.4 Ejemplo ASIR: Gestión de Direcciones IP

```java
public class DireccionIP {
    private int octeto1;
    private int octeto2;
    private int octeto3;
    private int octeto4;

    public DireccionIP(String ip) {
        setIP(ip);
    }

    /**
     * Setter que valida y parsea una dirección IP
     */
    public void setIP(String ip) {
        String[] partes = ip.split("\\.");

        if (partes.length != 4) {
            System.out.println("✗ IP inválida: debe tener 4 octetos");
            return;
        }

        try {
            int o1 = Integer.parseInt(partes[0]);
            int o2 = Integer.parseInt(partes[1]);
            int o3 = Integer.parseInt(partes[2]);
            int o4 = Integer.parseInt(partes[3]);

            if (validarOcteto(o1) && validarOcteto(o2) &&
                validarOcteto(o3) && validarOcteto(o4)) {
                this.octeto1 = o1;
                this.octeto2 = o2;
                this.octeto3 = o3;
                this.octeto4 = o4;
                System.out.println("✓ IP válida: " + getIP());
            } else {
                System.out.println("✗ Octetos fuera de rango (0-255)");
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ IP inválida: formato incorrecto");
        }
    }

    /**
     * Getter que construye la IP como String
     */
    public String getIP() {
        return octeto1 + "." + octeto2 + "." + octeto3 + "." + octeto4;
    }

    /**
     * Valida que un octeto esté en rango válido
     */
    private boolean validarOcteto(int octeto) {
        return octeto >= 0 && octeto <= 255;
    }

    /**
     * Determina la clase de red
     */
    public String getClaseRed() {
        if (octeto1 >= 1 && octeto1 <= 126) return "A";
        if (octeto1 >= 128 && octeto1 <= 191) return "B";
        if (octeto1 >= 192 && octeto1 <= 223) return "C";
        if (octeto1 >= 224 && octeto1 <= 239) return "D (Multicast)";
        return "E (Experimental)";
    }

    /**
     * Verifica si es IP privada
     */
    public boolean isPrivada() {
        // Rangos privados:
        // 10.0.0.0 - 10.255.255.255
        // 172.16.0.0 - 172.31.255.255
        // 192.168.0.0 - 192.168.255.255

        if (octeto1 == 10) return true;
        if (octeto1 == 172 && octeto2 >= 16 && octeto2 <= 31) return true;
        if (octeto1 == 192 && octeto2 == 168) return true;

        return false;
    }
}
```

**Uso:**

```java
public class TestDireccionIP {
    public static void main(String[] args) {
        DireccionIP ip1 = new DireccionIP("192.168.1.1");
        System.out.println("IP: " + ip1.getIP());
        System.out.println("Clase: " + ip1.getClaseRed());
        System.out.println("Es privada: " + ip1.isPrivada());

        System.out.println();

        DireccionIP ip2 = new DireccionIP("8.8.8.8");
        System.out.println("IP: " + ip2.getIP());
        System.out.println("Clase: " + ip2.getClaseRed());
        System.out.println("Es privada: " + ip2.isPrivada());

        System.out.println();

        // Probar validación
        DireccionIP ip3 = new DireccionIP("999.999.999.999");  // Inválida
        DireccionIP ip4 = new DireccionIP("192.168.1");  // Inválida
    }
}
```

-----

## 7. La Palabra Clave ‘this’

### 7.1 ¿Qué es ‘this’?

`this` es una referencia al **objeto actual** (la instancia desde donde se llama el método).

### 7.2 Uso 1: Diferenciar Atributos de Parámetros

```java
public class Equipo {
    private String nombre;
    private String ip;

    // Sin 'this' - AMBIGUO
    public Equipo(String nombre, String ip) {
        // ¿Cuál es cuál?
        // nombre = nombre;  // ¡Asigna el parámetro a sí mismo!
    }

    // Con 'this' - CLARO
    public Equipo(String nombre, String ip) {
        this.nombre = nombre;  // this.nombre = atributo de la clase
        this.ip = ip;          // nombre = parámetro del método
    }
}
```

### 7.3 Uso 2: Llamar a Otros Constructores

```java
public class Servidor {
    private String nombre;
    private String ip;
    private String so;
    private int ram;

    // Constructor completo
    public Servidor(String nombre, String ip, String so, int ram) {
        this.nombre = nombre;
        this.ip = ip;
        this.so = so;
        this.ram = ram;
    }

    // Constructor que llama al completo usando 'this()'
    public Servidor(String nombre, String ip) {
        this(nombre, ip, "Ubuntu Server", 8);  // Llama al otro constructor
    }

    // Constructor mínimo
    public Servidor(String nombre) {
        this(nombre, "192.168.1.100");  // Llama al constructor de 2 parámetros
    }
}

// Uso:
Servidor srv1 = new Servidor("SRV-WEB-01", "192.168.1.10", "CentOS", 16);
Servidor srv2 = new Servidor("SRV-DB-01", "192.168.1.20");
Servidor srv3 = new Servidor("SRV-BACKUP");
```

### 7.4 Uso 3: Pasar el Objeto Actual como Parámetro

```java
public class Tarea {
    private String nombre;
    private String descripcion;

    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void registrarEnSistema(SistemaGestion sistema) {
        // Pasar 'this' (la tarea actual) al sistema
        sistema.agregarTarea(this);
    }

    public String getNombre() {
        return nombre;
    }
}

class SistemaGestion {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
        System.out.println("✓ Tarea agregada: " + tarea.getNombre());
    }
}

// Uso:
SistemaGestion sistema = new SistemaGestion();
Tarea tarea1 = new Tarea("Backup", "Realizar backup diario");
tarea1.registrarEnSistema(sistema);  // La tarea se pasa a sí misma
```

### 7.5 Uso 4: Retornar el Objeto Actual (Method Chaining)

```java
public class ConfiguradorServidor {
    private String nombre;
    private String ip;
    private int ram;
    private String so;

    // Constructor
    public ConfiguradorServidor(String nombre) {
        this.nombre = nombre;
    }

    // Métodos que retornan 'this' para encadenar llamadas
    public ConfiguradorServidor setIP(String ip) {
        this.ip = ip;
        return this;  // Retorna el objeto actual
    }

    public ConfiguradorServidor setRAM(int ram) {
        this.ram = ram;
        return this;
    }

    public ConfiguradorServidor setSO(String so) {
        this.so = so;
        return this;
    }

    public void construir() {
        System.out.println("=== Servidor Configurado ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("IP: " + ip);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("SO: " + so);
    }
}

// Uso: Method Chaining (encadenamiento de métodos)
ConfiguradorServidor config = new ConfiguradorServidor("SRV-WEB-01");
config.setIP("192.168.1.10")
      .setRAM(16)
      .setSO("Ubuntu Server 22.04")
      .construir();
```

### 7.6 Ejemplo Completo con ‘this’

```java
public class Router {
    private String modelo;
    private String ip;
    private int puertosLAN;
    private boolean wifi;

    // Constructor 1
    public Router(String modelo, String ip, int puertosLAN, boolean wifi) {
        this.modelo = modelo;      // 'this' diferencia atributo de parámetro
        this.ip = ip;
        this.puertosLAN = puertosLAN;
        this.wifi = wifi;
    }

    // Constructor 2: llama al primero usando 'this()'
    public Router(String modelo, String ip) {
        this(modelo, ip, 4, true);  // Valores por defecto
    }

    // Método que usa 'this' para comparar con otro router
    public boolean mismaMarca(Router otroRouter) {
        // 'this.modelo' = modelo de este router
        // 'otroRouter.modelo' = modelo del otro router
        return this.modelo.equals(otroRouter.modelo);
    }

    // Método que retorna 'this' para encadenamiento
    public Router configurarIP(String nuevaIP) {
        this.ip = nuevaIP;
        return this;
    }

    public Router habilitarWiFi(boolean habilitar) {
        this.wifi = habilitar;
        return this;
    }

    public void mostrarInfo() {
        System.out.println("\n=== Router ===");
        System.out.println("Modelo: " + this.modelo);
        System.out.println("IP: " + this.ip);
        System.out.println("Puertos LAN: " + this.puertosLAN);
        System.out.println("WiFi: " + (this.wifi ? "Habilitado" : "Deshabilitado"));
    }
}
```

**Uso:**

```java
public class TestRouter {
    public static void main(String[] args) {
        // Usar constructor completo
        Router r1 = new Router("TP-Link Archer C7", "192.168.1.1", 4, true);

        // Usar constructor simplificado
        Router r2 = new Router("TP-Link Archer C7", "192.168.1.254");

        // Comparar routers
        if (r1.mismaMarca(r2)) {
            System.out.println("Los routers son de la misma marca");
        }

        // Method chaining
        Router r3 = new Router("Cisco RV340", "192.168.1.1");
        r3.configurarIP("10.0.0.1")
          .habilitarWiFi(false)
          .mostrarInfo();
    }
}
```

-----

## 8. Métodos y Variables Estáticas

### 8.1 ¿Qué es ‘static’?

`static` indica que un miembro (atributo o método) pertenece a la **clase**, no a las instancias individuales.

**Diferencias clave:**

|Miembros de Instancia            |Miembros Estáticos              |
|---------------------------------|--------------------------------|
|Cada objeto tiene su propia copia|Compartido por todos los objetos|
|Se accede con: `objeto.miembro`  |Se accede con: `Clase.miembro`  |
|Requiere crear un objeto         |No requiere objeto              |

### 8.2 Variables Estáticas (de Clase)

```java
public class Contador {
    // Variable de INSTANCIA: cada objeto tiene su propia copia
    private int contadorInstancia = 0;

    // Variable ESTÁTICA: compartida por todos los objetos
    private static int contadorEstatico = 0;

    public Contador() {
        contadorInstancia++;
        contadorEstatico++;
    }

    public void mostrar() {
        System.out.println("Instancia: " + contadorInstancia +
                         " | Estático: " + contadorEstatico);
    }
}
```

**Comportamiento:**

```java
public class TestContador {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        c1.mostrar();  // Instancia: 1 | Estático: 1

        Contador c2 = new Contador();
        c2.mostrar();  // Instancia: 1 | Estático: 2

        Contador c3 = new Contador();
        c3.mostrar();  // Instancia: 1 | Estático: 3

        c1.mostrar();  // Instancia: 1 | Estático: 3 (estático sigue aumentando)
    }
}
```

### 8.3 Ejemplo Práctico: Contador de Objetos

```java
public class Usuario {
    // Variable estática: cuenta cuántos usuarios se han creado
    private static int totalUsuarios = 0;

    // Variables de instancia
    private String username;
    private int id;

    public Usuario(String username) {
        totalUsuarios++;  // Incrementar contador compartido
        this.id = totalUsuarios;  // Asignar ID único
        this.username = username;
        System.out.println("✓ Usuario #" + id + " creado: " + username);
    }

    // Método estático: se puede llamar sin crear objeto
    public static int getTotalUsuarios() {
        return totalUsuarios;
    }

    public void mostrarInfo() {
        System.out.println("Usuario: " + username + " (ID: " + id + ")");
    }
}
```

**Uso:**

```java
public class TestUsuario {
    public static void main(String[] args) {
        // Antes de crear objetos, podemos consultar el total
        System.out.println("Usuarios registrados: " + Usuario.getTotalUsuarios());

        // Crear usuarios
        Usuario u1 = new Usuario("jgarcia");
        Usuario u2 = new Usuario("mlopez");
        Usuario u3 = new Usuario("pmartin");

        // Consultar total sin referencia a un objeto específico
        System.out.println("\nTotal usuarios: " + Usuario.getTotalUsuarios());

        u1.mostrarInfo();
        u2.mostrarInfo();
        u3.mostrarInfo();
    }
}
```

### 8.4 Métodos Estáticos

```java
public class UtilidadesRed {
    // Método estático: no necesita objeto para ejecutarse
    public static boolean validarIP(String ip) {
        String[] partes = ip.split("\\.");

        if (partes.length != 4) return false;

        try {
            for (String parte : partes) {
                int octeto = Integer.parseInt(parte);
                if (octeto < 0 || octeto > 255) return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validarMAC(String mac) {
        // Formato: XX:XX:XX:XX:XX:XX
        String regex = "^([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}$";
        return mac.matches(regex);
    }

    public static String normalizarIP(String ip) {
        // Eliminar espacios y convertir a minúsculas
        return ip.trim().toLowerCase();
    }
}
```

**Uso:**

```java
public class TestUtilidades {
    public static void main(String[] args) {
        // Llamar métodos estáticos directamente con el nombre de la clase
        // NO hace falta crear un objeto UtilidadesRed

        boolean validaIP1 = UtilidadesRed.validarIP("192.168.1.1");
        System.out.println("192.168.1.1 válida: " + validaIP1);  // true

        boolean validaIP2 = UtilidadesRed.validarIP("999.999.999.999");
        System.out.println("999.999.999.999 válida: " + validaIP2);  // false

        boolean validaMAC = UtilidadesRed.validarMAC("00:1B:44:11:3A:B7");
        System.out.println("MAC válida: " + validaMAC);  // true

        String ipNormalizada = UtilidadesRed.normalizarIP("  192.168.1.1  ");
        System.out.println("IP normalizada: '" + ipNormalizada + "'");
    }
}
```

### 8.5 Constantes: static final

```java
public class ConfiguracionRed {
    // Constantes: static + final
    // Por convención se escriben en MAYÚSCULAS
    public static final String MASCARA_CLASE_A = "255.0.0.0";
    public static final String MASCARA_CLASE_B = "255.255.0.0";
    public static final String MASCARA_CLASE_C = "255.255.255.0";

    public static final int PUERTO_HTTP = 80;
    public static final int PUERTO_HTTPS = 443;
    public static final int PUERTO_SSH = 22;
    public static final int PUERTO_FTP = 21;

    public static final int MAX_INTENTOS_LOGIN = 3;
    public static final int TIMEOUT_CONEXION = 30;  // segundos
}

// Uso:
if (puerto == ConfiguracionRed.PUERTO_HTTP) {
    System.out.println("Conexión HTTP detectada");
}

String mascara = ConfiguracionRed.MASCARA_CLASE_C;
```

### 8.6 Métodos Estáticos vs Métodos de Instancia

```java
public class Calculadora {
    // Variable de instancia
    private double resultado;

    // Método de INSTANCIA: opera sobre el estado del objeto
    public void sumar(double a, double b) {
        this.resultado = a + b;
    }

    public double getResultado() {
        return resultado;
    }

    // Método ESTÁTICO: no depende del estado del objeto
    // Es una utilidad independiente
    public static double sumarEstatico(double a, double b) {
        return a + b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }
}
```

**Uso:**

```java
public class TestCalculadora {
    public static void main(String[] args) {
        // Método estático: se llama con el nombre de la clase
        double suma = Calculadora.sumarEstatico(5, 3);
        System.out.println("Suma estática: " + suma);

        // Método de instancia: requiere crear un objeto
        Calculadora calc = new Calculadora();
        calc.sumar(5, 3);
        System.out.println("Resultado: " + calc.getResultado());
    }
}
```

### 8.7 Restricciones de los Métodos Estáticos

```java
public class Ejemplo {
    private int atributoInstancia = 10;
    private static int atributoEstatico = 20;

    // Método ESTÁTICO
    public static void metodoEstatico() {
        // ✓ PUEDE acceder a variables estáticas
        System.out.println(atributoEstatico);

        // ✗ NO PUEDE acceder a variables de instancia
        // System.out.println(atributoInstancia);  // ¡ERROR!

        // ✗ NO PUEDE usar 'this'
        // System.out.println(this.atributoInstancia);  // ¡ERROR!

        // ✓ PUEDE llamar a otros métodos estáticos
        otroMetodoEstatico();

        // ✗ NO PUEDE llamar a métodos de instancia directamente
        // metodoInstancia();  // ¡ERROR!
    }

    public static void otroMetodoEstatico() {
        System.out.println("Método estático");
    }

    // Método de INSTANCIA
    public void metodoInstancia() {
        // ✓ PUEDE acceder a TODO
        System.out.println(atributoInstancia);
        System.out.println(atributoEstatico);
        System.out.println(this.atributoInstancia);
        metodoEstatico();
        otroMetodoEstatico();
    }
}
```

### 8.8 Ejemplo Completo: Gestor de Licencias

```java
public class Licencia {
    // Variable estática: total de licencias emitidas
    private static int totalLicencias = 0;

    // Constantes
    public static final int MAX_LICENCIAS = 100;
    public static final int DURACION_DIAS = 365;

    // Variables de instancia
    private int numeroLicencia;
    private String producto;
    private String titular;
    private boolean activa;

    // Constructor
    public Licencia(String producto, String titular) {
        if (totalLicencias >= MAX_LICENCIAS) {
            throw new RuntimeException("✗ Límite de licencias alcanzado");
        }

        totalLicencias++;
        this.numeroLicencia = totalLicencias;
        this.producto = producto;
        this.titular = titular;
        this.activa = true;

        System.out.println("✓ Licencia #" + numeroLicencia + " emitida para " + titular);
    }

    // Métodos de instancia
    public void activar() {
        this.activa = true;
        System.out.println("Licencia #" + numeroLicencia + " activada");
    }

    public void desactivar() {
        this.activa = false;
        System.out.println("Licencia #" + numeroLicencia + " desactivada");
    }

    // Métodos estáticos
    public static int getTotalLicencias() {
        return totalLicencias;
    }

    public static int getLicenciasDisponibles() {
        return MAX_LICENCIAS - totalLicencias;
    }

    public static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DE LICENCIAS ===");
        System.out.println("Total emitidas: " + totalLicencias);
        System.out.println("Disponibles: " + getLicenciasDisponibles());
        System.out.println("Límite máximo: " + MAX_LICENCIAS);
        System.out.println("Duración: " + DURACION_DIAS + " días");
        System.out.println("=================================\n");
    }

    public void mostrarInfo() {
        System.out.println("Licencia #" + numeroLicencia);
        System.out.println("  Producto: " + producto);
        System.out.println("  Titular: " + titular);
        System.out.println("  Estado: " + (activa ? "Activa" : "Inactiva"));
    }
}
```

**Uso:**

```java
public class TestLicencia {
    public static void main(String[] args) {
        // Consultar estado inicial (sin crear objetos)
        Licencia.mostrarEstadisticas();

        // Crear licencias
        Licencia lic1 = new Licencia("Windows Server", "Empresa ABC");
        Licencia lic2 = new Licencia("SQL Server", "Empresa ABC");
        Licencia lic3 = new Licencia("Office 365", "Empresa XYZ");

        // Consultar total (método estático)
        System.out.println("\nLicencias emitidas: " + Licencia.getTotalLicencias());
        System.out.println("Licencias disponibles: " + Licencia.getLicenciasDisponibles());

        // Operar sobre licencias individuales
        lic1.mostrarInfo();
        lic2.desactivar();
        lic3.mostrarInfo();

        // Estadísticas finales
        Licencia.mostrarEstadisticas();
    }
}
```

### 8.9 Cuándo Usar static

**Usar static cuando:**

- ✓ El método no necesita acceder al estado del objeto (utilidades, conversiones)
- ✓ Quieres contar objetos o mantener información compartida
- ✓ Defines constantes (con `final`)
- ✓ Métodos de fábrica o validación

**NO usar static cuando:**

- ✗ El método necesita acceder a atributos de instancia
- ✗ El comportamiento varía según el objeto
- ✗ Necesitas polimorfismo (temas avanzados)

-----

## 9. Proyecto Integrador: Sistema de Gestión de Equipos Informáticos

### 9.1 Descripción del Proyecto

Crear un sistema completo de gestión de equipos informáticos que aplique todos los conceptos vistos en este módulo.

**Funcionalidades:**

1. Registrar diferentes tipos de equipos
1. Asignar equipos a usuarios
1. Controlar estados (disponible, asignado, en mantenimiento, dado de baja)
1. Generar informes y estadísticas
1. Validar datos de entrada

### 9.2 Clase EquipoInformatico

```java
/**
 * Clase que representa un equipo informático en el inventario
 * Aplica: Encapsulación, constructores, getters/setters, static
 */
public class EquipoInformatico {
    // Variables estáticas
    private static int contadorEquipos = 0;
    private static int equiposAsignados = 0;

    // Constantes
    public static final String ESTADO_DISPONIBLE = "DISPONIBLE";
    public static final String ESTADO_ASIGNADO = "ASIGNADO";
    public static final String ESTADO_MANTENIMIENTO = "MANTENIMIENTO";
    public static final String ESTADO_BAJA = "BAJA";

    // Atributos de instancia (privados - encapsulación)
    private int id;
    private String codigo;
    private String tipo;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private double precio;
    private String estado;
    private String usuarioAsignado;
    private String fechaAdquisicion;
    private String ubicacion;

    // Constructor completo
    public EquipoInformatico(String codigo, String tipo, String marca, String modelo,
                            String numeroSerie, double precio, String fechaAdquisicion) {
        contadorEquipos++;
        this.id = contadorEquipos;
        this.codigo = codigo;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        setPrecio(precio);  // Usar setter para validar
        this.estado = ESTADO_DISPONIBLE;
        this.fechaAdquisicion = fechaAdquisicion;
        this.usuarioAsignado = null;
        this.ubicacion = "Almacén";
    }

    // Constructor simplificado
    public EquipoInformatico(String codigo, String tipo, String marca, String modelo) {
        this(codigo, tipo, marca, modelo, "SIN-SERIE", 0.0, "2024-01-01");
    }

    // Métodos de gestión

    /**
     * Asigna el equipo a un usuario
     */
    public boolean asignar(String usuario, String ubicacion) {
        if (this.estado.equals(ESTADO_DISPONIBLE)) {
            this.estado = ESTADO_ASIGNADO;
            this.usuarioAsignado = usuario;
            this.ubicacion = ubicacion;
            equiposAsignados++;
            System.out.println("✓ Equipo " + codigo + " asignado a " + usuario);
            return true;
        } else {
            System.out.println("✗ El equipo no está disponible (Estado: " + estado + ")");
            return false;
        }
    }

    /**
     * Libera el equipo
     */
    public void liberar() {
        if (this.estado.equals(ESTADO_ASIGNADO)) {
            System.out.println("✓ Equipo " + codigo + " liberado (antes asignado a " +
                             usuarioAsignado + ")");
            this.estado = ESTADO_DISPONIBLE;
            this.usuarioAsignado = null;
            this.ubicacion = "Almacén";
            equiposAsignados--;
        } else {
            System.out.println("⚠ El equipo no estaba asignado");
        }
    }

    /**
     * Envía el equipo a mantenimiento
     */
    public void enviarAMantenimiento() {
        if (this.estado.equals(ESTADO_ASIGNADO)) {
            liberar();
        }
        this.estado = ESTADO_MANTENIMIENTO;
        this.ubicacion = "Servicio Técnico";
        System.out.println("✓ Equipo " + codigo + " en mantenimiento");
    }

    /**
     * Marca el equipo como reparado
     */
    public void marcarReparado() {
        if (this.estado.equals(ESTADO_MANTENIMIENTO)) {
            this.estado = ESTADO_DISPONIBLE;
            this.ubicacion = "Almacén";
            System.out.println("✓ Equipo " + codigo + " reparado y disponible");
        }
    }

    /**
     * Da de baja el equipo
     */
    public void darDeBaja() {
        if (this.estado.equals(ESTADO_ASIGNADO)) {
            equiposAsignados--;
        }
        this.estado = ESTADO_BAJA;
        this.usuarioAsignado = null;
        System.out.println("✓ Equipo " + codigo + " dado de baja");
    }

    // Getters (solo lectura para algunos atributos)
    public int getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getNumeroSerie() { return numeroSerie; }
    public double getPrecio() { return precio; }
    public String getEstado() { return estado; }
    public String getUsuarioAsignado() { return usuarioAsignado; }
    public String getFechaAdquisicion() { return fechaAdquisicion; }
    public String getUbicacion() { return ubicacion; }

    // Setters con validación
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("⚠ Precio inválido, se asignará 0");
            this.precio = 0;
        }
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Métodos estáticos
    public static int getTotalEquipos() {
        return contadorEquipos;
    }

    public static int getEquiposAsignados() {
        return equiposAsignados;
    }

    public static int getEquiposDisponibles() {
        return contadorEquipos - equiposAsignados;
    }

    public static void mostrarEstadisticas() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║   ESTADÍSTICAS DEL INVENTARIO        ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.printf("║ Total de equipos:        %-12d║%n", contadorEquipos);
        System.out.printf("║ Equipos asignados:       %-12d║%n", equiposAsignados);
        System.out.printf("║ Equipos disponibles:     %-12d║%n", getEquiposDisponibles());
        System.out.println("╚═══════════════════════════════════════╝\n");
    }

    // toString() mejorado
    @Override
    public String toString() {
        return String.format("%-5d %-12s %-15s %-15s %-20s %-15s %8.2f€ %15s",
            id, codigo, tipo, marca + " " + modelo, ubicacion, estado, precio,
            usuarioAsignado != null ? usuarioAsignado : "-");
    }

    /**
     * Muestra información detallada del equipo
     */
    public void mostrarInfoDetallada() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    INFORMACIÓN DEL EQUIPO                     ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.printf("║ ID:              %-44d║%n", id);
        System.out.printf("║ Código:          %-44s║%n", codigo);
        System.out.printf("║ Tipo:            %-44s║%n", tipo);
        System.out.printf("║ Marca/Modelo:    %-44s║%n", marca + " " + modelo);
        System.out.printf("║ Número de Serie: %-44s║%n", numeroSerie);
        System.out.printf("║ Precio:          %-44s║%n", String.format("%.2f€", precio));
        System.out.printf("║ Estado:          %-44s║%n", estado);
        System.out.printf("║ Ubicación:       %-44s║%n", ubicacion);
        System.out.printf("║ Asignado a:      %-44s║%n",
                         usuarioAsignado != null ? usuarioAsignado : "No asignado");
        System.out.printf("║ Fecha Adq.:      %-44s║%n", fechaAdquisicion);
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
    }
}
```

### 9.3 Clase SistemaGestionEquipos

```java
import java.util.ArrayList;
import java.util.List;

/**
 * Sistema principal de gestión de equipos
 */
public class SistemaGestionEquipos {
    private List<EquipoInformatico> equipos;
    private String nombreEmpresa;

    public SistemaGestionEquipos(String nombreEmpresa) {
        this.equipos = new ArrayList<>();
        this.nombreEmpresa = nombreEmpresa;
        System.out.println("═════════════════════════════════════════");
        System.out.println("  SISTEMA DE GESTIÓN DE EQUIPOS");
        System.out.println("  " + nombreEmpresa);
        System.out.println("═════════════════════════════════════════\n");
    }

    /**
     * Agrega un equipo al inventario
     */
    public void agregarEquipo(EquipoInformatico equipo) {
        equipos.add(equipo);
        System.out.println("✓ Equipo agregado al inventario: " + equipo.getCodigo());
    }

    /**
     * Busca un equipo por código
     */
    public EquipoInformatico buscarPorCodigo(String codigo) {
        for (EquipoInformatico eq : equipos) {
            if (eq.getCodigo().equalsIgnoreCase(codigo)) {
                return eq;
            }
        }
        return null;
    }

    /**
     * Lista todos los equipos
     */
    public void listarTodos() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                          INVENTARIO COMPLETO");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-5s %-12s %-15s %-15s %-20s %-15s %10s %15s%n",
            "ID", "CÓDIGO", "TIPO", "MARCA/MODELO", "UBICACIÓN", "ESTADO", "PRECIO", "ASIGNADO A");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────");

        for (EquipoInformatico eq : equipos) {
            System.out.println(eq);
        }

        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Total de equipos: " + equipos.size());
        System.out.println();
    }

    /**
     * Lista equipos por estado
     */
    public void listarPorEstado(String estado) {
        System.out.println("\n═══ EQUIPOS EN ESTADO: " + estado + " ═══");

        int contador = 0;
        for (EquipoInformatico eq : equipos) {
            if (eq.getEstado().equals(estado)) {
                System.out.printf("%d. %s - %s %s [%s]%n",
                    ++contador,
                    eq.getCodigo(),
                    eq.getMarca(),
                    eq.getModelo(),
                    eq.getUbicacion()
                );
            }
        }

        if (contador == 0) {
            System.out.println("No hay equipos en este estado");
        } else {
            System.out.println("\nTotal: " + contador + " equipos");
        }
        System.out.println();
    }

    /**
     * Lista equipos asignados a un usuario
     */
    public void listarPorUsuario(String usuario) {
        System.out.println("\n═══ EQUIPOS ASIGNADOS A: " + usuario + " ═══");

        int contador = 0;
        for (EquipoInformatico eq : equipos) {
            if (usuario.equals(eq.getUsuarioAsignado())) {
                System.out.printf("%d. %s - %s %s [%s]%n",
                    ++contador,
                    eq.getCodigo(),
                    eq.getMarca(),
                    eq.getModelo(),
                    eq.getTipo()
                );
            }
        }

        if (contador == 0) {
            System.out.println("Este usuario no tiene equipos asignados");
        } else {
            System.out.println("\nTotal: " + contador + " equipos");
        }
        System.out.println();
    }

    /**
     * Calcula el valor total del inventario
     */
    public double calcularValorTotal() {
        double total = 0;
        for (EquipoInformatico eq : equipos) {
            if (!eq.getEstado().equals(EquipoInformatico.ESTADO_BAJA)) {
                total += eq.getPrecio();
            }
        }
        return total;
    }

    /**
     * Genera reporte completo
     */
    public void generarReporte() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                    REPORTE COMPLETO                       ║");
        System.out.println("╠═══════════════════════════════════════════════════════════╣");
        System.out.printf("║ Empresa:              %-35s║%n", nombreEmpresa);
        System.out.printf("║ Total de equipos:     %-35d║%n", EquipoInformatico.getTotalEquipos());
        System.out.printf("║ Equipos asignados:    %-35d║%n", EquipoInformatico.getEquiposAsignados());
        System.out.printf("║ Equipos disponibles:  %-35d║%n", EquipoInformatico.getEquiposDisponibles());
        System.out.printf("║ Valor total:          %-35s║%n",
                         String.format("%.2f€", calcularValorTotal()));
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");

        // Desglose por tipo
        System.out.println("Desglose por tipo:");
        contarPorTipo();
    }

    private void contarPorTipo() {
        String[] tipos = {"PC", "Portátil", "Servidor", "Monitor", "Impresora", "Switch", "Router"};

        for (String tipo : tipos) {
            int contador = 0;
            for (EquipoInformatico eq : equipos) {
                if (eq.getTipo().equalsIgnoreCase(tipo)) {
                    contador++;
                }
            }
            if (contador > 0) {
                System.out.printf("  - %-15s: %d%n", tipo, contador);
            }
        }
        System.out.println();
    }
}
```

### 9.4 Programa Principal

```java
/**
 * Programa principal que demuestra el uso del sistema
 */
public class ProgramaPrincipal {
    public static void main(String[] args) {
        // Crear sistema de gestión
        SistemaGestionEquipos sistema = new SistemaGestionEquipos("EMPRESA TECH S.L.");

        // Crear y agregar equipos
        System.out.println("═══ AGREGANDO EQUIPOS AL INVENTARIO ═══\n");

        EquipoInformatico eq1 = new EquipoInformatico(
            "PC-001", "PC", "Dell", "OptiPlex 7090",
            "SN12345", 899.99, "2024-01-15"
        );
        sistema.agregarEquipo(eq1);

        EquipoInformatico eq2 = new EquipoInformatico(
            "PORT-001", "Portátil", "HP", "EliteBook 840",
            "SN67890", 1299.99, "2024-02-20"
        );
        sistema.agregarEquipo(eq2);

        EquipoInformatico eq3 = new EquipoInformatico(
            "SRV-001", "Servidor", "Dell", "PowerEdge R740",
            "SN11223", 3499.99, "2024-01-10"
        );
        sistema.agregarEquipo(eq3);

        EquipoInformatico eq4 = new EquipoInformatico(
            "PC-002", "PC", "HP", "EliteDesk 800"
        );
        eq4.setPrecio(749.99);
        sistema.agregarEquipo(eq4);

        EquipoInformatico eq5 = new EquipoInformatico(
            "IMP-001", "Impresora", "Canon", "ImageClass",
            "SN44556", 399.99, "2024-03-01"
        );
        sistema.agregarEquipo(eq5);

        // Mostrar estadísticas iniciales
        EquipoInformatico.mostrarEstadisticas();

        // Listar todos los equipos
        sistema.listarTodos();

        // Asignar equipos
        System.out.println("\n═══ ASIGNANDO EQUIPOS ═══\n");
        eq1.asignar("Juan García", "Oficina 201");
        eq2.asignar("María López", "Oficina 305");
        eq3.asignar("Departamento IT", "Sala Servidores");

        // Listar equipos asignados a un usuario
        sistema.listarPorUsuario("Juan García");

        // Enviar un equipo a mantenimiento
        System.out.println("═══ GESTIÓN DE MANTENIMIENTO ═══\n");
        eq4.enviarAMantenimiento();

        // Listar por estado
        sistema.listarPorEstado(EquipoInformatico.ESTADO_DISPONIBLE);
        sistema.listarPorEstado(EquipoInformatico.ESTADO_MANTENIMIENTO);

        // Mostrar información detallada de un equipo
        eq2.mostrarInfoDetallada();

        // Reparar equipo
        eq4.marcarReparado();

        // Dar de baja un equipo
        eq5.darDeBaja();

        // Generar reporte final
        sistema.generarReporte();

        // Estadísticas finales
        EquipoInformatico.mostrarEstadisticas();

        // Buscar equipo
        System.out.println("═══ BÚSQUEDA DE EQUIPO ═══\n");
        String codigoBuscar = "PC-001";
        EquipoInformatico encontrado = sistema.buscarPorCodigo(codigoBuscar);
        if (encontrado != null) {
            encontrado.mostrarInfoDetallada();
        } else {
            System.out.println("Equipo no encontrado: " + codigoBuscar);
        }
    }
}
```

-----

## Resumen del Módulo 6

### Conceptos Clave Aprendidos

✓ **Programación Orientada a Objetos**

- Paradigma que organiza código en objetos
- Pilares: Encapsulación, Abstracción, Herencia, Polimorfismo

✓ **Clases y Objetos**

- Clase = molde o plantilla
- Objeto = instancia concreta de una clase
- Cada objeto tiene su propio estado

✓ **Atributos y Métodos de Instancia**

- Atributos: variables que pertenecen a cada objeto
- Métodos: funciones que operan sobre el objeto

✓ **Constructores**

- Método especial que inicializa objetos
- Sobrecarga: múltiples constructores con diferentes parámetros
- Llamada entre constructores con `this()`

✓ **Encapsulación**

- Ocultar detalles internos
- `private`: solo accesible en la clase
- `public`: accesible desde cualquier lugar

✓ **Getters y Setters**

- Métodos para acceder y modificar atributos privados
- Permiten validación y control de acceso

✓ **Palabra Clave ‘this’**

- Referencia al objeto actual
- Diferencia atributos de parámetros
- Permite llamar a otros constructores
- Útil para method chaining

✓ **static**

- Variables estáticas: compartidas por todos los objetos
- Métodos estáticos: no requieren objeto para ejecutarse
- Constantes: `static final`
- Útil para contadores, utilidades, configuración

### Habilidades Desarrolladas

✓ Diseñar clases con encapsulación apropiada
✓ Crear constructores sobrecargados
✓ Implementar getters y setters con validación
✓ Usar `this` correctamente
✓ Aplicar miembros estáticos cuando corresponda
✓ Desarrollar sistemas orientados a objetos para ASIR

### Proyecto Completado

✓ Sistema de Gestión de Equipos Informáticos

- Modelo completo de equipo con encapsulación
- Gestión de estados y asignaciones
- Estadísticas con variables estáticas
- Validación de datos
- Reportes y búsquedas

-----

**¡Módulo 6 Completado!**

*Estás listo para pasar al Módulo 7: Herencia y Polimorfismo*

<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>
