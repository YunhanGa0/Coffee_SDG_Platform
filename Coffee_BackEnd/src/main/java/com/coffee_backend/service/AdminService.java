package com.coffee_backend.service;

import com.coffee_backend.dto.ApiResponse;
import com.coffee_backend.dto.SaveFarmerRequest;
import com.coffee_backend.dto.SaveFarmerResponse;
import com.coffee_backend.entity.User;
import com.coffee_backend.enumType.UserRole;
import com.coffee_backend.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public ApiResponse saveFarmer(SaveFarmerRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String email = request.getEmail();

        if (username == null || username.trim().isEmpty()) {
            return ApiResponse.error(400, "Username should not be null");
        }

        if (email == null || email.trim().isEmpty()) {
            return ApiResponse.error(400, "Email should not be null");
        }

        if (password == null || password.trim().isEmpty()) {
            return ApiResponse.error(400, "Password should not be null");
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            return ApiResponse.error(400, "Email format is null");
        }

        if (userRepository.existsByUsername(username)) {
            return ApiResponse.error(400, "Username already exist");
        }

        if (userRepository.existsByEmail(email)) {
            return ApiResponse.error(400, "Email already exist");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(UserRole.FARMER);

        User savedUser = userRepository.save(user);

        SaveFarmerResponse response = new SaveFarmerResponse();

        BeanUtils.copyProperties(savedUser, response);

        return ApiResponse.success(response);
    }
}
