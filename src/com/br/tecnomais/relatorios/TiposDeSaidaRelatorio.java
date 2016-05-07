/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.relatorios;

import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.LogomarcaDAO;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.UsuarioEntity;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class TiposDeSaidaRelatorio extends javax.swing.JDialog {

    UsuarioEntity u;
    NovaData data = new NovaData();
    ConectaBanco con = new ConectaBanco();
    LogomarcaDAO dao = new LogomarcaDAO();

    /**
     * Creates new form TiposDeSaidaRelatorio
     */
    public TiposDeSaidaRelatorio(java.awt.Frame parent, boolean modal, UsuarioEntity u) {
        super(parent, false);
        initComponents();
        initComponents();
        con.conectar();
        this.u = u;
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
        btTodasSaidaComplexa = new javax.swing.JButton();
        btSaidasDataStatusComplexa = new javax.swing.JButton();
        btTodasSaidaSimplificada = new javax.swing.JButton();
        btSaidasDataStatusSimples = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório de Saídas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        btTodasSaidaComplexa.setText("Todas as Saída [Completa]");
        btTodasSaidaComplexa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodasSaidaComplexaActionPerformed(evt);
            }
        });

        btSaidasDataStatusComplexa.setText("Saídas por Data/Status [Completa]");
        btSaidasDataStatusComplexa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaidasDataStatusComplexaActionPerformed(evt);
            }
        });

        btTodasSaidaSimplificada.setText("Todas as Saídas [Simplificada]");
        btTodasSaidaSimplificada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodasSaidaSimplificadaActionPerformed(evt);
            }
        });

        btSaidasDataStatusSimples.setText("Saídas por Data/Status [Simplificada]");
        btSaidasDataStatusSimples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaidasDataStatusSimplesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btTodasSaidaComplexa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSaidasDataStatusComplexa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btTodasSaidaSimplificada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSaidasDataStatusSimples)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btSaidasDataStatusComplexa, btSaidasDataStatusSimples, btTodasSaidaComplexa, btTodasSaidaSimplificada});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSaidasDataStatusComplexa)
                    .addComponent(btTodasSaidaComplexa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSaidasDataStatusSimples)
                    .addComponent(btTodasSaidaSimplificada))
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void btTodasSaidaComplexaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodasSaidaComplexaActionPerformed
        try {
            String aux = dao.mostraLogomarca();
            ireport("./relatorio/saidasGeralComposta.jasper", "logomarca", aux, null, null, null, null, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btTodasSaidaComplexaActionPerformed

    private void btTodasSaidaSimplificadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodasSaidaSimplificadaActionPerformed
        try {
            String aux = dao.mostraLogomarca();
            ireport("./relatorio/saidasGeralSimplificada.jasper", "logomarca", aux, null, null, null, null, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btTodasSaidaSimplificadaActionPerformed

    private void btSaidasDataStatusComplexaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidasDataStatusComplexaActionPerformed
        new SaidasPorDataView(null, false, "c").setVisible(true);
    }//GEN-LAST:event_btSaidasDataStatusComplexaActionPerformed

    private void btSaidasDataStatusSimplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidasDataStatusSimplesActionPerformed
        new SaidasPorDataView(null, false, "s").setVisible(true);
    }//GEN-LAST:event_btSaidasDataStatusSimplesActionPerformed

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
            java.util.logging.Logger.getLogger(TiposDeSaidaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiposDeSaidaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiposDeSaidaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiposDeSaidaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TiposDeSaidaRelatorio dialog = new TiposDeSaidaRelatorio(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btSaidasDataStatusComplexa;
    private javax.swing.JButton btSaidasDataStatusSimples;
    private javax.swing.JButton btTodasSaidaComplexa;
    private javax.swing.JButton btTodasSaidaSimplificada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
  public void ireport(String caminho, String param1, String param11, String param2, String param22, String null3, String null4, String null5) {
        try {
            System.out.println(param11);
            HashMap parametros = new HashMap();
            if (param11 == null || param11 == "") {
                parametros.put(param1, "Logomarca/fund03376branc99o9954120.jpg");
                parametros.put(param2, param22);
            } else {
                parametros.put(param1, "Logomarca/" + param11);
                parametros.put(param2, param22);
            }
            JasperPrint jp;
            jp = JasperFillManager.fillReport(caminho, parametros, con.conn);
            JasperViewer jrv = new JasperViewer(jp, false);//segundo paremetro fechar ou não programa
            jrv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
