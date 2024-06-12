package com.csc3402.lab.healthmonitoring.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class HealthData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_id")
    private Integer healthDataId;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "bmi")
    private double BMI;

    @Column(name = "weight")
    private double weight;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "systolic")
    private Integer systolic;

    @Column(name = "diastolic")
    private Integer diastolic;

    @Column(name = "glucose_level")
    private double glucoseLevel;

    @Column(name = "ldl")
    private double LDL;

    @Column(name = "hdl")
    private double HDL;

    @Column(name = "triglycerides")
    private double triglycerides;

    @Column(name = "total")
    private double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // Default constructor
    public HealthData() {
    }

    public HealthData(Integer healthDataId, LocalDateTime timestamp, double temperature, double BMI, double weight, Integer heartRate, Integer systolic, Integer diastolic, double glucoseLevel, double LDL, double HDL, double triglycerides, double total, Patient patient) {
        this.healthDataId = healthDataId;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.BMI = BMI;
        this.weight = weight;
        this.heartRate = heartRate;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.glucoseLevel = glucoseLevel;
        this.LDL = LDL;
        this.HDL = HDL;
        this.triglycerides = triglycerides;
        this.total = total;
        this.patient = patient;
    }

    public Integer getHealthDataId() {
        return healthDataId;
    }

    public void setHealthDataId(Integer healthDataId) {
        this.healthDataId = healthDataId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public double getGlucoseLevel() {
        return glucoseLevel;
    }

    public void setGlucoseLevel(double glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public double getLDL() {
        return LDL;
    }

    public void setLDL(double LDL) {
        this.LDL = LDL;
    }

    public double getHDL() {
        return HDL;
    }

    public void setHDL(double HDL) {
        this.HDL = HDL;
    }

    public double getTriglycerides() {
        return triglycerides;
    }

    public void setTriglycerides(double triglycerides) {
        this.triglycerides = triglycerides;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "HealthData{" +
                "healthDataId=" + healthDataId +
                ", timestamp=" + timestamp +
                ", temperature=" + temperature +
                ", BMI=" + BMI +
                ", weight=" + weight +
                ", heartRate=" + heartRate +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                ", glucoseLevel=" + glucoseLevel +
                ", LDL=" + LDL +
                ", HDL=" + HDL +
                ", triglycerides=" + triglycerides +
                ", total=" + total +
                ", patient=" + patient +
                '}';
    }
}
