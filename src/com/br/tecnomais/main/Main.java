package com.br.tecnomais.main;

import com.br.tecnomais.classes.Alertas;
import com.br.tecnomais.classes.Licenca;
import com.br.tecnomais.dao.LicencaDao;
import com.br.tecnomais.vcadastros.LicenciarSoftwareView;
import javax.swing.JOptionPane;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class Main {

    static LicencaDao dao = new LicencaDao();

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        try {
            if (dao.verificaLicencaExistente() == false) {
                int opcao = JOptionPane.showConfirmDialog(null, "Sistema não licenciado, deseja licenciar agora?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                if(opcao == JOptionPane.YES_OPTION) {
                    new LicenciarSoftwareView(null, true).setVisible(true);
                } else {
                    new Alertas().mensagemAviso("O sistema será encerrado!");
                    System.exit(0);
                }
            } else {
                Licenca lic = new Licenca();
                lic.checaLicenca();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
