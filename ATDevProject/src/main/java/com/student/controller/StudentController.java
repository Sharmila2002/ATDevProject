package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@GetMapping("/student")
	public List<Student> getStudent() {
		return studentService.getStudent();
	}

	@PostMapping("/student")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}

	@DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable long studentId) {
		 studentService.deleteStudent(studentId);
	}

	@PutMapping("/student/{studentId}")
	public Student updateStudent(@PathVariable long studentId , @RequestBody Student student) {
		return studentService.updateStudent(studentId , student);
	}

}
