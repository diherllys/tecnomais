/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.Dinheiro;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.classes.ValidarCamposNumericos;
import com.br.tecnomais.dao.CaixaDAO;
import com.br.tecnomais.dao.ContasReceberDAO;
import com.br.tecnomais.dao.MovimentacaoDAO;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.ContasReceberEntity;
import com.br.tecnomais.entity.MovimentacaoEntity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desenvolvimento
 */
public class ContasReceberView extends javax.swing.JFrame {

    ClienteEntity cli = new ClienteEntity();
    List<ContasReceberEntity> contasList = new ArrayList();
    ContasReceberDAO contasDAO = new ContasReceberDAO();
    NovaData data = new NovaData();

    /**
     * Creates new form ContasReceber
     */
    public ContasReceberView(ClienteEntity cli) {
        initComponents();
        this.cli = cli;
        data.dataAtual(lbDataHoje);
        lbTop.setText(lbTop.getText() + " : " + cli.getNome());
        mostraPesquisa();
        tfId.setFocusable(false);
        tfNumParcelas.setFocusable(false);
        tfVencimento.setFocusable(false);
        tfVenda.setFocusable(false);
        tfVlrParcela.setFocusable(false);
        tfVlrRestante.setFocusable(false);
        tfVlrTotal.setFocusable(false);
        tfId.setVisible(false);
        tfVenda.setVisible(false);
        preencherCBCaixa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTop = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfVlrTotal = new javax.swing.JTextField();
        tfNumParcelas = new javax.swing.JTextField();
        tfVencimento = new javax.swing.JTextField();
        tfVenda = new javax.swing.JTextField();
        tfVlrRestante = new javax.swing.JTextField();
        tfVlrParcela = new javax.swing.JTextField();
        tfValorAPagar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lbDataHoje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbCaixa = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        lbTop.setBackground(new java.awt.Color(170, 180, 180));
        lbTop.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTop.setText("Contas à Receber");
        lbTop.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbTop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbTop.setOpaque(true);

        tbTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Venda", "Valor por Parcela", "Valor Restante", "Valor Total", "Nº de Parcelas", "Vencimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbTabelaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbTabela);
        if (tbTabela.getColumnModel().getColumnCount() > 0) {
            tbTabela.getColumnModel().getColumn(0).setResizable(false);
            tbTabela.getColumnModel().getColumn(1).setResizable(false);
            tbTabela.getColumnModel().getColumn(2).setResizable(false);
            tbTabela.getColumnModel().getColumn(3).setResizable(false);
            tbTabela.getColumnModel().getColumn(4).setResizable(false);
            tbTabela.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel3.setText("Valor Total");

        jLabel4.setText("Nº de Parcelas");

        jLabel5.setText("Vencimento");

        jLabel7.setText("Valor Restante");

        jLabel8.setText("Valor da Parcela");

        jLabel9.setText("Valor Pago");

        tfValorAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorAPagarActionPerformed(evt);
            }
        });
        tfValorAPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValorAPagarKeyReleased(evt);
            }
        });

        jButton2.setText("Receber");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbDataHoje.setText("valor data Atual");

        jLabel1.setText("Caixa");

        cbCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        jLabel2.setText("Data Atual");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(tfNumParcelas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfVlrTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbDataHoje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfId, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfValorAPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(tfVlrParcela, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfVlrRestante, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfId, tfVenda});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfNumParcelas, tfValorAPagar, tfVencimento, tfVlrParcela, tfVlrRestante, tfVlrTotal});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbTop, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDataHoje)
                    .addComponent(jLabel1)
                    .addComponent(cbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(tfVlrTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVlrRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(tfNumParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVlrParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(tfVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
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

    private void tbTabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTabelaMousePressed
        preecherCampos();
        tfValorAPagar.requestFocus();
        tfValorAPagar.selectAll();
    }//GEN-LAST:event_tbTabelaMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (tfId.getText().isEmpty() && !cbCaixa.getSelectedItem().toString().equals("...")) {
                new Alertas().mensagemAviso("Selecione um Caixa!");
            } else {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja receber o pagamento?", "Pergunta",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                if (opcao == JOptionPane.YES_OPTION) {
                    ContasReceberEntity cre = new ContasReceberEntity();
                    NovaData nv = new NovaData();
                    cre.setQuantidadeParcelas(Integer.parseInt(tfNumParcelas.getText()));
                    cre.setContaID(Integer.parseInt(tfId.getText()));

                    if (tfValorAPagar.getText().contains("*")) {

                    } else {
                        cre.setVlrRestante(Double.parseDouble(tfVlrRestante.getText().replace(",", ".").replace(".", ""))
                                - Double.parseDouble(tfValorAPagar.getText().replace(",", ".").replace(".", "")));
                    }

                    cre.setDataVencimento(nv.adiciona1Mes(tfVencimento.getText()));
                    if (cre.getQuantidadeParcelas() == 1 || cre.getQuantidadeParcelas() < 1) {
                        cre.setQuantidadeParcelas(1);
                    } else {
                        cre.setQuantidadeParcelas(Integer.parseInt(tfNumParcelas.getText()) - 1);
                        System.out.println("Qnt.: " + cre.getQuantidadeParcelas());
                    }

                    if (cre.getQuantidadeParcelas() > 1) {
                        cre.setVlrParcelas((cre.getVlrRestante()) / cre.getQuantidadeParcelas());
                    } else {
                        cre.setVlrParcelas((cre.getVlrRestante()));
                    }
                    //
                    if (cre.getVlrRestante() == 0) {
                        contasDAO.alteraStatusVenda(Integer.parseInt(tfVenda.getText()));
                        contasDAO.excluirContaId(Integer.parseInt(tfId.getText()));
                        fluxoNovinhaNoGrau();
                        JOptionPane.showMessageDialog(null, "Baixa na parcela Realizada com sucesso!!!");
                    } else if (cre.getVlrRestante() < 0) {
                        new Alertas().mensagemAviso("Valor pago é maior que valor restante!");
                    } else {
                        contasDAO.darBaixaEmParc(cre);
                        fluxoNovinhaNoGrau();
                        JOptionPane.showMessageDialog(null, "Baixa na parcela Realizada com sucesso!!!");
                    }
                    limparCampos();
                    mostraPesquisa();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfValorAPagarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorAPagarKeyReleased
//        new ValidarCamposNumericos().validar(tfValorAPagar);
//        tfValorAPagar.setText(new Dinheiro().dinheiro(tfValorAPagar.getText()));
    }//GEN-LAST:event_tfValorAPagarKeyReleased

    private void tfValorAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorAPagarActionPerformed
//        String auxS = tfValorAPagar.getText().substring(tfValorAPagar.getText().indexOf("*")+1, (tfValorAPagar.getText().length()));
//        tfValorAPagar.setText(tfValorAPagar.getText().replace("*", ""));
//        System.out.println("auxS "+auxS);
        Double aux = Double.parseDouble(tfValorAPagar.getText().replace(",", "."));
        tfValorAPagar.setText(new DecimalFormat("0.00").format(aux).replace(",", "."));
    }//GEN-LAST:event_tfValorAPagarActionPerformed
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
            java.util.logging.Logger.getLogger(ContasReceberView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContasReceberView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContasReceberView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContasReceberView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContasReceberView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCaixa;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDataHoje;
    private javax.swing.JLabel lbTop;
    private javax.swing.JTable tbTabela;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNumParcelas;
    private javax.swing.JTextField tfValorAPagar;
    private javax.swing.JTextField tfVencimento;
    private javax.swing.JTextField tfVenda;
    private javax.swing.JTextField tfVlrParcela;
    private javax.swing.JTextField tfVlrRestante;
    private javax.swing.JTextField tfVlrTotal;
    // End of variables declaration//GEN-END:variables

    private void mostraPesquisa() {
        try {

            DefaultTableModel tabela = (DefaultTableModel) tbTabela.getModel();
            tabela.setNumRows(0);
            int cont = 0;
            contasList = contasDAO.listarContas(cli.getId());
            for (ContasReceberEntity cre : contasList) {
                tabela.addRow(new Object[]{cre.getVendaID(), "R$ " + new DecimalFormat("0.00").format(cre.
                    getVlrParcelas() / 100), "R$ " + new DecimalFormat("0.00").format(cre.getVlrRestante() / 100),
                    "R$ " + new DecimalFormat("0.00").format(cre.getVlrTotal() / 100), cre.getQuantidadeParcelas(), cre.getDataVencimento()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void preecherCampos() {
        int linha = tbTabela.getSelectedRow();
        ContasReceberEntity cre = new ContasReceberEntity();
        cre = contasList.get(linha);
        tfId.setText(cre.getContaID().toString());
        tfValorAPagar.setText(new DecimalFormat("0.00").format(Double.parseDouble(cre.getVlrParcelas().toString()) / 100));
        tfVencimento.setText(cre.getDataVencimento());
        tfVenda.setText(cre.getVendaID().toString());
        tfVlrParcela.setText(new DecimalFormat("0.00").format(Double.parseDouble(cre.getVlrParcelas().toString()) / 100));
        tfVlrRestante.setText(new DecimalFormat("0.00").format(Double.parseDouble(cre.getVlrRestante().toString()) / 100));
        tfVlrTotal.setText(new DecimalFormat("0.00").format(Double.parseDouble(cre.getVlrTotal().toString()) / 100));
        Integer aux = cre.getQuantidadeParcelas();
        tfNumParcelas.setText(aux.toString());
    }

    private void limparCampos() {
        tfId.setText("");
        tfNumParcelas.setText("");
        tfValorAPagar.setText("");
        tfVencimento.setText("");
        tfVenda.setText("");
        tfVlrParcela.setText("");
        tfVlrRestante.setText("");
        tfVlrTotal.setText("");
    }

    private void fluxoNovinhaNoGrau() {
        try {
            MovimentacaoEntity mov = new MovimentacaoEntity();
            mov.setIdVenda(Integer.parseInt(tfVenda.getText()));
            mov.setIdConta(Integer.parseInt(tfId.getText()));
            mov.setDescricao("RECEBIMENTO DE PARCELA");
            mov.setTipoMovimento("ENTRADA");
            mov.setValor(Double.valueOf(tfValorAPagar.getText().replace(",", ".").replace(".", "")));
            mov.setDataMovimento(lbDataHoje.getText());
            mov.setCaixa(cbCaixa.getSelectedItem().toString());

            mov.setIdContaPagar(0);
            mov.setIdEntrada(0);

            MovimentacaoDAO dao = new MovimentacaoDAO();
            dao.gravarEntrada(mov);
        } catch (Exception e) {
            new Alertas().mensagemErro("" + e);
            e.printStackTrace();
        }
    }

    public void preencherCBCaixa() {
        CaixaDAO caiDAO = new CaixaDAO();
        try {
            CaixaEntity cls = new CaixaEntity();
//            cbCaixa.addItem("...");
            for (String str : caiDAO.todosCaixaNome()) {
                cbCaixa.addItem(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
