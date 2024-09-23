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

    @Override
    public String toString() { 
        StringBuilder stringTotal = new StringBuilder();
        stringTotal.append("ID do Pedido: ").append(id).append("\n");
        stringTotal.append("Valor Total: R$ ").append(valorTotal).append("\n");
        stringTotal.append("Itens:\n");
        for (ItemCarrinho item : itens) {
            stringTotal.append(item.toString()).append("\n");
        }
        return stringTotal.toString();
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