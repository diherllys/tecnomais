package com.br.tecnomais.vcadastros;

import com.br.tecnomais.dao.FilialDAO;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.FilialEntity;
import com.br.tecnomais.entity.ProdutoEntity;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PesquisaFilialView extends javax.swing.JFrame {

    private final FilialDAO filialDAO = new FilialDAO();
    private FilialEntity filialEntity;

    public PesquisaFilialView() {
        initComponents();
        ajustarTabela();
        jPanel1.setLocale(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bEditar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFilial = new javax.swing.JTable();
        bPesquisa = new javax.swing.JButton();
        bNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        tbFilial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Razão Social", "CNPJ", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFilial.setGridColor(new java.awt.Color(102, 102, 102));
        tbFilial.setShowHorizontalLines(false);
        tbFilial.setShowVerticalLines(false);
        tbFilial.getTableHeader().setReorderingAllowed(false);
        tbFilial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbFilialMousePressed(evt);
            }
        });
        tbFilial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbFilialKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbFilial);
        if (tbFilial.getColumnModel().getColumnCount() > 0) {
            tbFilial.getColumnModel().getColumn(0).setResizable(false);
            tbFilial.getColumnModel().getColumn(1).setResizable(false);
            tbFilial.getColumnModel().getColumn(2).setResizable(false);
            tbFilial.getColumnModel().getColumn(3).setResizable(false);
            tbFilial.getColumnModel().getColumn(4).setResizable(false);
        }

        bPesquisa.setText("Pesquisar");
        bPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisaActionPerformed(evt);
            }
        });

        bNovo.setText("Novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar Filial");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bEditar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bPesquisa)))
                        .addGap(0, 324, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bEditar, bNovo});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovo)
                    .addComponent(bEditar))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bPesquisa, tfPesquisa});

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

    private void bPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisaActionPerformed
        bEditar.setEnabled(false);
        tbFilial.clearSelection();
        preencherTabela();
    }//GEN-LAST:event_bPesquisaActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        preencherTabela();
    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        atalhos(evt);
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        filialEntity = new FilialEntity();
        new FilialView(filialEntity, false).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bNovoActionPerformed

    private void tbFilialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFilialMousePressed
        int linha = tbFilial.getSelectedRow();
        int id = Integer.parseInt(tbFilial.getValueAt(linha, 0).toString());
        FilialEntity fe = new FilialEntity();
        filialEntity = new FilialEntity();
        fe.setId(id);
        bEditar.setEnabled(true);
        for (FilialEntity c : filialDAO.selecionaFilial(fe)) {
            filialEntity = c;
        }
    }//GEN-LAST:event_tbFilialMousePressed
    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        new FilialView(filialEntity, true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bEditarActionPerformed

    private void tfPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFocusGained
        bEditar.setEnabled(false);
        tbFilial.clearSelection();
    }//GEN-LAST:event_tfPesquisaFocusGained

    private void tbFilialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbFilialKeyPressed
        int linha = tbFilial.getSelectedRow();
        int id = Integer.parseInt(tbFilial.getValueAt(linha, 0).toString());
        FilialEntity ce = new FilialEntity();
        filialEntity = new FilialEntity();
        ce.setId(id);
        bEditar.setEnabled(true);
        for (FilialEntity c : filialDAO.selecionaFilial(ce)) {
            filialEntity = c;
        }

        System.out.print(filialEntity.getNome());
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new FilialView(filialEntity, true).setVisible(true);
            this.dispose();
        } else {
            System.out.println("nada");
        }
    }//GEN-LAST:event_tbFilialKeyPressed

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
            java.util.logging.Logger.getLogger(PesquisaFilialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaFilialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaFilialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaFilialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new PesquisaFilialView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFilial;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables

    private void ajustarTabela() {
        tbFilial.getColumnModel().getColumn(0).setPreferredWidth(20);

        tbFilial.getColumnModel().getColumn(1).setPreferredWidth(240);
        tbFilial.getColumnModel().getColumn(2).setPreferredWidth(160);
    }

    private void preencherTabela() {
        try {
            DefaultTableModel tabela = (DefaultTableModel) tbFilial.getModel();
            tabela.setNumRows(0);
            String nomeFilial = tfPesquisa.getText() + "%";
            for (FilialEntity c : filialDAO.listar(nomeFilial)) {
                tabela.addRow(new Object[]{c.getId(), c.getNome(), c.getRazaoSocial(), c.getCnpj(), c.getTelefone()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == 40) {
            tbFilial.requestFocus();
            tbFilial.addRowSelectionInterval(0, 0);

            int linha = tbFilial.getSelectedRow();
            int id = Integer.parseInt(tbFilial.getValueAt(linha, 0).toString());
            FilialEntity e = new FilialEntity();
            filialEntity = new FilialEntity();
            e.setId(id);
            bEditar.setEnabled(true);
            for (FilialEntity c : filialDAO.selecionaFilial(e)) {
                filialEntity = c;
            }

            if (tbFilial.getRowCount() > 0) {
                linha = tbFilial.getSelectedRow();
                bEditar.setEnabled(true);
            }
        }
    }

}
