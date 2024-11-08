package pacoteDeNegocios;

public class Cliente extends Pessoa {
    public Cliente(String nome) {
        super(nome);
    }

    public void atualizarDadosCliente(String novoNome) {
        this.nome = novoNome;
    }
    
    @Override
    public void exibirDados() {
        System.out.println("ID do cliente: " + id);
        System.out.println("Nome do cliente: " + nome);
    }
}