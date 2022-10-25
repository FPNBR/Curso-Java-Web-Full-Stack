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

        Disciplina disciplina = new Disciplina();
        disciplina.setDisciplina("Curso de Java");
        disciplina.setNota(notas);
        aluno.getDisciplinas().add(disciplina);

        Disciplina disciplina2 = new Disciplina();
        disciplina.setDisciplina("Lógica de programação");
        disciplina.setNota(notasLogica);
        aluno.getDisciplinas().add(disciplina2);
    }
}
