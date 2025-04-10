# 📚 Librería Matrices

Librería escrita en Java que permite realizar operaciones con matrices matemáticas de manera eficiente.

## 🚀 Características
* ✅ Operaciones básicas: suma, resta, multiplicación.
* 🔢 Operaciones avanzadas: Multiplicación por escalar, determinante, traza, transpuesta, inversa.

## 📖 Documentación

### 📌 Clase `Matriz`

La clase `Matriz` proporciona métodos estáticos para realizar operaciones con matrices, las matrices son representadas por arreglos  `double[][]`.

### 📌 Métodos Principales

| Método | Descripción |
|--------|-------------|
| `crearMatriz(int numFilas, int numColumnas)` | Crea una nueva matriz vacía. |
| `getValor(double[][] matriz, int i, int j)` | Obtiene el valor de una celda de la matriz. |
| `establecerValor(double[][] matriz, int i, int j, double valor)` | Asigna un valor a una celda de la matriz. |
| `sumar(double[][] a, double[][] b)` | Retorna la suma de dos matrices. |
| `restar(double[][] a, double[][] b)` | Retorna la resta de dos matrices. |
| `multiplicarPorEscalar(double[][] a, double escalar)` | Multiplica la matriz por un escalar. |
| `multiplicar(double[][] a, double[][] b)` | Retorna el producto de dos matrices. |
| `calcularDeterminante(double[][] a)` | Calcula el determinante de una matriz cuadrada. |
| `calcularTranspuesta(double[][] a)` | Calcula la matriz transpuesta. |
| `calcularInversa(double[][] a)` | Calcula la inversa de una matriz cuadrada si es invertible. |
| `imprimirMatriz(double[][] a)` | Imprime la matriz en formato tabular en consola. |

---

## 📦 Instalación
1. Clona el repositorio
```bash
git clone https://github.com/bxxter/Libreria-Matrices.git
```
2. En tu proyecto de Java, agrega el `.jar` a las librerías:
   - En NetBeans: **Proyecto -> Propiedades -> Libraries -> Add JAR/Folder** y selecciona `LibreriaMatrices.jar`.
3. Importa la librería en tu código con:
   ```java
   import libreria.matrices.Matriz;
 
---

## 🛠️ Uso/Ejemplo

### Crear una matriz

```java
double[][] m = Matriz.crearMatriz(2, 2); // Matriz 2x2
Matriz.establecerValor(m, 0, 0, 1.5); // Establecer valor en (0,0)
```

### Operaciones básicas:

```java
// Suma
double[][] suma = Matriz.sumar(m1, m2);

// Multiplicación
double[][] producto = Matriz.multiplicar(m1, m2);

// Determinante
double det = Matriz.calcularDeterminante(matrizCuadrada);
```

---

## ⚙ Ejemplo de Implementación
### Screenshots
### Video explicativo

---

## 🚀 Construido con
* ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

## Autores

| [<img src="https://avatars.githubusercontent.com/u/166089639?v=4" width=115><br><sub>Azael</sub>](https://github.com/bxxter) | [<img src="https://avatars.githubusercontent.com/u/205721466?v=4" width=115><br><sub>Fernando</sub>](https://github.com/Bazendu) |
| :---: | :---: |
