/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vcadastros;

import com.br.tecnomais.classes.Licenca;
import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.Licenca;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.LicencaDao;
import com.br.tecnomais.entity.LicencaEntity;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFileChooser;

/**
 *
 * @author Usuario
 */
public class LicenciarSoftwareView extends javax.swing.JDialog {

    boolean licenciar = false;
    LicencaDao daoLic = new LicencaDao();

    /**
     * Creates new form LicenciarSoftwareView
     */
    public LicenciarSoftwareView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNumeroLicenca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfCnpj = new javax.swing.JTextField();
        tfInscricaoEstadual = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Licenciar");

        jLabel2.setText("Número da Licença:");

        tfNumeroLicenca.setFocusable(false);

        jLabel3.setText("Nome Fantasia:");

        tfNome.setFocusable(false);

        jLabel4.setText("Endereço:");

        tfEndereco.setFocusable(false);

        jLabel5.setText("Bairro:");

        tfBairro.setFocusable(false);

        tfCidade.setFocusable(false);

        jLabel6.setText("Cidade:");

        jLabel7.setText("CNPJ:");

        tfCnpj.setFocusable(false);

        tfInscricaoEstadual.setFocusable(false);

        jLabel8.setText("Inscrição Estadual:");

        jButton1.setText("Licenciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(tfNumeroLicenca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome)
                    .addComponent(tfEndereco)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(tfCidade)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(tfInscricaoEstadual, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))))
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNumeroLicenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();  //Cria uma instância do JFileChooser  
            int returnVal = chooser.showOpenDialog(tfNumeroLicenca); //Abre o diálogo JFileChooser  
            if (returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK  
                String nomeArquivo = chooser.getSelectedFile().getPath();//pega o caminho do arquivo selecionado
                System.out.println(nomeArquivo);
                if (chooser.getSelectedFile().getName().contains(".ssl")) {//verifica se o arquivo tem a extensão ssl
                    BufferedReader buf = new BufferedReader(new FileReader(nomeArquivo));//abre o arquivo e ler o seu conteudo
                    //seta os dados que estão dentro do arquivo de licenca
                    tfNumeroLicenca.setText(buf.readLine());
                    tfNome.setText(buf.readLine());
                    tfEndereco.setText(buf.readLine());
                    tfBairro.setText(buf.readLine());
                    tfCidade.setText(buf.readLine() + "-" + buf.readLine());
                    tfCnpj.setText(buf.readLine());
                    tfInscricaoEstadual.setText(buf.readLine());

                    buf.close();//fecha o arquivo
                    setDadosBanco();
                } else {
                    new Alertas().mensagemErro("Erro no arquivo!");//exibe uma mensagem de erro caso o arquivo não tenha a extensão .ssl
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alertas().mensagemErro("erro ao tentar licenciar\narquivo inválido!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LicenciarSoftwareView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LicenciarSoftwareView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LicenciarSoftwareView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LicenciarSoftwareView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LicenciarSoftwareView dialog = new LicenciarSoftwareView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCnpj;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfInscricaoEstadual;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumeroLicenca;
    // End of variables declaration//GEN-END:variables

    private void verificarSeEstaLicenciado() {

        try {
            LicencaDao licDAO = new LicencaDao();
            if (licDAO.verificaLicencaExistente() == true) {
                this.dispose();
                Licenca lic = new Licenca();
                lic.checaLicenca();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setDadosBanco() {
        try {
            LicencaEntity lic = new LicencaEntity();
            lic.setNumeroLicenca(Integer.valueOf(tfNumeroLicenca.getText()));
            lic.setNome(tfNome.getText());
            lic.setEndereco(tfEndereco.getText());
            lic.setBairro(tfBairro.getText());
            lic.setCidade(tfCidade.getText());
            lic.setUf(tfCidade.getText().substring(tfCidade.getText().indexOf("-") + 1, tfCidade.getText().length()));
            lic.setCnpj(tfCnpj.getText());
            lic.setInscricaoEstadual(tfInscricaoEstadual.getText());
            NovaData nd = new NovaData();
            lic.setDataAdesao(nd.dataAtual());
            lic.setDataVencimento(nd.dataAtual());
            daoLic.gravarLicenca(lic);
            daoLic.inserirDadosLogon(nd.dataAtual(), nd.addUmDia(nd.dataAtual()));
            new Alertas().mensagemConfirmacao("Sistema licenciado com sucesso!");
            verificarSeEstaLicenciado();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
