![Módulo](https://img.shields.io/badge/Módulo-Fundamentos_de_Programación-brown?style=for-the-badge)
![Proyecto](https://img.shields.io/badge/Proyecto-Aplicación_Java_Playlist_Manager-brown?style=for-the-badge)  
![Duración](https://img.shields.io/badge/Duración-50_horas-brown?style=for-the-badge)
![Profesor](https://img.shields.io/badge/Profesor-Ezequiel_Llarena_Borges-blue?style=for-the-badge)
--  
# Guía de referencia del proyecto: Playlist Manager

**Módulo:** Fundamentos de la Programación  
**Proyecto:** Integrador evolutivo en Java  
**Duración:** 50 horas / 3 trimestres · 1 hito de entrega por trimestre

---

## Cómo usar esta guía

El proyecto se construye de forma **incremental**: cada trimestre añade una capa nueva sobre lo entregado en el anterior. Para cada hito encontrarás:

1. Qué debes tener implementado en Java al final del trimestre.
2. La descripción de cada clase implicada (atributos y métodos).
3. Un esqueleto de código de partida (solo estructura, sin implementación) que debes completar.

Los esqueletos **no están pensados para compilar tal cual**: marcan la estructura de clases y métodos que se espera, y cada cuerpo de método queda señalado con `// TODO` para que lo completes tú.

---

## Trimestre 1  
## Entrega 1: Ficha de canción y funciones básicas

### Qué debes tener implementado
- Un programa con menú principal en bucle (`do-while`) que no termina hasta elegir "Salir".
- Uso de `switch` para las opciones del menú.
- Como mínimo tres funciones (métodos estáticos) con parámetros y valor de retorno.
- Validación de datos de entrada (por ejemplo, que la duración sea mayor que 0).
- Formateo de la duración de segundos a `mm:ss`.

### Clases

**`FichaCancionApp`**
Clase principal del programa. En este hito no se usan aún objetos: los datos de la canción se guardan en variables primitivas dentro de `main`.

| Método | Descripción |
|---|---|
| `main(String[] args)` | Punto de entrada; controla el bucle del menú. |
| `mostrarMenu(Scanner sc): int` | Muestra las opciones y devuelve la opción elegida. |
| `leerDuracionValida(Scanner sc): int` | Repite la lectura hasta obtener una duración válida (> 0). |
| `mostrarFicha(String, String, int): void` | Imprime los datos de la canción actual. |
| `formatearDuracion(int): String` | Convierte segundos a formato `mm:ss`. |

### Esqueleto de partida

```java
import java.util.Scanner;

/**
 * Playlist Manager - Hito 1
 * Ficha de una canción gestionada con variables primitivas y funciones.
 */
public class FichaCancionApp {

    public static void main(String[] args) {
        // TODO: declarar variables (titulo, artista, duracionSegundos, opcion)
        // TODO: bucle do-while que llama a mostrarMenu() y resuelve el switch
    }

    private static int mostrarMenu(Scanner sc) {
        // TODO: imprimir opciones y leer la opción elegida
        return 0;
    }

    private static int leerDuracionValida(Scanner sc) {
        // TODO: repetir lectura hasta que segundos > 0
        return 0;
    }

    private static void mostrarFicha(String titulo, String artista, int duracion) {
        // TODO: imprimir ficha formateada
    }

    private static String formatearDuracion(int segundos) {
        // TODO: devolver el string "m:ss"
        return null;
    }
}
```

---

## Trimestre 2 — Hito 2: Menú iterativo, excepciones y ficheros

### Qué debes tener implementado
- Un catálogo de canciones almacenado en un **array** (mínimo un array de `String` con los títulos).
- Búsqueda lineal dentro del array.
- Una **excepción personalizada** (`extends Exception`) lanzada con `throw` y capturada con `try-catch`.
- Persistencia del catálogo en un **fichero de texto**: guardar y recuperar los datos al iniciar/cerrar el programa.

### Clases

**`CatalogoPlaylist`**
Gestiona el catálogo de canciones en memoria y su persistencia en disco.

| Atributo | Descripción |
|---|---|
| `MAX: int` (constante) | Capacidad máxima del catálogo. |
| `titulos: String[]` | Array con los títulos almacenados. |
| `total: int` | Número de canciones actualmente guardadas. |

| Método | Descripción |
|---|---|
| `main(String[] args)` | Menú principal; carga el fichero al iniciar. |
| `anadir(String): void` | Añade un título; lanza `CatalogoLlenoException` si no hay espacio. |
| `buscar(String): int` | Búsqueda lineal; devuelve la posición o `-1`. |
| `guardarEnFichero(String): void` | Escribe el catálogo en un fichero de texto. |
| `cargarDesdeFichero(String): void` | Lee el fichero de texto al iniciar el programa. |

**`CatalogoLlenoException`**
Excepción personalizada para cuando el catálogo no tiene espacio libre.

| Método | Descripción |
|---|---|
| `CatalogoLlenoException(String mensaje)` | Constructor que delega el mensaje en `Exception`. |

### Esqueleto de partida

```java
import java.io.*;
import java.util.Scanner;

/**
 * Playlist Manager - Hito 2
 * Catálogo con arrays, excepciones y persistencia en fichero de texto.
 */
public class CatalogoPlaylist {
    private static final int MAX = 50;
    private static String[] titulos = new String[MAX];
    private static int total = 0;

    public static void main(String[] args) {
        // TODO: cargar el fichero al iniciar
        // TODO: bucle de menú (Añadir / Buscar / Guardar / Salir) con try-catch
    }

    private static void anadir(String titulo) throws CatalogoLlenoException {
        // TODO: comprobar espacio y lanzar CatalogoLlenoException si está lleno
    }

    private static int buscar(String titulo) {
        // TODO: búsqueda lineal, ignorando mayúsculas/minúsculas
        return -1;
    }

    private static void guardarEnFichero(String ruta) {
        // TODO: escribir cada título en una línea del fichero
    }

    private static void cargarDesdeFichero(String ruta) {
        // TODO: leer el fichero línea a línea si existe
    }
}

// Excepción personalizada para un catálogo sin espacio libre
class CatalogoLlenoException extends Exception {
    public CatalogoLlenoException(String mensaje) {
        // TODO: delegar el mensaje en el constructor de Exception
    }
}
```

---

## Trimestre 3 — Hito Final: Versión POO y base de datos (JDBC)

### Qué debes tener implementado
- El catálogo refactorizado a **objetos**: una clase `Cancion` con atributos privados y encapsulamiento (getters/setters).
- Una colección de objetos `Cancion` (array o `ArrayList<Cancion>`).
- Conexión a una base de datos relacional mediante **JDBC**.
- Las cuatro operaciones **CRUD** completas: insertar, listar/buscar, actualizar y eliminar.

### Clases

**`Cancion`**
Representa una canción como objeto, con encapsulamiento de sus datos.

| Atributo | Descripción |
|---|---|
| `id: int` | Identificador (coincide con la clave primaria en la base de datos). |
| `titulo: String` | Título de la canción. |
| `artista: String` | Artista o intérprete. |
| `duracionSegundos: int` | Duración en segundos. |

| Método | Descripción |
|---|---|
| `Cancion(String, String, int)` | Constructor sin id, para canciones nuevas aún no guardadas. |
| `Cancion(int, String, String, int)` | Constructor completo, usado al leer de la base de datos. |
| `getId/getTitulo/getArtista/getDuracionSegundos()` | Métodos de acceso (getters). |
| `setArtista(String): void` | Modifica el artista. |
| `toString(): String` | Representación legible de la canción. |

**`GestorPlaylistBD`**
Encapsula el acceso a la base de datos (patrón DAO simplificado).

| Método | Descripción |
|---|---|
| `insertar(Cancion): int` | Inserta una canción nueva y devuelve el id generado. |
| `listar(): List<Cancion>` | Devuelve todas las canciones almacenadas. |
| `buscarPorId(int): Cancion` | Devuelve una canción por su id, o `null` si no existe. |
| `actualizar(Cancion): boolean` | Actualiza los datos de una canción existente. |
| `eliminar(int): boolean` | Elimina una canción por su id. |

### Esqueleto de partida

```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Playlist Manager - Hito Final: modelo de objeto Cancion. */
public class Cancion {
    private int id;
    private String titulo;
    private String artista;
    private int duracionSegundos;

    public Cancion(String titulo, String artista, int duracionSegundos) {
        // TODO: delegar en el constructor de 4 parámetros con id = 0
    }

    public Cancion(int id, String titulo, String artista, int duracionSegundos) {
        // TODO: asignar los cuatro atributos
    }

    // TODO: getters de id, titulo, artista, duracionSegundos
    // TODO: setArtista(String)
    // TODO: toString()
}

/** Acceso a la base de datos relacional mediante JDBC (operaciones CRUD). */
class GestorPlaylistBD {
    private static final String URL = "jdbc:mysql://localhost:3306/playlist_db";
    private static final String USUARIO = "root";
    private static final String CLAVE = "clave";

    public int insertar(Cancion c) throws SQLException {
        // TODO: INSERT con PreparedStatement y RETURN_GENERATED_KEYS
        return -1;
    }

    public List<Cancion> listar() throws SQLException {
        // TODO: SELECT de todas las filas y mapeo a objetos Cancion
        return new ArrayList<>();
    }

    public Cancion buscarPorId(int id) throws SQLException {
        // TODO: SELECT ... WHERE id = ?
        return null;
    }

    public boolean actualizar(Cancion c) throws SQLException {
        // TODO: UPDATE ... SET titulo=?, artista=?, duracion=? WHERE id=?
        return false;
    }

    public boolean eliminar(int id) throws SQLException {
        // TODO: DELETE FROM canciones WHERE id = ?
        return false;
    }
}
```

---

## Retos finales del Trimestre 3

Los siguientes retos son de refuerzo sobre las dos partes más delicadas del proyecto: **ficheros** y **acceso a base de datos**. Se proponen como esqueletos casi completos para que puedas centrarte en la lógica concreta indicada en cada `TODO`.

### Reto A — Ficheros

```java
import java.io.*;

public class RetoFicheros {

    public static void escribirLinea(String ruta, String texto) throws IOException {
        // TODO: abrir el fichero en modo "append" (append = true) y escribir la línea
    }

    public static void leerFichero(String ruta) throws IOException {
        // TODO: abrir el fichero con BufferedReader y mostrar cada línea por consola
    }

    public static void main(String[] args) throws IOException {
        escribirLinea("historial.txt", "Canción reproducida: Ejemplo");
        // TODO: llamar a leerFichero("historial.txt") una vez la implementes
    }
}
```

### Reto B — Acceso a base de datos

```java
import java.sql.*;

public class RetoBaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/playlist_db";
    private static final String USUARIO = "root";
    private static final String CLAVE = "clave";

    public static Connection conectar() throws SQLException {
        // TODO: devolver la conexión con DriverManager.getConnection(...)
        return null;
    }

    public static void actualizarArtista(int id, String nuevoArtista) throws SQLException {
        // TODO: UPDATE canciones SET artista = ? WHERE id = ?
    }

    public static void eliminarCancion(int id) throws SQLException {
        // TODO: DELETE FROM canciones WHERE id = ?
    }

    public static void main(String[] args) throws SQLException {
        try (Connection con = conectar()) {
            System.out.println("Conexión establecida correctamente.");
        }
        // TODO: probar actualizarArtista(...) y eliminarCancion(...)
    }
}
```

---

*Profesor: Ezequiel Llarena Borges · Fundamentos de la Programación*
