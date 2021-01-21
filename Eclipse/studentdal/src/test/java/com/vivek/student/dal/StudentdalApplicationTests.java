package com.vivek.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vivek.student.dal.entities.Student;
import com.vivek.student.dal.repo.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository studentRepo;

	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setName("Rose Russell");
		student.setCourse("RESTApi");
		student.setFee(50d);
		studentRepo.save(student);
	}
	
	@Test
	public void testFindStudentById() {
		Student student = studentRepo.findById(1L).get();
		System.out.println(student);
	}
	
	@Test
	public void testUpdateStudent() {
		Student student = studentRepo.findById(2L).get();
		student.setName("Vivek");
		student.setCourse("Acting");
		student.setFee(100d);
		studentRepo.save(student);
	}

}
