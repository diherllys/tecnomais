package com.br.tecnomais.vmovimentacao;

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
import com.br.tecnomais.vconfiguracao.CfgInicializaSaidaView;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
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
public class InicializaSaidaView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();
    SaidasDAO dao = new SaidasDAO();
    String nomeOP;
    String nomeUs;
    ClienteEntity ce = new ClienteEntity();
    List<ProdutosVendaEntity> lista = new ArrayList();
    VendaEntity ve = new VendaEntity();

    ConfigurarTelaVendasEntity ctve = new ConfigurarTelaVendasEntity();
    ConfigurarTelaVendasDAO cfgDAO = new ConfigurarTelaVendasDAO();

    Integer idComputador = 0;

    //  VendasView saidasV = new VendasView();
    /**
     * Creates new form EntradaView
     */
    public InicializaSaidaView() {

        try {
            BufferedReader ler = new BufferedReader(new FileReader("Config/cfg.cfg"));
            idComputador = Integer.parseInt(ler.readLine());
            System.out.println("id " + idComputador);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                if (ctve.getMostraCaixa() == 0) {
                    lbCaixa.setVisible(false);
                    lbPesquisaCaixa.setVisible(false);
                    tfCaiNome.setVisible(false);
                    tfCaixa.setVisible(false);
                }
                if (ctve.getPermAlteraCaixa() == 0) {
                    lbPesquisaCaixa.setEnabled(false);
                    lbPesquisaCaixa.setFocusable(false);
                    tfCaixa.setEnabled(false);
                    tfCaiNome.setEnabled(false);
//                    tfCaiNome.setEditable(false);
//                    tfCaixa.setEditable(false);
                    tfCaiNome.setFocusable(false);
                    tfCaixa.setFocusable(false);
                    lbPesquisaCaixa.setVisible(false);
                }
            }
            if (ctve.getInVendCliente() > 0) {
                tfCliente.setText(ctve.getInVendCliente().toString());
                pesquisarCliente();

                if (ctve.getMostraCliente() == 0) {
                    lbCliente.setVisible(false);
                    lbPesquisaCliente.setVisible(false);
                    tfCliente.setVisible(false);
                    tfClienteNome.setVisible(false);
                }
                if (ctve.getPermAlteraCliente() == 0) {
                    lbPesquisaCliente.setEnabled(false);
                    lbPesquisaCliente.setFocusable(false);
                    tfClienteNome.setEnabled(false);
                    tfCliente.setEnabled(false);
                    tfClienteNome.setFocusable(false);
                    tfCliente.setFocusable(false);
                    lbPesquisaCliente.setVisible(false);
                }
            }
            if (ctve.getInVendOperacao() > 0) {
                tfOperacao.setText(ctve.getInVendOperacao().toString());
                if (ctve.getMostraOperacao() == 0) {
                    lbOperacao.setVisible(false);
                    tfOperacao.setVisible(false);
                    cbOperacao.setVisible(false);
                }
                if (ctve.getPermAlteraOperacao() == 0) {
                    tfOperacao.setFocusable(false);
                    tfOperacao.setEnabled(false);
                    cbOperacao.setFocusable(false);
                    cbOperacao.setEnabled(false);
                }
            }
            if (ctve.getInVendVendedor() > 0) {
                tfVendedor.setText(ctve.getInVendVendedor().toString());
                pesquisarUsuario();
                if (ctve.getMostraVendedor() == 0) {
                    lbVendedor.setVisible(false);
                    lbPesquisaVendedor.setVisible(false);
                    tfVendedor.setVisible(false);
                    tfVendedorNome.setVisible(false);
                }
                if (ctve.getPermAlteraVendedor() == 0) {
                    lbPesquisaVendedor.setEnabled(false);
                    lbPesquisaVendedor.setFocusable(false);
                    tfVendedorNome.setEnabled(false);
                    tfVendedor.setEnabled(false);
                    tfVendedorNome.setFocusable(false);
                    tfVendedor.setFocusable(false);
                    lbPesquisaVendedor.setVisible(false);
                }
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
        tfBuscaSequencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbOperacao = new javax.swing.JLabel();
        lbVendedor = new javax.swing.JLabel();
        lbCaixa = new javax.swing.JLabel();
        tfVendedor = new javax.swing.JTextField();
        tfCaixa = new javax.swing.JTextField();
        tfVendedorNome = new javax.swing.JTextField();
        tfCaiNome = new javax.swing.JTextField();
        bComecar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        cbOperacao = new javax.swing.JComboBox();
        tfOperacao = new javax.swing.JTextField();
        lbCliente = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        tfClienteNome = new javax.swing.JTextField();
        lbPesquisaVendedor = new javax.swing.JLabel();
        lbPesquisaCliente = new javax.swing.JLabel();
        lbPesquisaCaixa = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Saída");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        tfBuscaSequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscaSequenciaActionPerformed(evt);
            }
        });
        tfBuscaSequencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscaSequenciaKeyPressed(evt);
            }
        });

        jLabel2.setText("Buscar por Cupom.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscaSequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscaSequencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbOperacao.setText("Operação");

        lbVendedor.setText("Vendedor");

        lbCaixa.setText("Caixa");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfVendedorKeyTyped(evt);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCaixaKeyTyped(evt);
            }
        });

        tfVendedorNome.setEditable(false);
        tfVendedorNome.setEnabled(false);
        tfVendedorNome.setFocusable(false);

        tfCaiNome.setEditable(false);
        tfCaiNome.setEnabled(false);
        tfCaiNome.setFocusable(false);

        bComecar.setText("Começar-F12");
        bComecar.setFocusable(false);
        bComecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bComecarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar-F5");
        bCancelar.setFocusable(false);
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfOperacaoKeyTyped(evt);
            }
        });

        lbCliente.setText("Cliente");

        tfCliente.setText("1");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfClienteKeyTyped(evt);
            }
        });

        tfClienteNome.setEditable(false);
        tfClienteNome.setText("CLIENTE BALCAO");
        tfClienteNome.setEnabled(false);
        tfClienteNome.setFocusable(false);

        lbPesquisaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaVendedor.setText(".");
        lbPesquisaVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaVendedorMousePressed(evt);
            }
        });

        lbPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaCliente.setText(".");
        lbPesquisaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaClienteMousePressed(evt);
            }
        });

        lbPesquisaCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaCaixa.setText(".");
        lbPesquisaCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaCaixaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOperacao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbVendedor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCaixa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPesquisaVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisaCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisaCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfOperacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfClienteNome)
                        .addComponent(tfVendedorNome)
                        .addComponent(tfCaiNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bComecar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancelar)
                .addGap(18, 18, 18))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCancelar, bComecar});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfCaixa, tfCliente, tfOperacao, tfVendedor});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbOperacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbVendedor)
                    .addComponent(tfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisaVendedor)
                    .addComponent(tfVendedorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCliente)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisaCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfCaiNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCaixa)
                    .addComponent(tfCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisaCaixa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bComecar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void bComecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bComecarActionPerformed
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
            if (tfOperacao.getText().isEmpty() || (tfVendedor.getText().isEmpty() || tfVendedorNome.getText().isEmpty()) || (tfCaixa.getText().isEmpty() || tfCaiNome.getText().isEmpty()) || (tfCliente.getText().isEmpty() || tfClienteNome.getText().isEmpty())) {
                new Alertas().mensagemAviso("Preencha todos os campos!");
            } else {
                Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
                keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
                KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
                new VendasView(cbOperacao.getSelectedItem().toString(), tfVendedorNome.getText(), tfCaiNome.getText(), ce, lista, ve).setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_bComecarActionPerformed

    private void tfCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCaixaActionPerformed
        pesquisarCaixa();
        if (!tfCaixa.getText().isEmpty() && !tfCaiNome.getText().isEmpty()
                && !tfCliente.getText().isEmpty() && (!tfClienteNome.getText().isEmpty() && !tfClienteNome.getText().equals("") && !tfClienteNome.getText().equals(" "))
                && !tfOperacao.getText().isEmpty() && !tfVendedor.getText().isEmpty()
                && (!tfVendedorNome.getText().isEmpty() && !tfVendedorNome.getText().equals("") && !tfVendedorNome.getText().equals(" "))) {
            System.out.println("tf " + tfVendedorNome.getText());

            Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
            keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
            KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
            new VendasView(cbOperacao.getSelectedItem().toString(), tfVendedorNome.getText(), tfCaiNome.getText(), ce, lista, ve).setVisible(true);
            this.dispose();
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

    private void tfBuscaSequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscaSequenciaActionPerformed
        if (tfBuscaSequencia.getText().isEmpty()) {
            new Alertas().mensagemAviso("Não foi possível buscar esta sequência!\nSequência informada está nula!");
        } else {
            Integer sequencia = Integer.parseInt(tfBuscaSequencia.getText());
            SaidasDAO sDAO = new SaidasDAO();
            VendaEntity ve = new VendaEntity();
            try {
                ve = sDAO.retornaSaida(sequencia);
                if (ve.getClienteID() > 0) {
                    tfCaiNome.setText("");
                    tfCaixa.setText("");
                    tfCliente.setText("");
                    tfClienteNome.setText("");
                    tfOperacao.setText("");
                    tfVendedor.setText("");
                    tfVendedorNome.setText("");
                    cbOperacao.setSelectedIndex(0);

                    cbOperacao.setSelectedItem(ve.getOperacao());
                    String aux = 1 + cbOperacao.getSelectedIndex() + "";
                    tfOperacao.setText(aux);

                    tfCliente.setText(ve.getClienteID().toString());
                    pesquisarCliente();

                    tfCaiNome.setText(ve.getCaixa());
                    CaixaDAO cDAO = new CaixaDAO();
                    String caiAux = cDAO.caixaId(tfCaiNome.getText()) + "";
                    tfCaixa.setText(caiAux);

                    tfVendedorNome.setText(ve.getVendedor());
                    UsuarioDAO uDAO = new UsuarioDAO();
                    String vendAux = uDAO.usuarioID(tfVendedorNome.getText()) + "";
                    tfVendedor.setText(vendAux);

                    ProdutosVendaDAO pvDAO = new ProdutosVendaDAO();
                    lista = pvDAO.listaProdutosDaVenda(ve.getId());
                    this.ve = ve;
                    alerta.mensagemConfirmacao("Cupom inserido com sucesso!");

                } else {
                    alerta.mensagemAviso("Esse Cupom não é valido");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_tfBuscaSequenciaActionPerformed

    private void tfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfClienteActionPerformed
        if (!tfCliente.getText().isEmpty()) {
            pesquisarCliente();
        }
    }//GEN-LAST:event_tfClienteActionPerformed

    private void tfClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfClienteFocusLost
//        pesquisarCliente();
    }//GEN-LAST:event_tfClienteFocusLost

    private void lbPesquisaVendedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaVendedorMousePressed
        PesqCliVenCaixForIniVendaView pesqCli = new PesqCliVenCaixForIniVendaView(this, true, 2);
        pesqCli.setVisible(true);
        tfVendedor.setText(pesqCli.retornaid().toString());
        tfVendedorNome.setText(" ");
        tfVendedor.requestFocus();
    }//GEN-LAST:event_lbPesquisaVendedorMousePressed

    private void lbPesquisaClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaClienteMousePressed
        PesqCliVenCaixForIniVendaView pesqCli = new PesqCliVenCaixForIniVendaView(this, true, 3);
        pesqCli.setVisible(true);
        tfCliente.setText(pesqCli.retornaid().toString());
        tfClienteNome.setText(" ");
        tfCliente.requestFocus();
    }//GEN-LAST:event_lbPesquisaClienteMousePressed

    private void lbPesquisaCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaCaixaMousePressed
        PesqCliVenCaixForIniVendaView pesqCli = new PesqCliVenCaixForIniVendaView(this, true, 4);
        pesqCli.setVisible(true);
        tfCaixa.setText(pesqCli.retornaid().toString());
        tfCaiNome.setText(" ");
        tfCaixa.requestFocus();
    }//GEN-LAST:event_lbPesquisaCaixaMousePressed

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

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void tfOperacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOperacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            actionCamp1();
        }
        atalhos(evt);
    }//GEN-LAST:event_tfOperacaoKeyPressed

    private void tfBuscaSequenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaSequenciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfOperacao.requestFocus();
        }
        atalhos(evt);

    }//GEN-LAST:event_tfBuscaSequenciaKeyPressed

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

    private void tfOperacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOperacaoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfOperacaoKeyTyped

    private void tfVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVendedorKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfVendedorKeyTyped

    private void tfClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfClienteKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfClienteKeyTyped

    private void tfCaixaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCaixaKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCaixaKeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfigurarTelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigurarTelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigurarTelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigurarTelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicializaSaidaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bComecar;
    private javax.swing.JComboBox cbOperacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCaixa;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbOperacao;
    private javax.swing.JLabel lbPesquisaCaixa;
    private javax.swing.JLabel lbPesquisaCliente;
    private javax.swing.JLabel lbPesquisaVendedor;
    private javax.swing.JLabel lbVendedor;
    private javax.swing.JTextField tfBuscaSequencia;
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
                if (caixa.getNome().length() > 1) {
                    tfCaiNome.setText(caixa.getNome());
                }
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
                new VendasView(cbOperacao.getSelectedItem().toString(), tfVendedorNome.getText(), tfCaiNome.getText(), ce, lista, ve).setVisible(true);
                this.dispose();
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
}
