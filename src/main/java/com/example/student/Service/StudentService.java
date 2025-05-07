package com.example.student.Service;

import com.example.student.Entity.Student;
import com.example.student.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public ResponseEntity<Student> createStudent(Student student){
        Student studentObj = studentRepo.save(student);
        return ResponseEntity.ok(studentObj);
    }

    public List<Student> allStudents(){
        return studentRepo.findAll();
    }

    public Optional<Student> singleStudentByNIC(String nic){
        return studentRepo.findById(nic);
    }


    public Optional<Student> singleStudentByFirstName(String firstName){
        return studentRepo.findStudentByFirstName(firstName);
    }

    public Optional<Student> singleStudentByLastName(String lastName){
        return studentRepo.findStudentByLastName(lastName);
    }


    public ResponseEntity<Student> updateStudent(String nic, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepo.findById(nic);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setGender(updatedStudent.getGender());
            student.setDOB(updatedStudent.getDOB());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
            student.setEmail(updatedStudent.getEmail());

            studentRepo.save(student);
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteStudent(String nic) {
        Optional<Student> optionalStudent = studentRepo.findById(nic);
        if (optionalStudent.isPresent()) {
            studentRepo.deleteById(nic);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
