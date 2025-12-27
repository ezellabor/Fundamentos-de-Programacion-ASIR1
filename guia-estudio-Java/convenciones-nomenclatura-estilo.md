<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>
# Convenciones de Nomenclatura y Estilo Java

## Nomenclatura

### Clases e Interfaces
- Usar **PascalCase** (CamelCase con primera letra mayúscula)
- Nombres deben ser sustantivos o frases sustantivas
- Ejemplos: `String`, `ArrayList`, `CustomerOrder`

### Métodos
- Usar **camelCase** (primera letra minúscula)
- Nombres deben ser verbos o frases verbales
- Ejemplos: `calculateTotal()`, `getUserName()`, `isValid()`

### Variables
- Usar **camelCase** para variables locales y de instancia
- Variables constantes (static final) usar **MAYÚSCULAS_CON_GUIONES_BAJOS**
- Ejemplos: `userCount`, `MAX_CONNECTIONS`, `DEFAULT_TIMEOUT`

### Paquetes
- Usar **minúsculas** exclusivamente
- Evitar guiones bajos o mayúsculas
- Usar el dominio inverso como prefijo
- Ejemplos: `com.company.project.module`, `org.apache.commons`

## Estructura de código

### Declaraciones
- Una declaración por línea
- Declarar variables donde se usan por primera vez
- Inicializar variables locales en su declaración

### Espaciado
- Usar 4 espacios para indentación (NO tabs)
- Línea en blanco entre métodos
- Línea en blanco entre secciones lógicas dentro de métodos

### Longitud de línea
- Límite recomendado: 80-120 caracteres
- Dividir líneas largas en puntos lógicos

### Llaves
- Estilo K&R (llave de apertura en misma línea)
```java
if (condition) {
    // código
} else {
    // código
}
```


## Convenciones específicas

### Constantes


```java  
public static final int MAX_USERS = 100;
public static final String DEFAULT_NAME = "Unknown";
private static final double PI = 3.1415926535;
```

### Enums
Usar PascalCase para el tipo enum. Usar MAYÚSCULAS para los valores.

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public enum Status {
    ACTIVE, INACTIVE, PENDING, DELETED
}
```



### Colecciones

Usar nombres plurales para colecciones. Usar nombres descriptivos para mapas.

```java
List<String> employeeNames = new ArrayList<>();
Set<Integer> userIds = new HashSet<>();
Map<Integer, String> idToNameMap = new HashMap<>();
```


### Booleanos
Prefijos recomendados: is, has, can, should.

```java
boolean isActive;
boolean hasPermission;
boolean canExecute;
boolean shouldValidate;
```


### Excepciones
Nombres deben terminar con "Exception". Mensajes descriptivos en constructores.

```java
public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String userId) {
        super("User with ID " + userId + " not found");
    }
}
```

### Organización de archivos  
Orden de Declaraciones

1. Comentario de copyright/licencia

1. Declaraciones de paquete

1. Declaraciones de import

1. Declaración de clase

1. Variables de clase (static)

1. Variables de instancia

1. Constructores

## Métodos

### Importaciones
Importaciones específicas en lugar de wildcards. Organizar imports: estándar Java primero, luego terceros, luego propias.

```java
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.company.project.model.User;
import com.company.project.service.UserService;
```  
### Comentarios
Javadoc
Usar para clases públicas, interfaces y métodos públicos. Incluir descripción, parámetros, valor de retorno, excepciones.

```java
/**
 * Calcula el total de la orden incluyendo impuestos.
 * 
 * @param subtotal el subtotal de la orden
 * @param taxRate la tasa de impuesto aplicable
 * @return el total con impuestos incluidos
 * @throws IllegalArgumentException si taxRate es negativo
 */
public double calculateTotal(double subtotal, double taxRate) {
    if (taxRate < 0) {
        throw new IllegalArgumentException("Tax rate cannot be negative");
    }
    return subtotal * (1 + taxRate);
}
```  
### Comentarios inline
Usar solo cuando sea necesario para aclarar lógica compleja. Evitar comentarios obvios.

```java
// Algoritmo de Dijkstra para encontrar el camino más corto
for (Node node : graph.getNodes()) {
    // Procesamiento complejo aquí
    // No usar comentarios como: "incrementar i"
    // Eso es obvio del código
}
```

## Prácticas recomendadas

### Principios SOLID
- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

### Clean Code
- Métodos pequeños (menos de 20 líneas)
- Nombres descriptivos y expresivos
- Evitar código duplicado
- Una responsabilidad por método/clase

### Patrones de diseño
- Usar Builder para objetos con muchos parámetros
- Factory Method para creación de objetos
- Strategy para algoritmos intercambiables
- Observer para notificaciones de eventos

---  

>Última actualización: Diciembre 2023  
>Basado en _Oracle Code Conventions_ y _Google Java Style Guide_
>
>---


