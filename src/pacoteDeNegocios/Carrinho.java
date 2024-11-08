package pacoteDeNegocios;

import java.util.List;

public class Carrinho extends Compra {

    public Carrinho(List<ItemCarrinho> itens) {
        super(itens); // chama o construtor de Compra
    }
}
