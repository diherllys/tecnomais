/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vconfiguracao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.PermissoesDAO;
import com.br.tecnomais.dao.UsuarioDAO;
import com.br.tecnomais.entity.PermissoesEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desenvolvimento
 */
public class PermissoesView extends javax.swing.JFrame {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    List<UsuarioEntity> usList = new ArrayList();
    UsuarioEntity ue = new UsuarioEntity();
    PermissoesDAO pDAO = new PermissoesDAO();
    // PermissoesEntity pe = new PermissoesEntity();

    /**
     * Creates new form PermissoesView
     */
    public PermissoesView() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        chbCad = new javax.swing.JCheckBox();
        chbCadFilial = new javax.swing.JCheckBox();
        chbCadUsuario = new javax.swing.JCheckBox();
        chbMovimentacao = new javax.swing.JCheckBox();
        chbContasRevPagFCai = new javax.swing.JCheckBox();
        tfPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        chbConfLogo = new javax.swing.JCheckBox();
        chbConfImp = new javax.swing.JCheckBox();
        chbConfPerm = new javax.swing.JCheckBox();
        chbEscritorio = new javax.swing.JCheckBox();
        chbCancelarVendas = new javax.swing.JCheckBox();
        chbAbrirGaveta = new javax.swing.JCheckBox();
        chbExcluirMov = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbUsuarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuario);
        if (tbUsuario.getColumnModel().getColumnCount() > 0) {
            tbUsuario.getColumnModel().getColumn(0).setResizable(false);
            tbUsuario.getColumnModel().getColumn(1).setResizable(false);
        }

        chbCad.setBackground(new java.awt.Color(200, 210, 210));
        chbCad.setText("Cadastro");
        chbCad.setToolTipText("Clientes, Fornecedor, Produtos");

        chbCadFilial.setBackground(new java.awt.Color(200, 210, 210));
        chbCadFilial.setText("Cadastro Filial");

        chbCadUsuario.setBackground(new java.awt.Color(200, 210, 210));
        chbCadUsuario.setText("Cadastro Usuário");

        chbMovimentacao.setBackground(new java.awt.Color(200, 210, 210));
        chbMovimentacao.setText("Movimentação");
        chbMovimentacao.setToolTipText("Saída, Entrada e Consultar Saídas");

        chbContasRevPagFCai.setBackground(new java.awt.Color(200, 210, 210));
        chbContasRevPagFCai.setText("Mov Contas Receber, Pagar, Fluxo Caixa");

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

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chbConfLogo.setBackground(new java.awt.Color(200, 210, 210));
        chbConfLogo.setText("Configurar Logomarca");
        chbConfLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbConfLogoActionPerformed(evt);
            }
        });

        chbConfImp.setBackground(new java.awt.Color(200, 210, 210));
        chbConfImp.setText("Configurar Impressora");

        chbConfPerm.setBackground(new java.awt.Color(200, 210, 210));
        chbConfPerm.setText("Configurar Permissões");
        chbConfPerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbConfPermActionPerformed(evt);
            }
        });

        chbEscritorio.setBackground(new java.awt.Color(200, 210, 210));
        chbEscritorio.setText("Escritório");
        chbEscritorio.setToolTipText("Agenda e Anotações");

        chbCancelarVendas.setBackground(new java.awt.Color(200, 210, 210));
        chbCancelarVendas.setText("Cancelar Vendas");

        chbAbrirGaveta.setBackground(new java.awt.Color(200, 210, 210));
        chbAbrirGaveta.setText("Abrir Gaveta");

        chbExcluirMov.setBackground(new java.awt.Color(200, 210, 210));
        chbExcluirMov.setText("Excluir Movimentações");
        chbExcluirMov.setToolTipText("Poderá Excluir qualquer dado ligado ao Fluxo de Caixa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbContasRevPagFCai)
                            .addComponent(chbMovimentacao)
                            .addComponent(chbCadUsuario)
                            .addComponent(chbCadFilial)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chbConfImp)
                                    .addComponent(chbConfPerm)
                                    .addComponent(chbConfLogo))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chbEscritorio)
                                        .addComponent(chbCancelarVendas)
                                        .addComponent(chbAbrirGaveta))
                                    .addGap(28, 28, 28)))
                            .addComponent(chbCad)
                            .addComponent(chbExcluirMov))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chbExcluirMov)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbMovimentacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbContasRevPagFCai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbCadFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbCadUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbCad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbConfLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbConfImp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbConfPerm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbEscritorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbCancelarVendas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbAbrirGaveta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chbConfLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbConfLogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbConfLogoActionPerformed

    private void chbConfPermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbConfPermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbConfPermActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tbUsuario.clearSelection();
        ue = new UsuarioEntity();
        limparBox();
        preencherTabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        preencherTabela();
    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void tbUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMousePressed
        try {
            limparBox();
            PermissoesEntity pe = new PermissoesEntity();
            int linha = tbUsuario.getSelectedRow();
            ue = usList.get(linha);

            pe = pDAO.buscaPerm(ue.getId());
            if (pe.getCadastro() == 1) {
                chbCad.setSelected(true);
            }
            if (pe.getCadastroFilial() == 1) {
                chbCadFilial.setSelected(true);
            }
            if (pe.getCadastroUsuario() == 1) {
                chbCadUsuario.setSelected(true);
            }
            if (pe.getConfigurarImp() == 1) {
                chbConfImp.setSelected(true);
            }
            if (pe.getConfigurarLogo() == 1) {
                chbConfLogo.setSelected(true);
            }
            if (pe.getConfigurarPerm() == 1) {
                chbConfPerm.setSelected(true);
            }
            if (pe.getEscritorio() == 1) {
                chbEscritorio.setSelected(true);
            }
            if (pe.getMovContRecbPagFlxCaixa() == 1) {
                chbContasRevPagFCai.setSelected(true);
            }
            if (pe.getMovimentacao() == 1) {
                chbMovimentacao.setSelected(true);
            }
            if (pe.getCancelarVenda() == 1) {
                chbCancelarVendas.setSelected(true);
            }
            if (pe.getAbrirGaveta() == 1) {
                chbAbrirGaveta.setSelected(true);
            }
            if (pe.getExcluirMov() == 1) {
                chbExcluirMov.setSelected(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tbUsuarioMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            PermissoesEntity pe = new PermissoesEntity();
            pe = pDAO.buscaPerm(ue.getId());

            if (pDAO.verificaIdUsuario(pe.getIdUsuario())) {
                editar();
                new Alertas().mensagemConfirmacao("Permissões alteradas com sucesso!!!");
            } else {
                save();
                new Alertas().mensagemConfirmacao("Permissões salvas com sucesso!!!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFocusGained
        tbUsuario.clearSelection();
        ue = new UsuarioEntity();
        limparBox();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PermissoesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PermissoesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PermissoesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PermissoesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PermissoesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chbAbrirGaveta;
    private javax.swing.JCheckBox chbCad;
    private javax.swing.JCheckBox chbCadFilial;
    private javax.swing.JCheckBox chbCadUsuario;
    private javax.swing.JCheckBox chbCancelarVendas;
    private javax.swing.JCheckBox chbConfImp;
    private javax.swing.JCheckBox chbConfLogo;
    private javax.swing.JCheckBox chbConfPerm;
    private javax.swing.JCheckBox chbContasRevPagFCai;
    private javax.swing.JCheckBox chbEscritorio;
    private javax.swing.JCheckBox chbExcluirMov;
    private javax.swing.JCheckBox chbMovimentacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        DefaultTableModel tb = (DefaultTableModel) tbUsuario.getModel();
        tb.setNumRows(0);
        String nome = tfPesquisa.getText() + "%";

        try {
            usList = usuarioDAO.listar(nome);
            for (UsuarioEntity us : usList) {
                tb.addRow(new Object[]{us.getId(), us.getNome_usuario()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void limparBox() {
        chbCad.setSelected(false);
        chbCadFilial.setSelected(false);
        chbCadUsuario.setSelected(false);
        chbConfLogo.setSelected(false);
        chbConfPerm.setSelected(false);
        chbContasRevPagFCai.setSelected(false);
        chbEscritorio.setSelected(false);
        chbConfImp.setSelected(false);
        chbMovimentacao.setSelected(false);
        chbCancelarVendas.setSelected(false);
        chbAbrirGaveta.setSelected(false);
        chbExcluirMov.setSelected(false);
    }

    private void save() {
        PermissoesEntity pe = new PermissoesEntity();
        if (chbCad.isSelected() == true) {
            pe.setCadastro(1);
        }
        if (chbCadFilial.isSelected() == true) {
            pe.setCadastroFilial(1);
        }
        if (chbCadUsuario.isSelected() == true) {
            pe.setCadastroUsuario(1);
        }
        if (chbConfImp.isSelected() == true) {
            pe.setConfigurarImp(1);
        }
        if (chbConfPerm.isSelected() == true) {
            pe.setConfigurarPerm(1);
        }
        if (chbConfLogo.isSelected() == true) {
            pe.setConfigurarLogo(1);
        }
        if (chbEscritorio.isSelected() == true) {
            pe.setEscritorio(1);
        }
        if (chbContasRevPagFCai.isSelected() == true) {
            pe.setMovContRecbPagFlxCaixa(1);
        }
        if (chbMovimentacao.isSelected() == true) {
            pe.setMovimentacao(1);
        }
        if (chbCancelarVendas.isSelected() == true) {
            pe.setCancelarVenda(1);
        }
        if (chbAbrirGaveta.isSelected() == true) {
            pe.setAbrirGaveta(1);
        }
        if (chbExcluirMov.isSelected() == true) {
            pe.setExcluirMov(1);
        }
        pe.setIdUsuario(ue.getId());
        pDAO.salvarPerm(pe);
    }

    private void editar() {
        PermissoesEntity pe = new PermissoesEntity();
        if (chbCad.isSelected() == true) {
            pe.setCadastro(1);
        }
        if (chbCadFilial.isSelected() == true) {
            pe.setCadastroFilial(1);
        }
        if (chbCadUsuario.isSelected() == true) {
            pe.setCadastroUsuario(1);
        }
        if (chbConfImp.isSelected() == true) {
            pe.setConfigurarImp(1);
        }
        if (chbConfPerm.isSelected() == true) {
            pe.setConfigurarPerm(1);
        }
        if (chbConfLogo.isSelected() == true) {
            pe.setConfigurarLogo(1);
        }
        if (chbEscritorio.isSelected() == true) {
            pe.setEscritorio(1);
        }
        if (chbContasRevPagFCai.isSelected() == true) {
            pe.setMovContRecbPagFlxCaixa(1);
        }
        if (chbMovimentacao.isSelected() == true) {
            pe.setMovimentacao(1);
        }
        if (chbCancelarVendas.isSelected() == true) {
            pe.setCancelarVenda(1);
        }

        if (chbAbrirGaveta.isSelected() == true) {
            pe.setAbrirGaveta(1);
        }

        if (chbExcluirMov.isSelected() == true) {
            pe.setExcluirMov(1);
        }

        int linha = tbUsuario.getSelectedRow();
        pe.setIdUsuario(ue.getId());

        pDAO.alterarPerm(pe);

    }
}
