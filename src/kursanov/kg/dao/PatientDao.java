package kursanov.kg.dao;

import kursanov.kg.models.Department;
import kursanov.kg.models.Patient;

import java.util.List;
import java.util.Map;

public interface PatientDao {


    Patient findById(int patientId);

    Boolean add(int hospitalId, Patient patient);

    Boolean delete(int id);

    List<Patient> getAll();

    Boolean updateById(int id, Patient patient);

    Boolean addPatientsToHospital(int id, List<Patient> patients);

    Map<Integer, List<Patient>> getPatientByAge();

    List<Patient> sortPatientsByAge(String ascOrDesc);
}
