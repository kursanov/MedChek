package kursanov.kg.service;

import kursanov.kg.models.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartmentByHospital(int id);

    Department findDepartmentByName(String name);



}
