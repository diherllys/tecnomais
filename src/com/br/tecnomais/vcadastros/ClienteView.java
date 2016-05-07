package com.br.tecnomais.vcadastros;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.ValidarCamposNumericos;
import com.br.tecnomais.dao.ClienteDAO;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.vconfiguracao.FixedLengthDocument;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Usuario
 */
public class ClienteView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();
    ClienteEntity cliente;

    public ClienteView(ClienteEntity cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cliente = cliente;
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
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tfCpf = new javax.swing.JFormattedTextField();
        cbTipoDePessoa = new javax.swing.JComboBox();

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

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CE" }));

        lbRG.setText("RG");

        jLabel5.setText("Número");

        jLabel9.setText("Fantasia");

        jLabel2.setText("Fís./Jur.");

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
        jbSalvar.setToolTipText("");
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
        jLabel10.setText("Clientes");
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
        });

        cbTipoDePessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FISICA", "JURIDICA" }));
        cbTipoDePessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDePessoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
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
                                .addComponent(tfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbIndicadorDoIE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfCep)
                                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCidade)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoDePessoa, 0, 160, Short.MAX_VALUE))
                                .addGap(107, 107, 107)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(lbCpfCnpj)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfBairro))
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(71, Short.MAX_VALUE))
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfFantasia)
                                            .addComponent(tfNome)
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbRG)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfRg, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jpPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbBuscar, jbExcluir, jbNovo, jbSalvar});

        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbTipoDePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tfFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbIndicadorDoIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbCpfCnpj)
                                .addComponent(lbRG)
                                .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14)
                                .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(824, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (!tfCodigo.getText().isEmpty()) {
            try {
                alterarCliente();
            } catch (SQLException ex) {
                alerta.mensagemErro("Erro ao alterar cliente");
            }
        } else {
            try {
                if (tfNome.getText().isEmpty() || tfCpf.getText().contains(" ")) {
                    new Alertas().mensagemAviso("Preencha os campos Nome e CPF!");
                } else {
                    cadastrar();
                    this.dispose();
                }
            } catch (SQLException ex) {
                alerta.mensagemErro("Erro ao salvar cliente");
            }
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (!tfCodigo.getText().isEmpty()) {
            try {
                excluirCliente();
            } catch (SQLException ex) {
                alerta.mensagemErro("Erro ao excluir cliente");
            }
        } else {
            alerta.mensagemAviso("Não existe cliente selecionado");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        new PesquisaClienteView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void cbTipoDePessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDePessoaActionPerformed
        if (cbTipoDePessoa.getSelectedIndex() == 0) {
            tfFantasia.setText("");
            tfFantasia.setEnabled(false);
        }else{
            tfFantasia.setEnabled(true);
        }
    }//GEN-LAST:event_cbTipoDePessoaActionPerformed

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

    private void tfCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCpfKeyReleased
        new ValidarCamposNumericos().validar(tfCpf);
    }//GEN-LAST:event_tfCpfKeyReleased

    private void tfCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCpfFocusGained
        String cpfOld = tfCpf.getText();
        tfCpf.setText(cpfOld.replace(".", "").replace("-", "").replace("/", ""));
    }//GEN-LAST:event_tfCpfFocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new PesquisaClienteView().setVisible(true);
        limparCampos();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing
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
                new ClienteView(null).setVisible(true);
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
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfFantasia;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPais;
    private javax.swing.JTextField tfRg;
    private javax.swing.JFormattedTextField tfTelefone1;
    private javax.swing.JFormattedTextField tfTelefone2;
    // End of variables declaration//GEN-END:variables

    private void cadastrar() throws SQLException {

        ClienteEntity ce = new ClienteEntity();
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

        ClienteDAO dao = new ClienteDAO();
        dao.adicionar(ce);

        alerta.mensagemConfirmacao("Cadastro do cliente '" + tfNome.getText() + "' realizado com sucesso!!!");

    }

    private void alterarCliente() throws SQLException {

        if (!tfCodigo.getText().isEmpty()) {
            ClienteEntity ce = new ClienteEntity();
            ClienteDAO dao = new ClienteDAO();

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
            alerta.mensagemConfirmacao("Cliente '" + tfNome.getText() + "' alterado com sucesso!!!");
        }

    }

    private void preencherCampos() {
        if (cliente.getId() != null) {
            tfCodigo.setText(cliente.getId().toString());
            tfNome.setText(cliente.getNome());
            cbTipoDePessoa.setSelectedItem(cliente.getTipoDePessoa());
            cbIndicadorDoIE.setSelectedItem(cliente.getIndicadorDaIE());
            tfCep.setText(cliente.getCep());
            tfNumero.setText(cliente.getNumero());
            tfCidade.setText(cliente.getCidade());
            tfTelefone1.setText(cliente.getTelefone1());
            tfTelefone2.setText(cliente.getTelefone2());
            tfFantasia.setText(cliente.getFantasia());
            tfCpf.setText(cliente.getCnpjOuCpf());
            tfRg.setText(cliente.getRg());
            tfEndereco.setText(cliente.getEndereco());
            tfComplemento.setText(cliente.getComplemento());
            tfBairro.setText(cliente.getBairro());
            cbEstado.setSelectedItem(cliente.getEstado());
            tfPais.setText(cliente.getPais());
        }
    }

    private void excluirCliente() throws SQLException {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cliente!", "Pergunta",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (opcao == JOptionPane.YES_OPTION) {
            int id = Integer.valueOf(tfCodigo.getText());
            ClienteEntity ce = new ClienteEntity();
            ce.setId(id);
            ClienteDAO dao = new ClienteDAO();
            dao.remove(ce);
            alerta.mensagemConfirmacao("Cliente excluído com sucesso!");
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

    private void limitarCampos() {
        tfNome.setDocument(new FixedLengthDocument(50));
        tfFantasia.setDocument(new FixedLengthDocument(50));
        tfCpf.setDocument(new FixedLengthDocument(20));
        tfRg.setDocument(new FixedLengthDocument(12));
        tfNumero.setDocument(new FixedLengthDocument(6));
        tfEndereco.setDocument(new FixedLengthDocument(50));
        tfComplemento.setDocument(new FixedLengthDocument(50));
        tfCidade.setDocument(new FixedLengthDocument(50));
        tfBairro.setDocument(new FixedLengthDocument(50));
        tfPais.setDocument(new FixedLengthDocument(50));
        tfTelefone1.setDocument(new FixedLengthDocument(14));
        tfTelefone2.setDocument(new FixedLengthDocument(14));

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
