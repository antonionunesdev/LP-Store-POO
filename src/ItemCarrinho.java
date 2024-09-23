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

    // Método para atualizar o subtotal
    public void atualizarSubtotal() {
        this.subtotal = produto.getPreco() * quantidade;
    }
}
