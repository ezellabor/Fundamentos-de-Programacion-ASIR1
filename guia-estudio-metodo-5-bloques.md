# Guía de Estudio: Método para Algoritmos de Control Secuencial

## 🎯 ¿Qué es el Control Secuencial?

Un algoritmo con estructura de control secuencial es aquel cuyas instrucciones se ejecutan **en orden estricto**, una tras otra, desde el principio hasta el final. Sin saltos, sin bifurcaciones, sin repeticiones.

**FLUJO TÍPICO:** INICIO → Declarar Variables → Inicializar Datos → Realizar Cálculos → Mostrar Resultados → FIN

> 💡 **Consejo:** Piensa en una receta de cocina: primero reúnes ingredientes (declaración), luego los preparas (inicialización), después cocinas (proceso) y finalmente sirves (salida).

---

## 🧱 Los 5 Bloques Fundamentales

### 1. BLOQUE DE INICIO
**Propósito:** Marcar el comienzo formal del algoritmo.
- **Pseudocódigo:** `INICIO`
- **Java:** `public static void main(String[] args) {`

### 2. DECLARACIÓN DE VARIABLES
**Propósito:** Reservar espacio en memoria para los datos.
- **Pseudocódigo:** `DECLARAR variable COMO tipo`
- **Java:** `int horas; double precio;`

### 3. INICIALIZACIÓN
**Propósito:** Asignar valores iniciales a las variables.
- **Pseudocódigo:** `variable ← valor`
- **Java:** `horas = 15; precio = 29.99;`

### 4. PROCESO
**Propósito:** Realizar cálculos y transformaciones.
- **Pseudocódigo:** `resultado ← expresión`
- **Java:** `total = cantidad * precio;`

### 5. SALIDA
**Propósito:** Mostrar resultados al usuario.
- **Pseudocódigo:** `ESCRIBIR resultado`
- **Java:** `System.out.println("Total: " + total);`

---

## 🎮 Ejemplo Motivador: Calculadora de Recompensas Gamer

```java
// ============================================
// CALCULADORA DE RECOMPENSAS - RPG GAMER
// ============================================

public class CalculadoraGamer {
    public static void main(String[] args) {
        
        // BLOQUE 1: DECLARACIÓN DE VARIABLES
        int misionesCompletadas;
        int nivelJugador;
        int dificultad;        // 1=fácil, 2=normal, 3=difícil
        int experienciaGanada;
        int monedasGanadas;
        
        // BLOQUE 2: INICIALIZACIÓN (mis datos actuales)
        misionesCompletadas = 8;
        nivelJugador = 24;
        dificultad = 2;        // Normal
        
        // BLOQUE 3: PROCESO (¡cálculos épicos!)
        experienciaGanada = misionesCompletadas * 150 * nivelJugador * dificultad;
        monedasGanadas = misionesCompletadas * (75 * dificultad);
        
        // BLOQUE 4: SALIDA (¡mis recompensas!)
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      INFORME DE RECOMPENSAS         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 🎮 Misiones completadas: " + misionesCompletadas);
        System.out.println("║ ⭐ Nivel actual: " + nivelJugador);
        System.out.println("║ 🏆 Dificultad: " + dificultad);
        System.out.println("╟──────────────────────────────────────╢");
        System.out.println("║ 💡 EXPERIENCIA: " + experienciaGanada + " XP");
        System.out.println("║ 💰 MONEDAS: " + monedasGanadas + " de oro");
        System.out.println("╚══════════════════════════════════════╝");
    }
}
