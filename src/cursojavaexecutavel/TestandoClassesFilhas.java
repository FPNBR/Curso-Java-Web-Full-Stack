package cursojavaexecutavel;

import cursojavaclasses.Aluno;
import cursojavaclasses.Diretor;
import cursojavaclasses.Secretario;

public class TestandoClassesFilhas {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setNome("Felipe");

        Diretor diretor = new Diretor();
        diretor.setRegistroGeral("123123123");

        Secretario secretario = new Secretario();
        secretario.setExperiencia("Administração");
        secretario.setNumeroCpf("00000000000");

        System.out.println(aluno);
        System.out.println(diretor);
        System.out.println(secretario);
    }
}
