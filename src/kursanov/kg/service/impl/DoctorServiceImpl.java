package kursanov.kg.service.impl;

import kursanov.kg.dao.DoctorDao;
import kursanov.kg.exeption.NotFoundException;
import kursanov.kg.models.Doctor;
import kursanov.kg.service.DoctorService;
import kursanov.kg.service.GenericService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {

    private final DoctorDao doctorDao;

    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public Doctor findDoctorById(int id) {
        try {
            return doctorDao.findById(id);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(int departmentId, List<Integer> doctorsId) {
        try {
            return doctorDao.assignDoctorToDepartment(departmentId, doctorsId);
        } catch (NotFoundException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(int id) {
        try {
            return doctorDao.getAllDoctorsByHospitalId(id);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(int id) {
        try {
            return doctorDao.getAllDoctorsByDepartmentId(id);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String add(int hospitalId, Doctor doctor) {
        try {
            for (Doctor doctor1 : getAllDoctorsByHospitalId(hospitalId)) {
                if (doctor1.getId() == (doctor.getId())){
                    throw new IllegalArgumentException("error");
                }
            }
            doctorDao.add(hospitalId, doctor);
            return "Successfully added";
        } catch (NotFoundException | IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @Override
    public String removeById(int id) {
        try {
            doctorDao.remove(id);
            return "Successfully deleted";
        } catch (NotFoundException e){
            return e.getMessage();
        }
    }

    @Override
    public String updateById(int id, Doctor doctor) {
        try {
            doctorDao.updateById(id, doctor);
            return "Successfully updated";
        } catch (NotFoundException e){
            return e.getMessage();
        }
    }
}
