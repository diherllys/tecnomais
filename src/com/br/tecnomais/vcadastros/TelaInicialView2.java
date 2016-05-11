package com.br.tecnomais.vcadastros;

import br.com.daruma.jna.DUAL;
import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.*;
import com.br.tecnomais.entity.*;
import com.br.tecnomais.vescritorio.EscritorioView;
import com.br.tecnomais.vmovimentacao.MovimentacaoView;
import com.br.tecnomais.vconfiguracao.ConfiguracaoView;
import com.br.tecnomais.vconfiguracao.SuportView;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Tecnomais
 */
public class TelaInicialView2 extends javax.swing.JFrame implements Runnable {

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

    public TelaInicialView2(UsuarioEntity u) {
        Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
        keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        initComponents();
        backup();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.u = u;
        notificacoes();
        //   permissaoFull();
        setarLogo();
        // impressoraDaruma();
//        int tRetorno = DUAL.regTermica("1");//sempre 1 
//        int pRetorno = DUAL.regPortaComunicacao("USB");//porta de comunicação
//        int vRetorno = DUAL.regVelocidade("115200");
//
//        int tRetorno = DUAL.regTermica("1");
//        int iRetorno = DUAL.eBuscarPortaVelocidade();
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

        lbLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tecnomais");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
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

        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbLogoKeyPressed(evt);
            }
        });

        jMenuBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuBar1KeyPressed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/newCad.png"))); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/newMov.png"))); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/newConfig.png"))); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu4MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/newEscritorio.png"))); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu5MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/newSuporte.png"))); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu6MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
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
                Logger.getLogger(TelaInicialView2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();
            p = permDAO.buscaPerm(u.getId());

            if (p.getCadastro() == 1 || p.getCadastroFilial() == 1 || p.getCadastroUsuario() == 1) {
                new CadastrosView(u, p).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();
            p = permDAO.buscaPerm(u.getId());
            if (p.getMovimentacao() == 1 || p.getMovContRecbPagFlxCaixa() == 1) {
                new MovimentacaoView(u, p).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();

            p = permDAO.buscaPerm(u.getId());

            if (p.getConfigurarImp() == 1 || p.getConfigurarLogo() == 1 || p.getConfigurarPerm() == 1) {
                new ConfiguracaoView(u, p).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu4MousePressed

    private void jMenu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MousePressed
        try {
            PermissoesEntity p = new PermissoesEntity();
            p = permDAO.buscaPerm(u.getId());
            if (p.getEscritorio() == 1) {
                new EscritorioView(u).setVisible(true);
            } else {
                alerta.mensagemAviso("Você não tem permissão de acesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialView2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu5MousePressed

    private void jMenu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MousePressed
        new SuportView().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6MousePressed

    private void lbLogoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbLogoKeyPressed
       
    }//GEN-LAST:event_lbLogoKeyPressed

    private void jMenuBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuBar1KeyPressed
      
    }//GEN-LAST:event_jMenuBar1KeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     
    }//GEN-LAST:event_formWindowActivated

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicialView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialView2(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbLogo;
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
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int tam = (int) d.getWidth();
        int width = tam;
        int height = (int) d.getHeight() - 105;
        System.out.println(tam);

        image = new ImageIcon("Logomarca/logo-oficial 5.jpg");

        Image img = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lbLogo.setIcon(new ImageIcon(img));
    }

    @Override
    public void run() {
        this.setVisible(true);
    }

    private void atalhos(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            new Alertas().mensagemConfirmacao("Desenvolvido por Diherllys Lima Leal e Powered by Reginaldo Candido, diherllys@gmail.com (88) 9-99840013");
        }
    }
}
