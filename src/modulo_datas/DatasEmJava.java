package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatasEmJava {
    public static void main(String[] args) throws ParseException {

        Calendar calendar = Calendar.getInstance(); // Pega a data atual

        // Simular que a data vem do banco de dados

        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("10-03-2022")); // Definindo uma data qualquer

        calendar.add(Calendar.DAY_OF_MONTH, -40); // Data de hoje - 40 dias

        System.out.println("Subtraindo dia do mês: " + new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));

        calendar.add(Calendar.MONTH, 1); // Somando o mês

        System.out.println("Somando o mês: " + new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));

        calendar.add(Calendar.YEAR, 1); // Somando o ano
        System.out.println("Somando 1 ano: " + new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
    }
}