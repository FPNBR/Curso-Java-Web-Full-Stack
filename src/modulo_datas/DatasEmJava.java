package modulo_datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DatasEmJava {
    public static void main(String[] args) throws ParseException {

        // API de data a partir do Java 8

        LocalDate dataAtual = LocalDate.now();

        System.out.println("Data atual: " + dataAtual);

        LocalTime horaAtual = LocalTime.now();

        System.out.println("Hora atual: " + horaAtual);

        LocalDateTime dataAtualHoraAtual = LocalDateTime.now();

        System.out.println("Data e hora atual: " + dataAtualHoraAtual);
    }
}