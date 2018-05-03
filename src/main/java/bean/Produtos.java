package bean;

/**
 *
 * @author gabri
 */
public class Produtos {
    String id_produto;
    String nome;
    String descricao;
    int codBarras,
        quantidade;
    String categoria;

    public Produtos() {
    }

    public Produtos(String nome, String descricao, int codBarras, int quantidade, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.codBarras = codBarras;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Produtos(String id_produto, String nome, String descricao, int codBarras, int quantidade, String categoria) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.codBarras = codBarras;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getId_produto() {
        return id_produto;
    }

    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(int codBarras) {
        this.codBarras = codBarras;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
