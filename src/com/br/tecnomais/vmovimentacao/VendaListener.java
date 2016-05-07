/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.vmovimentacao;

import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.ConfigurarTelaVendasEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.util.List;
import javax.swing.JList;

/**
 *
 * @author Desenvolvimento
 */
public interface VendaListener {

    void apagarLista();

    void selecionaOperacao(String operacao);

    void selecionaCliente(ClienteEntity cliente);

    ClienteEntity retornaCliente();

    void selecionaVendedor(String vendedor);

    void selecionaCaixa(String caixa);
    
    void selecionaCupom(VendaEntity ve, List<ProdutosVendaEntity> lista);

    void atualizaCfg(ConfigurarTelaVendasEntity ctve);
    
    void CancelarVendaEfetivada();
}
