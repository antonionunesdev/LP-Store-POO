package pacoteDeInterface;

import java.util.InputMismatchException;
import java.util.Scanner;
import pacoteDeNegocios.Cliente;
import pacoteDeNegocios.FachadaLoja;
import pacoteDeNegocios.Gerente;
import pacoteDeNegocios.Pessoa;
import pacoteDeNegocios.Produto;

public class Main {
    public static void main(String[] args) {
        FachadaLoja fachadaLoja = new FachadaLoja();

        Pessoa ultimaPessoaLogada = null;
        Cliente clienteAtual;
        Gerente gerente = null;

        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;
            int quantidadeAcessosMenuPrincipal = 0;

            System.out.println(" (    (      (              )  (        ");
            System.out.println(" )\\ ) )\\ )   )\\ )  *   ) ( /(  )\\ )     ");
            System.out.println("(()/((()/(  (()/(` )  /( )\\())(()/((    ");
            System.out.println(" /(_))/(_))  /(_))( )(_)|(_)\\  /(_))\\   ");
            System.out.println("(_)) (_))   (_)) (_(_())  ((_)(_))((_)  ");
            System.out.println("| |  | _ \\  / __||_   _| / _ \\| _ \\ __| ");
            System.out.println("| |__|  _/  \\__ \\  | |  | (_) |   / _|  ");
            System.out.println("|____|_|    |___/  |_|   \\___/|_|_\\___  ");

            while (continuar) {
                if (ultimaPessoaLogada != null && quantidadeAcessosMenuPrincipal > 0) {
                    System.out.println("\nÚltimo usuário logado:");
                    System.out.println(ultimaPessoaLogada.exibirDados());
                }

                System.out.println("\n==== Menu Principal ====");
                System.out.println("1. Cadastrar Novo Cliente");
                System.out.println("2. Selecionar Cliente Existente");
                System.out.println("3. Cadastrar Gerente");
                System.out.println("4. Acessar como Gerente");
                System.out.println("5. Sair");
                int opcao = -1;
                boolean opcaoValida = false;

                while (!opcaoValida) {
                    try {
                        System.out.print("\nEscolha uma opção: ");
                        opcao = scanner.nextInt();
                        scanner.nextLine();
                        opcaoValida = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Opção inválida. Por gentileza, digite um número de 1 a 5.");
                        scanner.nextLine();
                    }
                }

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite seu nome: ");
                        String nomeCliente = scanner.nextLine();
                        System.out.print("Digite sua senha: ");
                        String senhaCliente = scanner.nextLine();

                        clienteAtual = fachadaLoja.cadastrarCliente(nomeCliente, senhaCliente);
                        System.out.println("\nVocê se cadastrou como Cliente com sucesso! Seu ID é: " + clienteAtual.getId());
                    }

                    case 2 -> {
                        try {
                            System.out.print("Digite o nome do cliente: ");
                            String nomeParaBuscar = scanner.nextLine();
                            int idParaBuscar = -1;
                            boolean idValido = false;

                            while (!idValido) {
                                try {
                                    System.out.print("Digite o ID do cliente: ");
                                    idParaBuscar = scanner.nextInt();
                                    scanner.nextLine();
                                    idValido = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("ID inválido. Por gentileza, digite um número inteiro.");
                                    scanner.nextLine();
                                }
                            }
                            
                            clienteAtual = fachadaLoja.buscarClientePorId(idParaBuscar);

                            if (clienteAtual == null || !clienteAtual.getNome().equalsIgnoreCase(nomeParaBuscar)) {
                                throw new Exception("Cliente não encontrado. Tente novamente.");
                            } else {
                                System.out.print("Digite sua senha: ");
                                String senha = scanner.nextLine();

                                if (clienteAtual.validarSenha(senha)) {
                                    ultimaPessoaLogada = clienteAtual;
                                    System.out.println("\nLogin efetuado com sucesso!");
                                    System.out.println("Cliente selecionado: " + clienteAtual.getNome() + ", ID: " + clienteAtual.getId());

                                    boolean clienteContinuar = true;
                                    while (clienteContinuar) {
                                        System.out.println("\n==== Menu Cliente ====");
                                        System.out.println("1. Listar Produtos");
                                        System.out.println("2. Adicionar Produto ao Carrinho");
                                        System.out.println("3. Remover Produto do Carrinho");
                                        System.out.println("4. Ver Carrinho");
                                        System.out.println("5. Filtrar Produtos por Categoria");
                                        System.out.println("6. Ordenar Produtos por Preço");
                                        System.out.println("7. Finalizar Compra");
                                        System.out.println("8. Voltar ao Menu Principal");
                                        int clienteOpcao = -1;
                                        boolean clienteOpcaoValida = false;

                                        while (!clienteOpcaoValida) {
                                            try {
                                                System.out.print("\nEscolha uma opção: ");
                                                clienteOpcao = scanner.nextInt();
                                                scanner.nextLine();
                                                clienteOpcaoValida = true;
                                            } catch (InputMismatchException e) {
                                                System.out.println("Opção inválida. Por gentileza, digite um número de 1 a 8.");
                                                scanner.nextLine();
                                            }
                                        }

                                        switch (clienteOpcao) {
                                            case 1 -> {
                                                System.out.println(fachadaLoja.exibirProdutos());
                                            }

                                            case 2 -> {
                                                    System.out.print("Digite o nome do produto que deseja adicionar: ");
                                                    String nomeProduto = scanner.nextLine();
                                                    int quantidade = -1;
                                                    boolean quantidadeValida = false;

                                                    while (!quantidadeValida) {
                                                        try {
                                                            System.out.print("Digite a quantidade: ");
                                                            quantidade = scanner.nextInt();
                                                            scanner.nextLine();
                                                            quantidadeValida = true;
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("Quantidade inválida. Por favor, digite um número inteiro.");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                            
                                                    System.out.println(fachadaLoja.adicionarItem(nomeProduto, quantidade));
                                            }

                                            case 3 -> {
                                                System.out.print("Digite o nome do produto que deseja remover: ");
                                                String nomeProduto = scanner.nextLine();
                                                System.out.println(fachadaLoja.removerItem(nomeProduto));
                                            }

                                            case 4 -> {
                                                System.out.println(fachadaLoja.exibirItensCarrinho());
                                            }

                                            case 5 -> {
                                                System.out.print("Digite a categoria para filtrar: ");
                                                String nomeCategoria = scanner.nextLine();
                                                System.out.println(fachadaLoja.filtrarPorCategoria(nomeCategoria));
                                            }

                                            case 6 -> {
                                                System.out.println(fachadaLoja.ordenarPorPreco());
                                            }

                                            case 7 -> {
                                                try {
                                                    fachadaLoja.finalizarCompra(clienteAtual);
                                                } catch (Exception erro) {
                                                    System.out.println(erro.getMessage());
                                                }
                                            }

                                            case 8 -> {
                                                clienteContinuar = false;
                                                quantidadeAcessosMenuPrincipal++;
                                            }

                                            default ->
                                                System.out.println("\nOpção inválida. Tente novamente.");
                                        }
                                    }
                                } else {
                                    throw new Exception("Senha incorreta. Tente novamente.");
                                }
                            }
                        } catch (Exception erro) {
                            System.out.println(erro.getMessage());
                        }
                    }

                    case 3 -> {
                        if (gerente == null) {
                            System.out.print("Digite seu nome: ");
                            String nomeGerente = scanner.nextLine();
                            System.out.print("Digite a senha do gerente: ");
                            String senhaGerente = scanner.nextLine();
                            gerente = new Gerente(nomeGerente, senhaGerente);
                    
                            System.out.println("\nVocê se cadastrou como Gerente com sucesso! Seu ID é: " + gerente.getId());
                        } else {
                            System.out.println("\nUm gerente já foi cadastrado: " + gerente.getNome());
                        }
                    }

                    case 4 -> {
                        if (gerente != null) {
                            System.out.print("Digite a senha do gerente: ");
                            String senha = scanner.nextLine();

                            if (gerente.validarSenha(senha)) {
                                boolean gerenteContinuar = true;
                                System.out.println("\nLogin efetuado com sucesso!");
                                System.out.println("Seja bem-vindo, gerente " + gerente.getNome() + ".");
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
                                    System.out.println("9. Visualizar Todas Vendas");
                                    System.out.println("10. Voltar ao Menu Principal");
                                    int gerenteOpcao = -1;
                                    boolean gerenteOpcaoValida = false;

                                    while (!gerenteOpcaoValida) {
                                        try {
                                            System.out.print("\nEscolha uma opção: ");
                                            gerenteOpcao = scanner.nextInt();
                                            scanner.nextLine();
                                            gerenteOpcaoValida = true;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Opção inválida. Por gentileza, digite um número de 1 a 10.");
                                            scanner.nextLine();
                                        }
                                    }

                                    switch (gerenteOpcao) {
                                        case 1 -> {
                                            System.out.print("Digite o nome do produto: ");
                                            String nome = scanner.nextLine();

                                            double preco = -1;
                                            boolean precoValido = false;

                                            while (!precoValido) {
                                                try {
                                                    System.out.print("Digite o preço do produto: ");
                                                    preco = scanner.nextDouble();
                                                    scanner.nextLine();
                                                    precoValido = true;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Preço inválido. Por gentileza, digite um número inteiro ou decimal.");
                                                    scanner.nextLine();
                                                }
                                            }
                                            
                                            System.out.print("Digite a categoria do produto: ");
                                            String categoria = scanner.nextLine();

                                            int quantidadeEstoque = -1;
                                            boolean quantidadeEstoqueValida = false;

                                            while (!quantidadeEstoqueValida) {
                                                try {
                                                    System.out.print("Digite o estoque do produto: ");
                                                    quantidadeEstoque = scanner.nextInt();
                                                    scanner.nextLine();
                                                    quantidadeEstoqueValida = true;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Quantidade inválida. Por gentileza, digite um número inteiro.");
                                                    scanner.nextLine();
                                                }
                                            }
                                            
                                            System.out.print("Digite a descrição do produto: ");
                                            String descricao = scanner.nextLine();

                                            Produto novoProduto = new Produto(nome, preco, quantidadeEstoque, categoria, descricao);
                                            fachadaLoja.cadastrarProduto(novoProduto);

                                            System.out.println("\nProduto cadastrado com sucesso!");
                                            System.out.println("O ID do novo produto é: " + novoProduto.getId());
                                        }

                                        case 2 -> {
                                            int idProduto = -1;
                                            boolean idProdutoValido = false;

                                            while (!idProdutoValido) {
                                                try {
                                                    System.out.print("Digite o ID do produto a ser removido: ");
                                                    idProduto = scanner.nextInt();
                                                    scanner.nextLine();
                                                    idProdutoValido = true;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("ID inválido. Por gentileza, digite um número inteiro.");
                                                    scanner.nextLine();
                                                }
                                            }
                                            System.out.println(fachadaLoja.removerProduto(idProduto));
                                        }

                                        case 3 -> {
                                            int idProduto = -1;
                                            boolean idProdutoValido = false;

                                            while (!idProdutoValido) {
                                                try {
                                                    System.out.print("Digite o ID do produto para atualizar o seu preço: ");
                                                    idProduto = scanner.nextInt();
                                                    scanner.nextLine();
                                                    idProdutoValido = true;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("ID inválido. Por gentileza, digite um número inteiro.");
                                                    scanner.nextLine();
                                                }
                                            }
                                            
                                            double novoPreco = -1;
                                            boolean novoPrecoValido = false;

                                            while (!novoPrecoValido) {
                                                try {
                                                    System.out.print("Digite o novo preço do produto: ");
                                                    novoPreco = scanner.nextDouble();
                                                    scanner.nextLine();
                                                    novoPrecoValido = true;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Novo preço inválido. Por gentileza, digite um número inteiro.");
                                                    scanner.nextLine();
                                                }
                                            }
                                            System.out.println(fachadaLoja.atualizarPrecoProduto(idProduto, novoPreco));
                                        }

                                        case 4 -> {
                                            int idProduto = -1;
                                            boolean idProdutoValido = false;

                                            while (!idProdutoValido) {
                                                try {
                                                    System.out.print("Digite o ID do produto para atualizar o seu estoque: ");
                                                    idProduto = scanner.nextInt();
                                                    scanner.nextLine();
                                                    idProdutoValido = true;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("ID inválido. Por gentileza, digite um número inteiro ou decimal.");
                                                    scanner.nextLine();
                                                }
                                            }
                                            
                                            int novaQuantidadeEstoque = -1;
                                            boolean novaQuantidadeEstoqueInvalida = false;

                                            while (!novaQuantidadeEstoqueInvalida) {
                                                try {
                                                    System.out.print("Digite a nova quantidade em estoque: ");
                                                    novaQuantidadeEstoque = scanner.nextInt();
                                                    scanner.nextLine();
                                                    novaQuantidadeEstoqueInvalida = true;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Nova quantidade em estoque inválida. Por gentileza, digite um número inteiro.");
                                                    scanner.nextLine();
                                                }
                                            }
                                            System.out.println(fachadaLoja.atualizarEstoqueProduto(idProduto, novaQuantidadeEstoque));
                                        }

                                        case 5 -> {
                                            System.out.println(fachadaLoja.exibirProdutos());
                                        }

                                        case 6 -> {
                                            System.out.print("Digite a categoria para filtrar: ");
                                            String nomeCategoria = scanner.nextLine();
                                            System.out.println(fachadaLoja.filtrarPorCategoria(nomeCategoria));
                                        }

                                        case 7 -> {
                                            System.out.println(fachadaLoja.ordenarPorPreco());
                                        }

                                        case 8 -> {
                                            System.out.println(fachadaLoja.visualizarUltimaVenda());
                                        }

                                        case 9 -> {
                                            System.out.println(fachadaLoja.listarVendasRealizadas());
                                        }

                                        case 10 -> {
                                            gerenteContinuar = false;
                                            quantidadeAcessosMenuPrincipal++;
                                        }

                                        default ->
                                            System.out.println("\nOpção inválida. Tente novamente.");
                                    }
                                }
                            } else {
                                System.out.println("\nSenha incorreta. Tente novamente.");
                            }
                        } else {
                            System.out.println("\nNenhum gerente cadastrado. Cadastre um gerente primeiro.");
                        }
                    }

                    case 5 -> {
                        continuar = false;
                        System.out.println("\nObrigado por visitar nossa loja. Volte sempre! :)");
                        System.out.println("Saindo...");
                    }

                    default ->
                        System.out.println("\nInsira uma opção válida.");
                }
            }
        }
    }
}