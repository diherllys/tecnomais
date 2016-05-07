package com.br.tecnomais.dao;

import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ClasseProdutoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class ClasseDAO extends ConectaBanco {

    public void cadastrarClasse(ClasseProdutoEntity classe) {
        try {
            conectar();
            String sql = "insert into tb_classes (nome) values (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, classe.getNomeClasse());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ClasseProdutoEntity> listaClassesProdutos(ClasseProdutoEntity cls) {
        List<ClasseProdutoEntity> lista = new ArrayList<>();
        try {
            conectar();
            String sql = "select * from tb_classes where nome like ? order by nome";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cls.getNomeClasse());
            rs = stmt.executeQuery();
            while (rs.next()) {
                ClasseProdutoEntity clas = new ClasseProdutoEntity();
                clas.setCodigo(rs.getInt("id"));
                clas.setNomeClasse(rs.getString("nome"));
                lista.add(clas);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizarClasse(ClasseProdutoEntity cls) {
        try {
            conectar();
            String sql = "update tb_classes set nome = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cls.getNomeClasse());
            stmt.setInt(2, cls.getCodigo());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirClasse(ClasseProdutoEntity cls) {
        try {
            conectar();
            String sql = "delete from tb_classes where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cls.getCodigo());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
