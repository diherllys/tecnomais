package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.Dinheiro;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.classes.ValidarCamposNumericos;
import com.br.tecnomais.dao.EntradaDAO;
import com.br.tecnomais.dao.OperacaoDAO;
import com.br.tecnomais.dao.ProdutoDAO;
import com.br.tecnomais.entity.EntradasEntity;
import com.br.tecnomais.entity.ProdutosEntradaEntity;
import com.br.tecnomais.entity.InicializaEntradaEntity;
import com.br.tecnomais.entity.OperacaoEntity;
import com.br.tecnomais.entity.ProdutoEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class EntradasView extends javax.swing.JFrame implements EntradaFinanceiroListener {

    private final Alertas alerta = new Alertas();
    private List<ProdutosEntradaEntity> listaProdutos = new ArrayList<>();
    private Double precoBanco;
    private Double qntBanco;
    private String classe;
    private final ProdutoDAO pd = new ProdutoDAO();
    private double vlrFinal;
    private int codigoRemovido = 0;
    private boolean cont = true;
    private String unidadeVenda = "";
    private EntradaDAO entDao = new EntradaDAO();
    private boolean statusGravacao = true;
    private Integer entradaAtual;
    Integer sequencia = 0;
    private List<ProdutosEntradaEntity> listaReserva = new ArrayList<>();
    boolean statusBGravar = false;
    boolean statusBEstoque = false;
    boolean statusBFinanceiro = false;
    UsuarioEntity u;
    Integer idAtual = 0;

    /**
     * Creates new form EntradasView
     */
    public EntradasView(InicializaEntradaEntity iniEntrada, List<ProdutosEntradaEntity> listProdEE, UsuarioEntity u) {
        initComponents();
        this.u = u;
        lbStatusEstq.setOpaque(true);
        lbStatusFinanceiro.setOpaque(true);

        tfProduto.requestFocusInWindow();
        sequencia = iniEntrada.getSequencia();
        tfCodigoProduto.setVisible(false);
        preencheCamposPadrao(iniEntrada);//sequencia
        listaReserva = listProdEE;
        System.out.println("inientrada = " + iniEntrada.getSequencia());

        try {
            if (sequencia == 0 || sequencia == null) {
                statusBGravar = false;
                sequencia = 0;
                statusBFinanceiro = false;
            } else {
                statusBGravar = true;
                financeiroFinalizado();
                lbStatusEstq.setOpaque(true);
                if (entDao.estoqueFoiEfetivado(sequencia)) {
                    Color cor = new Color(0, 153, 255);
                    lbStatusEstq.setBackground(cor);
                    cbOperacao.setEnabled(false);
                    statusBEstoque = true;
                } else {
                    Color cor = new Color(255, 255, 255);
                    lbStatusEstq.setBackground(cor);
                    //lbStatusEstq.setOpaque(true);
                    cbOperacao.setEnabled(true);
                    statusBEstoque = false;
                    System.out.println("estoque ainda não foi efetivado");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (listProdEE.size() > 0) {
            for (int i = 0; i < listProdEE.size(); i++) {
                listaProdutos.add(listProdEE.get(i));
                preencherTabelaSequencia();
            }
            if (cbOperacao.getSelectedItem().toString().equals("COMPRA")) {

            }

        }
        // preencherComboBoxOperacao();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfQuantidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTabela = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        tfProduto = new javax.swing.JTextField();
        tfDescontoReal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfPrecoUnitario = new javax.swing.JTextField();
        tfPrecoFinal = new javax.swing.JTextField();
        tfPrecoTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfDescontoPorcentagem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lbValorFinal = new javax.swing.JLabel();
        lbEstoqueB = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbGravarB = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbFinanceiroB = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfCodigoProduto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbFornecedor = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbOperacao = new javax.swing.JComboBox();
        lbCaixa = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbSequencia = new javax.swing.JLabel();
        lbStatusEstq = new javax.swing.JLabel();
        lbStatusFinanceiro = new javax.swing.JLabel();
        lbCaixaEdit = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tfDescricaoProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        tfQuantidade.setText("1");
        tfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfQuantidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantidadeFocusLost(evt);
            }
        });
        tfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantidadeActionPerformed(evt);
            }
        });
        tfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyTyped(evt);
            }
        });

        jTTabela.setAutoCreateRowSorter(true);
        jTTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Classe", "Qtde.", "Preço Unit.", "Preço Total", "Caixa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTTabela.getTableHeader().setReorderingAllowed(false);
        jTTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTabelaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTTabelaMousePressed(evt);
            }
        });
        jTTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTabelaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTTabela);
        if (jTTabela.getColumnModel().getColumnCount() > 0) {
            jTTabela.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/addcccc.png"))); // NOI18N
        jLabel20.setText("1");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });

        tfProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfProdutoFocusLost(evt);
            }
        });
        tfProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProdutoActionPerformed(evt);
            }
        });
        tfProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfProdutoKeyPressed(evt);
            }
        });

        tfDescontoReal.setText("0,00");
        tfDescontoReal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDescontoRealFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoRealFocusLost(evt);
            }
        });
        tfDescontoReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescontoRealActionPerformed(evt);
            }
        });
        tfDescontoReal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDescontoRealKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescontoRealKeyReleased(evt);
            }
        });

        jLabel2.setText("Qtde.*");

        jLabel3.setText("Preço Unitário*");

        tfPrecoUnitario.setText("0,00");
        tfPrecoUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPrecoUnitarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPrecoUnitarioFocusLost(evt);
            }
        });
        tfPrecoUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecoUnitarioActionPerformed(evt);
            }
        });
        tfPrecoUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPrecoUnitarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPrecoUnitarioKeyReleased(evt);
            }
        });

        tfPrecoFinal.setEditable(false);
        tfPrecoFinal.setText("0,00");
        tfPrecoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecoFinalActionPerformed(evt);
            }
        });

        tfPrecoTotal.setText("0,00");
        tfPrecoTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPrecoTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPrecoTotalFocusLost(evt);
            }
        });
        tfPrecoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecoTotalActionPerformed(evt);
            }
        });
        tfPrecoTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPrecoTotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPrecoTotalKeyReleased(evt);
            }
        });

        jLabel6.setText("Desc. (R$)");

        jLabel7.setText("Preço Final");

        jLabel1.setText("Produto*");

        tfDescontoPorcentagem.setText("0,00");
        tfDescontoPorcentagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDescontoPorcentagemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoPorcentagemFocusLost(evt);
            }
        });
        tfDescontoPorcentagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescontoPorcentagemActionPerformed(evt);
            }
        });
        tfDescontoPorcentagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDescontoPorcentagemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescontoPorcentagemKeyReleased(evt);
            }
        });

        jLabel4.setText("Preço Total*");

        jLabel5.setText("Desc. (%)");

        jPanel2.setBackground(new java.awt.Color(180, 190, 190));

        jLabel19.setText("Imprimir-F6");

        lbValorFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbValorFinal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbValorFinal.setText("0,00");

        lbEstoqueB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEstoqueB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/estoque205.png"))); // NOI18N
        lbEstoqueB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEstoqueB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbEstoqueBMousePressed(evt);
            }
        });

        jLabel9.setText("Gravar-F2");

        lbGravarB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGravarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/salvar.png"))); // NOI18N
        lbGravarB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbGravarB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGravarBMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbGravarBMousePressed(evt);
            }
        });

        jLabel15.setText("Estoque-F4");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/imprimir.png"))); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/novolimpa.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
            }
        });

        lbFinanceiroB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFinanceiroB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/financeiro.png"))); // NOI18N
        lbFinanceiroB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFinanceiroB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbFinanceiroBMousePressed(evt);
            }
        });
        lbFinanceiroB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbFinanceiroBKeyPressed(evt);
            }
        });

        jLabel13.setText("Financeiro-F3");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Total:");

        jLabel17.setText("Nova-F5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(lbGravarB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbFinanceiroB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(lbEstoqueB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValorFinal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(tfCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGravarB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(tfCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValorFinal)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFinanceiroB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEstoqueB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(180, 190, 190));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Entrada");

        jLabel22.setText("Fornecedor:");

        lbFornecedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbFornecedor.setText(".");

        jLabel24.setText("Operação:");

        cbOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AJUSTE DE ESTOQUE", "COMPRA" }));
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

        lbCaixa.setBackground(new java.awt.Color(51, 102, 255));
        lbCaixa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCaixa.setForeground(new java.awt.Color(255, 255, 255));
        lbCaixa.setText("Box");
        lbCaixa.setOpaque(true);

        jLabel10.setText("Sequencia:");

        lbSequencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSequencia.setText(".");

        lbStatusEstq.setBackground(new java.awt.Color(255, 255, 255));
        lbStatusEstq.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbStatusEstq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatusEstq.setText("E");
        lbStatusEstq.setToolTipText("Estoque");

        lbStatusFinanceiro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbStatusFinanceiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatusFinanceiro.setText("F");
        lbStatusFinanceiro.setToolTipText("Financeiro");

        lbCaixaEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/edit-op-us 16x.png"))); // NOI18N
        lbCaixaEdit.setToolTipText("Altera o Vendedor");
        lbCaixaEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCaixaEditMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbCaixaEditMouseReleased(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/edit-op-us 16x.png"))); // NOI18N
        jLabel25.setToolTipText("Altera o Vendedor");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel25MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel25MouseReleased(evt);
            }
        });

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/edit-op-us 16x.png"))); // NOI18N
        jLabel26.setToolTipText("Altera o Vendedor");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel26MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel26MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(31, 31, 31)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbStatusEstq, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatusFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbCaixaEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCaixaEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(lbFornecedor)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel24)
                        .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbStatusEstq)
                        .addComponent(lbStatusFinanceiro)
                        .addComponent(jLabel10)
                        .addComponent(lbSequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tfDescricaoProduto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfDescricaoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDescricaoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescricaoProdutoFocusLost(evt);
            }
        });
        tfDescricaoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescricaoProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDescontoPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addComponent(tfDescricaoProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescontoReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfPrecoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfDescontoPorcentagem, tfDescontoReal, tfPrecoFinal});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDescontoPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDescontoReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrecoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel20, tfPrecoFinal});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        new Alertas().mensagemAviso("teste");
    }//GEN-LAST:event_formKeyReleased

    private void lbGravarBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGravarBMouseClicked
//        salvarEntrada();
    }//GEN-LAST:event_lbGravarBMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        limparCampos();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked

    }//GEN-LAST:event_jLabel20MouseClicked

    private void jTTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTabelaMouseClicked

    }//GEN-LAST:event_jTTabelaMouseClicked

    private void tfProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProdutoFocusLost
//        new PesquisaProdutoView().setVisible(true);
    }//GEN-LAST:event_tfProdutoFocusLost

    private void tfProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProdutoActionPerformed
        if (tfProduto.getText().isEmpty()) {
            pesquisaProdutoVazio();
            tfQuantidade.selectAll();
        } else {
            String aux = tfProduto.getText();
            char[] c = aux.toCharArray();
            char d = c[0];

            for (int i = 0; i < c.length; i++) {
                if (!Character.isDigit(c[i])) {
                    d = c[i];
                }

            }
            if (!Character.isDigit(d)) {
                pesquisaProdutoVazio();
            } else {
                try {
                    pesquisaProdutoForCodigoBarrasOrId();
                    //    tfQuantidade.selectAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            pesquisaProdutoForCodigoBarrasOrId();
        }
    }//GEN-LAST:event_tfProdutoActionPerformed

    private void tfDescontoRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescontoRealActionPerformed
        tfPrecoFinal.requestFocus();
//        descontoReal();
    }//GEN-LAST:event_tfDescontoRealActionPerformed

    private void tfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantidadeActionPerformed
        if (tfQuantidade.getText().isEmpty()) {
            new Alertas().mensagemAviso("Quantidade não pode ser vazia!");
        } else {
            double qnt = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
            if (qnt <= 0) {
                new Alertas().mensagemAviso("Quantidade inválida!");
            } else {
                tfPrecoUnitario.requestFocus();
                tfPrecoUnitario.selectAll();
            }
        }
    }//GEN-LAST:event_tfQuantidadeActionPerformed

    private void tfPrecoUnitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioFocusGained
        tfPrecoUnitario.selectAll();
    }//GEN-LAST:event_tfPrecoUnitarioFocusGained

    private void tfPrecoUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioFocusLost
        tfDescontoPorcentagem.requestFocus();
        calculaPrecoTotal();
    }//GEN-LAST:event_tfPrecoUnitarioFocusLost

    private void tfPrecoUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioActionPerformed
        tfDescontoPorcentagem.requestFocus();
    }//GEN-LAST:event_tfPrecoUnitarioActionPerformed

    private void tfPrecoTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoTotalKeyReleased

    }//GEN-LAST:event_tfPrecoTotalKeyReleased

    private void tfPrecoTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoTotalKeyPressed

    }//GEN-LAST:event_tfPrecoTotalKeyPressed

    private void tfPrecoTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoTotalFocusGained
        tfPrecoTotal.setEnabled(false);
    }//GEN-LAST:event_tfPrecoTotalFocusGained

    private void tfPrecoTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoTotalFocusLost
        tfPrecoTotal.setEnabled(true);
    }//GEN-LAST:event_tfPrecoTotalFocusLost

    private void tfDescontoPorcentagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoPorcentagemFocusLost
        calculaPrecoFinal();
    }//GEN-LAST:event_tfDescontoPorcentagemFocusLost

    private void tfDescontoPorcentagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescontoPorcentagemActionPerformed
        tfPrecoFinal.requestFocus();
    }//GEN-LAST:event_tfDescontoPorcentagemActionPerformed

    private void tfDescontoRealFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoRealFocusLost
        descontoReal();
    }//GEN-LAST:event_tfDescontoRealFocusLost

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        adicionaProdutoLista();
        if (statusBEstoque == true) {
            preencherTabelaSequencia();
        } else {
            preencherTabela();
        }
    }//GEN-LAST:event_jLabel20MousePressed

    private void tfProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoKeyPressed
        eventoConsulta(evt);
        atalhos(evt);
    }//GEN-LAST:event_tfProdutoKeyPressed

    private void tfPrecoUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioKeyReleased
        new ValidarCamposNumericos().validar(tfPrecoUnitario);
        tfPrecoUnitario.setText(new Dinheiro().dinheiro(tfPrecoUnitario.getText()));
    }//GEN-LAST:event_tfPrecoUnitarioKeyReleased

    private void tfDescontoPorcentagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoPorcentagemKeyReleased

    }//GEN-LAST:event_tfDescontoPorcentagemKeyReleased

    private void tfDescontoRealKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoRealKeyReleased
        new ValidarCamposNumericos().validar(tfDescontoReal);
        tfDescontoReal.setText(new Dinheiro().dinheiro(tfDescontoReal.getText()));
    }//GEN-LAST:event_tfDescontoRealKeyReleased

    private void tfPrecoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoFinalActionPerformed
        adicionaProdutoLista();
        preencherTabela();
    }//GEN-LAST:event_tfPrecoFinalActionPerformed

    private void tfDescricaoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescricaoProdutoFocusGained
        tfDescricaoProduto.setEnabled(false);
    }//GEN-LAST:event_tfDescricaoProdutoFocusGained

    private void tfDescricaoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescricaoProdutoFocusLost
        tfDescricaoProduto.setEnabled(true);
    }//GEN-LAST:event_tfDescricaoProdutoFocusLost

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
        novaEntradaAction();
    }//GEN-LAST:event_jLabel16MousePressed

    private void jTTabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTabelaMousePressed
        int linha = jTTabela.getSelectedRow();
        codigoRemovido = Integer.parseInt(jTTabela.getValueAt(linha, 0).toString());
        System.out.println(codigoRemovido);
        cont = false;
    }//GEN-LAST:event_jTTabelaMousePressed

    private void lbEstoqueBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEstoqueBMousePressed
        efetivarEstoqueAction();
    }//GEN-LAST:event_lbEstoqueBMousePressed

    private void tfDescricaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescricaoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescricaoProdutoActionPerformed

    private void tfQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyReleased

    }//GEN-LAST:event_tfQuantidadeKeyReleased

    private void lbGravarBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGravarBMousePressed
        gravarEntradaAction();
    }//GEN-LAST:event_lbGravarBMousePressed

    private void tfPrecoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrecoTotalActionPerformed

    private void tfQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusGained
        tfQuantidade.selectAll();
    }//GEN-LAST:event_tfQuantidadeFocusGained

    private void tfDescontoPorcentagemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoPorcentagemFocusGained
        tfDescontoPorcentagem.selectAll();
    }//GEN-LAST:event_tfDescontoPorcentagemFocusGained

    private void tfDescontoRealFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoRealFocusGained
        tfDescontoReal.selectAll();
    }//GEN-LAST:event_tfDescontoRealFocusGained

    private void tfProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProdutoFocusGained
        tfDescricaoProduto.selectAll();
    }//GEN-LAST:event_tfProdutoFocusGained

    private void lbFinanceiroBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbFinanceiroBKeyPressed

    }//GEN-LAST:event_lbFinanceiroBKeyPressed

    private void cbOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOperacaoActionPerformed
//        if (statusBGravar == true) {
//            cbOperacao.setEnabled(false);
//        } else {
//
//        }
//        if (cbOperacao.getSelectedItem().equals("COMPRA")) {
//            int resposta = JOptionPane.showConfirmDialog(null, "Se mudar a operação para compra, uma nova sequencia será gerada", "Selecione uma Opção!", JOptionPane.YES_NO_OPTION);
//            if (resposta == JOptionPane.YES_OPTION) {
//                sequencia = 0;
//                entradaAtual = sequencia;
//                lbSequencia.setText(sequencia.toString());
//            } else {
//                cbOperacao.setSelectedItem("AJUSTE DE ESTOQUE");
//            }
//
//        }
    }//GEN-LAST:event_cbOperacaoActionPerformed

    private void lbCaixaEditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCaixaEditMousePressed
        if (statusBEstoque == false) {
            new AlteraDadosEntradaView(this, 3).setVisible(true);
        } else {
            new Alertas().mensagemAviso("Entrada não pode ser alterada, pois já foi efetivada");
        }
    }//GEN-LAST:event_lbCaixaEditMousePressed

    private void lbCaixaEditMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCaixaEditMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCaixaEditMouseReleased

    private void jLabel25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MousePressed
        if (statusBEstoque == false) {
            new AlteraDadosEntradaView(this, 2).setVisible(true);
        } else {
            new Alertas().mensagemAviso("Entrada não pode ser alterada, pois já foi efetivada");
        }
    }//GEN-LAST:event_jLabel25MousePressed

    private void jLabel25MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseReleased

    private void jLabel26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MousePressed
//        if (statusBGravar == true) {
        AlteraDadosEntradaView alt = new AlteraDadosEntradaView(this, 1);
        alt.setVisible(true);

        if (alt.retornaSequencia() > 0 && alt.cancelar() == false) {
            sequencia = alt.retornaSequencia();
            lbSequencia.setText(sequencia.toString());
            lbFornecedor.setText(alt.retornaFornecedor());
            lbCaixa.setText(alt.retornaCaixa());
            cbOperacao.setSelectedItem(alt.retornaOperacao());
            listaProdutos = alt.retornaListProdEnt();

            preencherTabelaSequencia();
        }

        try {
            if (sequencia == 0 || sequencia == null) {
                statusBGravar = false;
                sequencia = 0;
            } else {
                statusBGravar = true;
                financeiroFinalizado();
                lbStatusEstq.setOpaque(true);
                if (entDao.estoqueFoiEfetivado(sequencia)) {
                    Color cor = new Color(0, 153, 255);
                    lbStatusEstq.setBackground(cor);
                    cbOperacao.setEnabled(false);
                    statusBEstoque = true;
                } else {
                    Color cor = new Color(255, 255, 255);
                    lbStatusEstq.setBackground(cor);
                    //lbStatusEstq.setOpaque(true);
                    cbOperacao.setEnabled(true);
                    statusBEstoque = false;
                    System.out.println("estoque ainda não foi efetivado");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        } else {
//            new Alertas().mensagemAviso("Entrada não pode ser alterada, pois já foi efetivada");
//        }
    }//GEN-LAST:event_jLabel26MousePressed

    private void jLabel26MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseReleased

    private void lbFinanceiroBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFinanceiroBMousePressed
        efetivarFinanceiroAction();
    }//GEN-LAST:event_lbFinanceiroBMousePressed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
    }//GEN-LAST:event_jPanel1FocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        financeiroFinalizado();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tfQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfQuantidadeKeyTyped

    private void tfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_tfQuantidadeKeyPressed

    private void tfPrecoUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_tfPrecoUnitarioKeyPressed

    private void tfDescontoPorcentagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoPorcentagemKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_tfDescontoPorcentagemKeyPressed

    private void tfDescontoRealKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoRealKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_tfDescontoRealKeyPressed

    private void cbOperacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbOperacaoKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_cbOperacaoKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        atalhos(evt);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jTTabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTabelaKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_jTTabelaKeyPressed

    private void tfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusLost
        if (unidadeVenda.equals("UN")) {
            new ValidarCamposNumericos().validar(tfQuantidade);
        }
    }//GEN-LAST:event_tfQuantidadeFocusLost

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
            java.util.logging.Logger.getLogger(EntradasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntradasView(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbOperacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTTabela;
    private javax.swing.JLabel lbCaixa;
    private javax.swing.JLabel lbCaixaEdit;
    private javax.swing.JLabel lbEstoqueB;
    private javax.swing.JLabel lbFinanceiroB;
    private javax.swing.JLabel lbFornecedor;
    private javax.swing.JLabel lbGravarB;
    private javax.swing.JLabel lbSequencia;
    private javax.swing.JLabel lbStatusEstq;
    private javax.swing.JLabel lbStatusFinanceiro;
    private javax.swing.JLabel lbValorFinal;
    private javax.swing.JTextField tfCodigoProduto;
    private javax.swing.JTextField tfDescontoPorcentagem;
    private javax.swing.JTextField tfDescontoReal;
    private javax.swing.JTextField tfDescricaoProduto;
    private javax.swing.JTextField tfPrecoFinal;
    private javax.swing.JTextField tfPrecoTotal;
    private javax.swing.JTextField tfPrecoUnitario;
    private javax.swing.JTextField tfProduto;
    private javax.swing.JTextField tfQuantidade;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        tfProduto.setText("");
        tfQuantidade.setText("1");
        tfPrecoUnitario.setText("0,00");
        tfPrecoTotal.setText("0,00");
        tfDescontoPorcentagem.setText("0,0");
        tfDescontoReal.setText("0,0");
        tfPrecoFinal.setText("0,00");
        tfCodigoProduto.setText("");
        tfDescricaoProduto.setText("");

    }

    private void calculaPrecoTotal() {
        double precoUnit = Double.parseDouble(tfPrecoUnitario.getText().replace(",", ".").replace(".", ""));
        double qnt = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
        double precoTotal = (qnt * precoUnit) / 100;
        tfPrecoTotal.setText(new DecimalFormat("0.00").format(precoTotal));
    }

    private void calculaPrecoFinal() {
        double precoTotal = Double.parseDouble(tfPrecoTotal.getText().replace(",", ".").replace(".", ""));
        double descPor = Double.parseDouble(tfDescontoPorcentagem.getText().replace(",", "."));
        double vlrDescPor = ((descPor * precoTotal) / 100);
        tfDescontoReal.setText(new DecimalFormat("0.00").format(vlrDescPor / 100));
        double descReal = Double.parseDouble(tfDescontoReal.getText().replace(",", ".").replace(".", ""));
        double precoFinal = precoTotal - descReal;
        tfPrecoFinal.setText(new DecimalFormat("0.00").format(precoFinal / 100));
    }

    private void descontoReal() {
        double precoTotal = Double.parseDouble(tfPrecoTotal.getText().replace(",", ".").replace(".", ""));
        double descReal = Double.parseDouble(tfDescontoReal.getText().replace(",", ".").replace(".", ""));
        double por = (descReal / precoTotal) * 100;
        tfDescontoPorcentagem.setText(new DecimalFormat("0.00").format(por));
        tfPrecoFinal.setText(new DecimalFormat("0.00").format((precoTotal - descReal) / 100));
    }

    private void adicionaProdutoLista() {
        if (!tfCodigoProduto.getText().isEmpty() && Double.parseDouble(tfPrecoTotal.getText().replace(",", ".")) > 0.0) {
            if (statusBEstoque == false) {
                if (produtoRepetido()) {
//                    else {
//                        ProdutosEntradaEntity ent = new ProdutosEntradaEntity();
//                        ent.setCodigoProduto(Integer.parseInt(tfCodigoProduto.getText()));
//                        ent.setProdutoServico(tfDescricaoProduto.getText());
//                        ent.setClasse(classe);
//                        ent.setQuantidade(Double.parseDouble(tfQuantidade.getText().replace(",", ".")));
//                        ent.setPrecoUnitario(Double.parseDouble(tfPrecoUnitario.getText().replace(",", ".").replace(".", "")));
//                        ent.setPrecoTotal(Double.parseDouble(tfPrecoTotal.getText().replace(",", ".").replace(".", "")));
//                        ent.setPrecoFinal(Double.parseDouble(tfPrecoFinal.getText().replace(",", ".").replace(".", "")));
//                        ent.setDescontoPorcentagem(Double.parseDouble(tfDescontoPorcentagem.getText().replace(",", ".")));
//                        ent.setDescontoReal(Double.parseDouble(tfDescontoReal.getText().replace(",", ".")));
//                        listaProdutos.add(ent);
//                    }
                } else {
                    ProdutosEntradaEntity ent = new ProdutosEntradaEntity();
                    ent.setId(Integer.parseInt(tfCodigoProduto.getText()));
                    ent.setCodigoProduto(Integer.parseInt(tfProduto.getText()));
                    ent.setProdutoServico(tfDescricaoProduto.getText());
                    ent.setClasse(classe);
                    ent.setQuantidade(Double.parseDouble(tfQuantidade.getText().replace(",", ".")));
                    ent.setPrecoUnitario(Double.parseDouble(tfPrecoUnitario.getText().replace(",", ".").replace(".", "")));
                    ent.setPrecoTotal(Double.parseDouble(tfPrecoTotal.getText().replace(",", ".").replace(".", "")));
                    ent.setPrecoFinal(Double.parseDouble(tfPrecoFinal.getText().replace(",", ".").replace(".", "")));
                    ent.setDescontoPorcentagem(Double.parseDouble(tfDescontoPorcentagem.getText().replace(",", ".")));
                    ent.setDescontoReal(Double.parseDouble(tfDescontoReal.getText().replace(",", ".")));
                    ent.setCodigoDinamico(Integer.parseInt(tfProduto.getText()));
                    listaProdutos.add(ent);
                }
                preencherTabela();
            } else {
                new Alertas().mensagemConfirmacao("A entrada já foi efetivada, não podendo adicionar novos itens a mesma!");
            }
        } else {
            new Alertas().mensagemAviso("Selecione algum produto para adicionar à lista e preencha os campos necessários!");
        }

    }

    public boolean produtoRepetido() {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getCodigoProduto() == Integer.parseInt(tfProduto.getText().replace(",", ".").replace(".", ""))) {
                listaProdutos.get(i).setQuantidade(listaProdutos.get(i).getQuantidade() + Double.parseDouble(tfQuantidade.getText()));
//                        listaProdutos.get(i).setPrecoUnitario(Double.parseDouble(tfPrecoUnitario.getText().replace(",", ".").replace(".", "")));
                Double precoTotal = listaProdutos.get(i).getQuantidade() * Double.parseDouble(tfPrecoUnitario.getText().replace(",", ".").replace(".", ""));
                listaProdutos.get(i).setPrecoTotal(listaProdutos.get(i).getPrecoTotal() + Double.parseDouble(tfPrecoTotal.getText().replace(",", ".").replace(".", "")));
//                        listaProdutos.get(i).setPrecoFinal(listaProdutos.get(i).getPrecoFinal() + Double.parseDouble(tfPrecoFinal.getText().replace(",", ".").replace(".", "")));
                System.out.println("precoAgoraTotla " + listaProdutos.get(i).getPrecoTotal());
                listaProdutos.get(i).setPrecoFinal(listaProdutos.get(i).getPrecoTotal() + Double.parseDouble(tfPrecoTotal.getText().replace(",", ".")));
                listaProdutos.get(i).setDescontoPorcentagem(listaProdutos.get(i).getDescontoPorcentagem() + Double.parseDouble(tfDescontoPorcentagem.getText().replace(",", ".")));
                listaProdutos.get(i).setDescontoReal(listaProdutos.get(i).getDescontoReal() + Double.parseDouble(tfDescontoReal.getText().replace(",", ".")));
                listaProdutos.get(i).setId(listaProdutos.get(i).getId());
                listaProdutos.get(i).setCodigoDinamico(listaProdutos.get(i).getCodigoDinamico());
                return true;
            }
        }
        return false;
    }

    private void preencherTabela() {
        jTTabela.getColumnModel().getColumn(1).setPreferredWidth(250);
        DefaultTableModel tb = (DefaultTableModel) jTTabela.getModel();
        tb.setNumRows(0);
        for (ProdutosEntradaEntity ent : listaProdutos) {
            tb.addRow(new Object[]{ent.getCodigoProduto(), ent.getProdutoServico(), ent.getClasse(), ent.getQuantidade().toString().replace(".", ","), "R$ " + new DecimalFormat("0.00").format(ent.getPrecoUnitario() / 100), "R$ " + new DecimalFormat("0.00").format(ent.getPrecoFinal() / 100), ent.getId()});
        }
        somaValorFinal();
        limparCampos();
        tfProduto.requestFocus();
    }

    private void preencherTabelaSequencia() {
        jTTabela.getColumnModel().getColumn(1).setPreferredWidth(250);
        DefaultTableModel tb = (DefaultTableModel) jTTabela.getModel();
        tb.setNumRows(0);
        for (ProdutosEntradaEntity ent : listaProdutos) {
            tb.addRow(new Object[]{ent.getCodigoDinamico(), ent.getProdutoServico(), ent.getClasse(), ent.getQuantidade().toString().replace(".", ","), "R$ " + new DecimalFormat("0.00").format(ent.getPrecoUnitario() / 100), "R$ " + new DecimalFormat("0.00").format(ent.getPrecoFinal() / 100), ent.getId()});
        }
        somaValorFinal();
        limparCampos();
        tfProduto.requestFocus();
    }

    private void eventoConsulta(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            String consulta = tfProduto.getText();
            BuscaProdutoEntradaView busca = new BuscaProdutoEntradaView(this, true, consulta);
            busca.setVisible(true);
            for (ProdutoEntity p : busca.dadosProduto()) {
                tfProduto.setText(p.getCodigoProduto().toString());
                tfDescricaoProduto.setText(p.getNome() + " - " + p.getUnidadeDeVenda());
                tfCodigoProduto.setText(p.getCodigoProduto().toString());
                idAtual = p.getId();
                tfCodigoProduto.setText(p.getId().toString());
                precoBanco = p.getPrecoDeCusto();
                qntBanco = p.getQntAtual();
                classe = p.getClasse();
                unidadeVenda = p.getUnidadeDeVenda();
                tfPrecoUnitario.setText(new DecimalFormat("0.00").format(p.getPrecoDeCusto()));
            }
            tfQuantidade.requestFocus();
        }
    }

    private void pesquisaProdutoVazio() {
        String consulta = tfProduto.getText();
        BuscaProdutoEntradaView busca = new BuscaProdutoEntradaView(this, true, consulta);
        busca.setVisible(true);
        for (ProdutoEntity p : busca.dadosProduto()) {
            if (p.getId() == null || p.getId() == 0) {

            } else {
                tfProduto.setText(p.getCodigoProduto().toString());
                tfCodigoProduto.setText(p.getId().toString());
                tfDescricaoProduto.setText(p.getNome() + " - " + p.getUnidadeDeVenda());
                tfCodigoProduto.setText(p.getId().toString());
//            tfCodigoProduto.setText(p.getCodigoProduto().toString());
                precoBanco = p.getPrecoDeCusto();
                qntBanco = p.getQntAtual();
                classe = p.getClasse();
                unidadeVenda = p.getUnidadeDeVenda();
                tfPrecoUnitario.setText(new DecimalFormat("0.00").format(p.getPrecoDeCusto()));
                tfQuantidade.requestFocus();
                tfQuantidade.selectAll();
            }

        }
    }

    private void pesquisaProdutoForCodigoBarrasOrId() {
        try {
            String codigoBarras = tfProduto.getText();
            if (pd.pesquisarProdutoFromCodigoBarrasOrId(codigoBarras).size() == 0) {
                new Alertas().mensagemAviso("Produto inexistente!");
            } else {
                for (ProdutoEntity prod : pd.pesquisarProdutoFromCodigoBarrasOrId(codigoBarras)) {
                    tfCodigoProduto.setText(prod.getId().toString());
//                    tfCodigoProduto.setText(prod.getCodigoProduto().toString());
                    tfDescricaoProduto.setText(prod.getNome() + " - " + prod.getUnidadeDeVenda());
                    tfProduto.setText(prod.getCodigoProduto().toString());
                    classe = prod.getClasse();
                    qntBanco = prod.getQntAtual();
                    precoBanco = prod.getPrecoDeCusto();
                    unidadeVenda = prod.getUnidadeDeVenda();
                    tfPrecoUnitario.setText(new DecimalFormat("0.00").format(prod.getPrecoDeCusto()));
                }
                tfQuantidade.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void somaValorFinal() {
        double vlrFinal = 0;
        for (ProdutosEntradaEntity ent : listaProdutos) {
            vlrFinal += ent.getPrecoFinal();
        }
        lbValorFinal.setText(new DecimalFormat("0.00").format(vlrFinal / 100));
    }

    private void removerProdutoLista() {
        try {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover este produto?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            if (opcao == JOptionPane.YES_OPTION) {

                EntradaDAO dao = new EntradaDAO();
                String result = dao.selecionaFornecedor(1);
                lbFornecedor.setText(result);
                result = dao.selecionaCaixa(1);
                lbCaixa.setText(result);
                sequencia = 0;
                lbSequencia.setText("0");
                cbOperacao.setSelectedItem("AJUSTE DE ESTOQUE");
                cbOperacao.setEnabled(true);

                statusBGravar = false;
                statusGravacao = true;
                statusBEstoque = false;
                statusBFinanceiro = false;
                Color cor = new Color(255, 255, 255);

                lbStatusEstq.setBackground(cor);
                lbStatusFinanceiro.setBackground(cor);

                for (ProdutosEntradaEntity ent : listaProdutos) {
                    if (codigoRemovido == ent.getCodigoProduto()) {
                        listaProdutos.remove(ent);
                    }
                    if (listaProdutos.size() == 0) {
                        listaProdutos.clear();
                        DefaultTableModel tabela = (DefaultTableModel) jTTabela.getModel();
                        tabela.setNumRows(0);
                        lbValorFinal.setText("0,00");
                    } else {
                        preencherTabela();
                    }
                }
                somaValorFinal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void novaEntrada() {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente iniciar uma nova entrada!", "Opcões", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (opcao == JOptionPane.YES_OPTION) {
            cbOperacao.setEnabled(true);
            listaProdutos.clear();
            lbValorFinal.setText("0,00");
            DefaultTableModel tabela = (DefaultTableModel) jTTabela.getModel();
            tabela.setNumRows(0);

            statusBGravar = false;
            statusGravacao = true;
            statusBEstoque = false;
            statusBFinanceiro = false;
            Color cor = new Color(255, 255, 255);

            lbStatusEstq.setBackground(cor);
            lbStatusFinanceiro.setBackground(cor);

            try {
                EntradaDAO dao = new EntradaDAO();
                String result = dao.selecionaFornecedor(1);
                lbFornecedor.setText(result);
                result = dao.selecionaCaixa(1);
                lbCaixa.setText(result);
                sequencia = 0;
                lbSequencia.setText("0");
                cbOperacao.setSelectedItem("AJUSTE DE ESTOQUE");
                statusBGravar = false;
                statusGravacao = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void preencheCamposPadrao(InicializaEntradaEntity iniEntrada) {
        lbFornecedor.setText(iniEntrada.getFornecedor());
        lbCaixa.setText(iniEntrada.getCaixa());
        cbOperacao.setSelectedItem(iniEntrada.getOperacao());
        sequencia = iniEntrada.getSequencia();
        lbSequencia.setText(iniEntrada.getSequencia().toString());
    }

    private void preencherComboBoxOperacao() {
        OperacaoDAO opeDao = new OperacaoDAO();
        cbOperacao.removeAllItems();
        try {
            for (OperacaoEntity ope : opeDao.preencheComboBoxOperacaoInEntrada()) {
                cbOperacao.addItem(ope.getNome());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void gravarEntrada() {
        try {
            EntradasEntity ent = new EntradasEntity();
            ent.setFornecedor(lbFornecedor.getText());
            ent.setCaixa(lbCaixa.getText());
            ent.setOperacao(cbOperacao.getSelectedItem().toString());
            ent.setVlrTotal(Double.parseDouble(lbValorFinal.getText().replace(",", ".").replace(".", "")));
            NovaData nd = new NovaData();
            ent.setDataEntrada(nd.dataAtual());
            ent.setStatus("ABERTO");
            entDao.gravarEntrada(ent);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void gravarProdutosEntrada() {
        try {
            for (ProdutosEntradaEntity prod : listaProdutos) {
                entDao.lancarProdutosEntrada(prod, sequencia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void efetivaEstoque() throws Exception {
//        if (entDao.estoqueFoiEfetivado(sequencia)) {
//            new Alertas().mensagemConfirmacao("Estoque já foi Efetivado!");
//        } else {

        entDao.detelarProdutoEstoque(sequencia);
        gravarProdutosEntrada();

        for (ProdutosEntradaEntity p : listaProdutos) {
            entDao.adicionaProdutoEstoque(p);
        }
        entDao.atualizaStatusEntrada(sequencia);
        entDao.atualizaStatusProdutosEntrada(sequencia);

        Color cor = new Color(0, 153, 255);
        lbStatusEstq.setBackground(cor);
        lbStatusEstq.setOpaque(true);

        try {
            Double vlrTotal = Double.parseDouble(lbValorFinal.getText().replace(",", ".").replace(".", ""));
            EntradasEntity ee = new EntradasEntity();
            ee.setCaixa(lbCaixa.getText());
            ee.setCodigoEntrada(Integer.parseInt(lbSequencia.getText()));
            ee.setOperacao(cbOperacao.getSelectedItem().toString());
            ee.setFornecedor(lbFornecedor.getText());
            ee.setDataEntrada(new NovaData().dataAtual());
            ee.setVlrTotal(vlrTotal);
            ee.setStatus("FINALIZADO");
            entDao.atualizaEntrada(ee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Alertas().mensagemConfirmacao("Estoque Efetivado com sucesso!");
//        }

    }

    private void efetivaFinanceiro() {
        try {
            InicializaEntradaEntity iee = new InicializaEntradaEntity();
            iee.setCaixa(lbCaixa.getText());
            iee.setFornecedor(lbFornecedor.getText());
            iee.setOperacao(cbOperacao.getSelectedItem().toString());
            iee.setSequencia(Integer.parseInt(lbSequencia.getText()));

            Double vlrTotal = Double.parseDouble(lbValorFinal.getText().replace(",", "."));

            FinalizaFinanceiroEntrada ffe = new FinalizaFinanceiroEntrada(iee, vlrTotal, u);
            ffe.setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void financeiroFinalizado() {
        try {
            lbStatusFinanceiro.setOpaque(true);
            if (entDao.financeiroFoiEfetivado(sequencia)) {
                Color cor = new Color(0, 153, 255);
                lbStatusFinanceiro.setBackground(cor);
            } else {
                Color cor = new Color(255, 255, 255);
                lbStatusFinanceiro.setBackground(cor);
//               / lbStatusFinanceiro.setOpaque(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void selecionaCaixa(String caixa) {
        lbCaixa.setText(caixa);
        // en.setCaixa(caixa);
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            gravarEntradaAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_F3) {
            efetivarFinanceiroAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_F4) {
            efetivarEstoqueAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
            novaEntradaAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_F6) {
            new Alertas().mensagemAviso("Ainda não implementado, espera á proxima versão do software");
        }
    }

    private void gravarEntradaAction() {
        try {
            if (entDao.estoqueFoiEfetivado(sequencia)) {
                new Alertas().mensagemAviso("Entrada já foi efetivada!");
            } else {
                if (listaProdutos.size() == 0) {
                    new Alertas().mensagemAviso("Operação impossível de ser realizada!\nAdicione alguns produtos à lista!");
                    tfProduto.requestFocus();
                } else if (statusBGravar == false && sequencia == 0) {
                    gravarEntrada();
                    sequencia = entDao.retornaCodigoEntrada();
                    lbSequencia.setText(sequencia.toString());
                    gravarProdutosEntrada();
                    statusBGravar = true;
                    new Alertas().mensagemConfirmacao("Gravado com sucesso!\nNúmero da sequência: " + entDao.retornaCodigoEntrada());
                } else if (sequencia > 0 && statusBGravar == true && statusBEstoque == false) {
                    entDao.detelarProdutoEstoque(sequencia);
                    gravarProdutosEntrada();
                    try {
                        Double vlrTotal = Double.parseDouble(lbValorFinal.getText().replace(",", ".").replace(".", ""));
                        EntradasEntity ee = new EntradasEntity();
                        ee.setCaixa(lbCaixa.getText());
                        ee.setCodigoEntrada(Integer.parseInt(lbSequencia.getText()));
                        ee.setOperacao(cbOperacao.getSelectedItem().toString());
                        ee.setFornecedor(lbFornecedor.getText());
                        ee.setDataEntrada(new NovaData().dataAtual());
                        ee.setVlrTotal(vlrTotal);
                        ee.setStatus("ABERTO");
                        entDao.atualizaEntrada(ee);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    new Alertas().mensagemConfirmacao("Entrada Alterada com sucesso!");
                } else if (statusBGravar == true && statusBEstoque == true) {
                    new Alertas().mensagemConfirmacao("A entrada já foi efetivada!");
                } else {
                    new Alertas().mensagemAviso("Esta entrada já foi gravada!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void efetivarFinanceiroAction() {
        try {
            if (cbOperacao.getSelectedItem().toString().equals("COMPRA")) {
                if (statusBGravar == true && statusBEstoque == false) {
                    int opcao = JOptionPane.showConfirmDialog(null, "Estoque ainda não foi efetivado, deseja efetivar estoque?", "Opcões", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                    if (opcao == JOptionPane.YES_OPTION) {
                        efetivaEstoque();
                        statusBEstoque = true;
                        if (sequencia > 0) {
                            efetivaFinanceiro();
                        }
                        cbOperacao.setEnabled(false);
                    }
                } else if (statusBGravar == true && statusBEstoque == true) {
                    efetivaFinanceiro();
                } else if (statusBGravar == false) {
                    new Alertas().mensagemAviso("A entrada deve ser gravada primeiro, antes de ser efetivada");
                } else if (entDao.financeiroFoiEfetivado(sequencia)) {

                }
            } else {
                new Alertas().mensagemAviso("Apenas a Operação 'COMPRA' pode gerar um financeiro!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void efetivarEstoqueAction() {
        try {
            if (entDao.estoqueFoiEfetivado(sequencia)) {
                new Alertas().mensagemAviso("Entrada já foi efetivada!");
            } else {
                if (statusBGravar == true && statusBEstoque == false) {
                    int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente efetivar o estoque?", "Opções", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                    if (opcao == JOptionPane.YES_OPTION) {
                        efetivaEstoque();
                        statusBEstoque = true;
                        cbOperacao.setEnabled(false);
                    }
                } else if (statusBEstoque == true) {
                    new Alertas().mensagemConfirmacao("A entrada já foi efetivada!");
                } else {
                    new Alertas().mensagemAviso("Pressione gravar antes de efetivar o estoque!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void novaEntradaAction() {
        if (cont == false) {
            removerProdutoLista();
            cont = true;
        } else {
            novaEntrada();
        }
    }

}
