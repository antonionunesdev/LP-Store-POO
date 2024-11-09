package pacoteDeNegocios;

public class ProdutoBase {
    protected int id;  
    protected String nome;  

    public ProdutoBase(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome;
    }
}