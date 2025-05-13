package com.example.student.Controller;

import com.example.student.Entity.Student;
import com.example.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> insertStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<List<Student>>(studentService.allStudents(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam String nic, @RequestBody Student student) {
        return studentService.updateStudent(nic, student);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteStudent(@RequestParam String nic) {
        return studentService.deleteStudent(nic);
    }


}
