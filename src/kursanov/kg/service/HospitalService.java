package kursanov.kg.service;

import kursanov.kg.models.Hospital;
import kursanov.kg.models.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalService {

    String addHospital(Hospital hospital);

    Hospital findHospitalById(int id);

    List<Hospital> getAllHospital();

    List<Patient> getAllPatientFromHospital(int id);

    String deleteHospitalById(int id);

    Map<String, Hospital> getAllHospitalByAddress(String address);



}
