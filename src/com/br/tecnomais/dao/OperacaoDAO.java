/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.OperacaoEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class OperacaoDAO extends ConectaBanco {

    public void salvar(OperacaoEntity oe) throws SQLException {
        conectar();
        String sql = "insert into tb_operacoes (codigo, nome, naturezaDaOp, caracteristicaDeCompra, aumentaEstq, "
                + "saiDinheiro, dimComiDeProd, dimComiDeServ) values (?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, oe.getCodigo());
        stmt.setString(2, oe.getNome());
        stmt.setString(3, oe.getNatureza());
        stmt.setString(4, oe.getCaracteristicaDeOperacao());
        stmt.setBoolean(5, oe.isAumentaEstq());
        stmt.setBoolean(6, oe.isSaiDinheiro());
        stmt.setBoolean(7, oe.isDimComiDeProd());
        stmt.setBoolean(8, oe.isDimComiDeServ());

        stmt.executeUpdate();
        stmt.close();
    }

    public void alterar(OperacaoEntity oe) throws SQLException {
        conectar();
        String sql = "update tb_operacoes set codigo=?, nome=?, naturezaDaOp=?, caracteristicaDeCompra=?, "
                + "aumentaEstq=?, saiDinheiro=?, dimComiDeProd=?, dimComiDeServ=? where id=? ";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, oe.getCodigo());
        stmt.setString(2, oe.getNome());
        stmt.setString(3, oe.getNatureza());
        stmt.setString(4, oe.getCaracteristicaDeOperacao());
         stmt.setBoolean(5, oe.isAumentaEstq());
        stmt.setBoolean(6, oe.isSaiDinheiro());
        stmt.setBoolean(7, oe.isDimComiDeProd());
        stmt.setBoolean(8, oe.isDimComiDeServ());
        stmt.setInt(9, oe.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<OperacaoEntity> listar(String nome) throws SQLException {
        conectar();

        String sql = "select * from tb_operacoes where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        List<OperacaoEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            OperacaoEntity oe = new OperacaoEntity();
            oe.setId(rs.getInt("id"));
            oe.setCodigo(rs.getInt("codigo"));
            oe.setNome(rs.getString("nome"));
            oe.setNatureza(rs.getString("naturezaDaOp"));
            oe.setCaracteristicaDeOperacao(rs.getString("caracteristicaDeCompra"));
            oe.setAumentaEstq(rs.getBoolean("aumentaEstq"));
            oe.setSaiDinheiro(rs.getBoolean("saiDinheiro"));
            oe.setDimComiDeProd(rs.getBoolean("dimComiDeProd"));
            oe.setDimComiDeServ(rs.getBoolean("dimComiDeServ"));
            minhaLista.add(oe);
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }

    public void remover(Integer id) throws SQLException {
        conectar();
        String sql = "delete tb_operacoes where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<OperacaoEntity> selecionaOperacao(int id) throws SQLException {
        conectar();
        OperacaoEntity oe = new OperacaoEntity();
        String sql = "select * from tb_operacoes where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        List<OperacaoEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
           oe.setId(rs.getInt("id"));
            oe.setCodigo(rs.getInt("codigo"));
            oe.setNome(rs.getString("nome"));
            oe.setNatureza(rs.getString("naturezaDaOp"));
            oe.setCaracteristicaDeOperacao(rs.getString("caracteristicaDeCompra"));
            oe.setAumentaEstq(rs.getBoolean("aumentaEstq"));
            oe.setSaiDinheiro(rs.getBoolean("saiDinheiro"));
            oe.setDimComiDeProd(rs.getBoolean("dimComiDeProd"));
            oe.setDimComiDeServ(rs.getBoolean("dimComiDeServ"));
            minhaLista.add(oe);
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }

    public boolean codigoExistente(Integer codigo) throws SQLException {
        conectar();
        String sql = "select codigo from tb_operacoes where codigo=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigo);
        rs = stmt.executeQuery();
        while (rs.next()) {
            if (rs.getInt("codigo") == codigo) {
                return true;
            }
        }

        rs.close();
        stmt.close();
        return false;
    }

    public List<OperacaoEntity> preencheComboBoxOperacaoInEntrada() throws Exception {
        conectar();
        List<OperacaoEntity> lista = new ArrayList<>();
        String sql = "select * from tb_operacoes";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            OperacaoEntity op = new OperacaoEntity();
            op.setNome(rs.getString("nome"));
            lista.add(op);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
