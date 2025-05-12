package com.example.student.Controller;

import com.example.student.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResponseEntity<String> login(@RequestParam String email,@RequestParam String password){
        boolean isAuthenticated = adminService.authenticate(email,password);
        if(isAuthenticated){
            return ResponseEntity.ok("Login Successfull!");
        }else{
            return ResponseEntity.status(401).body("Invalid Credential");
        }
    }
}
