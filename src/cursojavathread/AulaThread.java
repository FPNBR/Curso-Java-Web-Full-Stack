package cursojavathread;

import javax.swing.*;
import java.lang.Thread;

public class AulaThread {
    public static void main(String[] args) throws InterruptedException {

        Thread threadEmail = new Thread(thread1);
        threadEmail.start();

        Thread threadNotaFiscal = new Thread(thread2);
        threadNotaFiscal.start();

        System.out.println("Teste de Execução da Thread Finalizada!");
        JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");
    }

    private static final Runnable thread1 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread Email - Executando...");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };

    private static final Runnable thread2 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread Nota Fiscal - Executando...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };
}