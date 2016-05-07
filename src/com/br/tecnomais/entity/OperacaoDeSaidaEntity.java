/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.entity;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class OperacaoDeSaidaEntity {
    
    private Integer id;
    private Integer codigo;
    private String nome;
    private String naturezaDaOperacao;
    private String caracteristicaDeOperacao;
    private boolean dimEstq;
    private boolean entraDinheiro;
    private boolean calcComissProd;
    private boolean calcComissServ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNaturezaDaOperacao() {
        return naturezaDaOperacao;
    }

    public void setNaturezaDaOperacao(String naturezaDaOperacao) {
        this.naturezaDaOperacao = naturezaDaOperacao;
    }

    public String getCaracteristicaDeOperacao() {
        return caracteristicaDeOperacao;
    }

    public void setCaracteristicaDeOperacao(String caracteristicaDeOperacao) {
        this.caracteristicaDeOperacao = caracteristicaDeOperacao;
    }

    public boolean isDimEstq() {
        return dimEstq;
    }

    public void setDimEstq(boolean dimEstq) {
        this.dimEstq = dimEstq;
    }

    public boolean isEntraDinheiro() {
        return entraDinheiro;
    }

    public void setEntraDinheiro(boolean entraDinheiro) {
        this.entraDinheiro = entraDinheiro;
    }

    public boolean isCalcComissProd() {
        return calcComissProd;
    }

    public void setCalcComissProd(boolean calcComissProd) {
        this.calcComissProd = calcComissProd;
    }

    public boolean isCalcComissServ() {
        return calcComissServ;
    }

    public void setCalcComissServ(boolean calcComissServ) {
        this.calcComissServ = calcComissServ;
    }
    

   
}
