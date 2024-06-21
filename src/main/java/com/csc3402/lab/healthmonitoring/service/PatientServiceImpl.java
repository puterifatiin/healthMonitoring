package com.csc3402.lab.healthmonitoring.service;

import com.csc3402.lab.healthmonitoring.model.Patient;
import com.csc3402.lab.healthmonitoring.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> listAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient addNewPatient(Patient patient) { return patientRepository.save(patient);
    }

    public Optional<Patient> findPatientById(Integer patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public Patient QueryPatientById(Integer patientId) {
        return patientRepository.findPatientById(patientId);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }
}
