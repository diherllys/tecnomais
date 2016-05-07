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
public class BuscarVendaEntity {
    private ProdutoEntity produto;
    private ProdutosVendaEntity produtosVenda;
    private VendaEntity venda ;
    private ClienteEntity cliente;

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public ProdutosVendaEntity getProdutosVenda() {
        return produtosVenda;
    }

    public void setProdutosVenda(ProdutosVendaEntity produtosVenda) {
        this.produtosVenda = produtosVenda;
    }

    public VendaEntity getVenda() {
        return venda;
    }

    public void setVenda(VendaEntity venda) {
        this.venda = venda;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

}
