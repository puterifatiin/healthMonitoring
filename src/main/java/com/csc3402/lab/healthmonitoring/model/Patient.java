package com.csc3402.lab.healthmonitoring.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_Id")
    private Integer patientId;

    public Patient() {
    }

    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<HealthData> healthData;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                '}';
    }
}


