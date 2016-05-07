
package com.br.tecnomais.entity;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class OperacaoEntity {

    private Integer id;
    private Integer codigo;
    private String nome;
    private String natureza;
    private String caracteristicaDeOperacao;
    private boolean aumentaEstq;
    private boolean saiDinheiro;
    private boolean dimComiDeProd;
    private boolean dimComiDeServ;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getCaracteristicaDeOperacao() {
        return caracteristicaDeOperacao;
    }

    public void setCaracteristicaDeOperacao(String caracteristicaDeOperacao) {
        this.caracteristicaDeOperacao = caracteristicaDeOperacao;
    }

    public boolean isAumentaEstq() {
        return aumentaEstq;
    }

    public void setAumentaEstq(boolean aumentaEstq) {
        this.aumentaEstq = aumentaEstq;
    }

    public boolean isSaiDinheiro() {
        return saiDinheiro;
    }

    public void setSaiDinheiro(boolean saiDinheiro) {
        this.saiDinheiro = saiDinheiro;
    }

    public boolean isDimComiDeProd() {
        return dimComiDeProd;
    }

    public void setDimComiDeProd(boolean dimComiDeProd) {
        this.dimComiDeProd = dimComiDeProd;
    }

    public boolean isDimComiDeServ() {
        return dimComiDeServ;
    }

    public void setDimComiDeServ(boolean dimComiDeServ) {
        this.dimComiDeServ = dimComiDeServ;
    }

}
