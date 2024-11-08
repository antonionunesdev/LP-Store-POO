package pacoteDeNegocios;

public class ItemCarrinho extends ProdutoBase {

    private Produto produto;  // O produto que está no carrinho
    private int quantidade;
    private double subtotal;

    // Construtor do ItemCarrinho, que também chama o construtor da classe Item
    public ItemCarrinho(Produto produto, int quantidade) {
        super(produto.getId(), produto.getNome());  // Chama o construtor da classe Item, passando id e nome do produto
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - " + quantidade + " x R$ " + produto.getPreco() + " = R$ " + subtotal;
    }

    // Métodos getters
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
