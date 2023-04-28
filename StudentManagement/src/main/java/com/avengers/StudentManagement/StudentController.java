package com.avengers.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s= studentService.addStudent(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }


    // get information
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("admnNo") int admnNo) {
        Student student= studentService.getStudent(admnNo);
        return new ResponseEntity<>(student,HttpStatus.FOUND);
    }

    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("Id") int id,@RequestParam("age") int age){
        String response= studentService.updateStudent(id,age);
        if(response==null){
            return new ResponseEntity<>("Invalid request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    //Delete the information
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id){
         String response= studentService.deleteStudent(id);
         if(response.equals("Invalid Id")){
             return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
}
