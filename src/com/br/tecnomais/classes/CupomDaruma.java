/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.classes;

import br.com.daruma.jna.DUAL;
import com.br.tecnomais.dao.ImpressoraDarumaDAO;
import com.br.tecnomais.dao.VendaDAO;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.CupomEntity;
import com.br.tecnomais.entity.ImpressoraDarumaEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import com.br.tecnomais.vmovimentacao.FinalizaVendaView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class CupomDaruma {

    VendaEntity venda;
    CupomEntity cupomEntity;
    ClienteEntity ce;
    ImpressoraDarumaEntity impressoraDarumaEntity = new ImpressoraDarumaEntity();
    ImpressoraDarumaDAO impressoraDarumaDAO = new ImpressoraDarumaDAO();
    VendaDAO vendaDAO = new VendaDAO();
    private List<ProdutosVendaEntity> listaProdutos = new ArrayList<>();
    Double vlrTotal = 0.0;
    NovaData data = new NovaData();

    public CupomDaruma(VendaEntity venda, ClienteEntity ce, CupomEntity cue, ImpressoraDarumaEntity ide, List<ProdutosVendaEntity> listaProdutos, Double vlrTotal) {
        this.venda = venda;
        this.ce = ce;
        this.cupomEntity = cue;
        this.impressoraDarumaEntity = ide;
        this.listaProdutos = listaProdutos;
        this.vlrTotal = vlrTotal;

//        try {
//            impressoraDarumaEntity = impressoraDarumaDAO.retornaIde();
//        } catch (SQLException ex) {
//          ex.printStackTrace();
//        }
//        int tRetorno = DUAL.eBuscarPortaVelocidade();
//        int tRetorno = DUAL.
//        int tRetorno = DUAL.regTermica(impressoraDarumaEntity.getRegistroTermico());
//        int pRetorno = DUAL.regPortaComunicacao(impressoraDarumaEntity.getPortaComunicacao());
//        int pvRetorno = DUAL.regVelocidade(impressoraDarumaEntity.getPortaVelocidade());
//        int cGRetorno = DUAL.iConfigurarGuilhotina(Integer.parseInt(impressoraDarumaEntity.getStatusGuilhotina()),
//                Integer.parseInt(impressoraDarumaEntity.getTamanhoGuilhotina()));
//        int cG2Retorno = DUAL.regLinhasGuilhotina(impressoraDarumaEntity.getTamanhoGuilhotina());
//        int zRetorno = DUAL.regZeroCortado(impressoraDarumaEntity.getZeroCortadoStatus());
    }

    public void imprimirPreVendaDarumaVendas() {
        Integer codigoVenda = 0;
        try {
            codigoVenda = venda.getId();
        } catch (Exception ex) {
            Logger.getLogger(FinalizaVendaView.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        String armazenamento = "";
        String variavel = "";
        int iRetorno;

        variavel = "<b><da>" + cupomEntity.getCabecalho() + "</da></b>";
        armazenamento = variavel + "\n";

        variavel = cupomEntity.getEndereco();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "------------------------------------------------";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Caixa: " + venda.getCaixa() + "  Data/Hora: " + venda.getDataVenda() + " " + venda.getHora();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "      --------- DADOS DO CLIENTE --------";
        armazenamento = armazenamento + variavel + "\n";

        if (ce.getNome() != null && !ce.getNome().equals("")) {
            variavel = "Nome: " + ce.getNome();
            armazenamento = armazenamento + variavel + "\n";

        }

        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
            variavel = "Endereco: " + ce.getEndereco();
            armazenamento = armazenamento + variavel + "\n";
        }
        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
            variavel = "CPF: " + ce.getCnpjOuCpf();
            armazenamento = armazenamento + variavel + "\n";
        }

        variavel = "          ****** CUPOM NAO FISCAL ******";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Descricao   Cod   Quant   PrecoUN   PrecoTotal";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "------------------------------------------------";
        armazenamento = armazenamento + variavel;

        for (int i = 0; i < listaProdutos.size(); i++) {
            armazenamento = armazenamento + "\n" + imprimirCupomDarumaVendas(i);
        }//0 ao 15

        variavel = "\n----------------Resumo da Compra----------------";
        armazenamento = armazenamento + variavel + "\n";
        variavel = "Valor Total R$" + new DecimalFormat("0.00").format(vlrTotal);
        armazenamento = armazenamento + variavel + "\n";

        variavel = "<b>" + cupomEntity.getMensagem() + "<b>";
        armazenamento = armazenamento + variavel + "\n";

//        recebe = "<b>" + cupomEntity.getMensagem() + "<b>";
//        armazena = armazena + recebe + "\n";
        iRetorno = DUAL.iImprimirTexto(armazenamento, armazenamento.length());
        iRetorno = DUAL.iImprimirTexto("<sl>" + impressoraDarumaEntity.getNumSaltoLinhas() + "</sl>", 0);
        iRetorno = DUAL.iConfigurarGuilhotina(Integer.parseInt(impressoraDarumaEntity
                .getStatusGuilhotina()), Integer.parseInt(impressoraDarumaEntity.
                        getTamanhoGuilhotina()));
    }

    private String imprimirCupomDarumaVendas(int i) {
        String tipoDeVenda = "";
        String auxCodigo = "";
        String auxQuant = "";
        String auxPrecoUn = "";
        String esp1 = "            ";//12

        ProdutosVendaEntity auxP = new ProdutosVendaEntity();

        auxP = listaProdutos.get(i);
        auxCodigo = auxP.getCodigoProduto().toString();
        auxQuant = auxP.getQuantidade().toString();
        auxPrecoUn = auxP.getPrecoUnitario().toString();
        String tam = auxP.getProdutoServico() + "\n" + auxCodigo + " " + esp1 + "   " + auxQuant + "     R$" + new DecimalFormat("0.00").format(Double.parseDouble(auxPrecoUn) / 100) + "   R$" + new DecimalFormat("0.00").format(auxP.getPrecoTotal() / 100);
//        int iRetorno = DUAL.iImprimirTexto(auxP.getProdutoServico() + "\n" + auxCodigo + " " + esp1 + "   " + auxQuant + "     R$" + new DecimalFormat("0.00").format(Double.parseDouble(auxPrecoUn) / 100) + "   R$" + new DecimalFormat("0.00").format(auxP.getPrecoTotal() / 100), tam.length());
        vlrTotal += auxP.getPrecoTotal() / 100;
        return tam;
    }

    public void imprimirCabecalhoDaruma(String tfVlrParcelas, String tfDataVencimento) {
        String aux = retornaResumoPag(tfVlrParcelas);
        String aux2 = retornaResumoPagParcelado(tfVlrParcelas, tfDataVencimento);
        Integer codigoVenda = 0;

        String armazenamento = "";
        String variavel = "";
        int iRetorno;
        try {
            codigoVenda = vendaDAO.getLastCodigoVenda();
        } catch (Exception ex) {
            Logger.getLogger(FinalizaVendaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        variavel = "<b><da>" + cupomEntity.getCabecalho() + "</da></b>";
        armazenamento = variavel + "\n";

        variavel = cupomEntity.getEndereco();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "------------------------------------------------";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Caixa: " + venda.getCaixa() + "  Data/Hora: " + venda.getDataVenda() + " " + venda.getHora();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "      --------- DADOS DO CLIENTE --------";
        armazenamento = armazenamento + variavel + "\n";

        if (ce.getNome() != null && !ce.getNome().equals("")) {
            variavel = "Nome: " + ce.getNome();
            armazenamento = armazenamento + variavel + "\n";

        }

        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
            variavel = "Endereco: " + ce.getEndereco();
            armazenamento = armazenamento + variavel + "\n";
        }
        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
            variavel = "CPF: " + ce.getCnpjOuCpf();
            armazenamento = armazenamento + variavel + "\n";
        }
        variavel = "          ****** CUPOM NAO FISCAL ******";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Descricao   Cod   Quant   PrecoUN   PrecoTotal";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "------------------------------------------------";
        armazenamento = armazenamento + variavel;

        for (int i = 0; i < listaProdutos.size(); i++) {
            armazenamento = armazenamento + "\n" + imprimirCupomDarumaVendas(i);
        }//0 ao 15

        variavel = "\n----------------Resumo da Compra----------------";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "<b>" + aux + "</b>";
        armazenamento = armazenamento + variavel + "\n";

        variavel = aux2;
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Valor Total R$" + new DecimalFormat("0.00").format(vlrTotal);
        armazenamento = armazenamento + variavel + "\n";

        variavel = "<b>" + cupomEntity.getMensagem() + "<b>";
        armazenamento = armazenamento + variavel + "\n";

//        recebe = "<b>" + cupomEntity.getMensagem() + "<b>";
//        armazena = armazena + recebe + "\n";
        iRetorno = DUAL.iImprimirTexto(armazenamento, armazenamento.length());
        iRetorno = DUAL.iImprimirTexto("<sl>" + impressoraDarumaEntity.getNumSaltoLinhas() + "</sl>", 0);
        iRetorno = DUAL.iConfigurarGuilhotina(Integer.parseInt(impressoraDarumaEntity
                .getStatusGuilhotina()), Integer.parseInt(impressoraDarumaEntity.
                        getTamanhoGuilhotina()));
        iRetorno = DUAL.iAcionarGaveta(); //aciona gaveta daruma

    }

//    public void imprimirCabecalhoDaruma(String tfVlrParcelas, String tfDataVencimento) {
//        String aux = retornaResumoPag(tfVlrParcelas);
//        String aux2 = retornaResumoPagParcelado(tfVlrParcelas, tfDataVencimento);
//        Integer codigoVenda = 0;
//        try {
//            codigoVenda = vendaDAO.getLastCodigoVenda();
//        } catch (Exception ex) {
//            Logger.getLogger(FinalizaVendaView.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String tam = "<b><da>" + cupomEntity.getCabecalho() + "</da></b>";
//        int iRetorno = DUAL.iImprimirTexto("<b><da>" + cupomEntity.getCabecalho() + "</da></b>", tam.length());
//        tam = cupomEntity.getEndereco();
//        iRetorno = DUAL.iImprimirTexto(cupomEntity.getEndereco(), tam.length());
//        iRetorno = DUAL.iImprimirTexto("------------------------------------------------", 48);
//        tam = "Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString();
//        iRetorno = DUAL.iImprimirTexto("Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString(), tam.length());
//        tam = "Caixa: " + venda.getCaixa() + "  Data/Hora: " + venda.getDataVenda() + " " + venda.getHora();
//        iRetorno = DUAL.iImprimirTexto("Caixa: " + venda.getCaixa() + "  Data/Hora: " + venda.getDataVenda() + " " + venda.getHora(), tam.length());
////        iRetorno = DUAL.iImprimirTexto("Data/Hora: " + venda.getDataVenda() + " " + venda.getHora(), 0);
//        iRetorno = DUAL.iImprimirTexto("      --------- DADOS DO CLIENTE --------", 41);
//
//        if (ce.getNome() != null && !ce.getNome().equals("")) {
//            tam = "Nome: " + ce.getNome();
//            iRetorno = DUAL.iImprimirTexto("Nome: " + ce.getNome(), tam.length());
//        }
//
//        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
//            tam = "Endereco: " + ce.getEndereco();
//            iRetorno = DUAL.iImprimirTexto("Endereco: " + ce.getEndereco(), tam.length());
//        }
//        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
//            tam = "CPF: " + ce.getCnpjOuCpf();
//            iRetorno = DUAL.iImprimirTexto("CPF: " + ce.getCnpjOuCpf(), tam.length());
//        }
//        
//        iRetorno = DUAL.iImprimirTexto("          ****** CUPOM NAO FISCAL ******", 40);
//        iRetorno = DUAL.iImprimirTexto("Descricao   Cod   Quant   PrecoUN   PrecoTotal", 46);
//        iRetorno = DUAL.iImprimirTexto("------------------------------------------------", 48);
//        for (int i = 0; i < listaProdutos.size(); i++) {
//            imprimirCupomDarumaVendas(i);
//        }//0 ao 15
//        iRetorno = DUAL.iImprimirTexto("----------------Resumo da Compra----------------", 48);
//        iRetorno = DUAL.iImprimirTexto(aux, aux.length());
////        iRetorno = DUAL.iImprimirTexto("<b>" + aux + "</b>", tam.length());//      dll.FormataTX(aux, 2, 0, 0, 0, 1);
//        System.out.println("aux: " + aux);
//        iRetorno = DUAL.iImprimirTexto(aux2, aux.length());
//        System.out.println("aux2: " + aux2);
//        tam = "Valor Total R$" + new DecimalFormat("0.00").format(vlrTotal);
//        iRetorno = DUAL.iImprimirTexto("Valor Total R$" + new DecimalFormat("0.00").format(vlrTotal), tam.length());
//        tam = "<b>" + cupomEntity.getMensagem() + "<b>";
//        iRetorno = DUAL.iImprimirTexto("<b>" + cupomEntity.getMensagem() + "<b>", tam.length());//  dll.FormataTX("\n" + cupomEntity.getMensagem(), 2, 0, 0, 0, 1);
//        iRetorno = DUAL.iImprimirTexto("<sl>" + impressoraDarumaEntity.getNumSaltoLinhas() + "</sl>", 0);
//
//        iRetorno = DUAL.iConfigurarGuilhotina(Integer.parseInt(impressoraDarumaEntity
//                .getStatusGuilhotina()), Integer.parseInt(impressoraDarumaEntity.
//                        getTamanhoGuilhotina()));
////        iRetorno = DUAL.iAcionarGaveta(); //aciona gaveta daruma
//
//    }
    public void imprimirCabecalhoDarumaVendasRealizada() {
        String aux = retornaResumoPagRealizadas();
        String aux2 = retornaResumoPagParceladoRealizado();
        Integer codigoVenda = 0;
        try {
            codigoVenda = venda.getId();

        } catch (Exception ex) {
            Logger.getLogger(FinalizaVendaView.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        String armazenamento = "";
        String variavel = "";
        int iRetorno;

        variavel = "<b><da>" + cupomEntity.getCabecalho() + "</da></b>";
        armazenamento = variavel + "\n";

        variavel = cupomEntity.getEndereco();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "------------------------------------------------";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Caixa: " + venda.getCaixa() + "  Data/Hora: " + venda.getDataVenda() + " " + venda.getHora();
        armazenamento = armazenamento + variavel + "\n";

        variavel = "      --------- DADOS DO CLIENTE --------";
        armazenamento = armazenamento + variavel + "\n";

        if (ce.getNome() != null && !ce.getNome().equals("")) {
            variavel = "Nome: " + ce.getNome();
            armazenamento = armazenamento + variavel + "\n";

        }

        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
            variavel = "Endereco: " + ce.getEndereco();
            armazenamento = armazenamento + variavel + "\n";
        }
        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
            variavel = "CPF: " + ce.getCnpjOuCpf();
            armazenamento = armazenamento + variavel + "\n";
        }

        variavel = "          ****** CUPOM NAO FISCAL ******";
        armazenamento = armazenamento + variavel + "\n";
        
        variavel = "Descricao   Cod   Quant   PrecoUN   PrecoTotal";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "------------------------------------------------";
        armazenamento = armazenamento + variavel;

        for (int i = 0; i < listaProdutos.size(); i++) {
            armazenamento = armazenamento + "\n" + imprimirCupomDarumaVendas(i);
        }//0 ao 15
        
        variavel = "\n----------------Resumo da Compra----------------";
        armazenamento = armazenamento + variavel + "\n";

        variavel = "<b>" + aux + "</b>";
        armazenamento = armazenamento + variavel + "\n";

        variavel = aux2;
        armazenamento = armazenamento + variavel + "\n";

        variavel = "Valor Total R$" + new DecimalFormat("0.00").format(vlrTotal);
        armazenamento = armazenamento + variavel + "\n";

        variavel = "<b>" + cupomEntity.getMensagem() + "<b>";
        armazenamento = armazenamento + variavel + "\n";

//        recebe = "<b>" + cupomEntity.getMensagem() + "<b>";
//        armazena = armazena + recebe + "\n";
        iRetorno = DUAL.iImprimirTexto(armazenamento, armazenamento.length());
        iRetorno = DUAL.iImprimirTexto("<sl>" + impressoraDarumaEntity.getNumSaltoLinhas() + "</sl>", 0);
        iRetorno = DUAL.iConfigurarGuilhotina(Integer.parseInt(impressoraDarumaEntity
                .getStatusGuilhotina()), Integer.parseInt(impressoraDarumaEntity.
                        getTamanhoGuilhotina()));
         iRetorno = DUAL.iAcionarGaveta();
    }

    private String retornaResumoPagRealizadas() {
        String aux = "";

        if (venda.getFormaPagamento().equals("DINHEIRO")) {
            aux = aux + " D R$" + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100) + "  ";

            if (venda.getFormaPagamento2().equals("CARTAO CREDITO")) {
                aux = aux + " CC R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento2().equals("CARTAO DEBITO")) {
                aux = aux + " CD 1x R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento2().equals("CHEQUE")) {
                aux = aux + " CQ R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + "  ";
            }
            if (venda.getFormaPagamento3().equals("CARTAO CREDITO")) {
                aux = aux + " CC R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento3().equals("CARTAO DEBITO")) {
                aux = aux + " CD 1x R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento3().equals("CHEQUE")) {
                aux = aux + " CQ R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + "  ";
            }
            if (venda.getFormaPagamento2().equals("PARCELADO")) {
                aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + "  ";
            }
            if (venda.getFormaPagamento3().equals("PARCELADO")) {
                aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + "  ";
            }

        }

        if (venda.getFormaPagamento().equals("CARTAO CREDITO")) {
            aux = aux + " CC R$ " + (venda.getVlrForma1() / 100) + "x" + venda.getParcelas() + " de "
                    + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
        }
        if (venda.getFormaPagamento().equals("CARTAO DEBITO")) {
            aux = aux + " CD x1 R$" + vlrTotal;// corrigir se der merda era tfValorTotal.getText()
        }
        if (venda.getFormaPagamento().equals("CHEQUE")) {
            aux = aux + " CQ " + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
        }
        if (venda.getFormaPagamento().equals("PARCELADO")) {
            aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
            if (venda.getVlrForma2() > 0.00) {
                aux = aux + " D R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100);
            }
        }

        return aux;
    }

    public String retornaResumoPagParceladoRealizado() {
        String aux = "";
        if (venda.getFormaPagamento().equals("DINHEIRO")) {
            if (venda.getFormaPagamento2().equals("PARCELADO")) {
                String data = venda.getDataVenda();
                data = this.data.adiciona1Mes(data);
                aux = aux;
                Double vlr2 = (venda.getVlrForma2() / 100) / venda.getParcelas();
                for (int i = 1; i <= venda.getParcelas(); i++) {
                    aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlr2)
                            + " " + data;
                    if (i % 2 == 0 && i != venda.getParcelas()) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }
            if (venda.getFormaPagamento3().equals("PARCELADO")) {
                String data = venda.getDataVenda();
                data = this.data.adiciona1Mes(data);
                aux = aux;
                Double vlr3 = (venda.getVlrForma3() / 100) / venda.getParcelas();
                for (int i = 1; i <= venda.getParcelas(); i++) {
                    aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlr3)
                            + " " + data;
                    if (i % 2 == 0 && i != venda.getParcelas()) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }
        }
        if (venda.getFormaPagamento().equals("PARCELADO")) {
            String data = venda.getDataVenda();
            data = this.data.adiciona1Mes(data);
            aux = aux;
            Double vlr1 = (venda.getVlrForma1() / 100) / venda.getParcelas();
            for (int i = 1; i <= venda.getParcelas(); i++) {
                aux = aux + " P x" + i + " " + new DecimalFormat("0.00").format(vlr1)
                        + " " + data;
                if (i % 2 == 0 && i != venda.getParcelas()) {
                    aux = aux + "\n";
                }
                data = this.data.adiciona1Mes(data);
            }
        }
        return aux;
    }
//JTextField tfFormaPagamento, JTextField tfFormaPagamento2,JTextField tfFormaPagamento3,JTextField tfDataVencimento, JTextField tfParcelas

    public String retornaResumoPagParcelado(String tfVlrParcelas, String tfDataVencimento) {
        String aux = "";
        if (venda.getFormaPagamento().equals("DINHEIRO")) {
            if (venda.getFormaPagamento2().equals("PARCELADO")) {
                String data = tfDataVencimento;
                aux = aux;
                for (int i = 1; i <= venda.getParcelas(); i++) {
                    aux = aux + " P x" + i + " " + tfVlrParcelas.replace(".", ",")
                            + " " + data;
                    if (i % 2 == 0 && i != venda.getParcelas()) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }
            if (venda.getFormaPagamento3().equals("PARCELADO")) {
                String data = tfDataVencimento;
                aux = aux;
                for (int i = 1; i <= venda.getParcelas(); i++) {
                    aux = aux + " P x" + i + " " + tfVlrParcelas.replace(".", ",")
                            + " " + data;
                    if (i % 2 == 0 && i != venda.getParcelas()) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }

        }
        if (venda.getFormaPagamento().equals("PARCELADO")) {
            String data = tfDataVencimento;
            aux = aux;
            for (int i = 1; i <= venda.getParcelas(); i++) {
                aux = aux + " P x" + i + " " + tfVlrParcelas.replace(".", ",")
                        + " " + data;
                if (i % 2 == 0 && i != venda.getParcelas()) {
                    aux = aux + "\n";
                }
                data = this.data.adiciona1Mes(data);
            }
        }
        return aux;
    }

    private String retornaResumoPag(String tfVlrParcelas) {
        String aux = "";

        if (venda.getFormaPagamento().equals("DINHEIRO")) {
            aux = aux + " D R$" + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100) + "  ";

            if (venda.getFormaPagamento2().equals("CARTAO CREDITO")) {
                aux = aux + " CC R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento2().equals("CARTAO DEBITO")) {
                aux = aux + " CD R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento2().equals("CHEQUE")) {
                aux = aux + " CQ R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + "  ";
            }
            if (venda.getFormaPagamento3().equals("CARTAO CREDITO")) {
                aux = aux + " CC R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento3().equals("CARTAO DEBITO")) {
                aux = aux + " CD R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + " x1" + "  ";
            }
            if (venda.getFormaPagamento3().equals("CHEQUE")) {
                aux = aux + " CQ R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + "  ";
            }

            if (venda.getFormaPagamento2().equals("PARCELADO")) {
                aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100) + "  ";
            }
            if (venda.getFormaPagamento3().equals("PARCELADO")) {
                aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma3() / 100) + "  ";
            }
        }

        if (venda.getFormaPagamento().equals("CARTAO CREDITO")) {
            double temp = Double.parseDouble(tfVlrParcelas.replace(",", "."));
            System.out.println("Essa aqui... " + temp);
            aux = aux + " CC  x" + venda.getParcelas() + " de " + new DecimalFormat("0.00").format(temp);
        }
        if (venda.getFormaPagamento().equals("CARTAO DEBITO")) {
            aux = aux + " CD x1 R$" + new DecimalFormat("0.00").format(venda.getVlrTotal() / 100);
        }
        if (venda.getFormaPagamento().equals("CHEQUE")) {
            aux = aux + " CQ " + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
        }
        if (venda.getFormaPagamento().equals("PARCELADO")) {
            aux = aux + " P R$" + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
            if (venda.getVlrForma2() > 0.00) {
                aux = aux + " D R$" + new DecimalFormat("0.00").format(venda.getVlrForma2() / 100);
            }
        }
        return aux;
    }

}
