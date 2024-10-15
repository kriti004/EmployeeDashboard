package com.CRUDEmployee.CRUDEmployee.rest;

import com.CRUDEmployee.CRUDEmployee.entity.Employee;
import com.CRUDEmployee.CRUDEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> EmployeeDisplay(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee EmployeeDisplayByID(@PathVariable int id){
        Employee theEmployee = employeeService.findById(id);
        if(theEmployee==null) {
            throw new RuntimeException("Employee Not Found!");
        }
        return theEmployee;
    }

    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbemployee = employeeService.save(employee);
         return dbemployee;
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbemployee = employeeService.save(employee);
        return dbemployee;
    }

    @DeleteMapping("employee/{id}")
    public String DeleteEmployee(@PathVariable int id) {
        Employee theEmployee = employeeService.findById(id);
        if (theEmployee == null) {
            throw new RuntimeException("Employee Not Found!");
        }
        employeeService.deleteById(id);
        return "deleted!";
    }
}
