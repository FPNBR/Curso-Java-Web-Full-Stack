package modulo_datas;

import java.time.LocalDate;
import java.time.Period;

public class DatasEmJava {
    public static void main(String[] args) {

        LocalDate dataAntiga = LocalDate.parse("2019-10-05");
        LocalDate dataNova = LocalDate.parse("2022-07-01");

        System.out.println("Data antiga é maior que data nova: " + dataAntiga.isAfter(dataNova));
        System.out.println("Data antiga é anterior que a data nova: " + dataAntiga.isBefore(dataNova));
        System.out.println("Datas são iguais: " + dataAntiga.isEqual(dataNova));

        Period periodo = Period.between(dataAntiga, dataNova);

        System.out.println("Quantos dias: " + periodo.getDays());
        System.out.println("Quantos meses: " + periodo.getMonths());
        System.out.println("Quantos anos: " + periodo.getYears());
        System.out.println("Somente meses: " + periodo.toTotalMonths());
        System.out.println("Período é: " + periodo.getYears() + " anos, " + periodo.getMonths() + " meses, " + "e " + periodo.getDays() + " dias");
    }
}