package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;

@SpringBootApplication
public class PayrollApplication {

  public static void main(String... args) {

    // MiTest hola = new MiTest();
    // Facade facade = new Facade();

    // facade.espacios_vacios();
    // System.out.println(hola.test_horas_a_fecha());

    SpringApplication.run(PayrollApplication.class, args);
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:8080/calcular");
      }
    };
  }

}