package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.CaixaDAO;
import com.br.tecnomais.dao.ClienteDAO;
import com.br.tecnomais.dao.ProdutosVendaDAO;
import com.br.tecnomais.dao.SaidasDAO;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class AlteraDadosSaidaView extends javax.swing.JDialog {

    SaidasDAO dao = new SaidasDAO();
    String nomeOP;
    String nomeUs;
    ClienteEntity ce = new ClienteEntity();
    VendaEntity ve = new VendaEntity();
    Alertas alerta = new Alertas();

    VendasView saidasV = new VendasView(null, null, null, ce, null, ve);
    int op;

    /**
     * Creates new form EntradaView
     */
    public AlteraDadosSaidaView(VendasView vv, int op) {

        this.saidasV = vv;
        this.initComponents();
        this.setModal(true);
        this.op = op;
        if (op == 1) {
            lbSeleciona.setText("Seleciona Cliente");
            lbNome.setText("Cliente");
        }
        if (op == 2) {
            lbSeleciona.setText("Seleciona Vendedor");
            lbNome.setText("Vendedor");
        }
        if (op == 3) {
            lbSeleciona.setText("Seleciona Caixa");
            lbNome.setText("Caixa");
        }
        if (op == 4) {
            lbSeleciona.setText("Buscar Cupom");
            lbNome.setText("Cupom");
            tfNome.setVisible(false);
        }
//        tfOperacao.setEnabled(false);
        // tfCaiNome.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbSeleciona = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        tfCod = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        lbSeleciona.setBackground(new java.awt.Color(170, 180, 180));
        lbSeleciona.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbSeleciona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSeleciona.setText("Seleciona Operação");
        lbSeleciona.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSeleciona.setOpaque(true);

        lbNome.setText("Operação");

        tfCod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCodFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodFocusLost(evt);
            }
        });
        tfCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodActionPerformed(evt);
            }
        });
        tfCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodKeyPressed(evt);
            }
        });

        jButton1.setText("Começar-F12");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfNome.setFocusable(false);

        jButton2.setText("Cancelar-F5");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(lbSeleciona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodFocusLost

    }//GEN-LAST:event_tfCodFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selecionaCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodActionPerformed
        if (op == 1) {
            pesquisarCliente();
        }
        if (op == 2) {
            pesquisarUsuario();
        }
        if (op == 3) {
            pesquisarCaixa();
        }
        if (op == 4) {
            pesquisaCupom();
        }
    }//GEN-LAST:event_tfCodActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_tfCodKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        atalhos(evt);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void tfCodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodFocusGained
        tfCod.selectAll();
    }//GEN-LAST:event_tfCodFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraDadosSaidaView(null, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSeleciona;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void pesquisarCliente() {
        try {
            ClienteEntity ce = new ClienteEntity();
            ce.setId(Integer.parseInt(tfCod.getText()));
            ClienteDAO dao = new ClienteDAO();
            for (ClienteEntity cliente : dao.selecionaCliente(ce)) {
                tfNome.setText(cliente.getNome());
                this.ce = cliente;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisarUsuario() {
        try {
            String result = dao.selecionaUsuario(Integer.parseInt(tfCod.getText()));
            tfNome.setText(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisarCaixa() {
        try {
            CaixaDAO dao = new CaixaDAO();
            for (CaixaEntity caixa : dao.selecionaCaixa(Integer.parseInt(tfCod.getText()))) {
                tfNome.setText(caixa.getNome());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisaCupom() {
        if (tfCod.getText().isEmpty()) {
            new Alertas().mensagemAviso("Não foi possível buscar esta sequência!\nSequência informada está nula!");
        } else {
            Integer sequencia = Integer.parseInt(tfCod.getText());
            SaidasDAO sDAO = new SaidasDAO();
            VendaEntity ve = new VendaEntity();
            try {
                ve = sDAO.retornaSaida(sequencia);
                if (ve.getClienteID() > 0) {
                    List<ProdutosVendaEntity> lista = new ArrayList();
                    ProdutosVendaDAO pvDAO = new ProdutosVendaDAO();
                    lista = pvDAO.listaProdutosDaVenda(ve.getId());
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println("ID: " + lista.get(i).getId());
                        System.out.println("IDDinamico: " + lista.get(i).getCodigoDinamico());
                        System.out.println("codigo do produto: " + lista.get(i).getCodigoProduto());
                    }
                    this.ve = ve;
                    saidasV.selecionaCupom(ve, lista);
                    this.dispose();
                } else {
                    alerta.mensagemAviso("Essa sequencia não é valida");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            selecionaCampos();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            this.dispose();
        }
    }

    private void selecionaCampos() {
        if (tfCod.getText().isEmpty()) {
            new Alertas().mensagemAviso("Preencha todos os campos!");
        } else {
            if (tfNome.getText().isEmpty() && op < 4) {
                new Alertas().mensagemAviso("Preencha o campo de código e aperte enter para pesquisar!");
            } else {
                if (op == 1) {
                    saidasV.selecionaCliente(ce);
                    this.dispose();
                }
                if (op == 2) {
                    saidasV.selecionaVendedor(tfNome.getText());
                    this.dispose();
                }
                if (op == 3) {
                    saidasV.selecionaCaixa(tfNome.getText());
                    this.dispose();
                }
            }
            if (op == 4) {
                pesquisaCupom();
            }
        }
    }

}
