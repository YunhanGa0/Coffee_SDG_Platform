package com.coffee_backend.controller;

import com.coffee_backend.dto.ApiResponse;
import com.coffee_backend.dto.UserRegisterRequest;
import com.coffee_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ApiResponse register(@RequestBody UserRegisterRequest userRegisterRequest){
        return authService.register(userRegisterRequest);
    }

    /**
     * 专门用于测试的端点，创建管理员账号并返回token
     */
    @GetMapping("/admin/test")
    public ApiResponse getAdminTokenForTest(){
        return authService.createAdminForTest();
    }
}
