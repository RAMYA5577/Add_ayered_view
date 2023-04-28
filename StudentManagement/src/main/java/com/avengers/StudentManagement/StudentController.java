package com.avengers.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }


    // get information
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("admnNo") int admnNo) {
        return studentService.getStudent(admnNo);
    }

    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("Id") int id,@RequestParam("age") int age){
        return studentService.updateStudent(id,age);
    }

    //Delete the information
    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
         return studentService.deleteStudent(id);
    }
}
