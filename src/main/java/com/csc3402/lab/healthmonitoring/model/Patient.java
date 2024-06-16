package com.csc3402.lab.healthmonitoring.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_Id")
    private Integer patientId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "height")
    private Integer height;

    @Column(name = "contact")
    private String contact;

    public Patient() {
    }

    public Patient(Integer patientId, String name, String gender, Integer age, Integer height, String contact) {
        this.patientId = patientId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.contact = contact;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<HealthData> healthData;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", contact='" + contact + '\'' +
                '}';
    }
}


