package org.cursojava.arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePoi2 {
    public static void main(String[] args) throws IOException {

        FileInputStream entrada = new FileInputStream(new File("C:\\Users\\felip\\Documents\\Projetos\\Java\\Java-JDEVTreinamentos\\src\\cursojavaarquivos\\arquivo_excel.xls"));

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // Preparada a entrada do arquivo excel para ler
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // Pega a primeira planilha do nosso arquivo excel

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (linhaIterator.hasNext()) { // Enquanto tiver linha no arquivo do excel
            Row linha = linhaIterator.next(); // Dados da pessoa na linha
            Iterator<Cell> celulas = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while (celulas.hasNext()) { // Percorrer as células
                Cell cell = celulas.next();
                switch (cell.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                        break;
                }
            }// Fim das células da linha

            pessoas.add(pessoa);
        }

        entrada.close(); // Terminou de ler o arquivo excel

        for (Pessoa p : pessoas) { // Poderia gravar no banco de dados
            System.out.println(p);
        }
    }
}