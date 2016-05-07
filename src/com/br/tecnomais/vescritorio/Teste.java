import com.br.tecnomais.vconfiguracao.FixedLengthDocument;
import java.awt.BorderLayout;
import java.util.Random;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JTextField;


/** Siemens Ltda.
 *<p> 
 *    Project: Teste<br>
 *   Filename: Teste.java<br>
 * Created on: 15/12/2006<br>
 */

public class Teste
{
    public static void main(String args[])
    {
        JFrame aFrame = new JFrame();
        aFrame.setLayout(new BorderLayout());
        JTextField txtTeste = new JTextField();
        txtTeste.setDocument(new FixedLengthDocument(10));        
        aFrame.add(txtTeste, BorderLayout.NORTH);
        
        aFrame.setSize(200,200);
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setVisible(true);
    }
}
