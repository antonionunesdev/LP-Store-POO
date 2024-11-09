package pacoteDeDados;

import java.util.ArrayList;
import java.util.List;
import pacoteDeNegocios.Carrinho;
import pacoteDeNegocios.ItemCarrinho;

public class CarrinhoCRUD {
    private final Carrinho carrinho;

    public CarrinhoCRUD() {
        this.carrinho = new Carrinho(new ArrayList<>());
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void adicionarItem(ItemCarrinho item) {
        carrinho.getItens().add(item);
        calcularTotal();
    }

    public boolean removerItem(String produtoNome) {
        List<ItemCarrinho> itens = carrinho.getItens();
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().getNome().equals(produtoNome)) {
                itens.remove(i);
                calcularTotal();
                return true;
            }
        }
        return false;
    }

    /* 
    public boolean verificarItem(String produtoNome) {
        for (ItemCarrinho item : carrinho.getItens()) {
            if (item.getProduto().getNome().equals(produtoNome)) {
                return true;
            }
        }
        return false;
    }
    */

    public List<ItemCarrinho> listarItens() {
        return carrinho.getItens();
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : carrinho.getItens()) {
            total += item.getSubtotal();
        }
        carrinho.setValorTotal(total);
        return total;
    }
}