package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desenvolvimento Diherllys
 */
public class ProdutosVendaDAO extends ConectaBanco {

    String sql = "";
    VendaDAO vdao = new VendaDAO();

    public void save(ProdutosVendaEntity pve) {
        try {
            conectar();
            int codigo = vdao.getLastCodigoVenda();
//            pve.setVendaID(codigo);
            System.out.println(codigo + " Venda Codigo");
            String sql = "INSERT INTO tb_produtosVendidos (vendaID, produtoID, qntVendida, valorTotal, produtoCodigoDinamico) VALUES (?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setInt(2, pve.getId());
            stmt.setDouble(3, pve.getQuantidade());
            stmt.setDouble(4, pve.getPrecoTotal());
            stmt.setInt(5, pve.getCodigoDinamico());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void updateCodigoDinamicoPrtVendidos(Integer idPrt, Integer novoCod) {
        try {
            conectar();
            int codigo = vdao.getLastCodigoVenda();
//            pve.setVendaID(codigo);
            System.out.println(codigo + " Venda Codigo");
            String sql = "update tb_produtosVendidos set produtoCodigoDinamico=? where produtoId=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, novoCod);
            stmt.setInt(2, idPrt);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateCodigoDinamicoPrtEntrada(Integer idPrt, Integer novoCod) {
        try {
            conectar();
            int codigo = vdao.getLastCodigoVenda();
//            pve.setVendaID(codigo);
            System.out.println(codigo + " Venda Codigo");
            String sql = "update tb_produtosEntrada set codigoProdutoDinamico=? where codigoProduto=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, novoCod);
            stmt.setInt(2, idPrt);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void devolucao(ProdutosVendaEntity pve) {
        try {
            conectar();
            Double quantAtual = pesqQuant(pve.getCodigoProduto());
            sql = "update tb_produtos set qntAtual = ? where id = ? ";
            stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, pve.getQuantidade() + quantAtual);
            stmt.setInt(2, pve.getCodigoProduto());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Double pesqQuant(Integer id) throws SQLException {
        conectar();
        sql = "select qntAtual from tb_produtos where id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        Double auxD = 0.00;
        while (rs.next()) {
            auxD = rs.getDouble("qntAtual");
        }
        return auxD;
    }

    public void daBaixaEsq(Double quantBaixa, Integer id) {
        try {
            conectar();
//            Double quantAtual = pesqQuant(id);
            String sql = "UPDATE tb_produtos SET qntAtual = qntAtual - ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, quantBaixa);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProdutosVendaEntity> listaProdutosDaVenda(int codigoVenda) throws Exception {
        List<ProdutosVendaEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT * FROM tb_produtos AS p INNER JOIN tb_produtosVendidos AS pv ON pv.vendaID = ? AND p.id = pv.produtoID";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoVenda);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ProdutosVendaEntity prod = new ProdutosVendaEntity();
            prod.setId(rs.getInt("produtoID"));
            prod.setCodigoProduto(rs.getInt("produtoCodigoDinamico"));
            prod.setQuantidade(rs.getDouble("qntVendida"));
            prod.setPrecoUnitario(rs.getDouble("precoDeVenda"));
            prod.setProdutoServico(rs.getString("nome"));
            prod.setPrecoTotal(rs.getDouble("valorTotal"));
            prod.setCodigoDinamico(rs.getInt("produtoCodigoDinamico"));
            lista.add(prod);
        }
        return lista;
    }

    public void excluirProdutosVendidos(int codigoVenda) throws Exception {
        conectar();
        String sql = "DELETE FROM tb_produtosVendidos WHERE vendaID = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoVenda);
        stmt.executeUpdate();
    }

    public List<ProdutosVendaEntity> prtVendidosPorIdSaida(int codigoVenda) throws SQLException {

        List<ProdutosVendaEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT * FROM tb_produtos AS p INNER JOIN tb_produtosVendidos AS pv ON pv.vendaID = ? AND p.id = pv.produtoID";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoVenda);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ProdutosVendaEntity prod = new ProdutosVendaEntity();
            prod.setCodigoProduto(rs.getInt("produtoID"));
            prod.setQuantidade(rs.getDouble("qntVendida"));
            prod.setPrecoUnitario(rs.getDouble("precoDeVenda"));
            prod.setProdutoServico(rs.getString("nome"));
            prod.setPrecoTotal(rs.getDouble("valorTotal"));
            prod.setCodigoDinamico(rs.getInt("produtoCodigoDinamico"));
            lista.add(prod);
        }
        return lista;
    }

}
