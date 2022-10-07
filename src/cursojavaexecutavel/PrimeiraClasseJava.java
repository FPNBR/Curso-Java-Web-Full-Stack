package cursojavaexecutavel;

import cursojavaclasses.Aluno;
import cursojavaclasses.Disciplina;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PrimeiraClasseJava {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<Aluno>();

        for (int i = 1; i <= 2; i++) {
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

            Aluno aluno1 = new Aluno();
            aluno1.setNome(nome);
            aluno1.setIdade(Integer.parseInt(idade));
            aluno1.setDataNascimento(dataNascimento);
            aluno1.setRegistroGeral(rg);
            aluno1.setNumeroCpf(cpf);
            aluno1.setNomeMae(nomeMae);
            aluno1.setNomePai(nomePai);
            aluno1.setDataMatricula(dataMatricula);
            aluno1.setSerieMatriculado(serie);
            aluno1.setNomeEscola(nomeEscola);

            for (int j = 1; j <= 4; j++) {
                String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + j + " ?");
                String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + j + " ?");
                Disciplina disciplina = new Disciplina();
                disciplina.setDisciplina(nomeDisciplina);
                disciplina.setNota(Double.parseDouble(notaDisciplina));
                aluno1.getDisciplinas().add(disciplina);
            }

            int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ?");
            if (escolha == 0) {
                int continuarRemover = 0;
                int posicao = 1;
                while (continuarRemover == 0) {
                    String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ?");
                    aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                    continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
                }
            }
            alunos.add(aluno1);
        }

        for (Aluno aluno: alunos) {
            System.out.println(aluno);
            System.out.println("A média da nota do aluno é = " + aluno.getMediaNota());
            System.out.println("Resultado = " + (aluno.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
            System.out.println("Resultado 2 = " + (aluno.getAlunoAprovado2()));
            System.out.println("-------------------------------------------------------------------------");
        }
    }
}