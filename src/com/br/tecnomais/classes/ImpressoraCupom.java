package com.br.tecnomais.classes;

import br.com.daruma.jna.DUAL;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class ImpressoraCupom {

    public void imprimirRecibo(List<ProdutosVendaEntity> listaProdutos, String tipoDeVenda) {
        List<ProdutosVendaEntity> st = new ArrayList<>();
        st = listaProdutos;
        String auxCodigo = "";
        String auxQuant = "";
        String auxPrecoUn = "";
        Double valorTotal = 0.00;
        ProdutosVendaEntity auxP = new ProdutosVendaEntity();
        int iRetorno = DUAL.iImprimirTexto("<b><ce><da>TecnoMais</da></ce></b>", 0);
        iRetorno = DUAL.iImprimirTexto("<b><ce><da>Automacao Comercial (88)????-????</da></ce></b>", 0);
        for (int i = 0; i < st.size(); i++) {
            auxP = st.get(i);
            auxCodigo = auxP.getCodigoProduto().toString();
            auxQuant = auxP.getQuantidade().toString();
            auxPrecoUn = auxP.getPrecoUnitario().toString();
            while (auxCodigo.length() < 7) {
                auxCodigo += " ";
            }
            while (auxQuant.length() < 10) {
                auxQuant += " ";
            }
            while (auxPrecoUn.length() < 9) {
                auxPrecoUn += " ";
            }
            iRetorno = DUAL.iImprimirTexto("<b>  Codigo     Nome</b>", 0);
            iRetorno = DUAL.iImprimirTexto("  " + auxCodigo + "    " + auxP.getProdutoServico(), 0);
            iRetorno = DUAL.iImprimirTexto("<b>  Quant      PrecoUn       VlrTotal</b>", 0);
            iRetorno = DUAL.iImprimirTexto("  " + "" + auxQuant + " R$ " + new DecimalFormat("0.00").format(Double.parseDouble(auxPrecoUn) / 100) + "   R$ " + new DecimalFormat("0.00").format(auxP.getPrecoTotal() / 100), 0);
            iRetorno = DUAL.iImprimirTexto("<b>  _______________________________________</b>", 0);
            valorTotal += auxP.getPrecoTotal();
        }
//      valorTotal =  new DecimalFormat("0.00").format(valorTotal);
        iRetorno = DUAL.iImprimirTexto("Valor total da compra: R$" + new DecimalFormat("0.00").format(valorTotal / 100), 0);
        if (tipoDeVenda.equals("ORÇAMENTO")) {
            tipoDeVenda = "Orcamento";
        }
        iRetorno = DUAL.iImprimirTexto("Tipo de Operacao: " + tipoDeVenda, 0);
        iRetorno = DUAL.iImprimirTexto("<gui></gui>", 0);
    }
}
