package com.br.tecnomais.dao;

import com.br.tecnomais.classes.ValidarCamposNumericos;
import com.br.tecnomais.db.ConectaBanco;
import com.br.tecnomais.entity.EntradaFinanceiroEntity;
import com.br.tecnomais.entity.EntradasEntity;
import com.br.tecnomais.entity.InicializaEntradaEntity;
import com.br.tecnomais.entity.ProdutosEntradaEntity;
import com.br.tecnomais.vmovimentacao.FinalizaFinanceiroEntrada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class EntradaDAO extends ConectaBanco {

    public void gravarEntrada(EntradasEntity e) throws SQLException {
        conectar();
        String sql = "insert into tb_entradas (fornecedor, caixa, operacao, vlrTotal, dataEntrada, status) values(?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, e.getFornecedor());
        stmt.setString(2, e.getCaixa());
        stmt.setString(3, e.getOperacao());
        stmt.setDouble(4, e.getVlrTotal());
        stmt.setString(5, e.getDataEntrada());
        stmt.setString(6, e.getStatus());
        stmt.executeUpdate();
        stmt.close();
    }

    public int caixaId(String nome) throws SQLException {
        conectar();
        int id = 0;
        String sql = "select * from tb_caixas where nome=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        while (rs.next()) {
            id = rs.getInt("id");
        }
        rs.close();
        stmt.close();
        return id;
    }

    public int forncedorId(String nome) throws SQLException {
        conectar();
        int id = 0;
        String sql = "select * from tb_fornecedores where nome=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        while (rs.next()) {
            id = rs.getInt("id");
        }
        rs.close();
        stmt.close();
        return id;
    }

    public List<ProdutosEntradaEntity> listaProdutosEntradaPorSequencia(int codigoEntrada) throws Exception {
        List<ProdutosEntradaEntity> lista = new ArrayList<>();
        conectar();
        String sql = "SELECT * FROM tb_produtos AS p INNER JOIN tb_produtosEntrada AS pv ON pv.codigoEntrada = ? AND p.id = pv.codigoProduto";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoEntrada);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ProdutosEntradaEntity prod = new ProdutosEntradaEntity();
            prod.setId(rs.getInt("codigoProduto"));
            prod.setQuantidade(rs.getDouble("quantidade"));
            prod.setPrecoUnitario(rs.getDouble("precoUnit"));
            prod.setProdutoServico(rs.getString("descricao"));
            prod.setPrecoTotal(rs.getDouble("precoTotal"));
            prod.setClasse(rs.getString("classe"));
            prod.setDescontoPorcentagem(rs.getDouble("descontoPor"));
            prod.setDescontoReal(rs.getDouble("descontoReal"));
            prod.setPrecoFinal(rs.getDouble("precoFinal"));
            prod.setCodigoDinamico(rs.getInt("codigoProdutoDinamico"));
            prod.setCodigoProduto(rs.getInt("codigoProdutoDinamico"));
            lista.add(prod);
        }
        return lista;
    }

    public List<EntradasEntity> listarSequencia(String codigoEntrada, String dtInicial, String dtFinal) throws Exception {
        List<EntradasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "";
        if (dtInicial.contains("/")) {
            sql = "SELECT * FROM tb_entradas where convert(datetime, dataEntrada, 103) BETWEEN convert(datetime, ?, 103) AND convert(datetime, ?, 103) ";//ORDER BY codigoEntrada desc
        } else {
            sql = "SELECT * FROM tb_entradas where fornecedor like ? or codigoEntrada =?";
        }
        stmt = conn.prepareStatement(sql);
        ValidarCamposNumericos vcn = new ValidarCamposNumericos();
        String aux = vcn.removerCaracteres(codigoEntrada.toLowerCase());
        if (aux.equals("")) {
            aux = "0";
        }
        Integer sequencia = Integer.parseInt(aux);
        if (sequencia == 0 || sequencia == null) {
            sequencia = 0;
        }

        if (dtInicial.contains("/")) {
            stmt.setString(1, dtInicial);
            stmt.setString(2, dtFinal);
        } else {
            stmt.setString(1, "%" + codigoEntrada + "%");
            stmt.setInt(2, sequencia);
        }
        rs = stmt.executeQuery();
        while (rs.next()) {
            EntradasEntity entrada = new EntradasEntity();
            entrada.setCaixa(rs.getString("caixa"));
            entrada.setCodigoEntrada(rs.getInt("codigoEntrada"));
            entrada.setDataEntrada(rs.getString("dataEntrada"));
            entrada.setFornecedor(rs.getString("fornecedor"));
            entrada.setOperacao(rs.getString("operacao"));
            entrada.setStatus(rs.getString("status"));
            entrada.setVlrTotal(rs.getDouble("vlrTotal"));
            lista.add(entrada);
        }
        return lista;
    }

    public List<ProdutosEntradaEntity> retornaPrtEntradas(Integer sequencia) throws SQLException {
        conectar();
        String sql = "select * from tb_produtosEntrada where codigoEntrada = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, sequencia);
        rs = stmt.executeQuery();
        List<ProdutosEntradaEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            ProdutosEntradaEntity pee = new ProdutosEntradaEntity();
            pee.setClasse(rs.getString("classe"));
            pee.setId(rs.getInt("codigoProduto"));
            pee.setDescontoPorcentagem(rs.getDouble("descontoPor"));
            pee.setDescontoReal(rs.getDouble("descontoReal"));
            pee.setId(rs.getInt("id"));
            pee.setPrecoFinal(rs.getDouble("precoFinal"));
            pee.setPrecoTotal(rs.getDouble("precoTotal"));
            pee.setPrecoUnitario(rs.getDouble("precoUnit"));
            pee.setProdutoServico(rs.getString("descricao"));
            pee.setQuantidade(rs.getDouble("quantidade"));
            pee.setCodigoDinamico(rs.getInt("codigoProdutoDinamico"));
            pee.setCodigoProduto(rs.getInt("codigoProdutoDinamico"));
            minhaLista.add(pee);
        }

        return minhaLista;
    }

    public List<EntradasEntity> retornaEntrada(String string) throws SQLException {
        conectar();
        String sql = "select * from tb_entradas where codigoEntrada = ? or fornecedor like ? or caixa like ? or operacao like ? or status like ?";

        stmt = conn.prepareStatement(sql);
        ValidarCamposNumericos vcn = new ValidarCamposNumericos();
        String aux = vcn.removerCaracteres(string.toLowerCase());
        if (aux.equals("")) {
            aux = "0";
        }
        Integer seq = Integer.parseInt(aux);
        if (seq == 0 || seq == null) {
            seq = 0;
        }
        stmt.setInt(1, seq);
        string = "%" + string + "%";
        stmt.setString(2, string);
        stmt.setString(3, string);
        stmt.setString(4, string);
        stmt.setString(5, string);
        rs = stmt.executeQuery();
        List<EntradasEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            EntradasEntity ee = new EntradasEntity();
            ee.setCodigoEntrada(rs.getInt("codigoEntrada"));
            ee.setCaixa(rs.getString("caixa"));
            ee.setDataEntrada(rs.getString("dataEntrada"));
            ee.setFornecedor(rs.getString("fornecedor"));
            ee.setOperacao(rs.getString("operacao"));
            ee.setStatus(rs.getString("status"));
            ee.setVlrTotal(rs.getDouble("vlrTotal"));
            minhaLista.add(ee);
        }

        return minhaLista;
    }

    public void updateEntrada(EntradasEntity ee) {
        try {
            conectar();
            String sql = "update tb_entrada set vlrTotal=?";
            stmt.setDouble(1, ee.getVlrTotal());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean estoqueFoiEfetivado(int seq) throws SQLException {
        conectar();
        String sql = "select * from tb_produtosEntrada where codigoEntrada=? AND status=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, seq);
        stmt.setString(2, "FINALIZADO");
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public boolean financeiroFoiEfetivado(int seq) throws SQLException {
        conectar();
        String sql = "select * from tb_entradas where codigoEntrada=? AND statusFinac=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, seq);
        stmt.setString(2, "FINALIZADO");
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public void atualizaStatusFinanceiro(int seq, String status) throws SQLException {
        conectar();
        String sql = "update tb_entradas set statusFinac=? where codigoEntrada=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, status);
        stmt.setInt(2, seq);
        stmt.executeUpdate();
        stmt.close();

    }

    public EntradasEntity retornaEntrada(Integer sequencia) throws SQLException {
        conectar();
        String sql = "select * from tb_entradas where codigoEntrada =?";
        EntradasEntity ee = new EntradasEntity();
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, sequencia);
        rs = stmt.executeQuery();
        ee.setCodigoEntrada(0);
        while (rs.next()) {
            ee.setCodigoEntrada(rs.getInt("codigoEntrada"));
            ee.setCaixa(rs.getString("caixa"));
            ee.setDataEntrada(rs.getString("dataEntrada"));
            ee.setFornecedor(rs.getString("fornecedor"));
            ee.setOperacao(rs.getString("operacao"));
            ee.setStatus(rs.getString("status"));
            ee.setVlrTotal(rs.getDouble("vlrTotal"));
        }
        return ee;
    }

    public List<EntradasEntity> retornaEntradaPorData(String dataInicial, String dataFinal) throws SQLException {
        conectar();
        String sql = "select * from tb_entradas where convert(datetime, dataEntrada, 103) BETWEEN convert(datetime, ?, 103) AND convert(datetime, ?, 103)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataInicial);
        stmt.setString(2, dataFinal);
        rs = stmt.executeQuery();
        List<EntradasEntity> minhaLista = new ArrayList<>();
        while (rs.next()) {
            EntradasEntity ee = new EntradasEntity();
            ee.setCodigoEntrada(rs.getInt("codigoEntrada"));
            ee.setCaixa(rs.getString("caixa"));
            ee.setDataEntrada(rs.getString("dataEntrada"));
            ee.setFornecedor(rs.getString("fornecedor"));
            ee.setOperacao(rs.getString("operacao"));
            ee.setStatus(rs.getString("status"));
            ee.setVlrTotal(rs.getDouble("vlrTotal"));
            minhaLista.add(ee);
        }
        return minhaLista;
    }

    public int retornaCodigoEntrada() throws Exception {
        conectar();
        int codigoEntrada = 0;
        String sql = "select top 1 codigoEntrada from tb_entradas order by codigoEntrada desc";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            codigoEntrada = rs.getInt("codigoEntrada");
        }
        System.out.println("O codigo é: " + codigoEntrada);
        return codigoEntrada;
    }

    public void lancarProdutosEntrada(ProdutosEntradaEntity p, Integer codigoEntrada) throws Exception {
        conectar();
//        int codigoEntrada = retornaCodigoEntrada();
        String sql = "insert into tb_produtosEntrada (codigoEntrada, codigoProduto, descricao, classe, quantidade, precoUnit, precoTotal, descontoPor, descontoReal, precoFinal, status, codigoProdutoDinamico) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoEntrada);
        stmt.setInt(2, p.getId());
        stmt.setString(3, p.getProdutoServico());
        stmt.setString(4, p.getClasse());
        stmt.setDouble(5, p.getQuantidade());
        stmt.setDouble(6, p.getPrecoUnitario());
        stmt.setDouble(7, p.getPrecoTotal());
        stmt.setDouble(8, p.getDescontoPorcentagem());
        stmt.setDouble(9, p.getDescontoReal());
        stmt.setDouble(10, p.getPrecoFinal());
        stmt.setString(11, "ABERTO");
        stmt.setInt(12, p.getCodigoDinamico());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<ProdutosEntradaEntity> listar(String nome) throws SQLException {
        conectar();
        String sql = "select * from tb_entradas where produtoServico like ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        ProdutosEntradaEntity ee = new ProdutosEntradaEntity();
        List<ProdutosEntradaEntity> minhaList = new ArrayList<>();

        while (rs.next()) {
            ee.setProdutoServico(rs.getString("produtoServico"));
            ee.setQuantidade(rs.getDouble("quantidade"));
            ee.setPrecoUnitario(rs.getDouble("precoUnitario"));
            ee.setPrecoTotal(rs.getDouble("precoTotal"));
            ee.setDescontoPorcentagem(rs.getDouble("precoPorcentagem"));
            ee.setDescontoReal(rs.getDouble("descontoReal"));
            ee.setPrecoFinal(rs.getDouble("precoFinal"));
            minhaList.add(ee);
        }

        rs.close();
        stmt.close();

        return minhaList;

    }

    public void remover(ProdutosEntradaEntity ee) throws SQLException {
        conectar();
        String sql = "delete from tb_entradas where id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, ee.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public String selecionaOperacao(Integer codigo) throws SQLException {
        conectar();
        String sql = "select nome from tb_operacoes where codigo=?";
        stmt = conn.prepareCall(sql);
        stmt.setInt(1, codigo);
        rs = stmt.executeQuery();
        rs.next();
        String result = rs.getString("nome");
        return result;
    }

    public String selecionaFornecedor(Integer id) throws SQLException {
        conectar();
        String sql = "select nome from tb_fornecedores where id=?";
        stmt = conn.prepareCall(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        String result = " ";
        if (rs.next()) {
            result = rs.getString("nome");
        }
        return result;
    }

    public String selecionaCaixa(Integer numero) throws SQLException {
        conectar();
        String sql = "select nome from tb_caixas where id=?";
        stmt = conn.prepareCall(sql);
        stmt.setInt(1, numero);
        rs = stmt.executeQuery();
        String result = " ";
        if (rs.next()) {
            result = rs.getString("nome");
        }
        return result;
    }

    public List<ProdutosEntradaEntity> listaProdutosEntrada(InicializaEntradaEntity ini) throws Exception {
        List<ProdutosEntradaEntity> lista = new ArrayList<>();
        conectar();
        String sql = "select * from tb_produtosEntrada where codigoEntrada = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, ini.getSequencia());
        rs = stmt.executeQuery();
        while (rs.next()) {
            ProdutosEntradaEntity pr = new ProdutosEntradaEntity();
            pr.setId(rs.getInt("codigoProduto"));
            pr.setProdutoServico(rs.getString("descricao"));
            pr.setClasse(rs.getString("classe"));
            pr.setQuantidade(rs.getDouble("quantidade"));
            pr.setPrecoUnitario(rs.getDouble("precoUnit"));
            pr.setPrecoTotal(rs.getDouble("precoTotal"));
            pr.setDescontoPorcentagem(rs.getDouble("descontoPor"));
            pr.setDescontoReal(rs.getDouble("descontoReal"));
            pr.setPrecoFinal(rs.getDouble("precoFinal"));
            pr.setCodigoDinamico(rs.getInt("codigoProdutoDinamico"));
            pr.setCodigoProduto(rs.getInt("codigoProdutoDinamico"));
            lista.add(pr);
        }
        stmt.close();
        rs.close();
        return lista;
    }

    public List<EntradasEntity> listaFornecedorAndCaixa(InicializaEntradaEntity ini) throws Exception {
        List<EntradasEntity> lista = new ArrayList<>();
        conectar();
        String sql = "select * from tb_entradas where codigoEntrada = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, ini.getSequencia());
        rs = stmt.executeQuery();
        while (rs.next()) {
            EntradasEntity ent = new EntradasEntity();
            ent.setFornecedor(rs.getString("fornecedor"));
            ent.setCaixa(rs.getString("caixa"));
            ent.setOperacao(rs.getString("operacao"));
            lista.add(ent);
        }
        stmt.close();
        rs.close();
        return lista;
    }

    public void adicionaProdutoEstoque(ProdutosEntradaEntity p) throws Exception {
        conectar();
        String sql = "update tb_produtos set qntAtual = qntAtual + ?, precoDeCusto = ?, precoDeVenda = precoDeVenda + (? - precoDeCusto) where id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, p.getQuantidade());
        stmt.setDouble(2, p.getPrecoUnitario());
        stmt.setDouble(3, p.getPrecoUnitario());
        stmt.setInt(4, p.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void detelarProdutoEstoque(Integer id) throws Exception {
        conectar();
        String sql = "delete from tb_produtosEntrada where codigoEntrada = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void atualizaStatusEntrada(int codigoEntrada) throws Exception {
        conectar();
        String sql = "update tb_entradas set status = ? where codigoEntrada = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, "FINALIZADO");
        stmt.setInt(2, codigoEntrada);
        stmt.executeUpdate();
        stmt.close();
    }

    public void atualizaEntrada(EntradasEntity ee) throws Exception {
        conectar();
        String sql = "update tb_entradas set vlrTotal = ?, operacao=?, caixa=?, fornecedor=?, status=?"
                + ", dataEntrada=? where codigoEntrada = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, ee.getVlrTotal());
        stmt.setString(2, ee.getOperacao());
        stmt.setString(3, ee.getCaixa());
        stmt.setString(4, ee.getFornecedor());
        stmt.setString(5, ee.getStatus());
        stmt.setString(6, ee.getDataEntrada());
        stmt.setInt(7, ee.getCodigoEntrada());
        stmt.executeUpdate();
        stmt.close();
    }

    public void atualizaStatusProdutosEntrada(int codigoEntrada) throws Exception {
        conectar();
        String sql = "update tb_produtosEntrada set status = ? where codigoEntrada = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, "FINALIZADO");
        stmt.setInt(2, codigoEntrada);
        stmt.executeUpdate();
        stmt.close();
    }

    public void finalizaFinaceiroEntrada(EntradaFinanceiroEntity efe) {
        try {
            conectar();
            String sql = "insert into tb_entradaFinanceiro (codigoEntrada, intervaloDias"
                    + ", parcelas, caixa, dataEmisao, dataVencimento, descricao, formaDePagamento,"
                    + " formaDePagamento2, formaDePagamento3, fornecedor, hora, operacao, status,"
                    + " usuario, vlrForma1, vlrForma2, vlrForma3, vlrTotal) values(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,"
                    + "? ,? ,? ,? ,? ,? ,? ,? )";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, efe.getEntradaFincId());
            stmt.setInt(2, efe.getIntervaloDias());
            stmt.setInt(3, efe.getParcelas());
            stmt.setString(4, efe.getCaixa());
            stmt.setString(5, efe.getDataEmissao());
            stmt.setString(6, efe.getDataVencimento());
            stmt.setString(7, efe.getDescricao());
            stmt.setString(8, efe.getFormaPagamento());
            stmt.setString(9, efe.getFormaPagamento2());
            stmt.setString(10, efe.getFormaPagamento3());
            stmt.setString(11, efe.getFornecedor());
            stmt.setString(12, efe.getHora());
            stmt.setString(13, efe.getOperacao());
            stmt.setString(14, efe.getStatus());
            stmt.setString(15, efe.getUsuario());
            stmt.setDouble(16, efe.getVlrForma1());
            stmt.setDouble(17, efe.getVlrForma2());
            stmt.setDouble(18, efe.getVlrForma3());
            stmt.setDouble(19, efe.getVlrTotal());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public EntradaFinanceiroEntity retornaFinaceiroEntrada(Integer sequencia) throws Exception {
        EntradaFinanceiroEntity efe = new EntradaFinanceiroEntity();
        conectar();
        String sql = "select * from tb_entradaFinanceiro where codigoEntrada =?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, sequencia);
        rs = stmt.executeQuery();

        rs.next();

        efe.setCaixa(rs.getString("caixa"));
        efe.setCodigoEntrada(rs.getInt("codigoEntrada"));
        efe.setDataEmissao(rs.getString("dataEmisao"));
        efe.setDataVencimento(rs.getString("dataVencimento"));
        efe.setDescricao(rs.getString("descricao"));
        efe.setFormaPagamento(rs.getString("formaDePagamento"));
        efe.setFormaPagamento2(rs.getString("formaDePagamento2"));
        efe.setFormaPagamento3(rs.getString("formaDePagamento3"));

        efe.setFornecedor(rs.getString("fornecedor"));
        efe.setHora(rs.getString("hora"));
        efe.setIntervaloDias(rs.getInt("intervaloDias"));
        efe.setOperacao(rs.getString("operacao"));
        efe.setParcelas(rs.getInt("parcelas"));
        efe.setStatus(rs.getString("status"));
        efe.setUsuario(rs.getString("usuario"));
        efe.setVlrForma1(rs.getDouble("vlrForma1"));
        efe.setVlrForma2(rs.getDouble("vlrForma2"));
        efe.setVlrForma3(rs.getDouble("vlrForma3"));
        efe.setVlrTotal(rs.getDouble("vlrTotal"));

        return efe;
    }

    public void inserirContaPagar() {
        try {
            conectar();
            String sql = "";
            stmt = conn.prepareStatement(sql);

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
