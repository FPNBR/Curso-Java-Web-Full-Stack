package modulo_datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DatasEmJava {
    public static void main(String[] args) throws ParseException {

        long dias = ChronoUnit.DAYS.between(LocalDate.parse("2022-01-01"), LocalDate.now()); // Total de dias de uma data até hoje

        System.out.println("Possui " + dias + " dias entra a faixa de data");

    }
}