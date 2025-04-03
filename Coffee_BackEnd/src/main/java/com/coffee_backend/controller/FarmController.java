package com.coffee_backend.controller;

import com.coffee_backend.dto.ApiResponse;
import com.coffee_backend.dto.PageQueryRequest;
import com.coffee_backend.dto.PageQueryResponse;
import com.coffee_backend.dto.SaveProfileRequest;
import com.coffee_backend.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    @Autowired
    private FarmService farmService;

    @GetMapping
    public ApiResponse list(@ModelAttribute PageQueryRequest pageQueryRequest){
        return ApiResponse.success(farmService.list(pageQueryRequest));
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id){
        return farmService.getById(id);
    }

    @PostMapping("/profile")
    public ApiResponse saveProfile(@RequestBody SaveProfileRequest saveProfileRequest){
        return farmService.saveProfile(saveProfileRequest);
    }

    @PutMapping("/update")
    public ApiResponse updateProfile(@RequestBody SaveProfileRequest saveProfileRequest){
        return farmService.updateProfile(saveProfileRequest);
    }

    @GetMapping("/status")
    public ApiResponse queryStatus(){
        return farmService.queryStatus();
    }
}
