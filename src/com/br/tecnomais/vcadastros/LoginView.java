package com.br.tecnomais.vcadastros;

import Treads.Ajax;
import Treads.TelaInicialChamada;
import Treads.TelaLoadingAjax;
import br.com.daruma.jna.DUAL;
import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.Licenca;
import com.br.tecnomais.classes.ValidarCamposNumericos;
import com.br.tecnomais.dao.FilialDAO;
import com.br.tecnomais.dao.UsuarioDAO;
import com.br.tecnomais.entity.FilialEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import com.sun.awt.AWTUtilities;
import java.awt.AWTKeyStroke;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
import oracle.jrockit.jfr.parser.ChunkParser;

/**
 *
 * @author Usuario
 */
public class LoginView extends javax.swing.JFrame {

    private UsuarioDAO ud = new UsuarioDAO();
    private Integer id;
    private String usuario;
    private String senha;
    private String nome_usuario;
    private Integer nivel;
    private String foto;
    private ImageIcon image;
    FilialDAO dao = new FilialDAO();

//    static {
//        try {
//
//            System.loadLibrary("DarumaFramework");
//            System.out.println("Biblioteca carregada!!!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public LoginView() {
        this.setUndecorated(true);
        Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
        keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_F12, 0));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        initComponents();

        //lbLoading.setVisible(false);
//        lbLoading.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbFotoUsuario = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfFilial = new javax.swing.JTextField();
        lbFotoCadeado = new javax.swing.JLabel();
        lbFilial = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbLoading = new javax.swing.JLabel();
        tfNomeFilial = new javax.swing.JTextField();
        tfUsuarioNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        lbFotoUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSenhaFocusLost(evt);
            }
        });
        tfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSenhaActionPerformed(evt);
            }
        });
        tfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSenhaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuário");

        tfUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfUsuarioFocusLost(evt);
            }
        });
        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });
        tfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUsuarioKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Senha");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Filial");

        tfFilial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfFilial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfFilialFocusLost(evt);
            }
        });
        tfFilial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFilialActionPerformed(evt);
            }
        });
        tfFilial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFilialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFilialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFilialKeyTyped(evt);
            }
        });

        lbFotoCadeado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbFilial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFilial.setRequestFocusEnabled(false);
        lbFilial.setVerifyInputWhenFocusTarget(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/tecnomais logo sem fundo 2.png"))); // NOI18N

        lbLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/Pesquisa.png"))); // NOI18N

        tfNomeFilial.setFocusable(false);

        tfUsuarioNome.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
            .addComponent(lbLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbFotoCadeado, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(tfSenha)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfNomeFilial, tfUsuarioNome});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbFilial, lbFotoCadeado, lbFotoUsuario});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lbLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfFilial, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addComponent(tfNomeFilial))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUsuario)
                                .addComponent(tfUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbFotoCadeado, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSenhaActionPerformed
        buscaUsuario();
    }//GEN-LAST:event_tfSenhaActionPerformed

    private void tfUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsuarioFocusLost
//        mostraFotoUsuario();
    }//GEN-LAST:event_tfUsuarioFocusLost

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        mostraFotoUsuario();
    }//GEN-LAST:event_tfUsuarioActionPerformed

    private void tfFilialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFilialFocusLost
    }//GEN-LAST:event_tfFilialFocusLost

    private void tfFilialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFilialActionPerformed
        selecionaFilial();
    }//GEN-LAST:event_tfFilialActionPerformed

    private void tfSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSenhaFocusGained
        image = new ImageIcon("Logomarca/senha.png");
        Image img = image.getImage().getScaledInstance(lbFotoUsuario.getWidth(), lbFotoUsuario.getHeight(), Image.SCALE_SMOOTH);
        lbFotoCadeado.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_tfSenhaFocusGained

    private void tfSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSenhaFocusLost

    }//GEN-LAST:event_tfSenhaFocusLost

    private void tfFilialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFilialKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            selecionaFilial();
        }
    }//GEN-LAST:event_tfFilialKeyPressed

    private void tfFilialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFilialKeyReleased
//        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
//            selecionaFilial();
//        }
    }//GEN-LAST:event_tfFilialKeyReleased

    private void tfFilialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFilialKeyTyped
//        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
//            selecionaFilial();
//        }
    }//GEN-LAST:event_tfFilialKeyTyped

    private void tfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            mostraFotoUsuario();
        }
    }//GEN-LAST:event_tfUsuarioKeyPressed

    private void tfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            buscaUsuario();
        }
    }//GEN-LAST:event_tfSenhaKeyPressed

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
            java.util.logging.Logger.getLogger(LoginView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbFilial;
    private javax.swing.JLabel lbFotoCadeado;
    private javax.swing.JLabel lbFotoUsuario;
    private javax.swing.JLabel lbLoading;
    private javax.swing.JTextField tfFilial;
    private javax.swing.JTextField tfNomeFilial;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfUsuario;
    private javax.swing.JTextField tfUsuarioNome;
    // End of variables declaration//GEN-END:variables

    private void mostraFotoUsuario() {
        ValidarCamposNumericos vcn = new ValidarCamposNumericos();
        try {
            String aux = vcn.removerCaracteres(tfUsuario.getText());
            if (aux.equals("")) {
                aux = "0";
            }

            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setUsuario(tfUsuario.getText());
            usuario.setId(Integer.valueOf(aux));
            List<UsuarioEntity> uList = new ArrayList();
            uList = ud.listarUsuarioPorLogin(usuario);
            if (uList.size() > 0) {
                for (UsuarioEntity u : uList) {
                    if (u.getFoto() == null) {
                        image = new ImageIcon("FotoUsuario/123321fg54userUnknow123321.jpg");
                    } else {
                        image = new ImageIcon("FotoUsuario/" + u.getFoto());
                    }
                    Image img = image.getImage().getScaledInstance(lbFotoUsuario.getWidth(), lbFotoUsuario.getHeight(), Image.SCALE_SMOOTH);
                    lbFotoUsuario.setIcon(new ImageIcon(img));
                    tfUsuarioNome.setText(u.getUsuario());
                    tfSenha.requestFocus();
                }
            } else {
                new Alertas().mensagemAviso("Usuário inválido ou não existe");
                tfUsuario.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selecionaFilial() {
        try {
            int codigoPassado = 0;
            if (tfFilial.getText().isEmpty()) {
                // new Alertas().mensagemAviso("O campo filial esta vazio!");
                tfFilial.requestFocus();
            } else {
                codigoPassado = Integer.valueOf(tfFilial.getText());
            }

            if (dao.verificaFilila(codigoPassado) == true) {
                image = new ImageIcon("Logomarca/empresa.png");
                Image img = image.getImage().getScaledInstance(lbFotoUsuario.getWidth(), lbFotoUsuario.getHeight(), Image.SCALE_SMOOTH);
                lbFilial.setIcon(new ImageIcon(img));
                tfUsuario.requestFocus();
                FilialEntity fe = new FilialEntity();
                fe = dao.retornFilial();
                tfNomeFilial.setText(fe.getNome());
            } else {
                new Alertas().mensagemErro("Filial não encontrada!");
                tfFilial.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keyTyped(KeyEvent e) {
        if ((int) e.getKeyChar() == KeyEvent.VK_TAB) {
            System.out.println("Que legal!");
        }
    }

    private void buscaUsuario() {
        try {
            ValidarCamposNumericos vcn = new ValidarCamposNumericos();
            if (tfUsuario.getText().isEmpty() || tfSenha.getText().isEmpty()) {
                new Alertas().mensagemAviso("Preencha os campos usuário e senha!");
            } else {
                usuario = tfUsuario.getText();
                senha = tfSenha.getText();
                UsuarioEntity u = new UsuarioEntity();
                u.setUsuario(usuario);
                u.setSenha(senha);
                String aux = vcn.removerCaracteres(u.getUsuario());
                if (aux.equals("")) {
                    aux = "0";
                }
                u.setId(Integer.parseInt(aux));
                if (ud.logarSistema(u) == true) {
//                    image = new ImageIcon("Logomarca/ajax.gif");
//                    Image img = image.getImage().getScaledInstance(lbFotoUsuario.getWidth(), lbFotoUsuario.getHeight(), Image.SCALE_SMOOTH);
//                    lbLoading.setIcon(image);
                    TelaLoadingAjax barraDeProgresso = new TelaLoadingAjax();
                    barraDeProgresso.setaUsuario(u);
                    Thread threadDaBarra = new Thread(barraDeProgresso);
                    threadDaBarra.start();
//                    TelaInicialView2 ti = new TelaInicialView2(u);
//                    Thread startTela = new Thread(ti);
//                    startTela.start();
                    this.dispose();
                    Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
                    keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
//                    new TelaInicialView2(u).setVisible(true);
                } else {
                    new Alertas().mensagemErro("Usuário ou senha incorreta!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
