package com.br.tecnomais.classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class NovaData {

    String data;

    public void dataAtual(JFormattedTextField campo) {
        SimpleDateFormat datas = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String grava = datas.format(cal.getTime());
        campo.setText(grava);
    }

    public void dataAtual(JLabel campo) {
        SimpleDateFormat datas = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String grava = datas.format(cal.getTime());
        campo.setText(grava);
    }

    public String dataAtual() {
        SimpleDateFormat datas = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String grava = datas.format(cal.getTime());
        return grava;
    }

    public String getDataConvertida() {
        return data;
    }

//    public void DataAtualChooser(JDateChooser campo) throws ParseException {
//        DateFormat dataChooser = new SimpleDateFormat("dd/MM/yyyy");
//        Calendar c = Calendar.getInstance();
//        String d = dataChooser.format(c.getTime());
//        Date da = (Date)dataChooser.parse(d);
//        campo.setDate(da);
//        
//    }
    public void calculaPeriodo(JTextField campo, String novaData, JTextField campo2) {
        try {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy"); //formata a data
            String mes = campo.getText().substring(4, 5); // pega os digitos do mês
            LocalDate vencimento = fmt.parseLocalDate(campo.getText());//passa a string formatada para Date

            if (mes.equals("12")) {// compara se o mes for 12
                //novaData = (vencimento.plusMonths(1).plusYears(1)).toString("dd/MM/yyyy");//muda o mes e ano
                novaData = (vencimento.toDateTimeAtStartOfDay().plusMonths(1).plusYears(1).toString("dd/MM/yyyy"));
            } else {
                //novaData = (vencimento.plusMonths(1)).toString("dd/MM/yyyy");//muda só o mês
                novaData = (vencimento.toDateTimeAtStartOfDay().plusMonths(1).toString("dd/MM/yyyy"));
            }
            campo2.setText(novaData);//novaData global recebe a nova data de vencimento

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Confira a data, o mês informado não possui este dia!");
        }
    }

    public String adiciona1Mes(String data) {
        try {
            String novaData;
            DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy"); //formata a data
            String mes = data.substring(4, 5); // pega os digitos do mês
            LocalDate vencimento = fmt.parseLocalDate(data);//passa a string formatada para Date

            if (mes.equals("12")) {// compara se o mes for 12
                //novaData = (vencimento.plusMonths(1).plusYears(1)).toString("dd/MM/yyyy");//muda o mes e ano
                novaData = (vencimento.toDateTimeAtStartOfDay().plusMonths(1).plusYears(1).toString("dd/MM/yyyy"));
            } else {
                //novaData = (vencimento.plusMonths(1)).toString("dd/MM/yyyy");//muda só o mês
                novaData = (vencimento.toDateTimeAtStartOfDay().plusMonths(1).toString("dd/MM/yyyy"));
            }
            data = novaData;//novaData global recebe a nova data de vencimento

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Confira a data, o mês informado não possui este dia!");
        }
        return data;
    }

    public String addUmDia(String data) {
        try {
            String novaData;
            DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy"); //formata a data
            String mes = data.substring(4, 5); // pega os digitos do mês
            LocalDate vencimento = fmt.parseLocalDate(data);//passa a string formatada para Date

            novaData = (vencimento.toDateTimeAtStartOfDay().plusDays(1).toString("dd/MM/yyyy"));
            data = novaData;//novaData global recebe a nova data de vencimento

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Confira a data, o mês informado não possui este dia!");
        }
        return data;
    }

    public String adicionaDias(String data, int dias) {
        try {
            String novaData;
            DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy"); //formata a data
            String mes = data.substring(4, 5); // pega os digitos do mês
            LocalDate vencimento = fmt.parseLocalDate(data);//passa a string formatada para Date

            //novaData = (vencimento.plusMonths(1)).toString("dd/MM/yyyy");//muda só o mês
            novaData = (vencimento.toDateTimeAtStartOfDay().plusDays(dias).toString("dd/MM/yyyy"));

            data = novaData;//novaData global recebe a nova data de vencimento

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Confira a data, o mês informado não possui este dia!");
        }
        return data;
    }
}
