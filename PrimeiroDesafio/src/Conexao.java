import java.sql.*;

public class Conexao {

    public static void Conexao_Banco(){

        String caminho = "jdbc:mysql://localhost:3306/desafio_um";
        try {

            //ESTABELECENDO A CONEXAO COM O BANCO DE DADOS
            Connection conexao = DriverManager.getConnection(caminho, "root", "");

            //CRIANDO UM OBJETO PARA PEGAR INFORMAÇÕES
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from produtos");

            //MOSTRANDO O RESULTADO
            while (resultSet.next()){
                String id_produto = resultSet.getString("id_produto");
                String nome = resultSet.getString("nome_produto");
                String descricao = resultSet.getString("descricao_produto");
                String preco = resultSet.getString("preço_produto");
                System.out.println("----------------------------------");
                System.out.println("ID do produto: "+ id_produto);
                System.out.println("Nome do produto: "+nome+ " - " + descricao);
                System.out.println("Valor do produto: "+preco);
                System.out.println("----------------------------------");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
