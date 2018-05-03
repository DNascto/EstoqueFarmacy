package DAO;

/**
 *
 * @author gabri
 */
import java.sql.*;

public class ModuloConexao {
    //método responsável por estabelecer conexão com o BD
    public static Connection Conector() {
        //a linha abaixo "chama" o driver 
        String driver = "com.mysql.cj.jdbc.Driver";
        //Armazenando informações referente ao banco
        //String url = "jdbc:mysql://localhost:3306/dbinfox";
        String url = "jdbc:mysql://localhost/farmacia1"
                + "?useTimezone=true&serverTimezone=UTC";
                //+ "?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "";
        //Estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            //a linha abaixo serve de apoio para esclarecer o erro
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ModuloConexao");
            System.err.println("\nERRO NO MÉTODO GET CONNECTION");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }
}
