package com.nt.servive;

import com.nt.dto.StudentDto;
import com.nt.entity.Student;
import com.nt.exception.CustomResourceNotFoundException;
import com.nt.repository.StudentRepository;
import com.nt.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public  class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public StudentDto registerStudent(StudentDto studentDto) {
        Student  student  = ModelMapperUtil.convert(studentDto, Student.class);
        student.setId(UUID.randomUUID());
        Student saveedStudent = studentRepository.save(student);
        return ModelMapperUtil.convert(saveedStudent,StudentDto.class);

    }

    @Override
    public StudentDto updateStudent(UUID id, StudentDto studentDto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException( "Invalid  student id : "+id ));

        student.setName(studentDto.getName());
        student.setDept(studentDto.getDept());
        student.setAddress(studentDto.getAddress());

        Student savedStudent = studentRepository.save(student);

        return ModelMapperUtil.convert(savedStudent,StudentDto.class);
    }

    @Override
    public StudentDto getStudent(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException( "Invalid  student id : "+id ));
        return ModelMapperUtil.convert(student,StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> studentsList = studentRepository.findAll();
        return studentsList.stream().map(s -> ModelMapperUtil.convert(s, StudentDto.class)).toList();
    }

    @Override
    public String deleteStudent(UUID id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException( "Invalid  student id : "+id ));
        studentRepository.deleteById(id);
        return "student deleted successfully";
    }
}
