package pacoteDeNegocios;

public class ItemCarrinho extends ProdutoBase {
    private final Produto produto;
    private int quantidade;
    private double subtotal;

    public ItemCarrinho(Produto produto, int quantidade) {
        super(produto.getId(), produto.getNome());
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - " + quantidade + " x R$ " + produto.getPreco() + " = R$ " + subtotal;
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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        atualizarSubtotal();
    }

    private void atualizarSubtotal() {
        this.subtotal = produto.getPreco() * quantidade;
    }
}