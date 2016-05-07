/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.PermissoesEntity;
import java.sql.SQLException;

/**
 *
 * @author Desenvolvimento
 */
public class PermissoesDAO extends ConectaBanco {

    public void salvarPerm(PermissoesEntity pe) {
        try {
            conectar();
            String sql = "insert into tb_permissoes(idUsuario, movimentacao, movContRecbPagFlxCaixa, cadastroFilial,"
                    + " cadastroUsuario, cadastro, configurarLogo, configurarImp, configurarPerm, escritorio, cancelarVendas, abrirGaveta) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pe.getIdUsuario());
            stmt.setInt(2, pe.getMovimentacao());
            stmt.setInt(3, pe.getMovContRecbPagFlxCaixa());
            stmt.setInt(4, pe.getCadastroFilial());
            stmt.setInt(5, pe.getCadastroUsuario());
            stmt.setInt(6, pe.getCadastro());
            stmt.setInt(7, pe.getConfigurarLogo());
            stmt.setInt(8, pe.getConfigurarImp());
            stmt.setInt(9, pe.getConfigurarPerm());
            stmt.setInt(10, pe.getEscritorio());
            stmt.setInt(11, pe.getCancelarVenda());
            stmt.setInt(12, pe.getAbrirGaveta());

            stmt.executeUpdate();
            stmt.close();

            // stmt.setInt(1)
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void alterarPerm(PermissoesEntity pe) {
        try {
            conectar();
            String sql = "update tb_permissoes set movimentacao=?, movContRecbPagFlxCaixa=?, cadastroFilial=?,"
                    + " cadastroUsuario=?, cadastro=?, configurarLogo=?, configurarImp=?, configurarPerm=?, escritorio=?, cancelarVendas=?, abrirGaveta=? where idUsuario=? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pe.getMovimentacao());
            stmt.setInt(2, pe.getMovContRecbPagFlxCaixa());
            stmt.setInt(3, pe.getCadastroFilial());
            stmt.setInt(4, pe.getCadastroUsuario());
            stmt.setInt(5, pe.getCadastro());
            stmt.setInt(6, pe.getConfigurarLogo());
            stmt.setInt(7, pe.getConfigurarImp());
            stmt.setInt(8, pe.getConfigurarPerm());
            stmt.setInt(9, pe.getEscritorio());
            stmt.setInt(10, pe.getCancelarVenda());
            stmt.setInt(11, pe.getAbrirGaveta());
            stmt.setInt(12, pe.getIdUsuario());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public PermissoesEntity buscaPerm(int idUsuario) throws SQLException {
        conectar();
        PermissoesEntity pe2 = new PermissoesEntity();
        String sql = "select * from tb_permissoes where idUsuario=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        rs = stmt.executeQuery();
        while (rs.next()) {
            PermissoesEntity pe = new PermissoesEntity();
            pe.setId(rs.getInt("id"));
            pe.setIdUsuario(rs.getInt("idUsuario"));
            pe.setCadastro(rs.getInt("cadastro"));
            pe.setCadastroFilial(rs.getInt("cadastroFilial"));
            pe.setCadastroUsuario(rs.getInt("cadastroUsuario"));
            pe.setConfigurarImp(rs.getInt("configurarImp"));
            pe.setConfigurarLogo(rs.getInt("configurarLogo"));
            pe.setConfigurarPerm(rs.getInt("configurarPerm"));
            pe.setMovContRecbPagFlxCaixa(rs.getInt("movContRecbPagFlxCaixa"));
            pe.setMovimentacao(rs.getInt("movimentacao"));
            pe.setEscritorio(rs.getInt("escritorio"));
            pe.setCancelarVenda(rs.getInt("cancelarVendas"));
            pe.setAbrirGaveta(rs.getInt("abrirGaveta"));
            pe2 = pe;
        }
        stmt.close();
        rs.close();
        return pe2;
    }

    public boolean verificaIdUsuario(int idUsuario) throws SQLException {
        conectar();
        PermissoesEntity pe = new PermissoesEntity();
        String sql = "select idUsuario from tb_permissoes where idUsuario=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        rs = stmt.executeQuery();
        while (rs.next()) {
            pe.setIdUsuario(rs.getInt("idUsuario"));
            return true;
        }
        return false;
    }

}
