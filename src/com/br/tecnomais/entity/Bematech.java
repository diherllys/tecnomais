
//package entidades;

package com.br.tecnomais.entity;
/**
 *
 * @author Boys
 */
public class Bematech{
    public Bematech(){
    // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: invokespecial #20                 // Method java/lang/Object."<init>":()V
         * 4: return
         *  */
        // </editor-fold>
    }
   
    public static native void ConfiguraTaxaSerial(int bps);
    public static native int AcionaGuilhotina(int modo);
    public static native int AjustaLarguraPapel(int iWidth);
    public static native int AutenticaDoc(String documento, int tempomlsegundos);
    public static native int BematechTX(String texto);
    public static native int ComandoTX(String comando, int tamanhoComando);
    public static native int ConfiguraModeloImpressora(int modelo);
    public static native int ConfiguraTamanhoExtrato(int tamanhoExtrato);
    public static native int DocumentInserted();
    public static native void EsperaImpressao(int ativadesativa);
    public static native int FechaPorta();
    public static native int FormataTX( String TextoImpresso, int TipoLetra, int Italico, int Sublinhado, int Expandido, int Enfatizado);
    public static native int HabilitaEsperaImpressao(int Espera);
    public static native int HabilitaExtratoLongo(int habilitaextrato);
    public static native int HabilitaPresenterRetratil(int habilitapresenter);
    public static native int IniciaPorta(String porta);
    public static native int Le_Status();
    public static native int Le_Status_Gaveta();
    public static native int PrinterReset();
    public static native int ProgramaPresenterRetratil(int tempodereset);
    public static native int SelecionaQualidadeImpressao(int qualidade);
    public static native int AtualizaFirmware(String destinofirmware);
    public static native int VerificaPapelPresenter();
    
   static{
          System.loadLibrary("MP2032");
   }   
}
class BemaInteger{public int number;}
class BemaString{public String buffer;}
