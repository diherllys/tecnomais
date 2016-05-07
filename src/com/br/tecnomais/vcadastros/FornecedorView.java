package com.br.tecnomais.vcadastros;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.ValidarCamposNumericos;
import com.br.tecnomais.dao.FornecedorDAO;
import com.br.tecnomais.entity.FornecedorEntity;
import com.br.tecnomais.vconfiguracao.FixedLengthDocument;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Usuario
 */
public class FornecedorView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();
    FornecedorEntity fornecedor;

    public FornecedorView(FornecedorEntity fornecedor) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fornecedor = fornecedor;
        desabilitarCampos();
        limitarCampos();
        preencherCampos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        tfCep = new javax.swing.JFormattedTextField();
        tfTelefone1 = new javax.swing.JFormattedTextField();
        jbNovo = new javax.swing.JButton();
        tfFantasia = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        tfPais = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        cbIndicadorDoIE = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfTelefone2 = new javax.swing.JFormattedTextField();
        cbTipoDePessoa = new javax.swing.JComboBox();
        cbEstado = new javax.swing.JComboBox();
        lbRG = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfRg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jbExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        tfCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfComplemento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbCpfCnpj = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setBackground(new java.awt.Color(255, 255, 51));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpPrincipal.setBackground(new java.awt.Color(200, 210, 210));
        jpPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-neutral-user  24px.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        tfFantasia.setEnabled(false);

        cbIndicadorDoIE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "valor" }));

        jLabel15.setText("Estado");

        jLabel7.setText("Telefones");

        jLabel11.setText("Endereço");

        try {
            tfTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbTipoDePessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FISICA", "JURIDICA" }));
        cbTipoDePessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDePessoaActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CE" }));

        lbRG.setText("RG");

        jLabel5.setText("Número");

        jLabel9.setText("Fantasia");

        tfRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfRgKeyTyped(evt);
            }
        });

        jLabel2.setText("Fís./Jur.");

        tfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumeroKeyTyped(evt);
            }
        });

        jLabel8.setText("Nome");

        jLabel12.setText("Complem.");

        jLabel14.setText("Bairro");

        jLabel16.setText("País");

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-remove-user  24px.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jLabel3.setText("Indicador do IE");

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-add-user  24px.png"))); // NOI18N
        jbSalvar.setText("Gravar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-find-user  24px.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("CEP");

        jLabel1.setText("Código");

        jLabel6.setText("Cidade");

        lbCpfCnpj.setText("CPF/CNPJ");

        jLabel10.setBackground(new java.awt.Color(170, 180, 180));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Fornecedor");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setOpaque(true);

        tfCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCpfFocusLost(evt);
            }
        });
        tfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCpfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCpfKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoDePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbIndicadorDoIE, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(87, 87, 87)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(lbCpfCnpj)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNome)
                                    .addComponent(tfFantasia)
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbRG)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfRg))
                                            .addComponent(tfEndereco))
                                        .addGap(0, 82, Short.MAX_VALUE))))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(tfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbBuscar, jbExcluir, jbNovo, jbSalvar});

        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoDePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2)))
                        .addGap(9, 9, 9)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbIndicadorDoIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3)))
                        .addGap(9, 9, 9)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4)))
                        .addGap(9, 9, 9)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5)))
                        .addGap(9, 9, 9)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCpfCnpj)
                            .addComponent(lbRG)
                            .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbNovo)
                    .addComponent(jbBuscar)
                    .addComponent(jbExcluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(824, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        FornecedorDAO forDAO = new FornecedorDAO();
        try {
            if ((forDAO.verificaFornecedor(tfNome.getText()) == false)
                    || tfNome.getText().equals(fornecedor.getNome())) {
                if (!tfCodigo.getText().isEmpty()) {
                    try {
                        alterarFornecedor();
                    } catch (SQLException ex) {
                        alerta.mensagemErro("Erro ao alterar fornecedor");
                    }
                } else {
                    try {
                        cadastrarFornecedor();
                        limparCampos();
                        this.dispose();
                    } catch (SQLException ex) {
                        alerta.mensagemErro("Erro ao salvar fornecedor");
                    }
                }
            } else {
                alerta.mensagemAviso("O nome do Fornecedor já existe");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (!tfCodigo.getText().isEmpty()) {
            try {
                excluirFornecedor();
                limparCampos();
            } catch (SQLException ex) {
                alerta.mensagemErro("Erro ao excluir fornecedor");
            }
        } else {
            alerta.mensagemAviso("Não existe fornecedor selecionado");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        new PesquisaFornecedorView().setVisible(true);
        this.dispose();
        limparCampos();

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void cbTipoDePessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDePessoaActionPerformed
        if (cbTipoDePessoa.getSelectedItem().equals("FISICA")) {
            tfFantasia.setEnabled(false);
            lbCpfCnpj.setText("CPF");
            tfRg.setVisible(true);
            lbRG.setVisible(true);
//            geraMascaraCPF();
        } else {
            tfFantasia.setEnabled(true);
            lbCpfCnpj.setText("CNPJ");
            tfRg.setVisible(false);
            lbRG.setVisible(false);
//            geraMascaraCNPJ();
        }
    }//GEN-LAST:event_cbTipoDePessoaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new PesquisaFornecedorView().setVisible(true);
        limparCampos();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void tfCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCpfKeyReleased
        new ValidarCamposNumericos().validar(tfCpf);
    }//GEN-LAST:event_tfCpfKeyReleased

    private void tfCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCpfFocusLost
        if (tfCpf.getText().length() == 11 || tfCpf.getText().length() == 14) {
            if (tfCpf.getText().length() == 11) {
                formataCPF();
            } else {
                formataCNPJ();
            }
        } else {
            new Alertas().mensagemAviso("CPF/CNPJ inválido!");
        }
    }//GEN-LAST:event_tfCpfFocusLost

    private void tfCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCpfFocusGained
        String cpfOld = tfCpf.getText();
        tfCpf.setText(cpfOld.replace(".", "").replace("-", "").replace("/", ""));
    }//GEN-LAST:event_tfCpfFocusGained

    private void tfNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfNumeroKeyTyped

    private void tfCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCpfKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCpfKeyTyped

    private void tfRgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfRgKeyTyped
      String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfRgKeyTyped
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
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FornecedorView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbIndicadorDoIE;
    private javax.swing.JComboBox cbTipoDePessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JLabel lbCpfCnpj;
    private javax.swing.JLabel lbRG;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfFantasia;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPais;
    private javax.swing.JTextField tfRg;
    private javax.swing.JFormattedTextField tfTelefone1;
    private javax.swing.JFormattedTextField tfTelefone2;
    // End of variables declaration//GEN-END:variables

    private void cadastrarFornecedor() throws SQLException {

        FornecedorEntity fe = new FornecedorEntity();
        fe.setNome(tfNome.getText());
        fe.setTipoDePessoa(cbTipoDePessoa.getSelectedItem().toString());
        fe.setIndicadorDaIE(cbIndicadorDoIE.getSelectedItem().toString());
        fe.setCep(tfCep.getText());
        fe.setNumero(tfNumero.getText());
        fe.setCidade(tfCidade.getText());
        fe.setTelefone1(tfTelefone1.getText());
        fe.setTelefone2(tfTelefone2.getText());
        fe.setFantasia(tfFantasia.getText());
        fe.setCnpjOuCpf(tfCpf.getText());
        fe.setRg(tfRg.getText());
        fe.setEndereco(tfEndereco.getText());
        fe.setComplemento(tfComplemento.getText());
        fe.setBairro(tfBairro.getText());
        fe.setEstado(cbEstado.getSelectedItem().toString());
        fe.setPais(tfPais.getText());

        FornecedorDAO dao = new FornecedorDAO();
        dao.adicionar(fe);

        alerta.mensagemConfirmacao("Cadastro do fornecedor '" + tfNome.getText() + "' realizado com sucesso!!!");

    }

    private void alterarFornecedor() throws SQLException {

        if (!tfCodigo.getText().isEmpty()) {
            FornecedorEntity ce = new FornecedorEntity();
            FornecedorDAO dao = new FornecedorDAO();

            ce.setId(Integer.valueOf(tfCodigo.getText()));
            ce.setNome(tfNome.getText());
            ce.setTipoDePessoa(cbTipoDePessoa.getSelectedItem().toString());
            ce.setIndicadorDaIE(cbIndicadorDoIE.getSelectedItem().toString());
            ce.setCep(tfCep.getText());
            ce.setNumero(tfNumero.getText());
            ce.setCidade(tfCidade.getText());
            ce.setTelefone1(tfTelefone1.getText());
            ce.setTelefone2(tfTelefone2.getText());
            ce.setFantasia(tfFantasia.getText());
            ce.setCnpjOuCpf(tfCpf.getText());
            ce.setRg(tfRg.getText());
            ce.setEndereco(tfEndereco.getText());
            ce.setComplemento(tfComplemento.getText());
            ce.setBairro(tfBairro.getText());
            ce.setEstado(cbEstado.getSelectedItem().toString());
            ce.setPais(tfPais.getText());
            dao.altera(ce);
            alerta.mensagemConfirmacao("Fornecedor '" + tfNome.getText() + "' alterado com sucesso!!!");
        }

    }

    private void preencherCampos() {
        if (fornecedor.getId() != null) {
            tfCodigo.setText(fornecedor.getId().toString());
            tfNome.setText(fornecedor.getNome());
            cbTipoDePessoa.setSelectedItem(fornecedor.getTipoDePessoa());
            cbIndicadorDoIE.setSelectedItem(fornecedor.getIndicadorDaIE());
            tfCep.setText(fornecedor.getCep());
            tfNumero.setText(fornecedor.getNumero());
            tfCidade.setText(fornecedor.getCidade());
            tfTelefone1.setText(fornecedor.getTelefone1());
            tfTelefone2.setText(fornecedor.getTelefone2());
            tfFantasia.setText(fornecedor.getFantasia());
            tfCpf.setText(fornecedor.getCnpjOuCpf());
            tfRg.setText(fornecedor.getRg());
            tfEndereco.setText(fornecedor.getEndereco());
            tfComplemento.setText(fornecedor.getComplemento());
            tfBairro.setText(fornecedor.getBairro());
            cbEstado.setSelectedItem(fornecedor.getEstado());
            tfPais.setText(fornecedor.getPais());
        }
    }

    private void excluirFornecedor() throws SQLException {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o fornecedor!", "Pergunta",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (opcao == JOptionPane.YES_OPTION) {
            int id = Integer.valueOf(tfCodigo.getText());
            FornecedorEntity fe = new FornecedorEntity();
            fe.setId(id);
            FornecedorDAO dao = new FornecedorDAO();
            dao.remove(fe);
            alerta.mensagemConfirmacao("Fornecedor excluído com sucesso!");
            limparCampos();
        }

    }

    private void limparCampos() {
        tfCodigo.setText("");
        tfNome.setText("");
        cbTipoDePessoa.setSelectedIndex(0);
        cbIndicadorDoIE.setSelectedIndex(0);
        tfCep.setText("");
        tfNumero.setText("");
        tfCidade.setText("");
        tfTelefone1.setText("");
        tfTelefone2.setText("");
        tfFantasia.setText("");
        tfCpf.setText("");
        tfRg.setText("");
        tfEndereco.setText("");
        tfComplemento.setText("");
        tfBairro.setText("");
        cbEstado.setSelectedIndex(0);
        tfPais.setText("");
    }

    private void desabilitarCampos() {
        tfCodigo.setEditable(false);
    }

//    private void geraMascaraCPF() {
//        try {
//            MaskFormatter mask = new MaskFormatter("###.###.###-##");
//            tfCpf.setText("");
//            tfCpf.setFormatterFactory(null);
//            tfCpf.setFormatterFactory(new DefaultFormatterFactory(mask));
//        } catch (Exception e) {
//        }
//    }
//
//    private void geraMascaraCNPJ() {
//        try {
//            MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
//            tfCpf.setText("");
//            tfCpf.setFormatterFactory(null);
//            tfCpf.setFormatterFactory(new DefaultFormatterFactory(mask));
//        } catch (Exception e) {
//        }
//    }
    private void formFrameClosing(javax.swing.event.InternalFrameEvent evt) {
        this.fechar();
    }

    private void fechar() {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Fechar?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
        }
    }

    private void limitarCampos() {
        tfNumero.setDocument(new FixedLengthDocument(11));
        tfCidade.setDocument(new FixedLengthDocument(11));
        tfNome.setDocument(new FixedLengthDocument(44));
        tfFantasia.setDocument(new FixedLengthDocument(50));
        tfCpf.setDocument(new FixedLengthDocument(20));
        tfRg.setDocument(new FixedLengthDocument(23));
        tfEndereco.setDocument(new FixedLengthDocument(48));
        tfComplemento.setDocument(new FixedLengthDocument(20));
        tfPais.setDocument(new FixedLengthDocument(21));
    }

    private void formataCPF() {
        String cpf = tfCpf.getText();
        //coloca 1º ponto(.)
        String aux = cpf.substring(0, 3);
        String naux = aux + ".";

        //coloca 2º ponto(.)
        String aux2 = cpf.substring(3, 6);
        String naux2 = aux2 + ".";

        //coloca traço(-)
        String aux3 = cpf.substring(6, 9);
        String naux3 = aux3 + "-" + cpf.substring(9, 11);

        tfCpf.setText(naux + "" + naux2 + "" + naux3);
    }

    private void formataCNPJ() {
        String cpf = tfCpf.getText();
        //coloca 1º ponto(.)
        String aux = cpf.substring(0, 2);
        String naux = aux + ".";

        //coloca 2º ponto(.)
        String aux2 = cpf.substring(2, 5);
        String naux2 = aux2 + ".";

        //coloca a barra(/)
        String aux3 = cpf.substring(5, 8);
        String naux3 = aux3 + "/";

        //coloca o traço(-)
        String aux4 = cpf.substring(8, 12);
        String naux4 = aux4 + "-" + cpf.substring(12, 14);

        //seta no campo
        tfCpf.setText(naux + "" + naux2 + "" + naux3 + "" + naux4);
    }
}
