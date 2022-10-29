package cursojavathread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

    public static void add(ObjetoFilaThread objetoFilaThread) {
        pilha_fila.add(objetoFilaThread);
    }

    @Override
    public void run() {

        while (true) {
            synchronized (pilha_fila) { // Bloquear o acesso desta lista por outros processos

                Iterator iteracao = pilha_fila.iterator();
                while (iteracao.hasNext()) { // Em quanto tiver dados na lista irá processar//
                    ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();

                    // Processar N notas fiscais
                    // Gerar N listas de PDF
                    // Gerar N envio de emails

                    System.out.println("----------------------------------------");

                    System.out.println(processar.getEmail());
                    System.out.println(processar.getNome());

                    iteracao.remove();

                    try {
                        Thread.sleep(1000); // Tempo para descarga de memória
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            try {
                Thread.sleep(1000); // Para a limpeza de memória após o processamento da lista
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
