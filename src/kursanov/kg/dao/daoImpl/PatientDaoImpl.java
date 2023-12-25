package kursanov.kg.dao.daoImpl;

import kursanov.kg.dao.PatientDao;
import kursanov.kg.database.DataBase;
import kursanov.kg.exeption.MyException;
import kursanov.kg.exeption.NotFoundException;
import kursanov.kg.genId.GeneretId;
import kursanov.kg.models.Department;
import kursanov.kg.models.Hospital;
import kursanov.kg.models.Patient;

import java.util.*;

public class PatientDaoImpl implements PatientDao {

    private final DataBase dataBase;

    public PatientDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public Patient findById(int patientId) {
        for (Hospital hospital : dataBase.getAll()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == (patientId)){
                    return patient;
                }
            }
        }
        throw new NotFoundException("Patient with "+patientId+" not found!");
    }

    @Override
    public Boolean add(int hospitalId, Patient patient) {
        for (Hospital hospital : dataBase.getAll()) {
            for (Patient hospitalPatient : hospital.getPatients()) {
                if (hospitalPatient.getId() == (hospitalId)){
                    throw new IllegalArgumentException("error");
                }
            }
            if (hospital.getId() == (hospitalId)){
                return hospital.getPatients().add(patient);
            }
        }
        throw new IllegalArgumentException("Hospital with "+hospitalId+" not found!");
    }

    @Override
    public Boolean delete(int id) {
        for (Hospital hospital: dataBase.getAll()) {
            return hospital.getPatients().removeIf(patient -> patient.getId() == id);
        }
        throw new RuntimeException("error aka");
    }

    @Override
    public List<Patient> getAll() {
        for (Hospital hospital: dataBase.getAll()) {
            return hospital.getPatients();

        }
        throw new NotFoundException("error aka");
    }

    @Override
    public Boolean updateById(int id, Patient patient) {
        for (Hospital hospital: dataBase.getAll()) {
            for (Patient hospitalPatient: hospital.getPatients()) {
                if (hospitalPatient.getId() == id){
                    hospitalPatient.setFirstName(patient.getFirstName());
                    hospitalPatient.setLastName(patient.getLastName());
                    hospitalPatient.setAge(patient.getAge());
                    hospitalPatient.setGender(patient.getGender());
                    return true;
                }

            }

        }
        throw new NotFoundException("error aka");
    }

    @Override
    public Boolean addPatientsToHospital(int id, List<Patient> patients) {
        for (Hospital hospital: dataBase.getAll()) {
            if (hospital.getId() == id){
                return hospital.getPatients().addAll(patients);
            }
        }
        throw new NotFoundException("Hospital with " + id + " not found");

    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        Map<Integer, List<Patient>> patientMap = new HashMap<>();
        for (Hospital hospital : dataBase.getAll()) {
            for (Patient patient : hospital.getPatients()) {
                int age = patient.getAge();
                if (!patientMap.containsKey(age)){
                    patientMap.put(age, new ArrayList<>());
                }
                patientMap.get(age).add(patient);
            }
        }
        return patientMap;
    }


    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        for (Hospital hospital : dataBase.getAll()) {
            patients.addAll(hospital.getPatients());
        }
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Comparator<Patient> comparator = Comparator.comparing(Patient::getAge);
            patients.sort(comparator);
            return patients;
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            Comparator<Patient> comparator = Comparator.comparing(Patient::getAge).reversed();
            patients.sort(comparator);
            return patients;
        }
        throw new NotFoundException("enter only asc or desc. you write: " + ascOrDesc);
    }
}
