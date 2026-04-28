package com.example.employee_service.repository;

import com.example.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employeeList.stream()
                .filter(employee ->
                        employee.id().equals(id))
                .findFirst().orElseThrow();
    }
    public List<Employee> findAll(){
        return employeeList;
    }
    public List<Employee> findByDepartment(Long departmentId){
        return employeeList.stream()
                .filter(employee ->
                        employee.departmentId().equals(departmentId))
                .toList();
    }
}
