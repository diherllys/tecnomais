package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.dao.ProdutoDAO;
import com.br.tecnomais.entity.ProdutoEntity;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class BuscaProdutoVendaView extends javax.swing.JDialog {

    private final ProdutoDAO pd = new ProdutoDAO();
    private ProdutoEntity produto;
    int linhaC = 0;

    /**
     * Creates new form BuscaProdutoEntradaView
     */
    public BuscaProdutoVendaView(java.awt.Frame parent, boolean modal, String consulta) {
        super(parent, modal);
        initComponents();
        ajustarTabela();
        tfBuscar.setText(consulta);
        if (tfBuscar.getText().contains("*")) {
            preecherTabela2(tfBuscar.getText().replace("*", ""));
        } else {
            preecherTabela(tfBuscar.getText());
        }
//        if (consulta.contains("*")) {
//            preecherTabela2(consulta);
//        } else {
//            preecherTabela(consulta);
//        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabela = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        tfBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Produto");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel2.setBackground(new java.awt.Color(170, 180, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pesquisar Produto");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        tbTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Classe", "Qtde. Atual", "Preço de Custo", "Unidade", "IdProd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTabela.getTableHeader().setReorderingAllowed(false);
        tbTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbTabelaMousePressed(evt);
            }
        });
        tbTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbTabelaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbTabelaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbTabela);
        if (tbTabela.getColumnModel().getColumnCount() > 0) {
            tbTabela.getColumnModel().getColumn(0).setResizable(false);
            tbTabela.getColumnModel().getColumn(1).setResizable(false);
            tbTabela.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbTabela.getColumnModel().getColumn(2).setResizable(false);
            tbTabela.getColumnModel().getColumn(3).setResizable(false);
            tbTabela.getColumnModel().getColumn(4).setResizable(false);
            tbTabela.getColumnModel().getColumn(5).setResizable(false);
        }

        tfBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscarFocusLost(evt);
            }
        });
        tfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarActionPerformed(evt);
            }
        });
        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar");

        bSelecionar.setText("Selecionar");
        bSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelecionarActionPerformed(evt);
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
                            .addComponent(bSelecionar)
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
                .addComponent(bSelecionar)
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
        atalhos(evt);
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void tbTabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTabelaMousePressed
        int linha = tbTabela.getSelectedRow();
        ProdutoEntity prod = new ProdutoEntity();
        prod.setCodigoProduto(Integer.parseInt(tbTabela.getValueAt(linha, 0).toString()));
        prod.setNome(tbTabela.getValueAt(linha, 1).toString());
        prod.setClasse(tbTabela.getValueAt(linha, 2).toString());
        prod.setQntAtual(Double.parseDouble(tbTabela.getValueAt(linha, 3).toString()));
        prod.setPrecoDeVenda(Double.parseDouble(tbTabela.getValueAt(linha, 4).toString().replace(",", ".")));
        prod.setUnidadeDeVenda(tbTabela.getValueAt(linha, 5).toString());
        prod.setId(Integer.parseInt(tbTabela.getValueAt(linha, 6).toString()));
        produto = prod;
    }//GEN-LAST:event_tbTabelaMousePressed

    private void bSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelecionarActionPerformed
        int linha = tbTabela.getSelectedRow();
        ProdutoEntity prod = new ProdutoEntity();
        prod.setCodigoProduto(Integer.parseInt(tbTabela.getValueAt(linha, 0).toString()));
        prod.setNome(tbTabela.getValueAt(linha, 1).toString());
        prod.setClasse(tbTabela.getValueAt(linha, 2).toString());
        prod.setQntAtual(Double.parseDouble(tbTabela.getValueAt(linha, 3).toString()));
        prod.setPrecoDeVenda(Double.parseDouble(tbTabela.getValueAt(linha, 4).toString().replace(",", ".")));
        prod.setUnidadeDeVenda(tbTabela.getValueAt(linha, 5).toString());
        prod.setId(Integer.parseInt(tbTabela.getValueAt(linha, 6).toString()));
        produto = prod;
        this.dispose();
    }//GEN-LAST:event_bSelecionarActionPerformed

    private void tfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarActionPerformed
        if (tfBuscar.getText().contains("*")) {
            preecherTabela2(tfBuscar.getText().replace("*", ""));
        } else {
            preecherTabela(tfBuscar.getText());
        }
    }//GEN-LAST:event_tfBuscarActionPerformed

    private void tbTabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTabelaKeyReleased

    }//GEN-LAST:event_tbTabelaKeyReleased

    private void tbTabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTabelaKeyPressed
//        int linha = 0;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int linha = tbTabela.getSelectedRow();

            ProdutoEntity prod = new ProdutoEntity();

            prod.setCodigoProduto(Integer.parseInt(tbTabela.getValueAt(linha, 0).toString()));
            prod.setNome(tbTabela.getValueAt(linha, 1).toString());
            prod.setClasse(tbTabela.getValueAt(linha, 2).toString());
            prod.setQntAtual(Double.parseDouble(tbTabela.getValueAt(linha, 3).toString()));
            prod.setPrecoDeVenda(Double.parseDouble(tbTabela.getValueAt(linha, 4).toString().replace(",", ".")));
            prod.setUnidadeDeVenda(tbTabela.getValueAt(linha, 5).toString());
            prod.setId(Integer.parseInt(tbTabela.getValueAt(linha, 6).toString()));
            produto = prod;
            evt.consume();
            this.dispose();
        } else {
            System.out.println("nada");
        }

    }//GEN-LAST:event_tbTabelaKeyPressed

    private void tfBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarFocusGained
        bSelecionar.setEnabled(false);
        tbTabela.clearSelection();
    }//GEN-LAST:event_tfBuscarFocusGained

    private void tfBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarFocusLost
        bSelecionar.setEnabled(true);
    }//GEN-LAST:event_tfBuscarFocusLost

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
            java.util.logging.Logger.getLogger(BuscaProdutoVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaProdutoVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaProdutoVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaProdutoVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaProdutoVendaView dialog = new BuscaProdutoVendaView(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton bSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbTabela;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables

    public void preecherTabela(String consulta) {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbTabela.getModel();
            tb.setNumRows(0);
            for (ProdutoEntity p : pd.listar(consulta + "%")) {
                //p.getId()
                tb.addRow(new Object[]{p.getCodigoProduto(), p.getNome(), p.getClasse(), p.getQntAtual(), new DecimalFormat("0.00").format(p.getPrecoDeVenda()), p.getUnidadeDeVenda(), p.getId()});
                linhaC++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void preecherTabela2(String consulta) {
        try {
            DefaultTableModel tb = (DefaultTableModel) tbTabela.getModel();
            tb.setNumRows(0);
            //p.getId()
            for (ProdutoEntity p : pd.listar2("%" + consulta + "%")) {
                tb.addRow(new Object[]{p.getCodigoProduto(), p.getNome(), p.getClasse(), p.getQntAtual(), new DecimalFormat("0.00").format(p.getPrecoDeVenda()), p.getUnidadeDeVenda(), p.getId()});
                linhaC++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProdutoEntity> dadosProduto() {
        List<ProdutoEntity> lista = new ArrayList<>();
        lista.add(produto);
        return lista;
    }

    private void ajustarTabela() {
        tbTabela.getColumnModel().getColumn(5).setMinWidth(0);
        tbTabela.getColumnModel().getColumn(5).setPreferredWidth(0);
        tbTabela.getColumnModel().getColumn(5).setMaxWidth(0);
        tbTabela.getColumnModel().getColumn(6).setMinWidth(0);
        tbTabela.getColumnModel().getColumn(6).setPreferredWidth(0);
        tbTabela.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tbTabela.requestFocus();
            tbTabela.addRowSelectionInterval(0, 0);
        }
    }

}
