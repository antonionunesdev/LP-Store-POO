public class Produto {
    private static int contadorId = 1;
    private int id;
    private int quantidadeEstoque;
    private double preco;
    private String nome;
    private String descricao;
    private String categoria;

    public Produto(String nome, double preco, int quantidadeEstoque, String categoria, String descricao) {
        this.id = contadorId++;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidadeEstoque = quantidadeEstoque;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ID do Produto: " + id + ", Nome: " + nome + ", Preço: R$ " + preco +
                ", Categoria: " + categoria + ", Estoque: " + quantidadeEstoque +
                ", Descrição: " + descricao;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
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