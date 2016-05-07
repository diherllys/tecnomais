package com.br.tecnomais.vconfiguracao;

import com.br.tecnomais.vmovimentacao.*;
import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.CaixaDAO;
import com.br.tecnomais.dao.ClienteDAO;
import com.br.tecnomais.dao.ConfigurarTelaVendasDAO;
import com.br.tecnomais.dao.ProdutosVendaDAO;
import com.br.tecnomais.dao.SaidasDAO;
import com.br.tecnomais.dao.UsuarioDAO;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.ConfigurarTelaVendasEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class CfgInicializaSaidaView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();
    SaidasDAO dao = new SaidasDAO();
    String nomeOP;
    String nomeUs;
    ClienteEntity ce = new ClienteEntity();
    List<ProdutosVendaEntity> lista = new ArrayList();
    VendaEntity ve = new VendaEntity();

    ConfigurarTelaVendasEntity ctve = new ConfigurarTelaVendasEntity();
    ConfigurarTelaVendasDAO cfgDAO = new ConfigurarTelaVendasDAO();
    Integer idComputador = 1;
    //  VendasView saidasV = new VendasView();
    /**
     * Creates new form EntradaView
     */
    public CfgInicializaSaidaView() throws NumberFormatException {
        Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
        keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_F24, 0));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        this.initComponents();
        ve.setId(0);

        try {
            ctve = cfgDAO.retornaCfg(idComputador);
            if (ctve.getInVendCaixa() > 0 && ctve.getInVendCaixa() != null) {
                tfCaixa.setText(ctve.getInVendCaixa().toString());
                pesquisarCaixa();
            }
            if (ctve.getInVendCliente() > 0) {
                tfCliente.setText(ctve.getInVendCliente().toString());
                pesquisarCliente();
            }
            if (ctve.getInVendOperacao() > 0) {
                tfOperacao.setText(ctve.getInVendOperacao().toString());
            }
            if (ctve.getInVendVendedor() > 0) {
                tfVendedor.setText(ctve.getInVendVendedor().toString());
                pesquisarUsuario();
            }

            if (tfOperacao.getText().equals("1")) {
                cbOperacao.setSelectedIndex(0);
            } else if (tfOperacao.getText().equals("2")) {
                cbOperacao.setSelectedIndex(1);
            } else if (tfOperacao.getText().equals("3")) {
                cbOperacao.setSelectedIndex(2);
            } else if (tfOperacao.getText().equals("4")) {
                cbOperacao.setSelectedIndex(3);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CfgInicializaSaidaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfVendedor = new javax.swing.JTextField();
        tfCaixa = new javax.swing.JTextField();
        tfVendedorNome = new javax.swing.JTextField();
        tfCaiNome = new javax.swing.JTextField();
        Salvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbOperacao = new javax.swing.JComboBox();
        tfOperacao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        tfClienteNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Configuração de Inicialização da Venda");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jLabel2.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel3.setText("Operação");

        jLabel4.setText("Vendedor");

        jLabel5.setText("Caixa");

        tfVendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfVendedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfVendedorFocusLost(evt);
            }
        });
        tfVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVendedorActionPerformed(evt);
            }
        });
        tfVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfVendedorKeyPressed(evt);
            }
        });

        tfCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCaixaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCaixaFocusLost(evt);
            }
        });
        tfCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCaixaActionPerformed(evt);
            }
        });
        tfCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCaixaKeyPressed(evt);
            }
        });

        tfVendedorNome.setEditable(false);
        tfVendedorNome.setFocusable(false);

        tfCaiNome.setEditable(false);
        tfCaiNome.setFocusable(false);

        Salvar.setText("Salvar-F12");
        Salvar.setFocusable(false);
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar-F5");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VENDA ESTADUAL", "PRE-VENDA", "BRINDE", "TROCA" }));
        cbOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOperacaoActionPerformed(evt);
            }
        });

        tfOperacao.setText("1");
        tfOperacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfOperacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfOperacaoFocusLost(evt);
            }
        });
        tfOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOperacaoActionPerformed(evt);
            }
        });
        tfOperacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfOperacaoKeyPressed(evt);
            }
        });

        jLabel7.setText("Cliente");

        tfCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfClienteFocusLost(evt);
            }
        });
        tfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfClienteActionPerformed(evt);
            }
        });
        tfCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfClienteKeyPressed(evt);
            }
        });

        tfClienteNome.setEditable(false);
        tfClienteNome.setFocusable(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        jLabel9.setText(".");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        jLabel10.setText(".");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        jLabel11.setText(".");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 277, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfOperacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfClienteNome)
                                .addComponent(tfVendedorNome)
                                .addComponent(tfCaiNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Salvar, jButton2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfCaixa, tfCliente, tfOperacao, tfVendedor});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVendedorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel7))
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCaiNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfCaiNome, tfClienteNome, tfVendedorNome});

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

    private void tfOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOperacaoActionPerformed
        actionCamp1();
    }//GEN-LAST:event_tfOperacaoActionPerformed

    private void tfOperacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOperacaoFocusLost

    }//GEN-LAST:event_tfOperacaoFocusLost

    private void cbOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOperacaoActionPerformed
        if (cbOperacao.getSelectedIndex() == 0) {
            tfOperacao.setText("1");
        } else if (cbOperacao.getSelectedIndex() == 1) {
            tfOperacao.setText("2");
        } else if (cbOperacao.getSelectedIndex() == 2) {
            tfOperacao.setText("3");
        } else if (cbOperacao.getSelectedIndex() == 3) {
            tfOperacao.setText("4");
        } else {
            int i = 0;
            while (i == 0) {
                new Alertas().mensagemAviso("Códifica esssa porra direito mah");
            }
        }
    }//GEN-LAST:event_cbOperacaoActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        if (tfOperacao.getText().isEmpty() || tfVendedor.getText().isEmpty() || tfCaixa.getText().isEmpty()) {
            new Alertas().mensagemAviso("Preencha todos os campos!");
            if (tfCaixa.getText().isEmpty()) {
                tfCaixa.requestFocus();
            }
            if (tfCliente.getText().isEmpty()) {
                tfCliente.requestFocus();
            }
            if (tfVendedor.getText().isEmpty()) {
                tfVendedor.requestFocus();
            }
        } else {
            pesquisarCliente();
            pesquisarCaixa();
            pesquisarUsuario();

            if (ctve == null) {
                salvarCfg();
                new Alertas().mensagemConfirmacao("Configuração Salva com Sucesso!");
            } else {
                updateCfg();
                new Alertas().mensagemConfirmacao("Configuração Alterada com Sucesso!");
            }

//            if (tfOperacao.getText().isEmpty() || (tfVendedor.getText().isEmpty() || tfVendedorNome.getText().isEmpty()) || (tfCaixa.getText().isEmpty() || tfCaiNome.getText().isEmpty()) || (tfCliente.getText().isEmpty() || tfClienteNome.getText().isEmpty())) {
//                new Alertas().mensagemAviso("Preencha todos os campos!");
//            } else {
//                new VendasView(cbOperacao.getSelectedItem().toString(), tfVendedorNome.getText(), tfCaiNome.getText(), ce, lista, ve).setVisible(true);
//                this.dispose();
//            }
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private void tfCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCaixaActionPerformed
        pesquisarCaixa();
        if (!tfCaixa.getText().isEmpty() && !tfCaiNome.getText().isEmpty()
                && !tfCliente.getText().isEmpty() && (!tfClienteNome.getText().isEmpty() && !tfClienteNome.getText().equals("") && !tfClienteNome.getText().equals(" "))
                && !tfOperacao.getText().isEmpty() && !tfVendedor.getText().isEmpty()
                && (!tfVendedorNome.getText().isEmpty() && !tfVendedorNome.getText().equals("") && !tfVendedorNome.getText().equals(" "))) {

//            Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
//            keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
//            KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
//            new VendasView(cbOperacao.getSelectedItem().toString(), tfVendedorNome.getText(), tfCaiNome.getText(), ce, lista, ve).setVisible(true);
//            this.dispose();
        } else {
            alerta.mensagemAviso("Preencha todos os campos de forma correta!");
            if (tfCaixa.getText().isEmpty()) {
                tfCaixa.requestFocus();
            }
            if (tfCliente.getText().isEmpty()) {
                tfCliente.requestFocus();
            }
            if (tfVendedor.getText().isEmpty()) {
                tfVendedor.requestFocus();
            }
        }
    }//GEN-LAST:event_tfCaixaActionPerformed

    private void tfCaixaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCaixaFocusLost
//        pesquisarCaixa();
    }//GEN-LAST:event_tfCaixaFocusLost

    private void tfVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVendedorActionPerformed
        if (!tfVendedor.getText().isEmpty()) {
            pesquisarUsuario();
        }
    }//GEN-LAST:event_tfVendedorActionPerformed

    private void tfVendedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfVendedorFocusLost
//        pesquisarUsuario();
    }//GEN-LAST:event_tfVendedorFocusLost

    private void tfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfClienteActionPerformed
        if (!tfCliente.getText().isEmpty()) {
            pesquisarCliente();
        }
    }//GEN-LAST:event_tfClienteActionPerformed

    private void tfClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfClienteFocusLost
//        pesquisarCliente();
    }//GEN-LAST:event_tfClienteFocusLost

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        PesqCliVenCaixCfgIniVendaView pesqCli = new PesqCliVenCaixCfgIniVendaView(this, true, 2);
        pesqCli.setVisible(true);
        tfVendedor.setText(pesqCli.retornaid().toString());
        tfVendedorNome.setText(" ");
        tfVendedor.requestFocus();
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        PesqCliVenCaixCfgIniVendaView pesqCli = new PesqCliVenCaixCfgIniVendaView(this, true, 3);
        pesqCli.setVisible(true);
        tfCliente.setText(pesqCli.retornaid().toString());
        tfClienteNome.setText(" ");
        tfCliente.requestFocus();
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        PesqCliVenCaixCfgIniVendaView pesqCli = new PesqCliVenCaixCfgIniVendaView(this, true, 4);
        pesqCli.setVisible(true);
        tfCaixa.setText(pesqCli.retornaid().toString());
        tfCaiNome.setText(" ");
        tfCaixa.requestFocus();
    }//GEN-LAST:event_jLabel11MousePressed

    private void tfVendedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfVendedorFocusGained
        tfVendedor.selectAll();
    }//GEN-LAST:event_tfVendedorFocusGained

    private void tfClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfClienteFocusGained
        tfCliente.selectAll();
    }//GEN-LAST:event_tfClienteFocusGained

    private void tfCaixaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCaixaFocusGained
        tfCaixa.selectAll();
    }//GEN-LAST:event_tfCaixaFocusGained

    private void tfOperacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOperacaoFocusGained
        tfOperacao.selectAll();
    }//GEN-LAST:event_tfOperacaoFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfOperacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOperacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            actionCamp1();
        }
        atalhos(evt);
    }//GEN-LAST:event_tfOperacaoKeyPressed

    private void tfVendedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVendedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (!tfVendedor.getText().isEmpty()) {
                pesquisarUsuario();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfVendedorKeyPressed

    private void tfClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfClienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (!tfCliente.getText().isEmpty()) {
                pesquisarCliente();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfClienteKeyPressed

    private void tfCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCaixaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            pesquisarCaixa();
//            if (!tfCaixa.getText().isEmpty() && !tfCaiNome.getText().isEmpty()
//                    && !tfCliente.getText().isEmpty() && (!tfClienteNome.getText().isEmpty() && !tfClienteNome.getText().equals("") && !tfClienteNome.getText().equals(" "))
//                    && !tfOperacao.getText().isEmpty() && !tfVendedor.getText().isEmpty()
//                    && (!tfVendedorNome.getText().isEmpty() && !tfVendedorNome.getText().equals("") && !tfVendedorNome.getText().equals(" "))) {
//                System.out.println("tf " + tfVendedorNome.getText());
//
//                Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
//                keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
//                KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
//                new VendasView(cbOperacao.getSelectedItem().toString(), tfVendedorNome.getText(), tfCaiNome.getText(), ce, lista, ve).setVisible(true);
//                this.dispose();
//            } else {
//                alerta.mensagemAviso("Preencha todos os campos de forma correta!");
//            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfCaixaKeyPressed

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
                new CfgInicializaSaidaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salvar;
    private javax.swing.JComboBox cbOperacao;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfCaiNome;
    private javax.swing.JTextField tfCaixa;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfClienteNome;
    private javax.swing.JTextField tfOperacao;
    private javax.swing.JTextField tfVendedor;
    private javax.swing.JTextField tfVendedorNome;
    // End of variables declaration//GEN-END:variables

    private void desabilitarCampos() {
        tfVendedorNome.setEditable(false);
        tfOperacao.setEditable(false);
        tfCaiNome.setEditable(false);
    }

    private void pesquisarUsuario() {
        try {
            String result = dao.selecionaUsuario(Integer.parseInt(tfVendedor.getText()));
            tfVendedorNome.setText(result);
            if (result.length() > 1) {
                tfCliente.requestFocus();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisarCaixa() {
        try {
            CaixaDAO dao = new CaixaDAO();
            for (CaixaEntity caixa : dao.selecionaCaixa(Integer.parseInt(tfCaixa.getText()))) {
                tfCaiNome.setText(caixa.getNome());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisarCliente() {
        try {
            ClienteEntity ce = new ClienteEntity();
            ce.setId(Integer.parseInt(tfCliente.getText()));
            ClienteDAO dao = new ClienteDAO();
            tfClienteNome.setText(" ");
            for (ClienteEntity cliente : dao.selecionaCliente(ce)) {
                if (!cliente.getNome().equals(" ") || !cliente.getNome().equals("")) {
                    tfClienteNome.setText(cliente.getNome());
                    tfCaixa.requestFocus();
                }
                this.ce = cliente;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            if (tfOperacao.getText().isEmpty() || tfVendedor.getText().isEmpty() || tfCaixa.getText().isEmpty() || tfCliente.getText().isEmpty() || tfVendedorNome.getText().isEmpty()) {
                new Alertas().mensagemAviso("Preencha todos os campos!");
            } else {
                pesquisarCliente();
                pesquisarCaixa();
                pesquisarUsuario();

                if (ctve == null) {
                    salvarCfg();
                    new Alertas().mensagemConfirmacao("Configuração Salva com Sucesso!");
                } else {
                    updateCfg();
                    new Alertas().mensagemConfirmacao("Configuração Alterada com Sucesso!");
                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            this.dispose();
        }
    }

    private void actionCamp1() {
        Integer cod = Integer.parseInt(tfOperacao.getText());
        if (cod < 5 && cod > 0) {
            if (cod == 1) {
                cbOperacao.setSelectedIndex(0);
                tfVendedor.requestFocus();
            }
            if (cod == 2) {
                cbOperacao.setSelectedIndex(1);
                tfVendedor.requestFocus();
            }
            if (cod == 3) {
                cbOperacao.setSelectedIndex(2);
                tfVendedor.requestFocus();
            }
            if (cod == 4) {
                tfVendedor.requestFocus();
                cbOperacao.setSelectedIndex(3);
            }
        } else {
            new Alertas().mensagemAviso("O intervalo do campo deve ser entre 1 e 4");
            tfOperacao.requestFocus();
            tfOperacao.selectAll();
        }
    }

    private void salvarCfg() {
        ConfigurarTelaVendasEntity ctve = new ConfigurarTelaVendasEntity();
        ctve.setInVendCaixa(Integer.parseInt(tfCaixa.getText()));
        ctve.setInVendCliente(Integer.parseInt(tfCliente.getText()));
        ctve.setInVendOperacao(Integer.parseInt(tfOperacao.getText()));
        ctve.setInVendVendedor(Integer.parseInt(tfVendedor.getText()));

        cfgDAO.salvarInCfg(ctve);
    }

    private void updateCfg() {
        ConfigurarTelaVendasEntity ctve = new ConfigurarTelaVendasEntity();
        ctve.setInVendCaixa(Integer.parseInt(tfCaixa.getText()));
        ctve.setInVendCliente(Integer.parseInt(tfCliente.getText()));
        ctve.setInVendOperacao(Integer.parseInt(tfOperacao.getText()));
        ctve.setInVendVendedor(Integer.parseInt(tfVendedor.getText()));

        cfgDAO.updateInCfg(ctve);

    }
}
