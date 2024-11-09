package pacoteDeNegocios;

import java.util.List;

public class Pedido extends Compra {
    private final int id;

    public Pedido(int id, List<ItemCarrinho> itens, double valorTotal) {
        super(itens);
        this.id = id;
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
}