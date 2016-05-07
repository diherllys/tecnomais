/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.classes;


public class Dinheiro {
    String txt,text;
    public String dinheiro(String text) {
        try{
            txt = text.replaceAll(",", "");
        try{
            txt = txt.replace(".", "").replace(",", "");
        }
        catch(Exception e){
            
        }
        String txt2[] = txt.split(",");
    
        String text1 = txt.substring(0, (txt.length()-2));
        if(text1.length()>3 && text1.length()<7) {
            text1 = text1.substring(0,text1.length()-3)+"."+text1.substring(text1.length()-3, text1.length());
            
        }
        String text2 = txt.substring((txt.length()-2), txt.length());
        String novo_valor = text1+","+text2;
    
        if(novo_valor.length() == 3 && novo_valor.startsWith(",")){
            String aux = novo_valor.substring(1, 2)+","+novo_valor.substring(2,3);
            novo_valor = aux;
        }
        return novo_valor;
    
    }
    catch(Exception e){
return text;
    }

    }

}
