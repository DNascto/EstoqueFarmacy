package controller;

import DAO.FornecedorDAO;
import bean.Fornecedores;
import java.util.ArrayList;

/**
 *
 * @author White
 */
public class ControleFornecedor {

    FornecedorDAO dao = new FornecedorDAO();

    public ControleFornecedor() {

    }

    public ControleFornecedor(FornecedorDAO dao) {
        this.dao = dao;
    }

    public void cadastrarFornecedor(String nome, String telefone, String endereco, String cnpj) {
        Fornecedores forn = new Fornecedores(nome, nome, endereco, cnpj);
        dao.cadastrarFornecedor(forn);
    }

    public ArrayList<Fornecedores> listarFornecedores() {
        ArrayList<Fornecedores> vetForn = dao.listarFornecedores();
        return vetForn;
    }
}
