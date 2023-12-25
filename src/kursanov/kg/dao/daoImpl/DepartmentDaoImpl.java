package kursanov.kg.dao.daoImpl;

import kursanov.kg.dao.DepartmentDao;
import kursanov.kg.database.DataBase;
import kursanov.kg.exeption.NotFoundException;
import kursanov.kg.models.Department;
import kursanov.kg.models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private final DataBase dataBase;

    public DepartmentDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Boolean add(int hospitalId, Department department) {
        for (Hospital hospital : dataBase.getAll()) {
            if (hospital.getId() == (hospitalId)) {
                return hospital.getDepartments().add(department);
            }
        }
        throw new NotFoundException("Hospital with " + hospitalId + " not found!");
    }


    @Override
    public Boolean remove(int id) {
        for (Hospital hospital : dataBase.getAll()) {
            return hospital.getDepartments().removeIf(department -> department.getId() == (id));
        }
        throw new NotFoundException("Department with " + id + " not found!");
    }

    @Override
    public List<Department> getAll(int hospitalId) {
        for (Hospital hospital : dataBase.getAll()) {
            if (hospital.getId() == (hospitalId)) {
                return hospital.getDepartments();
            }
        }
        throw new NotFoundException("Hospital with " + hospitalId + " not found!");
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        for (Hospital hospital : dataBase.getAll()) {
             departments.addAll(hospital.getDepartments());
        }
        return departments;
    }

    @Override
    public Boolean update(int id, Department department) {
        for (Hospital hospital : dataBase.getAll()) {
            for (Department hospitalDepartment : hospital.getDepartments()) {
                if (hospitalDepartment.getId() == (id)) {
                    hospitalDepartment.setDepartmentName(department.getDepartmentName());
                    return true;
                }
            }
        }
        throw new NotFoundException("Hospital with " + id + " not found!");
    }

}
