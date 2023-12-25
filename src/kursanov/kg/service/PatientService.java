package kursanov.kg.service;

import kursanov.kg.models.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {

    String addPatientsToHospital(int id, List<Patient> patients);

    Patient getPatientById(int id);

    Map<Integer, List<Patient>> getPatientByAge();

    List<Patient> sortPatientsByAge(String ascOrDesc);


}
