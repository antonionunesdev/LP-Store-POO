package pacoteDeNegocios;

public class Cliente extends Pessoa {
    private final String senha;

    public Cliente(String nome, String senha) {
        super(nome);
        this.senha = senha;
    }
    
    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public String exibirDados() {
        return "Nome do cliente: " + getNome() + "\nID do cliente: " + getId();
    }
}
