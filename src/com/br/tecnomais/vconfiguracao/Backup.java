/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vconfiguracao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.BackupDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Diherllys
 */
public class Backup extends javax.swing.JFrame {

    NovaData dataAtual = new NovaData();
    String data = dataAtual.dataAtual();
    Integer hora = Integer.valueOf(new SimpleDateFormat("HHmm").format(new Date(System.currentTimeMillis())));
    BackupDAO dao = new BackupDAO();
    Alertas alerta = new Alertas();

    /**
     * Creates new form Backup
     */
    public Backup() {
        initComponents();
        selecionarOpcoesDeBackup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbFazerBackupnaEntrada = new javax.swing.JRadioButton();
        rbFazerBackupnaSaída = new javax.swing.JRadioButton();
        rbFazerBackupnaEntradaenaSaida = new javax.swing.JRadioButton();
        rbNãofazerBackup = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/database saida 32x32.png"))); // NOI18N
        jButton1.setText("<html> Fazer <p> Backup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento do Banco de Dados");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(200, 210, 210));

        rbFazerBackupnaEntrada.setBackground(new java.awt.Color(200, 210, 210));
        buttonGroup1.add(rbFazerBackupnaEntrada);
        rbFazerBackupnaEntrada.setText("Fazer Backup na Entrada");
        rbFazerBackupnaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFazerBackupnaEntradaActionPerformed(evt);
            }
        });

        rbFazerBackupnaSaída.setBackground(new java.awt.Color(200, 210, 210));
        buttonGroup1.add(rbFazerBackupnaSaída);
        rbFazerBackupnaSaída.setText("Fazer Backup na Saída");
        rbFazerBackupnaSaída.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFazerBackupnaSaídaActionPerformed(evt);
            }
        });

        rbFazerBackupnaEntradaenaSaida.setBackground(new java.awt.Color(200, 210, 210));
        buttonGroup1.add(rbFazerBackupnaEntradaenaSaida);
        rbFazerBackupnaEntradaenaSaida.setText("Fazer Backup na Entrada e na Saída");
        rbFazerBackupnaEntradaenaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFazerBackupnaEntradaenaSaidaActionPerformed(evt);
            }
        });

        rbNãofazerBackup.setBackground(new java.awt.Color(200, 210, 210));
        buttonGroup1.add(rbNãofazerBackup);
        rbNãofazerBackup.setText("Não fazer Backup Automático");
        rbNãofazerBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNãofazerBackupActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Formas de Backup Automático");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbFazerBackupnaEntrada)
                    .addComponent(rbFazerBackupnaSaída)
                    .addComponent(rbFazerBackupnaEntradaenaSaida)
                    .addComponent(rbNãofazerBackup)
                    .addComponent(jLabel5))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbNãofazerBackup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFazerBackupnaEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFazerBackupnaSaída)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFazerBackupnaEntradaenaSaida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/database entrada 32x32.png"))); // NOI18N
        jButton2.setText("<html> Restaurar <p> Backup");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Olá usuário, para utilizar a função");

        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("de backup você  deve selecionar");

        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("uma das opções ao lado.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dao.fazBackup("tecnomais" + data.replace("/", "-") + "-" + hora + ".bak");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        dao.restauraBackup();
        // Propriedas do joptionPane
//         UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 35)));
//        UIManager.put("OptionPane.messageForeground", Color.blue);
//        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 35)));
//        UIManager.put("OptionPane.background", Color.RED);
//        UIManager.put("Panel.background", Color.yellow);

        UIManager.put("OptionPane.messageForeground", Color.blue);
        alerta.mensagemAviso("Para restaurar o banco de dados use comando SQL a seguir: \nRESTORE DATABASE tecnomais FROM DISK = 'caminhoDoArquivo\\nomeEextensãoDoAquivo' WITH RECOVERY");
//        
//        try {
//            File file = new File("Backup");
//            file.mkdir();
//            String nomeBkp = "clinicas.sql";
////            String dump="cmd.exe /c mysqldump -u root --password=senha -x -e -B -i -K --add-drop-database "
////                    + "--add-drop-table -d --default-character-set=latin1 clinicas.sql > Backup/"+nomeBkp;
//            String dump = "cmd.exe /c mysqldump --user=root --password=senha clinicas -x -e -B -i -K > Backup/" + nomeBkp;
//            Runtime bkp = Runtime.getRuntime();
//            bkp.exec(dump);
////            JOptionPane.showMessageDialog(rootPane, "Backup realizado com sucesso!");
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "erro" + ex.getMessage());
//        }


    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void rbFazerBackupnaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFazerBackupnaEntradaActionPerformed
        String aux = rbFazerBackupnaEntrada.getText();
        try {
            if (!dao.verExistDaOpcaoDeBackup()) {
                dao.salvaOpcaoDeBackup(aux);
                alerta.mensagemConfirmacao("Nova opção de backup salva com sucesso!!!");
            } else {
                dao.update(aux);
                alerta.mensagemConfirmacao("Opção de backup atual foi alterada com sucesso!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rbFazerBackupnaEntradaActionPerformed

    private void rbFazerBackupnaSaídaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFazerBackupnaSaídaActionPerformed
        String aux = rbFazerBackupnaSaída.getText();
        try {
            if (!dao.verExistDaOpcaoDeBackup()) {
                dao.salvaOpcaoDeBackup(aux);
                alerta.mensagemConfirmacao("Nova opção de backup salva com sucesso!!!");
            } else {
                dao.update(aux);
                alerta.mensagemConfirmacao("Opção de backup atual foi alterada com sucesso!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rbFazerBackupnaSaídaActionPerformed

    private void rbFazerBackupnaEntradaenaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFazerBackupnaEntradaenaSaidaActionPerformed
        String aux = rbFazerBackupnaEntradaenaSaida.getText();
        try {
            if (!dao.verExistDaOpcaoDeBackup()) {
                dao.salvaOpcaoDeBackup(aux);
                alerta.mensagemConfirmacao("Nova opção de backup salva com sucesso!!!");
            } else {
                dao.update(aux);
                alerta.mensagemConfirmacao("Opção de backup atual foi alterada com sucesso!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rbFazerBackupnaEntradaenaSaidaActionPerformed

    private void rbNãofazerBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNãofazerBackupActionPerformed
        String aux = rbNãofazerBackup.getText();
        try {
            if (!dao.verExistDaOpcaoDeBackup()) {
                dao.salvaOpcaoDeBackup(aux);
                alerta.mensagemConfirmacao("Nova opção de backup salva com sucesso!!!");
            } else {
                dao.update(aux);
                alerta.mensagemConfirmacao("Opção de backup atual foi alterada com sucesso!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rbNãofazerBackupActionPerformed

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
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Backup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbFazerBackupnaEntrada;
    private javax.swing.JRadioButton rbFazerBackupnaEntradaenaSaida;
    private javax.swing.JRadioButton rbFazerBackupnaSaída;
    private javax.swing.JRadioButton rbNãofazerBackup;
    // End of variables declaration//GEN-END:variables

    private void selecionarOpcoesDeBackup() {
        try {
            if (dao.opcaoDeBackupAtual().equals("Não fazer Backup Automático")) {
                rbNãofazerBackup.setSelected(true);
            }
            if (dao.opcaoDeBackupAtual().equals("Fazer Backup na Entrada")) {
                rbFazerBackupnaEntrada.setSelected(true);
            }
            if (dao.opcaoDeBackupAtual().equals("Fazer Backup na Saída")) {
                rbFazerBackupnaSaída.setSelected(true);
            }
            if (dao.opcaoDeBackupAtual().equals("Fazer Backup na Entrada e na Saída")) {
                rbFazerBackupnaEntradaenaSaida.setSelected(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
