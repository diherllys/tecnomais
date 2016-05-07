
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vconfiguracao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author Usuario
 */
public class IMP {
    
    // variavel estatica porque será utilizada por inumeras threads
    private static PrintService impressora;
    public IMP() {
        detectaImpressoras();
        imprime("teste");
    }
    // O metodo verifica se existe impressora conectada e a
    // define como padrao.
    public void detectaImpressoras() {
        try {
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            for (PrintService p: ps) {
                System.out.println("Impressora encontrada: " + p.getName());
                if (p.getName().contains("Text") || p.getName().contains("Generic") || p.getName().contains("MP"))  {
	                System.out.println("Impressora Selecionada: " + p.getName());
                    impressora = p;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized boolean imprime(String texto) {
        // se nao existir impressora, entao avisa usuario
        // senao imprime texto
        if (impressora == null) {
            String msg = "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.";
	       	System.out.println(msg);
        } else {
            try {
                DocPrintJob dpj = impressora.createPrintJob();
                InputStream stream = new ByteArrayInputStream(texto.getBytes());
                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new javax.print.SimpleDoc(stream, flavor, null);
                dpj.print(doc, null);
                return true;
            } catch (PrintException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}



