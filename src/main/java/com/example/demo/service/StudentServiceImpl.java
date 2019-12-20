/**
 * 
 */
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

/**
 * @author etwxaau
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public void saveStudentData(Student student) {

		studentRepository.save(student);
		
	}


	@Override
	public List<Student> getAllStudents() {
		 List<Student> studentList = studentRepository.findAll();
         
	        if(studentList.size() > 0) {
	            return studentList;
	        } else {
	            return new ArrayList<Student>();
	        }
	}


	@Override
	public Student getStudentById(Long id) throws RecordNotFoundException {
		 Optional<Student> student = studentRepository.findById(id);
         
	        if(student.isPresent()) {
	            return student.get();
	        } else {
	            throw new RecordNotFoundException("No student record exist for given id");
	        }
	}


	@Override
	public List<Student> getStudentByName(String name) throws RecordNotFoundException {
		List<Student> studentNameList = studentRepository.findByFirstName(name);
		return studentNameList; 
	}

}
