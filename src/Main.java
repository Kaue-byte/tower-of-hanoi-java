import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantidade de discos: ");
        int n = sc.nextInt();

        JogoHanoi jogo = new JogoHanoi(n);
        jogo.setTorre();

        int op;

        do {
            System.out.println("\n===== TORRE DE HANOI =====");
            System.out.println("1 - Mover disco");
            System.out.println("2 - Mostrar torres");
            System.out.println("3 - Reiniciar jogo");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    try {
                        System.out.print("Torre origem (0-2): ");
                        int origem = sc.nextInt();

                        System.out.print("Torre destino (0-2): ");
                        int destino = sc.nextInt();

                        jogo.move(origem, destino);

                        if (jogo.endGame()) {
                            System.out.println(" Você venceu!");
                        }

                    } catch (Exception e) {
                        System.out.println("Movimento inválido: " + e.getMessage());
                    }
                    break;

                case 2:
                    jogo.exibir();
                    break;

                case 3:
                    System.out.print("Nova quantidade de discos: ");
                    n = sc.nextInt();

                    jogo = new JogoHanoi(n);
                    jogo.setTorre();

                    System.out.println("Jogo reiniciado.");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 4);

        sc.close();
    }
}
