package tela;

import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javax.swing.JOptionPane;
import simplex.Matriz;
import simplex.Restricao;

public class Principal extends javax.swing.JFrame {

    public static ArrayList<Restricao> restricoesModelagem = new ArrayList<>();
    public static Matriz matrizStc;
    public Matriz matriz;
    ArrayList<String> variaveis = new ArrayList<>();
    ArrayList<String> folgas = new ArrayList<>();
    Modelagem modelagem;

    public Principal() {
        initComponents();
        modelagem = new Modelagem();
        modelagem.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Adicionar Modelagem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mostrar quadro otimo SIMPLEX");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton3.setText("Mostrar otimização");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modelagem.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (matrizStc != null) {
            matriz = matrizStc;
            matriz.resolveSimplex(restricoesModelagem);

            jTextArea1.setText("------------------------------------\n" + imprimir(matriz) + "\n------------------------------------\n");
        } else {
            JOptionPane.showMessageDialog(null, "Insira um modelo de problema antes!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (matrizStc != null) {
            matriz = matrizStc;
            matriz.resolveSimplex(restricoesModelagem);
            String str = "VARIAVEIS \t VALOR\n";
            for (int i = 0; i < matriz.getBasicas().size(); i++) {
                int coluna = matriz.getQuadro()[0].length - 1;
                if (modelagem.tipo.equals("min") && i + 1 == matriz.getBasicas().size()) {
                    str += matriz.getBasicas().get(i) + "\t\t" + -matriz.getQuadro()[i][coluna] + "\n";
                } else {
                    str += matriz.getBasicas().get(i) + "\t\t" + matriz.getQuadro()[i][coluna] + "\n";
                }

            }
            //FAZER OS PROBLEMA LA
            str += "\nLegenda:\n fn ->folga da enesima restirção\n xn-> enesima variavel\n z-> resultado da otimização";
            jTextArea1.setText(str);
        } else {
            JOptionPane.showMessageDialog(null, "Insira um modelo de problema antes!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    public static void setMatrizStc(Matriz matrizStc) {
        Principal.matrizStc = matrizStc;
    }

    public static void setRestricoesModelagem(ArrayList<Restricao> restricoesModelagem) {
        Principal.restricoesModelagem = restricoesModelagem;
    }

    public static String imprimir(Matriz matriz) {

        String str = "\t";
        for (int i = 0; i < matriz.getCoeficientes()[0].length; i++) {
            str += "x" + (i + 1) + "\t";
        }
        for (int i = 0; i < matriz.getFolgas()[0].length; i++) {
            str += "f" + (i + 1) + "\t";
        }
        for (int i = 0; i < matriz.getArtificiais()[0].length; i++) {
            str += "a" + (i + 1) + "\t";
        }
        str += "b\n";
        for (int i = 0; i < matriz.getQuadro().length; i++) {
            str += matriz.getBasicas().get(i) + "\t";
            for (int j = 0; j < matriz.getQuadro()[0].length; j++) {
                str += matriz.getQuadro()[i][j] + "\t";
            }
            str += "\n";
        }
        return str;

    }
}
