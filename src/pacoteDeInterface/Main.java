package pacoteDeInterface;

import java.util.List;
import java.util.Scanner;
import pacoteDeDados.CarrinhoCRUD;
import pacoteDeDados.ClienteCRUD;
import pacoteDeDados.PedidoCRUD;
import pacoteDeDados.ProdutoCRUD;
import pacoteDeNegocios.Cliente;
import pacoteDeNegocios.Gerente;
import pacoteDeNegocios.ItemCarrinho;
import pacoteDeNegocios.Pedido;
import pacoteDeNegocios.Pessoa;
import pacoteDeNegocios.Produto;

public class Main {
    public static void main(String[] args) {
        ClienteCRUD clienteCRUD = new ClienteCRUD();
        ProdutoCRUD produtoCRUD = new ProdutoCRUD();
        CarrinhoCRUD carrinhoCRUD = new CarrinhoCRUD();
        PedidoCRUD pedidoCRUD = new PedidoCRUD();

        Pessoa ultimaPessoaLogada = null;
        Cliente clienteAtual = null;
        Gerente gerente = null;

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int quantidadeAcessosMenuPrincipal = 0;

        while (continuar) {
            if (ultimaPessoaLogada != null) {
                System.out.println("\nÚltimo usuário logado:");
                ultimaPessoaLogada.exibirDados();
            }
            else if (quantidadeAcessosMenuPrincipal > 0) {
                System.out.println("\nNenhum cliente ou gerente realizou login até o momento.");
            }

            System.out.println("\n==== Menu Principal ====");
            System.out.println("1. Acessar como Cliente");
            System.out.println("2. Cadastrar Gerente");
            System.out.println("3. Acessar como Gerente");
            System.out.println("4. Sair");
            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    boolean clienteContinuar = true;
                    while (clienteContinuar) {
                        if (clienteAtual != null) {
                            System.out.println("\nCliente logado:");
                            clienteAtual.exibirDados();
                            ultimaPessoaLogada = clienteAtual;
                        }

                        System.out.println("\n==== Menu Cliente ====");
                        System.out.println("1. Cadastrar Novo Cliente");
                        System.out.println("2. Selecionar Cliente Existente");
                        System.out.println("3. Ver Produtos");
                        System.out.println("4. Adicionar Produto ao Carrinho");
                        System.out.println("5. Remover Produto do Carrinho");
                        System.out.println("6. Ver Carrinho");
                        System.out.println("7. Filtrar Produtos por Categoria");
                        System.out.println("8. Ordenar Produtos por Preço");
                        System.out.println("9. Finalizar Compra");
                        System.out.println("10. Voltar ao Menu Principal");
                        System.out.print("\nEscolha uma opção: ");
                        int clienteOpcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (clienteOpcao) {
                            case 1:
                                System.out.print("Digite seu nome: ");
                                String nomeCliente = scanner.nextLine();
                                clienteCRUD.cadastrarCliente(nomeCliente);
                                clienteAtual = new Cliente(nomeCliente);
                                System.out.println("\nVocê se cadastrou como Cliente com sucesso! Seu ID é: " + clienteAtual.getId());
                                break;

                            case 2:
                                System.out.print("Digite o nome do cliente: ");
                                String nomeParaBuscar = scanner.nextLine();
                                clienteAtual = clienteCRUD.buscarClientePorNome(nomeParaBuscar);
                                if (clienteAtual == null) {
                                    System.out.println("\nCliente não encontrado. Tente novamente.");
                                } else {
                                    System.out.println("\nCliente selecionado: " + clienteAtual.getNome());
                                    ultimaPessoaLogada = clienteAtual;
                                }
                                break;

                            case 3:
                                List<Produto> produtos = produtoCRUD.listarProdutos();
                                if (produtos.isEmpty()) {
                                    System.out.println("\nNão há produtos disponíveis.");
                                } else {
                                    System.out.println("\n==== Lista de Produtos ====");
                                    for (Produto produto : produtos) {
                                        System.out.println(produto);
                                    }
                                }
                                break;

                            case 4:
                                System.out.print("Digite o nome do produto que deseja adicionar: ");
                                String produtoNome = scanner.nextLine();
                                System.out.print("Digite a quantidade: ");
                                int quantidade = scanner.nextInt();
                                Produto produtoSelecionado = produtoCRUD.buscarProdutoPorNome(produtoNome);
                                if (produtoSelecionado != null) {
                                    ItemCarrinho item = new ItemCarrinho(produtoSelecionado, quantidade);
                                    carrinhoCRUD.adicionarItem(item);
                                    System.out.println("\nProduto adicionado ao carrinho!");
                                } else {
                                    System.out.println("\nProduto não encontrado.");
                                }
                                break;

                            case 5:
                                System.out.print("Digite o nome do produto que deseja remover: ");
                                String produtoRemover = scanner.nextLine();
                                if (carrinhoCRUD.removerItem(produtoRemover)) {
                                    System.out.println("\nProduto removido do carrinho!");
                                } else {
                                    System.out.println("\nProduto não encontrado no carrinho.");
                                }
                                break;

                            case 6:
                                List<ItemCarrinho> itensCarrinho = carrinhoCRUD.listarItens();
                                if (itensCarrinho.isEmpty()) {
                                    System.out.println("\nO carrinho está vazio.");
                                } else {
                                    System.out.println("\n==== Itens no Carrinho ====");
                                    for (ItemCarrinho item : itensCarrinho) {
                                        System.out.println(item);
                                    }
                                    System.out.println("Total: R$ " + carrinhoCRUD.calcularTotal());
                                }
                                break;

                            case 7:
                                System.out.print("Digite a categoria para filtrar: ");
                                String categoriaFiltrar = scanner.nextLine();
                                List<Produto> produtosFiltrados = produtoCRUD.filtrarPorCategoria(categoriaFiltrar);
                                if (produtosFiltrados.isEmpty()) {
                                    System.out.println("\nNão há produtos na categoria '" + categoriaFiltrar + "'.");
                                } else {
                                    System.out.println("\n==== Produtos na Categoria '" + categoriaFiltrar + "' ====");
                                    for (Produto produto : produtosFiltrados) {
                                        System.out.println(produto);
                                    }
                                }
                                break;

                            case 8:
                                List<Produto> produtosOrdenados = produtoCRUD.ordenarPorPreco();
                                if (produtosOrdenados.isEmpty()) {
                                    System.out.println("\nNão há produtos disponíveis para ordenar.");
                                } else {
                                    System.out.println("\n==== Produtos Ordenados por Preço ====");
                                    for (Produto produto : produtosOrdenados) {
                                        System.out.println(produto);
                                    }
                                }
                                break;

                            case 9:
                                if (clienteAtual != null) {
                                    if (!carrinhoCRUD.listarItens().isEmpty()) {
                                        pedidoCRUD.criarPedido(carrinhoCRUD.getCarrinho());
                                        System.out.println("Compra finalizada por " + clienteAtual.getNome() + "! Total: R$ " + carrinhoCRUD.calcularTotal());
                                        for (ItemCarrinho item : carrinhoCRUD.listarItens()) {
                                            Produto produto = item.getProduto();
                                            int quantidadeComprada = item.getQuantidade();
                                            produtoCRUD.atualizarEstoqueProduto(produto.getId(), produto.getQuantidadeEstoque() - quantidadeComprada);
                                        }
                                        carrinhoCRUD = new CarrinhoCRUD();
                                    } else {
                                        System.out.println("\nO carrinho está vazio. Adicione produtos antes de finalizar a compra.");
                                    }
                                } else {
                                    System.out.println("\nVocê precisa estar cadastrado como cliente para finalizar a compra.");
                                }
                                break;

                            case 10:
                                clienteContinuar = false;
                                quantidadeAcessosMenuPrincipal++;
                                break;

                            default:
                                System.out.println("\nOpção inválida. Tente novamente.");
                        }
                    }
                    break;

                case 2:
                    if (gerente == null) {
                        System.out.print("Digite seu nome: ");
                        String nomeGerente = scanner.nextLine();
                        gerente = new Gerente(nomeGerente);
                        System.out.println("\nVocê se cadastrou como Gerente com sucesso! Seu ID é: " + gerente.getId());
                    } else {
                        System.out.println("\nUm gerente já foi cadastrado: " + gerente.getNome());
                    }
                    break;

                case 3:
                    if (gerente != null) {
                        boolean gerenteContinuar = true;
                        gerente.exibirDados();
                        ultimaPessoaLogada = gerente;

                        while (gerenteContinuar) {
                            System.out.println("\n==== Menu Gerente ====");
                            System.out.println("1. Cadastrar Produto");
                            System.out.println("2. Remover Produto");
                            System.out.println("3. Atualizar Preço do Produto");
                            System.out.println("4. Atualizar Estoque do Produto");
                            System.out.println("5. Listar Produtos");
                            System.out.println("6. Filtrar Produtos por Categoria");
                            System.out.println("7. Ordenar Produtos por Preço");
                            System.out.println("8. Visualizar Última Venda");
                            System.out.println("9. Voltar ao Menu Principal");
                            System.out.print("\nEscolha uma opção: ");
                            int gerenteOpcao = scanner.nextInt();
                            scanner.nextLine();

                            switch (gerenteOpcao) {
                                case 1:
                                    System.out.print("Digite o nome do produto: ");
                                    String nome = scanner.nextLine();
                                    System.out.print("Digite o preço do produto: ");
                                    double preco = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.print("Digite a categoria do produto: ");
                                    String categoria = scanner.nextLine();
                                    System.out.print("Digite o estoque do produto: ");
                                    int quantidadeEstoque = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Digite a descrição do produto: ");
                                    String descricao = scanner.nextLine();
                                    Produto novoProduto = new Produto(nome, preco, quantidadeEstoque, categoria, descricao);
                                    produtoCRUD.cadastrarProduto(novoProduto);
                                    System.out.println("\nProduto cadastrado com sucesso!");
                                    break;

                                case 2:
                                    System.out.print("Digite o ID do produto a ser removido: ");
                                    int idRemover = scanner.nextInt();
                                    if (produtoCRUD.removerProduto(idRemover)) {
                                        System.out.println("\nProduto removido com sucesso!");
                                    } else {
                                        System.out.println("\nProduto não encontrado.");
                                    }
                                    break;

                                case 3:
                                    System.out.print("Digite o ID do produto para atualizar o seu preço: ");
                                    int idPreco = scanner.nextInt();

                                    Produto produtoExistentePreco = produtoCRUD.buscarProdutoPorId(idPreco);
                                    if (produtoExistentePreco != null) {
                                        System.out.print("Digite o novo preço do produto: ");
                                        double novoPreco = scanner.nextDouble();
                                        produtoCRUD.atualizarPrecoProduto(idPreco, novoPreco);
                                        System.out.println("\nPreço atualizado com sucesso!");
                                    } else {
                                        System.out.println("\nProduto não encontrado.");
                                    }
                                    break;

                                case 4:
                                    System.out.print("Digite o ID do produto para atualizar o seu estoque: ");
                                    int idEstoque = scanner.nextInt();

                                    Produto produtoExistenteEstoque = produtoCRUD.buscarProdutoPorId(idEstoque);
                                    if (produtoExistenteEstoque != null) {
                                        System.out.print("Digite a nova quantidade em estoque: ");
                                        int novaQuantidadeEstoque = scanner.nextInt();
                                        produtoCRUD.atualizarEstoqueProduto(idEstoque, novaQuantidadeEstoque);
                                        System.out.println("\nEstoque atualizado com sucesso!");
                                    } else {
                                        System.out.println("\nProduto não encontrado.");
                                    }
                                    break;

                                case 5:
                                    List<Produto> produtos = produtoCRUD.listarProdutos();
                                    if (produtos.isEmpty()) {
                                        System.out.println("\nNão há produtos cadastrados.");
                                    } else {
                                        System.out.println("\n==== Lista de Produtos ====");
                                        for (Produto produto : produtos) {
                                            System.out.println(produto);
                                        }
                                    }
                                    break;

                                case 6:
                                    System.out.print("Digite a categoria para filtrar: ");
                                    String categoriaFiltrar = scanner.nextLine();
                                    List<Produto> produtosFiltrados = produtoCRUD.filtrarPorCategoria(categoriaFiltrar);
                                    if (produtosFiltrados.isEmpty()) {
                                        System.out.println("\nNão há produtos na categoria '" + categoriaFiltrar + "'.");
                                    } else {
                                        System.out.println("\n==== Produtos na Categoria '" + categoriaFiltrar + "' ====");
                                        for (Produto produto : produtosFiltrados) {
                                            System.out.println(produto);
                                        }
                                    }
                                    break;

                                case 7:
                                    List<Produto> produtosOrdenados = produtoCRUD.ordenarPorPreco();
                                    if (produtosOrdenados.isEmpty()) {
                                        System.out.println("\nNão há produtos disponíveis para ordenar.");
                                    } else {
                                        System.out.println("\n==== Produtos Ordenados por Preço ====");
                                        for (Produto produto : produtosOrdenados) {
                                            System.out.println(produto);
                                        }
                                    }
                                    break;

                                case 8:
                                    Pedido ultimaVenda = pedidoCRUD.visualizarUltimaVenda();
                                    if (ultimaVenda == null) {
                                        System.out.println("\nAinda não foram realizadas vendas.");
                                    } else {
                                        System.out.println("\n==== Última Venda Realizada ====");
                                        System.out.println(ultimaVenda);
                                    }
                                    break;

                                case 9:
                                    gerenteContinuar = false;
                                    quantidadeAcessosMenuPrincipal++;
                                    break;

                                default:
                                    System.out.println("\nOpção inválida. Tente novamente.");
                            }
                        }
                    } else {
                        System.out.println("\nNenhum gerente cadastrado. Cadastre um gerente primeiro.");
                    }
                    break;

                case 4:
                    continuar = false;
                    System.out.println("\nObrigado por usar nosso sistema! :)");
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
