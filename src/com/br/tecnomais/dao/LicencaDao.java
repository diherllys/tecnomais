package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.LicencaEntity;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class LicencaDao extends ConectaBanco {

    public boolean verificaLicencaExistente() throws Exception {
        conectar();
        String sql = "select * from tb_licenca";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public void gravarLicenca(LicencaEntity lic) throws Exception {
        conectar();
        String sql = "insert into tb_licenca (NumeroLicenca, Nome, Endereco, Bairro, Cidade, UF, Cnpj, InscricaoEstadual, DataAdesao, DataVencimento) values(?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, lic.getNumeroLicenca());
        stmt.setString(2, lic.getNome());
        stmt.setString(3, lic.getEndereco());
        stmt.setString(4, lic.getBairro());
        stmt.setString(5, lic.getCidade());
        stmt.setString(6, lic.getUf());
        stmt.setString(7, lic.getCnpj());
        stmt.setString(8, lic.getInscricaoEstadual());
        stmt.setString(9, lic.getDataAdesao());
        stmt.setString(10, lic.getDataVencimento());
        stmt.executeUpdate();
    }

    public void atualizaDadosLogon(String dataAtual, String proximoDia) throws Exception {
        conectar();
        String sql = "update tb_loggon set DiaAtual = ?, ProximoDia = ? where Id = 1000";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataAtual);
        stmt.setString(2, proximoDia);
        stmt.executeUpdate();
    }

    public void inserirDadosLogon(String dataAtual, String proximoDia) throws Exception {
        conectar();
        String sql = "insert into tb_loggon(DiaAtual, ProximoDia, Id) values(?, ?, 1000)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataAtual);
        stmt.setString(2, proximoDia);
        stmt.executeUpdate();
    }

    public Integer retornaNumLicensa() throws SQLException {
        conectar();
        String sql = "select NumeroLicenca from tb_licenca";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        Integer numeroLicenca = 0;
        while (rs.next()) {
            numeroLicenca = rs.getInt("NumeroLicenca");
        }
        return numeroLicenca;
    }
}
