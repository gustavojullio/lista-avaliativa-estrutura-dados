import java.util.Scanner;

public class Main {
    public static boolean verificaParenteses(String expressao) {
        Pilha pilha = new Pilha(expressao.length());
        
        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(') {
                pilha.push(caractere);
            } else if (caractere == ')') {
                if (pilha.isEmpty()) {
                    return false; 
                } else {
                    pilha.pop(); 
                }
            }
        }

        return pilha.isEmpty(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a expressão:");
        String expressao = sc.nextLine();

        boolean correta = verificaParenteses(expressao);
        if (correta) {
            System.out.println("A expressão está correta");
        } else {
            System.out.println("A expressão está incorreta");
        }

        sc.close();
    }
}
