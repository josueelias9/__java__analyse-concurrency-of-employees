package payroll;

import java.lang.reflect.Array;

import org.json.*;
import java.util.ArrayList;
import java.util.List;

/**
 * logica
 */
public class Logica {

    public Logica() {
        super();
    }

    /*
     * ***********************************************
     * entrada: String
     * salida: JSONObject
     * ***********************************************
     * 
     * Metodos para tranformar XML a JSON para un mejor tratamiento.
     * Iteran sobre objeto JSONObject para extraer informacion de la fecha.
     * 
     */

    public JSONObject xml_a_json(String mi_xml) {
        JSONObject json = XML.toJSONObject(mi_xml);
        return json;
    }

    /*
     * ***********************************************
     * entrada: entero / Fecha / String
     * salida: entero / Fecha
     * ***********************************************
     * 
     * Funciones que operan sobre objetos de la clase Fecha.
     * Transforman de dias a fecha y viseversa.
     * 
     */

    int fecha_a_horas(Fecha fecha) {
        int mes = fecha.getMes();
        int dia = fecha.getDia();
        int hora = fecha.getHora();

        int dias = 0;
        int horas = 0;
        int meses[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int i = 0; i < mes - 1; i++) {
            dias = dias + meses[i];
        }
        // se resta uno porque cuando digo 3 de enero, en realidad han pasado solo 2
        // dias completos, no 3
        dias = dias + dia - 1;
        horas = dias * 24 + hora;

        return horas;
    }

    Fecha horas_a_fecha(int horas) {

        int hora = horas % 24;
        int dias = horas / 24;
        int meses[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int mes = 0;
        int dia = dias;
        for (int i = 0; i < meses.length; i++) {
            dias = dias - meses[i];
            if (0 < dias) {
                dia = dias;
                mes = mes + 1;
            }
        }
        return new Fecha(mes + 1, dia + 1, hora);
    }

    public Fecha string_a_fecha(String olo1) {
        int ano = 0;
        int mes = 0;
        int dia = 0;
        int hora = 0;
        int minuto = 0;
        int segundo = 0;

        String[] arrOfStr1 = olo1.split("-");

        ano = Integer.parseInt((String) Array.get(arrOfStr1, 0));
        mes = Integer.parseInt((String) Array.get(arrOfStr1, 1));

        String olo2 = (String) (String) Array.get(arrOfStr1, 2);
        String[] arrOfStr2 = olo2.split(" ");
        dia = Integer.parseInt((String) Array.get(arrOfStr2, 0));

        String olo3 = (String) (String) Array.get(arrOfStr2, 1);
        String[] arrOfStr3 = olo3.split(":");
        hora = Integer.parseInt((String) Array.get(arrOfStr3, 0));
        minuto = Integer.parseInt((String) Array.get(arrOfStr3, 1));
        segundo = Integer.parseInt((String) Array.get(arrOfStr3, 2));

        return new Fecha(mes, dia, hora);
    }

    /*
     * ***********************************************
     * entrada: Intervalo / ArrayList<Intervalo> / JSONObject
     * salida: ArrayList<Intervalo>
     * ***********************************************
     * 
     * Revisar seccion "Casos" del README.md para entender estas funciones.
     * Es la logica principal del proyecto.
     * 
     */

    public ArrayList<Intervalo> json_a_arraylist(JSONObject json) {
        ArrayList<Intervalo> rangos = new ArrayList<>();
        JSONObject a = (JSONObject) json.get("response");
        JSONArray miarreglo = a.getJSONArray("bar");
        JSONObject aux;
        for (int i = 0; i < miarreglo.length(); i++) {
            aux = miarreglo.getJSONObject(i);
            Fecha start_fecha = string_a_fecha((String) aux.get("startdate"));
            Fecha end_fecha = string_a_fecha((String) aux.get("enddate"));
            rangos.add(new Intervalo(fecha_a_horas(start_fecha), fecha_a_horas(end_fecha)));
        }
        return rangos;
    }

    public ArrayList<Intervalo> un_rango_un_intervalo(Intervalo rango, Intervalo intervalo) {

        int i = rango.getInfe();
        int s = rango.getSupe();
        int a = intervalo.getInfe();
        int b = intervalo.getSupe();

        ArrayList<Intervalo> intervalos = new ArrayList<>();
        // imposible llegar aqui
        if (!(a < b) || !(i < s)) {
            System.out.println("no es posible");
        }
        // caso 1
        else if ((a < i && i < b) && (a < s && s < b)) {
            intervalos.add(new Intervalo(a, i));
            intervalos.add(new Intervalo(s, b));
        }
        // caso 2
        else if (!(a < i && i < b) && (a < s && s < b)) {
            intervalos.add(new Intervalo(s, b));
        }
        // caso 3
        else if ((a < i && i < b) && !(a < s && s < b)) {
            intervalos.add(new Intervalo(a, i));
        }
        // caso 4
        else if (i <= a && b <= s) {
        }
        // caso 5
        else if (b <= i) {
            intervalos.add(new Intervalo(a, b));
        }
        // caso 6
        else if (s <= a) {
            intervalos.add(new Intervalo(a, b));
        }
        // imposible llegar aqui
        else {
            System.out.println("existe otro caso?");
        }

        return intervalos;
    }

    public ArrayList<Intervalo> un_rango_muchos_intervalos(Intervalo rango, ArrayList<Intervalo> intervalos) {

        ArrayList<Intervalo> resultado = new ArrayList<>();
        ArrayList<Intervalo> aux = new ArrayList<>();

        int index = 0;
        while (index < intervalos.size()) {
            aux = this.un_rango_un_intervalo(rango, intervalos.get(index));
            resultado.addAll(aux);
            index = index + 1;
        }

        // int indexb = 0;
        // System.out.println(resultado.size());
        // while (indexb < resultado.size()) {
        // System.out.println(resultado.get(indexb).getInfe() + " " +
        // resultado.get(indexb).getSupe());
        // indexb = indexb + 1;
        // }
        return resultado;
    }

    public ArrayList<Intervalo> muchos_rangos_un_intervalo(ArrayList<Intervalo> rangos, Intervalo intervalo) {
        // intervalo va de 0 a 365 dias ( 1 año). Lo convertiremos en ArrayList
        ArrayList<Intervalo> intervalos = new ArrayList<>();
        intervalos.add(intervalo);
        // llamar a mi_funcion
        for (int i = 0; i < rangos.size(); i++) {
            intervalos = this.un_rango_muchos_intervalos(rangos.get(i), intervalos);
        }
        return intervalos;
    }

}