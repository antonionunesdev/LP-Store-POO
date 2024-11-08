package pacoteDeNegocios;

public class Gerente extends Pessoa {
    public Gerente(String nome) {
        super(nome);
    }

    @Override
    public void exibirDados() {
        System.out.println("ID do gerente: " + id);
        System.out.println("Nome do gerente: " + nome);
    }
}