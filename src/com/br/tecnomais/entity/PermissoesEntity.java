/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.entity;

/**
 *
 * @author Desenvolvimento
 */
public class PermissoesEntity {
    private int id;
    private int idUsuario;
    private int movimentacao;
    private int movContRecbPagFlxCaixa;
    private int cadastroFilial;
    private int cadastroUsuario;
    private int cadastro;
    private int configurarLogo;
    private int configurarImp;
    private int configurarPerm;
    private int escritorio;
    private int cancelarVenda;
    private int abrirGaveta;
    private int excluirMov;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(int movimentacao) {
        this.movimentacao = movimentacao;
    }

    public int getMovContRecbPagFlxCaixa() {
        return movContRecbPagFlxCaixa;
    }

    public void setMovContRecbPagFlxCaixa(int movContRecbPagFlxCaixa) {
        this.movContRecbPagFlxCaixa = movContRecbPagFlxCaixa;
    }

    public int getCadastroFilial() {
        return cadastroFilial;
    }

    public void setCadastroFilial(int cadastroFilial) {
        this.cadastroFilial = cadastroFilial;
    }

    public int getCadastroUsuario() {
        return cadastroUsuario;
    }

    public void setCadastroUsuario(int cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;
    }

    public int getCadastro() {
        return cadastro;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }

    public int getConfigurarLogo() {
        return configurarLogo;
    }

    public void setConfigurarLogo(int configurarLogo) {
        this.configurarLogo = configurarLogo;
    }

    public int getConfigurarImp() {
        return configurarImp;
    }

    public void setConfigurarImp(int configurarImp) {
        this.configurarImp = configurarImp;
    }

    public int getConfigurarPerm() {
        return configurarPerm;
    }

    public void setConfigurarPerm(int configurarPerm) {
        this.configurarPerm = configurarPerm;
    }

    public int getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(int escritorio) {
        this.escritorio = escritorio;
    }

    public int getCancelarVenda() {
        return cancelarVenda;
    }

    public void setCancelarVenda(int cancelarVenda) {
        this.cancelarVenda = cancelarVenda;
    }

    public int getAbrirGaveta() {
        return abrirGaveta;
    }

    public void setAbrirGaveta(int abrirGaveta) {
        this.abrirGaveta = abrirGaveta;
    }

    public int getExcluirMov() {
        return excluirMov;
    }

    public void setExcluirMov(int excluirMov) {
        this.excluirMov = excluirMov;
    }
    
}
