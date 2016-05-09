package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.CaixaDAO;
import com.br.tecnomais.dao.MovimentacaoDAO;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.MovimentacaoEntity;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class FluxoMovimentacao extends javax.swing.JFrame {

    MovimentacaoDAO dao = new MovimentacaoDAO();
    NovaData n = new NovaData();
    Double vlrTotalEntrada = 0.00;
    Double vlrTotalSaida = 0.00;

    /**
     * Creates new form FluxoMovimentacao
     */
    public FluxoMovimentacao() {
        initComponents();
        preencherTabela();
        setValorTotal();
        setValorEntrada();
        setValorSaida();
        n.dataAtual(tfDataFinal);
        preencherCBCaixa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbEntradas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSaida = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDataInicial = new javax.swing.JFormattedTextField();
        tfDataFinal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        cbCaixa = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cbTipoMov = new javax.swing.JComboBox();
        cbFormaPag = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel2.setBackground(new java.awt.Color(170, 180, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fluxo de Caixa");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Movimento", "Descrição", "Tipo de Movimento", "Valor", "Data Movimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Vlr Total:");

        lbTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(0, 153, 0));
        lbTotal.setText("0,00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Total de Entradas:");

        lbEntradas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbEntradas.setForeground(new java.awt.Color(0, 102, 255));
        lbEntradas.setText("0,00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Total de Saídas:");

        lbSaida.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbSaida.setForeground(new java.awt.Color(255, 0, 0));
        lbSaida.setText("0,00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Pesquisar:");

        jLabel5.setText("Data Inicial:");

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

        jLabel7.setText("Data Final:");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Descrição:");

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));
        cbCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCaixaActionPerformed(evt);
            }
        });

        jLabel9.setText("Caixa:");

        cbTipoMov.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "ENTRADA", "SAIDA" }));

        cbFormaPag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "DINHEIRO", "PARCELADO", "CARTAO CREDITO", "CARTAO DEBITO" }));

        jLabel10.setText("Tipo Movimentação:");

        jLabel11.setText("Forma de Pagamento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(23, 23, 23)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbTipoMov, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton2))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jButton2))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbTotal)
                    .addComponent(jLabel4)
                    .addComponent(lbEntradas)
                    .addComponent(jLabel6)
                    .addComponent(lbSaida))
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        jMenuItem1.setText("Lançar Entrada");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Lançar Saída");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Atualizar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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
        if (tfDataInicial.getText().contains(" ") || tfDataFinal.getText().contains(" ")) {
            new Alertas().mensagemAviso("Preencha os campos das datas!");
        } else {
            preencherTabelaPorData();
            setValorEntradaPorData();
            setValorSaidaPorData();
            setValorTotalPorData();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        preencherTabela();
        setValorTotal();
        setValorEntrada();
        setValorSaida();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        preencherTabelaPorDescricao();
        preencherTabelaPorFiltros();
//        setValorSaidaPorDescricao();
//        setValorEntradaPorDescricao();
//        setValorTotalPorDescricao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new LancaSaidaView().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new LancaEntradaView().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cbCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCaixaActionPerformed
        preencherTabelaPorFiltros();
        setValorSaidaPorDescricao();
        setValorEntradaPorDescricao();
        setValorTotalPorDescricao();
    }//GEN-LAST:event_cbCaixaActionPerformed

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
            java.util.logging.Logger.getLogger(FluxoMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FluxoMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FluxoMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FluxoMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FluxoMovimentacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCaixa;
    private javax.swing.JComboBox cbFormaPag;
    private javax.swing.JComboBox cbTipoMov;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbEntradas;
    private javax.swing.JLabel lbSaida;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JFormattedTextField tfDataFinal;
    private javax.swing.JFormattedTextField tfDataInicial;
    private javax.swing.JTextField tfDescricao;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setNumRows(0);
            for (MovimentacaoEntity mov : dao.listaFluxoCaixa()) {
//                if (mov.getTipoMovimento().equals("Entrada")) {
                tb.addRow(new Object[]{mov.getIdMovimento(), mov.getDescricao(), mov.getTipoMovimento(), "R$ " + new DecimalFormat("0.00").format(mov.getValor()), mov.getDataMovimento()});
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValorEntrada() {
        try {
            lbEntradas.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorTotalEntradas()));
        } catch (Exception e) {
            new Alertas().mensagemErro("" + e);
        }
    }

    private void setValorTotal() {
        try {
            System.out.println(dao.getValorSaidas());
            lbTotal.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorTotalEntradas() + dao.getValorSaidas()));
        } catch (Exception e) {
            new Alertas().mensagemErro("" + e);
        }
    }

    private void setValorSaida() {
        try {
            System.out.println(dao.getValorSaidas());
            lbSaida.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorSaidas()).replace("-", ""));
        } catch (Exception e) {
            new Alertas().mensagemErro("" + e);
        }
    }

    private void preencherTabelaPorData() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setNumRows(0);
            String dataI = tfDataInicial.getText();
            String dataF = tfDataFinal.getText();
            for (MovimentacaoEntity mov : dao.consultaPorData(dataI, dataF)) {
//                if (mov.getTipoMovimento().equals("Entrada")) {
                tb.addRow(new Object[]{mov.getIdMovimento(), mov.getDescricao(), mov.getTipoMovimento(), "R$ " + new DecimalFormat("0.00").format(mov.getValor()), mov.getDataMovimento()});
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValorEntradaPorData() {
        try {
            String dataI = tfDataInicial.getText();
            String dataF = tfDataFinal.getText();
            lbEntradas.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorEntradaPorData(dataI, dataF)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValorSaidaPorData() {
        try {
            String dataI = tfDataInicial.getText();
            String dataF = tfDataFinal.getText();
            lbSaida.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorSaidaPorData(dataI, dataF)).replace("-", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValorTotalPorData() {
        try {
            String dataI = tfDataInicial.getText();
            String dataF = tfDataFinal.getText();
            lbTotal.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorEntradaPorData(dataI, dataF) + dao.getValorSaidaPorData(dataI, dataF)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorDescricao() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setNumRows(0);
            String descricao = tfDescricao.getText() + "%";
            for (MovimentacaoEntity mov : dao.consultaPorDescricao(descricao)) {
//                if (mov.getTipoMovimento().equals("Entrada")) {
                tb.addRow(new Object[]{mov.getIdMovimento(), mov.getDescricao(), mov.getTipoMovimento(), "R$ " + new DecimalFormat("0.00").format(mov.getValor()), mov.getDataMovimento()});
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaPorFiltros() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setNumRows(0);
            String descricao = "";
            String caixa = "";
            String tipoPag = "";
            String tipoMov = "";
            String dataInicial = "01/01/1950";
            String dataFinal = "25/12/2090";

            if (!cbCaixa.getSelectedItem().toString().equals("...")) {
                caixa = cbCaixa.getSelectedItem().toString();
            }

            if (!cbTipoMov.getSelectedItem().toString().equals("...")) {
                tipoMov = cbTipoMov.getSelectedItem().toString();
            }

            if (!cbFormaPag.getSelectedItem().toString().equals("...")) {
                tipoPag = cbFormaPag.getSelectedItem().toString();
            }

            if (!tfDescricao.getText().equals("")) {
                descricao = tfDescricao.getText();
            }

            if (!tfDataInicial.getText().contains(" ")) {
                dataInicial = tfDataInicial.getText();
            }

            if (!tfDataFinal.getText().contains(" ")) {
                dataFinal = tfDataFinal.getText();
            }

            vlrTotalEntrada = 0.00;
            vlrTotalSaida = 0.00;
            for (MovimentacaoEntity mov : dao.consultarPorFiltro("%" + descricao + "%",
                    "%" + caixa + "%", "%" + tipoPag + "%", "%" + tipoMov + "%",
                    dataInicial, dataFinal)) {
//                if (mov.getTipoMovimento().equals("Entrada")) {
                tb.addRow(new Object[]{mov.getIdMovimento(), mov.getDescricao(), mov.getTipoMovimento(), "R$ " + new DecimalFormat("0.00").format(mov.getValor()), mov.getDataMovimento()});
//                }
                if (mov.getTipoMovimento().equals("ENTRADA")) {
                    vlrTotalEntrada = vlrTotalEntrada + mov.getValor();
                }
                if (mov.getTipoMovimento().equals("SAIDA")) {
                    vlrTotalSaida = vlrTotalSaida + mov.getValor();
                }
            }
            lbEntradas.setText(new DecimalFormat("0.00").format(vlrTotalEntrada));
            lbSaida.setText(new DecimalFormat("0.00").format(vlrTotalSaida));
            lbTotal.setText(new DecimalFormat("0.00").format(vlrTotalEntrada- (-vlrTotalSaida)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValorSaidaPorDescricao() {
        try {
            String descricao = tfDescricao.getText() + "%";
            lbSaida.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorSaidaPorDescricao(descricao)).replace("-", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValorEntradaPorDescricao() {
        try {
            String descricao = tfDescricao.getText() + "%";
            lbEntradas.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorEntradaPorDescricao(descricao)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValorTotalPorDescricao() {
        try {
            String descricao = tfDescricao.getText() + "%";
            lbTotal.setText("R$ " + new DecimalFormat("0.00").format(dao.getValorEntradaPorDescricao(descricao) + dao.getValorSaidaPorDescricao(descricao)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherCBCaixa() {
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
