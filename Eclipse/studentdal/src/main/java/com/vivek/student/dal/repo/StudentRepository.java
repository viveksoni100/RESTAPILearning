package com.vivek.student.dal.repo;

import com.vivek.student.dal.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
