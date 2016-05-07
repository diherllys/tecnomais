package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ContasReceberEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class ContasReceberDAO extends ConectaBanco {

    public void excluirConta(int codigoVenda) throws Exception {
        conectar();
        String sql = "DELETE FROM tb_contas WHERE id_venda = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoVenda);
        stmt.executeUpdate();
    }

    public void excluirContaId(int id) {
        try {
            conectar();
            String sql = "DELETE FROM tb_contas WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ContasReceberEntity> listarContas(Integer id) throws SQLException {
        conectar();
        List<ContasReceberEntity> minhaLista = new ArrayList();
        String sql = "select * from tb_contas where id_cliente=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ContasReceberEntity cre = new ContasReceberEntity();
            cre.setClienteID(rs.getInt("id_cliente"));
            cre.setContaID(rs.getInt("id"));
            cre.setDataVencimento(rs.getString("data_vencimento"));
            cre.setQuantidadeParcelas(rs.getInt("numero_parcelas"));
            cre.setVendaID(rs.getInt("id_venda"));
            cre.setVlrRestante(rs.getDouble("vlrRestante"));
            cre.setVlrParcelas(rs.getDouble("vlrParcelas"));
            cre.setVlrTotal(rs.getDouble("vlrTotal"));
            minhaLista.add(cre);
        }
        stmt.close();
        rs.close();
        return minhaLista;
    }

    public void darBaixaEmParc(ContasReceberEntity cre) {
        try {
            conectar();
            String sql = "update tb_contas set data_vencimento = ?, numero_parcelas = ?, vlrRestante = ?, vlrParcelas = ? where id = ?";
            stmt = conn.prepareCall(sql);
            stmt.setString(1, cre.getDataVencimento());
            stmt.setInt(2, cre.getQuantidadeParcelas());
            stmt.setDouble(3, cre.getVlrRestante());
            stmt.setDouble(4, cre.getVlrParcelas());
            stmt.setInt(5, cre.getContaID());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alteraStatusVenda(int vendaId) {
        try {
            conectar();
            String sql = "update tb_vendas set status=? where codigoVendas=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "F");
            stmt.setInt(2, vendaId);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
