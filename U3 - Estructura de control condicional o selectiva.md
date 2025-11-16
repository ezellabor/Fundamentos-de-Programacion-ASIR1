
# Unidad 3 | Estructura de Control Condicional  
Resultado de aprendizaje a trabajar:
- *RA3 - Escribir y probar programas sencillos, reconociendo y aplicando los fundamentos de la programación..*


---

## Objetivos
- Comprender estructuras condicionales (SI/ENTONCES/SINO).
- Escribir pseudocódigo claro y correcto para decisiones simples y compuestas.
- Resolver problemas informáticos prácticos (validación de usuarios, control de acceso, procesos lógicos).

---
## 1. Introducción breve
Las **estructuras condicionales** permiten que un programa tome decisiones según datos de entrada. La forma básica en pseudocódigo que usaremos es:
```
SI <condición> ENTONCES
    <instrucciones si verdadero>
SINO
    <instrucciones si falso>
FIN_SI
```

También veremos condicionales anidadas y múltiples condiciones con operadores lógicos: `Y`, `O`, `NO`.

---
## 2. Primer ejemplo (PASO A PASO) — **Validación de acceso a un sistema**

**Contexto:** queremos controlar el acceso a una aplicación según usuario y contraseña, y además comprobar si el usuario está activo. Mostramos paso a paso, tabla de variables y un esquema/diagrama simple.

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

### Valores iniciales de ejemplo
- usuario_reg = "alumno01"
- pass_reg = "Clave123"
- activo = VERDADERO
- intento = 0

### Diagrama lógico (esquema)
1. Pedir usuario y contraseña
2. Comparar con los valores registrados (usuario_reg y pass_reg)
3. Si coinciden, comprobar si activo = VERDADERO
   - Si activo: acceso = VERDADERO → mostrar "Acceso concedido"
   - Si no: acceso = FALSO → mostrar "Cuenta inactiva"
4. Si no coinciden, intento = intento + 1 → mostrar "Credenciales incorrectas"

[Esquema simplificado]
```
INICIO
  LEER usuario, contraseña
  SI usuario = usuario_reg Y contraseña = pass_reg ENTONCES
      SI activo = VERDADERO ENTONCES
          acceso <- VERDADERO
          MOSTRAR "Acceso concedido"
      SINO
          acceso <- FALSO
          MOSTRAR "Cuenta inactiva"
      FIN_SI
  SINO
      intento <- intento + 1
      acceso <- FALSO
      MOSTRAR "Credenciales incorrectas"
  FIN_SI
FIN
```

### Ejecución paso a paso (ejemplo concreto)
1. Entrada: usuario="alumno01", contraseña="Clave123"
2. Comparación 1: usuario = usuario_reg ? "alumno01" = "alumno01" → VERDADERO
3. Comparación 2: contraseña = pass_reg ? "Clave123" = "Clave123" → VERDADERO
4. Verificar activo: activo = VERDADERO → VERDADERO
5. Resultado: acceso = VERDADERO → Mensaje: "Acceso concedido"

### Recordatorios y buenas prácticas
- Siempre sanitizar entradas (trim, manejo de mayúsculas/minúsculas) antes de comparar.
- No mostrar mensajes demasiado exactos en producción (p. ej. "Usuario correcto, contraseña incorrecta") para evitar dar pistas a atacantes.
- Limitar intentos y bloquear temporalmente cuentas tras varios intentos fallidos.

---
## 3. Ejemplos prácticos adicionales (resumidos)

### 3.1. Comprobar edad para registro (mayor de edad)
```
LEER edad
SI edad >= 18 ENTONCES
    MOSTRAR "Registro permitido"
SINO
    MOSTRAR "Debe ser mayor de 18 años"
FIN_SI
```

### 3.2. Validar formato de email (simplificado)
```
LEER email
SI existe_caracter(email, "@") Y existe_caracter(email, ".") ENTONCES
    MOSTRAR "Formato OK"
SINO
    MOSTRAR "Formato inválido"
FIN_SI
```

---
## 4. Ejercicios por niveles (orientados a Informática)

### Nivel 1 — Básico (práctico)
1. Escribir pseudocódigo que lea un número y muestre si es par o impar.
2. Pedir nombre de usuario; si es "admin" mostrar "Bienvenido administrador", sino "Bienvenido usuario".

### Nivel 2 — Intermedio (práctico + contextualizado)
1. Sistema de recuperación: leer usuario y email. Si coinciden con registro, mostrar "Enviar link de recuperación"; sino "Usuario no encontrado".
2. Calcular el precio final: leer precio y si `precio > 1000` aplicar 10% de descuento, sino precio sin descuento.

### Nivel 3 — Avanzado (práctico, algo abierto)
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

---
## 5. Soluciones (sugeridas) — breve
**Nivel 1.1 (par/impar)**
```
LEER n
SI n MOD 2 = 0 ENTONCES
    MOSTRAR "Par"
SINO
    MOSTRAR "Impar"
FIN_SI
```

**Nivel 2.2 (descuento)**
```
LEER precio
SI precio > 1000 ENTONCES
    descuento <- precio * 0.10
    total <- precio - descuento
SINO
    total <- precio
FIN_SI
MOSTRAR total
```

---
## 6. Reflexión personal y actividad final
Pedir a los estudiantes que escriban una breve reflexión (5–8 líneas) sobre:  
- ¿Qué tipo de errores fueron más comunes al escribir condicionales?  
- ¿Cómo ayudó el ejemplo paso a paso a entender el flujo lógico?  
- Proponer un mini-proyecto (2–3 frases) que use condicionales en una aplicación real informática.

---
### Material adicional (sugerido)
- Lista de comprobación para condicionales: condiciones claras, operadores lógicos correctos, manejo de casos límite, pruebas con datos extremos.
- Fichas de pseudocódigo con patrones (validación de usuario, cálculo de descuentos, selección de menú).
