
package com.br.tecnomais.entity;

/**
 *
 * @author Desenvolvimento
 */
public class ImpressoraDarumaEntity {
    private Integer id;
    private String registroTermico;
    private String portaComunicacao;
    private String portaVelocidade;
    private String statusGuilhotina;
    private String tamanhoGuilhotina;
    private String numSaltoLinhas;
    private String zeroCortadoStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getRegistroTermico() {
        return registroTermico;
    }

    public void setRegistroTermico(String registroTermico) {
        this.registroTermico = registroTermico;
    }

    public String getPortaComunicacao() {
        return portaComunicacao;
    }

    public void setPortaComunicacao(String portaComunicacao) {
        this.portaComunicacao = portaComunicacao;
    }

    public String getPortaVelocidade() {
        return portaVelocidade;
    }

    public void setPortaVelocidade(String portaVelocidade) {
        this.portaVelocidade = portaVelocidade;
    }

    public String getStatusGuilhotina() {
        return statusGuilhotina;
    }

    public void setStatusGuilhotina(String statusGuilhotina) {
        this.statusGuilhotina = statusGuilhotina;
    }

    public String getTamanhoGuilhotina() {
        return tamanhoGuilhotina;
    }

    public void setTamanhoGuilhotina(String tamanhoGuilhotina) {
        this.tamanhoGuilhotina = tamanhoGuilhotina;
    }

    public String getNumSaltoLinhas() {
        return numSaltoLinhas;
    }

    public void setNumSaltoLinhas(String numSaltoLinhas) {
        this.numSaltoLinhas = numSaltoLinhas;
    }

    public String getZeroCortadoStatus() {
        return zeroCortadoStatus;
    }

    public void setZeroCortadoStatus(String zeroCortadoStatus) {
        this.zeroCortadoStatus = zeroCortadoStatus;
    }
}
