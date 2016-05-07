package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.ContasReceberDAO;
import com.br.tecnomais.dao.MovimentacaoDAO;
import com.br.tecnomais.dao.ProdutoDAO;
import com.br.tecnomais.dao.ProdutosVendaDAO;
import com.br.tecnomais.dao.SaidasDAO;
import com.br.tecnomais.dao.VendaDAO;
import com.br.tecnomais.entity.MovimentacaoEntity;
import com.br.tecnomais.entity.ProdutoEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.SaidasEntity;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desenvolvimento
 */
public class SaidasView extends javax.swing.JFrame {

    SaidasDAO dao = new SaidasDAO();
    NovaData data = new NovaData();

    public SaidasView() {
        initComponents();
        preencherTabela();
        data.dataAtual(tfDataFinal);
        data.dataAtual(lbDataAtual);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaSaidas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDataInicial = new javax.swing.JFormattedTextField();
        tfDataFinal = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfCodigoVenda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfNomeCliente = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        tfVendaID = new javax.swing.JTextField();
        tfFormaPagamento = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        lbDataAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Saídas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        jtTabelaSaidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código da Venda", "Cliente", "Forma de Pagamento", "Valor", "Data da Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabelaSaidas.getTableHeader().setReorderingAllowed(false);
        jtTabelaSaidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtTabelaSaidasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabelaSaidas);
        if (jtTabelaSaidas.getColumnModel().getColumnCount() > 0) {
            jtTabelaSaidas.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtTabelaSaidas.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jLabel2.setText("Pesquisar:");

        jLabel3.setText("Data Inicial:");

        jLabel4.setText("Data Final:");

        try {
            tfDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Código da Venda:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Cliente:");

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Trocar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        lbDataAtual.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfNomeCliente))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 351, Short.MAX_VALUE)
                                        .addComponent(jButton3))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbDataAtual))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfVendaID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfDataFinal, tfDataInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton4, jButton5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDataAtual)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(tfVendaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfDataFinal, tfDataInicial});

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tfNomeCliente.getText().isEmpty()) {
            preencherTabela();
        } else {
            preencherTabelaPorCliente();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tfCodigoVenda.getText().isEmpty()) {
            new Alertas().mensagemErro("Forneço um código para pesquisar!");
        } else {
            preencherTabelaPorCodigoVenda();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preencherTabelaPorData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtTabelaSaidasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaSaidasMousePressed
        int linha = jtTabelaSaidas.getSelectedRow();
        tfVendaID.setText(jtTabelaSaidas.getValueAt(linha, 0).toString());
        tfFormaPagamento.setText(jtTabelaSaidas.getValueAt(linha, 2).toString());
        tfValor.setText(jtTabelaSaidas.getValueAt(linha, 3).toString().replace("R$", ""));
    }//GEN-LAST:event_jtTabelaSaidasMousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (tfFormaPagamento.getText().equals("PARCELADO")) {
            cancelarVenda();
            cancelarConta();
            cancelarMovimentacao();
            preencherTabela();
        } else {
            cancelarVenda();
            cancelarMovimentacao();
            preencherTabela();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (tfVendaID.getText().isEmpty()) {
            new Alertas().mensagemAviso("Selecione uma venda!");
        } else {
            int codigoVenda = Integer.valueOf(tfVendaID.getText());
//            new TrocaProdutos(codigoVenda).setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(SaidasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaidasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaidasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaidasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaidasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtTabelaSaidas;
    private javax.swing.JLabel lbDataAtual;
    private javax.swing.JTextField tfCodigoVenda;
    private javax.swing.JFormattedTextField tfDataFinal;
    private javax.swing.JFormattedTextField tfDataInicial;
    private javax.swing.JTextField tfFormaPagamento;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfValor;
    private javax.swing.JTextField tfVendaID;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jtTabelaSaidas.getModel();
            tb.setNumRows(0);
            for (SaidasEntity s : dao.listaSaidasAvista()) {
                tb.addRow(new Object[]{s.getIdVenda(), s.getNomeCliente(), s.getFormaPagamento(), "R$ " + new DecimalFormat("0.00").format(s.getValor()), s.getDataVenda()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorCliente() {
        String consulta = tfNomeCliente.getText() + "%";
        try {
            DefaultTableModel tb = (DefaultTableModel) jtTabelaSaidas.getModel();
            tb.setNumRows(0);
            for (SaidasEntity s : dao.consultaSaidasPorCliente(consulta)) {
                tb.addRow(new Object[]{s.getIdVenda(), s.getNomeCliente(), s.getFormaPagamento(), "R$ " + new DecimalFormat("0.00").format(s.getValor()), s.getDataVenda()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorCodigoVenda() {
        int codigo = Integer.valueOf(tfCodigoVenda.getText());
        try {
            DefaultTableModel tb = (DefaultTableModel) jtTabelaSaidas.getModel();
            tb.setNumRows(0);
            for (SaidasEntity s : dao.consultaSaidasPorCodigoVenda(codigo)) {
                tb.addRow(new Object[]{s.getIdVenda(), s.getNomeCliente(), s.getFormaPagamento(), "R$ " + new DecimalFormat("0.00").format(s.getValor()), s.getDataVenda()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorData() {
        String dataInicial = tfDataInicial.getText();
        String dataFinal = tfDataFinal.getText();
        try {
            DefaultTableModel tb = (DefaultTableModel) jtTabelaSaidas.getModel();
            tb.setNumRows(0);
            for (SaidasEntity s : dao.consultaSaidasPorDataVenda(dataInicial, dataFinal)) {
                tb.addRow(new Object[]{s.getIdVenda(), s.getNomeCliente(), s.getFormaPagamento(), "R$ " + new DecimalFormat("0.00").format(s.getValor()), s.getDataVenda()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cancelarVenda() {
        try {
            if (tfVendaID.getText().isEmpty()) {
                new Alertas().mensagemAviso("Selecione uma venda para cancelá-la!");
            } else {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a venda?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                if (opcao == JOptionPane.YES_OPTION) {
                    atualizaEstoque();
                    excluirProdutosVendidos();
                    excluirVenda();
                    new Alertas().mensagemConfirmacao("Venda cancelada com sucesso!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizaEstoque() {
        try {
            ProdutosVendaDAO dao = new ProdutosVendaDAO();
            int codigoVenda = Integer.parseInt(tfVendaID.getText());
            for (ProdutosVendaEntity prod : dao.listaProdutosDaVenda(codigoVenda)) {
                ProdutoEntity p = new ProdutoEntity();
                p.setId(prod.getCodigoProduto());
                p.setQntAtual(prod.getQuantidade());
                ProdutoDAO pd = new ProdutoDAO();
                pd.atualizarEstoqueProdutos(p);
            }
        } catch (Exception e) {
            new Alertas().mensagemErro("Erro ao tentar atualizar o estoque!");
        }
    }

    private void excluirProdutosVendidos() {
        try {
            ProdutosVendaDAO dao = new ProdutosVendaDAO();
            int codigo = Integer.valueOf(tfVendaID.getText());
            dao.excluirProdutosVendidos(codigo);
        } catch (Exception e) {
            new Alertas().mensagemErro("Erro ao tentar excluir os produtos vendidos!");
        }
    }

    private void excluirVenda() {
        try {
            VendaDAO dao = new VendaDAO();
            int codigo = Integer.valueOf(tfVendaID.getText());
            dao.cancelarVenda(codigo);
        } catch (Exception e) {
            new Alertas().mensagemErro("Erro ao tentar excluir a venda!");
        }
    }

    private void cancelarConta() {
        try {
            ContasReceberDAO dao = new ContasReceberDAO();
            int codigo = Integer.valueOf(tfVendaID.getText());
            dao.excluirConta(codigo);
        } catch (Exception e) {
            new Alertas().mensagemErro("Erro ao tentar excluir a conta!");
        }
    }
    private void cancelarMovimentacao() {
        try {
            MovimentacaoEntity c = new MovimentacaoEntity();
            c.setDescricao("Cancelamento de venda!");
            c.setValor(-Double.valueOf(tfValor.getText().replace(",", ".").replace(".", "")));
            c.setTipoMovimento("Saida");
            c.setDataMovimento(lbDataAtual.getText());
            c.setIdVenda(0);
            c.setIdConta(0);
            MovimentacaoDAO dao = new MovimentacaoDAO();
            dao.inserirValorMovimentacao(c);
        } catch (Exception e) {
            new Alertas().mensagemErro("Erro ao lancar a movimentação!");
            e.printStackTrace();
        }
    }
}
