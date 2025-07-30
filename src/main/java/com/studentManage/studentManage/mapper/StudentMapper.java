package com.studentManage.studentManage.mapper;

import com.studentManage.studentManage.DTO.StudentDTO;
import com.studentManage.studentManage.entity.Student;

public class StudentMapper {
    public static StudentDTO toDTO(Student student) {
        if (student == null) {
            return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setMajor(student.getMajor());
        return studentDTO;
    }
}
