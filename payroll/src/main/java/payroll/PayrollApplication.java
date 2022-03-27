package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class PayrollApplication {

  public static void main(String... args) {

    MiTest hola = new MiTest();
    Facade facade = new Facade();
    

    //facade.espacios_vacios();
    //System.out.println(hola.test_horas_a_fecha());
    
    SpringApplication.run(PayrollApplication.class, args);
  }
}