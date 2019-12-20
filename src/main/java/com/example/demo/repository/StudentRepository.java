/**
 * 
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Student;

/**
 * @author etwxaau
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("SELECT p FROM Student p WHERE LOWER(p.firstName) = LOWER(:firstName)")
	public List<Student> findByFirstName(String firstName);
}
