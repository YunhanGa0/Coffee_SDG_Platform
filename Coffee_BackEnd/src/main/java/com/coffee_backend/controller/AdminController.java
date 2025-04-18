package com.coffee_backend.controller;

import com.coffee_backend.dto.ApiResponse;
import com.coffee_backend.dto.SaveFarmerRequest;
import com.coffee_backend.dto.TechTrainingRequest;
import com.coffee_backend.service.AdminService;
import com.coffee_backend.service.TechnicalTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TechnicalTrainingService technicalTrainingService;


    @PostMapping("/createFarmer")
    public ApiResponse saveFarmer(@RequestBody SaveFarmerRequest request){
        return adminService.saveFarmer(request);
    }

    @PostMapping("/trainings")
    public ApiResponse saveTechTraining(@RequestBody TechTrainingRequest request){
        return technicalTrainingService.saveTraining(request);
    }

    @PutMapping("/trainings/{id}/cancel")
    public ApiResponse cancelTechTraining(@PathVariable Long id){
        return technicalTrainingService.cancelTechTraining(id);
    }

    @DeleteMapping("/trainings/{id}")
    public ApiResponse deleteTechTraining(@PathVariable Long id){
        return technicalTrainingService.deleteTechTraining(id);
    }

    @GetMapping("/trainings/{id}/applications")
    public ApiResponse getTechTrainingFarmers(@PathVariable Long id){
        return technicalTrainingService.getTechTrainingFarmers(id);
    }
}
