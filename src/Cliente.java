public class Cliente {
    private static int contadorId = 1;
    private int id;
    private String nome;
    
    public Cliente(String nome) {
        this.id = contadorId++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public void atualizarDadosCliente(String novoNome) {
        this.nome = novoNome;
    }
    
    public void exibirDadosCliente() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
    }
}
