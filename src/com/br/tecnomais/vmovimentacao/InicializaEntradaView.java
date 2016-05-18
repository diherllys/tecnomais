package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.EntradaDAO;
import com.br.tecnomais.dao.ProdutosVendaDAO;
import com.br.tecnomais.entity.EntradasEntity;
import com.br.tecnomais.entity.InicializaEntradaEntity;
import com.br.tecnomais.entity.ProdutosEntradaEntity;
import com.br.tecnomais.entity.UsuarioEntity;
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
public class InicializaEntradaView extends javax.swing.JFrame {

    ProdutosEntradaEntity produtosEntradaEntity = new ProdutosEntradaEntity();
    List<ProdutosEntradaEntity> listProdEntra = new ArrayList();
    Integer sequencia = 0;
    UsuarioEntity us;

    /**
     * Creates new form EntradaView
     */
    public InicializaEntradaView(UsuarioEntity us) {
        this.us = us;
        Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
        keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_F24, 0));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        initComponents();
        desabilitarCampos();
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
        lbPesquisaCaixa2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfFornecedor = new javax.swing.JTextField();
        tfCaixa = new javax.swing.JTextField();
        tfFornecedorNome = new javax.swing.JTextField();
        tfCaiNome = new javax.swing.JTextField();
        bComecar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        cbOperacao = new javax.swing.JComboBox();
        tfOperacao = new javax.swing.JTextField();
        lbPesquisaCaixa = new javax.swing.JLabel();
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

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrada");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfBuscaSequenciaKeyTyped(evt);
            }
        });

        jLabel2.setText("Buscar por Seq.");

        lbPesquisaCaixa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaCaixa2.setText(".");
        lbPesquisaCaixa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaCaixa2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscaSequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPesquisaCaixa2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscaSequencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lbPesquisaCaixa2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Operação");

        jLabel4.setText("Fornecedor");

        jLabel5.setText("Caixa");

        tfFornecedor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfFornecedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfFornecedorFocusLost(evt);
            }
        });
        tfFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFornecedorActionPerformed(evt);
            }
        });
        tfFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFornecedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFornecedorKeyTyped(evt);
            }
        });

        tfCaixa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCaixaFocusGained(evt);
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

        tfFornecedorNome.setEditable(false);
        tfFornecedorNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfFornecedorNome.setEnabled(false);
        tfFornecedorNome.setFocusable(false);

        tfCaiNome.setEditable(false);
        tfCaiNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfCaiNome.setEnabled(false);
        tfCaiNome.setFocusable(false);

        bComecar.setText("Começar-F12");
        bComecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bComecarActionPerformed(evt);
            }
        });
        bComecar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bComecarKeyPressed(evt);
            }
        });

        bCancelar.setText("Cancelar-F5");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        bCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarKeyPressed(evt);
            }
        });

        cbOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AJUSTE DE ESTOQUE", "COMPRA", " ", " " }));
        cbOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOperacaoActionPerformed(evt);
            }
        });
        cbOperacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbOperacaoKeyPressed(evt);
            }
        });

        tfOperacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfOperacao.setText("1");
        tfOperacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfOperacaoFocusGained(evt);
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

        lbPesquisaCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaCaixa.setText(".");
        lbPesquisaCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaCaixaMousePressed(evt);
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbPesquisaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbPesquisaCaixa1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfFornecedor)
                            .addComponent(tfCaixa)
                            .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCaiNome)
                            .addComponent(tfFornecedorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bComecar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCancelar, bComecar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFornecedorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisaCaixa1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCaiNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisaCaixa))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bComecar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfCaiNome, tfCaixa, tfFornecedor, tfFornecedorNome, tfOperacao});

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

    private void tfFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFornecedorFocusLost
    }//GEN-LAST:event_tfFornecedorFocusLost

    private void bComecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bComecarActionPerformed
        iniciaEntrada();
    }//GEN-LAST:event_bComecarActionPerformed

    private void tfFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFornecedorActionPerformed
        if (!tfFornecedor.getText().isEmpty()) {
            pesquisarFornecedor();
        }
    }//GEN-LAST:event_tfFornecedorActionPerformed

    private void tfCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCaixaActionPerformed
        if (!tfCaixa.getText().isEmpty()) {
            pesquisarCaixa();
        }
    }//GEN-LAST:event_tfCaixaActionPerformed

    private void tfBuscaSequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscaSequenciaActionPerformed
        if (tfBuscaSequencia.getText().isEmpty()) {
            sequencia = 0;
            cbOperacao.setSelectedIndex(0);
            tfCaiNome.setText("");
            tfFornecedorNome.setText("");
            listProdEntra = new ArrayList();
        } else {

            EntradaDAO eDAO = new EntradaDAO();
            try {
                EntradasEntity ee = new EntradasEntity();
                ee = eDAO.retornaEntrada(Integer.parseInt(tfBuscaSequencia.getText()));
                if (ee.getCodigoEntrada() > 0) {
                    cbOperacao.setSelectedItem(ee.getOperacao().toUpperCase());

                    tfCaiNome.setText(ee.getCaixa());
                    String caiAux = eDAO.caixaId(tfCaiNome.getText()) + "";
                    tfCaixa.setText(caiAux);

                    tfFornecedorNome.setText(ee.getFornecedor());
                    String forneAux = eDAO.forncedorId(tfFornecedorNome.getText()) + "";
                    tfFornecedor.setText(forneAux);

                    ProdutosVendaDAO pvDAO = new ProdutosVendaDAO();
                    listProdEntra = eDAO.listaProdutosEntradaPorSequencia(Integer.parseInt(tfBuscaSequencia.getText()));
                    for (ProdutosEntradaEntity pee : listProdEntra) {
                        System.out.println(pee.getId());
                    }
//                    for (int i = 0; i < listProdEntra.size(); i++) {
//                        System.out.println(" Removendo ao inciiar cd" + listProdEntra.get(i).getCodigoDinamico() + " cp" + listProdEntra.get(i).getCodigoProduto() + " id" + listProdEntra.get(i).getId());
//                    }

                    sequencia = Integer.parseInt(tfBuscaSequencia.getText());
                    bComecar.requestFocus();
                } else {
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
    }//GEN-LAST:event_tfBuscaSequenciaActionPerformed

    private void tfOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOperacaoActionPerformed
        if (!tfOperacao.getText().isEmpty()) {
            pesquisaOperacao();
        }
    }//GEN-LAST:event_tfOperacaoActionPerformed

    private void tfOperacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOperacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (!tfOperacao.getText().isEmpty()) {
                pesquisaOperacao();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfOperacaoKeyPressed

    private void tfBuscaSequenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaSequenciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfOperacao.requestFocus();
        }
        atalhos(evt);
    }//GEN-LAST:event_tfBuscaSequenciaKeyPressed

    private void tfOperacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOperacaoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfOperacaoKeyTyped

    private void tfFornecedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFornecedorKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfFornecedorKeyTyped

    private void tfCaixaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCaixaKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCaixaKeyTyped

    private void tfCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCaixaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (!tfCaixa.getText().isEmpty()) {
                pesquisarCaixa();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfCaixaKeyPressed

    private void bComecarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bComecarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            bCancelar.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciaEntrada();
        }
        atalhos(evt);
    }//GEN-LAST:event_bComecarKeyPressed

    private void bCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfBuscaSequencia.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
        atalhos(evt);
    }//GEN-LAST:event_bCancelarKeyPressed

    private void tfFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFornecedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (!tfFornecedor.getText().isEmpty()) {
                pesquisarFornecedor();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfFornecedorKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        atalhos(evt);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void cbOperacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbOperacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (!tfOperacao.getText().isEmpty()) {
                pesquisaOperacao();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_cbOperacaoKeyPressed

    private void tfOperacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOperacaoFocusGained
        tfOperacao.selectAll();
    }//GEN-LAST:event_tfOperacaoFocusGained

    private void tfFornecedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFornecedorFocusGained
        tfFornecedor.selectAll();
    }//GEN-LAST:event_tfFornecedorFocusGained

    private void tfCaixaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCaixaFocusGained
        tfCaixa.selectAll();
    }//GEN-LAST:event_tfCaixaFocusGained

    private void cbOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOperacaoActionPerformed
        if (cbOperacao.getSelectedItem().equals("AJUSTE DE ESTOQUE")) {
            tfOperacao.setText("1");
        } else if (cbOperacao.getSelectedItem().equals("COMPRA")) {
            tfOperacao.setText("2");
        }
    }//GEN-LAST:event_cbOperacaoActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void lbPesquisaCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaCaixaMousePressed
        PesqCliVenCaixForIniVendaView pesqCli = new PesqCliVenCaixForIniVendaView(this, true, 4);
        pesqCli.setVisible(true);
        tfCaixa.setText(pesqCli.retornaid().toString());
        if (tfCaixa.getText().equals("0")) {
            tfCaixa.setText("");
        }
        tfCaiNome.setText(" ");
        tfCaixa.requestFocus();
    }//GEN-LAST:event_lbPesquisaCaixaMousePressed

    private void lbPesquisaCaixa1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaCaixa1MousePressed
        PesqCliVenCaixForIniVendaView pesqCli = new PesqCliVenCaixForIniVendaView(this, true, 5);
        pesqCli.setVisible(true);
        tfFornecedor.setText(pesqCli.retornaid().toString());
        if (tfFornecedor.getText().equals("0")) {
            tfFornecedor.setText("");
        }
        tfFornecedorNome.setText(" ");
        tfFornecedor.requestFocus();
    }//GEN-LAST:event_lbPesquisaCaixa1MousePressed

    private void lbPesquisaCaixa2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaCaixa2MousePressed
        PesqCliVenCaixForIniVendaView pesqCli = new PesqCliVenCaixForIniVendaView(this, true, 6);
        pesqCli.setVisible(true);
        tfBuscaSequencia.setText(pesqCli.retornaid().toString());
        if (tfBuscaSequencia.getText().equals("0")) {
            tfBuscaSequencia.setText("");
        }
        tfBuscaSequencia.requestFocus();
    }//GEN-LAST:event_lbPesquisaCaixa2MousePressed

    private void tfBuscaSequenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaSequenciaKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfBuscaSequenciaKeyTyped

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
                new InicializaEntradaView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bComecar;
    private javax.swing.JComboBox cbOperacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbPesquisaCaixa;
    private javax.swing.JLabel lbPesquisaCaixa1;
    private javax.swing.JLabel lbPesquisaCaixa2;
    private javax.swing.JTextField tfBuscaSequencia;
    private javax.swing.JTextField tfCaiNome;
    private javax.swing.JTextField tfCaixa;
    private javax.swing.JTextField tfFornecedor;
    private javax.swing.JTextField tfFornecedorNome;
    private javax.swing.JTextField tfOperacao;
    // End of variables declaration//GEN-END:variables

    private void desabilitarCampos() {
        tfFornecedorNome.setEditable(false);
        //  tfOpNome.setEditable(false);
        tfCaiNome.setEditable(false);
    }

    private void pesquisaOperacao() {
        if (Integer.parseInt(tfOperacao.getText()) < 3) {
            if (tfOperacao.getText().equals("1")) {
                cbOperacao.setSelectedIndex(0);
            } else if (tfOperacao.getText().equals("2")) {
                cbOperacao.setSelectedIndex(1);
            }
            tfFornecedor.requestFocus();
        } else {
            new Alertas().mensagemAviso("Intervalo de operação invalido!");
            tfOperacao.requestFocus();
            tfOperacao.selectAll();
        }
    }

    private void pesquisarFornecedor() {
        try {
            EntradaDAO dao = new EntradaDAO();
            String result = dao.selecionaFornecedor(Integer.parseInt(tfFornecedor.getText()));
            if (result.length() > 1) {
                tfFornecedorNome.setText(result);
                tfCaixa.requestFocus();
            } else {
                tfFornecedorNome.setText("");
                tfFornecedor.selectAll();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisarCaixa() {
        EntradaDAO dao = new EntradaDAO();
        String caixa;
        try {
            caixa = dao.selecionaCaixa(Integer.parseInt(tfCaixa.getText()));
            if (caixa.length() > 1) {
                tfCaiNome.setText(caixa);
                bComecar.requestFocus();
            } else {
                tfCaiNome.setText("");
                tfCaixa.selectAll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(InicializaEntradaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            iniciaEntrada();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            this.dispose();
        }
    }

    private void iniciaEntrada() {
        pesquisaOperacao();
        pesquisarCaixa();
        pesquisarFornecedor();
        if (tfOperacao.getText().isEmpty() || tfFornecedor.getText().isEmpty() || tfCaixa.getText().isEmpty() || tfCaiNome.getText().equals("") || tfFornecedorNome.getText().equals("")) {
            new Alertas().mensagemAviso("Preencha todos os campos!");
        } else {
            pesquisarCaixa();
            pesquisaOperacao();
            pesquisarFornecedor();

            Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
            keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
            KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
            InicializaEntradaEntity iniEntrada = new InicializaEntradaEntity();
            iniEntrada.setOperacao(cbOperacao.getSelectedItem().toString());
            iniEntrada.setFornecedor(tfFornecedorNome.getText());
            iniEntrada.setCaixa(tfCaiNome.getText());
            iniEntrada.setSequencia(sequencia);

            new EntradasView(iniEntrada, listProdEntra, us).setVisible(true);
            this.dispose();
        }
    }
}
