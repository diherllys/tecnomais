package com.br.tecnomais.entity;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class VendaEntity {

    private Integer id;
    private String caixa;
    private String operacao;
    private String vendedor;
    private Double vlrTotal;
    private String formaPagamento;
    private String formaPagamento2;
    private String formaPagamento3;
    private String dataVenda;
    private Integer clienteID;
    private String status;
    private Double vlrForma1;
    private Double vlrForma2;
    private Double vlrForma3;
    private Integer parcelas;
    private String hora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
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

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
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
    

  

}
