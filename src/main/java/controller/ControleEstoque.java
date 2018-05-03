package controller;

import bean.Produtos;
import bean.Estoque;
import DAO.EstoqueDAO;
import java.util.ArrayList;

/**
 *
 * @author white
 */
public class ControleEstoque {
    EstoqueDAO dao = new EstoqueDAO();

    public ControleEstoque() {
    }

    public void entradaProduto(String nome, int quantidade) {
        Produtos p = new Produtos();
        p.setNome(nome);
        p.setQuantidade(quantidade);
        try {
            dao.entradaProduto(p);
        } catch (Exception e) {
            System.out.println("Erro na entrada de produto na classe Controle Estoque");
            e.printStackTrace();
        }
    }


    public ArrayList<Estoque> consultarEstoque(){
        try {
            return dao.consultarEstoque();
        } catch (Exception e) {
            System.out.println("Erro na consultar estoque na classe Controle Estoque");
            e.printStackTrace();
        }
        return  null;
    }

    public void saidaProduto() {
        dao.saidaProduto();
    }
}
