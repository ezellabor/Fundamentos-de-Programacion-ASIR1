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

## Estructura de Código

### Declaraciones
- Una declaración por línea
- Declarar variables donde se usan por primera vez
- Inicializar variables locales en su declaración

### Espaciado
- Usar 4 espacios para indentación (NO tabs)
- Línea en blanco entre métodos
- Línea en blanco entre secciones lógicas dentro de métodos

### Longitud de Línea
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
