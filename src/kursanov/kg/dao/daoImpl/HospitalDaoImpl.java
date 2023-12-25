package kursanov.kg.dao.daoImpl;

import kursanov.kg.dao.HospitalDao;
import kursanov.kg.database.DataBase;
import kursanov.kg.exeption.NotFoundException;
import kursanov.kg.models.Hospital;
import kursanov.kg.models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {

    private final DataBase dataBase;

    public HospitalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Boolean addHospital(Hospital hospital) {
        return dataBase.hospitals.add(hospital);
    }

    @Override
    public Hospital findHospitalById(int id) {
        for (Hospital hospital : dataBase.getAll()) {
            if (hospital.getId() == id){
                return  hospital;
            }

        }
        throw new NotFoundException("Error aka");
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dataBase.getAll();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(int id) {
        for (Hospital hospital: dataBase.getAll()) {
            if (hospital.getId() == id){
                return hospital.getPatients();
            }

        }
        throw  new NotFoundException("Error aka");
    }

    @Override
    public Boolean deleteHospitalById(int id) {
        for (Hospital hospital : dataBase.getAll()) {
            if(hospital.getId() == id){
                return dataBase.remove(hospital);
            }

        }
        throw new NotFoundException("Error aka");
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital> hospitalMap = new HashMap<>();
        for (Hospital hospital : dataBase.getAll()) {
            if (hospital.getAddress().equalsIgnoreCase(address)){
                hospitalMap.put(address,hospital);
                return hospitalMap;
            }
        }
        throw new NotFoundException("Error aka");
    }
}
