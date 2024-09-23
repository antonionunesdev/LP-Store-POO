import java.util.ArrayList;
import java.util.List;

public class CarrinhoCRUD {
    private Carrinho carrinho;  

    public CarrinhoCRUD() {
        this.carrinho = new Carrinho(new ArrayList<>()); 
    }

    public void adicionarItem(ItemCarrinho item) {
        carrinho.getItens().add(item);  
        calcularTotal();  
    }
 
    public void removerItem(String produtoNome) {
        List<ItemCarrinho> itens = carrinho.getItens();
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().getNome().equals(produtoNome)) {
                itens.remove(i); 
                break;
            }
        }
        calcularTotal();  
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public List<ItemCarrinho> listarItens() {
        return carrinho.getItens();  
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : carrinho.getItens()) {
            total += item.getSubtotal();  
        }
        carrinho.setTotal(total);  
        return total;
    }
}