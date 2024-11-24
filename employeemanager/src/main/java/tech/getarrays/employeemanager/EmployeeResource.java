package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeResource {

    // using service
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Return all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees= employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // get empl by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
       Employee employees= employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
