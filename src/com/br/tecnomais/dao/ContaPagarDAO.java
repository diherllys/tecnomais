/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ContasPagarEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ContaPagarDAO extends ConectaBanco {

    public void save(ContasPagarEntity cpe) {
        try {
            conectar();
            String sql = "insert into tb_contasPagar (dataEmisao, dataPagamento, descricao"
                    + ", valorPagar, fornecedor, tipoCobranca, observacoes, entradaId, usuario, status) values(?, ?, ? ,? ,? ,? ,? ,? ,? ,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpe.getDataEmissao());
            stmt.setString(2, cpe.getDataVencimento());
            stmt.setString(3, cpe.getDescricao());
            stmt.setDouble(4, cpe.getVlrPagar());
            stmt.setString(5, cpe.getFornecedor());
            stmt.setString(6, cpe.getTipoCobranca());
            stmt.setString(7, cpe.getObs());
            stmt.setInt(8, cpe.getEntradaId());
            stmt.setString(9, cpe.getUsuario());
            stmt.setString(10, cpe.getStatus());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(ContasPagarEntity cpe) {
        try {
            conectar();
            String sql = "update tb_contasPagar set dataEmisao=?, dataPagamento=?, descricao=?"
                    + ", valorPagar=?, fornecedor=?, tipoCobranca=?, observacoes=?, entradaId=?, status =? where contaPagarId=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpe.getDataEmissao());
            stmt.setString(2, cpe.getDataVencimento());
            stmt.setString(3, cpe.getDescricao());
            stmt.setDouble(4, cpe.getVlrPagar());
            stmt.setString(5, cpe.getFornecedor());
            stmt.setString(6, cpe.getTipoCobranca());
            stmt.setString(7, cpe.getObs());
            stmt.setInt(8, cpe.getEntradaId());
            stmt.setInt(9, cpe.getContaId());
            stmt.setString(10, cpe.getStatus());
            stmt.setString(11, cpe.getUsuario());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<ContasPagarEntity> contasPagarList(Integer id) throws Exception {
        List<ContasPagarEntity> minhaLista = new ArrayList<>();
        String sql = "select * from tb_contasPagar where contaPagarId=? and status=?";
        //continuar aqui select onde status forem on
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, "ON");
        rs = stmt.executeQuery();

        while (rs.next()) {
            ContasPagarEntity cpe = new ContasPagarEntity();
            cpe.setContaId(rs.getInt("contaPagarId"));
            cpe.setDataEmissao(rs.getString("dataEmisao"));
            cpe.setDataVencimento(rs.getString("dataPagamento"));
            cpe.setDescricao(rs.getString("descricao"));
            cpe.setEntradaId(rs.getInt("entradaId"));
            cpe.setFornecedor(rs.getString("fornecedor"));
            cpe.setObs(rs.getString("observacoes"));
            cpe.setTipoCobranca(rs.getString("tipoCobranca"));
            cpe.setVlrPagar(rs.getDouble("valorPagar"));
            cpe.setUsuario(rs.getString("usuario"));
            minhaLista.add(cpe);
        }
        return minhaLista;
    }

    public List<ContasPagarEntity> contasPagarListEntradaID(Integer id) throws Exception {
        List<ContasPagarEntity> minhaLista = new ArrayList<>();
        String sql = "select * from tb_contasPagar where entradaID=? and status=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, "ON");
        rs = stmt.executeQuery();

        while (rs.next()) {
            ContasPagarEntity cpe = new ContasPagarEntity();
            cpe.setContaId(rs.getInt("contaPagarId"));
            cpe.setDataEmissao(rs.getString("dataEmisao"));
            cpe.setDataVencimento(rs.getString("dataPagamento"));
            cpe.setDescricao(rs.getString("descricao"));
            cpe.setEntradaId(rs.getInt("entradaId"));
            cpe.setFornecedor(rs.getString("fornecedor"));
            cpe.setObs(rs.getString("observacoes"));
            cpe.setTipoCobranca(rs.getString("tipoCobranca"));
            cpe.setVlrPagar(rs.getDouble("valorPagar"));
            cpe.setUsuario(rs.getString("usuario"));
            minhaLista.add(cpe);
        }
        return minhaLista;
    }

    public List<ContasPagarEntity> listaContasPagarFiltros(String descOsb, String tipoCobranca,
            String dataVencimento, String fornecedor, String usuario, String dataPagamento, String obs) throws Exception {
        conectar();
        List<ContasPagarEntity> lista = new ArrayList<>();
        String sql = "select * from tb_contasPagar where descricao like ? and observacoes like ? and"
                + " tipoCobranca like ? and dataPagamento like ? and fornecedor like ? and usuario like ?"
                + " and dataEmisao like ? and status=? order by contaPagarId desc";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, descOsb);
        stmt.setString(2, obs);
        System.out.println("tipo cobranca: " + tipoCobranca);
        stmt.setString(3, tipoCobranca);
        stmt.setString(4, dataVencimento);
        stmt.setString(5, fornecedor);
        stmt.setString(6, usuario);
        stmt.setString(7, dataPagamento);
        stmt.setString(8, "ON");
        rs = stmt.executeQuery();
        while (rs.next()) {
            ContasPagarEntity cpe = new ContasPagarEntity();
            cpe.setContaId(rs.getInt("contaPagarId"));
            cpe.setDataEmissao(rs.getString("dataEmisao"));
            cpe.setDataVencimento(rs.getString("dataPagamento"));
            cpe.setDescricao(rs.getString("descricao"));
            cpe.setEntradaId(rs.getInt("entradaId"));
            cpe.setFornecedor(rs.getString("fornecedor"));
            cpe.setObs(rs.getString("observacoes"));
            cpe.setTipoCobranca(rs.getString("tipoCobranca"));
            cpe.setVlrPagar(rs.getDouble("valorPagar"));
            cpe.setUsuario(rs.getString("usuario"));
            lista.add(cpe);
        }
        return lista;
    }

    public List<ContasPagarEntity> listaContasPagar() throws Exception {
        conectar();
        List<ContasPagarEntity> lista = new ArrayList<>();
        String sql = "select top 200 * from tb_contasPagar where status=? order by contaPagarId desc ";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, "ON");
        rs = stmt.executeQuery();
        while (rs.next()) {
            ContasPagarEntity cpe = new ContasPagarEntity();
            cpe.setContaId(rs.getInt("contaPagarId"));
            cpe.setDataEmissao(rs.getString("dataEmisao"));
            cpe.setDataVencimento(rs.getString("dataPagamento"));
            cpe.setDescricao(rs.getString("descricao"));
            cpe.setEntradaId(rs.getInt("entradaId"));
            cpe.setFornecedor(rs.getString("fornecedor"));
            cpe.setObs(rs.getString("observacoes"));
            cpe.setTipoCobranca(rs.getString("tipoCobranca"));
            cpe.setVlrPagar(rs.getDouble("valorPagar"));
            cpe.setUsuario(rs.getString("usuario"));
            lista.add(cpe);
        }
        return lista;
    }

    public List<ContasPagarEntity> listaContasPagarId(Integer id) throws Exception {
        conectar();
        List<ContasPagarEntity> lista = new ArrayList<>();
        String sql = "select * from tb_contasPagar where contaPagarId=? and status=? order by contaPagarId desc";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, "ON");
        rs = stmt.executeQuery();
        while (rs.next()) {
            ContasPagarEntity cpe = new ContasPagarEntity();
            cpe.setContaId(rs.getInt("contaPagarId"));
            cpe.setDataEmissao(rs.getString("dataEmisao"));
            cpe.setDataVencimento(rs.getString("dataPagamento"));
            cpe.setDescricao(rs.getString("descricao"));
            cpe.setEntradaId(rs.getInt("entradaId"));
            cpe.setFornecedor(rs.getString("fornecedor"));
            cpe.setObs(rs.getString("observacoes"));
            cpe.setTipoCobranca(rs.getString("tipoCobranca"));
            cpe.setVlrPagar(rs.getDouble("valorPagar"));
            cpe.setUsuario(rs.getString("usuario"));
            lista.add(cpe);
        }
        return lista;
    }

    public void deletarConta(Integer id) {
        try {
            conectar();
            String sql = "delete from tb_contasPagar where contaPagarId=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(Integer id, String status) {
        try {
            conectar();
            String sql = "update tb_contasPagar set status=? where contaPagarId=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
