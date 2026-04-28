package com.example.department_service.controller;

import com.example.department_service.model.Department;
import com.example.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return departmentRepository.addDepartments(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department findAll");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department findById: id={}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department findAllWithEmployees");
        List<Department> departmentList = departmentRepository.findAll();
        LOGGER.info("Department all department list {}",departmentList);
        departmentList.forEach(department ->
                department.setEmployees(
                        employeeClient.findByDepartment(department.getId())));
        return departmentList;
    }
    @DeleteMapping
    public void removeAllDepartment(){
        departmentRepository.findAll().clear();
    }
}

