package pacoteDeNegocios;

import java.util.List;

public class Compra {
    protected List<ItemCarrinho> itens;
    protected double valorTotal;

    public Compra(List<ItemCarrinho> itens) {
        this.itens = itens;
        this.valorTotal = 0.0;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}