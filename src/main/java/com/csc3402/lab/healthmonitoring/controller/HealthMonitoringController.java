package com.csc3402.lab.healthmonitoring.controller;

import com.csc3402.lab.healthmonitoring.model.HealthData;

import com.csc3402.lab.healthmonitoring.model.Patient;
import com.csc3402.lab.healthmonitoring.service.HealthDataService;

import com.csc3402.lab.healthmonitoring.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/healthDatas")
public class HealthMonitoringController {
    private final HealthDataService healthDataService;
    private final PatientService patientService;


    public HealthMonitoringController(HealthDataService healthDataService, PatientService patientService) {
        this.healthDataService = healthDataService;
        this.patientService = patientService;
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    /*@GetMapping("list")
    public String showAllDataForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        return "list-data";
    }**/

    @GetMapping("signup")
    public String showAddNewDataForm(HealthData healthData, Model model){
        model.addAttribute("patients", patientService.listAllPatients());
        return "add-data";
    }

    @PostMapping("/add")
    public String addData(@Valid HealthData healthData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("patients", patientService.listAllPatients());
            return "add-data";
        }

        // Ensure the patient is set and valid
        if (healthData.getPatient() == null || healthData.getPatient().getPatientId() == null) {
            result.rejectValue("patient", "error.healthData", "Patient is required");
            model.addAttribute("patients", patientService.listAllPatients());
            return "add-data";
        }

        Integer patientId = healthData.getPatient().getPatientId();
        if (!patientService.findPatientById(patientId).isPresent()) {
            result.rejectValue("patient", "error.healthData", "Invalid or missing patient ID");
            model.addAttribute("patients", patientService.listAllPatients());
            return "add-data";
        }

        // Save the new health data
        healthDataService.addNewData(healthData);

        // Redirect to the view-data page
        return "redirect:/healthDatas/view/" + patientId;
    }



    // UPDATE DATA
    @GetMapping("update")
    public String showUpdateMainForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        return "choose-data-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        HealthData healthData = healthDataService.findHealthDataById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid data Id:" + id));
        model.addAttribute("healthData", healthData);
        model.addAttribute("patients", patientService.listAllPatients());
        return "update-data";
    }

    @PostMapping("/update/{id}")
    public String updateData(@PathVariable("id") long id,
                             @Valid HealthData healthData,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            healthData.setHealthDataId((int) id);
            model.addAttribute("patients", patientService.listAllPatients());
            return "update-data"; // Return to update form with validation errors
        }

        // Fetch existing health data to update
        HealthData existingHealthData = healthDataService.findHealthDataById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid data Id:" + id));

        // Preserve the patient ID from the existing data
        healthData.setPatient(existingHealthData.getPatient());

        // Update the health data fields
        existingHealthData.setTimestamp(healthData.getTimestamp());
        existingHealthData.setTemperature(healthData.getTemperature());
        existingHealthData.setBMI(healthData.getBMI());
        existingHealthData.setWeight(healthData.getWeight());
        existingHealthData.setHeartRate(healthData.getHeartRate());
        existingHealthData.setSystolic(healthData.getSystolic());
        existingHealthData.setDiastolic(healthData.getDiastolic());
        existingHealthData.setGlucoseLevel(healthData.getGlucoseLevel());
        existingHealthData.setLDL(healthData.getLDL());
        existingHealthData.setHDL(healthData.getHDL());
        existingHealthData.setTriglycerides(healthData.getTriglycerides());
        existingHealthData.setTotal(healthData.getTotal());

        // Save the updated health data
        healthDataService.updateData(existingHealthData);

        // Redirect to the view-data page or list-data page after successful update
        return "redirect:/healthDatas/view";
    }

    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        return "choose-data-to-delete";
    }

    @GetMapping("delete/{id}")
    public String deleteData(@PathVariable("id") long id, Model model) {
        HealthData healthData = healthDataService.findHealthDataById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid data Id:" + id));

        healthDataService.deleteData(healthData);
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        // Optionally, you can redirect to the list-data page after deletion
        return "redirect:/healthDatas/view";
    }


    @GetMapping("view/{id}")
    public String viewPatientHealthData(@PathVariable("id") int patientId, Model model) {
        // Fetch patient health data
        List<HealthData> healthDatas = healthDataService.findHealthDataByPatientId(patientId);

        // Fetch patient details
        Optional<Patient> patientOptional = patientService.findPatientById(patientId);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            model.addAttribute("patient", patient);
        } else {
            // Handle the case where the patient is not found
            model.addAttribute("patient", null);
            model.addAttribute("error", "Patient not found");
        }

        // Add health data to model
        model.addAttribute("healthDatas", healthDatas);

        return "view-data";
    }
    @GetMapping("view")
    public String showAllDataForm(Model model) {
        model.addAttribute("patients", patientService.listAllPatients());
        return "list-data";
    }
}
