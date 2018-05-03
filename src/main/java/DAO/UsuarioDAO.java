package DAO;

import bean.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO() {
        this.connection = new ModuloConexao().Conector();

    }

    public boolean logar(Usuarios usu) {
        String sql = "SELECT * FROM tbusuario WHERE login = ? and senha = ?";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);

            System.out.println("DAO: "+usu.getLogin());
            pst.setString(1, usu.getLogin());
            pst.setString(2, usu.getSenha());
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                //String nome = rs.getString("nome");
                System.out.println("IF ok");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleUsuario DAO");
            System.err.println("\nERRO NO MÉTODO Logar");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public boolean cadastrarUsuario(Usuarios user) {
        String sql = "INSERT INTO tbusuario (nome, fone, login, senha, endereco) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);

            pst.setString(1, user.getNome());
            pst.setString(2, user.getFone());
            pst.setString(3, user.getLogin());
            pst.setString(4, user.getSenha());
            pst.setString(5, user.getEndereco());

            pst.execute();
            pst.close();
            return true;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleUsuario DAO");
            System.err.println("\nERRO NO MÉTODO cadastrarUsuario");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Usuarios> listarUsuarios() {
        String sql = "SELECT * FROM tbusuario";
        try {
            ArrayList<Usuarios> vetUsuario = new ArrayList<>();
            PreparedStatement pst = this.connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setNome(rs.getString("nome"));
                u.setFone(rs.getString("fone"));
                u.setLogin(rs.getString("login"));
                //u.setSenha(rs.getString("senha"));
                u.setEndereco(rs.getString("endereco"));
                vetUsuario.add(u);
            }
            rs.close();
            pst.close();
            
            return vetUsuario;
            
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleUsuario - DAO");
            System.err.println("\nERRO NO MÉTODO buscarUsuario");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }
    
    public void deletarUsuario(String nome){
        String sql = "DELETE FROM tbusuario WHERE nome = ?";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            pst.close();
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleUsuario - DAO");
            System.err.println("\nERRO NO MÉTODO deletarUsuario");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);            
        }
    }
}
