import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens;  // Itens no carrinho
    private double total;  // Valor total do carrinho

    // Construtor
    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = itens;
        this.total = 0.0;
    }

    // Getters e Setters
    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
