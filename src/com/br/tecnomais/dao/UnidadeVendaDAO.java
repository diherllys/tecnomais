package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.UnidadeVendaEntity;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class UnidadeVendaDAO extends ConectaBanco {

    public void cadastrarUnidade(UnidadeVendaEntity unidade) throws Exception {
        conectar();
        String sql = "insert into tb_unidadeVenda (nome) values (?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, unidade.getNome());
        stmt.executeUpdate();
        stmt.close();
    }

    public void atualizarUnidade(UnidadeVendaEntity und) throws Exception {
        conectar();
        String sql = "update tb_unidadeVenda set nome = ? where id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, und.getNome());
        stmt.setInt(2, und.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void excluirUnidade(int codigo) throws Exception {
        conectar();
        String sql = "delete from tb_unidadeVenda where id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigo);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<UnidadeVendaEntity> listaUnidades(String nomeConsultado) throws Exception {
        conectar();
        List<UnidadeVendaEntity> lista = new ArrayList<>();
        String sql = "select * from tb_unidadeVenda where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeConsultado);
        rs = stmt.executeQuery();
        while (rs.next()) {
            UnidadeVendaEntity und = new UnidadeVendaEntity();
            und.setId(rs.getInt("id"));
            und.setNome(rs.getString("nome"));
            lista.add(und);
        }
        return lista;
    }

   

}
