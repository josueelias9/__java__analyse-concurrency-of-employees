package payroll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
class EmployeeController {

  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/calcular")
  ArrayList<Intervalo> calcular_get() {
    String xml = "<response><bar addedby='' comment='' datacenter='13' dateoffset='8' dcname='Alfa' enddate='2015-01-20 18:00:00' extension=' ' group='1' id='73969' isdbar='false' name='Kameron Diazzz' startdate='2015-01-20 09:00:00' type='0' useroffset='2' usertype='0'/><bar addedby='' comment='' datacenter='13' dateoffset='8' dcname='Alfa' enddate='2015-01-22 18:00:00' extension=' ' group='1' id='74074' isdbar='false' name='Kameron Diazzz' startdate='2015-01-22 09:00:00' type='0' useroffset='2' usertype='0'/></response>";
    Facade facade = new Facade();
    return facade.espacios_vacios(xml);
  }

  @PostMapping("/calcular")
  List<Intervalo> calcular_post(@RequestBody String xml) {
    Facade facade = new Facade();

    return facade.espacios_vacios(xml);
  }

  // Single item

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {

    return repository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return repository.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repository.save(employee);
        })
        .orElseGet(() -> {
          newEmployee.setId(id);
          return repository.save(newEmployee);
        });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}