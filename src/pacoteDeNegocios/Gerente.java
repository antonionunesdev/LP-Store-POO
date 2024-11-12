package pacoteDeNegocios;

public class Gerente extends Pessoa {
    private final String senha;

    public Gerente(String nome, String senha) {
        super(nome);
        this.senha = senha;
    }

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public String exibirDados() {
        return "Nome do gerente: " + nome + "\nID do gerente: " + id;
    }
}