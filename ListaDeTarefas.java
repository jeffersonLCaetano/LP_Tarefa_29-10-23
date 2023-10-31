import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        do {
            System.out.println();
            System.out.println("== Aplicativo de Lista de Tarefas ==");
            System.out.println("1. Adicionar Tarefas");
            System.out.println("2. Remover Tarefas");
            System.out.println("3. Listar Tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println();
                    System.out.print("Digite a tarefa a ser adicionada: ");
                    String tarefa = scanner.nextLine();
                    adicionarTarefa(tarefas, tarefa);
                    break;

                case 2:
                    System.out.println();
                    listarTarefas(tarefas);
                    System.out.println("Escolha a tarefa a ser removida: ");
                    String remover = scanner.nextLine();
                    removerTarefa(tarefas, remover);
                    break;

                case 3:
                    System.out.println();
                    listarTarefas(tarefas);
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Encerrando");
                    break;

                default:
                    System.out.println();
                    System.out.println("Opção inválida");
            }

        } while (opcao != 4);
    }

    private static void removerTarefa(ArrayList<String> tarefas, String remover) {
        tarefas.remove(remover);
    }

    private static void adicionarTarefa(ArrayList<String> tarefas, String tarefa) {
        tarefas.add(tarefa);
    }

    private static void listarTarefas(ArrayList<String> tarefas) {
        System.out.println("Lista de Tarefas: ");
        for (String item : tarefas) {
            System.out.println(item);
        }
    }
}
