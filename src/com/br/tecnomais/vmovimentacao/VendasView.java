package com.br.tecnomais.vmovimentacao;

import br.com.daruma.jna.DUAL;
import com.br.tecnomais.classes.*;
import com.br.tecnomais.dao.*;
import com.br.tecnomais.entity.*;
import com.sun.jna.Native;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class VendasView extends javax.swing.JFrame implements VendaListener {

    ProdutosVendaDAO daoProd = new ProdutosVendaDAO();
    private final VendaDAO daoVenda = new VendaDAO();
    private final UsuarioDAO ud = new UsuarioDAO();
    private final ProdutoDAO prodDao = new ProdutoDAO();
    private String unidadeVenda;
    private List<ProdutosVendaEntity> listaProdutos = new ArrayList<>();
    private DefaultListModel modelLista;
    CupomDAO cupomDAO = new CupomDAO();
    CupomEntity cupomEntity = new CupomEntity();
    private String codigo;
    //private boolean primeiraVez = true;
    private double valorDescontoItem = 0;
    Alertas alerta = new Alertas();

    ImpressoraPadraoDAO impressoraPadraoDAO = new ImpressoraPadraoDAO();
    ImpressoraBematchDAO impressoraBematchDAO = new ImpressoraBematchDAO();
    ImpressoraBematchEntity impressoraBematchEntity = new ImpressoraBematchEntity();
    ImpressoraDarumaDAO impressoraDarumaDAO = new ImpressoraDarumaDAO();
    ImpressoraDarumaEntity impressoraDarumaEntity = new ImpressoraDarumaEntity();
    String impressoraAtual = "";
    MP2032 dll = (MP2032) Native.loadLibrary("mp2032.dll", MP2032.class);

    ConfigurarTelaVendasEntity ctve = new ConfigurarTelaVendasEntity();
    ConfigurarTelaVendasDAO cfgDAO = new ConfigurarTelaVendasDAO();
    Double quantAtualPrt = 0.0;
    Double valorTotal = 0.0;

    private VendaEntity venda = new VendaEntity();
    ClienteEntity ce = new ClienteEntity();
    ClienteDAO cliDAO = new ClienteDAO();
    NovaData nd = new NovaData();
    int cont = 0;
    NovaData data = new NovaData();

    boolean leitor = false;
    Integer idComputador = 0;

    Integer idAtualprod = 0;
    String trueTfProduto = "";

    // AlteraOperacaoSaidaView alteraSV = new AlteraOperacaoSaidaView(this);
    public VendasView(String operacao, String usuario, String caixa, ClienteEntity clienteEntity, List<ProdutosVendaEntity> lista, VendaEntity ve) {
        initComponents();
        ajeitarTela();

        try {
            BufferedReader ler = new BufferedReader(new FileReader("Config/cfg.cfg"));
            idComputador = Integer.parseInt(ler.readLine());
            System.out.println("id " + idComputador);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            impressoraAtual = impressoraPadraoDAO.retornaImpAtual();
            if (impressoraAtual.equals("ImpressoraDaruma")) {
                impressoraDarumaEntity = impressoraDarumaDAO.retornaIde();
                int tRetorno = DUAL.regTermica(impressoraDarumaEntity.getRegistroTermico());
                int pRetorno = DUAL.regPortaComunicacao(impressoraDarumaEntity.getPortaComunicacao());
                int pvRetorno = DUAL.regVelocidade(impressoraDarumaEntity.getPortaVelocidade());
                int cG2Retorno = DUAL.regLinhasGuilhotina(impressoraDarumaEntity.getTamanhoGuilhotina());
                int zRetorno = DUAL.regZeroCortado(impressoraDarumaEntity.getZeroCortadoStatus());
            } else if (impressoraAtual.equals("ImpressoraBematech")) {
                impressoraBematchEntity = impressoraBematchDAO.RetornImpBematchCfg();
                if (impressoraBematchEntity.getDll64() == 1) {
                    dll = (MP2032) Native.loadLibrary("mp2064.dll", MP2032.class);
                }
                dll.ConfiguraModeloImpressora(8);
                dll.IniciaPorta(impressoraBematchEntity.getPorta());
                dll.IniciaPorta("USB");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        lbOperacao.setText(operacao);
        lbVendedor.setText(usuario);
        lbCaixa.setText(caixa);
        ce = clienteEntity;
        this.venda = ve;
        lbCliente.setText(ce.getNome());
        lbCaixaEdit.setVisible(false);
        try {
            cupomEntity = cupomDAO.retornaConfigsCupom();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            ctve = cfgDAO.retornaCfg(idComputador);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.listaProdutos = lista;
        tfProduto.requestFocus();

//        mbVendas.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbOperacao = new javax.swing.JLabel();
        lbVendedor = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbCaixa = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbCaixaEdit = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbEditeCupom = new javax.swing.JLabel();
        lbCupom = new javax.swing.JLabel();
        lbNomeProduto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        tfPrecoUnitario = new javax.swing.JTextField();
        tfPrecoTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlProdutos = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        tfValorTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        mbVendas = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais Automação Comercial");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jPanel2.setBackground(new java.awt.Color(237, 237, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jLabel2.setText("Vendedor:");

        jLabel11.setText("Operação:");

        lbOperacao.setForeground(new java.awt.Color(0, 51, 153));
        lbOperacao.setText(".");

        lbVendedor.setForeground(new java.awt.Color(0, 51, 153));
        lbVendedor.setText(".");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/edit-op-us 16x.png"))); // NOI18N
        jLabel14.setToolTipText("Alterar a Operação");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });

        jLabel15.setText("Caixa:");

        lbCaixa.setForeground(new java.awt.Color(0, 51, 153));
        lbCaixa.setText(".");

        jLabel16.setText("Cliente:");

        lbCliente.setForeground(new java.awt.Color(0, 51, 153));
        lbCliente.setText(".");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/edit-op-us 16x.png"))); // NOI18N
        jLabel18.setToolTipText("Alterar o Cliente");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel18MouseReleased(evt);
            }
        });

        lbCaixaEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/edit-op-us 16x.png"))); // NOI18N
        lbCaixaEdit.setToolTipText("Alterar o Caixa");
        lbCaixaEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCaixaEditMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbCaixaEditMouseReleased(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/edit-op-us 16x.png"))); // NOI18N
        jLabel20.setToolTipText("Altera o Vendedor");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel20MouseReleased(evt);
            }
        });

        jLabel17.setText("Cupom:");

        lbEditeCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/edit-op-us 16x.png"))); // NOI18N
        lbEditeCupom.setToolTipText("Alterar o Cupom e as outras informações");
        lbEditeCupom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbEditeCupomMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbEditeCupomMouseReleased(evt);
            }
        });

        lbCupom.setForeground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCaixaEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEditeCupom)
                .addGap(7, 7, 7)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCupom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCupom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEditeCupom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCaixaEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel11)
                        .addComponent(lbOperacao)
                        .addComponent(lbVendedor)
                        .addComponent(jLabel15)
                        .addComponent(lbCaixa)
                        .addComponent(jLabel16)
                        .addComponent(lbCliente)
                        .addComponent(jLabel17)))
                .addContainerGap())
        );

        lbNomeProduto.setBackground(new java.awt.Color(0, 51, 153));
        lbNomeProduto.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbNomeProduto.setForeground(new java.awt.Color(255, 255, 255));
        lbNomeProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNomeProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        lbNomeProduto.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Produto");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Quantidade");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Preço Unitário");

        tfProduto.setBackground(new java.awt.Color(240, 240, 240));
        tfProduto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tfProduto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfProdutoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfProdutoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Preço Total");

        tfQuantidade.setBackground(new java.awt.Color(240, 240, 240));
        tfQuantidade.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tfQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
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

        tfPrecoUnitario.setBackground(new java.awt.Color(240, 240, 240));
        tfPrecoUnitario.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tfPrecoUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPrecoUnitario.setText("0,00");
        tfPrecoUnitario.setFocusable(false);

        tfPrecoTotal.setBackground(new java.awt.Color(240, 240, 240));
        tfPrecoTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tfPrecoTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPrecoTotal.setText("0,00");
        tfPrecoTotal.setFocusable(false);

        jlProdutos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jScrollPane1.setViewportView(jlProdutos);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Total");

        tfValorTotal.setEditable(false);
        tfValorTotal.setBackground(new java.awt.Color(0, 51, 153));
        tfValorTotal.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        tfValorTotal.setForeground(new java.awt.Color(255, 255, 255));
        tfValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorTotal.setText("0,00");
        tfValorTotal.setBorder(null);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Logo.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("F1 - Consultar Produto; F2 - Buscar Venda  ; F12 - Finalizar Venda; F5 - Nova Venda; F7 - Cancelar Venda; F8 - Cancelar Item; F3 - Desconto no Item");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Desenvolvido por Tecnomais Automação Comercial");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Desconto:");

        tfDesconto.setEditable(false);
        tfDesconto.setBackground(new java.awt.Color(0, 51, 153));
        tfDesconto.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        tfDesconto.setForeground(new java.awt.Color(255, 255, 255));
        tfDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfDesconto.setText("0,00");
        tfDesconto.setBorder(null);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/configuração tela de vendas.png"))); // NOI18N
        jLabel13.setToolTipText("Configuração da Tela");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNomeProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jScrollPane1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(tfPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(tfPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfPrecoUnitario, tfProduto, tfQuantidade});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(tfDesconto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(10, 10, 10)
                .addComponent(jLabel3))
        );

        mbVendas.setBorder(null);

        jMenu1.setBorder(null);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        mbVendas.add(jMenu1);

        jMenu3.setBorder(null);
        jMenu3.setText("                                                                                                                                                                                                         Next PDV                                                                                                                                                                                            ");
        jMenu3.setEnabled(false);
        jMenu3.setFocusable(false);
        jMenu3.setRequestFocusEnabled(false);
        mbVendas.add(jMenu3);

        setJMenuBar(mbVendas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProdutoActionPerformed
        if (!tfProduto.getText().isEmpty()) {
            String aux = tfProduto.getText();
            char[] c = aux.toCharArray();
            char d = c[0];

            for (int i = 0; i < c.length; i++) {
                if (!Character.isDigit(c[i])) {
                    d = c[i];
                }
            }
            if (tfProduto.getText().isEmpty()) {

            } else if (!Character.isDigit(d) && (tfProduto.getText().endsWith("*"))) {
                pesquisarProduto();
            } else {
                try {
                    lancaProduto();
                    calculaPrecoTotal();
                    //    tfQuantidade.selectAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            else if (Character.isDigit(d)) {
//                pesquisarProduto();
//            } 
        }
        tfQuantidade.selectAll();
    }//GEN-LAST:event_tfProdutoActionPerformed
    private void tfQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyReleased

    }//GEN-LAST:event_tfQuantidadeKeyReleased

    private void tfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantidadeActionPerformed
        try {
            if (tfQuantidade.getText().length() > 10) {
                tfQuantidade.setText("1");
                tfQuantidade.selectAll();
            } else {
                double qntDigitada = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
                for (ProdutoEntity pro : prodDao.pesquisarProdutoFromCodigoBarrasOrId(codigo)) {
                    if (ctve.getPermitirEstqNegativo() == 1 || (pro.getQntAtual() > qntDigitada || pro.getQntAtual() == 1)) {
                        if (lbCupom.getText().equals("") || !lbOperacao.getText().equals("VENDA ESTADUAL")) {
                            calcPreco();
                            addListaProdutos(qntDigitada);
                            mostrarProdutosListados();
                            valorDescontoItem = 0;
                        } else {
                            alerta.mensagemAviso("Essa venda já foi efetivada, não podendo adicionar ou remover produtos da lista!!!");
                        }

                    } else {
                        new Alertas().mensagemAviso("Quantidade insuficiente no estoque ou 0!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tfQuantidadeActionPerformed

    private void tfProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_tfProdutoKeyPressed

    private void tfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_tfQuantidadeKeyPressed

    private void tfQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusGained
//        tfQuantidade.selectAll();
        if (leitor == true && ctve.getPassarMercadoriaDiretoComLeitor() == 1) {
            leitor = false;
            try {
                double qntDigitada = Double.parseDouble("1");
                if (trueTfProduto.contains("*")) {
                    System.out.println("entroius");
                    String aux = trueTfProduto.substring(0, trueTfProduto.indexOf("*"));
                    System.out.println("aux " + aux);
                    qntDigitada = Double.parseDouble(aux);
                    tfQuantidade.setText(aux);
                }
                for (ProdutoEntity pro : prodDao.pesquisarProdutoFromCodigoBarrasOrId(codigo)) {
                    if (ctve.getPermitirEstqNegativo() == 1 || (pro.getQntAtual() > qntDigitada || pro.getQntAtual() == 1)) {
                        if (lbCupom.getText().equals("") || !lbOperacao.getText().equals("VENDA ESTADUAL")) {
                            calcPreco();
                            addListaProdutos(qntDigitada);
                            mostrarProdutosListados();
                            valorDescontoItem = 0;
                        } else {
                            alerta.mensagemAviso("Essa venda já foi efetivada, não podendo adicionar ou remover produtos da lista!!!");
                        }

                    } else {
                        new Alertas().mensagemAviso("Quantidade insuficiente no estoque ou 0!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tfQuantidadeFocusGained

    private void tfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuantidadeFocusLost

    private void tfProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProdutoFocusLost

    }//GEN-LAST:event_tfProdutoFocusLost

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        new AlteraOperacaoSaidaView(this).setVisible(true);
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked

    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        new ConfigurarTelaVendas(this).setVisible(true);
    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        new AlteraDadosSaidaView(this, 1).setVisible(true);
    }//GEN-LAST:event_jLabel18MousePressed

    private void jLabel18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseReleased

    }//GEN-LAST:event_jLabel18MouseReleased

    private void lbCaixaEditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCaixaEditMousePressed
        new AlteraDadosSaidaView(this, 3).setVisible(true);
    }//GEN-LAST:event_lbCaixaEditMousePressed

    private void lbCaixaEditMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCaixaEditMouseReleased

    }//GEN-LAST:event_lbCaixaEditMouseReleased

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        new AlteraDadosSaidaView(this, 2).setVisible(true);
    }//GEN-LAST:event_jLabel20MousePressed

    private void jLabel20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseReleased

    private void tfProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProdutoFocusGained
        if (cont == 0) {
            mostrarProdutosListados();
            if (this.venda.getId() > 0) {
                lbCupom.setText(venda.getId().toString());
            }
            cont++;
        }
    }//GEN-LAST:event_tfProdutoFocusGained

    private void lbEditeCupomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditeCupomMousePressed
        new AlteraDadosSaidaView(this, 4).setVisible(true);
    }//GEN-LAST:event_lbEditeCupomMousePressed

    private void lbEditeCupomMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditeCupomMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lbEditeCupomMouseReleased

    private void tfQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyTyped
        String caracteres = "0987654321";
        if (unidadeVenda.equals("KG")) {
            caracteres = "0987654321,";
        }
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfQuantidadeKeyTyped

    private void tfProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoKeyReleased

    }//GEN-LAST:event_tfProdutoKeyReleased

    private void tfProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoKeyTyped

    }//GEN-LAST:event_tfProdutoKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AbrirGavetaDialog agd = new AbrirGavetaDialog(this, false, impressoraAtual);
        System.out.println("impressoa atualis: " + impressoraAtual);
        agd.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(VendasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendasView(null, null, null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList jlProdutos;
    private javax.swing.JLabel lbCaixa;
    private javax.swing.JLabel lbCaixaEdit;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbCupom;
    private javax.swing.JLabel lbEditeCupom;
    private javax.swing.JLabel lbNomeProduto;
    private javax.swing.JLabel lbOperacao;
    private javax.swing.JLabel lbVendedor;
    private javax.swing.JMenuBar mbVendas;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfPrecoTotal;
    private javax.swing.JTextField tfPrecoUnitario;
    private javax.swing.JTextField tfProduto;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfValorTotal;
    // End of variables declaration//GEN-END:variables

    private void calculaPrecoTotal() {
        double precoUnit = Double.parseDouble(tfPrecoUnitario.getText().replace(",", ".").replace(".", ""));
        double qnt = Double.valueOf(tfQuantidade.getText().replace(",", "."));
        double precoTotal = (precoUnit * qnt) / 100;
        tfPrecoTotal.setText(new DecimalFormat("0.00").format(precoTotal));
    }

    private void addListaProdutos(Double qnt) {//volta aqui
        ProdutosVendaEntity pro = new ProdutosVendaEntity();
        pro.setId(idAtualprod);
        pro.setCodigoProduto(Integer.parseInt(tfProduto.getText()));
//                pro.setQuantidade(Double.parseDouble(tfQuantidade.getText().replace(",", ".")));
        pro.setQuantidade(qnt);
        pro.setProdutoServico(lbNomeProduto.getText());
        pro.setPrecoUnitario(Double.parseDouble(tfPrecoUnitario.getText().replace(",", ".").replace(".", "")));
        pro.setPrecoTotal(Double.parseDouble(tfPrecoTotal.getText().replace(",", ".").replace(".", "")) - valorDescontoItem);
        pro.setDescontoPorcentagem(Double.parseDouble(tfQuantidade.getText().replace(",", ".")));
        pro.setCodigoDinamico(Integer.parseInt(tfProduto.getText()));
        if (verificaProdutoExistente(pro.getId(), pro.getQuantidade())) {

        } else {
            listaProdutos.add(pro);
        }
        valorDescontoItem = 0.0;
    }

    private void mostrarProdutosListados() {
        Double total = 0.0;
        modelLista = new DefaultListModel();
        for (ProdutosVendaEntity pro : listaProdutos) {
            total += pro.getPrecoTotal();
            modelLista.addElement(pro.getCupom().split("###")[1]);
            modelLista.addElement(pro.getCupom().split("###")[2]);
            modelLista.addElement(pro.getCupom().split("###")[3]);
            jlProdutos.setModel(modelLista);
        }
        tfQuantidade.setText("0");
        tfProduto.requestFocus();
        tfProduto.setText("");
        tfPrecoUnitario.setText("0,00");
        tfPrecoTotal.setText("0,00");
        tfValorTotal.setText(new DecimalFormat("0.00").format(total / 100));
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            pesquisarProduto();
        } else if (evt.getKeyCode() == KeyEvent.VK_F12) {

            if (listaProdutos.size() == 0) {
                alerta.mensagemAviso("A lista de produtos esta vazia!!!");
            } else {
                SaidasDAO sDAO = new SaidasDAO();
                if (lbOperacao.getText().equals("PRE-VENDA")) {
                    try {
                        if (sDAO.verificaPrevenda(venda.getId())) {
                            int resposta = JOptionPane.showConfirmDialog(null, "A PRE-VENDA já existe deseja transformar a\nPRE-VENDA em uma VENDA ESTADUAL?", "Selecione uma Opção!", JOptionPane.YES_NO_OPTION);
                            if (resposta == JOptionPane.YES_OPTION) {
                                double qntDigitada = Double.parseDouble(tfQuantidade.getText().replace(",", "."));
                                boolean resp = false;
                                ProdutosVendaEntity prt = new ProdutosVendaEntity();
                                ProdutoEntity prtAux = new ProdutoEntity();
                                List<Integer> listaInt = new ArrayList();
                                int cont2 = 0;
//                                System.out.println("lista id " + listaProdutos.get(0).getCodigoProduto());
                                for (int i = 0; i < listaProdutos.size(); i++) {
                                    prt = listaProdutos.get(i);
                                    System.out.println("prt id " + prt.getCodigoProduto());
                                    prtAux = prodDao.pesquisaProdutoQuantPorId(prt.getCodigoProduto());

//                                    ProdutoEntity pro : prodDao.pesquisarProdutoFromCodigoBarrasOrId(codigo)
                                    if ((ctve.getPermitirEstqNegativo() == 1 || (prt.getQuantidade() <= prtAux.getQntAtual())) && cont2 == 0) {
                                        resp = true;
                                    } else {
                                        cont2++;
                                        if (prt.getQuantidade() <= prtAux.getQntAtual()) {

                                        } else {
                                            listaInt.add(prt.getCodigoProduto());
                                        }

                                        resp = false;
                                    }
                                }

                                if (resp == true) {
                                    lbOperacao.setText("VENDA ESTADUAL");
                                    venda.setOperacao("VENDA ESTADUAL");
                                    lbCupom.setText("");
                                    alerta.mensagemConfirmacao("PRE-VENDA transformada em VENDA ESTADUAL com sucesso!!!");
                                    finalizarVenda();
                                } else {
                                    alerta.mensagemAviso("Um ou mais dos produtos da lista estão sem estoque!!!\n os Produtos são" + listaInt);
                                }
                            } else if (resposta == JOptionPane.NO_OPTION) {

                            }
                        } else {
                            finalizaPreVenda();
                            Integer auxId = sDAO.retornaLastSaida();
                            this.venda = sDAO.retornaSaida(auxId);
                            lbCupom.setText(auxId.toString());
                            if (ctve.getSempreImpPreVenda() == 1) {
                                System.out.println("sempre imprimir pre venda");
                                if (impressoraAtual.equals("ImpressoraBematech")) {
                                    imprimirPreVendaBematech();
                                } else if (impressoraAtual.equals("ImpressoraDaruma")) {
                                    imprimirPreVendaDaruma();
                                }
                            } else if (ctve.getSemprePergImpPreVenda() == 1) {
                                System.out.println("sempre perguntar pre venda");
                                int resposta = JOptionPane.showConfirmDialog(null, "Deseja Imprimir a Pré-Venda?", "Selecione uma Opção!", JOptionPane.YES_NO_OPTION);
                                if (resposta == JOptionPane.YES_OPTION) {
                                    if (impressoraAtual.equals("ImpressoraBematech")) {
                                        imprimirPreVendaBematech();
                                    } else if (impressoraAtual.equals("ImpressoraDaruma")) {
                                        imprimirPreVendaDaruma();
                                    }
                                } else {

                                }
                            } else if (ctve.getNuncaImpPreVenda() == 1) {
                                System.out.println("nunca perguntar pre venda");
                            }
                            alerta.mensagemConfirmacao("PRE-VENDA realizada com sucesso!");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                } else if (lbOperacao.getText().equals("VENDA ESTADUAL")) {
                    try {
                        if (sDAO.verificaVenda(venda.getId())) {
                            int resposta = JOptionPane.showConfirmDialog(null, "Essa VENDA ESTADUAL já foi efetivada!\n Deseja reimprimir o cupom?", "Selecione uma Opção!", JOptionPane.YES_NO_OPTION);
                            if (resposta == JOptionPane.YES_OPTION) {
                                if (impressoraAtual.equals("ImpressoraBematech")) {
                                    imprimirCabecalhoBematech();
                                } else if (impressoraAtual.equals("ImpressoraDaruma")) {
                                    imprimirCabecalhoDaruma();
                                }
                            } else if (resposta == JOptionPane.NO_OPTION) {

                            }
                        } else {
                            finalizarVenda();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else if (lbOperacao.getText().equals("BRINDE")) {
                    try {
                        if (sDAO.verificaVenda(venda.getId())) {
//                            int resposta = JOptionPane.showConfirmDialog(null, "Essa VENDA ESTADUAL já foi efetivada!\n Deseja reimprimir o cupom?", "Selecione uma Opção!", JOptionPane.YES_NO_OPTION);
//                            if (resposta == JOptionPane.YES_OPTION) {
//                                imprimirCabecalhoBematech();
//                            } else if (resposta == JOptionPane.NO_OPTION) {
//
//                            }
                        } else {
                            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente realizar esta venda como brinde!?", "Selecione uma Opção!", JOptionPane.YES_NO_OPTION);
                            if (resposta == JOptionPane.YES_OPTION) {
                                finalizaVendaBrinde();
                            } else if (resposta == JOptionPane.NO_OPTION) {

                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else if (lbOperacao.getText().equals("TROCA")) {
                    finalizaTroca();
                }
            }

        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {

            NovaVendaView nv = new NovaVendaView(this);

            if (listaProdutos.size() > 0) {
                int opcao = JOptionPane.showConfirmDialog(null, "Há dados pendentes na saída, deseja realmente iniciar\numa nova venda?");
                if (opcao == JOptionPane.YES_OPTION) {
                    novaVenda();
                    nv.setVisible(true);
                }
            } else {
                novaVenda();
                nv.setVisible(true);
            }

        } else if (evt.getKeyCode() == KeyEvent.VK_F7) {

            if (lbOperacao.getText().equals("VENDA ESTADUAL") && !lbCupom.getText().equals("")) {
                cancelarVenda();
            } else {
                alerta.mensagemErro("Não existe um cupom selecionado!");
            }

        } else if (evt.getKeyCode() == KeyEvent.VK_F8) {

            if (lbCupom.getText().equals("") || !lbOperacao.getText().equals("VENDA ESTADUAL")) {
                cancelarItem();
            } else {
                alerta.mensagemAviso("Essa venda já foi efetivada, não podendo adicionar ou remover produtos da lista!!!");
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F2) {

            new BuscarVendaView(this, rootPaneCheckingEnabled, this).setVisible(true);

        } else if (evt.getKeyCode() == KeyEvent.VK_F3) {

            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a forma de desconto:\n1 - Dinheiro\n2 - Porcentagem"));
            if (opcao == 1) {
                valorDescontoItem = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor:\nObs: Use vírgula para separar as casas decimais!").replace(",", ".").replace(".", ""));
            } else if (opcao == 2) {
                descontoItemPorcentagem();
            } else {
                new Alertas().mensagemErro("Opção inválida!");
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            if (evt.getKeyCode() == KeyEvent.VK_F5) {
                System.out.println("EXECUTOU O Q DEVIA SER EXECUTADO");
            }
        } else {
//            new ValidarCamposNumericos().validar(tfQuantidade);
//            tfQuantidade.setText(tfQuantidade.getText().replace("/", "")
//                    .replace(".", "").replace(",", "").replace("|", "")
//                    .replace("*", "").replace("'", "").replace(";", "")
//                    .replace("]", "").replace("~", "").replace("´", "")
//                    .replace("=", "").replace("-", "").replace("[", "")
//                    .replace("+", "").replace("ç", ""));
        }
    }

    private void pesquisarProduto() {
        //   ValidarCamposNumericos vcn = new ValidarCamposNumericos();
        String produto = tfProduto.getText();
        //   produto = vcn.removerNumeros(produto);
        BuscaProdutoVendaView busca = new BuscaProdutoVendaView(this, true, produto);
        busca.setVisible(true);
        try {
            for (ProdutoEntity p : busca.dadosProduto()) {
                lbNomeProduto.setText(p.getNome());
                tfProduto.setText(p.getCodigoProduto().toString());
                codigo = p.getId().toString();
                tfPrecoUnitario.setText(new DecimalFormat("0.00").format(p.getPrecoDeVenda()));
                unidadeVenda = p.getUnidadeDeVenda();
                idAtualprod = p.getId();
                calculaPrecoTotal();
                lancaProduto();
                tfQuantidade.setText("1");
                tfQuantidade.requestFocus();
                tfQuantidade.selectAll();
            }
        } catch (NullPointerException e) {
            tfProduto.requestFocus();
        }
    }

    public boolean verificaProdutoExistente(Integer id, double quantidade) {
        if (listaProdutos.size() == 0) {

        } else {
            ProdutosVendaEntity pro = new ProdutosVendaEntity();
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (this.listaProdutos.get(i).getId() == id) {
                    double auxQant = this.listaProdutos.get(i).getQuantidade() + quantidade;
                    if ((quantAtualPrt > this.listaProdutos.get(i).getQuantidade() && quantidade <= quantAtualPrt && (quantAtualPrt > auxQant || quantAtualPrt >= auxQant)) || ctve.getPermitirEstqNegativo() == 1) {
                        pro.setId(this.listaProdutos.get(i).getId());
                        pro.setCodigoProduto(this.listaProdutos.get(i).getCodigoProduto());
                        pro.setQuantidade(this.listaProdutos.get(i).getQuantidade() + quantidade);
                        pro.setProdutoServico(this.listaProdutos.get(i).getProdutoServico());
                        pro.setPrecoUnitario(this.listaProdutos.get(i).getPrecoUnitario());
                        pro.setPrecoTotal((pro.getPrecoUnitario() * pro.getQuantidade()) - valorDescontoItem);
                        pro.setDescontoPorcentagem(this.listaProdutos.get(i).getDescontoPorcentagem());
                        pro.setCodigoDinamico(this.listaProdutos.get(i).getCodigoDinamico());
                        this.listaProdutos.remove(i);
                        this.listaProdutos.add(pro);
                        //  contador--;
                    } else {
                        alerta.mensagemAviso("Quantidade insuficiente no estoque!");
                    }
                    valorDescontoItem = 0.0;
                    return true;
                }
            }
        }
        return false;
    }

    private void preencheComboOperacao() {
//        try {
//            OperacaoDeSaidaDAO saida = new OperacaoDeSaidaDAO();
//            for (OperacaoDeSaidaEntity op : saida.listar("%")) {
//                jcOperacao.addItem(op.getNome());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void lancaProduto() {
        try {
            String aux32 = tfProduto.getText();
            trueTfProduto = tfProduto.getText();
            if (tfProduto.getText().contains("*")) {
                aux32 = tfProduto.getText().substring(tfProduto.getText().indexOf("*") + 1, tfProduto.getText().length());
            }

            codigo = aux32.replace("*", "");
            System.out.println("aux 32 " + codigo);
//            codigo = tfProduto.getText();
            for (ProdutoEntity p : prodDao.pesquisarProdutoFromCodigoBarrasOrId(codigo)) {
                System.out.print(prodDao.pesquisarProdutoFromCodigoBarrasOrId(codigo).size());

                if (prodDao.pesquisarProdutoFromCodigoBarrasOrId(codigo).size() == 0) {
                    new Alertas().mensagemAviso("Produto inexistente!");
                } else {
                    tfPrecoUnitario.setText(new DecimalFormat("0.00").format(p.getPrecoDeVenda()));

                    trueTfProduto = tfProduto.getText();

                    tfProduto.setText(p.getCodigoProduto().toString());
                    lbNomeProduto.setText(p.getNome() + " - " + p.getUnidadeDeVenda());
                    unidadeVenda = p.getUnidadeDeVenda();
                    idAtualprod = p.getId();
                    tfQuantidade.setText("1");
                    if (codigo.length() > 10) {
                        leitor = true;
                    }
                    tfQuantidade.requestFocusInWindow();
                }
            }
            System.out.println("true tf " + trueTfProduto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherComboOperador() {
//        try {
//            for (UsuarioEntity us : ud.listar("%")) {
//                jcOperador.addItem(us.getNome_usuario());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void novaVenda() {
        listaProdutos.clear();
        modelLista = new DefaultListModel();
        jlProdutos.setModel(modelLista);
        lbNomeProduto.setText("");
        tfQuantidade.setText("0");
        tfPrecoUnitario.setText("0,00");
        tfPrecoTotal.setText("0,00");
        lbCliente.setText("CLIENTE BALCAO");
        lbCupom.setText("");
        lbOperacao.setText("VENDA ESTADUAL");
        this.venda = new VendaEntity();
        this.venda.setId(0);
        try {
            ClienteEntity ce = new ClienteEntity();
            ce.setId(1);
            ClienteDAO dao = new ClienteDAO();
            for (ClienteEntity cliente : dao.selecionaCliente(ce)) {
                lbCliente.setText(cliente.getNome());
                this.ce = cliente;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mostrarProdutosListados();
    }

    private void cancelarVenda() {

        CancelarVenda cv = new CancelarVenda(this, lbCupom.getText());
        cv.setVisible(true);

//        listaProdutos.clear();
//        modelLista = new DefaultListModel();
//        jlProdutos.setModel(modelLista);
//        lbNomeProduto.setText("");
//        tfQuantidade.setText("0");
//        tfPrecoUnitario.setText("0,00");
//        tfPrecoTotal.setText("0,00");//cancela1
//                        
//        lbCliente.setText("CLIENTE BALCAO");
//        lbCupom.setText("");
//        lbOperacao.setText("VENDA ESTADUAL");
//        this.venda = new VendaEntity();
//        this.venda.setId(0);
//        venda.setClienteID(1);
//        venda.setOperacao(lbOperacao.getText());
//        venda.setVendedor(lbVendedor.getText());
//        
//        mostrarProdutosListados();
    }

    private void cancelarItem() {
        int codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto!"));
        for (ProdutosVendaEntity p : listaProdutos) {
            if (p.getCodigoProduto() == codigoProduto) {
                listaProdutos.remove(p);
            }
            if (listaProdutos.size() == 0) {
                listaProdutos.clear();
                modelLista = new DefaultListModel();
                jlProdutos.setModel(modelLista);
                mostrarProdutosListados();
            } else {
                mostrarProdutosListados();
            }
        }
    }

    private void finalizarVenda() {
        venda.setVendedor(lbVendedor.getText());
        venda.setOperacao(lbOperacao.getText());
        venda.setCaixa(lbCaixa.getText());
        venda.setVlrTotal(Double.parseDouble(tfValorTotal.getText().replace(",", ".").replace(".", "")));
        Double valorTotal = Double.parseDouble(tfValorTotal.getText().replace(",", ".").replace(".", ""));
        new FinalizaVendaView(this, venda, listaProdutos, lbOperacao.getText(), valorTotal, ce).setVisible(true);
    }

    private void descontoItemPorcentagem() {
        double porcentagem = Double.parseDouble(JOptionPane.showInputDialog("Digite a porcentagem:\nObs: Caso seja porcentagem quebrada, use vírgula para separar as casas decimais!").replace(",", "."));
        double precoTotal = Double.parseDouble(tfPrecoTotal.getText().replace(",", ".").replace(".", ""));
        double desconto = (porcentagem * (precoTotal / 100) / 10);
        System.out.println(desconto);
        valorDescontoItem = (precoTotal / 100) - desconto;
    }

    private void calcPreco() {
        if (!tfQuantidade.getText().isEmpty()) {
            if (unidadeVenda.equals("UN")) {
                new ValidarCamposNumericos().validar(tfQuantidade);
            } else {

            }
            calculaPrecoTotal();
        }
    }

    @Override
    public void apagarLista() {
        if (ctve.getLimparTelaVendasAposFinalizar() == 1) {
            listaProdutos.clear();
            modelLista = new DefaultListModel();
            jlProdutos.setModel(modelLista);
            lbNomeProduto.setText("");
            tfQuantidade.setText("0");
            tfPrecoUnitario.setText("0,00");
            tfPrecoTotal.setText("0,00");
            tfValorTotal.setText("0,00");
            //mostrarProdutosListados();
            lbCliente.setText("");
            lbCupom.setText("");
            this.ce = new ClienteEntity();
            this.venda = new VendaEntity();
            venda.setOperacao("VENDA ESTADUAL");//MUDEI não existia
            lbOperacao.setText("VENDA ESTADUAL");//MUDEI não existia
            lbCliente.setText("CLIENTE BALCAO");
            venda.setVendedor(lbVendedor.getText());
            venda.setCaixa(lbCaixa.getText());
            venda.setId(0);
            ce.setId(1);
            ce.setNome("CLIENTE BALCAO");
            mostrarProdutosListados();
        } else {
            lbCupom.setText("");
        }
    }

    @Override
    public void selecionaOperacao(String operacao) {
        lbOperacao.setText(operacao);
        venda.setOperacao(operacao);
        lbCupom.setText("");
    }

    @Override
    public void selecionaCliente(ClienteEntity cliente) {
        this.ce = cliente;
        lbCliente.setText(ce.getNome());
        venda.setClienteID(cliente.getId());
    }

    @Override
    public ClienteEntity retornaCliente() {
        return ce;
    }

    @Override
    public void selecionaVendedor(String vendedor) {
        lbVendedor.setText(vendedor);
        venda.setVendedor(vendedor);
    }

    @Override
    public void selecionaCaixa(String caixa) {
        lbCaixa.setText(caixa);
        venda.setCaixa(caixa);
    }

    @Override
    public void atualizaCfg(ConfigurarTelaVendasEntity ctve) {
        try {
            this.ctve = ctve;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void selecionaCupom(VendaEntity ve, List<ProdutosVendaEntity> lista) {
        this.venda = ve;
        this.listaProdutos = lista;

        List<ClienteEntity> ml = new ArrayList();
        ClienteEntity ce = new ClienteEntity();
        ce.setId(Integer.parseInt(this.venda.getClienteID().toString()));
        ClienteDAO dao = new ClienteDAO();
        ml = dao.selecionaCliente(ce);
        this.ce = ml.get(0);

        lbOperacao.setText(venda.getOperacao());
        lbCliente.setText(ce.getNome());
        // verificar
        lbCaixa.setText(venda.getCaixa());
        lbCupom.setText(this.venda.getId().toString());
        mostrarProdutosListados();
    }

    private void imprimirCupomBematech(int i) {
        String tipoDeVenda = "";
        String auxCodigo = "";
        String auxQuant = "";
        String auxPrecoUn = "";
        String esp1 = "            ";//12

        ProdutosVendaEntity auxP = new ProdutosVendaEntity();
//fix
        auxP = listaProdutos.get(i);
        auxCodigo = auxP.getCodigoProduto().toString();
        auxQuant = auxP.getQuantidade().toString();
        auxPrecoUn = auxP.getPrecoUnitario().toString();
        dll.BematechTX(auxP.getProdutoServico() + "\n" + auxCodigo + " " + esp1 + "   " + auxQuant + "     R$" + new DecimalFormat("0.00").format(Double.parseDouble(auxPrecoUn) / 100) + "   R$" + new DecimalFormat("0.00").format(auxP.getPrecoTotal() / 100) + "\n");
        valorTotal += auxP.getPrecoTotal() / 100;
    }

    public void imprimirCabecalhoBematech() {
        new CupomBematch(dll, venda, ce, cupomEntity, listaProdutos, valorTotal).imprimirCabecalhoBematechVendas();
    }

    public void imprimirPreVendaBematech() {
        new CupomBematch(dll, venda, ce, cupomEntity, listaProdutos, valorTotal).imprimirPreVendaBematechVendas();
    }

    public void imprimirCabecalhoDaruma() {
        new CupomDaruma(venda, ce, cupomEntity, impressoraDarumaEntity, listaProdutos, valorTotal).imprimirCabecalhoDarumaVendasRealizada();
//        String aux = retornaResumoPag();
//        String aux2 = retornaResumoPagParcelado();
//        Integer codigoVenda = 0;
//        try {
//            codigoVenda = venda.getId();
//
//        } catch (Exception ex) {
//            Logger.getLogger(FinalizaVendaView.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//
//        dll.AjustaLarguraPapel(600);
//        dll.FormataTX(cupomEntity.getCabecalho() + "\n", 2, 0, 0, 1, 1);
//        dll.FormataTX(cupomEntity.getEndereco() + "\n", 2, 0, 0, 0, 0);
//        dll.BematechTX("--------------------------------------------------\n");
//        dll.BematechTX("Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString());
//        dll.BematechTX("\nCaixa: " + venda.getCaixa());
//        dll.BematechTX("   Data/Hora: " + venda.getDataVenda() + " " + venda.getHora());
//        dll.BematechTX("\n       --------- DADOS DO CLIENTE ---------\n");
//
//        if (ce.getNome() != null && !ce.getNome().equals("")) {
//            dll.BematechTX("Nome: " + ce.getNome() + "\n");
//        }
//
//        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
//            dll.BematechTX("Endereco: " + ce.getEndereco() + "\n");
//        }
//        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
//            dll.BematechTX("CPF: " + ce.getCnpjOuCpf() + "\n");
//        }
//        dll.BematechTX("          ****** CUPOM NAO FISCAL ******\n");
//        dll.BematechTX("Descricao   Cod   Quant   PrecoUN   PrecoTotal\n");
//        dll.BematechTX("-------------------------------------------------\n");
//        for (int i = 0; i < listaProdutos.size(); i++) {
//            imprimirCupomBematech(i);
//        }//0 ao 15
//        dll.BematechTX("----------------Resumo da Compra-----------------\n");
//        dll.FormataTX(aux, 2, 0, 0, 0, 1);
//        System.out.println("aux: " + aux);
//        dll.BematechTX(aux2);
//        System.out.println("aux2: " + aux2);
//        dll.BematechTX("\nValor Total R$" + new DecimalFormat("0.00").format(valorTotal));
//        dll.FormataTX("\n" + cupomEntity.getMensagem(), 2, 0, 0, 0, 1);
//
//        dll.AcionaGuilhotina(1);
    }

    public void imprimirPreVendaDaruma() {
        new CupomDaruma(venda, ce, cupomEntity, impressoraDarumaEntity, listaProdutos, valorTotal).imprimirPreVendaDarumaVendas();
//        Integer codigoVenda = 0;
//        try {
//            codigoVenda = venda.getId();
//
//        } catch (Exception ex) {
//            Logger.getLogger(FinalizaVendaView.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//
//        int iRetorno = DUAL.iImprimirTexto(cupomEntity.getCabecalho(), 0);
//        iRetorno = DUAL.iImprimirTexto(cupomEntity.getEndereco(), 0);//COMEÇAR AQUI COMECAR AQUI
//        iRetorno = DUAL.iImprimirTexto("--------------------------------------------------\n", 0);
//        iRetorno = DUAL.iImprimirTexto("Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString(), 0);
//        iRetorno = DUAL.iImprimirTexto("\nCaixa: " + venda.getCaixa(), 0);
//        iRetorno = DUAL.iImprimirTexto("   Data/Hora: " + venda.getDataVenda() + " " + venda.getHora(), 0);
//        iRetorno = DUAL.iImprimirTexto("\n       --------- DADOS DO CLIENTE ---------\n", 0);
//
//        if (ce.getNome() != null && !ce.getNome().equals("")) {
//            iRetorno = DUAL.iImprimirTexto("Nome: " + ce.getNome() + "\n", 0);
//        }
//        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
//            iRetorno = DUAL.iImprimirTexto("Endereco: " + ce.getEndereco() + "\n", 0);
//        }
//        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
//            iRetorno = DUAL.iImprimirTexto("CPF: " + ce.getCnpjOuCpf() + "\n", 0);
//        }
//        iRetorno = DUAL.iImprimirTexto("          ****** CUPOM NAO FISCAL ******\n", 0);
//        iRetorno = DUAL.iImprimirTexto("Descricao   Cod   Quant   PrecoUN   PrecoTotal\n", 0);
//        iRetorno = DUAL.iImprimirTexto("-------------------------------------------------\n", 0);
//        for (int i = 0; i < listaProdutos.size(); i++) {
//            imprimirCupomDarumaVendas(i);
//        }//0 ao 15
//        iRetorno = DUAL.iImprimirTexto("----------------Resumo da Compra-----------------\n", 0);
//
////        iRetorno = DUAL.iImprimirTexto("\nValor Total R$" + new DecimalFormat("0.00").format();
//        iRetorno = DUAL.iImprimirTexto("\n" + cupomEntity.getMensagem(), 0);
//
//        iRetorno
//                = DUAL.iConfigurarGuilhotina(Integer.parseInt(impressoraDarumaEntity.getStatusGuilhotina()), Integer.parseInt(impressoraDarumaEntity.getTamanhoGuilhotina()));

    }

    private void imprimirCupomDarumaVendas(int i) {
        String tipoDeVenda = "";
        String auxCodigo = "";
        String auxQuant = "";
        String auxPrecoUn = "";
        String esp1 = "            ";//12

        ProdutosVendaEntity auxP = new ProdutosVendaEntity();
//fix
        auxP = listaProdutos.get(i);
        auxCodigo = auxP.getCodigoProduto().toString();
        auxQuant = auxP.getQuantidade().toString();
        auxPrecoUn = auxP.getPrecoUnitario().toString();
        int iRetorno = DUAL.iImprimirTexto(auxP.getProdutoServico() + "\n" + auxCodigo + " " + esp1 + "   " + auxQuant + "     R$" + new DecimalFormat("0.00").format(Double.parseDouble(auxPrecoUn) / 100) + "   R$" + new DecimalFormat("0.00").format(auxP.getPrecoTotal() / 100) + "\n", 0);
//        vlrTotal += auxP.getPrecoTotal() / 100;
    }

    private String retornaResumoPag() {
        String aux = "";

        if (venda.getFormaPagamento().equals("DINHEIRO")) {
            aux = aux + " D R$" + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100) + "  ";

            if (venda.getFormaPagamento2().equals("CARTAO CREDITO")) {
                aux = aux + " CC R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento2().equals("CARTAO DEBITO")) {
                aux = aux + " CD R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento2().equals("CHEQUE")) {
                aux = aux + " CQ R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + "  ";
            }
            if (venda.getFormaPagamento3().equals("CARTAO CREDITO")) {
                aux = aux + " CC R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento3().equals("CARTAO DEBITO")) {
                aux = aux + " CD R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento3().equals("CHEQUE")) {
                aux = aux + " CQ R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + "  ";
            }

            if (venda.getFormaPagamento2().equals("PARCELADO")) {
                aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + "  ";
            }
            if (venda.getFormaPagamento3().equals("PARCELADO")) {
                aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + "  ";
            }

        }

        if (venda.getFormaPagamento().equals("CARTAO CREDITO")) {
            aux = aux + " CC R$ " + (venda.getVlrForma1() / 100) + "x" + venda.getParcelas() + " de "
                    + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
        }
        if (venda.getFormaPagamento().equals("CARTAO DEBITO")) {
            aux = aux + " CD x1" + tfValorTotal.getText();
        }
        if (venda.getFormaPagamento().equals("CHEQUE")) {
            aux = aux + " CQ " + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
        }
        if (venda.getFormaPagamento().equals("PARCELADO")) {
            aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
        }

        return aux;
    }

    public String retornaResumoPagParcelado() {
        String aux = "";
        if (venda.getFormaPagamento().equals("DINHEIRO")) {
            if (venda.getFormaPagamento2().equals("PARCELADO")) {
                String data = venda.getDataVenda();
                data = this.data.adiciona1Mes(data);
                aux = aux + "\n";
                Double vlr2 = (venda.getVlrForma2() / 100) / venda.getParcelas();
                for (int i = 1; i <= venda.getParcelas(); i++) {
                    aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlr2)
                            + " " + data;
                    if (i % 2 == 0) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }
            if (venda.getFormaPagamento3().equals("PARCELADO")) {
                String data = venda.getDataVenda();
                data = this.data.adiciona1Mes(data);
                aux = aux + "\n";
                Double vlr3 = (venda.getVlrForma3() / 100) / venda.getParcelas();
                for (int i = 1; i <= venda.getParcelas(); i++) {
                    aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlr3)
                            + " " + data;
                    if (i % 2 == 0) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }
        }
        if (venda.getFormaPagamento().equals("PARCELADO")) {
            String data = venda.getDataVenda();
            data = this.data.adiciona1Mes(data);
            aux = aux + "\n";
            Double vlr1 = (venda.getVlrForma1() / 100) / venda.getParcelas();
            for (int i = 1; i <= venda.getParcelas(); i++) {
                aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlr1)
                        + " " + data;
                if (i % 2 == 0) {
                    aux = aux + "\n";
                }
                data = this.data.adiciona1Mes(data);
            }
        }
        return aux;
    }

    private void finalizaPreVenda() {
        try {
            VendaEntity ve = new VendaEntity();
            ve.setCaixa(lbCaixa.getText());
            ve.setClienteID(ce.getId());
            ve.setStatus("A");
            ve.setOperacao("PRE-VENDA");
            ve.setVendedor(lbVendedor.getText());
            ve.setVlrTotal(Double.parseDouble(tfValorTotal.getText().replace(",", ".").replace(".", "")));
            ve.setDataVenda(data.dataAtual());
            ve.setFormaPagamento("");
            ve.setFormaPagamento2("");
            ve.setFormaPagamento3("");
            ve.setVlrForma1(0.0);
            ve.setVlrForma2(0.0);
            ve.setVlrForma3(0.0);
            ve.setParcelas(0);
            String hora = String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
            ve.setHora(hora);
            daoVenda.efetivarVenda(ve);
            for (ProdutosVendaEntity pro : listaProdutos) {
                daoProd.save(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void imprimirCliente() {
        System.out.println("ve em VendasView");
        System.out.println("Id: " + venda.getId());
        System.out.println("Operacao: " + venda.getOperacao());
        System.out.println("Caixa: " + venda.getCaixa());
        System.out.println("id Cliente: " + venda.getClienteID());
        System.out.println("Vendedor: " + venda.getVendedor());

        System.out.println(venda.getDataVenda());
        System.out.println(venda.getFormaPagamento());
        System.out.println(venda.getFormaPagamento2());
        System.out.println(venda.getFormaPagamento3());
        System.out.println(venda.getParcelas());
        System.out.println(venda.getStatus());
        System.out.println(venda.getVlrForma1());
        System.out.println(venda.getVlrForma2());
        System.out.println(venda.getVlrForma3());
        System.out.println(venda.getVlrTotal());
        System.out.println("_________________________________________________");
    }

    @Override
    public void CancelarVendaEfetivada() {
        try {
            Double novaQuant = 0.0;
            ProdutoEntity pec = new ProdutoEntity();
            for (int i = 0; i < listaProdutos.size(); i++) {
                Integer cod = listaProdutos.get(i).getCodigoProduto();
                pec = prodDao.pesquisaProdutoQuantPorId(cod);
                novaQuant = pec.getQntAtual() + listaProdutos.get(i).getQuantidade();
                daoVenda.RemoveProdutoVendidos(Integer.parseInt(lbCupom.getText()));
                daoVenda.RestocarProdutosVendidos(cod, novaQuant);
            }
            daoVenda.cancelarFluxoNovinha(Integer.parseInt(lbCupom.getText()));
            daoVenda.CancelarContasReceber(Integer.parseInt(lbCupom.getText()));
            daoVenda.cancelarVenda(Integer.parseInt(lbCupom.getText()));
            novaVenda();
        } catch (Exception ex) {
            Logger.getLogger(VendasView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fluxoNovinhaNoGrau() {
        try {
            VendaDAO daoVenda = new VendaDAO();
            int codigoVenda = daoVenda.getLastCodigoVenda();
            System.out.println("Codigo: " + codigoVenda);
            MovimentacaoEntity mov = new MovimentacaoEntity();
            mov.setIdVenda(codigoVenda);
            mov.setIdConta(0);
            mov.setDescricao("Cancelamento de Venda: " + lbCupom.getText());
            mov.setTipoMovimento("SAIDA");
            mov.setValor(Double.valueOf(tfValorTotal.getText().replace(",", ".").replace(".", "")));
            mov.setDataMovimento(nd.dataAtual());
            MovimentacaoDAO dao = new MovimentacaoDAO();
            dao.inserirValorMovimentacao(mov);
        } catch (Exception e) {
            new Alertas().mensagemErro("" + e);
            e.printStackTrace();
        }
    }

    public void finalizaVendaBrinde() {
        try {
            VendaDAO vDAO = new VendaDAO();
            VendaEntity v = new VendaEntity();
            v.setCaixa(lbCaixa.getText());
            v.setVendedor(lbVendedor.getText());
            v.setFormaPagamento("DINHEIRO");
            v.setFormaPagamento2("");
            v.setFormaPagamento3("");
            v.setOperacao(lbOperacao.getText());
            v.setVlrTotal(Double.parseDouble(tfValorTotal.getText().replace(",", ".").replace(".", "")));
            v.setStatus("F");
            v.setClienteID(ce.getId());
            System.out.println("Venda Brinde " + venda.getClienteID());
            v.setDataVenda(data.dataAtual());
            v.setVlrForma2(0.00);
            v.setVlrForma3(0.00);
            v.setVlrForma1(0.00);
            v.setParcelas(1);
            String hora = String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
            v.setHora(hora);
            daoVenda.efetivarVenda(v);
            baixaNoEstoque();
            MovimentacaoDAO dao = new MovimentacaoDAO();
            MovimentacaoEntity movE = new MovimentacaoEntity();

            movE.setCaixa(v.getCaixa());
            movE.setDataMovimento(v.getDataVenda());
            movE.setDescricao("BRINDE");
            movE.setIdConta(0);
            movE.setIdContaPagar(0);
            movE.setIdEntrada(0);
            VendaDAO daoVenda = new VendaDAO();
            int codigoVenda = daoVenda.getLastCodigoVenda();
            movE.setIdVenda(codigoVenda);
            movE.setTipoDePagamento("DINHEIRO");
            movE.setTipoMovimento("SAIDA");
            movE.setValor(Double.parseDouble(tfValorTotal.getText().replace(",", ".").replace(".", "")));
            dao.gravarSaida(movE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void baixaNoEstoque() {
        try {
            List<ProdutosVendaEntity> listaDeBaixas = new ArrayList<>();
            listaDeBaixas = this.listaProdutos;

            for (int i = 0; i < listaDeBaixas.size(); i++) {
                daoProd.daBaixaEsq(listaDeBaixas.get(i).getQuantidade(), listaDeBaixas.get(i).getCodigoProduto());
            }

            for (ProdutosVendaEntity pro : listaProdutos) {
                daoProd.save(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void finalizaTroca() {
        venda.setVendedor(lbVendedor.getText());
        venda.setOperacao(lbOperacao.getText());
        venda.setCaixa(lbCaixa.getText());
        venda.setVlrTotal(Double.parseDouble(tfValorTotal.getText().replace(",", ".").replace(".", "")));
        new TrocaProdutos(venda, listaProdutos, this).setVisible(true);
    }

    private void ajeitarTela() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width = (int) d.getWidth();
        if (width > 1280) {
            this.setExtendedState(MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(MAXIMIZED_VERT);
        }
    }

}
