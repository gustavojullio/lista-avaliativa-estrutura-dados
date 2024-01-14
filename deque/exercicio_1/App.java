public class App {
    public static void main(String[] args) {
        Deque<Numero> deque = new Deque<Numero>();
        try {
            for (int i = 0; i < 10; ++i) {

                if (Math.random() > 0.5) {
                    System.out.printf("addFirst(%d)\n", i);
                    deque.addFirst(new Numero(i));
                } else {
                    System.out.printf("addLast(%d)\n", i);
                    deque.addLast(new Numero(i));
                }
            }
            System.out.println("Deque atual");
            deque.print();
            for (int i = 0; i < 5; ++i) {
                if (Math.random() > 0.5) {
                    System.out.printf("removeFirst(): %d \n", deque.removeFirst().getValor());
                } else {
                    System.out.printf("removeLast(): %d \n", deque.removeLast().getValor());
                }
            }
            System.out.println("Deque atual");
            deque.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}