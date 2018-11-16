package tela;

import javax.swing.JOptionPane;
import simplex.Restricao;

public class Restricoes extends javax.swing.JFrame {

    float[] coeficientes;
    float b;
    String relacao;

    public Restricoes() {
        initComponents();
        coeficientes = new float[Restricao.getQntVariaveis()];
        jLabelAviso.setText("VOCE POSSUI " + Restricao.getQntVariaveis() + " VARIAVEIS");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCoeficientes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextAreaCoeficientes.setColumns(20);
        jTextAreaCoeficientes.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCoeficientes);

        jLabel1.setText("Exemplo: 1x1-2x2+4x4>=100");

        jLabel2.setText("Digite:1;-2;0;4;>=;100");

        jLabel3.setText("Digite os coeficientes da restrição, a relação e o termo independente:");

        jLabelAviso.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabelAviso)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabelAviso)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextAreaCoeficientes.getText().isEmpty()) {
            String txt = jTextAreaCoeficientes.getText();
            String[] strCoeficientes = txt.split(";");
            if (strCoeficientes.length == Restricao.getQntVariaveis() + 2) {
                for (int i = 0; i < strCoeficientes.length; i++) {
                    if (i < Restricao.getQntVariaveis()) {
                        coeficientes[i] = Float.parseFloat(strCoeficientes[i]);
                    } else {
                        if ((i == Restricao.getQntVariaveis())) {
                            relacao = strCoeficientes[i];
                        } else {
                            b = Float.parseFloat(strCoeficientes[i]);
                        }
                    }

                }
                Restricao restricao = new Restricao(coeficientes, "normal", relacao, b);
                Modelagem.addRestricao(restricao);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Insira o numero de coeficientes certo! Voce digitou" + strCoeficientes.length + " mas sao necessario " + (Restricao.getQntVariaveis() + 2));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira os coeficientes antes!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCoeficientes;
    // End of variables declaration//GEN-END:variables
}
