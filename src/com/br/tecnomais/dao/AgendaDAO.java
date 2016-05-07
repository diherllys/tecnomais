/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.AgendaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desenvolvimento
 */
public class AgendaDAO extends ConectaBanco {

    String sql;

    public void salvar(AgendaEntity a1) throws SQLException {
        conectar();
        sql = "insert into tb_agenda (nome, telefone, area, celular, bairro, cidade, estado, cep, email, homePage"
                + ", observacoes, endereco) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? )";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, a1.getNome());
        stmt.setString(2, a1.getTelefone());
        stmt.setString(3, a1.getArea());
        stmt.setString(4, a1.getCelular());
        stmt.setString(5, a1.getBairro());
        stmt.setString(6, a1.getCidade());
        stmt.setString(7, a1.getEstado());
        stmt.setString(8, a1.getCep());
        stmt.setString(9, a1.getEmail());
        stmt.setString(10, a1.getHomePage());
        stmt.setString(11, a1.getObservacoes());
        stmt.setString(12, a1.getEndereco());

        stmt.executeUpdate();
        stmt.close();
    }

    public void alterar(AgendaEntity a1) throws SQLException {
        conectar();
        sql = "update tb_agenda set nome=? , telefone=? , area=? , celular=? , bairro=? , cidade=? , estado=? ,"
                + " cep=? , email=? , homePage=? , observacoes=?, endereco=? where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, a1.getNome());
        stmt.setString(2, a1.getTelefone());
        stmt.setString(3, a1.getArea());
        stmt.setString(4, a1.getCelular());
        stmt.setString(5, a1.getBairro());
        stmt.setString(6, a1.getCidade());
        stmt.setString(7, a1.getEstado());
        stmt.setString(8, a1.getCep());
        stmt.setString(9, a1.getEmail());
        stmt.setString(10, a1.getHomePage());
        stmt.setString(11, a1.getObservacoes());
        stmt.setString(12, a1.getEndereco());
        stmt.setInt(13, a1.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    public List<AgendaEntity> listar(String nome) throws SQLException {
        conectar();

        sql = "select * from tb_agenda where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        List<AgendaEntity> minhaLista = new ArrayList();

        while (rs.next()) {
            AgendaEntity a1 = new AgendaEntity();
            a1.setId(rs.getInt("id"));
            a1.setNome(rs.getString("nome"));
            a1.setArea(rs.getString("area"));
            a1.setCelular(rs.getString("celular"));
            a1.setBairro(rs.getString("bairro"));
            a1.setCidade(rs.getString("cidade"));
            a1.setEstado(rs.getString("estado"));
            a1.setCep(rs.getString("cep"));
            a1.setEmail(rs.getString("email"));
            a1.setHomePage(rs.getString("homePage"));
            a1.setObservacoes(rs.getString("observacoes"));
            a1.setEndereco(rs.getString("endereco"));
            a1.setTelefone(rs.getString("telefone"));
            minhaLista.add(a1);
        }
        stmt.close();
        return minhaLista;
    }

    public void excluir(Integer id) throws SQLException {
        conectar();
        sql = "delete from tb_agenda where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<AgendaEntity> selecionaAgenda(AgendaEntity a1) {
        conectar();
        List<AgendaEntity> minhaLista = new ArrayList();
        // AgendaEntity a1 = new AgendaEntity();
        sql = "select * from tb_agenda where id=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, a1.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                a1.setId(rs.getInt("id"));
                a1.setNome(rs.getString("nome"));
                a1.setArea(rs.getString("area"));
                a1.setCelular(rs.getString("celular"));
                a1.setBairro(rs.getString("bairro"));
                a1.setCidade(rs.getString("cidade"));
                a1.setEstado(rs.getString("estado"));
                a1.setCep(rs.getString("cep"));
                a1.setEmail(rs.getString("email"));
                a1.setHomePage(rs.getString("homePage"));
                a1.setObservacoes(rs.getString("observacoes"));
                a1.setEndereco(rs.getString("endereco"));
                a1.setTelefone(rs.getString("telefone"));
                minhaLista.add(a1);
            }
            stmt.close();
            return minhaLista;
        } catch (SQLException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minhaLista;
    }
}
