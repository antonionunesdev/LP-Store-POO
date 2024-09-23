import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProdutoCRUD produtoCRUD = new ProdutoCRUD();  
        CarrinhoCRUD carrinhoCRUD = new CarrinhoCRUD(); 

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n==== Menu Principal ====");
            System.out.println("1. Acessar como Cliente");
            System.out.println("2. Acessar como Gerente");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    // Menu do Cliente
                    boolean clienteContinuar = true;
                    while (clienteContinuar) {
                        System.out.println("\n==== Menu Cliente ====");
                        System.out.println("1. Me cadastrar");
                        System.out.println("2. Ver Produtos");
                        System.out.println("3. Adicionar Produto ao Carrinho");
                        System.out.println("4. Ver Carrinho");
                        System.out.println("5. Finalizar Compra");
                        System.out.println("6. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        int clienteOpcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (clienteOpcao) {
                            case 1:
                            	//cadastrarcliente
                            	  System.out.print("Seu nome: ");
                                  String nome = scanner.nextLine();
                                  Cliente cliente = new Cliente(1, nome);  
                            	break;
                            case 2:
                                // Ver produtos
                                List<Produto> produtos = produtoCRUD.listarProdutos();
                                System.out.println("==== Lista de Produtos ====");
                                for (Produto produto : produtos) {
                                    System.out.println(produto);
                                }
                                break;
                            case 3:
                                // Adicionar produto ao carrinho
                                System.out.print("Digite o nome do produto que deseja adicionar: ");
                                String produtoNome = scanner.nextLine();
                                System.out.print("Digite a quantidade: ");
                                int quantidade = scanner.nextInt();
                                Produto produtoSelecionado = produtoCRUD.buscarProdutoPorNome(produtoNome);  // Método para buscar produto
                                if (produtoSelecionado != null) {
                                    ItemCarrinho item = new ItemCarrinho(produtoSelecionado, quantidade);
                                    carrinhoCRUD.adicionarItem(item);
                                    System.out.println("Produto adicionado ao carrinho!");
                                } else {
                                    System.out.println("Produto não encontrado.");
                                }
                                break;
                            case 4:
                                // Ver carrinho
                                List<ItemCarrinho> itensCarrinho = carrinhoCRUD.listarItens();
                                System.out.println("==== Itens no Carrinho ====");
                                for (ItemCarrinho item : itensCarrinho) {
                                    System.out.println(item);
                                }
                                System.out.println("Total: " + carrinhoCRUD.calcularTotal());
                                break;
                            case 5:
                                // Finalizar compra
                                System.out.println("Compra finalizada! Total: " + carrinhoCRUD.calcularTotal());
                                carrinhoCRUD = new CarrinhoCRUD();  // Limpar carrinho após finalizar a compra
                                break;
                            case 6:
                                clienteContinuar = false;
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                    break;
                    
                case 2:
                    // Menu do Gerente
                    boolean gerenteContinuar = true;
                    while (gerenteContinuar) {
                        System.out.println("\n==== Menu Gerente ====");
                        System.out.println("1. Cadastrar Produto");
                        System.out.println("2. Remover Produto");
                        System.out.println("3. Atualizar Preço do Produto");
                        System.out.println("4. Atualizar Estoque do Produto");
                        System.out.println("5. Listar Produtos");
                        System.out.println("6. Filtrar Produtos por Categoria");
                        System.out.println("7. Ordenar Produtos por Preço");
                        System.out.println("8. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        int gerenteOpcao = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha

                        switch (gerenteOpcao) {
                            case 1:
                                // Cadastrar Produto
                                System.out.print("Digite o nome do produto: ");
                                String nome = scanner.nextLine();
                                System.out.print("Digite o preço do produto: ");
                                double preco = scanner.nextDouble();
                                scanner.nextLine();  // Consumir nova linha
                                System.out.print("Digite a categoria do produto: ");
                                String categoria = scanner.nextLine();
                                System.out.print("Digite o estoque do produto: ");
                                int quantidadeEstoque = scanner.nextInt();
                                scanner.nextLine();  // Consumir nova linha
                                System.out.print("Digite a descrição do produto: ");
                                String descricao = scanner.nextLine();
                                Produto novoProduto = new Produto(nome, preco, quantidadeEstoque, categoria, descricao);
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
                                gerenteContinuar = false;
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                    break;

                case 3:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
