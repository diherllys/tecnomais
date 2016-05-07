/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desenvolvimento
 */
public class BlocoDeNotasDAO extends ConectaBanco {

    String sql = "";

    public List<String> retornaTexto() throws SQLException {
        conectar();
        sql = "select texto from blocoDeNotas";
        List<String> minhaLista = new ArrayList<>();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while(rs.next()){
           minhaLista.add(rs.getString("texto"));
        }
        
        return minhaLista;
    }

    public void salvar(String codigo, String texto) {
        conectar();
        try {
            sql = "insert into blocoDeNotas (codigo, texto) values (? ,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.setString(2, texto);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
