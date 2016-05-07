/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vconfiguracao;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Desenvolvimento
 */
public class LimitarCampoDeTexto {

    public void limitarJTextField(JTextField jtf, Integer tam) {
        if (jtf.getText().length() >= tam) {
            jtf.setText(jtf.getText().substring(0, tam));
        }else{
            jtf.setText(jtf.getText());
        }
    }
    
}
