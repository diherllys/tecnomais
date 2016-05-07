/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ImpressoraPadraoEntity;
import java.sql.SQLException;

/**
 *
 * @author Desenvolvimento
 */
public class ImpressoraPadraoDAO extends ConectaBanco {

    String sql;

    public void salvar(ImpressoraPadraoEntity ipe) {
        try {
            sql = "insert into tb_impressoras(impressoraAtual) values(?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ipe.getImpressoraAtual());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void alterar(ImpressoraPadraoEntity ipe) {
        try {
            sql = "update tb_impressoras set impressoraAtual=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ipe.getImpressoraAtual());
            //stmt.setInt(2, ipe.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
   public String retornaImpAtual() throws SQLException {
        conectar();
        ImpressoraPadraoEntity ipe = new ImpressoraPadraoEntity();
        sql = "select * from tb_impressoras where id=(select max(id) from tb_impressoras)";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while(rs.next()){
            ipe.setId(rs.getInt("id"));
            ipe.setImpressoraAtual(rs.getString("impressoraAtual"));
        }
        stmt.close();
        return ipe.getImpressoraAtual();
   }
   
   public boolean verificaConfiguracaoExistente() throws SQLException {
        conectar();
        String sql = "select * from tb_impressoras";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            return true;
        }
        stmt.close();
        rs.close();
        return false;
    }
}
