
# Unidad 4 - Estructuras condicionales: simple y doble  
Resultado de aprendizaje a trabajar:
- *RA4 - Escribir y depurar código, analizando y utilizando las estructuras de control del lenguaje.*


---

## 1. Objetivos
- Comprender la **lógica de decisión** en algoritmos.
- Comprender y aplicar estructura **condicional simple**.
- Comprender y aplicar estructura **condicional doble**.


---
## 2. Conceptos clave
- Las **estructuras condicionales** o de selección permiten que un programa tome decisiones según datos de entrada.
>- Una **condición** es una **expresión lógica** que se evalua como _Verdadera_ (TRUE) o como _Falsa_ (FALSE).
>- Existen dos tipos de estructuras condicionales: **simple** y **doble**.
### 2.1. Condicional simple _(Si-Entonces-FinSi)_
Estructura de control que permite ejecutar un bloque de instrucciones solo **si se cumple una condición.**
>- Si la condición es **verdadera,** el programa realiza una acción
>- Si es **falsa,** no hace nada y continúa con la siguiente instrucción

La **estructura** general en pseudocódigo es la siguiente:
```
Si <condición> Entonces
    <instrucciones si verdadero>
FinSi
```
_Ejemplo en pseudocódigo:_
```
Si temperatura > 40 Entonces
    Escribir "Alerta: el servidor está sobrecalentado."
FinSi
```
En este caso, solo se muestra el mensaje de alerta si la condición es verdadera (_valor de la variable temperatura es mayor que 40_). Si no lo es, el programa continua ejecutando la siguiente instrucción (la que haya después del ```FinSi```) sin ejecutar ninguna acción alternativa.

### 2.2. Condicional doble _(Si-Entonces-SiNo-FinSi)_
Una estructura condicional doble permite ejecutar **dos caminos posibles** del programa:
>- Uno cuando **se cumple** una condición
>- Otro cuando **no se cumple**

Su **estructura** general en pseudocódigo es:
```
Si <condición> Entonces
    <instrucciones si verdadero>
SiNo
    <instrucciones si falso>
FinSi
```
_Ejemplo: Comprobar si una persona es mayor de edad_
```
// Condicional Simple

Leer edad
Si edad >= 18 Entonces
    Escribir "Es mayor de edad"
FinSi

// Condicional Doble

Leer edad
Si edad >= 18 Entonces
    Escribir "Es mayor de edad"
SiNo
    Escribir "Es menor de edad"
FinSi
```

>En la segunda parte de esta unidad veremos condicionales anidadas y múltiples condiciones con operadores lógicos: `Y`, `O`, `NO`.

---
## 3. Ejemplo paso a paso
Algoritmo que pida la longitud de una contraseña y determine si es segura o no según la siguiente regla:
>- Si la contraseña tiene 8 caracteres o más → “Contraseña segura”
>- Si tiene menos de 8 caracteres → “Contraseña débil”

### 3.1. Pseudocódigo:
```
INICIO
   Escribir "Introduce la longitud de tu contraseña:"
   Leer longitud
   Si longitud >= 8 Entonces
        Escribir "La contraseña es segura."
   SiNo
        Escribir "La contraseña es débil. Debe tener al menos 8 caracteres."
   FinSi
FIN
```
### Explicación paso a paso:
| Paso | Acción                                 | Resultado                               |
| ---- | -------------------------------------- | --------------------------------------- |
| 1    | El programa pide la longitud           | El usuario introduce un número          |
| 2    | Se evalúa la condición `longitud >= 8` | Puede ser **verdadera** o **falsa**     |
| 3-V  | Si la condición es verdadera           | Muestra **"La contraseña es segura."**  |
| 3-F  | Si la condición es falsa               | Muestra **"La contraseña es débil..."** |
| 4    | Finaliza el programa                   | —                                       |


<!-- Condicional Anidado ejemplo validación de acceso a un sistema
**Contexto:** queremos controlar el acceso a una aplicación según usuario y contraseña, y además comprobar si el usuario está activo. Mostramos paso a paso, tabla de variables y un esquema lógico simple.

### Variables
| Nombre       | Tipo    | Descripción |
|--------------|---------|-------------|
| usuario      | Texto   | Nombre de usuario ingresado |
| contraseña   | Texto   | Contraseña ingresada |
| usuario_reg  | Texto   | Usuario registrado en el sistema |
| pass_reg     | Texto   | Contraseña registrada |
| activo       | Booleano | Indica si la cuenta está activa (VERDADERO/FALSO) |
| intento      | Entero  | Contador de intentos |
| acceso       | Booleano | Resultado final: permiso concedido o no |

### 3.1. Valores iniciales de las variables
- usuario_reg = "alumno01"
- pass_reg = "Clave123"
- activo = VERDADERO
- intento = 0

### 3.2. Esquema lógico previo
1. Pedir usuario y contraseña
2. Comparar con los valores registrados (usuario_reg y pass_reg)
3. Si coinciden, comprobar si activo = VERDADERO
   - Si activo: acceso = VERDADERO → mostrar "Acceso concedido"
   - Si no: acceso = FALSO → mostrar "Cuenta inactiva"
4. Si no coinciden, intento = intento + 1 → mostrar "Credenciales incorrectas"

```
INICIO
  LEER usuario, contraseña
  SI usuario = usuario_reg Y contraseña = pass_reg ENTONCES
      SI activo = VERDADERO ENTONCES
          acceso <- VERDADERO
          Escribir "Acceso concedido"
      SINO
          acceso <- FALSO
          Escribir "Cuenta inactiva"
      FIN_SI
  SINO
      intento <- intento + 1
      acceso <- FALSO
      Escribir "Credenciales incorrectas"
  FIN_SI
FIN
```

### 3.3. Ejecución paso a paso _(ejemplo concreto)_
1. Entrada: usuario="alumno01", contraseña="Clave123"
2. Comparación 1: usuario = usuario_reg ? "alumno01" = "alumno01" → VERDADERO
3. Comparación 2: contraseña = pass_reg ? "Clave123" = "Clave123" → VERDADERO
4. Verificar activo: activo = VERDADERO → VERDADERO
5. Resultado: acceso = VERDADERO → Mensaje: "Acceso concedido"
-->
---

## 4. Supuestos prácticos
### 4.1. Nivel 1 - Básico
1. Escribir pseudocódigo que lea un número y muestre si es par o impar.
2. Pedir nombre de usuario; si es "admin" mostrar "Bienvenido administrador", sino "Bienvenido usuario".

### 4.2. Nivel 2 - Intermedio
1. Sistema de recuperación: leer usuario y email. Si coinciden con registro, mostrar "Enviar link de recuperación"; sino "Usuario no encontrado".
2. Calcular el precio final: leer precio y si `precio > 1000` aplicar 10% de descuento, sino precio sin descuento.

<!--### Nivel 3 - Avanzado
1. Gestión de permisos: leer rol (admin, docente, alumno) y recurso (configuración, notas, perfil). Definir acceso según rol:
   - admin: acceso a todo
   - docente: acceso a notas y perfil, no a configuración
   - alumno: acceso solo a perfil
   Escribir pseudocódigo que devuelva "Acceso permitido" o "Acceso denegado".
2. Validación compleja de contraseña: leer contraseña y verificar que tenga:
   - al menos 8 caracteres
   - una letra mayúscula
   - un número
   - un carácter especial (por ejemplo: !@#$%)
   Mostrar qué condiciones no se cumplen (lista de fallos).
-->
### 4.3. Soluciones propuestas
**Nivel 1 (par/impar)**
```
LEER n
SI n MOD 2 = 0 ENTONCES
    Escribir "Par"
SINO
    Escribir "Impar"
FIN_SI
```

**Nivel 2 (descuento)**
```
LEER precio
SI precio > 1000 ENTONCES
    descuento <- precio * 0.10
    total <- precio - descuento
SINO
    total <- precio
FIN_SI
Escribir total
```

---

## 5. Buenas prácticas
- Verifica las condiciones lógicas antes de escribirlas.
- Los condicionales pueden ser anidados para múltiples decisiones.
- Prueba varios valores para comprobar el algoritmo.
- Usa sangría consistente para mejor legibilidad.

---

## Comparativa: condicional simple vs condicional doble
| Condicional    | ¿Cuándo se ejecuta?                                         | ¿Qué pasa si la condición es falsa?        | Estructura                            | Ejemplo simplificado                                                                                                                                               |
| ---------------------- | ----------------------------------------------------------- | ------------------------------------------ | ------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Simple** | Ejecuta instrucciones **solo si la condición es verdadera** | **No ejecuta nada** y continúa el programa | `if (condición) { ... }`              | `if (edad >= 18) {   System.out.println("Mayor de edad"); }` *(Si la condición no se cumple, no se muestra nada)*                                                  |
| **Doble**  | Ejecuta instrucciones **si la condición es verdadera**      | Ejecuta el bloque **alternativo**          | `if (condición) { ... } else { ... }` | `if (cpu >= 75) {   System.out.println("Sobrecarga"); } else {   System.out.println("Funcionamiento normal"); }` *(Si no se cumple, se ejecuta la segunda acción)* |


## 6. Síntesis

<div style="background-color:#d9f2e6; padding:15px; border-radius:8px;">
<table style="width:100%; border:1px solid #ccc; border-collapse:collapse;">
<tr style="background-color:#ccece6;">
<th style="border:1px solid #ccc; padding:4px;">Condicional</th>
<th style="border:1px solid #ccc; padding:4px;">Descripción</th>
<th style="border:1px solid #ccc; padding:4px;">Ejemplo</th>
</tr>
<tr><td>Simple</td><td>Decisión con un camino: <code>Si-Entonces-FinSi</code></td><td><code>Si edad >=18 Entonces "Mayor de edad"</code></td></tr>
<tr><td>Doble</td><td>Decisión con dos caminos: <code>Si-Entonces-SiNo-FinSi</code></td><td><code>Si nota >=5 Entonces "Aprobado" SiNo "Recuperación" FinSi</code></td></tr>
</table>
</div>

---

## 7. Reflexión
- ¿Qué tipo de errores fueron más comunes al escribir condicionales?  
- ¿Cómo ayudó el ejemplo paso a paso a entender el flujo lógico?  

<!--
---
## 8. Material adicional
- Lista de comprobación para condicionales: condiciones claras, operadores lógicos correctos, manejo de casos límite, pruebas con datos extremos.
- Fichas de pseudocódigo con patrones (validación de usuario, cálculo de descuentos, selección de menú).
-->
##  
_&copy; 2025 - Fundamentos de Programación - Ezequiel Llarena Borges_
