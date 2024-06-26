package com.csc3402.lab.healthmonitoring.controller;

import com.csc3402.lab.healthmonitoring.model.HealthData;

import com.csc3402.lab.healthmonitoring.service.HealthDataService;

import com.csc3402.lab.healthmonitoring.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("list")
    public String showAllDataForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        return "list-data";
    }

    @GetMapping("signup")
    public String showAddNewDataForm(HealthData healthData, Model model){
        model.addAttribute("patients", patientService.listAllPatients());
        return "add-data";
    }

    @PostMapping("add")
    public String addData(@Valid HealthData healthData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-data";
        }

        healthDataService.addNewData(healthData);
        return "redirect:list";
    }

    // UPDATE STAFF
    @GetMapping("update")
    public String showUpdateMainForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        return "choose-data-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        HealthData healthData = healthDataService.findHealthDataById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("healthData", healthData);
        model.addAttribute("patients", patientService.listAllPatients());
        return "update-data";
    }

    @PostMapping("update/{id}")
    public String updateData(@PathVariable("id") long id, @Valid HealthData healthData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            healthData.setHealthDataId((int) id);
            return "index";
        }
        healthDataService.updateData(healthData);
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        return "list-data";
    }

    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        return "choose-data-to-delete";
    }

    @GetMapping("delete/{id}")
    public String deleteStaff(@PathVariable("id") long id, Model model) {
        HealthData healthData = healthDataService.findHealthDataById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        healthDataService.deleteData(healthData);
        model.addAttribute("healthDatas", healthDataService.listAllDatas());
        return "list-data";
    }


}
