package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

    // CREATE AN EMP
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    // list of employees
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    // UPDATE EMP
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    //find employee by id
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()->new UserNotFoundException("User by id "+id+" was not Found"));
    }


    //DELETE EMP
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

}
