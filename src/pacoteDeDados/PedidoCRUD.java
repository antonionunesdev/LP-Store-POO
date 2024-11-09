package pacoteDeDados;

import java.util.ArrayList;
import java.util.List;
import pacoteDeNegocios.Carrinho;
import pacoteDeNegocios.Pedido;

public class PedidoCRUD {
    private final List<Pedido> pedidos;

    public PedidoCRUD() {
        this.pedidos = new ArrayList<>();
    }

    public Pedido criarPedido(Carrinho carrinho) {
        int novoId = pedidos.size() + 1;
        Pedido novoPedido = new Pedido(novoId, carrinho.getItens(), carrinho.getValorTotal());
        pedidos.add(novoPedido);
        return novoPedido;
    }

    public Pedido visualizarUltimaVenda() {
        if (pedidos.isEmpty()) {
            return null;
        }
        return pedidos.get(pedidos.size() - 1);
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}