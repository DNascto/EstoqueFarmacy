package Controller;

import DAO.FornecedorDAO;
import bean.Fornecedores;
import controller.ControleFornecedor;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
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
        forneDaoMock = mock(FornecedorDAO.class);
        forn = new ControleFornecedor(forneDaoMock);
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
    
    @Ignore
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
        ArrayList<Fornecedores> listaForn = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaForn.add(new Fornecedores());
        }
        when(forneDaoMock.listarFornecedores())
                .thenReturn(listaForn);
        ArrayList<Fornecedores> listaForne = forn.listarFornecedores();
        
        assertNotNull(listaForne);
        assertTrue(listaForne.size() == 10);
    }
    
    @Test
    public void testListarFornecedores_LancaException() {
        ArrayList<Fornecedores> listaForn = new ArrayList<>();
        
        when(forneDaoMock.listarFornecedores())
                .thenReturn(listaForn);
        
        ArrayList<Fornecedores> listaForne = forn.listarFornecedores();
        
        //assertNull(listaForne);
    }
}
