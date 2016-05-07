package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.MovimentacaoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class MovimentacaoDAO extends ConectaBanco {

    public void inserirValorMovimentacao(MovimentacaoEntity mov) throws Exception {
        conectar();
        String sql = "INSERT INTO tb_movimentacao (VendaID, EntradaID, ContaID, Descricao, TipoMovimento, Valor, DataMovimento, ContaPagarId, Caixa, TipoDePagamento) VALUES(?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, mov.getIdVenda());
        stmt.setInt(2, mov.getIdEntrada());
        stmt.setInt(3, mov.getIdConta());
        stmt.setString(4, mov.getDescricao());
        stmt.setString(5, mov.getTipoMovimento());
        stmt.setDouble(6, mov.getValor());
        stmt.setString(7, mov.getDataMovimento());
        stmt.setInt(8, mov.getIdContaPagar());
        stmt.setString(9, mov.getCaixa());
        stmt.setString(10, mov.getTipoDePagamento());
        stmt.executeUpdate();
    }

    public List<MovimentacaoEntity> listaFluxoCaixa() throws Exception {
        List<MovimentacaoEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT top 150 * FROM tb_movimentacao WHERE Valor != 0.0 ORDER BY IdMovimento desc";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            MovimentacaoEntity m = new MovimentacaoEntity();
            m.setIdMovimento(rs.getInt("IdMovimento"));
            m.setDescricao(rs.getString("Descricao"));
            m.setTipoMovimento(rs.getString("TipoMovimento"));
            m.setValor(rs.getDouble("Valor") / 100);
            m.setDataMovimento(rs.getString("DataMovimento"));
            m.setIdContaPagar(rs.getInt("ContaPagarId"));
            m.setIdVenda(rs.getInt("VendaId"));
            m.setIdEntrada(rs.getInt("EntradaId"));
            m.setIdContaPagar(rs.getInt("ContaId"));
            m.setCaixa(rs.getString("Caixa"));
            m.setTipoDePagamento(rs.getString("TipoDePagamento"));
            lista.add(m);
        }
        return lista;
    }

    public double getValorSaidas() throws Exception {
        double valor = 0;
        conectar();
        String sql = "SELECT * FROM tb_movimentacao WHERE Valor != 0.0 and TipoMovimento = 'Saida'";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            valor += rs.getDouble("Valor") / 100;
        }
        return valor;
    }

    public double getValorTotalEntradas() throws Exception {
        double valor = 0;
        conectar();
        String sql = "SELECT * FROM tb_movimentacao WHERE Valor != 0.0 and TipoMovimento = 'Entrada'";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            valor += rs.getDouble("Valor") / 100;
        }
        return valor;
    }

    public List<MovimentacaoEntity> consultaPorData(String dataI, String dataF) throws Exception {
        List<MovimentacaoEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT * FROM tb_movimentacao WHERE Valor != 0.0 AND convert(datetime, DataMovimento, 103) BETWEEN convert(datetime, ?, 103) AND convert(datetime, ?, 103) ORDER BY IdMovimento desc";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataI);
        stmt.setString(2, dataF);
        rs = stmt.executeQuery();
        while (rs.next()) {
            MovimentacaoEntity mov = new MovimentacaoEntity();
            mov.setIdMovimento(rs.getInt("IdMovimento"));
            mov.setDescricao(rs.getString("Descricao"));
            mov.setTipoMovimento(rs.getString("TipoMovimento"));
            mov.setValor(rs.getDouble("Valor") / 100);
            mov.setDataMovimento(rs.getString("DataMovimento"));
            mov.setIdContaPagar(rs.getInt("ContaPagarId"));
            mov.setIdVenda(rs.getInt("VendaId"));
            mov.setIdEntrada(rs.getInt("EntradaId"));
            mov.setIdContaPagar(rs.getInt("ContaId"));
            mov.setCaixa(rs.getString("Caixa"));
            mov.setTipoDePagamento(rs.getString("TipoDePagamento"));
            lista.add(mov);
        }
        return lista;
    }

    public double getValorEntradaPorData(String dataI, String dataF) throws Exception {
        double valor = 0;
        conectar();
        String sql = "SELECT * FROM tb_movimentacao WHERE Valor != 0.0 AND TipoMovimento = 'Entrada' AND convert(datetime, DataMovimento, 103) BETWEEN convert(datetime, ?, 103) AND convert(datetime, ?, 103) ORDER BY IdMovimento desc";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataI);
        stmt.setString(2, dataF);
        rs = stmt.executeQuery();
        while (rs.next()) {
            valor += rs.getDouble("Valor") / 100;
        }
        return valor;
    }

    public double getValorSaidaPorData(String dataI, String dataF) throws Exception {
        double valor = 0;
        conectar();
        String sql = "SELECT * FROM tb_movimentacao WHERE Valor != 0.0 AND TipoMovimento = 'Saida' AND convert(datetime, DataMovimento, 103) BETWEEN convert(datetime, ?, 103) AND convert(datetime, ?, 103) ORDER BY IdMovimento desc";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataI);
        stmt.setString(2, dataF);
        rs = stmt.executeQuery();
        while (rs.next()) {
            valor += rs.getDouble("Valor") / 100;
        }
        return valor;
    }

    public List<MovimentacaoEntity> consultaPorDescricao(String descricao) throws Exception {
        List<MovimentacaoEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT * FROM tb_movimentacao WHERE Valor != 0.0 AND Descricao like ? ORDER BY IdMovimento desc";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, descricao);
        rs = stmt.executeQuery();
        while (rs.next()) {
            MovimentacaoEntity m = new MovimentacaoEntity();
            m.setIdMovimento(rs.getInt("IdMovimento"));
            m.setDescricao(rs.getString("Descricao"));
            m.setTipoMovimento(rs.getString("TipoMovimento"));
            m.setValor(rs.getDouble("Valor") / 100);
            m.setDataMovimento(rs.getString("DataMovimento"));
            m.setIdContaPagar(rs.getInt("ContaPagarId"));
            m.setIdVenda(rs.getInt("VendaId"));
            m.setIdEntrada(rs.getInt("EntradaId"));
            m.setIdContaPagar(rs.getInt("ContaId"));
            m.setCaixa(rs.getString("caixa"));
            m.setTipoDePagamento(rs.getString("TipoDePagamento"));
            lista.add(m);
        }
        return lista;
    }

    public double getValorSaidaPorDescricao(String descricao) throws Exception {
        double valor = 0;
        conectar();
        String sql = "SELECT * FROM tb_movimentacao WHERE Valor != 0.0 AND TipoMovimento = 'Saida' AND Descricao like ? ORDER BY IdMovimento desc";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, descricao);
        rs = stmt.executeQuery();
        while (rs.next()) {
            valor += rs.getDouble("Valor") / 100;
        }
        return valor;
    }

    public double getValorEntradaPorDescricao(String descricao) throws Exception {
        double valor = 0;
        conectar();
        String sql = "SELECT * FROM tb_movimentacao WHERE Valor != 0.0 AND TipoMovimento = 'Entrada' AND Descricao like ? ORDER BY IdMovimento desc";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, descricao);
        rs = stmt.executeQuery();
        while (rs.next()) {
            valor += rs.getDouble("Valor") / 100;
        }
        return valor;
    }

    public void gravarSaida(MovimentacaoEntity mov) throws Exception {
        conectar();
        String sql = "INSERT INTO tb_movimentacao (Descricao, TipoMovimento, Valor, DataMovimento, Caixa, ContaID, ContaPagarId, EntradaId,VendaID, TipoDePagamento) VALUES(?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, mov.getDescricao());
        stmt.setString(2, mov.getTipoMovimento());
        stmt.setDouble(3, -mov.getValor());
        stmt.setString(4, mov.getDataMovimento());
        stmt.setString(5, mov.getCaixa());
        stmt.setInt(6, mov.getIdConta());
        stmt.setInt(7, mov.getIdContaPagar());
        stmt.setInt(8, mov.getIdEntrada());
        stmt.setInt(9, mov.getIdVenda());
        stmt.setString(10, mov.getTipoDePagamento());

        stmt.executeUpdate();
        stmt.close();
    }

    public void gravarEntrada(MovimentacaoEntity mov) throws Exception {
        conectar();
        String sql = "INSERT INTO tb_movimentacao(Descricao, TipoMovimento, Valor, DataMovimento, Caixa, ContaID, ContaPagarId, EntradaId,VendaID, TipoDePagamento) VALUES(?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, mov.getDescricao());
        stmt.setString(2, mov.getTipoMovimento());
        stmt.setDouble(3, mov.getValor());
        stmt.setString(4, mov.getDataMovimento());
        stmt.setString(5, mov.getCaixa());
        stmt.setInt(6, mov.getIdConta());
        stmt.setInt(7, mov.getIdContaPagar());
        stmt.setInt(8, mov.getIdEntrada());
        stmt.setInt(9, mov.getIdVenda());
        stmt.setString(10, mov.getTipoDePagamento());
        stmt.executeUpdate();
        stmt.close();
    }

    public void deletarPorContaPagarId(int id) {
        try {
            conectar();
            String sql = "delete from tb_movimentacao where contaPagarId=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
