package pacoteDeNegocios;

import java.util.List;

public class Pedido extends Compra {
    private final int id;
    private final Cliente cliente;

    public Pedido(Cliente cliente, int id, List<ItemCarrinho> itens, double valorTotal) {
        super(itens);
        this.cliente = cliente;
        this.id = id;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        StringBuilder stringTotal = new StringBuilder();
        stringTotal.append("ID do Pedido: ").append(id).append("\n");
        stringTotal.append("Cliente: ").append(cliente.getNome()).append("\n");
        stringTotal.append("Valor Total: R$ ").append(valorTotal).append("\n");
        stringTotal.append("Itens:");
        for (ItemCarrinho item : itens) {
            stringTotal.append("\n").append(item.toString());
        }
        return stringTotal.toString();
    }
}