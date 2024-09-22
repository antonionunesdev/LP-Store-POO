import java.util.ArrayList;
import java.util.List;

public class PedidoCRUD {
    private List<Pedido> pedidos; // Lista de pedidos

    // Construtor para inicializar a lista de pedidos
    public PedidoCRUD() {
        this.pedidos = new ArrayList<>();
    }

    // Método para criar um pedido a partir de um carrinho de compras
    public void criarPedido(Carrinho carrinho) {
        // Gera um novo ID para o pedido
        int novoId = pedidos.size() + 1;
        Pedido novoPedido = new Pedido(novoId, carrinho.getItens(), carrinho.getTotal());
        pedidos.add(novoPedido); // Adiciona o pedido à lista
    }

    // Método para listar todos os pedidos
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    // Método para visualizar a última venda (último pedido)
    public Pedido visualizarUltimaVenda() {
        if (pedidos.isEmpty()) {
            return null; // Se não há pedidos, retorna null
        }
        return pedidos.get(pedidos.size() - 1); // Retorna o último pedido
    }
}