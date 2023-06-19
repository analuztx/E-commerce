import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Supermercado");
        System.out.println("Você é cliente ou funcionário?");

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Cliente");
        System.out.println("2. Funcionário");
        int variavel_1 = scanner.nextInt();
        scanner.nextLine();

        boolean loop = true;

        if (variavel_1 == 1) {
            while (loop) {
                System.out.println("---------------------------------");
                System.out.println("Escolha uma opção: ");
                System.out.println("1. Adicionar produto no carrinho");
                System.out.println("2. Remover produto do carrinho");
                System.out.println("3. Listar produtos do carrinho");
                System.out.println("4. Atualizar produtos no carrinho");
                System.out.println("5. Listar produtos do Supermercado");
                System.out.println("6. Finalizar compra");
                System.out.println("7. Sair");

                String variavel_2 = scanner.nextLine();

                System.out.println("---------------------------------");

                switch (variavel_2) {
                    case "1": {
                        Carrinho.AdicionarCarrinho();
                        break;
                    }
                    case "2": {
                        Carrinho.RemoverCarrinho();
                        break;
                    }
                    case "3": {
                        Carrinho.ListarCarrinho();
                        break;
                    }
                    case "4": {
                        Carrinho.AtualizarCarrinho();
                        break;
                    }
                    case "5": {
                        Carrinho.ListarProduto();
                        break;
                    }
                    case "6": {
                        Carrinho.FinalizarCompra();
                        break;
                    }
                    case "7": {
                        System.out.println("Volte sempre ao Supermercado!");
                        loop = false;
                        break;
                    }
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        } else if (variavel_1 == 2) {
            while (loop) {
                System.out.println("---------------------------------");
                System.out.println("Escolha uma opção: ");
                System.out.println("1. Adicionar");
                System.out.println("2. Remover");
                System.out.println("3. Listar");
                System.out.println("4. Atualizar");
                System.out.println("5. Sair");
                String variavel_3 = scanner.nextLine();
                System.out.println("---------------------------------");

                switch (variavel_3) {
                    case "1": {
                        System.out.println("Qual produto deseja adicionar no Supermercado?");
                        Funcionario.Adicionar_Produto();
                        break;
                    }
                    case "2": {
                        System.out.println("Qual produto deseja remover do Supermercado?");
                        Funcionario.Deletar_Produto();
                        break;
                    }
                    case "3": {
                        System.out.println("Aqui estão os produtos do Supermercado: ");
                        Funcionario.Listar_Produtos();
                        break;
                    }
                    case "4": {
                        System.out.println("Qual produto você deseja atualizar no Supermercado?");
                        Funcionario.Atualizar_Produto();
                        break;
                    }
                    case "5": {
                        System.out.println("Espero ver você logo!");
                        loop = false;
                        break;
                    }
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        } else {
            System.out.println("Opção não reconhecida pelo sistema!");
        }

        scanner.close();
        System.out.println("---------------------------------");
    }
}