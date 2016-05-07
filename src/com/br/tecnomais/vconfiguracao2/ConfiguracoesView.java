package com.br.tecnomais.vconfiguracao2;

import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.entity.UsuarioEntity;
import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class ConfiguracoesView extends javax.swing.JFrame {

    UsuarioEntity u;
    NovaData data = new NovaData();

    public ConfiguracoesView(UsuarioEntity u) {
        initComponents();
//        setExtendedState(MAXIMIZED_BOTH);
        this.u = u;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPainel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbProdutos = new javax.swing.JLabel();
        lbFornecedor = new javax.swing.JLabel();
        lbOperacao = new javax.swing.JLabel();
        lbOperacoesDeSaida = new javax.swing.JLabel();
        lbAlgo2 = new javax.swing.JLabel();
        lbAlgo3 = new javax.swing.JLabel();
        lbAlgo4 = new javax.swing.JLabel();
        lbAlgo5 = new javax.swing.JLabel();
        lbAlgo6 = new javax.swing.JLabel();
        lbAlgo8 = new javax.swing.JLabel();
        lbAlgo9 = new javax.swing.JLabel();
        lbFilial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setResizable(false);

        jpPainel.setBackground(new java.awt.Color(200, 210, 210));

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        lbProdutos.setBackground(new java.awt.Color(204, 204, 204));
        lbProdutos.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
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

        lbFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        lbFornecedor.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
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

        lbOperacao.setBackground(new java.awt.Color(204, 204, 204));
        lbOperacao.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbOperacao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbOperacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/operacao-entrada 80x80.png"))); // NOI18N
        lbOperacao.setText("<html>Operações<p> de Entrada");
        lbOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbOperacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbOperacao.setOpaque(true);
        lbOperacao.setPreferredSize(new java.awt.Dimension(2, 2));
        lbOperacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbOperacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbOperacaoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbOperacaoMousePressed(evt);
            }
        });

        lbOperacoesDeSaida.setBackground(new java.awt.Color(204, 204, 204));
        lbOperacoesDeSaida.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbOperacoesDeSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/operacao-saida 80x80.png"))); // NOI18N
        lbOperacoesDeSaida.setText("<html>Operações<p> de Saida");
        lbOperacoesDeSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbOperacoesDeSaida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbOperacoesDeSaida.setOpaque(true);
        lbOperacoesDeSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbOperacoesDeSaidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbOperacoesDeSaidaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbOperacoesDeSaidaMousePressed(evt);
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

        lbAlgo6.setBackground(new java.awt.Color(204, 204, 204));
        lbAlgo6.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbAlgo6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAlgo6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlgo6.setOpaque(true);
        lbAlgo6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlgo6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlgo6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAlgo6MousePressed(evt);
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

        lbAlgo9.setBackground(new java.awt.Color(204, 204, 204));
        lbAlgo9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbAlgo9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAlgo9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlgo9.setOpaque(true);
        lbAlgo9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlgo9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlgo9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAlgo9MousePressed(evt);
            }
        });

        lbFilial.setBackground(new java.awt.Color(204, 204, 204));
        lbFilial.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbOperacoesDeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAlgo6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbAlgo3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAlgo2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAlgo4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbAlgo5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAlgo8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAlgo9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbAlgo2, lbAlgo3, lbAlgo4, lbAlgo5, lbAlgo6, lbAlgo8, lbAlgo9, lbFornecedor, lbOperacao, lbOperacoesDeSaida, lbProdutos});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbOperacoesDeSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlgo6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFilial, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlgo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlgo3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlgo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlgo5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlgo8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlgo9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbAlgo2, lbAlgo3, lbAlgo4, lbAlgo5, lbAlgo6, lbAlgo8, lbAlgo9, lbFornecedor, lbOperacao, lbOperacoesDeSaida, lbProdutos});

        javax.swing.GroupLayout jpPainelLayout = new javax.swing.GroupLayout(jpPainel);
        jpPainel.setLayout(jpPainelLayout);
        jpPainelLayout.setHorizontalGroup(
            jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpPainelLayout.setVerticalGroup(
            jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPainel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPainel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbOperacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOperacaoMouseEntered
        lbOperacao.setForeground(Color.red);
    }//GEN-LAST:event_lbOperacaoMouseEntered

    private void lbOperacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOperacaoMouseExited
        lbOperacao.setForeground(Color.black);
    }//GEN-LAST:event_lbOperacaoMouseExited

    private void lbOperacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOperacaoMousePressed
        new PesquisaOperacaoView().setVisible(true);
    }//GEN-LAST:event_lbOperacaoMousePressed

    private void lbOperacoesDeSaidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOperacoesDeSaidaMouseEntered
        lbOperacoesDeSaida.setForeground(Color.red);
    }//GEN-LAST:event_lbOperacoesDeSaidaMouseEntered

    private void lbOperacoesDeSaidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOperacoesDeSaidaMouseExited
        lbOperacoesDeSaida.setForeground(Color.black);
    }//GEN-LAST:event_lbOperacoesDeSaidaMouseExited

    private void lbOperacoesDeSaidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOperacoesDeSaidaMousePressed
        new OperacaoDeSaidaView(null,false).setVisible(true);
    }//GEN-LAST:event_lbOperacoesDeSaidaMousePressed

    private void lbFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFornecedorMousePressed
        
    }//GEN-LAST:event_lbFornecedorMousePressed

    private void lbProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProdutosMousePressed
       
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
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo2MouseEntered

    private void lbAlgo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo2MouseExited

    private void lbAlgo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo2MousePressed

    private void lbAlgo3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo3MouseEntered

    private void lbAlgo3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo3MouseExited

    private void lbAlgo3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo3MousePressed

    private void lbAlgo4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo4MouseEntered

    private void lbAlgo4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo4MouseExited

    private void lbAlgo4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo4MousePressed

    private void lbAlgo5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo5MouseEntered

    private void lbAlgo5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo5MouseExited

    private void lbAlgo5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo5MousePressed

    private void lbAlgo6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo6MouseEntered

    private void lbAlgo6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo6MouseExited

    private void lbAlgo6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo6MousePressed

    private void lbAlgo8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo8MouseEntered

    private void lbAlgo8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo8MouseExited

    private void lbAlgo8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo8MousePressed

    private void lbAlgo9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo9MouseEntered

    private void lbAlgo9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo9MouseExited

    private void lbAlgo9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo9MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo9MousePressed

    private void lbFilialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilialMouseEntered
        lbFilial.setForeground(Color.red);
    }//GEN-LAST:event_lbFilialMouseEntered

    private void lbFilialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilialMouseExited
        lbFilial.setForeground(Color.black);
    }//GEN-LAST:event_lbFilialMouseExited

    private void lbFilialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilialMousePressed
       
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
            java.util.logging.Logger.getLogger(ConfiguracoesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfiguracoesView(null).setVisible(true);
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
    private javax.swing.JLabel lbAlgo6;
    private javax.swing.JLabel lbAlgo8;
    private javax.swing.JLabel lbAlgo9;
    private javax.swing.JLabel lbFilial;
    private javax.swing.JLabel lbFornecedor;
    private javax.swing.JLabel lbOperacao;
    private javax.swing.JLabel lbOperacoesDeSaida;
    private javax.swing.JLabel lbProdutos;
    // End of variables declaration//GEN-END:variables

}
