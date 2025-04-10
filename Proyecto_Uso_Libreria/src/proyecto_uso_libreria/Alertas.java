/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_uso_libreria;


import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Bazendu
 */
public class Alertas {
    
    public boolean validarFilayColumna(String fila, String columna) {
        // Validar que no sean nulos
        if (fila == null || columna == null) {
            mostrarError("Los campos no pueden ser nulos");
            return false;
        }
        
        // Validar que no estén vacíos
        if (fila.trim().isEmpty() && columna.trim().isEmpty()) {
            mostrarError("Los campos no pueden estar vacíos");
            return false;
        }
        
        if (fila.trim().isEmpty()) {
            mostrarError("La fila no puede estar vacía");
            return false;
        }
        
        if (columna.trim().isEmpty()) {
            mostrarError("La columna no puede estar vacía");
            return false;
        }
        
        // Validar que sean números
        try {
            int numFila = Integer.parseInt(fila);
            int numColumna = Integer.parseInt(columna);
            
            // Validar que sean iguales
            if (numFila != numColumna) {
                mostrarError("No se puede crear la matriz: fila y columna deben ser iguales");
                return false;
            }
            
        } catch (NumberFormatException e) {
            mostrarError("Fila y Columna deben ser números enteros válidos");
            return false;
        }
        
        return true;  
    }
    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
            null, 
            mensaje, 
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    
     // Devuelve la dimensión válida o -1 si hay error
    public int validarDimensiones(String fila, String columna) {
        try {
            // Validar vacíos/nulos
            if(fila == null || columna == null || fila.isEmpty() || columna.isEmpty()) {
                mostrarError("Los campos no pueden estar vacíos");
                return -1;
            }
            
            // Convertir a números
            int numFila = Integer.parseInt(fila);
            int numColumna = Integer.parseInt(columna);
            
            // Validar que sean iguales
            if(numFila != numColumna) {
                mostrarError("Debe ser una matriz cuadrada (mismo valor en filas y columnas)");
                return -1;
            }
            
            // Validar rangos permitidos (2-4)
            if(numFila < 2 || numFila > 4) {
                mostrarError("Solo se permiten dimensiones de 2x2, 3x3 o 4x4");
                return -1;
            }
            
            return numFila;
            
        } catch(NumberFormatException e) {
            mostrarError("Debe ingresar números enteros válidos");
            return -1;
        }
    }
}
