package cursojavaexecutavel;

import cursojavaclasses.Aluno;
import cursojavaclasses.Disciplina;

import javax.swing.*;

public class PrimeiraClasseJava {

    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
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

        for (int i = 1; i <= 4; i++) {
            String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina "+i+" ?");
            String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina "+i+" ?");
            Disciplina disciplina = new Disciplina();
            disciplina.setDisciplina(nomeDisciplina);
            disciplina.setNota(Double.parseDouble(notaDisciplina));
            aluno1.getDisciplinas().add(disciplina);
        }

        int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ?");

        if (escolha == 0) {
            String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ?");
            aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - 1);
        }

        System.out.println(aluno1);
        System.out.println("A média da nota do aluno é = " + aluno1.getMediaNota());
        System.out.println("Resultado = " + (aluno1.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
        System.out.println("Resultado 2 = " + (aluno1.getAlunoAprovado2()));

    }
}
