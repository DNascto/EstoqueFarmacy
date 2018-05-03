package controller;

import DAO.ProdutoDAO;
import bean.Produtos;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class ControleProduto {
    ProdutoDAO dao = new ProdutoDAO();
    
    public ControleProduto(){
    }
    
    public void inserir(String nome, int codigo, String descricao, String categoria){
        try {
            Produtos p = new Produtos(nome, descricao, codigo, 0, categoria);
            dao.inserir(p);
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleProdutos DAO");
            System.err.println("\nERRO NO MÉTODO inserir");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);            
        }
    }

    
    public ArrayList<Produtos> buscarProduto(){
        try {
            ArrayList<Produtos> vetProd = new ArrayList<>();
            
            return vetProd;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleProduto");
            System.err.println("\nERRO NO MÉTODO buscarProduto");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);            
        }
    }    

}
