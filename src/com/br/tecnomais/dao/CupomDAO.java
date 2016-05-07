/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.CupomEntity;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desenvolvimento
 */
public class CupomDAO extends ConectaBanco {

    public void save(CupomEntity ce) {
        try {
            conectar();
            String sql = "insert into tb_cupom(cabecalho, endereco, mensagem) values(?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ce.getCabecalho());
            stmt.setString(2, ce.getEndereco());
            stmt.setString(3, ce.getMensagem());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CupomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(CupomEntity ce) {
        try {
            conectar();
            String sql = "update tb_cupom set cabecalho=?, endereco=?, mensagem=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ce.getCabecalho());
            stmt.setString(2, ce.getEndereco());
            stmt.setString(3, ce.getMensagem());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CupomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public CupomEntity retornaConfigsCupom() throws SQLException{
        conectar();
        CupomEntity ce = new CupomEntity();
        String sql="select * from tb_cupom";
        stmt= conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while(rs.next()){
            ce.setCabecalho(rs.getString("cabecalho"));
            ce.setEndereco(rs.getString("endereco"));
            ce.setMensagem(rs.getString("mensagem"));
            System.out.println("end "+ ce.getEndereco());
        }
        stmt.close();
        rs.close();
        return ce;
    }

}
