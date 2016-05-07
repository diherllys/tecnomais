
package com.br.tecnomais.classes;

import com.sun.jna.Library;

public interface MP2032 extends Library{
  
    public void ConfiguraTaxaSerial(int bps);
    public int AcionaGuilhotina(int modo);
    public int AjustaLarguraPapel(int iWidth);
    public int AutenticaDoc(String documento, int tempomlsegundos);
    public int BematechTX(String texto);
    public int ComandoTX(String comando, int tamanhoComando);
    public int ConfiguraModeloImpressora(int modelo);
    public int ConfiguraTamanhoExtrato(int tamanhoExtrato);
    public int DocumentInserted();
    public void EsperaImpressao(int ativadesativa);
    public int FechaPorta();
    public int FormataTX( String TextoImpresso, int TipoLetra, int Italico, int Sublinhado, int Expandido, int Enfatizado);
    public int HabilitaEsperaImpressao(int Espera);
    public int HabilitaExtratoLongo(int habilitaextrato);
    public int HabilitaPresenterRetratil(int habilitapresenter);
    public int IniciaPorta(String porta);
    public int Le_Status();
    public int Le_Status_Gaveta();
    public int PrinterReset();
    public int ProgramaPresenterRetratil(int tempodereset);
    public int SelecionaQualidadeImpressao(int qualidade);
    public int AtualizaFirmware(String destinofirmware);
    public int VerificaPapelPresenter();
    
      
}

