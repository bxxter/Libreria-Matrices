/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria_matrices;

/**
 * Esta clase final representa una matriz matemática y proporciona métodos 
 * estáticos para realizar operaciones básicas con matrices.
 */
public final class Matriz {

    private static double[][] datos;
    private static int numFilas;
    private static int numColumnas;

    private Matriz() {}

    // Crea una nueva matriz con las dimensiones especificadas y retorna la matriz vacía

    /**
     *
     * @param filas
     * @param columnas
     * @return
     */
    public static double[][] crearMatriz(int filas, int columnas) {
        return new double[filas][columnas];
    }

    // Retorna la cantidad de filas que tiene la matriz

    /**
     *
     * @return
     */
    public int getFilas() {
        return this.numFilas;
    }
    
    // Retorna la cantidad de columnas que tiene la matriz

    /**
     *
     * @return
     */
    public int getColumnas() {
        return this.numColumnas;
    }
    
    // Obtiene el valor de una posición específica en la matriz

    /**
     *
     * @param matriz
     * @param fila
     * @param columna
     * @return
     */
    public static double getValor(double[][] matriz, int fila, int columna) {
        return matriz[fila][columna];
    }

    // Establece un valor en una posición específica de la matriz

    /**
     *
     * @param matriz
     * @param fila
     * @param columna
     * @param valor
     */
    public static void setValor(double[][] matriz, int fila, int columna, double valor) {
        matriz[fila][columna] = valor;
    }

    // Suma dos matrices y devuelve el resultado

    /**
     *
     * @param matriz1
     * @param matriz2
     * @return
     */
    public static double[][] sumar(double[][] matriz1, double[][] matriz2) {
        int filas = matriz1.length, columnas = matriz1[0].length;
        double[][] resultado = crearMatriz(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return resultado;
    }

    // Resta dos matrices y devuelve el resultado

    /**
     *
     * @param matriz1
     * @param matriz2
     * @return
     */
    public static double[][] restar(double[][] matriz1, double[][] matriz2) {
        int filas = matriz1.length, columnas = matriz1[0].length;
        double[][] resultado = crearMatriz(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }
        return resultado;
    }

    // Multiplica una matriz por un escalar

    /**
     *
     * @param matriz
     * @param escalar
     * @return
     */
    public static double[][] multiplicarPorEscalar(double[][] matriz, double escalar) {
        int filas = matriz.length, columnas = matriz[0].length;
        double[][] resultado = crearMatriz(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
        return resultado;
    }

    // Multiplica dos matrices

    /**
     *
     * @param matriz1
     * @param matriz2
     * @return
     */
    public static double[][] multiplicar(double[][] matriz1, double[][] matriz2) {
        int filas = matriz1.length, columnas = matriz2[0].length;
        int comun = matriz1[0].length;
        double[][] resultado = crearMatriz(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < comun; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }

    // Calcula el determinante de una matriz cuadrada (este metodo es recursivo)

    /**
     *
     * @param matriz
     * @return
     */
    public static double calcularDeterminante(double[][] matriz) {
        int n = matriz.length;
        if (n == 1) return matriz[0][0];
        if (n == 2) return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];

        double determinante = 0;
        for (int i = 0; i < n; i++) {
            double[][] submatriz = obtenerSubmatriz(matriz, 0, i);
            determinante += Math.pow(-1, i) * matriz[0][i] * calcularDeterminante(submatriz);
        }
        return determinante;
    }

    // Obtiene una submatriz eliminando una fila y columna específica
    private static double[][] obtenerSubmatriz(double[][] matriz, int filaEliminar, int columnaEliminar) {
        int n = matriz.length - 1;
        double[][] submatriz = new double[n][n];

        for (int i = 0, subI = 0; i < matriz.length; i++) {
            if (i == filaEliminar) continue;
            for (int j = 0, subJ = 0; j < matriz.length; j++) {
                if (j == columnaEliminar) continue;
                submatriz[subI][subJ++] = matriz[i][j];
            }
            subI++;
        }
        return submatriz;
    }

    // Calcula la traza de una matriz cuadrada (Primera diagonal)

    /**
     *
     * @param matriz
     * @return
     */
    public static double calcularTraza(double[][] matriz) {
        int n = matriz.length;
        double traza = 0;
        for (int i = 0; i < n; i++) {
            traza += matriz[i][i];
        }
        return traza;
    }

    // Calcula la matriz transpuesta

    /**
     *
     * @param matriz
     * @return
     */
    public static double[][] calcularTranspuesta(double[][] matriz) {
        int filas = matriz.length, columnas = matriz[0].length;
        double[][] transpuesta = crearMatriz(columnas, filas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

    // Calcula la matriz inversa (usando la matriz adjunta)

    /**
     *
     * @param matriz
     * @return
     */
    public static double[][] calcularInversa(double[][] matriz) {
        int n = matriz.length;
        double determinante = calcularDeterminante(matriz);
        if (determinante == 0) throw new IllegalArgumentException("La matriz no es invertible.");

        double[][] adjunta = calcularAdjunta(matriz);
        return multiplicarPorEscalar(adjunta, 1 / determinante);
    }

    // Calcula la matriz adjunta
    private static double[][] calcularAdjunta(double[][] matriz) {
        int n = matriz.length;
        double[][] adjunta = crearMatriz(n, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[][] submatriz = obtenerSubmatriz(matriz, i, j);
                double cofactor = Math.pow(-1, i + j) * calcularDeterminante(submatriz);
                adjunta[j][i] = cofactor;
            }
        }
        return adjunta;
    }

    // Imprime la matriz

    /**
     *
     * @param matriz
     */
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.printf("%8.2f", valor);
            }
            System.out.println();
        }
        System.out.println();
    }
}

