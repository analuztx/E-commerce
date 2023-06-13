import java.sql.*;
import java.util.Scanner;

public class Funcionario {

    //Adicionar produto no banco de dados
    public static void Adicionar_Produto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        String preco = scanner.nextLine();
        System.out.print("Digite a descrição do produto (Comida ou Produto de limpeza): ");
        String descricao = scanner.nextLine();

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";

        try {
            Connection conexaobd = DriverManager.getConnection(caminho, "root", "");
            PreparedStatement statement = conexaobd.prepareStatement("INSERT INTO desafio_um.produtos (nome_produto, preço_produto, descricao_produto) VALUES(?, ?, ?)");

            statement.setString(1, nome);
            statement.setString(2, preco);
            statement.setString(3, descricao);

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Produto cadastrado com sucesso!");
            } else {
                System.out.println("Erro para cadastrar produto, tente novamente!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    //Atualizar produto no banco de dados
    public static void Atualizar_Produto(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do produto que você irá atualizar: ");
        int id_produto = scanner.nextInt();
        scanner.nextLine(); // limpando o buffer

        System.out.print("Digite o novo nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o novo preço do produto: ");
        String preco = scanner.nextLine();
        System.out.print("Digite a nova descrição do produto: ");
        String descricao = scanner.nextLine();

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";

        try{
            Connection conexaobd = DriverManager.getConnection(caminho, "root", "");
            PreparedStatement statement = conexaobd.prepareStatement("UPDATE desafio_um.produtos SET nome = ?, preco = ?, descricao = ? WHERE id_produto = ?");

            statement.setString(1, nome);
            statement.setString(2, preco);
            statement.setString(3, descricao);
            statement.setInt(4, id_produto);

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Erro ao atualizar o produto, tente novamente!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
