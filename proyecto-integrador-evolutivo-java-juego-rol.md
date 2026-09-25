# Programación Didáctica y Proyecto Evolutivo Integrador

**Módulo:** Fundamentos de Programación (Optativo - 1º ASIR)  
**Profesor:** Ezequiel Llarena Borges  
**Carga horaria:** 50 horas anuales (25 sesiones de 2 horas / 1 sesión semanal)  
**Lenguaje:** Java (JDK 17+)  

---

## 1. Resumen y Estrategia Didáctica

Debido a la restricción temporal de **2 horas semanales** (50 horas totales), la estrategia se centra en **desconectar al alumnado del perfil de administración de sistemas** durante la fase de aprendizaje para enfocarlos exclusivamente en la **lógica de programación pura** a través de la gamificación.

### El Proyecto: "JavaQuest Lite" (Juego de Rol Retro por Consola)
El alumno construirá paso a paso un minijuego de aventuras interactivo donde controlará a un héroe que combate monstruos, gestiona su inventario/puntuación y guarda su récord en un *Hall of Fame*.

**¿Por qué este proyecto?**
* **Inspirador y Lúdico:** La mecánica de un juego es intuitiva y altamente motivadora.
* **POO Natural:** Entender `Clase` (Personaje), `Atributos` (Vida, Fuerza), `Herencia` (Guerrero/Mago derivan de Personaje) y `Métodos` (`atacar()`, `curar()`) resulta 100% intuitivo.
* **Proyección al perfil:** En las últimas semanas (UT6), se planteará como reto opcional reutilizar la estructura aprendida para cualquier otra temática de su interés.

---

## 2. Cronograma Semanal y Prácticas Obligatorias (25 Semanas / 50 Horas)

### TRIMESTRE 1: Introducción, Fundamentos y Funciones (UT1 y UT2)
* **Resultados de Aprendizaje:** RA1 (10%), RA2 (20%)

| Sesión (2h) | UT | Contenidos Teórico-Prácticos | Práctica Obligatoria (Proyecto Evolutivo) | Criterios Eval. |
| :--- | :--- | :--- | :--- | :--- |
| **Semana 1** | UT1 | Entorno IDE, JDK, estructura de `main`, compilación y ejecución. | **P1.1:** Creación del proyecto `JavaQuest`. Pantalla de bienvenida con arte ASCII. | RA1.a, RA1.b, RA1.c |
| **Semana 2** | UT1 | Variables, tipos primitivos (`String`, `int`, `boolean`), constantes, comentarios. | **P1.2:** Variables del héroe (`nombre`, `puntosVida`, `fuerza`, `esHumano`). | RA1.d, RA1.e, RA1.f, RA1.i |
| **Semana 3** | UT1 | Operadores, lectura por consola (`Scanner`), conversiones de tipo. | **P1.3:** Formulario de creación del héroe leyendo datos por teclado. | RA1.g, RA1.h |
| **Semana 4** | UT2 | Concepto de función/método estático, parámetros de entrada y retorno. | **P2.1:** Funciones para calcular el daño de un ataque (`lanzarDado()`, `calcularDanio()`). | RA2.a, RA2.b, RA2.c, RA2.d |
| **Semana 5** | UT2 | Modularización y reutilización de código en Java. | **P2.2:** Creación de métodos de combate aislados (`simularAtaque()`, `mostrarEstado()`). | RA2.a, RA2.c |
| **Semana 6** | UT2 | Librerías estándar (`java.util`), uso básico de `ArrayList`. | **P2.3:** Creación de un inventario simple de objetos/pociones en un `ArrayList<String>`. | RA2.e |
| **Semana 7** | UT1-2 | Integración del 1º Trimestre y prueba práctica individual. | **Evaluación T1:** Prueba en aula creando métodos de simulación de dados y combate. | RA1, RA2 |

---

### TRIMESTRE 2: Control de Flujo y Programación Orientada a Objetos (UT3 y UT4)
* **Resultados de Aprendizaje:** RA3 (25%), RA4 (20%)

| Sesión (2h) | UT | Contenidos Teórico-Prácticos | Práctica Obligatoria (Proyecto Evolutivo) | Criterios Eval. |
| :--- | :--- | :--- | :--- | :--- |
| **Semana 8** | UT3 | Selección condicional (`if-else`, `switch`). | **P3.1:** Decisiones en la mazmorra (Atacar, Huir, Usar Poción). | RA3.a |
| **Semana 9** | UT3 | Bucle interactivo (`while`, `for`). | **P3.2:** Bucle principal del combate mientras el héroe y el monstruo tengan vida. | RA3.b, RA3.c |
| **Semana 10** | UT3 | Control de excepciones (`try-catch`, `NumberFormatException`). | **P3.3:** Validación del menú de opciones para evitar cierres del juego ante entradas erróneas. | RA3.d, RA3.e, RA3.f |
| **Semana 11** | UT3 | Práctica intensiva de depuración y pruebas de flujos. | **P3.4:** Depuración paso a paso del turno de combate y corrección de fallos. | RA3.f |
| **Semana 12** | UT4 | Introducción a POO: Clase, atributos, métodos y modificadores (`public`, `private`). | **P4.1:** Creación de la clase `Personaje`. Encapsulamiento con Getters y Setters. | RA4.a, RA4.c |
| **Semana 13** | UT4 | Constructores y gestión de memoria. | **P4.2:** Instanciación del héroe y del enemigo como objetos de la clase `Personaje`. | RA4.a |
| **Semana 14** | UT4 | Concepto de Herencia (`extends`) y uso de `super`. | **P4.3:** Creación de la subclase `Mago` que hereda de `Personaje` e incluye `puntosMana`. | RA4.b |
| **Semana 15** | UT4 | Polimorfismo y sobrescritura de métodos (`@Override`). | **P4.4:** Sobrescritura de `atacar()` en `Mago` para usar hechizos mágicos. | RA4.a, RA4.b |
| **Semana 16** | UT3-4 | Integración del 2º Trimestre y prueba práctica de POO. | **Evaluación T2:** Creación de una subclase `Guerrero` con habilidad de escudo. | RA3, RA4 |

---

### TRIMESTRE 3: Persistencia en Ficheros y Bases de Datos (UT5 y UT6)
* **Resultados de Aprendizaje:** RA5 (10%), RA6 (15%)

| Sesión (2h) | UT | Contenidos Teórico-Prácticos | Práctica Obligatoria (Proyecto Evolutivo) | Criterios Eval. |
| :--- | :--- | :--- | :--- | :--- |
| **Semana 17** | UT5 | Entrada/Salida por consola formateada (`System.out.printf`). | **P5.1:** Formateo gráfico en consola de las barras de vida y puntuaciones. | RA5.a, RA5.b, RA5.c |
| **Semana 18** | UT5 | Manejo de ficheros de texto (`PrintWriter`, `BufferedReader`). | **P5.2:** Guardar el historial de partidas ganadas en `partidas.csv`. | RA5.d |
| **Semana 19** | UT5 | Lectura y parseo de datos desde archivos planos. | **P5.3:** Cargar el ranking de jugadores al iniciar el juego. | RA5.e |
| **Semana 20** | UT6 | Conceptos de BBDD relacionales desde Java y conectores JDBC. | **P6.1:** Configuración de la librería JDBC (SQLite / MySQL) en el proyecto. | RA6.a |
| **Semana 21** | UT6 | Conexión con BBDD (`DriverManager`, `Connection`). | **P6.2:** Creación de la clase `ConexionBD` y tabla de *Hall of Fame*. | RA6.b |
| **Semana 22** | UT6 | Consultas e Inserciones SQL (`SELECT`, `INSERT`) con `PreparedStatement`. | **P6.3:** Guardar los récords de partidas ganadas en la BD relacional. | RA6.c, RA6.d, RA6.f |
| **Semana 23** | UT6 | Actualización y Borrado (`UPDATE`, `DELETE`). | **P6.4:** Implementar borrado de partidas guardadas o actualización de nivel de personaje. | RA6.e |
| **Semana 24** | UT6 | Proyecto Final / Transición al perfil técnico (Opcional). | **P6.5:** Finalización del juego O propuesta de adaptación libre del modelo a su perfil. | RA6.g |
| **Semana 25** | Cierre | Entrega final y demostración del juego `JavaQuest Lite`. | **Evaluación Final:** Presentación funcional del proyecto completo. | RA1 - RA6 |

---

## 3. Código Fuente Integrador (Modelo POO Mínimo para 50h)

Este código representa la **versión mínima funcional** que alcanzará el alumnado al completar el curso. La estructura es ultra-sencilla y fácil de seguir.

### Arquitectura de Ficheros
```text
src/
├── Personaje.java      (UT4 - Clase Base)
├── Mago.java           (UT4 - Subclase / Herencia)
├── GestorPartidas.java (UT5 y UT6 - Ficheros y JDBC)
└── JuegoApp.java       (UT1, UT2, UT3 - Programa Principal / Bucle del Juego)
```

---

### `Personaje.java` (UT4 - RA4.a, RA4.c)

```java
/**
 * Clase base que representa un personaje dentro del juego.
 * Muestra el uso de encapsulamiento (atributos privados) y métodos.
 */
public class Personaje {
    private String nombre;
    private int puntosVida;
    private int fuerza;

    // Constructor
    public Personaje(String nombre, int puntosVida, int fuerza) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.fuerza = fuerza;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPuntosVida() { return puntosVida; }
    public void setPuntosVida(int puntosVida) { this.puntosVida = Math.max(0, puntosVida); }

    public int getFuerza() { return fuerza; }

    // Método de combate básico
    public int atacar() {
        // Devuelve un daño basado en su fuerza + un valor aleatorio entre 1 y 6
        return fuerza + (int) (Math.random() * 6 + 1);
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public String obtenerEstado() {
        return String.format("Heroe: %-10s | Vida: %3d | Fuerza: %2d", nombre, puntosVida, fuerza);
    }
}
```

---

### `Mago.java` (UT4 - RA4.b)

```java
/**
 * Subclase especial que hereda de Personaje.
 * Demuestra el concepto de Herencia y Sobrescritura de métodos (Polimorfismo).
 */
public class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int puntosVida, int fuerza, int mana) {
        super(nombre, puntosVida, fuerza);
        this.mana = mana;
    }

    public int getMana() { return mana; }

    // Sobrescritura del método atacar (Ataque Mágico si tiene Mana)
    @Override
    public int atacar() {
        if (mana >= 5) {
            mana -= 5;
            System.out.println("-> ¡" + getNombre() + " lanza una Bola de Fuego! (Mana restante: " + mana + ")");
            return super.getFuerza() + 10; // Ataque potenciado
        } else {
            System.out.println("-> ¡Sin mana suficiente! Ataque básico con bastón.");
            return super.atacar();
        }
    }

    @Override
    public String obtenerEstado() {
        return super.obtenerEstado() + String.format(" | Mana: %2d", mana);
    }
}
```

---

### `GestorPartidas.java` (UT5 y UT6 - RA5.d, RA5.e, RA6.b, RA6.c)

```java
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Gestiona la persistencia de datos:
 * - UT5: Guardar ranking en fichero .csv
 * - UT6: Guardar historial en Base de Datos SQLite (JDBC)
 */
public class GestorPartidas {

    private static final String FICHERO_RANKING = "ranking.csv";
    private static final String URL_BD = "jdbc:sqlite:javaquest.db";

    // --- UT5: PERSISTENCIA EN FICHEROS ---

    public static void guardarPuntuacionCSV(String jugador, int puntos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_RANKING, true))) {
            pw.println(jugador + "," + puntos);
            System.out.println("[UT5] Puntuación guardada en " + FICHERO_RANKING);
        } catch (IOException e) {
            System.out.println("[ERROR UT5] No se pudo guardar el archivo: " + e.getMessage());
        }
    }

    public static void mostrarRankingCSV() {
        File f = new File(FICHERO_RANKING);
        if (!f.exists()) {
            System.out.println("No hay puntuaciones registradas aún.");
            return;
        }

        System.out.println("\n--- RANKING DE JUGADORES (FICHERO CSV) ---");
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    System.out.printf("Jugador: %-12s | Puntos: %s%n", datos[0], datos[1]);
                }
            }
        } catch (Exception e) {
            System.out.println("[ERROR UT5] Error al leer el ranking: " + e.getMessage());
        }
    }

    // --- UT6: PERSISTENCIA EN BASE DE DATOS (JDBC) ---

    public static void inicializarBD() {
        String sql = "CREATE TABLE IF NOT EXISTS hall_of_fame (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombre TEXT NOT NULL, " +
                     "puntuacion INTEGER NOT NULL);";
        try (Connection conn = DriverManager.getConnection(URL_BD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("[UT6] Base de datos SQLite inicializada correctamente.");
        } catch (SQLException e) {
            System.out.println("[ERROR UT6] Error de conexión a BD: " + e.getMessage());
        }
    }

    public static void guardarEnBD(String jugador, int puntos) {
        String sql = "INSERT INTO hall_of_fame(nombre, puntuacion) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL_BD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, jugador);
            pstmt.setInt(2, puntos);
            pstmt.executeUpdate();
            System.out.println("[UT6] Record registrado en el Hall of Fame (BD).");
        } catch (SQLException e) {
            System.out.println("[ERROR UT6] Error al guardar en BD: " + e.getMessage());
        }
    }
}
```

---

### `JuegoApp.java` (UT1, UT2, UT3 - RA1, RA2, RA3)

```java
import java.util.Scanner;

/**
 * Programa principal que controla la interacción por consola, el bucle de juego
 * y el menú de opciones.
 */
public class JuegoApp {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar persistencia de datos
        GestorPartidas.inicializarBD();

        System.out.println("==============================================");
        System.out.println("   ¡BIENVENIDO A JAVAQUEST LITE (1º ASIR)!   ");
        System.out.println("==============================================");

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        jugarPartida();
                        break;
                    case 2:
                        GestorPartidas.mostrarRankingCSV();
                        break;
                    case 3:
                        salir = true;
                        System.out.println("¡Gracias por jugar a JavaQuest!");
                        break;
                    default:
                        System.out.println("[ERROR] Seleccione una opción entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                // Manejo de excepciones (UT3 - RA3.d)
                System.out.println("[ERROR] Por favor, ingrese un número válido.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Ver Hall of Fame (Ranking)");
        System.out.println("3. Salir");
        System.out.print("Elija una opción: ");
    }

    private static void jugarPartida() {
        System.out.print("\nIngrese el nombre de su héroe: ");
        String nombre = teclado.nextLine();

        // Creación del héroe (Uso de la subclase Mago)
        Mago heroe = new Mago(nombre, 50, 8, 15);
        Personaje monstruo = new Personaje("Orco de las Sombras", 30, 5);

        System.out.println("\n¡Un " + monstruo.getNombre() + " ha aparecido!");

        // Bucle de combate (UT3 - RA3.b)
        int rondas = 0;
        while (heroe.estaVivo() && monstruo.estaVivo()) {
            rondas++;
            System.out.println("\n--- RONDA " + rondas + " ---");
            System.out.println(heroe.obtenerEstado());
            System.out.println(monstruo.obtenerEstado());

            System.out.print("\n¿Qué deseas hacer? (1: Atacar, 2: Huir): ");
            String accion = teclado.nextLine();

            if (accion.equals("1")) {
                // Turno del héroe
                int danioHeroe = heroe.atacar();
                monstruo.setPuntosVida(monstruo.getPuntosVida() - danioHeroe);
                System.out.println("-> Causas " + danioHeroe + " de daño al " + monstruo.getNombre());

                // Turno del monstruo (si sigue vivo)
                if (monstruo.estaVivo()) {
                    int danioMonstruo = monstruo.atacar();
                    heroe.setPuntosVida(heroe.getPuntosVida() - danioMonstruo);
                    System.out.println("-> El " + monstruo.getNombre() + " te inflige " + danioMonstruo + " de daño.");
                }
            } else if (accion.equals("2")) {
                System.out.println("¡Has huido cobardemente del combate!");
                return;
            } else {
                System.out.println("Opción no válida. Pierdes el turno.");
            }
        }

        // Fin de la partida
        if (heroe.estaVivo()) {
            int puntos = heroe.getPuntosVida() * 10;
            System.out.println("\n¡VICTORIA! Has derrotado al " + monstruo.getNombre());
            System.out.println("Puntuación final: " + puntos + " pts.");

            // Guardar resultados (UT5 y UT6)
            GestorPartidas.guardarPuntuacionCSV(heroe.getNombre(), puntos);
            GestorPartidas.guardarEnBD(heroe.getNombre(), puntos);
        } else {
            System.out.println("\n¡HAS SIDO DERROTADO! Tu héroe ha caído en combate...");
        }
    }
}
```

---

## 4. Instrucciones de Implementación y Ejecución

1. **Requisitos de Software:**
   * Tener instalado **JDK 17** o superior.
   * Cualquier IDE básico de Java (VS Code con Java Extension Pack, NetBeans o Eclipse).

2. **Configuración del Proyecto:**
   * Crear un proyecto Java denominado `JavaQuest`.
   * Copiar los cuatro archivos Java (`Personaje.java`, `Mago.java`, `GestorPartidas.java`, `JuegoApp.java`) en la carpeta fuente `src/`.

3. **Librería Externa (Opcional para UT6):**
   * Descargar el driver `sqlite-jdbc.jar` para habilitar la persistencia en Base de Datos de la UT6 y agregarlo a las dependencias del proyecto.

4. **Compilación y Ejecución:**
   ```bash
   javac *.java
   java JuegoApp
   ```