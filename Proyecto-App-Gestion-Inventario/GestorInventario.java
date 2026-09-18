import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * GestorInventario
 * ------------------------------------------------------------------
 * Proyecto vertebrador del módulo CMO-313. Fundamentos de programación (Java)
 * Aplicación de consola para gestionar el inventario de componentes
 * informáticos de un pequeño taller (discos, módulos de RAM, tarjetas
 * gráficas...).
 *
 * A lo largo del curso este programa ha ido incorporando, Unidad de Trabajo
 * a Unidad de Trabajo, los contenidos del módulo. Los comentarios "UTx:"
 * señalan en qué unidad se introdujo cada parte del código, para que sirva
 * como repaso de todo lo aprendido.
 * ------------------------------------------------------------------
 */
public class GestorInventario {

    // UT6/UT7: en vez de variables sueltas (UT1) o listas "paralelas" (UT4),
    // guardamos objetos completos en una única colección.
    private static ArrayList<ComponenteInformatico> inventario = new ArrayList<>();

    // UT1: Scanner único para leer datos del teclado durante toda la ejecución.
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        cargarInventarioInicial();

        int opcion;
        // UT3: bucle do-while que repite el menú hasta que el usuario elige salir.
        // Se ejecuta al menos una vez, aunque sea la primera vez que se muestra.
        do {
            mostrarMenu();
            opcion = leerOpcion();

            // UT2: sentencia switch para decidir qué hacer según la opción elegida.
            switch (opcion) {
                case 1:
                    listarComponentes();
                    break;
                case 2:
                    anadirComponente();
                    break;
                case 3:
                    actualizarStock();
                    break;
                case 4:
                    System.out.printf("Valor total del inventario: %.2f eur%n", calcularValorTotal());
                    break;
                case 5:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);

        teclado.close();
    }

    // ================================================================
    // UT5: el programa está modularizado en métodos, cada uno con una
    // única responsabilidad. Esto facilita leerlo, probarlo y corregirlo.
    // ================================================================

    /** Muestra las opciones del menú principal. */
    private static void mostrarMenu() {
        System.out.println();
        System.out.println("=== Gestor de Inventario de Componentes ===");
        System.out.println("1) Listar componentes");
        System.out.println("2) Anadir componente");
        System.out.println("3) Actualizar stock");
        System.out.println("4) Ver valor total del inventario");
        System.out.println("5) Salir");
        System.out.print("Elige una opcion: ");
    }

    /**
     * Lee la opción elegida por el usuario.
     * UT8: se valida la entrada para que el programa no se detenga con un
     * error si el usuario escribe algo que no es un número.
     */
    private static int leerOpcion() {
        try {
            int valor = teclado.nextInt();
            return valor;
        } catch (InputMismatchException e) {
            teclado.nextLine(); // limpiamos la entrada no válida del buffer
            System.out.println("Error: debes introducir un numero.");
            return -1; // opción inexistente: el switch mostrará "Opcion no valida"
        }
    }

    /** UT4/UT6: recorre el inventario con un bucle for-each y lo muestra. */
    private static void listarComponentes() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacio.");
            return;
        }
        System.out.println();
        int numero = 1;
        // UT7: gracias al polimorfismo, cada componente sabe describirse a sí
        // mismo con su propia versión de describir(), aunque sea de una
        // subclase distinta (Producto, TarjetaGrafica, MemoriaRAM...).
        for (ComponenteInformatico c : inventario) {
            System.out.println(numero + ". " + c.describir());
            numero++;
        }
    }

    /** UT6: crea un nuevo objeto Producto y lo añade al inventario. */
    private static void anadirComponente() {
        teclado.nextLine(); // limpiar el salto de línea pendiente del menú
        System.out.print("Nombre del componente: ");
        String nombre = teclado.nextLine();

        double precio = leerDouble("Precio (eur): ");
        int stock = leerEntero("Stock inicial: ");

        inventario.add(new Producto(nombre, precio, stock));
        System.out.println("Componente anadido correctamente.");
    }

    /**
     * UT8: actualiza el stock de un componente, controlando tanto errores
     * de formato (texto en vez de número) como valores fuera de rango
     * mediante una excepción personalizada.
     */
    private static void actualizarStock() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacio.");
            return;
        }
        listarComponentes();
        int indice = leerEntero("Numero del componente a actualizar: ") - 1;

        // UT4: misma idea que evitar un ArrayIndexOutOfBoundsException,
        // pero comprobando el rango "a mano" antes de acceder a la lista.
        if (indice < 0 || indice >= inventario.size()) {
            System.out.println("Ese componente no existe.");
            return;
        }

        try {
            int nuevoStock = leerEntero("Nuevo stock: ");
            if (nuevoStock < 0) {
                // UT8: excepción personalizada para una regla propia del programa
                // (el stock nunca puede ser negativo).
                throw new StockInvalidoException("El stock no puede ser negativo.");
            }
            inventario.get(indice).setStock(nuevoStock);
            System.out.println("Stock actualizado.");
        } catch (StockInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * UT5: método con valor de retorno que calcula el valor total del
     * inventario sumando el valor (precio x stock) de cada componente.
     */
    private static double calcularValorTotal() {
        double total = 0;
        for (ComponenteInformatico c : inventario) {
            total += c.getValorTotal();
        }
        return total;
    }

    /** Datos de ejemplo para no empezar la aplicación con el inventario vacío. */
    private static void cargarInventarioInicial() {
        inventario.add(new Producto("Disco SSD 500GB", 45.90, 12));
        inventario.add(new Producto("Modulo RAM 8GB", 28.50, 20));
        inventario.add(new TarjetaGrafica("Tarjeta grafica RTX", 349.00, 8, 12));
        inventario.add(new MemoriaRAM("Kit RAM DDR5 16GB", 62.00, 15, "DDR5"));
    }

    // ================================================================
    // UT1/UT8: métodos auxiliares para leer datos numéricos por teclado,
    // repitiendo la pregunta si el usuario introduce algo no válido.
    // ================================================================

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double valor = teclado.nextDouble();
                return valor;
            } catch (InputMismatchException e) {
                teclado.nextLine();
                System.out.println("Error: introduce un numero valido.");
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = teclado.nextInt();
                teclado.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                teclado.nextLine();
                System.out.println("Error: introduce un numero entero valido.");
            }
        }
    }

    // ================================================================
    // UT7: jerarquía de clases. ComponenteInformatico es la superclase;
    // Producto, TarjetaGrafica y MemoriaRAM son sus subclases.
    // ================================================================

    /**
     * UT6/UT7: clase que representa cualquier componente informático del
     * inventario. Define lo común a todos ellos (nombre, precio, stock) y
     * ofrece una forma de describirse por defecto, que cada subclase puede
     * sobrescribir con @Override si necesita mostrar algo distinto.
     */
    static class ComponenteInformatico {
        protected String nombre;
        protected double precio;
        protected int stock;

        public ComponenteInformatico(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        /** UT6: valor total de existencias de este componente concreto. */
        public double getValorTotal() {
            return precio * stock;
        }

        /**
         * UT7: implementación "por defecto" de describir(). Las subclases
         * que necesiten mostrar algo distinto la sobrescriben con
         * @Override (ver TarjetaGrafica y MemoriaRAM); las que no,
         * heredan directamente esta versión (ver Producto).
         * Esta es la base del polimorfismo: el código que recorre el
         * inventario (ver listarComponentes()) no necesita saber de qué
         * subclase concreta es cada componente para poder mostrarlo.
         */
        public String describir() {
            return String.format("%s - %.2f eur - %d uds.", nombre, precio, stock);
        }
    }

    /**
     * UT6: componente genérico. No sobrescribe describir() porque la
     * versión heredada de ComponenteInformatico ya es exactamente lo que
     * necesita: no todas las subclases tienen por qué sobrescribir un
     * método heredado.
     */
    static class Producto extends ComponenteInformatico {
        public Producto(String nombre, double precio, int stock) {
            super(nombre, precio, stock);
        }
    }

    /** UT7: subclase con un atributo propio, la memoria de vídeo (VRAM). */
    static class TarjetaGrafica extends ComponenteInformatico {
        private int memoriaVRAM; // en GB

        public TarjetaGrafica(String nombre, double precio, int stock, int memoriaVRAM) {
            super(nombre, precio, stock);
            this.memoriaVRAM = memoriaVRAM;
        }

        @Override
        public String describir() {
            return String.format("%s (%d GB VRAM) - %.2f eur - %d uds.",
                    nombre, memoriaVRAM, precio, stock);
        }
    }

    /** UT7: otra subclase, con un atributo propio distinto (el tipo de memoria). */
    static class MemoriaRAM extends ComponenteInformatico {
        private String tipo; // por ejemplo "DDR4", "DDR5"

        public MemoriaRAM(String nombre, double precio, int stock, String tipo) {
            super(nombre, precio, stock);
            this.tipo = tipo;
        }

        @Override
        public String describir() {
            return String.format("%s [%s] - %.2f eur - %d uds.",
                    nombre, tipo, precio, stock);
        }
    }

    // ================================================================
    // UT8: excepción personalizada para las reglas propias del programa.
    // ================================================================

    /** Se lanza cuando se intenta dejar un componente con stock negativo. */
    static class StockInvalidoException extends Exception {
        public StockInvalidoException(String mensaje) {
            super(mensaje);
        }
    }
}
