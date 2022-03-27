package payroll;
import java.util.ArrayList;

public class Facade {


    void espacios_vacios(){
        String xml = "<response>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-20 17:00:00' group='2' id='72780' isdbar='false' name='LoLa' startdate='2015-01-20 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-23 17:00:00' group='2' id='72783' isdbar='false' name='LoLa' startdate='2015-01-23 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-22 17:00:00' group='2' id='72782' isdbar='false' name='LoLa' startdate='2015-01-22 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-27 17:00:00' group='2' id='72785' isdbar='false' name='LoLa' startdate='2015-01-27 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-26 17:00:00' group='2' id='72784' isdbar='false' name='LoLa' startdate='2015-01-26 08:00:00' type='0' useroffset='2' usertype='0'/></response>  ";
       
        Logica logi = new Logica();
        System.out.println(logi.xml_a_json(xml).toString(4));
        ArrayList<Intervalo> rangos = logi.json_a_arraylist(logi.xml_a_json(xml));

        ArrayList<Intervalo> test = logi.muchos_rangos_un_intervalo(rangos,new Intervalo(0, 365*24));

        
        for(int i = 0 ; i < test.size(); i++){
            System.out.println(test.get(i).getInfe()+" "+ test.get(i).getSupe());  
            
            Fecha uno1 =logi.horas_a_fecha(test.get(i).getInfe());
            Fecha uno2 =logi.horas_a_fecha(test.get(i).getSupe());

            //System.out.println(uno1.getMes()+" "+uno1.getDia()+" "+uno1.getHora()+" --- "+uno2.getMes()+" "+uno2.getDia()+" "+uno2.getHora());
        }



// 0 464
// 1 1 0 --- 1 1 8
// 473 512
// 1 1 17 --- 1 1 8
// 521 536
// 1 1 17 --- 1 1 8
// 545 608
// 1 1 17 --- 1 1 8
// 617 632
// 1 1 17 --- 1 1 8
// 641 8760
// 1 1 17 --- 12 32 0

    }
    
}
