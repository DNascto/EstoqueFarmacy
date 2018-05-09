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
        forneDaoMock = mock(FornecedorDAO.class);
        forn = new ControleFornecedor(forneDaoMock);
    }

    @Test
    public void testCadastrarFornecedor() {
        String nome = "Eu";
        String telefone = "789456123";
        String endereco = "Alberto Carazzai";
        String cnpj = "789456123654/1000";
        
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
}
