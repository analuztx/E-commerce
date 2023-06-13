import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Supermercado Lara");
        System.out.println("Você é cliente ou funcionário?");

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Cliente");
        System.out.println("2. Funcionário");
        int variavel_1 = Integer.parseInt(scanner.next());

        if (variavel_1 == 1){
            System.out.println("Escolha uma opção: ");
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Listar produtos");
            System.out.println("4. Atualizar produtos");
        } else if (variavel_1 == 2){
            System.out.println("Deseja adicionar ou remover algum produto?");
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("1. Adicionar");
            System.out.println("2. Remover");
            System.out.println("3. Listar");
            Conexao.Conexao_Banco();
            System.out.println("4. Atualizar");
            int variavel_3 = Integer.parseInt(scanner3.next());

            if(variavel_3 == 1){
                System.out.println("Qual produto deseja adicionar?");
                Funcionario.Adicionar_Produto();
            } else if(variavel_3 == 2) {
                System.out.println("Qual produto deseja remover?");
            } else if(variavel_3 == 3){
                System.out.println("Aqui estao os produtos no seu carrinho: ");
                Conexao.Conexao_Banco();
            } else if(variavel_3 == 4) {
                System.out.println("Qual produto você deseja atualizar?");
                Funcionario.Atualizar_Produto();
            } else {
                System.out.println("Opção não reconhecida pelo sistema!");
            }
        } else {
            System.out.println("Opção não reconhecida pelo sistema!");
        }

        System.out.println("---------------------------------");



    }
}