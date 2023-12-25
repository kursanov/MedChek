package kursanov.kg.database;

import kursanov.kg.models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public List<Hospital> hospitals = new ArrayList<>();


    public List<Hospital> getAll(){
        return hospitals;
    }

    public Boolean remove(Hospital hospital){
        return hospitals.remove(hospital);
    }


}
