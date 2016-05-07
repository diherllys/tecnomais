package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ClienteEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@author Diherllys LL, Reginaldo Cândido

public class ClienteDAO extends ConectaBanco {

    public void adicionar(ClienteEntity ce) throws SQLException {
        conectar();
        String sql = "insert into tb_clientes(nome ,tipo, fantasia, cnpjCPF, rg, indicadorDaIE, cep, numero,"
                + " endereco, complemento, cidade, bairro, estado, pais, telefone1, telefone2) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, ce.getNome());
        stmt.setString(2, ce.getTipoDePessoa());
        stmt.setString(3, ce.getFantasia());
        stmt.setString(4, ce.getCnpjOuCpf());
        stmt.setString(5, ce.getRg());
        stmt.setString(6, ce.getIndicadorDaIE());
        stmt.setString(7, ce.getCep());
        stmt.setString(8, ce.getNumero());
        stmt.setString(9, ce.getEndereco());
        stmt.setString(10, ce.getComplemento());
        stmt.setString(11, ce.getCidade());
        stmt.setString(12, ce.getBairro());
        stmt.setString(13, ce.getEstado());
        stmt.setString(14, ce.getPais());
        stmt.setString(15, ce.getTelefone1());
        stmt.setString(16, ce.getTelefone2());

        stmt.executeUpdate();
        stmt.close();

    }

    public List<ClienteEntity> listar(String nome) throws SQLException {
        conectar();
        String sql = "select * from tb_clientes where nome like ? and id > 1";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        List<ClienteEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            ClienteEntity ce = new ClienteEntity();

            ce.setId(Integer.valueOf(rs.getString("id")));
            ce.setNome(rs.getString("nome"));
            ce.setTipoDePessoa(rs.getString("tipo"));
            ce.setFantasia(rs.getString("fantasia"));
            ce.setCnpjOuCpf(rs.getString("cnpjCPF"));
            ce.setRg(rs.getString("rg"));
            ce.setIndicadorDaIE(rs.getString("indicadorDaIE"));
            ce.setCep(rs.getString("cep"));
            ce.setNumero(rs.getString("numero"));
            ce.setEndereco(rs.getString("endereco"));
            ce.setComplemento(rs.getString("complemento"));
            ce.setCidade(rs.getString("cidade"));
            ce.setBairro(rs.getString("bairro"));
            ce.setEstado(rs.getString("estado"));
            ce.setPais(rs.getString("pais"));
            ce.setTelefone1(rs.getString("telefone1"));
            ce.setTelefone2(rs.getString("telefone2"));

            minhaLista.add(ce);

        }
        rs.close();
        stmt.close();

        return minhaLista;

    }

    public void altera(ClienteEntity ce) throws SQLException {
        conectar();
        String sql = "update tb_clientes set nome=? , tipo=?, fantasia=?, cnpjCPF=?, rg=?, indicadorDaIE=?, cep=?, numero=?,"
                + " endereco=?, complemento=?, cidade=?, bairro=?, estado=?, pais=?, telefone1=?, telefone2=? where id=? ";
        stmt = conn.prepareStatement(sql);

        stmt.setString(1, ce.getNome());
        stmt.setString(2, ce.getTipoDePessoa());
        stmt.setString(3, ce.getFantasia());
        stmt.setString(4, ce.getCnpjOuCpf());
        stmt.setString(5, ce.getRg());
        stmt.setString(6, ce.getIndicadorDaIE());
        stmt.setString(7, ce.getCep());
        stmt.setString(8, ce.getNumero());
        stmt.setString(9, ce.getEndereco());
        stmt.setString(10, ce.getComplemento());
        stmt.setString(11, ce.getCidade());
        stmt.setString(12, ce.getBairro());
        stmt.setString(13, ce.getEstado());
        stmt.setString(14, ce.getPais());
        stmt.setString(15, ce.getTelefone1());
        stmt.setString(16, ce.getTelefone2());

        stmt.setInt(17, ce.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    public void remove(ClienteEntity ce) throws SQLException {
        conectar();
        String sql = "delete from tb_clientes where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, ce.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<ClienteEntity> selecionaCliente(ClienteEntity ce) {
        List<ClienteEntity> minhaLista = new ArrayList<>();
        try {
            conectar();
            String sql = "select * from tb_clientes where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ce.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                ce.setId(Integer.valueOf(rs.getString("id")));
                ce.setNome(rs.getString("nome"));
                ce.setTipoDePessoa(rs.getString("tipo"));
                ce.setFantasia(rs.getString("fantasia"));
                ce.setCnpjOuCpf(rs.getString("cnpjCPF"));
                ce.setRg(rs.getString("rg"));
                ce.setIndicadorDaIE(rs.getString("indicadorDaIE"));
                ce.setCep(rs.getString("cep"));
                ce.setNumero(rs.getString("numero"));
                ce.setEndereco(rs.getString("endereco"));
                ce.setComplemento(rs.getString("complemento"));
                ce.setCidade(rs.getString("cidade"));
                ce.setBairro(rs.getString("bairro"));
                ce.setEstado(rs.getString("estado"));
                ce.setPais(rs.getString("pais"));
                ce.setTelefone1(rs.getString("telefone1"));
                ce.setTelefone2(rs.getString("telefone2"));
                minhaLista.add(ce);
            }
            stmt.close();
            rs.close();
        } catch (Exception r) {
            r.printStackTrace();
        }
        return minhaLista;
    }

}
