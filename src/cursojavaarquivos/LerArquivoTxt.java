package cursojavaarquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LerArquivoTxt {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream entradaArquivo = new FileInputStream(new File("C:\\Users\\felip\\Documents\\Projetos\\Java\\Java-JDEVTreinamentos\\src\\cursojavaarquivos\\arquivo.txt"));

        Scanner lerArquivo = new Scanner(entradaArquivo, StandardCharsets.UTF_8);

        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();

            if (linha != null && !linha.isEmpty()) {
                System.out.println(linha);
            }
        }
    }
}