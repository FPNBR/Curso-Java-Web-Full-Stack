package cursojavaexecutavel;

import cursojavaclasses.Aluno;

public class PrimeiraClasseJava {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        aluno1.nome = "João";
        aluno1.idade = 50;

        System.out.println("Nome do aluno é = " + aluno1.nome);
        System.out.println("A idade do aluno é = " + aluno1.idade);

        Aluno aluno2 = new Aluno();

        Aluno aluno3 = new Aluno();

        Aluno aluno4 = new Aluno("Maria");

        Aluno aluno5 = new Aluno("José", 50 );
    }
}
