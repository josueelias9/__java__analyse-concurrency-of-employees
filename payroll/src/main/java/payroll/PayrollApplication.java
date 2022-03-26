package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class PayrollApplication {

  public static void main(String... args) {

    String xml = "<response>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-20 17:00:00' group='2' id='72780' isdbar='false' name='LoLa' startdate='2015-01-20 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-23 17:00:00' group='2' id='72783' isdbar='false' name='LoLa' startdate='2015-01-23 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-22 17:00:00' group='2' id='72782' isdbar='false' name='LoLa' startdate='2015-01-22 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-27 17:00:00' group='2' id='72785' isdbar='false' name='LoLa' startdate='2015-01-27 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-26 17:00:00' group='2' id='72784' isdbar='false' name='LoLa' startdate='2015-01-26 08:00:00' type='0' useroffset='2' usertype='0'/></response>  ";

    MiTest hola = new MiTest();
    System.out.println(hola.test_un_rango_un_intervalo());
    System.out.println(hola.test_un_rango_muchos_intervalos());
    
    SpringApplication.run(PayrollApplication.class, args);
  }
}