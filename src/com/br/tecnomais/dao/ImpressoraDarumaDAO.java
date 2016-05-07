/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ImpressoraDarumaEntity;
import java.sql.SQLException;

/**
 *
 * @author Desenvolvimento
 */
public class ImpressoraDarumaDAO extends ConectaBanco {

    String sql = "";

    public void salvar(ImpressoraDarumaEntity ide) throws SQLException {
        conectar();
        sql = "insert into tb_impressoraDaruma(registroTermico, portaComunicacao, portaVelocidade, statusGuilhotina,"
                + " tamanhoGuilhotina, numSaltoLinhas, zeroCortadoStatus) values(?, ?, ?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, ide.getRegistroTermico());
        stmt.setString(2, ide.getPortaComunicacao());
        stmt.setString(3, ide.getPortaVelocidade());
        stmt.setString(4, ide.getStatusGuilhotina());
        stmt.setString(5, ide.getTamanhoGuilhotina());
        stmt.setString(6, ide.getNumSaltoLinhas());
        stmt.setString(7, ide.getZeroCortadoStatus());
        stmt.executeUpdate();
        stmt.close();
      
    }

    public void update(ImpressoraDarumaEntity ide) throws SQLException {
        conectar();
        sql = "update tb_impressoraDaruma set registroTermico=?, portaComunicacao=?, portaVelocidade=?, statusGuilhotina=?"
                + ", tamanhoGuilhotina=?, numSaltoLinhas=?, zeroCortadoStatus=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, ide.getRegistroTermico());
        stmt.setString(2, ide.getPortaComunicacao());
        stmt.setString(3, ide.getPortaVelocidade());
        stmt.setString(4, ide.getStatusGuilhotina());
        stmt.setString(5, ide.getTamanhoGuilhotina());
        stmt.setString(6, ide.getNumSaltoLinhas());
        stmt.setString(7, ide.getZeroCortadoStatus());
       // stmt.setInt(8, ide.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    public ImpressoraDarumaEntity retornaIde() throws SQLException {
        conectar();
        ImpressoraDarumaEntity ide = new ImpressoraDarumaEntity();
        sql = "select * from tb_impressoraDaruma where id=(select max(id) from tb_impressoraDaruma)";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        ide.setNumSaltoLinhas("0");
        ide.setPortaComunicacao("0");
        ide.setPortaVelocidade("0");
        ide.setRegistroTermico("0");
        ide.setStatusGuilhotina("0");
        ide.setTamanhoGuilhotina("0");
        ide.setZeroCortadoStatus("0");
        while (rs.next()) {
            ide.setId(rs.getInt("id"));
            ide.setNumSaltoLinhas(rs.getString("numSaltoLinhas"));
            ide.setPortaComunicacao(rs.getString("portaComunicacao"));
            ide.setPortaVelocidade(rs.getString("portaVelocidade"));
            ide.setRegistroTermico(rs.getString("registroTermico"));
            ide.setStatusGuilhotina(rs.getString("statusGuilhotina"));
            ide.setTamanhoGuilhotina(rs.getString("tamanhoGuilhotina"));
            ide.setZeroCortadoStatus(rs.getString("zeroCortadoStatus"));
        }
        stmt.close();
        return ide;
    }

    public boolean verificaConfiguracaoExistente() throws SQLException {
        conectar();
        String sql = "select * from tb_impressoraDaruma";
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
