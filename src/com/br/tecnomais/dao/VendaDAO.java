package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.BuscarVendaEntity;
import com.br.tecnomais.entity.ClienteEntity;
import com.br.tecnomais.entity.ContasReceberEntity;
import com.br.tecnomais.entity.ProdutosVendaEntity;
import com.br.tecnomais.entity.VendaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class VendaDAO extends ConectaBanco {

    int tam;

    public VendaDAO() {
        tam = 0;
    }

    public void efetivarVenda(VendaEntity v) throws Exception {
        conectar();
        String sql = "insert into tb_vendas(caixa, operacao, vlrTotal, dataVenda, vendedor, formaDePagamento, formaDePagamento2, formaDePagamento3, Status, idCliente, vlrForma1, vlrForma2, vlrForma3, parcelas, hora) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, v.getCaixa());
        stmt.setString(2, v.getOperacao());
        stmt.setDouble(3, v.getVlrTotal());
        stmt.setString(4, v.getDataVenda());
        stmt.setString(5, v.getVendedor());
        stmt.setString(6, v.getFormaPagamento());
        stmt.setString(7, v.getFormaPagamento2());
        stmt.setString(8, v.getFormaPagamento3());
        stmt.setString(9, v.getStatus());
        stmt.setInt(10, v.getClienteID());
        stmt.setDouble(11, v.getVlrForma1());
        stmt.setDouble(12, v.getVlrForma2());
        stmt.setDouble(13, v.getVlrForma3());
        stmt.setInt(14, v.getParcelas());
        stmt.setString(15, v.getHora());
        stmt.executeUpdate();
        stmt.close();
    }

    public int getLastCodigoVenda() throws Exception {
        conectar();
        int codigo = 0;
        String sql = "select top 1 codigoVendas from tb_vendas order by codigoVendas desc";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            codigo = rs.getInt("codigoVendas");
        }
        return codigo;
    }

    public void setProdutosVendidos(VendaEntity v) {

    }

    public void cadastrarContaReceber(ContasReceberEntity contas) throws Exception {
        conectar();
        contas.setVendaID(getLastCodigoVenda());
        String sql = "INSERT INTO tb_contas (id_venda, id_cliente, vlrTotal, vlrRestante, numero_parcelas, vlrParcelas, data_vencimento) VALUES(?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, contas.getVendaID());
        stmt.setInt(2, contas.getClienteID());
        stmt.setDouble(3, contas.getVlrTotal());
        stmt.setDouble(4, contas.getVlrRestante());
        stmt.setInt(5, contas.getQuantidadeParcelas());
        stmt.setDouble(6, contas.getVlrParcelas());
        stmt.setString(7, contas.getDataVencimento());
        stmt.executeUpdate();
    }

    public void cancelarVenda(int codigoVenda) throws Exception {
        conectar();
        String sql = "DELETE FROM tb_vendas WHERE codigoVendas = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoVenda);
        stmt.executeUpdate();
    }

    public void RestocarProdutosVendidos(Integer id, Double novaQuant) {
        try {
            conectar();
            String sql = "update tb_produtos set qntAtual=? where id=?";
            stmt = conn.prepareCall(sql);
            stmt.setDouble(1, novaQuant);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void RemoveProdutoVendidos(Integer id) {
        try {
            conectar();
            String sql = "delete tb_produtosVendidos where vendaId=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void CancelarContasReceber(Integer id) {
        try {
            conectar();
            String sql = "delete tb_contas where id_venda=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelarFluxoNovinha(Integer id) {
        try {
            conectar();
            String sql = "delete tb_movimentacao where vendaID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BuscarVendaEntity> listaVendasPorCodigoVenda(int codigoVendas) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.operacao, v.status from tb_vendas as v inner join tb_clientes as c on v.idCliente = c.id and v.codigoVendas = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoVendas);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorNomeCliente(String nomeCliente) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.operacao, v.status from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and c.nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeCliente);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorDataVenda(String dataVenda) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.operacao, v.status from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and v.dataVenda = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataVenda);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorOperacao(String operacao) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.operacao, v.status from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and v.operacao like ? order by v.codigoVendas";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, operacao);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorProduto(String nomeProduto) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.status, v.operacao from tb_produtos as p inner join tb_produtosVendidos as prod on prod.produtoID = p.id and p.nome like ? inner join tb_vendas as v on v.codigoVendas = prod.vendaID inner join tb_clientes as c on c.id = v.idCliente";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeProduto);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorNomeClienteDataVenda(String nomeCliente, String data) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.operacao, v.status from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and c.nome like ? and v.dataVenda=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeCliente);
        stmt.setString(2, data);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorNomeClienteOperacao(String nomeCliente, String operacao) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.operacao, v.status from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and c.nome like ? and v.operacao=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeCliente);
        stmt.setString(2, operacao);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorNomeClienteProduto(String nomeCliente, String produto) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.status, v.operacao from tb_produtos as p inner join tb_produtosVendidos as prod on prod.produtoID = p.id and p.nome like ? inner join tb_vendas as v on v.codigoVendas = prod.vendaID inner join tb_clientes as c on c.id = v.idCliente and c.nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(2, nomeCliente);
        stmt.setString(1, produto);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorDataVendaOperacao(String dataVenda, String operacao) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.operacao, v.status from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and v.dataVenda = ? and v.operacao=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataVenda);
        stmt.setString(2, operacao);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorDataVendaProduto(String dataVenda, String produto) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.status, v.operacao from tb_produtos as p inner join tb_produtosVendidos as prod on prod.produtoID = p.id and p.nome like ? inner join tb_vendas as v on v.codigoVendas = prod.vendaID inner join tb_clientes as c on c.id = v.idCliente and v.dataVenda= ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(2, dataVenda);
        stmt.setString(1, produto);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorOperacaoProduto(String operacao, String produto) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.status, v.operacao from tb_produtos as p inner join tb_produtosVendidos as prod on prod.produtoID = p.id and p.nome like ? inner join tb_vendas as v on v.codigoVendas = prod.vendaID inner join tb_clientes as c on c.id = v.idCliente and v.operacao= ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(2, operacao);
        stmt.setString(1, produto);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorNomeClienteDataVendaOperacao(String nomeCliente, String data, String operacao) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.operacao, v.status from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and c.nome like ? and v.dataVenda=? and v.operacao=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeCliente);
        stmt.setString(2, data);
        stmt.setString(3, operacao);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorNomeClienteDataVendaOperacaoProduto(String nomeCliente, String data, String operacao, String produto) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.status, v.operacao from tb_produtos as p inner join tb_produtosVendidos as prod on prod.produtoID = p.id and p.nome like ? inner join tb_vendas as v on v.codigoVendas = prod.vendaID inner join tb_clientes as c on c.id = v.idCliente and c.nome like ? and v.dataVenda=? and v.operacao=?";
        stmt = conn.prepareStatement(sql);

        stmt.setString(1, produto);
        stmt.setString(2, nomeCliente);
        stmt.setString(3, data);
        stmt.setString(4, operacao);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaVendasPorDataVendaOperacaoProduto(String dataVenda, String produto, String operacao) throws Exception {
        conectar();
        List<BuscarVendaEntity> lista = new ArrayList<>();
        String sql = "select c.nome as nomeCliente, v.codigoVendas, v.dataVenda, v.vlrTotal, v.status, v.operacao from tb_produtos as p inner join tb_produtosVendidos as prod on prod.produtoID = p.id and p.nome like ? inner join tb_vendas as v on v.codigoVendas = prod.vendaID inner join tb_clientes as c on c.id = v.idCliente and v.dataVenda= ? and v.operacao=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, produto);
        stmt.setString(2, dataVenda);
        stmt.setString(3, operacao);

        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            ClienteEntity cli = new ClienteEntity();
            cli.setNome(rs.getString("nomeCliente"));

            VendaEntity ve = new VendaEntity();
            ve.setId(rs.getInt("codigoVendas"));
            ve.setDataVenda(rs.getString("dataVenda"));
            ve.setVlrTotal(rs.getDouble("vlrTotal") / 100);
            ve.setStatus(rs.getString("status"));
            ve.setOperacao(rs.getString("operacao"));

            busc.setCliente(cli);
            busc.setVenda(ve);

            lista.add(busc);

        }
        return lista;
    }

    public List<BuscarVendaEntity> listaTodasVendas() throws Exception {
        List<BuscarVendaEntity> minhaLista = new ArrayList<>();
        conectar();
        String sql = "select v.*, c.nome, c.id from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            VendaEntity venda = new VendaEntity();
            venda.setId(rs.getInt("codigoVendas"));
            venda.setCaixa(rs.getString("caixa"));
            venda.setOperacao(rs.getString("operacao"));
            venda.setVlrTotal(rs.getDouble("vlrTotal")/100);
            venda.setStatus(rs.getString("status"));
            venda.setDataVenda(rs.getString("dataVenda"));
            venda.setVendedor(rs.getString("vendedor"));
            venda.setFormaPagamento(rs.getString("formaDePagamento"));
            venda.setFormaPagamento2(rs.getString("formaDePagamento2"));
            venda.setFormaPagamento3(rs.getString("formaDePagamento3"));
            venda.setClienteID(rs.getInt("idCliente"));
            venda.setVlrForma1(rs.getDouble("vlrForma1"));
            venda.setVlrForma2(rs.getDouble("vlrForma2"));
            venda.setVlrForma3(rs.getDouble("vlrForma3"));
            venda.setParcelas(rs.getInt("parcelas"));
            venda.setHora(rs.getString("hora"));
            
            ClienteEntity ce = new ClienteEntity();
            ce.setId(rs.getInt("id"));
            ce.setNome(rs.getString("nome"));
            busc.setCliente(ce);
            busc.setVenda(venda);
            minhaLista.add(busc);
        }
        return minhaLista;
    }
    
    public List<BuscarVendaEntity> listaTodasVendasPorNomeCliente(String nomeCliente) throws Exception {
        List<BuscarVendaEntity> minhaLista = new ArrayList<>();
        conectar();
        String sql = "select v.*, c.nome, c.id from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and c.nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeCliente);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            VendaEntity venda = new VendaEntity();
            venda.setId(rs.getInt("codigoVendas"));
            venda.setCaixa(rs.getString("caixa"));
            venda.setOperacao(rs.getString("operacao"));
            venda.setVlrTotal(rs.getDouble("vlrTotal")/100);
            venda.setStatus(rs.getString("status"));
            venda.setDataVenda(rs.getString("dataVenda"));
            venda.setVendedor(rs.getString("vendedor"));
            venda.setFormaPagamento(rs.getString("formaDePagamento"));
            venda.setFormaPagamento2(rs.getString("formaDePagamento2"));
            venda.setFormaPagamento3(rs.getString("formaDePagamento3"));
            venda.setClienteID(rs.getInt("idCliente"));
            venda.setVlrForma1(rs.getDouble("vlrForma1"));
            venda.setVlrForma2(rs.getDouble("vlrForma2"));
            venda.setVlrForma3(rs.getDouble("vlrForma3"));
            venda.setParcelas(rs.getInt("parcelas"));
            venda.setHora(rs.getString("hora"));
            
            ClienteEntity ce = new ClienteEntity();
            ce.setId(rs.getInt("id"));
            ce.setNome(rs.getString("nome"));
            busc.setCliente(ce);
            busc.setVenda(venda);
            minhaLista.add(busc);
        }
        return minhaLista;
    }
    
    public List<BuscarVendaEntity> listaTodasVendasPorNumeroCupom(int numeroCupom) throws Exception {
        List<BuscarVendaEntity> minhaLista = new ArrayList<>();
        conectar();
        String sql = "select v.*, c.nome, c.id from tb_vendas as v inner join tb_clientes as c on c.id = v.idCliente and v.codigoVendas = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, numeroCupom);
        rs = stmt.executeQuery();
        while (rs.next()) {
            BuscarVendaEntity busc = new BuscarVendaEntity();
            VendaEntity venda = new VendaEntity();
            venda.setId(rs.getInt("codigoVendas"));
            venda.setCaixa(rs.getString("caixa"));
            venda.setOperacao(rs.getString("operacao"));
            venda.setVlrTotal(rs.getDouble("vlrTotal")/100);
            venda.setStatus(rs.getString("status"));
            venda.setDataVenda(rs.getString("dataVenda"));
            venda.setVendedor(rs.getString("vendedor"));
            venda.setFormaPagamento(rs.getString("formaDePagamento"));
            venda.setFormaPagamento2(rs.getString("formaDePagamento2"));
            venda.setFormaPagamento3(rs.getString("formaDePagamento3"));
            venda.setClienteID(rs.getInt("idCliente"));
            venda.setVlrForma1(rs.getDouble("vlrForma1"));
            venda.setVlrForma2(rs.getDouble("vlrForma2"));
            venda.setVlrForma3(rs.getDouble("vlrForma3"));
            venda.setParcelas(rs.getInt("parcelas"));
            venda.setHora(rs.getString("hora"));
            
            ClienteEntity ce = new ClienteEntity();
            ce.setId(rs.getInt("id"));
            ce.setNome(rs.getString("nome"));
            busc.setCliente(ce);
            busc.setVenda(venda);
            minhaLista.add(busc);
        }
        return minhaLista;
    }
    
    public void trocaValorVendaForma1(VendaEntity v, String formaPagamento, double diferenca) throws Exception {
        conectar();
        String sql = "update tb_vendas set vlrTotal = ?, formaDePagamento = ?, vlrForma1 = vlrForma1 + ? where codigoVendas = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, v.getVlrTotal());
        stmt.setString(2, formaPagamento);
        stmt.setDouble(3, diferenca);
        stmt.setInt(4, v.getId());
        stmt.executeUpdate();
    }
    
    public void trocaValorVendaForma2(VendaEntity v, String formaPagamento, double diferenca) throws Exception {
        conectar();
        String sql = "update tb_vendas set vlrTotal = ?, formaDePagamento2 = ?, vlrForma2 = vlrForma2 + ? where codigoVendas = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, v.getVlrTotal());
        stmt.setString(2, formaPagamento);
        stmt.setDouble(3, diferenca);
        stmt.setInt(4, v.getId());
        stmt.executeUpdate();
    }
    
    public void trocaValorVendaForma3(VendaEntity v, String formaPagamento, double diferenca) throws Exception {
        conectar();
        String sql = "update tb_vendas set vlrTotal = ?, formaDePagamento3 = ?, vlrForma3 = vlrForma3 + ? where codigoVendas = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, v.getVlrTotal());
        stmt.setString(2, formaPagamento);
        stmt.setDouble(3, diferenca);
        stmt.setInt(4, v.getId());
        stmt.executeUpdate();
    }
    
    public void cancelarProdutosVendidos(int codigo) throws Exception {
        conectar();
        String sql = "delete from tb_produtosVendidos where vendaID = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigo);
        stmt.executeUpdate();
    }
    
    public void lancarNovosProdutosVendidos(ProdutosVendaEntity p, int idVenda) throws Exception {
        conectar();
        String sql = "insert into tb_produtosVendidos (vendaID, produtoID, qntVendida, valorTotal) values(?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idVenda);
        stmt.setInt(2, p.getCodigoProduto());
        stmt.setDouble(3, p.getQuantidade());
        stmt.setDouble(4, p.getPrecoTotal());
        stmt.executeUpdate();
    }
 }
