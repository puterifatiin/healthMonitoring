package com.csc3402.lab.healthmonitoring.controller;

import com.csc3402.lab.healthmonitoring.model.HealthData;
import com.csc3402.lab.healthmonitoring.model.Patient;
import com.csc3402.lab.healthmonitoring.service.HealthDataService;
import com.csc3402.lab.healthmonitoring.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    private final HealthDataService healthDataService;


    public PatientController(PatientService patientService, HealthDataService healthDataService){

        this.patientService = patientService;
        this.healthDataService = healthDataService;

    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("list")
    public String showAllPatientForm(Model model) {
        model.addAttribute("patients", patientService.listAllPatients());
        return "list-patients";
    }

    @GetMapping("signup")
    public String showAddNewPatientForm(Patient patient, Model model){
        model.addAttribute("patients", patientService.listAllPatients());
        return "add-patient";
    }

    @PostMapping("add")
    public String addPatient(@Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-patient";
        }
        patientService.addNewPatient(patient);
        return "redirect:list";
    }

    @GetMapping("update")
    public String showUpdateMainForm(Model model) {
        model.addAttribute("patients", patientService.listAllPatients());
        return "choose-patient-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Patient patient = patientService.findPatientById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        model.addAttribute("patient", patient);
        return "update-patient";
    }

    @PostMapping("update/{id}")
    public String updatePatient(@PathVariable("id") long id, @Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            patient.setPatientId((int) id);
            return "index";
        }

        model.addAttribute("patients", patientService.listAllPatients());
        patientService.updatePatient(patient);
        return "list-patients";
    }

    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("patients", patientService.listAllPatients());
        return "choose-patient-to-delete";
    }

    @GetMapping("delete/{id}")
    public String deletePatient(@PathVariable("id") long id, Model model) {
        Patient patient = patientService.findPatientById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        patientService.deletePatient(patient);
        model.addAttribute("patients", patientService.listAllPatients());
        return "list-patients";
    }



}

