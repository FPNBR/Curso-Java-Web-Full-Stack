package org.cursojava.classes;

import java.util.Arrays;
import java.util.Objects;

public class Disciplina {
    private String disciplina;
    private Double[] nota = new Double[4];

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double[] getNota() {
        return nota;
    }

    public void setNota(Double[] nota) {
        this.nota = nota;
    }

    public double getMediaNotas() {
        double somaNota = 0;
        for (int i = 0; i < nota.length; i++) {
            somaNota += nota[i];
        }
        return somaNota / nota.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(disciplina, that.disciplina) && Arrays.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(disciplina);
        result = 31 * result + Arrays.hashCode(nota);
        return result;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "disciplina='" + disciplina + '\'' +
                ", nota=" + Arrays.toString(nota) +
                '}';
    }
}