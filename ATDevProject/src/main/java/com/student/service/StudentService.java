package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getStudent() {
		return studentRepo.findAll();
	}

	public Student insertStudent(Student student) {
		return studentRepo.save(student);
	}

	public void deleteStudent(long studentId) {
		 studentRepo.deleteById(studentId);;
	}

	public Student updateStudent(long studentId , Student student) {
		Student updatedStudent;
		
		if(studentRepo.existsById(studentId))
		{
			Optional<Student> existStudent = studentRepo.findById(studentId);
			Student oldStudent = existStudent.get();
			oldStudent.setStudentName(student.getStudentName());
			oldStudent.setStudentRollNo(student.getStudentRollNo());
			oldStudent.setStudentDepartment(student.getStudentDepartment());
			
			updatedStudent = studentRepo.save(oldStudent);
		}
		else
		{
			updatedStudent=studentRepo.save(student);
		}
		return updatedStudent;
	}

}
