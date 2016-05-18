package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.classes.*;
import com.br.tecnomais.dao.*;
import com.br.tecnomais.entity.*;
import com.sun.jna.Native;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class FinalizaFinanceiroEntrada extends javax.swing.JDialog {

    Double valorTotal = 0.0;
    private String formaPagamento;
    private List<ProdutosVendaEntity> lista;
    private NovaData data = new NovaData();
    int clienteID;
    String tipoOp;
    Alertas alerta = new Alertas();

    ClienteEntity ce;
    VendaEntity venda;
//      VendaEntity venda = new VendaEntity();
//     ClienteEntity ce = new ClienteEntity();
//    VendasView vendasView = new VendasView(null, null, null, ce, null, venda);
    VendasView vendasView;
    MP2032 dll = (MP2032) Native.loadLibrary("mp2032.dll", MP2032.class);
    String nomeCli = "";
    String cpfCli = "";
    String endCli = "";
    //SelecionaClienteVendaView selCliente = new SelecionaClienteVendaView(this, true, null, null, null);
    InicializaEntradaEntity inicializaEntradaEntity;
    EntradaDAO entradaDAO = new EntradaDAO();
    EntradaFinanceiroEntity efe;
    boolean statusFinalizacao = false;
    UsuarioEntity u;

    public FinalizaFinanceiroEntrada(InicializaEntradaEntity iniEntrada, Double vlrTotal, UsuarioEntity u) {
        try {
            initComponents();
            Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
            keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_F24, 0));
            KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
            this.u = u;
            tfFocu.setVisible(false);
            //  setValorTotal();
            inicializaEntradaEntity = iniEntrada;
            System.out.println("Caixa " + iniEntrada.getCaixa());
            tfVlrTotal.setText(new DecimalFormat("0.00").format(vlrTotal));
            tfCodigoFormaPagamento.requestFocus();
            setarValores();
            if (entradaDAO.financeiroFoiEfetivado(inicializaEntradaEntity.getSequencia())) {
                btEfetivar.setEnabled(false);
                efe = entradaDAO.retornaFinaceiroEntrada(inicializaEntradaEntity.getSequencia());

                tfFormaPagamento.setText(efe.getFormaPagamento());
                tfFormaPagamento2.setText(efe.getFormaPagamento2());
                tfFormaPagamento3.setText(efe.getFormaPagamento3());

                lbTOP.setText("Finaliza Entrada Financeiro (Efetivado)");

                tfFormaPagamento2.setEnabled(true);
                tfFormaPagamento3.setEnabled(true);
                tfVlrPago2.setEnabled(true);
                tfVlrPago3.setEnabled(true);
                tfIntervaloDias.setEnabled(false);

                tfDataVencimento.setEnabled(true);
                tfParcelas.setEnabled(true);
                tfParcelas.setFocusable(false);
                tfDataVencimento.setEditable(true);
                tfDataVencimento.setFocusable(false);

                tfDataVencimento.setText(tipoOp);

                tfDataVencimento.setText(efe.getDataVencimento());
                tfIntervaloDias.setValue(efe.getIntervaloDias());
                tfParcelas.setText(efe.getParcelas().toString());

                tfVlrPago.setText(efe.getVlrForma1() / 100 + "");
                tfVlrPago2.setText(efe.getVlrForma2() / 100 + "");
                tfVlrPago3.setText(efe.getVlrForma3() / 100 + "");
                tfVlrTotal.setText(efe.getVlrTotal() / 100 + "");

                lbDataAtual.setText(efe.getDataEmissao());

                tfCodigoFormaPagamento.setEnabled(false);
                tfCodigoFormaPagamento2.setEnabled(false);
                tfCodigoFormaPagamento3.setEnabled(false);

                lbTrocoFalta.setForeground(Color.BLUE);
                lbTrocoUnico.setForeground(Color.BLUE);
                lbTroco.setForeground(Color.BLUE);
                tfTroco.setForeground(Color.BLUE);
                tfTroco.setText("0.00");

                tfVlrPago.setFocusable(false);
                tfVlrPago2.setFocusable(false);
                tfVlrPago3.setFocusable(false);
                tfVlrParcelas.setFocusable(false);
                tfDataVencimento.setFocusable(false);
                tfIntervaloDias.setFocusable(false);

                if (tfFormaPagamento.getText().equals("CARTAO CREDITO") || tfFormaPagamento.getText().equals("PARCELADO")) {
                    Double vlrParc = (efe.getVlrTotal() / 100) / efe.getParcelas();
                    tfVlrParcelas.setText(vlrParc.toString());
                } else if (tfFormaPagamento2.getText().equals("PARCELADO")) {
                    Double vlrParc = (efe.getVlrForma2() / 100) / efe.getParcelas();
                    tfVlrParcelas.setText(vlrParc.toString());
                } else if (tfFormaPagamento3.getText().equals("PARCELADO")) {
                    Double vlrParc = (efe.getVlrForma3() / 100) / efe.getParcelas();
                    tfVlrParcelas.setText(vlrParc.toString());
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(FinalizaFinanceiroEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FinalizaFinanceiroEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setModal(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbTOP = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btEfetivar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfVlrTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfVlrParcelas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfParcelas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDataVencimento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tfVlrPago = new javax.swing.JTextField();
        lbTrocoUnico = new javax.swing.JLabel();
        tfTroco = new javax.swing.JTextField();
        lbTroco = new javax.swing.JLabel();
        lbTrocoFalta = new javax.swing.JLabel();
        tfCodigoFormaPagamento = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lbDataAtual = new javax.swing.JLabel();
        tfCodigoFormaPagamento2 = new javax.swing.JTextField();
        tfVlrPago2 = new javax.swing.JTextField();
        tfCodigoFormaPagamento3 = new javax.swing.JTextField();
        tfVlrPago3 = new javax.swing.JTextField();
        tfFormaPagamento = new javax.swing.JTextField();
        tfFormaPagamento2 = new javax.swing.JTextField();
        tfFormaPagamento3 = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        tfFocu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfIntervaloDias = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PDV Evolution");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        lbTOP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTOP.setText("Finaliza Entrada Financeiro (Aberto)");

        btEfetivar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btEfetivar.setText("Efetivar-F12");
        btEfetivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btEfetivarMousePressed(evt);
            }
        });
        btEfetivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEfetivarActionPerformed(evt);
            }
        });
        btEfetivar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btEfetivarKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Forma de Pagamento");

        jLabel6.setText("Vlr. Total:");

        jLabel2.setText("Vlr. Parcelas:");

        tfVlrParcelas.setText("0,00");
        tfVlrParcelas.setFocusable(false);
        tfVlrParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVlrParcelasActionPerformed(evt);
            }
        });

        jLabel3.setText("Parcelas:");

        tfParcelas.setText("1");
        tfParcelas.setEnabled(false);
        tfParcelas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfParcelasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfParcelasFocusLost(evt);
            }
        });
        tfParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfParcelasActionPerformed(evt);
            }
        });
        tfParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfParcelasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfParcelasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfParcelasKeyTyped(evt);
            }
        });

        jLabel4.setText("Data Venc.:");

        try {
            tfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataVencimento.setEnabled(false);
        tfDataVencimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDataVencimentoKeyPressed(evt);
            }
        });

        jLabel7.setText("Vlr. Pago:");

        tfVlrPago.setText("0.00");
        tfVlrPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tfVlrPagoMousePressed(evt);
            }
        });
        tfVlrPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVlrPagoActionPerformed(evt);
            }
        });
        tfVlrPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfVlrPagoFocusLost(evt);
            }
        });
        tfVlrPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfVlrPagoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfVlrPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfVlrPagoKeyTyped(evt);
            }
        });

        lbTrocoUnico.setText("Troco:");

        tfTroco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTrocoActionPerformed(evt);
            }
        });

        lbTroco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTroco.setText("0,00");

        lbTrocoFalta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTrocoFalta.setText("Troco");

        tfCodigoFormaPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoFormaPagamentoFocusLost(evt);
            }
        });
        tfCodigoFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoFormaPagamentoActionPerformed(evt);
            }
        });
        tfCodigoFormaPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodigoFormaPagamentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCodigoFormaPagamentoKeyTyped(evt);
            }
        });

        lbDataAtual.setText("jLabel9");

        tfCodigoFormaPagamento2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoFormaPagamento2FocusLost(evt);
            }
        });
        tfCodigoFormaPagamento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoFormaPagamento2ActionPerformed(evt);
            }
        });
        tfCodigoFormaPagamento2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodigoFormaPagamento2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCodigoFormaPagamento2KeyTyped(evt);
            }
        });

        tfVlrPago2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfVlrPago2FocusLost(evt);
            }
        });
        tfVlrPago2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVlrPago2ActionPerformed(evt);
            }
        });
        tfVlrPago2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfVlrPago2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfVlrPago2KeyReleased(evt);
            }
        });

        tfCodigoFormaPagamento3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoFormaPagamento3FocusLost(evt);
            }
        });
        tfCodigoFormaPagamento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoFormaPagamento3ActionPerformed(evt);
            }
        });
        tfCodigoFormaPagamento3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodigoFormaPagamento3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCodigoFormaPagamento3KeyTyped(evt);
            }
        });

        tfVlrPago3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfVlrPago3FocusLost(evt);
            }
        });
        tfVlrPago3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVlrPago3ActionPerformed(evt);
            }
        });
        tfVlrPago3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfVlrPago3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfVlrPago3KeyReleased(evt);
            }
        });

        tfFormaPagamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfFormaPagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFormaPagamento.setFocusable(false);

        tfFormaPagamento2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfFormaPagamento2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFormaPagamento2.setFocusable(false);

        tfFormaPagamento3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfFormaPagamento3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFormaPagamento3.setFocusable(false);
        tfFormaPagamento3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFormaPagamento3KeyPressed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCancelar.setText("Cancelar-F5");
        btCancelar.setFocusable(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Intervalo de Dias:");

        tfIntervaloDias.setModel(new javax.swing.SpinnerNumberModel(30, 1, 90, 1));
        tfIntervaloDias.setFocusable(false);
        tfIntervaloDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfIntervaloDiasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfIntervaloDiasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIntervaloDiasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfFocu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTrocoFalta)
                            .addComponent(lbTroco))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tfCodigoFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(tfCodigoFormaPagamento2)
                                                    .addComponent(tfCodigoFormaPagamento3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tfFormaPagamento2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                                    .addComponent(tfFormaPagamento3))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfVlrPago2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfVlrPago3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfVlrPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTrocoUnico)
                                        .addGap(79, 79, 79))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfVlrTotal)
                                    .addComponent(tfVlrParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(tfDataVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(tfIntervaloDias))))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbDataAtual)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btCancelar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEfetivar))
                            .addComponent(lbTOP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btEfetivar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTOP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(lbTrocoUnico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCodigoFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfVlrPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfVlrPago2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfCodigoFormaPagamento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfFormaPagamento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCodigoFormaPagamento3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfVlrPago3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFormaPagamento3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfTroco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfVlrTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfVlrParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(tfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfIntervaloDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTrocoFalta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTroco)
                    .addComponent(tfFocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lbDataAtual))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar)
                            .addComponent(btEfetivar))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancelar, btEfetivar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEfetivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEfetivarActionPerformed
        System.out.println("valor da treta é" + tfIntervaloDias.getValue().toString());
        // ce = this.vendasView.retornaCliente();
//        clienteID = ce.getId();
        tfParcelas.requestFocus();
        btEfetivar.requestFocus();
        if (Double.parseDouble(tfTroco.getText().replace(",", ".")) > 0.00) {
            new Alertas().mensagemAviso("Valor pago é menor que o valor a ser pago");
        } else {
            finalizarVendaOp();
        }
    }//GEN-LAST:event_btEfetivarActionPerformed

    private void tfVlrPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVlrPagoKeyReleased
//        tfVlrPago.setText(new Dinheiro().dinheiro(tfVlrPago.getText()));
    }//GEN-LAST:event_tfVlrPagoKeyReleased

    private void tfCodigoFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamentoActionPerformed
        codigoFormaPagamento();
    }//GEN-LAST:event_tfCodigoFormaPagamentoActionPerformed

    private void tfVlrPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVlrPagoActionPerformed
        valorPag1();
        if (tfFormaPagamento.getText().equals("PARCELADO") || tfFormaPagamento.getText().equals("CARTAO CREDITO")) {
            tfParcelas.requestFocus();
        }
    }//GEN-LAST:event_tfVlrPagoActionPerformed

    private void tfParcelasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfParcelasFocusLost
    }//GEN-LAST:event_tfParcelasFocusLost

    private void tfVlrParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVlrParcelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfVlrParcelasActionPerformed

    private void tfTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTrocoActionPerformed

    private void tfCodigoFormaPagamento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamento2ActionPerformed
        codigoFormaPagamento2();
    }//GEN-LAST:event_tfCodigoFormaPagamento2ActionPerformed

    private void tfVlrPago2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVlrPago2ActionPerformed
        valorPag2();
//        if (tfFormaPagamento2.getText().equals("PARCELADO") || tfFormaPagamento2.getText().equals("CARTAO CREDITO")) {
//            tfParcelas.requestFocus();
//        }

////        Double vlrTotalNormal = Double.parseDouble(tfVlrPago2.getText().replace(",", "."));
//
////        tfVlrPago2.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
//        double vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""));
////                + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//        Double vlrMaximo = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")
//                .replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//        Double vlrCamp1 = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//        if (tfCodigoFormaPagamento2.getText().equals("2")) {
//            tfParcelas.setText("1");
//            tfVlrParcelas.setFocusable(false);
//            tfVlrParcelas.setText(tfVlrPago2.getText());
//            if (Double.parseDouble(tfTroco.getText()) > 0.0) {
//
//            }
//        } else {
//            tfParcelas.setText("1");
//        }
//
//        double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
//        double troco = vlrTotal - vlrPago;
//        tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//        lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//
//        if (tfCodigoFormaPagamento.getText().contains("1")) {
//            if (vlrTotal <= vlrPago) {
//                if (vlrTotal < vlrPago) {
//                    tfVlrParcelas.setText(tfVlrTotal.getText());
//                    Double vlr = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
////                    tfVlrPago2.setText(new DecimalFormat("0.00").format(vlr / 100));
//
//                    tfVlrPago2.setText(new DecimalFormat("0.00").format(vlrMaximo / 100).replace(",", "."));
////                    vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""));
//
//                    troco = vlrTotal - (vlrMaximo + vlrCamp1);
//                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//                    if (tfFormaPagamento2.equals("PARCELADO")) {
//                        tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlr / 100));
//                    }
//                    lbTroco.setForeground(Color.BLUE);
//                    lbTrocoFalta.setText("Troco");
//                    lbTrocoFalta.setForeground(Color.BLUE);
//
//                    lbTrocoUnico.setText("Troco");
//                    lbTrocoUnico.setForeground(Color.BLUE);
//                } else {
//                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//
//                    lbTroco.setForeground(Color.BLUE);
//                    lbTrocoFalta.setText("Troco");
//                    lbTrocoFalta.setForeground(Color.BLUE);
//
//                    lbTrocoUnico.setText("Troco");
//                    lbTrocoUnico.setForeground(Color.BLUE);
//
//                    tfFormaPagamento3.setEnabled(false);
//                    tfCodigoFormaPagamento3.setEnabled(false);
//                    tfVlrPago3.setEnabled(false);
//                    tfFormaPagamento3.setText("");
//                    tfCodigoFormaPagamento3.setText("");
//                    tfVlrPago3.setText("");
//                }
//            } else {
//                tfFormaPagamento3.setEnabled(true);
//                tfCodigoFormaPagamento3.setEnabled(true);
//                tfVlrPago3.setEnabled(true);
//                lbTroco.setForeground(Color.red);
//                lbTrocoFalta.setText("Falta");
//                lbTrocoFalta.setForeground(Color.red);
//
//                lbTrocoUnico.setText("Falta");
//                lbTrocoUnico.setForeground(Color.red);
//
//                tfCodigoFormaPagamento3.requestFocus();
//            }
//        }
//        if (tfCodigoFormaPagamento2.getText().equals("2")) {
//            tfDataVencimento.setEnabled(true);
//            tfDataVencimento.setFocusable(true);
//        }
//
//        if (!tfVlrPago3.getText().equals("")) {
//            vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
//                    + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""))
//                    + Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", ""));
//        }
//        bEfetivar.requestFocus();
    }//GEN-LAST:event_tfVlrPago2ActionPerformed

    private void tfVlrPago2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVlrPago2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfVlrPago2KeyReleased

    private void tfCodigoFormaPagamento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamento3ActionPerformed
        codigoFormaPagamento3();
    }//GEN-LAST:event_tfCodigoFormaPagamento3ActionPerformed

    private void tfVlrPago3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVlrPago3ActionPerformed
        valorPag3();
        if (Integer.parseInt(tfCodigoFormaPagamento3.getText()) == 2) {
            tfParcelas.requestFocus();
        } else {
            btEfetivar.requestFocus();
        }
    }//GEN-LAST:event_tfVlrPago3ActionPerformed

    private void tfVlrPago3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVlrPago3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfVlrPago3KeyReleased

    private void tfParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfParcelasActionPerformed
        if (!tfParcelas.getText().equals("")) {
            double var1;
            double var2;
            double var3;
            Double vlrParc = 0.0;
            if (tfFormaPagamento.getText().equals("CARTAO CREDITO")) {
                var1 = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
                var2 = Integer.parseInt(tfParcelas.getText());
                vlrParc = (var1) / var2;
            }
            if (tfFormaPagamento.getText().equals("PARCELADO")) {
                var1 = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
                var2 = Integer.parseInt(tfParcelas.getText());
                var3 = Double.parseDouble(tfVlrPago.getText().replace(",", "."));
                vlrParc = (var1 - var3) / var2;
            }
            if (tfFormaPagamento2.getText().equals("PARCELADO")) {
                var1 = Double.parseDouble(tfVlrPago2.getText().replace(",", "."));
                var2 = Integer.parseInt(tfParcelas.getText());
                vlrParc = var1 / var2;
            }
            if (tfFormaPagamento3.getText().equals("PARCELADO")) {
                var1 = Double.parseDouble(tfVlrPago3.getText().replace(",", "."));
                var2 = Integer.parseInt(tfParcelas.getText());
                vlrParc = var1 / var2;
            }
            tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrParc));
            btEfetivar.requestFocus();
        }
    }//GEN-LAST:event_tfParcelasActionPerformed

    private void tfParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfParcelasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (tfFormaPagamento.getText().equals("CARTAO CREDITO")) {
                btEfetivar.requestFocus();
            } else if (tfFormaPagamento.getText().equals("PARCELADO")) {
                tfDataVencimento.requestFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tfFormaPagamento.getText().equals("CARTAO CREDITO")) {
                btEfetivar.requestFocus();
            } else if (tfFormaPagamento.getText().equals("PARCELADO")) {
                tfDataVencimento.requestFocus();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfParcelasKeyPressed

    private void tfParcelasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfParcelasKeyReleased

        if (!tfParcelas.getText().equals("")) {
            double var1;
            double var2;
            double var3;
            Double vlrParc = 0.0;
            if (tfFormaPagamento.getText().equals("CARTAO CREDITO")) {
                var1 = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
                var2 = Integer.parseInt(tfParcelas.getText());
                vlrParc = (var1) / var2;
            }
            if (tfFormaPagamento.getText().equals("PARCELADO")) {
                var1 = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
                var2 = Integer.parseInt(tfParcelas.getText());
                var3 = Double.parseDouble(tfVlrPago.getText().replace(",", "."));
                vlrParc = (var1 - var3) / var2;
            }
            if (tfFormaPagamento2.getText().equals("PARCELADO")) {
                var1 = Double.parseDouble(tfVlrPago2.getText().replace(",", "."));
                var2 = Integer.parseInt(tfParcelas.getText());
                vlrParc = var1 / var2;
            }
            if (tfFormaPagamento3.getText().equals("PARCELADO")) {
                var1 = Double.parseDouble(tfVlrPago3.getText().replace(",", "."));
                var2 = Integer.parseInt(tfParcelas.getText());
                vlrParc = var1 / var2;
            }
            tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrParc));
        }


    }//GEN-LAST:event_tfParcelasKeyReleased

    private void tfCodigoFormaPagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            codigoFormaPagamento();
        }
        atalhos(evt);
    }//GEN-LAST:event_tfCodigoFormaPagamentoKeyPressed

    private void tfCodigoFormaPagamento2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamento2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            codigoFormaPagamento2();
        }
        atalhos(evt);
    }//GEN-LAST:event_tfCodigoFormaPagamento2KeyPressed

    private void tfCodigoFormaPagamento3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamento3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            codigoFormaPagamento3();
        }
        atalhos(evt);
    }//GEN-LAST:event_tfCodigoFormaPagamento3KeyPressed

    private void tfVlrPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVlrPagoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            valorPag1();
            if (tfFormaPagamento.getText().equals("PARCELADO") || tfFormaPagamento.getText().equals("CARTAO CREDITO")) {
                tfParcelas.requestFocus();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfVlrPagoKeyPressed

    private void tfVlrPago2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVlrPago2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            valorPag2();
        }
        atalhos(evt);
    }//GEN-LAST:event_tfVlrPago2KeyPressed

    private void tfVlrPago3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVlrPago3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            valorPag3();
            if (tfFormaPagamento2.getText().equals("PARCELADO") || tfFormaPagamento3.getText().equals("PARCELADO")) {
                tfParcelas.requestFocus();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_tfVlrPago3KeyPressed

    private void tfDataVencimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDataVencimentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            btEfetivar.requestFocus();
        }
        atalhos(evt);
    }//GEN-LAST:event_tfDataVencimentoKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        atalhos(evt);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void tfCodigoFormaPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamentoFocusLost
//        tfVlrParcelas.setText("0,00");
//        if (tfCodigoFormaPagamento.getText().isEmpty()) {
//            alerta.mensagemAviso("Digite um codigo de pagamento!");
//            tfCodigoFormaPagamento.requestFocus();
//        } else {
//            if (((tfCodigoFormaPagamento.getText().equals(tfCodigoFormaPagamento2.getText()) && !tfCodigoFormaPagamento2.getText().isEmpty())
//                    || (tfCodigoFormaPagamento.getText().equals(tfCodigoFormaPagamento3.getText())) && !tfCodigoFormaPagamento3.getText().isEmpty()) && (!tfCodigoFormaPagamento2.getText().equals(""))) {
//                alerta.mensagemAviso("Esta Forma de Pagamento já esta sendo utilizada, escolha outra!!!");
//                tfCodigoFormaPagamento.selectAll();
//            } else {
//                tfCodigoFormaPagamento.setName("tfCodigoFormaPagamento");
//                formaPagamentoTf(tfCodigoFormaPagamento, tfFormaPagamento);
//                if (tfCodigoFormaPagamento.getText().replace(" ", "").equals("1") || tfCodigoFormaPagamento.getText().replace(" ", "").equals("4")) {
//                    tfParcelas.setText("1");
//                    tfDataVencimento.setText("");
//                    tfParcelas.setEnabled(false);
//                    tfDataVencimento.setEnabled(false);
//                } else {
//                    if (tfCodigoFormaPagamento2.isEnabled()) {
//                        tfCodigoFormaPagamento2.setText("");
//                        tfFormaPagamento2.setText("");
//                        tfFormaPagamento2.setEnabled(false);
//                        tfCodigoFormaPagamento2.setEnabled(false);
//                        tfVlrPago2.setText("");
//                        tfVlrPago2.setEnabled(false);
//
//                        tfFormaPagamento3.setText("");
//                        tfFormaPagamento3.setEnabled(false);
//                        tfCodigoFormaPagamento3.setText("");
//                        tfCodigoFormaPagamento3.setEnabled(false);
//                        tfVlrPago3.setText("");
//                        tfVlrPago3.setEnabled(false);
//                    }
//                    if (tfCodigoFormaPagamento.getText().equals("4") || tfCodigoFormaPagamento.getText().equals("5")) {
//                        tfParcelas.setFocusable(false);
//                        tfDataVencimento.setFocusable(false);
//                        tfParcelas.setEnabled(false);
//                        tfDataVencimento.setEnabled(false);
//                    } else {
//                        tfParcelas.setFocusable(true);
//                    }
//                    tfDataVencimento.setFocusable(true);
//                    tfParcelas.setEnabled(true);
//                    tfDataVencimento.setEnabled(true);
//                    NovaData nd = new NovaData();
//                    nd.dataAtual(tfDataVencimento);
//                    String data = tfDataVencimento.getText();
//                    data = nd.adiciona1Mes(data);
//                    tfDataVencimento.setText(data);
//                    tfParcelas.setText("1");
//                    //  tfVlrPago.setText("0,00");
//
//                    if (tfCodigoFormaPagamento.getText().equals("3")) {
//                        tfDataVencimento.setEnabled(false);
//                        tfDataVencimento.setFocusable(false);
//                    }
//                }
//                tfVlrPago.requestFocus();
//                if (tfCodigoFormaPagamento.getText().equals("2")) {
//                    tfVlrPago.setText("0.00");
//                } else {
//                    tfVlrPago.setText(tfVlrTotal.getText().replace(",", "."));
//                }
//                tfVlrPago.selectAll();
//            }
//        }
    }//GEN-LAST:event_tfCodigoFormaPagamentoFocusLost

    private void tfCodigoFormaPagamento2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamento2FocusLost
//        if (tfCodigoFormaPagamento2.getText().isEmpty()) {
//            tfCodigoFormaPagamento2.requestFocus();
//            alerta.mensagemAviso("Digite um codigo de pagamento!");
//            tfCodigoFormaPagamento2.requestFocus();
//        } else {
//            if ((tfCodigoFormaPagamento2.getText().equals(tfCodigoFormaPagamento.getText())
//                    || tfCodigoFormaPagamento2.getText().equals(tfCodigoFormaPagamento3.getText())) && (!tfCodigoFormaPagamento2.getText().equals(""))) {
//                alerta.mensagemAviso("Esta Forma de Pagamento já esta sendo utilizada, escolha outra!!!");
//            } else {
//                tfCodigoFormaPagamento2.setName("tfCodigoFormaPagamento2");
//                formaPagamentoTf(tfCodigoFormaPagamento2, tfFormaPagamento2);
//
//                setStatusCampos2();
//                tfVlrPago2.requestFocus();
//                Double aux = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")) - Double.parseDouble(tfVlrPago.getText().replace(",", "."));
//                tfVlrPago2.setText(new DecimalFormat("0.00").format(aux));
//                if (tfCodigoFormaPagamento2.getText().equals("2")) {
//                    tfParcelas.setText("1");
//                    NovaData nd = new NovaData();
//                    nd.dataAtual(tfDataVencimento);
//                    String data = tfDataVencimento.getText();
//                    data = nd.adiciona1Mes(data);
//                    tfDataVencimento.setText(data);
//                    tfDataVencimento.setEnabled(true);
//                    tfDataVencimento.setFocusable(true);
//                    tfParcelas.setEnabled(true);
//                    tfParcelas.setFocusable(true);
////                    if (tfCodigoFormaPagamento2.getText().equals("5")
////                            || tfCodigoFormaPagamento2.getText().equals("4")) {
////                        // tfDataVencimento.setFocusable(false);
////                        tfParcelas.setFocusable(false);
////                    }else{
////                         tfParcelas.setFocusable(true);
////                    }
//                } else {
//                    tfDataVencimento.setFocusable(false);
//                    tfDataVencimento.setEnabled(false);
//                    tfParcelas.setFocusable(false);
//                    tfParcelas.setEnabled(false);
//                    tfParcelas.setText("1");
//                    tfDataVencimento.setText("");
//                }
//                tfVlrPago2.selectAll();
//            }
//
//        }
    }//GEN-LAST:event_tfCodigoFormaPagamento2FocusLost

    private void tfCodigoFormaPagamento3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamento3FocusLost
//        if (tfCodigoFormaPagamento3.getText().isEmpty()) {
//            alerta.mensagemAviso("Digite um codigo de pagamento!");
//            tfCodigoFormaPagamento3.requestFocus();
//        } else {
//            if ((tfCodigoFormaPagamento3.getText().equals(tfCodigoFormaPagamento.getText())
//                    || tfCodigoFormaPagamento3.getText().equals(tfCodigoFormaPagamento2.getText())) && (!tfCodigoFormaPagamento3.getText().equals(""))) {
//                alerta.mensagemAviso("Esta Forma de Pagamento já esta sendo utilizada, escolha outra!!!");
//            } else {
//                tfCodigoFormaPagamento3.setName("tfCodigoFormaPagamento3");
//                formaPagamentoTf(tfCodigoFormaPagamento3, tfFormaPagamento3);
//
//                if (tfCodigoFormaPagamento3.getText().equals("2")) {
//                    tfParcelas.setText("1");
//                    NovaData nd = new NovaData();
//                    nd.dataAtual(tfDataVencimento);
//                    String data = tfDataVencimento.getText();
//                    data = nd.adiciona1Mes(data);
//                    tfDataVencimento.setText(data);
//                    tfDataVencimento.setEnabled(true);
//                    tfDataVencimento.setFocusable(true);
//                    tfParcelas.setEnabled(true);
//                    tfParcelas.setFocusable(true);
//                } else {
////                    tfDataVencimento.setFocusable(false);
////                    tfDataVencimento.setEnabled(false);
////                    tfParcelas.setFocusable(false);
////                    tfParcelas.setEnabled(false);
////                    tfParcelas.setText("");
////                    tfDataVencimento.setText("");
//                }
//
//                setStatusCampos3();
//                tfVlrPago3.requestFocus();
//                tfVlrPago3.requestFocus();
//                Double aux = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".")) - Double.parseDouble(tfVlrPago2.getText().replace(",", "."));
//                tfVlrPago3.setText(new DecimalFormat("0.00").format(aux));
//                tfVlrPago3.selectAll();
//            }
//        }
    }//GEN-LAST:event_tfCodigoFormaPagamento3FocusLost

    private void btEfetivarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEfetivarMousePressed
    }//GEN-LAST:event_btEfetivarMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
        keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
    }//GEN-LAST:event_formWindowClosed

    private void tfVlrPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfVlrPagoFocusLost
//        Double vlrTotalNormal = Double.parseDouble(tfVlrPago.getText().replace(",", "."));
//        tfVlrPago.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
//        double vlrPago = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//        double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
//        double troco = vlrPago - vlrTotal;
//        tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//        lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//
//        if (tfCodigoFormaPagamento.getText().equals("1")) {
//
////            if (!tfVlrPago2.getText().isEmpty() && tfFormaPagamento2.isEnabled()) {
////                vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
////                        + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
////            } else if (!tfVlrPago3.getText().isEmpty() && tfFormaPagamento3.isEnabled()) {
////                vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
////                        + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""))
////                        + Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""));
////            }
//            if (vlrTotal < vlrPago || vlrTotal == vlrPago) {
//                lbTroco.setForeground(Color.BLUE);
//                lbTrocoFalta.setForeground(Color.BLUE);
//
//                lbTrocoFalta.setText("Troco");
//                lbTrocoUnico.setText("Troco");
//
//                lbTrocoUnico.setText("Troco");
//                lbTrocoUnico.setForeground(Color.BLUE);
//
//                tfFormaPagamento2.setEnabled(false);
//                tfCodigoFormaPagamento2.setEnabled(false);
//                tfVlrPago2.setEnabled(false);
//                tfFormaPagamento2.setText("");
//                tfCodigoFormaPagamento2.setText("");
//                tfVlrPago2.setText("");
//
//                tfFormaPagamento3.setEnabled(false);
//                tfCodigoFormaPagamento3.setEnabled(false);
//                tfVlrPago3.setEnabled(false);
//                tfFormaPagamento3.setText("");
//                tfCodigoFormaPagamento3.setText("");
//                tfVlrPago3.setText("");
//
//            } else {
//                //  lbTrocoUnico.setText("Falta");
//                tfFormaPagamento2.setEnabled(true);
//                tfCodigoFormaPagamento2.setEnabled(true);
//                tfVlrPago2.setEnabled(true);
//                lbTroco.setForeground(Color.red);
//
//                lbTrocoFalta.setForeground(Color.red);
//                lbTrocoFalta.setText("Falta");
//
//                lbTrocoUnico.setText("Falta");
//                lbTrocoUnico.setForeground(Color.red);
//
//                tfCodigoFormaPagamento2.requestFocus();
//            }
//            tfParcelas.setEnabled(false);
//            tfDataVencimento.setEnabled(false);
//        } else {
//            if (vlrTotal < vlrPago || vlrTotal == vlrPago) {
//                Double vlrCertoDaParc = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
//                if (vlrTotal < vlrPago) {
//                    tfVlrParcelas.setText(tfVlrTotal.getText());
//                    tfVlrPago.setText(tfVlrTotal.getText());
//
//                    vlrTotalNormal = Double.parseDouble(tfVlrPago.getText().replace(",", "."));
//                    tfVlrPago.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
//                    vlrPago = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//                    vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
//                    troco = vlrPago - vlrTotal;
//                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
////                    tfVlrPago.requestFocus();
////                    tfVlrPago.selectAll();
//                } else {
//                    vlrCertoDaParc = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
//                    tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrCertoDaParc).replace(",", "."));
//
//                    lbTroco.setForeground(Color.BLUE);
//                    lbTrocoFalta.setForeground(Color.BLUE);
//
//                    lbTrocoFalta.setText("Troco");
//                    lbTrocoUnico.setText("Troco");
//
//                    lbTrocoUnico.setText("Troco");
//                    lbTrocoUnico.setForeground(Color.BLUE);
//                }
//            } else {
//                lbTroco.setForeground(Color.red);
//
//                lbTrocoFalta.setForeground(Color.red);
//                lbTrocoFalta.setText("Falta");
//
//                lbTrocoUnico.setText("Falta");
//                lbTrocoUnico.setForeground(Color.red);
//            }
//
//        }
    }//GEN-LAST:event_tfVlrPagoFocusLost

    private void tfParcelasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfParcelasFocusGained

    }//GEN-LAST:event_tfParcelasFocusGained

    private void tfVlrPago2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfVlrPago2FocusLost
//////        Double vlrTotalNormal = Double.parseDouble(tfVlrPago2.getText().replace(",", "."));
//////        tfVlrPago2.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
//////        double vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
//////                + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//////        Double vlrMaximo = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")
//////                .replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//////        Double vlrCamp1 = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//////
//////        if (tfCodigoFormaPagamento2.getText().equals("2")) {
//////            tfParcelas.setText("1");
//////            tfVlrParcelas.setFocusable(false);
//////            tfVlrParcelas.setText(tfVlrPago2.getText());
//////            if (Double.parseDouble(tfTroco.getText()) > 0.0) {
//////
//////            }
//////        } else {
//////            tfParcelas.setText("");
//////        }
//////
//////        double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
//////        double troco = vlrPago - vlrTotal;
//////        tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//////        lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//////
//////        if (tfCodigoFormaPagamento.getText().contains("1")) {
//////            if (vlrPago >= vlrTotal) {
//////                if (vlrPago > vlrTotal) {
//////                    //tfVlrParcelas.setText(tfVlrTotal.getText());
//////                    Double vlr = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//////
//////                    tfVlrPago2.setText(new DecimalFormat("0.00").format(vlrMaximo / 100).replace(",", "."));
//////
//////                    troco = vlrTotal - (vlrMaximo + vlrCamp1);
//////                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//////                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//////                    System.out.println("Aqui é o maximo: " + vlrMaximo);
//////                    if (tfCodigoFormaPagamento2.equals("2")) {
//////                        tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrMaximo / 100));
//////                        System.out.println("Ali tbm: " + tfVlrParcelas.getText());
//////                    }
//////
//////                    lbTroco.setForeground(Color.BLUE);
//////                    lbTrocoFalta.setText("Troco");
//////                    lbTrocoFalta.setForeground(Color.BLUE);
//////
//////                    lbTrocoUnico.setText("Troco");
//////                    lbTrocoUnico.setForeground(Color.BLUE);
//////                } else {
//////                    System.out.println("entrou no else: " + tfVlrParcelas.getText());
//////                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//////                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//////
//////                    lbTroco.setForeground(Color.BLUE);
//////                    lbTrocoFalta.setText("Troco");
//////                    lbTrocoFalta.setForeground(Color.BLUE);
//////
//////                    lbTrocoUnico.setText("Troco");
//////                    lbTrocoUnico.setForeground(Color.BLUE);
//////
//////                    tfFormaPagamento3.setEnabled(false);
//////                    tfCodigoFormaPagamento3.setEnabled(false);
//////                    tfVlrPago3.setEnabled(false);
//////                    tfFormaPagamento3.setText("");
//////                    tfCodigoFormaPagamento3.setText("");
//////                    tfVlrPago3.setText("");
//////                }
//////            } else {
//////                System.out.println("Entrou no else 2: " + tfVlrParcelas.getText());
//////                tfFormaPagamento3.setEnabled(true);
//////                tfCodigoFormaPagamento3.setEnabled(true);
//////                tfVlrPago3.setEnabled(true);
//////                lbTroco.setForeground(Color.red);
//////                lbTrocoFalta.setText("Falta");
//////                lbTrocoFalta.setForeground(Color.red);
//////
//////                lbTrocoUnico.setText("Falta");
//////                lbTrocoUnico.setForeground(Color.red);
//////
//////                tfCodigoFormaPagamento3.requestFocus();
//////            }
//////        }
//////        if (tfCodigoFormaPagamento2.getText().equals("3")) {
//////            tfParcelas.setText("1");
//////        }
//////        if (tfCodigoFormaPagamento2.getText().equals("2")) {
//////            tfDataVencimento.setEnabled(true);
//////            tfDataVencimento.setFocusable(true);
//////            if (vlrPago >= vlrTotal) {
//////                tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrMaximo / 100));
//////                System.out.println("caiu no if: " + tfVlrParcelas.getText());
//////            }
//////        }
//////
//////        if (!tfVlrPago3.getText().equals("")) {
//////            System.out.println("caiu no if 2: " + tfVlrParcelas.getText());
//////            vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
//////                    + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""))
//////                    + Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", ""));
//////        }
    }//GEN-LAST:event_tfVlrPago2FocusLost

    private void tfVlrPago3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfVlrPago3FocusLost
//        if (tfCodigoFormaPagamento.getText().contains("1")) {
//            Double vlrTotalNormal = Double.parseDouble(tfVlrPago3.getText().replace(",", "."));
//            tfVlrPago3.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
//            double vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
//                    + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""))
//                    + Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", ""));
//
//            double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
//            double troco = vlrPago - vlrTotal;
//            tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//            lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//
//            Double vlrMaximo = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")
//                    .replace(".", "")) - (Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")) + Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", "")));
//
//            Double vlrCamp1 = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//            Double vlrCamp2 = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""));
//
//            if (vlrTotal < vlrPago || vlrTotal == vlrPago) {
//                if (vlrTotal < vlrPago) {
//                    //    tfVlrParcelas.setText(tfVlrTotal.getText());
//                    Double vlr = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//
//                    tfVlrPago3.setText(new DecimalFormat("0.00").format(vlrMaximo / 100).replace(",", "."));
//
//                    troco = vlrTotal - (vlrMaximo + vlrCamp1 + vlrCamp2);
//                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
//                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//                    if (tfFormaPagamento3.equals("PARCELADO")) {
//                        tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlr / 100));
//                    }
//                    lbTroco.setForeground(Color.BLUE);
//                    lbTrocoFalta.setText("Troco");
//                    lbTrocoFalta.setForeground(Color.BLUE);
//
//                    lbTrocoUnico.setText("Troco");
//                    lbTrocoUnico.setForeground(Color.BLUE);
//                } else {
//                    lbTroco.setForeground(Color.BLUE);
//                    lbTrocoFalta.setText("Troco");
//                    lbTrocoFalta.setForeground(Color.BLUE);
//
//                    lbTrocoUnico.setText("Troco");
//                    lbTrocoUnico.setForeground(Color.BLUE);
//                }
//            } else {
//                lbTroco.setForeground(Color.red);
//                lbTrocoFalta.setText("Falta");
//                lbTrocoFalta.setForeground(Color.red);
//
//                lbTrocoUnico.setText("Falta");
//                lbTrocoUnico.setForeground(Color.red);
//            }
//            if (tfCodigoFormaPagamento3.getText().equals("2")) {
//                tfParcelas.setText("1");
//                tfVlrParcelas.setText(tfVlrPago3.getText());
//            }
//
//        }
    }//GEN-LAST:event_tfVlrPago3FocusLost

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfFormaPagamento3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFormaPagamento3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFormaPagamento3KeyPressed

    private void btEfetivarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btEfetivarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfCodigoFormaPagamento.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Double.parseDouble(tfTroco.getText().replace(",", ".")) > 0.00) {
                new Alertas().mensagemAviso("Valor pago é menor que o valor a ser pago");
            } else {
                finalizarVendaOp();
            }
        }
        atalhos(evt);
    }//GEN-LAST:event_btEfetivarKeyPressed

    private void tfVlrPagoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfVlrPagoMousePressed
        if (!tfCodigoFormaPagamento.getText().equals("")) {
            valorPag1();
            tfVlrPago.selectAll();
        } else {
            tfCodigoFormaPagamento.requestFocus();
            tfCodigoFormaPagamento.selectAll();
        }
    }//GEN-LAST:event_tfVlrPagoMousePressed

    private void tfParcelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfParcelasKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfParcelasKeyTyped

    private void tfIntervaloDiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIntervaloDiasKeyTyped
//       if(){
//           
//       }

    }//GEN-LAST:event_tfIntervaloDiasKeyTyped

    private void tfIntervaloDiasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIntervaloDiasKeyPressed
        System.out.println("valor da treta é" + tfIntervaloDias.getValue().toString());
    }//GEN-LAST:event_tfIntervaloDiasKeyPressed

    private void tfIntervaloDiasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIntervaloDiasKeyReleased
        System.out.println(tfIntervaloDias.getValue().toString());
    }//GEN-LAST:event_tfIntervaloDiasKeyReleased

    private void tfVlrPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfVlrPagoKeyTyped
        String caracteres = "0987654321.,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfVlrPagoKeyTyped

    private void tfCodigoFormaPagamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamentoKeyTyped
        String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCodigoFormaPagamentoKeyTyped

    private void tfCodigoFormaPagamento2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamento2KeyTyped
        String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCodigoFormaPagamento2KeyTyped

    private void tfCodigoFormaPagamento3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoFormaPagamento3KeyTyped
        String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCodigoFormaPagamento3KeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        atalhos(evt);
    }//GEN-LAST:event_formKeyPressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinalizaFinanceiroEntrada.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalizaFinanceiroEntrada.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalizaFinanceiroEntrada.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalizaFinanceiroEntrada.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalizaFinanceiroEntrada(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEfetivar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDataAtual;
    private javax.swing.JLabel lbTOP;
    private javax.swing.JLabel lbTroco;
    private javax.swing.JLabel lbTrocoFalta;
    private javax.swing.JLabel lbTrocoUnico;
    private javax.swing.JTextField tfCodigoFormaPagamento;
    private javax.swing.JTextField tfCodigoFormaPagamento2;
    private javax.swing.JTextField tfCodigoFormaPagamento3;
    private javax.swing.JFormattedTextField tfDataVencimento;
    private javax.swing.JTextField tfFocu;
    private javax.swing.JTextField tfFormaPagamento;
    private javax.swing.JTextField tfFormaPagamento2;
    private javax.swing.JTextField tfFormaPagamento3;
    private javax.swing.JSpinner tfIntervaloDias;
    private javax.swing.JTextField tfParcelas;
    private javax.swing.JTextField tfTroco;
    private javax.swing.JTextField tfVlrPago;
    private javax.swing.JTextField tfVlrPago2;
    private javax.swing.JTextField tfVlrPago3;
    private javax.swing.JTextField tfVlrParcelas;
    private javax.swing.JTextField tfVlrTotal;
    // End of variables declaration//GEN-END:variables

    private void setValorTotal() {
        tfVlrTotal.setText(new DecimalFormat("0.00").format(venda.getVlrTotal() / 100));
    }

    private void setStatusCampos() {
        int cod = Integer.parseInt(tfCodigoFormaPagamento.getText());
        switch (cod) {
            case 1:
                tfVlrPago.requestFocus();
//                tfParcelas.setEditable(false);
//                tfVlrParcelas.setEditable(false);
//                tfDataVencimento.setEditable(false);
                tfVlrParcelas.setText("");
                tfParcelas.setText("");
                break;
        }
    }

    private void setStatusCampos2() {
        int cod = Integer.parseInt(tfCodigoFormaPagamento2.getText());
        switch (cod) {
            case 1:
                tfVlrPago2.requestFocus();
                tfParcelas.setEditable(false);
                tfVlrParcelas.setEditable(false);
                tfDataVencimento.setEditable(false);
                // tfVlrPago2.setText("");
                break;
            case 2:
                // tfParcelas.requestFocus();
                tfParcelas.setFocusable(false);
                tfParcelas.setEnabled(true);
                tfParcelas.setEditable(true);
                tfVlrParcelas.setFocusable(false);
                tfVlrParcelas.setEditable(true);
                tfDataVencimento.setEditable(true);
                // tfVlrPago2.setText("0,00");
                break;
        }
    }

    private void setStatusCampos3() {
        int cod = Integer.parseInt(tfCodigoFormaPagamento2.getText());
        switch (cod) {
            case 1:
                tfVlrPago3.requestFocus();
                tfParcelas.setEditable(false);
                tfVlrParcelas.setEditable(false);
                tfDataVencimento.setEditable(false);
                // tfVlrPago3.setText("");
                break;
            case 2:
                // tfParcelas.requestFocus();
                tfParcelas.setEditable(true);
                tfVlrParcelas.setEditable(true);
                tfDataVencimento.setEditable(true);
                //tfVlrPago3.setText("0,00");
                break;
        }
    }

    private void finalizaVenda() {
        try {
            VendaEntity v = new VendaEntity();
            v.setCaixa(venda.getCaixa());
            v.setVendedor(venda.getVendedor());
            if (tfFormaPagamento.getText().equals("CARTÃO CREDITO")) {
                v.setFormaPagamento(tfFormaPagamento.getText().replace("CARTÃO", "CARTAO") + " x" + tfParcelas.getText());
            } else {
                v.setFormaPagamento(tfFormaPagamento.getText().replace("CARTÃO", "CARTAO"));
            }
            v.setFormaPagamento2(tfFormaPagamento2.getText().replace("CARTÃO", "CARTAO"));
            v.setFormaPagamento3(tfFormaPagamento3.getText().replace("CARTÃO", "CARTAO"));
            v.setOperacao(venda.getOperacao());
            v.setVlrTotal(Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")));
            v.setStatus("F");
            v.setClienteID(clienteID);
            v.setDataVenda(lbDataAtual.getText());

            if (tfVlrPago2.getText().equals("")) {
                v.setVlrForma2(0.00);
            } else {
                v.setVlrForma2(Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", "")));
            }

            if (tfVlrPago3.getText().equals("")) {
                v.setVlrForma3(0.00);
            } else {
                v.setVlrForma3(Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", "")));
            }

            v.setVlrForma1(Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")));

            if (tfParcelas.getText().equals("")) {
                v.setParcelas(1);
            } else {
                v.setParcelas(Integer.parseInt(tfParcelas.getText()));
            }

            String hora = String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
            v.setHora(hora);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalizaVendaParcelado() {
        try {
            VendaEntity v = new VendaEntity();
            v.setCaixa(venda.getCaixa());
            v.setVendedor(venda.getVendedor());

            if (tfFormaPagamento.getText().equals("CARTÃO CREDITO")) {
                v.setFormaPagamento(tfFormaPagamento.getText() + " x" + tfParcelas.getText());
                v.setStatus("F");
            } else {
                v.setStatus("A");
                v.setFormaPagamento(tfFormaPagamento.getText());
            }

            v.setFormaPagamento2(tfFormaPagamento2.getText().replace("CARTÃO", "CARTAO"));
            v.setFormaPagamento3(tfFormaPagamento3.getText().replace("CARTÃO", "CARTAO"));
            v.setOperacao(venda.getOperacao());
            Double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
//            Double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
            v.setVlrTotal(vlrTotal);
            v.setClienteID(clienteID);
            v.setDataVenda(lbDataAtual.getText());

            if (Double.parseDouble(tfVlrPago.getText()) > 0 && (Integer.parseInt(tfCodigoFormaPagamento.getText()) == 2)) {
                v.setVlrForma2(venda.getVlrForma2());
                v.setFormaPagamento2("DINHEIRO");
                v.setVlrForma2(Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")));
            } else if (tfVlrPago2.getText().equals("")) {
                v.setVlrForma2(0.00);
            } else {
                v.setVlrForma2(Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", "")));
            }
            if (tfVlrPago3.getText().equals("")) {
                v.setVlrForma3(0.00);
            } else {
                v.setVlrForma3(Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", "")));
            }
            v.setVlrForma1(venda.getVlrForma1());
            if (tfParcelas.getText().equals("")) {
                v.setParcelas(1);
            } else {
                v.setParcelas(Integer.parseInt(tfParcelas.getText()));
            }

            String hora = String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
            v.setHora(hora);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalizaVendaAVista() {
        double troco = Double.parseDouble(lbTroco.getText().replace(",", "."));
        if (troco >= 0) {
            finalizaVenda();
            //   System.out.println("entrou na finalizar");
            //new ImpressoraCupom().imprimirRecibo(lista, tipoOp);
        } else if (troco < 0) {
            new Alertas().mensagemAviso("Troco não pode ser negativo!");
        }

    }

    private double getValorParcela() {
        int parc = Integer.parseInt(tfParcelas.getText());
        double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
        double valorParc = vlrTotal / parc;
        return valorParc;
    }

    public void formaPagamentoTf(JTextField codtf, JTextField tf) {
        if (codtf.getName().equals("tfCodigoFormaPagamento")) {
            if (codtf.getText().replace(" ", "").equals("1")) {
                tf.setText("DINHEIRO");
            }
            if (codtf.getText().replace(" ", "").equals("2")) {
                tf.setText("PARCELADO");
            }
            if (codtf.getText().replace(" ", "").equals("3")) {
                tf.setText("CARTAO CREDITO");
            }
            if (codtf.getText().replace(" ", "").equals("4")) {
                tf.setText("CARTAO DEBITO");
            }
            if (codtf.getText().replace(" ", "").equals("5")) {
                tf.setText("CHEQUE");
            }
        } else if (codtf.getName().equals("tfCodigoFormaPagamento2")) {
            if (codtf.getText().replace(" ", "").equals("1")) {
                tf.setText("DINHEIRO");
            }
            if (codtf.getText().replace(" ", "").equals("2")) {
                tf.setText("PARCELADO");
            }
            if (codtf.getText().replace(" ", "").equals("3")) {
                tf.setText("CARTAO CREDITO");
            }
            if (codtf.getText().replace(" ", "").equals("4")) {
                tf.setText("CARTAO DEBITO");
            }
            if (codtf.getText().replace(" ", "").equals("5")) {
                tf.setText("CHEQUE");
            }
        } else if (codtf.getName().equals("tfCodigoFormaPagamento3")) {
            if (codtf.getText().replace(" ", "").equals("1")) {
                tf.setText("DINHEIRO");
            }
            if (codtf.getText().replace(" ", "").equals("2")) {
                tf.setText("PARCELADO");
            }
            if (codtf.getText().replace(" ", "").equals("3")) {
                tf.setText("CARTAO CREDITO");
            }
            if (codtf.getText().replace(" ", "").equals("4")) {
                tf.setText("CARTAO DEBITO");
            }
            if (codtf.getText().replace(" ", "").equals("5")) {
                tf.setText("CHEQUE");
            }
        }
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            if (Double.parseDouble(tfTroco.getText().replace(",", ".")) > 0.00) {
                new Alertas().mensagemAviso("Valor pago é menor que o valor a ser pago");
            } else {
                finalizarVendaOp();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            this.dispose();
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
            mov.setDescricao("VENDA FINALIZADA");
            mov.setTipoMovimento("ENTRADA");
            Double vlrRecebido = 0.0;
            Double troco = Double.parseDouble(lbTroco.getText().replace(",", ".").replace(".", ""));

            if (tfFormaPagamento.equals("DINHEIRO") && troco >= 0) {
                mov.setValor(Double.valueOf(tfVlrTotal.getText().replace(",", ".").replace(".", "")));
            } else {
                mov.setValor(Double.valueOf(tfVlrPago.getText().replace(",", ".").replace(".", "")));
            }
            if ((tfCodigoFormaPagamento2.isEnabled()) && tfFormaPagamento2.getText().equals("CARTAO CREDITO") || tfFormaPagamento2.getText().equals("CARTAO DEBITO")) {
                vlrRecebido = Double.valueOf(tfVlrPago.getText().replace(",", ".").replace(".", "")) + Double.valueOf(tfVlrPago2.getText().replace(",", ".").replace(".", ""));
                mov.setValor(vlrRecebido);
            }
            if ((tfCodigoFormaPagamento3.isEnabled()) && tfFormaPagamento3.getText().equals("CARTAO CREDITO") || tfFormaPagamento3.getText().equals("CARTAO DEBITO")) {
                vlrRecebido = mov.getValor() + Double.valueOf(tfVlrPago3.getText().replace(",", ".").replace(".", ""));
                mov.setValor(vlrRecebido);
            }
            mov.setDataMovimento(lbDataAtual.getText());
            MovimentacaoDAO dao = new MovimentacaoDAO();
            dao.inserirValorMovimentacao(mov);
        } catch (Exception e) {
            new Alertas().mensagemErro("" + e);
            e.printStackTrace();
        }
    }

    private void imprimirCupomBematech(int i) {
        String tipoDeVenda = "";
        String auxCodigo = "";
        String auxQuant = "";
        String auxPrecoUn = "";
        String esp1 = "            ";//12

        ProdutosVendaEntity auxP = new ProdutosVendaEntity();

        auxP = lista.get(i);
        auxCodigo = auxP.getCodigoProduto().toString();
        auxQuant = auxP.getQuantidade().toString();
        auxPrecoUn = auxP.getPrecoUnitario().toString();
        dll.BematechTX(auxP.getProdutoServico() + "\n" + auxCodigo + " " + esp1 + "   " + auxQuant + "     R$" + new DecimalFormat("0.00").format(Double.parseDouble(auxPrecoUn) / 100) + "   R$" + new DecimalFormat("0.00").format(auxP.getPrecoTotal() / 100) + "\n");
        valorTotal += auxP.getPrecoTotal() / 100;
    }

    public void finalizarVendaOp() {
        try {

            EntradaFinanceiroEntity efe = new EntradaFinanceiroEntity();
            efe.setCaixa(inicializaEntradaEntity.getCaixa());
            efe.setFornecedor(inicializaEntradaEntity.getFornecedor());
            efe.setOperacao(inicializaEntradaEntity.getOperacao());
            efe.setCodigoEntrada(inicializaEntradaEntity.getSequencia());

            if (tfFormaPagamento.getText().equals("DINHEIRO") && tfFormaPagamento2.getText().equals("")) {
//                String dataVenc = data.adicionaDias(data.dataAtual(), Integer.parseInt(tfIntervaloDias.getValue().toString()));
                efe.setDataVencimento(data.dataAtual());
            } else {
                if (tfDataVencimento.getText().contains("")) {
                    tfDataVencimento.setText(data.dataAtual());
                }
                String dataVenc = data.adicionaDias(tfDataVencimento.getText(), Integer.parseInt(tfIntervaloDias.getValue().toString()));
                efe.setDataVencimento(dataVenc);
            }

//            if (tfDataVencimento.getText().startsWith(" ")) {
//                efe.setDataVencimento(data.adiciona1Mes(data.dataAtual()));
//                tfDataVencimento.setText(efe.getDataVencimento());
//            } else if(tfFormaPagamento.getText().equals("DINHEIRO")){
//                String dataVenc = data.adicionaDias(tfDataVencimento.getText(), Integer.parseInt(tfIntervaloDias.getValue().toString()));
//                efe.setDataVencimento(dataVenc);
//            }
            efe.setDataEmissao(data.dataAtual());

            efe.setIntervaloDias(Integer.parseInt(tfIntervaloDias.getValue().toString()));
            efe.setUsuario("USUARIO");
            efe.setDescricao("ENTRADA");
            efe.setStatus("ABERTO");

            efe.setFormaPagamento(tfFormaPagamento.getText());
            efe.setFormaPagamento2(tfFormaPagamento2.getText());
            efe.setFormaPagamento3(tfFormaPagamento3.getText());
            efe.setParcelas(Integer.parseInt(tfParcelas.getText()));

            efe.setHora("10:10");

            efe.setVlrForma1(Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")));
            if (!tfVlrPago2.getText().isEmpty()) {
                efe.setVlrForma2(Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", "")));
            } else {
                efe.setVlrForma2(0.0);
            }

            if (!tfVlrPago3.getText().isEmpty()) {
                efe.setVlrForma3(Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", "")));
            } else {
                efe.setVlrForma3(0.0);
            }
            efe.setVlrTotal(Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")));

            EntradaDAO eDAO = new EntradaDAO();
            eDAO.finalizaFinaceiroEntrada(efe);
            eDAO.atualizaStatusFinanceiro(inicializaEntradaEntity.getSequencia(), "FINALIZADO");

            new Alertas().mensagemConfirmacao("Financeiro efetivado com sucesso!");
            btEfetivar.setEnabled(false);
            tfCodigoFormaPagamento.setEnabled(false);
            tfCodigoFormaPagamento2.setEnabled(false);
            tfCodigoFormaPagamento3.setEnabled(false);

            tfCodigoFormaPagamento.setText("");
            tfCodigoFormaPagamento2.setText("");
            tfCodigoFormaPagamento3.setText("");
            statusFinalizacao = true;

            lbTOP.setText("Finaliza Entrada Financeiro (Efetivado)");

            //contas a pagar
            ContasPagarEntity cpe = new ContasPagarEntity();
            cpe.setDataEmissao(data.dataAtual());
            cpe.setStatus("ON");

            if (u == null) {
                cpe.setUsuario("UNKNOW");
            } else {
                cpe.setUsuario(u.getId() + "-" + u.getNome_usuario());
            }

            cpe.setEntradaId(inicializaEntradaEntity.getSequencia());
            cpe.setFornecedor(inicializaEntradaEntity.getFornecedor());
            cpe.setObs("REFERENTE A ENTRADA DE MERCADORIA COM A SEQUENCIA: Nº: " + cpe.getEntradaId().toString());

            ContasPagasEntity cpee = new ContasPagasEntity();
            cpee.setDataPagamento(data.dataAtual());
            cpee.setUsuario(cpe.getUsuario());
            cpee.setEntradaId(inicializaEntradaEntity.getSequencia());
            cpee.setFornecedor(inicializaEntradaEntity.getFornecedor());
            cpee.setCaixa(inicializaEntradaEntity.getCaixa());
            cpee.setObs("REFERENTE AO PAGAMENTO DA ENTRADA DE MERCADORIA COM A SEQUENCIA: Nº: " + cpe.getEntradaId().toString());

            ContaPagarDAO cpDAO = new ContaPagarDAO();
            ContasPagasDAO cpeeDAO = new ContasPagasDAO();

            Integer intervalo = Integer.parseInt(tfParcelas.getText());
            if (tfFormaPagamento.getText().equals("DINHEIRO")) {
                cpee.setTipoCobranca("DINHEIRO");
                cpee.setDataVencimento(cpee.getDataPagamento());
                Double valorD = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
                cpee.setVlrPago(valorD);
                cpee.setDescricao("PAGAMENTO DE MERCADORIAS");
                cpeeDAO.save(cpee);
                efetivaMovimentacaoDeEntrada(valorD, "DINHEIRO");

                if (tfFormaPagamento2.getText().equals("PARCELADO") || tfFormaPagamento3.getText().equals("PARCELADO")) {
                    String novoVenc = tfDataVencimento.getText();
                    for (int i = 0; i < intervalo; i++) {
                        cpe.setDataVencimento(novoVenc);
                        cpe.setTipoCobranca("PRAZO");
                        Double valor2 = Double.parseDouble(tfVlrParcelas.getText().replace(",", ".").replace(".", ""));
                        cpe.setVlrPagar(valor2);
                        cpe.setDescricao("PAGAMENTO DE MERCADORIAS PARCELA x" + (i + 1));
                        cpDAO.save(cpe);
                        novoVenc = data.adicionaDias(novoVenc,
                                Integer.parseInt(tfIntervaloDias.getValue().toString()));
                    }
                }
                if (tfFormaPagamento2.getText().equals("CARTAO CREDITO") || tfFormaPagamento3.getText().equals("CARTAO CREDITO")) {
                    cpee.setTipoCobranca("CARTAO CREDITO");
                    cpee.setDataVencimento(cpee.getDataPagamento());
                    if (tfFormaPagamento2.getText().equals("CARTAO CREDITO")) {
                        Double valor = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""));
                        cpee.setVlrPago(valor);
                        efetivaMovimentacaoDeEntrada(valor, "CARTAO CREDITO");
                        cpee.setDescricao("PAGAMENTO DE MERCADORIAS 1x de " + new DecimalFormat().format(valor / 100));
                    } else {
                        Double valor = Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", ""));
                        cpee.setVlrPago(valor);
                        efetivaMovimentacaoDeEntrada(valor, "CARTAO CREDITO");
                        cpee.setDescricao("PAGAMENTO DE MERCADORIAS 1x de " + new DecimalFormat().format(valor / 100));
                    }
                    cpeeDAO.save(cpee);
                }
                if (tfFormaPagamento2.getText().equals("CARTAO DEBITO") || tfFormaPagamento3.getText().equals("CARTAO DEBITO")) {
                    cpee.setTipoCobranca("CARTAO DEBITO");
                    cpee.setDescricao("PAGAMENTO DE MERCADORIAS EM CARTÃO DEBITO");
                    if (tfFormaPagamento2.getText().equals("CARTAO DEBITO")) {
                        Double valorCD = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""));
                        cpee.setVlrPago(valorCD);
                        efetivaMovimentacaoDeEntrada(valorCD, "CARTAO DEBITO");
                    }
                    if (tfFormaPagamento3.getText().equals("CARTAO DEBITO")) {
                        Double valorCD = Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", ""));
                        cpee.setVlrPago(valorCD);
                        efetivaMovimentacaoDeEntrada(valorCD, "CARTAO DEBITO");
                    }
                    cpeeDAO.save(cpee);
                }
            } else if (tfFormaPagamento.getText().equals("PARCELADO")) {
                String novoVenc = tfDataVencimento.getText();
                if (!tfVlrPago.getText().equals("0.00")) {
                    cpee.setTipoCobranca("DINHEIRO");
                    cpee.setDataVencimento(cpee.getDataPagamento());
                    Double valorD = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
                    cpee.setVlrPago(valorD);
                    cpee.setDescricao("PAGAMENTO DE MERCADORIAS");
                    efetivaMovimentacaoDeEntrada(valorD, "DINHEIRO");
                    cpeeDAO.save(cpee);
                }
                for (int i = 0; i < intervalo; i++) {

                    cpe.setDataVencimento(novoVenc);
                    cpe.setTipoCobranca("PRAZO");
                    Double valor = Double.parseDouble(tfVlrParcelas.getText().replace(",", ".").replace(".", ""));
                    cpe.setVlrPagar(valor);
                    cpe.setDescricao("PAGAMENTO DE MERCADORIAS PARCELA x" + (i + 1));
                    cpDAO.save(cpe);
                    novoVenc = data.adicionaDias(novoVenc,
                            Integer.parseInt(tfIntervaloDias.getValue().toString()));
                }
            } else if (tfFormaPagamento.getText().equals("CARTAO CREDITO")) {
                cpee.setTipoCobranca("CARTAO CREDITO");
                cpee.setDataVencimento(cpee.getDataPagamento());
                Double valor = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
                cpee.setVlrPago(valor);
                cpee.setDescricao("PAGAMENTO DE MERCADORIAS" + tfParcelas.getText() + "x de " + tfVlrParcelas.getText().replace(",", "."));
                cpeeDAO.save(cpee);
                efetivaMovimentacaoDeEntrada(valor, "CARTAO CREDITO");
            } else if (tfFormaPagamento.getText().equals("CARTAO DEBITO")) {
                cpee.setTipoCobranca("CARTAO DEBITO");
                cpee.setDescricao("PAGAMENTO DE MERCADORIAS EM CARTÃO DEBITO");
                Double valorCD = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
                cpee.setVlrPago(valorCD);
                efetivaMovimentacaoDeEntrada(valorCD, "CARTAO DEBITO");
                cpee.setDataVencimento(cpee.getDataPagamento());
                cpeeDAO.save(cpee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//public void finalizarVendaOp() {
//        String hora = String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
//        venda.setHora(hora);
//        venda.setDataVenda(data.dataAtual());
//        venda.setFormaPagamento(tfFormaPagamento.getText());
//        venda.setFormaPagamento2(tfFormaPagamento2.getText());
//        venda.setFormaPagamento3(tfFormaPagamento3.getText());
//
//        if (tfParcelas.getText().equals("") || tfParcelas.getText().equals(" ")) {
//            venda.setParcelas(1);
//            tfParcelas.setText("1");
//        } else {
//            venda.setParcelas(Integer.parseInt(tfParcelas.getText()));
//        }
//
//        venda.setVlrTotal(Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")));
//        venda.setVlrForma1(Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")));
//
//        if (tfFormaPagamento.getText().equals("PARCELADO")) {
//            venda.setVlrForma1(venda.getVlrTotal() - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")));
//            if (Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")) > 0) {
//                venda.setFormaPagamento2("DINHEIRO");
//                venda.setVlrForma2(Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")));
//            }
//        }
//
//        if (!tfVlrPago2.getText().isEmpty()) {
//            venda.setVlrForma2(Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", "")));
//        }
//
//        if (!tfVlrPago3.getText().isEmpty()) {
//            venda.setVlrForma3(Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", "")));
//        }
//
//        if (tfCodigoFormaPagamento.getText().equals("1")) {
//            if (Double.parseDouble(tfTroco.getText().replace(",", ".")) < 0.00) {
//                alerta.mensagemAviso("Valor pago é menor do que o valor total a ser pago!!!");
//            } else {
//                if (tfFormaPagamento.getText().equals("PARCELADO")
//                        || tfFormaPagamento2.getText().equals("PARCELADO")
//                        || tfFormaPagamento3.getText().equals("PARCELADO")) {
//                    if (!tfVlrParcelas.getText().isEmpty() && Integer.parseInt(tfParcelas.getText()) > 0) {//fix
//                        if (clienteID == 1 && clienteID > 0) {
////                            double valorCertoDaParcela = Double.valueOf(tfVlrParcelas.getText().replace(",", "."));
////                            SelecionaClienteVendaView selCliente = new SelecionaClienteVendaView(this, true, lista, tfParcelas.getText(), this, venda, valorCertoDaParcela);
////                            selCliente.setVisible(true);
////                            clienteID = selCliente.getCodigoCliente();
//                            System.out.println("ID " + clienteID);
//                            if (clienteID > 1) {
//                                ce.setId(clienteID);
//                                this.dispose();
//                                vendasView.apagarLista();
//                            }
//                        } else {
//                            finalizaVendaParcelado();
//                            fluxoNovinhaNoGrau();
//                            vendasView.apagarLista();
//                            new Alertas().mensagemConfirmacao("Venda finalizada com sucesso!");
//                            this.dispose();
//                        }
//                    } else {
//                        alerta.mensagemAviso("O campo de Data ou Numero de Parcelas esta vázio, preencha os campos!!!");
//                    }
//                } else {
//                    finalizaVendaAVista();
//                    fluxoNovinhaNoGrau();
//                 
//                    vendasView.apagarLista();
//                    new Alertas().mensagemConfirmacao("Venda finalizada com sucesso!");
//                    this.dispose();
//                }
//            }
//        } else if (tfCodigoFormaPagamento.getText().equals("2")) {
//            if (!tfVlrParcelas.getText().isEmpty() && Integer.parseInt(tfParcelas.getText()) > 0) {//fix
//                if (Double.parseDouble(tfTroco.getText().replace(",", ".")) <= 0.00) {
//                    if (clienteID == 1 && clienteID > 0) {
//                        double valorCertoDaParcela = Double.valueOf(tfVlrParcelas.getText().replace(",", "."));
////                        SelecionaClienteVendaView selCliente = new SelecionaClienteVendaView(this, true, lista, tfParcelas.getText(), this, venda, valorCertoDaParcela);
////                        selCliente.setVisible(true);
////                        clienteID = selCliente.getCodigoCliente();
//                        System.out.println("ID " + clienteID);
//                        if (clienteID > 1) {
//                            ce.setId(clienteID);
//                            vendasView.apagarLista();
//                            this.dispose();
//                        }
//                    } else {
//                        finalizaVendaParcelado();
//                        fluxoNovinhaNoGrau();
//                        vendasView.apagarLista();
//                        new Alertas().mensagemConfirmacao("Venda finalizada com sucesso!");
//                        this.dispose();
//                    }
//                } else {
//                    alerta.mensagemAviso("O Valor pago é maior que Valor Total");
//                }
//            } else {
//                alerta.mensagemAviso("O campo de Data ou Numero de Parcelas esta vázio, preencha os campos!!!");
//            }
//        } else if (tfCodigoFormaPagamento.getText().equals("3")) {
//            if (Double.parseDouble(tfTroco.getText().replace(",", ".")) < 0.00) {
//                alerta.mensagemAviso("Valor pago é menor do que o valor total a ser pago!!!");
//            } else {
//                finalizaVenda();
//                fluxoNovinhaNoGrau();
//                               vendasView.apagarLista();
//                new Alertas().mensagemConfirmacao("Venda finalizada com sucesso!");
//                this.dispose();
//            }
//        } else if (tfCodigoFormaPagamento.getText().equals("4")) {
//            if (Double.parseDouble(tfTroco.getText().replace(",", ".")) < 0.00) {
//                alerta.mensagemAviso("Valor pago é menor do que o valor total a ser pago!!!");
//            } else {
//                finalizaVenda();
//                fluxoNovinhaNoGrau();
//                vendasView.apagarLista();
//                new Alertas().mensagemConfirmacao("Venda finalizada com sucesso!");
//                this.dispose();
//            }
//        }
//
////        try {
////            FileOutputStream os;
////            os = new FileOutputStream("COM4");
////            PrintStream ps = new PrintStream(os);
////            System.out.println("entrou aqui seu bosta");
////            ps.print((char) 27);
////            ps.print((char) 118);
////            ps.print((char) 140);
////            ps.close();
////        } catch (FileNotFoundException ex) {
////            Logger.getLogger(CupomBematch.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }
    public void preencheDadosCliente(String cpf, String end, String nome, int cliId
    ) {
        this.cpfCli = cpf;
        this.endCli = end;
        this.nomeCli = nome;
        this.clienteID = cliId;
    }

    public String retornaPag1() {
        if (!tfFormaPagamento.getText().isEmpty()) {
            return tfFormaPagamento.getText();
        } else {
            return "";
        }
    }

    public String retornaPag2() {
        if (!tfFormaPagamento2.getText().isEmpty()) {
            return tfFormaPagamento2.getText();
        } else {
            return "";
        }
    }

    public String retornaPag3() {
        if (!tfFormaPagamento3.getText().isEmpty()) {
            return tfFormaPagamento3.getText();
        } else {
            return "";
        }
    }

    public Double retornaVal1() {
        Double var1 = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
        Double var2 = Double.parseDouble(tfVlrPago.getText().replace(",", "."));
        //  var3 = Double.parseDouble(tfVlrPago.getText().replace(",", "."));
        double vlr = (var1) - var2;
        if (vlr > 0.0) {
            return vlr;
        } else {
            return 0.0;
        }
    }

    public Double retornaVal2() {
        if (!tfVlrPago2.getText().isEmpty()) {
            return Double.parseDouble(tfVlrPago2.getText().replace(",", "."));
        } else {
            return 0.0;
        }
    }

    public Double retornaVal3() {
        if (!tfVlrPago3.getText().isEmpty()) {
            return Double.parseDouble(tfVlrPago3.getText().replace(",", "."));
        } else {
            return 0.0;
        }
    }

    public String retornaDataVenc() {
        return tfDataVencimento.getText();
    }

    public Double vlrParcela() {
        return Double.parseDouble(tfVlrParcelas.getText().replace(",", "."));
    }

    private void setarValores() {
//        nomeCli = this.ce.getNome();
//        cpfCli = this.ce.getCnpjOuCpf();
//        endCli = this.ce.getEndereco();

        data.dataAtual(lbDataAtual);
        tfVlrTotal.setFocusable(false);

        tfCodigoFormaPagamento2.setEnabled(false);
        tfFormaPagamento2.setEnabled(false);
        tfVlrPago2.setEnabled(false);

        tfCodigoFormaPagamento3.setEnabled(false);
        tfFormaPagamento3.setEnabled(false);
        tfVlrPago3.setEnabled(false);

        lbTroco.setFocusable(false);
        tfTroco.setEnabled(true);
        tfTroco.setFocusable(false);
    }

    private void codigoFormaPagamento() {
        tfVlrParcelas.setText("0,00");
        if (tfCodigoFormaPagamento.getText().isEmpty()) {
            alerta.mensagemAviso("Digite um codigo de pagamento!");
            tfCodigoFormaPagamento.requestFocus();
        } else {
            if (((tfCodigoFormaPagamento.getText().equals(tfCodigoFormaPagamento2.getText()) && !tfCodigoFormaPagamento2.getText().isEmpty())
                    || (tfCodigoFormaPagamento.getText().equals(tfCodigoFormaPagamento3.getText())) && !tfCodigoFormaPagamento3.getText().isEmpty()) && (!tfCodigoFormaPagamento2.getText().equals(""))) {
                alerta.mensagemAviso("Esta Forma de Pagamento já esta sendo utilizada, escolha outra!!!");
                tfCodigoFormaPagamento.selectAll();
            } else {
                tfCodigoFormaPagamento.setName("tfCodigoFormaPagamento");
                formaPagamentoTf(tfCodigoFormaPagamento, tfFormaPagamento);
                if (tfCodigoFormaPagamento.getText().replace(" ", "").equals("1") || tfCodigoFormaPagamento.getText().replace(" ", "").equals("4")) {
                    tfDataVencimento.setText(data.dataAtual());
                    tfParcelas.setText("1");
                    tfDataVencimento.setText("");
                    tfParcelas.setEnabled(false);
                    tfDataVencimento.setEnabled(false);
                } else {
                    if (tfCodigoFormaPagamento2.isEnabled()) {
                        tfCodigoFormaPagamento2.setText("");
                        tfFormaPagamento2.setText("");
                        tfFormaPagamento2.setEnabled(false);
                        tfCodigoFormaPagamento2.setEnabled(false);
                        tfVlrPago2.setText("");
                        tfVlrPago2.setEnabled(false);

                        tfFormaPagamento3.setText("");
                        tfFormaPagamento3.setEnabled(false);
                        tfCodigoFormaPagamento3.setText("");
                        tfCodigoFormaPagamento3.setEnabled(false);
                        tfVlrPago3.setText("");
                        tfVlrPago3.setEnabled(false);
                    }
                    if (tfCodigoFormaPagamento.getText().equals("4") || tfCodigoFormaPagamento.getText().equals("5")) {
                        tfParcelas.setFocusable(false);
                        tfDataVencimento.setFocusable(false);
                        tfParcelas.setEnabled(false);
                        tfDataVencimento.setEnabled(false);
                    } else {
                        tfParcelas.setFocusable(true);
                    }
                    tfDataVencimento.setFocusable(true);
                    tfParcelas.setEnabled(true);
                    tfDataVencimento.setEnabled(true);
                    NovaData nd = new NovaData();
                    nd.dataAtual(tfDataVencimento);
                    String data = tfDataVencimento.getText();
                    data = nd.adiciona1Mes(data);
                    tfDataVencimento.setText(data);
                    tfParcelas.setText("1");
                    //  tfVlrPago.setText("0,00");

                    if (tfCodigoFormaPagamento.getText().equals("3")) {
                        tfDataVencimento.setEnabled(false);
                        tfDataVencimento.setFocusable(false);
                    }
                }
                tfVlrPago.requestFocus();
                if (tfCodigoFormaPagamento.getText().equals("2")) {
                    tfVlrPago.setText("0.00");
                } else {
                    tfVlrPago.setText(tfVlrTotal.getText().replace(",", "."));
                }
                tfVlrPago.selectAll();
            }
        }
    }

    private void codigoFormaPagamento2() {
        if (tfCodigoFormaPagamento2.getText().isEmpty()) {
            alerta.mensagemAviso("Digite um codigo de pagamento!");
            tfCodigoFormaPagamento2.requestFocus();
        } else {
            if ((tfCodigoFormaPagamento2.getText().equals(tfCodigoFormaPagamento.getText())
                    || tfCodigoFormaPagamento2.getText().equals(tfCodigoFormaPagamento3.getText())) && (!tfCodigoFormaPagamento2.getText().equals(""))) {
                alerta.mensagemAviso("Esta Forma de Pagamento já esta sendo utilizada, escolha outra!!!");
            } else {
                tfCodigoFormaPagamento2.setName("tfCodigoFormaPagamento2");
                formaPagamentoTf(tfCodigoFormaPagamento2, tfFormaPagamento2);

                setStatusCampos2();
                tfVlrPago2.requestFocus();
                Double aux = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")) - Double.parseDouble(tfVlrPago.getText().replace(",", "."));
                tfVlrPago2.setText(new DecimalFormat("0.00").format(aux));
                if (tfCodigoFormaPagamento2.getText().equals("2")) {
                    tfParcelas.setText("1");
                    NovaData nd = new NovaData();
                    nd.dataAtual(tfDataVencimento);
                    String data = tfDataVencimento.getText();
                    data = nd.adiciona1Mes(data);
                    tfDataVencimento.setText(data);
                    tfDataVencimento.setEnabled(true);
                    tfDataVencimento.setFocusable(true);
                    tfParcelas.setEnabled(true);
                    tfParcelas.setFocusable(true);
//                    if (tfCodigoFormaPagamento2.getText().equals("5")
//                            || tfCodigoFormaPagamento2.getText().equals("4")) {
//                        // tfDataVencimento.setFocusable(false);
//                        tfParcelas.setFocusable(false);
//                    }else{
//                         tfParcelas.setFocusable(true);
//                    }
                } else {
                    tfDataVencimento.setFocusable(false);
                    tfDataVencimento.setEnabled(false);
                    tfParcelas.setFocusable(false);
                    tfParcelas.setEnabled(false);
                    tfParcelas.setText("");
                    tfDataVencimento.setText("");
                }
                tfVlrPago2.selectAll();
            }

        }
    }

    private void codigoFormaPagamento3() {
        if (tfCodigoFormaPagamento3.getText().isEmpty()) {
            alerta.mensagemAviso("Digite um codigo de pagamento!");
            tfCodigoFormaPagamento3.requestFocus();
        } else {
            if ((tfCodigoFormaPagamento3.getText().equals(tfCodigoFormaPagamento.getText())
                    || tfCodigoFormaPagamento3.getText().equals(tfCodigoFormaPagamento2.getText())) && (!tfCodigoFormaPagamento3.getText().equals(""))) {
                alerta.mensagemAviso("Esta Forma de Pagamento já esta sendo utilizada, escolha outra!!!");
            } else {
                tfCodigoFormaPagamento3.setName("tfCodigoFormaPagamento3");
                formaPagamentoTf(tfCodigoFormaPagamento3, tfFormaPagamento3);

                if (tfCodigoFormaPagamento3.getText().equals("2")) {
                    tfParcelas.setText("1");
                    NovaData nd = new NovaData();
                    nd.dataAtual(tfDataVencimento);
                    String data = tfDataVencimento.getText();
                    data = nd.adiciona1Mes(data);
                    tfDataVencimento.setText(data);
                    tfDataVencimento.setEnabled(true);
                    tfDataVencimento.setFocusable(true);
                    tfParcelas.setEnabled(true);
                    tfParcelas.setFocusable(true);
                } else {
//                    tfDataVencimento.setFocusable(false);
//                    tfDataVencimento.setEnabled(false);
//                    tfParcelas.setFocusable(false);
//                    tfParcelas.setEnabled(false);
//                    tfParcelas.setText("");
//                    tfDataVencimento.setText("");
                }

                setStatusCampos3();
                tfVlrPago3.requestFocus();
                tfVlrPago3.requestFocus();
                Double aux = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".")) - Double.parseDouble(tfVlrPago2.getText().replace(",", "."));
                tfVlrPago3.setText(new DecimalFormat("0.00").format(aux));
                tfVlrPago3.selectAll();
            }
        }
    }

    private void valorPag1() {
        Double vlrTotalNormal = Double.parseDouble(tfVlrPago.getText().replace(",", "."));
        tfVlrPago.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
        double vlrPago = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
        double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
        double troco = vlrPago - vlrTotal;
        tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
        lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));

        if (tfCodigoFormaPagamento.getText().equals("1")) {
//            if (!tfVlrPago2.getText().isEmpty() && tfFormaPagamento2.isEnabled()) {
//                vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
//                        + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
//            } else if (!tfVlrPago3.getText().isEmpty() && tfFormaPagamento3.isEnabled()) {
//                vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
//                        + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""))
//                        + Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""));
//            }
            if (vlrTotal < vlrPago || vlrTotal == vlrPago) {
                lbTroco.setForeground(Color.BLUE);
                lbTrocoFalta.setForeground(Color.BLUE);

                lbTrocoFalta.setText("Troco");
                lbTrocoUnico.setText("Troco");

                lbTrocoUnico.setText("Troco");
                lbTrocoUnico.setForeground(Color.BLUE);

                tfFormaPagamento2.setEnabled(false);
                tfCodigoFormaPagamento2.setEnabled(false);
                tfVlrPago2.setEnabled(false);
                tfFormaPagamento2.setText("");
                tfCodigoFormaPagamento2.setText("");
                tfVlrPago2.setText("");

                tfFormaPagamento3.setEnabled(false);
                tfCodigoFormaPagamento3.setEnabled(false);
                tfVlrPago3.setEnabled(false);
                tfFormaPagamento3.setText("");
                tfCodigoFormaPagamento3.setText("");
                tfVlrPago3.setText("");

                btEfetivar.requestFocus();
            } else {
                //  lbTrocoUnico.setText("Falta");
                tfFormaPagamento2.setEnabled(true);
                tfCodigoFormaPagamento2.setEnabled(true);
                tfVlrPago2.setEnabled(true);
                lbTroco.setForeground(Color.red);

                lbTrocoFalta.setForeground(Color.red);
                lbTrocoFalta.setText("Falta");

                lbTrocoUnico.setText("Falta");
                lbTrocoUnico.setForeground(Color.red);

                tfCodigoFormaPagamento2.requestFocus();
            }
            tfParcelas.setEnabled(false);
            tfDataVencimento.setEnabled(false);
        } else {
            if (vlrTotal < vlrPago || vlrTotal == vlrPago) {
                Double vlrCertoDaParc = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
//                if (tfFormaPagamento.getText().equals("PARCELADO") && vlrTotal < vlrPago) {
//                    alerta.mensagemAviso("O Valor pago é maior que Valor Total");
                if (vlrTotal < vlrPago) {
                    tfVlrParcelas.setText(tfVlrTotal.getText());
                    tfVlrPago.setText(tfVlrTotal.getText());

                    vlrTotalNormal = Double.parseDouble(tfVlrPago.getText().replace(",", "."));
                    tfVlrPago.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
                    vlrPago = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
                    vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
                    troco = vlrPago - vlrTotal;
                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
//                    tfVlrPago.requestFocus();
//                    tfVlrPago.selectAll();
                } else {
                    vlrCertoDaParc = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
                    tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrCertoDaParc).replace(",", "."));

                    lbTroco.setForeground(Color.BLUE);
                    lbTrocoFalta.setForeground(Color.BLUE);

                    lbTrocoFalta.setText("Troco");
                    lbTrocoUnico.setText("Troco");

                    lbTrocoUnico.setText("Troco");
                    lbTrocoUnico.setForeground(Color.BLUE);
                }
            } else {
                Double vlrCertoDaParc = 0.0;
                if (tfFormaPagamento.getText().equals("PARCELADO")) {
                    vlrCertoDaParc = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")) - Double.parseDouble(tfVlrPago.getText().replace(",", "."));
                } else {
                    vlrCertoDaParc = Double.parseDouble(tfVlrTotal.getText().replace(",", "."));
                }

                tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrCertoDaParc).replace(",", "."));
                lbTroco.setForeground(Color.red);

                lbTrocoFalta.setForeground(Color.red);
                lbTrocoFalta.setText("Falta");

                lbTrocoUnico.setText("Falta");
                lbTrocoUnico.setForeground(Color.red);
            }

        }
    }

    private void valorPag2() {
        Double vlrTotalNormal = Double.parseDouble(tfVlrPago2.getText().replace(",", "."));
        tfVlrPago2.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
        double vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
                + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
        Double vlrMaximo = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")
                .replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
        Double vlrCamp1 = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));

        if (tfCodigoFormaPagamento2.getText().equals("2")) {
            tfParcelas.setText("1");
            tfVlrParcelas.setFocusable(false);
            tfVlrParcelas.setText(tfVlrPago2.getText());
            if (Double.parseDouble(tfTroco.getText()) > 0.0) {

            }
        } else {
            tfParcelas.setText("");
        }

        double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
        double troco = vlrPago - vlrTotal;
        tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
        lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));

        if (tfCodigoFormaPagamento.getText().contains("1")) {
            if (vlrPago >= vlrTotal) {
                if (vlrPago > vlrTotal) {
                    //tfVlrParcelas.setText(tfVlrTotal.getText());
                    Double vlr = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));

                    tfVlrPago2.setText(new DecimalFormat("0.00").format(vlrMaximo / 100).replace(",", "."));

                    troco = vlrTotal - (vlrMaximo + vlrCamp1);
                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
                    System.out.println("Aqui é o maximo: " + vlrMaximo);
                    if (tfCodigoFormaPagamento2.equals("2")) {
                        tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrMaximo / 100));
                        System.out.println("Ali tbm: " + tfVlrParcelas.getText());
                    }

                    lbTroco.setForeground(Color.BLUE);
                    lbTrocoFalta.setText("Troco");
                    lbTrocoFalta.setForeground(Color.BLUE);

                    lbTrocoUnico.setText("Troco");
                    lbTrocoUnico.setForeground(Color.BLUE);

                    if (Integer.parseInt(tfCodigoFormaPagamento2.getText()) == 2) {
                        tfParcelas.requestFocus();
                    } else {
                        btEfetivar.requestFocus();
                    }

                } else {
                    System.out.println("entrou no else: " + tfVlrParcelas.getText());
                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));

                    lbTroco.setForeground(Color.BLUE);
                    lbTrocoFalta.setText("Troco");
                    lbTrocoFalta.setForeground(Color.BLUE);

                    lbTrocoUnico.setText("Troco");
                    lbTrocoUnico.setForeground(Color.BLUE);

                    tfFormaPagamento3.setEnabled(false);
                    tfCodigoFormaPagamento3.setEnabled(false);
                    tfVlrPago3.setEnabled(false);
                    tfFormaPagamento3.setText("");
                    tfCodigoFormaPagamento3.setText("");
                    tfVlrPago3.setText("");

                    if (Integer.parseInt(tfCodigoFormaPagamento2.getText()) == 2) {
                        tfParcelas.requestFocus();
                    } else {
                        btEfetivar.requestFocus();
                    }
                }
            } else {
                System.out.println("Entrou no else 2: " + tfVlrParcelas.getText());
                tfFormaPagamento3.setEnabled(true);
                tfCodigoFormaPagamento3.setEnabled(true);
                tfVlrPago3.setEnabled(true);
                lbTroco.setForeground(Color.red);
                lbTrocoFalta.setText("Falta");
                lbTrocoFalta.setForeground(Color.red);

                lbTrocoUnico.setText("Falta");
                lbTrocoUnico.setForeground(Color.red);

                tfCodigoFormaPagamento3.requestFocus();
            }
        }
        if (tfCodigoFormaPagamento2.getText().equals("3")) {
            tfParcelas.setText("1");
        }
        if (tfCodigoFormaPagamento2.getText().equals("2")) {
            tfDataVencimento.setEnabled(true);
            tfDataVencimento.setFocusable(true);
            if (vlrPago >= vlrTotal) {
                tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlrMaximo / 100));
                System.out.println("caiu no if: " + tfVlrParcelas.getText());
            }
        }

        if (!tfVlrPago3.getText().equals("")) {
            System.out.println("caiu no if 2: " + tfVlrParcelas.getText());
            vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
                    + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""))
                    + Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", ""));
        }

    }

    private void valorPag3() {
        if (tfCodigoFormaPagamento.getText().contains("1")) {
            Double vlrTotalNormal = Double.parseDouble(tfVlrPago3.getText().replace(",", "."));
            tfVlrPago3.setText(new DecimalFormat("0.00").format(vlrTotalNormal).replace(",", "."));
            double vlrPago = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""))
                    + Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""))
                    + Double.parseDouble(tfVlrPago3.getText().replace(",", ".").replace(".", ""));

            double vlrTotal = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", ""));
            double troco = vlrPago - vlrTotal;
            tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
            lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));

            Double vlrMaximo = Double.parseDouble(tfVlrTotal.getText().replace(",", ".")
                    .replace(".", "")) - (Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", "")) + Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", "")));

            Double vlrCamp1 = Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));
            Double vlrCamp2 = Double.parseDouble(tfVlrPago2.getText().replace(",", ".").replace(".", ""));

//            if (tfCodigoFormaPagamento3.getText().equals("2")) {
//                tfParcelas.setText("1");
//                tfVlrParcelas.setText(tfVlrPago3.getText());
//            }
            if (vlrTotal < vlrPago || vlrTotal == vlrPago) {
                if (vlrTotal < vlrPago) {
                    //  tfVlrParcelas.setText(tfVlrTotal.getText());
                    Double vlr = Double.parseDouble(tfVlrTotal.getText().replace(",", ".").replace(".", "")) - Double.parseDouble(tfVlrPago.getText().replace(",", ".").replace(".", ""));

                    tfVlrPago3.setText(new DecimalFormat("0.00").format(vlrMaximo / 100).replace(",", "."));

                    troco = vlrTotal - (vlrMaximo + vlrCamp1 + vlrCamp2);
                    tfTroco.setText(new DecimalFormat("0.00").format(troco / 100).replace(",", "."));
                    lbTroco.setText(new DecimalFormat("0.00").format(troco / 100));
                    if (tfFormaPagamento3.equals("PARCELADO")) {
                        tfVlrParcelas.setText(new DecimalFormat("0.00").format(vlr / 100));
                    }
                    lbTroco.setForeground(Color.BLUE);
                    lbTrocoFalta.setText("Troco");
                    lbTrocoFalta.setForeground(Color.BLUE);

                    lbTrocoUnico.setText("Troco");
                    lbTrocoUnico.setForeground(Color.BLUE);
                } else {
                    lbTroco.setForeground(Color.BLUE);
                    lbTrocoFalta.setText("Troco");
                    lbTrocoFalta.setForeground(Color.BLUE);

                    lbTrocoUnico.setText("Troco");
                    lbTrocoUnico.setForeground(Color.BLUE);
                }
            } else {
                lbTroco.setForeground(Color.red);
                lbTrocoFalta.setText("Falta");
                lbTrocoFalta.setForeground(Color.red);

                lbTrocoUnico.setText("Falta");
                lbTrocoUnico.setForeground(Color.red);
            }
            if (tfCodigoFormaPagamento3.getText().equals("2")) {
                tfParcelas.setText("1");
                tfVlrParcelas.setText(tfVlrPago3.getText());
            }
        }

    }

    public boolean retornaStatus() {
        return statusFinalizacao;
    }

    private void efetivaMovimentacaoDeEntrada(Double valorTotal, String tipoPagamento) {
        try {
            MovimentacaoEntity mov = new MovimentacaoEntity();
            mov.setIdConta(0);
            mov.setIdEntrada(inicializaEntradaEntity.getSequencia());
            mov.setDescricao("ENTRADA DE MERCADORIAS");
            mov.setTipoMovimento("SAIDA");
            mov.setValor(valorTotal);
            mov.setDataMovimento(lbDataAtual.getText());
            System.out.println(" Caixa " + inicializaEntradaEntity.getCaixa());
            mov.setCaixa(inicializaEntradaEntity.getCaixa());
            mov.setTipoDePagamento(tipoPagamento);
            MovimentacaoDAO dao = new MovimentacaoDAO();
            dao.gravarSaida(mov);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
