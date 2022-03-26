package payroll;

public class Intervalo {

    int infe;
    int supe;

    public Intervalo(int infe, int supe) {
        this.infe = infe;
        this.supe = supe;
    }

    public int getInfe() {
        return infe;
    }

    public void setInfe(int infe) {
        this.infe = infe;
    }

    public int getSupe() {
        return supe;
    }

    public void setSupe(int supe) {
        this.supe = supe;
    }
}
