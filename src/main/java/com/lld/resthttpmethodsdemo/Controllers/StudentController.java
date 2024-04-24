package com.lld.resthttpmethodsdemo.Controllers;

import com.lld.resthttpmethodsdemo.Models.Student;
import com.lld.resthttpmethodsdemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = studentService.getStudent(id);
        System.out.println(student);
        return student;
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updateStudent){
        Student student = studentService.getStudent(id);
        if(student == null) return "Student not found";
        student.setName(updateStudent.getName());
        student.setMarks(updateStudent.getMarks());
        student.setCollege(updateStudent.getCollege());
        studentService.saveStudent(student);
        return "Student data updated";
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

}
