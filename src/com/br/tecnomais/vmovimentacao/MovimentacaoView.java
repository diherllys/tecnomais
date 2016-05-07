package com.br.tecnomais.vmovimentacao;
import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.NovaData;
import com.br.tecnomais.entity.PermissoesEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import com.br.tecnomais.relatorios.RelatoriosMovimentacaoView;
import java.awt.Color;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class MovimentacaoView extends javax.swing.JFrame {

    Alertas alerta = new Alertas();
    UsuarioEntity u;
    NovaData data = new NovaData();
    PermissoesEntity p = new PermissoesEntity();

    public MovimentacaoView(UsuarioEntity u, PermissoesEntity p) {
        initComponents();
        centralizar();
        this.u = u;
        this.p = p;
//      //        this.p = p;
//                if (u.getNivel() >= 2) {
//            permissaoFull();
//        }
        //permissaoFull();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPainel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbConsultarSaida = new javax.swing.JLabel();
        lbSaida = new javax.swing.JLabel();
        lbEntrada = new javax.swing.JLabel();
        lbAlgo2 = new javax.swing.JLabel();
        lbAlgo3 = new javax.swing.JLabel();
        lbAlgo4 = new javax.swing.JLabel();
        lbAlgo5 = new javax.swing.JLabel();
        lbFluxoCaixa = new javax.swing.JLabel();
        lbAlgo8 = new javax.swing.JLabel();
        lbContasPagar = new javax.swing.JLabel();
        lbContasReceber = new javax.swing.JLabel();
        lbRelatorios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setResizable(false);

        jpPainel.setBackground(new java.awt.Color(200, 210, 210));

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        lbConsultarSaida.setBackground(new java.awt.Color(204, 204, 204));
        lbConsultarSaida.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbConsultarSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/consultasaida.png"))); // NOI18N
        lbConsultarSaida.setText("<html>Consultar<p>Saída");
        lbConsultarSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbConsultarSaida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbConsultarSaida.setOpaque(true);
        lbConsultarSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbConsultarSaidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbConsultarSaidaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbConsultarSaidaMousePressed(evt);
            }
        });

        lbSaida.setBackground(new java.awt.Color(204, 204, 204));
        lbSaida.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/saida.png"))); // NOI18N
        lbSaida.setText("Saída");
        lbSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbSaida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSaida.setOpaque(true);
        lbSaida.setPreferredSize(new java.awt.Dimension(2, 2));
        lbSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSaidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSaidaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbSaidaMousePressed(evt);
            }
        });

        lbEntrada.setBackground(new java.awt.Color(204, 204, 204));
        lbEntrada.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/icon-entrada.png"))); // NOI18N
        lbEntrada.setText("Entrada");
        lbEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEntrada.setOpaque(true);
        lbEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbEntradaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbEntradaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbEntradaMousePressed(evt);
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

        lbFluxoCaixa.setBackground(new java.awt.Color(204, 204, 204));
        lbFluxoCaixa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbFluxoCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/fluxoCaixa 80x80.png"))); // NOI18N
        lbFluxoCaixa.setText("Fluxo de Caixa");
        lbFluxoCaixa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbFluxoCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFluxoCaixa.setOpaque(true);
        lbFluxoCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFluxoCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFluxoCaixaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbFluxoCaixaMousePressed(evt);
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

        lbContasPagar.setBackground(new java.awt.Color(204, 204, 204));
        lbContasPagar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbContasPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/contasPagar 80x80.png"))); // NOI18N
        lbContasPagar.setText("<html>Contas<p>Pagar");
        lbContasPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbContasPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbContasPagar.setOpaque(true);
        lbContasPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbContasPagarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbContasPagarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbContasPagarMousePressed(evt);
            }
        });

        lbContasReceber.setBackground(new java.awt.Color(204, 204, 204));
        lbContasReceber.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbContasReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/tecnomais/images/contasreceber.png"))); // NOI18N
        lbContasReceber.setText("<html>Contas<p>Receber");
        lbContasReceber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbContasReceber.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbContasReceber.setOpaque(true);
        lbContasReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbContasReceberMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbContasReceberMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbContasReceberMousePressed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbConsultarSaida)
                            .addComponent(lbSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbContasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFluxoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(lbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbAlgo2, lbAlgo3, lbAlgo4, lbAlgo5, lbAlgo8, lbConsultarSaida, lbContasReceber, lbEntrada, lbFluxoCaixa, lbRelatorios, lbSaida});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEntrada)
                    .addComponent(lbSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFluxoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbConsultarSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbContasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlgo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlgo3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlgo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbAlgo5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAlgo8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbAlgo2, lbAlgo3, lbAlgo4, lbAlgo5, lbAlgo8, lbConsultarSaida, lbContasReceber, lbEntrada, lbFluxoCaixa, lbRelatorios, lbSaida});

        javax.swing.GroupLayout jpPainelLayout = new javax.swing.GroupLayout(jpPainel);
        jpPainel.setLayout(jpPainelLayout);
        jpPainelLayout.setHorizontalGroup(
            jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpPainelLayout.setVerticalGroup(
            jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelLayout.createSequentialGroup()
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

    private void lbSaidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSaidaMouseEntered
        lbSaida.setForeground(Color.red);
    }//GEN-LAST:event_lbSaidaMouseEntered

    private void lbSaidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSaidaMouseExited
        lbSaida.setForeground(Color.black);
    }//GEN-LAST:event_lbSaidaMouseExited

    private void lbSaidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSaidaMousePressed
        if (p.getMovimentacao() == 1) {
            new InicializaSaidaView().setVisible(true);
        } else {
            alerta.mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbSaidaMousePressed

    private void lbEntradaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEntradaMouseEntered
        lbEntrada.setForeground(Color.red);
    }//GEN-LAST:event_lbEntradaMouseEntered

    private void lbEntradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEntradaMouseExited
        lbEntrada.setForeground(Color.black);
    }//GEN-LAST:event_lbEntradaMouseExited

    private void lbConsultarSaidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConsultarSaidaMouseEntered
        lbConsultarSaida.setForeground(Color.red);
    }//GEN-LAST:event_lbConsultarSaidaMouseEntered

    private void lbConsultarSaidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConsultarSaidaMouseExited
        lbConsultarSaida.setForeground(Color.black);
    }//GEN-LAST:event_lbConsultarSaidaMouseExited

    private void lbContasReceberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContasReceberMouseEntered
        lbContasReceber.setForeground(Color.red);
    }//GEN-LAST:event_lbContasReceberMouseEntered

    private void lbContasReceberMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContasReceberMouseExited
        lbContasReceber.setForeground(Color.black);
    }//GEN-LAST:event_lbContasReceberMouseExited

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

    private void lbFluxoCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFluxoCaixaMouseEntered
        lbFluxoCaixa.setForeground(Color.red);
    }//GEN-LAST:event_lbFluxoCaixaMouseEntered

    private void lbFluxoCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFluxoCaixaMouseExited
        lbFluxoCaixa.setForeground(Color.black);
    }//GEN-LAST:event_lbFluxoCaixaMouseExited

    private void lbFluxoCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFluxoCaixaMousePressed
        if (p.getMovContRecbPagFlxCaixa() == 1) {
            new FluxoMovimentacao().setVisible(true);
        } else {
            alerta.mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbFluxoCaixaMousePressed

    private void lbAlgo8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo8MouseEntered

    private void lbAlgo8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo8MouseExited

    private void lbAlgo8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgo8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAlgo8MousePressed

    private void lbContasPagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContasPagarMouseEntered
        lbContasPagar.setForeground(Color.red);
    }//GEN-LAST:event_lbContasPagarMouseEntered

    private void lbContasPagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContasPagarMouseExited
        lbContasPagar.setForeground(Color.black);
    }//GEN-LAST:event_lbContasPagarMouseExited

    private void lbContasPagarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContasPagarMousePressed
        if (p.getMovContRecbPagFlxCaixa() == 1) {
            new ContasApagar(0, u).setVisible(true);
        } else {
            alerta.mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbContasPagarMousePressed

    private void lbEntradaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEntradaMousePressed
        if (p.getMovimentacao() == 1) {
            new InicializaEntradaView(u).setVisible(true);
        } else {
            alerta.mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbEntradaMousePressed

    private void lbContasReceberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContasReceberMousePressed
        if (p.getMovContRecbPagFlxCaixa() == 1) {
            new BuscaClienteContasView().setVisible(true);
        } else {
            alerta.mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbContasReceberMousePressed

    private void lbConsultarSaidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConsultarSaidaMousePressed
        if (p.getMovimentacao() == 1) {
            new SaidasView().setVisible(true);
        } else {
            alerta.mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbConsultarSaidaMousePressed

    private void lbRelatoriosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMouseEntered
        lbRelatorios.setForeground(Color.red);
    }//GEN-LAST:event_lbRelatoriosMouseEntered

    private void lbRelatoriosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMouseExited
        lbRelatorios.setForeground(Color.black);
    }//GEN-LAST:event_lbRelatoriosMouseExited

    private void lbRelatoriosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMousePressed
        if (p.getMovContRecbPagFlxCaixa() == 1 && p.getMovimentacao() == 1) {
            new RelatoriosMovimentacaoView(u).setVisible(true);
        } else {
            new Alertas().mensagemAviso("Você não tem permissão de acesso!");
        }
    }//GEN-LAST:event_lbRelatoriosMousePressed

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
            java.util.logging.Logger.getLogger(MovimentacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimentacaoView(null, null).setVisible(true);
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
    private javax.swing.JLabel lbConsultarSaida;
    private javax.swing.JLabel lbContasPagar;
    private javax.swing.JLabel lbContasReceber;
    private javax.swing.JLabel lbEntrada;
    private javax.swing.JLabel lbFluxoCaixa;
    private javax.swing.JLabel lbRelatorios;
    private javax.swing.JLabel lbSaida;
    // End of variables declaration//GEN-END:variables

    private void centralizar() {

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
