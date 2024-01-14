public class App {
    public static void main(String[] args) throws Exception {
        ListaDuplamenteEncadeada lst = new ListaDuplamenteEncadeada();
        lst.addInicio(new Pessoa("Elizabeth", 96));
        lst.addInicio(new Pessoa("Roberto Carlos", 78));
        lst.addInicio(new Pessoa("Joana", 16));
        lst.addFim(new Pessoa("Cerberus", 12));
        lst.addInicio(new Pessoa("Paulo Henrique", 39));
        lst.addFim(new Pessoa("Pandora", 12));
        lst.add(3, new Pessoa("Guilhermina", 53));
        lst.add(1, new Pessoa("Jovenilda", 53));
        lst.print();
        
        System.out.println();
        System.out.println();
        try {
            lst.removeFim();
            lst.removeInicio();
            lst.remove(2);
            lst.remove(1);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        lst.print();
    }
}