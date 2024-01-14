public class AlunoTree {
    AlunoNode raiz = null;

    public void inserir(Aluno aluno) {
        raiz = inserirRec(raiz, aluno);
    }

    private AlunoNode inserirRec(AlunoNode no, Aluno aluno) {
        if (no == null) {
            return new AlunoNode(aluno);
        }

        if (aluno.matricula < no.aluno.matricula) {
            no.esquerda = inserirRec(no.esquerda, aluno);
        } else if (aluno.matricula > no.aluno.matricula) {
            no.direita = inserirRec(no.direita, aluno);
        }

        return no;
    }

    public Aluno buscar(int matricula) {
        return buscarRec(raiz, matricula);
    }

    private Aluno buscarRec(AlunoNode no, int matricula) {
        if (no == null || no.aluno.matricula == matricula) {
            return (no != null) ? no.aluno : null;
        }

        if (matricula < no.aluno.matricula) {
            return buscarRec(no.esquerda, matricula);
        }

        return buscarRec(no.direita, matricula);
    }

    public Aluno encontrarMaiorMatricula() {
        return encontrarMaiorMatriculaRec(raiz);
    }

    private Aluno encontrarMaiorMatriculaRec(AlunoNode no) {
        if (no == null) {
            return null;
        }

        while (no.direita != null) {
            no = no.direita;
        }

        return no.aluno;
    }

    public void preOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(AlunoNode no) {
        if (no != null) {
            System.out.println(no.aluno);
            preOrdemRec(no.esquerda);
            preOrdemRec(no.direita);
        }
    }

    public void excluir(int matricula) {
        raiz = excluirRec(raiz, matricula);
    }

    private AlunoNode excluirRec(AlunoNode no, int matricula) {
        if (no == null) {
            return null;
        }

        if (matricula < no.aluno.matricula) {
            no.esquerda = excluirRec(no.esquerda, matricula);
        } else if (matricula > no.aluno.matricula) {
            no.direita = excluirRec(no.direita, matricula);
        } else {
            if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            }

            no.aluno = encontrarMenorMatricula(no.direita);
            no.direita = excluirRec(no.direita, no.aluno.matricula);
        }

        return no;
    }

    private Aluno encontrarMenorMatricula(AlunoNode no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }

        return no.aluno;
    }

    private class AlunoNode {
        Aluno aluno;
        AlunoNode esquerda;
        AlunoNode direita;

        public AlunoNode(Aluno aluno) {
            this.aluno = aluno;
            this.esquerda = null;
            this.direita = null;
        }
    }
}
