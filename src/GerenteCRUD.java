import java.util.List;

public class GerenteCRUD {
    private ProdutoCRUD produtoCRUD;
    private PedidoCRUD pedidoCRUD;

    // Construtor que recebe instâncias de ProdutoCRUD e PedidoCRUD
    public GerenteCRUD(ProdutoCRUD produtoCRUD, PedidoCRUD pedidoCRUD) {
        this.produtoCRUD = produtoCRUD;
        this.pedidoCRUD = pedidoCRUD;
    }

    // Método para visualizar o inventário de produtos
    public List<Produto> visualizarInventario() {
        return produtoCRUD.listarProdutos();  // Usa ProdutoCRUD para listar todos os produtos
    }

    // Método para visualizar a última venda (último pedido)
    public Pedido visualizarUltimaVenda() {
        return pedidoCRUD.visualizarUltimaVenda();  // Usa PedidoCRUD para obter o último pedido
    }
}