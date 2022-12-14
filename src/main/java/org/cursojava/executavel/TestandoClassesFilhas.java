package org.cursojava.executavel;

import org.cursojava.classes.Aluno;
import org.cursojava.classes.Diretor;
import org.cursojava.classes.Pessoa;
import org.cursojava.classes.Secretario;

public class TestandoClassesFilhas {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setNome("Felipe");
        aluno.setIdade(22);

        Diretor diretor = new Diretor();
        diretor.setRegistroGeral("123123123");
        diretor.setNome("Douglas");
        diretor.setIdade(50);


        Secretario secretario = new Secretario();
        secretario.setExperiencia("Administração");
        secretario.setNumeroCpf("00000000000");
        secretario.setNome("João");
        secretario.setIdade(18);


        System.out.println(aluno);
        System.out.println(diretor);
        System.out.println(secretario);

        System.out.println(aluno.pessoaMaiorIdade() + " - " + aluno.msgMaiorIdade());
        System.out.println(diretor.pessoaMaiorIdade());
        System.out.println(secretario.pessoaMaiorIdade());

        System.out.println("Salario do Aluno é = " + aluno.salario());
        System.out.println("Salario do Diretor é = " + diretor.salario());
        System.out.println("Salario do Secretário é = " + secretario.salario());

        teste(aluno);
        teste(diretor);
        teste(secretario);
    }

    public static void teste(Pessoa pessoa) {
        System.out.println("Essa pessoa é demais = " + pessoa.getNome()+ ", e o salário é de = " + pessoa.salario());
    }
}