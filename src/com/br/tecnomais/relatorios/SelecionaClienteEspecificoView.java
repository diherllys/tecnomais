package com.br.tecnomais.relatorios;

import com.br.tecnomais.dao.ClienteDAO;
import com.br.tecnomais.dao.LogomarcaDAO;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ClienteEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Diherllys
 */
public class SelecionaClienteEspecificoView extends javax.swing.JDialog {

    ConectaBanco conn = new ConectaBanco();
    private final ClienteDAO cd = new ClienteDAO();
    private ClienteEntity clienteEntity;
    private Integer clienteId;

    public SelecionaClienteEspecificoView(java.awt.Frame parent, boolean modal, String consulta) {
        super(parent, modal);
        conn.conectar();
        initComponents();
        ajustarTabela();
        preecherTabela(consulta);
        tfBuscar.setText(consulta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        tfBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Cliente");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel2.setBackground(new java.awt.Color(170, 180, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pesquisar Cliente");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Cidade", "Telefone 1", "Endereço", "Nº"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabela.getTableHeader().setReorderingAllowed(false);
        jtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtTabelaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabela);
        if (jtTabela.getColumnModel().getColumnCount() > 0) {
            jtTabela.getColumnModel().getColumn(0).setResizable(false);
            jtTabela.getColumnModel().getColumn(1).setResizable(false);
            jtTabela.getColumnModel().getColumn(1).setPreferredWidth(250);
            jtTabela.getColumnModel().getColumn(2).setResizable(false);
            jtTabela.getColumnModel().getColumn(3).setResizable(false);
            jtTabela.getColumnModel().getColumn(5).setResizable(false);
        }

        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar");

        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 555, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
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

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased
        preecherTabela(tfBuscar.getText());
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void jtTabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMousePressed
        int linha = jtTabela.getSelectedRow();
        clienteId = (Integer.parseInt(jtTabela.getValueAt(linha, 0).toString()));
    }//GEN-LAST:event_jtTabelaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.dispose();
            gerarRelatorio(clienteId);
            this.setDefaultCloseOperation(SelecionaClienteEspecificoView.DISPOSE_ON_CLOSE);
        } catch (Exception ex) {
            ex.printStackTrace();
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelecionaClienteEspecificoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionaClienteEspecificoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionaClienteEspecificoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionaClienteEspecificoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelecionaClienteEspecificoView dialog = new SelecionaClienteEspecificoView(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtTabela;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables

    public void preecherTabela(String consulta) {
        try {
            DefaultTableModel tb = (DefaultTableModel) jtTabela.getModel();
            tb.setNumRows(0);
            for (ClienteEntity p : cd.listar(consulta + "%")) {
                tb.addRow(new Object[]{p.getId(), p.getNome(), p.getCidade(), p.getTelefone1(), p.getEndereco(), p.getNumero()});
            }
        } catch (Exception e) {
        }
    }

    public List<ClienteEntity> dadosProduto() {
        List<ClienteEntity> lista = new ArrayList<>();
        lista.add(clienteEntity);
        return lista;
    }

    private void ajustarTabela() {
        jtTabela.getColumnModel().getColumn(0).setMinWidth(50);
        jtTabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtTabela.getColumnModel().getColumn(0).setMaxWidth(60);
//        jtTabela.getColumnModel().getColumn(5).setMinWidth(0);
//        jtTabela.getColumnModel().getColumn(5).setPreferredWidth(0);
//        jtTabela.getColumnModel().getColumn(5).setMaxWidth(0);
//         jtTabela.getColumnModel().getColumn(4).setMinWidth(0);
//        jtTabela.getColumnModel().getColumn(4).setPreferredWidth(0);
//        jtTabela.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void gerarRelatorio(int id) throws JRException, SQLException {
        HashMap parametros = new HashMap();

        LogomarcaDAO dao = new LogomarcaDAO();
        String aux = dao.mostraLogomarca();
        if (aux == null || aux == "") {
            parametros.put("logomarca", "Logomarca/fund03376branc99o9954120.jpg");

        } else {
            parametros.put("logomarca", "Logomarca/" + aux);
        }

        parametros.put("clienteEspecifico", id);
        JasperPrint jp = JasperFillManager.fillReport("./relatorio/clienteEspecifico.jasper", parametros, conn.conn);
        JasperViewer jrv = new JasperViewer(jp, false);
        jrv.setVisible(true);
    }
}
