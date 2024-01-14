public class Aluno {
    int matricula;
    String nome;
    String curso;

    public Aluno(int matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Nome: " + nome + ", Curso: " + curso;
    }
}
