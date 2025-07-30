package com.studentManage.studentManage.services;

import com.studentManage.studentManage.DTO.StudentDTO;
import com.studentManage.studentManage.entity.Student;

import java.util.List;

public interface StudentServices {
     List<StudentDTO> getAllStudents();
     StudentDTO getStudentById(Long id);
     Student createStudent(Student student);
     Void deleteStudent(Long id);
     Student updateStudent(Long id, Student student);
}
