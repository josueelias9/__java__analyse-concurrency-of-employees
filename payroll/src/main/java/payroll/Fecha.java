package payroll;

public class Fecha {
    int dia;
    int mes;
    int hora;

    public Fecha(int mes, int dia, int hora) {
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
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

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getHora() {
        return hora;
    }
}
