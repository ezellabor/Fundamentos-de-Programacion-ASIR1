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

## 7. Métodos estáticos
### ¿Qué significa static? 
✅ Por qué main es static - Razón fundamental
✅ Métodos estáticos vs no estáticos - Comparación completa
✅ Reglas importantes - Qué pueden y no pueden hacer
✅ Utilidades de métodos static - 3 casos de uso principales
✅ Contadores y datos compartidos - Ejemplo con servidores
✅ Factory methods - Patrón de diseño
✅ Clase Math - Ejemplos completos con más métodos
✅ Variables static - Cómo se comparten
✅ Constantes static final - Buenas prácticas
✅ Ejemplo completo - HerramientasRed ampliado con muchas funciones
✅ Cuándo usar y cuándo no - Guía práctica

## 7. Métodos Estáticos

### 7.1 Introducción a los Métodos Estáticos

Los **métodos estáticos** son métodos que pertenecen a la **clase** en lugar de a instancias individuales de la clase. Se declaran usando la palabra clave `static`.

**Características principales:**

- No requieren crear un objeto para ser ejecutados
- Se acceden usando el nombre de la clase: `NombreClase.metodoEstatico()`
- No pueden acceder a variables de instancia (no estáticas)
- No pueden usar la palabra clave `this`
- Son útiles para operaciones que no dependen del estado de un objeto

**Sintaxis:**

```java
public static tipoRetorno nombreMetodo(parametros) {
    // código del método
}
```

### 7.2 ¿Cuándo Usar Métodos Estáticos?

✓ **Usar métodos estáticos cuando:**

- El método realiza una operación que no depende del estado del objeto
- Son funciones de utilidad (conversiones, validaciones, cálculos)
- Son operaciones matemáticas o de transformación de datos
- Implementan el patrón Factory (creación de objetos)
- Son métodos de configuración global

✗ **NO usar métodos estáticos cuando:**

- El método necesita acceder a variables de instancia
- Requiere comportamiento diferente según el objeto
- Necesitas polimorfismo (sobreescritura en subclases)

### 7.3 Ejemplo Básico: Calculadora

```java
/**
 * Clase con métodos estáticos de utilidad
 * No requiere crear objetos para usar los métodos
 */
public class Calculadora {

    /**
     * Suma dos números
     * Método estático: no depende del estado de ningún objeto
     */
    public static int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números
     */
    public static int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números
     */
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números con validación
     */
    public static double dividir(double a, double b) {
        if (b == 0) {
            System.out.println("Error: División por cero");
            return 0;
        }
        return a / b;
    }

    /**
     * Calcula el factorial de un número
     */
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Error: Factorial de número negativo");
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /**
     * Determina si un número es primo
     */
    public static boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

**Uso de métodos estáticos:**

```java
public class TestCalculadora {
    public static void main(String[] args) {
        // Llamar métodos estáticos usando el nombre de la clase
        // NO hace falta crear un objeto

        int suma = Calculadora.sumar(10, 5);
        System.out.println("10 + 5 = " + suma);

        int resta = Calculadora.restar(10, 5);
        System.out.println("10 - 5 = " + resta);

        int mult = Calculadora.multiplicar(10, 5);
        System.out.println("10 * 5 = " + mult);

        double div = Calculadora.dividir(10, 5);
        System.out.println("10 / 5 = " + div);

        long fact = Calculadora.factorial(5);
        System.out.println("5! = " + fact);

        boolean primo = Calculadora.esPrimo(17);
        System.out.println("¿17 es primo? " + primo);
    }
}
```

**Salida:**

```
10 + 5 = 15
10 - 5 = 5
10 * 5 = 50
10 / 5 = 2.0
5! = 120
¿17 es primo? true
```

### 7.4 Métodos Estáticos para ASIR: Utilidades de Red

```java
/**
 * Clase de utilidades para administración de redes
 * Todos los métodos son estáticos
 */
public class UtilidadesRed {

    /**
     * Valida formato de dirección IP v4
     * @param ip Dirección IP a validar
     * @return true si es válida
     */
    public static boolean validarIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        String[] partes = ip.split("\\.");

        // Debe tener 4 octetos
        if (partes.length != 4) {
            return false;
        }

        try {
            for (String parte : partes) {
                int octeto = Integer.parseInt(parte);
                // Cada octeto debe estar entre 0 y 255
                if (octeto < 0 || octeto > 255) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Valida formato de dirección MAC
     * @param mac Dirección MAC a validar (formato XX:XX:XX:XX:XX:XX)
     * @return true si es válida
     */
    public static boolean validarMAC(String mac) {
        if (mac == null) return false;

        // Formato XX:XX:XX:XX:XX:XX
        String regex = "^([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}$";
        return mac.matches(regex);
    }

    /**
     * Determina la clase de red de una IP
     * @param ip Dirección IP
     * @return Clase de red (A, B, C, D, E)
     */
    public static String obtenerClaseRed(String ip) {
        if (!validarIP(ip)) {
            return "IP inválida";
        }

        String[] partes = ip.split("\\.");
        int primerOcteto = Integer.parseInt(partes[0]);

        if (primerOcteto >= 1 && primerOcteto <= 126) {
            return "Clase A";
        } else if (primerOcteto >= 128 && primerOcteto <= 191) {
            return "Clase B";
        } else if (primerOcteto >= 192 && primerOcteto <= 223) {
            return "Clase C";
        } else if (primerOcteto >= 224 && primerOcteto <= 239) {
            return "Clase D (Multicast)";
        } else {
            return "Clase E (Experimental)";
        }
    }

    /**
     * Verifica si una IP es privada
     * Rangos privados:
     * - 10.0.0.0 a 10.255.255.255
     * - 172.16.0.0 a 172.31.255.255
     * - 192.168.0.0 a 192.168.255.255
     */
    public static boolean esIPPrivada(String ip) {
        if (!validarIP(ip)) {
            return false;
        }

        String[] partes = ip.split("\\.");
        int octeto1 = Integer.parseInt(partes[0]);
        int octeto2 = Integer.parseInt(partes[1]);

        // Rango 10.0.0.0/8
        if (octeto1 == 10) {
            return true;
        }

        // Rango 172.16.0.0/12
        if (octeto1 == 172 && octeto2 >= 16 && octeto2 <= 31) {
            return true;
        }

        // Rango 192.168.0.0/16
        if (octeto1 == 192 && octeto2 == 168) {
            return true;
        }

        return false;
    }

    /**
     * Convierte dirección IP a formato binario
     */
    public static String ipABinario(String ip) {
        if (!validarIP(ip)) {
            return "IP inválida";
        }

        String[] octetos = ip.split("\\.");
        StringBuilder binario = new StringBuilder();

        for (int i = 0; i < octetos.length; i++) {
            int octeto = Integer.parseInt(octetos[i]);
            String octBinario = String.format("%8s", Integer.toBinaryString(octeto))
                                      .replace(' ', '0');
            binario.append(octBinario);
            if (i < octetos.length - 1) {
                binario.append(".");
            }
        }

        return binario.toString();
    }

    /**
     * Convierte bytes a formato legible (KB, MB, GB)
     */
    public static String formatearBytes(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.2f KB", bytes / 1024.0);
        } else if (bytes < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", bytes / (1024.0 * 1024));
        } else {
            return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
        }
    }

    /**
     * Calcula el número de hosts disponibles en una subred
     * @param bits Número de bits de la máscara (ej: 24 para /24)
     * @return Número de hosts disponibles
     */
    public static int calcularHostsDisponibles(int bits) {
        if (bits < 1 || bits > 30) {
            System.out.println("Error: Bits de máscara inválidos (1-30)");
            return 0;
        }

        int bitsHost = 32 - bits;
        // 2^bitsHost - 2 (se restan red y broadcast)
        return (int)Math.pow(2, bitsHost) - 2;
    }

    /**
     * Valida número de puerto
     */
    public static boolean validarPuerto(int puerto) {
        return puerto >= 1 && puerto <= 65535;
    }

    /**
     * Obtiene el nombre común del puerto
     */
    public static String obtenerServicioPuerto(int puerto) {
        switch (puerto) {
            case 20: return "FTP (Datos)";
            case 21: return "FTP (Control)";
            case 22: return "SSH";
            case 23: return "Telnet";
            case 25: return "SMTP";
            case 53: return "DNS";
            case 80: return "HTTP";
            case 110: return "POP3";
            case 143: return "IMAP";
            case 443: return "HTTPS";
            case 3306: return "MySQL";
            case 3389: return "RDP";
            case 5432: return "PostgreSQL";
            case 8080: return "HTTP Alternativo";
            default: return "Desconocido";
        }
    }
}
```

**Uso de las utilidades de red:**

```java
public class TestUtilidadesRed {
    public static void main(String[] args) {
        System.out.println("=== UTILIDADES DE RED ===\n");

        // Validar IPs
        String ip1 = "192.168.1.1";
        String ip2 = "999.999.999.999";

        System.out.println("Validando IPs:");
        System.out.println(ip1 + " es válida: " + UtilidadesRed.validarIP(ip1));
        System.out.println(ip2 + " es válida: " + UtilidadesRed.validarIP(ip2));

        // Clase de red
        System.out.println("\nClase de red:");
        System.out.println(ip1 + " -> " + UtilidadesRed.obtenerClaseRed(ip1));
        System.out.println("10.0.0.1 -> " + UtilidadesRed.obtenerClaseRed("10.0.0.1"));
        System.out.println("172.16.0.1 -> " + UtilidadesRed.obtenerClaseRed("172.16.0.1"));

        // IP privada
        System.out.println("\n¿Es IP privada?");
        System.out.println("192.168.1.1: " + UtilidadesRed.esIPPrivada("192.168.1.1"));
        System.out.println("8.8.8.8: " + UtilidadesRed.esIPPrivada("8.8.8.8"));

        // Convertir a binario
        System.out.println("\nConversión a binario:");
        System.out.println(ip1 + " = " + UtilidadesRed.ipABinario(ip1));

        // Formatear bytes
        System.out.println("\nFormateo de bytes:");
        System.out.println("1500 bytes = " + UtilidadesRed.formatearBytes(1500));
        System.out.println("1048576 bytes = " + UtilidadesRed.formatearBytes(1048576));
        System.out.println("5368709120 bytes = " + UtilidadesRed.formatearBytes(5368709120L));

        // Calcular hosts
        System.out.println("\nHosts disponibles:");
        System.out.println("/24 -> " + UtilidadesRed.calcularHostsDisponibles(24) + " hosts");
        System.out.println("/16 -> " + UtilidadesRed.calcularHostsDisponibles(16) + " hosts");

        // Validar MAC
        System.out.println("\nValidar MAC:");
        System.out.println("00:1B:44:11:3A:B7 -> " +
                         UtilidadesRed.validarMAC("00:1B:44:11:3A:B7"));
        System.out.println("XX:YY:ZZ:AA:BB:CC -> " +
                         UtilidadesRed.validarMAC("XX:YY:ZZ:AA:BB:CC"));

        // Servicios de puertos
        System.out.println("\nServicios por puerto:");
        int[] puertos = {22, 80, 443, 3306, 3389};
        for (int puerto : puertos) {
            System.out.println("Puerto " + puerto + ": " +
                             UtilidadesRed.obtenerServicioPuerto(puerto));
        }
    }
}
```

### 7.5 Métodos Estáticos vs Métodos de Instancia

```java
/**
 * Ejemplo que contrasta métodos estáticos e de instancia
 */
public class Servidor {
    // Variables de INSTANCIA
    private String nombre;
    private String ip;
    private boolean activo;

    // Variable ESTÁTICA (compartida por todos los servidores)
    private static int totalServidores = 0;

    // CONSTRUCTOR
    public Servidor(String nombre, String ip) {
        this.nombre = nombre;
        this.ip = ip;
        this.activo = false;
        totalServidores++;  // Incrementar contador compartido
    }

    // MÉTODO DE INSTANCIA
    // Requiere un objeto, accede a variables de instancia
    public void encender() {
        if (!activo) {
            activo = true;
            System.out.println("Servidor " + nombre + " encendido");
        } else {
            System.out.println("El servidor " + nombre + " ya está encendido");
        }
    }

    // MÉTODO DE INSTANCIA
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("IP: " + ip);
        System.out.println("Estado: " + (activo ? "Activo" : "Inactivo"));
    }

    // MÉTODO ESTÁTICO
    // No requiere objeto, no accede a variables de instancia
    public static int getTotalServidores() {
        return totalServidores;
    }

    // MÉTODO ESTÁTICO
    public static boolean validarNombreServidor(String nombre) {
        // Un nombre válido debe:
        // - No estar vacío
        // - Empezar con SRV-
        // - Tener al menos 7 caracteres

        if (nombre == null || nombre.isEmpty()) {
            return false;
        }

        if (!nombre.startsWith("SRV-")) {
            return false;
        }

        return nombre.length() >= 7;
    }

    // MÉTODO ESTÁTICO de utilidad
    public static String generarNombreServidor(String tipo, int numero) {
        return String.format("SRV-%s-%02d", tipo.toUpperCase(), numero);
    }
}
```

**Comparación de uso:**

```java
public class TestServidor {
    public static void main(String[] args) {
        // MÉTODOS ESTÁTICOS: se llaman con el nombre de la clase
        // No requieren crear objetos

        System.out.println("Total de servidores: " + Servidor.getTotalServidores());

        boolean valido = Servidor.validarNombreServidor("SRV-WEB-01");
        System.out.println("¿Nombre válido? " + valido);

        String nombre = Servidor.generarNombreServidor("DB", 1);
        System.out.println("Nombre generado: " + nombre);

        System.out.println("\n--- Creando servidores ---\n");

        // MÉTODOS DE INSTANCIA: requieren crear objetos
        Servidor srv1 = new Servidor("SRV-WEB-01", "192.168.1.10");
        Servidor srv2 = new Servidor("SRV-DB-01", "192.168.1.20");

        // Ahora sí podemos usar métodos de instancia
        srv1.encender();
        srv1.mostrarInfo();

        System.out.println();

        srv2.encender();
        srv2.mostrarInfo();

        // Método estático: podemos llamarlo en cualquier momento
        System.out.println("\nTotal de servidores: " + Servidor.getTotalServidores());
    }
}
```

### 7.6 Restricciones de los Métodos Estáticos

**Lo que NO pueden hacer los métodos estáticos:**

```java
public class EjemploRestricciones {
    // Variable de instancia
    private int atributoInstancia = 10;

    // Variable estática
    private static int atributoEstatico = 20;

    // MÉTODO ESTÁTICO
    public static void metodoEstatico() {
        // ✓ PUEDE acceder a variables estáticas
        System.out.println("Atributo estático: " + atributoEstatico);

        // ✗ NO PUEDE acceder a variables de instancia
        // System.out.println(atributoInstancia);  // ERROR de compilación

        // ✗ NO PUEDE usar 'this'
        // System.out.println(this.atributoEstatico);  // ERROR

        // ✓ PUEDE llamar a otros métodos estáticos
        otroMetodoEstatico();

        // ✗ NO PUEDE llamar directamente a métodos de instancia
        // metodoInstancia();  // ERROR

        // ✓ PERO puede crear un objeto y llamar sus métodos
        EjemploRestricciones obj = new EjemploRestricciones();
        obj.metodoInstancia();  // Esto sí funciona
    }

    public static void otroMetodoEstatico() {
        System.out.println("Otro método estático");
    }

    // MÉTODO DE INSTANCIA
    public void metodoInstancia() {
        // ✓ Puede acceder a TODO:
        System.out.println("Atributo de instancia: " + atributoInstancia);
        System.out.println("Atributo estático: " + atributoEstatico);

        // ✓ Puede usar 'this'
        System.out.println("Con this: " + this.atributoInstancia);

        // ✓ Puede llamar a métodos estáticos
        metodoEstatico();
        otroMetodoEstatico();
    }
}
```

### 7.7 El Método main() es Estático

```java
/**
 * El método main() DEBE ser estático
 * Porque la JVM lo llama sin crear ningún objeto
 */
public class ProgramaPrincipal {

    // Variables de instancia
    private String mensaje = "Hola desde instancia";

    // El punto de entrada DEBE ser static
    public static void main(String[] args) {
        System.out.println("Iniciando programa...");

        // No podemos acceder directamente a variables de instancia
        // System.out.println(mensaje);  // ERROR

        // Pero podemos crear un objeto y acceder
        ProgramaPrincipal programa = new ProgramaPrincipal();
        System.out.println(programa.mensaje);  // Esto sí funciona

        // Llamar a métodos estáticos (sin crear objeto)
        realizarTarea();

        // Llamar a métodos de instancia (creando objeto)
        programa.tareaInstancia();
    }

    // Método estático auxiliar
    public static void realizarTarea() {
        System.out.println("Ejecutando tarea estática");
    }

    // Método de instancia
    public void tareaInstancia() {
        System.out.println("Ejecutando tarea de instancia: " + mensaje);
    }
}
```

### 7.8 Ejemplo Completo: Sistema de Validación

```java
/**
 * Sistema de validación con métodos estáticos
 * Útil para validar datos antes de crear objetos
 */
public class Validadores {

    /**
     * Valida que un string no esté vacío
     */
    public static boolean validarNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida formato de email
     */
    public static boolean validarEmail(String email) {
        if (!validarNoVacio(email)) {
            return false;
        }

        // Validación simple: debe contener @ y un punto después del @
        int posicionArroba = email.indexOf('@');
        if (posicionArroba == -1) {
            return false;
        }

        String despuesArroba = email.substring(posicionArroba);
        return despuesArroba.contains(".");
    }

    /**
     * Valida formato de teléfono español (9 dígitos)
     */
    public static boolean validarTelefonoES(String telefono) {
        if (!validarNoVacio(telefono)) {
            return false;
        }

        // Eliminar espacios y guiones
        String telefonoLimpio = telefono.replaceAll("[\\s-]", "");

        // Debe tener 9 dígitos
        if (telefonoLimpio.length() != 9) {
            return false;
        }

        // Debe empezar por 6, 7, 8 o 9
        char primer = telefonoLimpio.charAt(0);
        if (primer < '6' || primer > '9') {
            return false;
        }

        // Todos deben ser dígitos
        return telefonoLimpio.matches("\\d+");
    }

    /**
     * Valida que una contraseña sea segura
     */
    public static boolean validarPasswordSegura(String password) {
        if (password == null || password.length() < 8) {
            System.out.println("La contraseña debe tener al menos 8 caracteres");
            return false;
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayuscula = true;
            else if (Character.isLowerCase(c)) tieneMinuscula = true;
            else if (Character.isDigit(c)) tieneNumero = true;
            else tieneEspecial = true;
        }

        if (!tieneMayuscula) {
            System.out.println("La contraseña debe tener al menos una mayúscula");
            return false;
        }
        if (!tieneMinuscula) {
            System.out.println("La contraseña debe tener al menos una minúscula");
            return false;
        }
        if (!tieneNumero) {
            System.out.println("La contraseña debe tener al menos un número");
            return false;
        }

        return true;
    }

    /**
     * Valida rango de edad
     */
    public static boolean validarEdad(int edad, int min, int max) {
        if (edad < min) {
            System.out.println("Edad mínima: " + min);
            return false;
        }
        if (edad > max) {
            System.out.println("Edad máxima: " + max);
            return false;
        }
        return true;
    }

    /**
     * Valida formato de código postal español
     */
    public static boolean validarCodigoPostalES(String cp) {
        if (!validarNoVacio(cp)) {
            return false;
        }

        // Debe ser exactamente 5 dígitos
        if (cp.length() != 5) {
            return false;
        }

        // Todos deben ser dígitos
        if (!cp.matches("\\d{5}")) {
            return false;
        }

        // Los dos primeros dígitos indican la provincia (01-52)
        int provincia = Integer.parseInt(cp.substring(0, 2));
        return provincia >= 1 && provincia <= 52;
    }
}
```

**Uso del sistema de validación:**

```java
public class TestValidadores {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE VALIDACIÓN ===\n");

        // Validar emails
        System.out.println("--- Validación de emails ---");
        String[] emails = {
            "usuario@ejemplo.com",
            "invalido",
            "sin@punto",
            "correcto@dominio.es"
        };

        for (String email : emails) {
            boolean valido = Validadores.validarEmail(email);
            System.out.println(email + " -> " + (valido ? "✓ Válido" : "✗ Inválido"));
        }

        // Validar teléfonos
        System.out.println("\n--- Validación de teléfonos ---");
        String[] telefonos = {
            "612345678",
            "91 234 56 78",
            "123456789",
            "612-345-678"
        };

        for (String tel : telefonos) {
            boolean valido = Validadores.validarTelefonoES(tel);
            System.out.println(tel + " -> " + (valido ? "✓ Válido" : "✗ Inválido"));
        }

        // Validar contraseñas
        System.out.println("\n--- Validación de contraseñas ---");
        String[] passwords = {
            "abc123",           // Muy corta, sin mayúscula
            "Abc12345",         // Válida
            "contraseña",       // Sin número, sin mayúscula
            "Password123"       // Válida
        };

        for (String pass : passwords) {
            System.out.println("\nProbando: " + pass);
            boolean valido = Validadores.validarPasswordSegura(pass);
            if (valido) {
                System.out.println("✓ Contraseña segura");
            }
        }

        // Validar edades
        System.out.println("\n--- Validación de edades ---");
        int[] edades = {15, 18, 25, 70};
        for (int edad : edades) {
            boolean valido = Validadores.validarEdad(edad, 18, 65);
            System.out.println("Edad " + edad + " -> " +
                             (valido ? "✓ Válida" : "✗ Inválida"));
        }

        // Validar códigos postales
        System.out.println("\n--- Validación de códigos postales ---");
        String[] codigosPostales = {
            "28001",   // Madrid - válido
            "080001",  // Barcelona - válido
            "12345",   // válido
            "99999",   // Inválido (provincia > 52)
            "1234"     // Inválido (solo 4 dígitos)
        };

        for (String cp : codigosPostales) {
            boolean valido = Validadores.validarCodigoPostalES(cp);
            System.out.println(cp + " -> " + (valido ? "✓ Válido" : "✗ Inválido"));
        }
    }
}
```

### 7.9 Métodos Estáticos en la Clase Math

Java proporciona la clase `Math` con muchos métodos estáticos útiles:

```java
public class EjemplosClaseMath {
    public static void main(String[] args) {
        // Todos estos métodos son estáticos de la clase Math

        // Valor absoluto
        System.out.println("Valor absoluto de -5: " + Math.abs(-5));

        // Potencia
        System.out.println("2 elevado a 8: " + Math.pow(2, 8));

        // Raíz cuadrada
        System.out.println("Raíz cuadrada de 16: " + Math.sqrt(16));

        // Máximo y mínimo
        System.out.println("Máximo entre 10 y 20: " + Math.max(10, 20));
        System.out.println("Mínimo entre 10 y 20: " + Math.min(10, 20));

        // Redondeo
        System.out.println("Redondeo de 3.7: " + Math.round(3.7));
        System.out.println("Ceil de 3.1: " + Math.ceil(3.1));
        System.out.println("Floor de 3.9: " + Math.floor(3.9));

        // Número aleatorio entre 0.0 y 1.0
        System.out.println("Número aleatorio: " + Math.random());

        // Número aleatorio en rango (ej: 1-100)
        int aleatorio = (int)(Math.random() * 100) + 1;
        System.out.println("Aleatorio 1-100: " + aleatorio);

        // Constantes
        System.out.println("PI: " + Math.PI);
        System.out.println("E: " + Math.E);
    }
}
```

### 7.10 Proyecto: Sistema de Conversión de Unidades

```java
/**
 * Sistema de conversión de unidades
 * Todos los métodos son estáticos (no requieren objeto)
 */
public class ConversorUnidades {

    // Constantes para conversiones
    private static final double BYTES_POR_KB = 1024;
    private static final double BYTES_POR_MB = BYTES_POR_KB * 1024;
    private static final double BYTES_POR_GB = BYTES_POR_MB * 1024;
    private static final double BYTES_POR_TB = BYTES_POR_GB * 1024;

    // ========== ALMACENAMIENTO ==========

    /**
     * Convierte bytes a kilobytes
     */
    public static double bytesAKB(long bytes) {
        return bytes / BYTES_POR_KB;
    }

    /**
     * Convierte bytes a megabytes
     */
    public static double bytesAMB(long bytes) {
        return bytes / BYTES_POR_MB;
    }

    /**
     * Convierte bytes a gigabytes
     */
    public static double bytesAGB(long bytes) {
        return bytes / BYTES_POR_GB;
    }

    /**
     * Convierte bytes a terabytes
     */
    public static double bytesATB(long bytes) {
        return bytes / BYTES_POR_TB;
    }

    /**
     * Formatea bytes al formato más apropiado
     */
    public static String formatearBytes(long bytes) {
        if (bytes < BYTES_POR_KB) {
            return bytes + " B";
        } else if (bytes < BYTES_POR_MB) {
            return String.format("%.2f KB", bytesAKB(bytes));
        } else if (bytes < BYTES_POR_GB) {
            return String.format("%.2f MB", bytesAMB(bytes));
        } else if (bytes < BYTES_POR_TB) {
            return String.format("%.2f GB", bytesAGB(bytes));
        } else {
            return String.format("%.2f TB", bytesATB(bytes));
        }
    }

    // ========== VELOCIDAD DE RED ==========

    /**
     * Convierte bits por segundo a megabits por segundo
     */
    public static double bpsAMbps(long bps) {
        return bps / 1_000_000.0;
    }

    /**
     * Convierte megabits por segundo a megabytes por segundo
     */
    public static double mbpsAMBps(double mbps) {
        return mbps / 8.0;
    }

    /**
     * Calcula tiempo de descarga
     * @param tamañoBytes Tamaño del archivo en bytes
     * @param velocidadMbps Velocidad de descarga en Mbps
     * @return Tiempo en segundos
     */
    public static double calcularTiempoDescarga(long tamañoBytes, double velocidadMbps) {
        // Convertir Mbps a Bps (bytes por segundo)
        double velocidadBps = (velocidadMbps * 1_000_000) / 8;
        return tamañoBytes / velocidadBps;
    }

    // ========== TIEMPO ==========

    /**
     * Convierte segundos a formato HH:MM:SS
     */
    public static String segundosAHMS(long segundos) {
        long horas = segundos / 3600;
        long minutos = (segundos % 3600) / 60;
        long segs = segundos % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segs);
    }

    /**
     * Convierte milisegundos a segundos
     */
    public static double msASegundos(long ms) {
        return ms / 1000.0;
    }

    // ========== TEMPERATURA ==========

    /**
     * Convierte Celsius a Fahrenheit
     */
    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    /**
     * Convierte Fahrenheit a Celsius
     */
    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    /**
     * Convierte Celsius a Kelvin
     */
    public static double celsiusAKelvin(double celsius) {
        return celsius + 273.15;
    }
}
```

**Uso del conversor:**

```java
public class TestConversor {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CONVERSIÓN DE UNIDADES ===\n");

        // Conversiones de almacenamiento
        System.out.println("--- ALMACENAMIENTO ---");
        long bytes = 5_368_709_120L; // 5GB en bytes

        System.out.println(bytes + " bytes =");
        System.out.println("  " + ConversorUnidades.bytesAKB(bytes) + " KB");
        System.out.println("  " + ConversorUnidades.bytesAMB(bytes) + " MB");
        System.out.println("  " + ConversorUnidades.bytesAGB(bytes) + " GB");
        System.out.println("  Formato automático: " + ConversorUnidades.formatearBytes(bytes));

        // Velocidad de red
        System.out.println("\n--- VELOCIDAD DE RED ---");
        long bps = 100_000_000; // 100 Mbps
        System.out.println(bps + " bps = " + ConversorUnidades.bpsAMbps(bps) + " Mbps");

        double mbps = 100;
        System.out.println(mbps + " Mbps = " + ConversorUnidades.mbpsAMBps(mbps) + " MB/s");

        // Tiempo de descarga
        System.out.println("\n--- TIEMPO DE DESCARGA ---");
        long tamañoArchivo = 1_073_741_824L; // 1 GB
        double velocidad = 100; // 100 Mbps

        double tiempoSegs = ConversorUnidades.calcularTiempoDescarga(tamañoArchivo, velocidad);
        String tiempoFormato = ConversorUnidades.segundosAHMS((long)tiempoSegs);

        System.out.println("Descargar " + ConversorUnidades.formatearBytes(tamañoArchivo) +
                         " a " + velocidad + " Mbps:");
        System.out.println("  Tiempo: " + tiempoFormato + " (" + (int)tiempoSegs + " segundos)");

        // Temperatura
        System.out.println("\n--- TEMPERATURA ---");
        double celsius = 25;
        System.out.println(celsius + "°C =");
        System.out.println("  " + ConversorUnidades.celsiusAFahrenheit(celsius) + "°F");
        System.out.println("  " + ConversorUnidades.celsiusAKelvin(celsius) + "K");

        double fahrenheit = 77;
        System.out.println(fahrenheit + "°F = " +
                         ConversorUnidades.fahrenheitACelsius(fahrenheit) + "°C");

        // Tiempo
        System.out.println("\n--- TIEMPO ---");
        long segundos = 3665;
        System.out.println(segundos + " segundos = " +
                         ConversorUnidades.segundosAHMS(segundos));

        long ms = 5500;
        System.out.println(ms + " ms = " + ConversorUnidades.msASegundos(ms) + " segundos");
    }
}
```

-----

## Resumen de Métodos Estáticos

### ✓ Conceptos Clave

1. **Definición**: Métodos que pertenecen a la clase, no a instancias
1. **Acceso**: Se llaman con `NombreClase.metodo()`
1. **No requieren objetos**: Pueden ejecutarse sin crear instancias
1. **Limitaciones**: No pueden acceder a variables de instancia ni usar `this`

### ✓ Cuándo Usar Métodos Estáticos

- Operaciones de utilidad (validaciones, conversiones)
- Funciones matemáticas
- Métodos que no dependen del estado del objeto
- Constantes y configuración global
- Contadores compartidos

### ✓ Ejemplos Prácticos para ASIR

- Validación de IPs y MACs
- Conversión de unidades (bytes, velocidad)
- Utilidades de red
- Formateo de datos
- Cálculos matemáticos

### ✓ Ventajas

- ✅ No requieren crear objetos
- ✅ Ahorro de memoria
- ✅ Código más organizado
- ✅ Reutilización fácil

### ✓ Desventajas

- ❌ No pueden acceder a variables de instancia
- ❌ No permiten polimorfismo
- ❌ Más difíciles de mockear en pruebas

-----

