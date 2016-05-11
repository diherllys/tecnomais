package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.CaixaDAO;
import com.br.tecnomais.dao.ClienteDAO;
import com.br.tecnomais.dao.ProdutosVendaDAO;
import com.br.tecnomais.dao.SaidasDAO;
import com.br.tecnomais.dao.UsuarioDAO;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class NovaVendaView extends javax.swing.JDialog {

    ClienteEntity ce = new ClienteEntity();
    List<ProdutosVendaEntity> lista = new ArrayList();
    VendaEntity ve = new VendaEntity();
    VendasView vv = new VendasView(null, null, null, ce, null, ve);
    Alertas alerta = new Alertas();
    SaidasDAO dao = new SaidasDAO();
    String nomeOP;
    String nomeUs;

    //  VendasView saidasV = new VendasView();
    /**
     * Creates new form EntradaView
     */
    public NovaVendaView(VendasView vv) {
        this.initComponents();
        this.vv = vv;
        ve.setId(0);
        this.setModal(true);

        lbPesquisaCaixa.setVisible(false);
        lbPesquisaCliente.setVisible(false);
        lbPesquisaVendedor.setVisible(false);
//        pCupom.setVisible(false);
//        tfBuscaSequencia.setVisible(false);
//        lbBuscaCupom.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfVendedor = new javax.swing.JTextField();
        tfCaixa = new javax.swing.JTextField();
        tfVendedorNome = new javax.swing.JTextField();
        tfCaiNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbOperacao = new javax.swing.JComboBox();
        tfOperacao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        tfClienteNome = new javax.swing.JTextField();
        lbPesquisaVendedor = new javax.swing.JLabel();
        lbPesquisaCliente = new javax.swing.JLabel();
        lbPesquisaCaixa = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nova Saída");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jLabel3.setText("Operação");

        jLabel4.setText("Vendedor");

        jLabel5.setText("Caixa");

        tfVendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfVendedorFocusLost(evt);
            }
        });
        tfVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVendedorActionPerformed(evt);
            }
        });

        tfCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCaixaFocusLost(evt);
            }
        });
        tfCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCaixaActionPerformed(evt);
            }
        });

        tfVendedorNome.setEditable(false);
        tfVendedorNome.setFocusable(false);

        tfCaiNome.setEditable(false);
        tfCaiNome.setFocusable(false);

        jButton1.setText("Começar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");

        cbOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VENDA ESTADUAL", "PRE-VENDA", "BRINDE" }));
        cbOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOperacaoActionPerformed(evt);
            }
        });

        tfOperacao.setText("1");
        tfOperacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfOperacaoFocusLost(evt);
            }
        });
        tfOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOperacaoActionPerformed(evt);
            }
        });

        jLabel7.setText("Cliente");

        tfCliente.setText("1");
        tfCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfClienteFocusLost(evt);
            }
        });
        tfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfClienteActionPerformed(evt);
            }
        });

        tfClienteNome.setText("CLIENTE BALCAO");

        lbPesquisaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaVendedor.setText(".");
        lbPesquisaVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaVendedorMousePressed(evt);
            }
        });

        lbPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaCliente.setText(".");
        lbPesquisaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaClienteMousePressed(evt);
            }
        });

        lbPesquisaCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaCaixa.setText(".");
        lbPesquisaCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaCaixaMousePressed(evt);
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
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 309, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPesquisaVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPesquisaCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPesquisaCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfOperacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfClienteNome)
                                .addComponent(tfVendedorNome)
                                .addComponent(tfCaiNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfCaixa, tfCliente, tfOperacao, tfVendedor});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVendedorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lbPesquisaVendedor))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel7))
                        .addComponent(lbPesquisaCliente, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCaiNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lbPesquisaCaixa))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfCaiNome, tfClienteNome, tfVendedorNome});

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

    private void tfOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOperacaoActionPerformed
        if (Integer.parseInt(tfOperacao.getText()) == 1) {
            cbOperacao.setSelectedIndex(0);
        }
        if (Integer.parseInt(tfOperacao.getText()) == 2) {
            cbOperacao.setSelectedIndex(1);
        }
        if (Integer.parseInt(tfOperacao.getText()) == 3) {
            cbOperacao.setSelectedItem(2);
        }
        tfVendedor.requestFocus();
    }//GEN-LAST:event_tfOperacaoActionPerformed

    private void tfOperacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOperacaoFocusLost
        if (Integer.parseInt(tfOperacao.getText()) == 1) {
            cbOperacao.setSelectedIndex(0);
        }
        if (Integer.parseInt(tfOperacao.getText()) == 2) {
            cbOperacao.setSelectedIndex(1);
        }
        if (Integer.parseInt(tfOperacao.getText()) == 3) {
            cbOperacao.setSelectedItem(2);
        }
        tfVendedor.requestFocus();
    }//GEN-LAST:event_tfOperacaoFocusLost

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
    }//GEN-LAST:event_cbOperacaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tfOperacao.getText().isEmpty() || tfVendedor.getText().isEmpty() || tfCaixa.getText().isEmpty()) {
            new Alertas().mensagemAviso("Preencha todos os campos!");
        } else {
            vv.selecionaCaixa(tfCaiNome.getText());
            vv.selecionaCliente(ce);
            vv.selecionaOperacao(cbOperacao.getSelectedItem().toString());
            vv.selecionaVendedor(tfVendedorNome.getText());
            //  vv.selecionaCupom(ve, lista);
            // new VendasView(cbOperacao.getSelectedItem().toString(), tfVendedor.getText(), tfCaiNome.getText(), ce, lista, ve).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCaixaActionPerformed
        pesquisarCaixa();
        if (!tfCaixa.getText().isEmpty() && !tfCaiNome.getText().isEmpty()
                && !tfCliente.getText().isEmpty() && !tfClienteNome.getText().isEmpty()
                && !tfOperacao.getText().isEmpty() && !tfVendedor.getText().isEmpty()
                && !tfVendedorNome.getText().isEmpty()) {
            vv.selecionaCaixa(tfCaiNome.getText());
            vv.selecionaCliente(ce);
            vv.selecionaOperacao(cbOperacao.getSelectedItem().toString());
            vv.selecionaVendedor(tfVendedorNome.getText());
//            vv.selecionaCupom(ve, lista);
            this.dispose();
        } else {
            alerta.mensagemAviso("Preencha todos os campos!");
        }
    }//GEN-LAST:event_tfCaixaActionPerformed

    private void tfCaixaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCaixaFocusLost
        pesquisarCaixa();
    }//GEN-LAST:event_tfCaixaFocusLost

    private void tfVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVendedorActionPerformed
        pesquisarUsuario();
    }//GEN-LAST:event_tfVendedorActionPerformed

    private void tfVendedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfVendedorFocusLost
        pesquisarUsuario();
    }//GEN-LAST:event_tfVendedorFocusLost

    private void tfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfClienteActionPerformed
        pesquisarCliente();
    }//GEN-LAST:event_tfClienteActionPerformed

    private void tfClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfClienteFocusLost
        pesquisarCliente();
    }//GEN-LAST:event_tfClienteFocusLost

    private void lbPesquisaVendedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaVendedorMousePressed
//        PesqCliVenCaixIniVendaView pesqCli = new PesqCliVenCaixIniVendaView(this, true, 2);
//        pesqCli.setVisible(true);
//        tfVendedor.setText(pesqCli.retornaid().toString());
    }//GEN-LAST:event_lbPesquisaVendedorMousePressed

    private void lbPesquisaClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaClienteMousePressed
//        PesqCliVenCaixIniVendaView pesqCli = new PesqCliVenCaixIniVendaView(this, true, 3);
//        pesqCli.setVisible(true);
//        tfCliente.setText(pesqCli.retornaid().toString());
    }//GEN-LAST:event_lbPesquisaClienteMousePressed

    private void lbPesquisaCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaCaixaMousePressed
//        PesqCliVenCaixIniVendaView pesqCli = new PesqCliVenCaixIniVendaView(this, true, 4);
//        pesqCli.setVisible(true);
//        tfCaixa.setText(pesqCli.retornaid().toString());
    }//GEN-LAST:event_lbPesquisaCaixaMousePressed

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
                new NovaVendaView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbOperacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbPesquisaCaixa;
    private javax.swing.JLabel lbPesquisaCliente;
    private javax.swing.JLabel lbPesquisaVendedor;
    private javax.swing.JTextField tfCaiNome;
    private javax.swing.JTextField tfCaixa;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfClienteNome;
    private javax.swing.JTextField tfOperacao;
    private javax.swing.JTextField tfVendedor;
    private javax.swing.JTextField tfVendedorNome;
    // End of variables declaration//GEN-END:variables

    private void desabilitarCampos() {
        tfVendedorNome.setEditable(false);
        tfOperacao.setEditable(false);
        tfCaiNome.setEditable(false);
    }

    private void pesquisarUsuario() {
        try {
            if (tfVendedor.getText().isEmpty()) {
                
            } else {
                String result = dao.selecionaUsuario(Integer.parseInt(tfVendedor.getText()));
                tfVendedorNome.setText(result);
                tfCliente.requestFocus();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisarCaixa() {
        try {
            CaixaDAO dao = new CaixaDAO();
            for (CaixaEntity caixa : dao.selecionaCaixa(Integer.parseInt(tfCaixa.getText()))) {
                tfCaiNome.setText(caixa.getNome());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisarCliente() {
        try {
            ClienteEntity ce = new ClienteEntity();
            ce.setId(Integer.parseInt(tfCliente.getText()));
            ClienteDAO dao = new ClienteDAO();
            for (ClienteEntity cliente : dao.selecionaCliente(ce)) {
                tfClienteNome.setText(cliente.getNome());
                this.ce = cliente;
            }
            tfCaixa.requestFocus();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
