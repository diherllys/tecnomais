package com.br.tecnomais.relatorios;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.LogomarcaDAO;
import com.br.tecnomais.dao.ProdutoDAO;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ProdutoEntity;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Diherllys
 */
public class SelecionaProdutoEspecificoView extends javax.swing.JDialog {

    ConectaBanco conn = new ConectaBanco();
    Alertas alerta = new Alertas();
    private final ProdutoDAO pd = new ProdutoDAO();
    private ProdutoEntity produtoEntityAux = new ProdutoEntity();
    private Integer produtoId;
    private String auxGeral;
    private Integer contador = 0;
    private int contadorDeLinhas = 0;

    public SelecionaProdutoEspecificoView(java.awt.Frame parent, String consulta) {
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
        jSeleciona = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTabela1 = new javax.swing.JTable();
        jBRelatorio = new javax.swing.JButton();
        jRemoverLinha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Produto");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel2.setBackground(new java.awt.Color(170, 180, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pesquisa Produto");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Custo", "%", "Venda", "Quant"
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
            jtTabela.getColumnModel().getColumn(4).setResizable(false);
            jtTabela.getColumnModel().getColumn(5).setResizable(false);
        }

        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar");

        jSeleciona.setText("Selecionar");
        jSeleciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSelecionaActionPerformed(evt);
            }
        });

        jtTabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Custo", "%", "Venda", "Quant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabela1.getTableHeader().setReorderingAllowed(false);
        jtTabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtTabela1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtTabela1);
        if (jtTabela1.getColumnModel().getColumnCount() > 0) {
            jtTabela1.getColumnModel().getColumn(0).setResizable(false);
            jtTabela1.getColumnModel().getColumn(1).setResizable(false);
            jtTabela1.getColumnModel().getColumn(1).setPreferredWidth(250);
            jtTabela1.getColumnModel().getColumn(2).setResizable(false);
            jtTabela1.getColumnModel().getColumn(3).setResizable(false);
            jtTabela1.getColumnModel().getColumn(4).setResizable(false);
            jtTabela1.getColumnModel().getColumn(5).setResizable(false);
        }

        jBRelatorio.setText("Relatório");
        jBRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRelatorioActionPerformed(evt);
            }
        });

        jRemoverLinha.setText("Remover");
        jRemoverLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverLinhaActionPerformed(evt);
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
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeleciona))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jBRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRemoverLinha))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 5, Short.MAX_VALUE))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSeleciona)
                    .addComponent(jBRelatorio)
                    .addComponent(jRemoverLinha))
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
        produtoEntityAux.setId(Integer.parseInt(jtTabela.getValueAt(linha, 0).toString()));
        produtoEntityAux.setNome(jtTabela.getValueAt(linha, 1).toString());
        produtoEntityAux.setPrecoDeCusto(Double.parseDouble(jtTabela.getValueAt(linha, 2).toString()));
        produtoEntityAux.setPorcentagem(Double.parseDouble(jtTabela.getValueAt(linha, 3).toString()));
        produtoEntityAux.setPrecoDeVenda(Double.parseDouble(jtTabela.getValueAt(linha, 4).toString()));
        produtoEntityAux.setQntAtual(Double.parseDouble(jtTabela.getValueAt(linha, 5).toString()));
        
    }//GEN-LAST:event_jtTabelaMousePressed

    private void jSelecionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSelecionaActionPerformed
        try {

            DefaultTableModel tb = (DefaultTableModel) jtTabela1.getModel();
            tb.addRow(new Object[]{produtoEntityAux.getId(), produtoEntityAux.getNome(), produtoEntityAux.getPrecoDeCusto(),
                produtoEntityAux.getPorcentagem(), produtoEntityAux.getPrecoDeVenda(), produtoEntityAux.getQntAtual()});

            contadorDeLinhas++;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jSelecionaActionPerformed

    private void jtTabela1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabela1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTabela1MousePressed

    private void jBRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRelatorioActionPerformed
        try {
            String aux = "";
            for (int i = 0; i < contadorDeLinhas; i++) {
                aux = (String) jtTabela1.getValueAt(i, 0).toString();
                if (contador == 0) {
                    auxGeral = aux;
                    contador++;
                } else {
                    auxGeral = auxGeral + "," + aux;
                }
            }

            gerarRelatorio(auxGeral);
//            System.out.println("auxGeral = " + auxGeral);
//            System.out.println("contadorDeLinhas = " + contadorDeLinhas);
//            System.out.println("contador = " + contador);

        } catch (JRException ex) {
            Logger.getLogger(SelecionaProdutoEspecificoView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SelecionaProdutoEspecificoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBRelatorioActionPerformed

    private void jRemoverLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverLinhaActionPerformed
        int linha = jtTabela1.getSelectedRow();
        ((DefaultTableModel) jtTabela1.getModel()).removeRow(linha);
        contadorDeLinhas--;
        auxGeral = "";
        contador = 0;
    }//GEN-LAST:event_jRemoverLinhaActionPerformed

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
            java.util.logging.Logger.getLogger(SelecionaProdutoEspecificoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionaProdutoEspecificoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionaProdutoEspecificoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionaProdutoEspecificoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelecionaProdutoEspecificoView dialog = new SelecionaProdutoEspecificoView(new javax.swing.JFrame(), null);
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
    private javax.swing.JButton jBRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jRemoverLinha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jSeleciona;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtTabela;
    private javax.swing.JTable jtTabela1;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables

    public void preecherTabela(String consulta) {
        try {
            DefaultTableModel tb = (DefaultTableModel) jtTabela.getModel();
            tb.setNumRows(0);
            for (ProdutoEntity p : pd.listar(consulta + "%")) {
                tb.addRow(new Object[]{p.getId(), p.getTextoDeSaida(), p.getPrecoDeCusto(), p.getPorcentagem(), p.getPrecoDeVenda(), p.getQntAtual()});
            }
        } catch (Exception e) {
        }
    }

    private void ajustarTabela() {
        jtTabela.getColumnModel().getColumn(0).setMinWidth(50);
        jtTabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtTabela.getColumnModel().getColumn(0).setMaxWidth(60);
    }

    private void gerarRelatorio(String ids) throws JRException, SQLException {
        HashMap parametros = new HashMap();
        LogomarcaDAO dao = new LogomarcaDAO();
        String aux = dao.mostraLogomarca();
        JasperPrint jp;
        if (aux == null || aux == "") {
            parametros.put("logomarca", "Logomarca/fund03376branc99o9954120.jpg");

        } else {
            parametros.put("logomarca", "Logomarca/" + aux);
        }
            parametros.put("produtosSelecionados", ids);
            jp = JasperFillManager.fillReport("./relatorio/produtosCadastradosEsp.jasper", parametros, conn.conn);
     
        JasperViewer jrv = new JasperViewer(jp, false);
        jrv.setVisible(true);
    }
}
