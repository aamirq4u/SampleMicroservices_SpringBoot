package com.example.department_service.repository;

import com.example.department_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departmentsList = new ArrayList<>();

    public Department addDepartments(Department department) {
        departmentsList.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departmentsList.stream()
                .filter(department ->
                        department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll(){
        return departmentsList;
    }
}
