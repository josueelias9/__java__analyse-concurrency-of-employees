package payroll;
import org.json.*;
import java.util.ArrayList;

public class MiTest {

    boolean test_xml_a_json() {

        String xml = "<response>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-20 17:00:00' group='2' id='72780' isdbar='false' name='LoLa' startdate='2015-01-20 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-23 17:00:00' group='2' id='72783' isdbar='false' name='LoLa' startdate='2015-01-23 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-22 17:00:00' group='2' id='72782' isdbar='false' name='LoLa' startdate='2015-01-22 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-27 17:00:00' group='2' id='72785' isdbar='false' name='LoLa' startdate='2015-01-27 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-26 17:00:00' group='2' id='72784' isdbar='false' name='LoLa' startdate='2015-01-26 08:00:00' type='0' useroffset='2' usertype='0'/></response>  ";
        Logica logi = new Logica();
        JSONObject json = logi.xml_a_json(xml);
        String s_json = json.toString(4);
        System.out.println(s_json);
        if (!("org.json.JSONObject" == logi.xml_a_json(xml).getClass().getName()))
            return false;
        return true;
    }

    boolean test_xml_a_arraylist(){
        String xml = "<response>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-20 17:00:00' group='2' id='72780' isdbar='false' name='LoLa' startdate='2015-01-20 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-23 17:00:00' group='2' id='72783' isdbar='false' name='LoLa' startdate='2015-01-23 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-22 17:00:00' group='2' id='72782' isdbar='false' name='LoLa' startdate='2015-01-22 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-27 17:00:00' group='2' id='72785' isdbar='false' name='LoLa' startdate='2015-01-27 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-26 17:00:00' group='2' id='72784' isdbar='false' name='LoLa' startdate='2015-01-26 08:00:00' type='0' useroffset='2' usertype='0'/></response>  ";
        Logica logi = new Logica();
        logi.xml_a_arraylist(xml);
        return true;
    }

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
 
        /* 
        test 1
                                           *====================*      rango
               *======*             *====================*             intervalos
               *======*             *======*                           resultado
        0      50     100    150    200    250    300    350    365 
        |------|------|------|------|------|------|------|------|
        
        test 2
                                           *======*                    rango           
                      *======*      *====================*             intervalos
                      *======*      *======*      *======*             resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
        test 3
               *====================*                                  rango
                      *======*      *====================*             intervalos  
                                    *====================*             resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
        test 4
                             *======*                                  rango
                      *======*      *====================*             intervalos  
                      *======*      *====================*             resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
        test 5
               *================================================*      rango
                      *======*      *====================*             intervalos  
                                                                       resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
        test 6
               *============================*                          rango
                      *======*      *====================*             intervalos  
                                           *=============*             resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
        test 7
               *======*                                                rango
                      *======*      *====================*             intervalos  
                      *======*      *====================*             resultado  
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|

        test 8
                             *=============*                           rango
                                    *====================*             intervalos  
                                           *=============*             resultado  
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
        */
        // genero intervalos...
        ArrayList<Intervalo> intervalos = new ArrayList<>();

        intervalos.add(new Intervalo(100,150));
        intervalos.add(new Intervalo(200,350));
        // preparo variables para el test...
        ArrayList<Intervalo> testear = new ArrayList<>();
        Logica logi = new Logica();
        // primer test...
        testear = logi.un_rango_muchos_intervalos(new Intervalo(250, 365), intervalos);
        if (!(testear.size() == 2))
            return false;
        if (!(testear.get(0).getInfe() == 100))
            return false;
        if (!(testear.get(0).getSupe() == 150))
            return false;
        if (!(testear.get(1).getInfe() == 200))
            return false;
        if (!(testear.get(1).getSupe() == 250))
            return false;
        // segundo test...
        testear = logi.un_rango_muchos_intervalos(new Intervalo(250, 300), intervalos);
        if (!(testear.size() == 3))
            return false;
        if (!(testear.get(0).getInfe() == 100))
            return false;
        if (!(testear.get(0).getSupe() == 150))
            return false;
        if (!(testear.get(1).getInfe() == 200))
            return false;
        if (!(testear.get(1).getSupe() == 250))
            return false;
        if (!(testear.get(2).getInfe() == 300))
            return false;
        if (!(testear.get(2).getSupe() == 350))
            return false;
        // tercer test...
        testear = logi.un_rango_muchos_intervalos(new Intervalo(50, 200), intervalos);
        if (!(testear.size() == 1))
            return false;
        if (!(testear.get(0).getInfe() == 200))
            return false;
        if (!(testear.get(0).getSupe() == 350))
            return false;
        // cuarto test...
        testear = logi.un_rango_muchos_intervalos(new Intervalo(150, 200), intervalos);
        if (!(testear.size() == 2))
            return false;
        if (!(testear.get(0).getInfe() == 100))
            return false;
        if (!(testear.get(0).getSupe() == 150))
            return false;
        if (!(testear.get(1).getInfe() == 200))
            return false;
        if (!(testear.get(1).getSupe() == 350))
            return false;
        // quinto test...
        testear = logi.un_rango_muchos_intervalos(new Intervalo(50, 365), intervalos);
        if (!(testear.size() == 0))
            return false;
        // sexto test...
        testear = logi.un_rango_muchos_intervalos(new Intervalo(50, 250), intervalos);
        if (!(testear.size() == 1))
            return false;
        if (!(testear.get(0).getInfe() == 250))
            return false;
        if (!(testear.get(0).getSupe() == 350))
            return false;
        // septimo test...
        testear = logi.un_rango_muchos_intervalos(new Intervalo(50, 100), intervalos);
        if (!(testear.size() == 2))
            return false;
        if (!(testear.get(0).getInfe() == 100))
            return false;
        if (!(testear.get(0).getSupe() == 150))
            return false;
        if (!(testear.get(1).getInfe() == 200))
            return false;
        if (!(testear.get(1).getSupe() == 350))
            return false;
        // octavo test...
        intervalos.remove(0);
        testear = logi.un_rango_muchos_intervalos(new Intervalo(150, 250), intervalos);
        if (!(testear.size() == 1))
            return false;
        if (!(testear.get(0).getInfe() == 250))
            return false;
        if (!(testear.get(0).getSupe() == 350))
            return false;
        return true;
    }


    boolean test_muchos_rangos_un_intervalo(){
        /*
        test 7
               *======*      *=============*      *======*             rangos
        *=======================================================*      intervalo unico (365 dias)  
        *======*      *======*             *======*      *======*      resultado  
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|        
        */
        
        // inicializamos los rangos
        ArrayList<Intervalo> rangos = new ArrayList<>();

        rangos.add(new Intervalo(50,100));
        rangos.add(new Intervalo(150,250));
        rangos.add(new Intervalo(300,350));
        
        // testeamos funcion
        Logica logi = new Logica();

        ArrayList<Intervalo> test = logi.muchos_rangos_un_intervalo(rangos,new Intervalo(0, 365));

        if(!(test.size()==4)){
            return false;
        }


        for(int i = 0 ; i < test.size(); i++){
            System.out.println(test.get(i).getInfe()+" "+ test.get(i).getSupe());            
        }
        return true;
    }

}
