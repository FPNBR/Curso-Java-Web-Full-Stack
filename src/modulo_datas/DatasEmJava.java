package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatasEmJava {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date dataVencimentoBoleto = simpleDateFormat.parse("31/10/2022");
        Date dataAtualHoje = simpleDateFormat.parse("31/10/2022");

        // After - Se a data 1 é maior que a data 2, Before - Se a data 1 é menor que a data 2
        if (dataVencimentoBoleto.before(dataAtualHoje)) {
            System.out.println("Boleto vencido");
        }
        else {
            System.out.println("Boleto não vencido");
        }
    }
}