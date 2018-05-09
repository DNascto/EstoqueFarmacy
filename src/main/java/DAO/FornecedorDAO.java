package DAO;

import bean.Fornecedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class FornecedorDAO {
    private final Connection connection = null;
    
//    public FornecedorDAO(){
//        this.connection = ModuloConexao.Conector();
//    }
    
    public void cadastrarFornecedor(Fornecedores forn){
        String sql = "INSERT INTO tbFornecedor (nome, fone, endereco, cnpj) "
                + "VALUES (?,?,?,?);";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            
            pst.setString(1, forn.getNome());
            pst.setString(2, forn.getFone());
            pst.setString(3, forn.getEndereco());
            pst.setString(4, forn.getCnpj());
            
            pst.execute();
            pst.close();
            
            //JOptionPane.showMessageDialog(null, "Fornecedor cadastrador com sucesso !");
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleFornecedor DAO");
            System.err.println("\nERRO NO MÉTODO cadastrarFornecedor");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);            
        }
    }
    
    public ArrayList<Fornecedores> listarFornecedores(){
        String sql = "SELECT * FROM tbFornecedor;";
        try {
            ArrayList<Fornecedores> vetForn = new ArrayList<>();
            PreparedStatement pst = this.connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Fornecedores f = new Fornecedores();
                f.setNome(rs.getString("nome"));
                f.setFone(rs.getString("fone"));
                f.setEndereco(rs.getString("endereco"));
                f.setCnpj(rs.getString("cnpj"));
                
                vetForn.add(f);
            }
            rs.close();
            pst.close();

            return vetForn;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE ControleFornecedor - DAO");
            System.err.println("\nERRO NO MÉTODO burscarFornecedore");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);            
        }
    }
}
