package kursanov.kg.dao;

import kursanov.kg.database.DataBase;
import kursanov.kg.models.Hospital;
import kursanov.kg.models.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalDao {


    Boolean addHospital(Hospital hospital);

    Hospital findHospitalById(int id);

    List<Hospital> getAllHospital();

    List<Patient> getAllPatientFromHospital(int id);

    Boolean deleteHospitalById(int id);

    Map<String,Hospital> getAllHospitalByAddress(String address);
}
