package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class PayrollApplication {

  public static void main(String... args) {

    MiTest hola = new MiTest();
    System.out.println(hola.test_muchos_rangos_un_intervalo());
    
    SpringApplication.run(PayrollApplication.class, args);
  }
}