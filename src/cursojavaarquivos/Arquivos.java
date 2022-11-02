package cursojavaarquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        Pessoa pessoa3 = new Pessoa();

        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade(24);
        pessoa1.setNome("Felipe");

        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade(50);
        pessoa2.setNome("Alex");

        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade(40);
        pessoa3.setNome("Lucas");

        // Pode vir do banco de dados ou qualquer fonte de dados
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        File arquivo = new File("C:\\Users\\felip\\Documents\\Projetos\\Java\\Java-JDEVTreinamentos\\src\\cursojavaarquivos\\arquivo.txt");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter escreverNoArquivo = new FileWriter(arquivo);

        for (Pessoa p : pessoas) {
            escreverNoArquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
        }
        escreverNoArquivo.flush();
        escreverNoArquivo.close();
    }
}