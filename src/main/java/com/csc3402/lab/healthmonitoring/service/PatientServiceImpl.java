package com.csc3402.lab.healthmonitoring.service;

import com.csc3402.lab.healthmonitoring.model.Patient;
import com.csc3402.lab.healthmonitoring.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> listAllPatients() {
        return patientRepository.findAll();
    }
}
