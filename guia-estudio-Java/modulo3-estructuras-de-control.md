<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# MÓDULO 3: ESTRUCTURAS DE CONTROL  

1. Sentencias condicionales: if, else, else if
1. Operador ternario
1. Sentencia switch
1. Bucles: while y do-while
1. Bucle for y for-each
1. Sentencias break y continue
1. Estructuras anidadas  

## 1. Sentencias condicionales: if, else, else if

Las estructuras condicionales permiten que un programa tome decisiones y ejecute diferentes bloques de código según se cumplan o no ciertas condiciones.

### Estructura if simple

La estructura `if` más básica ejecuta un bloque de código solo si la condición es verdadera:

```java
if (condición) {
    // Código que se ejecuta si la condición es true
}
```

**Ejemplo práctico:**

```java
int temperatura = 85;

if (temperatura > 80) {
    System.out.println("⚠️ Alerta: Temperatura alta");
}
```

**Otro ejemplo:**

```java
int memoriaDisponible = 512; // MB

if (memoriaDisponible < 1024) {
    System.out.println("Memoria baja, considere liberar recursos");
}
```

### Buenas prácticas con if

**Siempre usa llaves, incluso para una sola línea:**

```java
// ❌ MAL (sin llaves)
if (edad >= 18)
    System.out.println("Mayor de edad");

// ✅ BIEN (con llaves)
if (edad >= 18) {
    System.out.println("Mayor de edad");
}
```

**Condiciones legibles:**

```java
// ❌ MAL
if (m < 1024 && c > 80) {
    // código
}

// ✅ BIEN
int memoriaMinima = 1024;
int cpuMaximo = 80;
if (memoriaDisponible < memoriaMinima && usoCPU > cpuMaximo) {
    // código
}
```

### Estructura if-else

Ejecuta un bloque si la condición es verdadera, y otro bloque si es falsa:

```java
if (condición) {
    // Código si la condición es true
} else {
    // Código si la condición es false
}
```

**Ejemplo práctico:**

```java
int puerto = 80;

if (puerto < 1024) {
    System.out.println("Puerto privilegiado (requiere permisos de administrador)");
} else {
    System.out.println("Puerto no privilegiado (puede usar cualquier usuario)");
}
```

**Sistema de autenticación:**

```java
String usuario = "admin";
String password = "1234";

if (usuario.equals("admin") && password.equals("1234")) {
    System.out.println("✅ Acceso concedido");
    System.out.println("Bienvenido al sistema");
} else {
    System.out.println("❌ Acceso denegado");
    System.out.println("Credenciales incorrectas");
}
```

### Estructura if-else if-else

Permite evaluar múltiples condiciones en secuencia:

```java
if (condición1) {
    // Código si condición1 es true
} else if (condición2) {
    // Código si condición2 es true
} else if (condición3) {
    // Código si condición3 es true
} else {
    // Código si ninguna condición es true
}
```

**Ejemplo: Sistema de alertas por uso de CPU:**

```java
int usoCPU = 75;

if (usoCPU >= 90) {
    System.out.println("🔴 CRÍTICO: CPU al " + usoCPU + "%");
    System.out.println("Acción: Detener servicios no esenciales");
} else if (usoCPU >= 70) {
    System.out.println("🟡 ALERTA: CPU al " + usoCPU + "%");
    System.out.println("Acción: Monitorear de cerca");
} else if (usoCPU >= 50) {
    System.out.println("🟢 NORMAL-ALTO: CPU al " + usoCPU + "%");
    System.out.println("Acción: Sin acción requerida");
} else {
    System.out.println("🟢 NORMAL: CPU al " + usoCPU + "%");
    System.out.println("Acción: Sistema funcionando correctamente");
}
```

**Ejemplo: Clasificación de puertos:**

```java
int puerto = 8080;

if (puerto < 0 || puerto > 65535) {
    System.out.println("❌ Puerto inválido");
} else if (puerto < 1024) {
    System.out.println("Puerto del sistema (0-1023)");
    System.out.println("Ejemplos: HTTP(80), HTTPS(443), SSH(22)");
} else if (puerto < 49152) {
    System.out.println("Puerto registrado (1024-49151)");
    System.out.println("Usado por aplicaciones específicas");
} else {
    System.out.println("Puerto dinámico/privado (49152-65535)");
    System.out.println("Usado temporalmente por aplicaciones");
}
```

### Condiciones compuestas

Puedes combinar múltiples condiciones usando operadores lógicos:

```java
// AND (&&) - Todas las condiciones deben ser verdaderas
int memoria = 8192;
int cpu = 4;

if (memoria >= 8192 && cpu >= 4) {
    System.out.println("✅ El servidor cumple con los requisitos mínimos");
}

// OR (||) - Al menos una condición debe ser verdadera
int errorCode = 404;

if (errorCode == 404 || errorCode == 500 || errorCode == 503) {
    System.out.println("⚠️ Error del servidor detectado");
    System.out.println("Código de error: " + errorCode);
}

// Combinación de AND y OR
boolean usuarioValido = true;
boolean passwordValida = true;
boolean cuentaActiva = false;

if ((usuarioValido && passwordValida) && cuentaActiva) {
    System.out.println("Acceso permitido");
} else {
    System.out.println("Acceso denegado");
}
```

### Estructuras if anidadas

Puedes colocar estructuras `if` dentro de otras:

```java
int puerto = 22;
boolean firewall = true;

if (puerto == 22) {
    System.out.println("Puerto SSH detectado");

    if (firewall) {
        System.out.println("✅ Firewall activo - Conexión segura");
    } else {
        System.out.println("⚠️ ADVERTENCIA: Firewall inactivo");
        System.out.println("Puerto SSH expuesto sin protección");
    }
} else {
    System.out.println("Puerto no identificado: " + puerto);
}
```

**Recomendación:** Evita anidar demasiados niveles (máximo 2-3 niveles). Si necesitas más, considera reorganizar el código o usar métodos separados.

### Ejemplo completo: Sistema de monitorización

```java
import java.util.Scanner;

public class MonitorServidor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE MONITORIZACIÓN ===\n");

        System.out.print("Uso de CPU (%): ");
        int usoCPU = sc.nextInt();

        System.out.print("Memoria disponible (MB): ");
        int memoriaDisponible = sc.nextInt();

        System.out.print("Temperatura (°C): ");
        int temperatura = sc.nextInt();

        System.out.println("\n--- ANÁLISIS DEL SISTEMA ---");

        // Evaluar estado crítico
        boolean estadoCritico = false;

        if (usoCPU > 90) {
            System.out.println("🔴 CPU: CRÍTICO (" + usoCPU + "%)");
            estadoCritico = true;
        } else if (usoCPU > 70) {
            System.out.println("🟡 CPU: ALERTA (" + usoCPU + "%)");
        } else {
            System.out.println("🟢 CPU: NORMAL (" + usoCPU + "%)");
        }

        if (memoriaDisponible < 512) {
            System.out.println("🔴 MEMORIA: CRÍTICO (" + memoriaDisponible + " MB)");
            estadoCritico = true;
        } else if (memoriaDisponible < 1024) {
            System.out.println("🟡 MEMORIA: ALERTA (" + memoriaDisponible + " MB)");
        } else {
            System.out.println("🟢 MEMORIA: NORMAL (" + memoriaDisponible + " MB)");
        }

        if (temperatura > 85) {
            System.out.println("🔴 TEMPERATURA: CRÍTICO (" + temperatura + "°C)");
            estadoCritico = true;
        } else if (temperatura > 70) {
            System.out.println("🟡 TEMPERATURA: ALERTA (" + temperatura + "°C)");
        } else {
            System.out.println("🟢 TEMPERATURA: NORMAL (" + temperatura + "°C)");
        }

        // Recomendación final
        System.out.println("\n--- RECOMENDACIÓN ---");
        if (estadoCritico) {
            System.out.println("⚠️  ACCIÓN INMEDIATA REQUERIDA");
            System.out.println("- Revisar procesos que consumen más recursos");
            System.out.println("- Considerar reiniciar servicios no esenciales");
            System.out.println("- Verificar ventilación del servidor");
        } else {
            System.out.println("✅ Sistema operando dentro de parámetros normales");
        }

        sc.close();
    }
}
```

## 2. Operador ternario

El operador ternario es una forma compacta de escribir una estructura `if-else` simple en una sola línea. Es útil para asignaciones condicionales simples.

### Sintaxis

```java
variable = (condición) ? valorSiVerdadero : valorSiFalso;
```

### Ejemplos básicos

```java
// Ejemplo 1: Determinar si es mayor de edad
int edad = 20;
String estado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
System.out.println(estado);  // "Mayor de edad"

// Ejemplo 2: Determinar estado del servicio
boolean servicioActivo = true;
String mensaje = (servicioActivo) ? "✅ Activo" : "❌ Inactivo";
System.out.println(mensaje);  // "✅ Activo"

// Ejemplo 3: Calcular precio con descuento
int cantidad = 15;
double precioUnitario = (cantidad >= 10) ? 8.50 : 10.00;
System.out.println("Precio por unidad: $" + precioUnitario);
```

### Operador ternario anidado

Puedes anidar operadores ternarios, aunque puede reducir la legibilidad:

```java
int nota = 75;
String resultado = (nota >= 90) ? "Excelente"
                 : (nota >= 70) ? "Bueno"
                 : (nota >= 50) ? "Aprobado"
                 : "Reprobado";
System.out.println(resultado);  // "Bueno"

// Equivalente con if-else if-else (más legible para este caso)
String resultado2;
if (nota >= 90) {
    resultado2 = "Excelente";
} else if (nota >= 70) {
    resultado2 = "Bueno";
} else if (nota >= 50) {
    resultado2 = "Aprobado";
} else {
    resultado2 = "Reprobado";
}
```

### Cuándo usar el operador ternario

**✅ Usa el operador ternario cuando:**

- La condición es simple
- Solo necesitas elegir entre dos valores
- Mejora la legibilidad al hacer el código más conciso

```java
// BIEN: Asignación simple
int max = (a > b) ? a : b;
String tipo = (puerto < 1024) ? "Sistema" : "Usuario";
```

**❌ Evita el operador ternario cuando:**

- La lógica es compleja
- Necesitas ejecutar múltiples sentencias
- Reduce la legibilidad

```java
// MAL: Demasiado complejo
String mensaje = (cpu > 90) ? "Crítico: " + cpu + "% - " + ((memoria < 512) ? "y memoria baja" : "memoria OK") : "Normal";

// MEJOR: Usar if-else
String mensaje;
if (cpu > 90) {
    mensaje = "Crítico: " + cpu + "%";
    if (memoria < 512) {
        mensaje += " - y memoria baja";
    } else {
        mensaje += " - memoria OK";
    }
} else {
    mensaje = "Normal";
}
```

### Ejemplos prácticos para ASIR

```java
// Determinar tipo de IP
String ip = "192.168.1.10";
boolean esPrivada = ip.startsWith("192.168") || ip.startsWith("10.") || ip.startsWith("172.");
String tipoIP = (esPrivada) ? "IP Privada" : "IP Pública";

// Establecer nivel de prioridad
int severidad = 8;
String prioridad = (severidad >= 7) ? "Alta" : (severidad >= 4) ? "Media" : "Baja";

// Determinar protocolo por puerto
int puerto = 443;
String protocolo = (puerto == 80) ? "HTTP"
                 : (puerto == 443) ? "HTTPS"
                 : (puerto == 22) ? "SSH"
                 : "Desconocido";

// Estado del backup
boolean backupCompletado = true;
int horasDesdeBackup = 6;
String estadoBackup = (backupCompletado && horasDesdeBackup < 24)
                      ? "✅ Backup reciente"
                      : "⚠️ Backup desactualizado";
```

## 3. Sentencia switch

La sentencia `switch` es una alternativa al uso de múltiples `if-else if` cuando se necesita comparar una variable con varios valores posibles. Es especialmente útil cuando tienes muchas opciones discretas.

### Sintaxis básica

```java
switch (expresión) {
    case valor1:
        // Código si expresión == valor1
        break;
    case valor2:
        // Código si expresión == valor2
        break;
    case valor3:
        // Código si expresión == valor3
        break;
    default:
        // Código si no coincide con ningún case
}
```

### Ejemplo básico

```java
int dia = 3;

switch (dia) {
    case 1:
        System.out.println("Lunes");
        break;
    case 2:
        System.out.println("Martes");
        break;
    case 3:
        System.out.println("Miércoles");
        break;
    case 4:
        System.out.println("Jueves");
        break;
    case 5:
        System.out.println("Viernes");
        break;
    case 6:
        System.out.println("Sábado");
        break;
    case 7:
        System.out.println("Domingo");
        break;
    default:
        System.out.println("Día inválido");
}
```

### La importancia de break

La sentencia `break` es crucial en el `switch`. Sin ella, la ejecución continuará con los siguientes casos (esto se llama “fall-through”):

```java
int opcion = 2;

// SIN break (fall-through)
switch (opcion) {
    case 1:
        System.out.println("Opción 1");
    case 2:
        System.out.println("Opción 2");  // Se ejecuta
    case 3:
        System.out.println("Opción 3");  // También se ejecuta!
    default:
        System.out.println("Default");   // También se ejecuta!
}
// Salida: Opción 2, Opción 3, Default

// CON break (comportamiento normal)
switch (opcion) {
    case 1:
        System.out.println("Opción 1");
        break;
    case 2:
        System.out.println("Opción 2");
        break;  // Detiene la ejecución
    case 3:
        System.out.println("Opción 3");
        break;
    default:
        System.out.println("Default");
}
// Salida: Opción 2
```

### Fall-through intencional

A veces el fall-through es útil cuando varios casos comparten el mismo código:

```java
int mes = 2;
int dias;

switch (mes) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
        dias = 31;
        break;
    case 4:
    case 6:
    case 9:
    case 11:
        dias = 30;
        break;
    case 2:
        dias = 28;  // Simplificado, sin considerar años bisiestos
        break;
    default:
        dias = 0;
        System.out.println("Mes inválido");
}

System.out.println("El mes tiene " + dias + " días");
```

### Switch con String (Java 7+)

Desde Java 7, puedes usar `String` en switch:

```java
String comando = "start";

switch (comando) {
    case "start":
        System.out.println("Iniciando servicio...");
        break;
    case "stop":
        System.out.println("Deteniendo servicio...");
        break;
    case "restart":
        System.out.println("Reiniciando servicio...");
        break;
    case "status":
        System.out.println("Consultando estado...");
        break;
    default:
        System.out.println("Comando no reconocido");
        System.out.println("Comandos válidos: start, stop, restart, status");
}
```

**⚠️ Importante:** Con String, el `switch` es sensible a mayúsculas/minúsculas.

```java
String cmd = "START";

// No coincide porque "START" != "start"
switch (cmd) {
    case "start":  // No se ejecuta
        System.out.println("Iniciando...");
        break;
    default:
        System.out.println("Comando no reconocido");  // Se ejecuta esto
}

// Solución: convertir a minúsculas
switch (cmd.toLowerCase()) {
    case "start":
        System.out.println("Iniciando...");  // Ahora sí se ejecuta
        break;
}
```

### Ejemplo práctico: Menú de administración

```java
import java.util.Scanner;

public class MenuAdministracion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== MENÚ DE ADMINISTRACIÓN ===");
        System.out.println("1. Usuarios");
        System.out.println("2. Servicios");
        System.out.println("3. Red");
        System.out.println("4. Logs");
        System.out.println("5. Salir");
        System.out.print("\nSeleccione una opción: ");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("\n--- GESTIÓN DE USUARIOS ---");
                System.out.println("• Listar usuarios");
                System.out.println("• Crear usuario");
                System.out.println("• Modificar usuario");
                System.out.println("• Eliminar usuario");
                break;

            case 2:
                System.out.println("\n--- GESTIÓN DE SERVICIOS ---");
                System.out.println("• Ver servicios activos");
                System.out.println("• Iniciar servicio");
                System.out.println("• Detener servicio");
                System.out.println("• Reiniciar servicio");
                break;

            case 3:
                System.out.println("\n--- CONFIGURACIÓN DE RED ---");
                System.out.println("• Ver interfaces de red");
                System.out.println("• Configurar IP");
                System.out.println("• Configurar DNS");
                System.out.println("• Test de conectividad");
                break;

            case 4:
                System.out.println("\n--- VISUALIZACIÓN DE LOGS ---");
                System.out.println("• Ver logs del sistema");
                System.out.println("• Ver logs de aplicaciones");
                System.out.println("• Filtrar logs por fecha");
                System.out.println("• Exportar logs");
                break;

            case 5:
                System.out.println("\n👋 Saliendo del sistema...");
                System.out.println("Sesión cerrada correctamente");
                break;

            default:
                System.out.println("\n❌ Opción inválida");
                System.out.println("Por favor, seleccione una opción entre 1 y 5");
        }

        sc.close();
    }
}
```

### Ejemplo: Clasificación de códigos HTTP

```java
int codigoHTTP = 404;
String categoria;
String mensaje;

switch (codigoHTTP / 100) {  // Divide por 100 para obtener el primer dígito
    case 1:
        categoria = "Informativo";
        mensaje = "La solicitud fue recibida";
        break;
    case 2:
        categoria = "Éxito";
        mensaje = "La solicitud fue procesada correctamente";
        break;
    case 3:
        categoria = "Redirección";
        mensaje = "Se requiere acción adicional";
        break;
    case 4:
        categoria = "Error del cliente";
        mensaje = "La solicitud contiene un error";
        break;
    case 5:
        categoria = "Error del servidor";
        mensaje = "El servidor encontró un error";
        break;
    default:
        categoria = "Desconocido";
        mensaje = "Código HTTP no reconocido";
}

System.out.println("Código: " + codigoHTTP);
System.out.println("Categoría: " + categoria);
System.out.println("Descripción: " + mensaje);

// Descripción específica según el código exacto
switch (codigoHTTP) {
    case 200:
        System.out.println("Detalle: OK - Solicitud exitosa");
        break;
    case 404:
        System.out.println("Detalle: Not Found - Recurso no encontrado");
        break;
    case 500:
        System.out.println("Detalle: Internal Server Error - Error interno");
        break;
    case 503:
        System.out.println("Detalle: Service Unavailable - Servicio no disponible");
        break;
}
```

### Switch vs if-else: ¿Cuándo usar cada uno?

**Usa switch cuando:**

- Comparas una variable con múltiples valores constantes
- Los valores son discretos (números específicos, strings específicos)
- Tienes 3 o más opciones
- Mejora la legibilidad

```java
// BIEN con switch
switch (puerto) {
    case 21:  // FTP
    case 22:  // SSH
    case 80:  // HTTP
    case 443: // HTTPS
}
```

**Usa if-else cuando:**

- Necesitas evaluar rangos de valores
- Las condiciones son complejas
- Usas operadores relacionales (<, >, <=, >=)
- Combinas múltiples condiciones con && o ||

```java
// BIEN con if-else (rangos)
if (temperatura < 50) {
    // bajo
} else if (temperatura < 70) {
    // normal
} else {
    // alto
}
```

### Switch expressions (Java 14+)

A partir de Java 14, existe una sintaxis más moderna:

```java
// Sintaxis tradicional
String resultado;
switch (dia) {
    case 1:
        resultado = "Lunes";
        break;
    case 2:
        resultado = "Martes";
        break;
    default:
        resultado = "Otro día";
}

// Sintaxis moderna (Java 14+)
String resultado = switch (dia) {
    case 1 -> "Lunes";
    case 2 -> "Martes";
    case 3 -> "Miércoles";
    default -> "Otro día";
};

// Con múltiples casos
String tipoServicio = switch (puerto) {
    case 21, 22, 23 -> "Servicio de conexión remota";
    case 80, 443, 8080 -> "Servicio web";
    case 25, 587, 465 -> "Servicio de correo";
    default -> "Servicio no identificado";
};
```

## 4. Bucles: while y do-while

Los bucles permiten ejecutar un bloque de código repetidamente mientras se cumpla una condición. Son fundamentales para automatizar tareas repetitivas.

### Bucle while

El bucle `while` ejecuta un bloque de código mientras la condición sea verdadera. La condición se evalúa **antes** de cada iteración.

**Sintaxis:**

```java
while (condición) {
    // Código que se repite
}
```

**Ejemplo básico:**

```java
int contador = 1;

while (contador <= 5) {
    System.out.println("Iteración: " + contador);
    contador++;
}

// Salida:
// Iteración: 1
// Iteración: 2
// Iteración: 3
// Iteración: 4
// Iteración: 5
```

**Ejemplo: Suma de números:**

```java
int suma = 0;
int numero = 1;

while (numero <= 10) {
    suma += numero;
    numero++;
}

System.out.println("La suma de 1 a 10 es: " + suma);  // 55
```

### Ejemplo práctico: Reintentos de conexión

```java
int intentos = 0;
int maxIntentos = 3;
boolean conectado = false;

while (intentos < maxIntentos && !conectado) {
    intentos++;
    System.out.println("Intento " + intentos + " de conexión...");

    // Simular intento de conexión (aleatorio)
    conectado = Math.random() > 0.7;  // 30% de probabilidad

    if (conectado) {
        System.out.println("✅ Conexión establecida");
    } else {
        System.out.println("❌ Conexión fallida");
        if (intentos < maxIntentos) {
            System.out.println("Reintentando en 3 segundos...\n");
        }
    }
}

if (!conectado) {
    System.out.println("\n⚠️ No se pudo establecer conexión después de "
                       + maxIntentos + " intentos");
}
```

### Ejemplo: Validación de entrada

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
int puerto = 0;
boolean entradaValida = false;

while (!entradaValida) {
    System.out.print("Introduce un puerto (1-65535): ");
    puerto = sc.nextInt();

    if (puerto >= 1 && puerto <= 65535) {
        entradaValida = true;
        System.out.println("✅ Puerto válido: " + puerto);
    } else {
        System.out.println("❌ Puerto inválido. Intenta de nuevo.\n");
    }
}
```

### Bucle do-while

El bucle `do-while` es similar al `while`, pero la condición se evalúa **después** de cada iteración. Esto garantiza que el código se ejecute al menos una vez.

**Sintaxis:**

```java
do {
    // Código que se repite
} while (condición);
```

**Diferencia clave:**

```java
// while: puede no ejecutarse nunca
int x = 10;
while (x < 5) {
    System.out.println("Esto NO se imprime");
}

// do-while: se ejecuta al menos una vez
int y = 10;
do {
    System.out.println("Esto SÍ se imprime una vez");
} while (y < 5);
```

### Ejemplo práctico: Menú interactivo

```java
import java.util.Scanner;

public class MenuInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Iniciar servicio");
            System.out.println("2. Detener servicio");
            System.out.println("3. Reiniciar servicio");
            System.out.println("4. Ver estado");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n✅ Servicio iniciado");
                    break;
                case 2:
                    System.out.println("\n⏹️  Servicio detenido");
                    break;
                case 3:
                    System.out.println("\n🔄 Servicio reiniciado");
                    break;
                case 4:
                    System.out.println("\nℹ️  Estado: Servicio activo");
                    break;
                case 0:
                    System.out.println("\n👋 Saliendo del sistema...");
                    break;
                default:
                    System.out.println("\n❌ Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
```

### Ejemplo: Sistema de login con intentos limitados

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
final String PASSWORD_CORRECTA = "admin123";
final int MAX_INTENTOS = 3;
int intentos = 0;
boolean accesoConcedido = false;

do {
    intentos++;
    System.out.print("Introduce la contraseña (intento " + intentos
                     + " de " + MAX_INTENTOS + "): ");
    String password = sc.nextLine();
```
