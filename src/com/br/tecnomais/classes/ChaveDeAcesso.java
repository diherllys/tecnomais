package com.br.tecnomais.classes;

import com.br.tecnomais.db.ConectaBanco;
import java.sql.SQLException;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class ChaveDeAcesso {

    JLabel lbDataAtual = new JLabel();
    NovaData data = new NovaData();
    ConectaBanco con = new ConectaBanco();

    public ChaveDeAcesso() {
        data.dataAtual(lbDataAtual);
    }

    public boolean validaChave(String chaveDigitada) throws Exception {
        con.conectar();
        String dataAtual = lbDataAtual.getText();
        int diaAtual = Integer.parseInt(dataAtual.substring(0, 2));
        int mesAtual = Integer.parseInt(dataAtual.substring(3, 5));
        int anoAtual = Integer.parseInt(dataAtual.substring(6, 10));
        int numeroLicenca = 0;
        String dataVencimento = "";

        String sql = "select NumeroLicenca, DataVencimento from tb_licenca";
        con.stmt = con.conn.prepareStatement(sql);
        con.rs = con.stmt.executeQuery();
        while (con.rs.next()) {
            numeroLicenca = con.rs.getInt("NumeroLicenca");
            dataVencimento = con.rs.getString("DataVencimento");
        }

        int qntDias = Integer.parseInt(chaveDigitada.substring(chaveDigitada.indexOf(".") + 1, chaveDigitada.indexOf("-"))) / diaAtual;
        String novaChave = chaveDigitada.substring(0, chaveDigitada.indexOf(".")) + "" + chaveDigitada.substring(chaveDigitada.indexOf("-") + 1, chaveDigitada.length());
        String chaveAtual = "" + ((numeroLicenca * diaAtual) + "" + (anoAtual + diaAtual + mesAtual) * 3);
        System.out.println("essa aqui: "+numeroLicenca);
        if (chaveAtual.equals(novaChave)) {
            if (verificaChaveExistente(chaveDigitada) == false) {
                System.out.println("Executou chave de acesso!");
                cadastraChaveAcesso(novaChave);
                System.out.println("dataVencimento " + dataVencimento);
                atualizaDataVencimento(data.adicionaDias(dataVencimento, qntDias));
                System.out.println("dataNovaVenc " + data.adicionaDias(dataVencimento, qntDias));
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private void cadastraChaveAcesso(String numeroChave) throws Exception {
        con.conectar();
        String sql = "insert into tb_chaves (chave) values(?)";
        con.stmt = con.conn.prepareStatement(sql);
        con.stmt.setString(1, numeroChave);
        con.stmt.executeUpdate();
    }

    private void atualizaDataVencimento(String novaData) throws Exception {
        con.conectar();
        String sql = "update tb_licenca set DataVencimento = ?";
        con.stmt = con.conn.prepareStatement(sql);
        con.stmt.setString(1, novaData);
        con.stmt.executeUpdate();
    }

    private boolean verificaChaveExistente(String chave) throws SQLException {
        con.conectar();
        String sql = "select * from tb_chaves where chave = ?";
        con.stmt = con.conn.prepareStatement(sql);
        con.stmt.setString(1, chave);
        con.rs = con.stmt.executeQuery();
        if (con.rs.next()) {
            return true;
        } else {
            return false;
        }
    }
}
