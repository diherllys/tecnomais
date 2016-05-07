/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.entity;

/**
 *
 * @author Usuario
 */
public class EntradaFinanceiroEntity {

    private String descricao;
    private String dataEmissao;
    private String usuario;
    private String fornecedor;
    
    private Integer codigoEntrada;
    private String caixa;
    private String operacao;

    private Double vlrTotal;
    private String formaPagamento;
    private String formaPagamento2;
    private String formaPagamento3;
    private String dataVencimento;
    

    private String status;
    private Double vlrForma1;
    private Double vlrForma2;
    private Double vlrForma3;
    private Integer parcelas;
    private String hora;
    
    private Integer intervaloDias;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getEntradaFincId() {
        return codigoEntrada;
    }

    public void setCodigoEntrada(Integer entradaFincId) {
        this.codigoEntrada = entradaFincId;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getFormaPagamento2() {
        return formaPagamento2;
    }

    public void setFormaPagamento2(String formaPagamento2) {
        this.formaPagamento2 = formaPagamento2;
    }

    public String getFormaPagamento3() {
        return formaPagamento3;
    }

    public void setFormaPagamento3(String formaPagamento3) {
        this.formaPagamento3 = formaPagamento3;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getVlrForma1() {
        return vlrForma1;
    }

    public void setVlrForma1(Double vlrForma1) {
        this.vlrForma1 = vlrForma1;
    }

    public Double getVlrForma2() {
        return vlrForma2;
    }

    public void setVlrForma2(Double vlrForma2) {
        this.vlrForma2 = vlrForma2;
    }

    public Double getVlrForma3() {
        return vlrForma3;
    }

    public void setVlrForma3(Double vlrForma3) {
        this.vlrForma3 = vlrForma3;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getIntervaloDias() {
        return intervaloDias;
    }

    public void setIntervaloDias(Integer intervaloDias) {
        this.intervaloDias = intervaloDias;
    }

   
    
}
