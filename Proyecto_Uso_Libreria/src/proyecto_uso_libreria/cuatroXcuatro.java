/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_uso_libreria;

import javax.swing.JOptionPane;
import libreria_matrices.Matriz;

public class cuatroXcuatro extends javax.swing.JFrame {

    double[][] A;
    double[][] B;
    
    public cuatroXcuatro() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void obtenerValoresMatrices() {
        A = new double[4][4];
        B = new double[4][4];

        // Matriz A
        A[0][0] = Double.parseDouble(A1.getText());
        A[0][1] = Double.parseDouble(A2.getText());
        A[0][2] = Double.parseDouble(A3.getText());
        A[0][3] = Double.parseDouble(A4.getText());
    
        A[1][0] = Double.parseDouble(A5.getText());
        A[1][1] = Double.parseDouble(A6.getText());
        A[1][2] = Double.parseDouble(A7.getText());
        A[1][3] = Double.parseDouble(A8.getText());
    
        A[2][0] = Double.parseDouble(A9.getText());
        A[2][1] = Double.parseDouble(A10.getText());
        A[2][2] = Double.parseDouble(A11.getText());
        A[2][3] = Double.parseDouble(A12.getText());
    
        A[3][0] = Double.parseDouble(A13.getText());
        A[3][1] = Double.parseDouble(A14.getText());
        A[3][2] = Double.parseDouble(A15.getText());
        A[3][3] = Double.parseDouble(A16.getText());

        // Matriz B
        B[0][0] = Double.parseDouble(B1.getText());
        B[0][1] = Double.parseDouble(B2.getText());
        B[0][2] = Double.parseDouble(B3.getText());
        B[0][3] = Double.parseDouble(B4.getText());
    
        B[1][0] = Double.parseDouble(B5.getText());
        B[1][1] = Double.parseDouble(B6.getText());
        B[1][2] = Double.parseDouble(B7.getText());
        B[1][3] = Double.parseDouble(B8.getText());
    
        B[2][0] = Double.parseDouble(B9.getText());
        B[2][1] = Double.parseDouble(B10.getText());
        B[2][2] = Double.parseDouble(B11.getText());
        B[2][3] = Double.parseDouble(B12.getText());
    
        B[3][0] = Double.parseDouble(B13.getText());
        B[3][1] = Double.parseDouble(B14.getText());
        B[3][2] = Double.parseDouble(B15.getText());
        B[3][3] = Double.parseDouble(B16.getText());
    }
    
     // Método para realizar operaciones
    private void verificarOperaciones(double[][] A, double[][] B) {
        StringBuilder resultado = new StringBuilder();

    // Verificar dimensiones para operaciones que tienen restricciones relacionadas al tamaño
        boolean dimensionesCompatibles = A.length == B.length && A[0].length == B[0].length;

        if (jboxSuma.isSelected() && dimensionesCompatibles) {
            try {
                double[][] suma = Matriz.sumar(A, B);
                resultado.append("----- SUMA (A + B) -----\n").append(matrizToString(suma)).append("\n");
            } catch (Exception e) {
                resultado.append("Error en suma: ").append(e.getMessage()).append("\n");
            }
        }

        if (jboxResta.isSelected() && dimensionesCompatibles) {
            try {
                double[][] resta = Matriz.restar(A, B);
                resultado.append("----- RESTA (A - B) -----\n").append(matrizToString(resta)).append("\n");
            } catch (Exception e) {
                resultado.append("Error en resta: ").append(e.getMessage()).append("\n");
            }
        }

        if (jboxMultiplicacion.isSelected() && A[0].length == B.length) {
            try {
                double[][] multiplicacion = Matriz.multiplicar(A, B);
                resultado.append("----- MULTIPLICACIÓN (A × B) -----\n").append(matrizToString(multiplicacion)).append("\n");
            } catch (Exception e) {
                resultado.append("Error en multiplicación: ").append(e.getMessage()).append("\n");
            }
        }

        if (jboxInversa.isSelected()) {
            try {
                if (A.length == A[0].length) {
                    double[][] inversaA = Matriz.calcularInversa(A);
                    resultado.append("----- INVERSA DE A -----\n").append(matrizToString(inversaA)).append("\n");
                } else {
                    resultado.append("Inversa de A: No se puede calcular (matriz no cuadrada)\n");
                }
            
                if (B.length == B[0].length) {
                    double[][] inversaB = Matriz.calcularInversa(B);
                    resultado.append("----- INVERSA DE B -----\n").append(matrizToString(inversaB)).append("\n");
                } else {
                    resultado.append("Inversa de B: No se puede calcular (matriz no cuadrada)\n");
                }
            } catch (Exception e) {
                resultado.append("Error calculando inversas: ").append(e.getMessage()).append("\n");
            }
        }

        if (jboxTranspuesta.isSelected()) {
            try {
                double[][] transpuestaA = Matriz.calcularTranspuesta(A);
                resultado.append("----- TRANSPUESTA DE A -----\n").append(matrizToString(transpuestaA)).append("\n");
            
                double[][] transpuestaB = Matriz.calcularTranspuesta(B);
                resultado.append("----- TRANSPUESTA DE B -----\n").append(matrizToString(transpuestaB)).append("\n");
            } catch (Exception e) {
                resultado.append("Error calculando transpuestas: ").append(e.getMessage()).append("\n");
            }
        }

        if (jboxDeterminante.isSelected()) {
            try {
                if (A.length == A[0].length) {
                    double determinanteA = Matriz.calcularDeterminante(A);
                    resultado.append("----- DETERMINANTE DE A -----\n").append(String.format("%.2f", determinanteA)).append("\n");
                } else {
                    resultado.append("Determinante de A: No se puede calcular (matriz no cuadrada)\n");
                }
            
                if (B.length == B[0].length) {
                    double determinanteB = Matriz.calcularDeterminante(B);
                    resultado.append("----- DETERMINANTE DE B -----\n").append(String.format("%.2f", determinanteB)).append("\n");
                } else {
                    resultado.append("Determinante de B: No se puede calcular (matriz no cuadrada)\n");
                }
            } catch (Exception e) {
                resultado.append("Error calculando determinantes: ").append(e.getMessage()).append("\n");
            }
        }

        if (jboxDiagonales.isSelected()) {
            try {
                if (A.length == A[0].length) {
                    double trazaA = Matriz.calcularTraza(A);
                    resultado.append("----- TRAZA DE A -----\n").append(String.format("%.2f", trazaA)).append("\n");
                } else {
                    resultado.append("Traza de A: No se puede calcular (matriz no cuadrada)\n");
                }
            
                if (B.length == B[0].length) {
                    double trazaB = Matriz.calcularTraza(B);
                    resultado.append("----- TRAZA DE B -----\n").append(String.format("%.2f", trazaB)).append("\n");
                } else {
                    resultado.append("Traza de B: No se puede calcular (matriz no cuadrada)\n");
                }
            } catch (Exception e) {
                resultado.append("Error calculando trazas: ").append(e.getMessage()).append("\n");
            }
        }

     // Mostrar el resultado
        mostrarResultado(resultado.toString());
    }
    
    // Método para convertir matriz a String con formato
    private String matrizToString(double[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (double[] fila : matriz) {
            for (double valor : fila) {
                sb.append(String.format("%8.2f", valor));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Método para mostrar resultados
    private void mostrarResultado(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        A1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        A5 = new javax.swing.JTextField();
        A2 = new javax.swing.JTextField();
        A6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        A8 = new javax.swing.JTextField();
        B3 = new javax.swing.JTextField();
        A7 = new javax.swing.JTextField();
        B7 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jboxResta = new javax.swing.JCheckBox();
        jboxMultiplicacion = new javax.swing.JCheckBox();
        jboxTranspuesta = new javax.swing.JCheckBox();
        jboxSuma = new javax.swing.JCheckBox();
        jboxDeterminante = new javax.swing.JCheckBox();
        jboxDiagonales = new javax.swing.JCheckBox();
        jboxInversa = new javax.swing.JCheckBox();
        btnAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        A9 = new javax.swing.JTextField();
        A3 = new javax.swing.JTextField();
        B4 = new javax.swing.JTextField();
        B8 = new javax.swing.JTextField();
        A10 = new javax.swing.JTextField();
        A4 = new javax.swing.JTextField();
        B11 = new javax.swing.JTextField();
        B12 = new javax.swing.JTextField();
        A13 = new javax.swing.JTextField();
        A14 = new javax.swing.JTextField();
        A11 = new javax.swing.JTextField();
        A15 = new javax.swing.JTextField();
        A12 = new javax.swing.JTextField();
        A16 = new javax.swing.JTextField();
        B16 = new javax.swing.JTextField();
        B15 = new javax.swing.JTextField();
        B2 = new javax.swing.JTextField();
        B6 = new javax.swing.JTextField();
        B10 = new javax.swing.JTextField();
        B14 = new javax.swing.JTextField();
        B1 = new javax.swing.JTextField();
        B5 = new javax.swing.JTextField();
        B9 = new javax.swing.JTextField();
        B13 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matriz  A");

        jLabel2.setText("Matriz  B");

        jboxResta.setText("Resta");
        jboxResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jboxRestaActionPerformed(evt);
            }
        });

        jboxMultiplicacion.setText("Multiplicación");

        jboxTranspuesta.setText("Transpuesta");

        jboxSuma.setText("Suma");

        jboxDeterminante.setText("Determinantes");

        jboxDiagonales.setText("Traza (Diagonal principal)");

        jboxInversa.setText("Inversas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jboxTranspuesta)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jboxSuma)
                            .addComponent(jboxResta)
                            .addComponent(jboxMultiplicacion))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jboxInversa)
                            .addComponent(jboxDiagonales)
                            .addComponent(jboxDeterminante))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jboxSuma)
                    .addComponent(jboxDeterminante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jboxResta)
                    .addComponent(jboxDiagonales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jboxMultiplicacion)
                    .addComponent(jboxInversa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jboxTranspuesta)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel4.setText("Operaciones a realizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAceptar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(A3, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(A9)
                                    .addComponent(A5, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(A13))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(A10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(A14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(A11, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                            .addComponent(A15))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(A16)
                            .addComponent(A12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(A8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(A4))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B1)
                            .addComponent(B5)
                            .addComponent(B9)
                            .addComponent(B13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B6, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(B2)
                            .addComponent(B10)
                            .addComponent(B14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(B15, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(B7)
                                    .addComponent(B11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(B8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(B12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(A9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(A13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    if (A1.getText().isEmpty() || A2.getText().isEmpty() || 
    A3.getText().isEmpty() || A4.getText().isEmpty() ||
    A5.getText().isEmpty() || A7.getText().isEmpty() ||
    A8.getText().isEmpty() || A9.getText().isEmpty() ||
    A10.getText().isEmpty() || A11.getText().isEmpty() ||
    A12.getText().isEmpty() || A12.getText().isEmpty() ||
    A13.getText().isEmpty() || A14.getText().isEmpty() ||
    A15.getText().isEmpty() || A16.getText().isEmpty() ||
    B1.getText().isEmpty() || B2.getText().isEmpty() || 
    B3.getText().isEmpty() || B4.getText().isEmpty() ||
    B5.getText().isEmpty() || B6.getText().isEmpty() ||
    B7.getText().isEmpty() || B8.getText().isEmpty() ||
    B9.getText().isEmpty() || B10.getText().isEmpty() ||
    B11.getText().isEmpty() || B12.getText().isEmpty() ||
    B13.getText().isEmpty() || B14.getText().isEmpty() ||
    B15.getText().isEmpty() || B16.getText().isEmpty()) {
    
    JOptionPane.showMessageDialog(this, 
        "Todos los campos de las matrices deben estar rellenos.", 
        "Error", JOptionPane.ERROR_MESSAGE);
    return; // Salir del método si hay campos vacíos
    }

        // Validar que todos los campos contengan números
    try {
        // Obtener valores de las matrices
        obtenerValoresMatrices();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, 
            "Todos los campos deben contener números válidos.", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Validar que al menos una operación esté seleccionada
    if (!jboxSuma.isSelected() && !jboxResta.isSelected() && 
        !jboxMultiplicacion.isSelected() && !jboxTranspuesta.isSelected() && 
        !jboxDeterminante.isSelected() && !jboxDiagonales.isSelected() && 
        !jboxInversa.isSelected()) {
        
        JOptionPane.showMessageDialog(this, 
            "Debe seleccionar al menos una operación.", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Ejecutar las operaciones seleccionadas
    verificarOperaciones(A, B);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jboxRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jboxRestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jboxRestaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cuatroXcuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cuatroXcuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cuatroXcuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cuatroXcuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cuatroXcuatro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField A1;
    private javax.swing.JTextField A10;
    private javax.swing.JTextField A11;
    private javax.swing.JTextField A12;
    private javax.swing.JTextField A13;
    private javax.swing.JTextField A14;
    private javax.swing.JTextField A15;
    private javax.swing.JTextField A16;
    private javax.swing.JTextField A2;
    private javax.swing.JTextField A3;
    private javax.swing.JTextField A4;
    private javax.swing.JTextField A5;
    private javax.swing.JTextField A6;
    private javax.swing.JTextField A7;
    private javax.swing.JTextField A8;
    private javax.swing.JTextField A9;
    private javax.swing.JTextField B1;
    private javax.swing.JTextField B10;
    private javax.swing.JTextField B11;
    private javax.swing.JTextField B12;
    private javax.swing.JTextField B13;
    private javax.swing.JTextField B14;
    private javax.swing.JTextField B15;
    private javax.swing.JTextField B16;
    private javax.swing.JTextField B2;
    private javax.swing.JTextField B3;
    private javax.swing.JTextField B4;
    private javax.swing.JTextField B5;
    private javax.swing.JTextField B6;
    private javax.swing.JTextField B7;
    private javax.swing.JTextField B8;
    private javax.swing.JTextField B9;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox jboxDeterminante;
    private javax.swing.JCheckBox jboxDiagonales;
    private javax.swing.JCheckBox jboxInversa;
    private javax.swing.JCheckBox jboxMultiplicacion;
    private javax.swing.JCheckBox jboxResta;
    private javax.swing.JCheckBox jboxSuma;
    private javax.swing.JCheckBox jboxTranspuesta;
    // End of variables declaration//GEN-END:variables
}
