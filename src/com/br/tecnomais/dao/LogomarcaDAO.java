/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import java.sql.SQLException;

/**
 *
 * @author Desenvolvimento
 */
public class LogomarcaDAO extends ConectaBanco {

    public void salvarLogoMarca(String foto) throws SQLException {
        conectar();
        String sql = "insert into tb_logomarca (foto) values(?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, foto);
        stmt.executeUpdate();
        stmt.close();

    }

    public void update(String foto) throws SQLException {
        conectar();
        String sql = "update tb_logomarca set foto=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, foto);
        stmt.executeUpdate();
        stmt.close();
    }

    public void remover(String id) throws SQLException {
        conectar();
        String sql = "delete tb_logomarca where foto=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
    
    public String mostraLogomarca() throws SQLException {
        conectar();
        String sql = "SELECT * FROM tb_logomarca where id=(select max(id) from tb_logomarca)";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        String aux="";
        while (rs.next()) {
          aux =rs.getString("foto");
        }

        rs.close();
        stmt.close();
        return aux;
    }
    
    public boolean verificaLogoMarcaExistente() throws SQLException{
        conectar();
        String sql = "select * from tb_logomarca";
        stmt = conn.prepareStatement(sql);
        rs= stmt.executeQuery();
       
        while(rs.next()){
            return true;
        }
        stmt.close();
        rs.close();
        return false;
    }
}
