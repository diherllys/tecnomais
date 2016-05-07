/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.classes;

import com.br.tecnomais.dao.VendaDAO;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.CupomEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import com.br.tecnomais.vmovimentacao.FinalizaVendaView;
import com.sun.jna.Native;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class CupomBematch {

    VendaEntity venda;
    CupomEntity cupomEntity;
    ClienteEntity ce;
    VendaDAO vendaDAO = new VendaDAO();
    private List<ProdutosVendaEntity> listaProdutos = new ArrayList<>();
    Double vlrTotal = 0.0;
    NovaData data = new NovaData();
    MP2032 dll = (MP2032) Native.loadLibrary("mp2032.dll", MP2032.class);

    public CupomBematch(MP2032 dll, VendaEntity venda, ClienteEntity ce, CupomEntity cue, List<ProdutosVendaEntity> listaProdutos, Double vlrTotal) {
        this.venda = venda;
        this.ce = ce;
        this.cupomEntity = cue;
        this.listaProdutos = listaProdutos;
        this.vlrTotal = vlrTotal;
        this.dll = dll;
    }

    public void imprimirPreVendaBematechVendas() {
        Integer codigoVenda = 0;
        try {
            codigoVenda = venda.getId();

        } catch (Exception ex) {
            Logger.getLogger(FinalizaVendaView.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        dll.AjustaLarguraPapel(600);
        dll.FormataTX(cupomEntity.getCabecalho() + "\n", 2, 0, 0, 1, 1);
        dll.FormataTX(cupomEntity.getEndereco() + "\n", 2, 0, 0, 0, 0);
        dll.BematechTX("--------------------------------------------------\n");
        dll.BematechTX("Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString());
//        dll.BematechTX("Cupom: " + codigoVenda.toString());
        dll.BematechTX("\nCaixa: " + venda.getCaixa());
        dll.BematechTX("   Data/Hora: " + venda.getDataVenda() + " " + venda.getHora());
        dll.BematechTX("\n       --------- DADOS DO CLIENTE ---------\n");

        if (ce.getNome() != null && !ce.getNome().equals("")) {
            dll.BematechTX("Nome: " + ce.getNome() + "\n");
        }

        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
            dll.BematechTX("Endereco: " + ce.getEndereco() + "\n");
        }
        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
            dll.BematechTX("CPF: " + ce.getCnpjOuCpf() + "\n");
        }
        dll.BematechTX("          ****** CUPOM NAO FISCAL ******\n");
        dll.BematechTX("Descricao   Cod   Quant   PrecoUN   PrecoTotal\n");
        dll.BematechTX("-------------------------------------------------\n");
        for (int i = 0; i < listaProdutos.size(); i++) {
            imprimirCupomBematech(i);
        }//0 ao 15
        dll.BematechTX("----------------Resumo da Compra-----------------\n");
        dll.BematechTX("\nValor Total R$" + new DecimalFormat("0.00").format(vlrTotal));
        dll.FormataTX("\n" + cupomEntity.getMensagem(), 2, 0, 0, 0, 1);

        dll.AcionaGuilhotina(1);
    }

    private void imprimirCupomBematech(int i) {
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
        dll.BematechTX(auxP.getProdutoServico() + "\n" + auxCodigo + " " + esp1 + "   " + auxQuant + "     R$" + new DecimalFormat("0.00").format(Double.parseDouble(auxPrecoUn) / 100) + "   R$" + new DecimalFormat("0.00").format(auxP.getPrecoTotal() / 100) + "\n");
    }

    public void imprimirCabecalhoBematechVendas() {
        String aux = retornaResumoPagVendas();
        String aux2 = retornaResumoPagParceladoVendas();
        Integer codigoVenda = 0;
        try {
            codigoVenda = venda.getId();

        } catch (Exception ex) {
            Logger.getLogger(FinalizaVendaView.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        dll.AjustaLarguraPapel(600);
        dll.FormataTX(cupomEntity.getCabecalho() + "\n", 2, 0, 0, 1, 1);
        dll.FormataTX(cupomEntity.getEndereco() + "\n", 2, 0, 0, 0, 0);
        dll.BematechTX("--------------------------------------------------\n");
        dll.BematechTX("Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString());
        dll.BematechTX("\nCaixa: " + venda.getCaixa());
        dll.BematechTX("   Data/Hora: " + venda.getDataVenda() + " " + venda.getHora());
        dll.BematechTX("\n       --------- DADOS DO CLIENTE ---------\n");

        if (ce.getNome() != null && !ce.getNome().equals("")) {
            dll.BematechTX("Nome: " + ce.getNome() + "\n");
        }

        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
            dll.BematechTX("Endereco: " + ce.getEndereco() + "\n");
        }
        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
            dll.BematechTX("CPF: " + ce.getCnpjOuCpf() + "\n");
        }
        dll.BematechTX("          ****** CUPOM NAO FISCAL ******\n");
        dll.BematechTX("Descricao   Cod   Quant   PrecoUN   PrecoTotal\n");
        dll.BematechTX("-------------------------------------------------\n");
        for (int i = 0; i < listaProdutos.size(); i++) {
            imprimirCupomBematech(i);
        }//0 ao 15
        dll.BematechTX("----------------Resumo da Compra-----------------\n");
        dll.FormataTX(aux, 2, 0, 0, 0, 1);
        System.out.println("aux: " + aux);
        dll.BematechTX(aux2);
        System.out.println("aux2: " + aux2);
        dll.BematechTX("\nValor Total R$" + new DecimalFormat("0.00").format(vlrTotal / 100));
        dll.FormataTX("\n" + cupomEntity.getMensagem(), 2, 0, 0, 0, 1);

        dll.AcionaGuilhotina(1);
    }

    private String retornaResumoPagVendas() {
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
            aux = aux + " CC R$ " + (venda.getVlrForma1() / 100) + "x" + venda.getParcelas() + " de "
                    + new DecimalFormat("0.00").format(venda.getVlrForma1() / 100);
        }
        if (venda.getFormaPagamento().equals("CARTAO DEBITO")) {
            aux = aux + " CD x1" + vlrTotal;
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

    public String retornaResumoPagParceladoVendas() {
        String aux = "";
        if (venda.getFormaPagamento().equals("DINHEIRO")) {
            if (venda.getFormaPagamento2().equals("PARCELADO")) {
                String data = venda.getDataVenda();
                data = this.data.adiciona1Mes(data);
                aux = aux + "\n";
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
                aux = aux + "\n";
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
            aux = aux + "\n";
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

    public void imprimirCabecalhoBematech(String tfDataVencimento, String tfVlrParcelado) {
        String aux = retornaResumoPag(tfVlrParcelado);
        String aux2 = retornaResumoPagParcelado(tfVlrParcelado, tfDataVencimento);
        Integer codigoVenda = 0;

        try {
            codigoVenda = vendaDAO.getLastCodigoVenda();
        } catch (Exception ex) {

        }
        String hora = String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
        dll.AjustaLarguraPapel(600);
        dll.FormataTX(cupomEntity.getCabecalho() + "\n", 2, 0, 0, 1, 1);
        dll.FormataTX(cupomEntity.getEndereco() + "\n", 2, 0, 0, 0, 0);
        dll.BematechTX("--------------------------------------------------\n");
        dll.BematechTX("Operacao: " + venda.getOperacao() + "    Cupom: " + codigoVenda.toString());
        dll.BematechTX("\nCaixa: " + venda.getCaixa());
        dll.BematechTX("   Data/Hora: " + data.dataAtual() + " " + hora);
        dll.BematechTX("       --------- DADOS DO CLIENTE ---------\n");

        if (ce.getNome() != null && !ce.getNome().equals("")) {
            dll.BematechTX("Nome: " + ce.getNome() + "\n");
        }

        if (ce.getEndereco() != null && !ce.getEndereco().equals("")) {
            dll.BematechTX("Endereco: " + ce.getEndereco() + "\n");
        }
        if (ce.getCnpjOuCpf() != null && !ce.getCnpjOuCpf().equals("")) {
            dll.BematechTX("CPF: " + ce.getCnpjOuCpf() + "\n");
        }

        dll.BematechTX("          ****** CUPOM NAO FISCAL ******\n");
        dll.BematechTX("Descricao   Cod   Quant   PrecoUN   PrecoTotal\n");
        dll.BematechTX("-------------------------------------------------\n");
        for (int i = 0; i < listaProdutos.size(); i++) {
            imprimirCupomBematech(i);
        }//0 ao 15
        dll.BematechTX("----------------Resumo da Compra-----------------\n");
        dll.FormataTX(aux, 2, 0, 0, 0, 1);
        dll.BematechTX(aux2);
        dll.BematechTX("\nValor Total R$" + new DecimalFormat("0.00").format(vlrTotal));
        dll.FormataTX("\n" + cupomEntity.getMensagem(), 2, 0, 0, 0, 1);
        dll.AcionaGuilhotina(1);

        //System.out.println("entrou aqui seu bosta");

       
//
//        dll.BematechTX("<ESC><118><140>");
//        dll.ComandoTX("ESC><118><140>", 1);
    }

    public String retornaResumoPagParcelado(String tfVlrParcelas, String tfDataVencimento) {
        String aux = "";
        if (venda.getFormaPagamento().equals("DINHEIRO")) {
            if (venda.getFormaPagamento2().equals("PARCELADO")) {
                String data = tfDataVencimento;
                aux = aux + "\n";
                for (int i = 1; i <= venda.getParcelas(); i++) {
                    aux = aux + " P x" + i + " " + tfVlrParcelas.replace(".", ",") + " " + data;
                    if (i % 2 == 0 && i != venda.getParcelas()) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }
            if (venda.getFormaPagamento3().equals("PARCELADO")) {
                String data = tfDataVencimento;
                aux = aux + "\n";
                for (int i = 1; i <= venda.getParcelas(); i++) {
                    aux = aux + " P x" + i + " " + tfVlrParcelas.replace(".", ",") + " " + data;
                    if (i % 2 == 0 && i != venda.getParcelas()) {
                        aux = aux + "\n";
                    }
                    data = this.data.adiciona1Mes(data);
                }
            }

        }
        if (venda.getFormaPagamento().equals("PARCELADO")) {
            String data = tfDataVencimento;
            aux = aux + "\n";
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
            aux = aux + " CC  x" + venda.getParcelas() + " " + tfVlrParcelas;
        }

        if (venda.getFormaPagamento().equals("CARTAO DEBITO")) {
            aux = aux + " CD x1" + new DecimalFormat("0.00").format(vlrTotal);
        }

        if (venda.getFormaPagamento().equals("CHEQUE")) {
            aux = aux + " CQ " + venda.getFormaPagamento();
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
