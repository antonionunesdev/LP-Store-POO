import java.util.ArrayList;
import java.util.List;

public class PedidoCRUD {
    private List<Pedido> pedidos;

    public PedidoCRUD() {
        this.pedidos = new ArrayList<>();
    }

    public void criarPedido(Carrinho carrinho) {
        int novoId = pedidos.size() + 1;
        Pedido novoPedido = new Pedido(novoId, carrinho.getItens(), carrinho.getTotal());
        pedidos.add(novoPedido);
        System.out.println("Pedido criado: " + novoPedido.toString());
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public Pedido visualizarUltimaVenda() {
        if (pedidos.isEmpty()) {
            return null;
        }
        return pedidos.get(pedidos.size() - 1);
    }
}