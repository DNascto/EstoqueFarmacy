package bean;

/**
 *
 * @author gabri
 */
public class Usuarios {
    int id_usuario;
    String nome;
    String fone;
    String login;
    String senha;
    String endereco;

    public Usuarios() {
    }

    public Usuarios(String nome, String fone, String login, String senha, String endereco) {
        this.nome = nome;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Usuarios(int id_usuario, String nome, String fone, String login, String senha, String endereco) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id_usuario=" + id_usuario + ", nome=" + nome + ", fone=" + fone + ", login=" + login + ", senha=" + senha + ", endereco=" + endereco + '}';
    }
    
}
