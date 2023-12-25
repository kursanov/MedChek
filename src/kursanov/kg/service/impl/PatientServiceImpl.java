package kursanov.kg.service.impl;

import kursanov.kg.dao.PatientDao;
import kursanov.kg.exeption.NotFoundException;
import kursanov.kg.models.Hospital;
import kursanov.kg.models.Patient;
import kursanov.kg.service.GenericService;
import kursanov.kg.service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {

    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public String add(int hospitalId, Patient patient) {
        try {
            patientDao.add(hospitalId, patient);
            return "Successfully added";
        } catch (NotFoundException | IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @Override
    public String removeById(int id) {
        try {
            patientDao.delete(id);
            return "Successfully deleted";
        } catch (NotFoundException e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateById(int id, Patient patient) {
        try {
            patientDao.updateById(id, patient);
            return "Successfully updated";
        } catch (NotFoundException e) {
            return e.getMessage();
        }
    }

    @Override
    public String addPatientsToHospital(int id, List<Patient> patients) {
        try {
            patientDao.addPatientsToHospital(id, patients);
            return "Successfully added Patients";
        } catch (NotFoundException | IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @Override
    public Patient getPatientById(int id) {
        try {
            return patientDao.findById(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        return patientDao.getPatientByAge();

    }


    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        try {
            return patientDao.sortPatientsByAge(ascOrDesc);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
