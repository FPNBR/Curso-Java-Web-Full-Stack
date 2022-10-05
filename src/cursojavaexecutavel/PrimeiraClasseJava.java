package cursojavaexecutavel;

import cursojavaclasses.Aluno;

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
        String disciplinaUm = JOptionPane.showInputDialog("Qual a disciplina 1 do aluno?");
        String notaUm = JOptionPane.showInputDialog("Digite a nota 1 do aluno");
        String disciplinaDois = JOptionPane.showInputDialog("Qual a disciplina 2 do aluno?");
        String notaDois = JOptionPane.showInputDialog("Digite a nota 2 do aluno");
        String disciplinaTres = JOptionPane.showInputDialog("Qual a disciplina 3 do aluno?");
        String notaTres = JOptionPane.showInputDialog("Digite a nota 3 do aluno");
        String disciplinaQuatro = JOptionPane.showInputDialog("Qual a disciplina 4 do aluno?");
        String notaQuatro = JOptionPane.showInputDialog("Digite a nota 4 do aluno");

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

        aluno1.getDisciplina().setDisciplina1(disciplinaUm);
        aluno1.getDisciplina().setDisciplina2(disciplinaDois);
        aluno1.getDisciplina().setDisciplina3(disciplinaTres);
        aluno1.getDisciplina().setDisciplina4(disciplinaQuatro);

        aluno1.getDisciplina().setNota1(Double.parseDouble(notaUm));
        aluno1.getDisciplina().setNota2(Double.parseDouble(notaDois));
        aluno1.getDisciplina().setNota3(Double.parseDouble(notaTres));
        aluno1.getDisciplina().setNota4(Double.parseDouble(notaQuatro));

        System.out.println(aluno1);
        System.out.println("A média da nota do aluno é = " + aluno1.getMediaNota());
        System.out.println("Resultado = " + (aluno1.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
        System.out.println("Resultado 2 = " + (aluno1.getAlunoAprovado2()));

    }
}
