import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario {


    public static void Adicionar_Produto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        Double preco = Double.valueOf(scanner.nextLine());
        System.out.print("Digite a quantidade disponível: ");
        Integer quantidade = Integer.valueOf(scanner.nextLine());

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";

        try {
            Connection conexaobd = DriverManager.getConnection(caminho, "root", "");
            PreparedStatement statement = conexaobd.prepareStatement("INSERT INTO desafio_um.produtos (nome_produto, preço_produto, quantidade_produto) VALUES(?, ?, ?)");

            statement.setString(1, nome);
            statement.setDouble(2, preco);
            statement.setInt(3, quantidade);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("");
                System.out.println("Produto cadastrado com sucesso!");
            } else {
                System.out.println("Erro para cadastrar produto, tente novamente!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produto no banco de dados, tente novamente!");
        }

    }


    public static void Deletar_Produto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do produto que deseja remover do Supermercado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";

        try {
            Connection conexaobd = DriverManager.getConnection(caminho, "root", "");
            PreparedStatement statement = conexaobd.prepareStatement("DELETE FROM desafio_um.produtos WHERE id_produto = ?");

            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("");
                System.out.println("Produto deletado com sucesso!");
            } else {
                System.out.println("Erro ao deletar produto, tente novamente!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover produto do banco de dados, tente novamente!");
        }

    }


    public static List<Produto> Listar_Produtos() {

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";
        List<Produto> listaProdutos = new ArrayList<>();


        try {
            Connection conexaobd = DriverManager.getConnection(caminho, "root", "");
            PreparedStatement statement = conexaobd.prepareStatement("SELECT * FROM desafio_um.produtos");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_produto");
                String nome = resultSet.getString("nome_produto");
                Integer quantidade = resultSet.getInt("quantidade_produto");
                Double preco = resultSet.getDouble("preço_produto");

                System.out.println("");
                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Preço: " + preco);
                System.out.println("Quantidade: " + quantidade);
                System.out.println("");

                listaProdutos.add(new Produto(id, nome, preco, quantidade));
            }
            statement.close();
            conexaobd.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos do banco de dados, tente novamente!");
        }
        return listaProdutos;
    }


    public static void Atualizar_Produto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do produto que você irá atualizar: ");
        int id_produto = scanner.nextInt();
        scanner.nextLine(); // limpando o buffer

        System.out.print("Digite o novo nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o novo preço do produto: ");
        Double preco = Double.valueOf(scanner.nextLine());
        System.out.print("Digite a quantidade do produto: ");
        Integer quantidade = Integer.valueOf(scanner.nextLine());

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";

        try {
            Connection conexaobd = DriverManager.getConnection(caminho, "root", "");
            PreparedStatement statement = conexaobd.prepareStatement("UPDATE desafio_um.produtos SET nome_produto = ?, preço_produto = ?, quantidade_produto = ? WHERE id_produto = ?");

            statement.setString(1, nome);
            statement.setDouble(2, preco);
            statement.setInt(3, quantidade);
            statement.setInt(4, id_produto);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("");
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Erro ao atualizar o produto, tente novamente!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto no banco de dados, tente novamente!");
        }
    }


    public static Produto Buscar_Produto(String nome) {

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";
        Produto produto = null;


        try {
            Connection conexaobd = DriverManager.getConnection(caminho, "root", "");
            PreparedStatement statement = conexaobd.prepareStatement("SELECT * FROM desafio_um.produtos WHERE nome_produto = ?");
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_produto");
                String nomeProduto = resultSet.getString("nome_produto");
                Integer quantidade = resultSet.getInt("quantidade_produto");
                Double preco = resultSet.getDouble("preço_produto");

                System.out.println("");
                System.out.println("ID: " + id);
                System.out.println("Nome: " + nomeProduto);
                System.out.println("Preço: " + preco);
                System.out.println("Quantidade: " + quantidade);
                System.out.println("");

               produto = new Produto(id, nomeProduto, preco, quantidade);
            }
            statement.close();
            conexaobd.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto no banco de dados, tente novamente!");
        }
        return produto;
    }


}


