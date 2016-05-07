package com.br.tecnomais.vescritorio;

import com.br.tecnomais.dao.AgendaDAO;
import com.br.tecnomais.entity.AgendaEntity;
import com.br.tecnomais.entity.ProdutoEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import com.br.tecnomais.vcadastros.UsuarioView;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PesquisaAgendaView extends javax.swing.JFrame {

    private final AgendaDAO agendaDAO = new AgendaDAO();
    private AgendaEntity agend;

    public PesquisaAgendaView() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAgenda = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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

        tbAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Cidade", "Endereço", "Area/Celular", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAgenda.setGridColor(new java.awt.Color(102, 102, 102));
        tbAgenda.setShowHorizontalLines(false);
        tbAgenda.setShowVerticalLines(false);
        tbAgenda.getTableHeader().setReorderingAllowed(false);
        tbAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbAgendaMousePressed(evt);
            }
        });
        tbAgenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbAgendaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbAgenda);
        if (tbAgenda.getColumnModel().getColumnCount() > 0) {
            tbAgenda.getColumnModel().getColumn(0).setResizable(false);
            tbAgenda.getColumnModel().getColumn(1).setResizable(false);
            tbAgenda.getColumnModel().getColumn(2).setResizable(false);
            tbAgenda.getColumnModel().getColumn(3).setResizable(false);
            tbAgenda.getColumnModel().getColumn(4).setResizable(false);
            tbAgenda.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Novo");
        jButton2.setToolTipText("<html> <img src=\"addcccc.png\"/>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Busca de Contatos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bEditar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 307, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bEditar, jButton2});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        setSize(new java.awt.Dimension(824, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preencherTabela();
        bEditar.setEnabled(false);
        tbAgenda.clearSelection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        preencherTabela();
    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        atalhos(evt);
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        agend = new AgendaEntity();
        new AgendaView(agend).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbAgendaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAgendaMousePressed
        int linha = tbAgenda.getSelectedRow();
        int id = Integer.parseInt(tbAgenda.getValueAt(linha, 0).toString());
        AgendaEntity agenda = new AgendaEntity();
        agend = new AgendaEntity();
        agenda.setId(id);
        bEditar.setEnabled(true);
        for (AgendaEntity a : agendaDAO.selecionaAgenda(agenda)) {
            agend = a;
        }
        System.out.print(agend.getNome());

    }//GEN-LAST:event_tbAgendaMousePressed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        new AgendaView(agend).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bEditarActionPerformed

    private void tbAgendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAgendaKeyPressed
        int linha = tbAgenda.getSelectedRow();
        int id = Integer.parseInt(tbAgenda.getValueAt(linha, 0).toString());
        AgendaEntity ce = new AgendaEntity();
        agend = new AgendaEntity();
        ce.setId(id);
        bEditar.setEnabled(true);
        for (AgendaEntity c : agendaDAO.selecionaAgenda(ce)) {
            agend = c;
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new AgendaView(agend).setVisible(true);
            this.dispose();
        } else {
            System.out.println("nada");
        }
    }//GEN-LAST:event_tbAgendaKeyPressed

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
            java.util.logging.Logger.getLogger(PesquisaAgendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaAgendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaAgendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaAgendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaAgendaView().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAgenda;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables

    private void ajustarTabela() {
        tbAgenda.getColumnModel().getColumn(0).setMinWidth(0);
        tbAgenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbAgenda.getColumnModel().getColumn(0).setMaxWidth(0);

        tbAgenda.getColumnModel().getColumn(1).setPreferredWidth(220);
        tbAgenda.getColumnModel().getColumn(2).setPreferredWidth(130);
    }

    private void preencherTabela() {
        try {
            DefaultTableModel tabela = (DefaultTableModel) tbAgenda.getModel();
            tabela.setNumRows(0);
            String nomeCliente = tfPesquisa.getText() + "%";
            for (AgendaEntity c : agendaDAO.listar(nomeCliente)) {
                tabela.addRow(new Object[]{c.getId(), c.getNome(), c.getCidade(), c.getEndereco(), c.getArea() + "-" + c.getCelular(), c.getTelefone()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == 40) {
            // System.out.print(usuario.getNome());
            if (tbAgenda.getRowCount() > 0) {
                tbAgenda.requestFocus();
                tbAgenda.addRowSelectionInterval(0, 0);
                int linha = tbAgenda.getSelectedRow();
                int id = Integer.parseInt(tbAgenda.getValueAt(linha, 0).toString());
                AgendaEntity agenda = new AgendaEntity();
                agend = new AgendaEntity();
                agenda.setId(id);
                bEditar.setEnabled(true);
                for (AgendaEntity a : agendaDAO.selecionaAgenda(agenda)) {
                    agend = a;
                }
                System.out.print(agend.getNome());
                bEditar.setEnabled(true);
            }
        }
    }
}
