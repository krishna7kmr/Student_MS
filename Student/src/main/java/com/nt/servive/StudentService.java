package com.nt.servive;

import com.nt.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentDto registerStudent(StudentDto studentDto);
    StudentDto updateStudent(UUID id, StudentDto studentDto);
    StudentDto getStudent(UUID id);
    List<StudentDto> getAllStudents();
    String  deleteStudent(UUID id);

}
