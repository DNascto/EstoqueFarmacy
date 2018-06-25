package DAO;

import bean.Estoque;
import bean.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class EstoqueDAO {

    private Connection connection = null;
    
    public EstoqueDAO(){
        this.connection = ModuloConexao.Conector();
    }
    
    public void entradaProduto(Produtos produto){
        String sql = "INSERT INTO tbEstoque (quantidade, id_Produto) VALUES (?,?);";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, produto.getQuantidade());
            pst.setInt(2, encontrarIdProduto(produto.getNome()));
           
            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleEstoque DAO");
            System.err.println("\nERRO NO MÉTODO entradaProduto");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);              
        }
    }
    
    public int encontrarIdProduto(String nome){
        String sql = "SELECT * FROM tbproduto WHERE nome = ?";
        int idProduto = -1;

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
           
            if(!rs.next()){
                System.out.println("rs falso");
            }
            
            idProduto = rs.getInt("id_produto");
            rs.close();
            pst.close();
            return idProduto;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleEstoque DAO");
            System.err.println("\nERRO NO MÉTODO encontrarIdProduto");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);  
        }
    }    
    
    public ArrayList<Estoque> consultarEstoque(){
        String sql = "SELECT * FROM tbestoque INNER JOIN tbproduto "
                + "on tbestoque.id_Produto = tbproduto.id_produto";

        try {
            ArrayList<Estoque> vetEstoque = new ArrayList<>();
            PreparedStatement pst = this.connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Estoque e = new Estoque();
                e.setId_estoque(rs.getInt("id_estoque"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setId_produto(rs.getInt("id_produto"));
                e.setNome(rs.getString("nome"));
                vetEstoque.add(e);
            }
            rs.close();
            pst.close();
            
            return vetEstoque;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleEstoque - DAO");
            System.err.println("\nERRO NO MÉTODO consultarEstoque");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);              
        }
    }
/*
    public String encontrarNomeProduto(int id){
        String sql = "select * from tbproduto where id_produto = ?";
        String nome;
        String id_string = id + "";
        
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, id_string);
            ResultSet rs = pst.executeQuery();
           
            if(!rs.next()){
                System.out.println("rs falso");
            }
            
            nome = rs.getString("nome");
            rs.close();
            pst.close();
            return nome;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleEstoque DAO");
            System.err.println("\nERRO NO MÉTODO encontrarIdProduto");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);  
        }
    }    
    */
    public void saidaProduto(){
        String sql = "DELETE FROM tbestoque WHERE id_estoque = ?";
    }
}
