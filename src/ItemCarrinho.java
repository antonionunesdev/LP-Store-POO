public class ItemCarrinho {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }
    
    @Override
    public String toString() {
        return produto.getNome() + " - " + quantidade + " x " + produto.getPreco();
    }
  
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }
}