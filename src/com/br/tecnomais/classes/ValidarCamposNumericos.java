package com.br.tecnomais.classes;

import javax.swing.JTextField;

/**
 *
 * @author Reginaldo Cândido
 */
public class ValidarCamposNumericos {

    public void validar(JTextField tfCampo) {
        tfCampo.setText(tfCampo.getText().replace("a", ""));
        tfCampo.setText(tfCampo.getText().replace("b", ""));
        tfCampo.setText(tfCampo.getText().replace("c", ""));
        tfCampo.setText(tfCampo.getText().replace("d", ""));
        tfCampo.setText(tfCampo.getText().replace("e", ""));
        tfCampo.setText(tfCampo.getText().replace("f", ""));
        tfCampo.setText(tfCampo.getText().replace("g", ""));
        tfCampo.setText(tfCampo.getText().replace("h", ""));
        tfCampo.setText(tfCampo.getText().replace("i", ""));
        tfCampo.setText(tfCampo.getText().replace("j", ""));
        tfCampo.setText(tfCampo.getText().replace("k", ""));
        tfCampo.setText(tfCampo.getText().replace("l", ""));
        tfCampo.setText(tfCampo.getText().replace("m", ""));
        tfCampo.setText(tfCampo.getText().replace("n", ""));
        tfCampo.setText(tfCampo.getText().replace("o", ""));
        tfCampo.setText(tfCampo.getText().replace("p", ""));
        tfCampo.setText(tfCampo.getText().replace("q", ""));
        tfCampo.setText(tfCampo.getText().replace("r", ""));
        tfCampo.setText(tfCampo.getText().replace("s", ""));
        tfCampo.setText(tfCampo.getText().replace("t", ""));
        tfCampo.setText(tfCampo.getText().replace("u", ""));
        tfCampo.setText(tfCampo.getText().replace("v", ""));
        tfCampo.setText(tfCampo.getText().replace("x", ""));
        tfCampo.setText(tfCampo.getText().replace("w", ""));
        tfCampo.setText(tfCampo.getText().replace("y", ""));
        tfCampo.setText(tfCampo.getText().replace("z", ""));
        tfCampo.setText(tfCampo.getText().replace(".", ""));
        tfCampo.setText(tfCampo.getText().replace("!", ""));
        tfCampo.setText(tfCampo.getText().replace("@", ""));
        tfCampo.setText(tfCampo.getText().replace(",", ""));
        tfCampo.setText(tfCampo.getText().replace("#", ""));
        tfCampo.setText(tfCampo.getText().replace("ç", ""));
        tfCampo.setText(tfCampo.getText().replace("-", ""));
    }

    public String removerCaracteres(String tfCampo) {
        tfCampo = (tfCampo.replace("a", ""));
        tfCampo = (tfCampo.replace("b", ""));
        tfCampo = (tfCampo.replace("c", ""));
        tfCampo = (tfCampo.replace("d", ""));
        tfCampo = (tfCampo.replace("e", ""));
        tfCampo = (tfCampo.replace("f", ""));
        tfCampo = (tfCampo.replace("g", ""));
        tfCampo = (tfCampo.replace("h", ""));
        tfCampo = (tfCampo.replace("i", ""));
        tfCampo = (tfCampo.replace("j", ""));
        tfCampo = (tfCampo.replace("k", ""));
        tfCampo = (tfCampo.replace("l", ""));
        tfCampo = (tfCampo.replace("m", ""));
        tfCampo = (tfCampo.replace("n", ""));
        tfCampo = (tfCampo.replace("o", ""));
        tfCampo = (tfCampo.replace("p", ""));
        tfCampo = (tfCampo.replace("q", ""));
        tfCampo = (tfCampo.replace("r", ""));
        tfCampo = (tfCampo.replace("s", ""));
        tfCampo = (tfCampo.replace("t", ""));
        tfCampo = (tfCampo.replace("u", ""));
        tfCampo = (tfCampo.replace("v", ""));
        tfCampo = (tfCampo.replace("x", ""));
        tfCampo = (tfCampo.replace("w", ""));
        tfCampo = (tfCampo.replace("y", ""));
        tfCampo = (tfCampo.replace("z", ""));
        tfCampo = (tfCampo.replace(".", ""));
        tfCampo = (tfCampo.replace("!", ""));
        tfCampo = (tfCampo.replace("@", ""));
        tfCampo = (tfCampo.replace(",", ""));
        tfCampo = (tfCampo.replace("#", ""));
        tfCampo = (tfCampo.replace("ç", ""));
        tfCampo = (tfCampo.replace("-", ""));
        tfCampo = (tfCampo.replace("%", ""));

        return tfCampo;
    }
    
      public int removerCaracteresReturnInt(String tfCampo) {
        tfCampo = (tfCampo.replace("a", ""));
        tfCampo = (tfCampo.replace("b", ""));
        tfCampo = (tfCampo.replace("c", ""));
        tfCampo = (tfCampo.replace("d", ""));
        tfCampo = (tfCampo.replace("e", ""));
        tfCampo = (tfCampo.replace("f", ""));
        tfCampo = (tfCampo.replace("g", ""));
        tfCampo = (tfCampo.replace("h", ""));
        tfCampo = (tfCampo.replace("i", ""));
        tfCampo = (tfCampo.replace("j", ""));
        tfCampo = (tfCampo.replace("k", ""));
        tfCampo = (tfCampo.replace("l", ""));
        tfCampo = (tfCampo.replace("m", ""));
        tfCampo = (tfCampo.replace("n", ""));
        tfCampo = (tfCampo.replace("o", ""));
        tfCampo = (tfCampo.replace("p", ""));
        tfCampo = (tfCampo.replace("q", ""));
        tfCampo = (tfCampo.replace("r", ""));
        tfCampo = (tfCampo.replace("s", ""));
        tfCampo = (tfCampo.replace("t", ""));
        tfCampo = (tfCampo.replace("u", ""));
        tfCampo = (tfCampo.replace("v", ""));
        tfCampo = (tfCampo.replace("x", ""));
        tfCampo = (tfCampo.replace("w", ""));
        tfCampo = (tfCampo.replace("y", ""));
        tfCampo = (tfCampo.replace("z", ""));
        tfCampo = (tfCampo.replace(".", ""));
        tfCampo = (tfCampo.replace("!", ""));
        tfCampo = (tfCampo.replace("@", ""));
        tfCampo = (tfCampo.replace(",", ""));
        tfCampo = (tfCampo.replace("#", ""));
        tfCampo = (tfCampo.replace("ç", ""));
        tfCampo = (tfCampo.replace("-", ""));
        tfCampo = (tfCampo.replace("%", ""));

        return Integer.parseInt(tfCampo);
    }

    public String removerNumeros(String tfCampo) {
        tfCampo = (tfCampo.replace("1", ""));
        tfCampo = (tfCampo.replace("2", ""));
        tfCampo = (tfCampo.replace("3", ""));
        tfCampo = (tfCampo.replace("4", ""));
        tfCampo = (tfCampo.replace("5", ""));
        tfCampo = (tfCampo.replace("6", ""));
        tfCampo = (tfCampo.replace("7", ""));
        tfCampo = (tfCampo.replace("8", ""));
        tfCampo = (tfCampo.replace("9", ""));
        tfCampo = (tfCampo.replace("0", ""));
        
        return tfCampo;

    }

}
