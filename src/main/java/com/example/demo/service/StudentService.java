/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Student;

/**
 * @author etwxaau
 *
 */
public interface StudentService {
	
  public void saveStudentData(Student student);
	
  public List<Student> getAllStudents();
	   
  public Student getStudentById(Long id)throws RecordNotFoundException;
  
  public List<Student> getStudentByName(String name)throws RecordNotFoundException;
	   
	

}
