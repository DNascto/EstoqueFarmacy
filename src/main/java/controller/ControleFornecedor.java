package controller;

import DAO.FornecedorDAO;
import bean.Fornecedores;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class ControleFornecedor {
    FornecedorDAO dao = new FornecedorDAO();
    
    public ControleFornecedor(){
        
    }
   
    public ControleFornecedor(FornecedorDAO dao){
        this.dao = dao;
    }
    
    public void cadastrarFornecedor(String nome, String telefone, String endereco, String cnpj){
        try {
            Fornecedores forn = new Fornecedores(nome, nome, endereco, cnpj);
            dao.cadastrarFornecedor(forn);
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleFornecedor");
            System.err.println("\nERRO NO MÉTODO cadastrarFornecedor");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);            
        }
    }
    
    public ArrayList<Fornecedores> listarFornecedores(){
        try {
            ArrayList<Fornecedores> vetForn = dao.listarFornecedores();
            return vetForn;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleFornecedor");
            System.err.println("\nERRO NO MÉTODO burscarFornecedore");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);            
        }
    }
}
