package com.br.tecnomais.relatorios;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.InventarioEntity;
import com.br.tecnomais.entity.ProdutosEntradaEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FalcatruaDAO extends ConectaBanco {

    private Double somaCartaoCredito = 0.0;
    private Double somaCartaoDebito = 0.0;
    private Double somaParcelado = 0.0;
    private Double somaDinheiro = 0.0;

    public FalcatruaDAO() {
        try {
            dinheiroTotal(null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Double dinheiroTotal(String diaI, String diaF) throws SQLException {
        conectar();
        String sql = "select * from tb_vendas where convert(datetime, dataVenda, 103) between convert(datetime, ?, 103) and convert(datetime, ?, 103)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, diaI);
        stmt.setString(2, diaF);
        rs = stmt.executeQuery();
        while (rs.next()) {
            //DINHEIRO
            if (rs.getString("formaDePagamento").equals("DINHEIRO")) {
                somaDinheiro = somaDinheiro + rs.getDouble("vlrForma1");
            }
            if (rs.getString("formaDePagamento2").equals("DINHEIRO")) {
                somaDinheiro = somaDinheiro + rs.getDouble("vlrForma2");
            }
            if (rs.getString("formaDePagamento3").equals("DINHEIRO")) {
                somaDinheiro = somaDinheiro + rs.getDouble("vlrForma3");
            }

            //CARTÃO DE CREDITO
            if (rs.getString("formaDePagamento").equals("CARTAO CREDITO")) {
                somaCartaoCredito = somaCartaoCredito + rs.getDouble("vlrForma1");
            }
            if (rs.getString("formaDePagamento2").equals("CARTAO CREDITO")) {
                somaCartaoCredito = somaCartaoCredito + rs.getDouble("vlrForma2");
            }
            if (rs.getString("formaDePagamento3").equals("CARTAO CREDITO")) {
                somaCartaoCredito = somaCartaoCredito + rs.getDouble("vlrForma3");
            }

            //CARTAO DEBITO
            if (rs.getString("formaDePagamento").equals("CARTAO DEBITO")) {
                somaCartaoDebito = somaCartaoDebito + rs.getDouble("vlrForma1");
            }
            if (rs.getString("formaDePagamento2").equals("CARTAO DEBITO")) {
                somaCartaoDebito = somaCartaoDebito + rs.getDouble("vlrForma2");
            }
            if (rs.getString("formaDePagamento3").equals("CARTAO DEBITO")) {
                somaCartaoDebito = somaCartaoDebito + rs.getDouble("vlrForma3");
            }

            //PARCELADO
            if (rs.getString("formaDePagamento").equals("PARCELADO")) {
                somaParcelado = somaParcelado + rs.getDouble("vlrForma1");
            }
            if (rs.getString("formaDePagamento2").equals("PARCELADO")) {
                somaParcelado = somaParcelado + rs.getDouble("vlrForma2");
            }
            if (rs.getString("formaDePagamento3").equals("PARCELADO")) {
                somaParcelado = somaParcelado + rs.getDouble("vlrForma3");
            }
        }

        System.out.println("PARCELADO : " + somaParcelado);
        System.out.println("cartao DEBITO: " + somaCartaoDebito);
        System.out.println("cartao CREDITO: " + somaCartaoCredito);
        System.out.println("dinheiro : " + somaDinheiro);
        return somaDinheiro;
    }

    public Double totalCartaoCredito() throws SQLException {
        return somaCartaoCredito;
    }

    public Double totalCartaoDebito() throws SQLException {
        return somaCartaoDebito;
    }

    public Double totalParcelado() throws SQLException {
        return somaParcelado;
    }

    public Double totalGeral() {
        return somaCartaoCredito + somaParcelado + somaCartaoDebito + somaDinheiro;
    }

    public List<ProdutosVendaEntity> listaProdutosVendidos(String dataI) throws Exception {
        conectar();
        List<ProdutosVendaEntity> lista = new ArrayList<>();
        String sql = "select prod.produtoID, sum(prod.qntVendida) - (select sum(quantidade) from tb_produtosEntrada as pe inner join tb_entradas as ent on ent.codigoEntrada = pe.codigoEntrada and convert(datetime, ent.dataEntrada, 103) >= CONVERT(datetime, ?, 103) and prod.produtoID = codigoProduto) as qntVendida from tb_produtosVendidos as prod inner join tb_vendas as v on v.codigoVendas = prod.vendaID and convert(datetime, v.dataVenda, 103) >= convert(datetime, ?, 103) group by prod.produtoID";
//        String sql = "select produtoID, sum(qntVendida) as qntVendida from tb_produtosVendidos as p inner join tb_vendas as v on p.vendaID = v.codigoVendas and CONVERT(datetime, v.dataVenda, 103) >= CONVERT(datetime, ?, 103) group by produtoID";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataI);
        stmt.setString(2, dataI);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ProdutosVendaEntity pr = new ProdutosVendaEntity();
            pr.setCodigoProduto(rs.getInt("produtoID"));
            pr.setQuantidade(rs.getDouble("qntVendida"));
            lista.add(pr);
        }
        return lista;
    }

    public List<ProdutosVendaEntity> listaEstoqueProdutos() throws Exception {
        conectar();
        List<ProdutosVendaEntity> lista = new ArrayList<>();
        String sql = "select id, qntAtual from tb_produtos";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ProdutosVendaEntity p = new ProdutosVendaEntity();
            p.setCodigoProduto(rs.getInt("id"));
            p.setQuantidade(rs.getDouble("qntAtual"));
            lista.add(p);
        }
        return lista;
    }
    
    public List<ProdutosEntradaEntity> listaProdutosEntradas(String data) throws Exception {
        conectar();
        List<ProdutosEntradaEntity> lista = new ArrayList<>();
        String sql = "select p.codigoProduto, sum(p.quantidade) as quantidade from tb_produtosEntrada as p inner join tb_entradas as e on e.codigoEntrada = p.codigoEntrada and CONVERT(datetime, e.dataEntrada, 103) >= CONVERT(datetime, ?, 103) group by p.codigoProduto";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, data);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ProdutosEntradaEntity p = new ProdutosEntradaEntity();
            p.setCodigoProduto(rs.getInt("codigoProduto"));
            p.setQuantidade(rs.getDouble("quantidade"));
            lista.add(p);
        }
        return lista;
    }

    public void geraInventarioTemporario(InventarioEntity inv) throws Exception {
        conectar();
        String sql = "insert into tb_inventario (Codigo, Quantidade) values(?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, inv.getCodigoProduto());
        stmt.setDouble(2, inv.getQuantidade());
        stmt.executeUpdate();
    }

    public void deletaInventario() throws Exception {
        conectar();
        String sql = "delete from tb_inventario";
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }
}
