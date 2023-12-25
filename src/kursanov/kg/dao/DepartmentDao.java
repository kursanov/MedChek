package kursanov.kg.dao;

import kursanov.kg.models.Department;

import java.util.List;

public interface DepartmentDao {

    Boolean add(int hospitalId, Department department);

    Boolean remove(int id);

    List<Department> getAll(int hospitalId);

    List<Department> getAllDepartments();

    Boolean update(int id, Department department);

}
