

package com.br.tecnomais.entity;

/**
 *
 * @author Reginaldo
 */
public class ContasReceberEntity {
    
    private Integer ContaID;
    private Integer VendaID;
    private Integer ClienteID;
    private Double vlrTotal;
    private Double vlrPago;
    private Double vlrParcelas;
    private int quantidadeParcelas;
    private String dataVencimento;

    public Integer getContaID() {
        return ContaID;
    }

    public void setContaID(Integer ContaID) {
        this.ContaID = ContaID;
    }

    public Integer getVendaID() {
        return VendaID;
    }

    public void setVendaID(Integer VendaID) {
        this.VendaID = VendaID;
    }

    public Integer getClienteID() {
        return ClienteID;
    }

    public void setClienteID(Integer ClienteID) {
        this.ClienteID = ClienteID;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Double getVlrRestante() {
        return vlrPago;
    }

    public void setVlrRestante(Double vlrPago) {
        this.vlrPago = vlrPago;
    }

    public Double getVlrParcelas() {
        return vlrParcelas;
    }

    public void setVlrParcelas(Double vlrParcelas) {
        this.vlrParcelas = vlrParcelas;
    }

    public Double getVlrPago() {
        return vlrPago;
    }

    public void setVlrPago(Double vlrPago) {
        this.vlrPago = vlrPago;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }


    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    
}
