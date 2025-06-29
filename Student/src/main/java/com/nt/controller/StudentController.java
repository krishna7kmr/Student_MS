package com.nt.controller;

import com.nt.dto.StudentDto;
import com.nt.servive.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto){

        StudentDto student = studentService.registerStudent(studentDto);
        return  new ResponseEntity<StudentDto>(student, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable UUID id, @RequestBody StudentDto studentDto){

        StudentDto student = studentService.updateStudent(id,studentDto);
        return  new ResponseEntity<StudentDto>(student, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable UUID id){

        StudentDto student = studentService.getStudent(id);
        return  new ResponseEntity<StudentDto>(student, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAllStudent(){

        List< StudentDto > studentList = studentService.getAllStudents();
        return  new ResponseEntity< List<StudentDto> >(studentList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable UUID id){

        String msg = studentService.deleteStudent(id);
        return  new ResponseEntity<>(msg, HttpStatus.OK);
    }
}

