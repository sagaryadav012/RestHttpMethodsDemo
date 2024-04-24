package com.lld.resthttpmethodsdemo.Services;

import com.lld.resthttpmethodsdemo.Models.Student;
import com.lld.resthttpmethodsdemo.Repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public String saveStudent(Student student){
        studentRepo.save(student);
        return "Student inserted";
    }

    public Student getStudent(int id){
        return studentRepo.findById(id).orElse(null);
    }

    public String deleteStudent(int id){
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "Student with "+id+" is deleted";
        }
        return "Student is not found";
    }
}
