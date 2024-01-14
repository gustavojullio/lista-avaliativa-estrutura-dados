import java.util.Scanner;

public class Main {
   static boolean  penalidade = false;
    public static void main(String[] args) {
        PilhaReferencia jogador1 = new PilhaReferencia();
        PilhaReferencia jogador2 = new PilhaReferencia();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jogador 1, sua vez de jogar:");
        jogarRodada(jogador1, scanner);
        System.out.println("\nJogador 2, sua vez de jogar:");
        jogarRodada(jogador2, scanner);

        int pontuacaoJogador1 = calcularPontuacao(jogador1);
        int pontuacaoJogador2 = calcularPontuacao(jogador2);

        System.out.println("Pontuação do Jogador 1: " + pontuacaoJogador1);
        System.out.println("Pontuação do Jogador 2: " + pontuacaoJogador2);

        int vencedor = determinarVencedor(pontuacaoJogador1, pontuacaoJogador2);

        if (vencedor == 1) {
            System.out.println("O Jogador 1 venceu!");
            exibirCartas(jogador1);
        } else if (vencedor == 2) {
            System.out.println("O Jogador 2 venceu!");
            exibirCartas(jogador2);
        } else {
            System.out.println("Empate!");
        }

        scanner.close();
    }

    public static void jogarRodada(PilhaReferencia pilha, Scanner scanner) {
        int continuar;

        do {
            int valorCarta = (int) (Math.random() * 13 + 1);
            pilha.push(valorCarta);

            System.out.println("Carta sorteada: " + valorCarta);
            System.out.println("Pontuação atual: " + calcularPontuacao(pilha));
            

            if (calcularPontuacao(pilha) > 21) {
                System.out.println("Pontuação ultrapassou 21! Aplicando penalidade de 5 pontos.");
                penalidade = true;
                try {
                    pilha.pop(); 
                    pilha.push(-5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }else{
                penalidade = false;
            }

            System.out.print("Deseja continuar pegando cartas? (1 para Sim / 0 para Não): ");
            continuar = scanner.nextInt();
        } while (continuar == 1);
    }

    public static int calcularPontuacao(PilhaReferencia pilha) {
        int pontuacao = 0;

        PilhaReferencia temp = new PilhaReferencia();
        while (!pilha.isVazia()) {
            PilhaReferencia.Node carta = pilha.getTopo();
            pontuacao += carta.valor;

            try {
                pilha.pop();
                temp.push(carta.valor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (!temp.isVazia()) {
            try {
                pilha.push(temp.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            return pontuacao;
    }

    public static int determinarVencedor(int pontuacaoJogador1, int pontuacaoJogador2) {
        if (pontuacaoJogador1 > 21 && pontuacaoJogador2 > 21) {
            return 0; 
        } else if (pontuacaoJogador1 > 21) {
            return 2; 
        } else if (pontuacaoJogador2 > 21) {
            return 1; 
        } else if (pontuacaoJogador1 == pontuacaoJogador2) {
            return 0;
        } else {
            return Math.abs(21 - pontuacaoJogador1) < Math.abs(21 - pontuacaoJogador2) ? 1 : 2;
        }
    }
    

    public static void exibirCartas(PilhaReferencia pilha) {
        PilhaReferencia temp = new PilhaReferencia();

        while (!pilha.isVazia()) {
            try {
                int carta = pilha.pop();
                System.out.print(carta + " ");
                temp.push(carta);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (!temp.isVazia()) {
            try {
                pilha.push(temp.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

}


