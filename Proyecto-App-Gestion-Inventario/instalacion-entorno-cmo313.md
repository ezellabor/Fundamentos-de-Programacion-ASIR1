# Instalación del entorno de desarrollo

**CMO-313. Fundamentos de programación (Java) · Primeros pasos**

Guía rápida para instalar y comprobar tu entorno de programación en Java antes de empezar con el proyecto GestorInventario.  

| Opción | Cuándo usarla |
|---|---|
| 🟠 **IntelliJ IDEA Community** (*Recomendada*) | Instalación que detecta el JDK automáticamente y muestra mensajes de error más claros. |
| 🔵 **Visual Studio Code** (*Alternativa*) | Más ligero. Recomendable si ya lo usas en otros módulos del ciclo, o si el equipo es limitado. |
| 🟢 **IDEs online** (*Emergencia / Casa*) | Sin instalación. Útil los primeros días o para repasar desde casa. Nunca como entorno principal del módulo. |

---

## 01 · IntelliJ IDEA Community Edition

Es la opción recomendada para este módulo: gestiona el JDK por ti y da mensajes de error más claros, algo especialmente útil en los ejercicios de "encontrar el error".

**Descarga:** [www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download/)

1. **Descargar el instalador.** Entra en el enlace de arriba, elige tu sistema operativo (Windows / macOS / Linux) y descarga la edición **Community** (gratuita). No hace falta la edición Ultimate.

2. **Instalar.** Ejecuta el instalador y sigue el asistente con las opciones por defecto. En Windows, marca la casilla para añadir un acceso directo en el escritorio.

3. **Crear el proyecto GestorInventario.** Abre IntelliJ → `New Project` → selecciona `Java` como lenguaje. En el desplegable de JDK, elige `Download JDK...` si no aparece ninguno instalado.
   > Elige la versión **21 (LTS)** del JDK y cualquier proveedor de la lista (Amazon Corretto, Eclipse Temurin...); para este módulo da igual cuál.

4. **Pegar el código y ejecutar.** Sustituye el contenido de `Main.java` por el código de `GestorInventario.java` (o crea una clase con ese nombre). Pulsa el triángulo ▶ verde junto al método `main`, o `Shift + F10`.

5. **Comprobar la consola.** En la pestaña *Run*, en la parte inferior, debe aparecer el menú del programa. Escribe ahí mismo las opciones cuando el programa las pida.

**Cómo saber que todo funciona:**
```
=== Gestor de Inventario de Componentes ===
1) Listar componentes
2) Anadir componente
...
Elige una opcion:
```

---

## 02 · Visual Studio Code + Java

A diferencia de IntelliJ, VS Code no es un IDE de Java por sí mismo: necesita el JDK instalado aparte y una extensión. Tarda un poco más en dejarlo listo, así que resérvate unos minutos extra.

**Descarga:** [code.visualstudio.com/download](https://code.visualstudio.com/download)

> ⚠️ **Antes de empezar:** instala primero el JDK y después VS Code y la extensión, en ese orden, o la extensión puede no detectarlo.

1. **Instalar el JDK 21 (LTS).** Descarga e instala el JDK desde [adoptium.net](https://adoptium.net/) (Eclipse Temurin, gratuito y de código abierto), eligiendo la versión **21** para tu sistema operativo.

2. **Instalar Visual Studio Code.** Descarga el instalador desde el enlace de arriba y ejecútalo con las opciones por defecto.

3. **Instalar el paquete de extensiones de Java.** Dentro de VS Code, abre la pestaña de *Extensiones* (icono de piezas en la barra lateral, o `Ctrl+Shift+X`) y busca `Extension Pack for Java` (de Microsoft). Instálalo: incluye todo lo necesario (autocompletado, depurador, ejecución de pruebas).

4. **Crear la carpeta del proyecto.** Crea una carpeta llamada `GestorInventario` en tu equipo, ábrela con `Archivo → Abrir carpeta` y crea dentro un archivo `GestorInventario.java`.

5. **Pegar el código y ejecutar.** Pega el contenido de `GestorInventario.java`. Cuando la extensión termine de analizar el archivo (puede tardar unos segundos la primera vez), aparecerá un enlace `Run` justo encima del método `main`. Púlsalo.

6. **Comprobar la consola.** El menú del programa debe aparecer en el panel *Terminal* de la parte inferior; escribe ahí las opciones cuando el programa las pida.

---

## 03 · IDEs online

Solo para el primer día (mientras se termina de instalar IntelliJ) o para repasar en casa desde un equipo sin nada instalado. No los uses como entorno habitual del módulo: no tienen depurador real y dependen de la conexión a internet del aula.

> ⚠️ **Importante:** el proyecto GestorInventario pide datos por teclado mientras se ejecuta (con `Scanner`). Asegúrate de usar un IDE online que soporte esto ("entrada interactiva" o "STDIN en vivo"); si no, el programa se quedará bloqueado esperando una entrada que nunca llega.

### Opción A — Replit (recomendada)

**Enlace:** [replit.com](https://replit.com)

1. **Crear cuenta.** Regístrate gratis (puedes usar el correo del centro).
2. **Crear un Repl de Java.** `+ Create Repl` → busca la plantilla `Java`.
3. **Pegar el código y ejecutar.** Sustituye el contenido de `Main.java` por `GestorInventario.java` y pulsa `Run`. La consola de la derecha es interactiva: escribe en ella con normalidad cuando el programa lo pida.

### Opción B — JDoodle (alternativa rápida)

**Enlace:** [jdoodle.com/online-java-compiler](https://www.jdoodle.com/online-java-compiler/)

1. **Sin registro.** Se puede usar directamente, sin crear cuenta.
2. **Pegar el código.** Pega `GestorInventario.java` en el editor central.
3. **Escribir la entrada antes de ejecutar.** En el cuadro `STDIN`, escribe de antemano, una por línea, cada opción que el programa te vaya a pedir (por ejemplo `1` y luego `5`), y después pulsa `Execute`.
   > JDoodle no es interactivo en tiempo real: toda la entrada hay que prepararla antes de ejecutar, no según se va pidiendo. Para practicar con calma en casa vale; para la dinámica normal de clase, mejor Replit o el IDE instalado.

---

*Sistemas Microinformáticos y Redes · CMO-313 Fundamentos de programación (Java)*
*Profesor: Ezequiel Llarena Borges © 2026-2027*
