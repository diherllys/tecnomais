package com.br.tecnomais.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Diherllys LL, Reginaldo Cândido
 */
public class ConectaBanco {

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String banco = "";
    String host = "";
    String porta = "";
    String str_conn = "jdbc:sqlserver://" + host + ":" + porta + "/" + banco;
    String usuario = "sa";
    public String senha = "";
    public PreparedStatement stmt;
    public Statement st;
    public ResultSet rs;
    public Connection conn;

    public void criarSTR() throws FileNotFoundException, IOException {
        BufferedReader ler = new BufferedReader(new FileReader("Config/banco.cfg"));
        host = ler.readLine();
        banco = ler.readLine();
        porta = ler.readLine();
        usuario = ler.readLine();
        senha = ler.readLine();
        ler.close();
        str_conn = "jdbc:sqlserver://" + host + ":" + porta + "/" + banco;
    }
//192.168.1.67
    public void conectar() {
        try {
            criarSTR();
            // Define Driver de conexão JDBC thin
            String URL = "jdbc:sqlserver://"+host+"\\SQLEXPRESS:1433;databaseName=" + banco
                    + ";user=" + usuario + ";password=" + senha;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL);

            //Executa pedido SQL
            st = conn.createStatement();
//            JOptionPane.showMessageDialog(null, "Conexão Efetuada com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void executaSQL(String sql) {
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
        } catch (SQLException sqlex) {
            System.out.println("nao foi possivel executar o sql" + sqlex + "sql passado" + sql);
        }
    }
}