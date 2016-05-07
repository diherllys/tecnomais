package com.br.tecnomais.vconfiguracao2;

import com.br.tecnomais.dao.OperacaoDAO;
import com.br.tecnomais.entity.AgendaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.OperacaoEntity;
import com.br.tecnomais.vescritorio.AgendaView;
import java.awt.event.KeyEvent;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PesquisaOperacaoView extends javax.swing.JFrame {

    private final OperacaoDAO operacaoDAO = new OperacaoDAO();
    private OperacaoEntity opera;

    public PesquisaOperacaoView() {
        initComponents();
        ajustarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bEditar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbOperacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(200, 210, 210));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        bEditar.setText("Editar");
        bEditar.setEnabled(false);
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        tfPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPesquisaFocusGained(evt);
            }
        });
        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
            }
        });
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyReleased(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Novo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar Operação de Entrada");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        tbOperacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Nome", "Natureza da Operação", "Caracteristica de Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbOperacao.getTableHeader().setReorderingAllowed(false);
        tbOperacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOperacaoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbOperacaoMousePressed(evt);
            }
        });
        tbOperacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbOperacaoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbOperacao);
        if (tbOperacao.getColumnModel().getColumnCount() > 0) {
            tbOperacao.getColumnModel().getColumn(0).setResizable(false);
            tbOperacao.getColumnModel().getColumn(1).setResizable(false);
            tbOperacao.getColumnModel().getColumn(1).setPreferredWidth(15);
            tbOperacao.getColumnModel().getColumn(2).setResizable(false);
            tbOperacao.getColumnModel().getColumn(3).setResizable(false);
            tbOperacao.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEditar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(0, 296, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bEditar, jButton2});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(bEditar))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, tfPesquisa});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preencherTabela();
        bEditar.setEnabled(false);
        tbOperacao.clearSelection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        preencherTabela();
    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        atalhos(evt);
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        opera = new OperacaoEntity();
        new OperacaoView(opera, false).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        new OperacaoView(opera, true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bEditarActionPerformed

    private void tbOperacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOperacaoMousePressed
        int linha = tbOperacao.getSelectedRow();
        int codigo = Integer.parseInt(tbOperacao.getValueAt(linha, 0).toString());
        try {
            for (OperacaoEntity o : operacaoDAO.selecionaOperacao(codigo)) {
                opera = o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaOperacaoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        bEditar.setEnabled(true);
    }//GEN-LAST:event_tbOperacaoMousePressed

    private void tbOperacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOperacaoMouseClicked
    }//GEN-LAST:event_tbOperacaoMouseClicked

    private void tbOperacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbOperacaoKeyPressed
        int linha = tbOperacao.getSelectedRow();
        int id = Integer.parseInt(tbOperacao.getValueAt(linha, 0).toString());
        OperacaoEntity ce = new OperacaoEntity();
        opera = new OperacaoEntity();
        ce.setId(id);
        bEditar.setEnabled(true);
        try {
            for (OperacaoEntity c : operacaoDAO.selecionaOperacao(ce.getId())) {
                opera = c;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new OperacaoView(opera, true).setVisible(true);
            this.dispose();
        } else {
            System.out.println("nada");
        }
    }//GEN-LAST:event_tbOperacaoKeyPressed

    private void tfPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFocusGained
        bEditar.setEnabled(false);
        tbOperacao.clearSelection();
    }//GEN-LAST:event_tfPesquisaFocusGained

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
            java.util.logging.Logger.getLogger(PesquisaOperacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaOperacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaOperacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaOperacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PesquisaOperacaoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbOperacao;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables

    private void ajustarTabela() {
        tbOperacao.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbOperacao.getColumnModel().getColumn(0).setMinWidth(0);
        tbOperacao.getColumnModel().getColumn(0).setMaxWidth(0);

//        jtOperacao.getColumnModel().getColumn(1).setPreferredWidth(50);
//        jtOperacao.getColumnModel().getColumn(1).setPreferredWidth(1);
        tbOperacao.getColumnModel().getColumn(1).setPreferredWidth(1);
        tbOperacao.getColumnModel().getColumn(2).setPreferredWidth(120);
        tbOperacao.getColumnModel().getColumn(3).setPreferredWidth(170);
        tbOperacao.getColumnModel().getColumn(4).setPreferredWidth(170);
    }

    private void preencherTabela() {
        try {
            DefaultTableModel tabela = (DefaultTableModel) tbOperacao.getModel();
            tabela.setNumRows(0);
            String nomeOperacao = tfPesquisa.getText() + "%";
            for (OperacaoEntity c : operacaoDAO.listar(nomeOperacao)) {
                tabela.addRow(new Object[]{c.getId(), c.getCodigo(), c.getNome(), c.getNatureza(), c.getCaracteristicaDeOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == 40) {

            if (tbOperacao.getRowCount() > 0) {
                tbOperacao.requestFocus();
                tbOperacao.addRowSelectionInterval(0, 0);
                int linha = tbOperacao.getSelectedRow();
                int codigo = Integer.parseInt(tbOperacao.getValueAt(linha, 0).toString());
                try {
                    for (OperacaoEntity o : operacaoDAO.selecionaOperacao(codigo)) {
                        opera = o;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PesquisaOperacaoView.class.getName()).log(Level.SEVERE, null, ex);
                }
                bEditar.setEnabled(true);
            }
        }
    }
}
