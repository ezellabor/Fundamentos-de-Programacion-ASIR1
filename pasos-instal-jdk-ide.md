# Guía de instalación: Java y Entornos de Desarrollo Integrado (IDE)

## 1. Comparativa de IDEs
| Característica | **IntelliJ IDEA (Community)** | **Visual Studio Code** | **Eclipse IDE** |
| :--- | :--- | :--- | :--- |
| **Enfoque** | Profesional / Especializado | Ligero / Polivalente | Clásico / Robusto |
| **Consumo RAM (Uso)** | ~1.5 GB - 3 GB (Pesado) | ~400 MB - 800 MB (Ligero) | ~800 MB - 1.5 GB |
| **Espacio en Disco** | ~2.5 GB | ~500 MB | ~1 GB |
| **Arranque** | Lento (Indexación pesada) | Instantáneo | Medio |
| **Curva Aprendizaje** | Media/Alta | Muy Baja | Alta |  
| **Motor de ejecución** | Java (JVM) | Electron (Node.js) | Java (JVM) |  
| **Recomendación** | Desarrollo profesional | **Ideal para ASIR (50h)** | Entornos corporativos |

---  

## 2. Paso 0: Instalación del JDK (El Motor)
Es obligatorio instalar el kit de desarrollo antes que el editor.
1. Descarga **JDK 21 (LTS)** de [Adoptium (Temurin)](https://adoptium.net/).
2. **IMPORTANTE:** Durante la instalación, marca:
   * [x] **Add to PATH**
   * [x] **Set JAVA_HOME variable**
3. **Verificación:** Abre una terminal (`cmd`) y escribe:
   `java -version`

---

## 3. Configuración de los IDEs

### Opción A: Visual Studio Code (Recomendado)
1. Instala VS Code.
2. Abre el panel de Extensiones `Ctrl + Shift + X`.
3. Busca e instala: **"Extension Pack for Java"** de Microsoft. Este pack instala 6 extensiones clave (Language Support, Debugger, Maven, etc.).
4. Para crear un programa (selección de Runtime): F1 o `Ctrl + Shift + P` -> `Java: Create Java Project` -> `No Build Tools`.  
    Escribe: ```Java: Configure Java Runtime``` para asegurar que detecta el JDK 21.

### Opción B: IntelliJ IDEA Community
1. Descarga e instala la versión **Community** (gratuita).
2. Al abrirlo, ve a `New Project`.
3. Si el campo `JDK` está vacío, pulsa `Add JDK` y selecciona la ruta donde se instaló el JDK 21.

### Opción C: Eclipse IDE
1. Descarga el `Eclipse Installer`.
2. Elige **"Eclipse IDE for Java Developers"**.
3. Al arrancar, selecciona un `Workspace` (carpeta de trabajo) y verifica en `Window > Preferences > Java > Compiler` que el nivel sea **21**.

---

## 4. ✅ Prueba de funcionamiento
Crea un archivo `Test.java` y ejecuta:

```java
public class Test {
    public static void main(String[] args) {
        System.out.println("Entorno configurado correctamente para ASIR.");
    }
}
