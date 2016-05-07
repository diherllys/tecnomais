package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.ProdutosVendaDAO;
import com.br.tecnomais.dao.SaidasDAO;
import com.br.tecnomais.dao.VendaDAO;
import com.br.tecnomais.entity.BuscarVendaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class BuscarVendaView extends javax.swing.JDialog {

    List<VendaEntity> listVenda = new ArrayList();
    VendaDAO vendaDAO = new VendaDAO();
    BuscarVendaEntity bve = new BuscarVendaEntity();

    ClienteEntity ce = new ClienteEntity();
    VendaEntity ve = new VendaEntity();
    VendasView saidasV = new VendasView(null, null, null, ce, null, ve);

    public BuscarVendaView(java.awt.Frame parent, boolean modal, VendasView vv) {
        super(parent, modal);
        initComponents();
        this.saidasV = vv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfCodigoVendas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfCliNome = new javax.swing.JTextField();
        tfProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tfDataVenda = new javax.swing.JFormattedTextField();
        jcOperacoes = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel2.setBackground(new java.awt.Color(170, 180, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buscar Venda");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        tbVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº do Cupom", "Nome do Cliente", "Data da Venda", "Vlr. Total", "Operação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVenda.getTableHeader().setReorderingAllowed(false);
        tbVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbVendaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbVenda);
        if (tbVenda.getColumnModel().getColumnCount() > 0) {
            tbVenda.getColumnModel().getColumn(0).setResizable(false);
            tbVenda.getColumnModel().getColumn(1).setResizable(false);
            tbVenda.getColumnModel().getColumn(1).setPreferredWidth(275);
            tbVenda.getColumnModel().getColumn(2).setResizable(false);
            tbVenda.getColumnModel().getColumn(3).setResizable(false);
            tbVenda.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Id venda");

        tfCodigoVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoVendasActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome do Cliente");

        jLabel4.setText("Data da Venda");

        jLabel5.setText("Produto");

        tfCliNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCliNomeActionPerformed(evt);
            }
        });

        tfProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProdutoActionPerformed(evt);
            }
        });

        jLabel6.setText("Operação");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        try {
            tfDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataVendaActionPerformed(evt);
            }
        });

        jcOperacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "PRE-VENDA", "VENDA ESTADUAL", "BRINDE" }));
        jcOperacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcOperacoesActionPerformed(evt);
            }
        });

        jButton2.setText("Selecionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCodigoVendas, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(tfCliNome)
                            .addComponent(tfDataVenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfProduto)
                            .addComponent(jcOperacoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(109, 341, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfCliNome, tfCodigoVendas, tfProduto});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodigoVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jcOperacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mostrarPesquisa();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfCodigoVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoVendasActionPerformed
        mostrarPesquisa();
    }//GEN-LAST:event_tfCodigoVendasActionPerformed

    private void tfCliNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCliNomeActionPerformed
        mostrarPesquisa();
    }//GEN-LAST:event_tfCliNomeActionPerformed

    private void tfDataVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataVendaActionPerformed
        mostrarPesquisa();
    }//GEN-LAST:event_tfDataVendaActionPerformed

    private void tfProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProdutoActionPerformed
        mostrarPesquisa();
    }//GEN-LAST:event_tfProdutoActionPerformed

    private void jcOperacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcOperacoesActionPerformed
        mostrarPesquisa();
    }//GEN-LAST:event_jcOperacoesActionPerformed

    private void tbVendaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVendaMousePressed
        Integer linha = tbVenda.getSelectedRow();
        Integer cupom = (Integer) tbVenda.getValueAt(linha, 0);
        if (evt.getClickCount() == 2 && evt.getClickCount() > 1) {
            pesquisaCupom(cupom);
            this.dispose();
        }
    }//GEN-LAST:event_tbVendaMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Integer linha = tbVenda.getSelectedRow();
        Integer cupom = (Integer) tbVenda.getValueAt(linha, 0);
        if (tbVenda.getSelectedRow() == 0 || tbVenda.getSelectedRow() > 0) {
            pesquisaCupom(cupom);
            this.dispose();
        } else {
            new Alertas().mensagemAviso("Selecione uma venda!!!");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarVendaView dialog = new BuscarVendaView(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcOperacoes;
    private javax.swing.JTable tbVenda;
    private javax.swing.JTextField tfCliNome;
    private javax.swing.JTextField tfCodigoVendas;
    private javax.swing.JFormattedTextField tfDataVenda;
    private javax.swing.JTextField tfProduto;
    // End of variables declaration//GEN-END:variables

    public void mostrarPesquisa() {
        if (!tfCodigoVendas.getText().isEmpty() && tfCliNome.getText().isEmpty() && tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() == 0 && tfProduto.getText().isEmpty()) {
            preencherTabelaPorCodigoVenda();
        } else if (tfCodigoVendas.getText().isEmpty() && !tfCliNome.getText().isEmpty() && tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() == 0 && tfProduto.getText().isEmpty()) {
            preencherTabelaPorNomeCliente();
        } else if (tfCodigoVendas.getText().isEmpty() && tfCliNome.getText().isEmpty() && !tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() == 0 && tfProduto.getText().isEmpty()) {
            preencherTabelaPorData();
        } else if (tfCodigoVendas.getText().isEmpty() && tfCliNome.getText().isEmpty() && tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() != 0 && tfProduto.getText().isEmpty()) {
            preencherTabelaPorOperacao();
        } else if (tfCodigoVendas.getText().isEmpty() && tfCliNome.getText().isEmpty() && tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() == 0 && !tfProduto.getText().isEmpty()) {
            preencherTabelaPorProduto();
        } else if (tfCodigoVendas.getText().isEmpty() && !tfCliNome.getText().isEmpty() && !tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() == 0 && tfProduto.getText().isEmpty()) {
            preencherTabelaPorNomeClienteData();
        } else if (tfCodigoVendas.getText().isEmpty() && !tfCliNome.getText().isEmpty() && tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() != 0 && tfProduto.getText().isEmpty()) {
            preencherTabelaPorNomeClienteOperacao();
        } else if (tfCodigoVendas.getText().isEmpty() && !tfCliNome.getText().isEmpty() && tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() == 0 && !tfProduto.getText().isEmpty()) {
            preencherTabelaPorNomeClienteProduto();
        } else if (tfCodigoVendas.getText().isEmpty() && tfCliNome.getText().isEmpty() && !tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() != 0 && tfProduto.getText().isEmpty()) {
            preencherTabelaPorDataOperacao();
        } else if (tfCodigoVendas.getText().isEmpty() && tfCliNome.getText().isEmpty() && !tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() == 0 && !tfProduto.getText().isEmpty()) {
            preencherTabelaPorDataProduto();
        } else if (tfCodigoVendas.getText().isEmpty() && tfCliNome.getText().isEmpty() && tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() != 0 && !tfProduto.getText().isEmpty()) {
            preencherTabelaPorOperacaoProduto();
        } else if (tfCodigoVendas.getText().isEmpty() && !tfCliNome.getText().isEmpty() && !tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() != 0 && tfProduto.getText().isEmpty()) {
            preencherTabelaPorNomeClienteDataOperacao();
        } else if (tfCodigoVendas.getText().isEmpty() && !tfCliNome.getText().isEmpty() && !tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() != 0 && !tfProduto.getText().isEmpty()) {
            preencherTabelaPorNomeClienteDataOperacaoProduto();
        } else if (tfCodigoVendas.getText().isEmpty() && tfCliNome.getText().isEmpty() && !tfDataVenda.getText().contains(" ") && jcOperacoes.getSelectedIndex() != 0 && !tfProduto.getText().isEmpty()) {
            preencherTabelaPorDataOperacaoProduto();
        } else {
            limpaTabela();
        }
    }

    private void preencherTabelaPorCodigoVenda() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            Integer codigoVendas = Integer.parseInt(tfCodigoVendas.getText());
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorCodigoVenda(codigoVendas)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorNomeCliente() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String nome = "%" + tfCliNome.getText() + "%";
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorNomeCliente(nome)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorData() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String dataVenda = tfDataVenda.getText();
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorDataVenda(dataVenda)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorOperacao() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String operacao = jcOperacoes.getSelectedItem().toString();
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorOperacao(operacao)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorProduto() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String produto = tfProduto.getText() + "%";
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorProduto(produto)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limpaTabela() {
        DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
        tb.setNumRows(0);
    }

    private void preencherTabelaPorNomeClienteData() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String dataVenda = tfDataVenda.getText();
            String nome = "%" + tfCliNome.getText() + "%";
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorNomeClienteDataVenda(nome, dataVenda)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorNomeClienteOperacao() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String operacao = jcOperacoes.getSelectedItem().toString();
            String nome = "%" + tfCliNome.getText() + "%";
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorNomeClienteOperacao(nome, operacao)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorNomeClienteProduto() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String produto = tfProduto.getText() + "%";
            String nome = "%" + tfCliNome.getText() + "%";
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorNomeClienteProduto(nome, produto)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorDataOperacao() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String dataVenda = tfDataVenda.getText();
            String operacao = jcOperacoes.getSelectedItem().toString();
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorDataVendaOperacao(dataVenda, operacao)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorDataProduto() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String dataVenda = tfDataVenda.getText();
            String produto = tfProduto.getText() + "%";
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorDataVendaProduto(dataVenda, produto)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorOperacaoProduto() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String produto = tfProduto.getText() + "%";
            String operacao = jcOperacoes.getSelectedItem().toString();
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorOperacaoProduto(operacao, produto)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorNomeClienteDataOperacao() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String dataVenda = tfDataVenda.getText();
            String nome = "%" + tfCliNome.getText() + "%";
            String operacao = jcOperacoes.getSelectedItem().toString();
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorNomeClienteDataVendaOperacao(nome, dataVenda, operacao)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorNomeClienteDataOperacaoProduto() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String dataVenda = tfDataVenda.getText();
            String nome = "%" + tfCliNome.getText() + "%";
            String operacao = jcOperacoes.getSelectedItem().toString();
            String produto = tfProduto.getText() + "%";
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorNomeClienteDataVendaOperacaoProduto(nome, dataVenda, operacao, produto)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorDataOperacaoProduto() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();
            tb.setNumRows(0);
            String dataVenda = tfDataVenda.getText();
            String operacao = jcOperacoes.getSelectedItem().toString();
            String produto = tfProduto.getText() + "%";
            for (BuscarVendaEntity bve : vendaDAO.listaVendasPorDataVendaOperacaoProduto(dataVenda, produto, operacao)) {
                tb.addRow(new Object[]{bve.getVenda().getId(), bve.getCliente().getNome(), bve.getVenda().getDataVenda(), new DecimalFormat("0.00").format(bve.getVenda().getVlrTotal()), bve.getVenda().getOperacao()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pesquisaCupom(Integer cod) {
        if (cod == 0 || cod == null) {
            new Alertas().mensagemAviso("Não foi possível buscar esta sequência!\nSequência informada está nula!");
        } else {
            Integer sequencia = cod;
            SaidasDAO sDAO = new SaidasDAO();
            VendaEntity ve = new VendaEntity();
            try {
                ve = sDAO.retornaSaida(sequencia);
                if (ve.getClienteID() > 0) {
                    List<ProdutosVendaEntity> lista = new ArrayList();
                    ProdutosVendaDAO pvDAO = new ProdutosVendaDAO();
                    lista = pvDAO.listaProdutosDaVenda(ve.getId());
                    this.ve = ve;
                    saidasV.selecionaCupom(ve, lista);
                    this.dispose();
                } else {
                    new Alertas().mensagemAviso("Essa sequencia não é valida");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
