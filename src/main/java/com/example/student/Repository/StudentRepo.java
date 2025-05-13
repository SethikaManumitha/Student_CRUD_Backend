package com.example.student.Repository;

import com.example.student.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepo extends MongoRepository<Student,String> {

}
