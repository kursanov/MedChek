package kursanov.kg.service.impl;

import kursanov.kg.dao.DepartmentDao;
import kursanov.kg.exeption.NotFoundException;
import kursanov.kg.models.Department;
import kursanov.kg.models.Hospital;
import kursanov.kg.service.DepartmentService;
import kursanov.kg.service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService , GenericService<Department> {

   private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(int id) {
        try {
            return departmentDao.getAll(id);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        try {
            for (Department department : departmentDao.getAllDepartments()) {
                if (department.getDepartmentName().equalsIgnoreCase(name)){
                    return department;
                } else {
                    throw new NotFoundException("Department with "+name+" not found!");
                }
            }
        } catch (NotFoundException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String add(int hospitalId, Department department) {
        try {
            for (Department department1 : getAllDepartmentByHospital(hospitalId)) {
                if (department1.getId() == (department.getId())){
                    throw new IllegalArgumentException("error");
                }
            }
            departmentDao.add(hospitalId, department);
            return "Successfully added";
        } catch (NotFoundException | IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @Override
    public String removeById(int id) {
        try {
            departmentDao.remove(id);
            return "Successfully deleted";
        } catch (NotFoundException e){
            return e.getMessage();
        }
    }

    @Override
    public String updateById(int id, Department department) {
        try {
            departmentDao.update(id, department);
            return "Successfully updated";
        } catch (NotFoundException e){
            return e.getMessage();
        }
    }




}
