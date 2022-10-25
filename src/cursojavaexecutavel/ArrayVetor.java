package cursojavaexecutavel;

public class ArrayVetor {
    public static void main(String[] args) {

        double[] notas = new double[5];
        notas[0] = 9.8;
        notas[1] = 8.7;
        notas[2] = 9.7;
        notas[3] = 9.9;

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota " + (i + 1) + " é = " + notas[i]);
        }
    }
}
