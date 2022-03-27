package payroll;

import java.util.ArrayList;


public class MiTest {

    boolean test_horas_a_fecha() {
        Logica logi = new Logica();
        Fecha fecha = logi.horas_a_fecha(968);
        if (fecha.getMes() != 2)
            return false;
        if (fecha.getDia() != 10)
            return false;
        if (fecha.getHora() != 8)
            return false;
        return true;
    }

    boolean test_fecha_a_horas(){
        Logica logi = new Logica();
        /*
        Hasta el 10 de febrero, a las 8 horas, ¿cuantas horas han transcurrido?
        - meses transcurridos: solo uno, enero. TOTAL = 1 meses
        - dias trancurridos: enero tiene 31 dias. Si estamos 10/02 entonces ya pasaron 9 dias completos de febrero. TOTAL = 31 + 9 dias
        - horas transcurridas: hay que multiplicar los dias transcurridos por 24. Al resultado hay que sumarle las 8 horas que ya pasaron. TOTAL = (31 + 9) x 24 + 8 horas. 
        */
        if (!(logi.fecha_a_horas(new Fecha(2,10,8)) == 968)){
            return false;
        }
        
        /*
        Hasta el 30 de septiembre, a las 23 horas, ¿cuantas horas han transcurrido?
        - meses transcurridos: 8 meses completos hasta agosto. MESES TOTALES = 8 meses
        - dias trancurridos: septiembre tiene 30 dias. Si estamos 30/09 entonces ya pasaron 29 dias completos de septiembre. Tener en cuenta que cada mes tiene distintos dias. DIAS TOTALES =  (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31) + 29 dias
        - horas transcurridas: hay que multiplicar los dias transcurridos por 24. Al resultado hay que sumarle las 23 horas que ya pasaron. TOTAL = (DIAS TOTALES) x 24 + 23 horas. 
        */
        if (!(logi.fecha_a_horas(new Fecha(9,30,23)) == 6551)){
            return false;
        }
//
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
