import java.sql.*;
import java.util.*;

public class Carrinho {

    private static List<Produto> listaProduto = new ArrayList<>();

    public static void AdicionarCarrinho() {
        Scanner scanner = new Scanner(System.in);

        Produto produto = null;

        try {
            do {
                System.out.println("Qual o nome do produto que você deseja adicionar? ");
                String nome = scanner.nextLine();
                produto = Funcionario.Buscar_Produto(nome);
                if (produto == null) {
                    System.out.println("Produto não existente, tente novamente!");
                }
            } while (produto == null);

            System.out.println("Qual a quantidade do produto que você deseja adicionar?");
            Integer quantidade = scanner.nextInt();
            scanner.nextLine();

            produto.setQuantidade(quantidade);
            listaProduto.add(produto);
            System.out.println("Produto adicionado ao carrinho com sucesso!");

        } catch (NoSuchElementException e) {
            System.out.println("Erro ao colocar produto no carrinho, tente novamente!");
        }
    }

    public static void RemoverCarrinho() {
        Scanner scanner = new Scanner(System.in);

        boolean produtoEncontrado = false;

        try {
            if (listaProduto.isEmpty()) {
                System.out.println("Não há produto no carrinho para ser removido!");
                produtoEncontrado = true;
            } else {
                System.out.println("Qual o nome do produto que você deseja remover? ");
                String nome = scanner.nextLine();
                for (int i = 0; i < listaProduto.size(); i++) {
                    if (listaProduto.get(i).getNome().equals(nome)) {
                        listaProduto.remove(i);
                        System.out.println("Produto removido com sucesso!");
                        produtoEncontrado = true;
                        break;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Erro ao remover item da lista, tente novamente!");
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado na lista.");
        }

    }

    public static void ListarCarrinho() {

        try {
            if (listaProduto.isEmpty()) {
                System.out.println("O carrinho está vazio, adicione alguns itens!");
            } else {
                System.out.println("Aqui está os produtos do seu carrinho:");
                System.out.println(listaProduto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao mostrar os produtos do carrinho, tente novamente!");
        }
    }

    public static void ListarProduto() {

        try {
            System.out.println("Aqui está os produtos do Supermercado:");
            Funcionario.Listar_Produtos();
        } catch (Exception e) {
            System.out.println("Erro ao mostrar produtos do Supermercado, tente novamente!");
        }
    }

    public static void AtualizarCarrinho() {
        Scanner scanner = new Scanner(System.in);

        if (listaProduto.isEmpty()) {
            System.out.println("O carrinho está vazio, adicione alguns itens!");
        } else {
            System.out.println("Qual o nome do produto que você deseja atualizar? ");
            String nome = scanner.nextLine();

            boolean produtoEncontrado = false;

            try {
                for (Produto produto : listaProduto) {
                    if (produto.getNome().equals(nome)) {
                        System.out.println("Produto encontrado. Informe a nova quantidade: ");
                        int novaQuantidade = scanner.nextInt();
                        scanner.nextLine();

                        produto.setQuantidade(novaQuantidade);
                        System.out.println("Produto atualizado com sucesso!");
                        produtoEncontrado = true;
                        break;
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro ao atualizar o produto!");
            }

            if (!produtoEncontrado) {
                System.out.println("Produto não encontrado na lista.");
            }
        }
    }

    public static void FinalizarCompra() {
        String caminho = "jdbc:mysql://localhost:3306/desafio_um";

        Scanner scanner = new Scanner(System.in);

        if (listaProduto.isEmpty()){
            System.out.println("O carrinho está vazio, adicione alguns itens!");
        } else {
            ListarCarrinho();
            System.out.println("\n" + "\n");
            Double precoFinal = 0.0;
            for (Produto produto : listaProduto) {
                precoFinal += produto.getPreco() * produto.getQuantidade();
            }

            System.out.println("O preço final é de: " + precoFinal);
            System.out.println("Deseja concluir o pedido? (1/2)");
            System.out.println(" Opção 1: Sim \n Opção 2: Não");
            Integer opcao = Integer.valueOf(scanner.nextLine());

            if (opcao == 1) {
                System.out.println("Seu pedido foi de: " + precoFinal);
                System.out.println("Pedido finalizado!");
                Carrinho.AtualizarBancoDados();
                listaProduto.clear();


                try {
                    Connection conexaobd = DriverManager.getConnection(caminho, "root", "");

                    for (Produto produto : listaProduto) {
                        int quantidadeCompra = produto.getQuantidade();
                        String nomeCompra = String.valueOf(produto.getPreco());

                        String sql = "INSERT INTO compra_finalizada (nome_compra, quantidade_compra) VALUES (?, ?)";

                        PreparedStatement statement = conexaobd.prepareStatement(sql);
                        statement.setString(1, nomeCompra);
                        statement.setInt(2, quantidadeCompra);

                        statement.executeUpdate();
                        statement.close();
                    }

                    conexaobd.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao finalizar a compra: " + e.getMessage());
                }
            } else {
                System.out.println("Pedido não salvo!");
            }
        }
    }

    public static void AtualizarBancoDados() {
        String caminho = "jdbc:mysql://localhost:3306/desafio_um";

        try {
            Connection conexaobd = DriverManager.getConnection(caminho, "root", "");

            for (Produto produto : listaProduto) {
                String nomeProduto = produto.getNome();
                int quantidadeCompra = produto.getQuantidade();

                String sql = "UPDATE produtos SET quantidade_produto = quantidade_produto - ? WHERE nome_produto = ?";

                PreparedStatement statement = conexaobd.prepareStatement(sql);
                statement.setInt(1, quantidadeCompra);
                statement.setString(2, nomeProduto);

                statement.executeUpdate();
                statement.close();
            }

            conexaobd.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o banco de dados: " + e.getMessage());
        }
    }

}



