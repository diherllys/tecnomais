/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treads;

import br.com.daruma.jna.DUAL;
import com.br.tecnomais.entity.UsuarioEntity;

/**
 *
 * @author Usuario
 */
public class Ajax implements Runnable {

    UsuarioEntity us = new UsuarioEntity();

    @Override
    public void run() {
        carregaImp();
    }
    
    public void setUs(UsuarioEntity us){
        this.us = us;
    }

    public void carregaImp() {
        System.out.println("entrou");
        int tRetorno = DUAL.regTermica("1");//sempre 1 
        int pRetorno = DUAL.regPortaComunicacao("COM2");//porta de comunicação
        int vRetorno = DUAL.regVelocidade("115200");// velocidade da porta utilziada
         System.out.println("saiu");
    }

}
