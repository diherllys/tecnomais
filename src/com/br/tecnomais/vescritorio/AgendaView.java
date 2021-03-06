/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vescritorio;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.dao.AgendaDAO;
import com.br.tecnomais.entity.AgendaEntity;
import com.br.tecnomais.vconfiguracao.FixedLengthDocument;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Desenvolvimento
 */
public class AgendaView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();
    AgendaEntity agenda;
    AgendaDAO dao = new AgendaDAO();

    public AgendaView(AgendaEntity agenda) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.agenda = agenda;
//        desabilitarCampos();
        limitarCampos();
        preencherCampos();

    }

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFArea = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        tfCelular = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        tfCep = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfHomePage = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfObservacoes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel1.setBackground(new java.awt.Color(170, 180, 180));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agenda");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        jLabel2.setText("Área");

        jLabel3.setText("Nome");

        jLabel4.setText("Telefone");

        jLabel5.setText("Endereço");

        jLabel6.setText("Bairro");

        TFArea.setText(" ");
        TFArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFAreaActionPerformed(evt);
            }
        });

        jLabel7.setText("Cidade");

        jLabel8.setText("Estado");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CE" }));

        jLabel9.setText("Cep");

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setText("E-mail");

        jLabel11.setText("Home Page");

        jLabel12.setText("Observações");

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-add-user  24px.png"))); // NOI18N
        jbSalvar.setText("Gravar");
        jbSalvar.setToolTipText("");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-neutral-user  24px.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-find-user  24px.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-remove-user  24px.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jLabel13.setText("Id");

        tfObservacoes.setColumns(20);
        tfObservacoes.setLineWrap(true);
        tfObservacoes.setRows(5);
        jScrollPane1.setViewportView(tfObservacoes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TFArea, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCelular))
                                    .addComponent(tfTelefone)
                                    .addComponent(tfEndereco)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCidade))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCep))
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(tfHomePage)
                                    .addComponent(jScrollPane1)))
                            .addComponent(lID, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbBuscar, jbExcluir, jbNovo, jbSalvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(lID, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(tfHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbNovo)
                    .addComponent(jbBuscar)
                    .addComponent(jbExcluir))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbBuscar, jbExcluir, jbNovo, jbSalvar});

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

    private void TFAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFAreaActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (!lID.getText().isEmpty()) {
            try {
                alteraContato();
            } catch (SQLException ex) {
                alerta.mensagemErro("Erro ao alterar contato");
            }
        } else {
            try {
                salvarContato();
                this.dispose();
            } catch (SQLException ex) {
                alerta.mensagemErro("Erro ao salvar acontato");
            }
        }
        limparCampos();
        agenda = new AgendaEntity();
        this.dispose();
        new PesquisaAgendaView().setVisible(true);
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        new PesquisaAgendaView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (!lID.getText().isEmpty()) {
            try {
                excluirContato();
            } catch (SQLException ex) {
                alerta.mensagemErro("Erro ao excluir contato");
            }
        } else {
            alerta.mensagemAviso("Não existe contato selecionado");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new PesquisaAgendaView().setVisible(true);
        limparCampos();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AgendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFArea;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel lID;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfHomePage;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextArea tfObservacoes;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        lID.setText("");
        tfNome.setText("");
        TFArea.setText("");
        tfCelular.setText("");
        tfBairro.setText("");
        tfCep.setText("");
        tfCidade.setText("");
        tfEmail.setText("");
        tfEndereco.setText("");
        cbEstado.setSelectedItem("");
        tfHomePage.setText("");
        tfObservacoes.setText("");
        tfTelefone.setText("");
    }

    private void salvarContato() throws SQLException {
        AgendaEntity ae = new AgendaEntity();
//        ae.setId(Integer.parseInt(lID.getText()));
        ae.setNome(tfNome.getText());
        ae.setArea(TFArea.getText());
        ae.setCelular(tfCelular.getText());
        ae.setBairro(tfBairro.getText());
        ae.setCep(tfCep.getText());
        ae.setCidade(tfCidade.getText());
        ae.setEmail(tfEmail.getText());
        ae.setEndereco(tfEndereco.getText());
        ae.setEstado(cbEstado.getSelectedItem().toString());
        ae.setHomePage(tfHomePage.getText());
        ae.setObservacoes(tfObservacoes.getText());
        ae.setTelefone(tfTelefone.getText());
        alerta.mensagemConfirmacao("Contato salvo com sucesso!!!");
        dao.salvar(ae);
    }

    private void alteraContato() throws SQLException {
        AgendaEntity ae = new AgendaEntity();
        ae.setId(Integer.parseInt(lID.getText()));
        ae.setNome(tfNome.getText());
        ae.setArea(TFArea.getText());
        ae.setCelular(tfCelular.getText());
        ae.setBairro(tfBairro.getText());
        ae.setCep(tfCep.getText());
        ae.setCidade(tfCidade.getText());
        ae.setEmail(tfEmail.getText());
        ae.setEndereco(tfEndereco.getText());
        ae.setEstado(cbEstado.getSelectedItem().toString());
        ae.setHomePage(tfHomePage.getText());
        ae.setObservacoes(tfObservacoes.getText());
        ae.setTelefone(tfTelefone.getText());

        alerta.mensagemConfirmacao("Contato alterado com sucesso!!!");
        dao.alterar(ae);
    }

    private void preencherCampos() {
        if (agenda.getId() != null) {
            lID.setText(agenda.getId().toString());
            tfNome.setText(agenda.getNome());
            TFArea.setText(agenda.getArea());
            tfCelular.setText(agenda.getCelular());
            tfBairro.setText(agenda.getBairro());
            tfCep.setText(agenda.getCep());
            tfCidade.setText(agenda.getCidade());
            tfEmail.setText(agenda.getEmail());

            cbEstado.setSelectedItem(agenda.getEstado());
            tfHomePage.setText(agenda.getHomePage());
            tfObservacoes.setText(agenda.getObservacoes());
            tfEndereco.setText(agenda.getEndereco());
            tfTelefone.setText(agenda.getTelefone());
        }
    }

    private void excluirContato() throws SQLException {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o contato?!", "Pergunta",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (opcao == JOptionPane.YES_OPTION) {
            int id = Integer.valueOf(lID.getText());
//            AgendaEntity ae = new AgendaEntity();
//            ae.setId(id);
            dao.excluir(id);
            alerta.mensagemConfirmacao("Contato excluído com sucesso!");
            limparCampos();
        }
    }

    private void limitarCampos() {
        TFArea.setDocument(new FixedLengthDocument(2));
        tfCelular.setDocument(new FixedLengthDocument(9));
        tfTelefone.setDocument(new FixedLengthDocument(9));
        tfNome.setDocument(new FixedLengthDocument(34));
        tfEndereco.setDocument(new FixedLengthDocument(34));
        tfBairro.setDocument(new FixedLengthDocument(30));
        tfCidade.setDocument(new FixedLengthDocument(30));
        tfEmail.setDocument(new FixedLengthDocument(35));
        tfHomePage.setDocument(new FixedLengthDocument(255));
        tfObservacoes.setDocument(new FixedLengthDocument(209));
    }

}
