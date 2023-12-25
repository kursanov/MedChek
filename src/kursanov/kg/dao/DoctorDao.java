package kursanov.kg.dao;

import kursanov.kg.models.Doctor;

import java.util.List;

public interface DoctorDao {

    Doctor findById(int doctorId);

    Boolean add(int hospitalId, Doctor doctor);

    Boolean remove(int id);

    List<Doctor> getAll();

    String assignDoctorToDepartment(int departmentId, List<Integer> doctorsId);

    List<Doctor> getAllDoctorsByHospitalId(int id);

    List<Doctor> getAllDoctorsByDepartmentId(int id);

    Boolean updateById(int id, Doctor doctor);
}
