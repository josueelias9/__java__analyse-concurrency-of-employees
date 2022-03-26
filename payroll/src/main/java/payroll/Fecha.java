package payroll;

public class Fecha {
    int dia;
    int mes;

    public Fecha(int dia, int mes) {
        this.dia=dia;
        this.mes=mes;

    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

}
