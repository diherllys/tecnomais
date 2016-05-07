package com.br.tecnomais.entity;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class ProdutoEntity {

    private Integer id;
    private Integer codigoProduto;
    private String nome;
    private String codigoDeBarras;
    private String classe;
    private String tipo;
    private String textoDeSaida;
    private Double precoDeCusto;
    private Double precoDeVenda;
    private Double porcentagem;
    private Double qntAtual;
    private Double estqCritico;
    private String unidadeDeVenda;
    private String foto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTextoDeSaida() {
        return textoDeSaida;
    }

    public void setTextoDeSaida(String textoDeSaida) {
        this.textoDeSaida = textoDeSaida;
    }

    public Double getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(Double precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public Double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(Double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Double getQntAtual() {
        return qntAtual;
    }

    public void setQntAtual(Double qntAtual) {
        this.qntAtual = qntAtual;
    }

    public String getUnidadeDeVenda() {
        return unidadeDeVenda;
    }

    public void setUnidadeDeVenda(String unidadeDeVenda) {
        this.unidadeDeVenda = unidadeDeVenda;
    }

    public Double getEstqCritico() {
        return estqCritico;
    }

    public void setEstqCritico(Double estqCritico) {
        this.estqCritico = estqCritico;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
