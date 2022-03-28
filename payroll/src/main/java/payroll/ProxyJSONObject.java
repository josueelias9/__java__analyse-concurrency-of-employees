package payroll;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProxyJSONObject {
    JSONObject mi_json;

    public ProxyJSONObject(JSONObject mi_json) {
        this.mi_json = mi_json;
    }

    public JSONObject getMi_json() {
        return this.mi_json;
    }

    public JSONObject operation() {


        JSONObject a = (JSONObject) mi_json.get("response");
        JSONArray miarreglo = a.getJSONArray("bar");
        JSONObject aux = miarreglo.getJSONObject(0);

        return aux;
    }

}
