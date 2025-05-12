package com.example.student.Repository;

import com.example.student.Entity.Admin;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminRepo extends MongoRepository<Admin, ObjectId> {
    Optional<Admin> findByEmailAndPassword(String email, String password);
}
