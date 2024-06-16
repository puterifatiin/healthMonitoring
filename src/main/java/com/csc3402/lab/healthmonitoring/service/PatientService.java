package com.csc3402.lab.healthmonitoring.service;

import com.csc3402.lab.healthmonitoring.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> listAllPatients();

    Patient addNewPatient(Patient patient);

    Optional<Patient> findPatientById(Integer patientId);
    Patient QueryPatientById(Integer patientId);
    Patient updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
