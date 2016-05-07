/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.OperacaoDeSaidaEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class OperacaoDeSaidaDAO extends ConectaBanco {

    public void salvar(OperacaoDeSaidaEntity odse) throws SQLException {
        conectar();
        String sql = "insert into tb_operacoesDeSaida(codigo, nome, naturezaDaOp, caracteristicaDeOperacaoSaida, "
                + "dimEstq, entraDinheiro, calcComissProd, calcComissServ) values(?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, odse.getCodigo());
        stmt.setString(2, odse.getNome());
        stmt.setString(3, odse.getNaturezaDaOperacao());
        stmt.setString(4, odse.getCaracteristicaDeOperacao());
        stmt.setBoolean(5, odse.isDimEstq());
        stmt.setBoolean(6, odse.isEntraDinheiro());
        stmt.setBoolean(7, odse.isCalcComissProd());
        stmt.setBoolean(8, odse.isCalcComissServ());

        stmt.executeUpdate();
        stmt.close();
    }

    public void alterar(OperacaoDeSaidaEntity odse) throws SQLException {
        conectar();
        String sql = "update tb_operacoesDeSaida set codigo=?, nome=?, naturezaDaOp=?, caracteristicaDeOperacaoSaida=?,"
                + "dimEstq=?, entraDinheiro=?, calcComissProd=?, calcComissServ=? where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, odse.getCodigo());
        stmt.setString(2, odse.getNome());
        stmt.setString(3, odse.getNaturezaDaOperacao());
        stmt.setString(4, odse.getCaracteristicaDeOperacao());
        stmt.setBoolean(5, odse.isDimEstq());
        stmt.setBoolean(6, odse.isEntraDinheiro());
        stmt.setBoolean(7, odse.isCalcComissProd());
        stmt.setBoolean(8, odse.isCalcComissServ());
        
        stmt.setInt(9, odse.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<OperacaoDeSaidaEntity> listar(String nome) throws SQLException {
        conectar();
        String sql = "select * from tb_operacoesDeSaida where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        List<OperacaoDeSaidaEntity> minhaLista = new ArrayList();
        while (rs.next()) {
            OperacaoDeSaidaEntity odse = new OperacaoDeSaidaEntity();
            odse.setId(rs.getInt("id"));
            odse.setCodigo(rs.getInt("codigo"));
            odse.setNome(rs.getString("nome"));
            odse.setNaturezaDaOperacao(rs.getString("naturezaDaOp"));
            odse.setCaracteristicaDeOperacao(rs.getString("caracteristicaDeOperacaoSaida"));
            odse.setDimEstq(rs.getBoolean("dimEstq"));
            odse.setEntraDinheiro(rs.getBoolean("entraDinheiro"));
            odse.setCalcComissProd(rs.getBoolean("calcComissProd"));
            odse.setCalcComissServ(rs.getBoolean("calcComissServ"));

            minhaLista.add(odse);
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }

    public void remover(Integer id) throws SQLException {
        conectar();
        String sql = "delete tb_operacoesDeSaida where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<OperacaoDeSaidaEntity> selecionaOperacao(int id) throws SQLException {
        conectar();

        String sql = "select * from tb_operacoesDeSaida where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        List<OperacaoDeSaidaEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            OperacaoDeSaidaEntity odse = new OperacaoDeSaidaEntity();
            odse.setId(rs.getInt("id"));
            odse.setCodigo(rs.getInt("codigo"));
            odse.setNome(rs.getString("nome"));
            odse.setNaturezaDaOperacao(rs.getString("naturezaDaOp"));
            odse.setCaracteristicaDeOperacao(rs.getString("caracteristicaDeOperacaoSaida"));
            odse.setDimEstq(rs.getBoolean("dimEstq"));
            odse.setEntraDinheiro(rs.getBoolean("entraDinheiro"));
            odse.setCalcComissProd(rs.getBoolean("calcComissProd"));
            odse.setCalcComissServ(rs.getBoolean("calcComissServ"));
            minhaLista.add(odse);
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }

    public boolean codigoExistente(Integer pesq) throws SQLException {
        conectar();
        String sql = "select codigo from tb_operacoesDeSaida where codigo=?";
        stmt = conn.prepareCall(sql);
        stmt.setInt(1, pesq);
        rs = stmt.executeQuery();

        while (rs.next()) {
            if (rs.getInt("codigo") == pesq) {
                return true;
            }
        }
        rs.close();
        stmt.close();
        return false;

    }

}
