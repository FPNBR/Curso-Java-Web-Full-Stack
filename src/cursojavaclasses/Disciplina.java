package cursojavaclasses;

import java.util.Objects;

public class Disciplina {
    private String disciplina1;
    private String disciplina2;
    private String disciplina3;
    private String disciplina4;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    public String getDisciplina1() {
        return disciplina1;
    }

    public void setDisciplina1(String disciplina1) {
        this.disciplina1 = disciplina1;
    }

    public String getDisciplina2() {
        return disciplina2;
    }

    public void setDisciplina2(String disciplina2) {
        this.disciplina2 = disciplina2;
    }

    public String getDisciplina3() {
        return disciplina3;
    }

    public void setDisciplina3(String disciplina3) {
        this.disciplina3 = disciplina3;
    }

    public String getDisciplina4() {
        return disciplina4;
    }

    public void setDisciplina4(String disciplina4) {
        this.disciplina4 = disciplina4;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "disciplina1='" + disciplina1 + '\'' +
                ", disciplina2='" + disciplina2 + '\'' +
                ", disciplina3='" + disciplina3 + '\'' +
                ", disciplina4='" + disciplina4 + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", nota4=" + nota4 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Double.compare(that.nota1, nota1) == 0 && Double.compare(that.nota2, nota2) == 0 && Double.compare(that.nota3, nota3) == 0 && Double.compare(that.nota4, nota4) == 0 && Objects.equals(disciplina1, that.disciplina1) && Objects.equals(disciplina2, that.disciplina2) && Objects.equals(disciplina3, that.disciplina3) && Objects.equals(disciplina4, that.disciplina4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplina1, disciplina2, disciplina3, disciplina4, nota1, nota2, nota3, nota4);
    }
}
