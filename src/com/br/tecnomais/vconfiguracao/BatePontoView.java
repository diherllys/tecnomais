package com.br.tecnomais.vconfiguracao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.classes.NovaHora;
import com.br.tecnomais.dao.BatePontoDAO;
import com.br.tecnomais.entity.BatePontoEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Desenvolvimento
 */
public class BatePontoView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();

    NovaData dataAtual = new NovaData();
    String data = dataAtual.dataAtual();

    NovaHora horaAtual = new NovaHora();
    String hora = horaAtual.lerHora();

    ;
    /**
     * Creates new form BatePontoView
     */
    public BatePontoView() {
        initComponents();
        desabilitaCampos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfFuncionario = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfEntradaManha = new javax.swing.JTextField();
        tfSaidaManha = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        tfEntradaTarde = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfEntradaNoite = new javax.swing.JTextField();
        tfSaidaNoite = new javax.swing.JTextField();
        tfSaidaTarde = new javax.swing.JTextField();
        tfEntradaExtra = new javax.swing.JTextField();
        tfSaidaExtra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Livro de Ponto");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        jLabel2.setText("Funcionário");

        jLabel3.setText("Senha");

        tfFuncionario.setToolTipText("Digite o código do funcionário e aperta 'TAB'");
        tfFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfFuncionarioFocusLost(evt);
            }
        });

        tfSenha.setToolTipText("Digite a senha e permaneça no campo e selecione o horário com a hotkey desejada.");
        tfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSenhaActionPerformed(evt);
            }
        });
        tfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSenhaKeyReleased(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(200, 210, 210));

        jPanel2.setBackground(new java.awt.Color(170, 180, 180));

        jLabel4.setText("Manhã");

        tfEntradaManha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEntradaManha.setText("F1");
        tfEntradaManha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEntradaManhaActionPerformed(evt);
            }
        });
        tfEntradaManha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfEntradaManhaKeyReleased(evt);
            }
        });

        tfSaidaManha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSaidaManha.setText("F2");

        tfEntradaTarde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEntradaTarde.setText("F3");

        jLabel5.setText("Tarde");

        jLabel6.setText("Noite");

        jLabel7.setText("Extra");

        tfEntradaNoite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEntradaNoite.setText("F5");

        tfSaidaNoite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSaidaNoite.setText("F6");
        tfSaidaNoite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSaidaNoiteActionPerformed(evt);
            }
        });

        tfSaidaTarde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSaidaTarde.setText("F4");
        tfSaidaTarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSaidaTardeActionPerformed(evt);
            }
        });

        tfEntradaExtra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEntradaExtra.setText("F7");
        tfEntradaExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEntradaExtraActionPerformed(evt);
            }
        });

        tfSaidaExtra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSaidaExtra.setText("F8");
        tfSaidaExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSaidaExtraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfEntradaNoite, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfSaidaNoite, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfEntradaExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfSaidaExtra)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfEntradaManha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfSaidaManha, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfEntradaTarde, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfSaidaTarde)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfEntradaExtra, tfEntradaManha, tfEntradaNoite, tfEntradaTarde, tfSaidaExtra, tfSaidaManha, tfSaidaNoite, tfSaidaTarde});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEntradaManha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSaidaManha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEntradaTarde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfSaidaTarde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEntradaNoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfSaidaNoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfEntradaExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSaidaExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfEntradaExtra, tfEntradaManha, tfEntradaNoite, tfEntradaTarde, tfSaidaExtra, tfSaidaManha, tfSaidaNoite, tfSaidaTarde});

        jLabel8.setText("Entrada");

        jLabel9.setText("Saída");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9)
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSenha)
                            .addComponent(tfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(105, 105, 105))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfSaidaNoiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSaidaNoiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSaidaNoiteActionPerformed

    private void tfSaidaTardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSaidaTardeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSaidaTardeActionPerformed

    private void tfEntradaExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEntradaExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEntradaExtraActionPerformed

    private void tfSaidaExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSaidaExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSaidaExtraActionPerformed

    private void tfEntradaManhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEntradaManhaActionPerformed

    }//GEN-LAST:event_tfEntradaManhaActionPerformed

    private void tfEntradaManhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEntradaManhaKeyReleased

    }//GEN-LAST:event_tfEntradaManhaKeyReleased

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyReleased

    private void tfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSenhaActionPerformed
        tfSenha.requestFocus();
    }//GEN-LAST:event_tfSenhaActionPerformed

    private void tfSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSenhaKeyReleased
        if (!tfFuncionario.getText().isEmpty() || tfFuncionario.getText() != "") {
            atalho(evt);
        }
    }//GEN-LAST:event_tfSenhaKeyReleased

    private void tfFuncionarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFuncionarioFocusLost
        try {
            selecionaFuncionario();
            tfFuncionario.setEditable(false);
            tfSenha.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(BatePontoView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tfFuncionarioFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
//            if (verificaSenha()) {
            if (verificaCampo()) {
                salvarPonto();
            } else {
                alteraPonto();
//                }
//            } else {
                // alerta.mensagemAviso("A senha esta incorreta, por favor tente novamente!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BatePontoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatePontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatePontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatePontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatePontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatePontoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField tfEntradaExtra;
    private javax.swing.JTextField tfEntradaManha;
    private javax.swing.JTextField tfEntradaNoite;
    private javax.swing.JTextField tfEntradaTarde;
    private javax.swing.JTextField tfFuncionario;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSaidaExtra;
    private javax.swing.JTextField tfSaidaManha;
    private javax.swing.JTextField tfSaidaNoite;
    private javax.swing.JTextField tfSaidaTarde;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables

    public void atalho(KeyEvent evt) {
        Integer aux;
        hora = String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
        aux = Integer.valueOf(new SimpleDateFormat("HHmm").format(new Date(System.currentTimeMillis())));
//        System.out.println(aux);

        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            if (aux > 859) {
                alerta.mensagemAviso("Já passou do expediente matutino");
            } else {
                if (!tfEntradaManha.getText().contains(":")) {
                    tfEntradaManha.setText(hora);
                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            if (aux > 1259) {
                alerta.mensagemAviso("Já passou do expediente matutino");
            } else {
                if (!tfSaidaManha.getText().contains(":")) {
                    tfSaidaManha.setText(hora);
                }
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            if (aux > 1759) {
                alerta.mensagemAviso("Já passou do expediente da tarde");
            } else {
                if (!tfEntradaTarde.getText().contains(":")) {
                    tfEntradaTarde.setText(hora);
                }
            }

        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            if (aux > 1759) {
                alerta.mensagemAviso("Já passou do expediente da tarde");
            } else {
                if (!tfSaidaTarde.getText().contains(":")) {
                    tfSaidaTarde.setText(hora);
                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            if (aux > 2359) {
                alerta.mensagemAviso("Já passou do expediente noturno");
            } else {
                if (!tfEntradaNoite.getText().contains(":")) {
                    tfEntradaNoite.setText(hora);
                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            if (aux > 2359) {
                alerta.mensagemAviso("Já passou do expediente noturno");
            } else {
                if (!tfSaidaNoite.getText().contains(":")) {
                    tfSaidaNoite.setText(hora);
                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            if (!tfEntradaExtra.getText().contains(":")) {
                tfEntradaExtra.setText(hora);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            if (!tfSaidaExtra.getText().contains(":")) {
                tfSaidaExtra.setText(hora);
            }
        }
    }

    public void selecionaFuncionario() throws SQLException {
        UsuarioEntity u = new UsuarioEntity();
        BatePontoDAO dao = new BatePontoDAO();
        BatePontoEntity bpe = new BatePontoEntity();
        int aux = Integer.parseInt(tfFuncionario.getText());
        u.setNome_usuario(dao.selecionaFuncionario(aux));
        tfNome.setText(u.getNome_usuario());
        if (tfNome.getText().isEmpty()) {
            tfFuncionario.setEditable(false);
        }

        bpe = dao.pesquisaPonto(aux, data);

        tfEntradaManha.setText(bpe.getEntradaManha().replace("-", "F1"));
        tfSaidaManha.setText(bpe.getSaidaManha().replace("-", "F2"));
        tfEntradaTarde.setText(bpe.getEntradaTarde().replace("-", "F3"));
        tfSaidaTarde.setText(bpe.getSaidaTarde().replace("-", "F4"));
        tfEntradaNoite.setText(bpe.getEntradaNoite().replace("-", "F5"));
        tfSaidaNoite.setText(bpe.getSaidaNoite().replace("-", "F6"));
        tfEntradaExtra.setText(bpe.getEntradaExtra().replace("-", "F7"));
        tfSaidaExtra.setText(bpe.getSaidaExtra().replace("-", "F8"));

        System.out.println(bpe.getTotalHoras());

        verificaStringNullPonto(bpe);

    }

    private void salvarPonto() throws SQLException {

        BatePontoEntity bpe = new BatePontoEntity();
        BatePontoDAO dao = new BatePontoDAO();

        bpe.setEntradaManha(tfEntradaManha.getText().replace("F1", "-"));
        bpe.setSaidaManha(tfSaidaManha.getText().replace("F2", "-"));
        bpe.setEntradaTarde(tfEntradaTarde.getText().replace("F3", "-"));
        bpe.setSaidaTarde(tfSaidaTarde.getText().replace("F4", "-"));
        bpe.setEntradaNoite(tfEntradaNoite.getText().replace("F5", "-"));
        bpe.setSaidaNoite(tfSaidaNoite.getText().replace("F6", "-"));
        bpe.setEntradaExtra(tfEntradaExtra.getText().replace("F7", "-"));
        bpe.setSaidaExtra(tfSaidaExtra.getText().replace("F8", "-"));

        bpe.setTotalManha("");
        bpe.setTotalTarde("");
        bpe.setTotalNoite("");
        bpe.setTotalExtra("");
        bpe.setTotalHoras(0.00);

        bpe.setData(data);
        bpe.setIdFunc(Integer.parseInt(tfFuncionario.getText()));

        dao.salvarPonto(bpe);
        alerta.mensagemConfirmacao("Ponto Salvo com sucesso");

    }

    public boolean verificaCampo() throws SQLException {
        BatePontoDAO dao = new BatePontoDAO();
        int idAux = Integer.valueOf(tfFuncionario.getText());

        boolean aux = dao.verificaPontoExistente(idAux, data);
        return aux;
    }

    public void alteraPonto() throws SQLException {

        BatePontoEntity bpe = new BatePontoEntity();
        BatePontoDAO dao = new BatePontoDAO();

        bpe.setEntradaManha(tfEntradaManha.getText().replace("F1", "-"));
        bpe.setSaidaManha(tfSaidaManha.getText().replace("F2", "-"));
        bpe.setEntradaTarde(tfEntradaTarde.getText().replace("F3", "-"));
        bpe.setSaidaTarde(tfSaidaTarde.getText().replace("F4", "-"));
        bpe.setEntradaNoite(tfEntradaNoite.getText().replace("F5", "-"));
        bpe.setSaidaNoite(tfSaidaNoite.getText().replace("F6", "-"));
        bpe.setEntradaExtra(tfEntradaExtra.getText().replace("F7", "-"));
        bpe.setSaidaExtra(tfSaidaExtra.getText().replace("F8", "-"));

        bpe.setTotalManha(calcHora(tfEntradaManha, tfSaidaManha, "F1", "F2").replace("-", ""));
        bpe.setTotalTarde(calcHora(tfEntradaTarde, tfSaidaTarde, "F3", "F4").replace("-", ""));
        bpe.setTotalNoite(calcHora(tfEntradaNoite, tfSaidaNoite, "F5", "F6").replace("-", ""));
        bpe.setTotalExtra(calcHora(tfEntradaExtra, tfSaidaExtra, "F7", "F8").replace("-", ""));

//        System.out.println("TotalManha " + bpe.getTotalManha());
//        System.out.println("TotalTarde " + bpe.getTotalTarde());
//        System.out.println("TotalNoite " + bpe.getTotalNoite());
//        System.out.println("TotalExtra " + bpe.getTotalExtra());
        bpe.setTotalHoras(0.0);
        Double auxF = 0.00;

        // formato.format(auxF);
        if (bpe.getTotalManha() != null && !bpe.getTotalManha().equals("")) {
            bpe.setTotalHoras(Double.parseDouble(bpe.getTotalManha().replace(":", ".")));
            auxF += bpe.getTotalHoras();
//            auxF += somaMin(auxF, Double.parseDouble(bpe.getTotalManha().replace(":", ".")));
            System.out.println("auxManha " + auxF);
        }
        if (bpe.getTotalTarde() != null && !bpe.getTotalTarde().equals("")) {
            //   bpe.setTotalHoras(Double.parseDouble(bpe.getTotalTarde().replace(":", ".")));
//            auxF += somaMin(auxF, Double.parseDouble(bpe.getTotalTarde().replace(":", ".")));
            // auxF += bpe.getTotalHoras();
            auxF = somaMin(auxF, Double.parseDouble(bpe.getTotalTarde().replace(":", ".")));
            System.out.println("auxTarde " + auxF);
        }
        if (bpe.getTotalNoite() != null && !bpe.getTotalNoite().equals("")) {
//            bpe.setTotalHoras(Double.parseDouble(bpe.getTotalNoite().replace(":", ".")));
            //   auxF += bpe.getTotalHoras();
            auxF = somaMin(auxF, Double.parseDouble(bpe.getTotalNoite().replace(":", ".")));

            System.out.println("auxNoite " + auxF);
        }
        if (bpe.getTotalExtra() != null && !bpe.getTotalExtra().equals("")) {
//            bpe.setTotalHoras(Double.parseDouble(bpe.getTotalExtra().replace(":", ".")));
//            auxF += bpe.getTotalHoras();
            auxF = somaMin(auxF, Double.parseDouble(bpe.getTotalExtra().replace(":", ".")));

            System.out.println("auxExtra " + auxF);
        }
        if (auxF != null && !Objects.equals(auxF, "")) {
            BigDecimal bd = new BigDecimal(auxF).setScale(2, RoundingMode.HALF_EVEN);
            auxF = bd.doubleValue();
            bpe.setTotalHoras(auxF);
            System.out.println("TotalHoras: " + bpe.getTotalHoras());
        }

        bpe.setIdFunc(Integer.valueOf(tfFuncionario.getText()));
        dao.alteraPonto(bpe, data);
        alerta.mensagemConfirmacao("Ponto Salvo com sucesso");

    }

    public double somaMin(Double valor1, Double valor2) {
        String min1 = valor1.toString();
        String min2 = valor2.toString();
        Integer aux1;
        Integer aux2;
        Integer aux3;
        Integer aux4;

        if (min1.length() == 4) {
            aux1 = Integer.parseInt(min1.substring(0, 2).replace(".", ""));
            aux2 = Integer.parseInt(min1.substring(2, 4).replace(".", ""));
        } else {
            aux1 = Integer.parseInt(min1.substring(0, 2).replace(".", ""));
            aux2 = Integer.parseInt(min1.substring(2, 3).replace(".", ""));
        }

        if (min2.length() == 4) {
            aux3 = Integer.parseInt(min2.substring(0, 2).replace(".", ""));
            aux4 = Integer.parseInt(min2.substring(2, 4).replace(".", ""));
        } else {
            aux3 = Integer.parseInt(min2.substring(0, 2).replace(".", ""));
            aux4 = Integer.parseInt(min2.substring(2, 3).replace(".", ""));
        }

        Integer somaHora = aux1 + aux3;
        Integer somaMin = aux2 + aux4;

        while (somaMin > 60) {
            somaMin = somaMin - 60;
            somaHora++;
        }
        String concat1 = somaHora.toString();
        String concat2 = "";
        if (somaMin < 10) {
            concat2 = concat1.concat(".0" + somaMin.toString());
        } else {
            concat2 = concat1.concat("." + somaMin.toString());
        }
        double result = Double.parseDouble(concat2);
//        System.out.println("result " + result);
        return result;
    }

    public String calcHora(JTextField tf1, JTextField tf2, String f1, String f2) {
        Integer horaA;
        Integer minA;
        String totalString = "";
        if (!tf1.getText().equals(f1) && !tf2.getText().equals(f2)) {
            Integer aux1;
            Integer aux2;
            Integer aux3;
            Integer aux4;
            System.out.println(tf1.getText().length());
            if (tf1.getText().length() == 5) {
                aux1 = Integer.parseInt(tf1.getText().substring(0, 2).replace(":", ""));
                aux2 = Integer.parseInt(tf1.getText().substring(3, 5).replace(":", ""));
                System.out.println("aux 2: " + aux2);
            } else {
                aux1 = Integer.parseInt(tf1.getText().substring(0, 2).replace(":", ""));
                aux2 = Integer.parseInt(tf1.getText().substring(3, 4).replace(":", ""));
            }
//            System.out.println(tf2.getText().length());
            if (tf2.getText().length() == 5) {
                aux3 = Integer.parseInt(tf2.getText().substring(0, 2).replace(":", ""));
                aux4 = Integer.parseInt(tf2.getText().substring(3, 5).replace(":", ""));
                // System.out.println("aux 4: " + aux4);
            } else {
                aux3 = Integer.parseInt(tf2.getText().substring(0, 2).replace(":", ""));
                aux4 = Integer.parseInt(tf2.getText().substring(3, 4).replace(":", ""));
            }

            double ah1 = aux1;
            double ah2 = aux3;

            double am1 = aux2;
            double am2 = aux4;

            double hm1 = ah1 * 60;
            hm1 = (hm1 + am1) * 60;// virando segundos

            double hm2 = ah2 * 60;
            hm2 = (hm2 + am2) * 60;

            Double total = hm2 - hm1;
            total = total / 120;
            total = total / 60;
            System.out.println("total:" + total);

            if (aux3 > aux1) {
                horaA = aux3 - aux1;
            } else {
                horaA = aux1 - aux3;
            }
            System.out.println("horaAA " + horaA);

            minA = aux2 - aux4;
            System.out.println("minAA " + minA);

//            if (minA < 0 && horaA > 0) {
//                minA += 60;
//                horaA -= 1;
//            }
            if (horaA == 0 && minA < 0) {
                minA *= (-1);
            }

            System.out.println("minA AH: " + horaA + ":" + minA);
            String auxS1 = "";
            String auxS2 = "";

            if (horaA > 0) {
//                minA = aux4 - aux3;
//                if (minA < 0) {
//                    horaA += (-1);
//                    minA *= (-1);
////                    Math.abs(minA);
////                    minA = 60 - minA;
//                    if (aux1 > aux3 && aux2 > aux4) {
//                        minA = 60 - minA;
//                    }
//
//                }
//                System.out.println("horaA A2:" + horaA);
//                System.out.println("minA A2:" + minA);
                if (horaA < 10) {
                    if (horaA < 0) {
                        horaA = horaA * (-1);
                    }
                    if (horaA > 0) {
                        auxS2 = "0" + horaA.toString();
                    }
//                    if (horaA == 0) {
//                        auxS2 = "00";
//                    }
                } else {
                    auxS2 = horaA.toString();
                }

            }
            if (horaA == 0) {
                auxS2 = "00";
            }
            System.out.println("minAA: " + minA);
//            if (minA < 0) {
//                minA = Math.abs(minA);
//            }
            if (minA < 10) {
                if (minA < 0) {
                    minA *= (-1);
//                    System.out.println("minAC1");
                }

                if (minA > 0) {
                    auxS1 = "0" + minA.toString();
//                    System.out.println("minAC2");
                }
                if (minA == 0) {
                    auxS1 = "00";
//                    System.out.println("minAC3");
                }
            } else {
                //    System.out.println("minult1: " + minA);
                auxS1 = minA.toString();
                System.out.println("minult1: " + minA);
            }
            if (auxS1.substring(0, 1).equals(0) && auxS1.length() > 2) {
                auxS1 = auxS1.replace(" ", "-").substring(1, auxS1.length() - 2);
            }
            System.out.println("auxS2 " + auxS2 + "  auxs1 " + auxS1);
            System.out.println("minult2: " + minA);
            totalString = auxS2 + ":" + auxS1;
            System.out.println("total String:" + totalString);
            return totalString;

        }
        return totalString;
    }

    public void verificaStringNullPonto(BatePontoEntity bpe) {
        if (bpe.getEntradaManha() == null) {
            tfEntradaManha.setText("F1");
        }
        if (bpe.getSaidaManha() == null) {
            tfSaidaManha.setText("F2");
        }
        if (bpe.getEntradaTarde() == null) {
            tfEntradaTarde.setText("F3");
        }
        if (bpe.getSaidaTarde() == null) {
            tfSaidaTarde.setText("F4");
        }
        if (bpe.getEntradaNoite() == null) {
            tfEntradaNoite.setText("F5");
        }
        if (bpe.getSaidaNoite() == null) {
            tfSaidaNoite.setText("F6");
        }
        if (bpe.getEntradaExtra() == null) {
            tfEntradaExtra.setText("F7");
        }
        if (bpe.getSaidaExtra() == null) {
            tfSaidaExtra.setText("F8");
        }
    }

    public void desabilitaCampos() {

        tfNome.setEditable(false);
        tfEntradaExtra.setEditable(false);
        tfEntradaManha.setEditable(false);
        tfEntradaNoite.setEditable(false);
        tfEntradaTarde.setEditable(false);

        tfSaidaExtra.setEditable(false);
        tfSaidaManha.setEditable(false);
        tfSaidaNoite.setEditable(false);
        tfSaidaTarde.setEditable(false);
    }

    public void limparCampos() {
        tfFuncionario.setEditable(true);
        tfFuncionario.setText("");
        tfNome.setText("");
        tfSenha.setText("");

        tfEntradaExtra.setText("F7");
        tfEntradaManha.setText("F1");
        tfEntradaNoite.setText("F5");
        tfEntradaTarde.setText("F3");

        tfSaidaExtra.setText("F8");
        tfSaidaManha.setText("F2");
        tfSaidaNoite.setText("F6");
        tfSaidaTarde.setText("F4");
    }

    public boolean verificaSenha() throws SQLException {

        BatePontoDAO dao = new BatePontoDAO();

        boolean resp = dao.verificaSenha(tfSenha.getText(), Integer.valueOf(tfFuncionario.getText()));

        return resp;
    }

//    public String calcHora(JTextField tf1, JTextField tf2, String f1, String f2) {
//        String totalString = "";
//        if (!tf1.getText().equals(f1) && !tf2.getText().equals(f2)) {
//
//            Integer aux1 = Integer.parseInt(tf1.getText().replace(":", ""));
//            Integer aux2 = Integer.parseInt(tf2.getText().replace(":", ""));
//
//            Integer auxT = aux1 - aux2;
////            if (auxT < 0) {
//////                auxT = auxT * (-1);
////              auxT =+ Math.abs(auxT);
////                 System.out.println("auxT:PouN " + auxT);
////            }
//
//            String shoraA = "";
//            String sminA = "";
//            if (auxT != null && !auxT.equals("") && auxT >= 1000) {
//                shoraA = auxT.toString().substring(0, 1);
//                System.out.println("C1AuxT1: " + shoraA);
//                sminA = auxT.toString().substring(2, 3);
//                System.out.println("C1AuxT2: " + sminA);
//            } else if (auxT != null && !auxT.equals("") && auxT >= 100) {
//                shoraA = auxT.toString().substring(0, 0);
//                System.out.println("C2AuxT1: " + shoraA);
//                sminA = auxT.toString().substring(0, 2);
//                System.out.println("C2AuxT2: " + sminA);
//            } else {
//                sminA = auxT.toString().substring(0, 2);
//                System.out.println("C3AuxT2: " + sminA);
//            }
//
//            Integer ihora = 0;
//            Integer imin = Integer.parseInt(sminA);
//            String aux = "";
////            if (ihora == 0 || ihora == null) {
////                aux = "00";
////            }
//            System.out.println("iHora: " + ihora);
//            System.out.println("iMin: " + imin);
//            System.out.println("auxT valor atual: " + auxT);
//
//            auxT = Math.abs(auxT);
//            if (auxT < 100) {
//                if (auxT >= 60) {
//                    imin += -60;
//                    ihora += +1;
//                }
//                if (ihora >= 0 && ihora < 10) {
//                    aux = "0";
//                }
//                System.out.println("Menor que 100 aux " + aux + " ihora: " + ihora + " imin= " + imin);
//                totalString = aux + ihora.toString() + ":" + imin.toString();
//                if (auxT < 10) {
//                    totalString = aux + ihora.toString() + ":0" + imin.toString();
//                }
//                return totalString;
//            } else {
//                if (auxT == 100 || imin >= 60) {
//                    ihora++;
//                    if (imin >= 60) {
//                        imin += -60;
//                    }
//                }
//
////                if (auxT >= 60) {
////                    if (imin > 60) {
////                        imin += -60;
////                        ihora++;
////                    }
////                    if (imin == 0) {
////                        imin = auxT -60;
////                        ihora += +1;
////                    }
//            }
//            if (imin < 10) {
//                totalString = aux + ihora.toString() + ":0" + imin.toString();
//                if (imin == 0) {
//                    totalString = aux + ihora.toString() + ":00" + imin.toString();
//                }
//            }
//            totalString = aux + ihora.toString() + ":" + imin.toString();
//            System.out.println("totalString 0" + totalString);
//        }
////            if (auxT < 1000) {
////
////                if (imin > 60) {
////                    imin += -60;
////                    ihora += +1;
////                }
////                if (ihora > 0 && ihora < 10) {
////                    aux = "0";
////                }
////                totalString = aux + ihora.toString() + ":" + imin.toString();
////
////                return totalString;
////            }
////             System.out.println("hora" + totalString);
//
//        return totalString;
//    }
//
}

//Integer horaA;
//        Integer minA;
//        if (!bpe.getEntradaTarde().equals("F3") && !bpe.getSaidaTarde().equals("F4")) {
//            Integer aux1 = Integer.parseInt(tfEntradaTarde.getText().substring(0, 2).replace(":", ""));
//            Integer aux2 = Integer.parseInt(bpe.getEntradaTarde().substring(3, 5).replace(":", ""));
//
//            Integer aux3 = Integer.parseInt(bpe.getSaidaTarde().substring(0, 2).replace(":", ""));
//            Integer aux4 = Integer.parseInt(bpe.getSaidaTarde().substring(3, 5).replace(":", ""));
//
//            horaA = aux1 - aux3;
//            minA = aux2 - aux4;
//
//            if (minA < 10) {
//                if (minA < 0) {
//                    minA = minA * (-1);
//                }
//                String concatMin = "0" + minA.toString();
//                minA = Integer.parseInt(concatMin);
//            }
//            String totalTarde;
//            if (minA.toString().length() < 4) {
//                totalTarde = String.valueOf(horaA.toString().concat(".0" + minA.toString()));
//            } else {
//                totalTarde = String.valueOf(horaA.toString().concat("." + minA.toString()));
//            }
//
//            bpe.setTotalTarde(totalTarde);
//            System.out.println("Total tarde " + totalTarde);
//        }
