/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treads;

import br.com.daruma.jna.DUAL;
import com.br.tecnomais.classes.ImpressoraBematchEntity;
import com.br.tecnomais.classes.MP2032;
import com.br.tecnomais.dao.ImpressoraBematchDAO;
import com.br.tecnomais.dao.ImpressoraDarumaDAO;
import com.br.tecnomais.dao.ImpressoraPadraoDAO;
import com.br.tecnomais.entity.ImpressoraDarumaEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import com.br.tecnomais.vcadastros.TelaInicialView2;
import com.sun.jna.Native;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class TelaLoadingAjax implements Runnable {

    UsuarioEntity us = new UsuarioEntity();
    ImpressoraPadraoDAO impressoraPadraoDAO = new ImpressoraPadraoDAO();
    ImpressoraBematchDAO impressoraBematchDAO = new ImpressoraBematchDAO();
    ImpressoraBematchEntity impressoraBematchEntity = new ImpressoraBematchEntity();
    ImpressoraDarumaDAO impressoraDarumaDAO = new ImpressoraDarumaDAO();
    ImpressoraDarumaEntity impressoraDarumaEntity = new ImpressoraDarumaEntity();
    String impressoraAtual = "";

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
    @Override
    public void run() {
        try {
            loading();
//            Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
//            keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
//            KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        } catch (InterruptedException ex) {
            Logger.getLogger(TelaLoadingAjax.class.getName()).log(Level.SEVERE, null, ex);
        }
//        carregaImp();
//        carregaImp();
    }

    public void setaUsuario(UsuarioEntity ue) {
        us = ue;
    }

    public void loading() throws InterruptedException {
        Loading load = new Loading();
        load.setVisible(true);
        carregaImp();
        load.dispose();
        new TelaInicialView2(us).setVisible(true);
    }

    public void carregaImp() throws InterruptedException {
//        System.out.println("entrou");
//        int tRetorno = DUAL.regTermica("1");//sempre 1 
//        int pRetorno = DUAL.regPortaComunicacao("USB");//porta de comunicação
//        int vRetorno = DUAL.regVelocidade("115200");
//        System.out.println("saiu");
        try {
            impressoraAtual = impressoraPadraoDAO.retornaImpAtual();
            if (impressoraAtual.equals("ImpressoraDaruma")) {
                System.loadLibrary("DarumaFramework");
                System.out.println("Biblioteca carregada!!!");
                
                System.out.println("entrou imp");
                impressoraDarumaEntity = impressoraDarumaDAO.retornaIde();
//                int tRetorno = DUAL.regTermica("1");//sempre 1 
//                int pRetorno = DUAL.regPortaComunicacao("COM2");//porta de comunicação
//                int vRetorno = DUAL.regVelocidade("115200");// velocidade da porta utilziada
//                int tRetorno = DUAL.regTermica(impressoraDarumaEntity.getRegistroTermico());
                int pRetorno = DUAL.regPortaComunicacao(impressoraDarumaEntity.getPortaComunicacao());
                int pvRetorno = DUAL.regVelocidade(impressoraDarumaEntity.getPortaVelocidade());
//                int cG2Retorno = DUAL.regLinhasGuilhotina(impressoraDarumaEntity.getTamanhoGuilhotina());
//                int zRetorno = DUAL.regZeroCortado(impressoraDarumaEntity.getZeroCortadoStatus());
                System.out.println("saiu imp");
            } else if (impressoraAtual.equals("ImpressoraBematech")) {
//                Thread.sleep(10 * 1000);
            } else {

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
