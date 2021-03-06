package tela;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import simplex.Matriz;
import simplex.Restricao;

public class Modelagem extends javax.swing.JFrame {

    ArrayList<Restricao> restricoes = new ArrayList<>();
    static ArrayList<Restricao> restricoesSTC;// = new ArrayList<>();
    float[] funcaoOtimizadora;
    static float[] fnOtimizadora;
   public String tipo;

    public Modelagem() {
        initComponents();
        jPanelAdiciona.setVisible(false);
        funcaoOtimizadora = new float[Restricao.getQntVariaveis()];

    }

    static void addCoeficiente(float coeficiente, int index) {
        fnOtimizadora[index] = coeficiente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jTextFieldQntVariaveis = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelAdiciona = new javax.swing.JPanel();
        jButtonAddRestricao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRestricoes = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaFuncaoOtimizadora = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTipoRelacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantas variaveis?");

        jButtonAddRestricao.setText("Adicionar restricao");
        jButtonAddRestricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRestricaoActionPerformed(evt);
            }
        });

        jTextAreaRestricoes.setColumns(20);
        jTextAreaRestricoes.setRows(5);
        jScrollPane1.setViewportView(jTextAreaRestricoes);

        jButton3.setText("Definir Funcao otimizadora");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextAreaFuncaoOtimizadora.setColumns(20);
        jTextAreaFuncaoOtimizadora.setRows(5);
        jScrollPane2.setViewportView(jTextAreaFuncaoOtimizadora);

        jButton5.setText("Display Funcao");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Display restricoes");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setText("OBS: Insira os coeficientes da forma CÂNONICA");

        javax.swing.GroupLayout jPanelAdicionaLayout = new javax.swing.GroupLayout(jPanelAdiciona);
        jPanelAdiciona.setLayout(jPanelAdicionaLayout);
        jPanelAdicionaLayout.setHorizontalGroup(
            jPanelAdicionaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdicionaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdicionaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdicionaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelAdicionaLayout.createSequentialGroup()
                        .addGroup(jPanelAdicionaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanelAdicionaLayout.createSequentialGroup()
                                .addGroup(jPanelAdicionaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelAdicionaLayout.createSequentialGroup()
                                        .addComponent(jButtonAddRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton6))
                                    .addGroup(jPanelAdicionaLayout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5)))
                                .addGap(0, 30, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanelAdicionaLayout.setVerticalGroup(
            jPanelAdicionaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdicionaLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAdicionaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAdicionaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddRestricao)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jButton4.setText("Finalizar modelagem");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Qual tipo de otimizaçao?");

        jComboBoxTipoRelacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max", "Min" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldQntVariaveis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxTipoRelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jPanelAdiciona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAdiciona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQntVariaveis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoRelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(118, 118, 118)
                        .addComponent(jButton4)
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        restricoes = new ArrayList<>();
        restricoesSTC = new ArrayList<>();
        if (!jTextFieldQntVariaveis.getText().isEmpty()) {
            int qntVariaveis = Integer.parseInt(jTextFieldQntVariaveis.getText());
            Restricao.setQntVariaveis(qntVariaveis);
            funcaoOtimizadora = new float[Restricao.getQntVariaveis()];
            fnOtimizadora = new float[Restricao.getQntVariaveis()];
            int index = jComboBoxTipoRelacao.getSelectedIndex();
            if (index == 0) {
                tipo = "max";
            } else {
                tipo = "min";
            }
            jPanelAdiciona.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Insira o numero de variaveis a serem utilizadas no probelma!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        for (int i = 0; i < Restricao.getQntVariaveis(); i++) {
            FuncaoOtimizadora funcao = new FuncaoOtimizadora(i, tipo);
            funcao.setVisible(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        funcaoOtimizadora = fnOtimizadora;
        imprimeFuncaoOtimizadora();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonAddRestricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRestricaoActionPerformed
        Restricoes restricoesTela = new Restricoes();
        restricoesTela.setVisible(true);
    }//GEN-LAST:event_jButtonAddRestricaoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (restricoesSTC != null) {
            restricoes = restricoesSTC;
            imprimeRestricoes();
        } else {
            JOptionPane.showMessageDialog(null, "Insira uma restriçao antes!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (restricoesSTC != null) {
            restricoes = restricoesSTC;
            Matriz matriz = new Matriz(restricoes, funcaoOtimizadora);
            Principal.setMatrizStc(matriz);
            Principal.setRestricoesModelagem(restricoes);
            Principal.jTextArea1.setText(Principal.imprimir(matriz));
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Insira um modelo de problema antes!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonAddRestricao;
    private javax.swing.JComboBox<String> jComboBoxTipoRelacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelAdiciona;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaFuncaoOtimizadora;
    private javax.swing.JTextArea jTextAreaRestricoes;
    private javax.swing.JTextField jTextFieldQntVariaveis;
    // End of variables declaration//GEN-END:variables

    private void imprimeFuncaoOtimizadora() {
        String str = "Z=";
        for (int i = 0; i < funcaoOtimizadora.length; i++) {
            String coeficiente = String.format("%.0f", funcaoOtimizadora[i]);
            if (funcaoOtimizadora[i] < 0) {
                str += "" + coeficiente;
            } else {
                str += " +" + coeficiente;
            }
            str += "* x" + (i + 1);

        }
        str += "";
        jTextAreaFuncaoOtimizadora.setText(str);
    }

    public static void addRestricao(Restricao restricao) {
        if (restricoesSTC == null) {
            restricoesSTC = new ArrayList<>();
        }
        if (!restricoesSTC.contains(restricao)) {
            restricoesSTC.add(restricao);
        }

    }

    private void imprimeRestricoes() {
        String str = "";
        for (int j = 0; j < restricoes.size(); j++) {
            for (int i = 0; i < restricoes.get(j).getCoeficientes().length; i++) {
                if (restricoes.get(j).getCoeficientes()[i] > 0) {
                    String coeficiente = String.format("%.0f", restricoes.get(j).getCoeficientes()[i]);
                    str += "+ " + coeficiente + " x" + (i + 1);
                }
                if (restricoes.get(j).getCoeficientes()[i] < 0) {
                    String coeficiente = String.format("%.0f", restricoes.get(j).getCoeficientes()[i]);
                    str += coeficiente + " x" + (i + 1);
                }
            }
            str += " " + restricoes.get(j).getRelacao();
            if (restricoes.get(j).getB() >= 0) {
                str += " + " + restricoes.get(j).getB();
            } else {
                str += " " + restricoes.get(j).getB();
            }
            str += "\n";
        }
        jTextAreaRestricoes.setText(str);
    }

    private String retornaModelagem() {
        String modelagem;
        String str = "Z";
        for (int i = 0; i < funcaoOtimizadora.length; i++) {
            String coeficiente = String.format("%.0f", funcaoOtimizadora[i]);
            if (funcaoOtimizadora[i] < 0) {
                str += "" + coeficiente;
            } else {
                str += " +" + coeficiente;
            }
            str += "* x" + (i + 1);

        }
        str += "=0\n";
        modelagem = str;
        str = "";
        for (int j = 0; j < restricoes.size(); j++) {
            for (int i = 0; i < restricoes.get(j).getCoeficientes().length; i++) {
                if (restricoes.get(j).getCoeficientes()[i] > 0) {
                    String coeficiente = String.format("%.0f", restricoes.get(j).getCoeficientes()[i]);
                    str += "+ " + coeficiente + " x" + (i + 1);
                }
                if (restricoes.get(j).getCoeficientes()[i] < 0) {
                    String coeficiente = String.format("%.0f", restricoes.get(j).getCoeficientes()[i]);
                    str += coeficiente + " x" + (i + 1);
                }
            }
            str += " " + restricoes.get(j).getRelacao();
            if (restricoes.get(j).getB() >= 0) {
                str += " + " + restricoes.get(j).getB();
            } else {
                str += " " + restricoes.get(j).getB();
            }
            str += "\n";
        }
        modelagem += "\n" + str;
        return modelagem;
    }
}
