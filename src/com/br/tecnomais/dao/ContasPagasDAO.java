/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ContasPagasEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ContasPagasDAO extends ConectaBanco {

    public void save(ContasPagasEntity cpe) {
        try {
            conectar();
            String sql = "insert into tb_contasPagas(datavencimento, dataPagamento, descricao"
                    + ", valorPago, fornecedor, tipoCobranca, observacoes, entradaId, usuario,"
                    + " contaPagarId, caixa) values(?, ?, ?, ? ,? ,? ,? ,? ,? ,? ,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpe.getDataVencimento());
            stmt.setString(2, cpe.getDataPagamento());
            stmt.setString(3, cpe.getDescricao());
            stmt.setDouble(4, cpe.getVlrPago());
            stmt.setString(5, cpe.getFornecedor());
            stmt.setString(6, cpe.getTipoCobranca());
            stmt.setString(7, cpe.getObs());
            stmt.setInt(8, cpe.getEntradaId());
            stmt.setString(9, cpe.getUsuario());
            stmt.setInt(10, cpe.getContaPagarId());
            stmt.setString(11, cpe.getCaixa());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(ContasPagasEntity cpe) {
        try {
            conectar();
            String sql = "update tb_contasPagas set dataVencimento=?, dataPagamento=?, descricao=?"
                    + ", valorPagar=?, fornecedor=?, tipoCobranca=?, observacoes=?, entradaId=?, caixa=? where contasPagasId=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpe.getDataVencimento());
            stmt.setString(2, cpe.getDataPagamento());
            stmt.setString(3, cpe.getDescricao());
            stmt.setDouble(4, cpe.getVlrPago());
            stmt.setString(5, cpe.getFornecedor());
            stmt.setString(6, cpe.getTipoCobranca());
            stmt.setString(7, cpe.getObs());
            stmt.setInt(8, cpe.getEntradaId());
            stmt.setString(9, cpe.getCaixa());
            stmt.setInt(10, cpe.getContasPagasId());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<ContasPagasEntity> contasPagarList(Integer id) throws SQLException {
        List<ContasPagasEntity> minhaLista = new ArrayList<>();
        String sql = "select * from tb_contaPagas where contaPagarId=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        while (rs.next()) {
            ContasPagasEntity cpe = new ContasPagasEntity();
            cpe.setContasPagasId(rs.getInt("contaPagasId"));
            cpe.setDataPagamento(rs.getString("dataPagamento"));
            cpe.setDataVencimento(rs.getString("dataVencimento"));
            cpe.setDescricao(rs.getString("descricao"));
            cpe.setEntradaId(rs.getInt("entradaId"));
            cpe.setFornecedor(rs.getString("fornecedor"));
            cpe.setObs(rs.getString("observacoes"));
            cpe.setTipoCobranca(rs.getString("tipoCobranca"));
            cpe.setVlrPago(rs.getDouble("valorPago"));
            cpe.setUsuario(rs.getString("usuario"));
            cpe.setCaixa(rs.getString("caixa"));
            minhaLista.add(cpe);
        }
        return minhaLista;
    }

    public List<ContasPagasEntity> listaContasPagas() throws Exception {
        conectar();
        List<ContasPagasEntity> lista = new ArrayList<>();
        String sql = "select top 200 * from tb_contasPagas";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ContasPagasEntity cpe = new ContasPagasEntity();
            cpe.setContasPagasId(rs.getInt("contaPagasId"));
            cpe.setDataPagamento(rs.getString("dataPagamento"));
            cpe.setDataVencimento(rs.getString("dataVencimento"));
            cpe.setDescricao(rs.getString("descricao"));
            cpe.setEntradaId(rs.getInt("entradaId"));
            cpe.setFornecedor(rs.getString("fornecedor"));
            cpe.setObs(rs.getString("observacoes"));
            cpe.setTipoCobranca(rs.getString("tipoCobranca"));
            cpe.setVlrPago(rs.getDouble("valorPago"));
            cpe.setUsuario(rs.getString("usuario"));
            cpe.setCaixa(rs.getString("caixa"));
            lista.add(cpe);
        }
        return lista;
    }

    public List<ContasPagasEntity> listaContasPagasFiltros(String descOsb, String tipoCobranca,
            String dataVencimento, String fornecedor, String usuario, String dataPagamento, String obs, String caixa) throws Exception {
        conectar();
        List<ContasPagasEntity> lista = new ArrayList<>();
        String sql = "select * from tb_contasPagas where descricao like ? and observacoes like ? and"
                + " tipoCobranca like ? and dataVencimento like ? and fornecedor like ? and usuario like ?"
                + " and dataPagamento like ? and caixa like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, descOsb);
        stmt.setString(2, obs);
        stmt.setString(3, tipoCobranca);
        stmt.setString(4, dataVencimento);
        stmt.setString(5, fornecedor);
        stmt.setString(6, usuario);
        stmt.setString(7, dataPagamento);
        stmt.setString(8, caixa);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ContasPagasEntity cpe = new ContasPagasEntity();
            cpe.setContasPagasId(rs.getInt("contaPagasId"));
            cpe.setDataPagamento(rs.getString("dataPagamento"));
            cpe.setDataVencimento(rs.getString("dataVencimento"));
            cpe.setDescricao(rs.getString("descricao"));
            cpe.setEntradaId(rs.getInt("entradaId"));
            cpe.setFornecedor(rs.getString("fornecedor"));
            cpe.setObs(rs.getString("observacoes"));
            cpe.setTipoCobranca(rs.getString("tipoCobranca"));
            cpe.setVlrPago(rs.getDouble("valorPago"));
            cpe.setUsuario(rs.getString("usuario"));
            cpe.setCaixa(rs.getString("caixa"));
            lista.add(cpe);
        }
        return lista;
    }

    public void deletarContaPagas(Integer id) {
        try {
            conectar();
            String sql = "delete from tb_contasPagas where contaPagasId=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
