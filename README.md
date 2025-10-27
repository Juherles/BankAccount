# Proyecto: Cuenta Bancaria Mejorada

Este proyecto fue desarrollado como parte de la práctica de **Programación Orientada a Objetos (POO)**.  
El objetivo es aplicar los principios de **encapsulación**, **responsabilidad única**, **abierto/cerrado** y **dependencia invertida**, usando un ejemplo práctico de una **cuenta bancaria**.

---

## Descripción

El programa simula un sistema bancario sencillo que permite realizar las siguientes operaciones:

1. Transferir dinero entre cuentas.  
2. Aplicar intereses mensuales a las cuentas.  
3. Visualizar el historial de transacciones realizadas.

El código está organizado por clases y carpetas para mantener una buena estructura y separación de responsabilidades.

---

## Estructura del proyecto

Carpetas principales dentro de `src/com/bank`:

- **exception** → Maneja los errores y excepciones personalizadas.  
- **model** → Contiene las clases principales del modelo (cuenta, transacción, tipo de transacción).  
- **repository** → Administra el almacenamiento de cuentas (simulado en memoria).  
- **service** → Contiene la lógica de negocio (transferencias, intereses, historial).  
- **Main.java** → Punto de inicio del programa.  

---

## Cómo ejecutar el proyecto

1. Abre **Visual Studio Code**.  
2. Crea una carpeta llamada **CuentaBancaria**.  
3. Dentro de ella, copia la carpeta `src` y el archivo `README.md`.  
4. Asegúrate de que las rutas estén correctas, por ejemplo:  

5. Abre el archivo **Main.java**.  
6. Ejecuta el programa con la opción **"Run Java"** o usando la terminal:

```bash
javac src/com/bank/Main.java
java com.bank.Main

=== Transferencia ===
Transferencia exitosa de 150000.0 de la cuenta 001 a la cuenta 002

=== Aplicando intereses ===
Interés aplicado del 2% a la cuenta 001

=== Historial de transacciones ===
Transacción: DEPÓSITO - Monto: 500000.0
Transacción: TRANSFERENCIA - Monto: -150000.0
Transacción: INTERÉS - Monto: +10000.0

=== Saldos finales ===
Cuenta 001 - Juan Pérez: 360000.0
Cuenta 002 - Ana Gómez: 450000.0

---