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
public class ContasPagasEntity {

    private Integer contasPagasId;
    private String dataPagamento;
    private String dataVencimento;
    private String descricao;
    private Double vlrPago;
    private String fornecedor;
    private String tipoCobranca;
    private String obs;
    private Integer entradaId;
    private String usuario;
    private Integer contaPagarId;
    private String caixa;

    public ContasPagasEntity() {
        this.contaPagarId = 0;
    }

    public Integer getContasPagasId() {
        return contasPagasId;
    }

    public void setContasPagasId(Integer contasPagasId) {
        this.contasPagasId = contasPagasId;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getVlrPago() {
        return vlrPago;
    }

    public void setVlrPago(Double vlrPago) {
        this.vlrPago = vlrPago;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getTipoCobranca() {
        return tipoCobranca;
    }

    public void setTipoCobranca(String tipoCobranca) {
        this.tipoCobranca = tipoCobranca;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(Integer entradaId) {
        this.entradaId = entradaId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getContaPagarId() {
        return contaPagarId;
    }

    public void setContaPagarId(Integer contaPagarId) {
        this.contaPagarId = contaPagarId;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }
    
}
