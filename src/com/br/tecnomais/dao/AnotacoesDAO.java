/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.AnotacoesEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desenvolvimento
 */
public class AnotacoesDAO extends ConectaBanco {

    String sql;

    public void save(AnotacoesEntity ae) {
        conectar();
        try {

            sql = "insert into tb_anotacoes (titulo, texto, data) values (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ae.getTitulo());
            stmt.setString(2, ae.getInformacoes());
            stmt.setString(3, ae.getData());
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(AnotacoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(AnotacoesEntity ae) {
        conectar();
        sql = "update tb_anotacoes set titulo=?, texto=?, data=? where id=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ae.getTitulo());
            stmt.setString(2, ae.getInformacoes());
            stmt.setString(3, ae.getData());
            stmt.setInt(4, ae.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnotacoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<AnotacoesEntity> list(String titulo) throws SQLException {
        conectar();
        List<AnotacoesEntity> minhaLista = new ArrayList();

        sql = "select * from tb_anotacoes where titulo like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        rs = stmt.executeQuery();

        while (rs.next()) {
            AnotacoesEntity ae = new AnotacoesEntity();
            ae.setId(rs.getInt("id"));
            ae.setTitulo(rs.getString("titulo"));
            ae.setInformacoes(rs.getString("texto"));
            ae.setData(rs.getString("data"));
            minhaLista.add(ae);
        }
        stmt.close();
        return minhaLista;
    }

    public void remove(Integer id) {
        conectar();
        try {
            sql = "remove from tb_anotacoes where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnotacoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<AnotacoesEntity> selecionaAnotacao(AnotacoesEntity ae) {
        conectar();
        List<AnotacoesEntity> minhaLista = new ArrayList();
        // AgendaEntity a1 = new AgendaEntity();
        sql = "select * from tb_anotacoes where id=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ae.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                ae.setId(rs.getInt("id"));
                ae.setTitulo(rs.getString("titulo"));
                ae.setInformacoes(rs.getString("texto"));
                ae.setData(rs.getString("data"));
                minhaLista.add(ae);
            }
            stmt.close();
            return minhaLista;
        } catch (SQLException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minhaLista;
    }
}
