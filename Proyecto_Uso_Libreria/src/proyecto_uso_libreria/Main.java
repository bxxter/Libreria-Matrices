/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_uso_libreria;

import javax.swing.JOptionPane;

/**
 *
 * @author Rzxyz
 */
public class Main {
     public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ventanaPrincipal().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Error al abrir la ventana: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}
