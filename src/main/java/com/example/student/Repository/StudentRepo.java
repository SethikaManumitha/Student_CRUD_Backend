package com.example.student.Repository;

import com.example.student.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepo extends MongoRepository<Student,String> {

}
