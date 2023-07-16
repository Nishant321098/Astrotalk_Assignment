package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Patient;

public class patientRepository {

	@Repository
	public interface PatientRepository extends JpaRepository<Patient, Long> {
	}

}
