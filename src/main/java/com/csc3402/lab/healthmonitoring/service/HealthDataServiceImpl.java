package com.csc3402.lab.healthmonitoring.service;

import com.csc3402.lab.healthmonitoring.model.HealthData;
import com.csc3402.lab.healthmonitoring.repository.HealthDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthDataServiceImpl implements HealthDataService{

    private final HealthDataRepository healthDataRepository;

    //Constructor Injection to inject StaffRepository dependency
    public HealthDataServiceImpl(HealthDataRepository healthDataRepository){
        this.healthDataRepository = healthDataRepository;
    }

    // Method to list all staff members
    @Override
    public List<HealthData> listAllDatas() {
        return healthDataRepository.findAll();
    }

    // Method to add a new staff member
    @Override
    public HealthData addNewData(HealthData healthData) {
        return healthDataRepository.save(healthData);
    }

    // Method to update an existing staff member's details
    @Override
    public void updateData(HealthData healthData) {
        healthDataRepository.save(healthData);
    }

    // Method to delete a staff member
    @Override
    public void deleteData(HealthData healthData) {
        healthDataRepository.delete(healthData);
    }

    @Override
    public HealthData QueryHealthDataById(Integer healthDataId) {
        return healthDataRepository.findHealthDataById(healthDataId);
    }

    // Method to find a staff member by their ID
    public Optional<HealthData> findHealthDataById(Integer healthDataId) {
        return healthDataRepository.findById(healthDataId);
    }
}
