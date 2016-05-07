package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.BatePontoEntity2;
import com.br.tecnomais.entity.UsuarioEntity;
import java.sql.SQLException;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class BatePontoDAO2 extends ConectaBanco {

    public void alteraPonto(BatePontoEntity2 bpe, String data) throws SQLException {
        conectar();
        String sql = "update tb_pontos set entradaManha=?, saidaManha=?, entradaTarde=?, saidaTarde=?, "
                + "entradaNoite=?, saidaNoite=?, entradaExtra=?, saidaExtra=?, totalManha=?, totalTarde=?, "
                + "totalNoite=?, totalExtra=?, totalHoras=? where idFuncionario=? and data=?";

        stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, bpe.getEntradaManha());
        stmt.setDouble(2, bpe.getSaidaManha());
        stmt.setDouble(3, bpe.getEntradaTarde());
        stmt.setDouble(4, bpe.getSaidaTarde());
        stmt.setDouble(5, bpe.getEntradaNoite());
        stmt.setDouble(6, bpe.getSaidaNoite());
        stmt.setDouble(7, bpe.getEntradaExtra());
        stmt.setDouble(8, bpe.getSaidaExtra());
        stmt.setDouble(9, bpe.getTotalManha());
        stmt.setDouble(10, bpe.getTotalTarde());
        stmt.setDouble(11, bpe.getTotalNoite());
        stmt.setDouble(12, bpe.getTotalExtra());
        stmt.setDouble(13, bpe.getTotalHoras());

        stmt.setInt(14, bpe.getIdFunc());
        stmt.setString(15, data);

        stmt.executeUpdate();
        stmt.close();

    }

    public void salvarPonto(BatePontoEntity2 bpe) throws SQLException {

        conectar();
        String sql = "insert into tb_pontos(entradaManha, saidaManha, entradaTarde, saidaTarde, entradaNoite"
                + ", saidaNoite, entradaExtra, saidaExtra, totalManha, totalTarde, totalNoite, totalExtra, "
                + "totalHoras, data, idFuncionario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);

        stmt.setDouble(1, bpe.getEntradaManha());
        stmt.setDouble(2, bpe.getSaidaManha());
        stmt.setDouble(3, bpe.getEntradaTarde());
        stmt.setDouble(4, bpe.getSaidaTarde());
        stmt.setDouble(5, bpe.getEntradaNoite());
        stmt.setDouble(6, bpe.getSaidaNoite());
        stmt.setDouble(7, bpe.getEntradaExtra());
        stmt.setDouble(8, bpe.getSaidaExtra());
        stmt.setDouble(9, bpe.getTotalManha());
        stmt.setDouble(10, bpe.getTotalTarde());
        stmt.setDouble(11, bpe.getTotalNoite());
        stmt.setDouble(12, bpe.getTotalExtra());
        stmt.setDouble(13, bpe.getTotalHoras());

        stmt.setString(14, bpe.getData());
        stmt.setInt(15, bpe.getIdFunc());

        stmt.executeUpdate();
        stmt.close();

    }

    public String selecionaFuncionario(int id) {

        UsuarioEntity u = new UsuarioEntity();
        try {
            conectar();
            String sql = "select id,nome_usuario from tb_usuarios where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNome_usuario(rs.getString("nome_usuario"));
            }
            rs.close();
            stmt.close();
        } catch (Exception r) {
            r.printStackTrace();
        }

        return u.getNome_usuario();

    }

    public BatePontoEntity2 pesquisaPonto(Integer id, String data) throws SQLException {

        BatePontoEntity2 bpe = new BatePontoEntity2();
        try {
            conectar();
            String sql = "select * from tb_pontos where idFuncionario = ? and data=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, data);
            rs = stmt.executeQuery();
            while (rs.next()) {
                bpe.setIdFunc(rs.getInt("idFuncionario"));
                bpe.setEntradaManha(rs.getDouble("entradaManha"));
                bpe.setSaidaManha(rs.getDouble("saidaManha"));
                bpe.setEntradaTarde(rs.getDouble("entradaTarde"));
                bpe.setSaidaTarde(rs.getDouble("saidaTarde"));
                bpe.setEntradaNoite(rs.getDouble("entradaNoite"));
                bpe.setSaidaNoite(rs.getDouble("saidaNoite"));
                bpe.setEntradaExtra(rs.getDouble("entradaExtra"));
                bpe.setSaidaExtra(rs.getDouble("saidaExtra"));
                
                bpe.setData(rs.getString("data"));
                
                bpe.setTotalManha(rs.getDouble("totalManha"));
                bpe.setTotalTarde(rs.getDouble("totalTarde"));
                bpe.setTotalNoite(rs.getDouble("totalNoite"));
                bpe.setTotalExtra(rs.getDouble("totalExtra"));
                bpe.setTotalHoras(rs.getDouble("totalHoras"));
            }
            rs.close();
            stmt.close();
        } catch (Exception r) {
            r.printStackTrace();
        }

        return bpe;

    }

    public boolean verificaPontoExistente(Integer id, String data) throws SQLException {
        BatePontoEntity2 bpe = new BatePontoEntity2();

        conectar();
        String sql = "select id from tb_pontos where idFuncionario = ? and data=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, data);
        rs = stmt.executeQuery();
        if (rs.next()) {
            System.out.println("retornou falso");
            return false;
        }
        rs.close();
        stmt.close();
        return true;
    }

    public boolean verificaSenha(String senha, Integer id) throws SQLException {
        boolean resp = false;
        conectar();
        UsuarioEntity ue = new UsuarioEntity();
        String sql = "select senha from tb_usuarios where id=? and senha=? ";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, senha);
        rs = stmt.executeQuery();

        while (rs.next()) {
            resp = true;
        }
        stmt.close();
        return resp;

    }

}
