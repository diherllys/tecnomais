package com.br.tecnomais.dao;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.ProdutoEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@author Diherllys LL, Reginaldo Cândido
public class ProdutoDAO extends ConectaBanco {

    public void adicionar(ProdutoEntity pe) throws SQLException {
        conectar();
        String sql = "insert into tb_produtos(nome , codigoDeBarras, tipo, classe, textoDeSaida, precoDeCusto,"
                + " precoDeVenda, porcentagem, qntAtual, estqCritico, unidadeDeVenda, foto, codigoProduto) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, pe.getNome());
        stmt.setString(2, pe.getCodigoDeBarras());
        stmt.setString(3, pe.getTipo());
        stmt.setString(4, pe.getClasse());
        stmt.setString(5, pe.getTextoDeSaida());
        stmt.setDouble(6, pe.getPrecoDeCusto());
        stmt.setDouble(7, pe.getPrecoDeVenda());
        stmt.setDouble(8, pe.getPorcentagem());
        stmt.setDouble(9, pe.getQntAtual());
        stmt.setDouble(10, pe.getEstqCritico());
        stmt.setString(11, pe.getUnidadeDeVenda());
        stmt.setString(12, pe.getFoto());
        stmt.setInt(13, pe.getCodigoProduto());

        stmt.executeUpdate();
        stmt.close();

    }

    public List<ProdutoEntity> listar(String nome) throws SQLException, Exception {
        conectar();
        String sql = "select * from tb_produtos where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
//        ValidarCamposNumericos vcn = new ValidarCamposNumericos();
//        nome = vcn.removerCaracteres(nome);
//        stmt.setInt(2, Integer.parseInt("%"+nome+"%"));
        rs = stmt.executeQuery();

        List<ProdutoEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            minhaLista.add(getDadosProdutos());
        }
        rs.close();
        stmt.close();

        return minhaLista;

    }

    public List<ProdutoEntity> listar2(String nome) throws SQLException, Exception {
        conectar();
        String sql = "select * from tb_produtos where nome like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
//        ValidarCamposNumericos vcn = new ValidarCamposNumericos();
//        nome = vcn.removerCaracteres(nome);
//        stmt.setInt(2, Integer.parseInt("%"+nome+"%"));
        rs = stmt.executeQuery();

        List<ProdutoEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            minhaLista.add(getDadosProdutos());
        }
        rs.close();
        stmt.close();

        return minhaLista;

    }

    public void altera(ProdutoEntity pe) throws SQLException {
        conectar();
        String sql = "update tb_produtos set nome=? , codigoDeBarras=?, tipo=?, classe=?, textoDeSaida=?,"
                + " precoDeCusto=?, precoDeVenda=?, porcentagem = ?, qntAtual = ?, estqCritico = ?, unidadeDeVenda = ?, foto = ? , codigoProduto=? where id = ? ";
        stmt = conn.prepareStatement(sql);

        stmt.setString(1, pe.getNome());
        stmt.setString(2, pe.getCodigoDeBarras());
        stmt.setString(3, pe.getTipo());
        stmt.setString(4, pe.getClasse());
        stmt.setString(5, pe.getTextoDeSaida());
        stmt.setDouble(6, pe.getPrecoDeCusto());
        stmt.setDouble(7, pe.getPrecoDeVenda());
        stmt.setDouble(8, pe.getPorcentagem());
        stmt.setDouble(9, pe.getQntAtual());
        stmt.setDouble(10, pe.getEstqCritico());
        stmt.setString(11, pe.getUnidadeDeVenda());
        stmt.setString(12, pe.getFoto());
        stmt.setInt(13, pe.getCodigoProduto());

        stmt.setInt(14, pe.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    public void remove(ProdutoEntity pe) throws SQLException {
        conectar();
        String sql = "delete from tb_produtos where id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, pe.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<ProdutoEntity> selecionaProduto(int codigo) {
        List<ProdutoEntity> minhaLista = new ArrayList<>();
        try {
            conectar();
            //String sql = "select * from tb_produtos where id = ?";
            String sql = "select * from tb_produtos where codigoProduto = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                minhaLista.add(getDadosProdutos());
            }
            stmt.close();
            rs.close();
        } catch (Exception r) {
            r.printStackTrace();
        }
        return minhaLista;
    }

    public List<ProdutoEntity> pesquisarProdutoFromCodigoBarrasOrId(String codigoBarras) throws SQLException, Exception {
        conectar();
        String sql = "";
        Integer tamCodigo = codigoBarras.length();
        System.out.println(tamCodigo);
        if (tamCodigo > 8) {
            sql = "select * from tb_produtos where codigoDeBarras = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigoBarras);
        } else {
//            sql = "select * from tb_produtos where id = ?";
            sql = "select * from tb_produtos where codigoProduto = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigoBarras);
        }

        rs = stmt.executeQuery();

        List<ProdutoEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            minhaLista.add(getDadosProdutos());
        }
        rs.close();
        stmt.close();

        if (minhaLista.size() == 0) {
            new Alertas().mensagemErro("Desculpe, produto não encontrado! Verifique se o produto foi selecionado corretamente!");
        }

        return minhaLista;

    }

    public ProdutoEntity pesquisaProdutoQuantPorId(Integer codigoBarras) throws SQLException, Exception {
        conectar();
//     String sql = "select * from tb_produtos where id = ?";
        String sql = "select * from tb_produtos where codigoProduto = ?";
        stmt = conn.prepareStatement(sql);
        System.out.println("Codigo barras " + codigoBarras);
        stmt.setInt(1, codigoBarras);
        rs = stmt.executeQuery();

        ProdutoEntity prt = new ProdutoEntity();
        while (rs.next()) {
            prt = getDadosProdutos();
        }
        rs.close();
        stmt.close();

        if (prt.getId() == null || prt.getId().equals("")) {
            new Alertas().mensagemErro("Desculpe, produto não encontrado! Verifique se o produto foi selecionado corretamente!");
        }
        return prt;
    }

    public void atualizarEstoqueProdutos(ProdutoEntity p) throws Exception {
        conectar();
        String sql = "UPDATE tb_produtos SET qntAtual = qntAtual + ? WHERE id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, p.getQntAtual());
        stmt.setInt(2, p.getId());
        stmt.executeUpdate();
    }

    private ProdutoEntity getDadosProdutos() throws Exception {
        ProdutoEntity pe = new ProdutoEntity();
        pe.setId(null);
        pe.setId(rs.getInt("id"));
        pe.setNome(rs.getString("nome"));
        pe.setCodigoDeBarras(rs.getString("codigoDeBarras"));
        pe.setTipo(rs.getString("tipo"));
        pe.setClasse(rs.getString("classe"));
        pe.setTextoDeSaida(rs.getString("textoDeSaida"));
        pe.setPrecoDeCusto(rs.getDouble("precoDeCusto") / 100);
        pe.setPrecoDeVenda(rs.getDouble("precoDeVenda") / 100);
        pe.setPorcentagem(rs.getDouble("porcentagem"));
        pe.setQntAtual(rs.getDouble("qntAtual"));
        pe.setEstqCritico(rs.getDouble("estqCritico"));
        pe.setUnidadeDeVenda(rs.getString("unidadeDeVenda"));
        pe.setFoto(rs.getString("foto"));
        pe.setCodigoProduto(rs.getInt("codigoProduto"));
        return pe;
    }

    public Integer retornaNovoCodigo() throws Exception {
        conectar();
        String sql = "select top 1 codigoProduto from tb_produtos order by codigoProduto desc";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("codigoProduto") + 1;
        } else {
            return null;
        }
    }

    public boolean verificaCodigoExistente(int codigoProduto) throws Exception {
        conectar();
        String sql = "select * from tb_produtos where codigoProduto = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoProduto);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public Integer retornaUltimoId() throws SQLException {
        conectar();
        String sql = "select codigoProduto from tb_produtos order by codigoProduto";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        int ultimoId = 0;
        while(rs.next()){
            ultimoId = rs.getInt("codigoProduto");
        }
        return ultimoId;
    }
}
