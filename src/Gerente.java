public class Gerente {
	public static int contadorId = 1;
    private int id;
    private String nome;
    
    public Gerente(String nome) {
    	this.id = contadorId++;
    	this.nome = nome;
    }
    
    public int getId() {
    	return id;
    }
    
    public String getNome() {
    	return nome;
    }
}