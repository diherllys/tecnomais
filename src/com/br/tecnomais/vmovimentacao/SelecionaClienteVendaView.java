package com.br.tecnomais.vmovimentacao;

import br.com.daruma.jna.DUAL;
import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.CupomBematch;
import com.br.tecnomais.classes.CupomDaruma;
import com.br.tecnomais.classes.ImpressoraBematchEntity;
import com.br.tecnomais.classes.MP2032;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.ClienteDAO;
import com.br.tecnomais.dao.CupomDAO;
import com.br.tecnomais.dao.ImpressoraBematchDAO;
import com.br.tecnomais.dao.ImpressoraDarumaDAO;
import com.br.tecnomais.dao.ImpressoraPadraoDAO;
import com.br.tecnomais.dao.VendaDAO;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.CupomEntity;
import com.br.tecnomais.entity.ImpressoraDarumaEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import com.sun.jna.Native;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reginaldo
 */
public class SelecionaClienteVendaView extends javax.swing.JDialog {

    private final VendaDAO daoVenda = new VendaDAO();
    private final ClienteDAO cliDao = new ClienteDAO();
    private int codigoCliente;
    Double valorTotal = 0.0;
    List<ProdutosVendaEntity> lista = new ArrayList();
    String numParce = "";
    NovaData data = new NovaData();

    String impressoraAtual = "";
    ImpressoraPadraoDAO impressoraPadraoDAO = new ImpressoraPadraoDAO();
    ImpressoraBematchDAO impressoraBematchDAO = new ImpressoraBematchDAO();
    ImpressoraBematchEntity impressoraBematchEntity = new ImpressoraBematchEntity();
    ImpressoraDarumaDAO impressoraDarumaDAO = new ImpressoraDarumaDAO();
    ImpressoraDarumaEntity impressoraDarumaEntity = new ImpressoraDarumaEntity();

    MP2032 dll = (MP2032) Native.loadLibrary("mp2032.dll", MP2032.class);

    ClienteEntity ce = new ClienteEntity();
    FinalizaVendaView fvv = new FinalizaVendaView(null, null, null, null, 1.0, ce);
    String formaPag1;
    String formaPag2;
    String formaPag3;
    String dataVencimento;
    Double pag1;
    Double pag2;
    Double pag3;
    Double vlrParc;
    VendaEntity vendaEntity = new VendaEntity();
    CupomDAO cupomDAO = new CupomDAO();
    CupomEntity cupomEntity = new CupomEntity();
    double valorCertoDaParcela;

    /**
     * Creates new form SelecionaClienteVendaView
     */
    public SelecionaClienteVendaView(java.awt.Frame parent, boolean modal, List<ProdutosVendaEntity> lista, String numParce, FinalizaVendaView fvv, VendaEntity ve, double valorCertoDaParcela) {
        super(parent, modal);
        initComponents();
        this.valorCertoDaParcela = valorCertoDaParcela;
        this.numParce = numParce;
        this.lista = lista;
        this.fvv = fvv;
        formaPag1 = this.fvv.retornaPag1();
        formaPag2 = this.fvv.retornaPag2();
        formaPag3 = this.fvv.retornaPag3();
        pag1 = this.fvv.retornaVal1();
        pag2 = this.fvv.retornaVal2();
        pag3 = this.fvv.retornaVal3();
        dataVencimento = this.fvv.retornaDataVenc();
        vlrParc = this.fvv.vlrParcela();
        vendaEntity = ve;

        System.out.println("Forma pag1 " + formaPag1);
        System.out.println("Forma pag2 " + formaPag2);
        System.out.println("Forma pag3 " + formaPag3);

        System.out.println("pag1 " + pag1);
        System.out.println("pag2 " + pag2);
        System.out.println("pag3 " + pag3);
        try {
            impressoraAtual = impressoraPadraoDAO.retornaImpAtual();
            if (impressoraAtual.equals("ImpressoraDaruma")) {
                impressoraDarumaEntity = impressoraDarumaDAO.retornaIde();
                int tRetorno = DUAL.regTermica(impressoraDarumaEntity.getRegistroTermico());
                int pRetorno = DUAL.regPortaComunicacao(impressoraDarumaEntity.getPortaComunicacao());
                int pvRetorno = DUAL.regVelocidade(impressoraDarumaEntity.getPortaVelocidade());
//                int cGRetorno = DUAL.iConfigurarGuilhotina(Integer.parseInt(impressoraDarumaEntity.getStatusGuilhotina()),
//                Integer.parseInt(impressoraDarumaEntity.getTamanhoGuilhotina()));
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
        try {
            cupomEntity = cupomDAO.retornaConfigsCupom();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

//        dll.ConfiguraModeloImpressora(8);
//        dll.IniciaPorta("USB");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfNomePesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bSelecionar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfNomeCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfEnderecoCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfCpfCli = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        tfNomePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomePesquisaActionPerformed(evt);
            }
        });
        tfNomePesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNomePesquisaKeyReleased(evt);
            }
        });

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF/CNPJ", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbClientes.getTableHeader().setReorderingAllowed(false);
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbClientesMousePressed(evt);
            }
        });
        tbClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbClientesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);
        if (tbClientes.getColumnModel().getColumnCount() > 0) {
            tbClientes.getColumnModel().getColumn(0).setResizable(false);
            tbClientes.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbClientes.getColumnModel().getColumn(1).setResizable(false);
            tbClientes.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbClientes.getColumnModel().getColumn(2).setResizable(false);
            tbClientes.getColumnModel().getColumn(2).setPreferredWidth(120);
            tbClientes.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Pesquisar Cliente:");

        bSelecionar.setText("Selecionar");
        bSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelecionarActionPerformed(evt);
            }
        });

        jButton2.setText("P");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome: ");

        tfNomeCli.setFocusable(false);

        jLabel3.setText("Endereço");

        tfEnderecoCli.setFocusable(false);

        jLabel4.setText("CPF/ CNPJ");

        tfCpfCli.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar)
                        .addGap(144, 144, 144))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 144, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfCpfCli)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSelecionar)
                    .addComponent(bCancelar))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomePesquisaActionPerformed
        tfNomeCli.setText("");
        tfCpfCli.setText("");
        tfEnderecoCli.setText("");
        preencherTabela();
    }//GEN-LAST:event_tfNomePesquisaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tfNomeCli.setText("");
        tfCpfCli.setText("");
        tfEnderecoCli.setText("");
        preencherTabela();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelecionarActionPerformed
        int linha = tbClientes.getSelectedRow();
        codigoCliente = Integer.parseInt(tbClientes.getValueAt(linha, 0).toString());
        fvv.finalizaVendaParcelado();
        fvv.cadastrarContaReceber();
        fvv.fluxoNovinhaNoGrau();
        fvv.baixaNoEstoque();
        if (impressoraAtual.equals("ImpressoraBematech")) {
            imprimirCabecalhoBematech();
        } else if (impressoraAtual.equals("ImpressoraDaruma")) {
            imprimirCabecalhoDaruma();
        }
        new Alertas().mensagemConfirmacao("Venda finalizada com sucesso!");
        this.dispose();
    }//GEN-LAST:event_bSelecionarActionPerformed

    private void tbClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMousePressed
        int linha = tbClientes.getSelectedRow();

        codigoCliente = Integer.parseInt(tbClientes.getValueAt(linha, 0).toString());
        tfNomeCli.setText(tbClientes.getValueAt(linha, 1).toString());
        tfCpfCli.setText(tbClientes.getValueAt(linha, 2).toString());
        tfEnderecoCli.setText(tbClientes.getValueAt(linha, 3).toString());

        ce.setId(codigoCliente);
        ce.setNome(tbClientes.getValueAt(linha, 1).toString());
        ce.setCnpjOuCpf(tbClientes.getValueAt(linha, 2).toString());
        ce.setEndereco(tbClientes.getValueAt(linha, 3).toString());

        fvv.preencheDadosCliente(tfCpfCli.getText(), tfEnderecoCli.getText(), tfNomeCli.getText(), codigoCliente);
    }//GEN-LAST:event_tbClientesMousePressed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        codigoCliente = 0;
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void tfNomePesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomePesquisaKeyReleased
        atalhos(evt);
    }//GEN-LAST:event_tfNomePesquisaKeyReleased

    private void tbClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbClientesKeyPressed
        int linha = tbClientes.getSelectedRow();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            codigoCliente = Integer.parseInt(tbClientes.getValueAt(linha, 0).toString());
            tfNomeCli.setText(tbClientes.getValueAt(linha, 1).toString());
            tfCpfCli.setText(tbClientes.getValueAt(linha, 2).toString());
            tfEnderecoCli.setText(tbClientes.getValueAt(linha, 3).toString());
            fvv.preencheDadosCliente(tfCpfCli.getText(), tfEnderecoCli.getText(), tfNomeCli.getText(), codigoCliente);

            ce.setId(codigoCliente);
            ce.setNome(tbClientes.getValueAt(linha, 1).toString());
            ce.setCnpjOuCpf(tbClientes.getValueAt(linha, 2).toString());
            ce.setEndereco(tbClientes.getValueAt(linha, 3).toString());
            fvv.finalizaVendaParcelado();
            fvv.cadastrarContaReceber();
            fvv.fluxoNovinhaNoGrau();
            fvv.baixaNoEstoque();
            if (impressoraAtual.equals("ImpressoraBematech")) {
                imprimirCabecalhoBematech();
            } else if (impressoraAtual.equals("ImpressoraDaruma")) {
                imprimirCabecalhoDaruma();
            }
            new Alertas().mensagemConfirmacao("Venda finalizada com sucesso!");
            this.dispose();
        } else {
            System.out.println("nada");
        }
    }//GEN-LAST:event_tbClientesKeyPressed

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
            java.util.logging.Logger.getLogger(SelecionaClienteVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionaClienteVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionaClienteVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionaClienteVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelecionaClienteVendaView dialog = new SelecionaClienteVendaView(new javax.swing.JFrame(), true, null, null, null, null, 0.0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bSelecionar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField tfCpfCli;
    private javax.swing.JTextField tfEnderecoCli;
    private javax.swing.JTextField tfNomeCli;
    private javax.swing.JTextField tfNomePesquisa;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        DefaultTableModel tb = (DefaultTableModel) tbClientes.getModel();
        tb.setNumRows(0);
        try {
            String nome = tfNomePesquisa.getText() + "%";
            for (ClienteEntity cli : cliDao.listar(nome)) {
                tb.addRow(new Object[]{cli.getId(), cli.getNome(), cli.getCnpjOuCpf(), cli.getEndereco()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setNumParce(String numParce) {
        this.numParce = numParce;
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == 40) {// ao apertar para baixo

            if (tbClientes.getRowCount() > 0) {
                tbClientes.requestFocus();
                tbClientes.addRowSelectionInterval(0, 0);

                int linha = tbClientes.getSelectedRow();
                codigoCliente = Integer.parseInt(tbClientes.getValueAt(linha, 0).toString());

                bSelecionar.setEnabled(true);
            }
        }
    }

    public void imprimirCabecalhoBematech() {
        String vlrForm = new DecimalFormat("0.00").format(valorCertoDaParcela);
        new CupomBematch(dll, vendaEntity, ce, cupomEntity, lista, vendaEntity.getVlrTotal() / 100).imprimirCabecalhoBematech(dataVencimento, vlrForm);
//        String aux = retornaResumoPag();
//        String aux2 = retornaResumoPagParcelado();
//
//        Integer codigoVenda = 0;
//
//        try {
//            codigoVenda = daoVenda.getLastCodigoVenda();
//        } catch (Exception ex) {
//            Logger.getLogger(FinalizaVendaView.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String hora = String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
//        dll.AjustaLarguraPapel(600);
//        dll.FormataTX(cupomEntity.getCabecalho() + "\n", 2, 0, 0, 1, 1);
//        dll.FormataTX(cupomEntity.getEndereco() + "\n", 2, 0, 0, 0, 0);
//        dll.BematechTX("--------------------------------------------------\n");
//        dll.BematechTX("Operacao: " + vendaEntity.getOperacao() + "    Cupom: " + codigoVenda.toString());
//        dll.BematechTX("\nCaixa: " + vendaEntity.getCaixa());
//        dll.BematechTX("   Data/Hora: " + data.dataAtual() + " " + hora);
//        dll.BematechTX("       --------- DADOS DO CLIENTE ---------\n");
//        if (!tfNomeCli.getText().isEmpty()) {
//            dll.BematechTX("Nome: " + tfNomeCli.getText() + "\n");
//        }
//        if (!tfEnderecoCli.getText().isEmpty()) {
//            dll.BematechTX("Endereco: " + tfEnderecoCli.getText() + "\n");
//        }
//        if (!tfCpfCli.getText().isEmpty()) {
//            dll.BematechTX("CPF: " + tfCpfCli.getText() + "\n");
//        }
//
//        dll.BematechTX("          ****** CUPOM NAO FISCAL ******\n");
//        dll.BematechTX("Descricao   Cod   Quant   PrecoUN   PrecoTotal\n");
//        dll.BematechTX("-------------------------------------------------\n");
//        for (int i = 0; i < lista.size(); i++) {
//            imprimirCupom(i);
//        }
//        dll.BematechTX("----------------Resumo da Compra-----------------\n");
//        dll.FormataTX(aux, 2, 0, 0, 0, 1);
//        dll.BematechTX(aux2);
//        dll.BematechTX("\nValor Total R$" + new DecimalFormat("0.00").format(valorTotal));
//        dll.FormataTX("\n" + cupomEntity.getMensagem(), 2, 0, 0, 0, 1);
//        dll.AcionaGuilhotina(1);
    }

    public void imprimirCabecalhoDaruma() {
        String vlrForm = new DecimalFormat("0.00").format(valorCertoDaParcela);
        new CupomDaruma(vendaEntity, ce, cupomEntity, impressoraDarumaEntity, lista,
                valorTotal).imprimirCabecalhoDaruma(vlrForm, dataVencimento);
    }

    public void imprimirCupom(int i) {
//        List<ProdutosVendaEntity> st = new ArrayList();
//        st = lista;
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

    public String retornaResumoPagParcelado() {
        String aux = "";
        if (formaPag1.equals("DINHEIRO")) {
            if (formaPag2.equals("PARCELADO")) {
                String data = dataVencimento;
                aux = aux + "\n";
                for (int i = 1; i <= Integer.parseInt(numParce); i++) {
                    aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlrParc)
                            + " " + data;
                    if (i % 2 == 0) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }
            if (formaPag3.equals("PARCELADO")) {
                String data = dataVencimento;
                aux = aux + "\n";
                for (int i = 1; i <= Integer.parseInt(numParce); i++) {
                    aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlrParc)
                            + " " + data;
                    if (i % 2 == 0) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }

        }
        if (formaPag1.equals("PARCELADO")) {
            String data = dataVencimento;
            aux = aux + "\n";
            for (int i = 1; i <= Integer.parseInt(numParce); i++) {
                aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlrParc)
                        + " " + data;
                if (i % 2 == 0) {
                    aux = aux + "\n";
                }
                data = this.data.adiciona1Mes(data);
            }
        }
        return aux;
    }

    private String retornaResumoPag() {
        String aux = "";

        if (formaPag1.equals("DINHEIRO")) {
            aux = aux + " D R$" + new DecimalFormat("0.00").format(pag1) + "  ";

            if (formaPag2.equals("CARTAO CREDITO")) {
                aux = aux + " CC R$" + new DecimalFormat("0.00").format(pag2) + " x1" + "  ";
            }
            if (formaPag2.equals("CARTAO DEBITO")) {
                aux = aux + " CD R$" + new DecimalFormat("0.00").format(pag2) + " x1" + "  ";
            }
            if (formaPag2.equals("CHEQUE")) {
                aux = aux + " CQ R$" + new DecimalFormat("0.00").format(pag2) + "  ";
            }
            if (formaPag3.equals("CARTAO CREDITO")) {
                aux = aux + " CC R$" + new DecimalFormat("0.00").format(pag3) + " x1" + "  ";
            }
            if (formaPag3.equals("CARTAO DEBITO")) {
                aux = aux + " CD R$" + new DecimalFormat("0.00").format(pag3) + " x1" + "  ";
            }
            if (formaPag3.equals("CHEQUE")) {
                aux = aux + " CQ R$" + new DecimalFormat("0.00").format(pag3) + "  ";
            }

            if (formaPag2.equals("PARCELADO")) {
                aux = aux + " P R$" + new DecimalFormat("0.00").format(pag2) + "  ";
            }
            if (formaPag3.equals("PARCELADO")) {
                aux = aux + " P R$" + new DecimalFormat("0.00").format(pag3) + "  ";
            }

        }

        if (formaPag1.equals("CARTAO CREDITO")) {
            aux = aux + " CC  x" + numParce + " de " + new DecimalFormat("0.00").format(vlrParc);
        }
        if (formaPag1.equals("CARTAO DEBITO")) {
            aux = aux + " CD x1" + new DecimalFormat("0.00").format(valorTotal);
        }
        if (formaPag1.equals("CHEQUE")) {
            aux = aux + " CQ " + new DecimalFormat("0.00").format(pag1);
        }
        if (formaPag1.equals("PARCELADO")) {
            aux = aux + " P R$" + new DecimalFormat("0.00").format(pag1);
        }
        return aux;
    }
}
