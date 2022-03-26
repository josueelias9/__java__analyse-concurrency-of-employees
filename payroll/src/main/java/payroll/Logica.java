package payroll;

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
     * entrada: String / entero
     * salida: String
     * ***********************************************
     * 
     * Metodos para tranformar XML a JSON para un mejor tratamiento.
     * Iteran sobre objeto JSONObject para extraer informacion de la fecha.
     * 
     */
    public String retorna_todo(String hi) {
        JSONObject json = XML.toJSONObject(hi);
        String hola = json.toString(4);
        return hola;
    }

    public String retorna_json(String xml) {
        JSONObject json = XML.toJSONObject(xml);
        JSONObject a = (JSONObject) json.get("response");
        String jsonString = a.toString(4);
        return jsonString;
    }

    public String retorna_lista(String xml, int num) {
        JSONObject json = XML.toJSONObject(xml);
        JSONObject a = (JSONObject) json.get("response");
        JSONArray ja_data = a.getJSONArray("bar");
        JSONObject jObj = ja_data.getJSONObject(num);
        String hola = (String) jObj.get("startdate");
        return hola;

    }
    /*
     * ***********************************************
     * entrada: Intervalo / ArrayList<Intervalo>
     * salida: ArrayList<Intervalo>
     * ***********************************************
     * 
     * Revisar seccion "Casos" del README.md para entender estas funciones.
     * Es la logica principal del proyecto.
     * 
     */

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

        //int indexb = 0;
        //System.out.println(resultado.size());
        //while (indexb < resultado.size()) {
        //    System.out.println(resultado.get(indexb).getInfe() + " " + resultado.get(indexb).getSupe());
        //    indexb = indexb + 1;
        //}
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

    /*
     * ***********************************************
     * entrada: entero / Fecha
     * salida: entero / Fecha
     * ***********************************************
     * 
     * Funciones que operan sobre objetos de la clase Fecha.
     * Transforman de dias a fecha y viseversa.
     * 
     */

    int fecha_a_dias(Fecha fecha) {
        int mes = fecha.getMes();
        int dia = fecha.getDia();

        int dias = 0;
        int meses[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int i = 0; i < mes - 1; i++) {
            dias = dias + meses[i];
        }
        dias = dias + dia;
        return dias;
    }

    Fecha dias_a_fecha(int dias) {
        int meses[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int conteo = 0;
        int dias_aux = 0;
        for (int i = 0; i < meses.length; i++) {
            dias = dias - meses[i];
            if (0 < dias) {
                dias_aux = dias;
                conteo = conteo + 1;
            }
        }
        return new Fecha(conteo, dias_aux);
    }

}