package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.SaidasDAO;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.awt.event.KeyEvent;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class AlteraOperacaoSaidaView extends javax.swing.JDialog {

    SaidasDAO dao = new SaidasDAO();
    String nomeOP;
    String nomeUs;
    ClienteEntity ce = new ClienteEntity();
    VendaEntity ve = new VendaEntity();

    VendasView saidasV = new VendasView(null, null, null, ce, null, ve);

    /**
     * Creates new form EntradaView
     */
    public AlteraOperacaoSaidaView(VendasView vv) {
        this.saidasV = vv;
        this.initComponents();
        this.setModal(true);
//        tfOperacao.setEnabled(false);
        // tfCaiNome.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfOperacao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbOperacao = new javax.swing.JComboBox();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecione a Operação");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jLabel3.setText("Operação");

        tfOperacao.setText("1");
        tfOperacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfOperacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfOperacaoFocusLost(evt);
            }
        });
        tfOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOperacaoActionPerformed(evt);
            }
        });
        tfOperacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfOperacaoKeyPressed(evt);
            }
        });

        jButton1.setText("Começar-F12");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar-F5");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VENDA ESTADUAL", "PRE-VENDA", "BRINDE", "TROCA" }));
        cbOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOperacaoActionPerformed(evt);
            }
        });
        cbOperacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbOperacaoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfOperacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOperacaoFocusLost
        pesquisaOperacao();
    }//GEN-LAST:event_tfOperacaoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tfOperacao.getText().isEmpty()) {
            new Alertas().mensagemAviso("Preencha todos os campos!");
        } else {
            saidasV.selecionaOperacao(cbOperacao.getSelectedItem().toString());
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOperacaoActionPerformed
        pesquisaOperacao();
    }//GEN-LAST:event_tfOperacaoActionPerformed

    private void cbOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOperacaoActionPerformed
        if (cbOperacao.getSelectedIndex() == 0) {
            tfOperacao.setText("1");
        }
        if (cbOperacao.getSelectedIndex() == 1) {
            tfOperacao.setText("2");
        }
        if (cbOperacao.getSelectedIndex() == 2) {
            tfOperacao.setText("3");
        }
         if (cbOperacao.getSelectedIndex() == 3) {
            tfOperacao.setText("4");
        }
    }//GEN-LAST:event_cbOperacaoActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.requestFocus();
        tfOperacao.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfOperacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOperacaoKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_tfOperacaoKeyPressed

    private void cbOperacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbOperacaoKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_cbOperacaoKeyPressed

    private void tfOperacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOperacaoFocusGained
        tfOperacao.selectAll();
    }//GEN-LAST:event_tfOperacaoFocusGained

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        atalhos(evt);
    }//GEN-LAST:event_jPanel1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraOperacaoSaidaView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbOperacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfOperacao;
    // End of variables declaration//GEN-END:variables

    private void pesquisaOperacao() {
        Integer cod = Integer.parseInt(tfOperacao.getText());
        if (cod < 5 && cod > 0) {
            if (Integer.parseInt(tfOperacao.getText()) == 1) {
                cbOperacao.setSelectedIndex(0);
            }
            if (Integer.parseInt(tfOperacao.getText()) == 2) {
                cbOperacao.setSelectedIndex(1);
            }
            if (Integer.parseInt(tfOperacao.getText()) == 3) {
                cbOperacao.setSelectedIndex(2);
            }
            if (Integer.parseInt(tfOperacao.getText()) == 4) {
                cbOperacao.setSelectedIndex(3);
            }
        } else {
            new Alertas().mensagemAviso("O intervalo que deve ser digitado é entre 1 e 3");
        }
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            if (tfOperacao.getText().isEmpty()) {
                new Alertas().mensagemAviso("Preencha todos os campos!");
            } else {
                saidasV.selecionaOperacao(cbOperacao.getSelectedItem().toString());
                this.dispose();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            this.dispose();
        }
    }

}
