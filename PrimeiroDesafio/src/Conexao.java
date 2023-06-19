import java.sql.*;

public class Conexao {

    public static void Conexao_Banco(){

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";

        try {
            Connection conexao = DriverManager.getConnection(caminho, "root", "");
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from produtos");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados!");
        }

    }
}
