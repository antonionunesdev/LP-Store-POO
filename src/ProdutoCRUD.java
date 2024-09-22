import java.util.List;
import java.util.ArrayList;

public class ProdutoCRUD {
    private List<Produto> produtos;
    
    public ProdutoCRUD() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int id) {
        for (int i = produtos.size() - 1; i >= 0; i--) {
            Produto produto = produtos.get(i);
            if (produto.getId() == id) {
                produtos.remove(i);
                break;
            }
        }
    }

    public void atualizarPrecoProduto(int id, double novoPreco) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.atualizarPreco(novoPreco);
                break;
            }
        }
    }

    public void atualizarEstoqueProduto(int id, int novaQuantidadeEstoque) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.atualizarEstoque(novaQuantidadeEstoque);
                break;
            }
        }
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public List<Produto> filtrarPorCategoria(String categoria) {
        List<Produto> produtosFiltrados = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getCategoria().equals(categoria)) {
                produtosFiltrados.add(produto);
            }
        }

        return produtosFiltrados;
    }

    public List<Produto> ordenarPorPreco() {
        List<Produto> produtosOrdenados = new ArrayList<>(produtos);

        for (int i = 0; i < produtosOrdenados.size() - 1; i++) {
            for (int j = 0; j < produtosOrdenados.size() - 1 - i; j++) {
                if (produtosOrdenados.get(j).getPreco() > produtosOrdenados.get(j + 1).getPreco()) {
                    Produto temporario = produtosOrdenados.get(j);
                    produtosOrdenados.set(j, produtosOrdenados.get(j + 1));
                    produtosOrdenados.set(j + 1, temporario);
                }
            }
        }

        return produtosOrdenados;
    }
}
