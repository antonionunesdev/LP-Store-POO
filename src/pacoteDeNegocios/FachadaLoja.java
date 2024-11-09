package pacoteDeNegocios;

import java.util.List;
import pacoteDeDados.CarrinhoCRUD;
import pacoteDeDados.ClienteCRUD;
import pacoteDeDados.PedidoCRUD;
import pacoteDeDados.ProdutoCRUD;

public class FachadaLoja {
    private final ClienteCRUD clienteCRUD;
    private final ProdutoCRUD produtoCRUD;
    private CarrinhoCRUD carrinhoCRUD;
    private final PedidoCRUD pedidoCRUD;

    public FachadaLoja() {
        this.produtoCRUD = new ProdutoCRUD();
        this.carrinhoCRUD = new CarrinhoCRUD();
        this.clienteCRUD = new ClienteCRUD();
        this.pedidoCRUD = new PedidoCRUD();
    }

    // Operações relacionadas ao cliente
    public Cliente cadastrarCliente(String nome) {
        clienteCRUD.cadastrarCliente(nome);
        return clienteCRUD.listarClientes().get(clienteCRUD.listarClientes().size() - 1);
    }

    public Cliente buscarClientePorId(int id) {
        return clienteCRUD.buscarClientePorId(id);
    }

    // Operações relacionadas ao produto
    public void cadastrarProduto(Produto produto) {
        produtoCRUD.cadastrarProduto(produto);
    }

    public String removerProduto(int idProduto) {
        return produtoCRUD.removerProduto((idProduto));
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtoCRUD.buscarProdutoPorNome(nome);
    }

    public Produto buscarProdutoPorId(int id) {
        return produtoCRUD.buscarProdutoPorId(id);
    }

    public String atualizarPrecoProduto(int idProduto, double novoPreco) {
        Produto produto = buscarProdutoPorId(idProduto);
        if (produto == null) {
            return "\nProduto não encontrado.";
        }
        produtoCRUD.atualizarPrecoProduto(idProduto, novoPreco);
        return "\nPreço atualizado com sucesso!";
    }

    public String atualizarEstoqueProduto(int idProduto, int novaQuantidadeEstoque) {
        Produto produto = buscarProdutoPorId(idProduto);
        if (produto == null) {
            return "\nProduto não encontrado.";
        }
        produtoCRUD.atualizarEstoqueProduto(idProduto, novaQuantidadeEstoque);
        return "\nEstoque atualizado com sucesso!";
    }

    public String filtrarPorCategoria(String categoria) {
        List<Produto> produtosFiltrados = produtoCRUD.filtrarPorCategoria(categoria);
        
        if (produtosFiltrados.isEmpty()) {
            return "\nNão há produtos na categoria '" + categoria + "'.";
        }
        
        StringBuilder resultado = new StringBuilder("\n==== Produtos na Categoria '" + categoria + "' ====\n");
        for (Produto produto : produtosFiltrados) {
            resultado.append(produto).append("\n");
        }
        return resultado.toString();
    }

    public String ordenarPorPreco() {
        List<Produto> produtos = produtoCRUD.ordenarPorPreco();
        
        if (produtos.isEmpty()) {
            return "\nNão há produtos disponíveis para ordenar.";
        }
        
        StringBuilder produtosOrdenados = new StringBuilder("\n==== Produtos Ordenados por Preço ====\n");
        for (Produto produto : produtos) {
            produtosOrdenados.append(produto).append("\n");
        }
        return produtosOrdenados.toString();
    }

    public List<Produto> listarProdutos() {
        return produtoCRUD.listarProdutos();
    }

    public String exibirProdutos() {
        List<Produto> produtos = listarProdutos();
        if (produtos.isEmpty()) {
            return "\nNão há produtos disponíveis.";
        } else {
            StringBuilder resultado = new StringBuilder("\n==== Lista de Produtos ====\n");
            for (Produto produto : produtos) {
                resultado.append(produto).append("\n");
            }
            return resultado.toString();
        }        
    }

    public void finalizarCompra(Cliente clienteAtual) throws Exception {
        if (listarItens().isEmpty()) {
            throw new Exception("\nO carrinho está vazio. Adicione produtos antes de finalizar a compra.");
        } else {
            Pedido novoPedido = criarPedido();
            System.out.println("Pedido criado:\n" + novoPedido);
            System.out.println("Compra finalizada por " + clienteAtual.getNome() + ". Total: R$ " + calcularTotal());
            for (ItemCarrinho item : listarItens()) {
                Produto produto = item.getProduto();
                int quantidadeComprada = item.getQuantidade();
                produtoCRUD.atualizarEstoqueProduto(produto.getId(), produto.getQuantidadeEstoque() - quantidadeComprada);
            }
            carrinhoCRUD = new CarrinhoCRUD();
        }
    }

    // Operações relacionadas ao carrinho
    public String adicionarItem(String nomeProduto, int quantidade) {
        Produto produto = produtoCRUD.buscarProdutoPorNome(nomeProduto);
        if (produto == null) {
            return "\nProduto não encontrado.";
        } else {
            ItemCarrinho item = new ItemCarrinho(produto, quantidade);
            carrinhoCRUD.adicionarItem(item);
            return "\nProduto adicionado ao carrinho!";
        }
    }

    public String removerItem(String nomeProduto) {
        if (carrinhoCRUD.removerItem(nomeProduto)) {
            return "\nProduto removido do carrinho!";
        } else {
            return "\nProduto não encontrado no carrinho.";
        }
    }

    public double calcularTotal() {
        return carrinhoCRUD.calcularTotal();
    }

    public List<ItemCarrinho> listarItens() {
        return carrinhoCRUD.listarItens();
    }

    public String exibirItensCarrinho() {
        List<ItemCarrinho> itensCarrinho = carrinhoCRUD.listarItens();
        
        if (itensCarrinho.isEmpty()) {
            return "\nO carrinho está vazio.";
        }
        
        StringBuilder resultado = new StringBuilder("\n==== Itens no Carrinho ====\n");
        for (ItemCarrinho item : itensCarrinho) {
            resultado.append(item).append("\n");
        }
        resultado.append("Total: R$ ").append(carrinhoCRUD.calcularTotal());
        return resultado.toString();
    }

    // Operações relacionadas ao pedido
    public Pedido criarPedido() {
        return pedidoCRUD.criarPedido(carrinhoCRUD.getCarrinho());
    }

    public String visualizarUltimaVenda() {
        Pedido ultimaVenda = pedidoCRUD.visualizarUltimaVenda();
        if (ultimaVenda == null) {
            return "\nAinda não foram realizadas vendas.";
        }
        return "\n==== Última Venda Realizada ====\n" + ultimaVenda;
    }

    public String listarVendasRealizadas() {
        List<Pedido> vendasRealizadas = pedidoCRUD.listarPedidos();
        
        if (vendasRealizadas.isEmpty()) {
            return "\nAinda não foram realizadas vendas.";
        }

        StringBuilder resultado = new StringBuilder("\n==== Vendas Efetuadas ====\n");
        for (Pedido pedido : vendasRealizadas) {
            resultado.append(pedido);
        }
        return resultado.toString();
    }
}