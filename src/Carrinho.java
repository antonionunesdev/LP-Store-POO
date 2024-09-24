import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens;  
    private double total;  

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = itens;
        this.total = 0.0;
    }

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