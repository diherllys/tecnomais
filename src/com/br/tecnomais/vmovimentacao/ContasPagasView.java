package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.CaixaDAO;
import com.br.tecnomais.dao.ContaPagarDAO;
import com.br.tecnomais.dao.ContasPagasDAO;
import com.br.tecnomais.dao.MovimentacaoDAO;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.ContasPagasEntity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ContasPagasView extends javax.swing.JFrame {

    private final ContasPagasDAO dao = new ContasPagasDAO();
    /**
     * Creates new form ContasPagasView
     */
    int linha;
    int entradaId = 0;

    public ContasPagasView() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        preencherTabela();
        bDevolverPag.setVisible(false);
        preencherCBCaixa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbContasPagas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfDescricaoObs = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfFornecedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbTipoCobranca = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfDataVencimento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tfDataPagamento = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bDevolverPag = new javax.swing.JButton();
        cbCaixa = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        tbContasPagas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Valor Pago", "Fornecedor", "Tipo Cobrança", "Observações", "Usuário", "Vencimento", "Pagamento", "EntradaID", "ContaPagarID", "Caixa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbContasPagas.getTableHeader().setReorderingAllowed(false);
        tbContasPagas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbContasPagasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbContasPagas);
        if (tbContasPagas.getColumnModel().getColumnCount() > 0) {
            tbContasPagas.getColumnModel().getColumn(0).setMinWidth(0);
            tbContasPagas.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbContasPagas.getColumnModel().getColumn(0).setMaxWidth(0);
            tbContasPagas.getColumnModel().getColumn(1).setPreferredWidth(220);
            tbContasPagas.getColumnModel().getColumn(3).setPreferredWidth(220);
            tbContasPagas.getColumnModel().getColumn(5).setPreferredWidth(320);
            tbContasPagas.getColumnModel().getColumn(9).setMinWidth(0);
            tbContasPagas.getColumnModel().getColumn(9).setPreferredWidth(0);
            tbContasPagas.getColumnModel().getColumn(9).setMaxWidth(0);
            tbContasPagas.getColumnModel().getColumn(10).setMinWidth(0);
            tbContasPagas.getColumnModel().getColumn(10).setPreferredWidth(0);
            tbContasPagas.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        jLabel2.setText("Descrição");

        tfDescricaoObs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescricaoObsFocusLost(evt);
            }
        });
        tfDescricaoObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescricaoObsActionPerformed(evt);
            }
        });

        jLabel3.setText("Fornecedor");

        tfFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFornecedorActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo de Cobrança");

        cbTipoCobranca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "DINHEIRO", "PRAZO", "BOLETO", "CARTAO CREDITO", "CARTAO DEBITO", "CHEQUE", " " }));
        cbTipoCobranca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbTipoCobrancaKeyPressed(evt);
            }
        });

        jLabel5.setText("Usuário");

        jLabel6.setText("Vencimento");

        try {
            tfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDataVencimentoFocusLost(evt);
            }
        });
        tfDataVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataVencimentoActionPerformed(evt);
            }
        });

        jLabel7.setText("Data de Pagamento");

        try {
            tfDataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataPagamentoActionPerformed(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Contas Pagas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        bDevolverPag.setText("Dev.Pag");
        bDevolverPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDevolverPagActionPerformed(evt);
            }
        });

        cbCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        jLabel8.setText("Caixa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(tfDescricaoObs)
                    .addComponent(jLabel3)
                    .addComponent(tfFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(tfUsuario)
                            .addComponent(cbTipoCobranca, 0, 182, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDevolverPag, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(279, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescricaoObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoCobranca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDevolverPag)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
        if (cbCaixa.getSelectedIndex() == 0 && tfDataPagamento.getText().contains(" ") && tfDataVencimento.getText().contains(" ") && tfDescricaoObs.getText().isEmpty() && tfFornecedor.getText().isEmpty() && tfUsuario.getText().isEmpty() && cbTipoCobranca.getSelectedIndex() == 0) {
            preencherTabela();
        } else {
            pesquisar();
        }

        tbContasPagas.clearSelection();
        bDevolverPag.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfDataVencimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDataVencimentoFocusLost
        if (tfDataVencimento.getText().equals(" ")) {
            tfDataVencimento.setValue("");
        }
    }//GEN-LAST:event_tfDataVencimentoFocusLost

    private void tfDescricaoObsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescricaoObsFocusLost

    }//GEN-LAST:event_tfDescricaoObsFocusLost

    private void cbTipoCobrancaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbTipoCobrancaKeyPressed
        pesquisar();
    }//GEN-LAST:event_cbTipoCobrancaKeyPressed

    private void tfFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFornecedorActionPerformed
        pesquisar();
    }//GEN-LAST:event_tfFornecedorActionPerformed

    private void tfDescricaoObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescricaoObsActionPerformed
        pesquisar();
    }//GEN-LAST:event_tfDescricaoObsActionPerformed

    private void tfDataVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataVencimentoActionPerformed
        pesquisar();
    }//GEN-LAST:event_tfDataVencimentoActionPerformed

    private void tfDataPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataPagamentoActionPerformed
        pesquisar();
    }//GEN-LAST:event_tfDataPagamentoActionPerformed

    private void bDevolverPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDevolverPagActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja Devolver a conta a tabela de Contas à Pagar?", "Opcões", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        //tenho que se entrada não existir na tb_contasPagar não vai poder ser removida apenas pela entrada;
        Integer contaPagasId = Integer.parseInt(tbContasPagas.getValueAt(linha, 0).toString());
        Integer contaPagarId = Integer.parseInt(tbContasPagas.getValueAt(linha, 10).toString());
        if (opcao == JOptionPane.YES_OPTION && (contaPagarId == 0 || contaPagarId == null)) {
            ContaPagarDAO contasPagarDAO = new ContaPagarDAO();
            ContasPagasDAO contasPagasDAO = new ContasPagasDAO();
            MovimentacaoDAO movDAO = new MovimentacaoDAO();
            System.out.println("conta pagar id " + contaPagarId);
            contasPagarDAO.updateStatus(contaPagarId, "ON");
            contasPagasDAO.deletarContaPagas(contaPagasId);
            movDAO.deletarPorContaPagarId(contaPagarId);
            pesquisar();
            new Alertas().mensagemConfirmacao("A conta foi apagada com sucesso! Excluindo a Saída no Fluxo de Caixa Geral do Sistema");
        } else {
//            new Alertas().mensagemAviso("Selecione uma Conta na Tabela");
            new Alertas().mensagemAviso("A conta não pode ser devolvida , pois foi gerada pela Tela de Entrada "
                    + "\n só podendo ser devolvida pela Tela de Entrada!");
        }
    }//GEN-LAST:event_bDevolverPagActionPerformed

    private void tbContasPagasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbContasPagasMousePressed
        linha = tbContasPagas.getSelectedRow();
        entradaId = Integer.parseInt(tbContasPagas.getValueAt(linha, 9).toString());
        bDevolverPag.setVisible(true);
//        if (id > 0) {
//            this.dispose();
//            new ContasApagar(id, u).setVisible(true);
//        }
    }//GEN-LAST:event_tbContasPagasMousePressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContasPagasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContasPagasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContasPagasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContasPagasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContasPagasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDevolverPag;
    private javax.swing.JComboBox cbCaixa;
    private javax.swing.JComboBox cbTipoCobranca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbContasPagas;
    private javax.swing.JFormattedTextField tfDataPagamento;
    private javax.swing.JFormattedTextField tfDataVencimento;
    private javax.swing.JTextField tfDescricaoObs;
    private javax.swing.JTextField tfFornecedor;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        DefaultTableModel tb = (DefaultTableModel) tbContasPagas.getModel();
        tb.setNumRows(0);
        try {
            for (ContasPagasEntity c : dao.listaContasPagas()) {
                tb.addRow(new Object[]{c.getContasPagasId(), c.getDescricao(), new DecimalFormat("0.00").format(c.getVlrPago() / 100), c.getFornecedor(), c.getTipoCobranca(), c.getObs(), c.getUsuario(), c.getDataVencimento(), c.getDataPagamento(), c.getEntradaId(), c.getContaPagarId()});
                System.out.println("ID: " + c.getContasPagasId() + " Entrada: " + c.getEntradaId());
            }
        } catch (Exception e) {
            new Alertas().mensagemErro("Erro ao executar a sql para preencher a tabela!");
        }
    }

    private void pesquisar() {
        List<ContasPagasEntity> minhaLista = new ArrayList<>();
        String descricao = "";
        String tipoCobranca = "";
        String dataVencimento = "";
        String fornecedor = "";
        String usuario = "";
        String dataPagamento = "";
        String obs = "";
        String caixa = "";

        if (!tfDescricaoObs.getText().isEmpty()) {
            descricao = tfDescricaoObs.getText();
        }

        if (!cbTipoCobranca.getSelectedItem().toString().equals("...")) {
            tipoCobranca = cbTipoCobranca.getSelectedItem().toString();
        }

        if (!cbCaixa.getSelectedItem().toString().equals("...")) {
            caixa = cbCaixa.getSelectedItem().toString();
        }

        if (!tfDataVencimento.getText().contains(" ")) {
            dataVencimento = tfDataVencimento.getText();
        }

        if (!tfFornecedor.getText().isEmpty()) {
            fornecedor = tfFornecedor.getText();
        }

        if (!tfUsuario.getText().isEmpty()) {
            usuario = tfUsuario.getText();
        }
//
        if (!tfDataPagamento.getText().contains(" ")) {
            dataPagamento = tfDataPagamento.getText();
        }
        try {
            minhaLista = dao.listaContasPagasFiltros("%" + descricao + "%", "%" + tipoCobranca + "%", "%" + dataVencimento + "%", "%" + fornecedor + "%", "%" + usuario + "%", "%" + dataPagamento + "%", "%" + obs + "%", "%" + caixa + "%");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DefaultTableModel tb = (DefaultTableModel) tbContasPagas.getModel();
        tb.setNumRows(0);
        try {
            for (ContasPagasEntity c : minhaLista) {
                tb.addRow(new Object[]{c.getContasPagasId(), c.getDescricao(), new DecimalFormat("0.00").format(c.getVlrPago() / 100), c.getFornecedor(), c.getTipoCobranca(), c.getObs(), c.getUsuario(), c.getDataVencimento(), c.getDataPagamento(), c.getEntradaId(), c.getCaixa()});
                System.out.println("ID: " + c.getContasPagasId() + " Entrada: " + c.getEntradaId());
            }
        } catch (Exception e) {
            new Alertas().mensagemErro("Erro ao executar a sql para preencher a tabela!");
        }
    }
    
    public void preencherCBCaixa() {
        CaixaDAO caiDAO = new CaixaDAO();
        try {
            CaixaEntity cls = new CaixaEntity();
            for (String str : caiDAO.todosCaixaNome()) {
                cbCaixa.addItem(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
