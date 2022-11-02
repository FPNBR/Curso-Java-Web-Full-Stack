package cursojavaarquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream entradaArquivo = new FileInputStream(new File("C:\\Users\\felip\\Documents\\Projetos\\Java\\Java-JDEVTreinamentos\\src\\cursojavaarquivos\\arquivo.txt"));

        Scanner lerArquivo = new Scanner(entradaArquivo, StandardCharsets.UTF_8);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (lerArquivo.hasNext()) { // Ler o arquivo txt e adicionar as pessoas na Lista
            String linha = lerArquivo.nextLine();

            if (linha != null && !linha.isEmpty()) { // Verifica se as linhas estão vazias ou nulas
                String[] dados = linha.split("\\;"); // Regex para separar cada atributo por ;
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(dados[0]);
                pessoa.setEmail(dados[1]);
                pessoa.setIdade(Integer.parseInt(dados[2]));
                pessoas.add(pessoa);
            }
        }

        for (Pessoa p : pessoas) { // Poderia gravar no banco de dados, enviar email, gerar boleto, etc...
            System.out.println(p);
        }
    }
}