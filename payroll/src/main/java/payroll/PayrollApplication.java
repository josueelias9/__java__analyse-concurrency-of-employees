package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.parser.XmlTreeBuilder;
import org.json.*;

@SpringBootApplication
public class PayrollApplication {

  public static void main(String... args) {
    String xml= "<response>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-20 17:00:00' group='2' id='72780' isdbar='false' name='LoLa' startdate='2015-01-20 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-23 17:00:00' group='2' id='72783' isdbar='false' name='LoLa' startdate='2015-01-23 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-22 17:00:00' group='2' id='72782' isdbar='false' name='LoLa' startdate='2015-01-22 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-27 17:00:00' group='2' id='72785' isdbar='false' name='LoLa' startdate='2015-01-27 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-26 17:00:00' group='2' id='72784' isdbar='false' name='LoLa' startdate='2015-01-26 08:00:00' type='0' useroffset='2' usertype='0'/></response>  ";  
    JSONObject json = XML.toJSONObject(xml); 
    String jsonString = json.toString(4);  
    //JSONParser parser = new JSONParser();
    JSONObject a=(JSONObject) json.get("response");

    //System.out.println(a);  
    System.out.println(a.get("bar"));
    //String html="<bar addedby='' comment='' datacenter='13' dateoffset='8' dcname='Alfa' enddate='2015-01-27 22:00:00' group='2' id='72986' isdbar='false' name='Jonh Smit' startdate='2015-01-27 09:00:00' type='0' useroffset='2' usertype='0'/>";
    //Document doc = Jsoup.parse(html, "", Parser.xmlParser());
    //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
    //Document doc = Jsoup.parse(html);
    //Element link = doc.select("a").first();
 //   for(Element e: doc.select("bar")){
 //     System.out.println(e);
 // }
    //String linkHref = link.attr("href"); // "http://example.com/"
    //String linkText = link.text(); // "example""
    //
    //String linkOuterH = link.outerHtml();
    //// "<a href="http://example.com"><b>example</b></a>"
    //String linkInnerH = link.html(); // "<b>example</b>"
   // System.out.println(doc);
    //System.out.println(linkHref);
    //System.out.println(linkText);
    //System.out.println(linkOuterH);
    //System.out.println(linkInnerH);
    
    SpringApplication.run(PayrollApplication.class, args);
  }
}