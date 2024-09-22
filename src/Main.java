import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProdutoCRUD produtoCRUD = new ProdutoCRUD();  // Cria uma instância de ProdutoCRUD
        Scanner scanner = new Scanner(System.in);
        
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n==== Menu Principal ====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Atualizar Preço do Produto");
            System.out.println("4. Atualizar Estoque do Produto");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Filtrar Produtos por Categoria");
            System.out.println("7. Ordenar Produtos por Preço");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Cadastrar Produto
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();  // Consumir nova linha
                    System.out.print("Digite a categoria do produto: ");
                    String categoria = scanner.nextLine();
                    
                    Produto novoProduto = new Produto(nome, preco, categoria);
                    produtoCRUD.cadastrarProduto(novoProduto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    // Remover Produto
                    System.out.print("Digite o ID do produto a ser removido: ");
                    int idRemover = scanner.nextInt();
                    produtoCRUD.removerProduto(idRemover);
                    System.out.println("Produto removido com sucesso!");
                    break;

                case 3:
                    // Atualizar Preço do Produto
                    System.out.print("Digite o ID do produto para atualizar o preço: ");
                    int idPreco = scanner.nextInt();
                    System.out.print("Digite o novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    produtoCRUD.atualizarPrecoProduto(idPreco, novoPreco);
                    System.out.println("Preço atualizado com sucesso!");
                    break;

                case 4:
                    // Atualizar Estoque do Produto
                    System.out.print("Digite o ID do produto para atualizar o estoque: ");
                    int idEstoque = scanner.nextInt();
                    System.out.print("Digite a nova quantidade em estoque: ");
                    int novaQuantidadeEstoque = scanner.nextInt();
                    produtoCRUD.atualizarEstoqueProduto(idEstoque, novaQuantidadeEstoque);
                    System.out.println("Estoque atualizado com sucesso!");
                    break;

                case 5:
                    // Listar Produtos
                    List<Produto> produtos = produtoCRUD.listarProdutos();
                    System.out.println("==== Lista de Produtos ====");
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }
                    break;

                case 6:
                    // Filtrar Produtos por Categoria
                    System.out.print("Digite a categoria para filtrar: ");
                    String categoriaFiltrar = scanner.nextLine();
                    List<Produto> produtosFiltrados = produtoCRUD.filtrarPorCategoria(categoriaFiltrar);
                    System.out.println("==== Produtos na Categoria '" + categoriaFiltrar + "' ====");
                    for (Produto produto : produtosFiltrados) {
                        System.out.println(produto);
                    }
                    break;

                case 7:
                    // Ordenar Produtos por Preço
                    List<Produto> produtosOrdenados = produtoCRUD.ordenarPorPreco();
                    System.out.println("==== Produtos Ordenados por Preço ====");
                    for (Produto produto : produtosOrdenados) {
                        System.out.println(produto);
                    }
                    break;

                case 8:
                    // Sair
                    continuar = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}

