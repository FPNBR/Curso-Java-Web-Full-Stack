package cursojavaclasses;

public class Aluno {
    public String nome;
    public int idade;
    public String dataNascimento;
    String registroGeral;
    String numeroCpf;
    String nomeMae;
    String nomePai;
    String nomeMatricula;
    String nomeEscola;
    String serieMatriculado;

    public Aluno() {
    }

    public Aluno(String nomePadrao) {
        nome = nomePadrao;
    }

    public Aluno(String nomePadrao, int idadePadrao) {
        nome = nomePadrao;
        idade = idadePadrao;
    }
}
