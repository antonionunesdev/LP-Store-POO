package pacoteDeNegocios;

public class Cliente extends Pessoa {
    public Cliente(String nome) {
        super(nome);
    }
    
    @Override
    public String exibirDados() {
        return "Nome do cliente: " + nome + "\nID do cliente: " + id;
    }
}