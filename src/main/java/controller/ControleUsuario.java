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

    public boolean logar(String log, String senha) {
        Usuarios usu = new Usuarios();
        if (log.trim() != null && !log.trim().equals("")
                || senha.trim() != null && !senha.trim().equals("")) {
            usu.setLogin(log);
            usu.setSenha(senha);
            return dao.logar(usu);
        } else {
            return false;
        }
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
