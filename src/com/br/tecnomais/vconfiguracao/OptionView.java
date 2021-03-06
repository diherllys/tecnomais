/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vconfiguracao;

import com.br.tecnomais.dao.LogomarcaDAO;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.relatorios.RelatorioContasReceber;
import com.br.tecnomais.relatorios.SaidasPorDataView;
import com.br.tecnomais.relatorios.SelecionaClienteContasView;
import com.br.tecnomais.relatorios.SelecionaClienteEspecificoView;
import com.br.tecnomais.relatorios.SelecionaFornecedorEspecificoView;
import com.br.tecnomais.relatorios.SelecionaProdutoEspecificoView;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Desenvolvimento
 */
public class OptionView extends javax.swing.JFrame {
    
    ConectaBanco con = new ConectaBanco();
    String metodo;
    String s1;
    String s2;

    /**
     * Creates new form OptionView
     */
    public OptionView(String s1, String s2, String metodo) {
        initComponents();
        jButton1.setText(s1);
        jButton2.setText(s2);
        this.metodo = metodo;
        this.s1 = s1;
        this.s2 = s2;
        con.conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbIcone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecione uma Opção");
        setFocusTraversalPolicyProvider(true);
        setFocusable(false);
        setResizable(false);

        jButton1.setText("Todos os Clientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clientes Específico");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Question-50px black.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbIcone)
                .addContainerGap(284, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcone, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        metodo = jButton1.getText();
        metodo(metodo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        metodo = jButton2.getText();
        metodo(metodo);
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
            java.util.logging.Logger.getLogger(OptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionView(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lbIcone;
    // End of variables declaration//GEN-END:variables

    private void metodo(String metodo) {
        
        try {
            LogomarcaDAO dao = new LogomarcaDAO();
            String aux = dao.mostraLogomarca();
            
            if (metodo.equals("Todos os Clientes")) {
                HashMap parametros = new HashMap();
                if (aux == null || aux == "") {
                    parametros.put("logomarca", "Logomarca/fund03376branc99o9954120.jpg");
                    
                } else {
                    parametros.put("logomarca", "Logomarca/" + aux);
                }
                
                JasperPrint jp;
                jp = JasperFillManager.fillReport("./relatorio/clienteGeral.jasper", parametros, con.conn);
                JasperViewer jrv = new JasperViewer(jp, false);//segundo paremetro fechar ou não programa tipo exit_on_close ou dispose
                jrv.setVisible(true);
                this.dispose();
            }
            
            if (metodo.equals("Cliente Específico")) {
                new SelecionaClienteEspecificoView(null, true, null).setVisible(true);
                this.dispose();
            }
            
            if (metodo.equals("Todos os Produtos")) {
                HashMap parametros = new HashMap();
                if (aux == null || aux == "") {
                    parametros.put("logomarca", "Logomarca/fund03376branc99o9954120.jpg");
                    
                } else {
                    parametros.put("logomarca", "Logomarca/" + aux);
                }
                
                JasperPrint jp;
                jp = JasperFillManager.fillReport("./relatorio/produtosCadastrado.jasper", parametros, con.conn);
                JasperViewer jrv = new JasperViewer(jp, false);//segundo paremetro fechar ou não programa tipo exit_on_close ou dispose
                jrv.setVisible(true);
                this.dispose();
            }
            
            if (metodo.equals("Produto Específico")) {
                new SelecionaProdutoEspecificoView(null, null).setVisible(true);
                this.dispose();
            }
            
            if (metodo.equals("Todos os Fornecedores")) {
                HashMap parametros = new HashMap();
                if (aux == null || aux == "") {
                    parametros.put("logomarca", "Logomarca/fund03376branc99o9954120.jpg");
                    
                } else {
                    parametros.put("logomarca", "Logomarca/" + aux);
                }
                
                JasperPrint jp;
                jp = JasperFillManager.fillReport("./relatorio/fornecedorGeral.jasper", parametros, con.conn);
                JasperViewer jrv = new JasperViewer(jp, false);//segundo paremetro fechar ou não programa tipo exit_on_close ou dispose
                jrv.setVisible(true);
                this.dispose();
            }
            
            if (metodo.equals("Fornecedor Específico")) {
                new SelecionaFornecedorEspecificoView(null, true, null).setVisible(true);
                this.dispose();
            }
            
            if (metodo.equals("Todas as Entradas")) {
                new SelecionaFornecedorEspecificoView(null, true, null).setVisible(true);
                this.dispose();
            }
            
            if (metodo.equals("Entradas por Data")) {
//                new SaidasPorDataView(null, true).setVisible(true);
                this.dispose();
            }
            
            if (metodo.equals("Contas Por Data")) {
                new RelatorioContasReceber(this, false, null).setVisible(true);
            }
            if (metodo.equals("Contas por Cliente")) {
                HashMap parametros = new HashMap();
                if (aux == null || aux == "") {
                    parametros.put("logomarca", "Logomarca/fund03376branc99o9954120.jpg");
                    
                } else {
                    parametros.put("logomarca", "Logomarca/" + aux);
                }
                SelecionaClienteContasView sccv = new SelecionaClienteContasView(this, true);
                sccv.setVisible(true);
               
                int clienteId = sccv.getCodigoCliente();
                System.out.println("codigoCliente relatorio de contas "+ clienteId);
                parametros.put("idCliente", clienteId);
                
                JasperPrint jp;
                jp = JasperFillManager.fillReport("./relatorio/contasReceberPorCliente.jasper", parametros, con.conn);
                JasperViewer jrv = new JasperViewer(jp, false);//segundo paremetro fechar ou não programa tipo exit_on_close ou dispose
                jrv.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
