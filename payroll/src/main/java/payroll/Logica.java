package payroll;

import org.json.*;
/**
 * logica
 */
public class Logica {

    public Logica() {
        super();
    }
    /*
    entrada: String
    salida: String
    */
    public String retorna_todo(String hi){
        JSONObject json = XML.toJSONObject(hi);
        String hola = json.toString(4);
        return hola;
    }
    /*
    entrada: String
    salida: String
    */
    public String retorna_json(String xml) {
        JSONObject json = XML.toJSONObject(xml);
        JSONObject a = (JSONObject) json.get("response");
        String jsonString = a.toString(4);
        return jsonString;
        // JSONParser parser = new JSONParser();
        // System.out.println(a);
        //System.out.println(a.get("bar"));
        // String html="<bar addedby='' comment='' datacenter='13' dateoffset='8'
        // dcname='Alfa' enddate='2015-01-27 22:00:00' group='2' id='72986'
        // isdbar='false' name='Jonh Smit' startdate='2015-01-27 09:00:00' type='0'
        // useroffset='2' usertype='0'/>";
        // Document doc = Jsoup.parse(html, "", Parser.xmlParser());
        // String html = "<p>An <a href='http://example.com/'><b>example</b></a>
        // link.</p>";
        // Document doc = Jsoup.parse(html);
        // Element link = doc.select("a").first();
        // for(Element e: doc.select("bar")){
        // System.out.println(e);
        // }
        // String linkHref = link.attr("href"); // "http://example.com/"
        // String linkText = link.text(); // "example""
        //
        // String linkOuterH = link.outerHtml();
        //// "<a href="http://example.com"><b>example</b></a>"
        // String linkInnerH = link.html(); // "<b>example</b>"
        // System.out.println(doc);
        // System.out.println(linkHref);
        // System.out.println(linkText);
        // System.out.println(linkOuterH);
        // System.out.println(linkInnerH);

    }
}