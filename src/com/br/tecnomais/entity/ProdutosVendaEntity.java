package com.br.tecnomais.entity;

import java.text.DecimalFormat;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class ProdutosVendaEntity {

    private Integer id;
    private Integer vendaID;
    private Integer codigoProduto;
    private Integer codigoDinamico;
    private String produtoServico;
    private String classe;
    private Double quantidade;
    private Double precoUnitario;
    private Double precoTotal;
    private Double descontoPorcentagem;
    private Double descontoReal;
    private Double precoFinal;
    private String status;

    public Integer getId() {
        return id;
    }

    public Integer getVendaID() {
        return vendaID;
    }

    public void setVendaID(Integer vendaID) {
        this.vendaID = vendaID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getProdutoServico() {
        return produtoServico;
    }

    public void setProdutoServico(String produtoServico) {
        this.produtoServico = produtoServico;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Double getDescontoPorcentagem() {
        return descontoPorcentagem;
    }

    public void setDescontoPorcentagem(Double descontoPorcentagem) {
        this.descontoPorcentagem = descontoPorcentagem;
    }

    public Double getDescontoReal() {
        return descontoReal;
    }

    public void setDescontoReal(Double descontoReal) {
        this.descontoReal = descontoReal;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCupom() {
        String texto = "";
        texto += ("Modelo") + "###";
        texto += ("Código: " + getCodigoDinamico() + "     Produto:  " + getProdutoServico() + "     Quant.:  " + new DecimalFormat("0.0").format(getQuantidade())) + "###";
        texto += ("Valor Unit.:  " + new DecimalFormat("0.00").format(getPrecoUnitario() / 100) + "  Val. Total:  " + new DecimalFormat("0.00").format(getPrecoTotal() / 100)) + "###";
//        texto += ("\n-------------------------------------------------------------------------------------- " + "\n");
        texto += ("\n\n");
        return texto;
    }

    public Integer getCodigoDinamico() {
        return codigoDinamico;
    }

    public void setCodigoDinamico(Integer codigoDinamico) {
        this.codigoDinamico = codigoDinamico;
    }
    
    

}
