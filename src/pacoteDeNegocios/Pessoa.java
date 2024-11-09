package pacoteDeNegocios;

public abstract class Pessoa {
    protected static int contadorId = 1;
    protected int id;
    protected String nome;

    public Pessoa(String nome) {
        this.id = contadorId++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public abstract String exibirDados();
}