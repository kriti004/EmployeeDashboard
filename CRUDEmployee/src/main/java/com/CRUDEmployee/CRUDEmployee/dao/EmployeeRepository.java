package com.CRUDEmployee.CRUDEmployee.dao;

import com.CRUDEmployee.CRUDEmployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>{

}
