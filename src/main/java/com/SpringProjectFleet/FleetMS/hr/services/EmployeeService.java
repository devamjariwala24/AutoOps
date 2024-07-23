package com.SpringProjectFleet.FleetMS.hr.services;

import com.SpringProjectFleet.FleetMS.hr.models.Employee;
import com.SpringProjectFleet.FleetMS.hr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Get All Employees
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    //Get Employee By Id
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    //Delete Employee
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    //Update Employee
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    //Get Employee by username
    public Employee findByUsername(String un) {
        return employeeRepository.findByUsername(un);
    }

    //Get employee by Keyword
    public List<Employee> findByKeyword(String keyword) {
        return employeeRepository.findByKeyword(keyword);
    }


}