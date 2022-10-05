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

        Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina("Banco de dados");
        disciplina1.setNota(90);

        Disciplina disciplina2 = new Disciplina();
        disciplina2.setDisciplina("Matemática");
        disciplina2.setNota(80);

        Disciplina disciplina3 = new Disciplina();
        disciplina3.setDisciplina("Geografia");
        disciplina3.setNota(70);

        Disciplina disciplina4 = new Disciplina();
        disciplina4.setDisciplina("Java Web");
        disciplina4.setNota(70);

        aluno1.getDisciplinas().add(disciplina1);
        aluno1.getDisciplinas().add(disciplina2);
        aluno1.getDisciplinas().add(disciplina3);
        aluno1.getDisciplinas().add(disciplina4);

        System.out.println(aluno1);
        System.out.println("A média da nota do aluno é = " + aluno1.getMediaNota());
        System.out.println("Resultado = " + (aluno1.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
        System.out.println("Resultado 2 = " + (aluno1.getAlunoAprovado2()));

    }
}
