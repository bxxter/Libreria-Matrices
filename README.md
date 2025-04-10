# 📚 Librería Matrices  

Librería escrita en Java que permite realizar operaciones con matrices matemáticas de manera eficiente.  

## 🚀 Características  
* ✅ Operaciones básicas: suma, resta, multiplicación.  
* 🔢 Operaciones avanzadas: Multiplicación por escalar, determinante, traza, transpuesta, inversa.  

## 📖 Documentación  

### 📌 Clase Matriz  

La clase Matriz proporciona métodos para realizar operaciones con matrices, las cuales son representadas por arreglos de tipo double [][].  

### 📌 Métodos Principales

| Método | Descripción |
|--------|-------------|
| crearMatriz(int filas, int columnas) | Crea una nueva matriz vacía con las dimensiones especificadas. |
| getFilas() | Retorna la cantidad de filas de la matriz. |
| getColumnas() | Retorna la cantidad de columnas de la matriz. |
| getValor(double[][] matriz, int fila, int columna) | Obtiene el valor de una celda específica en la matriz. |
| setValor(double[][] matriz, int fila, int columna, double valor) | Asigna un valor a una celda específica de la matriz. |
| sumar(double[][] matriz1, double[][] matriz2) | Retorna la suma de dos matrices del mismo tamaño. |
| restar(double[][] matriz1, double[][] matriz2) | Retorna la resta de dos matrices del mismo tamaño. |
| multiplicarPorEscalar(double[][] matriz, double escalar) | Retorna la matriz original multiplicada por un escalar. |
| multiplicar(double[][] matriz1, double[][] matriz2) | Retorna el producto de dos matrices compatibles para multiplicación. |
| calcularDeterminante(double[][] matriz) | Calcula el determinante de una matriz cuadrada. |
| calcularTraza(double[][] matriz) | Calcula la traza de una matriz cuadrada (suma de los elementos de la diagonal principal). |
| calcularTranspuesta(double[][] matriz) | Retorna la matriz transpuesta. |
| calcularInversa(double[][] matriz) | Calcula y retorna la matriz inversa si es invertible, de lo contrario lanza una excepción. |
| imprimirMatriz(double[][] matriz) | Imprime la matriz en consola. |

## 📦 Instalación  
1. Clona el repositorio  
```bash  
git clone https://github.com/bxxter/Libreria-Matrices.git  
```  
2. En tu proyecto de Java, agrega el archivo Proyecto_Libreria.jar a las librerías:  
   - En NetBeans: haz clic derecho sobre la carpeta "Libraries" dentro de tu proyecto *Projects -> Libraries -> Add JAR/Folder* y selecciona LibreriaMatrices.jar.  
3. Importa la librería en tu código con:  
```   java  
import libreria_matrices.Matriz;  
```     

## 🛠 Uso/Ejemplo  

### Crear una matriz  

```java  
double[][] m = Matriz.crearMatriz(2, 2); // Crear matriz 2x2  
Matriz.setValor(m, 0, 0, 1.5); // Establecer valor en (0,0)  
Matriz.setValor(m, 0, 1, 2.0); // Establecer valor en (0,1)  
Matriz.setValor(m, 1, 0, 3.0); // Establecer valor en (1,0)  
Matriz.setValor(m, 1, 1, 4.5); // Establecer valor en (1,1)  
```

### Operaciones básicas  

```java  
// Crear dos matrices  
double[][] m1 = { {1, 2}, {3, 4} };  
double[][] m2 = { {5, 6}, {7, 8} };  

// Suma  
double[][] suma = Matriz.sumar(m1, m2);  
Matriz.imprimirMatriz(suma);  

// Resta  
double[][] resta = Matriz.restar(m1, m2);  
System.out.println("Resta de matrices:");  
Matriz.imprimirMatriz(resta); 

// Multiplicación  
double[][] producto = Matriz.multiplicar(m1, m2);  
Matriz.imprimirMatriz(producto);  
```  

## ⚙ Ejemplo de Implementación  

### Video Explicativo

[![Video Explicativo](https://img.youtube.com/vi/UlRzD6CIt90/0.jpg)](https://www.youtube.com/watch?v=UlRzD6CIt90&feature=youtu.be)


### Screenshots
![Frame Operaciones Matriz](https://i.imgur.com/s42YDBv.png)

![Frame resultados operaciones](https://i.imgur.com/qLmFCP0.png)


## 🚀 Construido con  
* ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  

## Autores  

| [<img src="https://avatars.githubusercontent.com/u/166089639?v=4" width=115><br><sub>Azael</sub>](https://github.com/bxxter) | [<img src="https://avatars.githubusercontent.com/u/205721466?v=4" width=115><br><sub>Fernando</sub>](https://github.com/Bazendu) |  
| :---: | :---: |
