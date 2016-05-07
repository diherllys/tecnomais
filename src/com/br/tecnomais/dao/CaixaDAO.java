package com.br.tecnomais.dao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.CaixaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class CaixaDAO extends ConectaBanco {

    public void salvar(CaixaEntity ce) throws SQLException {
        conectar();
        String sql = "insert into tb_caixas (nome) values(?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, ce.getNome());
        stmt.executeUpdate();
        stmt.close();
    }

    public void alterar(CaixaEntity ce) throws SQLException {
        conectar();
        String sql = "update tb_caixas set nome=? where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, ce.getNome());
        stmt.setInt(2, ce.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<CaixaEntity> listar(String nome) throws SQLException {
        conectar();
        String sql = "select * from tb_caixas where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        List<CaixaEntity> minhaLista = new ArrayList();
        while (rs.next()) {
            CaixaEntity ce = new CaixaEntity();
            ce.setNome(rs.getString("nome"));
            ce.setId(rs.getInt("id"));
            minhaLista.add(ce);
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }

    public int caixaId(String nome) throws SQLException {
        conectar();
        int id = 0;
        String sql = "select * from tb_caixas where nome=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        CaixaEntity ce = new CaixaEntity();
        while (rs.next()) {
            id = rs.getInt("id");
        }
        rs.close();
        stmt.close();
        return id;
    }

    public void remover(Integer id) throws SQLException {
        conectar();
        String sql = "delete from tb_caixas where id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<CaixaEntity> selecionaCaixa(Integer id) throws SQLException {
        conectar();
        String sql = "select * from tb_caixas where id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        List<CaixaEntity> minhaLista = new ArrayList();
        while (rs.next()) {
            CaixaEntity ce = new CaixaEntity();
            ce.setId(rs.getInt("id"));
            ce.setNome(rs.getString("nome"));
            minhaLista.add(ce);
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }

    public String nomeCaixa() throws Exception {
        String nome = "";
        conectar();
        String sql = "select * from tb_caixas";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            nome = rs.getString("nome");
        }
        return nome;
    }

    public List<String> todosCaixaNome() throws Exception {
        conectar();
        List<String> minhaLista = new ArrayList<>();
        String sql = "select nome from tb_caixas";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            minhaLista.add(rs.getString("nome"));
        }
        return minhaLista;
    }

    public boolean caixaRepetida(String nome) throws SQLException {
        conectar();
        boolean op = false;
        String sql = "select * from tb_caixas where nome=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        if (rs.next()) {
            op = true;
        }
        stmt.close();
        rs.close();
        return op;
    }

    public void atualizarNomeCaixa(String nome, String novoNome) throws SQLException {
        conectar();
        String sql = "update tb_vendas set caixa=? where caixa=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoNome);
        stmt.setString(2, nome);
        stmt.executeUpdate();
        stmt.close();
        new Alertas().mensagemConfirmacao("Deu certo");
    }

}
