/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.CaixaDAO;
import com.br.tecnomais.dao.ContaPagarDAO;
import com.br.tecnomais.dao.ContasPagasDAO;
import com.br.tecnomais.dao.FornecedorDAO;
import com.br.tecnomais.dao.MovimentacaoDAO;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.ContasPagarEntity;
import com.br.tecnomais.entity.ContasPagasEntity;
import com.br.tecnomais.entity.MovimentacaoEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import com.br.tecnomais.vconfiguracao.FixedLengthDocument;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Usuario
 */
public class ContasApagar extends javax.swing.JFrame implements DocumentListener {

    UsuarioEntity u;
    private static final String COMMIT_ACTION = "commit";
    private final ContaPagarDAO dao = new ContaPagarDAO();
    NovaData nd = new NovaData();
    ContasPagarEntity contasPagarEntity;
    boolean carregouCaixa = false;

    /**
     * Creates new form ContasApagar
     */
    public ContasApagar(Integer id, UsuarioEntity u) {
        super("ContasApagar");
        initComponents();

        preencherCBCaixa();
        cbCaixa.setFocusable(false);

        nd.dataAtual(tfDataEmissao);
        tfVlrParcela.setEnabled(false);
        tfContaN.setEnabled(false);
        tfFornecedor.setDocument(new FixedLengthDocument(44));
        tfX.setDocument(new FixedLengthDocument(2));
//        lbCaixa.setVisible(false);
//        cbCaixa.setVisible(false);

//        if (!tfContaN.getText().isEmpty()) {
//
//        } else {
//           
//        }
        if (id != null && id > 0) {
            try {
                ContasPagarEntity cpe = new ContasPagarEntity();
                cpe = dao.listaContasPagarId(id).get(0);
                preencherCamposPorId(cpe);
                desabilitarCampos();
                contasPagarEntity = cpe;
                bPagar.setVisible(true);
                bExcluir.setVisible(true);
                tfVlrParcela.setVisible(false);

                tfX.setVisible(false);
                lbX.setVisible(false);
                lbVlrParcela.setVisible(false);
                lbIntervaloDias.setVisible(false);
                tfIntervaloDias.setVisible(false);

                cbCaixa.setEnabled(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            cbCaixa.setEnabled(false);
            bExcluir.setVisible(false);
            bPagar.setVisible(false);
            camposEnableTrue();
        }
        if (!cbTipoCobranca.getSelectedItem().toString().equals("PRAZO")) {
            lbIntervaloDias.setVisible(false);
            tfIntervaloDias.setVisible(false);
            lbX.setVisible(false);
            tfX.setVisible(false);
            lbVlrParcela.setVisible(false);
            tfVlrParcela.setVisible(false);
        }
//        tfFornecedor.requestFocus();

        //AutoComplete
        tfFornecedor.getDocument().addDocumentListener(this);
        words = new ArrayList();
        List<String> list = new ArrayList();
        InputMap im = tfFornecedor.getInputMap();
        ActionMap am = tfFornecedor.getActionMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
        am.put(COMMIT_ACTION, new ContasApagar.CommitAction());

        FornecedorDAO fornDAO = new FornecedorDAO();
        try {
            list = fornDAO.nomesFornecedor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            words.add(list.get(i).toUpperCase());
        }

    }

    private void limparCampos() {
        tfContaN.setText("");
        tfDataEmissao.setText("");
        tfDataVencimento.setText("");
        tfDescricao.setText("");
        tfFornecedor.setText("");
        tfIntervaloDias.setValue(1);
        tfObs.setText("");
        tfValoraPagar.setText("");
        cbTipoCobranca.setSelectedIndex(0);
        tfPesquisa.setText("");
    }

    private void desabilitarCampos() {
        tfDataEmissao.setEnabled(false);
        tfDataVencimento.setEnabled(false);
        tfDescricao.setEnabled(false);
        tfFornecedor.setEnabled(false);
        tfIntervaloDias.setEnabled(false);
        tfObs.setEnabled(false);
        tfValoraPagar.setEnabled(false);
        cbTipoCobranca.setEnabled(false);
        tfValoraPagar.setEnabled(false);
        tfX.setEnabled(false);
    }

    private void habilitarCampos() {
        tfDataEmissao.setEnabled(true);
        //continuar aqui
    }

    private void preencherCamposPorId(ContasPagarEntity cpe) {
        tfContaN.setText(cpe.getContaId().toString());
        tfDataEmissao.setText(cpe.getDataEmissao());
        tfDataVencimento.setText(cpe.getDataVencimento());
        tfDescricao.setText(cpe.getDescricao());
        tfFornecedor.setText(cpe.getFornecedor());
        tfObs.setText(cpe.getObs());
        tfValoraPagar.setText(new DecimalFormat("0.00").format(cpe.getVlrPagar() / 100));
        cbTipoCobranca.setSelectedItem(cpe.getTipoCobranca());
    }

    private void pagarContaAdicionarFluxoNegativo() {
        try {
            MovimentacaoDAO movDAO = new MovimentacaoDAO();
            MovimentacaoEntity mov = new MovimentacaoEntity();
//            mov.setIdEntrada(0);
//            mov.setIdConta(0);
//            mov.set
            mov.setDataMovimento(nd.dataAtual());
            mov.setDescricao("PAGAMENTO DE CONTAS DO TIPO : " + cbTipoCobranca.getSelectedItem().toString()
                    + " ");
            mov.setCaixa(cbCaixa.getSelectedItem().toString());
            mov.setIdContaPagar(Integer.parseInt(tfContaN.getText()));
            mov.setTipoMovimento("SAIDA");
            mov.setValor(Double.parseDouble(tfValoraPagar.getText().replace(",", ".").replace(".", "")));
            movDAO.gravarSaida(mov);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void transfEmContaPagas() {
        try {
            ContasPagasEntity cpe = new ContasPagasEntity();
            cpe.setContaPagarId(Integer.parseInt(tfContaN.getText()));
            cpe.setDataPagamento(nd.dataAtual());
            cpe.setDataVencimento(tfDataVencimento.getText());
            cpe.setDescricao(tfDescricao.getText());
            cpe.setEntradaId(this.contasPagarEntity.getEntradaId());
            cpe.setFornecedor(tfFornecedor.getText());
            cpe.setObs(tfObs.getText());
            cpe.setTipoCobranca(cbTipoCobranca.getSelectedItem().toString());
            cpe.setCaixa(cbCaixa.getSelectedItem().toString());
            if (u == null) {
                cpe.setUsuario("UNKNOW");
            } else {
                cpe.setUsuario(u.getId() + "-" + u.getNome_usuario());
            }
            cpe.setVlrPago(Double.parseDouble(tfValoraPagar.getText().replace(",", ".").replace(".", "")));
            ContasPagasDAO cpDAO = new ContasPagasDAO();
            cpDAO.save(cpe);
            ContaPagarDAO contasPagarDAO = new ContaPagarDAO();
            contasPagarDAO.updateStatus(cpe.getContaPagarId(), "OFF");
//            contasPagarDAO.deletarConta(cpe.getContaPagarId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static enum Mode {

        INSERT, COMPLETION
    };
    private final List<String> words;
    private ContasApagar.Mode mode = ContasApagar.Mode.INSERT;

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
        jLabel2 = new javax.swing.JLabel();
        tfContaN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDataVencimento = new javax.swing.JFormattedTextField();
        tfDescricao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfValoraPagar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbTipoCobranca = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfObs = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tfIntervaloDias = new javax.swing.JSpinner();
        lbIntervaloDias = new javax.swing.JLabel();
        lbPesquisaFornecedor = new javax.swing.JLabel();
        bNova = new javax.swing.JButton();
        lbPesquisaFornecedor1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfFornecedor = new javax.swing.JTextArea();
        tfDataEmissao = new javax.swing.JFormattedTextField();
        lbX = new javax.swing.JLabel();
        tfX = new javax.swing.JTextField();
        lbVlrParcela = new javax.swing.JLabel();
        tfVlrParcela = new javax.swing.JTextField();
        bPagar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        lbCaixa = new javax.swing.JLabel();
        cbCaixa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Conta a Pagar");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jLabel2.setText("Conta Nº:");

        jLabel3.setText("Descrição:");

        jLabel4.setText("Data de Emissão:");

        jLabel5.setText("Data de Vencimento:");

        try {
            tfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Valor á Pagar:");

        tfValoraPagar.setText("0.00");
        tfValoraPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValoraPagarActionPerformed(evt);
            }
        });

        jLabel7.setText("Fornecedor:");

        jLabel8.setText("Tipo de cobrança:");

        cbTipoCobranca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DINHEIRO", "PRAZO", "CARTAO DE CREDITO", "CARTAO DE DEBITO", "CHEQUE", "BOLETO" }));
        cbTipoCobranca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoCobrancaActionPerformed(evt);
            }
        });

        jLabel9.setText("Obs:");

        tfObs.setColumns(20);
        tfObs.setLineWrap(true);
        tfObs.setRows(5);
        jScrollPane2.setViewportView(tfObs);

        jLabel10.setText("Pesquisa:");

        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfIntervaloDias.setModel(new javax.swing.SpinnerNumberModel(1, 1, 90, 1));

        lbIntervaloDias.setText("Intervalo de Dias:");

        lbPesquisaFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaFornecedor.setText(".");
        lbPesquisaFornecedor.setToolTipText("Pesquisar Fornecedor");
        lbPesquisaFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaFornecedorMousePressed(evt);
            }
        });

        bNova.setText("Nova");
        bNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovaActionPerformed(evt);
            }
        });

        lbPesquisaFornecedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N
        lbPesquisaFornecedor1.setText(".");
        lbPesquisaFornecedor1.setToolTipText("Filtros");
        lbPesquisaFornecedor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbPesquisaFornecedor1MousePressed(evt);
            }
        });

        tfFornecedor.setColumns(1);
        tfFornecedor.setRows(1);
        tfFornecedor.setTabSize(1);
        tfFornecedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tfFornecedorAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tfFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfFornecedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfFornecedorFocusLost(evt);
            }
        });
        tfFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFornecedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFornecedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFornecedorKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(tfFornecedor);

        try {
            tfDataEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbX.setText("  x");

        tfX.setText("1");

        lbVlrParcela.setText("Vlr Parcela:");

        tfVlrParcela.setText("0.00");
        tfVlrParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVlrParcelaActionPerformed(evt);
            }
        });

        bPagar.setText("Pagar");
        bPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPagarActionPerformed(evt);
            }
        });

        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        lbCaixa.setText("Caixa:");

        cbCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));
        cbCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbCaixaFocusGained(evt);
            }
        });
        cbCaixa.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCaixaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCaixaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbCaixaMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbCaixaMousePressed(evt);
            }
        });
        cbCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCaixaActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNova)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(lbCaixa))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2)))
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfContaN)
                                            .addComponent(cbCaixa, 0, 107, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(tfDescricao)
                                    .addComponent(jScrollPane3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbPesquisaFornecedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbIntervaloDias))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbPesquisaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6))))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(450, 450, 450)
                                .addComponent(lbVlrParcela)
                                .addGap(23, 23, 23)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfVlrParcela, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbTipoCobranca, javax.swing.GroupLayout.Alignment.LEADING, 0, 144, Short.MAX_VALUE)
                                .addComponent(tfValoraPagar, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfDataVencimento, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(tfIntervaloDias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbX, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfX, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bNova, bPagar, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfX, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfIntervaloDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPesquisaFornecedor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbX)
                        .addComponent(lbCaixa)
                        .addComponent(cbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbIntervaloDias)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfContaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfValoraPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbTipoCobranca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPesquisaFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbVlrParcela)
                            .addComponent(tfVlrParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(bNova)
                    .addComponent(bPagar)
                    .addComponent(bExcluir))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane3, tfContaN, tfDataEmissao, tfDataVencimento, tfDescricao, tfIntervaloDias, tfPesquisa, tfValoraPagar});

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

    private void lbPesquisaFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaFornecedorMousePressed
        if (tfContaN.getText().isEmpty()) {
            PesqCliVenCaixForIniVendaView pesqCli = new PesqCliVenCaixForIniVendaView(this, true, 5);
            pesqCli.setVisible(true);
            tfFornecedor.setText(pesqCli.getStr());
            tfFornecedor.requestFocus();
        }
    }//GEN-LAST:event_lbPesquisaFornecedorMousePressed

    private void lbPesquisaFornecedor1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisaFornecedor1MousePressed
        this.dispose();
        new ContaPagarListView(u).setVisible(true);
    }//GEN-LAST:event_lbPesquisaFornecedor1MousePressed

    private void tfFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFornecedorKeyPressed
        if (tfFornecedor.getText().length() == 44 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                tfFornecedor.setText(tfFornecedor.getText().toUpperCase());
                evt.consume();
            }
            if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                evt.consume();
                tfObs.requestFocus();
            }
        }
    }//GEN-LAST:event_tfFornecedorKeyPressed

    private void tfFornecedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFornecedorKeyTyped
//        if (tfFornecedor.getText().length() >= 44) {
//            evt.consume();
//        }
    }//GEN-LAST:event_tfFornecedorKeyTyped

    private void tfFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFornecedorKeyReleased


    }//GEN-LAST:event_tfFornecedorKeyReleased

    private void tfFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFornecedorFocusLost
        tfFornecedor.setText(tfFornecedor.getText().toUpperCase());
    }//GEN-LAST:event_tfFornecedorFocusLost

    private void tfFornecedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFornecedorFocusGained

    }//GEN-LAST:event_tfFornecedorFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ContasPagarEntity cae = new ContasPagarEntity();
        cae.setDataEmissao(tfDataEmissao.getText());
        cae.setDataVencimento(tfDataVencimento.getText());
        cae.setDescricao(tfDescricao.getText());
        cae.setEntradaId(0);
        cae.setFornecedor(tfFornecedor.getText());
        cae.setObs(tfObs.getText());

        if (u == null) {
            cae.setUsuario("UNKNOW");
        } else {
            cae.setUsuario(u.getId() + "-" + u.getNome_usuario());
        }
        cae.setVlrPagar(Double.parseDouble(tfValoraPagar.getText().replace(",", ".").replace(".", "")));

        ContaPagarDAO cpDAO = new ContaPagarDAO();
        int x = Integer.parseInt(tfX.getText());
        if (x < 0 || tfX.isVisible() == false) {
            x = 1;
        }
        if (cbTipoCobranca.getSelectedItem().toString().equals("PRAZO")) {
            Double auxVlrPagar;
            auxVlrPagar = cae.getVlrPagar() / x;
            cae.setVlrPagar(auxVlrPagar);
        }

        Integer intervalo = (Integer) tfIntervaloDias.getValue();
        String vencAtual = cae.getDataVencimento();
        cae.setTipoCobranca(cbTipoCobranca.getSelectedItem().toString());
        for (int t = 0; t < x; t++) {
            cae.setDataVencimento(vencAtual);
            if (tfFornecedor.getText().isEmpty()) {
                cpDAO.save(cae);
                desabilitarCampos();
                if (t == x) {
                    new Alertas().mensagemConfirmacao("Conta Salva com Sucesso!");
                    System.out.println("Foi salvo vazio");
                }
                vencAtual = nd.adicionaDias(vencAtual, intervalo);
            } else {
                boolean status = false;
                for (int i = 0; i < words.size(); i++) {
                    if (tfFornecedor.getText().equals(words.get(i))) {
                        cpDAO.save(cae);
                        desabilitarCampos();
                        vencAtual = nd.adicionaDias(vencAtual, intervalo);
                        status = true;
                        if (t == x) {
                            System.out.println("Foi salvo o distribuidor contem na lista");
                            new Alertas().mensagemConfirmacao("Conta Salva com Sucesso!");
                        }
                    }
                }
                if (status == false) {
                    new Alertas().mensagemAviso("O Fornecedor não consta na base de dados, tente novamente");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfFornecedorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tfFornecedorAncestorAdded

    }//GEN-LAST:event_tfFornecedorAncestorAdded

    private void bNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovaActionPerformed
        limparCampos();
//        habilitarCampos();
        camposEnableTrue();
    }//GEN-LAST:event_bNovaActionPerformed

    private void cbTipoCobrancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoCobrancaActionPerformed
        if (!cbTipoCobranca.getSelectedItem().toString().equals("PRAZO")) {
            lbIntervaloDias.setVisible(false);
            tfIntervaloDias.setVisible(false);
            lbX.setVisible(false);
            tfX.setVisible(false);
            lbVlrParcela.setVisible(false);
            tfVlrParcela.setVisible(false);
        } else {
            lbIntervaloDias.setVisible(true);
            tfIntervaloDias.setVisible(true);
            lbX.setVisible(true);
            tfX.setVisible(true);
            lbVlrParcela.setVisible(true);
            tfVlrParcela.setVisible(true);
        }
    }//GEN-LAST:event_cbTipoCobrancaActionPerformed

    private void tfVlrParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVlrParcelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfVlrParcelaActionPerformed

    private void bPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPagarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente pagar a conta selecionada?", "Opcões", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (!cbCaixa.getSelectedItem().toString().equals("...")) {
            if (opcao == JOptionPane.YES_OPTION) {
                pagarContaAdicionarFluxoNegativo();
                transfEmContaPagas();
                camposEnableTrue();
                limparCampos();
                new Alertas().mensagemConfirmacao("A conta foi paga com sucesso! Gerando uma Saída no Fluxo de Caixa");
            }
        }
    }//GEN-LAST:event_bPagarActionPerformed

    private void tfValoraPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValoraPagarActionPerformed
//        if(!tfValoraPagar.getText().contains(".") && !tfValoraPagar.getText().contains(",")){
//            tfValoraPagar.setText(tfValoraPagar.getText()+".00");
//        }
        if (!tfValoraPagar.getText().contains(".")) {
            if (!tfValoraPagar.getText().contains(",")) {
                tfValoraPagar.setText(tfValoraPagar.getText() + ".00");
//            }else if(tfVlrParcela.getText().substring(tfVlrParcela.getText().size, WIDTH)){

            }
        }
//         tfValoraPagar.setText(tfValoraPagar.getText()+".00");
//        tfValoraPagar.setText(new DecimalFormat().format(Double.parseDouble(tfValoraPagar.getText().replace(",", "."))));
    }//GEN-LAST:event_tfValoraPagarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a conta selecionada?", "Opcões", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (opcao == JOptionPane.YES_OPTION && contasPagarEntity.getEntradaId() == 0) {
            ContaPagarDAO contasPagarDAO = new ContaPagarDAO();
            contasPagarDAO.deletarConta(Integer.parseInt(tfContaN.getText()));
            limparCampos();
            new Alertas().mensagemConfirmacao("A conta foi apaga com sucesso! Gerando uma Saída no Fluxo de Caixa Geral do Sistema");
        } else {
            new Alertas().mensagemAviso("A conta não pode ser excluida, pois esta vinculada a uma Entrada!");
        }
    }//GEN-LAST:event_bExcluirActionPerformed

    private void cbCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCaixaActionPerformed
//        CaixaDAO caiDAO = new CaixaDAO();
//        try {
//            CaixaEntity cls = new CaixaEntity();
//            for (String str : caiDAO.todosCaixaNome()) {
//                cbCaixa.addItem(str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_cbCaixaActionPerformed

    private void cbCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCaixaMousePressed

    }//GEN-LAST:event_cbCaixaMousePressed

    private void cbCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCaixaMouseClicked
//        CaixaDAO caiDAO = new CaixaDAO();
//        try {
//            CaixaEntity cls = new CaixaEntity();
//            for (String str : caiDAO.todosCaixaNome()) {
//                cbCaixa.addItem(str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_cbCaixaMouseClicked

    private void cbCaixaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCaixaPopupMenuWillBecomeInvisible
//         CaixaDAO caiDAO = new CaixaDAO();
//        try {
//            CaixaEntity cls = new CaixaEntity();
//            for (String str : caiDAO.todosCaixaNome()) {
//                cbCaixa.addItem(str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_cbCaixaPopupMenuWillBecomeInvisible

    private void cbCaixaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbCaixaFocusGained
//        CaixaDAO caiDAO = new CaixaDAO();
//        try {
//            CaixaEntity cls = new CaixaEntity();
//            for (String str : caiDAO.todosCaixaNome()) {
//                cbCaixa.addItem(str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_cbCaixaFocusGained

    private void cbCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCaixaMouseEntered
    }//GEN-LAST:event_cbCaixaMouseEntered

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContasApagar(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bNova;
    private javax.swing.JButton bPagar;
    private javax.swing.JComboBox cbCaixa;
    private javax.swing.JComboBox cbTipoCobranca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCaixa;
    private javax.swing.JLabel lbIntervaloDias;
    private javax.swing.JLabel lbPesquisaFornecedor;
    private javax.swing.JLabel lbPesquisaFornecedor1;
    private javax.swing.JLabel lbVlrParcela;
    private javax.swing.JLabel lbX;
    private javax.swing.JTextField tfContaN;
    private javax.swing.JFormattedTextField tfDataEmissao;
    private javax.swing.JFormattedTextField tfDataVencimento;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextArea tfFornecedor;
    private javax.swing.JSpinner tfIntervaloDias;
    private javax.swing.JTextArea tfObs;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JTextField tfValoraPagar;
    private javax.swing.JTextField tfVlrParcela;
    private javax.swing.JTextField tfX;
    // End of variables declaration//GEN-END:variables

    public void changedUpdate(DocumentEvent ev) {
    }

    public void removeUpdate(DocumentEvent ev) {
    }

    public void insertUpdate(DocumentEvent ev) {
        if (ev.getLength() != 1) {
            return;
        }

        int pos = ev.getOffset();
        String content = null;
        try {
            content = tfFornecedor.getText(0, pos + 1);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Find where the word starts
        int w;
        for (w = pos; w >= 0; w--) {
//            if (!Character.isLetter(content.charAt(w))) {
//                break;
//            }
        }
        if (pos - w < 2) {
            // Too few chars
            return;
        }

        String prefix = content.substring(w + 1).toUpperCase();//ra pesquisar com letra maiuscula
        int n = Collections.binarySearch(words, prefix);
        if (n < 0 && -n <= words.size()) {
            String match = words.get(-n - 1);
            if (match.startsWith(prefix)) {
                // A completion is found
                String completion = match.substring(pos - w).toUpperCase();//tamanho da letra do autocomplete
                // We cannot modify Document from within notification,
                // so we submit a task that does the change later
                SwingUtilities.invokeLater(
                        new CompletionTask(completion, pos + 1));
            }
        } else {
            // Nothing found
            mode = ContasApagar.Mode.INSERT;

        }
    }

    private class CompletionTask implements Runnable {

        String completion;
        int position;

        CompletionTask(String completion, int position) {
            this.completion = completion;
            this.position = position;
        }

        public void run() {
            tfFornecedor.insert(completion, position);
            tfFornecedor.setCaretPosition(position + completion.length());
            tfFornecedor.moveCaretPosition(position);
            mode = ContasApagar.Mode.COMPLETION;
        }
    }

    private class CommitAction extends AbstractAction {

        public void actionPerformed(ActionEvent ev) {
            if (mode == ContasApagar.Mode.COMPLETION) {
                int pos = tfFornecedor.getSelectionEnd();
                tfFornecedor.insert("", pos);
//                   tfFornecedor.insert(" ", pos);
                tfFornecedor.setCaretPosition(pos);
//                    tfFornecedor.setCaretPosition(pos+1);
                mode = ContasApagar.Mode.INSERT;
            } else {
                tfFornecedor.replaceSelection("\n");
            }
        }
    }

    public void camposEnableTrue() {
        tfDataEmissao.setEnabled(true);
        tfDataVencimento.setEnabled(true);
        tfDescricao.setEnabled(true);
        tfFornecedor.setEnabled(true);
        tfIntervaloDias.setEnabled(true);
        tfObs.setEnabled(true);
        tfValoraPagar.setEnabled(true);
        cbTipoCobranca.setEnabled(true);
        tfValoraPagar.setEnabled(true);

        tfX.setEnabled(true);
        lbIntervaloDias.setVisible(true);
        tfIntervaloDias.setVisible(true);
        //        tfVlrParcela.setEnabled(true);
    }

    public void preencherCBCaixa() {
        CaixaDAO caiDAO = new CaixaDAO();
        try {
            CaixaEntity cls = new CaixaEntity();
//            cbCaixa.addItem("...");
            for (String str : caiDAO.todosCaixaNome()) {
                cbCaixa.addItem(str);
            }
            carregouCaixa = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
