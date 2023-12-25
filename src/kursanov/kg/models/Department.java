package kursanov.kg.models;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private int id;
    private String departmentName;
    private List<Doctor> doctors = new ArrayList<>();

    public Department(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctor() {
        return doctors;
    }

    public void setDoctor(List<Doctor> doctor) {
        this.doctors = doctor;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", doctor=" + doctors +
                '}';
    }
}
