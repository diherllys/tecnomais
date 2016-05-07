package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.CaixaDAO;
import com.br.tecnomais.dao.ClienteDAO;
import com.br.tecnomais.dao.EntradaDAO;
import com.br.tecnomais.dao.ProdutosVendaDAO;
import com.br.tecnomais.dao.SaidasDAO;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.EntradasEntity;
import com.br.tecnomais.entity.InicializaEntradaEntity;
import com.br.tecnomais.entity.ProdutosEntradaEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class AlteraDadosEntradaView extends javax.swing.JDialog {

    SaidasDAO dao = new SaidasDAO();
    EntradaDAO entradaDAO = new EntradaDAO();
    String nomeOP;
    String nomeUs;
    ClienteEntity ce = new ClienteEntity();
    VendaEntity ve = new VendaEntity();
    Alertas alerta = new Alertas();

    InicializaEntradaEntity iee = new InicializaEntradaEntity();
    EntradasView entradaView;
    VendasView saidasV = new VendasView(null, null, null, ce, null, ve);
    int op = 1;
    List<ProdutosEntradaEntity> listProdEntra = new ArrayList();

    String fornecedor = "";
    String caixa = "";
    String operacao = "";
    int sequencia = 0;
    boolean cancelar = false;

    /**
     * Creates new form EntradaView
     */
    public AlteraDadosEntradaView(EntradasView ev, int op) {
        this.initComponents();
//        System.out.println("entradaView.sequencia.toString();" + entradaView.sequencia.toString());
        this.entradaView = ev;

        this.setModal(true);
        this.op = op;
        if (op == 1) {
//            tfNome.setVisible(false);
            lbSeleciona.setText("Buscar Sequencia de Entrada");
            lbNome.setText("Sequencia");
        }
        if (op == 2) {
            lbSeleciona.setText("Seleciona Fornecedor");
            lbNome.setText("Fornecedor");
        }
        if (op == 3) {
            lbSeleciona.setText("Seleciona Caixa");
            lbNome.setText("Caixa");
        }
//        if (op == 4) {
//            lbSeleciona.setText("Buscar Cupom");
//            lbNome.setText("Cupom");
//            tfNome.setVisible(false);
//        }
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
        lbPesquisaCaixa1 = new javax.swing.JLabel();

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

        lbPesquisaCaixa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaCaixa1.setText(".");
        lbPesquisaCaixa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaCaixa1MousePressed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPesquisaCaixa1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisaCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            pesquisaSequencia();
        }
        if (op == 2) {
            pesquisarFornecedor();
        }
        if (op == 3) {
            pesquisarCaixa();
        }
        if (op == 4) {
//            pesquisaCupom();
        }
    }//GEN-LAST:event_tfCodActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cancelar = true;
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

    private void lbPesquisaCaixa1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaCaixa1MousePressed
        if (op == 1) {
            PesqCliVenCaixForIniVendaView pesqCli = new PesqCliVenCaixForIniVendaView(null, true, 6);
            pesqCli.setVisible(true);
            tfCod.setText(pesqCli.retornaid().toString());
            tfCod.requestFocus();
            tfCod.selectAll();
        } else if (op == 2) {

        } else if (op == 3) {

        }
    }//GEN-LAST:event_lbPesquisaCaixa1MousePressed

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
                new AlteraDadosEntradaView(null, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPesquisaCaixa1;
    private javax.swing.JLabel lbSeleciona;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void pesquisaSequencia() {
        if (tfCod.getText().isEmpty()) {
            new Alertas().mensagemAviso("Não foi possível buscar esta sequência!\nSequência informada está nula!");
        } else {
            EntradaDAO eDAO = new EntradaDAO();
            try {
                EntradasEntity ee = new EntradasEntity();
                ee = eDAO.retornaEntrada(Integer.parseInt(tfCod.getText()));
                if (ee.getCodigoEntrada() > 0) {
                    operacao = ee.getOperacao().toUpperCase();
                    caixa = ee.getCaixa();
                    fornecedor = ee.getFornecedor();
                    sequencia = Integer.parseInt(tfCod.getText());
//               
                    ProdutosVendaDAO pvDAO = new ProdutosVendaDAO();
                    listProdEntra = eDAO.listaProdutosEntradaPorSequencia(Integer.parseInt(tfCod.getText()));
                    for (ProdutosEntradaEntity pee : listProdEntra) {
                        System.out.println(pee.getCodigoProduto());
                    }
                    tfNome.setText("Sequencia encontrada!");
                } else {
                    tfNome.setText("Sequencia não encontrada!");
                    new Alertas().mensagemAviso("Essa sequência não é válida!");
                }

//                int sequencia = Integer.parseInt(tfBuscaSequencia.getText());
//            InicializaEntradaEntity conEntrada = new InicializaEntradaEntity();
//            conEntrada.setSequencia(sequencia);
//            new ConsultaEntradaView(conEntrada).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(InicializaEntradaView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(InicializaEntradaView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void pesquisarFornecedor() {
        try {
            String result = entradaDAO.selecionaFornecedor(Integer.parseInt(tfCod.getText()));
            if (result.length() > 0) {
                tfNome.setText(result);
            } else {
                tfNome.setText("");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisarCaixa() {
        try {
            String result = "";
            CaixaDAO dao = new CaixaDAO();
            for (CaixaEntity caixa : dao.selecionaCaixa(Integer.parseInt(tfCod.getText()))) {
                result = caixa.getNome();
            }
            if (result.length() > 0) {
                tfNome.setText(result);
            } else {
                tfNome.setText("");
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
                    entradaView.selecionaCaixa(tfNome.getText());
                    this.dispose();
                }
            }
            if (op == 4) {
                pesquisaCupom();
            }
        }
    }

    public String retornaCaixa() {
        return caixa;
    }

    public String retornaOperacao() {
        return operacao;
    }

    public String retornaFornecedor() {
        return fornecedor;
    }

    public Integer retornaSequencia() {
        return sequencia;
    }

    public List<ProdutosEntradaEntity> retornaListProdEnt() {
        return listProdEntra;
    }

    public boolean cancelar() {
        return cancelar;
    }

}
