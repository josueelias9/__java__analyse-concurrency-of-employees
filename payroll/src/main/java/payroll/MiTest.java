package payroll;

import java.util.ArrayList;

public class MiTest {

    boolean test_un_rango_un_intervalo() {
        ArrayList<Intervalo> intervalos = new ArrayList<>();
        Logica logi = new Logica();

        intervalos = logi.un_rango_un_intervalo(new Intervalo(10, 20), new Intervalo(20, 30));
        if (!(intervalos.get(0).getInfe() == 20 && intervalos.get(0).getSupe() == 30)) {
            return false;
        }

        intervalos = logi.un_rango_un_intervalo(new Intervalo(20, 30), new Intervalo(20, 30));
        if (!(intervalos.size() == 0)) {
            return false;
        }

        intervalos = logi.un_rango_un_intervalo(new Intervalo(40, 50), new Intervalo(20, 30));
        if (!(intervalos.get(0).getInfe() == 20 && intervalos.get(0).getSupe() == 30)) {
            return false;
        }

        intervalos = logi.un_rango_un_intervalo(new Intervalo(29, 40), new Intervalo(20, 30));
        if (!(intervalos.get(0).getInfe() == 20 && intervalos.get(0).getSupe() == 29)) {
            return false;
        }
        return true;
    }

    boolean test_un_rango_muchos_intervalos()
    {
        ArrayList<Intervalo> intervalos = new ArrayList<>();
        Logica logi = new Logica();

        return true;
    }

}
