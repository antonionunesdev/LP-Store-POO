
public class Cliente {
   int id;
   String nome;
   
   
   public Cliente(int id, String nome) {
	   this.id = id;
	   this.nome = nome;
   }
   
   public void atualizarDadosCliente (String NovoNome){
	   this.nome = NovoNome;
   }
   
   public void exibirDadosCliente() {
       System.out.println("ID: " + id);
       System.out.println("Nome: " + nome);
   }

   public int getId() {
       return id;
   }

   public String getNome() {
       return nome;
   }
   
}
