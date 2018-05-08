package controller;

import DAO.UsuarioDAO;
import bean.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class ControleUsuario {

    UsuarioDAO dao = new UsuarioDAO();

    public ControleUsuario() {
    }
    
    public ControleUsuario(UsuarioDAO dao) {
        this.dao = dao;
    }

    public boolean logar(String log, String sen) {
        try {
            Usuarios usu = new Usuarios();
            usu.setLogin(log);
            usu.setSenha(sen);
            System.out.println("Metodo: " + usu.getLogin());
            return dao.logar(usu);
        } catch (Exception e) {
            System.err.println("\nCLASSE ControleUsuario");
            System.err.println("\nERRO NO MÉTODO Logar");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean cadastrarUsuario(String nome, String telefone, String login,
                                    String senha, String endereco) {
        try {
            Usuarios user = new Usuarios(nome, telefone, login, senha, endereco);

            return dao.cadastrarUsuario(user);
        } catch (Exception e) {
            System.err.println("\nCLASSE ControleUsuario");
            System.err.println("\nERRO NO MÉTODO cadastrarUsuario");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Usuarios> listarUsuarios() {
        try {
            ArrayList<Usuarios> vetUsuario = dao.listarUsuarios();

            return vetUsuario;
        } catch (Exception e) {
            System.err.println("\nCLASSE ControleUsuario");
            System.err.println("\nERRO NO MÉTODO buscarUsuario");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deletarUsuario(String nome) {
        try {
            dao.deletarUsuario(nome);
        } catch (Exception e) {
            System.err.println("\nCLASSE ControleUsuario");
            System.err.println("\nERRO NO MÉTODO deletarUsuario");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
