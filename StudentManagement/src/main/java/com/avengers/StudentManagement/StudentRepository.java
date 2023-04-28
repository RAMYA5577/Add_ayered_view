package com.avengers.StudentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> db=new HashMap<>();
    //Integer--key(admission number)
    //Student--value(we want to get all the details of student)

    //adding
    public String addStudent(Student student){
        int id=student.getAdmnNo();
        db.put(id,student);
        return "Added successfully";
    }

    //getting
    public Student getStudent(int id){
        return db.get(id);
    }

    //updating
    public String updateStudent(int id,int age){
        if(!db.containsKey(id)){
            return "Invalid Id";
        }
            // Student student=db.get(id);
           // student.setAge(age);
          // db.put(id,student);
        db.get(id).setAge(22);

        return "Age Successfully Updated";
    }

    //deleting
    public String deleteStudent(int id){
        if(!db.containsKey(id)){
            return "Invalid ID";
        }
        db.remove(id);
        return "Details of The Students Removed Successfully";
    }
}
