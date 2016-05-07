/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.classes.ImpressoraBematchEntity;
import com.br.tecnomais.db.ConectaBanco;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ImpressoraBematchDAO extends ConectaBanco {

    public void salvar(ImpressoraBematchEntity ibe) {
        try {
            conectar();
            String sql = "insert into tb_impressoraBematch(dll64, dll32, guilhotina, porta, id) values(?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ibe.getDll64());
            stmt.setInt(2, ibe.getDll32());
            stmt.setInt(3, ibe.getGuilhotina());
            stmt.setString(4, ibe.getPorta());
            stmt.setInt(5, ibe.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ImpressoraBematchEntity ibe) {
        try {
            conectar();
            String sql = "update tb_impressoraBematch set dll64=?, dll32=?, guilhotina=?, porta=?, id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ibe.getDll64());
            stmt.setInt(2, ibe.getDll32());
            stmt.setInt(3, ibe.getGuilhotina());
            stmt.setString(4, ibe.getPorta());
            stmt.setInt(5, ibe.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImpressoraBematchEntity RetornImpBematchCfg() throws SQLException {
        conectar();
        ImpressoraBematchEntity ibe = new ImpressoraBematchEntity();
        String sql = "select * from tb_impressoraBematch";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        ibe.setId(0);
        if (rs.next()) {
            ibe.setId(rs.getInt("id"));
            ibe.setDll32(rs.getInt("dll32"));
            ibe.setDll64(rs.getInt("dll64"));
            ibe.setGuilhotina(rs.getInt("guilhotina"));
            ibe.setPorta(rs.getString("porta"));
        }
        stmt.close();
        rs.close();
        return ibe;
    }

}
