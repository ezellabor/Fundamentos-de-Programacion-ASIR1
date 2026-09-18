# CMO-313. Fundamentos de programación (Java)

**Solucionario — Ejercicios cortos de clase, por Unidad de Trabajo**

24 ejercicios (3 por UT): completar código, encontrar el error y escribir un bloque. Uso exclusivo del profesorado.

## UT1. Introducción al lenguaje y elementos básicos

### 1. Completar código

*Completar la línea que falta para declarar la variable stock de tipo entero, inicializada a 12 unidades.*

**Código de partida**

```java
_____ stock = ____;
System.out.println("Stock: " + stock);
```

**Solución**

```java
int stock = 12;
System.out.println("Stock: " + stock);
```

*Se usa el tipo entero int, ya que el stock se cuenta en unidades completas, y se inicializa con el valor 12.*

### 2. Encontrar el error

*Localizar el error: el precio se ha declarado como String y se usa después en un cálculo aritmético.*

**Código de partida**

```java
String precio = "45.90";
double total = precio * 2;
System.out.println(total);
```

**Solución**

```java
double precio = 45.90;
double total = precio * 2;
System.out.println(total);
```

*precio es un String y no se puede multiplicar por un número; debe declararse como double, el tipo adecuado para un valor decimal.*

### 3. Escribir un bloque

*Escribir las líneas necesarias para pedir por teclado el nombre de un producto y mostrarlo por pantalla.*

**Solución**

```java
Scanner teclado = new Scanner(System.in);
System.out.print("Nombre del producto: ");
String nombre = teclado.nextLine();
System.out.println("Producto introducido: " + nombre);
```

*Se usa Scanner para leer del teclado y nextLine() porque el nombre puede contener espacios.*

## UT2. Estructuras de control selectivas

### 1. Completar código

*Completar un if-else que clasifique el stock en "agotado", "bajo" o "suficiente".*

**Código de partida**

```java
if (stock == 0) {
    System.out.println("Agotado");
} else if (____) {
    System.out.println("Bajo");
} else {
    System.out.println("Suficiente");
}
```

**Solución**

```java
if (stock == 0) {
    System.out.println("Agotado");
} else if (stock < 5) {
    System.out.println("Bajo");
} else {
    System.out.println("Suficiente");
}
```

*La condición intermedia debe cubrir los valores entre 1 y el umbral elegido (aquí, menos de 5 unidades) antes de considerar el stock "suficiente".*

### 2. Encontrar el error

*Localizar el fallo en este switch: al elegir la opción 1 se muestran también los mensajes de la opción 2.*

**Código de partida**

```java
switch (opcion) {
    case 1:
        System.out.println("Ver stock");
    case 2:
        System.out.println("Salir");
}
```

**Solución**

```java
switch (opcion) {
    case 1:
        System.out.println("Ver stock");
        break;
    case 2:
        System.out.println("Salir");
        break;
}
```

*Falta el break tras el case 1: sin él, la ejecución "cae" (fall-through) al siguiente case y también lo ejecuta.*

### 3. Escribir un bloque

*Escribir un operador ternario que muestre "Disponible" o "Agotado" según el stock.*

**Solución**

```java
String estado = (stock > 0) ? "Disponible" : "Agotado";
System.out.println(estado);
```

*El operador ternario condición ? siVerdadero : siFalso resuelve en una sola línea una selección simple de dos opciones.*

## UT3. Estructuras de control iterativas

### 1. Completar código

*Completar un bucle for que recorra del 1 al 10, ambos incluidos.*

**Código de partida**

```java
for (int i = ___; i ___ 10; i++) {
    System.out.println(i);
}
```

**Solución**

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

*i debe empezar en 1 y la condición debe ser <= 10 para incluir también el valor 10 en el recorrido.*

### 2. Encontrar el error

*Localizar por qué este bucle no termina nunca.*

**Código de partida**

```java
int contador = 0;
while (contador < 5) {
    System.out.println(contador);
}
```

**Solución**

```java
int contador = 0;
while (contador < 5) {
    System.out.println(contador);
    contador++;
}
```

*contador nunca se modifica dentro del bucle, así que la condición contador < 5 siempre es verdadera: es un bucle infinito. Falta incrementar contador en cada vuelta.*

### 3. Escribir un bloque

*Escribir un do-while que repita un menú hasta que el usuario introduzca la opción 3 (salir).*

**Solución**

```java
int opcion;
do {
    System.out.println("1) Ver  2) Actualizar  3) Salir");
    opcion = teclado.nextInt();
} while (opcion != 3);
```

*do-while comprueba la condición después de ejecutar el bloque, por lo que el menú se muestra siempre al menos una vez.*

## UT4. Arrays y colecciones

### 1. Completar código

*Completar la declaración de un ArrayList<String> vacío llamado nombres.*

**Código de partida**

```java
ArrayList<String> nombres = ____;
```

**Solución**

```java
ArrayList<String> nombres = new ArrayList<>();
```

*new ArrayList<>() crea una lista vacía; el diamante <> evita repetir el tipo, que Java infiere del lado izquierdo.*

### 2. Encontrar el error

*Localizar el error de este fragmento, que provoca una excepción al ejecutarse.*

**Código de partida**

```java
String[] productos = {"SSD", "RAM", "GPU"};
System.out.println(productos[3]);
```

**Solución**

```java
String[] productos = {"SSD", "RAM", "GPU"};
System.out.println(productos[2]);
```

*El array tiene 3 elementos, con índices 0, 1 y 2; productos[3] no existe y lanza ArrayIndexOutOfBoundsException. El último elemento válido es productos[2].*

### 3. Escribir un bloque

*Recorrer con for-each un ArrayList<String> llamado nombres, mostrando cada elemento en mayúsculas.*

**Solución**

```java
for (String nombre : nombres) {
    System.out.println(nombre.toUpperCase());
}
```

*El for-each recorre cada elemento de la lista sin necesidad de gestionar un índice; toUpperCase() convierte el texto a mayúsculas.*

## UT5. Métodos y modularización

### 1. Completar código

*Completar la cabecera de un método que reciba un ArrayList<Integer> y devuelva un double con la media de sus valores.*

**Código de partida**

```java
public static ____ calcularMedia(____ valores) {
    ...
}
```

**Solución**

```java
public static double calcularMedia(ArrayList<Integer> valores) {
    ...
}
```

*El tipo de retorno (double) va antes del nombre del método; el tipo del parámetro debe coincidir con la colección que se le va a pasar.*

### 2. Encontrar el error

*Localizar el error en este método, que no compila.*

**Código de partida**

```java
public static void mostrarTotal(double total) {
    return total;
}
```

**Solución**

```java
public static void mostrarTotal(double total) {
    System.out.println("Total: " + total);
}
```

*Un método void no puede devolver ningún valor con return. O se cambia el cuerpo del método (como aquí), o se cambia su tipo de retorno a double.*

### 3. Escribir un bloque

*Escribir el método mostrarMenu() que imprima las tres opciones del programa.*

**Solución**

```java
public static void mostrarMenu() {
    System.out.println("1) Ver stock");
    System.out.println("2) Actualizar stock");
    System.out.println("3) Salir");
}
```

*Un método void agrupa varias instrucciones (aquí, tres println) bajo un nombre que describe su propósito.*

## UT6. Programación orientada a objetos I: clases y objetos

### 1. Completar código

*Completar el constructor de la clase Producto.*

**Código de partida**

```java
public Producto(String nombre, double precio, int stock) {
    ____
}
```

**Solución**

```java
public Producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
}
```

*this.atributo diferencia el atributo de la clase del parámetro que tiene el mismo nombre, asignándole el valor recibido.*

### 2. Encontrar el error

*Localizar el fallo de diseño en esta clase.*

**Código de partida**

```java
public class Producto {
    public String nombre;
    private double precio;
    private int stock;
    ...
}
```

**Solución**

```java
public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    ...
}
```

*El atributo nombre es public, lo que rompe la encapsulación: cualquier código externo podría modificarlo sin control. Debe ser private, como el resto de atributos.*

### 3. Escribir un bloque

*Escribir el método toString() de la clase Producto.*

**Solución**

```java
@Override
public String toString() {
    return nombre + " - " + precio + " eur - " + stock + " uds.";
}
```

*Sobrescribir toString() permite que System.out.println(producto) muestre directamente una descripción legible del objeto.*

## UT7. Programación orientada a objetos II: herencia y polimorfismo

### 1. Completar código

*Completar la cabecera de la subclase MemoriaRAM, que hereda de ComponenteInformatico.*

**Código de partida**

```java
public class MemoriaRAM ____ ComponenteInformatico {
    ...
}
```

**Solución**

```java
public class MemoriaRAM extends ComponenteInformatico {
    ...
}
```

*extends indica que MemoriaRAM hereda los atributos y métodos de la superclase ComponenteInformatico.*

### 2. Encontrar el error

*Localizar el error en este constructor: los atributos heredados (nombre, precio, stock) quedan sin inicializar.*

**Código de partida**

```java
public class MemoriaRAM extends ComponenteInformatico {
    private String tipo;

    public MemoriaRAM(String nombre, double precio, int stock, String tipo) {
        this.tipo = tipo;
    }
}
```

**Solución**

```java
public class MemoriaRAM extends ComponenteInformatico {
    private String tipo;

    public MemoriaRAM(String nombre, double precio, int stock, String tipo) {
        super(nombre, precio, stock);
        this.tipo = tipo;
    }
}
```

*Falta la llamada a super(nombre, precio, stock) como primera línea del constructor: es la que inicializa los atributos heredados de ComponenteInformatico. Sin ella, esos atributos se quedarían sin asignar.*

### 3. Escribir un bloque

*Escribir el método describir() sobrescrito para la clase TarjetaGrafica.*

**Solución**

```java
@Override
public String describir() {
    return nombre + " (" + memoriaVRAM + " GB VRAM) - " + precio + " eur";
}
```

*Cada subclase da su propia versión de describir(), incluyendo el dato que le es propio (aquí, la memoria de vídeo).*

## UT8. Excepciones, documentación y cierre del proyecto

### 1. Completar código

*Completar el catch para que capture el tipo de excepción adecuado al leer un entero por teclado.*

**Código de partida**

```java
try {
    int stock = teclado.nextInt();
} catch (____) {
    System.out.println("Error: introduce un numero.");
}
```

**Solución**

```java
try {
    int stock = teclado.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Error: introduce un numero.");
}
```

*Scanner.nextInt() lanza InputMismatchException cuando lo introducido no es un número entero válido.*

### 2. Encontrar el error

*Localizar por qué este bloque no captura realmente el error que se produce.*

**Código de partida**

```java
try {
    int stock = teclado.nextInt();
} catch (NumberFormatException e) {
    System.out.println("Error de formato.");
}
```

**Solución**

```java
try {
    int stock = teclado.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Error de formato.");
}
```

*nextInt() no lanza NumberFormatException, sino InputMismatchException; con el catch original, el programa se detendría igualmente al no capturar el error real.*

### 3. Escribir un bloque

*Escribir la clase StockInvalidoException, que extienda de Exception.*

**Solución**

```java
public class StockInvalidoException extends Exception {
    public StockInvalidoException(String mensaje) {
        super(mensaje);
    }
}
```

*Una excepción personalizada se define extendiendo Exception y pasando el mensaje al constructor de la superclase con super(mensaje).*

