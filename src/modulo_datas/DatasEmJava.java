package modulo_datas;

import java.util.Date;

public class DatasEmJava {
    public static void main(String[] args) {

        Date date = new Date();

        System.out.println("Data em milisegundos: " + date.getTime());
        System.out.println("Dia do mês: " + date.getDate()); // Deprecated, mas nas próximas aulas irá ser abordado a classe Calendar
        System.out.println("Dia da semana: " + date.getDay()); // Deprecated, mas nas próximas aulas irá ser abordado a classe Calendar
        System.out.println("Hora do dia: " + date.getHours()); // Deprecated, mas nas próximas aulas irá ser abordado a classe Calendar
        System.out.println("Minuto da hora: " + date.getMinutes()); // Deprecated, mas nas próximas aulas irá ser abordado a classe Calendar
        System.out.println("Segundos: " + date.getSeconds()); // Deprecated, mas nas próximas aulas irá ser abordado a classe Calendar
        System.out.println("Ano: " + (date.getYear() + 1900)); // Deprecated, mas nas próximas aulas irá ser abordado a classe Calendar
    }
}
