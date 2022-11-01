package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava {
    public static void main(String[] args) throws ParseException {

        Date dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2022"); // Data inicial

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicial);

        for (int parcela = 1; parcela <= 12; parcela ++) { // Gerar parcelas
            calendar.add(Calendar.MONTH, 1); // A cada iteração adiciona um mês

            System.out.println("Parcela número: " + parcela + " vencimento é em: " + new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        }
    }
}