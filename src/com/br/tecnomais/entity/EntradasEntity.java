
package com.br.tecnomais.entity;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class EntradasEntity {
    
    private Integer codigoEntrada;
    private String fornecedor;
    private String caixa;
    private String operacao;
    private Double vlrTotal;
    private String dataEntrada;
    private String status;

    public Integer getCodigoEntrada() {
        return codigoEntrada;
    }

    public void setCodigoEntrada(Integer codigoEntrada) {
        this.codigoEntrada = codigoEntrada;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
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

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
