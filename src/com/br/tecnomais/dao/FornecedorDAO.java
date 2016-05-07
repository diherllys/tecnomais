package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.FornecedorEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@author Diherllys LL, Reginaldo Cândido
public class FornecedorDAO extends ConectaBanco {

    public void adicionar(FornecedorEntity fe) throws SQLException {
        conectar();
        String sql = "insert into tb_fornecedores(nome ,tipo, fantasia, cnpjCPF, rg, indicadorDaIE, cep, numero,"
                + " endereco, complemento, cidade, bairro, estado, pais, telefone1, telefone2) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, fe.getNome());
        stmt.setString(2, fe.getTipoDePessoa());
        stmt.setString(3, fe.getFantasia());
        stmt.setString(4, fe.getCnpjOuCpf());
        stmt.setString(5, fe.getRg());
        stmt.setString(6, fe.getIndicadorDaIE());
        stmt.setString(7, fe.getCep());
        stmt.setString(8, fe.getNumero());
        stmt.setString(9, fe.getEndereco());
        stmt.setString(10, fe.getComplemento());
        stmt.setString(11, fe.getCidade());
        stmt.setString(12, fe.getBairro());
        stmt.setString(13, fe.getEstado());
        stmt.setString(14, fe.getPais());
        stmt.setString(15, fe.getTelefone1());
        stmt.setString(16, fe.getTelefone2());

        stmt.executeUpdate();
        stmt.close();

    }

    public boolean verificaFornecedor(String nome) throws SQLException {
        conectar();
        String sql = "select * from tb_fornecedores where nome=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        if (rs.next()) {
            return true;
        }
        return false;
    }

    public List<FornecedorEntity> listar(String nome) throws SQLException {
        conectar();
        String sql = "select * from tb_fornecedores where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        List<FornecedorEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            FornecedorEntity fe = new FornecedorEntity();

            fe.setId(Integer.valueOf(rs.getString("id")));
            fe.setNome(rs.getString("nome"));
            fe.setTipoDePessoa(rs.getString("tipo"));
            fe.setFantasia(rs.getString("fantasia"));
            fe.setCnpjOuCpf(rs.getString("cnpjCPF"));
            fe.setRg(rs.getString("rg"));
            fe.setIndicadorDaIE(rs.getString("indicadorDaIE"));
            fe.setCep(rs.getString("cep"));
            fe.setNumero(rs.getString("numero"));
            fe.setEndereco(rs.getString("endereco"));
            fe.setComplemento(rs.getString("complemento"));
            fe.setCidade(rs.getString("cidade"));
            fe.setBairro(rs.getString("bairro"));
            fe.setEstado(rs.getString("estado"));
            fe.setPais(rs.getString("pais"));
            fe.setTelefone1(rs.getString("telefone1"));
            fe.setTelefone2(rs.getString("telefone2"));

            minhaLista.add(fe);

        }
        rs.close();
        stmt.close();

        return minhaLista;

    }

    public void altera(FornecedorEntity fe) throws SQLException {
        conectar();
        String sql = "update tb_fornecedores set nome=? , tipo=?, fantasia=?, cnpjCPF=?, rg=?, indicadorDaIE=?, cep=?, numero=?,"
                + " endereco=?, complemento=?, cidade=?, bairro=?, estado=?, pais=?, telefone1=?, telefone2=? where id=? ";
        stmt = conn.prepareStatement(sql);

        stmt.setString(1, fe.getNome());
        stmt.setString(2, fe.getTipoDePessoa());
        stmt.setString(3, fe.getFantasia());
        stmt.setString(4, fe.getCnpjOuCpf());
        stmt.setString(5, fe.getRg());
        stmt.setString(6, fe.getIndicadorDaIE());
        stmt.setString(7, fe.getCep());
        stmt.setString(8, fe.getNumero());
        stmt.setString(9, fe.getEndereco());
        stmt.setString(10, fe.getComplemento());
        stmt.setString(11, fe.getCidade());
        stmt.setString(12, fe.getBairro());
        stmt.setString(13, fe.getEstado());
        stmt.setString(14, fe.getPais());
        stmt.setString(15, fe.getTelefone1());
        stmt.setString(16, fe.getTelefone2());

        stmt.setInt(17, fe.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    public void remove(FornecedorEntity ce) throws SQLException {
        conectar();
        String sql = "delete from tb_fornecedores where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, ce.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<FornecedorEntity> selecionaFornecedor(FornecedorEntity fe) {
        List<FornecedorEntity> minhaLista = new ArrayList<>();
        try {
            conectar();
            String sql = "select * from tb_fornecedores where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, fe.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                fe.setId(Integer.valueOf(rs.getString("id")));
                fe.setNome(rs.getString("nome"));
                fe.setTipoDePessoa(rs.getString("tipo"));
                fe.setFantasia(rs.getString("fantasia"));
                fe.setCnpjOuCpf(rs.getString("cnpjCPF"));
                fe.setRg(rs.getString("rg"));
                fe.setIndicadorDaIE(rs.getString("indicadorDaIE"));
                fe.setCep(rs.getString("cep"));
                fe.setNumero(rs.getString("numero"));
                fe.setEndereco(rs.getString("endereco"));
                fe.setComplemento(rs.getString("complemento"));
                fe.setCidade(rs.getString("cidade"));
                fe.setBairro(rs.getString("bairro"));
                fe.setEstado(rs.getString("estado"));
                fe.setPais(rs.getString("pais"));
                fe.setTelefone1(rs.getString("telefone1"));
                fe.setTelefone2(rs.getString("telefone2"));
                minhaLista.add(fe);
            }
            stmt.close();
        } catch (Exception r) {
            r.printStackTrace();
        }
        return minhaLista;
    }

    public List<String> nomesFornecedor() throws SQLException {
        List<String> minhaLista = new ArrayList<>();
        conectar();
        String sql = "select nome from tb_fornecedores order by nome";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            minhaLista.add(rs.getString("nome"));
        }
        stmt.close();

        return minhaLista;
    }

}
