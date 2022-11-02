package cursojavaarquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\felip\\Documents\\Projetos\\Java\\Java-JDEVTreinamentos\\src\\cursojavaarquivos\\arquivo_excel.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        Pessoa pessoa3 = new Pessoa();
        Pessoa pessoa4 = new Pessoa();

        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade(24);
        pessoa1.setNome("Felipe");

        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade(50);
        pessoa2.setNome("Alex");

        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade(40);
        pessoa3.setNome("Lucas");

        pessoa4.setEmail("pessoa4@gmail.com");
        pessoa4.setIdade(30);
        pessoa4.setNome("Paulo");

        // Pode vir do banco de dados ou qualquer fonte de dados
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // Usado para escrever a planilha
        HSSFSheet planilhaPessoa = hssfWorkbook.createSheet("Planilha de pessoas"); // Criar a planilha

        int numeroLinha = 0;
        for (Pessoa p : pessoas) {
            Row linha = planilhaPessoa.createRow(numeroLinha++); // Criando a linha na planilha

            int celula = 0;
            Cell celNome = linha.createCell(celula++); // Célula 1
            celNome.setCellValue(p.getNome());

            Cell celEmail = linha.createCell(celula++); // Célula 2
            celEmail.setCellValue(p.getEmail());

            Cell celIdade = linha.createCell(celula++); // Célula 3
            celIdade.setCellValue(p.getIdade());

        } // Término da montagem da planilha

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida); // Escreve a planilha
        saida.flush();
        saida.close();

        System.out.println("Planilha criada!");
    }
}