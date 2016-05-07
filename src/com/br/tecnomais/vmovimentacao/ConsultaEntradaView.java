package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.Dinheiro;
import com.br.tecnomais.classes.ValidarCamposNumericos;
import com.br.tecnomais.dao.EntradaDAO;
import com.br.tecnomais.dao.OperacaoDAO;
import com.br.tecnomais.dao.ProdutoDAO;
import com.br.tecnomais.entity.EntradasEntity;
import com.br.tecnomais.entity.ProdutosEntradaEntity;
import com.br.tecnomais.entity.InicializaEntradaEntity;
import com.br.tecnomais.entity.OperacaoEntity;
import com.br.tecnomais.entity.ProdutoEntity;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ConsultaEntradaView extends javax.swing.JFrame {

    private int codigoRemovido;
    private boolean cont;
    private String classe;
    private List<ProdutosEntradaEntity> listaProdutos = new ArrayList<>();
    private Double precoBanco;
    private Double qntBanco;
    private ProdutoDAO pd = new ProdutoDAO();
    private InicializaEntradaEntity conEntrada;
    private EntradaDAO entDao = new EntradaDAO();

    public ConsultaEntradaView(InicializaEntradaEntity conEntrada) {
        initComponents();
        this.conEntrada = conEntrada;
        tfProduto.requestFocusInWindow();
        tfCodigoProduto.setVisible(false);
        preencherComboBoxOperacao();
        preencheCamposPadrao();
        inicializarConsultaEntradas();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfCodigoProduto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbFornecedor = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jcOperacao = new javax.swing.JComboBox();
        lbCaixa = new javax.swing.JLabel();
        tfDescricaoProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        tfQuantidade.setText("1");
        tfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantidadeActionPerformed(evt);
            }
        });

        jTTabela.setAutoCreateRowSorter(true);
        jTTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Classe", "Qtde.", "Preço Unit.", "Preço Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane1.setViewportView(jTTabela);

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

        tfDescontoReal.setText("0,0");
        tfDescontoReal.addFocusListener(new java.awt.event.FocusAdapter() {
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescontoRealKeyReleased(evt);
            }
        });

        jLabel2.setText("Qtde.");

        jLabel3.setText("Preço Unitário");

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

        jLabel1.setText("Produto");

        tfDescontoPorcentagem.setText("0,0");
        tfDescontoPorcentagem.addFocusListener(new java.awt.event.FocusAdapter() {
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescontoPorcentagemKeyReleased(evt);
            }
        });

        jLabel4.setText("Preço Total");

        jLabel5.setText("Desc. (%)");

        jPanel2.setBackground(new java.awt.Color(180, 190, 190));

        jLabel19.setText("Imprimir");

        lbValorFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbValorFinal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbValorFinal.setText("0,00");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/estoque205.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
        });

        jLabel9.setText("Gravar");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/salvar.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel15.setText("Estoque");

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

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/financeiro.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel13.setText("Financeiro");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Total:");

        jLabel17.setText("Nova");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        lbFornecedor.setText("jLabel23");

        jLabel24.setText("Operação:");

        lbCaixa.setBackground(new java.awt.Color(51, 102, 255));
        lbCaixa.setForeground(new java.awt.Color(255, 255, 255));
        lbCaixa.setText("jLabel25");
        lbCaixa.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFornecedor)
                        .addGap(249, 249, 249)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCaixa))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(lbFornecedor)
                    .addComponent(jLabel24)
                    .addComponent(jcOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbCaixa)
                .addGap(0, 0, Short.MAX_VALUE))
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
                        .addGap(0, 70, Short.MAX_VALUE)))
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

    private void tfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantidadeActionPerformed
        if (tfQuantidade.getText().isEmpty()) {
            new Alertas().mensagemAviso("Quantidade não pode ser vazia!");
        } else {
            int qnt = Integer.parseInt(tfQuantidade.getText());
            if (qnt <= 0) {
                new Alertas().mensagemAviso("Quantidade inválida!");
            } else {
                tfPrecoUnitario.requestFocus();
            }
        }
    }//GEN-LAST:event_tfQuantidadeActionPerformed

    private void jTTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTabelaMouseClicked

    }//GEN-LAST:event_jTTabelaMouseClicked

    private void jTTabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTabelaMousePressed
        int linha = jTTabela.getSelectedRow();
        codigoRemovido = Integer.parseInt(jTTabela.getValueAt(linha, 0).toString());
        System.out.println(codigoRemovido);
        cont = false;
    }//GEN-LAST:event_jTTabelaMousePressed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked

    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        adicionaProdutoLista();
        preencherTabela();
    }//GEN-LAST:event_jLabel20MousePressed

    private void tfProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProdutoFocusLost
        //        new PesquisaProdutoView().setVisible(true);
    }//GEN-LAST:event_tfProdutoFocusLost

    private void tfProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProdutoActionPerformed
        if (tfProduto.getText().isEmpty()) {
            pesquisaProdutoVazio();
        } else {
            pesquisaProdutoForCodigoBarrasOrId();
        }
    }//GEN-LAST:event_tfProdutoActionPerformed

    private void tfProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoKeyPressed
        eventoConsulta(evt);
    }//GEN-LAST:event_tfProdutoKeyPressed

    private void tfDescontoRealFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoRealFocusLost
        descontoReal();
    }//GEN-LAST:event_tfDescontoRealFocusLost

    private void tfDescontoRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescontoRealActionPerformed
        tfPrecoFinal.requestFocus();
        //        descontoReal();
    }//GEN-LAST:event_tfDescontoRealActionPerformed

    private void tfDescontoRealKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoRealKeyReleased
        new ValidarCamposNumericos().validar(tfDescontoReal);
        tfDescontoReal.setText(new Dinheiro().dinheiro(tfDescontoReal.getText()));
    }//GEN-LAST:event_tfDescontoRealKeyReleased

    private void tfPrecoUnitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioFocusGained
        tfPrecoUnitario.setText("");
    }//GEN-LAST:event_tfPrecoUnitarioFocusGained

    private void tfPrecoUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioFocusLost
        tfDescontoPorcentagem.requestFocus();
        calculaPrecoTotal();
    }//GEN-LAST:event_tfPrecoUnitarioFocusLost

    private void tfPrecoUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioActionPerformed
        tfDescontoPorcentagem.requestFocus();
    }//GEN-LAST:event_tfPrecoUnitarioActionPerformed

    private void tfPrecoUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoUnitarioKeyReleased
        new ValidarCamposNumericos().validar(tfPrecoUnitario);
        tfPrecoUnitario.setText(new Dinheiro().dinheiro(tfPrecoUnitario.getText()));
    }//GEN-LAST:event_tfPrecoUnitarioKeyReleased

    private void tfPrecoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoFinalActionPerformed
        adicionaProdutoLista();
        preencherTabela();
    }//GEN-LAST:event_tfPrecoFinalActionPerformed

    private void tfPrecoTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoTotalFocusGained
        tfPrecoTotal.setEnabled(false);
    }//GEN-LAST:event_tfPrecoTotalFocusGained

    private void tfPrecoTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoTotalFocusLost
        tfPrecoTotal.setEnabled(true);
    }//GEN-LAST:event_tfPrecoTotalFocusLost

    private void tfPrecoTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoTotalKeyPressed

    }//GEN-LAST:event_tfPrecoTotalKeyPressed

    private void tfPrecoTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoTotalKeyReleased

    }//GEN-LAST:event_tfPrecoTotalKeyReleased

    private void tfDescontoPorcentagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoPorcentagemFocusLost
        calculaPrecoFinal();
    }//GEN-LAST:event_tfDescontoPorcentagemFocusLost

    private void tfDescontoPorcentagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescontoPorcentagemActionPerformed
        tfPrecoFinal.requestFocus();
    }//GEN-LAST:event_tfDescontoPorcentagemActionPerformed

    private void tfDescontoPorcentagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoPorcentagemKeyReleased

    }//GEN-LAST:event_tfDescontoPorcentagemKeyReleased

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        //        salvarEntrada();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        limparCampos();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
        if (cont == false) {
            removerProdutoLista();
            cont = true;
        } else {
            novaEntrada();
        }
    }//GEN-LAST:event_jLabel16MousePressed

    private void tfDescricaoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescricaoProdutoFocusGained
        tfDescricaoProduto.setEnabled(false);
    }//GEN-LAST:event_tfDescricaoProdutoFocusGained

    private void tfDescricaoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescricaoProdutoFocusLost
        tfDescricaoProduto.setEnabled(true);
    }//GEN-LAST:event_tfDescricaoProdutoFocusLost

    private void tfDescricaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescricaoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescricaoProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaEntradaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEntradaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEntradaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEntradaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEntradaView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JComboBox jcOperacao;
    private javax.swing.JLabel lbCaixa;
    private javax.swing.JLabel lbFornecedor;
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
        int qnt = Integer.parseInt(tfQuantidade.getText());
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
        if (!tfCodigoProduto.getText().isEmpty()) {
            ProdutosEntradaEntity ent = new ProdutosEntradaEntity();
            ent.setCodigoProduto(Integer.parseInt(tfCodigoProduto.getText()));
            ent.setProdutoServico(tfDescricaoProduto.getText());
            ent.setClasse(classe);
            ent.setQuantidade(Double.parseDouble(tfQuantidade.getText().replace(",", ".")));
            ent.setPrecoUnitario(Double.parseDouble(tfPrecoUnitario.getText().replace(",", ".").replace(".", "")));
            ent.setPrecoTotal(Double.parseDouble(tfPrecoTotal.getText().replace(",", ".").replace(".", "")));
            ent.setPrecoFinal(Double.parseDouble(tfPrecoFinal.getText().replace(",", ".").replace(".", "")));
            ent.setDescontoPorcentagem(Double.parseDouble(tfDescontoPorcentagem.getText().replace(",", ".")));
            ent.setDescontoReal(Double.parseDouble(tfDescontoReal.getText().replace(",", ".")));
            listaProdutos.add(ent);
        } else {
            new Alertas().mensagemAviso("Selecione algum produto para adicionar à lista!");
        }

    }

    private void preencherTabela() {
        jTTabela.getColumnModel().getColumn(1).setPreferredWidth(250);
        DefaultTableModel tb = (DefaultTableModel) jTTabela.getModel();
        tb.setNumRows(0);
        for (ProdutosEntradaEntity ent : listaProdutos) {
            tb.addRow(new Object[]{ent.getCodigoProduto(), ent.getProdutoServico(), ent.getClasse(), ent.getQuantidade(), "R$ " + new DecimalFormat("0.00").format(ent.getPrecoUnitario() / 100), "R$ " + new DecimalFormat("0.00").format(ent.getPrecoFinal() / 100)});
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
                tfProduto.setText(p.getId().toString());
                tfDescricaoProduto.setText(p.getNome() + " - " + p.getUnidadeDeVenda());
                tfCodigoProduto.setText(p.getId().toString());
                precoBanco = p.getPrecoDeCusto();
                qntBanco = p.getQntAtual();
                classe = p.getClasse();
            }
            tfQuantidade.requestFocus();
        }
    }

    private void pesquisaProdutoVazio() {
        String consulta = tfProduto.getText();
        BuscaProdutoEntradaView busca = new BuscaProdutoEntradaView(this, true, consulta);
        busca.setVisible(true);
        for (ProdutoEntity p : busca.dadosProduto()) {
            tfProduto.setText(p.getId().toString());
            tfDescricaoProduto.setText(p.getNome() + " - " + p.getUnidadeDeVenda());
            tfCodigoProduto.setText(p.getId().toString());
            precoBanco = p.getPrecoDeCusto();
            qntBanco = p.getQntAtual();
            classe = p.getClasse();
        }
        tfQuantidade.requestFocus();
    }

    private void pesquisaProdutoForCodigoBarrasOrId() {
        try {
            String codigoBarras = tfProduto.getText();
            if (pd.pesquisarProdutoFromCodigoBarrasOrId(codigoBarras).size() == 0) {
                new Alertas().mensagemAviso("Produto inexistente!");
            } else {
                for (ProdutoEntity prod : pd.pesquisarProdutoFromCodigoBarrasOrId(codigoBarras)) {
                    tfCodigoProduto.setText(prod.getId().toString());
                    tfDescricaoProduto.setText(prod.getNome() + " - " + prod.getUnidadeDeVenda());
                    tfProduto.setText(prod.getId().toString());
                    classe = prod.getClasse();
                    qntBanco = prod.getQntAtual();
                    precoBanco = prod.getPrecoDeCusto();
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
            listaProdutos.clear();
            lbValorFinal.setText("0,00");
            DefaultTableModel tabela = (DefaultTableModel) jTTabela.getModel();
            tabela.setNumRows(0);
        }
    }

    private void preencheCamposPadrao() {

    }

    private void preencherComboBoxOperacao() {
        OperacaoDAO opeDao = new OperacaoDAO();
        jcOperacao.removeAllItems();
        try {
            for (OperacaoEntity ope : opeDao.preencheComboBoxOperacaoInEntrada()) {
                jcOperacao.addItem(ope.getNome());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void inicializarConsulta() {
        try {
            DefaultTableModel tb = (DefaultTableModel) jTTabela.getModel();
            tb.setNumRows(0);
            for (ProdutosEntradaEntity prod : entDao.listaProdutosEntrada(conEntrada)) {
                tb.addRow(new Object[]{prod.getCodigoProduto(), prod.getProdutoServico(), prod.getClasse(), prod.getQuantidade().toString().replace(".", ","), "R$ " + new DecimalFormat("0.00").format(prod.getPrecoUnitario() / 100), "R$ " + new DecimalFormat("0.00").format(prod.getPrecoFinal() / 100)});
            }
            listaProdutos = entDao.listaProdutosEntrada(conEntrada);
            somaValorFinal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void inserirFornecedorAndCaixa() {
        try {
            for(EntradasEntity ent : entDao.listaFornecedorAndCaixa(conEntrada)) {
                lbFornecedor.setText(ent.getFornecedor());
                lbCaixa.setText(ent.getCaixa());
                jcOperacao.setSelectedItem(ent.getOperacao());
            }
        } catch (Exception e) {
        }
    }
    
    private void inicializarConsultaEntradas() {
        inicializarConsulta();
        inserirFornecedorAndCaixa();
    }
}
