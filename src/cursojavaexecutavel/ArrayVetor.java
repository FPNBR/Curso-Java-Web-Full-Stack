package cursojavaexecutavel;

import cursojavaclasses.Aluno;
import cursojavaclasses.Disciplina;

import javax.swing.*;

public class ArrayVetor {
    public static void main(String[] args) {

        Double[] notas = {8.8, 9.7, 7.6, 6.8};
        Double[] notasLogica = {7.1, 5.7, 9.6, 7.8};

        Aluno aluno = new Aluno();
        aluno.setNome("Felipe");
        aluno.setNomeEscola("Jdev Treinamento");

        Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina("Curso de Java");
        disciplina1.setNota(notas);
        aluno.getDisciplinas().add(disciplina1);

        Disciplina disciplina2 = new Disciplina();
        disciplina2.setDisciplina("Lógica de programação");
        disciplina2.setNota(notasLogica);
        aluno.getDisciplinas().add(disciplina2);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Felipe 2");
        aluno2.setNomeEscola("Jdev Treinamento 2");

        Disciplina disciplina3 = new Disciplina();
        disciplina3.setDisciplina("Curso de Java 2");
        disciplina3.setNota(notas);
        aluno2.getDisciplinas().add(disciplina3);

        Disciplina disciplina4 = new Disciplina();
        disciplina4.setDisciplina("Lógica de programação 2");
        disciplina4.setNota(notasLogica);
        aluno2.getDisciplinas().add(disciplina4);

        Aluno[] arrayAlunos = new Aluno[2];

        arrayAlunos[0] = aluno;
        arrayAlunos[1] = aluno2;

        for (int i = 0; i < arrayAlunos.length; i++) {
            System.out.println("Nome do aluno é: " + arrayAlunos[i].getNome());

            for (Disciplina d : arrayAlunos[i].getDisciplinas()) {
                System.out.println("Nome da disciplina é: " + d.getDisciplina());

                for (int j = 0; j < d.getNota().length; j++) {
                    System.out.println("A nota número: " + (j + 1) + " é = " + d.getNota()[j]);
                }
            }
        }
    }
}