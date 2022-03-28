package payroll;

import java.util.ArrayList;

public class Facade {

    ArrayList<Intervalo> espacios_vacios_intervalos(String xml) {
        Logica logi = new Logica();
        ArrayList<Intervalo> rangos = logi.json_a_arraylist(logi.xml_a_json(xml));
        ArrayList<Intervalo> test = logi.muchos_rangos_un_intervalo(rangos, new Intervalo(0, 365 * 24));
        return test;
    }
    ArrayList<Fecha> espacios_vacios_fechas(String xml) {
        Logica logi = new Logica();
        ArrayList<Intervalo> rangos = logi.json_a_arraylist(logi.xml_a_json(xml));
        ArrayList<Intervalo> test = logi.muchos_rangos_un_intervalo(rangos, new Intervalo(0, 365 * 24));

        ArrayList<Fecha> fechas = new ArrayList<>();

        Fecha fecha = new Fecha(0,0,0);
        
        for(int i = 0 ; i < test.size(); i++){
            fecha = logi.horas_a_fecha(test.get(i).getInfe());
            fechas.add(fecha);
            fecha = logi.horas_a_fecha(test.get(i).getSupe());
            fechas.add(fecha);
        }
        return fechas;
    }

}
