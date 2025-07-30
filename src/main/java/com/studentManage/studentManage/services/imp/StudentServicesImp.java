package com.studentManage.studentManage.services.imp;

import com.studentManage.studentManage.DTO.StudentDTO;
import com.studentManage.studentManage.entity.Student;
import com.studentManage.studentManage.mapper.StudentMapper;
import com.studentManage.studentManage.repository.StudentRepository;
import com.studentManage.studentManage.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImp implements StudentServices {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::toDTO).toList();
    }
    @Override
    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(StudentMapper::toDTO)
                .orElse(null); // Trả về null nếu không tìm thấy sinh viên
    }
    @Override
    public Student createStudent(Student student) {
        // Lưu sinh viên vào cơ sở dữ liệu
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        // Kiểm tra xem sinh viên có tồn tại không
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Sinh viên không tồn tại");
        }
        // Cập nhật thông tin sinh viên
        student.setId(id);
        Student updatedStudent = studentRepository.save(student);
        return updatedStudent;
    }

    @Override
    public Void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Sinh viên không tồn tại");
        }
        studentRepository.deleteById(id);
        return null; // Trả về null sau khi xóa
    }
}
