import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Pilha p = new Pilha();
        Processo proc = new Processo();

        Pilha afonso = new Pilha();
        Pilha rosimeire = new Pilha();
        Pilha ana = new Pilha();

        p.push(new Processo(1, "Rosimeire", "Acme"));
        p.push(new Processo(2, "Afonso", "Samsung"));
        p.push(new Processo(3, "Rosimeire", "Lenovo"));
        p.push(new Processo(4, "Ana", "Lenovo"));
        p.push(new Processo(5, "Afonso", "Acme"));
        p.push(new Processo(6, "Rosimeire", "Lenovo"));

        System.out.println("Lista de processos a serem executados:");
        while (!p.isVazia()) {
            proc = p.pop();
            if (proc.responsavel.equals("Rosimeire")) {
                rosimeire.push(proc);
            }
            if (proc.responsavel.equals("Ana")) {
                ana.push(proc);
            }
            if (proc.responsavel.equals("Afonso")) {
                afonso.push(proc);
            }

            System.out.printf("Responsável: %s\t\t Código: %d\tCliente: %s\n", proc.responsavel, proc.codigo,
                    proc.cliente);

        }

        System.out.println();
        System.out.println();


        System.out.println("Lista de processos a serem executados pela Rosimeire:");
        while (!rosimeire.isVazia()) {
            proc = rosimeire.pop();
            System.out.printf("Responsável: %s\t\t Código: %d\tCliente: %s\n", proc.responsavel, proc.codigo,
                    proc.cliente);
        }

        System.out.println();
        System.out.println();

        System.out.println("Lista de processos a serem executados pela Ana:");
        while (!ana.isVazia()) {
            proc = ana.pop();
            System.out.printf("Responsável: %s\t\t Código: %d\tCliente: %s\n", proc.responsavel, proc.codigo,
                    proc.cliente);
        }

        System.out.println();
        System.out.println();

        System.out.println("Lista de processos a serem executados pelo Afonso:");
        while (!afonso.isVazia()) {
            proc = afonso.pop();
            System.out.printf("Responsável: %s\t\t Código: %d\tCliente: %s\n", proc.responsavel, proc.codigo,
                    proc.cliente);
        }

        System.out.println();
        System.out.println();

        // Testando o método de busca pelo código
        Pilha teste = new Pilha();
        teste.push(new Processo(1, "Erick", "Acme"));
        teste.push(new Processo(2, "Lucas", "Samsung"));
        teste.push(new Processo(3, "Fernando", "Lenovo"));
        teste.push(new Processo(4, "Flávio", "Lenovo"));

        System.out.println("\nDigite o código do processo que deseja procurar na PILHA TESTE:");
        int codigoProcurado = sc.nextInt();

        try {
            int posicao = teste.buscarPosicaoPorCodigo(codigoProcurado);
            System.out.printf("O processo com código %d está na posição %d da pilha.\n", codigoProcurado,
                    posicao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
