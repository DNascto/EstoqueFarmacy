package Controller;

import DAO.UsuarioDAO;
import bean.Usuarios;
import controller.ControleUsuario;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author White
 */
public class ControleUsuarioTest {

    Usuarios usuario;
    ControleUsuario controleUsu;
    UsuarioDAO usuarioDaoMock;

    public ControleUsuarioTest() {
    }

    @Before
    public void setUp() {
        usuario = new Usuarios();
        usuarioDaoMock = mock(UsuarioDAO.class);
        controleUsu = new ControleUsuario(usuarioDaoMock);
    }

    @Test
    public void testLogarValido() {
        Usuarios usu = new Usuarios();
        usu.setLogin("eu");
        usu.setSenha("123");
        when(usuarioDaoMock.logar(any()))
                .thenReturn(Boolean.TRUE);

        boolean login = controleUsu.logar(usu.getLogin(), usu.getSenha());
        assertTrue(login);
    }
    
    @Test
    public void testLogarInvalido() {
        when(usuarioDaoMock.logar(any()))
                .thenReturn(Boolean.FALSE);

        boolean login = controleUsu.logar("admin", "123456");
        assertFalse(login);
    }
    
    @Test
    public void testCadastrarUsuario() {
        String nome = "Andre",
                telefone = "132456789",
                login = "and",
                senha = "tats",
                endereco = "alberto carazzai";
        
        when(usuarioDaoMock.cadastrarUsuario(any()))
                .thenReturn(Boolean.TRUE);

        boolean cadastro = controleUsu.cadastrarUsuario(nome, telefone, login, senha, endereco);
        assertTrue(cadastro);
    }
   
    @Test (expected = Exception.class)
    public void testCadastrarUsuarioInvalido() { 
        String nome = null,
                telefone = null,
                login = null,
                senha = null,
                endereco = null;

        when(usuarioDaoMock.cadastrarUsuario(any()))
                .then(null);
        
        controleUsu.cadastrarUsuario(nome, telefone, login, senha, endereco);        
    }
     
    @Test
    public void testListarUsuarios() {
        ArrayList<Usuarios> listaUsu = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaUsu.add(new Usuarios());
        }
        
        when(usuarioDaoMock.listarUsuarios())
                .thenReturn(listaUsu);
        
        ArrayList<Usuarios> list = controleUsu.listarUsuarios();
        assertNotNull(list);
        assertTrue(list.size() == 10);
    }
    
    @Test (expected = Exception.class)
    public void testListarUsuarios_LancaException() { 
        ControleUsuario controlUsu = new ControleUsuario();
        
        when(usuarioDaoMock.listarUsuarios())
                .then(null);
        
        controlUsu.listarUsuarios();
    }
        
    @Test
    public void testDeletarUsuario() { 
        controleUsu.deletarUsuario("Joselito");
    }
}
