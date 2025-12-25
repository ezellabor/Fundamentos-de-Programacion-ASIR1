<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>
# MÓDULO 5: MÉTODOS Y FUNCIONES

## 1. Definición y declaración de métodos

### ¿Qué es un método?

Un método es un bloque de código que realiza una tarea específica y puede ser reutilizado. Los métodos permiten:

- **Reutilizar código:** Escribir una vez, usar muchas veces
- **Organizar código:** Dividir programas complejos en partes más pequeñas
- **Facilitar mantenimiento:** Cambios en un solo lugar
- **Mejorar legibilidad:** Código más claro y comprensible

### Analogía

Piensa en un método como una función en una calculadora. Cuando presionas “√” (raíz cuadrada), la calculadora:

1. Recibe un número (entrada/parámetro)
1. Realiza un cálculo (procesamiento)
1. Devuelve el resultado (salida/retorno)

### Sintaxis básica de un método

```java
modificadorAcceso tipoRetorno nombreMetodo(parámetros) {
    // Cuerpo del método
    // Código a ejecutar
    return valor; // Si el método devuelve algo
}
```

**Componentes:**

- **Modificador de acceso:** `public`, `private`, `protected` (lo veremos más adelante)
- **Tipo de retorno:** Tipo de dato que devuelve el método (`int`, `String`, `void`, etc.)
- **Nombre del método:** Identificador en camelCase
- **Parámetros:** Datos de entrada (opcionales)
- **Cuerpo:** Código que se ejecuta
- **return:** Devuelve un valor (obligatorio si no es `void`)

### Primer ejemplo: Método simple

```java
public class EjemploMetodos {

    // Método sin parámetros y sin retorno
    public static void saludar() {
        System.out.println("¡Hola desde un método!");
    }

    public static void main(String[] args) {
        saludar();  // Llamar al método
        saludar();  // Llamar nuevamente
    }
}

// Salida:
// ¡Hola desde un método!
// ¡Hola desde un método!
```

### Métodos con diferentes tipos de retorno

```java
public class TiposRetorno {

    // Método que retorna un entero
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Método que retorna un double
    public static double calcularPromedio(double num1, double num2) {
        return (num1 + num2) / 2.0;
    }

    // Método que retorna un String
    public static String obtenerEstado(int puerto) {
        if (puerto < 1024) {
            return "Puerto del sistema";
        } else {
            return "Puerto de usuario";
        }
    }

    // Método que retorna un boolean
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // Método sin retorno (void)
    public static void mostrarMensaje(String mensaje) {
        System.out.println("Mensaje: " + mensaje);
    }

    public static void main(String[] args) {
        int resultado = sumar(10, 5);
        System.out.println("Suma: " + resultado);

        double promedio = calcularPromedio(8.5, 9.0);
        System.out.println("Promedio: " + promedio);

        String estado = obtenerEstado(80);
        System.out.println(estado);

        boolean par = esPar(10);
        System.out.println("¿Es par?: " + par);

        mostrarMensaje("Hola Mundo");
    }
}
```

### Convenciones de nomenclatura

```java
// ✅ BIEN: camelCase, verbo + sustantivo
public static void iniciarServicio() { }
public static int calcularTotal() { }
public static boolean validarDatos() { }
public static String obtenerNombre() { }

// ❌ MAL: No usar camelCase, no descriptivo
public static void IniciarServicio() { }  // Primera letra mayúscula
public static int calc() { }              // No descriptivo
public static boolean x() { }             // Nombre sin significado
```

## 2. Parámetros y argumentos

### Diferencia entre parámetros y argumentos

- **Parámetros:** Variables en la definición del método
- **Argumentos:** Valores reales pasados al llamar al método

```java
// 'numero' es un PARÁMETRO
public static boolean esPar(int numero) {
    return numero % 2 == 0;
}

public static void main(String[] args) {
    boolean resultado = esPar(10);  // '10' es un ARGUMENTO
}
```

### Métodos sin parámetros

```java
public static void mostrarFecha() {
    System.out.println("Fecha actual: 24/12/2025");
}

public static void main(String[] args) {
    mostrarFecha();  // No requiere argumentos
}
```

### Métodos con un parámetro

```java
public static void saludar(String nombre) {
    System.out.println("Hola, " + nombre);
}

public static void main(String[] args) {
    saludar("Ana");     // Hola, Ana
    saludar("Carlos");  // Hola, Carlos
}
```

### Métodos con múltiples parámetros

```java
public static double calcularArea(double base, double altura) {
    return (base * altura) / 2.0;
}

public static void mostrarServidor(String nombre, String ip, int puerto) {
    System.out.println("Servidor: " + nombre);
    System.out.println("IP: " + ip);
    System.out.println("Puerto: " + puerto);
}

public static void main(String[] args) {
    double area = calcularArea(10.0, 5.0);
    System.out.println("Área: " + area);

    mostrarServidor("web-01", "192.168.1.10", 80);
}
```

### Paso por valor

En Java, los tipos primitivos se pasan **por valor**, lo que significa que se pasa una copia del valor, no la variable original.

```java
public static void modificarNumero(int numero) {
    numero = 100;  // Solo modifica la copia
    System.out.println("Dentro del método: " + numero);
}

public static void main(String[] args) {
    int x = 10;
    System.out.println("Antes: " + x);
    modificarNumero(x);
    System.out.println("Después: " + x);  // x sigue siendo 10
}

// Salida:
// Antes: 10
// Dentro del método: 100
// Después: 10
```

### Ejemplo práctico: Calculadora de red

```java
public class CalculadoraRed {

    // Calcular número de hosts en una subred
    public static int calcularHosts(int cidr) {
        return (int) Math.pow(2, 32 - cidr) - 2;
    }

    // Determinar clase de IP
    public static String determinarClase(String ip) {
        String primerOcteto = ip.split("\\.")[0];
        int primer = Integer.parseInt(primerOcteto);

        if (primer >= 1 && primer <= 126) {
            return "Clase A";
        } else if (primer >= 128 && primer <= 191) {
            return "Clase B";
        } else if (primer >= 192 && primer <= 223) {
            return "Clase C";
        } else {
            return "Especial";
        }
    }

    // Validar si es IP privada
    public static boolean esIPPrivada(String ip) {
        String[] octetos = ip.split("\\.");
        int primero = Integer.parseInt(octetos[0]);
        int segundo = Integer.parseInt(octetos[1]);

        // 10.0.0.0 - 10.255.255.255
        if (primero == 10) {
            return true;
        }

        // 172.16.0.0 - 172.31.255.255
        if (primero == 172 && segundo >= 16 && segundo <= 31) {
            return true;
        }

        // 192.168.0.0 - 192.168.255.255
        if (primero == 192 && segundo == 168) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Calcular hosts
        int hosts = calcularHosts(24);
        System.out.println("Hosts en /24: " + hosts);

        // Determinar clase
        String clase = determinarClase("192.168.1.10");
        System.out.println("Clase: " + clase);

        // Verificar si es privada
        boolean privada = esIPPrivada("192.168.1.10");
        System.out.println("¿Es privada?: " + privada);
    }
}
```

## 3. Valor de retorno

### Métodos void (sin retorno)

Los métodos `void` no devuelven ningún valor. Se usan para realizar acciones sin necesidad de devolver un resultado.

```java
public static void imprimirLinea() {
    System.out.println("-".repeat(50));
}

public static void mostrarAlerta(String mensaje) {
    System.out.println("⚠️  ALERTA: " + mensaje);
}

public static void registrarLog(String evento) {
    System.out.println("[LOG] " + evento);
}
```

### Métodos con retorno

Los métodos con retorno deben especificar el tipo de dato que devuelven y usar la palabra clave `return`.

```java
// Retorna int
public static int multiplicar(int a, int b) {
    return a * b;
}

// Retorna double
public static double dividir(double a, double b) {
    if (b == 0) {
        return 0.0;  // Evitar división por cero
    }
    return a / b;
}

// Retorna String
public static String obtenerDiaSemana(int dia) {
    switch (dia) {
        case 1: return "Lunes";
        case 2: return "Martes";
        case 3: return "Miércoles";
        case 4: return "Jueves";
        case 5: return "Viernes";
        case 6: return "Sábado";
        case 7: return "Domingo";
        default: return "Inválido";
    }
}

// Retorna boolean
public static boolean esPuertoValido(int puerto) {
    return puerto >= 1 && puerto <= 65535;
}
```

### Múltiples puntos de retorno

Un método puede tener varios `return`, pero solo se ejecuta uno:

```java
public static String evaluarNota(int nota) {
    if (nota >= 90) {
        return "Excelente";
    } else if (nota >= 70) {
        return "Bueno";
    } else if (nota >= 50) {
        return "Aprobado";
    } else {
        return "Reprobado";
    }
    // No necesitamos más código después de los returns
}

// Versión simplificada con return temprano
public static String validarPassword(String password) {
    if (password == null || password.isEmpty()) {
        return "Password vacía";
    }

    if (password.length() < 8) {
        return "Password muy corta";
    }

    if (!password.matches(".*[A-Z].*")) {
        return "Debe contener mayúsculas";
    }

    return "Password válida";
}
```

### Guardar y usar valores de retorno

```java
public static int sumar(int a, int b) {
    return a + b;
}

public static void main(String[] args) {
    // Guardar el resultado en una variable
    int resultado = sumar(10, 5);
    System.out.println(resultado);

    // Usar directamente en una expresión
    int total = sumar(5, 3) + sumar(2, 8);
    System.out.println(total);  // 18

    // Usar en condiciones
    if (sumar(10, 10) > 15) {
        System.out.println("La suma es mayor que 15");
    }

    // Pasar como argumento a otro método
    System.out.println("Resultado: " + sumar(7, 3));
}
```

### Ejemplo práctico: Validador de configuración

```java
public class ValidadorConfiguracion {

    // Validar puerto
    public static boolean validarPuerto(int puerto) {
        return puerto >= 1 && puerto <= 65535;
    }

    // Validar IP (simplificado)
    public static boolean validarIP(String ip) {
        String[] octetos = ip.split("\\.");

        if (octetos.length != 4) {
            return false;
        }

        for (String octeto : octetos) {
            try {
                int num = Integer.parseInt(octeto);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    // Validar timeout
    public static boolean validarTimeout(int timeout) {
        return timeout > 0 && timeout <= 300000;  // Máximo 5 minutos
    }

    // Método principal que valida toda la configuración
    public static String validarConfiguracion(String ip, int puerto, int timeout) {
        if (!validarIP(ip)) {
            return "❌ IP inválida";
        }

        if (!validarPuerto(puerto)) {
            return "❌ Puerto inválido (debe estar entre 1 y 65535)";
        }

        if (!validarTimeout(timeout)) {
            return "❌ Timeout inválido (debe estar entre 1 y 300000 ms)";
        }

        return "✅ Configuración válida";
    }

    public static void main(String[] args) {
        // Probar diferentes configuraciones
        System.out.println(validarConfiguracion("192.168.1.10", 80, 5000));
        System.out.println(validarConfiguracion("192.168.1.256", 80, 5000));
        System.out.println(validarConfiguracion("192.168.1.10", 70000, 5000));
        System.out.println(validarConfiguracion("192.168.1.10", 80, 400000));
    }
}
```

## 4. Sobrecarga de métodos

### ¿Qué es la sobrecarga?

La sobrecarga (overloading) permite tener varios métodos con el mismo nombre pero con diferentes parámetros. Java distingue los métodos por:

- Número de parámetros
- Tipo de parámetros
- Orden de los parámetros

**No se puede sobrecargar solo por:**

- Tipo de retorno diferente
- Nombre de parámetros diferente

### Sobrecarga por número de parámetros

```java
public class Calculadora {

    // Sumar dos números
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Sumar tres números
    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Sumar cuatro números
    public static int sumar(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public static void main(String[] args) {
        System.out.println(sumar(5, 3));          // 8
        System.out.println(sumar(5, 3, 2));       // 10
        System.out.println(sumar(5, 3, 2, 1));    // 11
    }
}
```

### Sobrecarga por tipo de parámetros

```java
public class CalculadoraAvanzada {

    // Multiplicar enteros
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    // Multiplicar decimales
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    // Multiplicar un entero por un decimal
    public static double multiplicar(int a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        System.out.println(multiplicar(5, 3));        // 15 (int)
        System.out.println(multiplicar(5.5, 2.0));    // 11.0 (double)
        System.out.println(multiplicar(5, 2.5));      // 12.5 (mixed)
    }
}
```

### Sobrecarga práctica: Formatear datos

```java
public class FormateadorDatos {

    // Formatear servidor con solo nombre
    public static void mostrarServidor(String nombre) {
        System.out.println("Servidor: " + nombre);
    }

    // Formatear servidor con nombre e IP
    public static void mostrarServidor(String nombre, String ip) {
        System.out.println("Servidor: " + nombre);
        System.out.println("IP: " + ip);
    }

    // Formatear servidor con nombre, IP y puerto
    public static void mostrarServidor(String nombre, String ip, int puerto) {
        System.out.println("Servidor: " + nombre);
        System.out.println("IP: " + ip);
        System.out.println("Puerto: " + puerto);
    }

    // Formatear servidor completo con estado
    public static void mostrarServidor(String nombre, String ip, int puerto, boolean activo) {
        System.out.println("Servidor: " + nombre);
        System.out.println("IP: " + ip);
        System.out.println("Puerto: " + puerto);
        System.out.println("Estado: " + (activo ? "🟢 Activo" : "🔴 Inactivo"));
    }

    public static void main(String[] args) {
        System.out.println("--- Versión simple ---");
        mostrarServidor("web-01");

        System.out.println("\n--- Con IP ---");
        mostrarServidor("web-02", "192.168.1.10");

        System.out.println("\n--- Con puerto ---");
        mostrarServidor("db-01", "192.168.1.20", 3306);

        System.out.println("\n--- Completo ---");
        mostrarServidor("cache-01", "192.168.1.30", 6379, true);
    }
}
```

### Ventajas de la sobrecarga

1. **Flexibilidad:** Llamar al método con diferentes combinaciones de datos
1. **Legibilidad:** Mismo nombre para operaciones similares
1. **Simplicidad:** No necesitas recordar múltiples nombres de métodos

### Ejemplo completo: Registro de eventos

```java
public class RegistroEventos {

    // Registro simple
    public static void registrar(String evento) {
        System.out.println("[LOG] " + evento);
    }

    // Registro con nivel
    public static void registrar(String nivel, String evento) {
        System.out.println("[" + nivel + "] " + evento);
    }

    // Registro con nivel y timestamp
    public static void registrar(String nivel, String evento, long timestamp) {
        System.out.println("[" + nivel + "] [" + timestamp + "] " + evento);
    }

    // Registro con nivel, usuario y evento
    public static void registrar(String nivel, String usuario, String evento) {
        System.out.println("[" + nivel + "] Usuario: " + usuario + " - " + evento);
    }

    public static void main(String[] args) {
        registrar("Sistema iniciado");
        registrar("INFO", "Usuario conectado");
        registrar("ERROR", "Fallo de conexión", System.currentTimeMillis());
        registrar("WARNING", "admin", "Intento de acceso a archivo protegido");
    }
}
```

## 5. Ámbito de variables

### ¿Qué es el ámbito (scope)?

El ámbito de una variable determina dónde puede ser accedida en el código. Hay tres tipos principales:

1. **Variables locales:** Dentro de un método
1. **Parámetros:** Dentro del método donde se declaran
1. **Variables de clase (estáticas):** Accesibles por todos los métodos de la clase

### Variables locales

Las variables declaradas dentro de un método solo existen en ese método:

```java
public class EjemploAmbito {

    public static void metodo1() {
        int x = 10;  // Variable local de metodo1
        System.out.println("metodo1 - x: " + x);
    }

    public static void metodo2() {
        int x = 20;  // Variable local diferente de metodo2
        System.out.println("metodo2 - x: " + x);

        // No podemos acceder a la 'x' de metodo1
    }

    public static void main(String[] args) {
        metodo1();  // Imprime: metodo1 - x: 10
        metodo2();  // Imprime: metodo2 - x: 20
    }
}
```

### Ámbito de bloque

Las variables declaradas en un bloque (if, for, while) solo existen dentro de ese bloque:

```java
public static void ejemploBloque() {
    int x = 10;

    if (x > 5) {
        int y = 20;  // 'y' solo existe dentro del if
        System.out.println("x: " + x);  // OK
        System.out.println("y: " + y);  // OK
    }

    System.out.println("x: " + x);  // OK
    // System.out.println("y: " + y);  // ❌ ERROR: 'y' no existe aquí
}

public static void ejemploFor() {
    for (int i = 0; i < 5; i++) {
        int temp = i * 2;
        System.out.println(temp);
    }

    // System.out.println(i);     // ❌ ERROR: 'i' no existe aquí
    // System.out.println(temp);  // ❌ ERROR: 'temp' no existe aquí
}
```

### Variables de clase (estáticas)

Las variables declaradas con `static` fuera de los métodos son accesibles por todos los métodos de la clase:

```java
public class Contador {
    // Variable de clase (estática)
    static int contadorGlobal = 0;

    public static void incrementar() {
        contadorGlobal++;
    }

    public static void mostrar() {
        System.out.println("Contador: " + contadorGlobal);
    }

    public static void main(String[] args) {
        mostrar();      // 0
        incrementar();
        mostrar();      // 1
        incrementar();
        mostrar();      // 2
    }
}
```

### Ejemplo práctico: Sistema de logs con contador

```java
public class SistemaLogs {
    // Variables de clase
    static int totalLogs = 0;
    static int errores = 0;
    static int advertencias = 0;

    public static void registrarInfo(String mensaje) {
        totalLogs++;
        System.out.println("[INFO] " + mensaje);
    }

    public static void registrarError(String mensaje) {
        totalLogs++;
        errores++;
        System.out.println("[ERROR] " + mensaje);
    }

    public static void registrarAdvertencia(String mensaje) {
        totalLogs++;
        advertencias++;
        System.out.println("[WARNING] " + mensaje);
    }

    public static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de logs: " + totalLogs);
        System.out.println("Errores: " + errores);
        System.out.println("Advertencias: " + advertencias);
        System.out.println("Info: " + (totalLogs - errores - advertencias));
    }

    public static void main(String[] args) {
        registrarInfo("Sistema iniciado");
        registrarError("Conexión perdida");
        registrarAdvertencia("Memoria al 85%");
        registrarInfo("Usuario admin login");
        registrarError("Timeout en servicio");

        mostrarEstadisticas();
    }
}
```

### Sombreado de variables (shadowing)

Cuando una variable local tiene el mismo nombre que una variable de clase:

```java
public class EjemploShadowing {
    static int x = 100;  // Variable de clase

    public static void metodo() {
        int x = 10;  // Variable local "sombrea" a la de clase
        System.out.println("Variable local: " + x);  // 10
        System.out.println("Variable de clase: " + EjemploShadowing.x);  // 100
    }

    public static void main(String[] args) {
        System.out.println("Variable de clase: " + x);  // 100
        metodo();
    }
}
```

## 6. Métodos recursivos

### ¿Qué es la recursión?

La recursión es cuando un método se llama a sí mismo. Es útil para resolver problemas que pueden dividirse en subproblemas más pequeños del mismo tipo.

**Componentes esenciales:**

1. **Caso base:** Condición que detiene la recursión
1. **Caso recursivo:** Llamada al propio método con un problema más pequeño

### Ejemplo básico: Cuenta regresiva

```java
public class Recursion {

    public static void cuentaRegresiva(int numero) {
        // Caso base: detener cuando llegue a 0
        if (numero == 0) {
            System.out.println("¡Despegue!");
            return;
        }

        // Caso recursivo
        System.out.println(numero);
        cuentaRegresiva(numero - 1);  // Llamada recursiva
    }

    public static void main(String[] args) {
        cuentaRegresiva(5);
    }
}

// Salida:
// 5
// 4
// 3
// 2
// 1
// ¡Despegue!
```

### Factorial: Ejemplo clásico

El factorial de n (n!) es: n × (n-1) × (n-2) × … × 1

```java
public static int factorial(int n) {
    // Caso base
    if (n == 0 || n == 1) {
        return 1;
    }

    // Caso recursivo
    return n * factorial(n - 1);
}

public static void main(String[] args) {
    System.out.println("5! = " + factorial(5));  // 120
    System.out.println("3! = " + factorial(3));  // 6
}

// Ejecución de factorial(5):
// factorial(5) = 5 * factorial(4)
//              = 5 * (4 * factorial(3))
//              = 5 * (4 * (3 * factorial(2)))
//              = 5 * (4 * (3 * (2 * factorial(1))))
//              = 5 * (4 * (3 * (2 * 1)))
//              = 120
```

### Suma de números: Recursión vs Iteración

**Versión recursiva:**

```java
public static int sumaRecursiva(int n) {
    if (n == 1) {
        return 1;
    }
    return n + sumaRecursiva(n - 1);
}
```

**Versión iterativa (con bucle):**

```java
public static int sumaIterativa(int n) {
    int suma = 0;
    for (int i = 1; i <= n; i++) {
        suma += i;
    }
    return suma;
}
```

### Fibonacci: Ejemplo de recursión múltiple

La secuencia de Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21…

```java
public static int fibonacci(int n) {
    // Casos base
    if (n == 0) {
        return 0;
    }
    if (n == 1) {
        return 1;
    }

    // Caso recursivo: dos llamadas recursivas
    return fibonacci(n - 1) + fibonacci(n - 2);
}

public static void main(String[] args) {
    System.out.println("Secuencia de Fibonacci:");
    for (int i = 0; i < 10; i++) {
        System.out.print(fibonacci(i) + " ");
    }
    // Salida: 0 1 1 2 3 5 8 13 21 34
}
```

### Ejemplo práctico: Búsqueda recursiva en directorios

```java
public class BusquedaRecursiva {

    // Simular búsqueda de archivos en directorios
    public static void buscarArchivos(String directorio, int nivel) {
        // Caso base: nivel máximo de profundidad
        if (nivel > 3) {
            return;
        }

        // Simular archivos en el directorio
        String[] archivos = {"file1.txt", "file2.log", "subdir1", "subdir2"};

        // Mostrar contenido con indentación según nivel
        String indentacion = "  ".repeat(nivel);
        System.out.println(indentacion + directorio + "/");

        for (String archivo : archivos) {
            System.out.println(indentacion + "  - " + archivo);

            // Si es un subdirectorio, buscar recursivamente
            if (archivo.startsWith("subdir")) {
                buscarArchivos(directorio + "/" + archivo, nivel + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=
```

