package com.br.tecnomais.vcadastros;

import br.com.daruma.jna.DUAL;
import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.*;
import com.br.tecnomais.entity.*;
import com.br.tecnomais.vconfiguracao2.ConfiguracoesView;
import com.br.tecnomais.vescritorio.EscritorioView;
import com.br.tecnomais.vmovimentacao.MovimentacaoView;
import com.br.tecnomais.vconfiguracao.ConfiguracaoView;
import com.br.tecnomais.vconfiguracao.SuportView;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Tecnomais
 */
public class TelaInicialView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();
    private UsuarioEntity u;
    BackupDAO dao = new BackupDAO();
    NovaData dataAtual = new NovaData();
    String data = dataAtual.dataAtual();
    Integer hora = Integer.valueOf(new SimpleDateFormat("HHmm").format(new Date(System.currentTimeMillis())));
    ImpressoraDarumaDAO ddao = new ImpressoraDarumaDAO();
    ImpressoraDarumaEntity ide = new ImpressoraDarumaEntity();
    ImpressoraPadraoDAO ipd = new ImpressoraPadraoDAO();
    PermissoesDAO permDAO = new PermissoesDAO();
    PermissoesEntity p = new PermissoesEntity();
    private ImageIcon image;

    public TelaInicialView(UsuarioEntity u) {
        initComponents();
        backup();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.u = u;
        notificacoes();
        String impAtual;
        permissaoFull();
        setarLogo();

        int iRetorno = DUAL.eBuscarPortaVelocidade();

//        try {
//            impAtual = ipd.retornaImpAtual();
//            if (impAtual.equals("ImpressoraDaruma")) {
//                impressoraDaruma();
//            } else {
//                impressoraBematch();
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbConfiguracao = new javax.swing.JLabel();
        lbSuporte = new javax.swing.JLabel();
        lbOutros = new javax.swing.JLabel();
        lbEscritorio = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tecnomais");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(200, 210, 210));

        jPanel1.setBackground(new java.awt.Color(210, 220, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icone_cadastro.jpg"))); // NOI18N
        jLabel1.setToolTipText("Cadastros");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/movimentação.png"))); // NOI18N
        jLabel2.setToolTipText("Movimentações");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        lbConfiguracao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/livro de ponto 80x80 - Editado2.png"))); // NOI18N
        lbConfiguracao.setToolTipText("Configurações");
        lbConfiguracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbConfiguracao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbConfiguracao.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbConfiguracaoMouseMoved(evt);
            }
        });
        lbConfiguracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbConfiguracaoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbConfiguracaoMousePressed(evt);
            }
        });

        lbSuporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSuporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/suportWoman100x100.png"))); // NOI18N
        lbSuporte.setToolTipText("Suporte");
        lbSuporte.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSuporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSuporte.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbSuporteMouseMoved(evt);
            }
        });
        lbSuporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSuporteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbSuporteMousePressed(evt);
            }
        });

        lbOutros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/configuracao2000.png"))); // NOI18N
        lbOutros.setText("<html> <marquee>Fazer Texto Ficar Passando</marquee>");
        lbOutros.setToolTipText("Configurações");
        lbOutros.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbOutros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbOutros.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbOutrosMouseMoved(evt);
            }
        });
        lbOutros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbOutrosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbOutrosMousePressed(evt);
            }
        });

        lbEscritorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEscritorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/escritorio 100x100 vermelho.png"))); // NOI18N
        lbEscritorio.setToolTipText("Escritório");
        lbEscritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbEscritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEscritorio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbEscritorioMouseMoved(evt);
            }
        });
        lbEscritorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbEscritorioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbEscritorioMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEscritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSuporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSuporte, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int op = JOptionPane.showConfirmDialog(null, "Deseja realmente encerrar o sistema?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (op == JOptionPane.YES_OPTION) {
            try {
                if (dao.opcaoDeBackupAtual().equals("Fazer Backup na Saída")) {
                    dao.fazBackup("tecnomais" + data.replace("/", "-") + "-" + hora + ".bak");
                }
                System.exit(0);
            } catch (SQLException ex) {
                Logger.getLogger(TelaInicialView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();
            if (u.getNivel() == 1) {
                p = permDAO.buscaPerm(u.getId());
            } else {
                p = this.p;
            }

            if (p.getMovimentacao() == 1 || p.getMovContRecbPagFlxCaixa() == 1) {
                new MovimentacaoView(u, p).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();
            if (u.getNivel() == 1) {
                p = permDAO.buscaPerm(u.getId());
            } else {
                permissaoFull();
                p = this.p;
            }
            if (p.getCadastro() == 1 || p.getCadastroFilial() == 1 || p.getCadastroUsuario() == 1) {
                new CadastrosView(u, p).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved
        jLabel1.setBackground(Color.gray);
    }//GEN-LAST:event_jLabel1MouseMoved

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBackground(Color.lightGray);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
        jLabel2.setBackground(Color.gray);
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setBackground(Color.lightGray);
    }//GEN-LAST:event_jLabel2MouseExited

    private void lbConfiguracaoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConfiguracaoMouseMoved
        lbConfiguracao.setBackground(Color.gray);
    }//GEN-LAST:event_lbConfiguracaoMouseMoved

    private void lbConfiguracaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConfiguracaoMouseExited
        lbConfiguracao.setBackground(Color.lightGray);
    }//GEN-LAST:event_lbConfiguracaoMouseExited

    private void lbConfiguracaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConfiguracaoMousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();
            if (u.getNivel() == 1) {
                p = permDAO.buscaPerm(u.getId());
            } else {
                p = this.p;
            }
            if (p.getConfigurarImp() == 1 || p.getCadastroFilial() == 1 || p.getCadastroUsuario() == 1) {
                new ConfiguracoesView(u).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbConfiguracaoMousePressed

    private void lbSuporteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSuporteMouseMoved
        lbSuporte.setBackground(Color.gray);
    }//GEN-LAST:event_lbSuporteMouseMoved

    private void lbSuporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSuporteMouseExited
        lbSuporte.setBackground(Color.lightGray);
    }//GEN-LAST:event_lbSuporteMouseExited

    private void lbSuporteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSuporteMousePressed
        new SuportView().setVisible(true);
    }//GEN-LAST:event_lbSuporteMousePressed

    private void lbOutrosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOutrosMouseMoved
        lbOutros.setBackground(Color.gray);
    }//GEN-LAST:event_lbOutrosMouseMoved

    private void lbOutrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOutrosMouseExited
        lbOutros.setBackground(Color.lightGray);
    }//GEN-LAST:event_lbOutrosMouseExited

    private void lbOutrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOutrosMousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();
            if (u.getNivel() == 1) {
                p = permDAO.buscaPerm(u.getId());
            } else {
                p = this.p;
            }
            if (p.getConfigurarImp() == 1 || p.getConfigurarLogo() == 1 || p.getConfigurarPerm() == 1) {
                new ConfiguracaoView(u, p).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbOutrosMousePressed

    private void lbEscritorioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEscritorioMouseMoved
        lbEscritorio.setBackground(Color.gray);
    }//GEN-LAST:event_lbEscritorioMouseMoved

    private void lbEscritorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEscritorioMouseExited
        lbEscritorio.setBackground(Color.lightGray);
    }//GEN-LAST:event_lbEscritorioMouseExited

    private void lbEscritorioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEscritorioMousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();
            if (u.getNivel() == 1) {
                p = permDAO.buscaPerm(u.getId());
            } else {
                p = this.p;
            }
            if (p.getEscritorio() == 1) {
                new EscritorioView(u).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbEscritorioMousePressed

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
            java.util.logging.Logger.getLogger(TelaInicialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbConfiguracao;
    private javax.swing.JLabel lbEscritorio;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbOutros;
    private javax.swing.JLabel lbSuporte;
    // End of variables declaration//GEN-END:variables

    private void notificacoes() {
        for (int i = 0; i < 10; i++) {

        }
    }

    private void backup() {
        try {
            if (dao.opcaoDeBackupAtual().equals("Fazer Backup na Entrada e na Saída") || dao.opcaoDeBackupAtual().equals("Fazer Backup na Entrada")) {
                dao.fazBackup("tecnomais" + data.replace("/", "-") + "-" + hora + ".bak");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void impressoraDaruma() {
        try {
            ide = ddao.retornaIde();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        int pRetorno = DUAL.regPortaComunicacao(ide.getPortaComunicacao());
        int pvRetorno = DUAL.regVelocidade(ide.getPortaVelocidade());
        // int qlRetorno = DUAL.regEnterFinal("1");// 1 para quebra de linha e 0 para desabilitar
        int cGRetorno = DUAL.iConfigurarGuilhotina(Integer.parseInt(ide.getStatusGuilhotina()),
                Integer.parseInt(ide.getTamanhoGuilhotina()));
        int cG2Retorno = DUAL.regLinhasGuilhotina(ide.getTamanhoGuilhotina());
        int zRetorno = DUAL.regZeroCortado(ide.getZeroCortadoStatus());

//         int pRetorno = DUAL.regPortaComunicacao("COM1"); //(ide.getPortaComunicacao());//porta de comunicação
//        int vRetorno = DUAL.regVelocidade(ide.getPortaVelocidade());// velocidade da porta utilziada
//         System.out.println("works");
        // int dsadas = DUAL.iLimparBuffer();
        // int da2 = DUAL.iReinicializar();
//        int d1 = DUAL.rStatusImpressora();
//        System.out.println("status " + d1);
//    //    int la = DUAL.eBuscarPortaVelocidade();
//        System.out.println("status2 " + d1);
        // int tRetorno = DUAL.regTermica(ide.getRegistroTermico());//sempre 1 
        //int gRetorno = DUAL.regLinhasGuilhotina(ide.getTamanhoGuilhotina());
//       / System.out.println("status3 " + d1);
    }

    private void impressoraBematch() {
        JOptionPane.showMessageDialog(null, "Ainda não esta implementado, aguarde nova versão");
    }

    public void permissaoFull() {
        this.p.setCadastro(1);
        this.p.setCadastroFilial(1);
        this.p.setCadastroUsuario(1);
        this.p.setConfigurarImp(1);
        this.p.setConfigurarLogo(1);
        this.p.setConfigurarPerm(1);
        this.p.setEscritorio(1);
        this.p.setMovContRecbPagFlxCaixa(1);
        this.p.setMovimentacao(1);
    }

    public void setarLogo() {
        lbLogo.setSize(1105, 685);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int tam = (int) d.getWidth();
        int width = lbLogo.getWidth();
        int height = lbLogo.getHeight();
        System.out.println(tam);
        if (tam > 1280) {
            image = new ImageIcon("Logomarca/logo-inicial5.jpg");
        } else {
            image = new ImageIcon("Logomarca/logo-inicial3.jpg");
            height = 638;
        }
        Image img = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lbLogo.setIcon(new ImageIcon(img));
    }
}
