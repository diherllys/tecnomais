/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.relatorios;

import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.EntradaDAO;
import com.br.tecnomais.dao.LogomarcaDAO;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.EntradasEntity;
import com.br.tecnomais.entity.ProdutosEntradaEntity;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class MovimentacaoEntradaPrt extends javax.swing.JDialog {

    EntradaDAO entradaDAO = new EntradaDAO();
    List<EntradasEntity> listEE = new ArrayList();
    ConectaBanco con = new ConectaBanco();
    LogomarcaDAO dao = new LogomarcaDAO();
    NovaData data = new NovaData();
    int entradaId=0;
            /**
             * Creates new form MovimentacaoEntradaPrt
             */

    public MovimentacaoEntradaPrt(java.awt.Frame parent, boolean modal) {
        super(parent, false);
        initComponents();
        con.conectar();
        data.dataAtual(tfDataInicial);
        data.dataAtual(tfDataFinal);

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEntradas = new javax.swing.JTable();
        tfPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfDataInicial = new javax.swing.JFormattedTextField();
        tfDataFinal = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório de Entradas de Produtos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        tbEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sequência ", "Fornecedor", "Caixa", "Operação", "Vlr Total", "Status", "Data"
            }
        ));
        tbEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbEntradasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbEntradas);

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

        jLabel2.setText("Data Inicial");

        jLabel3.setText("Data Final");

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
        tfDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataFinalActionPerformed(evt);
            }
        });

        jButton2.setText("Relátorio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição Produto", "Quantidade", "Preço Unitário", "Preço Total", "Desconto R$", "Preço Final"
            }
        ));
        jScrollPane2.setViewportView(tbProdutos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfPesquisa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        if (!tfPesquisa.getText().isEmpty()) {
            pesquisar();
        } else if (!tfPesquisa.getText().isEmpty() && (!tfDataFinal.getText().isEmpty() && !tfDataInicial.getText().isEmpty())) {
            pesquisarPorDataDescricao();
        } else {
//            pesquisarPorData();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbEntradasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEntradasMousePressed
        int linha = tbEntradas.getSelectedRow();
        entradaId = Integer.parseInt(tbEntradas.getValueAt(linha, 0).toString());
        preencherTabelaProdutos(entradaId);
    }//GEN-LAST:event_tbEntradasMousePressed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        if (!tfPesquisa.getText().isEmpty()) {
            pesquisar();
        } else if (!tfPesquisa.getText().isEmpty() && (!tfDataFinal.getText().isEmpty() && !tfDataInicial.getText().isEmpty())) {
            pesquisarPorDataDescricao();
        } else {
//            pesquisarPorData();
        }
    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void tfDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataFinalActionPerformed
        if (!tfPesquisa.getText().isEmpty()) {
            pesquisar();
        } else if (tfPesquisa.getText().isEmpty()) {
            pesquisarPorData();
        } else {
//            pesquisarPorData();
        }
    }//GEN-LAST:event_tfDataFinalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            String aux = dao.mostraLogomarca();
            if (aux.equals("") || aux.equals(null)) {
                aux = "fund03376branc99o9954120.jpg";
            }
            if (!tfPesquisa.getText().isEmpty()) {
                HashMap p = new HashMap();
                p.put("logomarca", "Logomarca/" + aux);
                p.put("entradaId", entradaId);
                JasperPrint jp = JasperFillManager.fillReport("./relatorio/entradaDeProdutosEspecificos.jasper", p, con.conn);
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            } else if (tfPesquisa.getText().isEmpty()) {
                String dataI = tfDataInicial.getText();
                String dataF = tfDataFinal.getText();
                HashMap p = new HashMap();
                p.put("logomarca", "Logomarca/" + aux);
                p.put("dataInicial", dataI);
                p.put("dataFinal", dataF);
                JasperPrint jp = JasperFillManager.fillReport("./relatorio/entradaDeProdutosPorData.jasper", p, con.conn);
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovimentacaoEntradaPrt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(MovimentacaoEntradaPrt.class.getName()).log(Level.SEVERE, null, ex);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoEntradaPrt.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoEntradaPrt.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoEntradaPrt.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoEntradaPrt.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MovimentacaoEntradaPrt dialog = new MovimentacaoEntradaPrt(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbEntradas;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JFormattedTextField tfDataFinal;
    private javax.swing.JFormattedTextField tfDataInicial;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        try {
            listEE.clear();
            String aux = tfPesquisa.getText();
            if (tfPesquisa.getText().isEmpty()) {
                aux = "0";
            }
            for (EntradasEntity ee : entradaDAO.retornaEntrada(aux)) {
                listEE.add(ee);
            }
            preencherTabelaEntrada(listEE);

        } catch (Exception ex) {
            Logger.getLogger(MovimentacaoEntradaPrt.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pesquisarPorDataDescricao() {

    }

    private void pesquisarPorData() {
        try {
            listEE.clear();
            for (EntradasEntity ee : entradaDAO.retornaEntradaPorData(tfDataInicial.getText(), tfDataFinal.getText())) {
                listEE.add(ee);
            }
            preencherTabelaEntrada(listEE);

        } catch (Exception ex) {
            Logger.getLogger(MovimentacaoEntradaPrt.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherTabelaEntrada(List<EntradasEntity> listEE) {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbEntradas.getModel();
            tb.setNumRows(0);
            for (EntradasEntity ee : listEE) {
                tb.addRow(new Object[]{ee.getCodigoEntrada(), ee.getFornecedor(),
                    ee.getCaixa(), ee.getOperacao(), "R$ " + new DecimalFormat("0.00").format(ee.getVlrTotal() / 100), ee.getStatus(), ee.getDataEntrada()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherTabelaProdutos(int codigoEntrada) {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbProdutos.getModel();
            tb.setNumRows(0);
            for (ProdutosEntradaEntity pee : entradaDAO.retornaPrtEntradas(codigoEntrada)) {
                tb.addRow(new Object[]{pee.getCodigoProduto(), pee.getProdutoServico(), new DecimalFormat("0.00").format(pee.getQuantidade()), "R$ " + new DecimalFormat("0.00").format(pee.getPrecoUnitario() / 100), "R$ " + new DecimalFormat("0.00").format(pee.getPrecoTotal() / 100), "R$ " + new DecimalFormat("0.00").format(pee.getDescontoReal()), "R$ " + new DecimalFormat("0.00").format(pee.getPrecoFinal() / 100)});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
