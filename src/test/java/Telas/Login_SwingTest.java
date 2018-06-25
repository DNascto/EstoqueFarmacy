package Telas;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;
import org.junit.Ignore;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.junit.Assert.*;

/**
 *
 * @author White
 */
public class Login_SwingTest extends AssertJSwingJUnitTestCase {

    public Login_SwingTest() {
    }

    private FrameFixture window;
    private FrameFixture mainFrame;

    @Override
    protected void onSetUp() {
        //SimpleCopyApplication frame = GuiActionRunner.execute(() -> new SimpleCopyApplication());
        telas.TelaLogin frame = GuiActionRunner.execute(() -> new telas.TelaLogin());
        // IMPORTANT: note the call to 'robot()'
        // we must use the Robot from AssertJSwingJUnitTestCase
        window = new FrameFixture(robot(), frame);
        window.show(); // shows the frame to test
    }

    @Test 
    public void testeLogarCorreto() {
        window.textBox("txtUsuario").enterText("eu");
        window.textBox("txtSenha").enterText("123");
        window.button("btnLogin").click();

        mainFrame = findFrame("Principal").
                withTimeout(10, SECONDS).using(robot());
        assertTrue(mainFrame.isEnabled());
    }

    @Test   
    public void testeCadastrarUsuario() {
        String user = "voce", senha = "456";
        window.button("btnRegistrar").click();

        FrameFixture registerFrame = findFrame("telaCadastro").
                withTimeout(10, SECONDS).using(robot());

        registerFrame.textBox("txtEndereco").enterText("Logradouro aleatorio");
        registerFrame.textBox("txtTelefone").enterText("11963258741");
        registerFrame.textBox("txtNome").enterText("TATS");
        registerFrame.textBox("txtLogin").enterText(user);
        registerFrame.textBox("txtSenha").enterText(senha);
        
        window.robot().settings().delayBetweenEvents(1000);
        registerFrame.button("btnCadastrar").click();
        assertTrue(registerFrame.label("msgSucesso").isEnabled());
        
        window.robot().settings().delayBetweenEvents(75);
        registerFrame.button("btnCancelar").click();

        window.textBox("txtUsuario").enterText(user);
        window.textBox("txtSenha").enterText(senha);
        window.button("btnLogin").click();

        mainFrame = findFrame("Principal").
                withTimeout(10, SECONDS).using(robot());
        assertTrue(mainFrame.isEnabled());
    }
    
    @Test
    public void testeConsultaDeProdutos() {
        testeLogarCorreto();
        
        window.robot().settings().delayBetweenEvents(500);
        
        mainFrame.menuItem("menuProdutos").click();
        mainFrame.menuItem("menuItemConsultaProdutos").click();
        
        FrameFixture consultFrame = findFrame("telaConsultaProdutos").
                withTimeout(10, SECONDS).using(robot());
        assertTrue(consultFrame.isEnabled());
        
        assertEquals(0, consultFrame.table("tabelaProdutos").rowCount());
        
        consultFrame.button("btnConsultarProdutos").click();
        
        assertTrue(consultFrame.table("tabelaProdutos").rowCount() >= 1);        
    }

    @Test
    public void testeDeletaUsuario() {
        String nome = "TATS";
        testeLogarCorreto();
        
        mainFrame.menuItem("menuUsuario").click();
        mainFrame.menuItem("menuItemDeletarUsuario").click();
        
        FrameFixture deleteUserFrame = findFrame("telaDeletarUsuario")
                .withTimeout(10, SECONDS).using(robot());
        assertTrue(deleteUserFrame.isEnabled());
        
        window.robot().settings().delayBetweenEvents(1000);
        deleteUserFrame.comboBox("cbNomeUsuario").selectItem(nome);
        
        deleteUserFrame.comboBox("cbNomeUsuario").selectedItem();
        deleteUserFrame.button("btnDeletar").click();
        
        String nomes[] = deleteUserFrame.comboBox("cbNomeUsuario").contents();
        int encontrado = 0;
        for (String nomeAtual : nomes) {
            if(nomeAtual.equals(nome))
                encontrado++;
        }
        assertEquals(0, encontrado);
    }
}
