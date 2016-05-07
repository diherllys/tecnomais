/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.FluxoCaixaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desenvolvimento
 */
public class FluxoCaixaDAO extends ConectaBanco {

    String sql = "";

    public void save(FluxoCaixaEntity fce) {
        try {
            conectar();
            sql = "insert tb_fluxoCaixa into(dataMov, decricao, idVenda, tipoMov, valor) values(?, ?, select id FROM tb_vendas ORDER BY ID DESC LIMIT 1, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fce.getDataMov());
            stmt.setString(2, fce.getDescricao());
            stmt.setInt(3, fce.getIdVenda());
            stmt.setString(4, fce.getTipoMov());
            stmt.setDouble(5, fce.getValor());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
        }
    }

    public void editar(FluxoCaixaEntity fce) {
        try {
            conectar();
            sql = "update tb_fluxoCaixa setdataMov=?, decricao=?, idVenda=?, tipoMov=?, valor=? where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fce.getDataMov());
            stmt.setString(2, fce.getDescricao());
            stmt.setInt(3, fce.getIdVenda());
            stmt.setString(4, fce.getTipoMov());
            stmt.setDouble(5, fce.getValor());
            stmt.setInt(6, fce.getId());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
        }
    }

    public List<FluxoCaixaEntity> listaFluxo(FluxoCaixaEntity fce2) throws SQLException {
        conectar();
        List<FluxoCaixaEntity> minhaLista = new ArrayList();
        sql = "select * from tb_fluxoCaixa where descricao=? or idVenda=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, fce2.getDescricao());
        stmt.setInt(2, fce2.getIdVenda());

        rs = stmt.executeQuery();

        while (rs.next()) {
            FluxoCaixaEntity fce = new FluxoCaixaEntity();
            fce.setId(rs.getInt("id"));
            fce.setDataMov(rs.getString("davaMov"));
            fce.setDescricao(rs.getString("descricao"));
            fce.setIdVenda(rs.getInt("idVenda"));
            fce.setTipoMov(rs.getString("tipoMov"));
            fce.setValor(rs.getDouble("valor"));
            minhaLista.add(fce);
        }
        stmt.close();
        rs.close();
        return minhaLista;
    }

    public void delete(Integer id) {
        try {
            conectar();
            sql = "delete from tb_fluxo where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
