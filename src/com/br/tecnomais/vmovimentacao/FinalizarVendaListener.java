/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vmovimentacao;

import javax.swing.JList;

/**
 *
 * @author Desenvolvimento
 */
public interface FinalizarVendaListener {

    void preencheDadosCliente(String cpf, String end, String nome, int cliId);

    void finalizarVendaOp();

    String retornaPag1();

    String retornaPag2();

    String retornaPag3();

    Double retornaVal1();

    Double retornaVal2();

    Double retornaVal3();

    String retornaDataVenc();

    Double vlrParcela();

    void finalizaVendaParcelado();

    void cadastrarContaReceber();

    void fluxoNovinhaNoGrau(Double valorTotal, String tipoPagamento);

    void baixaNoEstoque();
}
