package cursojavaexecutavel;

import cursojavaclasses.Aluno;
import cursojavaclasses.Disciplina;
import cursojavaconstantes.StatusAluno;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PrimeiraClasseJava {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<Aluno>();
        List<Aluno> alunosAprovados = new ArrayList<Aluno>();
        List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
        List<Aluno> alunosReprovados = new ArrayList<Aluno>();

        for (int i = 1; i <= 5; i++) {
            String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + i + " ?");
            String idade = JOptionPane.showInputDialog("Qual a idade do aluno?");
            String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno?");
            String rg = JOptionPane.showInputDialog("Qual o RG do aluno?");
            String cpf = JOptionPane.showInputDialog("Qual o CPF do aluno?");
            String nomeMae = JOptionPane.showInputDialog("Qual o nome da mãe do aluno?");
            String nomePai = JOptionPane.showInputDialog("Qual o nome do pai do aluno?");
            String dataMatricula = JOptionPane.showInputDialog("Qual a data de matrícula do aluno?");
            String nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola do aluno?");
            String serie = JOptionPane.showInputDialog("Qual a série do aluno?");

            Aluno cadastrarAluno = new Aluno();
            cadastrarAluno.setNome(nome);
            cadastrarAluno.setIdade(Integer.parseInt(idade));
            cadastrarAluno.setDataNascimento(dataNascimento);
            cadastrarAluno.setRegistroGeral(rg);
            cadastrarAluno.setNumeroCpf(cpf);
            cadastrarAluno.setNomeMae(nomeMae);
            cadastrarAluno.setNomePai(nomePai);
            cadastrarAluno.setDataMatricula(dataMatricula);
            cadastrarAluno.setSerieMatriculado(serie);
            cadastrarAluno.setNomeEscola(nomeEscola);

            for (int j = 1; j <= 1; j++) {
                String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + j + " ?");
                String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + j + " ?");
                Disciplina disciplina = new Disciplina();
                disciplina.setDisciplina(nomeDisciplina);
                disciplina.setNota(Double.parseDouble(notaDisciplina));
                cadastrarAluno.getDisciplinas().add(disciplina);
            }

            int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ?");
            if (escolha == 0) {
                int continuarRemover = 0;
                int posicao = 1;
                while (continuarRemover == 0) {
                    String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ?");
                    cadastrarAluno.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                    continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
                }
            }
            alunos.add(cadastrarAluno);
        }
        for (Aluno aluno : alunos) {
            if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
                alunosAprovados.add(aluno);
            }
            else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                alunosRecuperacao.add(aluno);
            }
            else {
                alunosReprovados.add(aluno);
            }
        }

        System.out.println("------------- Lista dos Aprovados ------------");
        for (Aluno aluno : alunosAprovados) {
            System.out.println("Resultado = " + aluno.getNome() + ": " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
        }

        System.out.println("------------- Lista dos Reprovados ------------");
        for (Aluno aluno : alunosReprovados) {
            System.out.println("Resultado = " + aluno.getNome() + ": " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
        }

        System.out.println("------------- Lista dos em Recuperação ------------");
        for (Aluno aluno : alunosRecuperacao) {
            System.out.println("Resultado = " + aluno.getNome() + ": " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
        }
    }
}