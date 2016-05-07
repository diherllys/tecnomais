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
 * @author Diherllys e Dudu
 */
public class BackupDAO extends ConectaBanco {

    public void fazBackup(String nomeDoBanco) {
        try {
            conectar();
            String sql = "BACKUP DATABASE tecnomais TO DISK = 'C:\\Backup\\" + nomeDoBanco + "'";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public void restauraBackup() {
//        try {
//            conectar();
//            String sql = "RESTORE DATABASE tecnomais FROM DISK = 'C:\\Backup\\tecnomais10-08-2015-10;37.bak' WITH RECOVERY";
//            stmt = conn.prepareStatement(sql);
//            stmt.executeUpdate();
//            stmt.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    public String opcaoDeBackupAtual() throws SQLException {
        conectar();
        String sql = "select opcaoBackup from tb_backup where id=1";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        String aux="";
        while (rs.next()) {
          aux = rs.getString("opcaoBackup");
        }
        return aux;
    }

    public void salvaOpcaoDeBackup(String opcao) {
        try {
            conectar();
            String sql = "insert into tb_backup (opcaoBackup) values(?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, opcao);
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean verExistDaOpcaoDeBackup() throws SQLException {
        conectar();
        String sql = "select * from tb_backup";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            return true;
        }
        stmt.close();
        rs.close();
        return false;
    }

    public void update(String opcao) throws SQLException {
        conectar();
        String sql = "update tb_backup set opcaoBackup=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, opcao);
        stmt.executeUpdate();
        stmt.close();
    }
}
