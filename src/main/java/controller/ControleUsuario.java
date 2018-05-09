package controller;

import DAO.UsuarioDAO;
import bean.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author White
 */
public class ControleUsuario {

    UsuarioDAO dao = new UsuarioDAO();

    public ControleUsuario() {
    }

    public ControleUsuario(UsuarioDAO dao) {
        this.dao = dao;
    }

    public boolean logar(String log, String sen) {
        Usuarios usu = new Usuarios();
        usu.setLogin(log);
        usu.setSenha(sen);
        return dao.logar(usu);
    }

    public boolean cadastrarUsuario(String nome, String telefone, String login,
                                    String senha, String endereco) {
        Usuarios user = new Usuarios(nome, telefone, login, senha, endereco);

        return dao.cadastrarUsuario(user);
    }

    public ArrayList<Usuarios> listarUsuarios() {
        ArrayList<Usuarios> vetUsuario = dao.listarUsuarios();

        return vetUsuario;
    }

    public void deletarUsuario(String nome) {
        dao.deletarUsuario(nome);
    }
}
