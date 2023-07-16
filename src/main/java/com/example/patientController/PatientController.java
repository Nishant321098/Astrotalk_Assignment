package com.example.patientController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Patient;
import com.example.repository.patientRepository.PatientRepository;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    
    @PostMapping("/signup")
    public String signUp(@RequestBody String staffDetails) {
        // Implement signup logic
        return "Signed up successfully";
    }
    
    @PostMapping("/login")
    public String login(@RequestBody String staffCredentials) {
        // Implement login logic
        return "Logged in successfully";
    }
    
    @PostMapping("/patients")
    public String admitPatient(@RequestBody Patient patient) {
        // Save the patient to the database
        patientRepository.save(patient);
        return "Patient admitted successfully";
    }
    
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        // Fetch all admitted patients from the database
        return patientRepository.findAll();
    }
    
    @PutMapping("/patients/{id}/discharge")
    public String dischargePatient(@PathVariable Long id) {
        // Fetch the patient by ID and update the status to discharged
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        patient.setStatus("discharged");
        patientRepository.save(patient);
        return "Patient discharged successfully";
    }
}

