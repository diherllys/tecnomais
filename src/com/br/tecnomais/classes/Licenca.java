package com.br.tecnomais.classes;

import com.br.tecnomais.dao.LicencaDao;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.vcadastros.LoginView;
import com.br.tecnomais.vconfiguracao.ChaveAcessoView;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author Usuario
 */
public class Licenca {

    private int dia;
    ConectaBanco con = new ConectaBanco();
    JLabel lbDataAtual = new JLabel();
    NovaData data = new NovaData();

    public Licenca() {
        data.dataAtual(lbDataAtual);
    }

    public void checaLicenca() {

        try {
            if (verificaIntegridade() == false) {
                new Alertas().mensagemErro("Quebra de integridade do sistema, por favor verifique a data do seu computador!");
            } else {
                if (verificaVencimento() == true) {
                    checaDiasRestantes();
                } else {
                    new Alertas().mensagemErro("Sua licenca está vencida, por favor forneça uma nova chave de acesso!");
                    new ChaveAcessoView(null, true, getDiasRestantes()).setVisible(true);
                }
            }
        } catch (Exception e) {
            new Alertas().mensagemErro("erro 2:" + e);
            e.printStackTrace();
        }

    }

    private boolean verificaVencimento() throws Exception {
        con.conectar();
        String sql = "select DataVencimento from tb_licenca where convert(datetime, DataVencimento, 103) >= convert(datetime, ?, 103)";
        con.stmt = con.conn.prepareStatement(sql);
        con.stmt.setString(1, lbDataAtual.getText());
        con.rs = con.stmt.executeQuery();
        if (con.rs.next()) {
            return true;

        } else {
            return false;
        }
    }

    private boolean verificaIntegridade() throws Exception {
        con.conectar();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtualBanco = null, dataProximoDia = null;
        String sql = "select * from tb_loggon";
        con.stmt = con.conn.prepareStatement(sql);
        con.rs = con.stmt.executeQuery();
        if (con.rs.next()) {
            dataAtualBanco = format.parse(con.rs.getString("DiaAtual"));
            dataProximoDia = format.parse(con.rs.getString("ProximoDia"));
        }
        String dataAtualSistema = lbDataAtual.getText();
        Date dataOntem = dataAtualBanco;
        Date dataA = format.parse(dataAtualSistema);

        System.out.println(dataOntem);

        if (dataA.equals(dataProximoDia) || dataA.after(dataProximoDia) || dataA.equals(dataAtualBanco)) {
            LicencaDao dao = new LicencaDao();
            String dataAux = data.addUmDia(dataAtualSistema);
            dao.atualizaDadosLogon(dataAtualSistema, dataAux);
            return true;
        } else {
            return false;
        }
    }

    private void checaDiasRestantes() throws Exception {
        con.conectar();
        String sql = "select DataVencimento from tb_licenca";
        con.stmt = con.conn.prepareStatement(sql);
        con.rs = con.stmt.executeQuery();
        String dataVencimento = "";
        while (con.rs.next()) {
            dataVencimento = con.rs.getString("DataVencimento");
        }
        int diaVencimento = Integer.parseInt(dataVencimento.substring(0, 2));
        int mesVencimento = Integer.parseInt(dataVencimento.substring(3, 5));
        int anoVencimento = Integer.parseInt(dataVencimento.substring(6, 10));

        String dataAtual = lbDataAtual.getText();
        int diaAtual = Integer.parseInt(dataAtual.substring(0, 2));
        int mesAtual = Integer.parseInt(dataAtual.substring(3, 5));
        int anoAtual = Integer.parseInt(dataAtual.substring(6, 10));

        DateTime dataInicial = new DateTime(anoAtual, mesAtual, diaAtual, 0, 0);
        DateTime dataFinal = new DateTime(anoVencimento, mesVencimento, diaVencimento, 0, 0);

        int dia = Days.daysBetween(dataInicial, dataFinal).getDays();
        setDiasRestantes(dia);

        if (dia <= 5 && dia > 1) {
            new Alertas().mensagemAviso("Faltam " + dia + " dias para sua licença expirar, por favor forneça uma nova chave de acesso!");
            new ChaveAcessoView(null, true, getDiasRestantes()).setVisible(true);
        } else if (dia == 1) {
            new Alertas().mensagemAviso("Falta " + dia + " dia para sua licença expirar, por favor forneça uma nova chave de acesso!");
            new ChaveAcessoView(null, true, getDiasRestantes()).setVisible(true);
        } else if (dia == 0) {
            new Alertas().mensagemAviso("Último dia de licença, forneça uma nova chave de acesso!");
            new ChaveAcessoView(null, true, getDiasRestantes()).setVisible(true);
        } else {
            new LoginView().setVisible(true);
        }
    }

    public int getDiasRestantes() {
        return dia;
    }

    public void setDiasRestantes(int dia) {
        this.dia = dia;
    }

}
