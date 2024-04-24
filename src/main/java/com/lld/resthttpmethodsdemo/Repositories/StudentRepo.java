package com.lld.resthttpmethodsdemo.Repositories;

import com.lld.resthttpmethodsdemo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
     Optional<Student> findById(int id);
     boolean existsById(int id);
     void deleteById(int id);
}
