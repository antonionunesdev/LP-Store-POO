package pacoteDeNegocios;

public class Pessoa {
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

    public void exibirDados() {
        System.out.println("Último usuário logado:");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
    }
}