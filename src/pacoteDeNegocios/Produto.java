package pacoteDeNegocios;

public class Produto extends ProdutoBase {
    private static int contadorId = 1; 
    private int quantidadeEstoque;
    private double preco;
    private final String categoria;
    private final String descricao;

    public Produto(String nome, double preco, int quantidadeEstoque, String categoria, String descricao) {
        super(contadorId++, nome); 
        this.preco = preco;
        this.categoria = categoria;
        this.quantidadeEstoque = quantidadeEstoque;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Preço: R$ " + preco + ", Categoria: " + categoria + ", Estoque: " + quantidadeEstoque + ", Descrição: " + descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public void setEstoque(int novaQuantidadeEstoque) {
        this.quantidadeEstoque = novaQuantidadeEstoque;
    }
}