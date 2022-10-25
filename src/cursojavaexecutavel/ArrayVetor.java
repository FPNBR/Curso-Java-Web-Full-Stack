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
        disciplina2.setDisciplina("Lógica de programação");
        disciplina2.setNota(notasLogica);
        aluno.getDisciplinas().add(disciplina2);

        System.out.println("Nome do aluno: " + aluno.getNome() + ", inscrito no curso: " + aluno.getNomeEscola());
        System.out.println("------- Disciplina do aluno -------");

        for (Disciplina d : aluno.getDisciplinas()) {
            System.out.println("Disciplina: " + d.getDisciplina());
            System.out.println("As notas da disciplina são: ");

            Double maiorNota = 0.0;
            for (int i = 0; i < d.getNota().length; i++) {
                System.out.println("Nota " + (i + 1) + " é = " + d.getNota()[i]);
                if (i == 0) {
                    maiorNota = d.getNota()[i];
                }
                else if (d.getNota()[i] > maiorNota) {
                    maiorNota = d.getNota()[i];
                }
            }
            System.out.println("A maior nota da Disciplina: " + d.getDisciplina() + ", é = " + maiorNota);
        }
    }
}