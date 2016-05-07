/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.classes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Desenvolvimento
 */
public class NovaHora {

    String hora;
    Integer horaInt;

    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
    SimpleDateFormat horaFormataSemString = new SimpleDateFormat("HHmm");

    public String lerHora() {
        Date horaAtual = new Date();
        hora = horaFormatada.format(horaAtual);
        return hora;

    }
    
    public Integer lerHoraInt(){
        Date horaAtual = new Date();
        horaInt = Integer.parseInt(horaFormatada.format(horaFormataSemString));
        return horaInt;
    }

}
