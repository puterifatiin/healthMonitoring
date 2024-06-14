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

@Controller
@RequestMapping("/healthDatas")
public class HealthMonitoringController {
    private final HealthDataService healthDataService;
    private final PatientService patientService;


    public HealthMonitoringController(HealthDataService healthDataService, PatientService patientService) {
        this.healthDataService = healthDataService;
        this.patientService = patientService;
    }


    @GetMapping("list")
    public String showAllStaffForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllStaffs());
        return "list-staff";
    }

    @GetMapping("signup")
    public String showAddNewStaffForm(HealthData healthData, Model model){
        model.addAttribute("patients", patientService.listAllPatients());
        return "add-staff";
    }

    @PostMapping("add")
    public String addStaff(@Valid HealthData healthData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-staff";
        }

        healthDataService.addNewStaff(healthData);
        return "redirect:list";
    }

    // UPDATE STAFF
    @GetMapping("update")
    public String showUpdateMainForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllStaffs());
        return "choose-staff-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        HealthData healthData = healthDataService.findHealthDataById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("healthData", healthData);
        model.addAttribute("patients", patientService.listAllPatients());
        return "update-staff";
    }

    @PostMapping("update/{id}")
    public String updateStaff(@PathVariable("id") long id, @Valid HealthData healthData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            healthData.setHealthDataId((int) id);
            return "index";
        }
        healthDataService.updateStaff(healthData);
        model.addAttribute("healthDatas", healthDataService.listAllStaffs());
        return "list-staff";
    }

    // DELETE STAFF
    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllStaffs());
        return "choose-staff-to-delete";
    }

    @GetMapping("delete/{id}")
    public String deleteStaff(@PathVariable("id") long id, Model model) {
        HealthData healthData = healthDataService.findHealthDataById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        healthDataService.deleteStaff(healthData);
        model.addAttribute("healthDatas", healthDataService.listAllStaffs());
        return "list-staff";
    }


}
