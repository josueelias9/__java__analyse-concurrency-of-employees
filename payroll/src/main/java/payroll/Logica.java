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

    public ArrayList<Intervalo> un_rango_muchos_intervalos(Intervalo rangos, ArrayList<Intervalo> intervalos) {

        ArrayList<Intervalo> auxiliar = new ArrayList<>();

        intervalos.add(new Intervalo(0, 100));
        intervalos.add(new Intervalo(40, 60));
        int i = rangos.infe;
        int s = rangos.supe;
        int a = 0;
        int b = 0;

        int index = 0;
        while (index < intervalos.size()) {
            a = intervalos.get(index).getInfe();
            b = intervalos.get(index).getSupe();

            if (!(a < b) || !(i < s)) {
                System.out.println("no es posible");
            } else if ((a < i && i < b) && (a < s && s < b)) {
                System.out.println("caso 1");
                auxiliar.add(new Intervalo(a, i));
                auxiliar.add(new Intervalo(s, b));
            } else if (!(a < i && i < b) && (a < s && s < b)) {
                System.out.println("caso 2");
                auxiliar.add(new Intervalo(s, b));
            } else if ((a < i && i < b) && !(a < s && s < b)) {
                System.out.println("caso 3");
                auxiliar.add(new Intervalo(a, i));
            } else if (i <= a && b <= s) {
                System.out.println("caso 4");
            } else if (b <= i) {
                System.out.println("caso 5");
                auxiliar.add(new Intervalo(a, b));
            } else if (s <= a) {
                System.out.println("caso 6");
                auxiliar.add(new Intervalo(a, b));
            } else {
                System.out.println("existe otro caso?");
            }
            index = index + 1;
        }

        int indexb = 0;
        System.out.println(auxiliar.size());
        while (indexb < auxiliar.size()) {
            System.out.println(auxiliar.get(indexb).getInfe() + " " + auxiliar.get(indexb).getSupe());
            indexb = indexb + 1;
        }
        return auxiliar;
    }

    ArrayList<Intervalo> muchos_rangos_muchos_intervalos(ArrayList<Intervalo> rangos, ArrayList<Intervalo> intervalos) {

        // llamar a mi_funcion
        for (int i = 0; i < rangos.size(); i++) {
            un_rango_muchos_intervalos(rangos.get(i), intervalos);
        }
        return rangos;
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