# IntelliJ IDEA & Java: Guía de supervivencia

Esta guía rápida está diseñada para ayudarte a dar tus primeros pasos en **Java** utilizando **IntelliJ IDEA**. Aquí encontrarás los atajos esenciales, trucos de automatización, cómo solucionar problemas con el JDK y cómo usar el depurador como un profesional.

---

## 1. Atajos 

Usa estos comandos en tu día a día para escribir código más rápido, mantenerlo limpio y solucionar errores de sintaxis al instante.

| Acción | Windows / Linux | macOS |
| :--- | :--- | :--- |
| **Autocompletar / Sugerencias** | `Ctrl` + `Espacio` | `⌃` + `Espacio` |
| **Corregir error automáticamente** (Quick Fix) | `Alt` + `Enter` | `⌥` + `Enter` |
| **Formatear código** (Alinear y limpiar) | `Ctrl` + `Alt` + `L` | `⌘` + `⌥` + `L` |
| **Duplicar la línea actual** | `Ctrl` + `D` | `⌘` + `D` |
| **Borrar la línea actual** | `Ctrl` + `Y` | `⌘` + `Backspace` |
| **Comentar / Descomentar línea** | `Ctrl` + `/` | `⌘` + `/` |
| **Buscar cualquier cosa** (Clases, archivos, menús) | Presionar `Shift` 2 veces | Presionar `⇧` 2 veces |

💡 *¿Se te perdió la barra lateral del proyecto? Presiona `Alt + 1` (Windows) o `⌘ + 1` (macOS) para recuperarla.*

---

## 2. Plantillas Automáticas (Live Templates)

No pierdas tiempo escribiendo código repetitivo. Escribe la palabra clave y presiona la tecla **`Tabulador ⇥`** o **`Enter ↵`** para expandirla:

*   **`psvm`** o **`main`** → Genera el método principal del programa:
    ```java
    public static void main(String[] args) {
        
    }
    ```
*   **`sout`** → Genera el comando para imprimir en la consola de salida:
    ```java
    System.out.println();
    ```
*   **`souf`** → Genera el comando para imprimir texto con formato:
    ```java
    System.out.printf("");
    ```
*   **`fori`** → Diseña la estructura de un bucle `for` tradicional con su contador:
    ```java
    for (int i = 0; i < ; i++) {
        
    }
    ```

---

## 3. Configuración de la Versión de Java (JDK) 

Si IntelliJ te muestra un error que dice *"Project SDK is not defined"* o el código no compila por incompatibilidad de versiones, sigue estos pasos:

1. **Abrir la Estructura del Proyecto:**
   * Ve al menú superior: `File` > `Project Structure...`
   * *Atajo:* `Ctrl + Alt + Shift + S` (Win/Linux) o `⌘ + ;` (macOS).
2. **Configurar el SDK:**
   * En el menú izquierdo, haz clic en **Project**.
   * En el desplegable **SDK**, selecciona la versión de Java que requiere tu clase (por ejemplo, Java 17 o Java 21).
3. **¿No tienes un JDK instalado?**
   * En el mismo desplegable, haz clic en **Add SDK** > **Download JDK...**
   * Elige la versión que necesitas y un proveedor estable (ej. *Eclipse Temurin* u *OpenJDK*). Haz clic en **Download** y el IDE se encargará del resto de forma automática.
4. **Guardar cambios:** Haz clic en **Apply** y luego en **OK**.

---

## 4. Guía de Uso del Depurador (Debugger) 🪲

El depurador te permite pausar tu programa y ver paso a paso cómo piensa la computadora, línea por línea. ¡Es mucho mejor que llenar tu código de `System.out.println()` temporales!

### Paso 1: Poner un punto de interrupción (Breakpoint)
Haz clic en el espacio gris que hay justo al lado del número de línea donde quieres que el programa se detenga temporalmente. Aparecerá un **círculo rojo** 🔴.

### Paso 2: Iniciar la depuración
En lugar de darle al botón de reproducir normal, haz clic en el icono del **escarabajo** 🪲 en la esquina superior derecha, o usa el atajo:
* **Win/Linux:** `Shift + F9`
* **macOS:** `⌃ + D`

### Paso 3: Controlar la ejecución
Cuando el programa se detenga en tu punto de interrupción (la línea se iluminará en azul), usa los controles de la pestaña inferior para avanzar:

*   🔄 **Step Over (`F8`):** Salta a la siguiente línea de código en el archivo actual.
*   ⬇️ **Step Into (`F7`):** Si la línea actual es una función o método propio, entra a mirar su lógica interna.
*   ⬆️ **Step Out (`Shift + F8`):** Sale del método actual y vuelve a la línea donde fue llamado.
*   ▶️ **Resume Program (`F9` / `⌘ + ⌥ + R`):** Reanuda la ejecución normal del programa hasta encontrar el siguiente breakpoint o finalizar.

### Paso 4: Inspeccionar Variables
En la pestaña **Variables** (en la parte inferior del entorno), verás una lista en tiempo real de todas las variables creadas y sus valores exactos en el instante de la pausa. ¡Ideal para descubrir por qué un bucle no termina o un cálculo da un resultado erróneo!

---

## 5. Estructura Estándar de un Proyecto

Para no perderte en el árbol de carpetas de la izquierda (`Project View`), recuerda este orden jerárquico básico:

```text
📂 MiProyectoJava/
├── 📂 .idea/             ⚠️ Configuraciones internas del IDE (¡No borrar ni modificar!)
├── 📂 src/               🚀 ¡AQUÍ VA TU CÓDIGO!
│   └── 📄 MiClase.java   El archivo fuente donde escribes tu programa Java
└── 📂 out/ o target/     Código compilado automáticamente en formato binario (.class)
```
