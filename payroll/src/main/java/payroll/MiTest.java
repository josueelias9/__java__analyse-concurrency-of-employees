package payroll;

import java.util.ArrayList;

public class MiTest {

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
                                           *====================*      rango
               *======*             *====================*             intervalos
               *======*             *======*                           resultado
        0      50     100    150    200    250    300    350    365 
        |------|------|------|------|------|------|------|------|
        
        
                                           *======*                    rango           
                      *======*      *====================*             intervalos
                      *======*      *======*      *======*             resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
        
               *====================*                                  rango
                      *======*      *====================*             intervalos  
                                    *====================*             resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
                             *======*                                  rango
                      *======*      *====================*             intervalos  
                      *======*      *====================*             resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
               *================================================*      rango
                      *======*      *====================*             intervalos  
                                                                       resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
               *============================*                          rango
                      *======*      *====================*             intervalos  
                                           *=============*             resultado
        0      50     100    150    200    250    300    350    365  
        |------|------|------|------|------|------|------|------|
        
               *======*                                                rango
                      *======*      *====================*             intervalos  
                      *======*      *====================*             resultado  
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
        return true;
    }

}
