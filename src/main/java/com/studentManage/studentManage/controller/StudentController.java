package com.studentManage.studentManage.controller;

import com.studentManage.studentManage.DTO.StudentDTO;
import com.studentManage.studentManage.entity.Student;
import com.studentManage.studentManage.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @GetMapping
    ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentServices.getAllStudents());
    }

    @GetMapping("/{id}")
    ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentServices.getStudentById(id));
    }

    @PostMapping
    ResponseEntity<Student> createStudent(@RequestBody Student request) {
        return ResponseEntity.ok(studentServices.createStudent(request));
    }
    @PutMapping("/{id}")
    ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student request) {
        // Assuming the update logic is handled in the service
        return ResponseEntity.ok(studentServices.updateStudent(id,request));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentServices.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
