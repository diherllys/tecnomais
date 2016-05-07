
package com.br.tecnomais.relatorios;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.LogomarcaDAO;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.InventarioEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class InventarioPorData extends javax.swing.JDialog {

    UsuarioEntity u;
    NovaData data = new NovaData();
    ConectaBanco con = new ConectaBanco();
    LogomarcaDAO dao = new LogomarcaDAO();
    FalcatruaDAO daoFalc = new FalcatruaDAO();

    /**
     * Creates new form EntradasPorData
     */
    public InventarioPorData(java.awt.Frame parent, boolean modal) {
        super(parent, false);
        con.conectar();
        initComponents();

        tfData.setEnabled(false);
        lbData.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        tfData = new javax.swing.JFormattedTextField();
        btGerarRelatorio = new javax.swing.JButton();
        cbInventario = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel2.setBackground(new java.awt.Color(170, 180, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Relatório de Movimentação Geral");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        lbData.setText("Data:");

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataActionPerformed(evt);
            }
        });

        btGerarRelatorio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btGerarRelatorio.setText("Gerar");
        btGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarRelatorioActionPerformed(evt);
            }
        });

        cbInventario.setText("Inventário por Data");
        cbInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbInventario)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btGerarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbInventario)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbData)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
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

    private void btGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarRelatorioActionPerformed
        try {
            String aux = dao.mostraLogomarca();
            if (aux.equals("") || aux.equals(null)) {
                String logoPadrao = "fund03376branc99o9954120.jpg";
                if (cbInventario.isSelected() == true) {
                    geraRelatorioPorData(logoPadrao);
                } else {
                    geraRelatorioGeral(logoPadrao);
                }

            } else {
                if (cbInventario.isSelected() == true) {
                    geraRelatorioPorData(aux);
                } else {
                    geraRelatorioGeral(aux);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btGerarRelatorioActionPerformed

    private void tfDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataActionPerformed

    }//GEN-LAST:event_tfDataActionPerformed

    private void cbInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInventarioActionPerformed
        if (cbInventario.isSelected() == true) {
            tfData.setEnabled(true);
        } else {
            tfData.setEnabled(false);
        }
    }//GEN-LAST:event_cbInventarioActionPerformed

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
            java.util.logging.Logger.getLogger(InventarioPorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioPorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioPorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioPorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InventarioPorData dialog = new InventarioPorData(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btGerarRelatorio;
    private javax.swing.JCheckBox cbInventario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JFormattedTextField tfData;
    // End of variables declaration//GEN-END:variables

    private void geraRelatorioGeral(String logomarca) {
        try {
            String dataI = tfData.getText();
            HashMap p = new HashMap();
            p.put("logomarca", "Logomarca/" + logomarca);
            p.put("dataInicial", tfData.getText());
            JasperPrint jp = JasperFillManager.fillReport("./relatorio/inventarioGeral.jasper", p, con.conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            new Alertas().mensagemErro("Erro ao imprimir relatorio: \n" + e);
        }
    }

    private void geraRelatorioPorData(String logomarca) {
        try {
            geraInventario();
            HashMap p = new HashMap();
            p.put("logomarca", "Logomarca/" + logomarca);
            p.put("data", tfData.getText());
            JasperPrint jp = JasperFillManager.fillReport("./relatorio/inventarioPorData.jasper", p, con.conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            daoFalc.deletaInventario();
        } catch (Exception e) {
            e.printStackTrace();
            new Alertas().mensagemErro("Erro ao imprimir relatorio: \n" + e);
        }
    }

    private void geraInventario() {
        try {
            String data = tfData.getText();
            JLabel dataAtual = new JLabel();
            this.data.dataAtual(dataAtual);
            List<InventarioEntity> lista = new ArrayList<>();
            for (ProdutosVendaEntity p : daoFalc.listaProdutosVendidos(data)) {
                for (ProdutosVendaEntity prod : daoFalc.listaEstoqueProdutos()) {
                    if (p.getCodigoProduto() == prod.getCodigoProduto()) {
                        InventarioEntity i = new InventarioEntity();
                        i.setCodigoProduto(prod.getCodigoProduto());
                        i.setQuantidade(prod.getQuantidade() + p.getQuantidade());
                        lista.add(i);
                    }
                }
            }
            for (InventarioEntity inv : lista) {
                daoFalc.geraInventarioTemporario(inv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
