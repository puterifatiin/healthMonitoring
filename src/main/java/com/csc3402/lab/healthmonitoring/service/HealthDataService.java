package com.csc3402.lab.healthmonitoring.service;

import com.csc3402.lab.healthmonitoring.model.HealthData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HealthDataService {

        // Method to list all health data members
        List<HealthData> listAllDatas();

        // Method to add a new health data
        HealthData addNewData(HealthData healthData);

        HealthData QueryHealthDataById(Integer healthDataId);

        // Method to find a health data by their ID
        Optional<HealthData> findHealthDataById(Integer healthDataId);

        // Method to update an existing health data's details
        void updateData(HealthData healthData);

        // Method to delete a health data
        void deleteData(HealthData healthData);

        // To fetch health data by patient ID
        List<HealthData> findHealthDataByPatientId(int patientId);

}
