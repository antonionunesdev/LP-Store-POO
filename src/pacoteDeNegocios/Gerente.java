package pacoteDeNegocios;

public class Gerente extends Pessoa {
    public Gerente(String nome) {
        super(nome);
    }

    @Override
    public String exibirDados() {
        return "Nome do gerente: " + nome + "\nID do gerente: " + id;
    }
}