
package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.FilialEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class FilialDAO extends ConectaBanco {

    String sql;
    FilialEntity fe = new FilialEntity();

    public void salvar(FilialEntity fe) throws SQLException {
        conectar();
        sql = "insert into tb_filiais (nome, razaoSocial, cep, telefone, fax, numero, complemento, bairro,"
                + "cidade, estado, cnpj, indicadorDaIE, inscricaoEstadual, inscricaoMunicipal, inscricaoSuframa)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, fe.getNome());
        stmt.setString(2, fe.getRazaoSocial());
        stmt.setString(3, fe.getCep());
        stmt.setString(4, fe.getTelefone());
        stmt.setString(5, fe.getFax());
        stmt.setString(6, fe.getNumero());
        stmt.setString(7, fe.getComplemento());
        stmt.setString(8, fe.getBairro());
        stmt.setString(9, fe.getCidade());
        stmt.setString(10, fe.getEstado());
        stmt.setString(11, fe.getCnpj());
        stmt.setString(12, fe.getIndicadorDaIE());
        stmt.setString(13, fe.getInscricaoEstadual());
        stmt.setString(14, fe.getInscricaoMunicipal());
        stmt.setString(15, fe.getInscricaoSuframa());

        stmt.executeUpdate();
        stmt.close();

    }

    public void alterar(FilialEntity fe) throws SQLException {
        conectar();
        sql = "update tb_filiais set nome=?, razaoSocial=?, cep=?, telefone=?, fax=?, numero=?, complemento=?, bairro=?,"
                + "cidade=?, estado=?, cnpj=?, indicadorDaIE=?, inscricaoEstadual=?, inscricaoMunicipal=?, inscricaoSuframa=? where id=?";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, fe.getNome());
        stmt.setString(2, fe.getRazaoSocial());
        stmt.setString(3, fe.getCep());
        stmt.setString(4, fe.getTelefone());
        stmt.setString(5, fe.getFax());
        stmt.setString(6, fe.getNumero());
        stmt.setString(7, fe.getComplemento());
        stmt.setString(8, fe.getBairro());
        stmt.setString(9, fe.getCidade());
        stmt.setString(10, fe.getEstado());
        stmt.setString(11, fe.getCnpj());
        stmt.setString(12, fe.getIndicadorDaIE());
        stmt.setString(13, fe.getInscricaoEstadual());
        stmt.setString(14, fe.getInscricaoMunicipal());
        stmt.setString(15, fe.getInscricaoSuframa());

        stmt.setInt(16, fe.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    public List<FilialEntity> listar(String nome) throws SQLException {
        conectar();
        sql = "select * from tb_filiais where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        List<FilialEntity> minhaLista = new ArrayList<>();

        while (rs.next()) {

            FilialEntity fe = new FilialEntity();
            fe.setId(rs.getInt("id"));
            fe.setNome(rs.getString("nome"));
            fe.setRazaoSocial(rs.getString("razaoSocial"));
            fe.setCep(rs.getString("cep"));
            fe.setTelefone(rs.getString("telefone"));
            fe.setFax(rs.getString("fax"));
            fe.setNumero(rs.getString("numero"));
            fe.setComplemento(rs.getString("complemento"));
            fe.setBairro(rs.getString("bairro"));
            fe.setCidade(rs.getString("cidade"));
            fe.setEstado(rs.getString("estado"));
            fe.setCnpj(rs.getString("cnpj"));
            fe.setIndicadorDaIE(rs.getString("indicadorDaIE"));
            fe.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
            fe.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
            fe.setInscricaoSuframa(rs.getString("inscricaoSuframa"));

            minhaLista.add(fe);
        }
        rs.close();
        stmt.close();
        return minhaLista;

    }

    public void remover(Integer id) throws SQLException {
        sql = "delete tb_filiais where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<FilialEntity> selecionaFilial(FilialEntity fe) {
        List<FilialEntity> minhaLista = new ArrayList<>();
        try {
            conectar();
            String sql = "select * from tb_filiais where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, fe.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                fe.setId(rs.getInt("id"));
                fe.setNome(rs.getString("nome"));
                fe.setRazaoSocial(rs.getString("razaoSocial"));
                fe.setCep(rs.getString("cep"));
                fe.setTelefone(rs.getString("telefone"));
                fe.setFax(rs.getString("fax"));
                fe.setNumero(rs.getString("numero"));
                fe.setComplemento(rs.getString("complemento"));
                fe.setBairro(rs.getString("bairro"));
                fe.setCidade(rs.getString("cidade"));
                fe.setEstado(rs.getString("estado"));
                fe.setCnpj(rs.getString("cnpj"));
                fe.setIndicadorDaIE(rs.getString("indicadorDaIE"));
                fe.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
                fe.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
                fe.setInscricaoSuframa(rs.getString("inscricaoSuframa"));
                minhaLista.add(fe);
            }
            stmt.close();
        } catch (Exception r) {
            r.printStackTrace();
        }
        return minhaLista;
    }
    
    public boolean verificaFilila(int id) throws Exception {
        boolean status = false;
        conectar();
        String sql = "SELECT * FROM tb_filiais WHERE id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        while(rs.next()) {
            fe.setNome(rs.getString("nome"));
            status = true;
        }
        return status;
    }
    
    public FilialEntity retornFilial(){
        return this.fe;
    }

}
