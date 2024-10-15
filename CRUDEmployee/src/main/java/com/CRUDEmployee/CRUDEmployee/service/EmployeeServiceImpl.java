package com.CRUDEmployee.CRUDEmployee.service;

import com.CRUDEmployee.CRUDEmployee.dao.EmployeeRepository;
import com.CRUDEmployee.CRUDEmployee.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if(result.isEmpty()){
           theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Employee Not Found!");
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
     return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
     employeeRepository.deleteById(id);
    }
}
