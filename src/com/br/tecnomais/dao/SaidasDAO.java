package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.SaidasEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desenvolvimento
 */
public class SaidasDAO extends ConectaBanco {

    public List<SaidasEntity> listaSaidasParceladas() throws Exception {
        List<SaidasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT TOP 50 v.codigoVendas, v.vlrTotal, v.dataVenda, v.formaDePagamento, cli.nome from tb_vendas as v "
                + "INNER JOIN tb_contas as cont on cont.id_venda = v.codigoVendas "
                + "INNER JOIN tb_clientes as cli on cli.id = cont.id_cliente";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            SaidasEntity s = new SaidasEntity();
            s.setIdVenda(rs.getInt("codigoVendas"));
            s.setNomeCliente(rs.getString("nome"));
            s.setFormaPagamento(rs.getString("formaDePagamento"));
            s.setDataVenda(rs.getString("dataVenda"));
            s.setValor(rs.getDouble("vlrTotal") / 100);
            lista.add(s);
        }
        return lista;
    }

    public List<SaidasEntity> listaSaidasAvista() throws Exception {
        List<SaidasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT TOP 50 * FROM tb_vendas as v INNER JOIN tb_clientes as cli on v.idCliente = cli.id order by convert(datetime, dataVenda, 103)";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            SaidasEntity s = new SaidasEntity();
            s.setIdVenda(rs.getInt("codigoVendas"));
            s.setNomeCliente(rs.getString("nome"));
            s.setFormaPagamento(rs.getString("formaDePagamento"));
            s.setDataVenda(rs.getString("dataVenda"));
            s.setValor(rs.getDouble("vlrTotal") / 100);
            lista.add(s);
        }
        return lista;
    }

    public List<SaidasEntity> consultaSaidasPorCliente(String consulta) throws Exception {
        List<SaidasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT v.codigoVendas, v.dataVenda, v.formaDePagamento, v.vlrTotal, cli.nome FROM tb_vendas as v "
                + "INNER JOIN tb_contas as cont on cont.id_venda = v.codigoVendas "
                + "INNER JOIN tb_clientes as cli on cont.id_cliente = cli.id AND cli.nome LIKE ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, consulta);
        rs = stmt.executeQuery();
        while (rs.next()) {
            SaidasEntity s = new SaidasEntity();
            s.setIdVenda(rs.getInt("codigoVendas"));
            s.setNomeCliente(rs.getString("nome"));
            s.setFormaPagamento(rs.getString("formaDePagamento"));
            s.setDataVenda(rs.getString("dataVenda"));
            s.setValor(rs.getDouble("vlrTotal") / 100);
            lista.add(s);
        }
        return lista;
    }

    public List<SaidasEntity> consultaSaidasPorCodigoVendaParcelado(int consulta) throws Exception {
        List<SaidasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT v.codigoVendas, v.dataVenda, v.formaDePagamento, v.vlrTotal, cli.nome FROM tb_vendas as v "
                + "INNER JOIN tb_contas as cont on cont.id_venda = ? AND v.codigoVendas = ? "
                + "INNER JOIN tb_clientes as cli on cont.id_cliente = cli.id";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, consulta);
        stmt.setInt(2, consulta);

        rs = stmt.executeQuery();
        while (rs.next()) {
            SaidasEntity s = new SaidasEntity();
            s.setIdVenda(rs.getInt("codigoVendas"));
            s.setNomeCliente(rs.getString("nome"));
            s.setFormaPagamento(rs.getString("formaDePagamento"));
            s.setDataVenda(rs.getString("dataVenda"));
            s.setValor(rs.getDouble("vlrTotal") / 100);
            lista.add(s);
        }
        return lista;
    }

    public List<SaidasEntity> consultaSaidasPorCodigoVenda(int consulta) throws Exception {
        List<SaidasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT * FROM tb_vendas as v inner join tb_clientes as cli on v.idCliente = cli.id and codigoVendas = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, consulta);
        rs = stmt.executeQuery();
        while (rs.next()) {
            SaidasEntity s = new SaidasEntity();
            s.setIdVenda(rs.getInt("codigoVendas"));
            s.setNomeCliente(rs.getString("nome"));
            s.setFormaPagamento(rs.getString("formaDePagamento"));
            s.setDataVenda(rs.getString("dataVenda"));
            s.setValor(rs.getDouble("vlrTotal") / 100);
            lista.add(s);
        }
        return lista;
    }

    public List<SaidasEntity> consultaSaidasPorDataVenda(String dataInicial, String dataFinal) throws Exception {
        List<SaidasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT * from tb_vendas as v inner join tb_clientes as cli on cli.id = v.idCliente and convert(datetime, dataVenda, 103) between convert(datetime, ?, 103) and convert(datetime, ?, 103)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataInicial);
        stmt.setString(2, dataFinal);
        rs = stmt.executeQuery();
        while (rs.next()) {
            SaidasEntity s = new SaidasEntity();
            s.setIdVenda(rs.getInt("codigoVendas"));
            s.setNomeCliente(rs.getString("nome"));
            s.setFormaPagamento(rs.getString("formaDePagamento"));
            s.setDataVenda(rs.getString("dataVenda"));
            s.setValor(rs.getDouble("vlrTotal") / 100);
            lista.add(s);
        }
        return lista;
    }

    public List<SaidasEntity> consultaSaidasPorDataVendaParcelada(String dataInicial, String dataFinal) throws Exception {
        List<SaidasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT v.codigoVendas, v.dataVenda, v.formaDePagamento, v.vlrTotal, cli.nome FROM tb_vendas as v "
                + "INNER JOIN tb_contas as cont on cont.id_venda = v.codigoVendas AND convert(datetime, v.dataVenda, 103) between convert(datetime, ?, 103) AND convert(datetime, ?, 103) "
                + "INNER JOIN tb_clientes as cli on cont.id_cliente = cli.id";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataInicial);
        stmt.setString(2, dataFinal);
        rs = stmt.executeQuery();
        while (rs.next()) {
            SaidasEntity s = new SaidasEntity();
            s.setIdVenda(rs.getInt("codigoVendas"));
            s.setNomeCliente(rs.getString("nome"));
            s.setFormaPagamento(rs.getString("formaDePagamento"));
            s.setDataVenda(rs.getString("dataVenda"));
            s.setValor(rs.getDouble("vlrTotal") / 100);
            lista.add(s);
        }
        return lista;
    }

    public String selecionaOperacao(Integer codigo) throws SQLException {
        conectar();
        String sql = "select nome from tb_operacoesDeSaida where codigo=?";
        stmt = conn.prepareCall(sql);
        stmt.setInt(1, codigo);
        rs = stmt.executeQuery();
        String result = " ";
        if (rs.next()) {
            result = rs.getString("nome");
        }
        return result;
    }

    public String selecionaUsuario(Integer id) throws SQLException {
        conectar();
        String sql = "select nome_usuario from tb_usuarios where id=?";
        stmt = conn.prepareCall(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        String result = " ";
        if (rs.next()) {
            result = rs.getString("nome_usuario");
        }
        return result;
    }

    public String selecionaCaixa(Integer numero) throws SQLException {
        conectar();
        String sql = "select nome from tb_caixas where id=?";
        stmt = conn.prepareCall(sql);
        stmt.setInt(1, numero);
        rs = stmt.executeQuery();
        String result = " ";
        if (rs.next()) {
            result = rs.getString("nome");
        }
        return result;
    }

    public VendaEntity retornaSaida(int idVenda) throws SQLException {
        conectar();
        String sql = "select * from tb_vendas where codigoVendas=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idVenda);
        rs = stmt.executeQuery();
        VendaEntity ve = new VendaEntity();
        ve.setClienteID(0);
        while (rs.next()) {
            ve.setCaixa(rs.getString("caixa"));
            ve.setClienteID(rs.getInt("idCliente"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setFormaPagamento(rs.getString("formaDePagamento"));
            ve.setFormaPagamento2(rs.getString("formaDePagamento2"));
            ve.setFormaPagamento3(rs.getString("formaDePagamento3"));
            ve.setId(rs.getInt("codigoVendas"));
            ve.setOperacao(rs.getString("operacao"));
            ve.setStatus(rs.getString("status"));
            ve.setVendedor(rs.getString("vendedor"));
            ve.setVlrTotal(rs.getDouble("vlrTotal"));
            ve.setParcelas(rs.getInt("parcelas"));
            ve.setVlrForma1(rs.getDouble("vlrForma1"));
            ve.setVlrForma2(rs.getDouble("vlrForma2"));
            ve.setVlrForma3(rs.getDouble("vlrForma3"));
            ve.setHora(rs.getString("hora"));
        }
        return ve;
    }

    public boolean verificaPrevenda(int id) throws SQLException {
        conectar();
        String sql = "select * from tb_vendas where codigoVendas=? and operacao='PRE-VENDA'";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public boolean verificaVenda(int id) throws SQLException {
        conectar();
        String sql = "select * from tb_vendas where codigoVendas=? and operacao='VENDA ESTADUAL'";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public int retornaLastSaida() throws SQLException {
        conectar();
        String sql = "select top 1 codigoVendas from tb_vendas order by codigoVendas desc";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        VendaEntity ve = new VendaEntity();
        ve.setId(0);
        while (rs.next()) {
            ve.setId(rs.getInt("codigoVendas"));
        }

        return ve.getId();
    }

}
