package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.MovimentacaoDAO;
import com.br.tecnomais.dao.VendaDAO;
import com.br.tecnomais.entity.BuscarVendaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.MovimentacaoEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TrocaProdutos extends javax.swing.JFrame {

    /**
     * Creates new form TrocaProdutos
     */
    private VendaDAO dao = new VendaDAO();
    private ClienteEntity cliente = new ClienteEntity();
    private VendasView vendaView;
    private VendaEntity venda;
    private String forma1;
    private String forma2;
    private String forma3;
    private JLabel lbData = new JLabel();
    private NovaData data = new NovaData();
    private MovimentacaoDAO daoMovimentacao = new MovimentacaoDAO();
    private List<ProdutosVendaEntity> lista;

    public TrocaProdutos(VendaEntity venda, List<ProdutosVendaEntity> lista, VendasView vendaView) {
        initComponents();
        preencherTabela();
        this.venda = venda;
        this.vendaView = vendaView;
        this.lista = lista;
        lbNovoValor.setText(new DecimalFormat("0.00").format(venda.getVlrTotal() / 100));
        data.dataAtual(lbData);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lbNumeroCupom = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbNovoValor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfNumeroCupom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfNomeCliente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        tfDiferenca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbDinheiro = new javax.swing.JRadioButton();
        rbCartaoCredito = new javax.swing.JRadioButton();
        rbCartaoDebito = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        lbValorAnterior = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Troca de Produtos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° do Cupom", "Cliente", "Valor Total", "Data da Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("N° do Cupom:");

        lbNumeroCupom.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Novo Valor;");

        lbNovoValor.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbNovoValor.setText("jLabel5");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Efetivar Troca [F12]");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Nº do Cupom:");

        tfNumeroCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroCupomActionPerformed(evt);
            }
        });

        jLabel7.setText("Cliente:");

        tfNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeClienteActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setText("Diferença(R$):");

        tfDiferenca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfDiferenca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setText("Forma de Pagamento:");

        buttonGroup1.add(rbDinheiro);
        rbDinheiro.setText("DINHEIRO");
        rbDinheiro.setOpaque(false);

        buttonGroup1.add(rbCartaoCredito);
        rbCartaoCredito.setText("CARTAO CREDITO");
        rbCartaoCredito.setOpaque(false);

        buttonGroup1.add(rbCartaoDebito);
        rbCartaoDebito.setText("CARTAO DEBITO");
        rbCartaoDebito.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel10.setText("Valor Anterior:");

        lbValorAnterior.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumeroCupom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeCliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(lbNovoValor)
                            .addComponent(jButton1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(lbNumeroCupom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbValorAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(tfDiferenca, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbDinheiro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbCartaoCredito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbCartaoDebito)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNumeroCupom, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNovoValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(4, 4, 4)
                                .addComponent(lbValorAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDiferenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel9)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbDinheiro)
                                    .addComponent(rbCartaoCredito)
                                    .addComponent(rbCartaoDebito))))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNumeroCupom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

    private void tfNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeClienteActionPerformed
        preencherTabelaPorNomeCliente();
    }//GEN-LAST:event_tfNomeClienteActionPerformed

    private void tfNumeroCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroCupomActionPerformed
        preencherTabelaPorNumeroCupom();
    }//GEN-LAST:event_tfNumeroCupomActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        try {
            int linha = jTable1.getSelectedRow();
            int codigoVenda = Integer.parseInt(jTable1.getValueAt(linha, 0).toString());
            for (BuscarVendaEntity bu : dao.listaTodasVendasPorNumeroCupom(codigoVenda)) {
                forma1 = bu.getVenda().getFormaPagamento();
                forma2 = bu.getVenda().getFormaPagamento2();
                forma3 = bu.getVenda().getFormaPagamento3();
                lbNumeroCupom.setText(bu.getVenda().getId().toString());
                lbValorAnterior.setText(new DecimalFormat("0.00").format(bu.getVenda().getVlrTotal()));
                tfDiferenca.setText(new DecimalFormat("0.00").format(calculaValorDiferenca(bu.getVenda().getVlrTotal())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double diferenca = Double.valueOf(tfDiferenca.getText().replace(",", "."));
        if (diferenca == 0.0) {

        } else if (diferenca > 0.0) {
            efetivaTroca();
        } else {
            new Alertas().mensagemErro("Não é possível realizar troca de produtos com o valor menor do que da venda anterior!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TrocaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrocaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrocaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrocaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrocaProdutos(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbNovoValor;
    private javax.swing.JLabel lbNumeroCupom;
    private javax.swing.JLabel lbValorAnterior;
    private javax.swing.JRadioButton rbCartaoCredito;
    private javax.swing.JRadioButton rbCartaoDebito;
    private javax.swing.JRadioButton rbDinheiro;
    private javax.swing.JTextField tfDiferenca;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfNumeroCupom;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setNumRows(0);
            for (BuscarVendaEntity b : dao.listaTodasVendas()) {
                tb.addRow(new Object[]{b.getVenda().getId(), b.getCliente().getNome(), new DecimalFormat("0.00").format(b.getVenda().getVlrTotal()), b.getVenda().getDataVenda()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alertas().mensagemErro("" + e);
        }
    }

    private void preencherTabelaPorNomeCliente() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setNumRows(0);
            String nome = tfNomeCliente.getText() + "%";
            for (BuscarVendaEntity b : dao.listaTodasVendasPorNomeCliente(nome)) {
                tb.addRow(new Object[]{b.getVenda().getId(), b.getCliente().getNome(), new DecimalFormat("0.00").format(b.getVenda().getVlrTotal()), b.getVenda().getDataVenda()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alertas().mensagemErro("" + e);
        }
    }

    private void preencherTabelaPorNumeroCupom() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setNumRows(0);
            int numeroCupom = Integer.valueOf(tfNumeroCupom.getText());
            for (BuscarVendaEntity b : dao.listaTodasVendasPorNumeroCupom(numeroCupom)) {
                tb.addRow(new Object[]{b.getVenda().getId(), b.getCliente().getNome(), new DecimalFormat("0.00").format(b.getVenda().getVlrTotal()), b.getVenda().getDataVenda()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alertas().mensagemErro("Erro: número inválido!");
        }
    }

    public void limpaVenda() {
        vendaView.apagarLista();
    }

    private void efetivaTroca() {
        if (rbDinheiro.isSelected() == true) {
            atualizaDadosVenda(1);
        } else if (rbCartaoCredito.isSelected() == true) {
            atualizaDadosVenda(2);
        } else if (rbCartaoDebito.isSelected() == true) {
            atualizaDadosVenda(3);
        }
    }

    private void atualizaDadosVenda(int index) {
        try {
            venda.setId(Integer.parseInt(lbNumeroCupom.getText()));
            double diferença = Double.parseDouble(tfDiferenca.getText().replace(",", ".").replace(".", ""));
            if (index == 1 && forma1.equals("DINHEIRO")) {
                dao.trocaValorVendaForma1(venda, forma1, diferença);
            } else if (index == 1 && !forma1.equals("DINHEIRO") && forma2.equals("DINHEIRO") || forma2.equals("")) {
                forma2 = rbDinheiro.getText();
                dao.trocaValorVendaForma2(venda, forma2, diferença);
            } else if (index == 2 && forma1.equals("CARTAO CREDITO")) {
                dao.trocaValorVendaForma1(venda, forma1, diferença);
            } else if ((index == 2 && forma2.equals("CARTAO CREDITO")) || (index == 2 && forma2.equals(""))) {
                forma2 = rbCartaoCredito.getText();
                dao.trocaValorVendaForma2(venda, forma2, diferença);
            } else if ((index == 2 && forma3.equals("CARTAO CREDITO")) || (index == 2 && forma3.equals(""))) {
                forma3 = rbCartaoCredito.getText();
                dao.trocaValorVendaForma3(venda, forma3, diferença);
            } else if (index == 3 && forma1.equals("CARTAO DEBITO")) {
                dao.trocaValorVendaForma1(venda, forma1, diferença);
            } else if ((index == 3 && forma2.equals("CARTAO DEBITO")) || (index == 3 && forma2.equals(""))) {
                forma2 = rbCartaoDebito.getText();
                dao.trocaValorVendaForma2(venda, forma2, diferença);
            } else if ((index == 3 && forma3.equals("CARTAO DEBITO")) || (index == 3 && forma3.equals(""))) {
                forma3 = rbCartaoDebito.getText();
                dao.trocaValorVendaForma3(venda, forma3, diferença);
            }
            gravarEntrada();
            cancelarProdutosVendidos();
            limpaVenda();
            this.dispose();
            new Alertas().mensagemConfirmacao("A venda foi trocada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            new Alertas().mensagemErro("" + e);
        }
    }

    private double calculaValorDiferenca(double valorAntigo) {
        double diferenca = (venda.getVlrTotal() / 100) - valorAntigo;
        return diferenca;
    }

    private void gravarEntrada() {
        try {
            VendaDAO daoVenda = new VendaDAO();
            int codigoVenda = Integer.parseInt(lbNumeroCupom.getText());
            System.out.println("Codigo: " + codigoVenda);
            MovimentacaoEntity mov = new MovimentacaoEntity();
            mov.setIdVenda(codigoVenda);
            mov.setIdConta(0);
            mov.setIdEntrada(0);
            mov.setIdContaPagar(0);
            mov.setTipoDePagamento(rbCartaoCredito.getText().toString());
            mov.setCaixa(venda.getCaixa());
//            mov.set
            mov.setDescricao("TROCA DE PRODUTOS");
            mov.setTipoMovimento("ENTRADA");
            mov.setValor(Double.valueOf(tfDiferenca.getText().replace(",", ".").replace(".", "")));
            mov.setDataMovimento(lbData.getText());
            daoMovimentacao.gravarEntrada(mov);
        } catch (Exception e) {
            e.printStackTrace();
            new Alertas().mensagemErro("" + e);
        }
    }

    private void cancelarProdutosVendidos() {
        try {
            dao.cancelarProdutosVendidos(Integer.valueOf(lbNumeroCupom.getText()));
            for (ProdutosVendaEntity p : lista) {
                dao.lancarNovosProdutosVendidos(p, Integer.parseInt(lbNumeroCupom.getText()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
