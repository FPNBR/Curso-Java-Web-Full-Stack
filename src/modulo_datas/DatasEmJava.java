package modulo_datas;

import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;

public class DatasEmJava {
    public static void main(String[] args) throws ParseException, InterruptedException {

        Instant inicio = Instant.now();

        Thread.sleep(2000); // Pode ser um processo com tempo qualquer que não conhecemos
        Instant ifinal = Instant.now();

        Duration duracao = Duration.between(inicio, ifinal);

        System.out.println("Duração em nano segundos: " + duracao.toNanos());
        System.out.println("Duração em minutos: " + duracao.toMinutes());
        System.out.println("Duração em horas: " + duracao.toHours());
        System.out.println("Duração em milisegundos: " + duracao.toMillis());
        System.out.println("Duração em milisegundos: " + duracao.toDays());
    }
}