package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class PayrollApplication {

  public static void main(String... args) {

    MiTest hola = new MiTest();
    System.out.println(hola.test_xml_a_json());
    
    System.out.println(hola.test_xml_a_arraylist());
    
    SpringApplication.run(PayrollApplication.class, args);
  }
}