package modulo_datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DatasEmJava {
    public static void main(String[] args) throws ParseException {

        // API de data a partir do Java 8

        LocalDate dataAtual = LocalDate.now();

        System.out.println("Data atual: " + dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        LocalTime horaAtual = LocalTime.now();

        System.out.println("Hora atual: " + horaAtual.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        LocalDateTime dataAtualHoraAtual = LocalDateTime.now();

        System.out.println("Data e hora atual: " + dataAtualHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
}