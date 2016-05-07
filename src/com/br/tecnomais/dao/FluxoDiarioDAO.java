/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.FluxoDiarioEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desenvolvimento
 */
public class FluxoDiarioDAO extends ConectaBanco {

    String sql = "";

    public void salvar(FluxoDiarioEntity fde) {
        try {
            conectar();
            sql = "INSERT INTO tb_fluxoDiario(data, valor, descricao, tipo, idVenda) values(?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fde.getData());
            stmt.setDouble(2, fde.getValor());
            stmt.setString(3, fde.getDescricao());
            stmt.setInt(4, fde.getTipo());
            stmt.setInt(5, fde.getIdVenda());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(FluxoDiarioEntity fde) {
        try {
            conectar();
            sql = "UPDATE tb_fluxoDiario SET data=?, valor=?, descricao=?, tipo=? where id=? or idVenda=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fde.getData());
            stmt.setDouble(2, fde.getValor());
            stmt.setString(3, fde.getDescricao());
            stmt.setInt(4, fde.getTipo());
            stmt.setInt(5, fde.getId());
            stmt.setInt(6, fde.getIdVenda());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<FluxoDiarioEntity> listarFluxoDiario(String data) throws SQLException {
        conectar();
        List<FluxoDiarioEntity> minhaLista = new ArrayList();
        sql = "select * from tb_fluxoDiario where data=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, data);
        rs = stmt.executeQuery();

        while (rs.next()) {
            FluxoDiarioEntity fde = new FluxoDiarioEntity();
            fde.setData(rs.getString("data"));
            fde.setDescricao(rs.getString("descricao"));
            fde.setId(rs.getInt("id"));
            fde.setIdVenda(rs.getInt("idVenda"));
            fde.setTipo(rs.getInt("tipo"));
            fde.setValor(rs.getDouble("valor"));
        }

        return minhaLista;
    }

    public void deletarFluxoDiarioByID(Integer idVenda) {
        try {
            conectar();
            sql = "delete from tb_fluxoDiario where idVenda=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idVenda);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
