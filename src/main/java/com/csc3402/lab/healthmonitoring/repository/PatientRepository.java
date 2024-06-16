package com.csc3402.lab.healthmonitoring.repository;

import com.csc3402.lab.healthmonitoring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "SELECT * FROM patient WHERE patient_Id = :id", nativeQuery = true)
    Patient findPatientById(@Param("id") int id);
}
