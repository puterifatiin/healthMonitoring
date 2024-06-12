package com.csc3402.lab.healthmonitoring.service;

import com.csc3402.lab.healthmonitoring.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> listAllPatients();
}
