/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ConfigurarTelaVendasEntity;
import java.sql.SQLException;

/**
 *
 * @author Desenvolvimento
 */
public class ConfigurarTelaVendasDAO extends ConectaBanco {

    public void salvarInCfg(ConfigurarTelaVendasEntity ctve) {
        try {
            conectar();
            String sql = "insert into tb_configTelaVendas(InVendOperacao"
                    + ", InVendVendedor, InVendCliente, InVendCaixa) values(?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ctve.getInVendOperacao());
            stmt.setInt(2, ctve.getInVendVendedor());
            stmt.setInt(3, ctve.getInVendCliente());
            stmt.setInt(4, ctve.getInVendCaixa());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateInCfg(ConfigurarTelaVendasEntity ctve) {
        try {
            conectar();
            String sql = "update tb_configTelaVendas set InVendOperacao=?"
                    + ", InVendVendedor=?, InVendCliente=?, InVendCaixa=? where Idcomputador=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ctve.getInVendOperacao());
            stmt.setInt(2, ctve.getInVendVendedor());
            stmt.setInt(3, ctve.getInVendCliente());
            stmt.setInt(4, ctve.getInVendCaixa());
//            stmt.setInt(5, ctve.get);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void salvarCfg(ConfigurarTelaVendasEntity ctve) {
        try {
            conectar();
            String sql = "insert into tb_configTelaVendas(permitirEstqNegativo"
                    + ", limparTelaVendasAposFinalizar, nuncaImpPreVenda, sempreImpPreVenda, "
                    + "semprePergImpPreVenda, passarMercadoriaDiretoComLeitor, InVendOperacao"
                    + ", InVendVendedor, InVendCliente, InVendCaixa, IdComputador,"
                    + "permAlteraCaixa, permAlteraOperacao, permAlteraVendedor, permAlteraCliente,"
                    + "mostraCaixa, mostraCliente, mostraOperacao, mostraVendedor) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ctve.getPermitirEstqNegativo());
            stmt.setInt(2, ctve.getLimparTelaVendasAposFinalizar());
            stmt.setInt(3, ctve.getNuncaImpPreVenda());
            stmt.setInt(4, ctve.getSempreImpPreVenda());
            stmt.setInt(5, ctve.getSemprePergImpPreVenda());
            stmt.setInt(6, ctve.getPassarMercadoriaDiretoComLeitor());

            stmt.setInt(7, ctve.getInVendOperacao());
            stmt.setInt(8, ctve.getInVendVendedor());
            stmt.setInt(9, ctve.getInVendCliente());
            stmt.setInt(10, ctve.getInVendCaixa());
            stmt.setInt(11, ctve.getIdComputador());

            stmt.setInt(12, ctve.getPermAlteraCaixa());
            stmt.setInt(13, ctve.getPermAlteraOperacao());
            stmt.setInt(14, ctve.getPermAlteraVendedor());
            stmt.setInt(15, ctve.getPermAlteraCliente());
            stmt.setInt(16, ctve.getMostraCaixa());
            stmt.setInt(17, ctve.getMostraCliente());
            stmt.setInt(18, ctve.getMostraOperacao());
            stmt.setInt(19, ctve.getMostraVendedor());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCfg(ConfigurarTelaVendasEntity ctve) {
        try {
            conectar();
            String sql = "update tb_configTelaVendas set permitirEstqNegativo=?, "
                    + "limparTelaVendasAposFinalizar=?, nuncaImpPreVenda=?, sempreImpPreVenda=?, "
                    + "semprePergImpPreVenda=?, passarMercadoriaDiretoComLeitor=?, InVendOperacao=?"
                    + ", InVendVendedor=?, InVendCliente=?, InVendCaixa=?, permAlteraCaixa=?, permAlteraOperacao=?, permAlteraVendedor=?, permAlteraCliente=?,"
                    + "mostraCaixa=?, mostraCliente=?, mostraOperacao=?, mostraVendedor=? where IdComputador=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ctve.getPermitirEstqNegativo());
            stmt.setInt(2, ctve.getLimparTelaVendasAposFinalizar());
            stmt.setInt(3, ctve.getNuncaImpPreVenda());
            stmt.setInt(4, ctve.getSempreImpPreVenda());
            stmt.setInt(5, ctve.getSemprePergImpPreVenda());
            System.out.println("ctve.getPassarMercadoriaDiretoComLeitor(" + ctve.getPassarMercadoriaDiretoComLeitor());
            stmt.setInt(6, ctve.getPassarMercadoriaDiretoComLeitor());

            stmt.setInt(7, ctve.getInVendOperacao());
            stmt.setInt(8, ctve.getInVendVendedor());
            stmt.setInt(9, ctve.getInVendCliente());
            stmt.setInt(10, ctve.getInVendCaixa());

            stmt.setInt(11, ctve.getPermAlteraCaixa());
            stmt.setInt(12, ctve.getPermAlteraOperacao());
            stmt.setInt(13, ctve.getPermAlteraVendedor());
            stmt.setInt(14, ctve.getPermAlteraCliente());
            stmt.setInt(15, ctve.getMostraCaixa());
            stmt.setInt(16, ctve.getMostraCliente());
            stmt.setInt(17, ctve.getMostraOperacao());
            stmt.setInt(18, ctve.getMostraVendedor());
            stmt.setInt(19, ctve.getIdComputador());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ConfigurarTelaVendasEntity retornaCfg(Integer idComputador) throws SQLException {
        conectar();
        ConfigurarTelaVendasEntity cfg = new ConfigurarTelaVendasEntity();
        String sql = "select * from tb_configTelaVendas where IdComputador=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idComputador);
        rs = stmt.executeQuery();
        while (rs.next()) {
            cfg.setLimparTelaVendasAposFinalizar(rs.getInt("limparTelaVendasAposFinalizar"));
            cfg.setPermitirEstqNegativo(rs.getInt("permitirEstqNegativo"));
            cfg.setNuncaImpPreVenda(rs.getInt("nuncaImpPreVenda"));
            cfg.setSempreImpPreVenda(rs.getInt("sempreImpPreVenda"));
            cfg.setSemprePergImpPreVenda(rs.getInt("semprePergImpPreVenda"));
            cfg.setPassarMercadoriaDiretoComLeitor(rs.getInt("passarMercadoriaDiretoComLeitor"));

            cfg.setInVendCaixa(rs.getInt("InVendCaixa"));
            cfg.setInVendCliente(rs.getInt("InVendCliente"));
            cfg.setInVendOperacao(rs.getInt("InVendOperacao"));
            cfg.setInVendVendedor(rs.getInt("InVendVendedor"));
          
            cfg.setIdComputador(rs.getInt("IdComputador"));

            cfg.setPermAlteraCaixa(rs.getInt("permAlteraCaixa"));
            cfg.setPermAlteraCliente(rs.getInt("permAlteraCliente"));
            cfg.setPermAlteraOperacao(rs.getInt("permAlteraOperacao"));
            cfg.setPermAlteraVendedor(rs.getInt("permAlteraVendedor"));
            cfg.setMostraCaixa(rs.getInt("mostraCaixa"));
            cfg.setMostraCliente(rs.getInt("mostraCliente"));
            cfg.setMostraOperacao(rs.getInt("mostraOperacao"));
            cfg.setMostraVendedor(rs.getInt("mostraVendedor"));
        }
        return cfg;
    }

}
