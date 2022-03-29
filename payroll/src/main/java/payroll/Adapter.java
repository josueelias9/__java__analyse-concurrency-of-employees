package payroll;

import org.json.JSONObject;
import org.json.*;

public class Adapter {
    Logica logica;

    public Adapter(Logica logica) {
        this.logica = logica;
    }

    /*
     * convierte de Fecha a String
     */
    public JSONObject conversor(String mi_xml) {
        JSONObject json = XML.toJSONObject(mi_xml);
        return json;
    }

    public void metodo_adapter() {
        JSONObject hola = this.conversor("{'s':'s'}");
        logica.json_a_arraylist(hola);
    }

}
