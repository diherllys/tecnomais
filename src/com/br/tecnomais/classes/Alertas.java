/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Alertas {
    
    public void mensagemAviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public void mensagemConfirmacao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public void mensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.ERROR_MESSAGE);
    }
}
