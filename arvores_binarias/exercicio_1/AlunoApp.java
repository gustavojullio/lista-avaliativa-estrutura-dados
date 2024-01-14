import java.util.Scanner;

public class AlunoApp {
    public static void main(String[] args) {
        AlunoTree arvore = new AlunoTree();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite a matrícula do aluno " + (i + 1) + ": ");
            int matricula = sc.nextInt();
            sc.nextLine(); 
            System.out.println("Digite o nome do aluno " + (i + 1) + ": ");
            String nome = sc.nextLine();
            System.out.println("Digite o curso do aluno " + (i + 1) + ": ");
            String curso = sc.nextLine();

            Aluno aluno = new Aluno(matricula, nome, curso);
            arvore.inserir(aluno);
        }

      
        System.out.println("Árvore em pré-ordem:");
        arvore.preOrdem();

        System.out.println("Digite a matrícula para buscar:");
        int matriculaBusca = sc.nextInt();
        Aluno alunoBusca = arvore.buscar(matriculaBusca);
        if (alunoBusca != null) {
            System.out.println("Aluno encontrado: " + alunoBusca);
        } else {
            System.out.println("Aluno não encontrado.");
        }

        Aluno maiorMatricula = arvore.encontrarMaiorMatricula();
        System.out.println("Aluno com maior matrícula: " + maiorMatricula);

        System.out.println("Digite a matrícula para excluir:");
        int matriculaExclusao = sc.nextInt();
        arvore.excluir(matriculaExclusao);
        System.out.println("Árvore após exclusão em pré-ordem:");
        arvore.preOrdem();

        sc.close();
    }
}
