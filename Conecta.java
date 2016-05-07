package ConexaoBanco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conecta {

    String driver = "com.mysql.jdbc.Driver";
    public String banco = "";
    String host = "";
    String porta = "";
    String str_conn = "jdbc:mysql://" + host + ":" + porta + "/" + banco;
    String usuario = "root";
    public String senha = "";
    public PreparedStatement st;
    private Statement stmt;
    public ResultSet rs;
    public Connection conn;

    public void criarSTR() throws FileNotFoundException, IOException {

        BufferedReader ler = new BufferedReader(new FileReader("Configurações/Config.cfg"));
        host = ler.readLine();
        banco = ler.readLine();
        porta = ler.readLine();
        usuario = ler.readLine();
        senha = ler.readLine();
        ler.close();
        str_conn = "jdbc:mysql://" + host + ":" + porta + "/" + banco;

    }

    public boolean conectarBanco() {
        try {
            criarSTR();
            //    JOptionPane.showMessageDialog(null, "deu certo conectar");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "É necessário configurar o banco de dados.");
//            new ConfiguracaoBD().show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "É necessário configurar o banco de dados.");
//            new ConfiguracaoBD().show();
        }

        boolean result = true;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(str_conn, usuario, senha);
            stmt = conn.createStatement();

        } catch (ClassNotFoundException Driver) {
            System.out.println("driver nao localizado" + Driver);
            result = false;
        } catch (SQLException fonte) {
            System.out.println("problema com o aql" + fonte);
        }
        return result;
    }

    public void desconecta() {

        boolean result = true;

        try {
            conn.close();
//JOptionPane.showMessageDialog(null,"banco fechado");

        } catch (SQLException fecha) {
            System.out.println("banco nao fechado" + fecha);
            result = false;
        }

    }

    public void executSQL(String sql) {

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (SQLException sqlex) {
            System.out.println("nao foi possivel executar o sql" + sqlex + "sql passado" + sql);
        }

    }
}
