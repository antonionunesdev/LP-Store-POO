import java.util.ArrayList;
import java.util.List;

public class CarrinhoCRUD {
    private Carrinho carrinho;  // Carrinho de compras

    // Construtor para inicializar o carrinho
    public CarrinhoCRUD() {
        this.carrinho = new Carrinho(new ArrayList<>()); // Carrinho começa vazio
    }

    // Método para adicionar um item ao carrinho
    public void adicionarItem(ItemCarrinho item) {
        carrinho.getItens().add(item);  // Adiciona o item à lista de itens no carrinho
        calcularTotal();  // Atualiza o total após adicionar o item
    }

    // Método para remover um item do carrinho por produtoId
    public void removerItem(int produtoId) {
        List<ItemCarrinho> itens = carrinho.getItens();
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().getId() == produtoId) {
                itens.remove(i);  // Remove o item correspondente ao produtoId
                break;
            }
        }
        calcularTotal();  // Atualiza o total após remover o item
    }

    // Método para listar todos os itens do carrinho
    public List<ItemCarrinho> listarItens() {
        return carrinho.getItens();  // Retorna a lista de itens no carrinho
    }

    // Método para calcular o total do carrinho
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : carrinho.getItens()) {
            total += item.getSubtotal();  // Soma os subtotais de cada item
        }
        carrinho.setTotal(total);  // Atualiza o total no carrinho
        return total;
    }
}
