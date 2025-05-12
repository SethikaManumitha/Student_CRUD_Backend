package com.example.student.Service;

import com.example.student.Entity.Admin;
import com.example.student.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public boolean authenticate(String email, String password) {
        Optional<Admin> admin = adminRepo.findByEmailAndPassword(email, password);
        return admin.isPresent();
    }


}
