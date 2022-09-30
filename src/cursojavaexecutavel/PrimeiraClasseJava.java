package cursojavaexecutavel;

import cursojavaclasses.Aluno;

public class PrimeiraClasseJava {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("João da Silva");
        aluno1.setIdade(50);
        aluno1.setDataNascimento("18/10/1997");
        aluno1.setRegistroGeral("444.444.444.44");
        aluno1.setNumeroCpf("444.444.444.44");
        aluno1.setNomeMae("Shirlei");
        aluno1.setNomePai("Antônio");
        aluno1.setDataMatricula("10/01/2019");
        aluno1.setNomeEscola("Escola JDEV Treinamento");
        aluno1.setSerieMatriculado("5");

        System.out.println("O nome do aluno é = " + aluno1.getNome());
        System.out.println("A idade do aluno é = " + aluno1.getIdade());
        System.out.println("A data de nascimento do aluno é = " + aluno1.getDataNascimento());
        System.out.println("----------------------------------------");

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Pedro");
        aluno2.setIdade(40);
        aluno2.setDataNascimento("10/10/1970");

        System.out.println("O nome do aluno é = " + aluno2.getNome());
        System.out.println("A idade do aluno é = " + aluno2.getIdade());
        System.out.println("A data de nascimento do aluno é = " + aluno2.getDataNascimento());

        Aluno aluno3 = new Aluno();

        Aluno aluno4 = new Aluno("Maria");

        Aluno aluno5 = new Aluno("José", 50 );
    }
}
