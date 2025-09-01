package com.syntra.studentservice.data.repository;

import com.syntra.studentservice.data.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}