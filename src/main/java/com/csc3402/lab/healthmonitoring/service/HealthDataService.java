package com.csc3402.lab.healthmonitoring.service;

import com.csc3402.lab.healthmonitoring.model.HealthData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HealthDataService {

        // Method to list all staff members
        List<HealthData> listAllStaffs();

        // Method to add a new staff member
        HealthData addNewData(HealthData healthData);

        HealthData QueryHealthDataById(Integer healthDataId);

        // Method to find a staff member by their ID
        Optional<HealthData> findHealthDataById(Integer healthDataId);

        // Method to update an existing staff member's details
        void updateData(HealthData healthData);

        // Method to delete a staff member
        void deleteData(HealthData healthData);


}
