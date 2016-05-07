
package com.br.tecnomais.entity;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class UsuarioEntity {
    
    private Integer id;
    private String usuario;
    private String senha;
    private String nome_usuario;
    private Integer nivel;
    private String foto;
    private String dataNasc;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer id, String usuario, String senha, String nome_usuario, Integer nivel, String foto, String dataNasc) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome_usuario = nome_usuario;
        this.nivel = nivel;
        this.foto = foto;
        this.dataNasc = dataNasc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
     public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    
}
