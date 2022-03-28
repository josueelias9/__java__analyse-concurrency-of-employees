package payroll;
import org.json.*;

import java.util.ArrayList;


public class MiTest {


    boolean test_espacios_vacios_fechas(){
        Facade faca = new Facade();
        ArrayList<Fecha> test = new ArrayList<>();
        String xml = "";
        /**
         * TEST 1
         * startdate='2015-01-20 08:00:00' enddate='2015-01-20 17:00:00'
         * startdate='2015-01-23 08:00:00' enddate='2015-01-23 17:00:00'
         * startdate='2015-01-22 08:00:00' enddate='2015-01-22 17:00:00'
         * startdate='2015-01-27 08:00:00' enddate='2015-01-27 17:00:00'
         * startdate='2015-01-26 08:00:00' enddate='2015-01-26 17:00:00'
         */
        xml = "<response>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-20 17:00:00' group='2' id='72780' isdbar='false' name='LoLa' startdate='2015-01-20 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-23 17:00:00' group='2' id='72783' isdbar='false' name='LoLa' startdate='2015-01-23 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-22 17:00:00' group='2' id='72782' isdbar='false' name='LoLa' startdate='2015-01-22 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-27 17:00:00' group='2' id='72785' isdbar='false' name='LoLa' startdate='2015-01-27 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-26 17:00:00' group='2' id='72784' isdbar='false' name='LoLa' startdate='2015-01-26 08:00:00' type='0' useroffset='2' usertype='0'/></response>  ";
        test = faca.espacios_vacios_fechas(xml);

        //for (int i = 0; i < test.size(); i++) {
        //    System.out.println(test.get(i).getMes() + " " + test.get(i).getDia() + " " + test.get(i).getHora()+ " " + test.get(i).getMinuto());
        //}
        /**
         * TEST 2

        startdate='2015-01-23 08:00:00'  enddate='2015-01-23 10:30:00'
        startdate='2015-01-22 10:00:00'  enddate='2015-01-22 19:00:00'
        startdate='2015-01-22 10:00:00'  enddate='2015-01-22 14:00:00'
        startdate='2015-01-23 10:00:00'  enddate='2015-01-23 19:00:00'
        startdate='2015-01-23 10:00:00'  enddate='2015-01-23 14:00:00'
        startdate='2015-01-21 19:00:00'  enddate='2015-01-21 19:50:00'
         */

   
        xml = "<response>  <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-23 10:30:00' group='6' id='73582' isdbar='false' name='Ranee Xia' startdate='2015-01-23 08:00:00' type='1' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='13' dateoffset='8' dcname='Alfa' enddate='2015-01-22 19:00:00' group='0' hasnccduty='true' id='73810' isdbar='false' name='Victor Ma' startdate='2015-01-22 10:00:00' type='0' useroffset='2' usertype='0'/>    <bar comment='' datacenter='13' dateoffset='8' dcname='Alfa' enddate='2015-01-22 14:00:00' group='0' hasnccduty='true' id='73810' isdbar='true' name='Victor Ma' startdate='2015-01-22 10:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='13' dateoffset='8' dcname='Alfa' enddate='2015-01-23 19:00:00' group='0' hasnccduty='true' id='74134' isdbar='false' name='Victor Ma' startdate='2015-01-23 10:00:00' type='0' useroffset='2' usertype='0'/>    <bar comment='' datacenter='13' dateoffset='8' dcname='Alfa' enddate='2015-01-23 14:00:00' group='0' hasnccduty='true' id='74134' isdbar='true' name='Victor Ma' startdate='2015-01-23 10:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='13' dateoffset='8' dcname='Alfa' enddate='2015-01-21 19:50:00' group='0' id='74058' isdbar='false' name='Victor Ma' startdate='2015-01-21 19:00:00' type='0' useroffset='2' usertype='0'/>  </response>";
        test = faca.espacios_vacios_fechas(xml);

        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i).getMes() + " " + test.get(i).getDia() + " " + test.get(i).getHora()+ " " + test.get(i).getMinuto());
        }
        return false;
    }


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

    boolean test_json_a_arraylist() {
        String xml = "<response>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-20 17:00:00' group='2' id='72780' isdbar='false' name='LoLa' startdate='2015-01-20 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-23 17:00:00' group='2' id='72783' isdbar='false' name='LoLa' startdate='2015-01-23 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-22 17:00:00' group='2' id='72782' isdbar='false' name='LoLa' startdate='2015-01-22 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-27 17:00:00' group='2' id='72785' isdbar='false' name='LoLa' startdate='2015-01-27 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-26 17:00:00' group='2' id='72784' isdbar='false' name='LoLa' startdate='2015-01-26 08:00:00' type='0' useroffset='2' usertype='0'/></response>  ";
        Logica logi = new Logica();
        ArrayList<Intervalo> rangos = logi.json_a_arraylist(logi.xml_a_json(xml));

        /*
         * para el primer elemento de json:
         * 
         * enddate = '2015-01-20 17:00:00'
         * startdate = '2015-01-20 08:00:00'
         * 
         * startdate:
         * - meses = 0
         * - dias = 19 dias
         * - horas = 19*24 + 8 = 464
         * 
         * enddate:
         * - meses = 0
         * - dias = 19
         * - horas = 19*24 + 17 = 473
         * 
         */

        if (rangos.get(0).getInfe() != 464)
            return false;
        if (rangos.get(0).getSupe() != 473)
            return false;
        return true;
    }

    boolean test_minutos_a_fecha() {
/*
        dias del año 2015
        31 enero 
        28 febrero
        31 marzo
        30 abril
        31 mayo
        30 junio
        31 julio
        31 agosto
        30 septiembre
        31 octubre
        30 noviembre
        31 diciembre
*/
        Logica logi = new Logica();
        Fecha fecha = new Fecha(0, 0, 0, 0);
        
        // test 1: 3008 minutos han pasado hasta el 3 de enero con 2:08 minutos
        fecha = logi.minutos_a_fecha(3008);
        if (fecha.getMes() != 1)
            return false;
        if (fecha.getDia() != 3)
            return false;
        if (fecha.getHora() != 2)
            return false;
        if (fecha.getMinuto() != 8)
            return false;
        // test 2: 7200 minutos han pasado hasta el 36de enero con 0:00 minutos
        fecha = logi.minutos_a_fecha(7200);
        if (fecha.getMes() != 1)
            return false;
        if (fecha.getDia() != 6)
            return false;
        if (fecha.getHora() != 0)
            return false;
        if (fecha.getMinuto() != 0)
            return false;
        // test 3: 84960 minutos han pasado hasta el 1 de marzo con 0:00 horas
        fecha = logi.minutos_a_fecha(84960);
        if (fecha.getMes() != 3)
            return false;
        if (fecha.getDia() != 1)
            return false;
        if (fecha.getHora() != 0)
            return false;
        if (fecha.getMinuto() != 0)
            return false;

    return true;
    }

    boolean test_fecha_a_minutos() {
        Logica logi = new Logica();
        /*
         * Hasta el 1 de marzo, a las 0:00 horas, ¿cuantos minutos han transcurrido?
         * - resumen: 2 meses + 0 dias + 0 horas + 0 minutos
         * 
         * - meses a minutos = (31 + 28) x 24 x 60 = 84960
         * - dias a minutos = 0
         * - horas a minutos = 0
         * 
         * - total: 84960 + 0 + 0 + 0 = 84960
         *  
         */
        if (!(logi.fecha_a_minutos(new Fecha(3, 1, 0, 0)) == 84960)) {
            return false;
        }

        /*
         * Hasta el 6 de enero, a las 0:00 horas, ¿cuantas minutos han transcurrido?
         * - resumen: 0 meses + 5 dias + 0 horas + 0 minutos
         * 
         * - meses a minutos = 0
         * - dias a minutos = 5 x 24 x 60 = 7200
         * - horas a minutos = 0
         * 
         * - total: 0 + 7200 + 0 + 0 = 7200
         * 
         */
        if (!(logi.fecha_a_minutos(new Fecha(1, 6, 0, 0)) == 7200)) {
            return false;
        }

        /*
         * Hasta el 10 de febrero, a las 8 horas, ¿cuantas horas han transcurrido?
         * - resumen: 1 meses + 9 dias + 8 horas + 0 minutos
         * 
         * - meses a minutos = (31) x 24 x 60 = 44640
         * - dias a minutos = 9 x 24 x 60 = 12960
         * - horas a minutos = 8 x 60 = 480
         * 
         * - total: 44640 + 12960 + 480 + 0 = 58080
         * 
         */
        if (!(logi.fecha_a_minutos(new Fecha(2, 10, 8, 0)) == 58080)) {
            return false;
        }

        /*
         * Hasta el 3 de enero, a las 2:08 horas, ¿cuantos minutos han transcurrido?
         * - resumen: 0 meses + 2 dias + 2 horas + 8 minutos
         * 
         * - meses a minutos = 0
         * - dias a minutos = 2 x 24 x 60 = 2880
         * - horas a minutos = 2 x 60 = 120
         * 
         * - total: 0 + 2880 + 120 + 8 = 3008
         */

        if (!(logi.fecha_a_minutos(new Fecha(1, 3, 2, 8)) == 3008)) {
            return false;
        }
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
