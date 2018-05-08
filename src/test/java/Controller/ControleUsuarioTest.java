package Controller;

import DAO.UsuarioDAO;
import bean.Usuarios;
import controller.ControleUsuario;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
    /*
    @Test (expected = Exception.class)
    public void testCadastrarUsuarioInvalido() { //possibilidade de nao funcionar
        String nome = null,
                telefone = null,
                login = null,
                senha = null,
                endereco = null;

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
        assertTrue(list != null);
        //assertTrue(list.size() == 10);
    }
    
    @Ignore
    @Test (expected = Exception.class)
    public void testListarUsuarios_LancaException() { 
        ControleUsuario controlUsu = new ControleUsuario();
        controlUsu.listarUsuarios();
    }
        
    @Test
    public void testDeletarUsuario() { 
        ControleUsuario controlUsu = new ControleUsuario();
        controlUsu.deletarUsuario("teste");
    }
    
    @Ignore
    @Test (expected = Exception.class)
    public void testDeletarUsuario_LancaException() { 
        ControleUsuario controlUsu = new ControleUsuario();
        controlUsu.deletarUsuario("$###@@");
    }
    */
}
