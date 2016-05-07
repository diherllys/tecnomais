package com.br.tecnomais.vcadastros;

//import br.com.daruma.jna.DUAL;
import br.com.daruma.jna.DUAL;
import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.dao.ImpressoraDarumaDAO;
import com.br.tecnomais.entity.ImpressoraDarumaEntity;
import com.br.tecnomais.entity.PermissoesEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import com.br.tecnomais.relatorios.RelatoriosCadastrosView;
import java.awt.Color;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class CadastrosView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();
    ImpressoraDarumaDAO ddao = new ImpressoraDarumaDAO();
    ImpressoraDarumaEntity ide = new ImpressoraDarumaEntity();
    PermissoesEntity p = new PermissoesEntity();

    UsuarioEntity u;
    NovaData data = new NovaData();

    public CadastrosView(UsuarioEntity u, PermissoesEntity p) {
        initComponents();
        this.u = u;
//        this.p = p;
//                if (u.getNivel() >= 2) {
//            permissaoFull();
//        }
        permissaoFull();
        try {
            ide = ddao.retornaIde();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        int iRetorno = DUAL.iImprimirTexto("TesteTesteTesteTesteTesteTesteTesteTeste o 0 <sl>"+ide.getNumSaltoLinhas()+"</sl><gui></gui>", 0);
//         int iRetorno2 = DUAL.iImprimirTexto("TesteTesteTesteTesteTesteTeste o 0 <sl>"+ide.getNumSaltoLinhas()+"</sl><gui></gui>", 0);
//          int iRetorno3 = DUAL.iImprimirTexto("TesteTesteTesteTeste o 0 <sl>"+ide.getNumSaltoLinhas()+"</sl><gui></gui>", 0);
//           int iRetorno4 = DUAL.iImprimirTexto("TesteTesteTesteTesteTeste o 0 <sl>"+ide.getNumSaltoLinhas()+"</sl><gui></gui>", 0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPainel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbFornecedor = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbClientes = new javax.swing.JLabel();
        lbAlgo2 = new javax.swing.JLabel();
        lbAlgo3 = new javax.swing.JLabel();
        lbAlgo4 = new javax.swing.JLabel();
        lbAlgo5 = new javax.swing.JLabel();
        lbCaixa = new javax.swing.JLabel();
        lbAlgo8 = new javax.swing.JLabel();
        lbRelatorios = new javax.swing.JLabel();
        lbProdutos = new javax.swing.JLabel();
        lbFilial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setResizable(false);

        jpPainel.setBackground(new java.awt.Color(200, 210, 210));
        jpPainel.setPreferredSize(new java.awt.Dimension(780, 400));

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        lbFornecedor.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/forne0003.png"))); // NOI18N
        lbFornecedor.setText("Fornecedor");
        lbFornecedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFornecedor.setOpaque(true);
        lbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFornecedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFornecedorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbFornecedorMousePressed(evt);
            }
        });

        lbUsuario.setBackground(new java.awt.Color(204, 204, 204));
        lbUsuario.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon user.png"))); // NOI18N
        lbUsuario.setText("Usuários");
        lbUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbUsuario.setOpaque(true);
        lbUsuario.setPreferredSize(new java.awt.Dimension(2, 2));
        lbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbUsuarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbUsuarioMousePressed(evt);
            }
        });

        lbClientes.setBackground(new java.awt.Color(204, 204, 204));
        lbClientes.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/clientes45.png"))); // NOI18N
        lbClientes.setText("Clientes");
        lbClientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClientes.setOpaque(true);
        lbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbClientesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbClientesMousePressed(evt);
            }
        });

        lbAlgo2.setBackground(new java.awt.Color(204, 204, 204));
        lbAlgo2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbAlgo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAlgo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlgo2.setOpaque(true);
        lbAlgo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlgo2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlgo2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAlgo2MousePressed(evt);
            }
        });

        lbAlgo3.setBackground(new java.awt.Color(204, 204, 204));
        lbAlgo3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbAlgo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAlgo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlgo3.setOpaque(true);
        lbAlgo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlgo3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlgo3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAlgo3MousePressed(evt);
            }
        });

        lbAlgo4.setBackground(new java.awt.Color(204, 204, 204));
        lbAlgo4.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbAlgo4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAlgo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlgo4.setOpaque(true);
        lbAlgo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlgo4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlgo4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAlgo4MousePressed(evt);
            }
        });

        lbAlgo5.setBackground(new java.awt.Color(204, 204, 204));
        lbAlgo5.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbAlgo5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAlgo5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlgo5.setOpaque(true);
        lbAlgo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlgo5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlgo5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAlgo5MousePressed(evt);
            }
        });

        lbCaixa.setBackground(new java.awt.Color(204, 204, 204));
        lbCaixa.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/caixa.png"))); // NOI18N
        lbCaixa.setText("Caixa");
        lbCaixa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCaixa.setOpaque(true);
        lbCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCaixaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCaixaMousePressed(evt);
            }
        });

        lbAlgo8.setBackground(new java.awt.Color(204, 204, 204));
        lbAlgo8.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbAlgo8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAlgo8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlgo8.setOpaque(true);
        lbAlgo8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlgo8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlgo8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAlgo8MousePressed(evt);
            }
        });

        lbRelatorios.setBackground(new java.awt.Color(204, 204, 204));
        lbRelatorios.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/relatorio cadastros 80x80px.png"))); // NOI18N
        lbRelatorios.setText("Relatórios");
        lbRelatorios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRelatorios.setOpaque(true);
        lbRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbRelatoriosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbRelatoriosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbRelatoriosMousePressed(evt);
            }
        });

        lbProdutos.setBackground(new java.awt.Color(204, 204, 204));
        lbProdutos.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icone-carga5854.png"))); // NOI18N
        lbProdutos.setText("Produtos");
        lbProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbProdutos.setOpaque(true);
        lbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbProdutosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbProdutosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbProdutosMousePressed(evt);
            }
        });

        lbFilial.setBackground(new java.awt.Color(204, 204, 204));
        lbFilial.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbFilial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/filial80x80.png"))); // NOI18N
        lbFilial.setText("Filial");
        lbFilial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbFilial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFilial.setOpaque(true);
        lbFilial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFilialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFilialMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbFilialMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpPainelLayout = new javax.swing.GroupLayout(jpPainel);
        jpPainel.setLayout(jpPainelLayout);
        jpPainelLayout.setHorizontalGroup(
            jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPainelLayout.createSequentialGroup()
                        .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPainelLayout.createSequentialGroup()
                        .addComponent(lbAlgo3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAlgo2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAlgo4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPainelLayout.createSequentialGroup()
                        .addComponent(lbAlgo5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAlgo8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpPainelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbAlgo2, lbAlgo3, lbAlgo4, lbAlgo5, lbAlgo8, lbCaixa, lbClientes, lbFornecedor, lbProdutos, lbRelatorios, lbUsuario});

        jpPainelLayout.setVerticalGroup(
            jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPainelLayout.createSequentialGroup()
                        .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbClientes)
                                .addComponent(lbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbAlgo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAlgo3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAlgo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAlgo8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAlgo5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpPainelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbAlgo2, lbAlgo3, lbAlgo4, lbAlgo5, lbAlgo8, lbCaixa, lbClientes, lbFornecedor, lbProdutos, lbRelatorios, lbUsuario});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPainel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1525, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPainel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(796, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUsuarioMouseEntered
        lbUsuario.setForeground(Color.red);
    }//GEN-LAST:event_lbUsuarioMouseEntered

    private void lbUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUsuarioMouseExited
        lbUsuario.setForeground(Color.black);
    }//GEN-LAST:event_lbUsuarioMouseExited

    private void lbUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUsuarioMousePressed
        if (p.getCadastro() == 1) {
            new PesquisaUsuarioView().setVisible(true);
        } else {
            new Alertas().mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbUsuarioMousePressed

    private void lbClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClientesMouseEntered
        lbClientes.setForeground(Color.red);
    }//GEN-LAST:event_lbClientesMouseEntered

    private void lbClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClientesMouseExited
        lbClientes.setForeground(Color.black);
    }//GEN-LAST:event_lbClientesMouseExited

    private void lbClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClientesMousePressed
        new PesquisaClienteView().setVisible(true);
    }//GEN-LAST:event_lbClientesMousePressed

    private void lbFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFornecedorMousePressed
        new PesquisaFornecedorView().setVisible(true);
    }//GEN-LAST:event_lbFornecedorMousePressed

    private void lbProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProdutosMousePressed
        new MenuProdutosView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbProdutosMousePressed

    private void lbFornecedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFornecedorMouseEntered
        lbFornecedor.setForeground(Color.red);
    }//GEN-LAST:event_lbFornecedorMouseEntered

    private void lbFornecedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFornecedorMouseExited
        lbFornecedor.setForeground(Color.black);
    }//GEN-LAST:event_lbFornecedorMouseExited

    private void lbProdutosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProdutosMouseEntered
        lbProdutos.setForeground(Color.red);
    }//GEN-LAST:event_lbProdutosMouseEntered

    private void lbProdutosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProdutosMouseExited
        lbProdutos.setForeground(Color.black);
    }//GEN-LAST:event_lbProdutosMouseExited

    private void lbAlgo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo2MouseEntered

    }//GEN-LAST:event_lbAlgo2MouseEntered

    private void lbAlgo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo2MouseExited

    }//GEN-LAST:event_lbAlgo2MouseExited

    private void lbAlgo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo2MousePressed

    }//GEN-LAST:event_lbAlgo2MousePressed

    private void lbAlgo3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo3MouseEntered

    }//GEN-LAST:event_lbAlgo3MouseEntered

    private void lbAlgo3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo3MouseExited

    }//GEN-LAST:event_lbAlgo3MouseExited

    private void lbAlgo3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo3MousePressed

    }//GEN-LAST:event_lbAlgo3MousePressed

    private void lbAlgo4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo4MouseEntered

    }//GEN-LAST:event_lbAlgo4MouseEntered

    private void lbAlgo4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo4MouseExited

    }//GEN-LAST:event_lbAlgo4MouseExited

    private void lbAlgo4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo4MousePressed

    }//GEN-LAST:event_lbAlgo4MousePressed

    private void lbAlgo5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo5MouseEntered

    }//GEN-LAST:event_lbAlgo5MouseEntered

    private void lbAlgo5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo5MouseExited

    }//GEN-LAST:event_lbAlgo5MouseExited

    private void lbAlgo5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo5MousePressed

    }//GEN-LAST:event_lbAlgo5MousePressed

    private void lbCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCaixaMouseEntered
        lbCaixa.setForeground(Color.red);
    }//GEN-LAST:event_lbCaixaMouseEntered

    private void lbCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCaixaMouseExited
        lbCaixa.setForeground(Color.black);
    }//GEN-LAST:event_lbCaixaMouseExited

    private void lbCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCaixaMousePressed
        if (p.getCadastro() == 1) {
            new CaixaView().setVisible(true);
        } else {
            new Alertas().mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbCaixaMousePressed

    private void lbAlgo8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MouseEntered

    }//GEN-LAST:event_lbAlgo8MouseEntered

    private void lbAlgo8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MouseExited

    }//GEN-LAST:event_lbAlgo8MouseExited

    private void lbAlgo8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MousePressed

    }//GEN-LAST:event_lbAlgo8MousePressed

    private void lbRelatoriosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMouseEntered
        lbRelatorios.setForeground(Color.red);
    }//GEN-LAST:event_lbRelatoriosMouseEntered

    private void lbRelatoriosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMouseExited
        lbRelatorios.setForeground(Color.black);
    }//GEN-LAST:event_lbRelatoriosMouseExited

    private void lbRelatoriosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMousePressed
        if (p.getCadastro() == 1) {
            new RelatoriosCadastrosView(u).setVisible(true);
        } else {
            new Alertas().mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbRelatoriosMousePressed

    private void lbFilialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilialMouseEntered
        lbFilial.setForeground(Color.red);
    }//GEN-LAST:event_lbFilialMouseEntered

    private void lbFilialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilialMouseExited
        lbFilial.setForeground(Color.black);
    }//GEN-LAST:event_lbFilialMouseExited

    private void lbFilialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilialMousePressed
        if (p.getCadastroFilial() == 1) {
            new PesquisaFilialView().setVisible(true);
        } else {
            new Alertas().mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbFilialMousePressed

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
            java.util.logging.Logger.getLogger(CadastrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrosView(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpPainel;
    private javax.swing.JLabel lbAlgo2;
    private javax.swing.JLabel lbAlgo3;
    private javax.swing.JLabel lbAlgo4;
    private javax.swing.JLabel lbAlgo5;
    private javax.swing.JLabel lbAlgo8;
    private javax.swing.JLabel lbCaixa;
    private javax.swing.JLabel lbClientes;
    private javax.swing.JLabel lbFilial;
    private javax.swing.JLabel lbFornecedor;
    private javax.swing.JLabel lbProdutos;
    private javax.swing.JLabel lbRelatorios;
    private javax.swing.JLabel lbUsuario;
    // End of variables declaration//GEN-END:variables

    public void cotroleUsuarioCadView() {

    }

    public void permissaoFull() {
        p.setCadastro(1);
        p.setCadastroFilial(1);
        p.setCadastroUsuario(1);
        p.setConfigurarImp(1);
        p.setConfigurarLogo(1);
        p.setConfigurarPerm(1);
        p.setEscritorio(1);
        p.setMovContRecbPagFlxCaixa(1);
        p.setMovimentacao(1);
    }
}
