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
     * entrada: String
     * salida: String
     */
    public String retorna_todo(String hi) {
        JSONObject json = XML.toJSONObject(hi);
        String hola = json.toString(4);
        return hola;
    }

    /*
     * entrada: String
     * salida: String
     */
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

    public void mi_funcion() {

        ArrayList<Intervalo> names = new ArrayList<>();

        names.add(new Intervalo(0, 100));
        int a = names.get(0).getInfe();
        int b = names.get(0).getSupe();
        int i = -10;
        int s = 200;

        
        if (!(a < b) || !(i < s)) {
            System.out.println("no es posible");
        } else if ((a < i && i < b) && (a < s && s < b)) {
            System.out.println("caso 1");
            names.remove(0);
            names.add(new Intervalo(a, i));
            names.add(new Intervalo(s, b));
        } else if (!(a < i && i < b) && (a < s && s < b)) {
            System.out.println("caso 2");
            names.add(new Intervalo(s, b));
        } else if ((a < i && i < b) && !(a < s && s < b)) {
            System.out.println("caso 3");
            names.add(new Intervalo(a, i));
        } else if (i <= a && b <= s) {
            System.out.println("caso 4");
            names.remove(0);
        } else if (b <= i) {
            System.out.println("caso 5");
        } else if (s <= a) {
            System.out.println("caso 6");
        } else {
            System.out.println("existe otro caso?");
        }

        // Intervalo hola = new Intervalo(2, 10);
        // names.add(hola);
        // Intervalo hola2 = new Intervalo(7, 20);
        // names.add(hola2);
        //
        int index = 0;
        while (index < names.size()) {
            System.out.println(names.get(index).getInfe() + " " + names.get(index).getSupe());
            index = index + 1;
        }
        //// string can first be stored in a variable
        // String name = "Betty Jennings";
        //// then add it to the list
        // names.add(name);
        //
        //// strings can also be directly added to the list:
        // names.add("Betty Snyder");
        // names.add("Frances Spence");
        // names.add("Kay McNulty");
        // names.add("Marlyn Wescoff");
        // names.add("Ruth Lichterman");
        //
        //// several different repeat statements can be
        //// used to go through the list elements
        //
        //// 1. while loop
        // int index = 0;
        // while (index < names.size()) {
        // System.out.println(names.get(index));
        // index = index + 1;
        // }
        //
        //// 2. for loop with index
        // for (int i = 0; i < names.size(); i++) {
        // System.out.println(names.get(i));
        // }
        //
        // System.out.println();
        //// 3. for each loop (no index)
        // for (String name: names) {
        // System.out.println(name);
        // } }

    }
}