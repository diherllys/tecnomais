package com.br.tecnomais.vcadastros;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.ConvertToMaiuscula;
import com.br.tecnomais.classes.Dinheiro;
import com.br.tecnomais.classes.ValidarCamposNumericos;
import com.br.tecnomais.dao.ClasseDAO;
import com.br.tecnomais.dao.ProdutoDAO;
import com.br.tecnomais.dao.ProdutosVendaDAO;
import com.br.tecnomais.dao.UnidadeVendaDAO;
import com.br.tecnomais.entity.ClasseProdutoEntity;
import com.br.tecnomais.entity.ProdutoEntity;
import com.br.tecnomais.entity.UnidadeVendaEntity;
import com.br.tecnomais.vconfiguracao.FixedLengthDocument;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Usuario
 */
public class ProdutoView extends javax.swing.JFrame {

    private String nomeFoto;
    private final ProdutoDAO proDao = new ProdutoDAO();
    private ProdutoEntity prod;
    private Integer codigo;
    private Integer id = 0;

    public ProdutoView(ProdutoEntity prod, boolean preencher) {
        initComponents();
        this.prod = prod;
        codigo = prod.getCodigoProduto();
        if (this.prod.getId() != null && this.prod.getId() >= 0) {
            this.id = prod.getId();
            tfID.setText(id.toString());
        } else {
            tfID.setText("");

        }

        preencherComboClasses();
        preencherComboUnidadeVenda();
        limitarCampos();
        preecherCampos(preencher);
        tfID.setVisible(false);
        if (tfID.getText().isEmpty()) {
            try {
                Integer cod = proDao.retornaUltimoId() + 1;
                tfCodigoProduto.setText(cod.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcClasse = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        tfQntAtual = new javax.swing.JTextField();
        tfCodigoProduto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfPrecoVenda = new javax.swing.JTextField();
        tfPrecoCusto = new javax.swing.JTextField();
        jcUnidadeVenda = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tfTextoSaida = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfEstoqueCritico = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfPorcentagem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        bGravar = new javax.swing.JButton();
        bNovo = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        bApagar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lbFoto = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tfCodBarras = new javax.swing.JTextField();
        tfID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnomais");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(200, 210, 210));

        jLabel5.setText("Qnt. Inicial");

        jcClasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        jLabel11.setText("%");

        jLabel7.setText("*Texto de Saída");

        tfDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescricaoFocusLost(evt);
            }
        });
        tfDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescricaoActionPerformed(evt);
            }
        });
        tfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescricaoKeyReleased(evt);
            }
        });

        tfQntAtual.setText("0");
        tfQntAtual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfQntAtualFocusGained(evt);
            }
        });
        tfQntAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQntAtualKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQntAtualKeyTyped(evt);
            }
        });

        tfCodigoProduto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCodigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoProdutoActionPerformed(evt);
            }
        });
        tfCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCodigoProdutoKeyTyped(evt);
            }
        });

        jLabel8.setText("*Classe");

        jLabel4.setText("*Unid. Venda");

        tfPrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecoVendaActionPerformed(evt);
            }
        });
        tfPrecoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPrecoVendaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPrecoVendaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPrecoVendaKeyTyped(evt);
            }
        });

        tfPrecoCusto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPrecoCustoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPrecoCustoKeyTyped(evt);
            }
        });

        jcUnidadeVenda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        jLabel2.setText("*Descrição");

        tfTextoSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTextoSaidaFocusLost(evt);
            }
        });
        tfTextoSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTextoSaidaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTextoSaidaKeyReleased(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel10.setText("*Pre. Custo");

        tfEstoqueCritico.setText("0");
        tfEstoqueCritico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfEstoqueCriticoFocusGained(evt);
            }
        });
        tfEstoqueCritico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfEstoqueCriticoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEstoqueCriticoKeyTyped(evt);
            }
        });

        jLabel6.setText("Est. Crítico");

        jLabel12.setText("*Pre. Venda");

        tfPorcentagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPorcentagemActionPerformed(evt);
            }
        });
        tfPorcentagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPorcentagemKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPorcentagemKeyTyped(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(170, 180, 180));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Produtos");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setOpaque(true);

        bGravar.setText("Gravar");
        bGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGravarActionPerformed(evt);
            }
        });
        bGravar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bGravarKeyPressed(evt);
            }
        });

        bNovo.setText("Novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        bBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bBuscarKeyPressed(evt);
            }
        });

        bApagar.setText("Apagar");
        bApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bApagarActionPerformed(evt);
            }
        });
        bApagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bApagarKeyPressed(evt);
            }
        });

        jLabel14.setText("Adicionar Foto");

        lbFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFoto.setOpaque(true);

        jButton5.setText("Importar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel15.setText("Cod. Barras");

        tfCodBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodBarrasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCodBarrasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTextoSaida)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCodBarras))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcUnidadeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEstoqueCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfQntAtual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tfPrecoVenda, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfPrecoCusto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(176, 176, 176))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bApagar, bBuscar, bGravar, bNovo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(tfCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcUnidadeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(tfPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQntAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEstoqueCritico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTextoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(jButton5)
                .addGap(41, 41, 41)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGravar)
                    .addComponent(bNovo)
                    .addComponent(bBuscar)
                    .addComponent(bApagar)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg", "gif");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(lbFoto);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                ImageIcon image = new ImageIcon(chooser.getSelectedFile().getPath());
                Image img = image.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_SMOOTH);
                lbFoto.setIcon(new ImageIcon(img));
                nomeFoto = chooser.getSelectedFile().getName();
                new Alertas().mensagemConfirmacao(nomeFoto);
            }

            FileInputStream origem;
            FileOutputStream destino;

            FileChannel fcOrigem;
            FileChannel fcDestino;

            origem = new FileInputStream(chooser.getSelectedFile().getPath());//arquivo que você quer copiar  
            destino = new FileOutputStream("FotoProduto/" + chooser.getSelectedFile().getName());//onde irá ficar a copia do aquivo  

            fcOrigem = origem.getChannel();
            fcDestino = destino.getChannel();

            fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);//copiando o arquivo e salvando no diretório que você escolheu  

            origem.close();
            destino.close();
        } catch (Exception ero) {
            ero.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tfQntAtualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQntAtualKeyReleased
        new ValidarCamposNumericos().validar(tfQntAtual);
    }//GEN-LAST:event_tfQntAtualKeyReleased

    private void tfEstoqueCriticoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEstoqueCriticoKeyReleased
        new ValidarCamposNumericos().validar(tfEstoqueCritico);
    }//GEN-LAST:event_tfEstoqueCriticoKeyReleased

    private void tfPrecoCustoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoCustoKeyReleased
        new ValidarCamposNumericos().validar(tfPrecoCusto);
        tfPrecoCusto.setText(new Dinheiro().dinheiro(tfPrecoCusto.getText()));
    }//GEN-LAST:event_tfPrecoCustoKeyReleased

    private void tfPrecoVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoVendaKeyReleased
        new ValidarCamposNumericos().validar(tfPrecoVenda);
        tfPrecoVenda.setText(new Dinheiro().dinheiro(tfPrecoVenda.getText()));
        tfPorcentagem.setText(new DecimalFormat("0.0").format(calculaPorcentagem() * 100));
    }//GEN-LAST:event_tfPrecoVendaKeyReleased

    private void tfPorcentagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPorcentagemActionPerformed
        double prCusto = Double.parseDouble(tfPrecoCusto.getText().replace(",", ".").replace(".", ""));
        double porcentagem = Double.parseDouble(tfPorcentagem.getText().replace(",", "."));
        double vlrAcrescimo = (porcentagem * prCusto) / 100;
        tfPrecoVenda.setText(new DecimalFormat("0.00").format((prCusto + vlrAcrescimo) / 100));
    }//GEN-LAST:event_tfPorcentagemActionPerformed

    private void bGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGravarActionPerformed
        if (tfID.getText().isEmpty()) {
            if (!tfCodigoProduto.getText().isEmpty()) {
                int codigo = Integer.parseInt(tfCodigoProduto.getText());
                try {
                    if (proDao.verificaCodigoExistente(codigo) == false) {
                        cadastrarProduto();
                        if (tfID.getText().isEmpty()) {
                            try {
                                Integer cod = proDao.retornaUltimoId() + 1;
                                tfCodigoProduto.setText(cod.toString());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    } else {
                        new Alertas().mensagemErro("O código informado encontra-se em uso por outro produto, por favor forneça um novo código!");
                        tfCodigoProduto.requestFocus();
                        tfCodigoProduto.selectAll();
                        tfCodigoProduto.setBorder(new LineBorder(Color.red));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                if (tfCodigoProduto.getText().equals(codigo.toString())) {
                    atualizarProduto();
                    limpaCampos();

                    if (tfID.getText().isEmpty()) {
                        try {
                            Integer cod = proDao.retornaUltimoId() + 1;
                            tfCodigoProduto.setText(cod.toString());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("entrou e atualizou codtf e codigo");
                } else if (proDao.verificaCodigoExistente(Integer.parseInt(tfCodigoProduto.getText())) == false) {
                    System.out.println("atualizou o codigo novo");
                    atualizarProduto();
                    ProdutosVendaDAO prodDAO = new ProdutosVendaDAO();
                    prodDAO.updateCodigoDinamicoPrtVendidos(id, Integer.parseInt(tfCodigoProduto.getText()));
                    prodDAO.updateCodigoDinamicoPrtEntrada(id, Integer.parseInt(tfCodigoProduto.getText()));
                    limpaCampos();

                    if (tfID.getText().isEmpty()) {
                        try {
                            Integer cod = proDao.retornaUltimoId() + 1;
                            tfCodigoProduto.setText(cod.toString());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    new Alertas().mensagemAviso("O código atribuido já existe!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
//            if (!tfCodigoProduto.getText().isEmpty()) {
//                int codigo = Integer.parseInt(tfCodigoProduto.getText());
//                try {
//                    if (verificaSeCodigoProdutoEIgualCodigoPassado() == true) {
//                        atualizarProduto();
//                    } else if (proDao.verificaCodigoExistente(codigo) == false) {
//                        atualizarProduto();
//                    } else {
//                        new Alertas().mensagemErro("O código informado encontra-se em uso por outro produto, por favor forneça um novo código!");
//                        tfCodigoProduto.requestFocus();
//                        tfCodigoProduto.selectAll();
//                        tfCodigoProduto.setBorder(new LineBorder(Color.red));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }


    }//GEN-LAST:event_bGravarActionPerformed

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        limpaCampos();
        if (tfID.getText().isEmpty()) {
            try {
                Integer cod = proDao.retornaUltimoId() + 1;
                tfCodigoProduto.setText(cod.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bNovoActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        this.dispose();
        new PesquisaProdutoView().setVisible(true);
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bApagarActionPerformed
        excluirProduto();
    }//GEN-LAST:event_bApagarActionPerformed

    private void tfTextoSaidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTextoSaidaKeyReleased
        tfTextoSaida.setText(new ConvertToMaiuscula().convertTo(tfTextoSaida.getText()));
    }//GEN-LAST:event_tfTextoSaidaKeyReleased

    private void tfDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescricaoKeyReleased
        tfDescricao.setText(new ConvertToMaiuscula().convertTo(tfDescricao.getText()));
    }//GEN-LAST:event_tfDescricaoKeyReleased

    private void tfPrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrecoVendaActionPerformed

    private void tfDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescricaoActionPerformed

    private void tfDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescricaoFocusLost
        tfTextoSaida.setText(tfDescricao.getText());
    }//GEN-LAST:event_tfDescricaoFocusLost

    private void tfCodigoProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoProdutoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCodigoProdutoKeyTyped

    private void tfCodBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodBarrasKeyPressed
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfCodBarras.requestFocus();
        }
    }//GEN-LAST:event_tfCodBarrasKeyPressed

    private void tfQntAtualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQntAtualKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfQntAtualKeyTyped

    private void tfEstoqueCriticoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEstoqueCriticoKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfEstoqueCriticoKeyTyped

    private void tfPrecoVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoVendaKeyPressed

    }//GEN-LAST:event_tfPrecoVendaKeyPressed

    private void tfPrecoCustoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoCustoKeyTyped
        String caracteres = "0987654321.,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfPrecoCustoKeyTyped

    private void tfPorcentagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPorcentagemKeyPressed
//        String caracteres = "0987654321.,";
//        if (!caracteres.contains(evt.getKeyChar() + "")) {
//            evt.consume();
//        }
    }//GEN-LAST:event_tfPorcentagemKeyPressed

    private void tfPorcentagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPorcentagemKeyTyped
        String caracteres = "0987654321,.";
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

        } else if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfPorcentagemKeyTyped

    private void tfPrecoVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoVendaKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfPrecoVendaKeyTyped

    private void tfCodBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodBarrasKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCodBarrasKeyTyped

    private void tfCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoProdutoActionPerformed

    private void tfTextoSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTextoSaidaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTextoSaidaFocusLost

    private void tfTextoSaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTextoSaidaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            bGravar.requestFocus();
        }
    }//GEN-LAST:event_tfTextoSaidaKeyPressed

    private void bGravarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bGravarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            bNovo.requestFocus();
        }
    }//GEN-LAST:event_bGravarKeyPressed

    private void bBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            bBuscar.requestFocus();
        }
    }//GEN-LAST:event_bBuscarKeyPressed

    private void bApagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bApagarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            bGravar.requestFocus();
        }
    }//GEN-LAST:event_bApagarKeyPressed

    private void tfQntAtualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQntAtualFocusGained
        tfQntAtual.selectAll();
    }//GEN-LAST:event_tfQntAtualFocusGained

    private void tfEstoqueCriticoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEstoqueCriticoFocusGained
       tfEstoqueCritico.selectAll();
    }//GEN-LAST:event_tfEstoqueCriticoFocusGained

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
                if ("Matal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoView(null, false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bApagar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bGravar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox jcClasse;
    private javax.swing.JComboBox jcUnidadeVenda;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JTextField tfCodBarras;
    private javax.swing.JTextField tfCodigoProduto;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfEstoqueCritico;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfPorcentagem;
    private javax.swing.JTextField tfPrecoCusto;
    private javax.swing.JTextField tfPrecoVenda;
    private javax.swing.JTextField tfQntAtual;
    private javax.swing.JTextField tfTextoSaida;
    // End of variables declaration//GEN-END:variables

    private double calculaPorcentagem() {
        double por = 0;
        double prCusto = Double.parseDouble(tfPrecoCusto.getText().replace(",", ".").replace(".", ""));
        double prVenda = Double.parseDouble(tfPrecoVenda.getText().replace(",", ".").replace(".", ""));
        double diferenca = prVenda - prCusto;
        por = diferenca / prCusto;
        return por;
    }

    private void cadastrarProduto() {
        try {
            if (tfDescricao.getText().isEmpty() || jcUnidadeVenda.getSelectedItem().equals("...") || jcClasse.getSelectedItem().equals("...") || tfPrecoCusto.getText().isEmpty() || tfPrecoVenda.getText().isEmpty() || tfTextoSaida.getText().isEmpty()) {
                new Alertas().mensagemAviso("Preencha todos os campos obrigatórios(*)!");
            } else {
                ProdutoEntity p = new ProdutoEntity();
                p.setNome(tfDescricao.getText());
                p.setTipo("Normal");
                p.setUnidadeDeVenda(jcUnidadeVenda.getSelectedItem().toString());
                p.setQntAtual(Double.parseDouble(tfQntAtual.getText().replace(",", ".")));

                if (tfEstoqueCritico.getText().equals("")) {
                    p.setEstqCritico(0.0);
                } else {
                    p.setEstqCritico(Double.parseDouble(tfEstoqueCritico.getText().replace(",", ".")));
                }

                p.setTextoDeSaida(tfTextoSaida.getText());
                p.setCodigoDeBarras(tfCodBarras.getText());
                p.setClasse(jcClasse.getSelectedItem().toString());
                p.setPrecoDeCusto(Double.parseDouble(tfPrecoCusto.getText().replace(",", ".").replace(".", "")));
                p.setPorcentagem(Double.parseDouble(tfPorcentagem.getText().replace(",", ".")));
                p.setPrecoDeVenda(Double.parseDouble(tfPrecoVenda.getText().replace(",", ".").replace(".", "")));
                p.setFoto("FotoProduto/" + nomeFoto);
                p.setCodigoProduto(Integer.parseInt(tfCodigoProduto.getText()));
                proDao.adicionar(p);
                limpaCampos();
                new Alertas().mensagemConfirmacao("Produto cadastrado com sucesso!");
                tfCodigoProduto.setBorder(new LineBorder(Color.LIGHT_GRAY));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizarProduto() {
        try {
            ProdutoEntity p = new ProdutoEntity();
            p.setId(id);
            p.setCodigoProduto(Integer.parseInt(tfCodigoProduto.getText()));
            p.setNome(tfDescricao.getText());
            p.setTipo("Normal");
            p.setUnidadeDeVenda(jcUnidadeVenda.getSelectedItem().toString());
            p.setQntAtual(Double.parseDouble(tfQntAtual.getText()));
            if (tfEstoqueCritico.getText().equals("")) {
                p.setEstqCritico(0.0);
            } else {
                p.setEstqCritico(Double.parseDouble(tfEstoqueCritico.getText().replace(",", ".")));
            }

            p.setTextoDeSaida(tfTextoSaida.getText());
            p.setCodigoDeBarras(tfCodBarras.getText());
            p.setClasse(jcClasse.getSelectedItem().toString());
            p.setPrecoDeCusto(Double.parseDouble(tfPrecoCusto.getText().replace(",", ".").replace(".", "")));
            p.setPorcentagem(Double.parseDouble(tfPorcentagem.getText().replace(",", ".")));
            p.setPrecoDeVenda(Double.parseDouble(tfPrecoVenda.getText().replace(",", ".").replace(".", "")));
            p.setFoto("FotoProduto/" + nomeFoto);
            proDao.altera(p);
            new Alertas().mensagemConfirmacao("Produto atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluirProduto() {
        try {
            if (tfCodigoProduto.getText().isEmpty()) {
                new Alertas().mensagemAviso("Selecione um produto para excluí-lo!");
            } else {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o produto?");
                if (opcao == JOptionPane.YES_OPTION) {
                    ProdutoEntity prod = new ProdutoEntity();
                    prod.setId(Integer.parseInt(tfCodigoProduto.getText()));
                    proDao.remove(prod);
                    limpaCampos();
                    new Alertas().mensagemConfirmacao("Produto excluído com sucesso!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limpaCampos() {
        JTextField tf[] = new JTextField[]{tfCodBarras, tfDescricao, tfEstoqueCritico, tfCodigoProduto, tfPorcentagem, tfPrecoCusto, tfPrecoVenda, tfQntAtual, tfTextoSaida, tfID};
        for (JTextField text : tf) {
            text.setText("");
        }
        jcClasse.setSelectedItem("...");
//        jcTipo.setSelectedItem("...");
        jcUnidadeVenda.setSelectedItem("...");
        lbFoto.setIcon(null);
        tfQntAtual.setEnabled(true);
    }

    private void preecherCampos(boolean preencher) {
        if (preencher == true) {
            codigo = prod.getCodigoProduto();
            tfCodigoProduto.setText(prod.getCodigoProduto().toString());
            tfCodBarras.setText(prod.getCodigoDeBarras());
            tfDescricao.setText(prod.getNome());
//            jcTipo.setSelectedItem(prod.getTipo());
            jcClasse.setSelectedItem(prod.getClasse());
            jcUnidadeVenda.setSelectedItem(prod.getUnidadeDeVenda());
            tfQntAtual.setText(prod.getQntAtual().toString());
            tfEstoqueCritico.setText(prod.getEstqCritico().toString());
            tfPrecoCusto.setText(new DecimalFormat("0.00").format(prod.getPrecoDeCusto()));
            tfPorcentagem.setText(new DecimalFormat("0.0").format(prod.getPorcentagem()));
            tfPrecoVenda.setText(new DecimalFormat("0.00").format(prod.getPrecoDeVenda()));
            tfTextoSaida.setText(prod.getTextoDeSaida());
            pegaFotoProduto();
            tfQntAtual.setEnabled(false);
        }
    }

    private void preencherComboClasses() {
        ClasseDAO clsDao = new ClasseDAO();
        try {
            ClasseProdutoEntity cls = new ClasseProdutoEntity();
            cls.setNomeClasse("%");
            for (ClasseProdutoEntity cl : clsDao.listaClassesProdutos(cls)) {
                jcClasse.addItem(cl.getNomeClasse());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherComboUnidadeVenda() {
        try {
            UnidadeVendaDAO undDao = new UnidadeVendaDAO();
            for (UnidadeVendaEntity und : undDao.listaUnidades("%")) {
                jcUnidadeVenda.addItem(und.getNome());
            }
        } catch (Exception e) {
        }
    }

    private void pegaFotoProduto() {
        ImageIcon image;
        image = new ImageIcon("FotoProduto/" + prod.getFoto());
        Image img = image.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_SMOOTH);
        lbFoto.setIcon(new ImageIcon(img));
    }

    private void limitarCampos() {
        tfDescricao.setDocument(new FixedLengthDocument(100));
        tfTextoSaida.setDocument(new FixedLengthDocument(100));

    }

    private boolean verificaSeCodigoProdutoEIgualCodigoPassado() {
        int novoCodigo = Integer.parseInt(tfCodigoProduto.getText());
        return (codigo == novoCodigo);
    }
}
