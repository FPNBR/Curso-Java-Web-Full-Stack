package org.cursojava.executavel;

import org.cursojava.classes.Aluno;
import org.cursojava.classes.Diretor;
import org.cursojava.classes.Disciplina;
import org.cursojava.classes.auxiliares.FuncaoAutenticacao;
import org.cursojava.constantes.StatusAluno;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PrimeiraClasseJava {

    public static void main(String[] args) {

        try {
            //lerArquivo();
            String login = JOptionPane.showInputDialog("Informe o login");
            String senha = JOptionPane.showInputDialog("Informe a senha");

            if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) {
                List<Aluno> alunos = new ArrayList<Aluno>();
                HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

                for (int i = 1; i <= 1; i++) {
                    String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + i + " ?");
                    String idade = JOptionPane.showInputDialog("Qual a idade do aluno?");
                    /*
                    String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno?");
                    String rg = JOptionPane.showInputDialog("Qual o RG do aluno?");
                    String cpf = JOptionPane.showInputDialog("Qual o CPF do aluno?");
                    String nomeMae = JOptionPane.showInputDialog("Qual o nome da mãe do aluno?");
                    String nomePai = JOptionPane.showInputDialog("Qual o nome do pai do aluno?");
                    String dataMatricula = JOptionPane.showInputDialog("Qual a data de matrícula do aluno?");
                    String nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola do aluno?");
                    String serie = JOptionPane.showInputDialog("Qual a série do aluno?");
                     */

                    Aluno cadastrarAluno = new Aluno();
                    cadastrarAluno.setNome(nome);
                    cadastrarAluno.setIdade(Integer.parseInt(idade));
                    /*
                    cadastrarAluno.setDataNascimento(dataNascimento);
                    cadastrarAluno.setRegistroGeral(rg);
                    cadastrarAluno.setNumeroCpf(cpf);
                    cadastrarAluno.setNomeMae(nomeMae);
                    cadastrarAluno.setNomePai(nomePai);
                    cadastrarAluno.setDataMatricula(dataMatricula);
                    cadastrarAluno.setSerieMatriculado(serie);
                    cadastrarAluno.setNomeEscola(nomeEscola);
                     */

                    for (int j = 1; j <= 2; j++) {
                        String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + j + " ?");
                        String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + j + " ?");
                        Disciplina disciplina = new Disciplina();
                        disciplina.setDisciplina(nomeDisciplina);
                        //disciplina.setNota(Double.parseDouble(notaDisciplina));
                        cadastrarAluno.getDisciplinas().add(disciplina);
                    }

                    int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ?");
                    if (escolha == 0) {
                        int continuarRemover = 0;
                        int posicao = 1;
                        while (continuarRemover == 0) {
                            String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ?");
                            System.out.println(cadastrarAluno.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao));
                            posicao++;
                            if (cadastrarAluno.getDisciplinas().isEmpty()) {
                                break;
                            }
                            continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja remover mais disciplinas?");
                        }
                    }
                    alunos.add(cadastrarAluno);
                }

                maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
                maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
                maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

                for (Aluno aluno : alunos) {
                    if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
                        maps.get(StatusAluno.APROVADO).add(aluno);
                    } else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                        maps.get(StatusAluno.RECUPERACAO).add(aluno);
                    } else {
                        maps.get(StatusAluno.REPROVADO).add(aluno);
                    }
                }

                System.out.println("------------- Lista dos Aprovados ------------");
                for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                    System.out.println("Resultado = " + aluno.getNome() + ": " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
                }

                System.out.println("------------- Lista dos Reprovados ------------");
                for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                    System.out.println("Resultado = " + aluno.getNome() + ": " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
                }

                System.out.println("------------- Lista dos em Recuperação ------------");
                for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                    System.out.println("Resultado = " + aluno.getNome() + ": " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Acesso negado");
            }
        }
        catch (Exception e) {
            StringBuilder saida = new StringBuilder();
            e.printStackTrace();
            System.out.println("Mensagem: " + e.getMessage());

            for (int i = 0; i < e.getStackTrace().length; i++) {
                saida.append("\n Classe de erro: " + e.getStackTrace()[i].getClassName());
                saida.append("\n Método de erro: " + e.getStackTrace()[i].getMethodName());
                saida.append("\n Linha de erro: " + e.getStackTrace()[i].getLineNumber());
                saida.append("\n Class: " + e.getClass().getName());
            }
            JOptionPane.showMessageDialog(null, "Erro de conversão de número" + saida.toString());
        }
        finally {
            JOptionPane.showMessageDialog(null, "Teste");
        }
    }
    public static void lerArquivo () throws FileNotFoundException {
            File file = new File("arquivo.txt");
            Scanner scanner = new Scanner(file);
    }
}