package cursojavathread;

public class AulaThread {
    public static void main(String[] args ) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            System.out.println("Executando...");

            Thread.sleep(1000);
        }
        System.out.println("Execução Finalizada!");
    }
}