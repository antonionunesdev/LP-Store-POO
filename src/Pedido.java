
import java.util.List;

public class Pedido {
    private int id;
    private List<ItemCarrinho> itens; // Itens do pedido
    private double valorTotal;

    // Construtor
    public Pedido(int id, List<ItemCarrinho> itens, double valorTotal) {
        this.id = id;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    // Getters
    public int getId() {
        return id;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
