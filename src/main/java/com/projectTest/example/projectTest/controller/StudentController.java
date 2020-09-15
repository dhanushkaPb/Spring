package com.projectTest.example.projectTest.controller;

import com.projectTest.example.projectTest.dto.request.StudentRequest;
import com.projectTest.example.projectTest.dto.request.studentUpdateRequest;
import com.projectTest.example.projectTest.dto.response.StudentDeleteResponse;
import com.projectTest.example.projectTest.dto.response.StudentResponse;
import com.projectTest.example.projectTest.dto.response.studentUpdateResponse;
import com.projectTest.example.projectTest.entity.StudentsEntity;
import com.projectTest.example.projectTest.repository.StudentRepository;
import com.projectTest.example.projectTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.util.List;

@RequestMapping("Student")
@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("student")
    public List<StudentsEntity> getall()
    {
        return studentRepository.findAll();
    }

    @PostMapping("student")
    public void add(@RequestBody StudentRequest request) {
        studentService.save(request);
    }

    @PutMapping("/student/{id}")
    public  ResponseEntity<studentUpdateResponse> update(@PathVariable("id") long id,@RequestBody studentUpdateRequest updateRequest){


        studentUpdateResponse update = studentService.update(updateRequest, id);
        if(update == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StudentDeleteResponse> deleteStudent(@PathVariable("id") Long id){

        StudentDeleteResponse delete = studentService.delete(id);

        if (delete == null) {

            return  ResponseEntity.notFound().build();
        }

            return ResponseEntity.ok(delete);
    }







}
