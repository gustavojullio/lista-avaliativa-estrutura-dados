import java.util.ArrayList;
import java.util.Iterator;

public class HashTable {
    public static final int M = 17;
    private ArrayList<Time>[] tabela;

    public HashTable() {
        tabela = (ArrayList<Time>[]) new ArrayList[M];
    }

    private int hash(int codigo) {
        return (31 * codigo) % M;
    }

    public Time get(int codigo) {
        int hash = hash(codigo);
        ArrayList<Time> times = tabela[hash];
        if (times == null)
            return null;
        for (Time time : times)
            if (time.getCodigo() == codigo)
                return time;
        return null;
    }

    public void put(Time t) {
        int hash = hash(t.getCodigo());
        ArrayList<Time> times = tabela[hash];
        if (times == null) {
            times = new ArrayList<Time>();
            times.add(t);
            tabela[hash] = times;
        } else {
            boolean existe = false;
            for (Time time : times)
                if (time.getCodigo() == t.getCodigo())
                    existe = true;
            if (!existe)
                times.add(t);
        }
    }

    public Time remove(int codigo) {
        int hash = hash(codigo);
        ArrayList<Time> times = this.tabela[hash];

        Iterator<Time> it = times.iterator();
        Time atual = null;

        while (it.hasNext()) {
            atual = it.next();
            if (atual.getCodigo() == codigo) {
                it.remove();
                return atual;
            }
        }

        return null;
    }

    public void status() {
        for (int i = 0; i < M; ++i) {
            if (tabela[i] != null) {
                ArrayList<Time> times = tabela[i];
                System.out.printf("A posição %d possui %d times\n", i, times.size());
            } else
                System.out.printf("A posição %d não possui times cadastrados\n", i);
        }
    }
}
