package kursanov.kg.service.impl;

import kursanov.kg.dao.HospitalDao;
import kursanov.kg.exeption.NotFoundException;
import kursanov.kg.models.Hospital;
import kursanov.kg.models.Patient;
import kursanov.kg.service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {

    private final HospitalDao hospitalDao;

    public HospitalServiceImpl(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }
    @Override
    public String addHospital(Hospital hospital) {
        try {
            hospitalDao.addHospital(hospital);
            return "Successfully saved";
        } catch (NotFoundException e){
            return e.getMessage();
        }
    }

    @Override
    public Hospital findHospitalById(int id) {
        try {
            return hospitalDao.findHospitalById(id);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(int id) {
        try {
            return hospitalDao.getAllPatientFromHospital(id);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteHospitalById(int id) {
        try {
            hospitalDao.deleteHospitalById(id);
            return "Successfully deleted";
        } catch (NotFoundException e){
            return e.getMessage();
        }
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        try {
            return hospitalDao.getAllHospitalByAddress(address);
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
        }

        return null;

    }
}
