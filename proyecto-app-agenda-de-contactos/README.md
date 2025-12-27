<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>

# Proyecto integrador: Sistema de Gestión de Agenda de Contactos  

Este proyecto permite al alumnado de ASIR desarrollar habilidades prácticas mientras construyen una aplicación útil, aplicando progresivamente todos los fundamentos de Java hasta culminar en un sistema orientado a objetos completo y funcional.

## Fundamentos de Programación en Java - ASIR1

-----

## **Descripción del proyecto**

Los estudiantes desarrollarán una **Agenda de Contactos Profesional** que permitirá:
- gestionar contactos personales y profesionales
- organizar grupos
- realizar búsquedas avanzadas
- generar estadísticas

 El proyecto se construirá de forma incremental a través de 8 prácticas, cada una aplicando conceptos fundamentales de programación en Java.

-----
 
## Demo aplicación Agenda de Contactos versión web (HTML + JavaScript + CSS)  
[Agenda de Contactos](www.zekiland.es)  

-----

## **PRÁCTICA 1: Introducción a Java y Estructura Básica**

>**Conceptos:** Sintaxis básica, variables, tipos de datos y entrada/salida

### Objetivos:

- Crear la estructura inicial del proyecto
- Implementar un menú de consola básico
- Trabajar con variables y tipos de datos primitivos

### Tareas:

1. Crear la clase principal `AgendaContactosApp` con el método `main`
1. Implementar un menú de texto que muestre opciones principales
1. Leer la opción del usuario usando `Scanner`
1. Declarar variables para almacenar información de un contacto individual:

- Nombre completo (String)
- Teléfono (String)
- Email (String)
- Empresa (String)
- Cargo (String)
- Edad (int)
- Favorito (boolean)

1. Crear un formulario simple para introducir datos de un contacto y mostrarlos

### Entregables:

- Código fuente de `AgendaContactosApp.java`
- Captura de pantalla mostrando entrada y salida de datos

-----

## **PRÁCTICA 2: Operadores y Expresiones**

>**Conceptos:** Operadores aritméticos, lógicos, relacionales y de asignación

### Objetivos:

- Implementar cálculos y estadísticas básicas de la agenda
- Utilizar operadores para validaciones

### Tareas:

1. Crear un módulo de estadísticas que calcule:

- Total de contactos registrados
- Porcentaje de contactos personales vs profesionales
- Porcentaje de contactos marcados como favoritos
- Edad promedio de los contactos
- Contador de contactos por rango de edad (menores 18, 18-30, 31-50, mayores 50)

1. Implementar validaciones usando operadores lógicos y relacionales:

- Verificar formato básico de email (contiene ‘@’ y ‘.’)
- Validar que el teléfono contenga solo dígitos
- Comprobar que la edad esté en rango válido (1-120)
- Validar campos obligatorios (nombre y teléfono no vacíos)

1. Usar operadores de asignación compuesta (+=, -=, etc.) para contadores

### Entregables:

- Clase `EstadisticasAgenda.java` con métodos de cálculo
- Ejemplos de ejecución mostrando validaciones y estadísticas

-----

## **PRÁCTICA 3: Estructuras de Control (Condicionales)**

>**Conceptos:** if, if-else, if-else-if, switch, operador ternario

### Objetivos:

- Implementar la lógica de decisión del sistema
- Gestionar el flujo del programa según las opciones del menú

### Tareas:

1. Implementar el switch para el menú principal con opciones:

- Añadir contacto
- Buscar contacto
- Listar contactos
- Editar contacto
- Eliminar contacto
- Estadísticas
- Configuración
- Salir

1. Crear un sistema de categorización de contactos usando if-else-if:

- Personal (familia, amigos)
- Profesional (trabajo, negocios)
- Servicios (médico, mecánico, etc.)
- Emergencias

1. Implementar clasificación automática por edad:

- Menor de edad
- Adulto joven (18-30)
- Adulto (31-60)
- Senior (+60)

1. Sistema de prioridad de contactos:

- Alta: Favoritos + Emergencias
- Media: Profesionales
- Baja: Resto

1. Validación de formato de email usando condiciones múltiples
1. Usar operador ternario para mostrar etiquetas: `String etiqueta = esFavorito ? "⭐ FAVORITO" : "NORMAL";`

### Entregables:

- Código actualizado con todas las estructuras condicionales
- Documento explicando la lógica de categorización
- Ejemplos de diferentes flujos del programa

-----

## **PRÁCTICA 4: Estructuras de Control (Bucles)**

>**Conceptos:** for, while, do-while, break, continue

### Objetivos:

- Implementar iteraciones para gestionar múltiples contactos
- Utilizar bucles para búsquedas y listados

### Tareas:

1. Usar un bucle `do-while` para mantener el menú activo hasta que el usuario elija salir
1. Implementar búsqueda de contactos usando diferentes bucles:

- Búsqueda por nombre usando `for`
- Búsqueda por teléfono usando `while`
- Búsqueda por email usando `for-each` (cuando se introduzcan arrays)

1. Crear listados con bucles:

- Listar TODOS los contactos (for)
- Listar solo favoritos (for con continue para saltar no favoritos)
- Listar por categoría (for con break si se encuentra el primero de una búsqueda específica)

1. Implementar validación de entrada con bucles:

- Repetir solicitud de email hasta que sea válido
- Repetir solicitud de edad hasta que esté en rango correcto

1. Menú de navegación paginada (mostrar 5 contactos por página)
1. Sistema de intentos para búsquedas (máximo 3 intentos)

### Entregables:

- Métodos de búsqueda y listado implementados
- Ejemplos de ejecución mostrando diferentes tipos de bucles
- Demostración de validaciones con bucles

-----

## **PRÁCTICA 5: Arrays y Estructuras de Datos**

>**Conceptos:** Arrays unidimensionales y bidimensionales

### Objetivos:

- Almacenar múltiples contactos en memoria
- Manipular colecciones de datos de forma eficiente

### Tareas:

1. Crear arrays paralelos para almacenar contactos (capacidad inicial: 100):

- `String[] nombres`
- `String[] telefonos`
- `String[] emails`
- `String[] empresas`
- `String[] cargos`
- `int[] edades`
- `boolean[] favoritos`
- `String[] categorias`

1. Implementar variable contador: `int totalContactos = 0`
1. Crear array bidimensional para historial de interacciones:

- `String[][] historial` donde cada fila representa: [fecha, tipo_interaccion, notas]
- Ejemplo: `historial[0] = {"27/12/2024", "Llamada", "Reunión programada"}`

1. Crear métodos para manipular arrays:

- `void agregarContacto(...)` - añade al final del array
- `int buscarContactoPorNombre(String nombre)` - devuelve índice o -1
- `void mostrarContacto(int indice)` - muestra datos formateados
- `void listarTodosContactos()` - recorre e imprime todos
- `void ordenarContactosPorNombre()` - algoritmo de burbuja
- `String[] obtenerFavoritos()` - retorna array solo con favoritos

1. Implementar búsqueda avanzada que retorne array de índices coincidentes
1. Crear copia de seguridad de contactos (clonar arrays)

### Entregables:

- Clase `GestorContactos.java` con todos los métodos
- Datos de prueba precargados (al menos 10 contactos)
- Demostración de operaciones CRUD completas
- Ejemplos de búsquedas y ordenamiento

-----

## **PRÁCTICA 6: Métodos y Modularización**

>**Conceptos:** Definición de métodos, parámetros, retorno de valores, sobrecarga, ámbito de variables

### Objetivos:

- Organizar el código en métodos reutilizables
- Aplicar buenas prácticas de programación modular
- Entender el paso de parámetros y retorno de valores

### Tareas:

1. Refactorizar el código existente creando métodos específicos y bien documentados:

   ```java
   void mostrarMenuPrincipal()
   void mostrarMenuBusqueda()
   int leerOpcion(int min, int max)
   String leerTexto(String mensaje)
   int leerEntero(String mensaje)
   boolean confirmarAccion(String mensaje)
   ```
1. Métodos de gestión de contactos:

   ```java
   void agregarContacto(String nombre, String telefono, String email, String empresa, String cargo, int edad, String categoria)
   boolean editarContacto(int indice, String campo, String nuevoValor)
   boolean eliminarContacto(int indice)
   void marcarComoFavorito(int indice)
   ```
1. Métodos de búsqueda (implementar sobrecarga):

   ```java
   int[] buscarContacto(String nombre)
   int[] buscarContacto(String nombre, String categoria)
   int buscarContactoPorTelefono(String telefono)
   int buscarContactoPorEmail(String email)
   ```
1. Métodos de validación:

   ```java
   boolean validarEmail(String email)
   boolean validarTelefono(String telefono)
   boolean validarEdad(int edad)
   boolean contactoExiste(String telefono)
   ```
1. Métodos de utilidad:

   ```java
   String formatearTelefono(String telefono)  // "+34 123 45 67 89"
   String obtenerIniciales(String nombreCompleto)  // "Juan Pérez" -> "JP"
   int calcularEdad(String fechaNacimiento)
   ```
1. Métodos de estadísticas y reportes:

   ```java
   void mostrarEstadisticasGenerales()
   void generarReportePorCategoria(String categoria)
   int contarContactosPorCategoria(String categoria)
   double calcularEdadPromedio()
   ```
1. Métodos privados auxiliares:

   ```java
   private void mostrarSeparador()
   private void limpiarPantalla()
   private String centrarTexto(String texto, int ancho)
   ```
1. Documentar TODOS los métodos con JavaDoc:

   ```java
   /**
    * Busca contactos por nombre (búsqueda parcial, no case-sensitive)
    * @param nombre Nombre o parte del nombre a buscar
    * @return Array con los índices de contactos encontrados, o array vacío si no hay coincidencias
    */
   ```

### Entregables:

- Código completamente modularizado y refactorizado
- Diagrama de flujo mostrando la jerarquía de llamadas entre métodos
- Documentación JavaDoc generada (HTML)
- Archivo README explicando cada método público

-----

## **PRÁCTICA 7: Programación Orientada a Objetos (Clases y Objetos)**

>**Conceptos:** Clases, objetos, atributos, métodos, constructores, encapsulación, this

### Objetivos:

- Transformar el sistema a un enfoque orientado a objetos
- Aplicar principios de encapsulación y abstracción
- Entender la diferencia entre datos primitivos y objetos

### Tareas:

1. **Crear la clase `Contacto`:**

   ```java
   public class Contacto {
       // Atributos privados
       private String nombre;
       private String telefono;
       private String email;
       private String empresa;
       private String cargo;
       private int edad;
       private boolean favorito;
       private String categoria;
       private String fechaCreacion;

       // Constructor completo
       public Contacto(String nombre, String telefono, String email,
                      String empresa, String cargo, int edad, String categoria) {
           // Implementación con validaciones
       }

       // Constructor sobrecargado (solo datos esenciales)
       public Contacto(String nombre, String telefono) {
           // Implementación
       }

       // Getters y Setters con validación
       public void setEmail(String email) {
           if (validarEmail(email)) {
               this.email = email;
           }
       }

       // Métodos de negocio
       public void marcarComoFavorito()
       public void cambiarCategoria(String nuevaCategoria)
       public boolean esProfesional()
       public String obtenerNombreCorto()

       // Métodos de utilidad
       public String toString()  // Formato legible
       public void mostrarInfo()  // Mostrar en consola formateado

       // Validaciones privadas
       private boolean validarEmail(String email)
       private boolean validarTelefono(String telefono)
   }
   ```
1. **Crear la clase `Grupo`:**

   ```java
   public class Grupo {
       private String nombre;
       private String descripcion;
       private int[] indicesContactos;  // Índices de contactos en este grupo
       private int totalContactos;

       public Grupo(String nombre, String descripcion)
       public void agregarContacto(int indice)
       public void eliminarContacto(int indice)
       public boolean contieneContacto(int indice)
       public int getTotalContactos()
       public String toString()
   }
   ```
1. **Crear la clase `Interaccion`:**

   ```java
   public class Interaccion {
       private String fecha;
       private String tipo;  // "Llamada", "Email", "Reunión", "Mensaje"
       private String notas;
       private int duracion;  // en minutos

       public Interaccion(String tipo, String notas)
       public Interaccion(String tipo, String notas, int duracion)
       public String getResumen()
       public String toString()
   }
   ```
1. **Refactorizar la clase `GestorContactos`:**

   ```java
   public class GestorContactos {
       private Contacto[] contactos;
       private Grupo[] grupos;
       private int totalContactos;
       private int totalGrupos;
       private final int CAPACIDAD_MAXIMA = 500;

       // Constructor
       public GestorContactos()

       // Métodos CRUD para contactos
       public boolean agregarContacto(Contacto contacto)
       public Contacto buscarPorTelefono(String telefono)
       public Contacto[] buscarPorNombre(String nombre)
       public boolean editarContacto(int indice, Contacto nuevoContacto)
       public boolean eliminarContacto(int indice)

       // Métodos para grupos
       public boolean crearGrupo(String nombre, String descripcion)
       public boolean agregarContactoAGrupo(int indiceContacto, int indiceGrupo)

       // Métodos de utilidad
       public int getTotalContactos()
       public Contacto[] obtenerFavoritos()
       public void ordenarPorNombre()
       public void mostrarTodos()
   }
   ```
1. **Actualizar la clase principal `AgendaContactosApp`:**

- Instanciar `GestorContactos`
- Trabajar con objetos `Contacto` en lugar de arrays paralelos
- Crear objetos para cada operación

1. **Implementar encapsulación completa:**

- Todos los atributos privados
- Acceso solo mediante getters/setters
- Validaciones en setters

1. **Precargar datos de prueba:**

   ```java
   private void cargarDatosPrueba() {
       gestor.agregarContacto(new Contacto("Ana García", "666123456",
           "ana@email.com", "TechCorp", "Desarrolladora", 28, "Profesional"));
       // ... más contactos
   }
   ```

### Entregables:

- Clases `Contacto.java`, `Grupo.java`, `Interaccion.java`
- Clase `GestorContactos.java` refactorizada
- Clase `AgendaContactosApp.java` actualizada
- **Diagrama de clases UML** mostrando:
  - Atributos y métodos de cada clase
  - Relaciones entre clases
  - Multiplicidad
- Documento explicando las decisiones de diseño OOP
- Código funcional con al menos 15 contactos de prueba

-----

## **PRÁCTICA 8: Proyecto Final Integrado**

>**Conceptos:** Integración completa + Strings avanzados, manejo de excepciones y persistencia básica

### Objetivos:

- Completar todas las funcionalidades del sistema
- Implementar manejo robusto de errores
- Añadir persistencia de datos
- Pulir la experiencia de usuario

### Tareas:

### **1. Gestión Avanzada de Strings (20%)**

```java
// En clase Contacto o utilidades
public static String normalizarNombre(String nombre) {
    // Capitalizar primera letra de cada palabra
    // "juan pérez garcía" -> "Juan Pérez García"
}

public static boolean validarEmailAvanzado(String email) {
    // Expresiones más completas
    // Verificar formato: texto@dominio.extension
}

public static String formatearTelefono(String telefono) {
    // "666123456" -> "+34 666 12 34 56"
    // Detectar prefijos internacionales
}

public static String generarIniciales(String nombreCompleto) {
    // "Juan Antonio Pérez García" -> "JAPG"
}

public static String[] separarNombreApellidos(String nombreCompleto) {
    // Dividir en nombre y apellidos
}

// Búsquedas insensibles a mayúsculas/minúsculas y acentos
public Contacto[] buscarFlexible(String termino) {
    // Buscar en nombre, email, empresa
    // Ignorar mayúsculas y acentos
}
```

### **2. Manejo Robusto de Excepciones (25%)**

```java
public class AgendaContactosApp {

    public static void main(String[] args) {
        try {
            AgendaContactosApp app = new AgendaContactosApp();
            app.iniciar();
        } catch (Exception e) {
            System.err.println("Error crítico: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int leerOpcion() {
        while (true) {
            try {
                System.out.print("Opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                return opcion;
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Debe introducir un número");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    private void agregarContactoConValidacion() {
        try {
            String nombre = leerTextoObligatorio("Nombre completo: ");
            String telefono = leerTelefonoValido();
            String email = leerEmailValido();
            int edad = leerEdadValida();

            Contacto contacto = new Contacto(nombre, telefono, email, edad);

            if (gestor.agregarContacto(contacto)) {
                System.out.println("✅ Contacto añadido correctamente");
            } else {
                System.out.println("❌ No se pudo añadir el contacto");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Datos inválidos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}

// En clase GestorContactos
public boolean agregarContacto(Contacto contacto) throws IllegalArgumentException {
    if (contacto == null) {
        throw new IllegalArgumentException("El contacto no puede ser nulo");
    }

    if (totalContactos >= CAPACIDAD_MAXIMA) {
        throw new IllegalArgumentException("Agenda llena");
    }

    if (existeTelefono(contacto.getTelefono())) {
        throw new IllegalArgumentException("Ya existe un contacto con ese teléfono");
    }

    // ... lógica de inserción
}
```

### **3. Persistencia Básica en Archivos de Texto (30%)**

```java
import java.io.*;

public class GestorArchivos {
    private static final String ARCHIVO_CONTACTOS = "contactos.txt";
    private static final String SEPARADOR = "|";

    /**
     * Guarda todos los contactos en archivo de texto
     */
    public static boolean guardarContactos(Contacto[] contactos, int total) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_CONTACTOS))) {

            for (int i = 0; i < total; i++) {
                Contacto c = contactos[i];
                String linea = String.format("%s%s%s%s%s%s%s%s%s%s%d%s%b%s%s",
                    c.getNombre(), SEPARADOR,
                    c.getTelefono(), SEPARADOR,
                    c.getEmail(), SEPARADOR,
                    c.getEmpresa(), SEPARADOR,
                    c.getCargo(), SEPARADOR,
                    c.getEdad(), SEPARADOR,
                    c.esFavorito(), SEPARADOR,
                    c.getCategoria()
                );
                writer.println(linea);
            }

            System.out.println("✅ Contactos guardados correctamente");
            return true;

        } catch (IOException e) {
            System.err.println("❌ Error al guardar: " + e.getMessage());
            return false;
        }
    }

    /**
     * Carga contactos desde archivo de texto
     */
    public static Contacto[] cargarContactos() {
        Contacto[] contactos = new Contacto[500];
        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CONTACTOS))) {

            String linea;
            while ((linea = reader.readLine()) != null && contador < 500) {
                String[] datos = linea.split("\\" + SEPARADOR);

                if (datos.length >= 8) {
                    Contacto c = new Contacto(
                        datos[0],  // nombre
                        datos[1],  // telefono
                        datos[2],  // email
                        datos[3],  // empresa
                        datos[4],  // cargo
                        Integer.parseInt(datos[5]),  // edad
                        datos[7]   // categoria
                    );

                    if (Boolean.parseBoolean(datos[6])) {
                        c.marcarComoFavorito();
                    }

                    contactos[contador++] = c;
                }
            }

            System.out.println("✅ Cargados " + contador + " contactos");

        } catch (FileNotFoundException e) {
            System.out.println("ℹ️ No se encontró archivo previo. Iniciando agenda vacía.");
        } catch (IOException e) {
            System.err.println("❌ Error al cargar: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("❌ Error en formato de datos");
        }

        return contactos;
    }

    /**
     * Exporta contactos a formato CSV
     */
    public static void exportarCSV(Contacto[] contactos, int total, String archivo) {
        // Implementar exportación CSV
    }
}
```

### **4. Funcionalidades Avanzadas Completas (15%)**

- **Exportación/Importación**: CSV, TXT
- **Filtros avanzados**: Por categoría, edad, favoritos, empresa
- **Ordenamiento múltiple**: Por nombre, edad, categoría, fecha de creación
- **Grupos y etiquetas**: Organizar contactos en grupos personalizados
- **Historial de interacciones**: Registrar llamadas, emails, reuniones
- **Estadísticas completas**:
  - Contactos por categoría (gráfico de barras ASCII)
  - Distribución por edades
  - Empresas más frecuentes
  - Top 10 contactos con más interacciones

### **5. Interfaz de Usuario Mejorada (10%)**

```java
public class InterfazConsola {

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mostrarCabecera() {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║          AGENDA DE CONTACTOS PROFESIONAL         ║");
        System.out.println("║                  Versión 1.0                     ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("\n┌─────────── MENÚ PRINCIPAL ───────────┐");
        System.out.println("│ 1. 👤 Añadir contacto               │");
        System.out.println("│ 2. 🔍 Buscar contacto               │");
        System.out.println("│ 3. 📋 Listar contactos              │");
        System.out.println("│ 4. ✏️  Editar contacto               │");
        System.out.println("│ 5. 🗑️  Eliminar contacto             │");
        System.out.println("│ 6. ⭐ Gestionar favoritos           │");
        System.out.println("│ 7. 📊 Estadísticas                  │");
        System.out.println("│ 8. 💾 Guardar y Salir               │");
        System.out.println("└──────────────────────────────────────┘");
    }

    public static void mostrarContacto(Contacto c) {
        System.out.println("┌────────────────────────────────────────┐");
        System.out.printf("│ %s %s%n",
            c.esFavorito() ? "⭐" : "  ",
            c.getNombre());
        System.out.println("├────────────────────────────────────────┤");
        System.out.printf("│ 📞 %s%n", c.getTelefono());
        System.out.printf("│ 📧 %s%n", c.getEmail());
        System.out.printf("│ 🏢 %s - %s%n", c.getEmpresa(), c.getCargo());
        System.out.printf("│ 🎂 %d años%n", c.getEdad());
        System.out.printf("│ 🏷️  %s%n", c.getCategoria());
        System.out.println("└────────────────────────────────────────┘");
    }
}
```

### **Entregables Finales:**

1. **Código fuente completo** (bien organizado en paquetes):

- `main/AgendaContactosApp.java`
- `modelo/Contacto.java`
- `modelo/Grupo.java`
- `modelo/Interaccion.java`
- `gestor/GestorContactos.java`
- `gestor/GestorArchivos.java`
- `util/Validaciones.java`
- `util/InterfazConsola.java`

2. **Manual de Usuario** (PDF, 8-10 páginas):

- Introducción y características
- Guía de instalación
- Tutorial paso a paso con capturas
- Casos de uso comunes
- Solución de problemas frecuentes

3. **Memoria Técnica** (PDF, 10-15 páginas):

- Análisis y diseño del sistema
- Diagrama de clases UML completo
- Decisiones de diseño justificadas
- Estructura de datos utilizada
- Manejo de errores implementado
- Dificultades encontradas y soluciones
- Pruebas realizadas
- Posibles mejoras futuras (ArrayList, HashMap, base de datos, interfaz gráfica)

4. **Vídeo Demostración** (8-12 minutos):

- Presentación del proyecto
- Demostración de todas las funcionalidades
- Casos de uso reales
- Explicación del código más relevante

5. **Presentación para defensa** (PowerPoint/PDF, 15-20 diapositivas):

- Portada y objetivos
- Arquitectura del sistema
- Funcionalidades implementadas
- Código destacado
- Demostración en vivo
- Conclusiones y aprendizajes

6. **Archivo de datos de prueba** con 20-30 contactos precargados

-----

## **Criterios de Evaluación**

|Criterio                                                   |Práctica 8|Global Proyecto|
|-----------------------------------------------------------|----------|---------------|
|**Funcionalidad completa y correcta**                      |35%       |40%            |
|**Calidad del código** (organización, nombres, comentarios)|20%       |20%            |
|**Aplicación correcta de OOP**                             |15%       |15%            |
|**Manejo robusto de errores**                              |10%       |10%            |
|**Persistencia de datos**                                  |10%       |-              |
|**Documentación completa**                                 |5%        |10%            |
|**Presentación y defensa oral**                            |5%        |5%             |

-----

## **Rúbrica - Práctica Final**

### Excelente (9-10):

- Todas las funcionalidades implementadas y funcionando perfectamente
- Código limpio, modular y bien documentado
- Manejo exhaustivo de excepciones
- Persistencia robusta con validación de datos
- Interfaz de usuario intuitiva y profesional
- Documentación completa y de calidad

### Notable (7-8):

- Funcionalidades principales implementadas
- Código organizado con documentación adecuada
- Manejo básico de excepciones
- Persistencia funcional
- Interfaz clara
- Documentación suficiente

### Aprobado (5-6):

- Funcionalidades básicas funcionando
- Código funcional aunque mejorable
- Manejo mínimo de errores
- Persistencia básica
- Documentación mínima

### Suspenso (<5):

- Funcionalidades incompletas o con errores graves
- Código desorganizado o sin documentar
- Sin manejo de excepciones
- Documentación insuficiente

-----

## **Calendario estimado** (18 semanas)

|Semana|Práctica  |Contenido                       |
|------|----------|--------------------------------|
|1-2   |Práctica 1|Introducción y estructura básica|
|3     |Práctica 2|Operadores y expresiones        |
|4-5   |Práctica 3|Estructuras condicionales       |
|6-7   |Práctica 4|Bucles                          |
|8-9   |Práctica 5|Arrays                          |
|10-11 |Práctica 6|Métodos y modularización        |
|12-14 |Práctica 7|POO - Clases y objetos          |
|15-18 |Práctica 8|Integración final               |

-----

## **Recursos y Herramientas**

### Obligatorios:

- **JDK**: Java Development Kit 11 o superior
- **IDE**: IntelliJ IDEA Community Edition (recomendado) o Eclipse
- **Git**: Control de versiones *(Opcional)*  
- **GitHub**: Repositorio del proyecto *(Opcional)*  

### Recomendados:

- **draw.io / Lucidchart**: Diagramas UML
- **Markdown**: Documentación README
- **OBS Studio**: Grabación del vídeo
- **Canva / PowerPoint**: Presentación

### Documentación:

- [Java: Guía de estudio y manual de consulta | Ezequiel Llarena Borges](https://github.com/ezellabor/Fundamentos-de-Programacion-ASIR1/blob/main/guia-estudio-Java/README.md)
- Oracle Java Documentation
- Java Tutorials ([docs.oracle.com](http://docs.oracle.com))
- Stack Overflow para consultas específicas

-----

## **Extras Opcionales (para subir nota)**

- Implementar backup automático cada X operaciones
- Sistema de recuperación de contactos eliminados (papelera)
- Cifrado básico de datos sensibles
- Importación desde VCard (.vcf)
- Búsqueda con expresiones regulares
- Colores en consola (ANSI codes)
- Logs de operaciones
- Tests unitarios básicos

-----

<code>Fundamentos de Programación | ASIR1 | Profesor: Ezequiel Llarena Borges</code>
​​​​​​​​​​​​​​​​










