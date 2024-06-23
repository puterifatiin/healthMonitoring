package com.csc3402.lab.healthmonitoring.repository;


import com.csc3402.lab.healthmonitoring.model.HealthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HealthDataRepository extends JpaRepository<HealthData, Integer> {
    @Query(value = "SELECT * FROM healthData WHERE data_id = :id", nativeQuery = true)
    HealthData findHealthDataById(@Param("id") int id);

    List<HealthData> findByPatient_PatientId(int patientId);
}
