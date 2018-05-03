package Controller;

import DAO.FornecedorDAO;
import bean.Fornecedores;
import controller.ControleFornecedor;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author White
 */
public class ControleFornecedoresTest {
    ControleFornecedor forn;
    FornecedorDAO forneDaoMock;
    
    public ControleFornecedoresTest() {
    }
    
    @Before
    public void setUp() {
        forn = new ControleFornecedor();
        forneDaoMock = mock(FornecedorDAO.class);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCadastrarFornecedor() {
        String nome = "Eu";
        String telefone = "789456123";
        String endereco = "Alberto Carazzai";
        String cnpj = "789456123654/1000";
        
        forn.cadastrarFornecedor(nome, telefone, endereco, cnpj);
    }
    
    @Test (expected = Exception.class)
    public void testCadastrarFornecedor_LancaException() {
        String nome = null;
        String telefone = null;
        String endereco = null;
        String cnpj = null;
        
        forn.cadastrarFornecedor(nome, telefone, endereco, cnpj);
    }
    
    @Test
    public void testListarFornecedores() {
        ArrayList<Fornecedores> listaForne = forn.listarFornecedores();
        
        assertTrue(listaForne != null);
        assertTrue(listaForne.size() >= 1);
    }
    
    @Test
    public void testListarFornecedores_LancaException() {
        ArrayList<Fornecedores> listaForne = forn.listarFornecedores();
        
        assertTrue(listaForne != null);
        assertTrue(listaForne.size() >= 1);
    }
}
