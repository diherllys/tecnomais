package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.CaixaEntity;
import com.br.tecnomais.entity.UsuarioEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class UsuarioDAO extends ConectaBanco {

    public boolean logarSistema(UsuarioEntity u) {
        boolean logar = false;
        try {
            conectar();
            String sql = "SELECT * FROM tb_usuarios WHERE usuario = ? and senha = ? OR id = ? AND senha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, Integer.valueOf(u.getUsuario()));
            stmt.setString(4, u.getSenha());
            rs = stmt.executeQuery();

            if (rs.next()) {
                logar = true;
                u.setId(rs.getInt("id"));
                u.setNome_usuario(rs.getString("nome_usuario"));
                u.setNivel(rs.getInt("nivel"));
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logar;
    }

    public boolean verificaUsuario(String nome) throws SQLException {
        conectar();
        String sql = "SELECT * FROM tb_usuarios where nome_usuario=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println("entrou");
            return true; 
        }
        return false;
    }

    public void adicionar(UsuarioEntity ue) throws SQLException {
        conectar();
        String sql = "INSERT INTO tb_usuarios (nome_usuario,usuario,senha,nivel,data_nasc,foto) VALUES(?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, ue.getNome_usuario());
        stmt.setString(2, ue.getUsuario());
        stmt.setString(3, ue.getSenha());
        stmt.setInt(4, ue.getNivel());
        stmt.setString(5, ue.getDataNasc());
        stmt.setString(6, ue.getFoto());

        stmt.executeUpdate();
        stmt.close();

    }

    public List<UsuarioEntity> listar(String nome) throws SQLException {
        conectar();
        String sql = "SELECT * FROM tb_usuarios WHERE nome_usuario LIKE ? and nivel =1";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        List<UsuarioEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(Integer.valueOf(rs.getString("id")));
            usuario.setNome_usuario(rs.getString("nome_usuario"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setNivel(Integer.valueOf(rs.getString("nivel")));
            usuario.setFoto(rs.getString("foto"));
            usuario.setDataNasc(rs.getString("data_nasc"));
            minhaLista.add(usuario);

        }
        rs.close();
        stmt.close();

        return minhaLista;

    }

    public void altera(UsuarioEntity ue) throws SQLException {
        conectar();
        String sql = "UPDATE tb_usuarios SET nome_usuario=?, usuario=?, senha=?, nivel=?, foto=?,"
                + "data_nasc=? WHERE id = ? ";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, ue.getNome_usuario());
        stmt.setString(2, ue.getUsuario());
        stmt.setString(3, ue.getSenha());
        stmt.setInt(4, ue.getNivel());
        stmt.setString(5, ue.getFoto());
        stmt.setString(6, ue.getDataNasc());

        stmt.setInt(7, ue.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    public void remove(UsuarioEntity ue) throws SQLException {
        conectar();
        String sql = "DELETE FROM tb_usuarios WHERE id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, ue.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<UsuarioEntity> selecionaUsuario(UsuarioEntity ue) {
        List<UsuarioEntity> lista = new ArrayList<>();
        try {
            conectar();
            String sql = "SELECT * FROM tb_usuarios WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ue.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioEntity u = new UsuarioEntity();
                u.setId(rs.getInt("id"));
                u.setNome_usuario(rs.getString("nome_usuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                u.setNivel(rs.getInt("nivel"));
                u.setDataNasc(rs.getString("data_nasc"));
                u.setFoto(rs.getString("foto"));
                lista.add(u);
            }
            stmt.close();
        } catch (Exception r) {
            r.printStackTrace();
        }
        return lista;
    }

    public List<UsuarioEntity> listarUsuarioPorLogin(UsuarioEntity us) throws SQLException {
        conectar();

        String sql = "SELECT * FROM tb_usuarios WHERE usuario LIKE ? OR id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, us.getUsuario());
        stmt.setInt(2, us.getId());
        rs = stmt.executeQuery();

        List<UsuarioEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(Integer.valueOf(rs.getString("id")));
            usuario.setNome_usuario(rs.getString("nome_usuario"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setSenha(rs.getString("senha"));
            //usuario.setNivel(Integer.valueOf(rs.getString("nivel")));
            usuario.setFoto(rs.getString("foto"));
            usuario.setDataNasc(rs.getString("data_nasc"));
            minhaLista.add(usuario);
        }
        rs.close();
        stmt.close();

        return minhaLista;

    }

    public int usuarioID(String nome) throws SQLException {
        conectar();
        int id = 0;
        String sql = "select * from tb_usuarios where nome_usuario=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        CaixaEntity ce = new CaixaEntity();
        while (rs.next()) {
            id = rs.getInt("id");
        }
        rs.close();
        stmt.close();
        return id;
    }

}
