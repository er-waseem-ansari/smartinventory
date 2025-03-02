package com.smartinventory.smartinventory.controller;

import com.smartinventory.smartinventory.entity.User;
import com.smartinventory.smartinventory.repository.AuthRepository;
import com.smartinventory.smartinventory.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    AuthRepository authRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user){

        List<User> crudResponse = authRepository.findByEmail(user.getEmail());
        if (!crudResponse.isEmpty()){
            return ResponseEntity.badRequest().body("Email already exists");
        }
        if (user.getEmail() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email or password should not be empty");
        }

        boolean res = authService.createUser(user);
        if (res) {
            return ResponseEntity.ok("User created successfully!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cannot create user");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        if (user.getEmail() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email or password should not be empty");
        }
        boolean res = authService.login(user);
        if (res) {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");

    }

}
