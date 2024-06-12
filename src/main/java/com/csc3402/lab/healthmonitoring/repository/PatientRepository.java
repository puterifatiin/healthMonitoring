package com.csc3402.lab.healthmonitoring.repository;

import com.csc3402.lab.healthmonitoring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
