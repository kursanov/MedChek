package kursanov.kg.dao.daoImpl;

import kursanov.kg.dao.DoctorDao;
import kursanov.kg.database.DataBase;
import kursanov.kg.exeption.NotFoundException;
import kursanov.kg.models.Department;
import kursanov.kg.models.Doctor;
import kursanov.kg.models.Hospital;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao {

    private final DataBase dataBase;

    public DoctorDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Doctor findById(int doctorId) {
        for (Hospital hospital:dataBase.getAll() ) {
            for (Doctor doctor: hospital.getDoctors()) {
                if (doctor.getId() == doctorId){
                    return doctor;
                }

            }

        }
        throw new NotFoundException("Doctor with " + doctorId + " not found!");

    }

    @Override
    public Boolean add(int hospitalId, Doctor doctor) {
        for (Hospital hospital: dataBase.getAll()) {
            if (hospital.getId() == hospitalId){
                return hospital.getDoctors().add(doctor);
            }

        }
        throw new NotFoundException("Hospital with " + hospitalId + " not found!");
    }

    @Override
    public Boolean remove(int id) {
        for (Hospital hospital: dataBase.getAll()) {
            for (Doctor doctor: hospital.getDoctors()) {
                if (doctor.getId() == id){
                    return hospital.getDoctors().remove(doctor);
                }

            }

        }
        throw new NotFoundException("Doctor with " + id + " not found!");

    }

    @Override
    public List<Doctor> getAll() {
        for (Hospital hospital: dataBase.getAll()) {
            return hospital.getDoctors();

        }

        throw new NotFoundException("error aka");
    }

    @Override
    public String assignDoctorToDepartment(int departmentId, List<Integer> doctorsId) {
        for (Hospital hospital: dataBase.getAll()) {
            for (Department department:hospital.getDepartments()) {
                if (department.getId() == departmentId){
                    for (Doctor doctor: hospital.getDoctors()) {
                        if (doctorsId.contains(doctor.getId()) ){
                            department.getDoctors().add(doctor);
//                            hospital.getDoctors().remove(doctor);
                        }
                    }
                    return "Successfully assign doctor to Department";
                }

            }

        }
        throw new NotFoundException("error aka");
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(int id) {
        for (Hospital hospital: dataBase.getAll()) {
            if (hospital.getId() == id){
                return hospital.getDoctors();
            }

        }

        throw new NotFoundException("Hospital with " + id + " not found");
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(int id) {
        for (Hospital hospital : dataBase.getAll()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId() == (id)) {
                    return department.getDoctors();
                }
            }
        }
        throw new NotFoundException("Department with " + id + " not found");
    }

    @Override
    public Boolean updateById(int id, Doctor doctor) {
        for (Hospital hospital : dataBase.getAll()) {
            for (Doctor hospitalDoctor : hospital.getDoctors()) {
                if (hospitalDoctor.getId() == (id)) {
                    hospitalDoctor.setFirstName(doctor.getFirstName());
                    hospitalDoctor.setLastName(doctor.getLastName());
                    hospitalDoctor.setGender(doctor.getGender());
                    hospitalDoctor.setExperienceYear(doctor.getExperienceYear());
                    return true;
                }
            }
        }
        throw new NotFoundException("Doctor with " + id + " not found");
    }
}
