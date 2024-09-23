public class ItemCarrinho {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    // Construtor
    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;  // Calcula o subtotal
    }
    
    @Override
    public String toString() {
        return produto.getNome() + " - " + quantidade + " x " + produto.getPreco();
    }
  
    // Getters
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    // MÃ©todo para atualizar o subtotal
    public void atualizarSubtotal() {
        this.subtotal = produto.getPreco() * quantidade;
    }
}