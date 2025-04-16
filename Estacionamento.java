import java.util.Scanner;

public class estacionamento {

    // Matriz 10x30 representando o estacionamento
    // 0 - Espaço livre, 1 - Espaço ocupado
    static int[][] estacionamento = new int[10][30];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu de opções
        while (true) {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Estacionar veículo");
            System.out.println("2. Remover veículo");
            System.out.println("3. Verificar disponibilidade de um espaço");
            System.out.println("4. Mostrar status do estacionamento");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    estacionarVeiculo(scanner);
                    break;
                case 2:
                    removerVeiculo(scanner);
                    break;
                case 3:
                    verificarDisponibilidade(scanner);
                    break;
                case 4:
                    mostrarStatusEstacionamento();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para estacionar um veículo
    private static void estacionarVeiculo(Scanner scanner) {
        System.out.println("Digite a linha (0-9) e a coluna (0-29) do espaço para estacionar:");
        int linha = scanner.nextInt();
        int coluna = scanner.nextInt();

        if (linha >= 0 && linha < 10 && coluna >= 0 && coluna < 30) {
            if (estacionamento[linha][coluna] == 0) {
                estacionamento[linha][coluna] = 1; // Marca o espaço como ocupado
                System.out.println("Veículo estacionado no espaço [" + linha + "][" + coluna + "]");
            } else {
                System.out.println("Espaço já ocupado!");
            }
        } else {
            System.out.println("Espaço inválido! Tente novamente.");
        }
    }

    // Método para remover um veículo
    private static void removerVeiculo(Scanner scanner) {
        System.out.println("Digite a linha (0-9) e a coluna (0-29) do espaço para remover o veículo:");
        int linha = scanner.nextInt();
        int coluna = scanner.nextInt();

        if (linha >= 0 && linha < 10 && coluna >= 0 && coluna < 30) {
            if (estacionamento[linha][coluna] == 1) {
                estacionamento[linha][coluna] = 0; // Marca o espaço como livre
                System.out.println("Veículo removido do espaço [" + linha + "][" + coluna + "]");
            } else {
                System.out.println("Não há veículo estacionado nesse espaço.");
            }
        } else {
            System.out.println("Espaço inválido! Tente novamente.");
        }
    }

    // Método para verificar a disponibilidade de um espaço
    private static void verificarDisponibilidade(Scanner scanner) {
        System.out.println("Digite a linha (0-9) e a coluna (0-29) do espaço para verificar:");
        int linha = scanner.nextInt();
        int coluna = scanner.nextInt();

        if (linha >= 0 && linha < 10 && coluna >= 0 && coluna < 30) {
            if (estacionamento[linha][coluna] == 0) {
                System.out.println("Espaço [" + linha + "][" + coluna + "] está livre.");
            } else {
                System.out.println("Espaço [" + linha + "][" + coluna + "] está ocupado.");
            }
        } else {
            System.out.println("Espaço inválido! Tente novamente.");
        }
    }

    // Método para mostrar o status do estacionamento
    private static void mostrarStatusEstacionamento() {
        System.out.println("\n----- Status do Estacionamento -----");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 30; j++) {
                if (estacionamento[i][j] == 0) {
                    System.out.print("[L] "); // L de Livre
                } else {
                    System.out.print("[O] "); // O de Ocupado
                }
            }
            System.out.println();
        }
    }
}