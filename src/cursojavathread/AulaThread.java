package cursojavathread;

import javax.swing.*;
import java.lang.Thread;

public class AulaThread {
    public static void main(String[] args ) throws InterruptedException {

        new Thread() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Executando...");

                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();

        System.out.println("Teste de Execução da Thread Finalizada!");
        JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");
    }
}