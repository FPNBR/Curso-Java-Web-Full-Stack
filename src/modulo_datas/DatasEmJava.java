package modulo_datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatasEmJava {
    public static void main(String[] args) throws ParseException {

        LocalDate localDate = LocalDate.now();
        System.out.println("Data atual: " + localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println("Dia da semana: " + localDate.getDayOfWeek()); // Dia da semana

        System.out.println("Dia do mês: " + localDate.getDayOfMonth()); // Dia do mês

        System.out.println("Dia do ano: " + localDate.getDayOfYear()); // Dia do ano

        System.out.println("Mês: " + localDate.getMonth()); // Nome do mês

        System.out.println("Ano: " + localDate.getYear()); // Número do mês
    }
}